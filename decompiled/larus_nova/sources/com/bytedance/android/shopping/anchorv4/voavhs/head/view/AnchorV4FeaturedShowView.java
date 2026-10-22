package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/AnchorV4FeaturedShowView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4FeaturedShowView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f168870a;

    public AnchorV4FeaturedShowView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4FeaturedShowView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r100);
    }

    public AnchorV4FeaturedShowView(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        n1.f45660i.getClass();
        this.f168870a = (n1.a.d() - com.bytedance.android.shopping.extensions.b.b(32)) / 2;
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v4_featured_show_layout, this, true).setBackgroundColor(com.bytedance.android.shopping.extensions.j.b(R.color.shopping_color_CCFFFFFF));
        List r101 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.id.featured_show_image_one), Integer.valueOf(R.id.featured_show_image_two), Integer.valueOf(R.id.featured_show_image_three), Integer.valueOf(R.id.featured_show_image_four)});
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r112.add(findViewById(((Number) r102.next()).intValue()));
        goto L4
    L6:
        Iterator r103 = r112.iterator();
        int r113 = 0;
    L8:
        if (r103.hasNext() == false) goto L24;
        Object r104 = r103.next();
        int r105 = r113 + 1;
        if (r113 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        View r106 = (View) r104;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        int r108 = this.f168870a;
        r107.width = r108;
        if (r113 == 0) goto L23;
        if (r113 == 1) goto L21;
        if (r113 == 2) goto L20;
        if (r113 == 3) goto L19;
        r108 = 0;
        goto L23
    L19:
        r108 = (r108 * 74) / 171;
        goto L23
    L20:
        n1.f45660i.getClass();
        int r114 = n1.a.d() - this.f168870a;
        int r109 = com.bytedance.android.shopping.extensions.j.a(R.dimen.commerce_anchor_v3_top_area_height);
    L22:
        r108 = r114 - r109;
        goto L23
    L21:
        n1.f45660i.getClass();
        r114 = n1.a.d() - ((this.f168870a * 74) / 171);
        r109 = com.bytedance.android.shopping.extensions.j.a(R.dimen.commerce_anchor_v3_top_area_height);
    L23:
        r107.height = r108;
        Unit r115 = Unit.INSTANCE;
        r106.setLayoutParams(r107);
        r113 = r105;
        goto L8
    }

    public final void a(com.bytedance.android.shopping.anchorv4.voavhs.head.holder.d r110, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r111, boolean r112) {
        List r100 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.id.featured_show_image_four), Integer.valueOf(R.id.featured_show_image_one), Integer.valueOf(R.id.featured_show_image_two), Integer.valueOf(R.id.featured_show_image_three)});
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add((SimpleDraweeView) findViewById(((Number) r102.next()).intValue()));
        goto L4
    L6:
        Iterator r103 = r101.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L22;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        SimpleDraweeView r107 = (SimpleDraweeView) r105;
        if (r110 == null) goto L21;
        w r108 = r110.f168681a;
        if (r108 == null) goto L21;
        List<ImageModel> r109 = r108.c();
        if (r109 == null) goto L21;
        ImageModel r113 = (ImageModel) CollectionsKt.getOrNull(r109, r104);
        if (r113 == null) goto L21;
        y.a(r107, r113.getRemote());
    L21:
        r104 = r106;
        goto L8
    L22:
        TextWithOneIconElementView r114 = (TextWithOneIconElementView) findViewById(R.id.featured_show_more_hint);
        if (r112 == false) goto L25;
        r114.setVisibility(8);
    L32:
        if (r110 == null) goto L36;
        String r115 = r110.f168682b;
        if (r115 == null) goto L36;
    L37:
        setContentDescription(r115);
        if (r112 == false) goto L48;
        setBackgroundColor(-1);
        postDelayed(new f(this), 300);
        return;
    L48:
        return;
    L36:
        r115 = "图片，商品评论";
        goto L37
    L25:
        r114.setVisibility(0);
        if (r110 == null) goto L30;
        w r116 = r110.f168681a;
        if (r116 == null) goto L30;
        TextWithOneIconElement r117 = r116.d();
    L31:
        TextWithOneIconElementView.b(r114, r117, null, false, null, 14);
        r114.setOnClickListener(new e(r111));
    L30:
        r117 = null;
        goto L31
    }

    public /* synthetic */ AnchorV4FeaturedShowView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
