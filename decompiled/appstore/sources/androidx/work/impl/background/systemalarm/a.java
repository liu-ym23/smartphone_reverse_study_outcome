package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.h;
import androidx.work.impl.utils.g;
import com.bytedance.apm.battery.config.BatteryTypeInf;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5462a = null;

    /* JADX INFO: renamed from: androidx.work.impl.background.systemalarm.a$a, reason: collision with other inner class name */
    public static class C0058a {
        @DoNotInline
        public static void a(AlarmManager r10, int r11, long r12, PendingIntent r13) {
            r10.setExact(r11, r12, r13);
        }
    }

    static {
        f5462a = i.i("Alarms");
    }

    public static void a(Context r10, WorkDatabase r11, androidx.work.impl.model.i r12) {
        SystemIdInfoDao r13 = r11.I();
        androidx.work.impl.model.f r14 = r13.getSystemIdInfo(r12);
        if (r14 == null) goto L6;
        b(r10, r12, r14.f5643c);
        i.e().a(f5462a, "Removing SystemIdInfo for workSpecId (" + r12 + ")");
        r13.removeSystemIdInfo(r12);
        return;
    }

    public static void b(Context r10, androidx.work.impl.model.i r11, int r12) {
        AlarmManager r13 = (AlarmManager) r10.getSystemService(BatteryTypeInf.BATTERY_ALARM);
        PendingIntent r14 = PendingIntent.getService(r10, r12, b.b(r10, r11), 603979776);
        if (r14 == null) goto L7;
        if (r13 == null) goto L8;
        i.e().a(f5462a, "Cancelling existing alarm with (workSpecId, systemId) (" + r11 + ", " + r12 + ")");
        r13.cancel(r14);
        return;
    L8:
        return;
    }

    public static void c(Context r10, WorkDatabase r11, androidx.work.impl.model.i r12, long r13) {
        SystemIdInfoDao r14 = r11.I();
        androidx.work.impl.model.f r15 = r14.getSystemIdInfo(r12);
        if (r15 == null) goto L5;
        b(r10, r12, r15.f5643c);
        d(r10, r12, r15.f5643c, r13);
        return;
    L5:
        int r16 = new g(r11).c();
        r14.insertSystemIdInfo(h.a(r12, r16));
        d(r10, r12, r16, r13);
    }

    public static void d(Context r10, androidx.work.impl.model.i r11, int r12, long r13) {
        AlarmManager r14 = (AlarmManager) r10.getSystemService(BatteryTypeInf.BATTERY_ALARM);
        PendingIntent r15 = PendingIntent.getService(r10, r12, b.b(r10, r11), 201326592);
        if (r14 == null) goto L6;
        C0058a.a(r14, 0, r13, r15);
        return;
    }
}
