package com.android.server.locksettings;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Bundle;
import android.os.ParcelableException;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.service.resumeonreboot.IResumeOnRebootService;
import android.util.Slog;
import com.android.internal.os.BackgroundThread;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class ResumeOnRebootServiceProvider {
    static final String PROP_ROR_PROVIDER_PACKAGE = "persist.sys.resume_on_reboot_provider_package";
    private static final String PROVIDER_PACKAGE = null;
    private static final String PROVIDER_REQUIRED_PERMISSION = "android.permission.BIND_RESUME_ON_REBOOT_SERVICE";
    private static final String TAG = "ResumeOnRebootServiceProvider";
    private final Context mContext;
    private final PackageManager mPackageManager;

    private static class ResumeOnRebootServiceCallback implements RemoteCallback.OnResultListener {
        private Bundle mResult;
        private final CountDownLatch mResultLatch;

        /* JADX INFO: renamed from: -$$Nest$fgetmResult, reason: not valid java name */
        static /* bridge */ /* synthetic */ Bundle m5471$$Nest$fgetmResult(ResumeOnRebootServiceCallback r0) {
            return r0.mResult;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetResult, reason: not valid java name */
        static /* bridge */ /* synthetic */ Bundle m5472$$Nest$mgetResult(ResumeOnRebootServiceCallback r0) {
            return r0.getResult();
        }

        /* synthetic */ ResumeOnRebootServiceCallback(CountDownLatch r1, ResumeOnRebootServiceProviderIA r2) {
            this(r1);
        }

        private ResumeOnRebootServiceCallback(CountDownLatch resultLatch) {
            this.mResultLatch = resultLatch;
        }

        public void onResult(Bundle result) {
            this.mResult = result;
            this.mResultLatch.countDown();
        }

        private Bundle getResult() {
            return this.mResult;
        }
    }

    public static class ResumeOnRebootServiceConnection {
        private static final String TAG = "ResumeOnRebootServiceConnection";
        private IResumeOnRebootService mBinder;
        private final ComponentName mComponentName;
        private final Context mContext;
        ServiceConnection mServiceConnection;

        /* JADX INFO: renamed from: -$$Nest$fputmBinder, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5473$$Nest$fputmBinder(ResumeOnRebootServiceConnection r0, IResumeOnRebootService r1) {
            r0.mBinder = r1;
        }

        /* synthetic */ ResumeOnRebootServiceConnection(Context r1, ComponentName r2, ResumeOnRebootServiceProviderIA r3) {
            this(r1, r2);
        }

        private ResumeOnRebootServiceConnection(Context context, ComponentName componentName) {
            this.mContext = context;
            this.mComponentName = componentName;
        }

        public void unbindService() {
            if (this.mServiceConnection == null) goto L5;
            this.mContext.unbindService(this.mServiceConnection);
        L5:
            this.mBinder = null;
        }

        public void bindToService(long timeOut) throws RemoteException, TimeoutException {
            if (this.mBinder != null) goto L5;
        L6:
            final CountDownLatch connectionLatch = new CountDownLatch(1);
            Intent intent = new Intent();
            intent.setComponent(this.mComponentName);
            this.mServiceConnection = new AnonymousClass1(this, connectionLatch);
            boolean success = this.mContext.bindServiceAsUser(intent, this.mServiceConnection, AudioFormat.AAC_MAIN, BackgroundThread.getHandler(), UserHandle.SYSTEM);
            if (success == true) goto L10;
            Slog.e(TAG, "Binding: " + this.mComponentName + " u" + UserHandle.SYSTEM + " failed.");
            return;
        L10:
            waitForLatch(connectionLatch, "serviceConnection", timeOut);
            return;
        L5:
            if (this.mBinder.asBinder().isBinderAlive() == false) goto L6;
        }

        public byte[] wrapBlob(byte[] unwrappedBlob, long lifeTimeInMillis, long timeOutInMillis) throws RemoteException, TimeoutException, IOException {
            if (this.mBinder == null) goto L12;
            if (this.mBinder.asBinder().isBinderAlive() == false) goto L12;
            CountDownLatch binderLatch = new CountDownLatch(1);
            ResumeOnRebootServiceCallback resultCallback = new ResumeOnRebootServiceCallback(binderLatch, null);
            this.mBinder.wrapSecret(unwrappedBlob, lifeTimeInMillis, new RemoteCallback(resultCallback));
            waitForLatch(binderLatch, "wrapSecret", timeOutInMillis);
            if (ResumeOnRebootServiceCallback.m5472$$Nest$mgetResult(resultCallback).containsKey("exception_key") == false) goto L10;
            throwTypedException((ParcelableException) ResumeOnRebootServiceCallback.m5472$$Nest$mgetResult(resultCallback).getParcelable("exception_key", ParcelableException.class));
        L10:
            return ResumeOnRebootServiceCallback.m5471$$Nest$fgetmResult(resultCallback).getByteArray("wrapped_blob_key");
        L12:
            throw new RemoteException("Service not bound");
        }

        public byte[] unwrap(byte[] wrappedBlob, long timeOut) throws RemoteException, TimeoutException, IOException {
            if (this.mBinder == null) goto L12;
            if (this.mBinder.asBinder().isBinderAlive() == false) goto L12;
            CountDownLatch binderLatch = new CountDownLatch(1);
            ResumeOnRebootServiceCallback resultCallback = new ResumeOnRebootServiceCallback(binderLatch, null);
            this.mBinder.unwrap(wrappedBlob, new RemoteCallback(resultCallback));
            waitForLatch(binderLatch, "unWrapSecret", timeOut);
            if (ResumeOnRebootServiceCallback.m5472$$Nest$mgetResult(resultCallback).containsKey("exception_key") == false) goto L10;
            throwTypedException((ParcelableException) ResumeOnRebootServiceCallback.m5472$$Nest$mgetResult(resultCallback).getParcelable("exception_key", ParcelableException.class));
        L10:
            return ResumeOnRebootServiceCallback.m5472$$Nest$mgetResult(resultCallback).getByteArray("unrwapped_blob_key");
        L12:
            throw new RemoteException("Service not bound");
        }

        private void throwTypedException(ParcelableException exception) throws IOException, RemoteException {
            if (exception == null) goto L8;
            if ((exception.getCause() instanceof IOException) == false) goto L8;
            exception.maybeRethrow(IOException.class);
            return;
        L8:
            throw new RemoteException("ResumeOnRebootServiceConnection wrap/unwrap failed", exception, true, true);
        }

        private void waitForLatch(CountDownLatch latch, String reason, long timeOut) throws RemoteException, TimeoutException {
            if (latch.await(timeOut, TimeUnit.SECONDS) == false) goto L7;
            return;
        L7:
            throw new TimeoutException("Latch wait for " + reason + " elapsed");     // Catch: InterruptedException -> L8
        L9:
            Thread.currentThread().interrupt();
            throw new RemoteException("Latch wait for " + reason + " interrupted");
        }
    }

    static {
        PROVIDER_PACKAGE = DeviceConfig.getString("ota", "resume_on_reboot_service_package", "");
    }

    public ResumeOnRebootServiceProvider(Context context) {
        this(context, context.getPackageManager());
    }

    public ResumeOnRebootServiceProvider(Context context, PackageManager packageManager) {
        this.mContext = context;
        this.mPackageManager = packageManager;
    }

    private ServiceInfo resolveService() {
        Intent intent = new Intent();
        intent.setAction("android.service.resumeonreboot.ResumeOnRebootService");
        int queryFlag = 4;
        String testAppName = SystemProperties.get(PROP_ROR_PROVIDER_PACKAGE, "");
        if (testAppName.isEmpty() == true) goto L5;
        Slog.i(TAG, "Using test app: " + testAppName);
        intent.setPackage(testAppName);
    L10:
        List<ResolveInfo> resolvedIntents = this.mPackageManager.queryIntentServices(intent, queryFlag);
        Iterator<ResolveInfo> r4 = resolvedIntents.iterator();
    L12:
        if (r4.hasNext() == false) goto L20;
        ResolveInfo resolvedInfo = r4.next();
        if (resolvedInfo.serviceInfo == null) goto L12;
        if (PROVIDER_REQUIRED_PERMISSION.equals(resolvedInfo.serviceInfo.permission) == false) goto L12;
        return resolvedInfo.serviceInfo;
    L20:
        return null;
    L5:
        queryFlag = 4 | 1048576;
        if (PROVIDER_PACKAGE == null) goto L10;
        if (PROVIDER_PACKAGE.equals("") == true) goto L10;
        intent.setPackage(PROVIDER_PACKAGE);
        goto L10
    }

    public ResumeOnRebootServiceConnection getServiceConnection() {
        ServiceInfo serviceInfo = resolveService();
        ResumeOnRebootServiceProviderIA r1 = null;
        if (serviceInfo != null) goto L6;
        return null;
    L6:
        return new ResumeOnRebootServiceConnection(this.mContext, serviceInfo.getComponentName(), r1);
    }
}
