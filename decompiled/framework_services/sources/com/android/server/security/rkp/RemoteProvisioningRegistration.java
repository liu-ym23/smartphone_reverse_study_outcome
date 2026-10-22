package com.android.server.security.rkp;

import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.OperationCanceledException;
import android.os.OutcomeReceiver;
import android.security.rkp.IGetKeyCallback;
import android.security.rkp.IRegistration;
import android.security.rkp.IStoreUpgradedKeyCallback;
import android.security.rkp.service.RegistrationProxy;
import android.security.rkp.service.RemotelyProvisionedKey;
import android.security.rkp.service.RkpProxyException;
import android.util.Log;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class RemoteProvisioningRegistration extends IRegistration.Stub {
    static final String TAG = "RemoteProvisionSysSvc";
    private final Executor mExecutor;
    private final ConcurrentHashMap<IBinder, CancellationSignal> mGetKeyOperations;
    private final RegistrationProxy mRegistration;
    private final Set<IBinder> mStoreUpgradedKeyOperations;

    /* JADX INFO: renamed from: com.android.server.security.rkp.RemoteProvisioningRegistration$1, reason: invalid class name */
    class AnonymousClass1 implements OutcomeReceiver<Void, Exception> {
        final /* synthetic */ RemoteProvisioningRegistration this$0;
        final /* synthetic */ IStoreUpgradedKeyCallback val$callback;

        public static /* synthetic */ void $r8$lambda$4yaVkdqF2eFFug9OQ2SVWZqTBaM(IStoreUpgradedKeyCallback r0, Exception r1) {
            lambda$onError$0(r0, r1);
        }

        AnonymousClass1(RemoteProvisioningRegistration this$0, IStoreUpgradedKeyCallback r2) {
            this.this$0 = this$0;
            this.val$callback = r2;
        }

        @Override // android.os.OutcomeReceiver
        public /* bridge */ /* synthetic */ void onError(Throwable r1) {
            onError((Exception) r1);
        }

        @Override // android.os.OutcomeReceiver
        public /* bridge */ /* synthetic */ void onResult(Void r1) {
            onResult2(r1);
        }

        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(Void result) {
            RemoteProvisioningRegistration.m8061$$Nest$fgetmStoreUpgradedKeyOperations(this.this$0).remove(this.val$callback.asBinder());
            RemoteProvisioningRegistration r0 = this.this$0;
            final IStoreUpgradedKeyCallback r1 = this.val$callback;
            r1.getClass();
            RemoteProvisioningRegistration.m8063$$Nest$mwrapCallback(r0, new RemoteProvisioningRegistration$1$$ExternalSyntheticLambda1(r1));
        }

        public void onError(final Exception e) {
            RemoteProvisioningRegistration.m8061$$Nest$fgetmStoreUpgradedKeyOperations(this.this$0).remove(this.val$callback.asBinder());
            RemoteProvisioningRegistration r0 = this.this$0;
            final IStoreUpgradedKeyCallback r1 = this.val$callback;
            RemoteProvisioningRegistration.m8063$$Nest$mwrapCallback(r0, new RemoteProvisioningRegistration$1$$ExternalSyntheticLambda0(r1, e));
        }

        private static /* synthetic */ void lambda$onError$0(IStoreUpgradedKeyCallback callback, Exception e) throws Exception {
            callback.onError(e.getMessage());
        }
    }

    interface CallbackRunner {
        void run() throws Exception;
    }

    private class GetKeyReceiver implements OutcomeReceiver<RemotelyProvisionedKey, Exception> {
        IGetKeyCallback mCallback;
        final /* synthetic */ RemoteProvisioningRegistration this$0;

        /* JADX INFO: renamed from: $r8$lambda$M_-R0OjtT4km1nNaXi4OelOBbmQ, reason: not valid java name */
        public static /* synthetic */ void m8064$r8$lambda$M_R0OjtT4km1nNaXi4OelOBbmQ(GetKeyReceiver r0, android.security.rkp.RemotelyProvisionedKey r1) {
            r0.lambda$onResult$0(r1);
        }

        public static /* synthetic */ void $r8$lambda$f_lWKerO6AZ5R43ehcKyrIrPTp4(GetKeyReceiver r0, Exception r1) {
            r0.lambda$onError$2(r1);
        }

        public static /* synthetic */ void $r8$lambda$gu_5PA_M9DrzXXn38KhvBsdUfOE(GetKeyReceiver r0, RkpProxyException r1, Exception r2) {
            r0.lambda$onError$1(r1, r2);
        }

        @Override // android.os.OutcomeReceiver
        public /* bridge */ /* synthetic */ void onError(Throwable r1) {
            onError((Exception) r1);
        }

        @Override // android.os.OutcomeReceiver
        public /* bridge */ /* synthetic */ void onResult(RemotelyProvisionedKey r1) {
            onResult2(r1);
        }

        GetKeyReceiver(RemoteProvisioningRegistration r1, IGetKeyCallback callback) {
            this.this$0 = r1;
            this.mCallback = callback;
        }

        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(RemotelyProvisionedKey result) {
            RemoteProvisioningRegistration.m8060$$Nest$fgetmGetKeyOperations(this.this$0).remove(this.mCallback.asBinder());
            Log.i("RemoteProvisionSysSvc", "Successfully fetched key for client " + this.mCallback.asBinder().hashCode());
            final android.security.rkp.RemotelyProvisionedKey parcelable = new android.security.rkp.RemotelyProvisionedKey();
            parcelable.keyBlob = result.getKeyBlob();
            parcelable.encodedCertChain = result.getEncodedCertChain();
            RemoteProvisioningRegistration.m8063$$Nest$mwrapCallback(this.this$0, new RemoteProvisioningRegistration$GetKeyReceiver$$ExternalSyntheticLambda0(this, parcelable));
        }

        private /* synthetic */ void lambda$onResult$0(android.security.rkp.RemotelyProvisionedKey parcelable) throws Exception {
            this.mCallback.onSuccess(parcelable);
        }

        public void onError(final Exception e) {
            RemoteProvisioningRegistration.m8060$$Nest$fgetmGetKeyOperations(this.this$0).remove(this.mCallback.asBinder());
            if ((e instanceof OperationCanceledException) == false) goto L6;
            Log.i("RemoteProvisionSysSvc", "Operation cancelled for client " + this.mCallback.asBinder().hashCode());
            RemoteProvisioningRegistration r0 = this.this$0;
            final IGetKeyCallback r1 = this.mCallback;
            r1.getClass();
            RemoteProvisioningRegistration.m8063$$Nest$mwrapCallback(r0, new RemoteProvisioningRegistration$GetKeyReceiver$$ExternalSyntheticLambda1(r1));
            return;
        L6:
            if ((e instanceof RkpProxyException) == false) goto L8;
            Log.e("RemoteProvisionSysSvc", "RKP error fetching key for client " + this.mCallback.asBinder().hashCode() + ": " + e.getMessage());
            final RkpProxyException rkpException = (RkpProxyException) e;
            RemoteProvisioningRegistration.m8063$$Nest$mwrapCallback(this.this$0, new RemoteProvisioningRegistration$GetKeyReceiver$$ExternalSyntheticLambda2(this, rkpException, e));
            return;
        L8:
            Log.e("RemoteProvisionSysSvc", "Unknown error fetching key for client " + this.mCallback.asBinder().hashCode() + ": " + e.getMessage());
            RemoteProvisioningRegistration.m8063$$Nest$mwrapCallback(this.this$0, new RemoteProvisioningRegistration$GetKeyReceiver$$ExternalSyntheticLambda3(this, e));
        }

        private /* synthetic */ void lambda$onError$1(RkpProxyException rkpException, Exception e) throws Exception {
            this.mCallback.onError(RemoteProvisioningRegistration.m8062$$Nest$mtoGetKeyError(this.this$0, rkpException), e.getMessage());
        }

        private /* synthetic */ void lambda$onError$2(Exception e) throws Exception {
            this.mCallback.onError((byte) 1, e.getMessage());
        }
    }

    public static /* synthetic */ void $r8$lambda$OKnIln1b9VPA_xgjHC3oxdTjwNk(IGetKeyCallback r0, Exception r1) {
        lambda$getKey$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$zpi8B1rShh1YcynByB1qtlfC6NM(IStoreUpgradedKeyCallback r0, Exception r1) {
        lambda$storeUpgradedKeyAsync$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGetKeyOperations, reason: not valid java name */
    static /* bridge */ /* synthetic */ ConcurrentHashMap m8060$$Nest$fgetmGetKeyOperations(RemoteProvisioningRegistration r0) {
        return r0.mGetKeyOperations;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStoreUpgradedKeyOperations, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m8061$$Nest$fgetmStoreUpgradedKeyOperations(RemoteProvisioningRegistration r0) {
        return r0.mStoreUpgradedKeyOperations;
    }

    /* JADX INFO: renamed from: -$$Nest$mtoGetKeyError, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte m8062$$Nest$mtoGetKeyError(RemoteProvisioningRegistration r0, RkpProxyException r1) {
        return r0.toGetKeyError(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mwrapCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8063$$Nest$mwrapCallback(RemoteProvisioningRegistration r0, CallbackRunner r1) {
        r0.wrapCallback(r1);
    }

    private byte toGetKeyError(RkpProxyException exception) {
        switch(exception.getError()) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        Log.e("RemoteProvisionSysSvc", "Unexpected error code in RkpProxyException", exception);
        return 1;
    L6:
        return 5;
    L8:
        return 3;
    L10:
        return 2;
    L12:
        return 1;
    }

    RemoteProvisioningRegistration(RegistrationProxy registration, Executor executor) {
        this.mGetKeyOperations = new ConcurrentHashMap();
        this.mStoreUpgradedKeyOperations = ConcurrentHashMap.newKeySet();
        this.mRegistration = registration;
        this.mExecutor = executor;
    }

    public void getKey(int keyId, final IGetKeyCallback callback) {
        CancellationSignal cancellationSignal = new CancellationSignal();
        if (this.mGetKeyOperations.putIfAbsent(callback.asBinder(), cancellationSignal) == null) goto L11;
        Log.e("RemoteProvisionSysSvc", "Client can only request one call at a time " + callback.asBinder().hashCode());
        throw new IllegalArgumentException("Callback is already associated with an existing operation: " + callback.asBinder().hashCode());
    L11:
        Log.i("RemoteProvisionSysSvc", "Fetching key " + keyId + " for client " + callback.asBinder().hashCode());     // Catch: Exception -> L6
        this.mRegistration.getKeyAsync(keyId, cancellationSignal, this.mExecutor, new GetKeyReceiver(this, callback));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.e("RemoteProvisionSysSvc", "getKeyAsync threw an exception for client " + callback.asBinder().hashCode(), e);
        this.mGetKeyOperations.remove(callback.asBinder());
        wrapCallback(new RemoteProvisioningRegistration$$ExternalSyntheticLambda0(callback, e));
    }

    private static /* synthetic */ void lambda$getKey$0(IGetKeyCallback callback, Exception e) throws Exception {
        callback.onError((byte) 1, e.getMessage());
    }

    public void cancelGetKey(IGetKeyCallback callback) {
        CancellationSignal cancellationSignal = this.mGetKeyOperations.remove(callback.asBinder());
        if (cancellationSignal == null) goto L7;
        Log.i("RemoteProvisionSysSvc", "Requesting cancellation for client " + callback.asBinder().hashCode());
        cancellationSignal.cancel();
        return;
    L7:
        throw new IllegalArgumentException("Invalid client in cancelGetKey: " + callback.asBinder().hashCode());
    }

    public void storeUpgradedKeyAsync(byte[] oldKeyBlob, byte[] newKeyBlob, final IStoreUpgradedKeyCallback callback) {
        if (this.mStoreUpgradedKeyOperations.add(callback.asBinder()) == false) goto L10;
        this.mRegistration.storeUpgradedKeyAsync(oldKeyBlob, newKeyBlob, this.mExecutor, new AnonymousClass1(this, callback));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.e("RemoteProvisionSysSvc", "storeUpgradedKeyAsync threw an exception for client " + callback.asBinder().hashCode(), e);
        this.mStoreUpgradedKeyOperations.remove(callback.asBinder());
        wrapCallback(new RemoteProvisioningRegistration$$ExternalSyntheticLambda1(callback, e));
        return;
    L10:
        throw new IllegalArgumentException("Callback is already associated with an existing operation: " + callback.asBinder().hashCode());
    }

    private static /* synthetic */ void lambda$storeUpgradedKeyAsync$1(IStoreUpgradedKeyCallback callback, Exception e) throws Exception {
        callback.onError(e.getMessage());
    }

    private void wrapCallback(CallbackRunner callback) {
        callback.run();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("RemoteProvisionSysSvc", "Error invoking callback on client binder", e);
    }
}
