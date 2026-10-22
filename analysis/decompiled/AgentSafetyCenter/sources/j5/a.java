package j5;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import g5.u;
import h5.v;
import java.lang.invoke.VarHandle;
import p5.i;
import p5.j;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6558a = u.f("Alarms");

    public static void a(Context context, j jVar, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        String str = b.f6559j;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        b.c(intent, jVar);
        PendingIntent service = PendingIntent.getService(context, i, intent, 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        u.d().a(f6558a, "Cancelling existing alarm with (workSpecId, systemId) (" + jVar + ", " + i + ")");
        alarmManager.cancel(service);
    }

    public static void b(Context context, WorkDatabase workDatabase, j jVar, long j10) {
        i iVarZ = workDatabase.z();
        p5.g gVarW = iVarZ.w(jVar);
        if (gVarW != null) {
            int i = gVarW.f9728c;
            a(context, jVar, i);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            String str = b.f6559j;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_DELAY_MET");
            b.c(intent, jVar);
            PendingIntent service = PendingIntent.getService(context, i, intent, 201326592);
            if (alarmManager != null) {
                alarmManager.setExact(0, j10, service);
                return;
            }
            return;
        }
        a1.g gVar = new a1.g(24, false);
        gVar.f19f = workDatabase;
        VarHandle.storeStoreFence();
        v vVar = new v(2);
        vVar.f5386f = gVar;
        VarHandle.storeStoreFence();
        Object objT = workDatabase.t(vVar);
        objT.getClass();
        int iIntValue = ((Number) objT).intValue();
        iVarZ.z(new p5.g(jVar.f9734a, jVar.f9735b, iIntValue));
        AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
        String str2 = b.f6559j;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_DELAY_MET");
        b.c(intent2, jVar);
        PendingIntent service2 = PendingIntent.getService(context, iIntValue, intent2, 201326592);
        if (alarmManager2 != null) {
            alarmManager2.setExact(0, j10, service2);
        }
    }
}
