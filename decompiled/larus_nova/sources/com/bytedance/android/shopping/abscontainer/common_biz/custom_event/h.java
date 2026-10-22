package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class h<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164247b;

    @Override // m33.a
    public final String d() {
        return this.f164247b;
    }

    public h(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164247b = "selfDelay";
    }

    @Override // m33.a
    public final void e(e43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        Map<String, Object> r101 = r100.a();
        if (r101 == null) goto L5;
        Object r102 = r101.get("duration");
    L7:
        if ((r102 instanceof Integer) == true) goto L9;
        r102 = null;
    L9:
        Integer r103 = (Integer) r102;
        if (r103 == null) goto L12;
        int r104 = r103.intValue();
    L13:
        this.f511708a.f507250d.e().c(new SelfDelayEvent$onExecute$1(r104, r100, null));
        return;
    L12:
        r104 = 0;
        goto L13
    L5:
        r102 = null;
        goto L7
    }
}
