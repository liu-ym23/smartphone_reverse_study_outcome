package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.l;

/* JADX INFO: loaded from: classes12.dex */
public final class m0<STATE extends v43.l, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164258b;

    @Override // m33.a
    public final String d() {
        return this.f164258b;
    }

    public m0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164258b = "selfSubmitBtnClick";
    }

    @Override // m33.a
    public final void e(e43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        ((v43.l) this.f511708a.f507247a).o().c(new p43.c.C7150c());
        r100.d(new m33.c(true, null, false, null, 30));
    }
}
