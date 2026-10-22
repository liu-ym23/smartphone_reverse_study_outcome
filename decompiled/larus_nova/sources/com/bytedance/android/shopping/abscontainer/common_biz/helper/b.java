package com.bytedance.android.shopping.abscontainer.common_biz.helper;

import j33.f;
import kotlin.jvm.internal.Intrinsics;
import v43.q;
import v43.r;

/* JADX INFO: loaded from: classes12.dex */
public final class b {
    public static final void a(f r100, r r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "yataAbility");
        Intrinsics.checkNotNullParameter(r101, "bizState");
        Intrinsics.checkNotNullParameter(r102, "opportunity");
        q r103 = r101.u().get(r102);
        if (r103 != null) goto L5;
        return;
    L5:
        r100.j(null, r103.f553080d, r103.f553077a, null, "handleEvent_" + r103.f553078b);
        if (r103.f553079c == true) goto L9;
        r101.u().remove(r102);
        return;
    }
}
