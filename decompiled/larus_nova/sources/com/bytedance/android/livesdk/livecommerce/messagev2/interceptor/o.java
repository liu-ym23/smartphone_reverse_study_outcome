package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o extends a {
    public o() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r100, boolean r101) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        sg2.b r101 = r100.getCommon();
        if (r101 == null) goto L5;
        String r102 = r101.f541771b;
    L6:
        sg2.b r103 = r100.getCommon();
        if (r103 == null) goto L9;
        String r104 = r103.f541770a;
    L10:
        sg2.b r105 = r100.getCommon();
        if (r105 == null) goto L13;
        boolean r106 = r105.f541775f;
    L14:
        xh.b.d r107 = new xh.b.d();
        sg2.b r108 = r100.getCommon();
        if (r108 == null) goto L18;
        String r109 = r108.f541774e;
        if (r109 == null) goto L18;
    L19:
        r107.d(r109);
        r107.c(r104);
        r107.b(r106);
        if (ECAppInfoService.f48114e.isLocalTest() == true) goto L23;
        r100 = null;
    L23:
        r107.a(r100);
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"LiveInteractionMessage", "ProductListUpdateMessage", "ProductUpdateMessage"}), r102) == false) goto L26;
        int r110 = 3;
    L27:
        xh.c.a("Live").h(null, r102, r107, r110);
        return false;
    L26:
        r110 = 4;
    L18:
        r109 = "";
        goto L19
    L13:
        r106 = false;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
