package com.bytedance.android.shopping.anchorv3.detail.viewholder.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.widget.ECCouponView;
import com.bytedance.android.shopping.feed.view.c;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import d63.h;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import u63.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/info/CouponGroupLayout;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponGroupLayout extends LinearLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<h> f164830a;

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public CouponGroupLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(getContext());
        this.f164830a = CollectionsKt.emptyList();
        setOrientation(0);
        setGravity(16);
    }

    public final void b(List r110) {
        Intrinsics.checkNotNullParameter(r110, "couponList");
        this.f164830a = r110;
        removeAllViews();
        Iterator r111 = r110.iterator();
        int r100 = 0;
    L4:
        if (r111.hasNext() == false) goto L13;
        h r101 = (h) r111.next();
        View r102 = a.a(getContext(), R.layout.ec_commerce_anchor_v3_coupon_layout_big, null, false);
        ECCouponView r103 = (ECCouponView) r102.findViewById(R.id.anchor_v3_coupon);
        String r104 = r101.f467117a;
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        String r105 = r104;
        ECCouponView.a(r103, r105, r101.f467118b, false, r101.f467121e, 8);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, (int) UIUtils.dip2Px(getContext(), 16.0f));
        if (r100 != 0) goto L11;
        r106.setMargins(0, 0, 0, 0);
    L12:
        r102.setLayoutParams(r106);
        addView(r102);
        r100 = r100 + 1;
        goto L4
    L11:
        r106.setMargins((int) UIUtils.dip2Px(getContext(), 4.0f), 0, 0, 0);
        goto L12
    }

    public CouponGroupLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101);
        LayoutInflater.from(getContext());
        this.f164830a = CollectionsKt.emptyList();
        setOrientation(0);
        setGravity(16);
    }

    public CouponGroupLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101, r102);
        LayoutInflater.from(getContext());
        this.f164830a = CollectionsKt.emptyList();
        setOrientation(0);
        setGravity(16);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (getChildCount() != this.f164830a.size()) goto L9;
        int r105 = getChildCount() - 1;
    L5:
        if (r105 < 0) goto L12;
        View r106 = getChildAt(r105);
        if ((r106.getLeft() + r106.getMeasuredWidth()) < getMeasuredWidth()) goto L13;
        removeViewInLayout(r106);
        r105 = r105 - 1;
        goto L5
    L13:
        return;
    L12:
        return;
    }
}
