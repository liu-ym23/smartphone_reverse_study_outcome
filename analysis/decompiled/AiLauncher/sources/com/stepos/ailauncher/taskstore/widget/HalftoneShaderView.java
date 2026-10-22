package com.stepos.ailauncher.taskstore.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RenderNode;
import android.graphics.RuntimeShader;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.display.k;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import s.C5423E;
import v9.C5685n;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 b2\u00020\u0001:\u0001cB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\fJ\u001f\u0010$\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\n¢\u0006\u0004\b&\u0010\fJ\u0015\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\n¢\u0006\u0004\b+\u0010\fJ\r\u0010,\u001a\u00020\n¢\u0006\u0004\b,\u0010\fJ\u000f\u0010-\u001a\u00020\nH\u0014¢\u0006\u0004\b-\u0010\fJ\u0017\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b/\u0010\u0011J\u000f\u00100\u001a\u00020\nH\u0014¢\u0006\u0004\b0\u0010\fJ\u0017\u00101\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00108R\u0014\u0010:\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R*\u0010B\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010@R\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010R\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010T\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010LR\u001e\u0010W\u001a\n\u0018\u00010Uj\u0004\u0018\u0001`V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u001e\u0010Y\u001a\n\u0018\u00010Uj\u0004\u0018\u0001`V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010XR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0011\u0010a\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b`\u0010\u0013¨\u0006d"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/HalftoneShaderView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", Const.INTENT_KEY_BACKGROUND_COMMAND, "", UxipConstants.f30680s, "setRunning", "(Z)V", "s", "()Z", "o", "p", "n", "", "y", "()F", "Landroid/graphics/Canvas;", "canvas", "drawW", "drawH", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/graphics/Canvas;II)V", "f", "", "name", "rgb", "r", "(Ljava/lang/String;I)V", "t", "", "delayMs", "v", "(J)V", "u", "k", "onAttachedToWindow", "isVisible", "onVisibilityAggregated", "onDetachedFromWindow", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/RuntimeShader;", "shader", "Landroid/graphics/RuntimeShader;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "upsamplePaint", "density", "F", "Landroid/graphics/RenderNode;", "waitRenderNode", "Landroid/graphics/RenderNode;", "animating", "Z", "Lkotlin/Function0;", "onRunningChanged", "Lp9/a;", "getOnRunningChanged", "()Lp9/a;", "setOnRunningChanged", "(Lp9/a;)V", "epochNanos", "J", "Ljava/lang/Runnable;", "pendingStop", "Ljava/lang/Runnable;", "frameScheduled", "Landroid/graphics/Rect;", "visibleRect", "Landroid/graphics/Rect;", "Landroid/view/ViewTreeObserver;", "attachedObserver", "Landroid/view/ViewTreeObserver;", "frameTick", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "waitClockToken", "Ljava/lang/AutoCloseable;", "waitModeListener", "Lcom/stepos/agentframework/display/k$a;", "waitFrameTick", "Lcom/stepos/agentframework/display/k$a;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "l", "isRunning", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HalftoneShaderView extends View {

    @Deprecated
    public static final String AGSL = "\nuniform float2 uRes;      // view size in px\nuniform float  uDensity;  // resources.displayMetrics.density\nuniform float  uTime;     // seconds\n\nuniform float  uSpacing;\nuniform float  uSizeMin;  uniform float uSizeMax;\nuniform float  uSizeMaxAmp; uniform float uSizeMaxFreq;\nuniform float  uAlphaMin; uniform float uAlphaMax;\nuniform float  uMidA;     uniform float uScaleA;  uniform float uSpeedA;  uniform float uScatterA;\nuniform float3 uColorA;   uniform float3 uColorB; uniform float3 uColorC;\nuniform float  uBPos;     uniform float uBWidth;  uniform float uMidB;    uniform float uScaleB; uniform float uSpeedB; uniform float uScatterB;\nuniform float3 uBgColor;  uniform float uBgAlpha;\nuniform float  uOpacity;  // master opacity for the whole layer\n\nfloat2 hash2(float n){ return fract(sin(float2(n*12.9898, n*78.233)) * 43758.5453); }\nfloat blobField(float2 P, float time, float scl, float seed, float scatter){\n    float refH = uRes.y / uDensity;\n    float2 q = (P / refH) * 2.5 * scl;\n    float acc = 0.0;\n    for (int i = 0; i < 4; i++){\n        float fi = float(i);\n        float2 ctr = (hash2(fi + 1.0 + seed*0.137) - 0.5) * 2.0 * scatter;\n        float sp = 0.5 + 0.17 * fi;\n        float2 orbit = float2(1.1*sin(time*sp + fi*2.399 + seed),\n                              1.1*cos(time*sp*0.83 + fi*1.7 + seed*1.3));\n        float2 dq = q - (ctr + orbit);\n        acc += exp(-dot(dq, dq) * 0.9);\n    }\n    return smoothstep(0.25, 1.5, acc);\n}\nfloat bias(float x, float m){ m = clamp(m, 0.02, 0.98); return pow(clamp(x,0.0,1.0), log(m)/log(0.5)); }\nfloat3 grad3(float tt, float3 a, float3 b, float3 c, float bp, float bw){\n    bp = clamp(bp, 0.001, 0.999);\n    float lo = max(bp - bw, 0.0);\n    float hi = min(bp + bw, 1.0);\n    if(tt < lo) return mix(a, b, smoothstep(0.0, lo, tt));\n    if(tt > hi) return mix(b, c, smoothstep(hi, 1.0, tt));\n    return b;\n}\nhalf4 main(float2 fragCoord){\n    float2 P = (fragCoord - 0.5 * uRes) / uDensity;\n    float2 cell   = floor(P / uSpacing + 0.5);\n    float2 center = cell * uSpacing;\n    float fA = bias(blobField(center, uTime*uSpeedA, uScaleA, 0.0,  uScatterA), uMidA);\n    float fB = bias(blobField(center, uTime*uSpeedB, uScaleB, 17.0, uScatterB), uMidB);\n    float breath = sin(uTime*uSizeMaxFreq*6.2831853) * uSizeMaxAmp;\n    float sizeMaxDyn = max(uSizeMin, uSizeMax + breath);\n    float radius = mix(uSizeMin, sizeMaxDyn, fA) * uSpacing * 0.5;\n    float dotA   = mix(uAlphaMin, uAlphaMax, fA);\n    float3 dotCol = grad3(fB, uColorA, uColorB, uColorC, uBPos, uBWidth);\n    float d   = length(P - center);\n    float cov = smoothstep(radius, radius - 1.0, d);\n    float da  = cov * dotA;\n    float outA   = da + uBgAlpha * (1.0 - da);\n    float3 outRGB = dotCol*da + uBgColor*uBgAlpha*(1.0 - da);\n    return half4(half3(outRGB), half(outA)) * uOpacity;   // premultiplied, master opacity\n}\n";
    private static final a Companion = new a(null);

    @Deprecated
    public static final long FRAME_INTERVAL_MS = 66;

    @Deprecated
    public static final float RENDER_BASE = 560.0f;

    @Deprecated
    public static final float SPACING = 23.0f;

    @Deprecated
    public static final float WAIT_RENDER_SCALE = 0.62f;
    private boolean animating;
    private ViewTreeObserver attachedObserver;
    private final float density;
    private long epochNanos;
    private boolean frameScheduled;
    private final Runnable frameTick;
    private InterfaceC5063a<Y8.t> onRunningChanged;
    private final Paint paint;
    private Runnable pendingStop;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final RuntimeShader shader;
    private final Paint upsamplePaint;
    private final Rect visibleRect;
    private AutoCloseable waitClockToken;
    private final k.a waitFrameTick;
    private AutoCloseable waitModeListener;
    private final RenderNode waitRenderNode;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/HalftoneShaderView$a;", "", "<init>", "()V", "", "SPACING", "F", "RENDER_BASE", "", "FRAME_INTERVAL_MS", "J", "WAIT_RENDER_SCALE", "", "AGSL", "Ljava/lang/String;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HalftoneShaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final void j(HalftoneShaderView halftoneShaderView) {
        halftoneShaderView.frameScheduled = false;
        if (halftoneShaderView.s()) {
            halftoneShaderView.postInvalidateOnAnimation();
        }
    }

    public static final Y8.t m(HalftoneShaderView halftoneShaderView) throws Exception {
        if (halftoneShaderView.animating) {
            halftoneShaderView.o();
        }
        return Y8.t.f7040a;
    }

    public static final void q(HalftoneShaderView halftoneShaderView) throws Exception {
        if (halftoneShaderView.animating && !halftoneShaderView.frameScheduled && halftoneShaderView.s()) {
            halftoneShaderView.o();
        }
    }

    private final void setRunning(boolean value) {
        if (this.animating == value) {
            return;
        }
        this.animating = value;
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onRunningChanged;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void w(HalftoneShaderView halftoneShaderView) {
        halftoneShaderView.pendingStop = null;
        halftoneShaderView.u();
    }

    public static final void x(HalftoneShaderView halftoneShaderView, long j10) throws Exception {
        if (halftoneShaderView.s() && com.stepos.agentframework.display.j.INSTANCE.p(halftoneShaderView)) {
            halftoneShaderView.invalidate();
        } else {
            halftoneShaderView.n();
        }
    }

    public final void f() {
        this.shader.setFloatUniform("uSizeMin", 0.0f);
        this.shader.setFloatUniform("uSizeMax", 0.32f);
        this.shader.setFloatUniform("uSizeMaxAmp", 0.05f);
        this.shader.setFloatUniform("uSizeMaxFreq", 0.07f);
        this.shader.setFloatUniform("uAlphaMin", 0.0f);
        this.shader.setFloatUniform("uAlphaMax", 1.0f);
        this.shader.setFloatUniform("uMidA", 0.84f);
        this.shader.setFloatUniform("uScaleA", 1.74f);
        this.shader.setFloatUniform("uSpeedA", 1.25f);
        this.shader.setFloatUniform("uScatterA", 1.51f);
        r("uColorA", 16213553);
        r("uColorB", 13946057);
        r("uColorC", 6802425);
        this.shader.setFloatUniform("uBPos", 0.64f);
        this.shader.setFloatUniform("uBWidth", 0.09f);
        this.shader.setFloatUniform("uMidB", 0.29f);
        this.shader.setFloatUniform("uScaleB", 0.84f);
        this.shader.setFloatUniform("uSpeedB", 0.74f);
        this.shader.setFloatUniform("uScatterB", 2.19f);
        r("uBgColor", 1184274);
        this.shader.setFloatUniform("uBgAlpha", 1.0f);
        this.shader.setFloatUniform("uOpacity", 1.0f);
    }

    public final void g() throws Exception {
        n();
        if (this.frameScheduled) {
            removeCallbacks(this.frameTick);
            this.frameScheduled = false;
        }
    }

    public final InterfaceC5063a<Y8.t> getOnRunningChanged() {
        return this.onRunningChanged;
    }

    public final void h() {
        Runnable runnable = this.pendingStop;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.pendingStop = null;
    }

    public final void i(Canvas canvas, int drawW, int drawH) {
        this.waitRenderNode.setPosition(0, 0, drawW, drawH);
        this.waitRenderNode.setUseCompositingLayer(true, this.upsamplePaint);
        RecordingCanvas recordingCanvasBeginRecording = this.waitRenderNode.beginRecording();
        kotlin.jvm.internal.p.h(recordingCanvasBeginRecording, "beginRecording(...)");
        float f10 = drawW;
        float f11 = drawH;
        try {
            recordingCanvasBeginRecording.drawRect(0.0f, 0.0f, f10, f11, this.paint);
            this.waitRenderNode.endRecording();
            canvas.save();
            canvas.scale(getWidth() / f10, getHeight() / f11);
            canvas.drawRenderNode(this.waitRenderNode);
            canvas.restore();
        } catch (Throwable th) {
            this.waitRenderNode.endRecording();
            throw th;
        }
    }

    public final void k() {
        h();
        g();
        setRunning(false);
        setVisibility(0);
    }

    /* renamed from: l, reason: from getter */
    public final boolean getAnimating() {
        return this.animating;
    }

    public final void n() throws Exception {
        AutoCloseable autoCloseable = this.waitClockToken;
        if (autoCloseable != null) {
            C5423E.a(autoCloseable);
        }
        this.waitClockToken = null;
    }

    public final void o() throws Exception {
        if (s()) {
            p();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() throws Exception {
        super.onAttachedToWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        this.attachedObserver = viewTreeObserver;
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnScrollChangedListener(this.scrollChangedListener);
        }
        AutoCloseable autoCloseable = this.waitModeListener;
        if (autoCloseable != null) {
            C5423E.a(autoCloseable);
        }
        this.waitModeListener = com.stepos.agentframework.display.j.INSTANCE.i(this, new InterfaceC5063a() { // from class: com.stepos.ailauncher.taskstore.widget.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HalftoneShaderView.m(this.f29373a);
            }
        });
        if (this.animating) {
            o();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() throws Exception {
        ViewTreeObserver viewTreeObserver = this.attachedObserver;
        this.attachedObserver = null;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.scrollChangedListener);
        }
        AutoCloseable autoCloseable = this.waitModeListener;
        if (autoCloseable != null) {
            C5423E.a(autoCloseable);
        }
        this.waitModeListener = null;
        g();
        Runnable runnable = this.pendingStop;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.pendingStop = null;
            u();
        }
        this.waitRenderNode.discardDisplayList();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) throws Exception {
        Canvas canvas2;
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (!canvas.isHardwareAccelerated()) {
            if (this.animating) {
                o();
                return;
            }
            return;
        }
        if (this.epochNanos == 0) {
            this.epochNanos = System.nanoTime();
        }
        float fY = y();
        int iF = C5685n.f((int) (getWidth() * fY), 1);
        int iF2 = C5685n.f((int) (getHeight() * fY), 1);
        this.shader.setFloatUniform("uRes", iF, iF2);
        this.shader.setFloatUniform("uDensity", this.density);
        this.shader.setFloatUniform("uTime", (System.nanoTime() - this.epochNanos) / 1.0E9f);
        this.shader.setFloatUniform("uSpacing", ((Math.min(iF, iF2) / this.density) / 560.0f) * 23.0f);
        this.paint.setShader(this.shader);
        if (fY < 1.0f) {
            i(canvas, iF, iF2);
            canvas2 = canvas;
        } else {
            canvas2 = canvas;
            canvas2.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.paint);
        }
        M6.c cVar = M6.c.INSTANCE;
        int layerType = getLayerType();
        boolean zIsHardwareAccelerated = canvas2.isHardwareAccelerated();
        Display display = getDisplay();
        cVar.o(layerType, iF, iF2, zIsHardwareAccelerated, display != null ? display.getRefreshRate() : 0.0f);
        cVar.n();
        if (this.animating) {
            o();
        }
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) throws Exception {
        super.onVisibilityAggregated(isVisible);
        if (this.animating) {
            if (isVisible) {
                o();
            } else {
                g();
            }
        }
    }

    public final void p() throws Exception {
        if (s()) {
            if (!com.stepos.agentframework.display.j.INSTANCE.p(this)) {
                n();
                if (this.frameScheduled) {
                    return;
                }
                this.frameScheduled = true;
                postDelayed(this.frameTick, 66L);
                return;
            }
            if (this.frameScheduled) {
                removeCallbacks(this.frameTick);
                this.frameScheduled = false;
            }
            if (this.waitClockToken == null) {
                this.waitClockToken = com.stepos.agentframework.display.k.INSTANCE.e(this.waitFrameTick);
            }
        }
    }

    public final void r(String name, int rgb) {
        int i10 = rgb | (-16777216);
        this.shader.setFloatUniform(name, Color.red(i10) / 255.0f, Color.green(i10) / 255.0f, Color.blue(i10) / 255.0f);
    }

    public final boolean s() {
        return this.animating && isAttachedToWindow() && isShown() && getWidth() > 0 && getHeight() > 0 && getGlobalVisibleRect(this.visibleRect) && this.visibleRect.width() > 0 && this.visibleRect.height() > 0;
    }

    public final void setOnRunningChanged(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onRunningChanged = interfaceC5063a;
    }

    public final void t() {
        h();
        setVisibility(0);
        if (this.animating) {
            o();
            return;
        }
        setRunning(true);
        if (this.epochNanos == 0) {
            this.epochNanos = System.nanoTime();
        }
        o();
    }

    public final void u() {
        h();
        g();
        setRunning(false);
        this.epochNanos = 0L;
        this.waitRenderNode.discardDisplayList();
        setVisibility(8);
    }

    public final void v(long delayMs) {
        h();
        if (delayMs <= 0) {
            u();
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.i
            @Override // java.lang.Runnable
            public final void run() {
                HalftoneShaderView.w(this.f29376a);
            }
        };
        this.pendingStop = runnable;
        postDelayed(runnable, delayMs);
        postInvalidateOnAnimation();
    }

    public final float y() {
        return (this.animating && this.pendingStop == null) ? 0.62f : 1.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HalftoneShaderView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.shader = new RuntimeShader(AGSL);
        this.paint = new Paint();
        this.upsamplePaint = new Paint(2);
        this.density = getResources().getDisplayMetrics().density;
        this.waitRenderNode = new RenderNode("halftoneWait");
        this.visibleRect = new Rect();
        this.frameTick = new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                HalftoneShaderView.j(this.f29364a);
            }
        };
        this.waitFrameTick = new k.a() { // from class: com.stepos.ailauncher.taskstore.widget.f
            @Override // com.stepos.agentframework.display.k.a
            public final void a(long j10) throws Exception {
                HalftoneShaderView.x(this.f29369a, j10);
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.stepos.ailauncher.taskstore.widget.g
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() throws Exception {
                HalftoneShaderView.q(this.f29371a);
            }
        };
        setLayerType(0, null);
        f();
    }

    public /* synthetic */ HalftoneShaderView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
