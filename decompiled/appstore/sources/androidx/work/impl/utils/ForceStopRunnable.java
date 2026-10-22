package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import androidx.work.Configuration;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.c0;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.y;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5777e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f5778f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f5780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f5781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5782d;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f5783a = null;

        static {
            f5783a = androidx.work.i.i("ForceStopRunnable$Rcvr");
        }

        public BroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            if ("ACTION_FORCE_STOP_RESCHEDULE".equals(r11.getAction()) == false) goto L8;
            androidx.work.i.e().j(f5783a, "Rescheduling alarm that keeps track of force-stops.");
            ForceStopRunnable.g(r10);
            return;
        }
    }

    static {
        f5777e = androidx.work.i.i("ForceStopRunnable");
        f5778f = TimeUnit.DAYS.toMillis(3650);
    }

    public ForceStopRunnable(Context r10, c0 r11) {
        this.f5779a = r10.getApplicationContext();
        this.f5780b = r11;
        this.f5781c = r11.m();
        this.f5782d = 0;
    }

    public static Intent c(Context r10) {
        Intent r11 = new Intent();
        r11.setComponent(new ComponentName(r10, BroadcastReceiver.class));
        r11.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return r11;
    }

    public static PendingIntent d(Context r10, int r11) {
        return PendingIntent.getBroadcast(r10, -1, c(r10), r11);
    }

    public static void g(Context r10) {
        AlarmManager r11 = (AlarmManager) r10.getSystemService(BatteryTypeInf.BATTERY_ALARM);
        if (Build.VERSION.SDK_INT < 31) goto L5;
        int r12 = 167772160;
    L6:
        PendingIntent r13 = d(r10, r12);
        long r14 = System.currentTimeMillis() + f5778f;
        if (r11 == null) goto L10;
        r11.setExact(0, r14, r13);
        return;
    L10:
        return;
    L5:
        r12 = 134217728;
        goto L6
    }

    public boolean a() {
        boolean r10 = androidx.work.impl.background.systemjob.b.f(this.f5779a, this.f5780b);
        WorkDatabase r11 = this.f5780b.q();
        WorkSpecDao r12 = r11.L();
        WorkProgressDao r13 = r11.K();
        r11.e();
        List<androidx.work.impl.model.o> r14 = r12.getRunningWork();     // Catch: Throwable -> L8
        if (r14 != null) goto L6;
    L10:
        boolean r15 = false;
    L11:
        if (r15 == false) goto L16;
        Iterator<androidx.work.impl.model.o> r16 = r14.iterator();     // Catch: Throwable -> L8
    L14:
        if (r16.hasNext() == false) goto L16;
        androidx.work.impl.model.o r17 = r16.next();     // Catch: Throwable -> L8
        r12.setState(WorkInfo.State.ENQUEUED, r17.f5670a);     // Catch: Throwable -> L8
        r12.markWorkSpecScheduled(r17.f5670a, -1);     // Catch: Throwable -> L8
    L16:
        r13.deleteAll();     // Catch: Throwable -> L8
        r11.D();     // Catch: Throwable -> L8
        r11.i();
        if (r15 == true) goto L21;
        if (r10 == true) goto L21;
        return false;
    L21:
        return true;
    L6:
        if (r14.isEmpty() == true) goto L10;
        r15 = true;
    L8:
        th = move-exception;
        r11.i();
        throw th;
    }

    public void b() {
        boolean r10 = a();
        if (h() == false) goto L6;
        androidx.work.i.e().a(f5777e, "Rescheduling Workers.");
        this.f5780b.u();
        this.f5780b.m().e(false);
        return;
    L6:
        if (e() == false) goto L8;
        androidx.work.i.e().a(f5777e, "Application was force-stopped, rescheduling.");
        this.f5780b.u();
        this.f5781c.d(System.currentTimeMillis());
        return;
    L8:
        if (r10 == false) goto L13;
        androidx.work.i.e().a(f5777e, "Found unfinished work, scheduling it.");
        androidx.work.impl.s.b(this.f5780b.j(), this.f5780b.q(), this.f5780b.o());
        return;
    }

    public boolean e() {
    L10:
        e = move-exception;
        androidx.work.i.e().l(f5777e, "Ignoring exception", e);
        return true;
    L4:
        if (Build.VERSION.SDK_INT < 31) goto L6;
        int r10 = 570425344;
    L7:
        PendingIntent r11 = d(this.f5779a, r10);     // Catch: Throwable -> L10
        if (r11 == null) goto L12;
        r11.cancel();     // Catch: Throwable -> L10
    L12:
        List<ApplicationExitInfo> r12 = ((ActivityManager) this.f5779a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);     // Catch: Throwable -> L10
        if (r12 != null) goto L15;
    L26:
        return false;
    L15:
        if (r12.isEmpty() == true) goto L26;
        long r13 = this.f5781c.a();     // Catch: Throwable -> L10
        int r14 = 0;
    L17:
        if (r14 >= r12.size()) goto L26;
        ApplicationExitInfo r15 = r12.get(r14);     // Catch: Throwable -> L10
        if (r15.getReason() != 10) goto L25;
        if (r15.getTimestamp() < r13) goto L25;
        return true;
    L25:
        r14 = r14 + 1;
        goto L17
    L6:
        r10 = 536870912;
        goto L7
    }

    public boolean f() {
        Configuration r10 = this.f5780b.j();
        if (TextUtils.isEmpty(r10.c()) == false) goto L6;
        androidx.work.i.e().a(f5777e, "The default process name was not specified.");
        return true;
    L6:
        boolean r11 = n.b(this.f5779a, r10);
        androidx.work.i.e().a(f5777e, "Is default app process = " + r11);
        return r11;
    }

    public boolean h() {
        return this.f5780b.m().b();
    }

    public void i(long r10) {
        Thread.sleep(r10);     // Catch: InterruptedException -> L4
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
    L10:
        th = move-exception;
        this.f5780b.t();
        throw th;
    L3:
        if (f() == true) goto L32;
        this.f5780b.t();
        return;
    L32:
        y.d(this.f5779a);     // Catch: Throwable -> L10 SQLiteException -> L20
        androidx.work.i.e().a(f5777e, "Performing cleanup operations.");     // Catch: Throwable -> L10
        b();     // Catch: Throwable -> L10 Throwable -> L12
    L24:
        this.f5780b.t();
        return;
    L12:
        e = move-exception;
        int r10 = this.f5782d + 1;     // Catch: Throwable -> L10
        this.f5782d = r10;     // Catch: Throwable -> L10
        if (r10 >= 3) goto L15;
        androidx.work.i.e().b(f5777e, "Retrying after " + (((long) r10) * 300), e);     // Catch: Throwable -> L10
        i(((long) this.f5782d) * 300);     // Catch: Throwable -> L10
        goto L32
    L15:
        androidx.work.i r11 = androidx.work.i.e();     // Catch: Throwable -> L10
        String r12 = f5777e;     // Catch: Throwable -> L10
        r11.d(r12, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);     // Catch: Throwable -> L10
        IllegalStateException r13 = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);     // Catch: Throwable -> L10
        Consumer r14 = this.f5780b.j().e();     // Catch: Throwable -> L10
        if (r14 == null) goto L18;
        androidx.work.i.e().b(r12, "Routing exception to the specified exception handler", r13);     // Catch: Throwable -> L10
        r14.accept(r13);     // Catch: Throwable -> L10
        goto L24
    L18:
        throw r13;     // Catch: Throwable -> L10
    L20:
        e = move-exception;
        androidx.work.i.e().c(f5777e, "Unexpected SQLite exception during migrations");     // Catch: Throwable -> L10
        IllegalStateException r15 = new IllegalStateException("Unexpected SQLite exception during migrations", e);     // Catch: Throwable -> L10
        Consumer r16 = this.f5780b.j().e();     // Catch: Throwable -> L10
        if (r16 == null) goto L26;
        r16.accept(r15);     // Catch: Throwable -> L10
        goto L24
    L26:
        throw r15;     // Catch: Throwable -> L10
    }
}
