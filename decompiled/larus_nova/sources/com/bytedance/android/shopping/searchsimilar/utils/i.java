package com.bytedance.android.shopping.searchsimilar.utils;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.searchsimilar.model.SortRuleInfo;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements TabLayout.OnTabSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f182507a;

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab r100) {
    }

    public i(h r100) {
        this.f182507a = r100;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab r110) {
        h r100 = this.f182507a;
        r100.getClass();
        if (r110 == null) goto L46;
        int r101 = r110.getPosition();
        List<Integer> r102 = r100.a(r101);
        if (r102 == null) goto L47;
        r100.f182506f++;
        View r111 = r110.getCustomView();
        if (r111 == null) goto L9;
        ImageView r112 = (ImageView) r111.findViewById(R.id.tab_image_view);
    L10:
        int r103 = 0;
        if ((r100.f182506f % 2) != 0) goto L13;
        int r104 = 1;
    L14:
        Integer r105 = (Integer) CollectionsKt.getOrNull(r102, r104);
        if (r105 != null) goto L18;
    L21:
        if (r105 != null) goto L24;
        return;
    L24:
        if (r105.intValue() != 2) goto L48;
        if (r112 == null) goto L27;
        r112.setImageResource(R.drawable.commerce_similar_product_sort_up_to_down);
    L27:
        StringBuilder r113 = new StringBuilder();
        SortRuleInfo r106 = (SortRuleInfo) CollectionsKt.getOrNull(r100.f182502b, r101);
        if (r106 == null) goto L32;
        Integer r107 = r106.getSortType();
        if (r107 == null) goto L32;
        int r108 = r107.intValue();
    L33:
        r113.append(r108);
        r113.append("_");
        Integer r109 = (Integer) CollectionsKt.getOrNull(r102, r104);
        if (r109 == null) goto L36;
        r103 = r109.intValue();
    L36:
        r113.append(r103);
        SimilarProductVM r114 = r100.f182504d;
        if (r114 == null) goto L39;
        r114.resetRequestParams(r113.toString());
    L39:
        SimilarProductVM r115 = r100.f182504d;
        if (r115 == null) goto L42;
        r115.clearSimilarProduct();
    L42:
        SimilarProductVM r116 = r100.f182504d;
        if (r116 == null) goto L49;
        r116.loadSimilarProduct();
        Unit r117 = Unit.INSTANCE;
        return;
    L49:
        return;
    L32:
        r108 = 0;
        goto L33
    L48:
        return;
    L18:
        if (r105.intValue() != 1) goto L21;
        if (r112 == null) goto L27;
        r112.setImageResource(R.drawable.commerce_similar_product_sort_down_to_up);
        goto L27
    L13:
        r104 = 0;
        goto L14
    L9:
        r112 = null;
        goto L10
    L47:
        return;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab r110) {
        h r100 = this.f182507a;
        r100.getClass();
        if (r110 == null) goto L65;
        int r101 = r110.getPosition();
        View r111 = r110.getCustomView();
        int r102 = 0;
        if (r111 == null) goto L21;
        TextView r103 = (TextView) r111.findViewById(R.id.tab_text_view);
        int r104 = g1.f45599a;
        r103.setTextColor(g1.a.a(r103.getContext(), R.color.shopping_color_161823));
        r103.setTypeface(null, 1);
        ImageView r112 = (ImageView) r111.findViewById(R.id.tab_image_view);
        List<Integer> r105 = r100.a(r101);
        if (r105 == null) goto L9;
        Integer r106 = (Integer) CollectionsKt.firstOrNull(r105);
    L10:
        if (r106 != null) goto L13;
    L15:
        if (r106 != null) goto L18;
    L20:
        r112.setVisibility(8);
        goto L21
    L18:
        if (r106.intValue() != 2) goto L20;
        r112.setVisibility(0);
        r112.setImageResource(R.drawable.commerce_similar_product_sort_up_to_down);
        goto L21
    L13:
        if (r106.intValue() != 1) goto L15;
        r112.setVisibility(0);
        r112.setImageResource(R.drawable.commerce_similar_product_sort_down_to_up);
        goto L21
    L9:
        r106 = null;
    L21:
        TabLayout r113 = r100.f182503c;
        if (r113 != null) goto L24;
    L25:
        TabLayout r114 = r100.f182503c;
        if (r114 == null) goto L40;
        Intrinsics.checkNotNull(r114);
        int r115 = r114.getTabCount();
        int r107 = r100.f182505e;
        if (r107 < 0) goto L40;
        if (r115 <= r107) goto L40;
        TabLayout r116 = r100.f182503c;
        if (r116 == null) goto L40;
        TabLayout.Tab r117 = r116.getTabAt(r107);
        if (r117 == null) goto L40;
        View r118 = r117.getCustomView();
        if (r118 == null) goto L40;
        TextView r108 = (TextView) r118.findViewById(R.id.tab_text_view);
        int r109 = g1.f45599a;
        r108.setTextColor(g1.a.a(r108.getContext(), R.color.shopping_color_99161823));
        r108.setTypeface(null, 0);
        ImageView r119 = (ImageView) r118.findViewById(R.id.tab_image_view);
        if (r119.getVisibility() != 0) goto L40;
        r119.setImageResource(R.drawable.commerce_similar_product_sort_default);
    L40:
        r100.f182505e = r101;
        if (r100.f182501a == false) goto L43;
        r100.f182501a = false;
    L63:
        r100.f182506f = 1;
        return;
    L43:
        StringBuilder r120 = new StringBuilder();
        SortRuleInfo r121 = (SortRuleInfo) CollectionsKt.getOrNull(r100.f182502b, r101);
        if (r121 == null) goto L48;
        Integer r122 = r121.getSortType();
        if (r122 == null) goto L48;
        int r123 = r122.intValue();
    L49:
        r120.append(r123);
        r120.append("_");
        List<Integer> r124 = r100.a(r101);
        if (r124 == null) goto L54;
        Integer r125 = (Integer) CollectionsKt.firstOrNull(r124);
        if (r125 == null) goto L54;
        r102 = r125.intValue();
    L54:
        r120.append(r102);
        SimilarProductVM r126 = r100.f182504d;
        if (r126 == null) goto L57;
        r126.resetRequestParams(r120.toString());
    L57:
        SimilarProductVM r127 = r100.f182504d;
        if (r127 == null) goto L60;
        r127.clearSimilarProduct();
    L60:
        SimilarProductVM r128 = r100.f182504d;
        if (r128 == null) goto L63;
        r128.loadSimilarProduct();
    L48:
        r123 = 0;
        goto L49
    L24:
        if (r113.getTabCount() == 0) goto L40;
    }
}
