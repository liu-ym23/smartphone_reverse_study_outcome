package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class i0<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164250b;

    @Override // m33.a
    public final String d() {
        return this.f164250b;
    }

    public i0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164250b = "selfScrollOverKeyboard";
    }

    @Override // m33.a
    public final void e(e43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        r100.d(new m33.c(true, null, false, null, 30));
    }
}
