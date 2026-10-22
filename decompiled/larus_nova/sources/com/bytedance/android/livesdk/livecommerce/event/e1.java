package com.bytedance.android.livesdk.livecommerce.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e1 extends ECEventV3 {

    public static final class a {
    }

    static {
    }

    public /* synthetic */ e1() {
        this(0, "");
    }

    public e1(int r100, String r101) {
        Intrinsics.checkNotNullParameter("entry", "page");
        super("livesdk_coupon_load_status");
        d("status", r100);
        f("page", "entry");
        if (r101 == null) goto L6;
        f("error_msg", r101);
        return;
    }
}
