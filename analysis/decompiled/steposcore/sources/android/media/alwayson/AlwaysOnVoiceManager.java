package android.media.alwayson;

import android.content.Context;
import android.media.alwayson.IAlwaysOnVoiceService;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.provider.Settings;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class AlwaysOnVoiceManager {
    public static final int CAPTURE_IN = 1;
    public static final int CAPTURE_OUT = 2;
    public static final int REASON_AUDIO_PREEMPTED = 2;
    public static final int REASON_RECORD_OPEN_FAILED = 9;
    public static final int REASON_SCENE_EXIT = 7;
    public static final int REASON_SERVICE_UNBIND = 4;
    public static final int REASON_SETTINGS_OFF = 1;
    public static final int REASON_USER_FORCE_STOP = 3;
    public static final int REASON_USER_STOP = 8;
    public static final int REASON_USER_SWITCHED = 5;
    public static final int REASON_VAD_IDLE = 6;
    public static final String SCENE_SUBTAG_ACTIVE = "active";
    public static final String SCENE_SUBTAG_LISTEN = "listen";
    public static final String SCENE_SUBTAG_MEDIA_GAME = "game";
    public static final String SCENE_SUBTAG_MEDIA_MUSIC = "music";
    public static final String SCENE_SUBTAG_MEDIA_VIDEO = "video";
    public static final String SCENE_SUBTAG_RINGING = "ringing";
    public static final String SCENE_TAG_CALL = "call";
    public static final String SCENE_TAG_MEDIA = "media";
    public static final String SCENE_TAG_NORMAL = "normal";
    public static final String SCENE_TAG_VOIP = "voip";
    public static final int SCOPE_ALL = 4;
    public static final int SCOPE_AUTO_SCENE = 2;
    public static final int SCOPE_AUTO_VAD = 1;
    public static final int SCOPE_VAD_ENABLED = 3;
    public static final String SERVICE_NAME = "always_on_voice";
    public static final String SETTINGS_ALWAYS_ON_CALL_RECORDING_ENABLED = "always_on_call_recording_enabled";
    public static final String SETTINGS_ALWAYS_ON_VOICE_ENABLED = "always_on_voice_enabled";
    public static final String SETTINGS_ALWAYS_ON_VOIP_PACKAGE_ALLOWLIST = "always_on_voip_package_allowlist";
    public static final String SETTINGS_ALWAYS_ON_VOIP_RECORDING_ENABLED = "always_on_voip_recording_enabled";
    private static final String TAG = "AlwaysOnVoiceManager";
    public static final int TRIGGER_AUTO_SCENE = 2;
    public static final int TRIGGER_AUTO_VAD = 1;
    public static final int TRIGGER_VAD_ENABLED = 3;
    private final Context mContext;
    private IAlwaysOnVoiceService mService;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureMask {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureStopScope {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureTrigger {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StopReason {
    }

    public AlwaysOnVoiceManager(Context context) {
        this.mContext = context;
    }

    public static AlwaysOnVoiceManager get(Context context) {
        return (AlwaysOnVoiceManager) context.getSystemService("always_on_voice");
    }

    public void enableVadListening(AlwaysOnVadListenRequest request) {
        try {
            requireService().enableVadListening(request);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void disableVadListening(String callerTag) {
        try {
            requireService().disableVadListening(callerTag);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean isAlwaysOnEnabled() {
        return Settings.Secure.getInt(this.mContext.getContentResolver(), SETTINGS_ALWAYS_ON_VOICE_ENABLED, 0) != 0;
    }

    public boolean isCapturing() {
        try {
            return requireService().isCapturing();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean isVadListeningEnabled(String callerTag) {
        try {
            return requireService().isVadListeningEnabled(callerTag);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean isVadListeningActive() {
        try {
            return requireService().isVadListeningActive();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    private IAlwaysOnVoiceService requireService() {
        IAlwaysOnVoiceService service = this.mService;
        if (service != null) {
            return service;
        }
        IBinder binder = ServiceManager.waitForService("always_on_voice");
        if (binder == null) {
            throw new IllegalStateException("AlwaysOn voice service is not available");
        }
        IAlwaysOnVoiceService service2 = IAlwaysOnVoiceService.Stub.asInterface(binder);
        this.mService = service2;
        Log.i(TAG, "Resolved AO service from always_on_voice");
        return service2;
    }
}
