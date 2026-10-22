package androidx.work.impl.constraints;

import androidx.work.i;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.d;
import androidx.work.impl.constraints.controllers.e;
import androidx.work.impl.constraints.controllers.f;
import androidx.work.impl.constraints.controllers.g;
import androidx.work.impl.constraints.trackers.m;
import androidx.work.impl.model.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class b implements WorkConstraintsTracker, ConstraintController.OnConstraintUpdatedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkConstraintsCallback f5519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintController[] f5520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5521c;

    public b(WorkConstraintsCallback r10, ConstraintController[] r11) {
        q.g(r11, "constraintControllers");
        this.f5519a = r10;
        this.f5520b = r11;
        this.f5521c = new Object();
    }

    public final boolean a(String r10) {
        q.g(r10, "workSpecId");
        Object r11 = this.f5521c;
        monitor-enter(r11);
        ConstraintController[] r12 = this.f5520b;     // Catch: Throwable -> L10
        int r13 = r12.length;     // Catch: Throwable -> L10
        boolean r14 = false;
        int r15 = 0;
    L5:
        if (r15 >= r13) goto L12;
        ConstraintController r16 = r12[r15];     // Catch: Throwable -> L10
        if (r16.c(r10) == true) goto L13;
        r15 = r15 + 1;     // Catch: Throwable -> L10
    L13:
        if (r16 == null) goto L15;
        i.e().a(c.a(), "Work " + r10 + " constrained by " + r16.getClass().getSimpleName());     // Catch: Throwable -> L10
    L15:
        if (r16 != null) goto L17;
        r14 = true;
    L17:
        monitor-exit(r11);
        return r14;
    L12:
        r16 = null;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public void onConstraintMet(List r10) {
        q.g(r10, "workSpecs");
        Object r11 = this.f5521c;
        monitor-enter(r11);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L10
        Iterator r13 = r10.iterator();     // Catch: Throwable -> L10
    L6:
        if (r13.hasNext() == false) goto L12;
        Object r14 = r13.next();     // Catch: Throwable -> L10
        if (a(((o) r14).f5670a) == false) goto L6;
        r12.add(r14);     // Catch: Throwable -> L10
        goto L6
    L12:
        Iterator r15 = r12.iterator();     // Catch: Throwable -> L10
    L14:
        if (r15.hasNext() == false) goto L16;
        o r16 = (o) r15.next();     // Catch: Throwable -> L10
        i.e().a(c.a(), "Constraints met for " + r16);     // Catch: Throwable -> L10
        goto L14
    L16:
        WorkConstraintsCallback r17 = this.f5519a;     // Catch: Throwable -> L10
        if (r17 == null) goto L19;
        r17.onAllConstraintsMet(r12);     // Catch: Throwable -> L10
        Unit r18 = Unit.f21064a;     // Catch: Throwable -> L10
    L19:
        monitor-exit(r11);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public void onConstraintNotMet(List r10) {
        q.g(r10, "workSpecs");
        Object r11 = this.f5521c;
        monitor-enter(r11);
        WorkConstraintsCallback r12 = this.f5519a;     // Catch: Throwable -> L8
        if (r12 == null) goto L10;
        r12.onAllConstraintsNotMet(r10);     // Catch: Throwable -> L8
        Unit r13 = Unit.f21064a;     // Catch: Throwable -> L8
    L10:
        monitor-exit(r11);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsTracker
    public void replace(Iterable r10) {
        q.g(r10, "workSpecs");
        Object r11 = this.f5521c;
        monitor-enter(r11);
        ConstraintController[] r12 = this.f5520b;     // Catch: Throwable -> L7
        int r13 = r12.length;     // Catch: Throwable -> L7
        int r14 = 0;
        int r15 = 0;
    L5:
        if (r15 >= r13) goto L9;
        r12[r15].f(null);     // Catch: Throwable -> L7
        r15 = r15 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        ConstraintController[] r16 = this.f5520b;     // Catch: Throwable -> L7
        int r17 = r16.length;     // Catch: Throwable -> L7
        int r18 = 0;
    L10:
        if (r18 >= r17) goto L12;
        r16[r18].d(r10);     // Catch: Throwable -> L7
        r18 = r18 + 1;     // Catch: Throwable -> L7
        goto L10
    L12:
        ConstraintController[] r19 = this.f5520b;     // Catch: Throwable -> L7
        int r20 = r19.length;     // Catch: Throwable -> L7
    L13:
        if (r14 >= r20) goto L15;
        r19[r14].f(this);     // Catch: Throwable -> L7
        r14 = r14 + 1;     // Catch: Throwable -> L7
        goto L13
    L15:
        Unit r21 = Unit.f21064a;     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsTracker
    public void reset() {
        Object r10 = this.f5521c;
        monitor-enter(r10);
        ConstraintController[] r11 = this.f5520b;     // Catch: Throwable -> L7
        int r12 = r11.length;     // Catch: Throwable -> L7
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].e();     // Catch: Throwable -> L7
        r13 = r13 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        Unit r14 = Unit.f21064a;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public b(m r10, WorkConstraintsCallback r11) {
        q.g(r10, "trackers");
        this(r11, new ConstraintController[]{new androidx.work.impl.constraints.controllers.a(r10.a()), new androidx.work.impl.constraints.controllers.b(r10.b()), new g(r10.d()), new androidx.work.impl.constraints.controllers.c(r10.c()), new f(r10.c()), new e(r10.c()), new d(r10.c())});
    }
}
