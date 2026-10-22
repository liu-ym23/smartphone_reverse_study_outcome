package com.android.server.display.brightness.clamper;

import android.content.Context;
import android.database.ContentObserver;
import android.hardware.display.DisplayManagerInternal;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.view.SurfaceControlHdrLayerInfoListener;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.DisplayDeviceConfig;
import com.android.server.display.config.HdrBrightnessData;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HdrBrightnessModifier implements BrightnessStateModifier, BrightnessClamperController.DisplayDeviceDataListener, BrightnessClamperController.StatefulModifier {
    private static final float DEFAULT_HDR_LAYER_SIZE = -1.0f;
    static final float DEFAULT_MAX_HDR_SDR_RATIO = 1.0f;
    private float mAmbientLux;
    private final BrightnessClamperController.ClamperChangeListener mClamperChangeListener;
    private final ContentObserver mContentObserver;
    private boolean mContentObserverRegistered;
    private final Runnable mDebouncer;
    private DisplayDeviceConfig mDisplayDeviceConfig;
    private IExtHdrBrightnessModifier mExt;
    private final Handler mHandler;
    private HdrBrightnessData mHdrBrightnessData;
    private float mHdrLayerSize;
    private final SurfaceControlHdrLayerInfoListener mHdrListener;
    private final Injector mInjector;
    private boolean mLowPowerMode;
    private final Uri mLowPowerModeSetting;
    private float mMaxBrightness;
    private float mMaxDesiredHdrRatio;
    private Mode mMode;
    private float mPendingMaxBrightness;
    private float mPendingTransitionRate;
    private IBinder mRegisteredDisplayToken;
    private float mScreenSize;
    private float mTransitionRate;

    /* JADX INFO: renamed from: com.android.server.display.brightness.clamper.HdrBrightnessModifier$1, reason: invalid class name */
    class AnonymousClass1 extends SurfaceControlHdrLayerInfoListener {
        final /* synthetic */ HdrBrightnessModifier this$0;

        public static /* synthetic */ void $r8$lambda$tA6jNs_7pjoXYUSOu7koQISLea8(AnonymousClass1 r0, boolean r1, int r2, int r3, float r4) {
            r0.lambda$onHdrInfoChanged$0(r1, r2, r3, r4);
        }

        AnonymousClass1(HdrBrightnessModifier this$0) {
            this.this$0 = this$0;
        }

        public void onHdrInfoChanged(IBinder displayToken, int numberOfHdrLayers, final int maxW, final int maxH, int flags, final float maxDesiredHdrSdrRatio) {
            HdrBrightnessModifier.m3998$$Nest$fgetmExt(this.this$0).onHdrInfoChanged(displayToken, numberOfHdrLayers, maxW, maxH, flags, maxDesiredHdrSdrRatio);
            if (numberOfHdrLayers <= 0) goto L6;
            boolean r9 = true;
        L5:
            final boolean hdrLayerPresent = r9;
            HdrBrightnessModifier.m3999$$Nest$fgetmHandler(this.this$0).post(new HdrBrightnessModifier$1$$ExternalSyntheticLambda0(this, hdrLayerPresent, maxW, maxH, maxDesiredHdrSdrRatio));
            return;
        L6:
            r9 = false;
            goto L5
        }

        private /* synthetic */ void lambda$onHdrInfoChanged$0(boolean hdrLayerPresent, int maxW, int maxH, float maxDesiredHdrSdrRatio) {
            HdrBrightnessModifier r0 = this.this$0;
            if (hdrLayerPresent == false) goto L5;
            float r1 = maxW * maxH;
        L6:
            float r2 = 1.0f;
            if (hdrLayerPresent == false) goto L10;
            r2 = Math.max(maxDesiredHdrSdrRatio, 1.0f);
        L10:
            HdrBrightnessModifier.m4000$$Nest$monHdrInfoChanged(r0, r1, r2);
            return;
        L5:
            r1 = -1.0f;
            goto L6
        }
    }

    static class Injector {
        private final Context mContext;

        Injector(Context context) {
            this.mContext = context;
        }

        void registerHdrListener(SurfaceControlHdrLayerInfoListener listener, IBinder token) {
            listener.register(token);
        }

        void unregisterHdrListener(SurfaceControlHdrLayerInfoListener listener, IBinder token) {
            listener.unregister(token);
        }

        void registerContentObserver(ContentObserver observer, Uri uri) {
            this.mContext.getContentResolver().registerContentObserver(uri, false, observer, -1);
        }

        void unregisterContentObserver(ContentObserver observer) {
            this.mContext.getContentResolver().unregisterContentObserver(observer);
        }

        boolean isLowPowerMode() {
            if (Settings.Global.getInt(this.mContext.getContentResolver(), "low_power", 0) == 0) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode HBM_HDR = null;
        public static final Mode HDR_EXIT = null;
        public static final Mode NBM_HDR = null;
        public static final Mode NO_HDR = null;

        private static /* synthetic */ Mode[] $values() {
            return new Mode[]{NO_HDR, NBM_HDR, HBM_HDR, HDR_EXIT};
        }

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String name) {
            return (Mode) Enum.valueOf(Mode.class, name);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        static {
            NO_HDR = new Mode("NO_HDR", 0);
            NBM_HDR = new Mode("NBM_HDR", 1);
            HBM_HDR = new Mode("HBM_HDR", 2);
            HDR_EXIT = new Mode("HDR_EXIT", 3);
            $VALUES = $values();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$WMdE1pH9-xTj-nE01JzyyBO_rH0, reason: not valid java name */
    public static /* synthetic */ void m3996$r8$lambda$WMdE1pH9xTjnE01JzyyBO_rH0(HdrBrightnessModifier r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$bPyCPpEw8kWC_aSHq_ULgOQp-kk, reason: not valid java name */
    public static /* synthetic */ void m3997$r8$lambda$bPyCPpEw8kWC_aSHq_ULgOQpkk(HdrBrightnessModifier r0, BrightnessClamperController.DisplayDeviceData r1) {
        r0.lambda$new$1(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtHdrBrightnessModifier m3998$$Nest$fgetmExt(HdrBrightnessModifier r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m3999$$Nest$fgetmHandler(HdrBrightnessModifier r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$monHdrInfoChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4000$$Nest$monHdrInfoChanged(HdrBrightnessModifier r0, float r1, float r2) {
        r0.onHdrInfoChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monLowPowerModeChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4001$$Nest$monLowPowerModeChange(HdrBrightnessModifier r0) {
        r0.onLowPowerModeChange();
    }

    HdrBrightnessModifier(Handler handler, Context context, BrightnessClamperController.ClamperChangeListener clamperChangeListener, BrightnessClamperController.DisplayDeviceData displayData) {
        this(new Handler(handler.getLooper()), clamperChangeListener, new Injector(context), displayData);
    }

    HdrBrightnessModifier(Handler handler, BrightnessClamperController.ClamperChangeListener clamperChangeListener, Injector injector, final BrightnessClamperController.DisplayDeviceData displayData) {
        this.mLowPowerModeSetting = Settings.Global.getUriFor("low_power");
        this.mHdrListener = new AnonymousClass1(this);
        this.mContentObserverRegistered = false;
        this.mMaxDesiredHdrRatio = 1.0f;
        this.mHdrLayerSize = -1.0f;
        this.mAmbientLux = -1.0f;
        this.mLowPowerMode = false;
        this.mMode = Mode.NO_HDR;
        this.mMaxBrightness = 1.0f;
        this.mPendingMaxBrightness = 1.0f;
        this.mTransitionRate = -1.0f;
        this.mPendingTransitionRate = -1.0f;
        this.mExt = (IExtHdrBrightnessModifier) ExtImplFactory.getImpl(IExtHdrBrightnessModifier.class, new Object[]{this});
        this.mHandler = handler;
        this.mClamperChangeListener = clamperChangeListener;
        this.mInjector = injector;
        this.mDebouncer = new HdrBrightnessModifier$$ExternalSyntheticLambda0(this);
        final Handler r1 = this.mHandler;
        this.mContentObserver = new AnonymousClass2(this, r1);
        this.mHandler.post(new HdrBrightnessModifier$$ExternalSyntheticLambda1(this, displayData));
    }

    private /* synthetic */ void lambda$new$0() {
        this.mTransitionRate = this.mPendingTransitionRate;
        this.mMaxBrightness = this.mPendingMaxBrightness;
        this.mClamperChangeListener.onChanged();
    }

    private /* synthetic */ void lambda$new$1(BrightnessClamperController.DisplayDeviceData displayData) {
        onDisplayChanged(displayData);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void apply(DisplayManagerInternal.DisplayPowerRequest request, DisplayBrightnessState.Builder stateBuilder) {
        if (this.mHdrBrightnessData != null) goto L6;
        return;
    L6:
        if (this.mMode != Mode.NO_HDR) goto L8;
        return;
    L8:
        float hdrBrightness = this.mDisplayDeviceConfig.getHdrBrightnessFromSdr(stateBuilder.getBrightness(), this.mMaxDesiredHdrRatio, this.mHdrBrightnessData.sdrToHdrRatioSpline);
        float maxBrightness = getMaxBrightness(this.mMode, this.mMaxBrightness, this.mHdrBrightnessData);
        stateBuilder.setHdrBrightness(Math.min(hdrBrightness, maxBrightness));
        stateBuilder.setCustomAnimationRate(this.mTransitionRate);
        stateBuilder.getBrightnessReason().addModifier(4);
        this.mTransitionRate = -1.0f;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void dump(PrintWriter pw) {
        pw.println("HdrBrightnessModifier:");
        pw.println("  mHdrBrightnessData=" + this.mHdrBrightnessData);
        pw.println("  mScreenSize=" + this.mScreenSize);
        pw.println("  mMaxDesiredHdrRatio=" + this.mMaxDesiredHdrRatio);
        pw.println("  mHdrLayerSize=" + this.mHdrLayerSize);
        pw.println("  mAmbientLux=" + this.mAmbientLux);
        pw.println("  mLowPowerMode=" + this.mLowPowerMode);
        pw.println("  mMode=" + this.mMode);
        pw.println("  mMaxBrightness=" + this.mMaxBrightness);
        pw.println("  mPendingMaxBrightness=" + this.mPendingMaxBrightness);
        pw.println("  mTransitionRate=" + this.mTransitionRate);
        pw.println("  mPendingTransitionRate=" + this.mPendingTransitionRate);
        StringBuilder r0 = new StringBuilder();
        r0.append("  mHdrListener registered=");
        if (this.mRegisteredDisplayToken == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        pw.println(r0.toString());
        pw.println("  mContentObserverRegistered=" + this.mContentObserverRegistered);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void stop() {
        unregisterHdrListener();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public boolean shouldListenToLightSensor() {
        return hasBrightnessLimits();
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void setAmbientLux(float lux) {
        this.mAmbientLux = lux;
        if (hasBrightnessLimits() == true) goto L5;
        return;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessClamperController.DisplayDeviceDataListener
    public void onDisplayChanged(BrightnessClamperController.DisplayDeviceData displayData) {
        this.mDisplayDeviceConfig = displayData.mDisplayDeviceConfig;
        this.mScreenSize = displayData.mWidth * displayData.mHeight;
        HdrBrightnessData data = this.mDisplayDeviceConfig.getHdrBrightnessData();
        if (data != null) goto L5;
        unregisterHdrListener();
    L6:
        if (data != null) goto L8;
    L11:
        unregisterContentObserver();
    L12:
        Mode newMode = recalculateMode(data);
        if (this.mMode == newMode) goto L15;
    L20:
        boolean needToNotifyChange = true;
    L21:
        this.mMode = newMode;
        this.mHdrBrightnessData = data;
        this.mExt.onDisplayChanged(displayData, this.mMode);
        if (needToNotifyChange == false) goto L25;
        this.mTransitionRate = -1.0f;
        this.mClamperChangeListener.onChanged();
        return;
    L25:
        return;
    L15:
        if (this.mMode != Mode.NO_HDR) goto L17;
    L19:
        needToNotifyChange = false;
        goto L21
    L17:
        if (data == this.mHdrBrightnessData) goto L19;
    L8:
        if (data.allowInLowPowerMode == true) goto L11;
        registerContentObserver();
        goto L12
    L5:
        registerHdrListener(displayData.mDisplayToken);
        goto L6
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessClamperController.StatefulModifier
    public void applyStateChange(BrightnessClamperController.ModifiersAggregatedState aggregatedState) {
        if (this.mMode != Mode.NO_HDR) goto L5;
        return;
    L5:
        if (this.mHdrBrightnessData == null) goto L9;
        aggregatedState.mMaxDesiredHdrRatio = this.mMaxDesiredHdrRatio;
        aggregatedState.mSdrHdrRatioSpline = this.mHdrBrightnessData.sdrToHdrRatioSpline;
        aggregatedState.mMaxHdrBrightness = getMaxBrightness(this.mMode, this.mMaxBrightness, this.mHdrBrightnessData);
        return;
    }

    private boolean hasBrightnessLimits() {
        if (this.mHdrBrightnessData != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mHdrBrightnessData.maxBrightnessLimits.isEmpty() == true) goto L7;
        return true;
    }

    private void scheduleMaxBrightnessUpdate(float desiredMaxBrightness, HdrBrightnessData data) {
        if (this.mMaxBrightness != desiredMaxBrightness) goto L6;
        this.mPendingMaxBrightness = this.mMaxBrightness;
        this.mPendingTransitionRate = -1.0f;
        this.mTransitionRate = -1.0f;
        this.mHandler.removeCallbacks(this.mDebouncer);
        return;
    L6:
        if (this.mPendingMaxBrightness == desiredMaxBrightness) goto L14;
        this.mPendingMaxBrightness = desiredMaxBrightness;
        if (this.mPendingMaxBrightness <= this.mMaxBrightness) goto L10;
        long debounceTime = data.brightnessIncreaseDebounceMillis;
        this.mPendingTransitionRate = data.screenBrightnessRampIncrease;
    L11:
        this.mHandler.removeCallbacks(this.mDebouncer);
        this.mHandler.postDelayed(this.mDebouncer, debounceTime);
        return;
    L10:
        debounceTime = data.brightnessDecreaseDebounceMillis;
        this.mPendingTransitionRate = data.screenBrightnessRampDecrease;
        goto L11
    }

    private Mode recalculateMode(HdrBrightnessData data) {
        if (data != null) goto L6;
        return Mode.NO_HDR;
    L6:
        if (this.mHdrLayerSize != (-1.0f)) goto L14;
        if (this.mExt.isHdrExit(this.mHdrLayerSize, this.mScreenSize, data) == false) goto L12;
        return Mode.HDR_EXIT;
    L12:
        return Mode.NO_HDR;
    L14:
        if (data.allowInLowPowerMode == true) goto L20;
        if (this.mLowPowerMode == false) goto L20;
        return Mode.NO_HDR;
    L20:
        if (this.mHdrLayerSize >= (this.mScreenSize * data.minimumHdrPercentOfScreenForNbm)) goto L24;
        return Mode.NO_HDR;
    L24:
        if (this.mHdrLayerSize >= (this.mScreenSize * data.minimumHdrPercentOfScreenForHbm)) goto L28;
        return Mode.NBM_HDR;
    L28:
        return Mode.HBM_HDR;
    }

    private void onLowPowerModeChange() {
        this.mLowPowerMode = this.mInjector.isLowPowerMode();
        Mode newMode = recalculateMode(this.mHdrBrightnessData);
        if (newMode == this.mMode) goto L5;
        this.mMode = newMode;
        this.mTransitionRate = -1.0f;
        this.mClamperChangeListener.onChanged();
    L5:
        this.mExt.onLowPowerModeChange(this.mLowPowerMode, this.mMode);
    }

    private float getMaxBrightness(Mode mode, float maxBrightness, HdrBrightnessData data) {
        if (this.mExt.isHdrMode() == false) goto L6;
        return 1.0f;
    L6:
        if (mode != Mode.NBM_HDR) goto L10;
        return Math.min(data.hbmTransitionPoint, maxBrightness);
    L10:
        if (mode != Mode.HBM_HDR) goto L12;
        return maxBrightness;
    L12:
        return 1.0f;
    }

    private float findBrightnessLimit(HdrBrightnessData data, float ambientLux) {
        if (data != null) goto L6;
        return 1.0f;
    L6:
        if (ambientLux != (-1.0f)) goto L8;
        return 1.0f;
    L8:
        float foundAmbientBoundary = Float.MAX_VALUE;
        float foundMaxBrightness = 1.0f;
        Iterator<Map.Entry<Float, Float>> r2 = data.maxBrightnessLimits.entrySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L17;
        Map.Entry<Float, Float> brightnessPoint = r2.next();
        float ambientBoundary = brightnessPoint.getKey().floatValue();
        if (ambientBoundary <= ambientLux) goto L10;
        if (ambientBoundary >= foundAmbientBoundary) goto L10;
        foundMaxBrightness = brightnessPoint.getValue().floatValue();
        foundAmbientBoundary = ambientBoundary;
        goto L10
    L17:
        return foundMaxBrightness;
    }

    private void onHdrInfoChanged(float hdrLayerSize, float maxDesiredHdrSdrRatio) {
        this.mHdrLayerSize = hdrLayerSize;
        Mode newMode = recalculateMode(this.mHdrBrightnessData);
        if (this.mMode == newMode) goto L5;
    L10:
        boolean needToNotifyChange = true;
    L11:
        this.mMode = newMode;
        this.mMaxDesiredHdrRatio = maxDesiredHdrSdrRatio;
        if (needToNotifyChange == false) goto L14;
        this.mTransitionRate = -1.0f;
        this.mClamperChangeListener.onChanged();
    L14:
        this.mExt.onHdrInfoChanged(hdrLayerSize, maxDesiredHdrSdrRatio, this.mMode);
        return;
    L5:
        if (this.mMode != Mode.NO_HDR) goto L7;
    L9:
        needToNotifyChange = false;
        goto L11
    L7:
        if (BrightnessSynchronizer.floatEquals(this.mMaxDesiredHdrRatio, maxDesiredHdrSdrRatio) == true) goto L9;
        goto L9
    }

    private void registerHdrListener(IBinder displayToken) {
        if (this.mRegisteredDisplayToken != displayToken) goto L5;
        return;
    L5:
        unregisterHdrListener();
        if (displayToken == null) goto L9;
        this.mInjector.registerHdrListener(this.mHdrListener, displayToken);
        this.mRegisteredDisplayToken = displayToken;
        return;
    }

    private void unregisterHdrListener() {
        if (this.mRegisteredDisplayToken == null) goto L6;
        this.mInjector.unregisterHdrListener(this.mHdrListener, this.mRegisteredDisplayToken);
        this.mRegisteredDisplayToken = null;
        this.mHdrLayerSize = -1.0f;
        return;
    }

    private void registerContentObserver() {
        if (this.mContentObserverRegistered == true) goto L6;
        this.mInjector.registerContentObserver(this.mContentObserver, this.mLowPowerModeSetting);
        this.mContentObserverRegistered = true;
        this.mLowPowerMode = this.mInjector.isLowPowerMode();
        return;
    }

    private void unregisterContentObserver() {
        if (this.mContentObserverRegistered == false) goto L6;
        this.mInjector.unregisterContentObserver(this.mContentObserver);
        this.mContentObserverRegistered = false;
        this.mLowPowerMode = false;
        return;
    }

    public IExtHdrBrightnessModifier getExt() {
        return this.mExt;
    }
}
