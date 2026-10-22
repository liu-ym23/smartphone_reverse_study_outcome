package com.android.server.security.rkp;

import android.content.Context;
import android.os.Binder;
import android.os.OutcomeReceiver;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.security.rkp.IGetRegistrationCallback;
import android.security.rkp.IRemoteProvisioning;
import android.security.rkp.service.RegistrationProxy;
import android.util.Log;
import com.android.internal.util.DumpUtils;
import com.android.server.SystemService;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class RemoteProvisioningService extends SystemService {
    private static final Duration CREATE_REGISTRATION_TIMEOUT = null;
    public static final String TAG = "RemoteProvisionSysSvc";
    private final RemoteProvisioningImpl mBinderImpl;

    private static class RegistrationReceiver implements OutcomeReceiver<RegistrationProxy, Exception> {
        private final IGetRegistrationCallback mCallback;
        private final Executor mExecutor;

        @Override // android.os.OutcomeReceiver
        public /* bridge */ /* synthetic */ void onError(Throwable r1) {
            onError((Exception) r1);
        }

        @Override // android.os.OutcomeReceiver
        public /* bridge */ /* synthetic */ void onResult(RegistrationProxy r1) {
            onResult2(r1);
        }

        RegistrationReceiver(Executor executor, IGetRegistrationCallback callback) {
            this.mExecutor = executor;
            this.mCallback = callback;
        }

        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(RegistrationProxy registration) {
            this.mCallback.onSuccess(new RemoteProvisioningRegistration(registration, this.mExecutor));     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(RemoteProvisioningService.TAG, "Error calling success callback " + this.mCallback.asBinder().hashCode(), e);
        }

        public void onError(Exception error) {
            this.mCallback.onError(error.toString());     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(RemoteProvisioningService.TAG, "Error calling error callback " + this.mCallback.asBinder().hashCode(), e);
        }
    }

    private final class RemoteProvisioningImpl extends IRemoteProvisioning.Stub {
        final /* synthetic */ RemoteProvisioningService this$0;

        /* synthetic */ RemoteProvisioningImpl(RemoteProvisioningService r1, RemoteProvisioningServiceIA r2) {
            this(r1);
        }

        private RemoteProvisioningImpl(RemoteProvisioningService r1) {
            this.this$0 = r1;
        }

        public void getRegistration(String irpcName, IGetRegistrationCallback callback) throws RemoteException {
            int callerUid = Binder.getCallingUidOrThrow();
            long callingIdentity = Binder.clearCallingIdentity();
            Executor executor = this.this$0.getContext().getMainExecutor();
            Log.i(RemoteProvisioningService.TAG, "getRegistration(" + irpcName + ")");     // Catch: Throwable -> L10
            RegistrationProxy.createAsync(this.this$0.getContext(), callerUid, irpcName, RemoteProvisioningService.m8065$$Nest$sfgetCREATE_REGISTRATION_TIMEOUT(), executor, new RegistrationReceiver(executor, callback));     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(callingIdentity);
            return;
        L8:
            th = move-exception;
            Throwable r9 = th;
        L12:
            Binder.restoreCallingIdentity(callingIdentity);
            throw r9;
        L10:
            th = move-exception;
            r9 = th;
            goto L12
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), RemoteProvisioningService.TAG, pw) == true) goto L5;
            return;
        L5:
            int callerUid = Binder.getCallingUidOrThrow();
            long callingIdentity = Binder.clearCallingIdentity();
            new RemoteProvisioningShellCommand(this.this$0.getContext(), callerUid).dump(pw);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(callingIdentity);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(callingIdentity);
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int handleShellCommand(ParcelFileDescriptor in, ParcelFileDescriptor out, ParcelFileDescriptor err, String[] args) {
            int callerUid = Binder.getCallingUidOrThrow();
            long callingIdentity = Binder.clearCallingIdentity();
            int r14 = new RemoteProvisioningShellCommand(this.this$0.getContext(), callerUid).exec(this, in.getFileDescriptor(), out.getFileDescriptor(), err.getFileDescriptor(), args);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(callingIdentity);
            return r14;
        L8:
            th = move-exception;
            Throwable r15 = th;
        L12:
            Binder.restoreCallingIdentity(callingIdentity);
            throw r15;
        L10:
            th = move-exception;
            r15 = th;
            goto L12
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetCREATE_REGISTRATION_TIMEOUT, reason: not valid java name */
    static /* bridge */ /* synthetic */ Duration m8065$$Nest$sfgetCREATE_REGISTRATION_TIMEOUT() {
        return CREATE_REGISTRATION_TIMEOUT;
    }

    static {
        CREATE_REGISTRATION_TIMEOUT = Duration.ofSeconds(10);
    }

    public RemoteProvisioningService(Context context) {
        super(context);
        this.mBinderImpl = new RemoteProvisioningImpl(this, null);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("remote_provisioning", this.mBinderImpl);
    }
}
