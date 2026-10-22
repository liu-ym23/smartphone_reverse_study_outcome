package com.bytedance.android.ec.window.base.product.presenter.element.tags;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.window.base.view.ECWindowCouponView;
import com.bytedance.android.ec.window.base.view.ECWindowMallGoldCouponView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f49422a = 0;

    static {
    }

    public static ECWindowCouponView a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ECWindowCouponView r101 = new ECWindowCouponView(r100, null, 6, 0);
        TextView r102 = r101.f49796b;
        if (r102 == null) goto L5;
        r102.setTextSize(2, 10.0f);
    L5:
        TextView r103 = r101.f49795a;
        if (r103 == null) goto L8;
        r103.setTextSize(2, 10.0f);
    L8:
        r101.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(14)));
        return r101;
    }

    public static ECDraweeView b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ECDraweeView r101 = new ECDraweeView(r100, null, 0, 6, null);
        r101.setAdjustMode(1);
        r101.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(14)));
        return r101;
    }

    public static ECWindowMallGoldCouponView c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ECWindowMallGoldCouponView r101 = new ECWindowMallGoldCouponView(r100, null, 6, 0);
        TextView r102 = r101.f49813b;
        if (r102 == null) goto L5;
        r102.setTextSize(2, 10.0f);
    L5:
        TextView r103 = r101.f49812a;
        if (r103 == null) goto L8;
        r103.setTextSize(2, 10.0f);
    L8:
        r101.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(14)));
        return r101;
    }

    public static TextView d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TextView r101 = new TextView(r100);
        GradientDrawable r102 = new GradientDrawable();
        r102.setColor(0);
        r102.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(2));
        Unit r103 = Unit.INSTANCE;
        ViewCompat.setBackground(r101, r102);
        r101.setTextSize(2, 10.0f);
        r101.setPadding(com.bytedance.android.shopping.extensions.b.b(4), 0, com.bytedance.android.shopping.extensions.b.b(4), 0);
        r101.setGravity(17);
        r101.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(14)));
        return r101;
    }
}
