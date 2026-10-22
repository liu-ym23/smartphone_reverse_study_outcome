package com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t43.a;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class CheckWhenContinueCloseModule<STATE extends w33.g, PROPS extends u33.a & t43.a> extends s33.b<STATE, PROPS> implements o33.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f164322c;

    @Override // o33.b
    public final String getEventName() {
        return this.f164322c;
    }

    @Override // s33.b
    public final String j() {
        return this.f164321b;
    }

    public CheckWhenContinueCloseModule(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164321b = "CheckWhenContinueCloseModule";
        this.f164322c = "ecom.continue_pay.dismiss";
    }

    @Override // o33.b
    public final void a(Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        HashMap r111 = (HashMap) r110;
        Object r100 = r111.get("pre_session_id");
        z33.a r101 = null;
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        if ((!Intrinsics.areEqual((String) r100, ((t43.a) this.f540457a.f507249c).a())) == false) goto L8;
        return;
    L8:
        Object r112 = r111.get("has_check");
        if ((r112 instanceof Boolean) == true) goto L12;
        r112 = null;
    L12:
        if (Intrinsics.areEqual((Boolean) r112, Boolean.TRUE) == false) goto L14;
        return;
    L14:
        List<z33.a> r113 = this.f540457a.f507250d.c().o(CheckWhenContinueCloseModule$onReceivedEvent$submitBarNode$1.INSTANCE);
        if (r113 == null) goto L17;
        r101 = (z33.a) CollectionsKt.firstOrNull(r113);
    L17:
        if (r101 != null) goto L19;
        return;
    L19:
        this.f540457a.f507250d.c().j(null, r101.d(), "checkPayStatus", null, "twice_check");
    }
}
