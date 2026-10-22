package androidx.core.app;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f9555c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static Set<String> f9556d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private static final Object f9557e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f9558a;

    /* renamed from: b, reason: collision with root package name */
    private final NotificationManager f9559b;

    static class a {
        static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    private m(Context context) {
        this.f9558a = context;
        this.f9559b = (NotificationManager) context.getSystemService("notification");
    }

    public static m b(Context context) {
        return new m(context);
    }

    public boolean a() {
        return a.a(this.f9559b);
    }
}
