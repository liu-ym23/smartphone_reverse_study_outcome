package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategoryImage;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R(\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/TopCategoryView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function1;", "Landroid/view/View;", "", "clickListener", "setDisableClickListener", "", SlcFlexDirection.FLEX_ROW, "setTabRow", "Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategory;", "<set-?>", "h", "Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategory;", "getCurrentCategory", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategory;", "currentCategory", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopCategoryView extends FrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f149168l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatTextView f149169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f149170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECDraweeView f149171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECDraweeView f149172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f149173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f149174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.skin.f f149175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PromotionCategory f149176h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f149177i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f149178j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super View, Unit> f149179k;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopCategoryView f149180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f149181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Drawable f149182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f149183d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f149184e;

        public b(TopCategoryView r100, boolean r101, Drawable r102, boolean r103, boolean r104) {
            this.f149180a = r100;
            this.f149181b = r101;
            this.f149182c = r102;
            this.f149183d = r103;
            this.f149184e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TopCategoryView r100 = this.f149180a;     // Catch: Throwable -> L4
            boolean r101 = this.f149181b;     // Catch: Throwable -> L4
            Drawable r102 = this.f149182c;     // Catch: Throwable -> L4
            int r103 = TopCategoryView.f149168l;     // Catch: Throwable -> L4
            r100.a(r101, r102);     // Catch: Throwable -> L4
            this.f149180a.f(this.f149183d, this.f149184e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopCategoryView f149185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f149186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f149187c;

        public c(TopCategoryView r100, boolean r101, boolean r102) {
            this.f149185a = r100;
            this.f149186b = r101;
            this.f149187c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TopCategoryView r100 = this.f149185a;     // Catch: Throwable -> L4
            boolean r101 = this.f149186b;     // Catch: Throwable -> L4
            boolean r102 = this.f149187c;     // Catch: Throwable -> L4
            int r103 = TopCategoryView.f149168l;     // Catch: Throwable -> L4
            r100.f(r101, r102);     // Catch: Throwable -> L4
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

    public TopCategoryView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TopCategoryView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final PromotionCategory getCurrentCategory() {
        return this.f149176h;
    }

    public final void b(boolean r100) {
        boolean r101 = true;
        if ((!Intrinsics.areEqual(this.f149177i, Boolean.valueOf(r100))) == false) goto L13;
        PromotionCategory r102 = this.f149176h;
        if (r102 == null) goto L7;
        r102.setSelected(r100);
    L7:
        boolean r103 = this.f149178j;
        if (this.f149177i == null) goto L11;
        r101 = false;
    L11:
        c(r103, r100, r101);
        this.f149177i = Boolean.valueOf(r100);
        return;
    }

    public final void d(int r100) {
        if (this.f149173e != r100) goto L5;
        return;
    L5:
        this.f149173e = r100;
        boolean r101 = this.f149178j;
        Boolean r102 = this.f149177i;
        Boolean r103 = Boolean.TRUE;
        c(r101, Intrinsics.areEqual(r102, r103), false);
        e(this.f149173e, this.f149178j, Intrinsics.areEqual(this.f149177i, r103));
        ViewGroup.LayoutParams r104 = this.f149169a.getLayoutParams();
        bi2.a r105 = bi2.a.f19090a;
        int r106 = this.f149173e;
        r105.getClass();
        if (r106 == 2) goto L12;
        if (r106 != 3) goto L9;
        int r107 = UtilityKotlinExtentionsKt.d(24);
    L13:
        r104.height = r107;
        this.f149169a.setLayoutParams(r104);
        ViewGroup.LayoutParams r108 = getLayoutParams();
        if (this.f149173e == 3) goto L16;
        int r109 = UtilityKotlinExtentionsKt.d(42);
    L17:
        r108.height = r109;
        setLayoutParams(r108);
        return;
    L16:
        r109 = UtilityKotlinExtentionsKt.d(24);
        goto L17
    L9:
        if (r106 == 4) goto L12;
        r107 = UtilityKotlinExtentionsKt.d(Float.valueOf(26.0f)) + 2;
    L12:
        r107 = -1;
        goto L13
    }

    public final void setDisableClickListener(Function1<? super View, Unit> r100) {
        this.f149179k = r100;
    }

    public final void setTabRow(int r100) {
        PromotionCategory r101 = this.f149176h;
        if (r101 == null) goto L6;
        r101.setTabRow(r100);
        return;
    }

    public final void a(boolean r100, Drawable r101) {
        if (r100 == true) goto L6;
        if (this.f149170b.getDrawable() == null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 28) goto L8;
    L10:
        this.f149170b.setImageDrawable(r101);
        boolean r102 = r101 instanceof Animatable;
        Object r103 = r101;
        if (r102 == true) goto L13;
        r103 = null;
    L13:
        Animatable r104 = (Animatable) r103;
        if (r104 == null) goto L18;
        r104.start();
        return;
    L18:
        return;
    L8:
        if ((r101 instanceof AnimatedImageDrawable) == false) goto L10;
        ((AnimatedImageDrawable) r101).setRepeatCount(0);
        goto L10
    }

    public final void f(boolean r210, boolean r211) {
        AppCompatTextView r100 = this.f149169a;
        bi2.a r101 = bi2.a.f19090a;
        Context r102 = getContext();
        int r103 = this.f149173e;
        com.bytedance.android.livesdk.livecommerce.skin.f r104 = this.f149175g;
        String r105 = this.f149174f;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r110 = null;
        if (r210 == false) goto L5;
        if (r211 == false) goto L48;
        if (r103 == 3) goto L36;
        if (r103 == 4) goto L31;
        if (r104 == null) goto L30;
        Integer r106 = r104.c(r210, r211);
        if (r106 == null) goto L30;
        int r107 = r106.intValue();
    L79:
        r100.setTextColor(r107);
        e(this.f149173e, r210, r211);
        AppCompatTextView r108 = this.f149169a;
        TextPaint r109 = r108.getPaint();
        int r111 = this.f149173e;
        if (r111 == 3) goto L92;
        if (r111 == 4) goto L86;
        if (r210 == false) goto L85;
        if (r211 == false) goto L85;
        Typeface r112 = Typeface.DEFAULT_BOLD;
    L113:
        r108.setTypeface(r112);
        PromotionCategory r113 = this.f149176h;
        if (r113 == null) goto L238;
        Integer r114 = Integer.valueOf(r113.getEnhanceType());
        if (r114.intValue() <= 0) goto L118;
        boolean r115 = true;
    L119:
        if (r115 == true) goto L122;
        r114 = null;
    L122:
        if (r114 == null) goto L239;
        int r116 = r114.intValue();
        if (this.f149173e != 4) goto L245;
        int r117 = ci2.a.f23851a;
        PromotionCategory r118 = this.f149176h;
        if (r118 == null) goto L129;
        String r119 = r118.getUniqueIndex();
    L131:
        if (r119 == null) goto L144;
        HashMap<String, JSONObject> r120 = j.f44312a;
        JSONObject r121 = j.i(q.f48131a.getString("ec_live_tab_enhance_control_show", ""));
        if (r121 == null) goto L144;
        Integer r122 = Integer.valueOf(r121.optInt(r119, 0));
        if (r122.intValue() <= 0) goto L138;
        boolean r123 = true;
    L139:
        if (r123 == true) goto L142;
        r122 = null;
    L142:
        if (r122 == null) goto L144;
        r122.intValue();
        boolean r124 = true;
    L145:
        if (r124 == true) goto L231;
        PromotionCategory r125 = this.f149176h;
        if (r125 == null) goto L149;
        String r126 = r125.getUniqueIndex();
    L150:
        if (r126 == null) goto L163;
        HashMap<String, JSONObject> r127 = j.f44312a;
        JSONObject r128 = j.i(q.f48131a.getString("ec_live_tab_enhance_control_click", ""));
        if (r128 == null) goto L163;
        Integer r129 = Integer.valueOf(r128.optInt(r126, 0));
        if (r129.intValue() <= 0) goto L157;
        boolean r130 = true;
    L158:
        if (r130 == true) goto L161;
        r129 = null;
    L161:
        if (r129 == null) goto L163;
        r129.intValue();
        boolean r131 = true;
    L164:
        if (r131 == true) goto L231;
        com.bytedance.android.livesdk.livecommerce.skin.f r132 = this.f149175g;
        if (r132 == null) goto L208;
        com.bytedance.android.livesdk.livecommerce.skin.b r133 = r132.f();
        if (r133 == null) goto L208;
        int[] r134 = r133.b(r116, r210, r211);
        if (r134 == null) goto L208;
        if (r134.length < 2) goto L196;
        PromotionCategory r135 = this.f149176h;
        if (r135 == null) goto L217;
        String r136 = r135.getName();
        if (r136 == null) goto L217;
        if (r136.length() <= 0) goto L181;
        boolean r137 = true;
    L182:
        if (r137 == false) goto L184;
        r110 = r136;
    L184:
        if (r110 == null) goto L217;
        Integer r138 = ArraysKt.firstOrNull(r134);
        if (r138 == null) goto L188;
        this.f149169a.setTextColor(r138.intValue());
    L188:
        TextPaint r139 = this.f149169a.getPaint();
        if (r139 == null) goto L191;
        Number r140 = Float.valueOf(r139.measureText(r110));
    L192:
        TextPaint r141 = this.f149169a.getPaint();
        if (r141 == null) goto L217;
        r141.setShader(new LinearGradient(0.0f, 0.0f, r140.floatValue(), 0.0f, r134, null, Shader.TileMode.CLAMP));
        goto L217
    L191:
        r140 = 0;
        goto L192
    L181:
        r137 = false;
    L217:
        com.bytedance.android.livesdk.livecommerce.skin.f r142 = this.f149175g;
        if (r142 == null) goto L224;
        com.bytedance.android.livesdk.livecommerce.skin.b r143 = r142.f();
        if (r143 == null) goto L224;
        Integer r144 = r143.c(r116, r210, r211);
        if (r144 == null) goto L224;
        this.f149169a.setTextSize(1, r144.intValue());
    L224:
        com.bytedance.android.livesdk.livecommerce.skin.f r145 = this.f149175g;
        if (r145 == null) goto L240;
        com.bytedance.android.livesdk.livecommerce.skin.b r146 = r145.f();
        if (r146 == null) goto L241;
        Integer r147 = r146.d(r116, r210, r211);
        if (r147 == null) goto L242;
        int r148 = r147.intValue();
        int r149 = c0.f45558a;
        c0.b(this.f149169a, r148);
        return;
    L242:
        return;
    L241:
        return;
    L240:
        return;
    L196:
        if (r134.length != 1) goto L200;
        Integer r150 = ArraysKt.firstOrNull(r134);
        if (r150 == null) goto L217;
        this.f149169a.setTextColor(r150.intValue());
        goto L217
    L200:
        TextPaint r151 = this.f149169a.getPaint();
        if (r151 == null) goto L203;
        Shader r152 = r151.getShader();
    L204:
        if (r152 == null) goto L217;
        TextPaint r153 = this.f149169a.getPaint();
        if (r153 == null) goto L217;
        r153.setShader(null);
        goto L217
    L203:
        r152 = null;
    L208:
        TextPaint r154 = this.f149169a.getPaint();
        if (r154 == null) goto L211;
        Shader r155 = r154.getShader();
    L212:
        if (r155 == null) goto L216;
        TextPaint r156 = this.f149169a.getPaint();
        if (r156 == null) goto L216;
        r156.setShader(null);
    L216:
        Unit r157 = Unit.INSTANCE;
        goto L217
    L211:
        r155 = null;
        goto L212
    L157:
        r130 = false;
    L163:
        r131 = false;
        goto L164
    L149:
        r126 = null;
    L231:
        AppCompatTextView r158 = this.f149169a;
        TextPaint r159 = r158.getPaint();
        if (r159 == null) goto L234;
        Shader r160 = r159.getShader();
    L235:
        if (r160 == null) goto L244;
        r158.getPaint().setShader(null);
        return;
    L244:
        return;
    L234:
        r160 = null;
        goto L235
    L138:
        r123 = false;
    L144:
        r124 = false;
        goto L145
    L129:
        r119 = null;
        goto L131
    L245:
        return;
    L239:
        return;
    L118:
        r115 = false;
        goto L119
    L238:
        return;
    L85:
        r112 = Typeface.DEFAULT;
        goto L113
    L86:
        if (r109 != null) goto L88;
        r112 = Typeface.DEFAULT;
        goto L113
    L88:
        if (r211 == false) goto L90;
        r112 = c0.a(r109, 600);
        goto L113
    L90:
        r112 = c0.a(r109, 400);
        goto L113
    L92:
        if (r211 == false) goto L104;
        if (Build.VERSION.SDK_INT < 28) goto L99;
        if (r109 == null) goto L97;
        Typeface r161 = r109.getTypeface();
    L98:
        r112 = Typeface.create(r161, 500, false);
        goto L113
    L97:
        r161 = null;
        goto L98
    L99:
        if (r210 == false) goto L102;
        if (r211 == false) goto L102;
        r112 = Typeface.DEFAULT_BOLD;
    L102:
        r112 = Typeface.DEFAULT;
        goto L113
    L104:
        if (Build.VERSION.SDK_INT < 28) goto L109;
        if (r109 == null) goto L107;
        Typeface r162 = r109.getTypeface();
    L108:
        r112 = Typeface.create(r162, 400, false);
        goto L113
    L107:
        r162 = null;
        goto L108
    L109:
        if (r210 == false) goto L112;
        if (r211 == false) goto L112;
        r112 = Typeface.DEFAULT_BOLD;
    L112:
        r112 = Typeface.DEFAULT;
    L30:
        r107 = th.a.a(r102, R.color.shopping_std_brand);
        goto L79
    L31:
        if (r104 == null) goto L35;
        Integer r163 = r104.c(r210, r211);
        if (r163 == null) goto L35;
        r107 = r163.intValue();
    L35:
        r107 = th.a.a(r102, R.color.ec_color_black_text);
        goto L79
    L36:
        int r164 = s.f45717a;
        int r165 = wh2.c.f559646a;
        List r166 = wh2.b.a("live_list_tab_text_selected_color", r105);
        if (r166 == null) goto L39;
        String r167 = (String) CollectionsKt.firstOrNull(r166);
    L40:
        Integer r168 = s.b(r167);
        if (r168 != null) goto L45;
        if (r104 == null) goto L44;
        r168 = r104.c(r210, r211);
        goto L45
    L44:
        r168 = null;
    L45:
        if (r168 == null) goto L47;
        r107 = r168.intValue();
        goto L79
    L47:
        r107 = th.a.a(r102, R.color.shopping_color_FF00BC35);
        goto L79
    L39:
        r167 = null;
        goto L40
    L48:
        if (r103 != 1) goto L50;
        if (r104 == null) goto L78;
        Integer r169 = r104.c(r210, r211);
        if (r169 == null) goto L78;
        r107 = r169.intValue();
    L78:
        r107 = th.a.a(r102, R.color.shopping_color_99161823);
        goto L79
    L50:
        if (r103 == 3) goto L62;
        if (r103 == 4) goto L57;
        if (r104 == null) goto L56;
        Integer r170 = r104.c(r210, r211);
        if (r170 == null) goto L56;
        r107 = r170.intValue();
    L56:
        r107 = th.a.a(r102, R.color.shopping_std_text_black_3);
        goto L79
    L57:
        if (r104 == null) goto L61;
        Integer r171 = r104.c(r210, r211);
        if (r171 == null) goto L61;
        r107 = r171.intValue();
    L61:
        r107 = th.a.a(r102, R.color.shopping_color_FF8A8B91);
        goto L79
    L62:
        int r172 = s.f45717a;
        int r173 = wh2.c.f559646a;
        List r174 = wh2.b.a("live_list_tab_text_unselected_color", r105);
        if (r174 == null) goto L65;
        String r175 = (String) CollectionsKt.firstOrNull(r174);
    L66:
        Integer r176 = s.b(r175);
        if (r176 != null) goto L71;
        if (r104 == null) goto L70;
        r176 = r104.c(r210, r211);
        goto L71
    L70:
        r176 = null;
    L71:
        if (r176 == null) goto L73;
        r107 = r176.intValue();
        goto L79
    L73:
        r107 = th.a.a(r102, R.color.shopping_std_text_black_3);
        goto L79
    L65:
        r175 = null;
        goto L66
    L5:
        if (r103 == 3) goto L11;
        if (r104 == null) goto L10;
        Integer r177 = r104.c(r210, r211);
        if (r177 == null) goto L10;
        r107 = r177.intValue();
    L10:
        r107 = th.a.a(r102, R.color.ec_color_black_161823_25);
        goto L79
    L11:
        int r178 = s.f45717a;
        int r179 = wh2.c.f559646a;
        List r180 = wh2.b.a("live_list_tab_text_disabled_color", r105);
        if (r180 == null) goto L14;
        String r181 = (String) CollectionsKt.firstOrNull(r180);
    L15:
        Integer r182 = s.b(r181);
        if (r182 != null) goto L20;
        if (r104 == null) goto L19;
        r182 = r104.c(r210, r211);
        goto L20
    L19:
        r182 = null;
    L20:
        if (r182 == null) goto L22;
        r107 = r182.intValue();
        goto L79
    L22:
        r107 = th.a.a(r102, R.color.ec_color_black_161823_25);
        goto L79
    L14:
        r181 = null;
        goto L15
    }

    public TopCategoryView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f149178j = true;
        ViewGroup.LayoutParams r100 = new FrameLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(42));
        o0.c(this, 17);
        Unit r101 = Unit.INSTANCE;
        setLayoutParams(r100);
        int r102 = 0;
        int r103 = 6;
        DefaultConstructorMarker r104 = null;
        ECDraweeView r113 = new ECDraweeView(r110, null, r102, r103, r104);
        r113.setAdjustMode(33);
        r113.setVisibility(8);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = 17;
        r113.setLayoutParams(r105);
        addView(r113);
        this.f149171c = r113;
        ImageView r106 = new ImageView(r110);
        r106.setVisibility(8);
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        r107.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        r107.setMarginEnd(UtilityKotlinExtentionsKt.d(3));
        r107.bottomMargin = UtilityKotlinExtentionsKt.d(8);
        r106.setLayoutParams(r107);
        addView(r106);
        this.f149170b = r106;
        ECDraweeView r114 = new ECDraweeView(r110, null, r102, r103, r104);
        r114.setAdjustMode(33);
        r114.setVisibility(8);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-2, -2);
        r108.gravity = 17;
        r114.setLayoutParams(r108);
        addView(r114);
        this.f149172d = r114;
        AppCompatTextView r109 = new AppCompatTextView(r110);
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(Float.valueOf(26.0f)) + 2);
        r115.gravity = 17;
        r109.setLayoutParams(r115);
        r109.setGravity(16);
        r109.setTextColor(th.a.a(r110, R.color.shopping_std_text_black_3));
        addView(r109);
        this.f149169a = r109;
        e(this.f149173e, true, false);
        int r116 = ph.b.f529227a;
        Intrinsics.checkNotNullParameter(this, "view");
        if (com.bytedance.android.ec.core.opt.ab.j.a().k() == false) goto L6;
        ph.b.b(this);
        return;
    }

    public final void c(boolean r210, boolean r211, boolean r212) {
        int r100 = 4;
        ECUrlModel r101 = null;
        if (this.f149173e != 3) goto L62;
        bi2.a r102 = bi2.a.f19090a;
        com.bytedance.android.livesdk.livecommerce.skin.f r103 = this.f149175g;
        String r104 = this.f149174f;
        r102.getClass();
        if (r210 == true) goto L24;
        if (r103 == null) goto L13;
        ECLiveSkinBackgroundElement r105 = r103.e(r210, r211);
        if (r105 == null) goto L13;
        List<String> r106 = r105.getColor();
        if (r106 == null) goto L13;
        String r107 = (String) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L13;
    L17:
        if (r103 == null) goto L23;
        List r108 = r103.g();
        if (r108 == null) goto L23;
        Integer r109 = (Integer) CollectionsKt.firstOrNull(r108);
        if (r109 == null) goto L23;
        r100 = r109.intValue();
    L23:
        Drawable r110 = bi2.a.c(r107, r100);
    L61:
        setBackground(r110);
        this.f149170b.setVisibility(8);
        f(r210, r211);
    L98:
        PromotionCategory r111 = this.f149176h;
        if (r111 != null) goto L101;
    L118:
        this.f149169a.setVisibility(0);
        this.f149172d.setVisibility(8);
        Unit r112 = Unit.INSTANCE;
        return;
    L101:
        if (r111.getImage() == null) goto L118;
        this.f149169a.setVisibility(8);
        this.f149172d.setVisibility(0);
        if (r211 == false) goto L109;
        PromotionCategory r113 = this.f149176h;
        if (r113 == null) goto L114;
        PromotionCategoryImage r114 = r113.getImage();
        if (r114 == null) goto L114;
        r101 = r114.getSelectedImage();
    L114:
        ECUrlModel r115 = r101;
        if (r115 == null) goto L117;
        ViewGroup.LayoutParams r116 = this.f149172d.getLayoutParams();
        r116.width = UtilityKotlinExtentionsKt.d(Integer.valueOf(r115.getWidth()));
        r116.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r115.getHeight()));
        this.f149172d.setLayoutParams(r116);
        this.f149169a.setVisibility(8);
        this.f149172d.setVisibility(0);
        h0.d(this.f149172d, r115, new r("ec_live", "promotion_list_category_tab"), null, null, null, new h(this), 56);
        return;
    L117:
        this.f149169a.setVisibility(0);
        this.f149172d.setVisibility(8);
        Unit r117 = Unit.INSTANCE;
        return;
    L109:
        PromotionCategory r118 = this.f149176h;
        if (r118 == null) goto L114;
        PromotionCategoryImage r119 = r118.getImage();
        if (r119 == null) goto L114;
        r101 = r119.getDefaultImage();
    L13:
        int r120 = wh2.c.f559646a;
        List r121 = wh2.b.a("live_list_tab_bg_disabled_color", r104);
        if (r121 == null) goto L16;
        r107 = (String) CollectionsKt.firstOrNull(r121);
        goto L17
    L16:
        r107 = null;
        goto L17
    L24:
        if (r211 == false) goto L43;
        if (r103 == null) goto L32;
        ECLiveSkinBackgroundElement r122 = r103.e(r210, r211);
        if (r122 == null) goto L32;
        List<String> r123 = r122.getColor();
        if (r123 == null) goto L32;
        String r124 = (String) CollectionsKt.firstOrNull(r123);
        if (r124 == null) goto L32;
    L36:
        if (r103 == null) goto L42;
        List r125 = r103.g();
        if (r125 == null) goto L42;
        Integer r126 = (Integer) CollectionsKt.firstOrNull(r125);
        if (r126 == null) goto L42;
        r100 = r126.intValue();
    L42:
        r110 = bi2.a.c(r124, r100);
    L32:
        int r127 = wh2.c.f559646a;
        List r128 = wh2.b.a("live_list_tab_bg_selected_color", r104);
        if (r128 == null) goto L35;
        r124 = (String) CollectionsKt.firstOrNull(r128);
        goto L36
    L35:
        r124 = null;
        goto L36
    L43:
        if (r103 == null) goto L50;
        ECLiveSkinBackgroundElement r129 = r103.e(r210, r211);
        if (r129 == null) goto L50;
        List<String> r130 = r129.getColor();
        if (r130 == null) goto L50;
        String r131 = (String) CollectionsKt.firstOrNull(r130);
        if (r131 == null) goto L50;
    L54:
        if (r103 == null) goto L60;
        List r132 = r103.g();
        if (r132 == null) goto L60;
        Integer r133 = (Integer) CollectionsKt.firstOrNull(r132);
        if (r133 == null) goto L60;
        r100 = r133.intValue();
    L60:
        r110 = bi2.a.c(r131, r100);
    L50:
        int r134 = wh2.c.f559646a;
        List r135 = wh2.b.a("live_list_tab_bg_unselected_color", r104);
        if (r135 == null) goto L53;
        r131 = (String) CollectionsKt.firstOrNull(r135);
        goto L54
    L53:
        r131 = null;
        goto L54
    L62:
        setBackground(null);
        this.f149170b.setVisibility(0);
        bi2.a r136 = bi2.a.f19090a;
        Context r137 = getContext();
        int r138 = this.f149173e;
        com.bytedance.android.livesdk.livecommerce.skin.f r139 = this.f149175g;
        ECDraweeView r140 = this.f149171c;
        r136.getClass();
        Intrinsics.checkNotNullParameter(r137, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r210 == true) goto L73;
        if (r138 == 4) goto L67;
        Drawable r141 = th.a.b(r137, bi2.a.a(r138, r210, r211));
    L66:
        Drawable r142 = r141;
    L87:
        if ((r142 instanceof Animatable) == false) goto L97;
        if (r212 == false) goto L91;
        if (r211 == true) goto L91;
        this.f149170b.setImageDrawable(new ColorDrawable(0));
        f(r210, r211);
    L91:
        boolean r143 = !Intrinsics.areEqual(this.f149177i, Boolean.valueOf(r211));
        if (r211 == false) goto L96;
        if (r212 == false) goto L95;
        a(r143, r142);
        f(r210, r211);
        goto L98
    L95:
        postDelayed(new b(this, r143, r142, r210, r211), 150);
        goto L98
    L96:
        postDelayed(new c(this, r210, r211), 150);
        a(r143, r142);
        goto L98
    L97:
        this.f149170b.setImageDrawable(r142);
        f(r210, r211);
        goto L98
    L67:
        if (r139 == null) goto L72;
        Drawable r144 = r139.d(r137, r210, r211, r140);
        if (r144 == null) goto L72;
    L71:
        r142 = r144;
    L72:
        r141 = th.a.b(r137, R.color.transparent);
        goto L66
    L73:
        if (r211 == false) goto L80;
        if (r138 == 4) goto L76;
        r141 = th.a.b(r137, bi2.a.a(r138, r210, r211));
        goto L66
    L76:
        if (r139 == null) goto L79;
        r141 = r139.d(r137, r210, r211, r140);
        if (r141 != null) goto L66;
    L79:
        r141 = th.a.b(r137, R.drawable.ec_list_tab_selected_bg_upgrade_new);
        goto L66
    L80:
        if (r138 == 4) goto L82;
        r141 = th.a.b(r137, bi2.a.a(r138, r210, r211));
        goto L66
    L82:
        if (r139 == null) goto L85;
        r144 = r139.d(r137, r210, r211, r140);
        if (r144 != null) goto L71;
    L85:
        r141 = th.a.b(r137, R.color.transparent);
        goto L66
    }

    public final void e(int r110, boolean r111, boolean r112) {
        bi2.a.f19090a.getClass();
        float r100 = 14.0f;
        Float r101 = Float.valueOf(14.0f);
        Float r102 = Float.valueOf(12.0f);
        if (r110 == 1) goto L11;
        if (r110 == 2) goto L10;
        if (r110 == 3) goto L9;
        if (r110 == 4) goto L8;
        bi2.a.C0306a r103 = new bi2.a.C0306a(UtilityKotlinExtentionsKt.d(r102), UtilityKotlinExtentionsKt.d(r102));
    L12:
        this.f149169a.setPadding(r103.f19091a, r103.f19092b, r103.f19093c, r103.f19094d);
        wg.a.f(this.f149172d, r103.f19091a, r103.f19092b, r103.f19093c, r103.f19094d);
        AppCompatTextView r104 = this.f149169a;
        com.bytedance.android.livesdk.livecommerce.skin.f r105 = this.f149175g;
        if (r105 == null) goto L17;
        Integer r113 = r105.a(r111, r112);
        if (r113 == null) goto L17;
        r100 = r113.intValue();
    L26:
        r104.setTextSize(1, r100);
        return;
    L17:
        if (r110 == 1) goto L26;
        if (r110 == 2) goto L25;
        if (r110 == 3) goto L25;
        if (r110 != 4) goto L25;
        if (r112 != true) goto L24;
        r100 = 16.0f;
        goto L26
    L24:
        r100 = 13.0f;
    L25:
        r100 = 12.0f;
        goto L26
    L8:
        r103 = new bi2.a.C0306a(UtilityKotlinExtentionsKt.d(Float.valueOf(10.0f)), UtilityKotlinExtentionsKt.d(Float.valueOf(10.0f)));
        goto L12
    L9:
        r103 = new bi2.a.C0306a(UtilityKotlinExtentionsKt.d(r102), UtilityKotlinExtentionsKt.d(r102));
        goto L12
    L10:
        r103 = new bi2.a.C0306a(UtilityKotlinExtentionsKt.d(r101), UtilityKotlinExtentionsKt.d(r101));
        goto L12
    L11:
        r103 = new bi2.a.C0306a(UtilityKotlinExtentionsKt.d(r102), UtilityKotlinExtentionsKt.d(Float.valueOf(15.0f)));
        goto L12
    }

    public /* synthetic */ TopCategoryView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
