package android.hardware.display;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.display.IBackScreenAnimationListener;
import android.hardware.display.IBackScreenCountdownListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class StepOSDisplayManager {
    public static final String BACK_SCREEN_AGENT_EXTRA_IS_READ = "is_read";
    public static final String BACK_SCREEN_BASIC_TEXT_DEFAULT = "AMOO";
    public static final int BACK_SCREEN_BASIC_TEXT_MAX_CHARS = 15;
    public static final String BACK_SCREEN_BASIC_TYPE_AGENT = "agent";
    public static final String BACK_SCREEN_BASIC_TYPE_TEXT = "text";
    public static final String BACK_SCREEN_BASIC_TYPE_TIME = "time";
    public static final int BACK_SCREEN_BRIGHTNESS_DEFAULT = 127;
    public static final int BACK_SCREEN_BRIGHTNESS_MAX = 255;
    public static final int BACK_SCREEN_BRIGHTNESS_MIN = 1;
    public static final int BACK_SCREEN_BRIGHTNESS_MODE_AUTOMATIC = 1;
    public static final int BACK_SCREEN_BRIGHTNESS_MODE_MANUAL = 0;
    public static final int BACK_SCREEN_CUSTOM_DEFAULT_END_MINUTES = 1320;
    public static final int BACK_SCREEN_CUSTOM_DEFAULT_START_MINUTES = 480;
    public static final int BACK_SCREEN_DISPLAY_MODE_ALWAYS = 1;
    public static final int BACK_SCREEN_DISPLAY_MODE_AUTO = 0;
    public static final int BACK_SCREEN_DISPLAY_MODE_CUSTOM = 2;

    @Deprecated
    public static final int BACK_SCREEN_DISPLAY_MODE_FLIP = 0;
    public static final String DISPLAY_EXT_SERVICE = "display_ext";
    private static IBackScreenCountdownListener sActiveCountdownStub;
    private static final Object sAnimationListenerLock = new Object();
    private static final ArrayList<ListenerRecord> sAnimationListeners = new ArrayList<>();
    private static final Object sCountdownLock = new Object();
    private final Context mContext;
    private boolean mIsPreviewNightDisplay;
    private final IStepOSDisplayManager mService;

    public interface BackScreenAnimationListener {
        void onBackScreenAnimationResult(BackScreenAnimationInfo backScreenAnimationInfo, boolean z);
    }

    public StepOSDisplayManager(Context context, IStepOSDisplayManager service) {
        this.mContext = context.getApplicationContext();
        this.mService = service;
    }

    void setNightDisplayActivatedImmediate(boolean activate) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setNightDisplayActivatedImmediate(activate);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    void setDisplayColorTemperature(int temperature, boolean applyImmediate) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setDisplayColorTemperature(temperature, applyImmediate);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    void setBlockColorMatrixEffectEnabled(boolean enabled) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBlockColorMatrixEffectEnabled(enabled);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenAgentState(String agentState) {
        setBackScreenAgentState(agentState, null);
    }

    public void setBackScreenAgentState(String agentState, Bundle extra) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenAgentState(agentState, extra);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenAgentFrame(int[] frame, Bundle extra) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenAgentFrame(frame, extra != null ? new Bundle(extra) : null);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void clearBackScreenAgentFrame() {
        setBackScreenAgentFrame(null, null);
    }

    public void setBackScreenAgentBitmap(Bitmap bitmap, Bundle extra) {
        setBackScreenAgentFrame(StepOSBackScreenConverter.bitmapToFrame(bitmap), extra);
    }

    public void clearBackScreenAgentBitmap() {
        setBackScreenAgentFrame(null, null);
    }

    public void registerBackScreenAnimationListener(Executor executor, BackScreenAnimationListener listener) {
        registerBackScreenAnimationListener(executor, listener, null);
    }

    public void registerBackScreenAnimationListener(Executor executor, BackScreenAnimationListener listener, String type) {
        boolean firstRegistration;
        IBackScreenAnimationListener stub;
        if (executor == null || listener == null) {
            throw new IllegalArgumentException("executor and listener must not be null");
        }
        if (this.mService == null) {
            return;
        }
        String normalizedType = normalizeAnimationType(type);
        synchronized (sAnimationListenerLock) {
            ListenerRecord record = findRecordLocked(listener);
            if (record != null) {
                record.executor = executor;
                firstRegistration = false;
            } else {
                record = new ListenerRecord(listener, executor);
                sAnimationListeners.add(record);
                firstRegistration = true;
            }
            stub = record.stub;
        }
        try {
            if (normalizedType == null) {
                this.mService.registerBackScreenAnimationListener(stub);
            } else {
                this.mService.registerBackScreenAnimationListenerForType(stub, normalizedType);
            }
        } catch (RemoteException e) {
            rollbackNewRecord(firstRegistration, listener);
            throw e.rethrowFromSystemServer();
        } catch (RuntimeException e2) {
            rollbackNewRecord(firstRegistration, listener);
            throw e2;
        }
    }

    private static void rollbackNewRecord(boolean firstRegistration, BackScreenAnimationListener listener) {
        if (!firstRegistration) {
            return;
        }
        synchronized (sAnimationListenerLock) {
            removeRecordLocked(listener);
        }
    }

    public void unregisterBackScreenAnimationListener(BackScreenAnimationListener listener) {
        unregisterBackScreenAnimationListener(listener, null);
    }

    public boolean unregisterBackScreenAnimationListener(BackScreenAnimationListener listener, String type) {
        boolean removedEntirely;
        if (listener == null) {
            return true;
        }
        if (this.mService == null) {
            synchronized (sAnimationListenerLock) {
                removeRecordLocked(listener);
            }
            return true;
        }
        String normalizedType = normalizeAnimationType(type);
        synchronized (sAnimationListenerLock) {
            ListenerRecord record = findRecordLocked(listener);
            if (record == null) {
                return true;
            }
            IBackScreenAnimationListener stub = record.stub;
            try {
                if (normalizedType == null) {
                    this.mService.unregisterBackScreenAnimationListener(stub);
                    removedEntirely = true;
                } else {
                    removedEntirely = this.mService.unregisterBackScreenAnimationListenerForType(stub, normalizedType);
                }
                if (removedEntirely) {
                    synchronized (sAnimationListenerLock) {
                        removeRecordLocked(listener);
                    }
                }
                return removedEntirely;
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    private static ListenerRecord findRecordLocked(BackScreenAnimationListener listener) {
        for (int i = 0; i < sAnimationListeners.size(); i++) {
            ListenerRecord record = sAnimationListeners.get(i);
            if (record.listener == listener) {
                return record;
            }
        }
        return null;
    }

    private static void removeRecordLocked(BackScreenAnimationListener listener) {
        for (int i = sAnimationListeners.size() - 1; i >= 0; i--) {
            if (sAnimationListeners.get(i).listener == listener) {
                sAnimationListeners.remove(i);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class ListenerRecord {
        volatile Executor executor;
        final BackScreenAnimationListener listener;
        final IBackScreenAnimationListener stub = new AnonymousClass1();

        ListenerRecord(BackScreenAnimationListener listener, Executor executor) {
            this.listener = listener;
            this.executor = executor;
        }

        /* renamed from: android.hardware.display.StepOSDisplayManager$ListenerRecord$1, reason: invalid class name */
        class AnonymousClass1 extends IBackScreenAnimationListener.Stub {
            AnonymousClass1() {
            }

            @Override // android.hardware.display.IBackScreenAnimationListener
            public void onBackScreenAnimationResult(final BackScreenAnimationInfo info, final boolean success) {
                if (info == null) {
                    return;
                }
                ListenerRecord.this.executor.execute(new Runnable() { // from class: android.hardware.display.StepOSDisplayManager$ListenerRecord$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onBackScreenAnimationResult$0(info, success);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onBackScreenAnimationResult$0(BackScreenAnimationInfo info, boolean success) {
                ListenerRecord.this.listener.onBackScreenAnimationResult(info, success);
            }
        }
    }

    private static String normalizeAnimationType(String type) {
        if (type == null) {
            return null;
        }
        String normalized = type.trim().toLowerCase(Locale.ROOT);
        if ("agent".equals(normalized) || BackScreenAnimationInfo.TYPE_INPUT.equals(normalized) || BackScreenAnimationInfo.TYPE_OS_STATE.equals(normalized) || BackScreenAnimationInfo.TYPE_CUSTOM.equals(normalized)) {
            return normalized;
        }
        throw new IllegalArgumentException("unknown back-screen animation type: " + type);
    }

    public BackScreenAnimationInfo getBackScreenAnimationInfo() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getBackScreenAnimationInfo();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public interface BackScreenCountdownListener {
        default void onStart(int seconds) {
        }

        default void onUpdate(int remainingSeconds) {
        }

        default void onEnd() {
        }

        default void onCancel() {
        }

        default void onError(String reason) {
        }
    }

    public void startBackScreenCountdown(int seconds, Bundle extra, BackScreenCountdownListener listener) {
        CountdownListenerStub stub;
        if (listener == null) {
            stub = null;
        } else {
            stub = new CountdownListenerStub(listener);
        }
        if (this.mService == null) {
            if (stub != null) {
                stub.onError("service_unavailable");
                return;
            }
            return;
        }
        if (stub != null) {
            synchronized (sCountdownLock) {
                sActiveCountdownStub = stub;
            }
        }
        try {
            this.mService.startBackScreenCountdown(seconds, extra != null ? new Bundle(extra) : null, stub);
        } catch (RemoteException e) {
            if (stub != null) {
                stub.release();
            }
            throw e.rethrowFromSystemServer();
        }
    }

    public void cancelBackScreenCountdown() {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.cancelBackScreenCountdown();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenBrightnessMode(int mode) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenBrightnessMode(mode);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public int getBackScreenBrightnessMode() {
        if (this.mService == null) {
            return 1;
        }
        try {
            return this.mService.getBackScreenBrightnessMode();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenBrightness(int brightness) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenBrightness(brightness);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public int getBackScreenBrightness() {
        if (this.mService == null) {
            return 127;
        }
        try {
            return this.mService.getBackScreenBrightness();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean isBackScreenAutoBrightnessEnabled() {
        return getBackScreenBrightnessMode() == 1;
    }

    public void setBackScreenAutoBrightnessEnabled(boolean enabled) {
        int i;
        if (enabled) {
            i = 1;
        } else {
            i = 0;
        }
        setBackScreenBrightnessMode(i);
    }

    public boolean isBackScreenEnabled() {
        if (this.mService == null) {
            return true;
        }
        try {
            return this.mService.isBackScreenEnabled();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenEnabled(boolean enabled) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenEnabled(enabled);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean isBackScreenAlwaysOnActive() {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.isBackScreenAlwaysOnActive();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public int getBackScreenDisplayMode() {
        if (this.mService == null) {
            return 0;
        }
        try {
            return this.mService.getBackScreenDisplayMode();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenDisplayMode(int mode) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenDisplayMode(mode);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public int getBackScreenCustomStart() {
        if (this.mService == null) {
            return BACK_SCREEN_CUSTOM_DEFAULT_START_MINUTES;
        }
        try {
            return this.mService.getBackScreenCustomStart();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenCustomStart(int minutesFromMidnight) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenCustomStart(minutesFromMidnight);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public int getBackScreenCustomEnd() {
        if (this.mService == null) {
            return BACK_SCREEN_CUSTOM_DEFAULT_END_MINUTES;
        }
        try {
            return this.mService.getBackScreenCustomEnd();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenCustomEnd(int minutesFromMidnight) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenCustomEnd(minutesFromMidnight);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public String getBackScreenBasicType() {
        if (this.mService == null) {
            return "agent";
        }
        try {
            String type = this.mService.getBackScreenBasicType();
            return type != null ? type : "agent";
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenBasicType(String type) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenBasicType(type);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean isBackScreenRaiseFlipEnabled() {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.isBackScreenRaiseFlipEnabled();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenRaiseFlipEnabled(boolean enabled) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenRaiseFlipEnabled(enabled);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean isBackScreenCameraLinkEnabled() {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.isBackScreenCameraLinkEnabled();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenCameraLinkEnabled(boolean enabled) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenCameraLinkEnabled(enabled);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean isBackScreenAutoRotateEnabled() {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.isBackScreenAutoRotateEnabled();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenAutoRotateEnabled(boolean enabled) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenAutoRotateEnabled(enabled);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public String getBackScreenBasicText() {
        if (this.mService == null) {
            return BACK_SCREEN_BASIC_TEXT_DEFAULT;
        }
        try {
            String text = this.mService.getBackScreenBasicText();
            return text != null ? text : BACK_SCREEN_BASIC_TEXT_DEFAULT;
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenBasicText(String text) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenBasicText(text);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean isBackScreenBasicTextInvert() {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.isBackScreenBasicTextInvert();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenBasicTextInvert(boolean invert) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenBasicTextInvert(invert);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean isBackScreenBasicTextMarquee() {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.isBackScreenBasicTextMarquee();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setBackScreenBasicTextMarquee(boolean enabled) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBackScreenBasicTextMarquee(enabled);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void notifyBackScreenCameraCapture(Bundle extra) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.notifyBackScreenCameraCapture(extra != null ? new Bundle(extra) : null);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class CountdownListenerStub extends IBackScreenCountdownListener.Stub {
        private final Executor mExecutor = new Executor() { // from class: android.hardware.display.StepOSDisplayManager$CountdownListenerStub$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                Handler.createAsync(Looper.getMainLooper()).post(runnable);
            }
        };
        private final BackScreenCountdownListener mListener;

        CountdownListenerStub(BackScreenCountdownListener listener) {
            this.mListener = listener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onStart$1(int seconds) {
            this.mListener.onStart(seconds);
        }

        @Override // android.hardware.display.IBackScreenCountdownListener
        public void onStart(final int seconds) {
            this.mExecutor.execute(new Runnable() { // from class: android.hardware.display.StepOSDisplayManager$CountdownListenerStub$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStart$1(seconds);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onUpdate$2(int remainingSeconds) {
            this.mListener.onUpdate(remainingSeconds);
        }

        @Override // android.hardware.display.IBackScreenCountdownListener
        public void onUpdate(final int remainingSeconds) {
            this.mExecutor.execute(new Runnable() { // from class: android.hardware.display.StepOSDisplayManager$CountdownListenerStub$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onUpdate$2(remainingSeconds);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onEnd$3() {
            this.mListener.onEnd();
        }

        @Override // android.hardware.display.IBackScreenCountdownListener
        public void onEnd() {
            this.mExecutor.execute(new Runnable() { // from class: android.hardware.display.StepOSDisplayManager$CountdownListenerStub$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onEnd$3();
                }
            });
            release();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCancel$4() {
            this.mListener.onCancel();
        }

        @Override // android.hardware.display.IBackScreenCountdownListener
        public void onCancel() {
            this.mExecutor.execute(new Runnable() { // from class: android.hardware.display.StepOSDisplayManager$CountdownListenerStub$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCancel$4();
                }
            });
            release();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$5(String reason) {
            this.mListener.onError(reason);
        }

        @Override // android.hardware.display.IBackScreenCountdownListener
        public void onError(final String reason) {
            this.mExecutor.execute(new Runnable() { // from class: android.hardware.display.StepOSDisplayManager$CountdownListenerStub$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onError$5(reason);
                }
            });
            release();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release() {
            synchronized (StepOSDisplayManager.sCountdownLock) {
                if (StepOSDisplayManager.sActiveCountdownStub == this) {
                    StepOSDisplayManager.sActiveCountdownStub = null;
                }
            }
        }
    }

    public boolean isPreviewNightDisplay() {
        return this.mIsPreviewNightDisplay;
    }
}
