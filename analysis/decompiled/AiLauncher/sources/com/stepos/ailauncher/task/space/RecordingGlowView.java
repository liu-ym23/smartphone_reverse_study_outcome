package com.stepos.ailauncher.task.space;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.Arrays;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u0000 12\u00020\u0001:\u0001!B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u0012J\u001f\u0010!\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/stepos/ailauncher/task/space/RecordingGlowView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "active", "LY8/t;", "setActive", "(Z)V", "", "level", "setAudioLevel", "(F)V", "onDetachedFromWindow", "()V", "", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", Const.INTENT_KEY_PKGNAME, "widthDp", "heightDp", Const.INTENT_KEY_APIKEY, "(FF)V", "Landroid/graphics/RuntimeShader;", "shader", "Landroid/graphics/RuntimeShader;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "density", "F", "audioSmoothed", "audioTarget", "Z", "", "startNanos", "J", "Companion", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RecordingGlowView extends View {
    private static final String AGSL = "\n            uniform float2 iResolution;\n            uniform float  iTime;\n            uniform float  uDensity;\n            uniform float  uRadius, uMargin, uInnerRound;\n            uniform float  uBarInset, uMidGap, uMidOffset, uSideInset;\n            uniform float  uMidRound, uTaper, uTaperWidth;\n            uniform float  uEdgeFeatherTop, uEdgeFeatherBottom, uMidFeather, uCenterZone, uBandWidth, uOuterFeather, uDimZone;\n            uniform float  uIntensity, uOpacity, uMidOpacity;\n            uniform float  uFlowSpeed, uFlowAmount, uFlowAngle;\n            uniform float  uAudio, uAudioMid, uAudioSide;\n            uniform float3 uBase, uGlow1, uGlow2;\n\n            float sdRoundBox(float2 p, float2 b, float r){\n                float2 q = abs(p) - b + r;\n                return min(max(q.x, q.y), 0.0) + length(max(q, float2(0.0))) - r;\n            }\n            // 四角各自半径的圆角矩形 SDF;r = (右上, 右下, 左上, 左下)\n            float sdRoundBox4(float2 p, float2 b, float4 r){\n                float2 rxy = (p.x > 0.0) ? r.xy : r.zw;\n                float  rr  = (p.y > 0.0) ? rxy.x : rxy.y;\n                float2 q   = abs(p) - b + rr;\n                return min(max(q.x, q.y), 0.0) + length(max(q, float2(0.0))) - rr;\n            }\n            // 平滑最小值:把两面板相接处倒成圆角(k=0 等价 min)\n            float smin(float a, float b, float k){\n                if (k <= 0.0) return min(a, b);\n                float h = clamp(0.5 + 0.5 * (b - a) / k, 0.0, 1.0);\n                return mix(b, a, h) - k * h * (1.0 - h);\n            }\n\n            half4 main(float2 fragCoord){\n                // 翻转 Y(统一为 Y 向上,与网页一致)再除以密度 → dp 空间\n                float2 P  = float2(fragCoord.x - 0.5 * iResolution.x,\n                                   0.5 * iResolution.y - fragCoord.y) / uDensity;\n                float2 hb = 0.5 * iResolution / uDensity - float2(uMargin);\n                float  t  = iTime;\n\n                float dCard = sdRoundBox(P, hb, min(uRadius, min(hb.x, hb.y)));\n\n                // 音量 → 中线/侧线变粗;上下保持不变\n                float midGap    = uMidGap    + uAudio * uAudioMid;\n                float sideInset = uSideInset + uAudio * uAudioSide;\n\n                // 中线锥度:cos^k 全宽连续,从中央到两端单调收窄、绝不中途归零(始终一整块融合带)\n                float dX     = clamp(abs(P.x) / max(hb.x, 1.0), 0.0, 1.0);\n                float kT     = clamp(0.6 / clamp(uTaperWidth, 0.1, 1.5), 0.4, 8.0);\n                float taperW = pow(max(cos(dX * 1.5707963), 0.0), kT);\n                float yShift = uTaper * taperW;\n\n                // 上/下面板:外边沿固定,仅内边沿随 锥度 与 中线Y偏移(mc) 移动\n                float mc = uMidOffset;\n                float2 thHalf = float2(hb.x - sideInset, max((mc - midGap - yShift) - (-hb.y + uBarInset), 1.0) * 0.5);\n                float2 thCent = float2(0.0, ((-hb.y + uBarInset) + (mc - midGap - yShift)) * 0.5);\n                float2 bhHalf = float2(hb.x - sideInset, max((hb.y - uBarInset) - (mc + midGap + yShift), 1.0) * 0.5);\n                float2 bhCent = float2(0.0, ((mc + midGap + yShift) + (hb.y - uBarInset)) * 0.5);\n\n                float rMax = min(thHalf.x, thHalf.y);\n                float ro   = min(max(uRadius - uSideInset, 0.0), rMax);   // 外侧圆角:与外卡片圆角同心\n                float ri   = min(uInnerRound, rMax);                      // 内侧圆角(朝向中线)\n\n                // Y 已翻转:thCent.y<0 渲染在屏幕下方;外侧角用 ro、朝中线的内侧角用 ri\n                float dT = sdRoundBox4(P - thCent, thHalf, float4(ri, ro, ri, ro));\n                float dB = sdRoundBox4(P - bhCent, bhHalf, float4(ro, ri, ro, ri));\n                float m  = smin(dT, dB, uMidRound);     // 平滑合并两面板,相接处倒圆\n\n                // 羽化随位置:向上/向下各自按\"到该侧面板外沿的实际距离\"归一化,\n                // 顶/底两端无论中线位置(mc)如何都收敛到锁死的\"顶底羽化\"\n                float dyf    = P.y - mc;\n                float spanUp = max((hb.y - uBarInset) - mc, 1.0);\n                float spanDn = max((hb.y - uBarInset) + mc, 1.0);\n                float spanF  = (dyf >= 0.0) ? spanUp : spanDn;\n                // P.y 向上为正 → dyf>=0 是屏幕上方(顶部一侧),dyf<0 是底部一侧。\n                // 顶/底各自用独立的 edgeFeather,允许\"顶部更薄、底部更厚\"。\n                float edgeF = (dyf >= 0.0) ? uEdgeFeatherTop : uEdgeFeatherBottom;\n                float w  = smoothstep(0.0, 1.0, clamp(abs(dyf) / max(spanF * uCenterZone, 1.0), 0.0, 1.0));\n                float fe = mix(uMidFeather, edgeF, w);\n\n                float inner = smoothstep(-max(fe, 0.001), 0.0, m);                                  // 向面板内羽化到暗\n                float outer = 1.0 - smoothstep(uBandWidth, uBandWidth + max(uOuterFeather, 0.001), m); // 外缘淡出\n                float glow  = inner * outer;\n\n                // 平滑流动微光(非噪点):沿 uFlowAngle 指定方向传播(0°=右,90°=上)\n                float fAng  = uFlowAngle * 0.0174532925;\n                float2 fDir = float2(cos(fAng), sin(fAng));\n                float sh = 1.0 + uFlowAmount * 0.5 * sin(dot(P, fDir) * 0.017 - t * uFlowSpeed * 6.0);\n                glow = clamp(glow * sh, 0.0, 1.0);\n\n                float cardMask = 1.0 - smoothstep(-1.5, 1.5, dCard);\n\n                float3 gcol = mix(uGlow1, uGlow2, smoothstep(0.25, 1.0, glow));\n                float wDim  = smoothstep(0.0, 1.0, clamp(abs(P.y - mc) / max(hb.y * uDimZone, 1.0), 0.0, 1.0));\n                float vis   = mix(uMidOpacity, 1.0, wDim);                              // 中段相对顶/底淡化\n                float3 col  = uBase + gcol * glow * uIntensity * uOpacity * vis;        // uOpacity=整体虚化\n                col = mix(uBase, col, cardMask);\n                return half4(half3(clamp(col, 0.0, 1.0)), 1.0);\n            }\n        ";
    private static final float BASE_HEIGHT_DP = 500.0f;
    private static final float BASE_WIDTH_DP = 325.0f;
    private static final a Companion = new a(null);
    private static final String TAG = "RecordingGlowView";
    private boolean active;
    private float audioSmoothed;
    private volatile float audioTarget;
    private final float density;
    private final Paint paint;
    private final RuntimeShader shader;
    private long startNanos;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/task/space/RecordingGlowView$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "", "BASE_WIDTH_DP", "F", "BASE_HEIGHT_DP", "AGSL", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordingGlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        RuntimeShader runtimeShader = new RuntimeShader(AGSL);
        this.shader = runtimeShader;
        Paint paint = new Paint();
        paint.setShader(runtimeShader);
        this.paint = paint;
        this.density = getResources().getDisplayMetrics().density;
        setLayerType(2, null);
        b();
        a(BASE_WIDTH_DP, 500.0f);
    }

    public final void a(float widthDp, float heightDp) {
        float fM = C5685n.m(widthDp / BASE_WIDTH_DP, 0.4f, 1.6f);
        float fM2 = C5685n.m(heightDp / 500.0f, 0.4f, 1.6f);
        float fMin = Math.min(fM, fM2);
        this.shader.setFloatUniform("uBarInset", 4.0f * fM2);
        this.shader.setFloatUniform("uMidGap", (-73.0f) * fM2);
        this.shader.setFloatUniform("uMidOffset", (-63.0f) * fM2);
        this.shader.setFloatUniform("uTaper", 15.0f * fM2);
        this.shader.setFloatUniform("uMidFeather", 126.0f * fM2);
        this.shader.setFloatUniform("uAudioMid", fM2 * 41.0f);
        this.shader.setFloatUniform("uSideInset", 1.0f * fM);
        this.shader.setFloatUniform("uAudioSide", fM * 12.0f);
        this.shader.setFloatUniform("uInnerRound", 120.0f * fMin);
        this.shader.setFloatUniform("uMidRound", 85.0f * fMin);
        this.shader.setFloatUniform("uBandWidth", 52.0f * fMin);
        this.shader.setFloatUniform("uOuterFeather", fMin * 114.0f);
    }

    public final void b() {
        this.shader.setFloatUniform("uDensity", this.density);
        this.shader.setFloatUniform("uRadius", 24.0f);
        this.shader.setFloatUniform("uMargin", 0.0f);
        this.shader.setFloatUniform("uTaperWidth", 0.98f);
        this.shader.setFloatUniform("uCenterZone", 1.0f);
        this.shader.setFloatUniform("uDimZone", 1.5f);
        this.shader.setFloatUniform("uEdgeFeatherTop", 14.0f);
        this.shader.setFloatUniform("uEdgeFeatherBottom", 36.0f);
        this.shader.setFloatUniform("uIntensity", 1.58f);
        this.shader.setFloatUniform("uOpacity", 0.8f);
        this.shader.setFloatUniform("uMidOpacity", 0.36f);
        this.shader.setFloatUniform("uFlowSpeed", 1.18f);
        this.shader.setFloatUniform("uFlowAmount", 0.12f);
        this.shader.setFloatUniform("uFlowAngle", 100.0f);
        this.shader.setFloatUniform("uBase", 0.137f, 0.137f, 0.153f);
        this.shader.setFloatUniform("uGlow1", 0.757f, 0.263f, 0.059f);
        this.shader.setFloatUniform("uGlow2", 0.953f, 0.643f, 0.306f);
        this.shader.setFloatUniform("uAudio", 0.0f);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.active = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (this.startNanos == 0) {
            this.startNanos = SystemClock.elapsedRealtimeNanos();
        }
        float fElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.startNanos) / 1.0E9f;
        float f10 = this.audioTarget;
        float f11 = this.audioSmoothed;
        this.audioSmoothed = f11 + ((f10 - f11) * ((f10 > f11 ? 1 : (f10 == f11 ? 0 : -1)) > 0 ? 0.5f : 0.08f));
        this.shader.setFloatUniform("iResolution", getWidth(), getHeight());
        this.shader.setFloatUniform("iTime", fElapsedRealtimeNanos);
        this.shader.setFloatUniform("uAudio", this.audioSmoothed);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.paint);
        if (this.active) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        if (w10 <= 0 || h10 <= 0) {
            return;
        }
        float f10 = this.density;
        float f11 = w10 / f10;
        float f12 = h10 / f10;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("card size: %dpx × %dpx  (%.1fdp × %.1fdp), density=%.2f", Arrays.copyOf(new Object[]{Integer.valueOf(w10), Integer.valueOf(h10), Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(this.density)}, 5));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        a(f11, f12);
    }

    public final void setActive(boolean active) {
        if (this.active == active) {
            return;
        }
        this.active = active;
        if (active) {
            this.startNanos = 0L;
            this.audioSmoothed = 0.0f;
            this.audioTarget = 0.0f;
            postInvalidateOnAnimation();
        }
    }

    public final void setAudioLevel(float level) {
        this.audioTarget = C5685n.m(level, 0.0f, 1.0f);
    }
}
