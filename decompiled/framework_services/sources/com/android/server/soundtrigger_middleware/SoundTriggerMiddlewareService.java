package com.android.server.soundtrigger_middleware;

import android.content.Context;
import android.content.PermissionChecker;
import android.media.permission.ClearCallingIdentityContext;
import android.media.permission.Identity;
import android.media.permission.PermissionUtil;
import android.media.permission.SafeCloseable;
import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.media.soundtrigger_middleware.ISoundTriggerCallback;
import android.media.soundtrigger_middleware.ISoundTriggerInjection;
import android.media.soundtrigger_middleware.ISoundTriggerMiddlewareService;
import android.media.soundtrigger_middleware.ISoundTriggerModule;
import android.media.soundtrigger_middleware.SoundTriggerModuleDescriptor;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.server.SystemService;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerMiddlewareService extends ISoundTriggerMiddlewareService.Stub {
    private static final String TAG = "SoundTriggerMiddlewareService";
    private final Context mContext;
    private final ISoundTriggerMiddlewareInternal mDelegate;
    private final SoundTriggerInjection mInjection;

    public static final class Lifecycle extends SystemService {
        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            SoundTriggerInjection injection = new SoundTriggerInjection();
            HalFactory[] factories = {new DefaultHalFactory(), new FakeHalFactory(injection)};
            publishBinderService("soundtrigger_middleware", new SoundTriggerMiddlewareService(new SoundTriggerMiddlewareLogging(getContext(), new SoundTriggerMiddlewarePermission(new SoundTriggerMiddlewareValidation(new SoundTriggerMiddlewareImpl(factories, new AudioSessionProviderImpl())), getContext())), getContext(), injection, null));
        }
    }

    private static final class ModuleService extends ISoundTriggerModule.Stub {
        private final ISoundTriggerModule mDelegate;

        /* synthetic */ ModuleService(ISoundTriggerModule r1, SoundTriggerMiddlewareServiceIA r2) {
            this(r1);
        }

        private ModuleService(ISoundTriggerModule delegate) {
            this.mDelegate = delegate;
        }

        public int loadModel(SoundModel model) throws RemoteException {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            int r1 = this.mDelegate.loadModel(model);     // Catch: Throwable -> L7
            if (ignored == null) goto L6;
            ignored.close();
        L6:
            return r1;
        L7:
            th = move-exception;
            if (ignored != null) goto L16;
        L13:
            throw th;
        L16:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public int loadPhraseModel(PhraseSoundModel model) throws RemoteException {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            int r1 = this.mDelegate.loadPhraseModel(model);     // Catch: Throwable -> L7
            if (ignored == null) goto L6;
            ignored.close();
        L6:
            return r1;
        L7:
            th = move-exception;
            if (ignored != null) goto L16;
        L13:
            throw th;
        L16:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public void unloadModel(int modelHandle) throws RemoteException {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            this.mDelegate.unloadModel(modelHandle);     // Catch: Throwable -> L7
            if (ignored == null) goto L18;
            ignored.close();
            return;
        L18:
            return;
        L7:
            th = move-exception;
            if (ignored != null) goto L14;
        L13:
            throw th;
        L14:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public IBinder startRecognition(int modelHandle, RecognitionConfig config) throws RemoteException {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            IBinder r1 = this.mDelegate.startRecognition(modelHandle, config);     // Catch: Throwable -> L7
            if (ignored == null) goto L6;
            ignored.close();
        L6:
            return r1;
        L7:
            th = move-exception;
            if (ignored != null) goto L16;
        L13:
            throw th;
        L16:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public void stopRecognition(int modelHandle) throws RemoteException {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            this.mDelegate.stopRecognition(modelHandle);     // Catch: Throwable -> L7
            if (ignored == null) goto L18;
            ignored.close();
            return;
        L18:
            return;
        L7:
            th = move-exception;
            if (ignored != null) goto L14;
        L13:
            throw th;
        L14:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public void forceRecognitionEvent(int modelHandle) throws RemoteException {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            this.mDelegate.forceRecognitionEvent(modelHandle);     // Catch: Throwable -> L7
            if (ignored == null) goto L18;
            ignored.close();
            return;
        L18:
            return;
        L7:
            th = move-exception;
            if (ignored != null) goto L14;
        L13:
            throw th;
        L14:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public void setModelParameter(int modelHandle, int modelParam, int value) throws RemoteException {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            this.mDelegate.setModelParameter(modelHandle, modelParam, value);     // Catch: Throwable -> L7
            if (ignored == null) goto L18;
            ignored.close();
            return;
        L18:
            return;
        L7:
            th = move-exception;
            if (ignored != null) goto L14;
        L13:
            throw th;
        L14:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public int getModelParameter(int modelHandle, int modelParam) throws RemoteException {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            int r1 = this.mDelegate.getModelParameter(modelHandle, modelParam);     // Catch: Throwable -> L7
            if (ignored == null) goto L6;
            ignored.close();
        L6:
            return r1;
        L7:
            th = move-exception;
            if (ignored != null) goto L16;
        L13:
            throw th;
        L16:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public ModelParameterRange queryModelParameterSupport(int modelHandle, int modelParam) throws RemoteException {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            ModelParameterRange r1 = this.mDelegate.queryModelParameterSupport(modelHandle, modelParam);     // Catch: Throwable -> L7
            if (ignored == null) goto L6;
            ignored.close();
        L6:
            return r1;
        L7:
            th = move-exception;
            if (ignored != null) goto L16;
        L13:
            throw th;
        L16:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public void detach() throws RemoteException {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            this.mDelegate.detach();     // Catch: Throwable -> L7
            if (ignored == null) goto L18;
            ignored.close();
            return;
        L18:
            return;
        L7:
            th = move-exception;
            if (ignored != null) goto L14;
        L13:
            throw th;
        L14:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }
    }

    /* synthetic */ SoundTriggerMiddlewareService(ISoundTriggerMiddlewareInternal r1, Context r2, SoundTriggerInjection r3, SoundTriggerMiddlewareServiceIA r4) {
        this(r1, r2, r3);
    }

    private SoundTriggerMiddlewareService(ISoundTriggerMiddlewareInternal delegate, Context context, SoundTriggerInjection injection) {
        delegate.getClass();
        this.mDelegate = delegate;
        this.mContext = context;
        this.mInjection = injection;
    }

    public SoundTriggerModuleDescriptor[] listModulesAsOriginator(Identity identity) {
        SafeCloseable ignored = establishIdentityDirect(identity);
        SoundTriggerModuleDescriptor[] r1 = this.mDelegate.listModules();     // Catch: Throwable -> L7
        if (ignored == null) goto L6;
        ignored.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (ignored != null) goto L16;
    L13:
        throw th;
    L16:
        ignored.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public SoundTriggerModuleDescriptor[] listModulesAsMiddleman(Identity middlemanIdentity, Identity originatorIdentity) {
        SafeCloseable ignored = establishIdentityIndirect(middlemanIdentity, originatorIdentity);
        SoundTriggerModuleDescriptor[] r1 = this.mDelegate.listModules();     // Catch: Throwable -> L7
        if (ignored == null) goto L6;
        ignored.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (ignored != null) goto L16;
    L13:
        throw th;
    L16:
        ignored.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public ISoundTriggerModule attachAsOriginator(int handle, Identity identity, ISoundTriggerCallback callback) {
        identity.getClass();
        SafeCloseable ignored = establishIdentityDirect(identity);
        ModuleService r1 = new ModuleService(this.mDelegate.attach(handle, callback, false), null);     // Catch: Throwable -> L7
        if (ignored == null) goto L6;
        ignored.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (ignored != null) goto L14;
    L13:
        throw th;
    L14:
        ignored.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public ISoundTriggerModule attachAsMiddleman(int handle, Identity middlemanIdentity, Identity originatorIdentity, ISoundTriggerCallback callback, boolean isTrusted) {
        middlemanIdentity.getClass();
        originatorIdentity.getClass();
        SafeCloseable ignored = establishIdentityIndirect(middlemanIdentity, originatorIdentity);
        ModuleService r1 = new ModuleService(this.mDelegate.attach(handle, callback, isTrusted), null);     // Catch: Throwable -> L7
        if (ignored == null) goto L6;
        ignored.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (ignored != null) goto L14;
    L13:
        throw th;
    L14:
        ignored.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public void attachFakeHalInjection(ISoundTriggerInjection injection) {
        PermissionChecker.checkCallingOrSelfPermissionForPreflight(this.mContext, "android.permission.MANAGE_SOUND_TRIGGER");
        SafeCloseable ignored = ClearCallingIdentityContext.create();
        SoundTriggerInjection r1 = this.mInjection;     // Catch: Throwable -> L7
        injection.getClass();     // Catch: Throwable -> L7
        r1.registerClient(injection);     // Catch: Throwable -> L7
        if (ignored == null) goto L18;
        ignored.close();
        return;
    L18:
        return;
    L7:
        th = move-exception;
        if (ignored != null) goto L14;
    L13:
        throw th;
    L14:
        ignored.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        if ((this.mDelegate instanceof Dumpable) == false) goto L6;
        ((Dumpable) this.mDelegate).dump(fout);
        return;
    }

    private SafeCloseable establishIdentityIndirect(Identity middlemanIdentity, Identity originatorIdentity) {
        return PermissionUtil.establishIdentityIndirect(this.mContext, "android.permission.SOUNDTRIGGER_DELEGATE_IDENTITY", middlemanIdentity, originatorIdentity);
    }

    private SafeCloseable establishIdentityDirect(Identity originatorIdentity) {
        return PermissionUtil.establishIdentityDirect(originatorIdentity);
    }
}
