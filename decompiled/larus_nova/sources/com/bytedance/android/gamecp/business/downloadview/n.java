package com.bytedance.android.gamecp.business.downloadview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.android.gamecp.base.core.service.depend.x;
import com.bytedance.android.gamecp.business.i0;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.common.utils.g0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f53108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f53109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f53110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f53111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f53112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProgressBar f53113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f53114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f53115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f53116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SimpleDraweeView f53117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i f53118k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f53119l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f53120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public GradientDrawable f53121n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f53122o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public GradientDrawable f53123p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public GradientDrawable f53124q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f53125r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public d f53126s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<SimpleDraweeView, String> f53127t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f53128u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f53129v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Runnable f53130w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ObjectAnimator f53131x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AnimatorSet f53132y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Context f53133z;

    public static final class a {
    }

    static {
    }

    public final void e() {
        i r100 = this.f53118k;
        if (r100 != null) goto L5;
        return;
    L5:
        if (f() == false) goto L7;
        UtilityKotlinExtentionsKt.j(this.f53113f);
        this.f53109b.setBackground(null);
    L8:
        this.f53110c.setTextColor(r100.f53066d);
        this.f53111d.setTextColor(r100.f53067e);
        return;
    L7:
        UtilityKotlinExtentionsKt.h(this.f53113f);
        k(this.f53109b, r100, r100.f53068f);
        goto L8
    }

    public final boolean f() {
        i r100 = this.f53118k;
        Integer r101 = null;
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.f53068f);
    L6:
        i r103 = this.f53118k;
        if (r103 == null) goto L10;
        r101 = Integer.valueOf(r103.f53069g);
    L10:
        return !Intrinsics.areEqual(r102, r101);
    L5:
        r102 = null;
        goto L6
    }

    public final void h() {
        i r100 = this.f53118k;
        if (r100 == null) goto L6;
        UtilityKotlinExtentionsKt.h(this.f53113f);
        this.f53110c.setTextColor(r100.f53063a);
        this.f53111d.setTextColor(r100.f53064b);
        k(this.f53109b, r100, r100.f53065c);
        return;
    }

    public final void i() {
        g r100 = this.f53119l;
        if (r100 == null) goto L5;
        this.f53110c.setText(r100.f53031a);
    L5:
        h();
        TextView r101 = this.f53110c;
        TextView r102 = this.f53111d;
        SimpleDraweeView r103 = this.f53112e;
        c r104 = this.f53120m;
        if (r104 == null) goto L8;
        d r105 = r104.f52997a;
    L9:
        l(r101, r102, r103, r105);
        return;
    L8:
        r105 = null;
        goto L9
    }

    public final void j() {
        this.f53114g.setTranslationY(0.0f);
        this.f53114g.setAlpha(1.0f);
        this.f53114g.setVisibility(0);
        this.f53115h.setTranslationY(0.0f);
        this.f53115h.setAlpha(1.0f);
        this.f53115h.setVisibility(8);
    }

    public final Context getContext() {
        return this.f53133z;
    }

    public n(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f53133z = r100;
        View r101 = LayoutInflater.from(r100).inflate(R.layout.gamecp_game_download_component, null, false);
        this.f53108a = r101;
        this.f53109b = r101.findViewById(R.id.download_component_bg);
        this.f53110c = (TextView) r101.findViewById(R.id.download_component_tv);
        this.f53111d = (TextView) r101.findViewById(R.id.download_component_tv_sub);
        SimpleDraweeView r102 = (SimpleDraweeView) r101.findViewById(R.id.download_component_ic);
        this.f53112e = r102;
        fu.j.f(r102);
        this.f53113f = (ProgressBar) r101.findViewById(R.id.download_component_pb);
        this.f53114g = r101.findViewById(R.id.download_component_info);
        this.f53115h = r101.findViewById(R.id.download_component_anim_tips);
        this.f53116i = (TextView) r101.findViewById(R.id.download_component_anim_tips_content);
        SimpleDraweeView r103 = (SimpleDraweeView) r101.findViewById(R.id.download_component_anim_tips_icon);
        this.f53117j = r103;
        fu.j.f(r103);
        this.f53127t = new LinkedHashMap();
    }

    public static void g(String r100) {
        int r101 = ps.a.f530408a;
        ps.a.a("LynxDownloadRender " + r100);
    }

    @Override // com.bytedance.android.gamecp.business.downloadview.l
    public final void b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonConfig");
        this.f53120m = r100;
        com.bytedance.android.gamecp.business.downloadview.a r101 = r100.f53008l;
        if (r101 == null) goto L6;
        n(this.f53116i, r101.f52994a);
        m(this.f53117j, r101.f52995b);
        this.f53128u = true;
        return;
    }

    @Override // com.bytedance.android.gamecp.business.downloadview.l
    public final void c(g r100) {
        Intrinsics.checkNotNullParameter(r100, "downloadText");
        this.f53119l = r100;
    }

    @Override // com.bytedance.android.gamecp.business.downloadview.l
    public final void d(i r100) {
        Intrinsics.checkNotNullParameter(r100, "uiStyle");
        this.f53118k = r100;
        g("initBasisUIStyle");
        this.f53110c.setTextSize(r100.f53080r, r100.f53079q);
        int r101 = r100.f53081s;
        if (r101 == 0) goto L5;
        int r102 = yt.o.f569021a;
        yt.o.a(this.f53110c, r101);
    L5:
        this.f53111d.setTextSize(r100.f53083u, r100.f53082t);
        int r103 = r100.f53084v;
        if (r103 == 0) goto L8;
        int r104 = yt.o.f569021a;
        yt.o.a(this.f53111d, r103);
    L8:
        g0.f(this.f53111d, r100.f53085w);
        if (this.f53122o != null) goto L15;
        GradientDrawable r105 = new GradientDrawable();
        r105.setCornerRadius(r100.f53073k);
        r105.setColor(r100.f53069g);
        Unit r106 = Unit.INSTANCE;
        this.f53123p = r105;
        GradientDrawable r107 = new GradientDrawable();
        r107.setCornerRadius(r100.f53073k);
        r107.setColor(r100.f53068f);
        this.f53124q = r107;
        Object[] r108 = CollectionsKt.listOf(new Drawable[]{this.f53124q, new ClipDrawable(this.f53123p, GravityCompat.START, 1)}).toArray(new Drawable[0]);
        if (r108 == null) goto L14;
        LayerDrawable r109 = new LayerDrawable((Drawable[]) r108);
        r109.setId(0, android.R.id.background);
        r109.setId(1, android.R.id.progress);
        this.f53122o = r109;
        this.f53113f.setProgressDrawable(r109);
        goto L15
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L15:
        String r110 = r100.f53074l;
        if (UtilsKt.c(r110) == false) goto L22;
        g("loadIcon start");
        this.f53125r = true;
        UtilityKotlinExtentionsKt.j(this.f53112e);
        ViewGroup.LayoutParams r111 = this.f53112e.getLayoutParams();
        if (r111 == null) goto L21;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        r112.width = r100.f53075m;
        r112.height = r100.f53076n;
        r112.rightMargin = r100.f53078p;
        this.f53112e.setLayoutParams(r112);
        fu.j.e(this.f53112e, r110);
        g("loadIcon bindImage");
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public static void n(TextView r100, h r101) {
        if (r101 != null) goto L4;
        UtilityKotlinExtentionsKt.h(r100);
        return;
    L4:
        r100.setText(r101.f53042a);
        Integer r102 = r101.f53046e;
        if (r102 == null) goto L7;
        r100.setTextColor(r102.intValue());
    L7:
        int r103 = r101.f53045d;
        if (r103 == 0) goto L10;
        yt.o.a(r100, r103);
    L10:
        r100.setTextSize(r101.f53044c, r101.f53043b);
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        if (r104 == null) goto L15;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        r105.leftMargin = r101.f53047f;
        r105.rightMargin = r101.f53048g;
        r105.topMargin = r101.f53049h;
        r105.bottomMargin = r101.f53050i;
        r100.setLayoutParams(r105);
        UtilityKotlinExtentionsKt.j(r100);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void m(SimpleDraweeView r100, e r101) {
        if (r101 != null) goto L5;
        UtilityKotlinExtentionsKt.h(r100);
        return;
    L5:
        if ((!Intrinsics.areEqual((String) ((LinkedHashMap) this.f53127t).get(r100), r101.f53018a)) == false) goto L7;
        fu.j.e(r100, r101.f53018a);
        this.f53127t.put(r100, r101.f53018a);
    L7:
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L12;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        r103.width = r101.f53019b;
        r103.height = r101.f53020c;
        r103.leftMargin = r101.f53022e;
        r103.rightMargin = r101.f53021d;
        r103.topMargin = r101.f53023f;
        r103.bottomMargin = r101.f53024g;
        r100.setLayoutParams(r103);
        UtilityKotlinExtentionsKt.j(r100);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.bytedance.android.gamecp.business.downloadview.l
    public final void a(int r100, x r101, Integer r110) {
        if (this.f53125r == false) goto L21;
        i r102 = this.f53118k;
        if (r102 == null) goto L21;
        if (r102.f53077o.size() == 1) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L17;
        UtilityKotlinExtentionsKt.j(this.f53112e);
        goto L21
    L17:
        if (r102.f53077o.contains(Integer.valueOf(r100)) == false) goto L19;
        UtilityKotlinExtentionsKt.j(this.f53112e);
        goto L21
    L19:
        UtilityKotlinExtentionsKt.h(this.f53112e);
        goto L21
    L11:
        if (((Number) ListProtector.get(r102.f53077o, 0)).intValue() != (-11)) goto L13;
        r103 = true;
    L21:
        if (r100 == (-3)) goto L23;
        UtilityKotlinExtentionsKt.j(this.f53108a);
    L23:
        g("dispatchUIState currentState=" + r100);
        d r104 = null;
        switch(r100) {
            case -3: goto L148;
            case -2: goto L138;
            case -1: goto L131;
            case 0: goto L130;
            case 1: goto L106;
            case 2: goto L72;
            case 3: goto L65;
            case 4: goto L64;
            case 5: goto L40;
            case 6: goto L33;
            case 7: goto L26;
            default: goto L175;
        };
    L26:
        g r105 = this.f53119l;
        if (r105 == null) goto L29;
        this.f53110c.setText(r105.f53039i);
    L29:
        h();
        TextView r106 = this.f53110c;
        TextView r107 = this.f53111d;
        SimpleDraweeView r111 = this.f53112e;
        c r108 = this.f53120m;
        if (r108 == null) goto L32;
        r104 = r108.f53005i;
    L32:
        l(r106, r107, r111, r104);
        this.f53129v = true;
        return;
    L33:
        g r109 = this.f53119l;
        if (r109 == null) goto L36;
        this.f53110c.setText(r109.f53036f);
    L36:
        h();
        TextView r112 = this.f53110c;
        TextView r113 = this.f53111d;
        SimpleDraweeView r114 = this.f53112e;
        c r115 = this.f53120m;
        if (r115 == null) goto L39;
        r104 = r115.f53002f;
    L39:
        l(r112, r113, r114, r104);
        this.f53129v = false;
        return;
    L40:
        if (r110 != null) goto L43;
    L44:
        if (r110 != null) goto L47;
    L49:
        g r116 = this.f53119l;
        if (r116 == null) goto L52;
        this.f53110c.setText(r116.f53037g);
    L52:
        h();
        TextView r117 = this.f53110c;
        TextView r118 = this.f53111d;
        SimpleDraweeView r119 = this.f53112e;
        c r120 = this.f53120m;
        if (r120 == null) goto L55;
        r104 = r120.f53003g;
    L55:
        l(r117, r118, r119, r104);
    L63:
        this.f53129v = false;
        return;
    L47:
        if (r110.intValue() != 1049) goto L49;
    L56:
        g r121 = this.f53119l;
        if (r121 == null) goto L59;
        this.f53110c.setText(r121.f53038h);
    L59:
        e();
        TextView r122 = this.f53110c;
        TextView r123 = this.f53111d;
        SimpleDraweeView r124 = this.f53112e;
        c r125 = this.f53120m;
        if (r125 == null) goto L62;
        r104 = r125.f53004h;
    L62:
        l(r122, r123, r124, r104);
        goto L63
    L43:
        if (r110.intValue() == 1013) goto L56;
    L64:
        i();
        this.f53129v = true;
        return;
    L65:
        g r126 = this.f53119l;
        if (r126 == null) goto L68;
        this.f53110c.setText(r126.f53035e);
    L68:
        h();
        TextView r127 = this.f53110c;
        TextView r128 = this.f53111d;
        SimpleDraweeView r129 = this.f53112e;
        c r130 = this.f53120m;
        if (r130 == null) goto L71;
        r104 = r130.f53001e;
    L71:
        l(r127, r128, r129, r104);
        this.f53129v = false;
        return;
    L72:
        if (r101 == null) goto L105;
        int r131 = i0.h(r101);
        g r132 = this.f53119l;
        if (r132 == null) goto L80;
        if (StringsKt.contains$default(r132.f53034d, "%s", false, 2, null) == false) goto L78;
        TextView r133 = this.f53110c;
        StringCompanionObject r134 = StringCompanionObject.INSTANCE;
        r133.setText(String.format(r132.f53034d, Arrays.copyOf(new Object[]{String.valueOf(r131)}, 1)));
        goto L80
    L78:
        this.f53110c.setText(r132.f53034d);
    L80:
        if (f() == false) goto L82;
        this.f53113f.setProgress(r131);
    L82:
        e();
        TextView r135 = this.f53110c;
        TextView r136 = this.f53111d;
        SimpleDraweeView r137 = this.f53112e;
        c r138 = this.f53120m;
        if (r138 == null) goto L85;
        r104 = r138.f53000d;
    L85:
        l(r135, r136, r137, r104);
        if (this.f53128u == false) goto L105;
        if (this.f53129v == false) goto L105;
        this.f53129v = false;
        ObjectAnimator r139 = this.f53131x;
        if (r139 != null) goto L92;
    L94:
        Runnable r140 = this.f53130w;
        if (r140 == null) goto L99;
        this.f53115h.removeCallbacks(r140);
        Runnable r141 = this.f53130w;
        if (r141 == null) goto L105;
        r141.run();
        goto L105
    L99:
        AnimatorSet r142 = this.f53132y;
        if (r142 != null) goto L102;
    L104:
        j();
        goto L105
    L102:
        if (r142.isRunning() != true) goto L104;
    L92:
        if (r139.isRunning() != true) goto L94;
        ObjectAnimator r143 = this.f53131x;
        Intrinsics.checkNotNull(r143);
        r143.cancel();
    L105:
        this.f53129v = false;
        return;
    L106:
        if (r101 == null) goto L168;
        int r144 = i0.h(r101);
        if (f() == false) goto L110;
        this.f53113f.setProgress(r144);
    L110:
        e();
        TextView r145 = this.f53110c;
        TextView r146 = this.f53111d;
        SimpleDraweeView r147 = this.f53112e;
        c r148 = this.f53120m;
        if (r148 == null) goto L113;
        d r149 = r148.f53007k;
    L114:
        l(r145, r146, r147, r149);
        g r150 = this.f53119l;
        if (r150 == null) goto L121;
        if (StringsKt.contains$default(r150.f53041k, "%s", false, 2, null) == false) goto L119;
        TextView r151 = this.f53110c;
        StringCompanionObject r152 = StringCompanionObject.INSTANCE;
        r151.setText(String.format(r150.f53041k, Arrays.copyOf(new Object[]{String.valueOf(r144)}, 1)));
        goto L121
    L119:
        this.f53110c.setText(r150.f53041k);
    L121:
        if (this.f53128u == true) goto L123;
        return;
    L123:
        if (this.f53129v == false) goto L170;
        this.f53129v = false;
        this.f53115h.setAlpha(0.3f);
        UtilityKotlinExtentionsKt.j(this.f53115h);
        UtilityKotlinExtentionsKt.h(this.f53114g);
        ObjectAnimator r153 = this.f53131x;
        if (r153 != null) goto L127;
    L129:
        ObjectAnimator r154 = ObjectAnimator.ofFloat(this.f53115h, "alpha", new float[]{0.3f, 1.0f});
        this.f53131x = r154;
        r154.setDuration(250);
        r154.start();
        p r155 = new p(this);
        this.f53130w = r155;
        this.f53115h.postDelayed(r155, 2000);
        return;
    L127:
        if (r153.isRunning() != true) goto L129;
        ObjectAnimator r156 = this.f53131x;
        Intrinsics.checkNotNull(r156);
        r156.cancel();
        j();
        goto L129
    L170:
        return;
    L113:
        r149 = null;
        goto L114
    L168:
        return;
    L130:
        i();
        this.f53129v = true;
        return;
    L131:
        g r157 = this.f53119l;
        if (r157 == null) goto L134;
        this.f53110c.setText(r157.f53032b);
    L134:
        h();
        TextView r158 = this.f53110c;
        TextView r159 = this.f53111d;
        SimpleDraweeView r160 = this.f53112e;
        c r161 = this.f53120m;
        if (r161 == null) goto L137;
        r104 = r161.f52998b;
    L137:
        l(r158, r159, r160, r104);
        return;
    L138:
        g r162 = this.f53119l;
        if (r162 == null) goto L141;
        this.f53110c.setText(r162.f53040j);
    L141:
        i r163 = this.f53118k;
        if (r163 == null) goto L144;
        UtilityKotlinExtentionsKt.h(this.f53113f);
        this.f53110c.setTextColor(r163.f53071i);
        this.f53111d.setTextColor(r163.f53072j);
        k(this.f53109b, r163, r163.f53070h);
    L144:
        TextView r164 = this.f53110c;
        TextView r165 = this.f53111d;
        SimpleDraweeView r166 = this.f53112e;
        c r167 = this.f53120m;
        if (r167 == null) goto L147;
        r104 = r167.f53006j;
    L147:
        l(r164, r165, r166, r104);
        return;
    L148:
        g r168 = this.f53119l;
        if (r168 == null) goto L151;
        this.f53110c.setText(r168.f53033c);
    L151:
        h();
        i r169 = this.f53118k;
        if (r169 != null) goto L154;
    L156:
        UtilityKotlinExtentionsKt.j(this.f53108a);
    L157:
        TextView r170 = this.f53110c;
        TextView r171 = this.f53111d;
        SimpleDraweeView r172 = this.f53112e;
        c r173 = this.f53120m;
        if (r173 == null) goto L160;
        r104 = r173.f52999c;
    L160:
        l(r170, r171, r172, r104);
        return;
    L154:
        if (r169.f53086x != true) goto L156;
        UtilityKotlinExtentionsKt.i(this.f53108a);
        goto L157
    }

    public final void k(View r100, i r101, int r102) {
        if (this.f53121n != null) goto L5;
        GradientDrawable r103 = new GradientDrawable();
        r103.setCornerRadius(r101.f53073k);
        Unit r104 = Unit.INSTANCE;
        this.f53121n = r103;
    L5:
        GradientDrawable r105 = this.f53121n;
        Intrinsics.checkNotNull(r105);
        r105.setColor(r102);
        r100.setBackground(this.f53121n);
    }

    public final void l(TextView r100, TextView r101, SimpleDraweeView r102, d r103) {
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L49
        if (r103 != null) goto L5;
    L47:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L49
        return;
    L5:
        if ((!Intrinsics.areEqual(this.f53126s, r103)) == false) goto L47;
        this.f53126s = r103;     // Catch: Throwable -> L49
        n(r100, r103.f53010b);     // Catch: Throwable -> L49
        n(r101, r103.f53011c);     // Catch: Throwable -> L49
        m(r102, r103.f53012d);     // Catch: Throwable -> L49
        if (r103.f53013e == null) goto L9;
    L10:
        Drawable r105 = this.f53109b.getBackground();     // Catch: Throwable -> L49
        if ((r105 instanceof GradientDrawable) == true) goto L13;
        r105 = null;
    L13:
        GradientDrawable r106 = (GradientDrawable) r105;     // Catch: Throwable -> L49
        Integer r107 = r103.f53013e;     // Catch: Throwable -> L49
        if (r107 == null) goto L18;
        int r108 = r107.intValue();     // Catch: Throwable -> L49
        if (r106 == null) goto L18;
        r106.setColor(r108);     // Catch: Throwable -> L49
    L18:
        Integer r109 = r103.f53014f;     // Catch: Throwable -> L49
        if (r109 == null) goto L24;
        int r110 = r109.intValue();     // Catch: Throwable -> L49
        if (r106 == null) goto L24;
        r106.setCornerRadius(r110);     // Catch: Throwable -> L49
    L24:
        if (r103.f53015g == null) goto L26;
    L29:
        Integer r111 = r103.f53016h;     // Catch: Throwable -> L49
        if (r111 == null) goto L34;
        int r112 = r111.intValue();     // Catch: Throwable -> L49
        GradientDrawable r113 = this.f53123p;     // Catch: Throwable -> L49
        if (r113 == null) goto L34;
        r113.setColor(r112);     // Catch: Throwable -> L49
    L34:
        Integer r114 = r103.f53015g;     // Catch: Throwable -> L49
        if (r114 == null) goto L39;
        int r115 = r114.intValue();     // Catch: Throwable -> L49
        GradientDrawable r116 = this.f53124q;     // Catch: Throwable -> L49
        if (r116 == null) goto L39;
        r116.setColor(r115);     // Catch: Throwable -> L49
    L39:
        Integer r117 = r103.f53017i;     // Catch: Throwable -> L49
        if (r117 == null) goto L47;
        int r118 = r117.intValue();     // Catch: Throwable -> L49
        GradientDrawable r119 = this.f53124q;     // Catch: Throwable -> L49
        if (r119 == null) goto L44;
        r119.setCornerRadius(r118);     // Catch: Throwable -> L49
    L44:
        GradientDrawable r120 = this.f53123p;     // Catch: Throwable -> L49
        if (r120 == null) goto L47;
        r120.setCornerRadius(r118);     // Catch: Throwable -> L49
        goto L47
    L26:
        if (r103.f53016h != null) goto L29;
        if (r103.f53017i == null) goto L47;
    L9:
        if (r103.f53014f == null) goto L24;
    L49:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
