package com.blankj.utilcode.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import androidx.core.app.j;
import com.blankj.utilcode.util.p;

/* loaded from: classes.dex */
public class i {

    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f19234b = new a(p.a().getPackageName(), p.a().getPackageName(), 3);

        /* renamed from: a, reason: collision with root package name */
        public NotificationChannel f19235a;

        public a(String str, CharSequence charSequence, int i10) {
            this.f19235a = new NotificationChannel(str, charSequence, i10);
        }

        public NotificationChannel b() {
            return this.f19235a;
        }
    }

    public static Notification a(a aVar, p.b<j.d> bVar) {
        ((NotificationManager) p.a().getSystemService("notification")).createNotificationChannel(aVar.b());
        j.d dVar = new j.d(p.a());
        dVar.g(aVar.f19235a.getId());
        if (bVar != null) {
            bVar.accept(dVar);
        }
        return dVar.b();
    }
}
