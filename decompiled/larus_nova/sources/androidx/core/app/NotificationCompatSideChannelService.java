package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public abstract class NotificationCompatSideChannelService extends Service {

    public class NotificationSideChannelStub extends INotificationSideChannel.Stub {
        final /* synthetic */ NotificationCompatSideChannelService this$0;

        public NotificationSideChannelStub(NotificationCompatSideChannelService r100) {
            this.this$0 = r100;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String r100) {
            androidx_core_app_NotificationCompatSideChannelService$NotificationSideChannelStub_androidx_core_app_NotificationCompatSideChannelService_checkPermission(this.this$0, Binder.getCallingUid(), r100);
            long r101 = Binder.clearCallingIdentity();
            this.this$0.cancelAll(r100);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r101);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r101);
            throw th;
        }

        private static void androidx_core_app_NotificationCompatSideChannelService$NotificationSideChannelStub_androidx_core_app_NotificationCompatSideChannelService_checkPermission(NotificationCompatSideChannelService r110, int r111, String r210) throws RemoteException {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {Integer.valueOf(r111), r210};
            f06.b r112 = new f06.b("auto_cert_androidx_core_app_NotificationCompatSideChannelService$NotificationSideChannelStub_androidx_core_app_NotificationCompatSideChannelService_checkPermission");
            g06.a r102 = ApiHookConfig.f245611b.get(102607);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            d r107 = r106.preInvoke(102607, "androidx/core/app/NotificationCompatSideChannelService", "checkPermission", r110, r101, "void", r112);     // Catch: Exception -> L21
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L21
        L17:
            if (r107.f474982a == false) goto L19;
            return;
        L19:
            r110.checkPermission(r111, r210);
            return;
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String r100, int r101, String r102) throws RemoteException {
            androidx_core_app_NotificationCompatSideChannelService$NotificationSideChannelStub_androidx_core_app_NotificationCompatSideChannelService_checkPermission(this.this$0, Binder.getCallingUid(), r100);
            long r103 = Binder.clearCallingIdentity();
            this.this$0.cancel(r100, r101, r102);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r103);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r103);
            throw th;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String r100, int r101, String r102, Notification r103) throws RemoteException {
            androidx_core_app_NotificationCompatSideChannelService$NotificationSideChannelStub_androidx_core_app_NotificationCompatSideChannelService_checkPermission(this.this$0, Binder.getCallingUid(), r100);
            long r104 = Binder.clearCallingIdentity();
            this.this$0.notify(r100, r101, r102, r103);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r104);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r104);
            throw th;
        }
    }

    public abstract void cancel(String r100, int r101, String r102);

    public abstract void cancelAll(String r100);

    public abstract void notify(String r100, int r101, String r102, Notification r103);

    public NotificationCompatSideChannelService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        r100.getAction().equals(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL);
        return null;
    }

    public void checkPermission(int r100, String r101) {
        String[] r102 = getPackageManager().getPackagesForUid(r100);
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        if (r102[r104].equals(r101) == true) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return;
    L9:
        throw new SecurityException("NotificationSideChannelService: Uid " + r100 + " is not authorized for package " + r101);
    }
}
