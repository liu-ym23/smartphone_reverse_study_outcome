package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import android.view.View;
import android.widget.HorizontalScrollView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class h0<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164248b;

    public static final class a {
    }

    static {
    }

    @Override // m33.a
    public final String d() {
        return this.f164248b;
    }

    public h0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164248b = "selfScrollItemToCenter";
    }

    @Override // m33.a
    public final void e(e43.a r110) {
        Intrinsics.checkNotNullParameter(r110, "eventData");
        View r100 = r110.g();
        Map<String, Object> r101 = r110.a();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("orientation");
    L7:
        if ((r103 instanceof String) == false) goto L10;
        r102 = r103;
    L10:
        String r104 = (String) r102;
        if (r100 != null) goto L14;
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L14:
        HorizontalScrollView r105 = f(r100);
        if (r105 != null) goto L18;
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L18:
        if (r104 != null) goto L21;
    L26:
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L21:
        if (r104.hashCode() != 1387629604) goto L26;
        if (r104.equals("horizontal") == false) goto L26;
        com.bytedance.android.shopping.buynow.utils.q.c(r100, r105);
        goto L26
    L5:
        r103 = null;
        goto L7
    }

    public final HorizontalScrollView f(View r100) {
        Object r101 = r100.getParent();
        if ((r101 instanceof View) == true) goto L5;
        r101 = null;
    L5:
        View r102 = (View) r101;
        if (r102 != null) goto L9;
        return null;
    L9:
        if ((r102 instanceof HorizontalScrollView) == false) goto L13;
        return (HorizontalScrollView) r102;
    L13:
        return f(r102);
    }
}
