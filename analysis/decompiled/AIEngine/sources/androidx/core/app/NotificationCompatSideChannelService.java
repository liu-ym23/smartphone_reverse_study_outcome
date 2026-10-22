package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Binder;
import android.support.v4.app.INotificationSideChannel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class NotificationCompatSideChannelService extends Service {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class NotificationSideChannelStub extends INotificationSideChannel.Stub {
        final /* synthetic */ NotificationCompatSideChannelService this$0;

        public NotificationSideChannelStub(NotificationCompatSideChannelService notificationCompatSideChannelService) {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String str, int i10, String str2) {
            Binder.getCallingUid();
            throw null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String str) {
            Binder.getCallingUid();
            throw null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String str, int i10, String str2, Notification notification) {
            Binder.getCallingUid();
            throw null;
        }
    }
}
