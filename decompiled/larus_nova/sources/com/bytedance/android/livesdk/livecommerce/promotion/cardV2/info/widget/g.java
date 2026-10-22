package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g extends LinearLayout implements com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f150641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LivePromotionCardArgsV2 f150642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a f150643c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getCurrentContentDescription() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getType() {
        return "coupon_group_widget";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public final void release() {
    }

    public g(Context r100, LivePromotionCardArgsV2 r101, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "argument");
        super(r100, null, 0);
        this.f150642b = r101;
        this.f150643c = r102;
        this.f150641a = LazyKt.lazy(ECLabelGroupWidget$isUseNewView$2.INSTANCE);
        int r103 = com.bytedance.android.ec.core.utils.a.f45549a;
        Intrinsics.checkNotNullParameter(this, "view");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        setImportantForAccessibility(4);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = getChildCount() - 1;
    L3:
        if (r105 < 0) goto L13;
        View r106 = getChildAt(r105);
        if (r106 == null) goto L12;
        if (r106.getVisibility() == 8) goto L12;
        if ((r106.getLeft() + r106.getMeasuredWidth()) < getMeasuredWidth()) goto L19;
        r106.layout(r106.getLeft(), r106.getTop(), r106.getLeft(), r106.getBottom());
        goto L12
    L19:
        return;
    L12:
        r105 = r105 - 1;
        goto L3
    }
}
