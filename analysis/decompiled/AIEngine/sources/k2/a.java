package k2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import h2.j;
import i2.u;
import q2.g;
import q2.h;
import q2.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9858a = j.f("Alarms");

    public static void a(Context context, k kVar, int i10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        String str = b.h;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        b.d(intent, kVar);
        PendingIntent service = PendingIntent.getService(context, i10, intent, 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        j.d().a(f9858a, "Cancelling existing alarm with (workSpecId, systemId) (" + kVar + ", " + i10 + ")");
        alarmManager.cancel(service);
    }

    public static void b(Context context, WorkDatabase workDatabase, k kVar, long j10) {
        h hVarT = workDatabase.t();
        g gVarC = hVarT.c(kVar);
        if (gVarC != null) {
            int i10 = gVarC.f11495c;
            a(context, kVar, i10);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            String str = b.h;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_DELAY_MET");
            b.d(intent, kVar);
            PendingIntent service = PendingIntent.getService(context, i10, intent, 201326592);
            if (alarmManager != null) {
                alarmManager.setExact(0, j10, service);
                return;
            }
            return;
        }
        Object objN = workDatabase.n(new u(new androidx.lifecycle.b(workDatabase), 1));
        kotlin.jvm.internal.g.e(objN, "workDatabase.runInTransa…NAGER_ID_KEY) }\n        )");
        int iIntValue = ((Number) objN).intValue();
        hVarT.p(new g(kVar.f11498a, kVar.f11499b, iIntValue));
        AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
        String str2 = b.h;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_DELAY_MET");
        b.d(intent2, kVar);
        PendingIntent service2 = PendingIntent.getService(context, iIntValue, intent2, 201326592);
        if (alarmManager2 != null) {
            alarmManager2.setExact(0, j10, service2);
        }
    }
}
