package com.baidu.xclient.gdid.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.xclient.gdid.d;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f9511a = 60000;

    /* renamed from: b, reason: collision with root package name */
    public static long f9512b = 3600000;

    /* renamed from: c, reason: collision with root package name */
    public static long f9513c = 86400000;

    public static void a(Context context, long j4) {
        if (j4 <= 0) {
            return;
        }
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent(b.f9514a);
            intent.setPackage(d.a().a(context));
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 100, intent, 201326592);
            alarmManager.cancel(broadcast);
            alarmManager.set(1, System.currentTimeMillis() + j4, broadcast);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }
}
