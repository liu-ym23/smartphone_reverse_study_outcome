package com.android.server.soundtrigger_middleware;

import android.content.Context;
import android.media.permission.Identity;
import android.media.permission.IdentityContext;
import android.media.permission.PermissionUtil;
import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.media.soundtrigger_middleware.ISoundTriggerCallback;
import android.media.soundtrigger_middleware.ISoundTriggerModule;
import android.media.soundtrigger_middleware.PhraseRecognitionEventSys;
import android.media.soundtrigger_middleware.RecognitionEventSys;
import android.media.soundtrigger_middleware.SoundTriggerModuleDescriptor;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.server.LocalServices;
import com.android.server.pm.permission.LegacyPermissionManagerInternal;
import java.io.PrintWriter;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerMiddlewarePermission implements ISoundTriggerMiddlewareInternal, Dumpable {
    private static final String TAG = "SoundTriggerMiddlewarePermission";
    private final Context mContext;
    private final ISoundTriggerMiddlewareInternal mDelegate;

    private class ModuleWrapper extends ISoundTriggerModule.Stub {
        private final CallbackWrapper mCallbackWrapper;
        private ISoundTriggerModule mDelegate;
        private final boolean mIsTrusted;
        private final Identity mOriginatorIdentity;
        final /* synthetic */ SoundTriggerMiddlewarePermission this$0;

        private class CallbackWrapper implements ISoundTriggerCallback {
            private final ISoundTriggerCallback mDelegate;
            final /* synthetic */ ModuleWrapper this$1;

            /* synthetic */ CallbackWrapper(ModuleWrapper r1, ISoundTriggerCallback r2, SoundTriggerMiddlewarePermissionIA r3) {
                this(r1, r2);
            }

            private CallbackWrapper(ModuleWrapper r1, ISoundTriggerCallback delegate) {
                this.this$1 = r1;
                this.mDelegate = delegate;
            }

            public void onRecognition(int modelHandle, RecognitionEventSys event, int captureSession) throws RemoteException {
                enforcePermissions("Sound trigger recognition.");
                this.mDelegate.onRecognition(modelHandle, event, captureSession);
            }

            public void onPhraseRecognition(int modelHandle, PhraseRecognitionEventSys event, int captureSession) throws RemoteException {
                enforcePermissions("Sound trigger phrase recognition.");
                this.mDelegate.onPhraseRecognition(modelHandle, event, captureSession);
            }

            public void onResourcesAvailable() throws RemoteException {
                this.mDelegate.onResourcesAvailable();
            }

            public void onModelUnloaded(int modelHandle) throws RemoteException {
                this.mDelegate.onModelUnloaded(modelHandle);
            }

            public void onModuleDied() throws RemoteException {
                this.mDelegate.onModuleDied();
            }

            public IBinder asBinder() {
                return this.mDelegate.asBinder();
            }

            public String toString() {
                return this.mDelegate.toString();
            }

            private void enforcePermissions(String reason) {
                if (ModuleWrapper.m8266$$Nest$fgetmIsTrusted(this.this$1) == false) goto L5;
                SoundTriggerMiddlewarePermission.m8265$$Nest$menforcePermissionsForPreflight(this.this$1.this$0, ModuleWrapper.m8267$$Nest$fgetmOriginatorIdentity(this.this$1));
                return;
            L5:
                this.this$1.this$0.enforcePermissionsForDataDelivery(ModuleWrapper.m8267$$Nest$fgetmOriginatorIdentity(this.this$1), reason);
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsTrusted, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8266$$Nest$fgetmIsTrusted(ModuleWrapper r0) {
            return r0.mIsTrusted;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOriginatorIdentity, reason: not valid java name */
        static /* bridge */ /* synthetic */ Identity m8267$$Nest$fgetmOriginatorIdentity(ModuleWrapper r0) {
            return r0.mOriginatorIdentity;
        }

        ModuleWrapper(SoundTriggerMiddlewarePermission r2, Identity originatorIdentity, ISoundTriggerCallback callback, boolean isTrusted) {
            this.this$0 = r2;
            this.mOriginatorIdentity = originatorIdentity;
            this.mCallbackWrapper = new CallbackWrapper(this, callback, null);
            this.mIsTrusted = isTrusted;
        }

        ModuleWrapper attach(ISoundTriggerModule delegate) {
            this.mDelegate = delegate;
            return this;
        }

        ISoundTriggerCallback getCallbackWrapper() {
            return this.mCallbackWrapper;
        }

        public int loadModel(SoundModel model) throws RemoteException {
            enforcePermissions();
            return this.mDelegate.loadModel(model);
        }

        public int loadPhraseModel(PhraseSoundModel model) throws RemoteException {
            enforcePermissions();
            return this.mDelegate.loadPhraseModel(model);
        }

        public void unloadModel(int modelHandle) throws RemoteException {
            this.mDelegate.unloadModel(modelHandle);
        }

        public IBinder startRecognition(int modelHandle, RecognitionConfig config) throws RemoteException {
            enforcePermissions();
            return this.mDelegate.startRecognition(modelHandle, config);
        }

        public void stopRecognition(int modelHandle) throws RemoteException {
            this.mDelegate.stopRecognition(modelHandle);
        }

        public void forceRecognitionEvent(int modelHandle) throws RemoteException {
            enforcePermissions();
            this.mDelegate.forceRecognitionEvent(modelHandle);
        }

        public void setModelParameter(int modelHandle, int modelParam, int value) throws RemoteException {
            enforcePermissions();
            this.mDelegate.setModelParameter(modelHandle, modelParam, value);
        }

        public int getModelParameter(int modelHandle, int modelParam) throws RemoteException {
            enforcePermissions();
            return this.mDelegate.getModelParameter(modelHandle, modelParam);
        }

        public ModelParameterRange queryModelParameterSupport(int modelHandle, int modelParam) throws RemoteException {
            enforcePermissions();
            return this.mDelegate.queryModelParameterSupport(modelHandle, modelParam);
        }

        public void detach() throws RemoteException {
            this.mDelegate.detach();
        }

        public String toString() {
            return Objects.toString(this.mDelegate);
        }

        private void enforcePermissions() {
            SoundTriggerMiddlewarePermission.m8265$$Nest$menforcePermissionsForPreflight(this.this$0, this.mOriginatorIdentity);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$menforcePermissionsForPreflight, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8265$$Nest$menforcePermissionsForPreflight(SoundTriggerMiddlewarePermission r0, Identity r1) {
        r0.enforcePermissionsForPreflight(r1);
    }

    public SoundTriggerMiddlewarePermission(ISoundTriggerMiddlewareInternal delegate, Context context) {
        this.mDelegate = delegate;
        this.mContext = context;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerMiddlewareInternal
    public SoundTriggerModuleDescriptor[] listModules() {
        Identity identity = getIdentity();
        enforcePermissionForPreflight(this.mContext, identity, "android.permission.CAPTURE_AUDIO_HOTWORD");
        return this.mDelegate.listModules();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerMiddlewareInternal
    public ISoundTriggerModule attach(int handle, ISoundTriggerCallback callback, boolean isTrusted) {
        Identity identity = getIdentity();
        enforcePermissionsForPreflight(identity);
        ModuleWrapper wrapper = new ModuleWrapper(this, identity, callback, isTrusted);
        return wrapper.attach(this.mDelegate.attach(handle, wrapper.getCallbackWrapper(), isTrusted));
    }

    public String toString() {
        return Objects.toString(this.mDelegate);
    }

    private static Identity getIdentity() {
        return IdentityContext.getNonNull();
    }

    private void enforcePermissionsForPreflight(Identity identity) {
        enforcePermissionForPreflight(this.mContext, identity, "android.permission.RECORD_AUDIO");
        enforcePermissionForPreflight(this.mContext, identity, "android.permission.CAPTURE_AUDIO_HOTWORD");
    }

    void enforcePermissionsForDataDelivery(Identity identity, String reason) {
        enforceSoundTriggerRecordAudioPermissionForDataDelivery(identity, reason);
        enforcePermissionForDataDelivery(this.mContext, identity, "android.permission.CAPTURE_AUDIO_HOTWORD", reason);
    }

    private static void enforcePermissionForDataDelivery(Context context, Identity identity, String permission, String reason) {
        int status = PermissionUtil.checkPermissionForDataDelivery(context, identity, permission, reason);
        if (status != 0) goto L6;
        return;
    L6:
        throw new SecurityException(String.format("Failed to obtain permission %s for identity %s", new Object[]{permission, ObjectPrinter.print(identity, 16)}));
    }

    private static void enforceSoundTriggerRecordAudioPermissionForDataDelivery(Identity identity, String reason) {
        LegacyPermissionManagerInternal lpmi = (LegacyPermissionManagerInternal) LocalServices.getService(LegacyPermissionManagerInternal.class);
        int status = lpmi.checkSoundTriggerRecordAudioPermissionForDataDelivery(identity.uid, identity.packageName, identity.attributionTag, reason);
        if (status != 0) goto L6;
        return;
    L6:
        throw new SecurityException(String.format("Failed to obtain permission RECORD_AUDIO for identity %s", new Object[]{ObjectPrinter.print(identity, 16)}));
    }

    private static void enforcePermissionForPreflight(Context context, Identity identity, String permission) {
        int status = PermissionUtil.checkPermissionForPreflight(context, identity, permission);
        switch(status) {
            case 0: goto L8;
            case 1: goto L8;
            case 2: goto L7;
            default: goto L5;
        };
    L8:
        return;
    L5:
        throw new RuntimeException("Unexpected perimission check result.");
    L7:
        throw new SecurityException(String.format("Failed to obtain permission %s for identity %s", new Object[]{permission, ObjectPrinter.print(identity, 16)}));
    }

    @Override // com.android.server.soundtrigger_middleware.Dumpable
    public void dump(PrintWriter pw) {
        if ((this.mDelegate instanceof Dumpable) == false) goto L6;
        ((Dumpable) this.mDelegate).dump(pw);
        return;
    }
}
