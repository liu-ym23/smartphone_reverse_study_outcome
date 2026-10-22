package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCommentClickArea;
import com.bytedance.android.shopping.deepfeed.ui.view.CommentItemView;
import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedProductBannerCommentVH;", "Lcom/bytedance/android/shopping/deepfeed/ui/vh/AbstractDeepFeedBannerVH;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductBannerCommentVH extends AbstractDeepFeedBannerVH {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f173772u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f173773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f173774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommentItemView f173775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f173776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f173777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f173778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SimpleDraweeView f173779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SimpleDraweeView f173780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SimpleDraweeView f173781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinearLayout f173782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f173783k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f173784l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f173785m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f173786n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super DeepFeedCommentClickArea, Unit> f173787o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function0<Unit> f173788p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f173789q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Context f173790r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.ec.core.imagex.r f173791s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f173792t;

    public static final class a extends MetricAffectingSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f173793a;

        public a(int r100) {
            this.f173793a = r100;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "textPaint");
            r100.baselineShift += this.f173793a;
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "textPaint");
            r100.baselineShift += this.f173793a;
        }
    }

    public static final class b {
    }

    public static final class c extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f173794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LinearGradient f173795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f173796c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f173797d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f173798e;

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f173798e = r100;
            this.f173794a = new Matrix();
            this.f173796c = -1.0f;
            this.f173797d = -1.0f;
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            Intrinsics.checkNotNullParameter(r101, "text");
            return (int) r100.measureText(this.f173798e);
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r210, CharSequence r211, int r212, int r213, float r214, int r215, int r216, int r217, Paint r218) {
            Intrinsics.checkNotNullParameter(r210, "canvas");
            Intrinsics.checkNotNullParameter(r211, "text");
            Intrinsics.checkNotNullParameter(r218, "paint");
            if (this.f173798e.length() != 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L8;
            return;
        L8:
            Shader r101 = r218.getShader();
            int r102 = r218.getColor();
            float r103 = RangesKt.coerceAtLeast(r218.measureText(this.f173798e), 1.0f);
            float r110 = RangesKt.coerceAtLeast(r217 - r215, 1.0f);
            if (this.f173795b != null) goto L11;
        L15:
            double r111 = Math.toRadians(99.48d);
            Pair r112 = TuplesKt.to(Float.valueOf((float) Math.sin(r111)), Float.valueOf((float) (-Math.cos(r111))));
            this.f173795b = new LinearGradient(0.0f, 0.0f, r103 * ((Number) r112.getFirst()).floatValue(), ((Number) r112.getSecond()).floatValue() * r110, new int[]{ColorProtector.parseColor("#A20A32"), ColorProtector.parseColor("#1D1724"), ColorProtector.parseColor("#161823")}, new float[]{0.0465f, 0.4277f, 0.8986f}, Shader.TileMode.CLAMP);
            this.f173796c = r103;
            this.f173797d = r110;
        L16:
            this.f173794a.reset();
            this.f173794a.setTranslate(r214, r215);
            LinearGradient r104 = this.f173795b;
            if (r104 == null) goto L19;
            r104.setLocalMatrix(this.f173794a);
        L19:
            r218.setShader(this.f173795b);
            r210.drawText(this.f173798e, r214, r216, r218);
            r218.setShader(r101);
            r218.setColor(r102);
            return;
        L11:
            if (this.f173796c != r103) goto L15;
            if (this.f173797d != r110) goto L15;
        L5:
            r100 = false;
            goto L6
        }
    }

    public static final class d extends MetricAffectingSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f173799a;

        public d() {
            this.f173799a = 900;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "textPaint");
            r100.setTypeface(i.a(r100.getTypeface(), this.f173799a));
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "textPaint");
            r100.setTypeface(i.a(r100.getTypeface(), this.f173799a));
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductBannerCommentVH f173800a;

        public e(DeepFeedProductBannerCommentVH r100) {
            this.f173800a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.f173800a.itemView.isShown() == false) goto L11;
            Function0<Unit> r100 = this.f173800a.f173788p;     // Catch: Throwable -> L8
            if (r100 == null) goto L15;
            Unit r101 = r100.invoke();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbstractDeepFeedBannerVH
    public final void T3(int r100) {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbstractDeepFeedBannerVH
    public final void U3(int r100) {
    }

    public final void Y3() {
        com.bytedance.android.shopping.deepfeed.ui.view.a r100 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        int r101 = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(this.f173790r, 12);
        ViewGroup.LayoutParams r102 = this.f173773a.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r102 = null;
    L5:
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        if (r103 != null) goto L8;
        return;
    L8:
        r103.leftMargin = r101;
        r103.rightMargin = r101;
        if (this.f173792t == true) goto L11;
        r103.gravity = 17;
        r103.topMargin = 0;
        r103.bottomMargin = com.bytedance.android.shopping.extensions.b.b(10);
    L12:
        this.f173773a.setLayoutParams(r103);
        return;
    L11:
        r103.gravity = 17;
        r103.topMargin = 0;
        r103.bottomMargin = com.bytedance.android.shopping.extensions.b.b(14);
        goto L12
    }

    public final void X3(SimpleDraweeView r110, ImageURL r111) {
        if (r111 == null) goto L4;
        InFeedUrlModel r100 = new InFeedUrlModel();
        r100.setUrlList(r111.getUrlList());
    L5:
        h0.d(r110, r100, this.f173791s, null, null, null, null, 120);
        return;
    L4:
        r100 = null;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v47 */
    public final void W3(he3.h r210, int r211, Bitmap r212) {
        TextView r100 = this.f173774b;
        r100.setTypeface(i.a(r100.getTypeface(), 700));
        if (r210 == null) goto L5;
        he3.f r101 = r210.b();
    L7:
        if (r101 != null) goto L16;
        if (r210 == null) goto L10;
        List<he3.g> r102 = r210.c();
    L11:
        if (r102 != null) goto L14;
        r102 = CollectionsKt.emptyList();
    L14:
        if (r102.size() != 1) goto L16;
        boolean r103 = true;
    L18:
        if (r103 == false) goto L20;
        TextView r104 = this.f173774b;
        com.bytedance.android.shopping.deepfeed.ui.view.a r105 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        d2.d(r104, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(this.f173790r, 24), 0, 0, 0);
    L21:
        ?? r106 = this.f173774b;
        if (r210 == null) goto L24;
        he3.n r107 = r210.f();
    L25:
        if (r107 == null) goto L27;
        List<String> r108 = r107.b();
    L28:
        if (r108 != null) goto L30;
        r108 = CollectionsKt.emptyList();
    L30:
        String r109 = "";
        if (r108.isEmpty() == false) goto L33;
        ?? r110 = "";
    L57:
        r106.setText(r110);
        if (r210 == null) goto L62;
        ImageURL r111 = r210.a();
        if (r111 == null) goto L62;
        InFeedUrlModel r112 = new InFeedUrlModel();
        r112.setUrlList(r111.getUrlList());
        InFeedUrlModel r113 = r112;
    L64:
        if (r113 != null) goto L66;
        this.f173781i.setVisibility(8);
        this.f173781i.setImageDrawable(null);
        this.f173781i.getHierarchy().setPlaceholderImage(null);
    L67:
        if (r210 == null) goto L69;
        he3.f r114 = r210.b();
    L70:
        if (r114 != null) goto L72;
        this.f173775c.setVisibility(8);
    L77:
        Context r115 = this.f173790r;
        if (r210 == null) goto L80;
        List<he3.g> r116 = r210.c();
    L81:
        if (r116 != null) goto L83;
        r116 = CollectionsKt.emptyList();
    L83:
        LinearLayout r117 = this.f173776d;
        if (r116.isEmpty() == false) goto L86;
        int r118 = 8;
    L87:
        r117.setVisibility(r118);
        if (r116.isEmpty() == true) goto L139;
        ViewGroup.LayoutParams r119 = this.f173776d.getLayoutParams();
        if (r119 == null) goto L211;
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r119;
        ViewGroup.LayoutParams r121 = this.f173777e.getLayoutParams();
        if (r121 == null) goto L209;
        LinearLayout.LayoutParams r122 = (LinearLayout.LayoutParams) r121;
        ViewGroup.LayoutParams r123 = this.f173778f.getLayoutParams();
        if (r123 == null) goto L207;
        LinearLayout.LayoutParams r124 = (LinearLayout.LayoutParams) r123;
        ViewGroup.LayoutParams r125 = this.f173779g.getLayoutParams();
        if (r125 == null) goto L205;
        LinearLayout.LayoutParams r126 = (LinearLayout.LayoutParams) r125;
        ViewGroup.LayoutParams r127 = this.f173780h.getLayoutParams();
        if (r127 == null) goto L203;
        LinearLayout.LayoutParams r128 = (LinearLayout.LayoutParams) r127;
        if (r116.size() < 3) goto L116;
        this.f173776d.setGravity(0);
        com.bytedance.android.shopping.deepfeed.ui.view.a r129 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r120.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, VideoRef.VALUE_VIDEO_REF_CATEGORY);
        this.f173778f.setVisibility(0);
        this.f173780h.setVisibility(0);
        r122.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, VideoRef.VALUE_VIDEO_REF_CATEGORY);
        r122.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, VideoRef.VALUE_VIDEO_REF_CATEGORY);
        r122.weight = 0.0f;
        r124.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 115);
        r124.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, VideoRef.VALUE_VIDEO_REF_CATEGORY);
        r124.weight = 0.0f;
        r124.setMarginStart(com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 4));
        r126.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 115);
        r126.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 114);
        r126.weight = 0.0f;
        r128.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 115);
        r128.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 114);
        r128.weight = 0.0f;
        r128.topMargin = com.bytedance.android.shopping.extensions.b.b(4);
        V3(this.f173777e, com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(16));
        V3(this.f173779g, com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8));
        V3(this.f173780h, com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(8));
        SimpleDraweeView r130 = this.f173777e;
        he3.g r131 = (he3.g) CollectionsKt.getOrNull(r116, 0);
        if (r131 == null) goto L105;
        ImageURL r132 = r131.a();
    L106:
        X3(r130, r132);
        SimpleDraweeView r133 = this.f173779g;
        he3.g r134 = (he3.g) CollectionsKt.getOrNull(r116, 1);
        if (r134 == null) goto L109;
        ImageURL r135 = r134.a();
    L110:
        X3(r133, r135);
        SimpleDraweeView r136 = this.f173780h;
        he3.g r137 = (he3.g) CollectionsKt.getOrNull(r116, 2);
        if (r137 == null) goto L113;
        ImageURL r138 = r137.a();
    L114:
        X3(r136, r138);
        Y3();
    L138:
        this.f173776d.setLayoutParams(r120);
        this.f173777e.setLayoutParams(r122);
        this.f173778f.setLayoutParams(r124);
        this.f173779g.setLayoutParams(r126);
        this.f173780h.setLayoutParams(r128);
        goto L139
    L113:
        r138 = null;
        goto L114
    L109:
        r135 = null;
        goto L110
    L105:
        r132 = null;
        goto L106
    L116:
        if (r116.size() != 2) goto L126;
        this.f173776d.setGravity(0);
        com.bytedance.android.shopping.deepfeed.ui.view.a r139 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r120.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 173);
        this.f173778f.setVisibility(0);
        this.f173780h.setVisibility(8);
        r122.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 173);
        r122.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 173);
        r122.weight = 0.0f;
        r124.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 173);
        r124.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 173);
        r124.weight = 0.0f;
        r124.setMarginStart(com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 6));
        r126.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 173);
        r126.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, 173);
        r126.weight = 0.0f;
        r128.topMargin = 0;
        V3(this.f173777e, com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(16));
        V3(this.f173779g, com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(8));
        SimpleDraweeView r140 = this.f173777e;
        he3.g r141 = (he3.g) CollectionsKt.getOrNull(r116, 0);
        if (r141 == null) goto L120;
        ImageURL r142 = r141.a();
    L121:
        X3(r140, r142);
        SimpleDraweeView r143 = this.f173779g;
        he3.g r144 = (he3.g) CollectionsKt.getOrNull(r116, 1);
        if (r144 == null) goto L124;
        ImageURL r145 = r144.a();
    L125:
        X3(r143, r145);
        Y3();
        goto L138
    L124:
        r145 = null;
        goto L125
    L120:
        r142 = null;
        goto L121
    L126:
        this.f173776d.setGravity(1);
        if (r210 == null) goto L129;
        he3.f r146 = r210.b();
    L130:
        if (r146 != null) goto L132;
        int r147 = 303;
    L133:
        com.bytedance.android.shopping.deepfeed.ui.view.a r148 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r120.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, r147);
        this.f173778f.setVisibility(8);
        r122.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, r147);
        r122.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r115, r147);
        r122.weight = 0.0f;
        r124.width = 0;
        r124.height = 0;
        r124.weight = 0.0f;
        r124.setMarginStart(0);
        V3(this.f173777e, com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(16));
        SimpleDraweeView r149 = this.f173777e;
        he3.g r150 = (he3.g) CollectionsKt.getOrNull(r116, 0);
        if (r150 == null) goto L136;
        ImageURL r151 = r150.a();
    L137:
        X3(r149, r151);
        Y3();
        goto L138
    L136:
        r151 = null;
        goto L137
    L132:
        r147 = MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME;
        goto L133
    L129:
        r146 = null;
        goto L130
    L203:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L205:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L207:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L209:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L211:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L139:
        if (r210 == null) goto L143;
        he3.p r152 = r210.d();
        if (r152 == null) goto L143;
        List<he3.o> r153 = r152.b();
    L144:
        if (r153 != null) goto L146;
        r153 = CollectionsKt.emptyList();
    L146:
        ArrayList r154 = new ArrayList();
        Iterator r155 = r153.iterator();
    L148:
        if (r155.hasNext() == false) goto L158;
        String r156 = ((he3.o) r155.next()).a();
        if (r156 != null) goto L152;
    L154:
        r156 = null;
    L155:
        if (r156 == null) goto L148;
        r154.add(r156);
        goto L148
    L152:
        if ((!StringsKt.isBlank(r156)) == false) goto L154;
    L158:
        if (r154.isEmpty() == false) goto L160;
        this.f173782j.setVisibility(8);
        this.f173785m.setVisibility(8);
    L200:
        this.itemView.setOnClickListener(new f(this));
        this.f173775c.setOnCommentAreaClickListener(new DeepFeedProductBannerCommentVH$bindClickListeners$2(this));
        this.f173776d.setOnClickListener(new g(this));
        this.f173784l.setOnClickListener(new h(this));
        this.itemView.post(new e(this));
        return;
    L160:
        this.f173782j.setVisibility(0);
        ViewGroup.LayoutParams r157 = this.f173782j.getLayoutParams();
        if ((r157 instanceof LinearLayout.LayoutParams) == true) goto L163;
        r157 = null;
    L163:
        LinearLayout.LayoutParams r158 = (LinearLayout.LayoutParams) r157;
        if (r158 == null) goto L184;
        if (r210 == null) goto L168;
        he3.f r159 = r210.b();
    L169:
        if (r159 != null) goto L178;
        if (r210 == null) goto L172;
        List<he3.g> r160 = r210.c();
    L173:
        if (r160 != null) goto L175;
        r160 = CollectionsKt.emptyList();
    L175:
        int r161 = 1;
        if (r160.size() != 1) goto L179;
        boolean r162 = true;
    L180:
        if (r162 == false) goto L182;
        com.bytedance.android.shopping.deepfeed.ui.view.a r163 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r158.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(this.f173790r, 303);
        r158.gravity = r161;
        r158.leftMargin = com.bytedance.android.shopping.extensions.b.b(4);
        r158.rightMargin = com.bytedance.android.shopping.extensions.b.b(4);
    L183:
        this.f173782j.setLayoutParams(r158);
        goto L184
    L182:
        r158.width = -1;
        r158.gravity = 0;
    L179:
        r162 = false;
        goto L180
    L172:
        r160 = null;
        goto L173
    L178:
        r161 = 1;
        goto L179
    L168:
        r159 = null;
    L184:
        TextView r164 = this.f173783k;
        if (r210 == null) goto L189;
        he3.p r165 = r210.d();
        if (r165 == null) goto L189;
        String r166 = r165.a();
    L190:
        if (r166 == null) goto L193;
        r109 = r166;
    L193:
        r164.setText(r109);
        this.f173784l.setText(CollectionsKt.joinToString$default(r154, tb2.c.DEFAULT_TEXT, null, null, 0, null, null, 62, null));
        if (r210 == null) goto L196;
        he3.f r167 = r210.b();
    L197:
        if (r167 != null) goto L199;
        this.f173785m.setVisibility(0);
        goto L200
    L199:
        this.f173785m.setVisibility(8);
        goto L200
    L196:
        r167 = null;
    L189:
        r166 = null;
    L143:
        r153 = null;
        goto L144
    L86:
        r118 = 0;
        goto L87
    L80:
        r116 = null;
        goto L81
    L72:
        this.f173775c.setVisibility(0);
        CommentItemView r168 = this.f173775c;
        if (r210 == null) goto L75;
        he3.f r169 = r210.b();
    L76:
        r168.a(r169, this.f173791s, true);
        goto L77
    L75:
        r169 = null;
        goto L76
    L69:
        r114 = null;
        goto L70
    L66:
        this.f173781i.setVisibility(0);
        LruCache<String, Bitmap> r170 = l.f173841a;
        l.a(this.f173786n, r113, r211, this.f173781i, this.f173791s, r212);
    L62:
        r113 = null;
        goto L64
    L33:
        if (r107 == null) goto L35;
        List<Integer> r171 = r107.a();
    L36:
        if (r171 != null) goto L38;
        r171 = CollectionsKt.emptyList();
    L38:
        r110 = new SpannableStringBuilder();
        Iterator r172 = r108.iterator();
        int r173 = 0;
    L40:
        if (r172.hasNext() == false) goto L57;
        Object r174 = r172.next();
        int r175 = r173 + 1;
        if (r173 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        String r176 = (String) r174;
        int r177 = r110.length();
        if (r176 != null) goto L47;
        r176 = "";
    L47:
        r110.append(r176);
        if (r171.contains(Integer.valueOf(r173)) == false) goto L51;
        r110.setSpan(new c(r176), r177, r110.length(), 33);
        r110.setSpan(new AbsoluteSizeSpan(24, true), r177, r110.length(), 33);
        r110.setSpan(new d(), r177, r110.length(), 33);
    L56:
        r173 = r175;
        goto L40
    L51:
        if (r176.length() <= 0) goto L53;
        boolean r178 = true;
    L54:
        if (r178 == false) goto L56;
        r110.setSpan(new a(this.f173789q), r177, r110.length(), 33);
        goto L56
    L53:
        r178 = false;
        goto L54
    L35:
        r171 = null;
        goto L36
    L27:
        r108 = null;
        goto L28
    L24:
        r107 = null;
        goto L25
    L20:
        d2.d(this.f173774b, 0, 0, 0, 0);
        goto L21
    L10:
        r102 = null;
    L16:
        r103 = false;
        goto L18
    L5:
        r101 = null;
        goto L7
    }

    public DeepFeedProductBannerCommentVH(Context r100, View r101, com.bytedance.android.ec.core.imagex.r r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "itemView");
        super(r101);
        this.f173790r = r100;
        this.f173791s = r102;
        this.f173792t = r103;
        this.f173773a = (LinearLayout) r101.findViewById(R.id.deep_feed_comment_container);
        this.f173774b = (TextView) r101.findViewById(R.id.tv_comment_title);
        this.f173775c = (CommentItemView) r101.findViewById(R.id.comment_content_view);
        this.f173776d = (LinearLayout) r101.findViewById(R.id.layout_image_container);
        this.f173777e = (SimpleDraweeView) r101.findViewById(R.id.iv_left);
        this.f173778f = (LinearLayout) r101.findViewById(R.id.layout_right_container);
        this.f173779g = (SimpleDraweeView) r101.findViewById(R.id.iv_right_up);
        this.f173780h = (SimpleDraweeView) r101.findViewById(R.id.iv_right_down);
        this.f173781i = (SimpleDraweeView) r101.findViewById(R.id.comment_blur_iv);
        this.f173782j = (LinearLayout) r101.findViewById(R.id.impression_container);
        this.f173783k = (TextView) r101.findViewById(R.id.comment_impression_prefix);
        this.f173784l = (TextView) r101.findViewById(R.id.tv_impression_words);
        this.f173785m = r101.findViewById(R.id.deep_feed_comment_tab_impression_arrow);
        this.f173789q = com.bytedance.android.shopping.extensions.b.b(-2);
    }

    public static void V3(SimpleDraweeView r100, float r101, float r102, float r103, float r104) {
        r100.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(r101, r102, r103, r104));
    }
}
