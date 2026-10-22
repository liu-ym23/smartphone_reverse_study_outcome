package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.sku.SkuStatusDetail;
import com.bytedance.commerce.base.richtext.SpanUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemOptimizeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getAtmosphereColor", "getCurrentPosition", "Lcom/bytedance/android/ec/common/impl/sku/view/r;", "clickListener", "", "setItemClickListener", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecItemOptimizeView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f43445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s.c f43446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f43447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f43448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f43449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f43450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SimpleDraweeView f43451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f43452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f43453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConstraintLayout f43454j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SimpleDraweeView f43455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f43456l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f43457m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f43458n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SkuViewModel f43459o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f43460p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function1<? super Integer, Unit> f43461q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SpecItemOptimizeGroupLayout.e f43462r;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpecItemOptimizeView f43464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f43465b;

        public a(SpecItemOptimizeView r100, r r101) {
            this.f43464a = r100;
            this.f43465b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (r100.getId() != R.id.iv_big_pic_gallery) goto L5;
            return;
        L5:
            s.c r101 = this.f43464a.f43446b;
            if ((r100 instanceof ConstraintLayout) == true) goto L8;
            r100 = null;
        L8:
            ConstraintLayout r102 = (ConstraintLayout) r100;
            if (r101 == null) goto L13;
            if (r102 == null) goto L14;
            this.f43465b.a(r101);
            return;
        L14:
            return;
        }
    }

    private final int getAtmosphereColor() {
        SkuViewModel r100 = this.f43459o;
        if (r100 == null) goto L13;
        QLiveData<Integer> r101 = r100.getCurrentAtmosphereStyle();
        if (r101 == null) goto L13;
        Integer r102 = r101.a();
        if (r102 == null) goto L13;
        if (r102.intValue() == 2) goto L15;
        return ColorProtector.parseColor("#FF3B52");
    L15:
        return ColorProtector.parseColor("#9E2DF5");
    L13:
        return ColorProtector.parseColor("#FF3B52");
    }

    private final int getCurrentPosition() {
        s.c r100 = this.f43446b;
        if (r100 == null) goto L18;
        String r101 = r100.f43570c;
        if (r101 == null) goto L18;
        SkuViewModel r102 = this.f43459o;
        if (r102 == null) goto L18;
        List<String> r103 = r102.getFirstIdList();
        if (r103 == null) goto L18;
        int r104 = r103.size();
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L18;
        if (TextUtils.equals(r101, (CharSequence) ListProtector.get(r103, r105)) == true) goto L16;
        r105 = r105 + 1;
        goto L12
    L16:
        return r105 + 1;
    L18:
        return 0;
    }

    public final void V5() {
        this.f43450f.setAlpha(1.0f);
        this.f43454j.setAlpha(1.0f);
        int r100 = getAtmosphereColor();
        if (this.f43448d == false) goto L5;
        this.f43452h.setTextColor(r100);
        GradientDrawable r101 = new GradientDrawable();
        r101.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(6));
        r101.setColor(com.bytedance.android.ec.common.impl.sku.utils.m.a(r100, 0.05f));
        r101.setStroke(vf4.a.b(1), com.bytedance.android.ec.common.impl.sku.utils.m.a(r100, 0.5f));
        this.f43450f.setBackgroundDrawable(r101);
        this.f43452h.setTypeface(Typeface.defaultFromStyle(1));
        this.f43453i.setVisibility(0);
    L9:
        this.f43458n.setVisibility(4);
        return;
    L5:
        this.f43456l.setTextColor(r100);
        this.f43457m.setTextColor(r100);
        GradientDrawable r102 = new GradientDrawable();
        r102.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(6));
        r102.setColor(com.bytedance.android.ec.common.impl.sku.utils.m.a(r100, 0.05f));
        r102.setStroke(vf4.a.b(1), com.bytedance.android.ec.common.impl.sku.utils.m.a(r100, 0.5f));
        this.f43454j.setBackgroundDrawable(r102);
        this.f43456l.setTypeface(Typeface.defaultFromStyle(1));
        this.f43457m.setTypeface(Typeface.defaultFromStyle(1));
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L8;
        this.f43453i.setVisibility(0);
        goto L9
    L8:
        this.f43453i.setVisibility(8);
        goto L9
    }

    public final void Y5() {
        this.f43450f.setAlpha(1.0f);
        this.f43454j.setAlpha(1.0f);
        if (this.f43448d == false) goto L5;
        this.f43452h.setTextColor(ColorProtector.parseColor("#161823"));
        this.f43452h.setTypeface(Typeface.defaultFromStyle(0));
        this.f43450f.setBackgroundResource(R.drawable.shopping_sku_spec_unselect);
        this.f43453i.setVisibility(0);
    L9:
        this.f43458n.setVisibility(4);
        return;
    L5:
        this.f43456l.setTextColor(ColorProtector.parseColor("#161823"));
        this.f43457m.setTextColor(ColorProtector.parseColor("#161823"));
        this.f43456l.setTypeface(Typeface.defaultFromStyle(0));
        this.f43457m.setTypeface(Typeface.defaultFromStyle(0));
        this.f43454j.setBackgroundResource(R.drawable.shopping_sku_spec_unselect);
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L8;
        this.f43453i.setVisibility(0);
        goto L9
    L8:
        this.f43453i.setVisibility(8);
        goto L9
    }

    public final void Z5() {
        if (this.f43445a == false) goto L19;
        s.c r100 = this.f43446b;
        if (r100 != null) goto L7;
    L9:
        SkuStatusDetail r101 = null;
        if (this.f43447c == false) goto L15;
        V5();
        s.c r102 = this.f43446b;
        if (r102 == null) goto L14;
        r101 = r102.f43569b;
    L14:
        c6(r101, true);
        return;
    L15:
        Y5();
        s.c r103 = this.f43446b;
        if (r103 == null) goto L18;
        r101 = r103.f43569b;
    L18:
        c6(r101, false);
        return;
    L7:
        if (r100.f43568a == true) goto L9;
    L19:
        U5();
    }

    public final void U5() {
        Y5();
        this.f43450f.setAlpha(0.34f);
        this.f43454j.setAlpha(0.34f);
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L5;
        this.f43453i.setVisibility(0);
    L6:
        s.c r100 = this.f43446b;
        if (r100 == null) goto L9;
        SkuStatusDetail r101 = r100.f43569b;
    L10:
        c6(r101, false);
        this.f43453i.setVisibility(8);
        return;
    L9:
        r101 = null;
        goto L10
    L5:
        this.f43453i.setVisibility(8);
        goto L6
    }

    public static final /* synthetic */ int R5(SpecItemOptimizeView r100) {
        return r100.getCurrentPosition();
    }

    public final void b6(s.c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r101 = false;
        if (this.f43448d == false) goto L19;
        this.f43450f.setVisibility(0);
        this.f43453i.setVisibility(0);
        this.f43454j.setVisibility(8);
        SimpleDraweeView r102 = this.f43451g;
        Map<String, String> r103 = r100.f43576i;
        if (r103 == null) goto L9;
        String r104 = r103.get(r100.f43570c);
    L10:
        com.bytedance.android.ec.core.utils.y.d(r102, r104);
        this.f43452h.setText(r100.f43571d);
        this.f43453i.setOnClickListener(new b0(this));
        int r105 = UIUtils.getScreenWidth(getContext());     // Catch: Exception -> L13
        this.f43449e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));     // Catch: Exception -> L13
        int r106 = ((((((((r105 - vf4.a.b(8)) - vf4.a.b(8)) - vf4.a.b(12)) - vf4.a.b(8)) - vf4.a.b(8)) - vf4.a.b(8)) - vf4.a.b(4)) - vf4.a.b(3)) / 3;     // Catch: Exception -> L13
        float r107 = r106;
        float r108 = r107 / vf4.a.b(106);     // Catch: Exception -> L13
        float r109 = r107 * (vf4.a.b(149) / vf4.a.b(106));     // Catch: Exception -> L13
        ConstraintLayout r110 = this.f43449e;     // Catch: Exception -> L13
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();     // Catch: Exception -> L13
        r111.width = r106;     // Catch: Exception -> L13
        r111.height = (int) r109;     // Catch: Exception -> L13
        Unit r112 = Unit.INSTANCE;     // Catch: Exception -> L13
        r110.setLayoutParams(r111);     // Catch: Exception -> L13
        int r113 = (int) (r108 * vf4.a.b(104));     // Catch: Exception -> L13
        SimpleDraweeView r114 = this.f43451g;     // Catch: Exception -> L13
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();     // Catch: Exception -> L13
        r115.width = r113;     // Catch: Exception -> L13
        r115.height = r113;     // Catch: Exception -> L13
        r114.setLayoutParams(r115);     // Catch: Exception -> L13
    L14:
        ECUrlModel r116 = r100.f43574g;
        if (r116 == null) goto L17;
        com.bytedance.android.ec.core.utils.y.l(r116, 0, 0, new w(this, r100));
    L18:
        this.f43452h.getViewTreeObserver().addOnGlobalLayoutListener(new x(this));
        return;
    L17:
        SpanUtils r117 = new SpanUtils(this.f43452h);
        r117.a(r100.f43571d);
        r117.c();
        goto L18
    L9:
        r104 = null;
        goto L10
    L19:
        this.f43450f.setVisibility(8);
        this.f43453i.setVisibility(8);
        this.f43454j.setVisibility(0);
        this.f43456l.setText(r100.f43571d);
        String r118 = r100.f43572e;
        if (r118 != null) goto L22;
    L25:
        boolean r119 = true;
    L26:
        if (r119 == false) goto L28;
        this.f43457m.setVisibility(8);
    L29:
        Map<String, String> r120 = r100.f43575h;
        if (r120 == null) goto L34;
        String r121 = r120.get(r100.f43570c);
        if (r121 == null) goto L34;
        this.f43455k.setVisibility(0);
        com.bytedance.android.ec.core.utils.y.d(this.f43455k, r121);
    L35:
        ECUrlModel r122 = r100.f43574g;
        if (r122 == null) goto L38;
        com.bytedance.android.ec.core.utils.y.l(r122, 0, 0, new z(this, r100));
    L39:
        this.f43456l.getViewTreeObserver().addOnGlobalLayoutListener(new a0(this));
        if (this.f43455k.getVisibility() != 0) goto L42;
        boolean r123 = true;
    L44:
        if (r123 == false) goto L47;
        this.f43456l.setPadding(vf4.a.b(8), 0, vf4.a.b(12), 0);
    L53:
        int r124 = UIUtils.getScreenWidth(getContext());
        ConstraintLayout r125 = this.f43449e;
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
        r126.width = -2;
        r126.height = -2;
        Unit r127 = Unit.INSTANCE;
        r125.setLayoutParams(r126);
        if (this.f43457m.getVisibility() != 0) goto L56;
        boolean r128 = true;
    L58:
        if (r128 == false) goto L63;
        this.f43449e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r129 = this.f43449e.getMeasuredWidth();
        int r130 = (((r124 - vf4.a.b(16)) - vf4.a.b(24)) - vf4.a.b(12)) / 2;
        TextView r131 = this.f43456l;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
        r132.width = vf4.a.b(0);
        r131.setLayoutParams(r132);
        if (r129 <= r130) goto L62;
        ConstraintLayout r133 = this.f43454j;
        ViewGroup.LayoutParams r134 = r133.getLayoutParams();
        r134.width = ((r124 - vf4.a.b(16)) - vf4.a.b(24)) - vf4.a.b(6);
        r133.setLayoutParams(r134);
        return;
    L62:
        ConstraintLayout r135 = this.f43454j;
        ViewGroup.LayoutParams r136 = r135.getLayoutParams();
        r136.width = r130;
        r135.setLayoutParams(r136);
        return;
    L63:
        TextView r137 = this.f43456l;
        ViewGroup.LayoutParams r138 = r137.getLayoutParams();
        r138.width = -2;
        r137.setLayoutParams(r138);
        TextView r139 = this.f43456l;
        if (this.f43455k.getVisibility() != 0) goto L66;
        r101 = true;
    L66:
        if (r101 == false) goto L68;
        int r140 = ((r124 - vf4.a.b(16)) - vf4.a.b(24)) - vf4.a.b(6);
        int r141 = vf4.a.b(48);
    L69:
        r139.setMaxWidth(r140 - r141);
        return;
    L68:
        r140 = ((r124 - vf4.a.b(16)) - vf4.a.b(24)) - vf4.a.b(6);
        r141 = vf4.a.b(20);
        goto L69
    L56:
        r128 = false;
        goto L58
    L47:
        if (this.f43457m.getVisibility() != 0) goto L49;
        boolean r142 = true;
    L50:
        if (r142 == false) goto L52;
        this.f43456l.setPadding(vf4.a.b(16), 0, vf4.a.b(8), 0);
        goto L53
    L52:
        this.f43456l.setPadding(vf4.a.b(16), 0, vf4.a.b(16), 0);
        goto L53
    L49:
        r142 = false;
        goto L50
    L42:
        r123 = false;
        goto L44
    L38:
        SpanUtils r143 = new SpanUtils(this.f43456l);
        r143.a(r100.f43571d);
        r143.c();
    L34:
        this.f43455k.setVisibility(8);
        goto L35
    L28:
        this.f43457m.setVisibility(0);
        this.f43457m.setText(r100.f43572e);
        goto L29
    L22:
        if (r118.length() == 0) goto L25;
        r119 = false;
        goto L26
    }

    public final void setItemClickListener(r r100) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
        setOnClickListener(new a(this, r100));
    }

    public SpecItemOptimizeView(Context r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f43462r = r101;
        ViewGroup.inflate(r100, R.layout.shopping_layout_sku_spec_item_optimize_view, this);
        this.f43449e = (ConstraintLayout) findViewById(R.id.cl_switch_mode_container);
        this.f43450f = (ConstraintLayout) findViewById(R.id.cl_big_pic_container);
        this.f43451g = (SimpleDraweeView) findViewById(R.id.sdv_big_pic_spec_pic);
        this.f43452h = (TextView) findViewById(R.id.tv_big_pic_spec_name);
        this.f43453i = (ImageView) findViewById(R.id.iv_big_pic_gallery);
        this.f43454j = (ConstraintLayout) findViewById(R.id.cl_small_pic_container);
        this.f43455k = (SimpleDraweeView) findViewById(R.id.sdv_small_pic_spec_pic);
        this.f43456l = (TextView) findViewById(R.id.tv_small_pic_spec_name);
        this.f43457m = (TextView) findViewById(R.id.tv_small_pic_price);
        this.f43458n = (TextView) findViewById(R.id.tv_sku_status);
        AccessibilityDelegateCompat r102 = new AnonymousClass1(this);
        int r103 = jg.a.f498940a;
        ViewCompat.setAccessibilityDelegate(this, r102);
    }

    public final void S5(s.c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "viewInfo");
        this.f43446b = r100.a();
        if (this.f43445a == true) goto L5;
    L16:
        U5();
        this.f43447c = false;
        return;
    L5:
        if (r100.f43568a == false) goto L16;
        SpecItemOptimizeGroupLayout.e r102 = this.f43462r;
        if (r102 == null) goto L10;
        s.c r103 = r102.getCheckedItemViewInfo();
    L11:
        if (r103 != null) goto L13;
    L15:
        Y5();
        c6(r100.f43569b, false);
        this.f43447c = false;
        return;
    L13:
        if (TextUtils.equals(r101, r100.f43570c) == false) goto L15;
        V5();
        c6(r100.f43569b, true);
        this.f43447c = true;
        return;
    L10:
        r103 = null;
        goto L11
    }

    public final void T5(int r100, s.c r101) {
        if (r100 != 0) goto L20;
        boolean r102 = this.f43448d;
        if (r102 == true) goto L21;
        boolean r103 = false;
        if (r102 == false) goto L10;
        SkuViewModel r104 = this.f43459o;
        if (r104 == null) goto L22;
        r104.setCurrentSpecHasPic(false);
        return;
    L22:
        return;
    L10:
        SkuViewModel r105 = this.f43459o;
        if (r105 == null) goto L24;
        if (r101 == null) goto L18;
        Map<String, String> r106 = r101.f43575h;
        if (r106 == null) goto L18;
        if (r106.isEmpty() == true) goto L18;
        r103 = true;
    L18:
        r105.setCurrentSpecHasPic(r103);
        return;
    L24:
        return;
    L21:
        return;
    }

    public final void c6(SkuStatusDetail r110, boolean r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        int r100 = 0;
        boolean r101 = true;
        if (r110.canAppointNoStock() == true) goto L7;
    L22:
        TextView r112 = this.f43458n;
        s.c r113 = this.f43446b;
        if (r113 == null) goto L29;
        SkuStatusDetail r114 = r113.f43569b;
        if (r114 == null) goto L29;
        String r115 = r114.getDesc();
        if (r115 == null) goto L29;
    L30:
        r112.setText(r115);
        int r116 = com.bytedance.android.ec.core.utils.s.f45717a;
        s.c r117 = this.f43446b;
        String r118 = null;
        if (r117 == null) goto L35;
        SkuStatusDetail r119 = r117.f43569b;
        if (r119 == null) goto L35;
        String r120 = r119.getDescBgColor();
    L36:
        Integer r121 = com.bytedance.android.ec.core.utils.s.b(r120);
        if (r121 == null) goto L45;
        int r122 = r121.intValue();
        int r102 = g1.f45599a;
        Drawable r103 = g1.a.b(getContext(), R.drawable.shopping_sku_spec_no_stock);
        if (r103 == null) goto L41;
        Drawable r104 = r103.mutate();
    L42:
        if (r104 == null) goto L44;
        r104.setColorFilter(r122, PorterDuff.Mode.SRC_IN);
    L44:
        this.f43458n.setBackground(r104);
        goto L45
    L41:
        r104 = null;
    L45:
        s.c r123 = this.f43446b;
        if (r123 == null) goto L50;
        SkuStatusDetail r124 = r123.f43569b;
        if (r124 == null) goto L50;
        String r125 = r124.getFontColor();
    L51:
        Integer r126 = com.bytedance.android.ec.core.utils.s.b(r125);
        if (r126 == null) goto L54;
        this.f43458n.setTextColor(r126.intValue());
    L54:
        TextView r127 = this.f43458n;
        s.c r105 = this.f43446b;
        if (r105 == null) goto L59;
        SkuStatusDetail r106 = r105.f43569b;
        if (r106 == null) goto L59;
        r118 = r106.getDesc();
    L59:
        if (r118 != null) goto L61;
    L64:
        if (r101 == false) goto L66;
        r100 = 8;
    L66:
        r127.setVisibility(r100);
        return;
    L61:
        if (r118.length() == 0) goto L64;
        r101 = false;
    L50:
        r125 = null;
    L35:
        r120 = null;
    L29:
        r115 = "";
        goto L30
    L7:
        if (r111 == false) goto L15;
        this.f43450f.setAlpha(1.0f);
        this.f43454j.setAlpha(1.0f);
        int r128 = getAtmosphereColor();
        int r107 = ColorProtector.parseColor("#161823");
        if (this.f43448d == false) goto L11;
        this.f43452h.setTextColor(ColorProtector.parseColor("#57161823"));
        GradientDrawable r129 = new GradientDrawable();
        r129.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(6));
        r129.setColor(com.bytedance.android.ec.common.impl.sku.utils.m.a(r107, 0.05f));
        r129.setStroke(vf4.a.b(1), com.bytedance.android.ec.common.impl.sku.utils.m.a(r128, 0.5f));
        this.f43450f.setBackgroundDrawable(r129);
        this.f43452h.setTypeface(Typeface.defaultFromStyle(0));
        this.f43453i.setVisibility(0);
        goto L22
    L11:
        this.f43456l.setTextColor(ColorProtector.parseColor("#57161823"));
        this.f43457m.setTextColor(ColorProtector.parseColor("#57161823"));
        GradientDrawable r130 = new GradientDrawable();
        r130.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(6));
        r130.setColor(com.bytedance.android.ec.common.impl.sku.utils.m.a(r107, 0.05f));
        r130.setStroke(vf4.a.b(1), com.bytedance.android.ec.common.impl.sku.utils.m.a(r128, 0.5f));
        this.f43454j.setBackgroundDrawable(r130);
        this.f43456l.setTypeface(Typeface.defaultFromStyle(0));
        this.f43457m.setTypeface(Typeface.defaultFromStyle(0));
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L14;
        this.f43453i.setVisibility(0);
        goto L22
    L14:
        this.f43453i.setVisibility(8);
        goto L22
    L15:
        this.f43450f.setAlpha(1.0f);
        this.f43454j.setAlpha(1.0f);
        if (this.f43448d == false) goto L18;
        this.f43452h.setTextColor(ColorProtector.parseColor("#57161823"));
        this.f43452h.setTypeface(Typeface.defaultFromStyle(0));
        this.f43450f.setBackgroundResource(R.drawable.shopping_sku_spec_unselect);
        this.f43453i.setVisibility(0);
        goto L22
    L18:
        this.f43456l.setTextColor(ColorProtector.parseColor("#57161823"));
        this.f43457m.setTextColor(ColorProtector.parseColor("#57161823"));
        this.f43456l.setTypeface(Typeface.defaultFromStyle(0));
        this.f43457m.setTypeface(Typeface.defaultFromStyle(0));
        this.f43454j.setBackgroundResource(R.drawable.shopping_sku_spec_unselect);
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L21;
        this.f43453i.setVisibility(0);
        goto L22
    L21:
        this.f43453i.setVisibility(8);
        goto L22
    }
}
