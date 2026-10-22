package q5;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.x;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.utils.ForceStopRunnable$BroadcastReceiver;
import g5.u;
import h5.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import p5.p;
import p5.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements Runnable {
    public static final String i = u.f("ForceStopRunnable");

    /* renamed from: j, reason: collision with root package name */
    public static final long f10076j = 315360000000L;

    /* renamed from: c, reason: collision with root package name */
    public Context f10077c;

    /* renamed from: f, reason: collision with root package name */
    public r f10078f;

    /* renamed from: g, reason: collision with root package name */
    public a2.i f10079g;

    /* renamed from: h, reason: collision with root package name */
    public int f10080h;

    /* JADX WARN: Finally extract failed */
    public final void a() {
        int i3;
        boolean z10;
        int i10;
        List<ApplicationExitInfo> historicalProcessExitReasons;
        a2.i iVar = this.f10079g;
        Context context = this.f10077c;
        r rVar = this.f10078f;
        g5.a aVar = rVar.f5371b;
        a2.i iVar2 = rVar.f5376g;
        WorkDatabase workDatabase = rVar.f5372c;
        String str = k5.c.f7248j;
        JobScheduler jobSchedulerA = k5.a.a(context);
        ArrayList arrayListE = k5.c.e(context, jobSchedulerA);
        p5.i iVarZ = workDatabase.z();
        iVarZ.getClass();
        x xVarD = x.d(0, "SELECT DISTINCT work_spec_id FROM SystemIdInfo");
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) iVarZ.f9730c;
        workDatabase_Impl.b();
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
        try {
            ArrayList arrayList = new ArrayList(cursorD.getCount());
            while (cursorD.moveToNext()) {
                arrayList.add(cursorD.getString(0));
            }
            HashSet hashSet = new HashSet(arrayListE != null ? arrayListE.size() : 0);
            if (arrayListE != null && !arrayListE.isEmpty()) {
                int size = arrayListE.size();
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayListE.get(i11);
                    i11++;
                    JobInfo jobInfo = (JobInfo) obj;
                    p5.j jVarF = k5.c.f(jobInfo);
                    if (jVarF != null) {
                        hashSet.add(jVarF.f9734a);
                    } else {
                        k5.c.a(jobSchedulerA, jobInfo.getId());
                    }
                }
            }
            int size2 = arrayList.size();
            int i12 = 0;
            while (true) {
                i3 = 1;
                if (i12 >= size2) {
                    z10 = false;
                    break;
                }
                Object obj2 = arrayList.get(i12);
                i12++;
                if (!hashSet.contains((String) obj2)) {
                    u.d().a(k5.c.f7248j, "Reconciling jobs");
                    z10 = true;
                    break;
                }
            }
            if (z10) {
                workDatabase.c();
                try {
                    s sVarC = workDatabase.C();
                    int size3 = arrayList.size();
                    int i13 = 0;
                    while (i13 < size3) {
                        Object obj3 = arrayList.get(i13);
                        i13++;
                        sVarC.l((String) obj3, -1L);
                    }
                    workDatabase.v();
                    workDatabase.q();
                } catch (Throwable th) {
                    throw th;
                }
            }
            s sVarC2 = workDatabase.C();
            p5.m mVarB = workDatabase.B();
            workDatabase.c();
            try {
                ArrayList arrayListG = sVarC2.g();
                boolean zIsEmpty = arrayListG.isEmpty();
                if (!zIsEmpty) {
                    int size4 = arrayListG.size();
                    int i14 = 0;
                    while (i14 < size4) {
                        Object obj4 = arrayListG.get(i14);
                        i14++;
                        String str2 = ((p) obj4).f9764a;
                        sVarC2.p(i3, str2);
                        sVarC2.q(-512, str2);
                        sVarC2.l(str2, -1L);
                        arrayListG = arrayListG;
                        zIsEmpty = zIsEmpty;
                        i3 = 1;
                    }
                }
                boolean z11 = zIsEmpty;
                WorkDatabase_Impl workDatabase_Impl2 = (WorkDatabase_Impl) mVarB.f9741f;
                workDatabase_Impl2.b();
                p5.h hVar = (p5.h) mVarB.f9743h;
                z4.j jVarA = hVar.a();
                try {
                    workDatabase_Impl2.c();
                    try {
                        jVarA.d();
                        workDatabase_Impl2.v();
                        hVar.c(jVarA);
                        workDatabase.v();
                        workDatabase.q();
                        boolean z12 = !z11 || z10;
                        Long lI = ((WorkDatabase) iVar2.f49f).y().i("reschedule_needed");
                        String str3 = i;
                        if (lI != null && lI.longValue() == 1) {
                            u.d().a(str3, "Rescheduling Workers.");
                            rVar.e();
                            iVar2.getClass();
                            p5.d dVar = new p5.d();
                            dVar.f9719a = "reschedule_needed";
                            dVar.f9720b = 0L;
                            ((WorkDatabase) iVar2.f49f).y().j(dVar);
                            return;
                        }
                        try {
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(context, (Class<?>) ForceStopRunnable$BroadcastReceiver.class));
                            intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
                            PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, 570425344);
                            if (broadcast != null) {
                                broadcast.cancel();
                            }
                            historicalProcessExitReasons = ((ActivityManager) context.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                        } catch (IllegalArgumentException | SecurityException e10) {
                            if (u.d().f4344a <= 5) {
                                Log.w(str3, "Ignoring exception", e10);
                            }
                        }
                        if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                            Long lI2 = ((WorkDatabase) iVar.f49f).y().i("last_force_stop_ms");
                            long jLongValue = lI2 != null ? lI2.longValue() : 0L;
                            for (i10 = 0; i10 < historicalProcessExitReasons.size(); i10++) {
                                ApplicationExitInfo applicationExitInfo = historicalProcessExitReasons.get(i10);
                                if (applicationExitInfo.getReason() == 10 && applicationExitInfo.getTimestamp() >= jLongValue) {
                                    u.d().a(str3, "Application was force-stopped, rescheduling.");
                                    rVar.e();
                                    aVar.f4271d.getClass();
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    iVar.getClass();
                                    Long lValueOf = Long.valueOf(jCurrentTimeMillis);
                                    p5.d dVar2 = new p5.d();
                                    dVar2.f9719a = "last_force_stop_ms";
                                    dVar2.f9720b = lValueOf;
                                    ((WorkDatabase) iVar.f49f).y().j(dVar2);
                                    return;
                                }
                            }
                        }
                        if (z12) {
                            u.d().a(str3, "Found unfinished work, scheduling it.");
                            h5.i.b(aVar, workDatabase, rVar.f5374e);
                        }
                    } finally {
                        workDatabase_Impl2.q();
                    }
                } catch (Throwable th2) {
                    hVar.c(jVarA);
                    throw th2;
                }
            } finally {
                workDatabase.q();
            }
        } finally {
            cursorD.close();
            xVarD.e();
        }
    }

    public final boolean b() {
        g5.a aVar = this.f10078f.f5371b;
        aVar.getClass();
        boolean zIsEmpty = TextUtils.isEmpty(null);
        String str = i;
        if (zIsEmpty) {
            u.d().a(str, "The default process name was not specified.");
            return true;
        }
        boolean zA = f.a(this.f10077c, aVar);
        u.d().a(str, "Is default app process = " + zA);
        return zA;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f10077c;
        String str = i;
        r rVar = this.f10078f;
        g5.a aVar = rVar.f5371b;
        try {
            if (!b()) {
                return;
            }
            while (true) {
                try {
                    ac.a.G(context);
                    u.d().a(str, "Performing cleanup operations.");
                    try {
                        a();
                        return;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteFullException | SQLiteTableLockedException e10) {
                        int i3 = this.f10080h + 1;
                        this.f10080h = i3;
                        if (i3 >= 3) {
                            String str2 = ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked() ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                            u.d().c(str, str2, e10);
                            IllegalStateException illegalStateException = new IllegalStateException(str2, e10);
                            aVar.getClass();
                            throw illegalStateException;
                        }
                        long j10 = i3 * 300;
                        String str3 = "Retrying after " + j10;
                        if (u.d().f4344a <= 3) {
                            Log.d(str, str3, e10);
                        }
                        try {
                            Thread.sleep(this.f10080h * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (SQLiteException e11) {
                    u.d().b(str, "Unexpected SQLite exception during migrations");
                    IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e11);
                    aVar.getClass();
                    throw illegalStateException2;
                }
            }
        } finally {
            rVar.d();
        }
    }
}
