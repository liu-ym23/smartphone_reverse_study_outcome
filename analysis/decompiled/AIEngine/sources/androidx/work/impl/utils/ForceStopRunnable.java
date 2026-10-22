package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import h2.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import l2.c;
import q2.d;
import q2.k;
import q2.o;
import q2.p;
import q2.q;
import r2.i;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ForceStopRunnable implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public static final String f2974e = j.f("ForceStopRunnable");
    public static final long h = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: a, reason: collision with root package name */
    public final Context f2975a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.work.impl.b f2976b;

    /* renamed from: c, reason: collision with root package name */
    public final i f2977c;

    /* renamed from: d, reason: collision with root package name */
    public int f2978d = 0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public static final String f2979a = j.f("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            if (((j.a) j.d()).f9274c <= 2) {
                Log.v(f2979a, "Rescheduling alarm that keeps track of force-stops.");
            }
            String str = ForceStopRunnable.f2974e;
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            int i10 = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
            intent2.setAction("ACTION_FORCE_STOP_RESCHEDULE");
            PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent2, i10);
            long jCurrentTimeMillis = System.currentTimeMillis() + ForceStopRunnable.h;
            if (alarmManager != null) {
                alarmManager.setExact(0, jCurrentTimeMillis, broadcast);
            }
        }
    }

    public ForceStopRunnable(Context context, androidx.work.impl.b bVar) {
        this.f2975a = context.getApplicationContext();
        this.f2976b = bVar;
        this.f2977c = bVar.f2883g;
    }

    /* JADX WARN: Finally extract failed */
    public final void a() {
        boolean z;
        int i10;
        List<ApplicationExitInfo> historicalProcessExitReasons;
        i iVar = this.f2977c;
        androidx.work.impl.b bVar = this.f2976b;
        WorkDatabase workDatabase = bVar.f2879c;
        androidx.work.a aVar = bVar.f2878b;
        i iVar2 = bVar.f2883g;
        workDatabase = bVar.f2879c;
        String str = c.h;
        Context context = this.f2975a;
        JobScheduler jobSchedulerB = l2.a.b(context);
        ArrayList arrayListB = c.b(context, jobSchedulerB);
        ArrayList arrayListO = workDatabase.t().o();
        HashSet hashSet = new HashSet(arrayListB != null ? arrayListB.size() : 0);
        if (arrayListB != null && !arrayListB.isEmpty()) {
            int size = arrayListB.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayListB.get(i11);
                i11++;
                JobInfo jobInfo = (JobInfo) obj;
                k kVarE = c.e(jobInfo);
                if (kVarE != null) {
                    hashSet.add(kVarE.f11498a);
                } else {
                    c.a(jobSchedulerB, jobInfo.getId());
                }
            }
        }
        int size2 = arrayListO.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size2) {
                z = false;
                break;
            }
            Object obj2 = arrayListO.get(i12);
            i12++;
            if (!hashSet.contains((String) obj2)) {
                j.d().a(c.h, "Reconciling jobs");
                z = true;
                break;
            }
        }
        if (z) {
            workDatabase.c();
            try {
                q qVarW = workDatabase.w();
                int size3 = arrayListO.size();
                int i13 = 0;
                while (i13 < size3) {
                    Object obj3 = arrayListO.get(i13);
                    i13++;
                    qVarW.c(-1L, (String) obj3);
                }
                workDatabase.p();
                workDatabase.k();
            } catch (Throwable th) {
                throw th;
            }
        }
        q qVarW2 = workDatabase.w();
        o oVarV = workDatabase.v();
        workDatabase.c();
        try {
            ArrayList arrayListU = qVarW2.u();
            boolean zIsEmpty = arrayListU.isEmpty();
            if (!zIsEmpty) {
                int size4 = arrayListU.size();
                int i14 = 0;
                while (i14 < size4) {
                    Object obj4 = arrayListU.get(i14);
                    i14++;
                    WorkInfo$State workInfo$State = WorkInfo$State.f2792a;
                    String str2 = ((p) obj4).f11505a;
                    qVarW2.r(workInfo$State, str2);
                    qVarW2.v(-512, str2);
                    qVarW2.c(-1L, str2);
                    z = z;
                    oVarV = oVarV;
                }
            }
            boolean z3 = z;
            oVarV.m();
            workDatabase.p();
            workDatabase.k();
            boolean z10 = !zIsEmpty || z3;
            Long lI = iVar2.f11695a.s().i("reschedule_needed");
            String str3 = f2974e;
            if (lI != null && lI.longValue() == 1) {
                j.d().a(str3, "Rescheduling Workers.");
                bVar.d();
                iVar2.getClass();
                iVar2.f11695a.s().b(new d("reschedule_needed", 0L));
                return;
            }
            try {
                int i15 = Build.VERSION.SDK_INT >= 31 ? 570425344 : 536870912;
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
                intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
                PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i15);
                if (broadcast != null) {
                    broadcast.cancel();
                }
                historicalProcessExitReasons = ((ActivityManager) context.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
            } catch (IllegalArgumentException | SecurityException e10) {
                if (((j.a) j.d()).f9274c <= 5) {
                    Log.w(str3, "Ignoring exception", e10);
                }
            }
            if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                Long lI2 = iVar.f11695a.s().i("last_force_stop_ms");
                long jLongValue = lI2 != null ? lI2.longValue() : 0L;
                for (i10 = 0; i10 < historicalProcessExitReasons.size(); i10++) {
                    ApplicationExitInfo applicationExitInfo = historicalProcessExitReasons.get(i10);
                    if (applicationExitInfo.getReason() == 10 && applicationExitInfo.getTimestamp() >= jLongValue) {
                        j.d().a(str3, "Application was force-stopped, rescheduling.");
                        bVar.d();
                        aVar.f2817d.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        iVar.getClass();
                        iVar.f11695a.s().b(new d("last_force_stop_ms", Long.valueOf(jCurrentTimeMillis)));
                        return;
                    }
                }
            }
            if (z10) {
                j.d().a(str3, "Found unfinished work, scheduling it.");
                i2.j.b(aVar, workDatabase, bVar.f2881e);
            }
        } finally {
            workDatabase.k();
        }
    }

    public final boolean b() {
        androidx.work.a aVar = this.f2976b.f2878b;
        aVar.getClass();
        boolean zIsEmpty = TextUtils.isEmpty(null);
        String str = f2974e;
        if (zIsEmpty) {
            j.d().a(str, "The default process name was not specified.");
            return true;
        }
        boolean zA = r2.j.a(this.f2975a, aVar);
        j.d().a(str, "Is default app process = " + zA);
        return zA;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f2975a;
        String str = f2974e;
        androidx.work.impl.b bVar = this.f2976b;
        try {
            if (!b()) {
                return;
            }
            while (true) {
                try {
                    i2.p.a(context);
                    j.d().a(str, "Performing cleanup operations.");
                    try {
                        a();
                        return;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteFullException | SQLiteTableLockedException e10) {
                        int i10 = this.f2978d + 1;
                        this.f2978d = i10;
                        if (i10 >= 3) {
                            String str2 = ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked() ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                            j.d().c(str, str2, e10);
                            IllegalStateException illegalStateException = new IllegalStateException(str2, e10);
                            bVar.f2878b.getClass();
                            throw illegalStateException;
                        }
                        long j10 = i10 * 300;
                        String str3 = "Retrying after " + j10;
                        if (((j.a) j.d()).f9274c <= 3) {
                            Log.d(str, str3, e10);
                        }
                        try {
                            Thread.sleep(this.f2978d * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (SQLiteException e11) {
                    j.d().b(str, "Unexpected SQLite exception during migrations");
                    IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e11);
                    bVar.f2878b.getClass();
                    throw illegalStateException2;
                }
            }
        } finally {
            bVar.c();
        }
    }
}
