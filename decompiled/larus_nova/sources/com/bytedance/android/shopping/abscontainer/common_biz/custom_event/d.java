package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import com.bytedance.android.shopping.abscontainer.common_biz.helper.RefreshHelper;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.a;

/* JADX INFO: loaded from: classes12.dex */
public final class d<STATE extends v43.a, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164239b;

    @Override // m33.a
    public final String d() {
        return this.f164239b;
    }

    public d(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164239b = "selfChangeBuyNum";
    }

    @Override // m33.a
    public final void e(e43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        if (com.bytedance.android.shopping.abscontainer.common_biz.helper.a.a(this.f511708a.f507250d.c(), r100) == false) goto L18;
        Map<String, Object> r101 = r100.c();
        Object r102 = null;
        if (r101 == null) goto L7;
        Object r103 = r101.get("next_count");
    L9:
        if ((r103 instanceof Number) == false) goto L12;
        r102 = r103;
    L12:
        Number r104 = (Number) r102;
        if (r104 == null) goto L15;
        int r105 = r104.intValue();
    L16:
        ((v43.a) this.f511708a.f507247a).p(Integer.valueOf(r105));
        int r106 = RefreshHelper.f164294a;
        RefreshHelper.a(this.f511708a.f507250d.g(), (v43.a) this.f511708a.f507247a);
        return;
    L15:
        r105 = 0;
        goto L16
    L7:
        r103 = null;
        goto L9
    L18:
        r100.d(new m33.c(true, null, false, null, 30));
    }
}
