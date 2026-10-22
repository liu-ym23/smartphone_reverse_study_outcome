package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskExecutor f5539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f5540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f5542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f5543e;

    public g(Context r10, TaskExecutor r11) {
        q.g(r10, "context");
        q.g(r11, "taskExecutor");
        this.f5539a = r11;
        Context r12 = r10.getApplicationContext();
        q.f(r12, "context.applicationContext");
        this.f5540b = r12;
        this.f5541c = new Object();
        this.f5542d = new LinkedHashSet();
    }

    public static /* synthetic */ void a(List r10, g r11) {
        b(r10, r11);
    }

    public static final void b(List r10, g r11) {
        q.g(r10, "$listenersList");
        q.g(r11, "this$0");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((ConstraintListener) r12.next()).onConstraintChanged(r11.f5543e);
        goto L4
    }

    public final void c(ConstraintListener r10) {
        q.g(r10, "listener");
        Object r11 = this.f5541c;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f5542d.add(r10) == true) goto L7;
    L12:
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L9
        monitor-exit(r11);
        return;
    L7:
        if (this.f5542d.size() != 1) goto L11;
        this.f5543e = e();     // Catch: Throwable -> L9
        androidx.work.i.e().a(h.a(), getClass().getSimpleName() + ": initial state = " + this.f5543e);     // Catch: Throwable -> L9
        h();     // Catch: Throwable -> L9
    L11:
        r10.onConstraintChanged(this.f5543e);     // Catch: Throwable -> L9
        goto L12
    }

    public final Context d() {
        return this.f5540b;
    }

    public abstract Object e();

    public final void f(ConstraintListener r10) {
        q.g(r10, "listener");
        Object r11 = this.f5541c;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f5542d.remove(r10) == true) goto L7;
    L11:
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L9
        monitor-exit(r11);
        return;
    L7:
        if (this.f5542d.isEmpty() == false) goto L11;
        i();     // Catch: Throwable -> L9
        goto L11
    }

    public final void g(Object r10) {
        Object r11 = this.f5541c;
        monitor-enter(r11);
        Object r12 = this.f5543e;     // Catch: Throwable -> L10
        if (r12 != null) goto L7;
    L12:
        this.f5543e = r10;     // Catch: Throwable -> L10
        final List r13 = b0.x0(this.f5542d);     // Catch: Throwable -> L10
        this.f5539a.getMainThreadExecutor().execute(new f(r13, this));     // Catch: Throwable -> L10
        Unit r14 = Unit.f21064a;     // Catch: Throwable -> L10
        monitor-exit(r11);
        return;
    L7:
        if (q.b(r12, r10) == false) goto L12;
        monitor-exit(r11);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public abstract void h();

    public abstract void i();
}
