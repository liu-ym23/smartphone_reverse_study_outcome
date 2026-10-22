package C0;

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
import android.database.sqlite.SQLiteTableLockedException;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.A;
import androidx.room.E;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable$BroadcastReceiver;
import ch.qos.logback.core.joran.action.Action;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import s0.C0844b;
import s0.G;
import t0.C0913H;
import t0.J;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public static final String f296e = s0.t.f("ForceStopRunnable");

    /* renamed from: f, reason: collision with root package name */
    public static final long f297f = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: a, reason: collision with root package name */
    public final Context f298a;

    /* renamed from: b, reason: collision with root package name */
    public final C0913H f299b;

    /* renamed from: c, reason: collision with root package name */
    public final i f300c;

    /* renamed from: d, reason: collision with root package name */
    public int f301d = 0;

    public f(Context context, C0913H c0913h) {
        this.f298a = context.getApplicationContext();
        this.f299b = c0913h;
        this.f300c = c0913h.f15331h;
    }

    /* JADX WARN: Finally extract failed */
    public final void a() {
        boolean z4;
        List<ApplicationExitInfo> historicalProcessExitReasons;
        i iVar = this.f300c;
        C0913H c0913h = this.f299b;
        WorkDatabase workDatabase = c0913h.f15327d;
        String str = w0.b.f15798f;
        Context context = this.f298a;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        ArrayList arrayListC = w0.b.c(context, jobScheduler);
        B0.p pVar = (B0.p) workDatabase.d();
        pVar.getClass();
        E eD = E.d(0, "SELECT DISTINCT work_spec_id FROM SystemIdInfo");
        A a4 = pVar.f160a;
        a4.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(a4, eD);
        try {
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (true) {
                String string = null;
                if (!cursorH.moveToNext()) {
                    break;
                }
                if (!cursorH.isNull(0)) {
                    string = cursorH.getString(0);
                }
                arrayList.add(string);
            }
            HashSet hashSet = new HashSet(arrayListC != null ? arrayListC.size() : 0);
            if (arrayListC != null && !arrayListC.isEmpty()) {
                Iterator it = arrayListC.iterator();
                while (it.hasNext()) {
                    JobInfo jobInfo = (JobInfo) it.next();
                    B0.k kVarF = w0.b.f(jobInfo);
                    if (kVarF != null) {
                        hashSet.add(kVarF.f150a);
                    } else {
                        w0.b.b(jobScheduler, jobInfo.getId());
                    }
                }
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!hashSet.contains((String) it2.next())) {
                        s0.t.d().a(w0.b.f15798f, "Reconciling jobs");
                        z4 = true;
                        break;
                    }
                } else {
                    z4 = false;
                    break;
                }
            }
            if (z4) {
                workDatabase.beginTransaction();
                try {
                    B0.u uVarG = workDatabase.g();
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        uVarG.k((String) it3.next(), -1L);
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                } catch (Throwable th) {
                    throw th;
                }
            }
            workDatabase = c0913h.f15327d;
            B0.u uVarG2 = workDatabase.g();
            B0.p pVarF = workDatabase.f();
            workDatabase.beginTransaction();
            try {
                ArrayList arrayListE = uVarG2.e();
                boolean z5 = !arrayListE.isEmpty();
                if (z5) {
                    Iterator it4 = arrayListE.iterator();
                    while (it4.hasNext()) {
                        B0.r rVar = (B0.r) it4.next();
                        G g4 = G.f14153a;
                        String str2 = rVar.f167a;
                        uVarG2.o(g4, str2);
                        uVarG2.p(-512, str2);
                        uVarG2.k(str2, -1L);
                    }
                }
                A a5 = pVarF.f160a;
                a5.assertNotSuspendingTransaction();
                androidx.room.G g5 = pVarF.f163d;
                k0.j jVarAcquire = g5.acquire();
                a5.beginTransaction();
                try {
                    jVarAcquire.executeUpdateDelete();
                    a5.setTransactionSuccessful();
                    a5.endTransaction();
                    g5.release(jVarAcquire);
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    boolean z6 = z5 || z4;
                    Long lG = c0913h.f15331h.f306a.c().g("reschedule_needed");
                    String str3 = f296e;
                    if (lG != null && lG.longValue() == 1) {
                        s0.t.d().a(str3, "Rescheduling Workers.");
                        c0913h.g0();
                        i iVar2 = c0913h.f15331h;
                        iVar2.getClass();
                        Intrinsics.checkNotNullParameter("reschedule_needed", Action.KEY_ATTRIBUTE);
                        iVar2.f306a.c().j(new B0.d("reschedule_needed", 0L));
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
                        historicalProcessExitReasons = ((ActivityManager) context.getSystemService(PerfBinderHelper.EVENT_KIND_ACTIVITY)).getHistoricalProcessExitReasons(null, 0, 0);
                    } catch (IllegalArgumentException | SecurityException e4) {
                        if (s0.t.d().f14213a <= 5) {
                            Log.w(str3, "Ignoring exception", e4);
                        }
                    }
                    if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                        Long lG2 = iVar.f306a.c().g("last_force_stop_ms");
                        long jLongValue = lG2 != null ? lG2.longValue() : 0L;
                        for (int i4 = 0; i4 < historicalProcessExitReasons.size(); i4++) {
                            ApplicationExitInfo applicationExitInfo = historicalProcessExitReasons.get(i4);
                            if (applicationExitInfo.getReason() == 10 && applicationExitInfo.getTimestamp() >= jLongValue) {
                                s0.t.d().a(str3, "Application was force-stopped, rescheduling.");
                                c0913h.g0();
                                c0913h.f15326c.f14172c.getClass();
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                iVar.getClass();
                                iVar.f306a.c().j(new B0.d("last_force_stop_ms", Long.valueOf(jCurrentTimeMillis)));
                                return;
                            }
                        }
                    }
                    if (z6) {
                        s0.t.d().a(str3, "Found unfinished work, scheduling it.");
                        t0.w.b(c0913h.f15326c, c0913h.f15327d, c0913h.f15329f);
                    }
                } catch (Throwable th2) {
                    a5.endTransaction();
                    g5.release(jVarAcquire);
                    throw th2;
                }
            } finally {
                workDatabase.endTransaction();
            }
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    public final boolean b() {
        C0844b configuration = this.f299b.f15326c;
        configuration.getClass();
        boolean zIsEmpty = TextUtils.isEmpty(null);
        String str = f296e;
        if (zIsEmpty) {
            s0.t.d().a(str, "The default process name was not specified.");
            return true;
        }
        int i4 = n.f308a;
        Context context = this.f298a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        boolean zAreEqual = Intrinsics.areEqual(a.f286a.a(), context.getApplicationInfo().processName);
        s0.t.d().a(str, "Is default app process = " + zAreEqual);
        return zAreEqual;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f298a;
        String str = f296e;
        C0913H c0913h = this.f299b;
        try {
            if (!b()) {
                return;
            }
            while (true) {
                try {
                    J.A(context);
                    s0.t.d().a(str, "Performing cleanup operations.");
                    try {
                        a();
                        return;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e4) {
                        int i4 = this.f301d + 1;
                        this.f301d = i4;
                        if (i4 >= 3) {
                            String str2 = G.k.a(context) ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                            s0.t.d().c(str, str2, e4);
                            IllegalStateException illegalStateException = new IllegalStateException(str2, e4);
                            c0913h.f15326c.getClass();
                            throw illegalStateException;
                        }
                        long j4 = i4 * 300;
                        String str3 = "Retrying after " + j4;
                        if (s0.t.d().f14213a <= 3) {
                            Log.d(str, str3, e4);
                        }
                        try {
                            Thread.sleep(this.f301d * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (SQLiteException e5) {
                    s0.t.d().b(str, "Unexpected SQLite exception during migrations");
                    IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e5);
                    c0913h.f15326c.getClass();
                    throw illegalStateException2;
                }
            }
        } finally {
            c0913h.f0();
        }
    }
}
