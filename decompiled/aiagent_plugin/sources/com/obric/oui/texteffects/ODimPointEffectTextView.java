package com.obric.oui.texteffects;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.obric.oui.texteffects.a.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.l;
import d.h.b.o;
import d.h.b.p;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ODimPointEffectTextView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ODimPointEffectTextView extends OProtocolTextEffectTextView {
    private static final a Companion = null;

    @Deprecated
    private static final String EffectNameGenerate = "generate";

    @Deprecated
    private static final String EffectNamePending = "pending";

    @Deprecated
    private static final String EffectNamePromptExitToGenerate = "prompt_exit_to_generate";

    @Deprecated
    private static final String EffectNamePromptSwitch = "prompt_switch";

    @Deprecated
    private static final String EffectNameRewrite = "rewrite";

    @Deprecated
    private static final String PendingGradientLayerId = "gradient_overlay";

    @Deprecated
    private static final String Tag = "DimPointTextView";
    private b activeMode;
    private final String logTag;
    private final float maxBlurRadiusDp;
    private CharSequence pendingRewriteText;
    private c pendingTextType;
    private CharSequence promptExitGenerateText;
    private d rewritePhase;

    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f36327a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f36328b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f36329c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f36330d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f36331e = null;
        public static final b f = null;
        private static final /* synthetic */ b[] g = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f36327a, f36328b, f36329c, f36330d, f36331e, f};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(g.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            f36327a = new b("NONE", 0);
            f36328b = new b("PENDING", 1);
            f36329c = new b("PROMPT_EXIT_TO_GENERATE", 2);
            f36330d = new b("PROMPT_SWITCH", 3);
            f36331e = new b("GENERATE", 4);
            f = new b("REWRITE", 5);
            g = a();
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f36332a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f36333b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ c[] f36334c = null;

        private static final /* synthetic */ c[] a() {
            return new c[]{f36332a, f36333b};
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f36334c.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        static {
            f36332a = new c("CONTENT", 0);
            f36333b = new c("PROMPT", 1);
            f36334c = a();
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f36335a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f36336b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f36337c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d[] f36338d = null;

        private static final /* synthetic */ d[] a() {
            return new d[]{f36335a, f36336b, f36337c};
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f36338d.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        static {
            f36335a = new d("NONE", 0);
            f36336b = new d("EXITING_OLD_TEXT", 1);
            f36337c = new d("ENTERING_NEW_TEXT", 2);
            f36338d = a();
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36339a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f36340b = null;

        static {
            int[] r0 = new int[b.values().length];
            r0[b.f36328b.ordinal()] = 1;
            r0[b.f36331e.ordinal()] = 2;
            r0[b.f.ordinal()] = 3;
            r0[b.f36329c.ordinal()] = 4;
            r0[b.f36330d.ordinal()] = 5;
            r0[b.f36327a.ordinal()] = 6;
            f36339a = r0;
            int[] r1 = new int[d.values().length];
            r1[d.f36336b.ordinal()] = 1;
            r1[d.f36337c.ordinal()] = 2;
            r1[d.f36335a.ordinal()] = 3;
            f36340b = r1;
        }
    }

    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    /* synthetic */ class f extends l implements d.h.a.b<Float, Float> {
        f(Object r8) {
            super(1, r8, ODimPointEffectTextView.class, "computeStartX", "computeStartX(F)F", 0);
        }

        public final Float a(float r3) {
            return Float.valueOf(((ODimPointEffectTextView) ZeusTransformUtils.preCheckCast(this.receiver, ODimPointEffectTextView.class, "com.obric.aiagent.plugin")).computeStartX(r3));
        }

        @Override // d.h.a.b
        public /* synthetic */ Float invoke(Float r3) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
        }
    }

    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    static final class g extends p implements d.h.a.b<com.obric.oui.texteffects.c.c, LinearGradient> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ODimPointEffectTextView f36341a;

        g(ODimPointEffectTextView r1) {
            this.f36341a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ LinearGradient invoke(com.obric.oui.texteffects.c.c r3) {
            return a((com.obric.oui.texteffects.c.c) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.c.c.class, "com.obric.aiagent.plugin"));
        }

        public final LinearGradient a(com.obric.oui.texteffects.c.c r4) {
            o.e(r4, "cache");
            return this.f36341a.buildGradientShader(r4, new com.obric.oui.texteffects.a.h.a(com.obric.oui.texteffects.b.b.f36434a.a(), com.obric.oui.texteffects.b.b.f36434a.b()));
        }
    }

    static {
        Companion = new a(null);
    }

    public ODimPointEffectTextView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ODimPointEffectTextView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ ODimPointEffectTextView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public ODimPointEffectTextView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.activeMode = b.f36327a;
        this.pendingTextType = c.f36332a;
        this.rewritePhase = d.f36335a;
        this.logTag = Tag;
        this.maxBlurRadiusDp = 16.0f;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public String getLogTag() {
        return this.logTag;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public float getMaxBlurRadiusDp() {
        return this.maxBlurRadiusDp;
    }

    public final void setDimPointMode(b r2) {
        o.e(r2, "mode");
        if (this.activeMode != r2) goto L5;
        return;
    L5:
        stopEffect();
        int r3 = e.f36339a[r2.ordinal()];
        if (r3 != 1) goto L8;
        startPending();
        return;
    L8:
        if (r3 != 2) goto L14;
        startGenerate(null);
        return;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void setDebugAnimationDurationScale(float r10) {
        float r0 = getDebugAnimationDurationScale();
        super.setDebugAnimationDurationScale(r10);
        if (r0 != getDebugAnimationDurationScale()) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        return;
    L8:
        if (this.activeMode != b.f36328b) goto L12;
        OProtocolTextEffectTextView.startTextEffect$default((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.aiagent.plugin"), com.obric.oui.texteffects.b.a.f36429a.a(), EffectNamePending, true, null, null, null, 56, null);
        return;
    L12:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void startPending() {
        this.pendingTextType = c.f36332a;
        OProtocolTextEffectTextView.startTextEffect$default((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.aiagent.plugin"), com.obric.oui.texteffects.b.a.f36429a.a(), EffectNamePending, false, null, null, null, 60, null);
    }

    public final void startPromptPending(CharSequence r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r11, "promptText");
        setText(r11);
        this.pendingTextType = c.f36333b;
        OProtocolTextEffectTextView.startTextEffect$default((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.aiagent.plugin"), com.obric.oui.texteffects.b.a.f36429a.a(), EffectNamePending, false, null, null, null, 60, null);
    }

    public final boolean isPromptPending() {
        if (this.activeMode == b.f36328b) goto L5;
    L7:
        return false;
    L5:
        if (this.pendingTextType != c.f36333b) goto L7;
        return true;
    }

    public final boolean isContentPending() {
        if (this.activeMode == b.f36328b) goto L5;
    L7:
        return false;
    L5:
        if (this.pendingTextType != c.f36332a) goto L7;
        return true;
    }

    public final boolean isRewriteExitingOldText() {
        updateRewritePhase();
        if (this.rewritePhase != d.f36336b) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRewriteEnteringNewText() {
        updateRewritePhase();
        if (this.rewritePhase != d.f36337c) goto L5;
        return true;
    L5:
        return false;
    }

    public final long currentRewritePlayTimeMs() {
        return getCurrentEffectPlayTimeMs();
    }

    public final void startDimPointTextEffect(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r0 = getText();
        if (r0 != null) goto L5;
        r0 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L5:
        if (r6 != null) goto L7;
        r6 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L7:
        boolean r2 = true;
        if (isPromptPending() == false) goto L17;
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
        setText(r6);
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
        startDimPointTextEffect((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final void startGenerateFromPromptPending(CharSequence r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r13, "actualText");
        if (isPromptPending() == true) goto L6;
        startGenerate(r13);
        return;
    L6:
        this.promptExitGenerateText = r13;
        OProtocolTextEffectTextView.startTextEffect$default((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.aiagent.plugin"), com.obric.oui.texteffects.b.a.f36429a.b(), EffectNamePromptExitToGenerate, false, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 52, null);
    }

    public final void startPromptTextSwitch(CharSequence r12) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r8, "newPromptText");
        CharSequence r13 = getText();
        if (r13 != null) goto L5;
        r13 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L5:
        CharSequence r7 = r13;
        setText(r8);
        this.pendingTextType = c.f36333b;
        OProtocolTextEffectTextView.startTextEffect$default((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.aiagent.plugin"), com.obric.oui.texteffects.b.a.f36429a.c(), EffectNamePromptSwitch, false, r8, r7, r8, 4, null);
    }

    public static /* synthetic */ void startContentPending$default(ODimPointEffectTextView r1, CharSequence r2, int r3, Object r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = r1.getText();
    L5:
        r1.startContentPending(r5);
    }

    public final void startContentPending(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        setText(r4);
    L6:
        startPending();
    }

    public static /* synthetic */ void startGenerate$default(ODimPointEffectTextView r1, CharSequence r2, int r3, Object r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        r1.startGenerate(r5);
    }

    public final void startGenerate(CharSequence r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L5;
        setText(r11);
    L5:
        this.pendingTextType = c.f36332a;
        this.promptExitGenerateText = null;
        OProtocolTextEffectTextView.startTextEffect$default((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.aiagent.plugin"), com.obric.oui.texteffects.b.a.f36429a.a(false), EffectNameGenerate, false, getText(), null, null, 52, null);
    }

    public final void startRewrite(CharSequence r12) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r8, "newText");
        if (this.activeMode != b.f) goto L12;
        d r13 = this.rewritePhase;
        int r14 = e.f36340b[r13.ordinal()];
        if (r14 != 1) goto L7;
        setText(r8);
        OProtocolTextEffectTextView.updateTextEffectSnapshots$default((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.aiagent.plugin"), r8, null, r8, 2, null);
        return;
    L7:
        if (r14 != 2) goto L18;
        this.pendingRewriteText = r8;
        return;
    L18:
        return;
    L12:
        CharSequence r15 = getText();
        if (r15 != null) goto L15;
        r15 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L15:
        CharSequence r7 = r15;
        float r16 = currentPendingGradientAlpha();
        this.pendingTextType = c.f36332a;
        this.promptExitGenerateText = null;
        this.pendingRewriteText = null;
        setText(r8);
        OProtocolTextEffectTextView.startTextEffect$default((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.aiagent.plugin"), com.obric.oui.texteffects.b.a.f36429a.a(false, r16), EffectNameRewrite, false, r8, r7, r8, 4, null);
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void stopEffect() {
        super.stopEffect();
        this.activeMode = b.f36327a;
        this.pendingTextType = c.f36332a;
        this.promptExitGenerateText = null;
        this.rewritePhase = d.f36335a;
        this.pendingRewriteText = null;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void onTextEffectStarted(String r2, n r3) {
        o.e(r2, "effectName");
        o.e(r3, "spec");
        this.activeMode = toDimPointMode(r2);
        updateRewritePhase();
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void onTextEffectStopped() {
        this.activeMode = b.f36327a;
        this.rewritePhase = d.f36335a;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void onTextEffectFinished() {
        b r0 = this.activeMode;
        this.activeMode = b.f36327a;
        this.rewritePhase = d.f36335a;
        if (r0 != b.f36329c) goto L8;
        CharSequence r1 = this.promptExitGenerateText;
        this.promptExitGenerateText = null;
        this.pendingTextType = c.f36332a;
        if (r1 == null) goto L18;
        startGenerate(r1);
        return;
    L18:
        return;
    L8:
        if (r0 != b.f36330d) goto L11;
        this.pendingTextType = c.f36333b;
        return;
    L11:
        if (r0 != b.f) goto L21;
        CharSequence r2 = this.pendingRewriteText;
        this.pendingRewriteText = null;
        if (r2 != null) goto L15;
        return;
    L15:
        if (TextUtils.equals(getText(), r2) == true) goto L23;
        startRewrite(r2);
        return;
    L23:
        return;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void onEffectFrameUpdated(String r1, long r2, n r4) {
        o.e(r1, "effectName");
        o.e(r4, "spec");
        updateRewritePhase();
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public com.obric.oui.texteffects.c.c buildTextCache(CharSequence r10) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r3, "text");
        com.obric.oui.texteffects.c.d r2 = com.obric.oui.texteffects.c.d.f36450a;
        TextPaint r4 = getPaint();
        o.c(r4, "paint");
        return r2.a(r3, r4, computeContentWidth(), getEllipsize(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new g(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public LinearGradient buildGradientShader(com.obric.oui.texteffects.c.c r9, com.obric.oui.texteffects.a.h.a r10) {
        o.e(r9, "cache");
        o.e(r10, "fill");
        if (r9.f() > 0.01f) goto L6;
        return null;
    L6:
        float r1 = r9.g();
        return new LinearGradient(r1, 0.0f, r1 + r9.f(), 0.0f, r10.a(), r10.b(), Shader.TileMode.CLAMP);
    }

    private final float currentPendingGradientAlpha() {
        if (this.activeMode == b.f36328b) goto L5;
        return 0.0f;
    L5:
        if (this.pendingTextType != c.f36332a) goto L29;
        com.obric.oui.texteffects.runtime.d r5 = sampleCurrentEffectFrame();
        if (r5 == null) goto L30;
        List<com.obric.oui.texteffects.runtime.c> r6 = r5.a();
        if (r6 == null) goto L31;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L15:
        if (r7.hasNext() == false) goto L19;
        Object r0 = r7.next();
        if (o.a(((com.obric.oui.texteffects.runtime.c) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.texteffects.runtime.c.class, "com.obric.aiagent.plugin")).b(), PendingGradientLayerId) == false) goto L15;
    L20:
        com.obric.oui.texteffects.runtime.c r8 = (com.obric.oui.texteffects.runtime.c) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.texteffects.runtime.c.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L24;
        return 0.0f;
    L24:
        return d.l.n.a(r8.a(0.0f), 0.0f, 0.8f);
    L19:
        r0 = null;
        goto L20
    L31:
        return 0.0f;
    L30:
        return 0.0f;
    L29:
        return 0.0f;
    }

    private final void updateRewritePhase() {
        if (this.activeMode == b.f) goto L5;
        d r0 = d.f36335a;
    L9:
        this.rewritePhase = r0;
        return;
    L5:
        if (getCurrentEffectPlayTimeMs() >= 150) goto L7;
        r0 = d.f36336b;
        goto L9
    L7:
        r0 = d.f36337c;
        goto L9
    }

    private final b toDimPointMode(String r1) {
        switch(r1.hashCode()) {
            case -1253981585: goto L22;
            case -682587753: goto L18;
            case -208065901: goto L14;
            case 1101148556: goto L10;
            case 1810371957: goto L6;
            default: goto L26;
        };
    L6:
        if (r1.equals(EffectNameGenerate) == false) goto L26;
        return b.f36331e;
    L10:
        if (r1.equals(EffectNameRewrite) == false) goto L26;
        return b.f;
    L14:
        if (r1.equals(EffectNamePromptExitToGenerate) == false) goto L26;
        return b.f36329c;
    L18:
        if (r1.equals(EffectNamePending) == false) goto L26;
        return b.f36328b;
    L22:
        if (r1.equals(EffectNamePromptSwitch) == false) goto L26;
        return b.f36330d;
    L26:
        return b.f36327a;
    }
}
