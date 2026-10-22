package androidx.work.impl;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class q implements ExecutionListener, ForegroundProcessor {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f5756m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f5757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f5758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Configuration f5759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TaskExecutor f5760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WorkDatabase f5761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f5762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map f5763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map f5764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f5765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Set f5766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f5767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f5768l;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExecutionListener f5769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.work.impl.model.i f5770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ListenableFuture f5771c;

        public a(ExecutionListener r10, androidx.work.impl.model.i r11, ListenableFuture r12) {
            this.f5769a = r10;
            this.f5770b = r11;
            this.f5771c = r12;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            boolean r10 = ((Boolean) this.f5771c.get()).booleanValue();     // Catch: Throwable -> L4
        L5:
            this.f5769a.onExecuted(this.f5770b, r10);
            return;
        L4:
            r10 = true;
            goto L5
        }
    }

    static {
        f5756m = androidx.work.i.i("Processor");
    }

    public q(Context r10, Configuration r11, TaskExecutor r12, WorkDatabase r13, List r14) {
        this.f5758b = r10;
        this.f5759c = r11;
        this.f5760d = r12;
        this.f5761e = r13;
        this.f5763g = new HashMap();
        this.f5762f = new HashMap();
        this.f5765i = r14;
        this.f5766j = new HashSet();
        this.f5767k = new ArrayList();
        this.f5757a = null;
        this.f5768l = new Object();
        this.f5764h = new HashMap();
    }

    public static /* synthetic */ void a(q r10, androidx.work.impl.model.i r11, boolean r12) {
        r10.h(r11, r12);
    }

    public static /* synthetic */ androidx.work.impl.model.o b(q r10, ArrayList r11, String r12) {
        return r10.i(r11, r12);
    }

    public static boolean e(String r10, f0 r11) {
        if (r11 == null) goto L5;
        r11.g();
        androidx.work.i.e().a(f5756m, "WorkerWrapper interrupted for " + r10);
        return true;
    L5:
        androidx.work.i.e().a(f5756m, "WorkerWrapper could not be found for " + r10);
        return false;
    }

    public void c(ExecutionListener r10) {
        Object r11 = this.f5768l;
        monitor-enter(r11);
        this.f5767k.add(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public androidx.work.impl.model.o d(String r10) {
        Object r11 = this.f5768l;
        monitor-enter(r11);
        f0 r12 = (f0) this.f5762f.get(r10);     // Catch: Throwable -> L7
        if (r12 != null) goto L9;
        r12 = (f0) this.f5763g.get(r10);     // Catch: Throwable -> L7
    L9:
        if (r12 == null) goto L13;
        androidx.work.impl.model.o r13 = r12.e();     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r13;
    L13:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return null;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean f(String r10) {
        Object r11 = this.f5768l;
        monitor-enter(r11);
        boolean r12 = this.f5766j.contains(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean g(String r10) {
        Object r11 = this.f5768l;
        monitor-enter(r11);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f5763g.containsKey(r10) == false) goto L7;
    L12:
        boolean r12 = true;
    L13:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r12;
    L7:
        if (this.f5762f.containsKey(r10) == true) goto L12;
        r12 = false;
        goto L13
    }

    public final /* synthetic */ void h(androidx.work.impl.model.i r10, boolean r11) {
        onExecuted(r10, r11);
    }

    public final /* synthetic */ androidx.work.impl.model.o i(ArrayList r10, String r11) {
        r10.addAll(this.f5761e.M().getTagsForWorkSpecId(r11));
        return this.f5761e.L().getWorkSpec(r11);
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public boolean isEnqueuedInForeground(String r10) {
        Object r11 = this.f5768l;
        monitor-enter(r11);
        boolean r12 = this.f5762f.containsKey(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public void j(ExecutionListener r10) {
        Object r11 = this.f5768l;
        monitor-enter(r11);
        this.f5767k.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void k(final androidx.work.impl.model.i r10, final boolean r11) {
        this.f5760d.getMainThreadExecutor().execute(new p(this, r10, r11));
    }

    public boolean l(t r10) {
        return m(r10, null);
    }

    public boolean m(t r13, WorkerParameters.a r14) {
        androidx.work.impl.model.i r10 = r13.a();
        final String r11 = r10.b();
        final ArrayList r12 = new ArrayList();
        androidx.work.impl.model.o r15 = (androidx.work.impl.model.o) this.f5761e.C(new o(this, r12, r11));
        if (r15 != null) goto L6;
        androidx.work.i.e().k(f5756m, "Didn't find WorkSpec for id " + r10);
        k(r10, false);
        return false;
    L6:
        Object r16 = this.f5768l;
        monitor-enter(r16);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (g(r11) == false) goto L19;
        Set r17 = (Set) this.f5764h.get(r11);     // Catch: Throwable -> L13
        if (((t) r17.iterator().next()).a().a() != r10.a()) goto L15;
        r17.add(r13);     // Catch: Throwable -> L13
        androidx.work.i.e().a(f5756m, "Work " + r10 + " is already enqueued for processing");     // Catch: Throwable -> L13
    L16:
        monitor-exit(r16);     // Catch: Throwable -> L13
        return false;
    L15:
        k(r10, false);     // Catch: Throwable -> L13
        goto L16
    L19:
        if (r15.d() == r10.a()) goto L23;
        k(r10, false);     // Catch: Throwable -> L13
        monitor-exit(r16);     // Catch: Throwable -> L13
        return false;
    L23:
        f0 r18 = new f0.c(this.f5758b, this.f5759c, this.f5760d, this, this.f5761e, r15, r12).d(this.f5765i).c(r14).b();     // Catch: Throwable -> L13
        ListenableFuture r19 = r18.c();     // Catch: Throwable -> L13
        r19.addListener(new a(this, r13.a(), r19), this.f5760d.getMainThreadExecutor());     // Catch: Throwable -> L13
        this.f5763g.put(r11, r18);     // Catch: Throwable -> L13
        HashSet r20 = new HashSet();     // Catch: Throwable -> L13
        r20.add(r13);     // Catch: Throwable -> L13
        this.f5764h.put(r11, r20);     // Catch: Throwable -> L13
        monitor-exit(r16);     // Catch: Throwable -> L13
        this.f5760d.getSerialTaskExecutor().execute(r18);
        androidx.work.i.e().a(f5756m, getClass().getSimpleName() + ": processing " + r10);
        return true;
    }

    public boolean n(String r10) {
        Object r11 = this.f5768l;
        monitor-enter(r11);
        androidx.work.i.e().a(f5756m, "Processor cancelling " + r10);     // Catch: Throwable -> L10
        this.f5766j.add(r10);     // Catch: Throwable -> L10
        f0 r12 = (f0) this.f5762f.remove(r10);     // Catch: Throwable -> L10
        if (r12 == null) goto L7;
        boolean r13 = true;
    L8:
        if (r12 != null) goto L12;
        r12 = (f0) this.f5763g.remove(r10);     // Catch: Throwable -> L10
    L12:
        if (r12 == null) goto L14;
        this.f5764h.remove(r10);     // Catch: Throwable -> L10
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L10
        boolean r14 = e(r10, r12);
        if (r13 == false) goto L18;
        o();
    L18:
        return r14;
    L7:
        r13 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final void o() {
        Object r10 = this.f5768l;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f5762f.isEmpty() == false) goto L16;
        Intent r11 = SystemForegroundDispatcher.d(this.f5758b);     // Catch: Throwable -> L14
        this.f5758b.startService(r11);     // Catch: Throwable -> L9
    L11:
        PowerManager.WakeLock r12 = this.f5757a;     // Catch: Throwable -> L14
        if (r12 == null) goto L16;
        r12.release();     // Catch: Throwable -> L14
        this.f5757a = null;     // Catch: Throwable -> L14
        goto L16
    L9:
        th = move-exception;
        androidx.work.i.e().d(f5756m, "Unable to stop foreground service", th);     // Catch: Throwable -> L14
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L14
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(androidx.work.impl.model.i r10, boolean r11) {
        Object r12 = this.f5768l;
        monitor-enter(r12);
        f0 r13 = (f0) this.f5763g.get(r10.b());     // Catch: Throwable -> L9
        if (r13 != null) goto L7;
    L11:
        androidx.work.i.e().a(f5756m, getClass().getSimpleName() + " " + r10.b() + " executed; reschedule = " + r11);     // Catch: Throwable -> L9
        Iterator r14 = this.f5767k.iterator();     // Catch: Throwable -> L9
    L13:
        if (r14.hasNext() == false) goto L15;
        ((ExecutionListener) r14.next()).onExecuted(r10, r11);     // Catch: Throwable -> L9
        goto L13
    L15:
        monitor-exit(r12);     // Catch: Throwable -> L9
        return;
    L7:
        if (r10.equals(r13.d()) == false) goto L11;
        this.f5763g.remove(r10.b());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public boolean p(t r10) {
        String r11 = r10.a().b();
        Object r12 = this.f5768l;
        monitor-enter(r12);
        androidx.work.i.e().a(f5756m, "Processor stopping foreground work " + r11);     // Catch: Throwable -> L7
        f0 r13 = (f0) this.f5762f.remove(r11);     // Catch: Throwable -> L7
        if (r13 == null) goto L9;
        this.f5764h.remove(r11);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L7
        return e(r11, r13);
    L7:
        th = move-exception;
        throw th;
    }

    public boolean q(t r10) {
        String r11 = r10.a().b();
        Object r12 = this.f5768l;
        monitor-enter(r12);
        f0 r13 = (f0) this.f5763g.remove(r11);     // Catch: Throwable -> L9
        if (r13 != null) goto L11;
        androidx.work.i.e().a(f5756m, "WorkerWrapper could not be found for " + r11);     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        return false;
    L11:
        Set r14 = (Set) this.f5764h.get(r11);     // Catch: Throwable -> L9
        if (r14 != null) goto L14;
    L20:
        monitor-exit(r12);     // Catch: Throwable -> L9
        return false;
    L14:
        if (r14.contains(r10) == false) goto L20;
        androidx.work.i.e().a(f5756m, "Processor stopping background work " + r11);     // Catch: Throwable -> L9
        this.f5764h.remove(r11);     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        return e(r11, r13);
    L9:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void startForeground(String r10, androidx.work.d r11) {
        Object r12 = this.f5768l;
        monitor-enter(r12);
        androidx.work.i.e().f(f5756m, "Moving WorkSpec (" + r10 + ") to the foreground");     // Catch: Throwable -> L9
        f0 r13 = (f0) this.f5763g.remove(r10);     // Catch: Throwable -> L9
        if (r13 != null) goto L7;
    L12:
        monitor-exit(r12);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.f5757a != null) goto L11;
        PowerManager.WakeLock r14 = androidx.work.impl.utils.s.b(this.f5758b, "ProcessorForegroundLck");     // Catch: Throwable -> L9
        this.f5757a = r14;     // Catch: Throwable -> L9
        r14.acquire();     // Catch: Throwable -> L9
    L11:
        this.f5762f.put(r10, r13);     // Catch: Throwable -> L9
        ContextCompat.l(this.f5758b, SystemForegroundDispatcher.c(this.f5758b, r13.d(), r11));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void stopForeground(String r10) {
        Object r11 = this.f5768l;
        monitor-enter(r11);
        this.f5762f.remove(r10);     // Catch: Throwable -> L7
        o();     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
