package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Binder;
import android.support.v4.app.INotificationSideChannel;

/* loaded from: classes.dex */
public abstract class NotificationCompatSideChannelService extends Service {

    private class NotificationSideChannelStub extends INotificationSideChannel.Stub {
        final /* synthetic */ NotificationCompatSideChannelService this$0;

        NotificationSideChannelStub(NotificationCompatSideChannelService notificationCompatSideChannelService) {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String str, int i5, String str2) {
            Binder.getCallingUid();
            throw null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String str) {
            Binder.getCallingUid();
            throw null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String str, int i5, String str2, Notification notification) {
            Binder.getCallingUid();
            throw null;
        }
    }
}
