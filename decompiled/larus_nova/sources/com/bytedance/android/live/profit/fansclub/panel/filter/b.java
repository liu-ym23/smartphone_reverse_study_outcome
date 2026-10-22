package com.bytedance.android.live.profit.fansclub.panel.filter;

import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.i;
import com.bytedance.android.live.profit.fansclub.panel.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements f {
    public b() {
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.f
    public final void a(FansClubEntranceParams r100, com.bytedance.android.live.profit.fansclub.panel.d r101) {
        Intrinsics.checkNotNullParameter(r100, "entranceParams");
        Intrinsics.checkNotNullParameter(r101, "panelParams");
        FansClubEntranceParams.Page r102 = r100.f87233a;
        Intrinsics.checkNotNullParameter(r102, "page");
        if (r102 != FansClubEntranceParams.Page.FansGroup) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        return;
    L9:
        if ((r101 instanceof cu0.b.C5588b) == false) goto L12;
        cu0.b.C5588b r104 = (cu0.b.C5588b) r101;
        String r105 = (String) i.f87316q.getValue(null, i.f87300a[14]);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f465416a = r105;
        return;
    L12:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
