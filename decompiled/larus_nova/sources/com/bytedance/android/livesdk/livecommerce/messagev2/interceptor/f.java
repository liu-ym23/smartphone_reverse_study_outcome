package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.livesdk.livecommerce.model.ECV2BarrageBuyInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class f extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.api.c f149431e;

    public f() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        boolean r101 = false;
        if ((r100 instanceof si2.y) == true) goto L5;
        return false;
    L5:
        si2.y r102 = (si2.y) r100;
        if (r102.msgType != 0) goto L19;
        ECV2BarrageBuyInfo r103 = r102.barrageBuyInfo;
        if (r103 == null) goto L18;
        String r104 = r103.nickName;
        if (r104 != null) goto L12;
    L13:
        r101 = true;
    L14:
        if (r101 == true) goto L18;
        com.bytedance.android.livesdk.livecommerce.room.api.c r105 = this.f149431e;
        if (r105 == null) goto L18;
        r105.jetDanmaku(r103.nickName, r103.purchaseCnt, r103.icon, r103.text);
        goto L18
    L12:
        if (StringsKt.isBlank(r104) == false) goto L14;
    L18:
        return true;
    L19:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r100, boolean r101) {
        this.f149431e = (com.bytedance.android.livesdk.livecommerce.room.api.c) b(com.bytedance.android.livesdk.livecommerce.room.api.c.class, null);
    }
}
