package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.s;

/* JADX INFO: loaded from: classes12.dex */
public final class a<STATE extends v43.s, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164233b;

    @Override // m33.a
    public final String d() {
        return this.f164233b;
    }

    public a(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164233b = "selfAddCurVersion";
    }

    @Override // m33.a
    public final void e(e43.a r110) {
        Intrinsics.checkNotNullParameter(r110, "eventData");
        ((v43.s) this.f511708a.f507247a).b().addAndGet(1);
        r110.d(new m33.c(true, null, false, null, 30));
    }
}
