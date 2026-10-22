package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import android.view.View;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g {
    public static final Pair<Integer, Integer> a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPositionOnScreen");
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        return TuplesKt.to(Integer.valueOf(r101[0]), Integer.valueOf(r101[1]));
    }
}
