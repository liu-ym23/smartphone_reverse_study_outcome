package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class p implements qh0.a<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qh0.b f77391a;

    public p(qh0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "createConfig");
        this.f77391a = r100;
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r110) {
        Intrinsics.checkNotNullParameter(r110, "consumer");
        if (tb1.c.f545231c == true) goto L5;
    L7:
        qh0.d.a.a(r110);
        return;
    L5:
        if (vm2.g.b() == true) goto L7;
        f2.b(R.string.ttlive_linkmic_close_link_tip, 0);
        r110.b(new BaseCheckException(this.f77391a.getLinkType(), this.f77391a.getOperateType(), BaseCheckException.CheckType.AndroidPermission, "dylite not support link", null, 16, null));
    }
}
