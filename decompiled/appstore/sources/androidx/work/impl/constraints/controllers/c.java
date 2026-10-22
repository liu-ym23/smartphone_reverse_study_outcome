package androidx.work.impl.constraints.controllers;

import androidx.work.NetworkType;
import androidx.work.impl.model.o;
import com.bytedance.apm.constant.CommonKey;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class c extends ConstraintController {
    public c(androidx.work.impl.constraints.trackers.g r10) {
        q.g(r10, "tracker");
        super(r10);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean a(o r10) {
        q.g(r10, "workSpec");
        if (r10.f5679j.d() != NetworkType.CONNECTED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public /* bridge */ /* synthetic */ boolean b(Object r10) {
        return h((androidx.work.impl.constraints.a) r10);
    }

    public boolean h(androidx.work.impl.constraints.a r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        if (r10.a() == true) goto L5;
    L8:
        return true;
    L5:
        if (r10.d() == false) goto L8;
        return false;
    }
}
