package com.android.server.ondeviceintelligence;

import android.app.ondeviceintelligence.IResponseCallback;
import android.app.ondeviceintelligence.IStreamingResponseCallback;
import android.app.ondeviceintelligence.ITokenInfoCallback;
import android.database.CursorWindow;
import android.graphics.Bitmap;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.android.internal.infra.AndroidFuture;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class BundleUtil {
    private static final String TAG = "BundleUtil";

    /* JADX INFO: renamed from: com.android.server.ondeviceintelligence.BundleUtil$1, reason: invalid class name */
    class AnonymousClass1 extends IStreamingResponseCallback.Stub {
        final /* synthetic */ AndroidFuture val$future;
        final /* synthetic */ InferenceInfoStore val$inferenceInfoStore;
        final /* synthetic */ Executor val$resourceClosingExecutor;
        final /* synthetic */ IStreamingResponseCallback val$streamingResponseCallback;

        public static /* synthetic */ void $r8$lambda$6B0WDwc5V9JAbtHLA5neXu0avp0(Bundle r0) {
            lambda$onNewContent$0(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$Bo3aWDhUkWiPrgV-VPhFJVp8vdo, reason: not valid java name */
        public static /* synthetic */ void m6384$r8$lambda$Bo3aWDhUkWiPrgVVPhFJVp8vdo(Bundle r0) {
            lambda$onSuccess$1(r0);
        }

        public static /* synthetic */ void $r8$lambda$MH_fyJYbguKPhYMoZkc7vcbrTBA(Bundle r0) {
            lambda$onDataAugmentRequest$4(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$QXA-bxaeSwDy8b37-DmPWysqUhc, reason: not valid java name */
        public static /* synthetic */ void m6385$r8$lambda$QXAbxaeSwDy8b37DmPWysqUhc(Bundle r0) {
            lambda$onDataAugmentRequest$2(r0);
        }

        public static /* synthetic */ void $r8$lambda$wOTgICwbHEI92xiGWmKn3OWVTPQ(RemoteCallback r0, Executor r1, Bundle r2) {
            lambda$onDataAugmentRequest$3(r0, r1, r2);
        }

        AnonymousClass1(IStreamingResponseCallback r1, Executor r2, InferenceInfoStore r3, AndroidFuture r4) {
            this.val$streamingResponseCallback = r1;
            this.val$resourceClosingExecutor = r2;
            this.val$inferenceInfoStore = r3;
            this.val$future = r4;
        }

        public void onNewContent(final Bundle processedResult) throws RemoteException {
            BundleUtil.sanitizeResponseParams(processedResult);     // Catch: Throwable -> L5
            this.val$streamingResponseCallback.onNewContent(processedResult);     // Catch: Throwable -> L5
            this.val$resourceClosingExecutor.execute(new BundleUtil$1$$ExternalSyntheticLambda0(processedResult));
            return;
        L5:
            th = move-exception;
            this.val$resourceClosingExecutor.execute(new BundleUtil$1$$ExternalSyntheticLambda0(processedResult));
            throw th;
        }

        private static /* synthetic */ void lambda$onNewContent$0(Bundle processedResult) {
            BundleUtil.tryCloseResource(processedResult);
        }

        public void onSuccess(final Bundle resultBundle) throws RemoteException {
            BundleUtil.sanitizeResponseParams(resultBundle);     // Catch: Throwable -> L6
            this.val$streamingResponseCallback.onSuccess(resultBundle);     // Catch: Throwable -> L6
            this.val$inferenceInfoStore.addInferenceInfoFromBundle(resultBundle);
            this.val$resourceClosingExecutor.execute(new BundleUtil$1$$ExternalSyntheticLambda2(resultBundle));
            this.val$future.complete(null);
            return;
        L6:
            th = move-exception;
            this.val$inferenceInfoStore.addInferenceInfoFromBundle(resultBundle);
            this.val$resourceClosingExecutor.execute(new BundleUtil$1$$ExternalSyntheticLambda2(resultBundle));
            this.val$future.complete(null);
            throw th;
        }

        private static /* synthetic */ void lambda$onSuccess$1(Bundle resultBundle) {
            BundleUtil.tryCloseResource(resultBundle);
        }

        public void onFailure(int errorCode, String errorMessage, PersistableBundle errorParams) throws RemoteException {
            this.val$streamingResponseCallback.onFailure(errorCode, errorMessage, errorParams);
            this.val$inferenceInfoStore.addInferenceInfoFromBundle(errorParams);
            this.val$future.completeExceptionally(new TimeoutException());
        }

        public void onDataAugmentRequest(final Bundle processedContent, final RemoteCallback remoteCallback) throws RemoteException {
            BundleUtil.sanitizeResponseParams(processedContent);     // Catch: Throwable -> L5
            IStreamingResponseCallback r0 = this.val$streamingResponseCallback;     // Catch: Throwable -> L5
            final Executor r2 = this.val$resourceClosingExecutor;     // Catch: Throwable -> L5
            r0.onDataAugmentRequest(processedContent, new RemoteCallback(new BundleUtil$1$$ExternalSyntheticLambda3(remoteCallback, r2)));     // Catch: Throwable -> L5
            this.val$resourceClosingExecutor.execute(new BundleUtil$1$$ExternalSyntheticLambda4(processedContent));
            return;
        L5:
            th = move-exception;
            this.val$resourceClosingExecutor.execute(new BundleUtil$1$$ExternalSyntheticLambda4(processedContent));
            throw th;
        }

        private static /* synthetic */ void lambda$onDataAugmentRequest$3(RemoteCallback remoteCallback, Executor resourceClosingExecutor, final Bundle augmentedData) {
            BundleUtil.sanitizeInferenceParams(augmentedData);     // Catch: Throwable -> L5
            remoteCallback.sendResult(augmentedData);     // Catch: Throwable -> L5
            resourceClosingExecutor.execute(new BundleUtil$1$$ExternalSyntheticLambda1(augmentedData));
            return;
        L5:
            th = move-exception;
            resourceClosingExecutor.execute(new BundleUtil$1$$ExternalSyntheticLambda1(augmentedData));
            throw th;
        }

        private static /* synthetic */ void lambda$onDataAugmentRequest$2(Bundle augmentedData) {
            BundleUtil.tryCloseResource(augmentedData);
        }

        private static /* synthetic */ void lambda$onDataAugmentRequest$4(Bundle processedContent) {
            BundleUtil.tryCloseResource(processedContent);
        }
    }

    /* JADX INFO: renamed from: com.android.server.ondeviceintelligence.BundleUtil$2, reason: invalid class name */
    class AnonymousClass2 extends IResponseCallback.Stub {
        final /* synthetic */ AndroidFuture val$future;
        final /* synthetic */ InferenceInfoStore val$inferenceInfoStore;
        final /* synthetic */ Executor val$resourceClosingExecutor;
        final /* synthetic */ IResponseCallback val$responseCallback;

        /* JADX INFO: renamed from: $r8$lambda$PV-2D1G17EGkK0qStjK0pRbJZ2g, reason: not valid java name */
        public static /* synthetic */ void m6386$r8$lambda$PV2D1G17EGkK0qStjK0pRbJZ2g(RemoteCallback r0, Executor r1, Bundle r2) {
            lambda$onDataAugmentRequest$2(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$RfTaB0ZJoPbn8O0LTIcx3BV7erY(Bundle r0) {
            lambda$onDataAugmentRequest$3(r0);
        }

        public static /* synthetic */ void $r8$lambda$U1ptxK_cE_ZZaF2CYFzzC4OxM3U(Bundle r0) {
            lambda$onDataAugmentRequest$1(r0);
        }

        public static /* synthetic */ void $r8$lambda$iy3swrfQYidJ5DvVNadfsJ3wtAA(Bundle r0) {
            lambda$onSuccess$0(r0);
        }

        AnonymousClass2(IResponseCallback r1, InferenceInfoStore r2, Executor r3, AndroidFuture r4) {
            this.val$responseCallback = r1;
            this.val$inferenceInfoStore = r2;
            this.val$resourceClosingExecutor = r3;
            this.val$future = r4;
        }

        public void onSuccess(final Bundle resultBundle) throws RemoteException {
            BundleUtil.sanitizeResponseParams(resultBundle);     // Catch: Throwable -> L6
            this.val$responseCallback.onSuccess(resultBundle);     // Catch: Throwable -> L6
            this.val$inferenceInfoStore.addInferenceInfoFromBundle(resultBundle);
            this.val$resourceClosingExecutor.execute(new BundleUtil$2$$ExternalSyntheticLambda3(resultBundle));
            this.val$future.complete(null);
            return;
        L6:
            th = move-exception;
            this.val$inferenceInfoStore.addInferenceInfoFromBundle(resultBundle);
            this.val$resourceClosingExecutor.execute(new BundleUtil$2$$ExternalSyntheticLambda3(resultBundle));
            this.val$future.complete(null);
            throw th;
        }

        private static /* synthetic */ void lambda$onSuccess$0(Bundle resultBundle) {
            BundleUtil.tryCloseResource(resultBundle);
        }

        public void onFailure(int errorCode, String errorMessage, PersistableBundle errorParams) throws RemoteException {
            this.val$responseCallback.onFailure(errorCode, errorMessage, errorParams);
            this.val$inferenceInfoStore.addInferenceInfoFromBundle(errorParams);
            this.val$future.completeExceptionally(new TimeoutException());
        }

        public void onDataAugmentRequest(final Bundle processedContent, final RemoteCallback remoteCallback) throws RemoteException {
            BundleUtil.sanitizeResponseParams(processedContent);     // Catch: Throwable -> L5
            IResponseCallback r0 = this.val$responseCallback;     // Catch: Throwable -> L5
            final Executor r2 = this.val$resourceClosingExecutor;     // Catch: Throwable -> L5
            r0.onDataAugmentRequest(processedContent, new RemoteCallback(new BundleUtil$2$$ExternalSyntheticLambda1(remoteCallback, r2)));     // Catch: Throwable -> L5
            this.val$resourceClosingExecutor.execute(new BundleUtil$2$$ExternalSyntheticLambda2(processedContent));
            return;
        L5:
            th = move-exception;
            this.val$resourceClosingExecutor.execute(new BundleUtil$2$$ExternalSyntheticLambda2(processedContent));
            throw th;
        }

        private static /* synthetic */ void lambda$onDataAugmentRequest$2(RemoteCallback remoteCallback, Executor resourceClosingExecutor, final Bundle augmentedData) {
            BundleUtil.sanitizeInferenceParams(augmentedData);     // Catch: Throwable -> L5
            remoteCallback.sendResult(augmentedData);     // Catch: Throwable -> L5
            resourceClosingExecutor.execute(new BundleUtil$2$$ExternalSyntheticLambda0(augmentedData));
            return;
        L5:
            th = move-exception;
            resourceClosingExecutor.execute(new BundleUtil$2$$ExternalSyntheticLambda0(augmentedData));
            throw th;
        }

        private static /* synthetic */ void lambda$onDataAugmentRequest$1(Bundle augmentedData) {
            BundleUtil.tryCloseResource(augmentedData);
        }

        private static /* synthetic */ void lambda$onDataAugmentRequest$3(Bundle processedContent) {
            BundleUtil.tryCloseResource(processedContent);
        }
    }

    public BundleUtil() {
    }

    public static void sanitizeInferenceParams(Bundle bundle) {
        ensureValidBundle(bundle);
        if (bundle.hasFileDescriptors() == true) goto L5;
        return;
    L5:
        Iterator<String> r0 = bundle.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L34;
        String key = r0.next();
        Object obj = bundle.get(key);
        if (obj == null) goto L10;
        if (canMarshall(obj) == true) goto L7;
        if ((obj instanceof CursorWindow) == true) goto L7;
        if ((obj instanceof Bundle) == true) goto L18;
        if ((obj instanceof ParcelFileDescriptor) == true) goto L21;
        if ((obj instanceof SharedMemory) == true) goto L24;
        if ((obj instanceof Bitmap) == true) goto L27;
        if ((obj instanceof Parcelable[]) == false) goto L33;
        validateParcelableArray((Parcelable[]) obj);
        goto L7
    L33:
        throw new BadParcelableException("Unsupported Parcelable type encountered in the Bundle: " + obj.getClass().getSimpleName());
    L27:
        validateBitmap((Bitmap) obj);
        goto L7
    L24:
        ((SharedMemory) obj).setProtect(OsConstants.PROT_READ);
        goto L7
    L21:
        validatePfdReadOnly((ParcelFileDescriptor) obj);
        goto L7
    L18:
        sanitizeInferenceParams((Bundle) obj);
        goto L7
    L10:
        bundle.putObject(key, null);
        goto L7
    }

    public static void sanitizeResponseParams(Bundle bundle) {
        ensureValidBundle(bundle);
        if (bundle.hasFileDescriptors() == true) goto L5;
        return;
    L5:
        Iterator<String> r0 = bundle.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L29;
        String key = r0.next();
        Object obj = bundle.get(key);
        if (obj == null) goto L10;
        if (canMarshall(obj) == true) goto L7;
        if ((obj instanceof Bundle) == true) goto L16;
        if ((obj instanceof ParcelFileDescriptor) == true) goto L19;
        if ((obj instanceof Bitmap) == true) goto L22;
        if ((obj instanceof Parcelable[]) == false) goto L28;
        validateParcelableArray((Parcelable[]) obj);
        goto L7
    L28:
        throw new BadParcelableException("Unsupported Parcelable type encountered in the Bundle: " + obj.getClass().getSimpleName());
    L22:
        validateBitmap((Bitmap) obj);
        goto L7
    L19:
        validatePfdReadOnly((ParcelFileDescriptor) obj);
        goto L7
    L16:
        sanitizeResponseParams((Bundle) obj);
        goto L7
    L10:
        bundle.putObject(key, null);
        goto L7
    }

    public static void sanitizeStateParams(Bundle bundle) {
        ensureValidBundle(bundle);
        if (bundle.hasFileDescriptors() == true) goto L5;
        return;
    L5:
        Iterator<String> r0 = bundle.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L19;
        String key = r0.next();
        Object obj = bundle.get(key);
        if (obj == null) goto L10;
        if (canMarshall(obj) == true) goto L7;
        if ((obj instanceof ParcelFileDescriptor) == false) goto L18;
        validatePfdReadOnly((ParcelFileDescriptor) obj);
        goto L7
    L18:
        throw new BadParcelableException("Unsupported Parcelable type encountered in the Bundle: " + obj.getClass().getSimpleName());
    L10:
        bundle.putObject(key, null);
        goto L7
    }

    public static IStreamingResponseCallback wrapWithValidation(IStreamingResponseCallback streamingResponseCallback, Executor resourceClosingExecutor, AndroidFuture future, InferenceInfoStore inferenceInfoStore) {
        return new AnonymousClass1(streamingResponseCallback, resourceClosingExecutor, inferenceInfoStore, future);
    }

    public static IResponseCallback wrapWithValidation(IResponseCallback responseCallback, Executor resourceClosingExecutor, AndroidFuture future, InferenceInfoStore inferenceInfoStore) {
        return new AnonymousClass2(responseCallback, inferenceInfoStore, resourceClosingExecutor, future);
    }

    public static ITokenInfoCallback wrapWithValidation(final ITokenInfoCallback responseCallback, final AndroidFuture future, final InferenceInfoStore inferenceInfoStore) {
        return new AnonymousClass3(responseCallback, inferenceInfoStore, future);
    }

    private static boolean canMarshall(Object obj) {
        if ((obj instanceof byte[]) == false) goto L5;
    L10:
        return true;
    L5:
        if ((obj instanceof PersistableBundle) == true) goto L10;
        if (PersistableBundle.isValidType(obj) == true) goto L10;
        return false;
    }

    private static void ensureValidBundle(Bundle bundle) {
        if (bundle == null) goto L9;
        if (bundle.hasBinders() != 0) goto L7;
        return;
    L7:
        throw new BadParcelableException("Bundle should not contain IBinder objects.");
    L9:
        throw new IllegalArgumentException("Request passed is expected to be non-null");
    }

    private static void validateParcelableArray(Parcelable[] parcelables) {
        if (parcelables.length <= 0) goto L8;
        if ((parcelables[0] instanceof ParcelFileDescriptor) == false) goto L8;
        validatePfdsReadOnly(parcelables);
        return;
    L8:
        if (parcelables.length <= 0) goto L14;
        if ((parcelables[0] instanceof Bitmap) == false) goto L14;
        validateBitmapsImmutable(parcelables);
        return;
    L14:
        throw new BadParcelableException("Could not cast to any known parcelable array");
    }

    public static void validatePfdsReadOnly(Parcelable[] pfds) {
        int r0 = pfds.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Parcelable pfd = pfds[r1];
        validatePfdReadOnly((ParcelFileDescriptor) pfd);
        r1 = r1 + 1;
        goto L3
    }

    public static void validatePfdReadOnly(ParcelFileDescriptor pfd) {
        if (pfd != null) goto L12;
        return;
    L12:
        int readMode = Os.fcntlInt(pfd.getFileDescriptor(), OsConstants.F_GETFL, 0) & OsConstants.O_ACCMODE;     // Catch: ErrnoException -> L9
        if (readMode != OsConstants.O_RDONLY) goto L8;
        return;
    L8:
        throw new BadParcelableException("Bundle contains a parcel file descriptor which is not read-only.");     // Catch: ErrnoException -> L9
    L9:
        e = move-exception;
        throw new BadParcelableException("Invalid File descriptor passed in the Bundle.", e);
    }

    private static void validateBitmap(Bitmap obj) {
        if (obj.isMutable() == true) goto L6;
        return;
    L6:
        throw new BadParcelableException("Encountered a mutable Bitmap in the Bundle at key : " + obj);
    }

    private static void validateBitmapsImmutable(Parcelable[] bitmaps) {
        int r0 = bitmaps.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Parcelable bitmap = bitmaps[r1];
        validateBitmap((Bitmap) bitmap);
        r1 = r1 + 1;
        goto L3
    }

    public static void tryCloseResource(Bundle bundle) {
        if (bundle != null) goto L4;
        return;
    L4:
        if (bundle.isEmpty() == false) goto L6;
        return;
    L6:
        if (bundle.hasFileDescriptors() == false) goto L44;
        Iterator<String> r0 = bundle.keySet().iterator();
    L10:
        if (r0.hasNext() == false) goto L26;
        String key = r0.next();
        Object obj = bundle.get(key);
        if ((obj instanceof ParcelFileDescriptor) == true) goto L14;
        if ((obj instanceof CursorWindow) == true) goto L19;
        if ((obj instanceof SharedMemory) == false) goto L10;
        ((SharedMemory) obj).close();     // Catch: Exception -> L15
        goto L10
    L19:
        ((CursorWindow) obj).close();     // Catch: Exception -> L15
        goto L10
    L14:
        ((ParcelFileDescriptor) obj).close();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.e(TAG, "Error closing resource with key: " + key, e);
        goto L10
    L26:
        return;
    }
}
