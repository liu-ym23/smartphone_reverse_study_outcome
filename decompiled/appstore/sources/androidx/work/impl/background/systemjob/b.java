package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import androidx.core.util.Consumer;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.i;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.c0;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.f;
import androidx.work.impl.model.h;
import androidx.work.impl.model.o;
import androidx.work.impl.model.q;
import androidx.work.impl.utils.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class b implements Scheduler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5495e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JobScheduler f5497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f5498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f5499d;

    static {
        f5495e = i.i("SystemJobScheduler");
    }

    public b(Context r10, c0 r11) {
        this(r10, r11, (JobScheduler) r10.getSystemService("jobscheduler"), new a(r10));
    }

    public static void a(Context r10) {
        JobScheduler r11 = (JobScheduler) r10.getSystemService("jobscheduler");
        if (r11 == null) goto L12;
        List r12 = d(r10, r11);
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.isEmpty() == true) goto L15;
        Iterator r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L16;
        b(r11, ((JobInfo) r13.next()).getId());
        goto L10
    L16:
        return;
    L15:
        return;
    }

    public static void b(JobScheduler r10, int r11) {
        r10.cancel(r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        i.e().d(f5495e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(r11)}), th);
    }

    public static List c(Context r10, JobScheduler r11, String r12) {
        List r13 = d(r10, r11);
        if (r13 != null) goto L6;
        return null;
    L6:
        ArrayList r14 = new ArrayList(2);
        Iterator r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L14;
        JobInfo r16 = (JobInfo) r15.next();
        androidx.work.impl.model.i r17 = e(r16);
        if (r17 == null) goto L8;
        if (r12.equals(r17.b()) == false) goto L8;
        r14.add(Integer.valueOf(r16.getId()));
        goto L8
    L14:
        return r14;
    }

    public static List d(Context r10, JobScheduler r11) {
        List<JobInfo> r12 = r11.getAllPendingJobs();     // Catch: Throwable -> L5
    L7:
        if (r12 != null) goto L9;
        return null;
    L9:
        ArrayList r13 = new ArrayList(r12.size());
        ComponentName r14 = new ComponentName(r10, SystemJobService.class);
        Iterator<JobInfo> r15 = r12.iterator();
    L11:
        if (r15.hasNext() == false) goto L15;
        JobInfo r16 = r15.next();
        if (r14.equals(r16.getService()) == false) goto L11;
        r13.add(r16);
        goto L11
    L15:
        return r13;
    L5:
        th = move-exception;
        i.e().d(f5495e, "getAllPendingJobs() is not reliable on this device.", th);
        r12 = null;
        goto L7
    }

    public static androidx.work.impl.model.i e(JobInfo r10) {
        PersistableBundle r11 = r10.getExtras();
        if (r11 != null) goto L11;
        return null;
    L11:
        if (r11.containsKey("EXTRA_WORK_SPEC_ID") == false) goto L13;
        int r12 = r11.getInt("EXTRA_WORK_SPEC_GENERATION", 0);     // Catch: NullPointerException -> L10
        return new androidx.work.impl.model.i(r11.getString("EXTRA_WORK_SPEC_ID"), r12);
    L13:
        return null;
    L14:
        return null;
    }

    public static boolean f(Context r10, c0 r11) {
        JobScheduler r12 = (JobScheduler) r10.getSystemService("jobscheduler");
        List r13 = d(r10, r12);
        List<String> r14 = r11.q().I().getWorkSpecIds();
        boolean r15 = false;
        if (r13 == null) goto L5;
        int r16 = r13.size();
    L6:
        HashSet r17 = new HashSet(r16);
        if (r13 != null) goto L9;
    L17:
        Iterator<String> r18 = r14.iterator();
    L19:
        if (r18.hasNext() == false) goto L23;
        if (r17.contains(r18.next()) == true) goto L19;
        i.e().a(f5495e, "Reconciling jobs");
        r15 = true;
    L23:
        if (r15 == false) goto L35;
        WorkDatabase r19 = r11.q();
        r19.e();
        WorkSpecDao r20 = r19.L();     // Catch: Throwable -> L29
        Iterator<String> r21 = r14.iterator();     // Catch: Throwable -> L29
    L27:
        if (r21.hasNext() == false) goto L31;
        r20.markWorkSpecScheduled(r21.next(), -1);     // Catch: Throwable -> L29
        goto L27
    L31:
        r19.D();     // Catch: Throwable -> L29
        r19.i();
    L29:
        th = move-exception;
        r19.i();
        throw th;
    L35:
        return r15;
    L9:
        if (r13.isEmpty() == true) goto L17;
        Iterator r22 = r13.iterator();
    L12:
        if (r22.hasNext() == false) goto L17;
        JobInfo r23 = (JobInfo) r22.next();
        androidx.work.impl.model.i r24 = e(r23);
        if (r24 != null) goto L15;
        b(r12, r23.getId());
        goto L12
    L15:
        r17.add(r24.b());
        goto L12
    L5:
        r16 = 0;
        goto L6
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(String r10) {
        List r11 = c(this.f5496a, this.f5497b, r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L14;
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        int r13 = ((Integer) r12.next()).intValue();
        b(this.f5497b, r13);
        goto L8
    L10:
        this.f5498c.q().I().removeSystemIdInfo(r10);
        return;
    }

    public void g(o r10, int r11) {
        JobInfo r12 = this.f5499d.a(r10, r11);
        i r13 = i.e();
        String r14 = f5495e;
        r13.a(r14, "Scheduling work ID " + r10.f5670a + "Job ID " + r11);
        int r15 = 0;
    L13:
        e = move-exception;
        List r16 = d(this.f5496a, this.f5497b);
        if (r16 == null) goto L19;
        r15 = r16.size();
    L19:
        String r17 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(r15), Integer.valueOf(this.f5498c.q().L().getScheduledWork().size()), Integer.valueOf(this.f5498c.j().h())});
        i.e().c(f5495e, r17);
        IllegalStateException r18 = new IllegalStateException(r17, e);
        Consumer r19 = this.f5498c.j().l();
        if (r19 == null) goto L23;
        r19.accept(r18);
        return;
    L23:
        throw r18;
    L11:
        th = move-exception;
        i.e().d(f5495e, "Unable to schedule " + r10, th);
        return;
    L4:
        if (this.f5497b.schedule(r12) != 0) goto L26;
        i.e().k(r14, "Unable to schedule work ID " + r10.f5670a);     // Catch: Throwable -> L11 IllegalStateException -> L13
        if (r10.f5686q == true) goto L8;
        return;
    L8:
        if (r10.f5687r != OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) goto L28;
        r10.f5686q = false;     // Catch: Throwable -> L11 IllegalStateException -> L13
        i.e().a(r14, String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{r10.f5670a}));     // Catch: Throwable -> L11 IllegalStateException -> L13
        g(r10, r11);     // Catch: Throwable -> L11 IllegalStateException -> L13
    L30:
        return;
    L28:
        return;
    }

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(o... r10) {
        WorkDatabase r11 = this.f5498c.q();
        g r12 = new g(r11);
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L26;
        o r15 = r10[r14];
        r11.e();
        o r16 = r11.L().getWorkSpec(r15.f5670a);     // Catch: Throwable -> L10
        if (r16 != null) goto L13;
        i.e().k(f5495e, "Skipping scheduling " + r15.f5670a + " because it's no longer in the DB");     // Catch: Throwable -> L10
        r11.D();     // Catch: Throwable -> L10
    L9:
        r11.i();
        r14 = r14 + 1;
        goto L3
    L13:
        if (r16.f5671b == WorkInfo.State.ENQUEUED) goto L15;
        i.e().k(f5495e, "Skipping scheduling " + r15.f5670a + " because it is no longer enqueued");     // Catch: Throwable -> L10
        r11.D();     // Catch: Throwable -> L10
        goto L9
    L15:
        androidx.work.impl.model.i r17 = q.a(r15);     // Catch: Throwable -> L10
        f r18 = r11.I().getSystemIdInfo(r17);     // Catch: Throwable -> L10
        if (r18 == null) goto L18;
        int r19 = r18.f5643c;     // Catch: Throwable -> L10
    L19:
        if (r18 != null) goto L21;
        this.f5498c.q().I().insertSystemIdInfo(h.a(r17, r19));     // Catch: Throwable -> L10
    L21:
        g(r15, r19);     // Catch: Throwable -> L10
        r11.D();     // Catch: Throwable -> L10
        goto L9
    L18:
        r19 = r12.e(this.f5498c.j().i(), this.f5498c.j().g());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r11.i();
        throw th;
    }

    public b(Context r10, c0 r11, JobScheduler r12, a r13) {
        this.f5496a = r10;
        this.f5498c = r11;
        this.f5497b = r12;
        this.f5499d = r13;
    }
}
