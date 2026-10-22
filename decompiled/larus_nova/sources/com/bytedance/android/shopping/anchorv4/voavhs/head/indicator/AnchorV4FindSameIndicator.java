package com.bytedance.android.shopping.anchorv4.voavhs.head.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import c63.d;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.business.PicSearchGoodsData;
import com.bytedance.android.shopping.anchorv4.dto.business.PicSearchItemData;
import com.bytedance.android.shopping.anchorv4.dto.business.ProductInfo;
import com.bytedance.android.shopping.anchorv4.dto.business.SameGoodsItem;
import com.bytedance.android.shopping.anchorv4.dto.business.g;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.t;
import com.bytedance.commerce.base.view.b;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import f83.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import th.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/indicator/AnchorV4FindSameIndicator;", "Landroid/widget/LinearLayout;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4FindSameIndicator extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f168731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f168732b;

    public AnchorV4FindSameIndicator(Context r100) {
        this(r100, null, 0, null, null, 30);
    }

    public AnchorV4FindSameIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 0, null, null, 28);
    }

    public AnchorV4FindSameIndicator(Context r100, AttributeSet r101, int r110) {
        this(r100, r101, r110, null, null, 24);
    }

    public final void a(com.bytedance.android.shopping.anchorv4.dto.business.d r100, CommonFindSameElement r110, t r111) {
        int r101 = 0;
        if (r100 == null) goto L16;
        List<SameGoodsItem> r102 = r100.getFeedStruct();
        if (r102 == null) goto L16;
        if (r102.size() < 3) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L16;
        List<PicSearchGoodsData> r104 = r102.subList(0, 3);
        if (r104 == null) goto L16;
    L29:
        setVisibility(8);
        p r105 = this.f168732b;
        if (r105 == null) goto L32;
        r105.e(null);
    L32:
        if (r104 == null) goto L77;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r104.iterator();
    L35:
        if (r107.hasNext() == false) goto L77;
        Object r108 = r107.next();
        int r109 = r101 + 1;
        if (r101 >= 0) goto L39;
        CollectionsKt.throwIndexOverflow();
    L39:
        Serializable r112 = (Serializable) r108;
        Object r113 = CollectionsKt.getOrNull(b.a(this), r101);
        if ((r113 instanceof SimpleDraweeView) == true) goto L42;
        r113 = null;
    L42:
        SimpleDraweeView r114 = (SimpleDraweeView) r113;
        if (r114 != null) goto L45;
    L67:
        d r115 = this.f168731a;
        if (r115 == null) goto L73;
        if (r110 == null) goto L71;
        Integer r116 = r110.getType();
    L72:
        r115.G(1, null, r116);
        Unit r117 = Unit.INSTANCE;
    L74:
        if (r117 == null) goto L76;
        r106.add(r117);
    L76:
        r101 = r109;
        goto L35
    L71:
        r116 = null;
        goto L72
    L73:
        r117 = null;
        goto L74
    L45:
        if ((r112 instanceof SameGoodsItem) == true) goto L47;
        Serializable r118 = null;
    L48:
        SameGoodsItem r119 = (SameGoodsItem) r118;
        if (r119 == null) goto L56;
        g r120 = r119.getProduct();
        if (r120 == null) goto L56;
        ECUrlModel r121 = r120.a();
        if (r121 == null) goto L56;
        y.a(r114, r121);
    L56:
        if ((r112 instanceof PicSearchGoodsData) == true) goto L58;
        r112 = null;
    L58:
        PicSearchGoodsData r122 = (PicSearchGoodsData) r112;
        if (r122 == null) goto L67;
        PicSearchItemData r123 = r122.getData();
        if (r123 == null) goto L67;
        ProductInfo r124 = r123.getProductInfo();
        if (r124 == null) goto L67;
        String r125 = r124.getImg();
        if (r125 == null) goto L67;
        y.d(r114, r125);
        goto L67
    L47:
        r118 = r112;
    L77:
        setOnClickListener(new f83.b(this, r111, r110, r100));
        return;
    L9:
        r103 = false;
    L16:
        if (r100 == null) goto L28;
        List<PicSearchGoodsData> r126 = r100.getBusinessDataStruct();
        if (r126 == null) goto L28;
        if (r126.size() < 3) goto L22;
        boolean r127 = true;
    L23:
        if (r127 == true) goto L26;
        r126 = null;
    L26:
        if (r126 == null) goto L28;
        r104 = r126.subList(0, 3);
        goto L29
    L22:
        r127 = false;
    L28:
        r104 = null;
        goto L29
    }

    public AnchorV4FindSameIndicator(Context r100, AttributeSet r101, int r102, d r103, p r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L14;
        r104 = null;
    L14:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f168731a = r103;
        this.f168732b = r104;
        a.c(r100, R.layout.ec_commerce_anchor_v4_find_same_indicator_layout, this, true);
        setBackgroundResource(R.drawable.commerce_anchor_v4_find_same_indicator_bg);
    }
}
