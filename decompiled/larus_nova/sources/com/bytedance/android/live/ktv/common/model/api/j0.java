package com.bytedance.android.live.ktv.common.model.api;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j0 {
    public static final List<String> a(i0 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getViceSingerList");
        List<String> r101 = r100.chorusUserOpenIds;
        if (r101 == null) goto L6;
        List<String> r102 = CollectionsKt.toMutableList(r101);
        if (r102 == null) goto L6;
    L7:
        r102.remove(r100.c());
        return r102;
    L6:
        r102 = new ArrayList();
        goto L7
    }
}
