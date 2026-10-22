package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yd3.t;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\n\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeViewStyle2;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNodeViewStyle2 extends HeaderNodeView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f175249i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECDraweeView f175250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECDraweeView f175251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f175252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f175253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ECDraweeView f175254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f175255h;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f175256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f175257b;

        public b(int r100, int r101) {
            this.f175256a = r100;
            this.f175257b = r101;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECDraweeView f175258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f175259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f175260c;

        public c(ECDraweeView r100, t r101, b r102) {
            this.f175258a = r100;
            this.f175259b = r101;
            this.f175260c = r102;
        }

        public final void a() {
            ECDraweeView r100 = this.f175258a;
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();
            if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
            r101 = null;
        L5:
            ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
            if (r102 == null) goto L21;
            r102.topMargin = 0;
            r102.bottomMargin = 0;
            t r103 = this.f175259b;
            if (r103 == null) goto L12;
            Integer r104 = r103.f();
            if (r104 == null) goto L12;
            int r105 = r104.intValue();
        L13:
            r102.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r105));
            t r106 = this.f175259b;
            if (r106 == null) goto L18;
            Integer r107 = r106.e();
            if (r107 == null) goto L18;
            int r108 = r107.intValue();
        L19:
            r102.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r108));
            r100.setLayoutParams(r102);
            return;
        L18:
            r108 = this.f175260c.f175256a;
        L12:
            r105 = this.f175260c.f175257b;
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public HeaderNodeViewStyle2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HeaderNodeViewStyle2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.HeaderNodeView
    public final void a(rd3.a r110) {
        Intrinsics.checkNotNullParameter(r110, "anchorInflowFeedItem");
        super.a(r110);
        ECDraweeView r100 = this.f175250c;
        TextView r101 = this.f175255h;
        yd3.f r102 = getHeaderNode();
        ViewGroup.LayoutParams r103 = null;
        if (r102 == null) goto L5;
        t r104 = r102.f();
    L6:
        String r105 = "#161823";
        b(r100, r101, r104, new b(12, 8), "#161823");
        ECDraweeView r106 = this.f175251d;
        TextView r107 = this.f175252e;
        yd3.f r108 = getHeaderNode();
        if (r108 == null) goto L9;
        t r109 = r108.d();
    L10:
        b(r106, r107, r109, new b(0, 0), "#E6FFFFFF");
        setPadding(0, 0, 0, 0);
        yd3.f r111 = getHeaderNode();
        if (r111 == null) goto L15;
        yd3.g r112 = r111.c();
        if (r112 == null) goto L15;
        String r113 = r112.d();
    L16:
        boolean r114 = true;
        if (a2.b(r113) == false) goto L71;
        TextView r115 = this.f175253f;
        r115.setVisibility(0);
        yd3.f r116 = getHeaderNode();
        if (r116 == null) goto L23;
        yd3.g r117 = r116.c();
        if (r117 == null) goto L23;
        String r118 = r117.d();
    L24:
        r115.setText(r118);
        yd3.f r119 = getHeaderNode();
        if (r119 == null) goto L31;
        yd3.g r120 = r119.c();
        if (r120 == null) goto L31;
        Integer r121 = r120.e();
        if (r121 == null) goto L31;
        float r122 = r121.intValue();
    L32:
        r115.setTextSize(1, r122);
        yd3.f r123 = getHeaderNode();
        if (r123 == null) goto L37;
        yd3.g r124 = r123.c();
        if (r124 == null) goto L37;
        String r125 = r124.a();
    L39:
        if (a2.b(r125) == false) goto L46;
        yd3.f r126 = getHeaderNode();
        if (r126 == null) goto L45;
        yd3.g r127 = r126.c();
        if (r127 == null) goto L45;
        r105 = r127.a();
    L45:
        r105 = null;
    L46:
        Integer r128 = com.bytedance.android.ec.core.utils.s.b(r105);
        if (r128 == null) goto L49;
        r115.setTextColor(r128.intValue());
    L49:
        TextView r129 = this.f175253f;
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
        if ((r130 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
        r130 = null;
    L52:
        ViewGroup.MarginLayoutParams r131 = (ViewGroup.MarginLayoutParams) r130;
        if (r131 == null) goto L72;
        yd3.f r132 = getHeaderNode();
        if (r132 == null) goto L61;
        yd3.g r133 = r132.c();
        if (r133 == null) goto L61;
        Integer r134 = r133.i();
        if (r134 == null) goto L61;
        int r135 = r134.intValue();
    L62:
        r131.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r135));
        r131.topMargin = 0;
        r131.bottomMargin = 0;
        yd3.f r136 = getHeaderNode();
        if (r136 == null) goto L69;
        yd3.g r137 = r136.c();
        if (r137 == null) goto L69;
        Integer r138 = r137.h();
        if (r138 == null) goto L69;
        int r139 = r138.intValue();
    L70:
        r131.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r139));
        r129.setLayoutParams(r131);
    L69:
        r139 = 0;
    L61:
        r135 = 12;
    L72:
        yd3.f r140 = getHeaderNode();
        if (r140 == null) goto L103;
        yd3.g r141 = r140.c();
        if (r141 == null) goto L103;
        ECUrlModel r142 = r141.b();
        if (r142 == null) goto L103;
        ECDraweeView r143 = this.f175254g;
        r143.setVisibility(0);
        ImageExtensionsKt.v(r143, r142, null, 8190);
        ViewGroup.LayoutParams r144 = this.f175254g.getLayoutParams();
        if (r144 == null) goto L81;
        r144.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r142.getWidth()));
        r144.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r142.getHeight()));
        this.f175254g.setLayoutParams(r144);
    L81:
        ECDraweeView r145 = this.f175254g;
        ViewGroup.LayoutParams r146 = r145.getLayoutParams();
        if ((r146 instanceof ViewGroup.MarginLayoutParams) == true) goto L84;
        r146 = null;
    L84:
        ViewGroup.MarginLayoutParams r147 = (ViewGroup.MarginLayoutParams) r146;
        if (r147 == null) goto L104;
        yd3.f r148 = getHeaderNode();
        if (r148 == null) goto L93;
        yd3.g r149 = r148.c();
        if (r149 == null) goto L93;
        Integer r150 = r149.g();
        if (r150 == null) goto L93;
        int r151 = r150.intValue();
    L94:
        r147.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r151));
        r147.topMargin = 0;
        r147.bottomMargin = 0;
        yd3.f r152 = getHeaderNode();
        if (r152 == null) goto L101;
        yd3.g r153 = r152.c();
        if (r153 == null) goto L101;
        Integer r154 = r153.f();
        if (r154 == null) goto L101;
        int r155 = r154.intValue();
    L102:
        r147.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r155));
        r145.setLayoutParams(r147);
    L101:
        r155 = 0;
    L93:
        r151 = 12;
    L104:
        yd3.f r156 = getHeaderNode();
        if (r156 == null) goto L109;
        yd3.g r157 = r156.c();
        if (r157 == null) goto L109;
        String r158 = r157.d();
    L110:
        if (r158 != null) goto L112;
    L115:
        if (r114 == false) goto L135;
        yd3.f r159 = getHeaderNode();
        if (r159 == null) goto L121;
        yd3.g r160 = r159.c();
        if (r160 == null) goto L121;
        ECUrlModel r161 = r160.b();
    L122:
        if (r161 != null) goto L136;
        yd3.p r162 = r110.i();
        if (r162 != null) goto L126;
        return;
    L126:
        if (r162.getType() != 7) goto L138;
        this.f175254g.setImageResource(R.drawable.commerce_button_node_view_header_white);
        this.f175254g.setVisibility(0);
        ECDraweeView r163 = this.f175254g;
        ViewGroup.LayoutParams r164 = r163.getLayoutParams();
        if ((r164 instanceof ViewGroup.MarginLayoutParams) == false) goto L131;
        r103 = r164;
    L131:
        ViewGroup.MarginLayoutParams r165 = (ViewGroup.MarginLayoutParams) r103;
        if (r165 == null) goto L139;
        r165.rightMargin = 12;
        r163.setLayoutParams(r165);
        return;
    L139:
        return;
    L138:
        return;
    L136:
        return;
    L121:
        r161 = null;
        goto L122
    L135:
        return;
    L112:
        if (r158.length() == 0) goto L115;
        r114 = false;
    L109:
        r158 = null;
    L103:
        this.f175254g.setVisibility(8);
    L37:
        r125 = null;
    L31:
        r122 = 13.0f;
    L23:
        r118 = null;
        goto L24
    L71:
        this.f175253f.setVisibility(8);
    L15:
        r113 = null;
        goto L16
    L9:
        r109 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public HeaderNodeViewStyle2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_header_node_view_style_2, this, true);
        this.f175250c = (ECDraweeView) findViewById(R.id.title_img_dv);
        this.f175251d = (ECDraweeView) findViewById(R.id.sub_title_img_dv);
        this.f175252e = (TextView) findViewById(R.id.sub_title_tv);
        this.f175254g = (ECDraweeView) findViewById(R.id.right_icon);
        this.f175255h = (TextView) findViewById(R.id.title_tv);
        this.f175253f = (TextView) findViewById(R.id.right_icon_tv);
    }

    public /* synthetic */ HeaderNodeViewStyle2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void b(ECDraweeView r100, TextView r101, t r102, b r103, String r104) {
        if (r102 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r105 = null;
        Integer r106 = null;
        if (r102.b() == null) goto L16;
        ECUrlModel r107 = r102.b();
        if (r107 == null) goto L9;
        r106 = Integer.valueOf(r107.getHeight());
    L9:
        int r108 = r106.intValue();
        if (r108 > 0) goto L12;
        r108 = 20;
    L12:
        ViewGroup.LayoutParams r109 = r100.getLayoutParams();
        if (r109 == null) goto L15;
        r109.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r108));
        r100.setLayoutParams(r109);
    L15:
        r100.post(new c(r100, r102, r103));
        r101.setVisibility(8);
        r100.setVisibility(0);
        y.a(r100, r102.b());
        return;
    L16:
        ViewGroup.LayoutParams r110 = r101.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        r105 = r110;
    L20:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r105;
        if (r111 == null) goto L31;
        r111.topMargin = 0;
        r111.bottomMargin = 0;
        Integer r112 = r102.f();
        if (r112 == null) goto L25;
        int r113 = r112.intValue();
    L26:
        r111.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r113));
        Integer r114 = r102.e();
        if (r114 == null) goto L29;
        int r115 = r114.intValue();
    L30:
        r111.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r115));
        r101.setLayoutParams(r111);
        goto L31
    L29:
        r115 = r103.f175256a;
        goto L30
    L25:
        r113 = r103.f175257b;
    L31:
        r101.setText(r102.c());
        Integer r116 = r102.d();
        if (r116 == null) goto L34;
        int r117 = r116.intValue();
    L35:
        r101.setTextSize(r117);
        if (a2.b(r102.a()) == false) goto L38;
        r104 = r102.a();
    L38:
        r101.setTextColor(ColorProtector.parseColor(r104));
        r101.setVisibility(0);
        r100.setVisibility(8);
        return;
    L34:
        r117 = 14;
        goto L35
    }
}
