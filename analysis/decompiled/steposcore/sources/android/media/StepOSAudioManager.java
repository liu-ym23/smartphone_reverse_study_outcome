package android.media;

import android.content.Context;
import android.media.IAlwaysOnSceneDispatcher;
import android.media.IAudioService;
import android.media.IStepOSAudioService;
import android.media.steposmanager.AlwaysOnRecordSceneCallback;
import android.media.steposmanager.AlwaysOnRecordSceneInfo;
import android.media.steposmanager.AlwaysOnRecordSceneSegment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.Log;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class StepOSAudioManager {
    public static final String SERVICE_NAME = "stepos_audio";
    public static final int SYSTEM_AUDIO_SESSION_ID = -1;
    private static final String TAG = "StepOSAudioManager";
    private final Map<Integer, IAlwaysOnSceneDispatcher> mAlwaysOnSceneDispatchers = new ArrayMap();
    private final Context mContext;
    private volatile IStepOSAudioService mExtCache;

    public StepOSAudioManager(Context context) {
        this.mContext = (Context) Objects.requireNonNull(context, "context");
    }

    public static StepOSAudioManager get(Context context) {
        return (StepOSAudioManager) context.getSystemService("stepos_audio");
    }

    public void registerAlwaysOnRecordSceneCallback(AlwaysOnRecordSceneCallback callback, Handler handler, int audioSessionId) {
        Objects.requireNonNull(callback, "callback");
        Handler dispatchHandler = handler != null ? handler : new Handler(Looper.getMainLooper());
        IAlwaysOnSceneDispatcher dispatcher = new AnonymousClass1(this, dispatchHandler, callback);
        IStepOSAudioService ext = getExtension();
        if (ext == null) {
            Log.w(TAG, "registerAlwaysOnRecordSceneCallback: audio extension unavailable");
            return;
        }
        try {
            ext.registerAlwaysOnSceneCallback(audioSessionId, dispatcher);
            synchronized (this.mAlwaysOnSceneDispatchers) {
                this.mAlwaysOnSceneDispatchers.put(Integer.valueOf(audioSessionId), dispatcher);
            }
        } catch (RemoteException e) {
            this.mExtCache = null;
            throw e.rethrowFromSystemServer();
        }
    }

    /* renamed from: android.media.StepOSAudioManager$1, reason: invalid class name */
    class AnonymousClass1 extends IAlwaysOnSceneDispatcher.Stub {
        final /* synthetic */ AlwaysOnRecordSceneCallback val$callback;
        final /* synthetic */ Handler val$dispatchHandler;

        AnonymousClass1(StepOSAudioManager this$0, Handler handler, AlwaysOnRecordSceneCallback alwaysOnRecordSceneCallback) {
            this.val$dispatchHandler = handler;
            this.val$callback = alwaysOnRecordSceneCallback;
        }

        @Override // android.media.IAlwaysOnSceneDispatcher
        public void dispatchSceneChanged(final AlwaysOnRecordSceneInfo scene) {
            Handler handler = this.val$dispatchHandler;
            final AlwaysOnRecordSceneCallback alwaysOnRecordSceneCallback = this.val$callback;
            handler.post(new Runnable() { // from class: android.media.StepOSAudioManager$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    alwaysOnRecordSceneCallback.onSceneChanged(scene);
                }
            });
        }

        @Override // android.media.IAlwaysOnSceneDispatcher
        public void dispatchSceneSegmentClosed(final AlwaysOnRecordSceneSegment segment) {
            Handler handler = this.val$dispatchHandler;
            final AlwaysOnRecordSceneCallback alwaysOnRecordSceneCallback = this.val$callback;
            handler.post(new Runnable() { // from class: android.media.StepOSAudioManager$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    alwaysOnRecordSceneCallback.onSceneSegmentClosed(segment);
                }
            });
        }
    }

    public void unregisterAlwaysOnRecordSceneCallback(int audioSessionId) {
        IAlwaysOnSceneDispatcher dispatcher;
        synchronized (this.mAlwaysOnSceneDispatchers) {
            dispatcher = this.mAlwaysOnSceneDispatchers.remove(Integer.valueOf(audioSessionId));
        }
        IStepOSAudioService ext = getExtension();
        if (ext == null || dispatcher == null) {
            return;
        }
        try {
            ext.unregisterAlwaysOnSceneCallback(audioSessionId, dispatcher);
        } catch (RemoteException e) {
            this.mExtCache = null;
            throw e.rethrowFromSystemServer();
        }
    }

    private IStepOSAudioService getExtension() {
        IStepOSAudioService ext = this.mExtCache;
        if (ext != null) {
            return ext;
        }
        IBinder audioBinder = ServiceManager.getService("audio");
        if (audioBinder == null) {
            return null;
        }
        IAudioService audioService = IAudioService.Stub.asInterface(audioBinder);
        try {
            IBinder extBinder = audioService.asBinder().getExtension();
            if (extBinder != null) {
                ext = IStepOSAudioService.Stub.asInterface(extBinder);
                this.mExtCache = ext;
                return ext;
            }
            return ext;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get audio service extension", e);
            return ext;
        }
    }
}
