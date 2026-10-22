package androidx.core.app;

import android.app.Notification;
import android.os.Binder;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

/* loaded from: classes.dex */
class NotificationCompatSideChannelService$NotificationSideChannelStub extends INotificationSideChannel.Stub {
    final /* synthetic */ y this$0;

    public NotificationCompatSideChannelService$NotificationSideChannelStub(y yVar) {
    }

    @Override // android.support.v4.app.INotificationSideChannel
    public void cancel(String str, int i4, String str2) throws RemoteException {
        Binder.getCallingUid();
        throw null;
    }

    @Override // android.support.v4.app.INotificationSideChannel
    public void cancelAll(String str) {
        Binder.getCallingUid();
        throw null;
    }

    @Override // android.support.v4.app.INotificationSideChannel
    public void notify(String str, int i4, String str2, Notification notification) throws RemoteException {
        Binder.getCallingUid();
        throw null;
    }
}
