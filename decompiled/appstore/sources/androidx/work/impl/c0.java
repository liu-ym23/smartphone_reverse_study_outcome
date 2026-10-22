package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.work.Configuration;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Operation;
import androidx.work.R$bool;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class c0 extends WorkManager {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f5501k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static c0 f5502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static c0 f5503m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f5504n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Configuration f5506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WorkDatabase f5507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TaskExecutor f5508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f5509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q f5510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.work.impl.utils.m f5511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f5513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.work.impl.constraints.trackers.m f5514j;

    public static class a {
        @DoNotInline
        public static boolean a(Context r10) {
            return r10.isDeviceProtectedStorage();
        }
    }

    static {
        f5501k = androidx.work.i.i("WorkManagerImpl");
        f5502l = null;
        f5503m = null;
        f5504n = new Object();
    }

    public c0(Context r10, Configuration r11, TaskExecutor r12) {
        this(r10, r11, r12, r10.getResources().getBoolean(R$bool.workmanager_test_configuration));
    }

    public static void f(Context r10, Configuration r11) {
        Object r12 = f5504n;
        monitor-enter(r12);
        c0 r13 = f5502l;     // Catch: Throwable -> L11
        if (r13 != null) goto L7;
    L13:
        if (r13 != null) goto L18;
        Context r14 = r10.getApplicationContext();     // Catch: Throwable -> L11
        if (f5503m != null) goto L17;
        f5503m = new c0(r14, r11, new androidx.work.impl.utils.taskexecutor.a(r11.m()));     // Catch: Throwable -> L11
    L17:
        f5502l = f5503m;     // Catch: Throwable -> L11
    L18:
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L7:
        if (f5503m == null) goto L13;
        throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static c0 k() {
        Object r10 = f5504n;
        monitor-enter(r10);
        c0 r11 = f5502l;     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return r11;
    L10:
        c0 r12 = f5503m;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c0 l(Context r10) {
        Object r11 = f5504n;
        monitor-enter(r11);
        c0 r12 = k();     // Catch: Throwable -> L9
        if (r12 != null) goto L13;
        Context r13 = r10.getApplicationContext();     // Catch: Throwable -> L9
        if ((r13 instanceof Configuration.Provider) == false) goto L12;
        f(r13, ((Configuration.Provider) r13).getWorkManagerConfiguration());     // Catch: Throwable -> L9
        r12 = l(r13);     // Catch: Throwable -> L9
        goto L13
    L12:
        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");     // Catch: Throwable -> L9
    L13:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return r12;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.WorkManager
    public Operation b(List r10) {
        if (r10.isEmpty() == true) goto L7;
        return new v(this, r10).a();
    L7:
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @Override // androidx.work.WorkManager
    public Operation d(String r10, ExistingWorkPolicy r11, List r12) {
        return new v(this, r10, r11, r12).a();
    }

    public Operation g(UUID r10) {
        androidx.work.impl.utils.b r11 = androidx.work.impl.utils.b.b(r10, this);
        this.f5508d.executeOnTaskThread(r11);
        return r11.d();
    }

    public List h(Context r10, Configuration r11, androidx.work.impl.constraints.trackers.m r12) {
        return Arrays.asList(new Scheduler[]{s.a(r10, this), new l0.b(r10, r11, r12, this)});
    }

    public Context i() {
        return this.f5505a;
    }

    public Configuration j() {
        return this.f5506b;
    }

    public androidx.work.impl.utils.m m() {
        return this.f5511g;
    }

    public q n() {
        return this.f5510f;
    }

    public List o() {
        return this.f5509e;
    }

    public androidx.work.impl.constraints.trackers.m p() {
        return this.f5514j;
    }

    public WorkDatabase q() {
        return this.f5507c;
    }

    public TaskExecutor r() {
        return this.f5508d;
    }

    public final void s(Context r10, Configuration r11, TaskExecutor r12, WorkDatabase r13, List r14, q r15) {
        Context r16 = r10.getApplicationContext();
        this.f5505a = r16;
        this.f5506b = r11;
        this.f5508d = r12;
        this.f5507c = r13;
        this.f5509e = r14;
        this.f5510f = r15;
        this.f5511g = new androidx.work.impl.utils.m(r13);
        this.f5512h = false;
        if (a.a(r16) == true) goto L7;
        this.f5508d.executeOnTaskThread(new ForceStopRunnable(r16, this));
        return;
    L7:
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public void t() {
        Object r10 = f5504n;
        monitor-enter(r10);
        this.f5512h = true;     // Catch: Throwable -> L8
        BroadcastReceiver.PendingResult r11 = this.f5513i;     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        r11.finish();     // Catch: Throwable -> L8
        this.f5513i = null;     // Catch: Throwable -> L8
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void u() {
        androidx.work.impl.background.systemjob.b.a(i());
        q().L().resetScheduledState();
        s.b(j(), q(), o());
    }

    public void v(BroadcastReceiver.PendingResult r10) {
        Object r11 = f5504n;
        monitor-enter(r11);
        BroadcastReceiver.PendingResult r12 = this.f5513i;     // Catch: Throwable -> L7
        if (r12 == null) goto L9;
        r12.finish();     // Catch: Throwable -> L7
    L9:
        this.f5513i = r10;     // Catch: Throwable -> L7
        if (this.f5512h == false) goto L12;
        r10.finish();     // Catch: Throwable -> L7
        this.f5513i = null;     // Catch: Throwable -> L7
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void w(t r10) {
        x(r10, null);
    }

    public void x(t r10, WorkerParameters.a r11) {
        this.f5508d.executeOnTaskThread(new androidx.work.impl.utils.p(this, r10, r11));
    }

    public void y(androidx.work.impl.model.i r10) {
        this.f5508d.executeOnTaskThread(new androidx.work.impl.utils.q(this, new t(r10), true));
    }

    public void z(t r10) {
        this.f5508d.executeOnTaskThread(new androidx.work.impl.utils.q(this, r10, false));
    }

    public c0(Context r10, Configuration r11, TaskExecutor r12, boolean r13) {
        this(r10, r11, r12, WorkDatabase.F(r10.getApplicationContext(), r12.getSerialTaskExecutor(), r13));
    }

    public c0(Context r10, Configuration r11, TaskExecutor r12, WorkDatabase r13) {
        Context r14 = r10.getApplicationContext();
        androidx.work.i.h(new androidx.work.i.a(r11.j()));
        androidx.work.impl.constraints.trackers.m r15 = new androidx.work.impl.constraints.trackers.m(r14, r12);
        this.f5514j = r15;
        List r16 = h(r14, r11, r15);
        s(r10, r11, r12, r13, r16, new q(r10, r11, r12, r13, r16));
    }
}
