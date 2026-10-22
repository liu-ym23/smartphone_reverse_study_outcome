package com.obric.oui.texteffects;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.texteffects.a.i;
import com.obric.oui.texteffects.a.k;
import com.obric.oui.texteffects.a.l;
import com.obric.oui.texteffects.a.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.h.b.z;
import d.n.j;
import d.n.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ODimPointGenerateEffectView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ODimPointGenerateEffectView extends FrameLayout {
    private static final a Companion = null;

    @Deprecated
    private static final String EnterScanIndicatorBindingKey = "enterScanIndicator";

    @Deprecated
    private static final String ExitScanIndicatorBindingKey = "exitScanIndicator";

    @Deprecated
    private static final String Tag = "DimPointGenerateView";
    private float debugAnimationDurationScale;
    private final d.h.a.b<Float, Integer> dp;
    private final ODimPointEffectTextView effectTextView;
    private final View enterScanIndicator;
    private final View exitScanIndicator;
    private ValueAnimator externalAnimator;
    private final List<com.obric.oui.texteffects.runtime.b> externalLayerBindings;
    private Runnable pendingContentRewriteRunnable;
    private Runnable promptGenerateIndicatorRunnable;

    /* JADX INFO: compiled from: ODimPointGenerateEffectView.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ODimPointGenerateEffectView.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36342a = null;

        static {
            int[] r0 = new int[com.obric.oui.texteffects.a.b.values().length];
            r0[com.obric.oui.texteffects.a.b.f36364b.ordinal()] = 1;
            r0[com.obric.oui.texteffects.a.b.f36363a.ordinal()] = 2;
            r0[com.obric.oui.texteffects.a.b.f36365c.ordinal()] = 3;
            r0[com.obric.oui.texteffects.a.b.f36366d.ordinal()] = 4;
            f36342a = r0;
        }
    }

    /* JADX INFO: compiled from: ODimPointGenerateEffectView.kt */
    static final class c extends p implements d.h.a.a<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ODimPointGenerateEffectView f36343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.texteffects.a.d.a f36344b;

        c(ODimPointGenerateEffectView r1, com.obric.oui.texteffects.a.d.a r2) {
            this.f36343a = r1;
            this.f36344b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Float invoke() {
            return a();
        }

        public final Float a() {
            return Float.valueOf(ODimPointGenerateEffectView.access$textWidthForBindingKey(this.f36343a, this.f36344b.c()));
        }
    }

    /* JADX INFO: compiled from: ODimPointGenerateEffectView.kt */
    static final class d extends p implements d.h.a.b<Float, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ODimPointGenerateEffectView f36345a;

        d(ODimPointGenerateEffectView r1) {
            this.f36345a = r1;
            super(1);
        }

        public final Integer a(float r2) {
            return Integer.valueOf(d.i.a.a(r2 * ZeusTransformUtils.getResources(this.f36345a, "com.obric.aiagent.plugin").getDisplayMetrics().density));
        }

        @Override // d.h.a.b
        public /* synthetic */ Integer invoke(Float r3) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
        }
    }

    /* JADX INFO: compiled from: _Sequences.kt */
    public static final class e extends p implements d.h.a.b<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f36346a = null;

        static {
            f36346a = new e();
        }

        public e() {
            super(1);
        }

        public final Boolean a(Object r1) {
            return Boolean.valueOf(ZeusTransformUtils.instanceOf(r1, com.obric.oui.texteffects.a.d.a.class));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(Object r1) {
            return a(r1);
        }
    }

    /* JADX INFO: compiled from: ODimPointGenerateEffectView.kt */
    static final class f extends p implements d.h.a.b<com.obric.oui.texteffects.a.f, j<? extends com.obric.oui.texteffects.a.d>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f36347a = null;

        static {
            f36347a = new f();
        }

        f() {
            super(1);
        }

        public final j<com.obric.oui.texteffects.a.d> a(com.obric.oui.texteffects.a.f r2) {
            o.e(r2, "it");
            return d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r2.d(), Iterable.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ j<? extends com.obric.oui.texteffects.a.d> invoke(com.obric.oui.texteffects.a.f r3) {
            return a((com.obric.oui.texteffects.a.f) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.a.f.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ODimPointGenerateEffectView.kt */
    static final class g extends p implements d.h.a.b<com.obric.oui.texteffects.a.d.a, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f36348a;

        g(String r1) {
            this.f36348a = r1;
            super(1);
        }

        public final Boolean a(com.obric.oui.texteffects.a.d.a r2) {
            o.e(r2, "it");
            return Boolean.valueOf(o.a(r2.c(), this.f36348a));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(com.obric.oui.texteffects.a.d.a r3) {
            return a((com.obric.oui.texteffects.a.d.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.a.d.a.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ODimPointGenerateEffectView.kt */
    static final class h extends p implements d.h.a.b<com.obric.oui.texteffects.a.d.a, j<? extends l>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f36349a = null;

        static {
            f36349a = new h();
        }

        h() {
            super(1);
        }

        public final j<l> a(com.obric.oui.texteffects.a.d.a r2) {
            o.e(r2, "it");
            return d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r2.b(), Iterable.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ j<? extends l> invoke(com.obric.oui.texteffects.a.d.a r3) {
            return a((com.obric.oui.texteffects.a.d.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.a.d.a.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    public ODimPointGenerateEffectView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ODimPointGenerateEffectView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$-wnuHuZPpkuz4sD_QmT5TvdB_ys, reason: not valid java name */
    public static /* synthetic */ void m1195lambda$wnuHuZPpkuz4sD_QmT5TvdB_ys(ODimPointGenerateEffectView r0, n r1) {
        m1198startGenerateFromPromptPending$lambda5(r0, r1);
    }

    public static /* synthetic */ void lambda$u5FFDfbdXFHgHyKBngFycc20gVs(ODimPointGenerateEffectView r0, CharSequence r1) {
        m1199startRewrite$lambda6(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$vDbfZ9YsfzP-mOMGFvJ-uKp033k, reason: not valid java name */
    public static /* synthetic */ void m1196lambda$vDbfZ9YsfzPmOMGFvJuKp033k(n r0, ODimPointGenerateEffectView r1, ValueAnimator r2) {
        m1197startExternalLayerAnimator$lambda11$lambda10(r0, r1, r2);
    }

    public /* synthetic */ ODimPointGenerateEffectView(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ void access$resetExternalLayers(ODimPointGenerateEffectView r0) {
        r0.resetExternalLayers();
    }

    public static final /* synthetic */ float access$textWidthForBindingKey(ODimPointGenerateEffectView r0, String r1) {
        return r0.textWidthForBindingKey(r1);
    }

    public ODimPointGenerateEffectView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        super(r3, r13, r12);
        this.externalLayerBindings = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.debugAnimationDurationScale = 1.0f;
        d.h.a.b<Float, Integer> r14 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.b.class, "com.obric.aiagent.plugin");
        this.dp = r14;
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f36355a;
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        INVOKESTATIC_com_obric_oui_texteffects_ODimPointGenerateEffectView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(o.a("OUITextEffects/", Tag), "init DimPointGenerateEffectView");
    L5:
        setClipChildren(false);
        setClipToPadding(false);
        ODimPointEffectTextView r8 = new ODimPointEffectTextView(r3, null, 0, 6, null);
        r8.setGravity(16);
        r8.setIncludeFontPadding(false);
        r8.setSingleLine(true);
        r8.setPadding(((Number) ZeusTransformUtils.preCheckCast(r14.invoke(Float.valueOf(16.0f)), Number.class, "com.obric.aiagent.plugin")).intValue(), 0, ((Number) ZeusTransformUtils.preCheckCast(r14.invoke(Float.valueOf(16.0f)), Number.class, "com.obric.aiagent.plugin")).intValue(), 0);
        this.effectTextView = r8;
        applyTextViewXmlAttributes(r13, r12);
        addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, ((Number) ZeusTransformUtils.preCheckCast(r14.invoke(Float.valueOf(56.0f)), Number.class, "com.obric.aiagent.plugin")).intValue(), 16), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r15 = createScanIndicator(false);
        this.exitScanIndicator = r15;
        View r16 = createScanIndicator(true);
        this.enterScanIndicator = r16;
        addView(r15, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(buildScanIndicatorLayoutParams(), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        addView(r16, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(buildScanIndicatorLayoutParams(), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        bindExternalLayers(com.obric.oui.texteffects.b.a.a(com.obric.oui.texteffects.b.a.f36429a, true, 0.0f, 2, null));
        resetExternalLayers();
    }

    public final ODimPointEffectTextView getEffectTextView() {
        return this.effectTextView;
    }

    public final View getExitScanIndicator() {
        return this.exitScanIndicator;
    }

    public final View getEnterScanIndicator() {
        return this.enterScanIndicator;
    }

    public final View getScanIndicator() {
        return this.enterScanIndicator;
    }

    private final void applyTextViewXmlAttributes(AttributeSet r23, int r24) {
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r23, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        if (r24 != 0) goto L6;
        return;
    L6:
        TypedArray r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r4, R.styleable.ODimPointGenerateEffectView, r24, 0);
        o.c(r1, "context.obtainStyledAttr…ectView, defStyleAttr, 0)");
    L68:
        th = move-exception;
        r1.recycle();
        throw th;
    L8:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textAppearance, "styleable", "ODimPointGenerateEffectView_android_textAppearance")) == false) goto L13;
        int r2 = r1.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textAppearance, "styleable", "ODimPointGenerateEffectView_android_textAppearance"), 0);     // Catch: Throwable -> L68
        if (r2 == 0) goto L13;
        this.effectTextView.setTextAppearance(r2);     // Catch: Throwable -> L68
    L13:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_text, "styleable", "ODimPointGenerateEffectView_android_text")) == false) goto L16;
        this.effectTextView.setText(r1.getText(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_text, "styleable", "ODimPointGenerateEffectView_android_text")));     // Catch: Throwable -> L68
    L16:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_hint, "styleable", "ODimPointGenerateEffectView_android_hint")) == false) goto L19;
        this.effectTextView.setHint(r1.getText(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_hint, "styleable", "ODimPointGenerateEffectView_android_hint")));     // Catch: Throwable -> L68
    L19:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textColor, "styleable", "ODimPointGenerateEffectView_android_textColor")) == false) goto L25;
        ColorStateList r3 = r1.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textColor, "styleable", "ODimPointGenerateEffectView_android_textColor"));     // Catch: Throwable -> L68
        if (r3 == null) goto L25;
        getEffectTextView().setTextColor(r3);     // Catch: Throwable -> L68
    L25:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textColorHint, "styleable", "ODimPointGenerateEffectView_android_textColorHint")) == false) goto L31;
        ColorStateList r5 = r1.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textColorHint, "styleable", "ODimPointGenerateEffectView_android_textColorHint"));     // Catch: Throwable -> L68
        if (r5 == null) goto L31;
        getEffectTextView().setHintTextColor(r5);     // Catch: Throwable -> L68
    L31:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textSize, "styleable", "ODimPointGenerateEffectView_android_textSize")) == false) goto L33;
        this.effectTextView.setTextSize(0, r1.getDimension(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textSize, "styleable", "ODimPointGenerateEffectView_android_textSize"), this.effectTextView.getTextSize()));     // Catch: Throwable -> L68
    L33:
        applyTypefaceFromXml(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_typeface, "styleable", "ODimPointGenerateEffectView_android_typeface"), -1), r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textStyle, "styleable", "ODimPointGenerateEffectView_android_textStyle"), -1));     // Catch: Throwable -> L68
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_gravity, "styleable", "ODimPointGenerateEffectView_android_gravity")) == false) goto L37;
        this.effectTextView.setGravity(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_gravity, "styleable", "ODimPointGenerateEffectView_android_gravity"), this.effectTextView.getGravity()));     // Catch: Throwable -> L68
    L37:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_includeFontPadding, "styleable", "ODimPointGenerateEffectView_android_includeFontPadding")) == false) goto L40;
        this.effectTextView.setIncludeFontPadding(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_includeFontPadding, "styleable", "ODimPointGenerateEffectView_android_includeFontPadding"), this.effectTextView.getIncludeFontPadding()));     // Catch: Throwable -> L68
    L40:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_singleLine, "styleable", "ODimPointGenerateEffectView_android_singleLine")) == false) goto L43;
        this.effectTextView.setSingleLine(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_singleLine, "styleable", "ODimPointGenerateEffectView_android_singleLine"), true));     // Catch: Throwable -> L68
    L43:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_lines, "styleable", "ODimPointGenerateEffectView_android_lines")) == false) goto L46;
        this.effectTextView.setLines(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_lines, "styleable", "ODimPointGenerateEffectView_android_lines"), 1));     // Catch: Throwable -> L68
    L46:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_minLines, "styleable", "ODimPointGenerateEffectView_android_minLines")) == false) goto L49;
        this.effectTextView.setMinLines(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_minLines, "styleable", "ODimPointGenerateEffectView_android_minLines"), 1));     // Catch: Throwable -> L68
    L49:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_maxLines, "styleable", "ODimPointGenerateEffectView_android_maxLines")) == false) goto L52;
        this.effectTextView.setMaxLines(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_maxLines, "styleable", "ODimPointGenerateEffectView_android_maxLines"), Integer.MAX_VALUE));     // Catch: Throwable -> L68
    L52:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_ellipsize, "styleable", "ODimPointGenerateEffectView_android_ellipsize")) == false) goto L56;
        this.effectTextView.setEllipsize(parseEllipsize(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_ellipsize, "styleable", "ODimPointGenerateEffectView_android_ellipsize"), 0)));     // Catch: Throwable -> L68
    L56:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_lineSpacingExtra, "styleable", "ODimPointGenerateEffectView_android_lineSpacingExtra")) == false) goto L58;
    L59:
        float r6 = r1.getDimension(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_lineSpacingExtra, "styleable", "ODimPointGenerateEffectView_android_lineSpacingExtra"), 0.0f);     // Catch: Throwable -> L68
        float r7 = r1.getFloat(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_lineSpacingMultiplier, "styleable", "ODimPointGenerateEffectView_android_lineSpacingMultiplier"), 1.0f);     // Catch: Throwable -> L68
        this.effectTextView.setLineSpacing(r6, r7);     // Catch: Throwable -> L68
    L61:
        if (Build.VERSION.SDK_INT >= 21) goto L63;
    L65:
        applyTextViewPaddingFromXml(r1);     // Catch: Throwable -> L68
        r1.recycle();
        return;
    L63:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_letterSpacing, "styleable", "ODimPointGenerateEffectView_android_letterSpacing")) == false) goto L65;
        this.effectTextView.setLetterSpacing(r1.getFloat(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_letterSpacing, "styleable", "ODimPointGenerateEffectView_android_letterSpacing"), this.effectTextView.getLetterSpacing()));     // Catch: Throwable -> L68
        goto L65
    L58:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_lineSpacingMultiplier, "styleable", "ODimPointGenerateEffectView_android_lineSpacingMultiplier")) == false) goto L61;
        goto L59
    }

    private final void applyTypefaceFromXml(int r3, int r4) {
        if (r4 < 0) goto L4;
        int r0 = r4;
    L6:
        if (r3 != 1) goto L8;
        Typeface r1 = Typeface.SANS_SERIF;
    L15:
        if (r3 >= 0) goto L17;
        if (r4 >= 0) goto L17;
        return;
    L17:
        this.effectTextView.setTypeface(r1, r0);
        return;
    L8:
        if (r3 != 2) goto L10;
        r1 = Typeface.SERIF;
        goto L15
    L10:
        if (r3 == 3) goto L12;
        r1 = this.effectTextView.getTypeface();
        goto L15
    L12:
        r1 = Typeface.MONOSPACE;
        goto L15
    L4:
        r0 = 0;
        goto L6
    }

    private final void applyTextViewPaddingFromXml(TypedArray r9) {
        int r0 = this.effectTextView.getPaddingLeft();
        int r1 = this.effectTextView.getPaddingTop();
        int r2 = this.effectTextView.getPaddingRight();
        int r3 = this.effectTextView.getPaddingBottom();
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_padding, "styleable", "ODimPointGenerateEffectView_android_padding")) == false) goto L5;
        Integer r4 = Integer.valueOf(r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_padding, "styleable", "ODimPointGenerateEffectView_android_padding"), 0));
    L6:
        if (r4 == null) goto L9;
        r0 = r4.intValue();
    L9:
        if (r4 == null) goto L12;
        r1 = r4.intValue();
    L12:
        if (r4 == null) goto L15;
        r2 = r4.intValue();
    L15:
        if (r4 == null) goto L19;
        r3 = r4.intValue();
    L19:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingLeft, "styleable", "ODimPointGenerateEffectView_android_paddingLeft")) == false) goto L22;
        r0 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingLeft, "styleable", "ODimPointGenerateEffectView_android_paddingLeft"), r0);
    L22:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingTop, "styleable", "ODimPointGenerateEffectView_android_paddingTop")) == false) goto L25;
        r1 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingTop, "styleable", "ODimPointGenerateEffectView_android_paddingTop"), r1);
    L25:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingRight, "styleable", "ODimPointGenerateEffectView_android_paddingRight")) == false) goto L28;
        r2 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingRight, "styleable", "ODimPointGenerateEffectView_android_paddingRight"), r2);
    L28:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingBottom, "styleable", "ODimPointGenerateEffectView_android_paddingBottom")) == false) goto L31;
        r3 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingBottom, "styleable", "ODimPointGenerateEffectView_android_paddingBottom"), r3);
    L31:
        if (Build.VERSION.SDK_INT >= 17) goto L33;
    L38:
        this.effectTextView.setPadding(r0, r1, r2, r3);
        return;
    L33:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingStart, "styleable", "ODimPointGenerateEffectView_android_paddingStart")) == false) goto L36;
        r0 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingStart, "styleable", "ODimPointGenerateEffectView_android_paddingStart"), r0);
    L36:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingEnd, "styleable", "ODimPointGenerateEffectView_android_paddingEnd")) == false) goto L38;
        r2 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingEnd, "styleable", "ODimPointGenerateEffectView_android_paddingEnd"), r2);
        goto L38
    L5:
        r4 = (Integer) ZeusTransformUtils.preCheckCast(null, Integer.class, "com.obric.aiagent.plugin");
        goto L6
    }

    private final TextUtils.TruncateAt parseEllipsize(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f36355a;
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        INVOKESTATIC_com_obric_oui_texteffects_ODimPointGenerateEffectView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(o.a("OUITextEffects/", Tag), "onDetachedFromWindow");
    L5:
        stopEffect();
        super.onDetachedFromWindow();
    }

    public final void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        stopEffect();
        this.effectTextView.setText(r4);
    }

    public static /* synthetic */ void startGenerate$default(ODimPointGenerateEffectView r1, CharSequence r2, int r3, Object r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        r1.startGenerate(r5);
    }

    public final void startGenerate(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        n r0 = com.obric.oui.texteffects.b.a.f36429a.a(true);
        this.effectTextView.setDebugAnimationDurationScale(this.debugAnimationDurationScale);
        this.effectTextView.startGenerate(r6);
        View r7 = this.enterScanIndicator;
        CharSequence r2 = this.effectTextView.getText();
        if (r2 != null) goto L5;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L5:
        updateScanIndicatorSize(r7, r2, r0, EnterScanIndicatorBindingKey);
        startExternalLayerAnimator(r0);
    }

    public final void startDimPointTextEffect(CharSequence r3) {
        submitContentText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final void submitContentText(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r0 = this.effectTextView.getText();
        if (r0 != null) goto L5;
        r0 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L5:
        if (r6 != null) goto L7;
        r6 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L7:
        boolean r2 = true;
        if (this.effectTextView.isPromptPending() == false) goto L17;
        if (r6.length() <= 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L17;
        startGenerateFromPromptPending(r6);
        return;
    L12:
        r1 = false;
    L17:
        if (TextUtils.equals(r0, r6) == false) goto L25;
        if (r0.length() == 0) goto L22;
        r2 = false;
    L22:
        if (r2 == false) goto L32;
        stopEffect();
        this.effectTextView.setText(r6);
        return;
    L32:
        return;
    L25:
        if (r0.length() == 0) goto L28;
        r2 = false;
    L28:
        if (r2 == false) goto L30;
        startGenerate(r6);
        return;
    L30:
        startRewrite(r6);
    }

    public final void setTextWithEffect(CharSequence r3) {
        submitContentText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final void showPromptPending(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "promptText");
        startPromptPending(r4);
    }

    public final void showPromptFailure(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "failurePromptText");
        startPromptTextSwitch(r4);
    }

    public static /* synthetic */ void showContentPending$default(ODimPointGenerateEffectView r1, CharSequence r2, int r3, Object r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = r1.effectTextView.getText();
    L5:
        r1.showContentPending(r5);
    }

    public final void showContentPending(CharSequence r3) {
        startContentPending((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final void startPromptPending(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "promptText");
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        stopExternalAnimator();
        this.effectTextView.setDebugAnimationDurationScale(this.debugAnimationDurationScale);
        this.effectTextView.startPromptPending(r4);
    }

    public static /* synthetic */ void startContentPending$default(ODimPointGenerateEffectView r1, CharSequence r2, int r3, Object r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = r1.effectTextView.getText();
    L5:
        r1.startContentPending(r5);
    }

    public final void startContentPending(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        stopExternalAnimator();
        this.effectTextView.setDebugAnimationDurationScale(this.debugAnimationDurationScale);
        this.effectTextView.startContentPending(r4);
    }

    public final void startGenerateFromPromptPending(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r5, "actualText");
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        if (this.effectTextView.isPromptPending() == true) goto L6;
        startGenerate(r5);
        return;
    L6:
        stopExternalAnimator();
        this.effectTextView.setDebugAnimationDurationScale(this.debugAnimationDurationScale);
        this.effectTextView.startGenerateFromPromptPending(r5);
        final n r0 = com.obric.oui.texteffects.b.a.f36429a.a(true);
        updateScanIndicatorSize(this.enterScanIndicator, r5, r0, EnterScanIndicatorBindingKey);
        Runnable r6 = new $$Lambda$ODimPointGenerateEffectView$wnuHuZPpkuz4sD_QmT5TvdB_ys(this, r0);
        this.promptGenerateIndicatorRunnable = r6;
        postDelayed(r6, scaledDurationMs(150));
    }

    /* JADX INFO: renamed from: startGenerateFromPromptPending$lambda-5, reason: not valid java name */
    private static final void m1198startGenerateFromPromptPending$lambda5(ODimPointGenerateEffectView r1, n r2) {
        o.e(r1, "this$0");
        o.e(r2, "$spec");
        r1.promptGenerateIndicatorRunnable = null;
        r1.startExternalLayerAnimator(r2);
    }

    public final void startPromptTextSwitch(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "newPromptText");
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        stopExternalAnimator();
        this.effectTextView.setDebugAnimationDurationScale(this.debugAnimationDurationScale);
        this.effectTextView.startPromptTextSwitch(r4);
    }

    public final void startRewrite(CharSequence r7) {
        final CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r8, "newText");
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        n r0 = com.obric.oui.texteffects.b.a.a(com.obric.oui.texteffects.b.a.f36429a, true, 0.0f, 2, null);
        if (this.effectTextView.isRewriteExitingOldText() == false) goto L7;
        this.effectTextView.startRewrite(r8);
        updateScanIndicatorSize(this.enterScanIndicator, r8, r0, EnterScanIndicatorBindingKey);
        return;
    L7:
        if (this.effectTextView.isRewriteEnteringNewText() == false) goto L10;
        Runnable r1 = new $$Lambda$ODimPointGenerateEffectView$u5FFDfbdXFHgHyKBngFycc20gVs(this, r8);
        this.pendingContentRewriteRunnable = r1;
        postDelayed(r1, remainingRewriteDurationMs());
        return;
    L10:
        CharSequence r2 = this.effectTextView.getText();
        if (r2 != null) goto L13;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L13:
        this.effectTextView.setDebugAnimationDurationScale(this.debugAnimationDurationScale);
        this.effectTextView.startRewrite(r8);
        updateScanIndicatorSize(this.exitScanIndicator, r2, r0, ExitScanIndicatorBindingKey);
        updateScanIndicatorSize(this.enterScanIndicator, r8, r0, EnterScanIndicatorBindingKey);
        startExternalLayerAnimator(r0);
    }

    /* JADX INFO: renamed from: startRewrite$lambda-6, reason: not valid java name */
    private static final void m1199startRewrite$lambda6(ODimPointGenerateEffectView r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        o.e(r4, "$newText");
        r2.pendingContentRewriteRunnable = null;
        r2.startRewrite(r4);
    }

    public final void stopGenerate() {
        stopEffect();
    }

    public final void stopEffect() {
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f36355a;
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        INVOKESTATIC_com_obric_oui_texteffects_ODimPointGenerateEffectView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(o.a("OUITextEffects/", Tag), "stopEffect");
    L5:
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        stopExternalAnimator();
        this.effectTextView.stopEffect();
    }

    public final void setDebugAnimationDurationScale(float r4) {
        if (Float.isNaN(r4) == false) goto L5;
    L8:
        float r5 = 1.0f;
    L10:
        if (this.debugAnimationDurationScale != r5) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        return;
    L15:
        this.debugAnimationDurationScale = r5;
        com.obric.oui.texteffects.a r1 = com.obric.oui.texteffects.a.f36355a;
        if (com.obric.oui.texteffects.a.a() == false) goto L18;
        INVOKESTATIC_com_obric_oui_texteffects_ODimPointGenerateEffectView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(o.a("OUITextEffects/", Tag), o.a("setDebugAnimationDurationScale scale=", Float.valueOf(r5)));
    L18:
        this.effectTextView.setDebugAnimationDurationScale(r5);
        return;
    L12:
        r0 = false;
        goto L13
    L5:
        if (Float.isInfinite(r4) == true) goto L8;
        r5 = d.l.n.a(r4, 0.1f, 10.0f);
        goto L10
    }

    public final float getDebugAnimationDurationScale() {
        return this.debugAnimationDurationScale;
    }

    public final void setScanIndicatorMaterial(com.obric.oui.material.c r2) {
        o.e(r2, "config");
        setEnterScanIndicatorMaterial(r2);
    }

    public final void setEnterScanIndicatorMaterial(com.obric.oui.material.c r2) {
        o.e(r2, "config");
        com.obric.oui.material.l.a(this.enterScanIndicator, r2);
    }

    public final void setExitScanIndicatorMaterial(com.obric.oui.material.c r2) {
        o.e(r2, "config");
        com.obric.oui.material.l.a(this.exitScanIndicator, r2);
    }

    private final void startExternalLayerAnimator(final n r6) {
        stopExternalAnimator();
        bindExternalLayers(r6);
        final z.a r0 = new z.a();
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setDuration(scaledDurationMs(r6.b()));
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r1.addUpdateListener(new $$Lambda$ODimPointGenerateEffectView$vDbfZ9YsfzPmOMGFvJuKp033k(r6, this));
        r1.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new ODimPointGenerateEffectView$startExternalLayerAnimator$1$2(r0, r6, this), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        r1.start();
        this.externalAnimator = r1;
    }

    /* JADX INFO: renamed from: startExternalLayerAnimator$lambda-11$lambda-10, reason: not valid java name */
    private static final void m1197startExternalLayerAnimator$lambda11$lambda10(n r4, ODimPointGenerateEffectView r5, ValueAnimator r6) {
        o.e(r4, "$spec");
        o.e(r5, "this$0");
        o.e(r6, "animator");
        long r0 = (long) (r6.getAnimatedFraction() * r4.b());
        com.obric.oui.texteffects.a r7 = com.obric.oui.texteffects.a.f36355a;
        if (com.obric.oui.texteffects.a.a() == true) goto L5;
    L7:
        r5.applyExternalFrame(r4, r0);
        return;
    L5:
        if (com.obric.oui.texteffects.a.b() == false) goto L7;
        INVOKESTATIC_com_obric_oui_texteffects_ODimPointGenerateEffectView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(o.a("OUITextEffects/", Tag), "external animator update spec=" + r4.a() + ", playTime=" + r0);
        goto L7
    }

    private final void applyExternalFrame(n r3, long r4) {
        com.obric.oui.texteffects.runtime.d r5 = com.obric.oui.texteffects.runtime.e.f36466a.a(r3, r4);
        com.obric.oui.texteffects.runtime.a.f36451a.a(r5, (Collection) ZeusTransformUtils.preCheckCast(this.externalLayerBindings, Collection.class, "com.obric.aiagent.plugin"), resolvedExternalParentWidthPx());
    }

    private final float resolvedExternalParentWidthPx() {
        Integer r0 = Integer.valueOf(getWidth());
        boolean r3 = true;
        int r4 = 0;
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r5 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L36;
        r0 = Integer.valueOf(getMeasuredWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L18;
        r0 = null;
    L18:
        if (r0 != null) goto L36;
        r0 = Integer.valueOf(this.effectTextView.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L26;
        r0 = null;
    L26:
        if (r0 != null) goto L36;
        Integer r7 = Integer.valueOf(this.effectTextView.getMeasuredWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L31;
        r3 = false;
    L31:
        if (r3 == false) goto L33;
        r5 = r7;
    L33:
        if (r5 == null) goto L38;
        r4 = r5.intValue();
    L38:
        return r4;
    L22:
        r6 = false;
        goto L23
    L14:
        r2 = false;
    L36:
        r4 = r0.intValue();
        goto L38
    L5:
        r1 = false;
        goto L6
    }

    private final void stopExternalAnimator() {
        if (this.externalAnimator == null) goto L7;
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f36355a;
        if (com.obric.oui.texteffects.a.a() == false) goto L7;
        INVOKESTATIC_com_obric_oui_texteffects_ODimPointGenerateEffectView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(o.a("OUITextEffects/", Tag), "stopExternalAnimator");
    L7:
        ValueAnimator r1 = this.externalAnimator;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        this.externalAnimator = null;
        resetExternalLayers();
    }

    private final void cancelPromptGenerateIndicatorRunnable() {
        Runnable r0 = this.promptGenerateIndicatorRunnable;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
    L6:
        this.promptGenerateIndicatorRunnable = null;
    }

    private final void cancelPendingContentRewriteRunnable() {
        Runnable r0 = this.pendingContentRewriteRunnable;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
    L6:
        this.pendingContentRewriteRunnable = null;
    }

    private final long remainingRewriteDurationMs() {
        return scaledDurationMs(d.l.n.a(com.obric.oui.texteffects.b.a.a(com.obric.oui.texteffects.b.a.f36429a, true, 0.0f, 2, null).b() - this.effectTextView.currentRewritePlayTimeMs(), 1));
    }

    private final void resetExternalLayers() {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.externalLayerBindings, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.obric.oui.texteffects.runtime.b) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.oui.texteffects.runtime.b.class, "com.obric.aiagent.plugin")).c();
        goto L4
    }

    private final void bindExternalLayers(n r13) {
        this.externalLayerBindings.clear();
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13.d(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        d.a.p.a(r0, (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.oui.texteffects.a.f) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.oui.texteffects.a.f.class, "com.obric.aiagent.plugin")).d(), Iterable.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L8:
        if (r17.hasNext() == false) goto L12;
        Object r2 = r17.next();
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.texteffects.a.d.a.class) == false) goto L8;
        r1.add(r2);
        goto L8
    L12:
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        HashSet r3 = new HashSet();
        ArrayList r4 = new ArrayList();
        Iterator r19 = r18.iterator();
    L14:
        if (r19.hasNext() == false) goto L18;
        Object r5 = r19.next();
        if (r3.add(((com.obric.oui.texteffects.a.d.a) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.texteffects.a.d.a.class, "com.obric.aiagent.plugin")).c()) == false) goto L14;
        r4.add(r5);
        goto L14
    L18:
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r110.hasNext() == false) goto L31;
        com.obric.oui.texteffects.a.d.a r6 = (com.obric.oui.texteffects.a.d.a) ZeusTransformUtils.preCheckCast(r110.next(), com.obric.oui.texteffects.a.d.a.class, "com.obric.aiagent.plugin");
        View r7 = viewForBindingKey(r6.c());
        if (r7 == null) goto L20;
        k r8 = r6.d();
        if (r8 == null) goto L28;
        com.obric.oui.material.l.a(r7, buildScanIndicatorMaterial(true, toMaterialBlurDirection(r8.a())));
    L28:
        ((Collection) ZeusTransformUtils.preCheckCast(this.externalLayerBindings, Collection.class, "com.obric.aiagent.plugin")).add(new com.obric.oui.texteffects.runtime.b(r6.c(), r7, (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this, r6), d.h.a.a.class, "com.obric.aiagent.plugin"), 0, 0.0f, 24, null));
        com.obric.oui.texteffects.a r9 = com.obric.oui.texteffects.a.f36355a;
        if (com.obric.oui.texteffects.a.a() == false) goto L20;
        INVOKESTATIC_com_obric_oui_texteffects_ODimPointGenerateEffectView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(o.a("OUITextEffects/", Tag), "bind external layer id=" + r6.a() + ", bindingKey=" + r6.c());
        goto L20
    }

    private final View viewForBindingKey(String r2) {
        if (o.a(r2, ExitScanIndicatorBindingKey) == false) goto L6;
        return this.exitScanIndicator;
    L6:
        if (o.a(r2, EnterScanIndicatorBindingKey) == true) goto L11;
        return null;
    L11:
        return this.enterScanIndicator;
    }

    private final float textWidthForBindingKey(String r4) {
        CharSequence r2 = null;
        if (o.a(r4, ExitScanIndicatorBindingKey) == false) goto L8;
        Object r5 = this.exitScanIndicator.getTag();
        if (ZeusTransformUtils.instanceOf(r5, CharSequence.class) == false) goto L12;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        if (r2 != null) goto L14;
        r2 = this.effectTextView.getText();
    L14:
        if (r2 != null) goto L17;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L17:
        return d.l.n.a(computeDisplayTextWidthPx(r2), 1.0f);
    L8:
        if (o.a(r4, EnterScanIndicatorBindingKey) == false) goto L12;
        Object r6 = this.enterScanIndicator.getTag();
        if (ZeusTransformUtils.instanceOf(r6, CharSequence.class) == false) goto L12;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        goto L12
    }

    private final int toMaterialBlurDirection(com.obric.oui.texteffects.a.b r3) {
        int r2 = b.f36342a[r3.ordinal()];
        if (r2 != 1) goto L5;
        return 4;
    L5:
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L12;
        if (r2 == 4) goto L12;
        throw new d.k();
    L12:
        return 3;
    }

    private final View createScanIndicator(boolean r3) {
        View r4 = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r4.setAlpha(1.0f);
        r4.setVisibility(4);
        return r4;
    }

    private final FrameLayout.LayoutParams buildScanIndicatorLayoutParams() {
        return new FrameLayout.LayoutParams(((Number) ZeusTransformUtils.preCheckCast(this.dp.invoke(Float.valueOf(16.0f)), Number.class, "com.obric.aiagent.plugin")).intValue(), computeScanIndicatorHeightPx(), 19);
    }

    private final void updateScanIndicatorSize(View r8, CharSequence r9, n r10, String r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        r8.setTag(r12);
        Float r0 = scanIndicatorFromRatio(r10, r11);
        if (r0 != null) goto L8;
        ODimPointGenerateEffectView r7 = (ODimPointGenerateEffectView) ZeusTransformUtils.preCheckCast(this, ODimPointGenerateEffectView.class, "com.obric.aiagent.plugin");
        com.obric.oui.texteffects.a r13 = com.obric.oui.texteffects.a.f36355a;
        if (com.obric.oui.texteffects.a.a() == false) goto L24;
        INVOKESTATIC_com_obric_oui_texteffects_ODimPointGenerateEffectView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(o.a("OUITextEffects/", Tag), "skip indicator size update, missing fromRatio bindingKey=" + r11 + ", spec=" + r10.a());
        return;
    L24:
        return;
    L8:
        float r14 = r0.floatValue();
        int r1 = computeScanIndicatorWidthPx(r12, r14);
        int r15 = computeScanIndicatorHeightPx();
        ViewGroup.LayoutParams r4 = r8.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r4, FrameLayout.LayoutParams.class) == false) goto L11;
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L13:
        if (r5 != null) goto L16;
        r8.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(r1, r15, 19), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L20:
        r8.measure(View.MeasureSpec.makeMeasureSpec(r1, 1073741824), View.MeasureSpec.makeMeasureSpec(r15, 1073741824));
        com.obric.oui.texteffects.a r16 = com.obric.oui.texteffects.a.f36355a;
        if (com.obric.oui.texteffects.a.a() == false) goto L25;
        INVOKESTATIC_com_obric_oui_texteffects_ODimPointGenerateEffectView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(o.a("OUITextEffects/", Tag), "update indicator size bindingKey=" + r11 + ", fromRatio=" + r14 + ", text=" + r12 + ", width=" + r1 + ", height=" + r15);
        return;
    L25:
        return;
    L16:
        if (r5.width == r1) goto L18;
    L19:
        r5.width = r1;
        r5.height = r15;
        r5.gravity = 19;
        r8.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        goto L20
    L18:
        if (r5.height == r15) goto L20;
    L11:
        r5 = null;
        goto L13
    }

    private final Float scanIndicatorFromRatio(n r9, String r10) {
        Iterator r11 = m.c(m.a(m.a(m.c(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r9.d(), Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(f.f36347a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(e.f36346a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(new g(r10), d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(h.f36349a, d.h.a.b.class, "com.obric.aiagent.plugin")).a();
    L4:
        if (r11.hasNext() == false) goto L11;
        Object r12 = r11.next();
        if (((l) ZeusTransformUtils.preCheckCast(r12, l.class, "com.obric.aiagent.plugin")).a() != com.obric.oui.texteffects.a.e.f36387c) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        l r13 = (l) ZeusTransformUtils.preCheckCast(r12, l.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L45;
        List<i> r14 = r13.b();
        if (r14 == null) goto L46;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r15.hasNext() == true) goto L21;
        Object r16 = null;
    L30:
        i r17 = (i) ZeusTransformUtils.preCheckCast(r16, i.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L47;
        com.obric.oui.texteffects.a.g r18 = r17.b();
        if (r18 != null) goto L37;
        return null;
    L37:
        return textWidthRatioOrNull(r18);
    L47:
        return null;
    L21:
        r16 = r15.next();
        if (r15.hasNext() == false) goto L30;
        long r3 = ((i) ZeusTransformUtils.preCheckCast(r16, i.class, "com.obric.aiagent.plugin")).a();
    L25:
        Object r4 = r15.next();
        long r5 = ((i) ZeusTransformUtils.preCheckCast(r4, i.class, "com.obric.aiagent.plugin")).a();
        if (r3 <= r5) goto L29;
        r16 = r4;
        r3 = r5;
    L29:
        if (r15.hasNext() == true) goto L25;
    L46:
        return null;
    L45:
        return null;
    L8:
        r2 = false;
        goto L9
    L11:
        r12 = null;
        goto L12
    }

    private final Float textWidthRatioOrNull(com.obric.oui.texteffects.a.g r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.texteffects.a.g.f.class) == false) goto L6;
        return Float.valueOf(((com.obric.oui.texteffects.a.g.f) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.a.g.f.class, "com.obric.aiagent.plugin")).a());
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.texteffects.a.g.c.class) == true) goto L11;
        return null;
    L11:
        return textWidthRatioOrNull(((com.obric.oui.texteffects.a.g.c) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.a.g.c.class, "com.obric.aiagent.plugin")).a());
    }

    private final int computeScanIndicatorWidthPx(CharSequence r3, float r4) {
        return d.l.n.c(d.i.a.a((float) Math.ceil(computeDisplayTextWidthPx((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin")) * Math.abs(r4))), 1);
    }

    private final float computeDisplayTextWidthPx(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        float r0 = d.l.n.a((this.effectTextView.getWidth() - this.effectTextView.getCompoundPaddingLeft()) - this.effectTextView.getCompoundPaddingRight(), 0.0f);
        if (this.effectTextView.getEllipsize() == null) goto L8;
        if (r0 <= 0.0f) goto L8;
        r5 = TextUtils.ellipsize(r5, this.effectTextView.getPaint(), r0, this.effectTextView.getEllipsize());
    L8:
        return this.effectTextView.getPaint().measureText(r5, 0, r5.length());
    }

    private final int computeScanIndicatorHeightPx() {
        Paint.FontMetrics r0 = this.effectTextView.getPaint().getFontMetrics();
        return d.l.n.c(d.i.a.a((float) Math.ceil((r0.descent - r0.ascent) + (((Number) ZeusTransformUtils.preCheckCast(this.dp.invoke(Float.valueOf(16.0f)), Number.class, "com.obric.aiagent.plugin")).floatValue() * 2.0f))), 1);
    }

    private final long scaledDurationMs(long r1) {
        return d.l.n.c(d.i.a.a(r1 * this.debugAnimationDurationScale), 1);
    }

    private final com.obric.oui.material.c buildScanIndicatorMaterial(boolean r16, int r17) {
        com.obric.oui.color.a[] r3 = com.obric.oui.material.l.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.array.oui_no_gradient_blur_colors, "array", "oui_no_gradient_blur_colors"), ZeusTransformUtils.mapRes(R.array.oui_no_gradient_blur_blend_modes, "array", "oui_no_gradient_blur_blend_modes"));
        if (r16 == false) goto L5;
    L8:
        float r0 = 16.0f;
    L10:
        return new com.obric.oui.material.c(null, null, r3, null, null, null, new com.obric.oui.blur.a(r0, r17, 0.0f, 3, 0.0f, 20, null), null, null, null, 955, null);
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L8;
        r0 = BlurToken.Blur_Progress_Thin;
        goto L10
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_texteffects_ODimPointGenerateEffectView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
