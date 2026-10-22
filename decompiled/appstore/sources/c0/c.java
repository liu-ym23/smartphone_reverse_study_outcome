package c0;

import android.app.ActivityManager;
import android.database.Cursor;
import android.net.Uri;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6024a = null;

    static {
        f6024a = new c();
    }

    public c() {
    }

    public static final Uri a(Cursor r10) {
        q.g(r10, "cursor");
        Uri r11 = r10.getNotificationUri();
        q.f(r11, "cursor.notificationUri");
        return r11;
    }

    public static final boolean b(ActivityManager r10) {
        q.g(r10, "activityManager");
        return r10.isLowRamDevice();
    }
}
