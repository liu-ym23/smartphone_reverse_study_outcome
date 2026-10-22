package com.bytedance.android.shopping.store.search.recyclerview.holder;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultItemType;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qj3.c;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/search/recyclerview/holder/ShopRecommendedNoticeHolder;", "Lcom/bytedance/android/shopping/store/search/recyclerview/holder/ShopBaseSearchResultViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopRecommendedNoticeHolder extends ShopBaseSearchResultViewHolder {

    public static final class a {
    }

    public static final class b extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f186128a;

        public b(Context r100) {
            super(r100);
            setOrientation(1);
            setGravity(17);
            c r101 = new c(getContext());
            this.f186128a = r101;
            addView(r101, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    static {
        com.bytedance.android.shopping.extensions.b.b(4);
    }

    public ShopRecommendedNoticeHolder(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(null, new b(r100), SearchResultItemType.RECOMMEND_NOTICE);
    }

    @Override // com.bytedance.android.shopping.store.search.recyclerview.holder.ShopBaseSearchResultViewHolder
    public final void T3(en.b r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        View r101 = this.f186126b;
        if (r101 == null) goto L36;
        b r102 = (b) r101;
        en.c r103 = (en.c) r100;
        boolean r104 = r103.f473140b;
        boolean r105 = r103.f473141c;
        int r106 = R.string.ec_store_empty_result_notice;
        if (r104 == false) goto L25;
        if (r105 == false) goto L25;
        c r107 = r102.f186128a;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("productTopBanner");
    L11:
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        ViewGroup.LayoutParams r109 = null;
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == true) goto L14;
        r108 = null;
    L14:
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r108;
        if (r110 == null) goto L17;
        r110.topMargin = com.bytedance.android.shopping.extensions.b.b(10);
    L17:
        ViewGroup.LayoutParams r111 = r107.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        r109 = r111;
    L21:
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r109;
        if (r112 == null) goto L24;
        r112.bottomMargin = com.bytedance.android.shopping.extensions.b.b(8);
    L24:
        r107.getTextView().setTextColor((int) 2568362019L);
        r107.getTextView().setTypeface(Typeface.DEFAULT);
        r107.getTextView().setTextSize(2, 13.0f);
        r107.getTextView().setText(R.string.ec_store_empty_result_notice);
        r107.getLeftImage().setImageResource(R.drawable.ec_shop_search_empty_icon_left);
        r107.getRightImage().setImageResource(R.drawable.ec_shop_search_empty_icon_left);
    L25:
        c r113 = r102.f186128a;
        if (r113 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("productTopBanner");
    L28:
        TextView r114 = r113.getTextView();
        if (r104 == false) goto L32;
        if (r105 == false) goto L32;
    L33:
        r114.setText(r106);
        return;
    L32:
        r106 = R.string.ec_store_more_goods_notice;
        goto L33
    L36:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.search.recyclerview.holder.ShopRecommendedNoticeHolder.ShopNoticeView");
    }
}
