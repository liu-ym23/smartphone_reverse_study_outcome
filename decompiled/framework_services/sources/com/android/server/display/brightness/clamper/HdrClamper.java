package com.android.server.display.brightness.clamper;

import android.os.Handler;
import android.os.IBinder;
import android.pico.utils.ExtImplFactory;
import android.view.SurfaceControlHdrLayerInfoListener;
import com.android.server.display.config.HdrBrightnessData;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HdrClamper {
    private float mAmbientLux;
    private boolean mAutoBrightnessEnabled;
    private final BrightnessClamperController.ClamperChangeListener mClamperChangeListener;
    private final Runnable mDebouncer;
    private float mDesiredMaxBrightness;
    private float mDesiredTransitionRate;
    private IExtHdrClamper mExt;
    private final Handler mHandler;
    private HdrBrightnessData mHdrBrightnessData;
    private final HdrLayerInfoListener mHdrListener;
    private boolean mHdrVisible;
    private float mMaxBrightness;
    private IBinder mRegisteredDisplayToken;
    private float mTransitionRate;
    private boolean mUseSlowTransition;

    static class HdrLayerInfoListener extends SurfaceControlHdrLayerInfoListener {
        private final Handler mHandler;
        private final HdrListener mHdrListener;
        private float mHdrMinPixels;

        /* JADX INFO: renamed from: $r8$lambda$vh6p3ci-h9CymlrGCKRkiEkEXOY, reason: not valid java name */
        public static /* synthetic */ void m4004$r8$lambda$vh6p3cih9CymlrGCKRkiEkEXOY(HdrLayerInfoListener r0, int r1, int r2, int r3) {
            r0.lambda$onHdrInfoChanged$0(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmHdrMinPixels, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m4005$$Nest$fgetmHdrMinPixels(HdrLayerInfoListener r0) {
            return r0.mHdrMinPixels;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmHdrMinPixels, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4006$$Nest$fputmHdrMinPixels(HdrLayerInfoListener r0, float r1) {
            r0.mHdrMinPixels = r1;
        }

        HdrLayerInfoListener(HdrListener hdrListener, Handler handler) {
            this.mHdrMinPixels = Float.MAX_VALUE;
            this.mHdrListener = hdrListener;
            this.mHandler = handler;
        }

        public void onHdrInfoChanged(IBinder displayToken, final int numberOfHdrLayers, final int maxW, final int maxH, int flags, float maxDesiredHdrSdrRatio) {
            this.mHandler.post(new HdrClamper$HdrLayerInfoListener$$ExternalSyntheticLambda0(this, numberOfHdrLayers, maxW, maxH));
        }

        private /* synthetic */ void lambda$onHdrInfoChanged$0(int numberOfHdrLayers, int maxW, int maxH) {
            HdrListener r0 = this.mHdrListener;
            if (numberOfHdrLayers > 0) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r0.onHdrVisible(r1);
            return;
        L5:
            if ((maxW * maxH) < this.mHdrMinPixels) goto L7;
            r1 = true;
            goto L8
        }
    }

    @FunctionalInterface
    interface HdrListener {
        void onHdrVisible(boolean r1);
    }

    static class Injector {
        Injector() {
        }

        HdrLayerInfoListener getHdrListener(HdrListener hdrListener, Handler handler) {
            return new HdrLayerInfoListener(hdrListener, handler);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-0g6cCNmtXXug3V6-htjabJyMKE, reason: not valid java name */
    public static /* synthetic */ void m4002$r8$lambda$0g6cCNmtXXug3V6htjabJyMKE(HdrClamper r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$30AxeD6U0TARSSJf2DIqNK-nOJQ, reason: not valid java name */
    public static /* synthetic */ void m4003$r8$lambda$30AxeD6U0TARSSJf2DIqNKnOJQ(HdrClamper r0, boolean r1) {
        r0.lambda$new$1(r1);
    }

    public HdrClamper(BrightnessClamperController.ClamperChangeListener clamperChangeListener, Handler handler) {
        this(clamperChangeListener, handler, new Injector());
    }

    public HdrClamper(BrightnessClamperController.ClamperChangeListener clamperChangeListener, Handler handler, Injector injector) {
        this.mHdrBrightnessData = null;
        this.mRegisteredDisplayToken = null;
        this.mAmbientLux = Float.MAX_VALUE;
        this.mHdrVisible = false;
        this.mMaxBrightness = 1.0f;
        this.mDesiredMaxBrightness = 1.0f;
        this.mTransitionRate = -1.0f;
        this.mDesiredTransitionRate = -1.0f;
        this.mAutoBrightnessEnabled = false;
        this.mUseSlowTransition = false;
        this.mExt = (IExtHdrClamper) ExtImplFactory.getImpl(IExtHdrClamper.class, new Object[]{this});
        this.mClamperChangeListener = clamperChangeListener;
        this.mHandler = handler;
        this.mDebouncer = new HdrClamper$$ExternalSyntheticLambda0(this);
        this.mHdrListener = injector.getHdrListener(new HdrClamper$$ExternalSyntheticLambda1(this), handler);
    }

    private /* synthetic */ void lambda$new$0() {
        this.mTransitionRate = this.mDesiredTransitionRate;
        this.mMaxBrightness = this.mDesiredMaxBrightness;
        this.mUseSlowTransition = true;
        this.mClamperChangeListener.onChanged();
    }

    private /* synthetic */ void lambda$new$1(boolean visible) {
        this.mHdrVisible = visible;
        recalculateBrightnessCap(this.mHdrBrightnessData, this.mAmbientLux, this.mHdrVisible);
    }

    public float clamp(float brightness) {
        return Math.min(brightness, this.mMaxBrightness);
    }

    public float getMaxBrightness() {
        return this.mMaxBrightness;
    }

    public float getTransitionRate() {
        float expectedTransitionRate = this.mExt.getTransitionRate(this.mHdrBrightnessData);
        this.mUseSlowTransition = false;
        return expectedTransitionRate;
    }

    public void onAmbientLuxChange(float ambientLux) {
        this.mAmbientLux = ambientLux;
        recalculateBrightnessCap(this.mHdrBrightnessData, ambientLux, this.mHdrVisible);
    }

    public void resetHdrConfig(HdrBrightnessData data, int width, int height, float minimumHdrPercentOfScreen, IBinder displayToken) {
        this.mHdrBrightnessData = data;
        HdrLayerInfoListener.m4006$$Nest$fputmHdrMinPixels(this.mHdrListener, (width * height) * minimumHdrPercentOfScreen);
        if (displayToken != this.mRegisteredDisplayToken) goto L5;
    L13:
        recalculateBrightnessCap(data, this.mAmbientLux, this.mHdrVisible);
        return;
    L5:
        if (this.mRegisteredDisplayToken == null) goto L7;
        this.mHdrListener.unregister(this.mRegisteredDisplayToken);
        this.mHdrVisible = false;
        this.mRegisteredDisplayToken = null;
    L7:
        if (displayToken == null) goto L13;
        if (HdrLayerInfoListener.m4005$$Nest$fgetmHdrMinPixels(this.mHdrListener) < 0.0f) goto L13;
        if (hasBrightnessLimits() == false) goto L13;
        this.mHdrListener.register(displayToken);
        this.mRegisteredDisplayToken = displayToken;
        goto L13
    }

    public void setAutoBrightnessState(int state) {
        boolean isEnabled = true;
        if (state == 1) goto L7;
        isEnabled = false;
    L7:
        if (isEnabled == this.mAutoBrightnessEnabled) goto L10;
        this.mAutoBrightnessEnabled = isEnabled;
        recalculateBrightnessCap(this.mHdrBrightnessData, this.mAmbientLux, this.mHdrVisible);
        return;
    }

    public void stop() {
        if (this.mRegisteredDisplayToken == null) goto L6;
        this.mHdrListener.unregister(this.mRegisteredDisplayToken);
        return;
    }

    public void dump(PrintWriter pw) {
        pw.println("HdrClamper:");
        pw.println("  mMaxBrightness=" + this.mMaxBrightness);
        pw.println("  mDesiredMaxBrightness=" + this.mDesiredMaxBrightness);
        pw.println("  mTransitionRate=" + this.mTransitionRate);
        pw.println("  mDesiredTransitionRate=" + this.mDesiredTransitionRate);
        pw.println("  mHdrVisible=" + this.mHdrVisible);
        pw.println("  mHdrListener.mHdrMinPixels=" + HdrLayerInfoListener.m4005$$Nest$fgetmHdrMinPixels(this.mHdrListener));
        StringBuilder r0 = new StringBuilder();
        r0.append("  mHdrBrightnessData=");
        if (this.mHdrBrightnessData != null) goto L5;
        String r1 = "null";
    L6:
        r0.append(r1);
        pw.println(r0.toString());
        StringBuilder r2 = new StringBuilder();
        r2.append("  mHdrListener registered=");
        if (this.mRegisteredDisplayToken == null) goto L9;
        boolean r3 = true;
    L10:
        r2.append(r3);
        pw.println(r2.toString());
        pw.println("  mAmbientLux=" + this.mAmbientLux);
        pw.println("  mAutoBrightnessEnabled=" + this.mAutoBrightnessEnabled);
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = this.mHdrBrightnessData.toString();
        goto L6
    }

    private boolean hasBrightnessLimits() {
        if (this.mHdrBrightnessData != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mHdrBrightnessData.maxBrightnessLimits.isEmpty() == true) goto L7;
        return true;
    }

    private void reset() {
        if (this.mMaxBrightness == 1.0f) goto L5;
    L11:
        this.mHandler.removeCallbacks(this.mDebouncer);
        this.mMaxBrightness = 1.0f;
        this.mDesiredMaxBrightness = 1.0f;
        this.mDesiredTransitionRate = -1.0f;
        this.mTransitionRate = -1.0f;
        this.mUseSlowTransition = false;
        this.mClamperChangeListener.onChanged();
        return;
    L5:
        if (this.mDesiredMaxBrightness != 1.0f) goto L11;
        if (this.mTransitionRate != (-1.0f)) goto L11;
        if (this.mDesiredTransitionRate != (-1.0f)) goto L11;
    }

    private void recalculateBrightnessCap(HdrBrightnessData data, float ambientLux, boolean hdrVisible) {
        if (data == null) goto L18;
        if (hdrVisible == false) goto L18;
        if (this.mAutoBrightnessEnabled == false) goto L18;
        float expectedMaxBrightness = findBrightnessLimit(data, ambientLux);
        if (this.mMaxBrightness != expectedMaxBrightness) goto L11;
        this.mDesiredMaxBrightness = this.mMaxBrightness;
        this.mDesiredTransitionRate = -1.0f;
        this.mTransitionRate = -1.0f;
        this.mHandler.removeCallbacks(this.mDebouncer);
        return;
    L11:
        if (this.mDesiredMaxBrightness == expectedMaxBrightness) goto L21;
        this.mDesiredMaxBrightness = expectedMaxBrightness;
        if (this.mDesiredMaxBrightness <= this.mMaxBrightness) goto L15;
        long debounceTime = this.mHdrBrightnessData.brightnessIncreaseDebounceMillis;
        this.mDesiredTransitionRate = this.mHdrBrightnessData.screenBrightnessRampIncrease;
    L16:
        this.mHandler.removeCallbacks(this.mDebouncer);
        this.mHandler.postDelayed(this.mDebouncer, debounceTime);
        return;
    L15:
        debounceTime = this.mHdrBrightnessData.brightnessDecreaseDebounceMillis;
        this.mDesiredTransitionRate = this.mHdrBrightnessData.screenBrightnessRampDecrease;
        goto L16
    L21:
        return;
    L18:
        reset();
    }

    private float findBrightnessLimit(HdrBrightnessData data, float ambientLux) {
        float foundAmbientBoundary = Float.MAX_VALUE;
        float foundMaxBrightness = 1.0f;
        Iterator<Map.Entry<Float, Float>> r2 = data.maxBrightnessLimits.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Map.Entry<Float, Float> brightnessPoint = r2.next();
        float ambientBoundary = brightnessPoint.getKey().floatValue();
        if (ambientBoundary <= ambientLux) goto L4;
        if (ambientBoundary >= foundAmbientBoundary) goto L4;
        foundMaxBrightness = brightnessPoint.getValue().floatValue();
        foundAmbientBoundary = ambientBoundary;
        goto L4
    L11:
        return foundMaxBrightness;
    }

    public IExtHdrClamper getExt() {
        return this.mExt;
    }

    public float getHdrExitTransitionRate() {
        return this.mExt.getHdrExitTransitionRate(this.mHdrBrightnessData);
    }
}
