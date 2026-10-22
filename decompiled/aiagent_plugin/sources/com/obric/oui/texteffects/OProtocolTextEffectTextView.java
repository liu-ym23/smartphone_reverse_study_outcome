package com.obric.oui.texteffects;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.texteffects.a.j;
import com.obric.oui.texteffects.a.m;
import com.obric.oui.texteffects.a.n;
import com.obric.oui.texteffects.a.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.l;
import d.h.b.p;
import d.h.b.z;
import d.k;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class OProtocolTextEffectTextView extends TextView {
    private static final a Companion = null;

    @Deprecated
    public static final String EffectNameNone = "none";
    private String activeEffectName;
    private n activeSpec;
    private ValueAnimator animator;
    private final d.f blurFilterCache$delegate;
    private final float blurFilterCacheGranularityPx;
    private com.obric.oui.texteffects.c.c currentTextCache;
    private float debugAnimationDurationScale;
    private final d.h.a.b<Float, Float> dp;
    private CharSequence finalTextOnEnd;
    private final String logTag;
    private final float maxBlurRadiusDp;
    private com.obric.oui.texteffects.c.c newTextCache;
    private CharSequence newTextForEffect;
    private com.obric.oui.texteffects.c.c oldTextCache;
    private CharSequence oldTextForEffect;
    private long playTimeMs;

    /* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36350a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f36351b = null;

        static {
            int[] r0 = new int[o.values().length];
            r0[o.f36425a.ordinal()] = 1;
            r0[o.f36426b.ordinal()] = 2;
            r0[o.f36427c.ordinal()] = 3;
            f36350a = r0;
            int[] r1 = new int[com.obric.oui.texteffects.a.a.values().length];
            r1[com.obric.oui.texteffects.a.a.f36358a.ordinal()] = 1;
            r1[com.obric.oui.texteffects.a.a.f36359b.ordinal()] = 2;
            r1[com.obric.oui.texteffects.a.a.f36360c.ordinal()] = 3;
            r1[com.obric.oui.texteffects.a.a.f36361d.ordinal()] = 4;
            r1[com.obric.oui.texteffects.a.a.f36362e.ordinal()] = 5;
            r1[com.obric.oui.texteffects.a.a.f.ordinal()] = 6;
            r1[com.obric.oui.texteffects.a.a.g.ordinal()] = 7;
            r1[com.obric.oui.texteffects.a.a.h.ordinal()] = 8;
            r1[com.obric.oui.texteffects.a.a.i.ordinal()] = 9;
            r1[com.obric.oui.texteffects.a.a.j.ordinal()] = 10;
            r1[com.obric.oui.texteffects.a.a.k.ordinal()] = 11;
            r1[com.obric.oui.texteffects.a.a.l.ordinal()] = 12;
            r1[com.obric.oui.texteffects.a.a.m.ordinal()] = 13;
            r1[com.obric.oui.texteffects.a.a.n.ordinal()] = 14;
            r1[com.obric.oui.texteffects.a.a.o.ordinal()] = 15;
            r1[com.obric.oui.texteffects.a.a.p.ordinal()] = 16;
            r1[com.obric.oui.texteffects.a.a.q.ordinal()] = 17;
            r1[com.obric.oui.texteffects.a.a.r.ordinal()] = 18;
            r1[com.obric.oui.texteffects.a.a.s.ordinal()] = 19;
            r1[com.obric.oui.texteffects.a.a.t.ordinal()] = 20;
            r1[com.obric.oui.texteffects.a.a.u.ordinal()] = 21;
            r1[com.obric.oui.texteffects.a.a.v.ordinal()] = 22;
            r1[com.obric.oui.texteffects.a.a.w.ordinal()] = 23;
            r1[com.obric.oui.texteffects.a.a.x.ordinal()] = 24;
            r1[com.obric.oui.texteffects.a.a.y.ordinal()] = 25;
            r1[com.obric.oui.texteffects.a.a.z.ordinal()] = 26;
            r1[com.obric.oui.texteffects.a.a.A.ordinal()] = 27;
            r1[com.obric.oui.texteffects.a.a.B.ordinal()] = 28;
            r1[com.obric.oui.texteffects.a.a.C.ordinal()] = 29;
            f36351b = r1;
        }
    }

    /* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
    static final class c extends p implements d.h.a.a<com.obric.oui.texteffects.c.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OProtocolTextEffectTextView f36352a;

        c(OProtocolTextEffectTextView r1) {
            this.f36352a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ com.obric.oui.texteffects.c.a invoke() {
            return a();
        }

        public final com.obric.oui.texteffects.c.a a() {
            return new com.obric.oui.texteffects.c.a(((Number) ZeusTransformUtils.preCheckCast(OProtocolTextEffectTextView.access$getDp$p(this.f36352a).invoke(Float.valueOf(this.f36352a.getMaxBlurRadiusDp())), Number.class, "com.obric.aiagent.plugin")).floatValue(), this.f36352a.getBlurFilterCacheGranularityPx());
        }
    }

    /* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
    /* synthetic */ class d extends l implements d.h.a.b<Float, Float> {
        d(Object r8) {
            super(1, r8, OProtocolTextEffectTextView.class, "computeStartX", "computeStartX(F)F", 0);
        }

        public final Float a(float r3) {
            return Float.valueOf(((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this.receiver, OProtocolTextEffectTextView.class, "com.obric.aiagent.plugin")).computeStartX(r3));
        }

        @Override // d.h.a.b
        public /* synthetic */ Float invoke(Float r3) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
        }
    }

    /* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
    static final class e extends p implements d.h.a.b<com.obric.oui.texteffects.c.c, LinearGradient> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f36353a = null;

        static {
            f36353a = new e();
        }

        e() {
            super(1);
        }

        public final LinearGradient a(com.obric.oui.texteffects.c.c r1) {
            d.h.b.o.e(r1, "it");
            return null;
        }

        @Override // d.h.a.b
        public /* synthetic */ LinearGradient invoke(com.obric.oui.texteffects.c.c r3) {
            return a((com.obric.oui.texteffects.c.c) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.c.c.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
    static final class f extends p implements d.h.a.b<Float, Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OProtocolTextEffectTextView f36354a;

        f(OProtocolTextEffectTextView r1) {
            this.f36354a = r1;
            super(1);
        }

        public final Float a(float r2) {
            return Float.valueOf(r2 * ZeusTransformUtils.getResources(this.f36354a, "com.obric.aiagent.plugin").getDisplayMetrics().density);
        }

        @Override // d.h.a.b
        public /* synthetic */ Float invoke(Float r3) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
        }
    }

    /* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
    /* synthetic */ class g extends l implements d.h.a.b<Float, BlurMaskFilter> {
        g(Object r8) {
            super(1, r8, OProtocolTextEffectTextView.class, "getBlurMaskFilter", "getBlurMaskFilter(F)Landroid/graphics/BlurMaskFilter;", 0);
        }

        public final BlurMaskFilter a(float r3) {
            return ((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this.receiver, OProtocolTextEffectTextView.class, "com.obric.aiagent.plugin")).getBlurMaskFilter(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ BlurMaskFilter invoke(Float r3) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
        }
    }

    static {
        Companion = new a(null);
    }

    public OProtocolTextEffectTextView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OProtocolTextEffectTextView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ void lambda$a8OojhJiwJtEEHagNiVLOUcTBGg(OProtocolTextEffectTextView r0, n r1, ValueAnimator r2) {
        m1200startAnimator$lambda9$lambda8(r0, r1, r2);
    }

    public void onEffectFrameUpdated(String r1, long r2, n r4) {
        d.h.b.o.e(r1, "effectName");
        d.h.b.o.e(r4, "spec");
    }

    public void onTextEffectFinished() {
    }

    public void onTextEffectStarted(String r1, n r2) {
        d.h.b.o.e(r1, "effectName");
        d.h.b.o.e(r2, "spec");
    }

    public void onTextEffectStopped() {
    }

    public /* synthetic */ OProtocolTextEffectTextView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public static final /* synthetic */ void access$finishEffect(OProtocolTextEffectTextView r0) {
        r0.finishEffect();
    }

    public static final /* synthetic */ d.h.a.b access$getDp$p(OProtocolTextEffectTextView r0) {
        return r0.dp;
    }

    public OProtocolTextEffectTextView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        super(r6, r7, r5);
        this.dp = (d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.b.class, "com.obric.aiagent.plugin");
        this.blurFilterCache$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.activeEffectName = EffectNameNone;
        this.debugAnimationDurationScale = 1.0f;
        this.logTag = "ProtocolTextEffectView";
        this.maxBlurRadiusDp = 16.0f;
        this.blurFilterCacheGranularityPx = 0.5f;
    }

    private final com.obric.oui.texteffects.c.a getBlurFilterCache() {
        return (com.obric.oui.texteffects.c.a) ZeusTransformUtils.preCheckCast(this.blurFilterCache$delegate.b(), com.obric.oui.texteffects.c.a.class, "com.obric.aiagent.plugin");
    }

    public final String getActiveEffectName() {
        return this.activeEffectName;
    }

    public final float getDebugAnimationDurationScale() {
        return this.debugAnimationDurationScale;
    }

    public final boolean isEffectRunning() {
        if (this.activeSpec == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final long getCurrentEffectPlayTimeMs() {
        return this.playTimeMs;
    }

    public final com.obric.oui.texteffects.runtime.d sampleCurrentEffectFrame() {
        n r0 = this.activeSpec;
        if (r0 != null) goto L7;
        return null;
    L7:
        return com.obric.oui.texteffects.runtime.e.f36466a.a(r0, this.playTimeMs);
    }

    public String getLogTag() {
        return this.logTag;
    }

    public float getMaxBlurRadiusDp() {
        return this.maxBlurRadiusDp;
    }

    public float getBlurFilterCacheGranularityPx() {
        return this.blurFilterCacheGranularityPx;
    }

    public void setDebugAnimationDurationScale(float r3) {
        if (Float.isNaN(r3) == false) goto L5;
    L8:
        float r4 = 1.0f;
    L10:
        if (this.debugAnimationDurationScale != r4) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        return;
    L15:
        this.debugAnimationDurationScale = r4;
        com.obric.oui.texteffects.a r1 = com.obric.oui.texteffects.a.f36355a;
        String r2 = getLogTag();
        if (com.obric.oui.texteffects.a.a() == false) goto L19;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r2), d.h.b.o.a("setDebugAnimationDurationScale scale=", Float.valueOf(r4)));
        return;
    L19:
        return;
    L12:
        r0 = false;
        goto L13
    L5:
        if (Float.isInfinite(r3) == true) goto L8;
        r4 = d.l.n.a(r3, 0.1f, 10.0f);
        goto L10
    }

    public void stopEffect() {
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f36355a;
        String r1 = getLogTag();
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r1), d.h.b.o.a("stopEffect effect=", getActiveEffectName()));
    L5:
        stopAnimator$default(this, false, 1, null);
        this.activeSpec = null;
        this.activeEffectName = EffectNameNone;
        this.playTimeMs = 0;
        this.finalTextOnEnd = null;
        this.oldTextForEffect = null;
        this.newTextForEffect = null;
        this.oldTextCache = null;
        this.newTextCache = null;
        onTextEffectStopped();
        invalidate();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f36355a;
        String r1 = getLogTag();
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r1), "onDetachedFromWindow, clear animator and blur cache");
    L5:
        stopEffect();
        getBlurFilterCache().a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onSizeChanged(int r4, int r5, int r6, int r7) {
        super.onSizeChanged(r4, r5, r6, r7);
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f36355a;
        String r1 = getLogTag();
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r1), "onSizeChanged " + r6 + " x " + r7 + " -> " + r4 + " x " + r5 + ", clear text caches");
    L5:
        clearTextCaches();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
        super.onTextChanged((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4, r5, r6);
        this.currentTextCache = null;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r12) {
        d.h.b.o.e(r12, "canvas");
        n r1 = this.activeSpec;
        if (r1 != null) goto L6;
        super.onDraw(r12);
        return;
    L6:
        com.obric.oui.texteffects.runtime.d r2 = com.obric.oui.texteffects.runtime.e.f36466a.a(r1, this.playTimeMs);
        com.obric.oui.texteffects.a r3 = com.obric.oui.texteffects.a.f36355a;
        String r4 = getLogTag();
        if (com.obric.oui.texteffects.a.a() == true) goto L9;
    L11:
        drawCompoundDrawables(r12);
        int r5 = r12.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r2.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L22
    L14:
        if (r6.hasNext() == false) goto L20;
        com.obric.oui.texteffects.runtime.c r7 = (com.obric.oui.texteffects.runtime.c) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.oui.texteffects.runtime.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        com.obric.oui.texteffects.a.d.b r8 = findTextLayer(r1, r7);     // Catch: Throwable -> L22
        if (r8 == null) goto L14;
        drawTextLayer(r12, r8, r7);     // Catch: Throwable -> L22
        goto L14
    L20:
        r12.restoreToCount(r5);
        return;
    L22:
        th = move-exception;
        r12.restoreToCount(r5);
        throw th;
    L9:
        if (com.obric.oui.texteffects.a.b() == false) goto L11;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r4), "onDraw effect=" + getActiveEffectName() + ", spec=" + r1.a() + ", playTime=" + this.playTimeMs + ", layers=" + r2.a().size());
        goto L11
    }

    public static /* synthetic */ void startTextEffect$default(OProtocolTextEffectTextView r7, n r8, String r9, boolean r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, Object r15) {
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r18 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L22;
        if ((r14 & 4) == 0) goto L7;
        r10 = false;
    L7:
        boolean r3 = r10;
        if ((r14 & 8) == 0) goto L10;
        CharSequence r4 = null;
    L12:
        if ((r14 & 16) == 0) goto L14;
        CharSequence r5 = null;
    L16:
        if ((r14 & 32) == 0) goto L18;
        CharSequence r6 = null;
    L19:
        r7.startTextEffect(r8, r9, r3, r4, r5, r6);
        return;
    L18:
        r6 = r18;
        goto L19
    L14:
        r5 = r17;
        goto L16
    L10:
        r4 = r16;
        goto L12
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startTextEffect");
    }

    public final void startTextEffect(n r5, String r6, boolean r7, CharSequence r8, CharSequence r9, CharSequence r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "spec");
        d.h.b.o.e(r6, "effectName");
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f36355a;
        String r1 = getLogTag();
        if (com.obric.oui.texteffects.a.a() == false) goto L6;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r1), "startTextEffect id=" + r5.a() + ", effect=" + r6 + ", duration=" + r5.b() + ", loop=" + r5.c() + ", restart=" + r7 + ", finalText=" + r11);
    L6:
        if (r7 == true) goto L8;
        stopAnimator$default(this, false, 1, null);
    L9:
        this.activeSpec = r5;
        this.activeEffectName = r6;
        this.playTimeMs = 0;
        this.finalTextOnEnd = r11;
        this.oldTextForEffect = r12;
        this.newTextForEffect = r13;
        this.oldTextCache = null;
        this.newTextCache = null;
        onTextEffectStarted(r6, r5);
        startAnimator(r5);
        invalidate();
        return;
    L8:
        stopAnimator(true);
        goto L9
    }

    public static /* synthetic */ void updateTextEffectSnapshots$default(OProtocolTextEffectTextView r2, CharSequence r3, CharSequence r4, CharSequence r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L16;
        if ((r6 & 1) == 0) goto L8;
        r8 = r2.finalTextOnEnd;
    L8:
        if ((r6 & 2) == 0) goto L11;
        r9 = r2.oldTextForEffect;
    L11:
        if ((r6 & 4) == 0) goto L13;
        r10 = r2.newTextForEffect;
    L13:
        r2.updateTextEffectSnapshots(r8, r9, r10);
        return;
    L16:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTextEffectSnapshots");
    }

    public final void updateTextEffectSnapshots(CharSequence r3, CharSequence r4, CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        this.finalTextOnEnd = r6;
        this.oldTextForEffect = r7;
        this.newTextForEffect = r8;
        this.oldTextCache = null;
        this.newTextCache = null;
        invalidate();
    }

    private final void startAnimator(final n r6) {
        final z.a r0 = new z.a();
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setDuration(scaledDurationMs(r6.b()));
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        if (d.h.b.o.a(r6.c(), j.b.f36408a) == false) goto L5;
        int r2 = -1;
    L6:
        r1.setRepeatCount(r2);
        r1.setRepeatMode(1);
        r1.addUpdateListener(new $$Lambda$OProtocolTextEffectTextView$a8OojhJiwJtEEHagNiVLOUcTBGg(this, r6));
        r1.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new OProtocolTextEffectTextView$startAnimator$1$2(r0, this, r6), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        r1.start();
        this.animator = r1;
        return;
    L5:
        r2 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: startAnimator$lambda-9$lambda-8, reason: not valid java name */
    private static final void m1200startAnimator$lambda9$lambda8(OProtocolTextEffectTextView r3, n r4, ValueAnimator r5) {
        d.h.b.o.e(r3, "this$0");
        d.h.b.o.e(r4, "$spec");
        d.h.b.o.e(r5, "valueAnimator");
        r3.playTimeMs = (long) (r5.getAnimatedFraction() * r4.b());
        com.obric.oui.texteffects.a r6 = com.obric.oui.texteffects.a.f36355a;
        String r7 = r3.getLogTag();
        if (com.obric.oui.texteffects.a.a() == true) goto L5;
    L7:
        r3.onEffectFrameUpdated(r3.activeEffectName, r3.playTimeMs, r4);
        r3.invalidate();
        return;
    L5:
        if (com.obric.oui.texteffects.a.b() == false) goto L7;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r7), "animator update spec=" + r4.a() + ", playTime=" + r3.playTimeMs);
        goto L7
    }

    private final void finishEffect() {
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f36355a;
        String r1 = getLogTag();
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r1), "finishEffect effect=" + getActiveEffectName() + ", finalText=" + this.finalTextOnEnd);
    L5:
        CharSequence r2 = this.finalTextOnEnd;
        if (r2 == null) goto L9;
        setText(r2);
    L9:
        this.activeSpec = null;
        this.activeEffectName = EffectNameNone;
        this.playTimeMs = 0;
        this.finalTextOnEnd = null;
        this.oldTextForEffect = null;
        this.newTextForEffect = null;
        this.oldTextCache = null;
        this.newTextCache = null;
        this.animator = null;
        onTextEffectFinished();
        invalidate();
    }

    static /* synthetic */ void stopAnimator$default(OProtocolTextEffectTextView r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.stopAnimator(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopAnimator");
    }

    private final void stopAnimator(boolean r4) {
        if (this.animator == null) goto L7;
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f36355a;
        String r1 = getLogTag();
        if (com.obric.oui.texteffects.a.a() == false) goto L7;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r1), d.h.b.o.a("stopAnimator keepFrame=", Boolean.valueOf(r4)));
    L7:
        ValueAnimator r2 = this.animator;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        this.animator = null;
        if (r4 == true) goto L15;
        this.playTimeMs = 0;
        return;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 10261. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void drawTextLayer(android.graphics.Canvas r41, com.obric.oui.texteffects.a.d.b r42, com.obric.oui.texteffects.runtime.c r43) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001d: INVOKE (r15v0 ?? I:com.obric.oui.texteffects.c.c) = 
              (r40v0 'this' ?? I:com.obric.oui.texteffects.OProtocolTextEffectTextView A[IMMUTABLE_TYPE, THIS])
              (r3v3 com.obric.oui.texteffects.a.o)
             VIRTUAL call: com.obric.oui.texteffects.OProtocolTextEffectTextView.cacheForSource(com.obric.oui.texteffects.a.o):com.obric.oui.texteffects.c.c A[DECLARE_VAR, MD:(com.obric.oui.texteffects.a.o):com.obric.oui.texteffects.c.c (m)] in method: com.obric.oui.texteffects.OProtocolTextEffectTextView.drawTextLayer(android.graphics.Canvas, com.obric.oui.texteffects.a.d$b, com.obric.oui.texteffects.runtime.c):void, file: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1026
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.oui.texteffects.OProtocolTextEffectTextView.drawTextLayer(android.graphics.Canvas, com.obric.oui.texteffects.a.d$b, com.obric.oui.texteffects.runtime.c):void");
    }

    public float layerInsetPx(float r3, float r4) {
        return Math.max(((Number) ZeusTransformUtils.preCheckCast(this.dp.invoke(Float.valueOf(getMaxBlurRadiusDp())), Number.class, "com.obric.aiagent.plugin")).floatValue(), r4) + Math.abs(r3);
    }

    public void drawScanLayer(Canvas r16, Paint r17, com.obric.oui.texteffects.c.c r18, float r19, float r20, float r21, float r22, m.b r23, BlendMode r24, Xfermode r25) {
        d.h.b.o.e(r16, "canvas");
        d.h.b.o.e(r17, "paint");
        d.h.b.o.e(r18, "cache");
        d.h.b.o.e(r23, "selector");
        float r9 = r21 + (r18.f() * r22);
        float r1 = d.l.n.a(r18.f() * r23.c(), ((Number) ZeusTransformUtils.preCheckCast(this.dp.invoke(Float.valueOf(r23.d())), Number.class, "com.obric.aiagent.plugin")).floatValue());
        com.obric.oui.texteffects.a r7 = com.obric.oui.texteffects.a.f36355a;
        String r8 = getLogTag();
        if (com.obric.oui.texteffects.a.a() == true) goto L5;
    L7:
        com.obric.oui.texteffects.c.b r0 = com.obric.oui.texteffects.c.b.f36440a;
        Paint r10 = com.obric.oui.texteffects.c.b.f36440a.a(r17);
        float r11 = getBaseline();
        float r12 = r9 + r1;
        float r13 = getHeight();
        if (r23.b() == com.obric.oui.texteffects.a.b.f36364b) goto L10;
        boolean r2 = true;
    L11:
        r0.a(r16, r19, r20, r10, r17, r18, r21, r11, r9, r12, r13, r2, r24, r25);
        return;
    L10:
        r2 = false;
        goto L11
    L5:
        if (com.obric.oui.texteffects.a.b() == false) goto L7;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r8), "drawScanLayer progress=" + r22 + ", scanX=" + r9 + ", featherWidth=" + r1 + ", direction=" + r23.a());
        goto L7
    }

    public void applyFillToPaint(Paint r3, com.obric.oui.texteffects.a.h r4, com.obric.oui.texteffects.c.c r5) {
        d.h.b.o.e(r3, "paint");
        d.h.b.o.e(r4, "fill");
        d.h.b.o.e(r5, "cache");
        if (d.h.b.o.a(r4, com.obric.oui.texteffects.a.h.b.f36404a) == false) goto L6;
        r3.setShader(null);
        r3.setColor(getCurrentTextColor());
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.a.h.a.class) == false) goto L10;
        r3.setShader((Shader) ZeusTransformUtils.preCheckCast(buildGradientShader(r5, (com.obric.oui.texteffects.a.h.a) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.a.h.a.class, "com.obric.aiagent.plugin")), Shader.class, "com.obric.aiagent.plugin"));
        return;
    }

    public void applyBlendToPaint(Paint r4, com.obric.oui.texteffects.a.a r5) {
        d.h.b.o.e(r4, "paint");
        d.h.b.o.e(r5, "blend");
        PorterDuffXfermode r2 = null;
        if (r5 != com.obric.oui.texteffects.a.a.f36361d) goto L10;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        r4.setBlendMode(null);
        return;
    L7:
        r4.setXfermode(null);
        return;
    L10:
        if (Build.VERSION.SDK_INT < 29) goto L12;
        r4.setBlendMode(toAndroidBlendMode(r5));
        return;
    L12:
        PorterDuff.Mode r3 = toPorterDuffMode(r5);
        if (r3 == null) goto L16;
        r2 = new PorterDuffXfermode(r3);
    L16:
        r4.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(r2, Xfermode.class, "com.obric.aiagent.plugin"));
    }

    public final com.obric.oui.texteffects.a.d.b findTextLayer(n r5, com.obric.oui.texteffects.runtime.c r6) {
        d.h.b.o.e(r5, "spec");
        d.h.b.o.e(r6, "frame");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r7 = r4.next();
        if (d.h.b.o.a(((com.obric.oui.texteffects.a.f) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.texteffects.a.f.class, "com.obric.aiagent.plugin")).a(), r6.a()) == false) goto L4;
    L9:
        com.obric.oui.texteffects.a.f r8 = (com.obric.oui.texteffects.a.f) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.texteffects.a.f.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L12;
        return null;
    L12:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r9.hasNext() == false) goto L18;
        Object r10 = r9.next();
        if (d.h.b.o.a(((com.obric.oui.texteffects.a.d) ZeusTransformUtils.preCheckCast(r10, com.obric.oui.texteffects.a.d.class, "com.obric.aiagent.plugin")).a(), r6.b()) == false) goto L14;
    L20:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.oui.texteffects.a.d.b.class) == true) goto L22;
        return null;
    L22:
        return (com.obric.oui.texteffects.a.d.b) ZeusTransformUtils.preCheckCast(r10, com.obric.oui.texteffects.a.d.b.class, "com.obric.aiagent.plugin");
    L18:
        r10 = null;
        goto L20
    L8:
        r7 = null;
        goto L9
    }

    public final com.obric.oui.texteffects.c.c cacheForSource(o r7) {
        d.h.b.o.e(r7, DBHelper.BATTERY_COL_SOURCE);
        int r8 = b.f36350a[r7.ordinal()];
        com.obric.oui.texteffects.c.c r5 = null;
        if (r8 != 1) goto L5;
        CharSequence r9 = getText();
        if (r9 != null) goto L43;
        r9 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L43:
        com.obric.oui.texteffects.c.c r0 = this.currentTextCache;
        if (r0 != null) goto L47;
    L49:
        if (r5 != null) goto L53;
        r5 = buildTextCache(r9);
        this.currentTextCache = r5;
        com.obric.oui.texteffects.a r1 = com.obric.oui.texteffects.a.f36355a;
        String r6 = getLogTag();
        if (com.obric.oui.texteffects.a.a() == false) goto L53;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r6), "build current text cache, text=" + r9 + ", width=" + r5.f());
    L53:
        return r5;
    L47:
        if (isTextCacheReusable(r0, r9) == false) goto L49;
        r5 = r0;
        goto L49
    L5:
        if (r8 != 2) goto L7;
        CharSequence r10 = this.oldTextForEffect;
        if (r10 != null) goto L28;
        r10 = getText();
    L28:
        if (r10 != null) goto L30;
        r10 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L30:
        com.obric.oui.texteffects.c.c r2 = this.oldTextCache;
        if (r2 != null) goto L34;
    L36:
        if (r5 != null) goto L53;
        r5 = buildTextCache(r10);
        this.oldTextCache = r5;
        com.obric.oui.texteffects.a r3 = com.obric.oui.texteffects.a.f36355a;
        String r11 = getLogTag();
        if (com.obric.oui.texteffects.a.a() == false) goto L53;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r11), "build old text cache, text=" + r10 + ", width=" + r5.f());
        goto L53
    L34:
        if (isTextCacheReusable(r2, r10) == false) goto L36;
        r5 = r2;
        goto L36
    L7:
        if (r8 != 3) goto L24;
        CharSequence r12 = this.newTextForEffect;
        if (r12 != null) goto L11;
        r12 = getText();
    L11:
        if (r12 != null) goto L13;
        r12 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L13:
        com.obric.oui.texteffects.c.c r4 = this.newTextCache;
        if (r4 != null) goto L17;
    L19:
        if (r5 != null) goto L53;
        r5 = buildTextCache(r12);
        this.newTextCache = r5;
        com.obric.oui.texteffects.a r13 = com.obric.oui.texteffects.a.f36355a;
        String r14 = getLogTag();
        if (com.obric.oui.texteffects.a.a() == false) goto L53;
        INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(d.h.b.o.a("OUITextEffects/", r14), "build new text cache, text=" + r12 + ", width=" + r5.f());
        goto L53
    L17:
        if (isTextCacheReusable(r4, r12) == false) goto L19;
        r5 = r4;
        goto L19
    L24:
        throw new k();
    }

    public com.obric.oui.texteffects.c.c buildTextCache(CharSequence r10) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "text");
        com.obric.oui.texteffects.c.d r2 = com.obric.oui.texteffects.c.d.f36450a;
        TextPaint r4 = getPaint();
        d.h.b.o.c(r4, "paint");
        return r2.a(r3, r4, computeContentWidth(), getEllipsize(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(e.f36353a, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final boolean isTextCacheReusable(com.obric.oui.texteffects.c.c r4, CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "cache");
        d.h.b.o.e(r6, "text");
        if (d.h.b.o.a(r4.a(), r6) == false) goto L18;
        if (r4.c() != computeContentWidth()) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L18;
        if (r4.d() != getEllipsize()) goto L18;
        if (r4.e() != getPaint().getTextSize()) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L18;
        return true;
    L14:
        r3 = false;
        goto L15
    L7:
        r7 = false;
    L18:
        return false;
    }

    public float computeStartX(float r4) {
        float r0 = computeContentWidth();
        int r1 = getGravity() & 7;
        float r3 = getCompoundPaddingLeft();
        if (r1 != 1) goto L5;
        float r2 = (r0 - r4) / 2.0f;
    L12:
        return r3 + r2;
    L5:
        if (r1 != 5) goto L7;
    L9:
        r2 = r0 - r4;
        goto L12
    L7:
        if (r1 == 8388613) goto L9;
        return r3;
    }

    public final float computeContentWidth() {
        return d.l.n.a((getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight(), 0.0f);
    }

    public LinearGradient buildGradientShader(com.obric.oui.texteffects.c.c r9, com.obric.oui.texteffects.a.h.a r10) {
        d.h.b.o.e(r9, "cache");
        d.h.b.o.e(r10, "fill");
        if (r9.f() > 0.01f) goto L6;
        return null;
    L6:
        float r1 = r9.g();
        return new LinearGradient(r1, 0.0f, r1 + r9.f(), 0.0f, r10.a(), r10.b(), Shader.TileMode.CLAMP);
    }

    public final BlurMaskFilter getBlurMaskFilter(float r1) {
        return getBlurFilterCache().a(r1);
    }

    public final void clearTextCaches() {
        this.currentTextCache = null;
        this.oldTextCache = null;
        this.newTextCache = null;
    }

    public final long scaledDurationMs(long r1) {
        return d.l.n.c(d.i.a.a(r1 * this.debugAnimationDurationScale), 1);
    }

    public final float dimensionPropertyPx(com.obric.oui.texteffects.runtime.c r2, com.obric.oui.texteffects.a.g r3, float r4) {
        d.h.b.o.e(r2, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.texteffects.a.g.a.class) == false) goto L6;
        return ((Number) ZeusTransformUtils.preCheckCast(this.dp.invoke(Float.valueOf(((com.obric.oui.texteffects.a.g.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.a.g.a.class, "com.obric.aiagent.plugin")).a())), Number.class, "com.obric.aiagent.plugin")).floatValue();
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.texteffects.a.g.b.class) == false) goto L9;
        return ((com.obric.oui.texteffects.a.g.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.a.g.b.class, "com.obric.aiagent.plugin")).a();
    L9:
        return ((Number) ZeusTransformUtils.preCheckCast(this.dp.invoke(Float.valueOf(r4)), Number.class, "com.obric.aiagent.plugin")).floatValue();
    }

    public void drawCompoundDrawables(Canvas r10) {
        d.h.b.o.e(r10, "canvas");
        Drawable[] r0 = getCompoundDrawables();
        d.h.b.o.c(r0, "compoundDrawables");
        int r1 = getCompoundPaddingLeft();
        int r2 = getCompoundPaddingTop();
        int r3 = getWidth() - getCompoundPaddingRight();
        int r4 = getHeight() - getCompoundPaddingBottom();
        int r5 = d.l.n.c(r3 - r1, 0);
        int r6 = d.l.n.c(r4 - r2, 0);
        Drawable r7 = r0[0];
        if (r7 == null) goto L6;
        drawAt(r7, r10, getPaddingLeft(), ((r6 - drawableHeight(r7)) / 2) + r2);
    L6:
        Drawable r8 = r0[1];
        if (r8 == null) goto L10;
        drawAt(r8, r10, ((r5 - drawableWidth(r8)) / 2) + r1, getPaddingTop());
    L10:
        Drawable r9 = r0[2];
        if (r9 == null) goto L14;
        drawAt(r9, r10, (getWidth() - getPaddingRight()) - drawableWidth(r9), r2 + ((r6 - drawableHeight(r9)) / 2));
    L14:
        Drawable r11 = r0[3];
        if (r11 == null) goto L19;
        drawAt(r11, r10, r1 + ((r5 - drawableWidth(r11)) / 2), (getHeight() - getPaddingBottom()) - drawableHeight(r11));
        return;
    }

    private final void drawAt(Drawable r1, Canvas r2, int r3, int r4) {
        int r0 = r2.save();
        r2.translate(r3, r4);     // Catch: Throwable -> L6
        r1.draw(r2);     // Catch: Throwable -> L6
        r2.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r2.restoreToCount(r0);
        throw th;
    }

    private final int drawableWidth(Drawable r3) {
        Integer r2 = Integer.valueOf(r3.getBounds().width());
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r2 = null;
    L9:
        if (r2 != null) goto L12;
        return d.l.n.c(r3.getIntrinsicWidth(), 0);
    L12:
        return r2.intValue();
    L5:
        r0 = false;
        goto L6
    }

    private final int drawableHeight(Drawable r3) {
        Integer r2 = Integer.valueOf(r3.getBounds().height());
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r2 = null;
    L9:
        if (r2 != null) goto L12;
        return d.l.n.c(r3.getIntrinsicHeight(), 0);
    L12:
        return r2.intValue();
    L5:
        r0 = false;
        goto L6
    }

    private final BlendMode toAndroidBlendMode(com.obric.oui.texteffects.a.a r1) {
        switch(b.f36351b[r1.ordinal()]) {
            case 1: goto L35;
            case 2: goto L63;
            case 3: goto L62;
            case 4: goto L61;
            case 5: goto L60;
            case 6: goto L59;
            case 7: goto L58;
            case 8: goto L57;
            case 9: goto L56;
            case 10: goto L55;
            case 11: goto L54;
            case 12: goto L53;
            case 13: goto L52;
            case 14: goto L51;
            case 15: goto L50;
            case 16: goto L49;
            case 17: goto L48;
            case 18: goto L47;
            case 19: goto L46;
            case 20: goto L45;
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            case 25: goto L40;
            case 26: goto L39;
            case 27: goto L38;
            case 28: goto L37;
            case 29: goto L36;
            default: goto L5;
        };
    L5:
        throw new k();
    L36:
        return BlendMode.LUMINOSITY;
    L37:
        return BlendMode.COLOR;
    L38:
        return BlendMode.SATURATION;
    L39:
        return BlendMode.HUE;
    L40:
        return BlendMode.MULTIPLY;
    L41:
        return BlendMode.EXCLUSION;
    L42:
        return BlendMode.DIFFERENCE;
    L43:
        return BlendMode.SOFT_LIGHT;
    L44:
        return BlendMode.HARD_LIGHT;
    L45:
        return BlendMode.COLOR_BURN;
    L46:
        return BlendMode.COLOR_DODGE;
    L47:
        return BlendMode.LIGHTEN;
    L48:
        return BlendMode.DARKEN;
    L49:
        return BlendMode.OVERLAY;
    L50:
        return BlendMode.SCREEN;
    L51:
        return BlendMode.MODULATE;
    L52:
        return BlendMode.PLUS;
    L53:
        return BlendMode.XOR;
    L54:
        return BlendMode.DST_ATOP;
    L55:
        return BlendMode.SRC_ATOP;
    L56:
        return BlendMode.DST_OUT;
    L57:
        return BlendMode.SRC_OUT;
    L58:
        return BlendMode.DST_IN;
    L59:
        return BlendMode.SRC_IN;
    L60:
        return BlendMode.DST_OVER;
    L61:
        return BlendMode.SRC_OVER;
    L62:
        return BlendMode.DST;
    L63:
        return BlendMode.SRC;
    L35:
        return BlendMode.CLEAR;
    }

    private final PorterDuff.Mode toPorterDuffMode(com.obric.oui.texteffects.a.a r1) {
        switch(b.f36351b[r1.ordinal()]) {
            case 1: goto L24;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L25;
            case 5: goto L40;
            case 6: goto L39;
            case 7: goto L38;
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L35;
            case 11: goto L34;
            case 12: goto L33;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            case 16: goto L29;
            case 17: goto L28;
            case 18: goto L27;
            case 19: goto L25;
            case 20: goto L25;
            case 21: goto L25;
            case 22: goto L25;
            case 23: goto L25;
            case 24: goto L25;
            case 25: goto L26;
            case 26: goto L25;
            case 27: goto L25;
            case 28: goto L25;
            case 29: goto L25;
            default: goto L5;
        };
    L25:
        return null;
    L5:
        throw new k();
    L26:
        return PorterDuff.Mode.MULTIPLY;
    L27:
        return PorterDuff.Mode.LIGHTEN;
    L28:
        return PorterDuff.Mode.DARKEN;
    L29:
        return PorterDuff.Mode.OVERLAY;
    L30:
        return PorterDuff.Mode.SCREEN;
    L31:
        return PorterDuff.Mode.MULTIPLY;
    L32:
        return PorterDuff.Mode.ADD;
    L33:
        return PorterDuff.Mode.XOR;
    L34:
        return PorterDuff.Mode.DST_ATOP;
    L35:
        return PorterDuff.Mode.SRC_ATOP;
    L36:
        return PorterDuff.Mode.DST_OUT;
    L37:
        return PorterDuff.Mode.SRC_OUT;
    L38:
        return PorterDuff.Mode.DST_IN;
    L39:
        return PorterDuff.Mode.SRC_IN;
    L40:
        return PorterDuff.Mode.DST_OVER;
    L41:
        return PorterDuff.Mode.DST;
    L42:
        return PorterDuff.Mode.SRC;
    L24:
        return PorterDuff.Mode.CLEAR;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_texteffects_OProtocolTextEffectTextView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
