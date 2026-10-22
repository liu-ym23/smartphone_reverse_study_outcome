package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.i;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.c0;
import androidx.work.impl.q;
import androidx.work.impl.u;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.s;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class SystemAlarmDispatcher implements ExecutionListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f5443k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskExecutor f5445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WorkTimer f5446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f5447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f5448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.work.impl.background.systemalarm.b f5449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f5450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Intent f5451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CommandsCompletedListener f5452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public u f5453j;

    public interface CommandsCompletedListener {
        void onAllCommandsCompleted();
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SystemAlarmDispatcher f5454a;

        public a(SystemAlarmDispatcher r10) {
            this.f5454a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            List r10 = this.f5454a.f5450g;
            monitor-enter(r10);
            SystemAlarmDispatcher r11 = this.f5454a;     // Catch: Throwable -> L19
            r11.f5451h = (Intent) r11.f5450g.get(0);     // Catch: Throwable -> L19
            monitor-exit(r10);     // Catch: Throwable -> L19
            Intent r12 = this.f5454a.f5451h;
            if (r12 == null) goto L18;
            String r13 = r12.getAction();
            int r14 = this.f5454a.f5451h.getIntExtra("KEY_START_ID", 0);
            i r15 = i.e();
            String r16 = SystemAlarmDispatcher.f5443k;
            r15.a(r16, "Processing command " + this.f5454a.f5451h + ", " + r14);
            PowerManager.WakeLock r17 = s.b(this.f5454a.f5444a, r13 + " (" + r14 + ")");
            i.e().a(r16, "Acquiring operation wake lock (" + r13 + ") " + r17);     // Catch: Throwable -> L12
            r17.acquire();     // Catch: Throwable -> L12
            SystemAlarmDispatcher r18 = this.f5454a;     // Catch: Throwable -> L12
            r18.f5449f.n(r18.f5451h, r14, r18);     // Catch: Throwable -> L12
            i.e().a(r16, "Releasing operation wake lock (" + r13 + ") " + r17);
            r17.release();
            Executor r19 = this.f5454a.f5445b.getMainThreadExecutor();
            c r20 = new c(this.f5454a);
        L11:
            r19.execute(r20);
            return;
        L12:
            th = move-exception;
            i r21 = i.e();     // Catch: Throwable -> L15
            String r22 = SystemAlarmDispatcher.f5443k;     // Catch: Throwable -> L15
            r21.d(r22, "Unexpected error in onHandleIntent", th);     // Catch: Throwable -> L15
            i.e().a(r22, "Releasing operation wake lock (" + r13 + ") " + r17);
            r17.release();
            r19 = this.f5454a.f5445b.getMainThreadExecutor();
            r20 = new c(this.f5454a);
        L15:
            th = move-exception;
            i.e().a(SystemAlarmDispatcher.f5443k, "Releasing operation wake lock (" + r13 + ") " + r17);
            r17.release();
            this.f5454a.f5445b.getMainThreadExecutor().execute(new c(this.f5454a));
            throw th;
        L18:
            return;
        L19:
            th = move-exception;
            throw th;
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SystemAlarmDispatcher f5455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Intent f5456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5457c;

        public b(SystemAlarmDispatcher r10, Intent r11, int r12) {
            this.f5455a = r10;
            this.f5456b = r11;
            this.f5457c = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5455a.a(this.f5456b, this.f5457c);
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SystemAlarmDispatcher f5458a;

        public c(SystemAlarmDispatcher r10) {
            this.f5458a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5458a.c();
        }
    }

    static {
        f5443k = i.i("SystemAlarmDispatcher");
    }

    public SystemAlarmDispatcher(Context r10) {
        this(r10, null, null);
    }

    public boolean a(Intent r10, int r11) {
        i r12 = i.e();
        String r13 = f5443k;
        r12.a(r13, "Adding command " + r10 + " (" + r11 + ")");
        b();
        String r14 = r10.getAction();
        if (TextUtils.isEmpty(r14) == false) goto L7;
        i.e().k(r13, "Unknown command. Ignoring");
        return false;
    L7:
        if ("ACTION_CONSTRAINTS_CHANGED".equals(r14) == true) goto L9;
    L11:
        r10.putExtra("KEY_START_ID", r11);
        List r15 = this.f5450g;
        monitor-enter(r15);
        boolean r16 = this.f5450g.isEmpty();     // Catch: Throwable -> L16
        this.f5450g.add(r10);     // Catch: Throwable -> L16
        if (r16 == false) goto L18;
        j();     // Catch: Throwable -> L16
    L18:
        monitor-exit(r15);     // Catch: Throwable -> L16
        return true;
    L16:
        th = move-exception;
        throw th;
    L9:
        if (h("ACTION_CONSTRAINTS_CHANGED") == false) goto L11;
        return false;
    }

    public final void b() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Needs to be invoked on the main thread.");
    }

    public void c() {
        i r10 = i.e();
        String r11 = f5443k;
        r10.a(r11, "Checking if commands are complete.");
        b();
        List r12 = this.f5450g;
        monitor-enter(r12);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f5451h == null) goto L13;
        i.e().a(r11, "Removing command " + this.f5451h);     // Catch: Throwable -> L9
        if (((Intent) this.f5450g.remove(0)).equals(this.f5451h) == false) goto L12;
        this.f5451h = null;     // Catch: Throwable -> L9
        goto L13
    L12:
        throw new IllegalStateException("Dequeue-d command is not the first.");     // Catch: Throwable -> L9
    L13:
        SerialExecutor r13 = this.f5445b.getSerialTaskExecutor();     // Catch: Throwable -> L9
        if (this.f5449f.m() == true) goto L23;
        if (this.f5450g.isEmpty() == false) goto L23;
        if (r13.hasPendingTasks() == true) goto L23;
        i.e().a(r11, "No more commands & intents.");     // Catch: Throwable -> L9
        CommandsCompletedListener r14 = this.f5452i;     // Catch: Throwable -> L9
        if (r14 == null) goto L25;
        r14.onAllCommandsCompleted();     // Catch: Throwable -> L9
    L25:
        monitor-exit(r12);     // Catch: Throwable -> L9
        return;
    L23:
        if (this.f5450g.isEmpty() == true) goto L25;
        j();     // Catch: Throwable -> L9
        goto L25
    }

    public q d() {
        return this.f5447d;
    }

    public TaskExecutor e() {
        return this.f5445b;
    }

    public c0 f() {
        return this.f5448e;
    }

    public WorkTimer g() {
        return this.f5446c;
    }

    public final boolean h(String r10) {
        b();
        List r11 = this.f5450g;
        monitor-enter(r11);
        Iterator r12 = this.f5450g.iterator();     // Catch: Throwable -> L12
    L6:
        if (r12.hasNext() == false) goto L14;
        if (r10.equals(((Intent) r12.next()).getAction()) == false) goto L6;
        monitor-exit(r11);     // Catch: Throwable -> L12
        return true;
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    public void i() {
        i.e().a(f5443k, "Destroying SystemAlarmDispatcher");
        this.f5447d.j(this);
        this.f5452i = null;
    }

    public final void j() {
        b();
        PowerManager.WakeLock r10 = s.b(this.f5444a, "ProcessCommand");
        r10.acquire();     // Catch: Throwable -> L6
        this.f5448e.r().executeOnTaskThread(new a(this));     // Catch: Throwable -> L6
        r10.release();
        return;
    L6:
        th = move-exception;
        r10.release();
        throw th;
    }

    public void k(CommandsCompletedListener r10) {
        if (this.f5452i == null) goto L6;
        i.e().c(f5443k, "A completion listener for SystemAlarmDispatcher already exists.");
        return;
    L6:
        this.f5452i = r10;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(androidx.work.impl.model.i r10, boolean r11) {
        this.f5445b.getMainThreadExecutor().execute(new b(this, androidx.work.impl.background.systemalarm.b.c(this.f5444a, r10, r11), 0));
    }

    public SystemAlarmDispatcher(Context r10, q r11, c0 r12) {
        Context r13 = r10.getApplicationContext();
        this.f5444a = r13;
        this.f5453j = new u();
        this.f5449f = new androidx.work.impl.background.systemalarm.b(r13, this.f5453j);
        if (r12 != null) goto L6;
        r12 = c0.l(r10);
    L6:
        this.f5448e = r12;
        this.f5446c = new WorkTimer(r12.j().k());
        if (r11 != null) goto L10;
        r11 = r12.n();
    L10:
        this.f5447d = r11;
        this.f5445b = r12.r();
        r11.c(this);
        this.f5450g = new ArrayList();
        this.f5451h = null;
    }
}
