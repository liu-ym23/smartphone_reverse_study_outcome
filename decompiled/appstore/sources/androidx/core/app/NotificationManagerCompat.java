package androidx.core.app;

import android.app.NotificationManager;
import android.content.Context;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationManagerCompat {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f2452c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Set f2453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f2454e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f2456b;

    public interface Task {
        void send(INotificationSideChannel r10) throws RemoteException;
    }

    static {
        f2452c = new Object();
        f2453d = new HashSet();
        f2454e = new Object();
    }

    public NotificationManagerCompat(Context r10) {
        this.f2455a = r10;
        this.f2456b = (NotificationManager) r10.getSystemService("notification");
    }

    public static NotificationManagerCompat b(Context r10) {
        return new NotificationManagerCompat(r10);
    }

    public boolean a() {
        return this.f2456b.areNotificationsEnabled();
    }
}
