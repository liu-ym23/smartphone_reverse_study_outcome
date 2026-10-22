package com.bytedance.android.shopping.store.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ShopShareGuideBubbleHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f183582a = 0;

    static {
    }

    public static void a(Context r110, LifecycleOwner r111, View r112, ViewGroup r113, com.bytedance.android.shopping.store.home.entity.j r114, final Function0 r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r112, "anchorView");
        Intrinsics.checkNotNullParameter(r114, "shareInfo");
        Intrinsics.checkNotNullParameter(r210, "onBubbleShown");
        Long r100 = r114.f183736d;
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L6:
        Long r102 = r114.f183735c;
        if (r102 == null) goto L9;
        long r103 = r102.longValue();
    L10:
        String r104 = r114.f183734b;
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        String r115 = r104;
        com.bytedance.android.ec.sdk.helper.q r105 = com.bytedance.android.ec.sdk.helper.q.f48131a;
        final long r116 = com.bytedance.android.ec.sdk.helper.q.f("sp_key_share_guide_bubble_show_count");
        if (r116 < r101) goto L16;
        return;
    L16:
        if (r115.length() <= 0) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == false) goto L23;
        long r107 = r103;
        com.bytedance.android.shopping.store.home.view.n r117 = new com.bytedance.android.shopping.store.home.view.n(r110, r111, r112, r113, r115, r107, new ShopShareGuideBubbleHelper$tryShowShareGuideBubbleNow$shareGuidBubbleView$1(r116, r210));
        ECBubbleControllerManager.f48207b.a(r111).a(com.bytedance.android.ec.store.common.bubble.a.f48211b, r117);
        return;
    L23:
        return;
    L18:
        r106 = false;
        goto L19
    L9:
        r103 = 3000;
        goto L10
    L5:
        r101 = 3;
        goto L6
    }
}
