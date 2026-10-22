package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final class FullyDrawnReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f133h;

    public FullyDrawnReporter(Executor r10, Function0 r11) {
        kotlin.jvm.internal.q.g(r10, "executor");
        kotlin.jvm.internal.q.g(r11, "reportFullyDrawn");
        this.f126a = r10;
        this.f127b = r11;
        this.f128c = new Object();
        this.f132g = new ArrayList();
        this.f133h = new k(this);
    }

    public static /* synthetic */ void a(FullyDrawnReporter r10) {
        g(r10);
    }

    public static final void g(FullyDrawnReporter r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        Object r11 = r10.f128c;
        monitor-enter(r11);
        r10.f130e = false;     // Catch: Throwable -> L10
        if (r10.f129d == 0) goto L8;
    L12:
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L10
        monitor-exit(r11);
        return;
    L8:
        if (r10.f131f == true) goto L12;
        r10.f127b.invoke();     // Catch: Throwable -> L10
        r10.c();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final void b() {
        Object r10 = this.f128c;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f131f == true) goto L9;
        this.f129d++;     // Catch: Throwable -> L7
    L9:
        Unit r11 = Unit.f21064a;     // Catch: Throwable -> L7
        monitor-exit(r10);
    }

    public final void c() {
        Object r10 = this.f128c;
        monitor-enter(r10);
        this.f131f = true;     // Catch: Throwable -> L9
        Iterator r11 = this.f132g.iterator();     // Catch: Throwable -> L9
    L7:
        if (r11.hasNext() == false) goto L11;
        ((Function0) r11.next()).invoke();     // Catch: Throwable -> L9
        goto L7
    L11:
        this.f132g.clear();     // Catch: Throwable -> L9
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L9
        monitor-exit(r10);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final boolean d() {
        Object r10 = this.f128c;
        monitor-enter(r10);
        boolean r11 = this.f131f;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final void e() {
        if (this.f130e == false) goto L5;
        return;
    L5:
        if (this.f129d != 0) goto L9;
        this.f130e = true;
        this.f126a.execute(this.f133h);
        return;
    }

    public final void f() {
        Object r10 = this.f128c;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f131f == true) goto L11;
        int r11 = this.f129d;     // Catch: Throwable -> L9
        if (r11 <= 0) goto L11;
        this.f129d = r11 - 1;     // Catch: Throwable -> L9
        e();     // Catch: Throwable -> L9
    L11:
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L9
        monitor-exit(r10);
    }
}
