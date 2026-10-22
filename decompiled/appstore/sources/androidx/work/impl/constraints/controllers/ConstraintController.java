package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.model.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintController implements ConstraintListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.work.impl.constraints.trackers.g f5523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f5525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnConstraintUpdatedCallback f5527e;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;", "", "", "Landroidx/work/impl/model/o;", "workSpecs", "", "onConstraintMet", "(Ljava/util/List;)V", "onConstraintNotMet", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnConstraintUpdatedCallback {
        void onConstraintMet(@NotNull List<o> r10);

        void onConstraintNotMet(@NotNull List<o> r10);
    }

    public ConstraintController(androidx.work.impl.constraints.trackers.g r10) {
        q.g(r10, "tracker");
        this.f5523a = r10;
        this.f5524b = new ArrayList();
        this.f5525c = new ArrayList();
    }

    public abstract boolean a(o r10);

    public abstract boolean b(Object r10);

    public final boolean c(String r10) {
        q.g(r10, "workSpecId");
        Object r11 = this.f5526d;
        if (r11 != null) goto L5;
    L9:
        return false;
    L5:
        if (b(r11) == false) goto L9;
        if (this.f5525c.contains(r10) == false) goto L9;
        return true;
    }

    public final void d(Iterable r10) {
        q.g(r10, "workSpecs");
        this.f5524b.clear();
        this.f5525c.clear();
        List r11 = this.f5524b;
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (a((o) r13) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        List r14 = this.f5524b;
        List r15 = this.f5525c;
        Iterator r16 = r14.iterator();
    L10:
        if (r16.hasNext() == false) goto L13;
        r15.add(((o) r16.next()).f5670a);
        goto L10
    L13:
        if (this.f5524b.isEmpty() == false) goto L15;
        this.f5523a.f(this);
    L16:
        g(this.f5527e, this.f5526d);
        return;
    L15:
        this.f5523a.c(this);
        goto L16
    }

    public final void e() {
        if (this.f5524b.isEmpty() == true) goto L6;
        this.f5524b.clear();
        this.f5523a.f(this);
        return;
    }

    public final void f(OnConstraintUpdatedCallback r10) {
        if (this.f5527e == r10) goto L6;
        this.f5527e = r10;
        g(r10, this.f5526d);
        return;
    }

    public final void g(OnConstraintUpdatedCallback r10, Object r11) {
        if (this.f5524b.isEmpty() == true) goto L13;
        if (r10 == null) goto L15;
        if (r11 != null) goto L8;
    L11:
        r10.onConstraintNotMet(this.f5524b);
        return;
    L8:
        if (b(r11) == true) goto L11;
        r10.onConstraintMet(this.f5524b);
        return;
    L15:
        return;
    }

    @Override // androidx.work.impl.constraints.ConstraintListener
    public void onConstraintChanged(Object r10) {
        this.f5526d = r10;
        g(this.f5527e, r10);
    }
}
