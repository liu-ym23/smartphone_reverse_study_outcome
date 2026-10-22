package com.bytedance.anniex.bd.foundation.impl;

import com.bytedance.rts.foundation.y;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class p {
    public p() {
    }

    public final void b(String r110) {
        Intrinsics.checkNotNullParameter("AnnieXServiceCenter", "tag");
        Intrinsics.checkNotNullParameter(r110, "msg");
        int r100 = y.f267598a;
        Object[] r101 = {"AnnieXServiceCenter: " + r110};
        Intrinsics.checkNotNullParameter(r101, "messages");
        Object[] r102 = Arrays.copyOf(r101, 1);
        Intrinsics.checkNotNullParameter(r102, "messages");
        System.err.println("RTSWarning:" + ArraysKt.joinToString$default(r102, " ", null, null, 0, null, null, 62, null));
    }

    public final void a(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "msg");
        int r100 = y.f267598a;
        Object[] r101 = {r110 + ": " + r111};
        Intrinsics.checkNotNullParameter(r101, "messages");
        Object[] r102 = Arrays.copyOf(r101, 1);
        Intrinsics.checkNotNullParameter(r102, "messages");
        System.out.println("RTSInfo:" + ArraysKt.joinToString$default(r102, " ", null, null, 0, null, null, 62, null));
    }
}
