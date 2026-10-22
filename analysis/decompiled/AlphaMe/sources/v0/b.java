package v0;

import B0.k;
import B0.p;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import s0.t;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f15675a = t.f("Alarms");

    public static void a(Context context, k kVar, int i4) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        String str = c.f15676f;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        c.d(intent, kVar);
        PendingIntent service = PendingIntent.getService(context, i4, intent, 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        t.d().a(f15675a, "Cancelling existing alarm with (workSpecId, systemId) (" + kVar + ", " + i4 + ")");
        alarmManager.cancel(service);
    }

    public static void b(Context context, WorkDatabase workDatabase, k generationalId, long j4) {
        p pVar = (p) workDatabase.d();
        B0.h hVarB = pVar.b(generationalId);
        if (hVarB != null) {
            int i4 = hVarB.f147c;
            a(context, generationalId, i4);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            String str = c.f15676f;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_DELAY_MET");
            c.d(intent, generationalId);
            PendingIntent service = PendingIntent.getService(context, i4, intent, 201326592);
            if (alarmManager != null) {
                AbstractC0952a.a(alarmManager, 0, j4, service);
                return;
            }
            return;
        }
        final C0.i iVar = new C0.i(workDatabase, 0);
        Object objRunInTransaction = iVar.f306a.runInTransaction((Callable<Object>) new Callable() { // from class: C0.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                i this$0 = iVar;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                WorkDatabase workDatabase2 = this$0.f306a;
                Long lG = workDatabase2.c().g("next_alarm_manager_id");
                int iLongValue = lG != null ? (int) lG.longValue() : 0;
                workDatabase2.c().j(new B0.d("next_alarm_manager_id", Long.valueOf(iLongValue != Integer.MAX_VALUE ? iLongValue + 1 : 0)));
                return Integer.valueOf(iLongValue);
            }
        });
        Intrinsics.checkNotNullExpressionValue(objRunInTransaction, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        int iIntValue = ((Number) objRunInTransaction).intValue();
        Intrinsics.checkNotNullParameter(generationalId, "generationalId");
        pVar.c(new B0.h(generationalId.f150a, generationalId.f151b, iIntValue));
        AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
        String str2 = c.f15676f;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_DELAY_MET");
        c.d(intent2, generationalId);
        PendingIntent service2 = PendingIntent.getService(context, iIntValue, intent2, 201326592);
        if (alarmManager2 != null) {
            AbstractC0952a.a(alarmManager2, 0, j4, service2);
        }
    }
}
