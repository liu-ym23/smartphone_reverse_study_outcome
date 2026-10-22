package com.bytedance.android.shopping.abscontainer.common_biz.util;

import j33.f;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class TargetViewFinder {
    static {
    }

    @JvmStatic
    public static final z33.a a(f r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "yataAbility");
        Intrinsics.checkNotNullParameter(r101, "targetComponentName");
        Intrinsics.checkNotNullParameter(r102, "targetYataKey");
        List<z33.a> r103 = r100.o(new TargetViewFinder$findRenderObject$1(r101, r102));
        if (r103 != null) goto L7;
        return null;
    L7:
        return (z33.a) CollectionsKt.firstOrNull(r103);
    }
}
