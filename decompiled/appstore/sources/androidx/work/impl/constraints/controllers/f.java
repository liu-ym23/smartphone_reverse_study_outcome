package androidx.work.impl.constraints.controllers;

import androidx.work.NetworkType;
import androidx.work.impl.model.o;
import com.bytedance.apm.constant.CommonKey;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class f extends ConstraintController {
    public f(androidx.work.impl.constraints.trackers.g r10) {
        q.g(r10, "tracker");
        super(r10);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean a(o r10) {
        q.g(r10, "workSpec");
        NetworkType r11 = r10.f5679j.d();
        if (r11 != NetworkType.UNMETERED) goto L5;
    L8:
        return true;
    L5:
        if (r11 == NetworkType.TEMPORARILY_UNMETERED) goto L8;
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
        if (r10.b() == true) goto L8;
        return false;
    }
}
