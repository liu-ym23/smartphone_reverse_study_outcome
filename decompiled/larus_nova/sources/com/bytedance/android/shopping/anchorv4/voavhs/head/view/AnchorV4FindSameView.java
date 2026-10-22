package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.business.IFindSameGoodsResponseWrapperDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.PicSearchGoodsData;
import com.bytedance.android.shopping.anchorv4.dto.business.PicSearchGoodsResponseWrapperDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.SameGoodsItem;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/AnchorV4FindSameView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/c;", "node", "", "update", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4FindSameView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f168881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f168882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f168883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f168884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f168885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.holder.e f168886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.d f168887g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f168888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AnchorV4FindSameView f168889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.c f168890c;

        public b(TextView r100, AnchorV4FindSameView r101, com.bytedance.android.shopping.anchorv4.voavhs.head.c r102) {
            this.f168888a = r100;
            this.f168889b = r101;
            this.f168890c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.shopping.anchorv4.voavhs.head.holder.e r101 = this.f168889b.f168886f;
            Integer r102 = null;
            if (r101 == null) goto L21;
            com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r103 = r101.f168684b;
            if (r103 == null) goto L21;
            com.bytedance.android.shopping.anchorv4.voavhs.head.c r104 = this.f168890c;
            if (r104 == null) goto L13;
            CommonFindSameElement r105 = r104.f168545r;
            if (r105 == null) goto L13;
            String r106 = r105.getSchema();
            if (r106 == null) goto L13;
            String r107 = com.bytedance.android.ec.core.btm.c.c(r106, this.f168888a, "a1.b8094.c86220.d09040", new Pair[0]);
        L14:
            com.bytedance.android.shopping.anchorv4.voavhs.head.c r108 = this.f168890c;
            if (r108 == null) goto L19;
            CommonFindSameElement r109 = r108.f168545r;
            if (r109 == null) goto L19;
            Integer r110 = r109.getType();
        L20:
            r103.g(r107, null, r110);
        L19:
            r110 = null;
        L13:
            r107 = null;
        L21:
            com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r111 = this.f168889b.f168887g;
            if (r111 == null) goto L32;
            c63.d r112 = r111.t();
            if (r112 == null) goto L33;
            com.bytedance.android.shopping.anchorv4.voavhs.head.c r113 = this.f168890c;
            if (r113 == null) goto L30;
            CommonFindSameElement r114 = r113.f168545r;
            if (r114 == null) goto L30;
            r102 = r114.getType();
        L30:
            r112.m(3, 1, r102);
            return;
        L33:
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4FindSameView f168891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.c f168892b;

        public c(AnchorV4FindSameView r100, com.bytedance.android.shopping.anchorv4.voavhs.head.c r101) {
            this.f168891a = r100;
            this.f168892b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.shopping.anchorv4.voavhs.head.holder.e r101 = this.f168891a.f168886f;
            Integer r102 = null;
            if (r101 == null) goto L17;
            com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r103 = r101.f168684b;
            if (r103 == null) goto L17;
            CommonFindSameElement r104 = this.f168892b.f168545r;
            if (r104 == null) goto L11;
            String r105 = r104.getSchema();
            if (r105 == null) goto L11;
            String r106 = com.bytedance.android.ec.core.btm.c.c(r105, this.f168891a, "a1.b8094.c86220.d09040", new Pair[0]);
        L12:
            com.bytedance.android.shopping.anchorv4.voavhs.head.c r107 = this.f168892b;
            com.bytedance.android.shopping.anchorv4.dto.business.d r108 = r107.f168546s;
            CommonFindSameElement r109 = r107.f168545r;
            if (r109 == null) goto L15;
            Integer r110 = r109.getType();
        L16:
            r103.g(r106, r108, r110);
            goto L17
        L15:
            r110 = null;
        L11:
            r106 = null;
        L17:
            com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r111 = this.f168891a.f168887g;
            if (r111 == null) goto L26;
            c63.d r112 = r111.t();
            if (r112 == null) goto L27;
            CommonFindSameElement r113 = this.f168892b.f168545r;
            if (r113 == null) goto L24;
            r102 = r113.getType();
        L24:
            r112.m(3, 0, r102);
            return;
        L27:
            return;
        }
    }

    public static final class d<T> implements y.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4FindSameView f168893a;

        public d(AnchorV4FindSameView r100) {
            this.f168893a = r100;
        }

        @Override // com.bytedance.android.ec.core.utils.y.c
        public final void accept(Object r100) {
            this.f168893a.post(new g(this, (Bitmap) r100));
        }
    }

    static {
    }

    public AnchorV4FindSameView(Context r100) {
        this(r100, null, 0, null, null, 30);
    }

    public AnchorV4FindSameView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, null, null, 28);
    }

    public AnchorV4FindSameView(Context r100, AttributeSet r101, int r110) {
        this(r100, r101, r110, null, null, 24);
    }

    public final void update(com.bytedance.android.shopping.anchorv4.voavhs.head.c r110) {
        Integer r100 = null;
        if (r110 == null) goto L5;
        com.bytedance.android.shopping.anchorv4.dto.business.d r101 = r110.f168546s;
    L7:
        if ((r101 instanceof IFindSameGoodsResponseWrapperDTO) == true) goto L9;
        r101 = null;
    L9:
        IFindSameGoodsResponseWrapperDTO r102 = (IFindSameGoodsResponseWrapperDTO) r101;
        if (r102 == null) goto L12;
        List<SameGoodsItem> r103 = r102.getFeed();
    L13:
        if (r110 == null) goto L15;
        com.bytedance.android.shopping.anchorv4.dto.business.d r104 = r110.f168546s;
    L17:
        if ((r104 instanceof PicSearchGoodsResponseWrapperDTO) == true) goto L19;
        r104 = null;
    L19:
        PicSearchGoodsResponseWrapperDTO r105 = (PicSearchGoodsResponseWrapperDTO) r104;
        if (r105 == null) goto L22;
        List<PicSearchGoodsData> r106 = r105.getBusinessData();
    L24:
        if (r103 == null) goto L26;
        int r107 = r103.size();
    L27:
        boolean r108 = true;
        if (r107 < 3) goto L30;
        boolean r109 = true;
    L31:
        if (r106 == null) goto L33;
        int r111 = r106.size();
    L34:
        if (r111 < 3) goto L36;
        boolean r112 = true;
    L37:
        if (r110 == null) goto L41;
        com.bytedance.android.shopping.anchorv4.dto.business.d r113 = r110.f168546s;
        if (r113 == null) goto L41;
        Integer r114 = r113.getStatusCodeInt();
    L42:
        if (r114 != null) goto L45;
    L123:
        ConstraintLayout r115 = this.f168885e;
        if (r115 == null) goto L126;
        List<View> r116 = com.bytedance.commerce.base.view.b.a(r115);
    L127:
        if (r116 == null) goto L129;
        int r117 = r116.size();
    L130:
        if (r117 <= 3) goto L132;
        boolean r118 = true;
    L133:
        if (r118 == true) goto L136;
        r116 = null;
    L136:
        if (r116 == null) goto L143;
        List<View> r119 = r116.subList(0, 4);
        if (r119 == null) goto L143;
        Iterator<T> r120 = r119.iterator();
    L141:
        if (r120.hasNext() == false) goto L143;
        ((View) r120.next()).setVisibility(8);
    L143:
        SimpleDraweeView r121 = this.f168881a;
        if (r110 == null) goto L150;
        CommonFindSameElement r122 = r110.f168545r;
        if (r122 == null) goto L150;
        ImageModel r123 = r122.getDefaultImage();
        if (r123 == null) goto L150;
        ECUrlModel r124 = r123.getRemote();
    L151:
        y.a(r121, r124);
        ImageView r125 = this.f168884d;
        if (r125 == null) goto L154;
        r125.setVisibility(0);
    L154:
        TextView r126 = this.f168882b;
        if (r126 == null) goto L157;
        r126.setVisibility(0);
        r126.setOnClickListener(new b(r126, this, r110));
    L157:
        SimpleDraweeView r127 = this.f168881a;
        if (r127 == null) goto L160;
        r127.setVisibility(0);
    L160:
        if (r110 == null) goto L166;
        CommonFindSameElement r128 = r110.f168545r;
        if (r128 == null) goto L166;
        ImageModel r129 = r128.getDefaultImage();
        if (r129 == null) goto L166;
        ECUrlModel r130 = r129.getRemote();
    L167:
        y.l(r130, -1, -1, new d(this));
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r131 = this.f168887g;
        if (r131 == null) goto L187;
        c63.d r132 = r131.t();
        if (r132 != null) goto L172;
        return;
    L172:
        if (r110 == null) goto L176;
        CommonFindSameElement r133 = r110.f168545r;
        if (r133 == null) goto L176;
        r100 = r133.getType();
    L176:
        r132.G(3, 1, r100);
        return;
    L187:
        return;
    L166:
        r130 = null;
    L150:
        r124 = null;
        goto L151
    L132:
        r118 = false;
        goto L133
    L129:
        r117 = 0;
        goto L130
    L126:
        r116 = null;
        goto L127
    L45:
        if (r114.intValue() != 0) goto L123;
        if (r109 == true) goto L48;
        if (r112 == false) goto L123;
    L48:
        if (r103 != null) goto L50;
    L80:
        if (r106 != null) goto L82;
    L112:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r134 = this.f168887g;
        if (r134 == null) goto L120;
        c63.d r135 = r134.t();
        if (r135 == null) goto L120;
        CommonFindSameElement r136 = r110.f168545r;
        if (r136 == null) goto L119;
        r100 = r136.getType();
    L119:
        r135.G(3, 0, r100);
    L120:
        ImageView r137 = this.f168883c;
        if (r137 == null) goto L185;
        r137.setOnClickListener(new c(this, r110));
        return;
    L185:
        return;
    L82:
        if (r106.size() >= 3) goto L85;
        r108 = false;
    L85:
        if (r108 == true) goto L88;
        r106 = null;
    L88:
        if (r106 == null) goto L112;
        List<PicSearchGoodsData> r138 = r106.subList(0, 3);
        if (r138 == null) goto L112;
        Iterator<T> r139 = r138.iterator();
        int r140 = 0;
    L93:
        if (r139.hasNext() == false) goto L112;
        Object r141 = r139.next();
        int r142 = r140 + 1;
        if (r140 >= 0) goto L97;
        CollectionsKt.throwIndexOverflow();
    L97:
        PicSearchGoodsData r143 = (PicSearchGoodsData) r141;
        ConstraintLayout r144 = this.f168885e;
        if (r144 == null) goto L100;
        View r145 = r144.getChildAt(r140);
    L102:
        if ((r145 instanceof AnchorV4FindSameItemView) == true) goto L104;
        r145 = null;
    L104:
        AnchorV4FindSameItemView r146 = (AnchorV4FindSameItemView) r145;
        if (r146 == null) goto L111;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r147 = this.f168887g;
        CommonFindSameElement r148 = r110.f168545r;
        if (r148 == null) goto L109;
        Integer r149 = r148.getType();
    L110:
        r146.update(r140, r147, null, r143, r149);
        goto L111
    L109:
        r149 = null;
    L111:
        r140 = r142;
        goto L93
    L100:
        r145 = null;
        goto L102
    L50:
        if (r103.size() < 3) goto L52;
        boolean r150 = true;
    L53:
        if (r150 == true) goto L56;
        r103 = null;
    L56:
        if (r103 == null) goto L80;
        List<SameGoodsItem> r151 = r103.subList(0, 3);
        if (r151 == null) goto L80;
        Iterator<T> r152 = r151.iterator();
        int r153 = 0;
    L61:
        if (r152.hasNext() == false) goto L80;
        Object r154 = r152.next();
        int r155 = r153 + 1;
        if (r153 >= 0) goto L65;
        CollectionsKt.throwIndexOverflow();
    L65:
        SameGoodsItem r156 = (SameGoodsItem) r154;
        ConstraintLayout r157 = this.f168885e;
        if (r157 == null) goto L68;
        View r158 = r157.getChildAt(r153);
    L70:
        if ((r158 instanceof AnchorV4FindSameItemView) == true) goto L72;
        r158 = null;
    L72:
        AnchorV4FindSameItemView r159 = (AnchorV4FindSameItemView) r158;
        if (r159 == null) goto L79;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r160 = this.f168887g;
        CommonFindSameElement r161 = r110.f168545r;
        if (r161 == null) goto L77;
        Integer r162 = r161.getType();
    L78:
        r159.update(r153, r160, r156, null, r162);
        goto L79
    L77:
        r162 = null;
    L79:
        r153 = r155;
        goto L61
    L68:
        r158 = null;
        goto L70
    L52:
        r150 = false;
    L41:
        r114 = null;
        goto L42
    L36:
        r112 = false;
        goto L37
    L33:
        r111 = 0;
        goto L34
    L30:
        r109 = false;
        goto L31
    L26:
        r107 = 0;
        goto L27
    L22:
        r106 = null;
        goto L24
    L15:
        r104 = null;
        goto L17
    L12:
        r103 = null;
        goto L13
    L5:
        r101 = null;
        goto L7
    }

    public AnchorV4FindSameView(Context r100, AttributeSet r101, int r102, com.bytedance.android.shopping.anchorv4.voavhs.head.holder.e r103, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r104, int r105) {
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
        this.f168886f = r103;
        this.f168887g = r104;
        ShoppingAsyncInflater.f45268e.getClass();
        View r106 = ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v4_find_same_layout, this, true);
        if (s73.b.b() == false) goto L17;
        int r107 = g1.f45599a;
        setBackgroundColor(g1.a.a(r100, R.color.white));
    L18:
        this.f168881a = (SimpleDraweeView) r106.findViewById(R.id.find_same_fall_back_img);
        this.f168882b = (TextView) r106.findViewById(R.id.find_same_fall_back_text);
        this.f168883c = (ImageView) r106.findViewById(R.id.find_same_item_4);
        this.f168884d = (ImageView) r106.findViewById(R.id.find_same_blur_mask);
        this.f168885e = (ConstraintLayout) r106.findViewById(R.id.anchor_v4_find_same_container);
        return;
    L17:
        int r108 = g1.f45599a;
        setBackgroundColor(g1.a.a(r100, R.color.shopping_color_12161823));
        goto L18
    }
}
