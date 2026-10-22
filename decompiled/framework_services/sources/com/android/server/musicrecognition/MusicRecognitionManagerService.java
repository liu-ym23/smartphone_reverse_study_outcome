package com.android.server.musicrecognition;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.musicrecognition.IMusicRecognitionManager;
import android.media.musicrecognition.IMusicRecognitionManagerCallback;
import android.media.musicrecognition.RecognitionRequest;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.util.Slog;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.FrameworkResourcesServiceNameResolver;
import com.android.server.infra.ServiceNameResolver;
import java.io.FileDescriptor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class MusicRecognitionManagerService extends AbstractMasterSystemService<MusicRecognitionManagerService, MusicRecognitionManagerPerUserService> {
    private static final int MAX_TEMP_SERVICE_SUBSTITUTION_DURATION_MS = 60000;
    private static final String TAG = null;
    final ExecutorService mExecutorService;
    private MusicRecognitionManagerStub mMusicRecognitionManagerStub;

    final class MusicRecognitionManagerStub extends IMusicRecognitionManager.Stub {
        final /* synthetic */ MusicRecognitionManagerService this$0;

        MusicRecognitionManagerStub(MusicRecognitionManagerService this$0) {
            this.this$0 = this$0;
        }

        public void beginRecognition(RecognitionRequest recognitionRequest, IBinder callback) {
            MusicRecognitionManagerService.m5925$$Nest$menforceCaller(this.this$0, "beginRecognition");
            Object r0 = MusicRecognitionManagerService.access$000(this.this$0);
            monitor-enter(r0);
            int userId = UserHandle.getCallingUserId();     // Catch: Throwable -> L11
            MusicRecognitionManagerPerUserService service = (MusicRecognitionManagerPerUserService) MusicRecognitionManagerService.access$100(this.this$0, userId);     // Catch: Throwable -> L11
            if (service != null) goto L7;
        L22:
            IMusicRecognitionManagerCallback.Stub.asInterface(callback).onRecognitionFailed(3);     // Catch: Throwable -> L11 RemoteException -> L17
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (isDefaultServiceLocked(userId) == false) goto L9;
        L13:
            service.beginRecognitionLocked(recognitionRequest, callback);     // Catch: Throwable -> L11
            goto L18
        L9:
            if (isCalledByServiceAppLocked("beginRecognition") == false) goto L22;
        L11:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) throws RemoteException {
            new MusicRecognitionManagerServiceShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }

        private boolean isDefaultServiceLocked(int userId) {
            String defaultServiceName = MusicRecognitionManagerService.access$200(this.this$0).getDefaultServiceName(userId);
            if (defaultServiceName != null) goto L6;
            return false;
        L6:
            String currentServiceName = MusicRecognitionManagerService.access$300(this.this$0).getServiceName(userId);
            return defaultServiceName.equals(currentServiceName);
        }

        private boolean isCalledByServiceAppLocked(String methodName) {
            int userId = UserHandle.getCallingUserId();
            int callingUid = Binder.getCallingUid();
            String serviceName = MusicRecognitionManagerService.access$400(this.this$0).getServiceName(userId);
            if (serviceName != null) goto L6;
            Slog.e(MusicRecognitionManagerService.m5926$$Nest$sfgetTAG(), methodName + ": called by UID " + callingUid + ", but there's no service set for user " + userId);
            return false;
        L6:
            ComponentName serviceComponent = ComponentName.unflattenFromString(serviceName);
            if (serviceComponent != null) goto L10;
            Slog.w(MusicRecognitionManagerService.m5926$$Nest$sfgetTAG(), methodName + ": invalid service name: " + serviceName);
            return false;
        L10:
            String servicePackageName = serviceComponent.getPackageName();
            PackageManager pm = this.this$0.getContext().getPackageManager();
            int serviceUid = pm.getPackageUidAsUser(servicePackageName, UserHandle.getCallingUserId());     // Catch: PackageManager.NameNotFoundException -> L17
            if (callingUid == serviceUid) goto L15;
            Slog.e(MusicRecognitionManagerService.m5926$$Nest$sfgetTAG(), methodName + ": called by UID " + callingUid + ", but service UID is " + serviceUid);
            return false;
        L15:
            return true;
        L18:
            Slog.w(MusicRecognitionManagerService.m5926$$Nest$sfgetTAG(), methodName + ": could not verify UID for " + serviceName);
            return false;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$menforceCaller, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5925$$Nest$menforceCaller(MusicRecognitionManagerService r0, String r1) {
        r0.enforceCaller(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5926$$Nest$sfgetTAG() {
        return TAG;
    }

    static /* synthetic */ Object access$000(MusicRecognitionManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$100(MusicRecognitionManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ ServiceNameResolver access$200(MusicRecognitionManagerService x0) {
        return x0.mServiceNameResolver;
    }

    static /* synthetic */ ServiceNameResolver access$300(MusicRecognitionManagerService x0) {
        return x0.mServiceNameResolver;
    }

    static /* synthetic */ ServiceNameResolver access$400(MusicRecognitionManagerService x0) {
        return x0.mServiceNameResolver;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    static {
        TAG = MusicRecognitionManagerService.class.getSimpleName();
    }

    public MusicRecognitionManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.string.config_fallbackCredentialManagerDialogComponent), null);
        this.mExecutorService = Executors.newCachedThreadPool();
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected MusicRecognitionManagerPerUserService newServiceLocked(int resolvedUserId, boolean disabled) {
        return new MusicRecognitionManagerPerUserService(this, this.mLock, resolvedUserId);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mMusicRecognitionManagerStub = new MusicRecognitionManagerStub(this);
        publishBinderService("music_recognition", this.mMusicRecognitionManagerStub);
    }

    private void enforceCaller(String func) {
        Context ctx = getContext();
        if (ctx.checkCallingPermission("android.permission.MANAGE_MUSIC_RECOGNITION") != 0) goto L5;
        return;
    L5:
        String msg = "Permission Denial: " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " doesn't hold android.permission.MANAGE_MUSIC_RECOGNITION";
        throw new SecurityException(msg);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void enforceCallingPermissionForManagement() {
        getContext().enforceCallingPermission("android.permission.MANAGE_MUSIC_RECOGNITION", TAG);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected int getMaximumTemporaryServiceDurationMs() {
        return 60000;
    }
}
