package com.bytedance.android.shopping.anchorv3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv3.repository.dto.RecommendInShopProductStruct;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/AnchorV3RecInShopBoxView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3RecInShopBoxView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f165461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b f165462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<AnchorV3RecInShopProductView> f165463c;

    public AnchorV3RecInShopBoxView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3RecInShopBoxView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a() {
        if (this.f165461a != null) goto L5;
        this.f165461a = new LinkedHashMap();
    L5:
        Map<Integer, View> r100 = this.f165461a;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        View r102 = (View) r101.get(Integer.valueOf(R.id.linear_layout_root_view));
        if (r102 != null) goto L12;
        View r103 = findViewById(R.id.linear_layout_root_view);
        if (r103 == null) goto L10;
        this.f165461a.put(Integer.valueOf(R.id.linear_layout_root_view), r103);
        return r103;
    L10:
        return null;
    L12:
        return r102;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f165462b.e(r100);
        super.draw(r100);
        this.f165462b.d(r100);
    }

    public AnchorV3RecInShopBoxView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f165461a = new LinkedHashMap();
        this.f165462b = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.f165463c = new ArrayList();
        u63.a.a(r100, R.layout.ec_commerce_anchor_v3_rec_in_shop_box_layout, this, true);
    }

    public final void b(List<RecommendInShopProductStruct> r110, CommonMeta r111, AnchorV4VM r112) {
        ((LinearLayout) a()).setBackground(com.bytedance.commerce.base.drawable.a.a(AnchorV3RecInShopBoxView$adjustBackground$1.INSTANCE));
        ((ArrayList) this.f165463c).clear();
        if (r110 == null) goto L32;
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r110.iterator();
        AttributeSet r102 = null;
        int r103 = 0;
        LinearLayout r104 = null;
        int r105 = 0;
        int r106 = -1;
    L6:
        if (r101.hasNext() == false) goto L21;
        Object r107 = r101.next();
        int r113 = r105 + 1;
        if (r105 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        RecommendInShopProductStruct r108 = (RecommendInShopProductStruct) r107;
        int r114 = r105 / 3;
        if (r106 == r114) goto L13;
        r104 = new LinearLayout(getContext());
        r100.add(r104);
        r104.setWeightSum(3.0f);
        r104.setOrientation(0);
        r106 = r114;
    L13:
        AnchorV3RecInShopProductView r115 = new AnchorV3RecInShopProductView(getContext(), r102, 6, r103);
        r115.d(r105, r108, r111, r112);
        if (r104 == null) goto L16;
        r104.setShowDividers(2);
    L16:
        if (r104 == null) goto L18;
        r104.setDividerDrawable(com.bytedance.commerce.base.drawable.a.a(AnchorV3RecInShopBoxView$fillWithCommonMeta$1$2.INSTANCE));
    L18:
        if (r104 == null) goto L20;
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(0, -2);
        r109.weight = 1.0f;
        Unit r116 = Unit.INSTANCE;
        r104.addView(r115, r109);
    L20:
        ((ArrayList) this.f165463c).add(r115);
        r105 = r113;
        goto L6
    L21:
        Iterator r117 = r100.iterator();
    L23:
        if (r117.hasNext() == false) goto L25;
        ((LinearLayout) a()).addView((LinearLayout) r117.next(), new FrameLayout.LayoutParams(-1, -1));
        goto L23
    L25:
        LinearLayout r118 = (LinearLayout) a();
        if (r118 == null) goto L28;
        r118.setShowDividers(2);
    L28:
        LinearLayout r119 = (LinearLayout) a();
        if (r119 == null) goto L31;
        r119.setDividerDrawable(com.bytedance.commerce.base.drawable.a.a(AnchorV3RecInShopBoxView$fillWithCommonMeta$3.INSTANCE));
    L31:
        post(new v(this, this.f165463c));
        return;
    L32:
        ((LinearLayout) a()).setVisibility(8);
    }

    public /* synthetic */ AnchorV3RecInShopBoxView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f165462b.c(r100, r101);
    }
}
