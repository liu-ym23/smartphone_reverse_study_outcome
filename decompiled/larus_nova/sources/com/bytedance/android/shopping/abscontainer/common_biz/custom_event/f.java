package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import com.bytedance.android.shopping.abscontainer.common_biz.constant.WidgetName;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.b;

/* JADX INFO: loaded from: classes12.dex */
public final class f<STATE extends v43.b, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164243b;

    @Override // m33.a
    public final String d() {
        return this.f164243b;
    }

    public f(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164243b = "selfCloseDialog";
    }

    @Override // m33.a
    public final void e(e43.a r110) {
        Intrinsics.checkNotNullParameter(r110, "eventData");
        n43.c r100 = this.f511708a.f507251e.f527570g.get(WidgetName.DIALOG.getValue());
        if ((r100 instanceof k43.c) == true) goto L5;
        r100 = null;
    L5:
        k43.c r101 = (k43.c) r100;
        if (r101 == null) goto L8;
        r101.e(new y33.a(false));
    L8:
        r110.d(new m33.c(true, null, false, null, 30));
    }
}
