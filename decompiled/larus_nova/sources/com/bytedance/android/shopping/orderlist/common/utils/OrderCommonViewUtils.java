package com.bytedance.android.shopping.orderlist.common.utils;

import android.content.Context;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonViewUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f179956a = 0;

    static {
    }

    public static com.bytedance.android.shopping.orderlist.common.widgets.task.b a(final String r100, final String r101, final Function0 r102) {
        return com.bytedance.android.shopping.orderlist.common.widgets.task.c.a(r101, new OrderCommonViewUtils$getInflateTask$1(r102, r100, r101));
    }

    public static void b(InflaterPriority r100, String r101, final Context r102, final int r110, final ViewGroup r111) {
        Intrinsics.checkNotNullParameter(r100, "priority");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, RootDescription.ROOT_ELEMENT);
        int r103 = p.f179986a[r100.ordinal()];
        if (r103 == 1) goto L9;
        if (r103 == 2) goto L8;
        if (r103 != 3) goto L13;
        com.bytedance.android.shopping.orderlist.common.widgets.task.c.b(CollectionsKt.listOf(new com.bytedance.android.shopping.orderlist.common.widgets.task.a[]{a(r101, "ContextInflateExt", new OrderCommonViewUtils$safeInflateWithDegrade$7(r102, r110, r111)), a(r101, "OriginInflater", new OrderCommonViewUtils$safeInflateWithDegrade$8(r102, r110, r111)), a(r101, "AsyncInflater", new OrderCommonViewUtils$safeInflateWithDegrade$9(r102, r110, r111))}));
        return;
    L13:
        return;
    L8:
        com.bytedance.android.shopping.orderlist.common.widgets.task.c.b(CollectionsKt.listOf(new com.bytedance.android.shopping.orderlist.common.widgets.task.a[]{a(r101, "AsyncInflater", new OrderCommonViewUtils$safeInflateWithDegrade$4(r102, r110, r111)), a(r101, "OriginInflater", new OrderCommonViewUtils$safeInflateWithDegrade$5(r102, r110, r111)), a(r101, "ContextInflateExt", new OrderCommonViewUtils$safeInflateWithDegrade$6(r102, r110, r111))}));
        return;
    L9:
        com.bytedance.android.shopping.orderlist.common.widgets.task.c.b(CollectionsKt.listOf(new com.bytedance.android.shopping.orderlist.common.widgets.task.a[]{a(r101, "OriginInflater", new OrderCommonViewUtils$safeInflateWithDegrade$1(r102, r110, r111)), a(r101, "AsyncInflater", new OrderCommonViewUtils$safeInflateWithDegrade$2(r102, r110, r111)), a(r101, "ContextInflateExt", new OrderCommonViewUtils$safeInflateWithDegrade$3(r102, r110, r111))}));
    }
}
