package com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t43.a;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class a<STATE extends w33.g, PROPS extends u33.a & t43.a> extends s33.b<STATE, PROPS> implements o33.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f164327c;

    @Override // o33.b
    public final String getEventName() {
        return this.f164327c;
    }

    @Override // s33.b
    public final String j() {
        return this.f164326b;
    }

    public a(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164326b = "CloseSelfWhenContinueJumpModule";
        this.f164327c = "ecom.continue.check.jump";
    }

    @Override // o33.b
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Object r101 = ((HashMap) r100).get("pre_session_id");
        if ((r101 instanceof String) == true) goto L6;
        r101 = null;
    L6:
        if ((!Intrinsics.areEqual((String) r101, ((t43.a) this.f540457a.f507249c).a())) == false) goto L8;
        return;
    L8:
        this.f540457a.f507252f.is();
    }
}
