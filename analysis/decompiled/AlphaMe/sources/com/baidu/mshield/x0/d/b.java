package com.baidu.mshield.x0.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f8379a;

    public static void a(Context context, long j4) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.baidu.mshield.x0.alarm.action");
            intent.setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 100, intent, 201326592);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
                d.a(th);
            }
            alarmManager.set(1, System.currentTimeMillis() + j4, broadcast);
        } catch (Throwable th2) {
            d.a(th2);
        }
    }

    public static int b(Context context) {
        try {
            String strC = new com.baidu.mshield.x0.l.a(context).c("plc33");
            if (!TextUtils.isEmpty(strC)) {
                return new JSONObject(strC).optJSONObject("5").optInt("t", 60);
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return 60;
    }

    public static void c(Context context) {
        int iB = new com.baidu.mshield.x0.l.a(context).b();
        if (iB == 0) {
            iB = 24;
        }
        a(context, "com.baidu.mshield.x0.detect.app.fr", iB * 3600000, 1);
    }

    public static void a(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.baidu.mshield.x0.alarm.action");
            intent.setPackage(context.getPackageName());
            alarmManager.cancel(PendingIntent.getBroadcast(context, 100, intent, 201326592));
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void a(Context context, boolean z4) {
        f8379a = z4;
        a(context, new com.baidu.mshield.x0.l.a(context));
        c(context);
        f8379a = false;
    }

    public static void a(Context context, String str, long j4, int i4) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() + j4;
            a aVar = new a();
            aVar.f8376a = str;
            aVar.f8378c = jCurrentTimeMillis;
            aVar.f8377b = i4;
            a aVarA = com.baidu.mshield.x0.f.a.a(context).a(str);
            if (aVarA != null) {
                long j5 = aVarA.f8378c;
                long jN = new com.baidu.mshield.x0.l.a(context).n();
                if (!f8379a && j5 >= jN) {
                    aVar.f8378c = j5;
                }
            }
            com.baidu.mshield.x0.f.a.a(context).a(aVar);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void a(Context context, com.baidu.mshield.x0.l.a aVar) {
        if (aVar == null) {
            aVar = new com.baidu.mshield.x0.l.a(context);
        }
        a(context, "com.baidu.mshield.x0.timer.pp.action", aVar.m() * 60000, 0);
    }
}
