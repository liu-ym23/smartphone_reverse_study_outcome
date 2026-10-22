package com.stepos.digitalwellbeing.server;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import f2.C0702g;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<Intent> f14522a = new ConcurrentLinkedQueue<>();

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f14523b;

    static void a(Intent intent) {
        if (intent == null) {
            return;
        }
        while (true) {
            ConcurrentLinkedQueue<Intent> concurrentLinkedQueue = f14522a;
            if (concurrentLinkedQueue.size() < 64) {
                concurrentLinkedQueue.offer(new Intent(intent));
                C0702g.O("AlphaMeIntentQueue", "enqueued AlphaMe intent, queueSize=" + concurrentLinkedQueue.size() + " action=" + intent.getAction());
                return;
            }
            Intent intentPoll = concurrentLinkedQueue.poll();
            StringBuilder sb = new StringBuilder();
            sb.append("queue full, drop oldest intent action=");
            sb.append(intentPoll != null ? intentPoll.getAction() : "null");
            C0702g.O("AlphaMeIntentQueue", sb.toString());
        }
    }

    static boolean b() {
        return f14522a.isEmpty();
    }

    static Intent c() {
        return f14522a.poll();
    }

    static void d() {
        f14523b = 0;
    }

    static void e(Context context) {
        if (b()) {
            return;
        }
        if (f14523b >= 8) {
            C0702g.p("AlphaMeIntentQueue", "retry exhausted, pendingSize=" + f14522a.size());
            return;
        }
        f14523b++;
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("com.stepos.digitalwellbeing.action.ALPHAME_SERVICE_RETRY");
        intent.setPackage(applicationContext.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(applicationContext, 4279621, intent, 201326592);
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService("alarm");
        if (alarmManager == null) {
            C0702g.p("AlphaMeIntentQueue", "AlarmManager is null, cannot schedule retry");
            return;
        }
        alarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 3000, broadcast);
        C0702g.b("AlphaMeIntentQueue", "scheduled retry #" + f14523b + " in 3000ms");
    }
}
