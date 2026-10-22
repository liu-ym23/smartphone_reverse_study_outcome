package ck5;

import android.content.Context;
import com.bytedance.ee.bear.notification.db.NotificationDatabase;
import com.bytedance.ee.util.db.DBController;

/* JADX INFO: loaded from: classes18.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile i f24043a;

    public final synchronized NotificationDatabase a() {
        monitor-enter(this);
        NotificationDatabase r100 = (NotificationDatabase) DBController.a().r1("notification.db");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public i(Context r100) {
        DBController.a r101 = new DBController.a(r100);     // Catch: Exception -> L5
        r101.f243099a = "notification.db";     // Catch: Exception -> L5
        r101.f243100b = NotificationDatabase.class;     // Catch: Exception -> L5
        DBController.a().W3("notification.db", r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }
}
