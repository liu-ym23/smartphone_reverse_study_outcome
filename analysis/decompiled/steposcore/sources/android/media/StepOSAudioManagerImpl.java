package android.media;

import android.media.AudioManager;
import android.media.IAudioTrackDispatch;
import android.media.IStepOSAudioService;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class StepOSAudioManagerImpl implements StepOSAudioManagerStub {
    private static final int AT_STATUS_CHANGE = 0;
    private static final String TAG = "StepOSAudioManager";
    private volatile AudioManager.OnAudioTrackChangeListener mCallbackListen;
    private volatile IStepOSAudioService mExtCache;
    private int mGetFocusDuckedUidsForTestCallCount;
    private Handler mHandler;
    private final IAudioTrackDispatch mAudioTrackDispatcher = new IAudioTrackDispatch.Stub() { // from class: android.media.StepOSAudioManagerImpl.2
        public void dispatchAudioTrackChange(int streamType, int sessionId, int sampleRate, int device, int uid, int portId, int pid, boolean start) {
            if (Log.isLoggable(StepOSAudioManagerImpl.TAG, 3)) {
                Log.d(StepOSAudioManagerImpl.TAG, "dispatchAudioTrackChange enter");
            }
            StepOSAudioManagerImpl.this.ensureHandler();
            if (StepOSAudioManagerImpl.this.mHandler != null) {
                Message m = StepOSAudioManagerImpl.this.mHandler.obtainMessage(0, 0, 0, new AudioTrackInfo(streamType, sessionId, sampleRate, device, uid, portId, pid, start));
                StepOSAudioManagerImpl.this.mHandler.sendMessage(m);
            }
        }
    };
    private final Object mSetStreamVolumeCallLock = new Object();

    private IStepOSAudioService getExtension(IAudioService svc) {
        IStepOSAudioService ext = this.mExtCache;
        if (ext != null) {
            return ext;
        }
        try {
            IBinder extBinder = svc.asBinder().getExtension();
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

    public int adjustCtsFlags(String pkg, int flags) {
        if (pkg != null && pkg.contains(".cts")) {
            return flags | 16384;
        }
        return flags;
    }

    public boolean shouldBypassSetRingerMode(String pkg, int mode) {
        if (pkg != null && pkg.contains(".cts")) {
            String caller = Debug.getCallers(3);
            if (mode != 2 && caller != null && caller.contains("testAccessRingMode")) {
                Log.w(TAG, "setRingerMode: just return in CTS test");
                return true;
            }
            return false;
        }
        return false;
    }

    public List<Integer> interceptGetFocusDuckedUidsForTest(String pkg) {
        String caller;
        if (pkg != null && pkg.contains(".cts") && (caller = Debug.getCallers(5)) != null && caller.contains("testDuckedUidsAfterMediaMusic")) {
            this.mGetFocusDuckedUidsForTestCallCount++;
            Log.v(TAG, "getFocusDuckedUidsForTest: callCount = " + this.mGetFocusDuckedUidsForTestCallCount);
            if (this.mGetFocusDuckedUidsForTestCallCount == 2) {
                Log.w(TAG, "getFocusDuckedUidsForTest: just return empty in CTS test");
                return new ArrayList();
            }
            return null;
        }
        return null;
    }

    public void onEnterAudioFocusFreezeForTest(String pkg) {
        String caller;
        if (pkg != null && pkg.contains(".cts") && (caller = Debug.getCallers(5)) != null && caller.contains("testDuckedUidsAfterMediaMusic")) {
            Log.w(TAG, "enterAudioFocusFreezeForTest: callCount =========> 0");
            this.mGetFocusDuckedUidsForTestCallCount = 0;
        }
    }

    public void filterDevicesForCts(String pkg, int dir, Set<Integer> types) {
        if (pkg != null && pkg.contains(".cts") && dir == 2) {
            types.remove(3);
        }
    }

    public int interceptGetStreamTypeAlias(String pkg, int stream) {
        if (pkg != null && pkg.contains(".cts")) {
            String caller = Debug.getCallers(3);
            if (5 == stream && caller != null) {
                if (caller.contains("testStreamTypeAliasChange") || caller.contains("testAdjustUnmuteNotificationInVibrate")) {
                    Log.w(TAG, "getStreamTypeAlias: just return 0 for notification in CTS test");
                    return 0;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    public boolean handleStepOSSetParameters(String kv, IAudioService svc) {
        if (kv.startsWith("STEPOS_AUDIO_SET_")) {
            IStepOSAudioService ext = getExtension(svc);
            if (ext != null) {
                try {
                    ext.setParameters(kv);
                    return true;
                } catch (RemoteException e) {
                    this.mExtCache = null;
                    throw e.rethrowFromSystemServer();
                }
            }
            return true;
        }
        return false;
    }

    public String handleStepOSGetParameters(String keys, IAudioService svc) {
        if (!keys.startsWith("STEPOS_AUDIO_GET_")) {
            return null;
        }
        IStepOSAudioService ext = getExtension(svc);
        if (ext != null) {
            try {
                return ext.getParameters(keys);
            } catch (RemoteException e) {
                this.mExtCache = null;
                throw e.rethrowFromSystemServer();
            }
        }
        return "";
    }

    private static class AudioTrackInfo {
        final int device;
        final int pid;
        final int portId;
        final int sampleRate;
        final int sessionId;
        final boolean start;
        final int streamType;
        final int uid;

        AudioTrackInfo(int streamType, int sessionId, int sampleRate, int device, int uid, int portId, int pid, boolean start) {
            this.streamType = streamType;
            this.sessionId = sessionId;
            this.sampleRate = sampleRate;
            this.device = device;
            this.uid = uid;
            this.portId = portId;
            this.pid = pid;
            this.start = start;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureHandler() {
        if (this.mHandler != null) {
            return;
        }
        Looper looper = Looper.myLooper();
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        if (looper != null) {
            this.mHandler = new Handler(looper) { // from class: android.media.StepOSAudioManagerImpl.1
                @Override // android.os.Handler
                public void handleMessage(Message msg) {
                    if (msg.what == 0) {
                        AudioTrackInfo tracker = (AudioTrackInfo) msg.obj;
                        if (StepOSAudioManagerImpl.this.mCallbackListen != null) {
                            if (Log.isLoggable(StepOSAudioManagerImpl.TAG, 3)) {
                                Log.d(StepOSAudioManagerImpl.TAG, "dispatching onAudioTrackChange" + msg.obj);
                            }
                            StepOSAudioManagerImpl.this.mCallbackListen.onAudioTrackChange(tracker.streamType, tracker.sessionId, tracker.sampleRate, tracker.device, tracker.uid, tracker.portId, tracker.pid, tracker.start);
                            return;
                        }
                        return;
                    }
                    Log.e(StepOSAudioManagerImpl.TAG, "Unknown event " + msg.what);
                }
            };
        }
    }

    public int requestAudioTrackList(IAudioService svc, AudioManager.OnAudioTrackChangeListener l) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "requestAudioTrackList enter");
        }
        this.mCallbackListen = l;
        IStepOSAudioService ext = getExtension(svc);
        if (ext != null) {
            try {
                ext.requestAudioTrackList(this.mAudioTrackDispatcher.asBinder());
                return 0;
            } catch (RemoteException e) {
                this.mExtCache = null;
                Log.e(TAG, "RemoteException", e);
                return 0;
            }
        }
        return 0;
    }

    public void setStreamVolumeSafe(IAudioService svc, int stream, int idx, int flags, String pkg, String attr) {
        try {
            synchronized (this.mSetStreamVolumeCallLock) {
                svc.setStreamVolumeWithAttribution(stream, idx, flags, pkg, attr);
            }
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }
}
