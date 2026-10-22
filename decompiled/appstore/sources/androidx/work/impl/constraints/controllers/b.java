package androidx.work.impl.constraints.controllers;

import androidx.work.impl.model.o;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class b extends ConstraintController {
    public b(androidx.work.impl.constraints.trackers.c r10) {
        q.g(r10, "tracker");
        super(r10);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean a(o r10) {
        q.g(r10, "workSpec");
        return r10.f5679j.f();
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public /* bridge */ /* synthetic */ boolean b(Object r10) {
        return h(((Boolean) r10).booleanValue());
    }

    public boolean h(boolean r10) {
        return !r10;
    }
}
