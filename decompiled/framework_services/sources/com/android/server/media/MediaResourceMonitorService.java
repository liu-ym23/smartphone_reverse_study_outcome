package com.android.server.media;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.media.IMediaResourceMonitor;
import android.os.Binder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.Log;
import com.android.server.SystemService;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MediaResourceMonitorService extends SystemService {
    private static final boolean DEBUG = false;
    private static final String SERVICE_NAME = "media_resource_monitor";
    private static final String TAG = "MediaResourceMonitor";
    private final MediaResourceMonitorImpl mMediaResourceMonitorImpl;

    class MediaResourceMonitorImpl extends IMediaResourceMonitor.Stub {
        final /* synthetic */ MediaResourceMonitorService this$0;

        MediaResourceMonitorImpl(MediaResourceMonitorService this$0) {
            this.this$0 = this$0;
        }

        public void notifyResourceGranted(int pid, int type) throws RemoteException {
            if (MediaResourceMonitorService.m5546$$Nest$sfgetDEBUG() == false) goto L5;
            Log.d(MediaResourceMonitorService.TAG, "notifyResourceGranted(pid=" + pid + ", type=" + type + ")");
        L5:
            long identity = Binder.clearCallingIdentity();
            String[] pkgNames = getPackageNamesFromPid(pid);     // Catch: Throwable -> L19
            if (pkgNames != null) goto L10;
            Binder.restoreCallingIdentity(identity);
            return;
        L10:
            UserManager manager = (UserManager) this.this$0.getContext().createContextAsUser(UserHandle.of(ActivityManager.getCurrentUser()), 0).getSystemService(UserManager.class);     // Catch: Throwable -> L19
            List<UserHandle> enabledProfiles = manager.getEnabledProfiles();     // Catch: Throwable -> L19
            if (enabledProfiles.isEmpty() == false) goto L14;
            Binder.restoreCallingIdentity(identity);
            return;
        L14:
            Intent intent = new Intent("android.intent.action.MEDIA_RESOURCE_GRANTED");     // Catch: Throwable -> L19
            intent.putExtra("android.intent.extra.PACKAGES", pkgNames);     // Catch: Throwable -> L19
            intent.putExtra("android.intent.extra.MEDIA_RESOURCE_TYPE", type);     // Catch: Throwable -> L19
            Iterator<UserHandle> r6 = enabledProfiles.iterator();     // Catch: Throwable -> L19
        L16:
            if (r6.hasNext() == false) goto L21;
            UserHandle userHandle = r6.next();     // Catch: Throwable -> L19
            this.this$0.getContext().sendBroadcastAsUser(intent, userHandle, "android.permission.RECEIVE_MEDIA_RESOURCE_USAGE");     // Catch: Throwable -> L19
            goto L16
        L21:
            Binder.restoreCallingIdentity(identity);
            return;
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private String[] getPackageNamesFromPid(int pid) {
            ActivityManager manager = (ActivityManager) this.this$0.getContext().getSystemService(ActivityManager.class);
            Iterator<ActivityManager.RunningAppProcessInfo> r1 = manager.getRunningAppProcesses().iterator();
        L4:
            if (r1.hasNext() == false) goto L10;
            ActivityManager.RunningAppProcessInfo proc = r1.next();
            if (proc.pid != pid) goto L4;
            return proc.pkgList;
        L10:
            return null;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5546$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaResourceMonitorService(Context context) {
        super(context);
        this.mMediaResourceMonitorImpl = new MediaResourceMonitorImpl(this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService(SERVICE_NAME, this.mMediaResourceMonitorImpl);
    }
}
