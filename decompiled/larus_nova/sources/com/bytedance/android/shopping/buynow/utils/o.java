package com.bytedance.android.shopping.buynow.utils;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171223a = 0;

    static {
    }

    public static void a(Context r100, List r101, List r102, List r103, int r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "videos");
        Intrinsics.checkNotNullParameter(r102, "images");
        Intrinsics.checkNotNullParameter(r103, "titlesList");
        int r104 = com.bytedance.android.shopping.utils.gallery.k.f187141a;
        com.bytedance.android.shopping.utils.gallery.k.a(r100, CollectionsKt.emptyList(), r102, r103, r110, false);
    }
}
