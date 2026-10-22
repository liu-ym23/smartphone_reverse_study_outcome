package com.stepos.ailauncher.speech.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.wake.circle.F;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5685n;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0017\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007*\u0001w\u0018\u0000 {2\u00020\u0001:\u0001|B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\fJ\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u000e\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0015J\u0017\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0018H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010\r\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010)J\u0017\u0010,\u001a\u00020\u00132\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0013H\u0002¢\u0006\u0004\b/\u0010'J\r\u00100\u001a\u00020\n¢\u0006\u0004\b0\u0010\fJ\r\u00101\u001a\u00020\n¢\u0006\u0004\b1\u0010\fJ\u0015\u00103\u001a\u00020\n2\u0006\u00102\u001a\u00020*¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\n¢\u0006\u0004\b5\u0010\fJ\r\u00106\u001a\u00020\n¢\u0006\u0004\b6\u0010\fJ/\u00109\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0014¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\nH\u0014¢\u0006\u0004\b;\u0010\fJ\u0017\u0010=\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0006H\u0014¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0006H\u0016¢\u0006\u0004\b?\u0010>J\u000f\u0010@\u001a\u00020\nH\u0014¢\u0006\u0004\b@\u0010\fJ\u0017\u0010C\u001a\u00020\n2\u0006\u0010B\u001a\u00020AH\u0014¢\u0006\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR\u0016\u0010H\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010I\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010FR\u0016\u0010J\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010FR\u0014\u0010K\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010LR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010LR\u0016\u0010N\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010FR\u0016\u0010O\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010FR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010RR\u0016\u0010T\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010RR\u0014\u0010U\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010RR\u0014\u0010V\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010RR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010RR\u0016\u0010_\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010`R\u0016\u0010b\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010RR\u0016\u0010c\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010e\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010dR\u0016\u0010f\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010FR\u0016\u0010g\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010FR\u0016\u0010i\u001a\u00020h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010jR\u0014\u0010m\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010p\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u001c\u0010t\u001a\n s*\u0004\u0018\u00010r0r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010v\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010dR\u0014\u0010x\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010z\u001a\u00020h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010j¨\u0006}"}, d2 = {"Lcom/stepos/ailauncher/speech/view/DotWaveVoiceView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "u", "()V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "q", "(II)V", "col", "cols", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(II)F", "r", "s", "", "nowMs", "t", "(IJ)V", "p", "()F", "o", "()I", "ageMs", "lifetimeMs", "frameTimeNanos", Const.INTENT_KEY_BACKGROUND_COMMAND, "(J)V", "xNorm", "l", "(F)F", "seed", "(I)F", "", "samples", "n", "([S)F", "rms", "m", "x", "y", "pcm", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "([S)V", "k", "v", "oldw", "oldh", "onSizeChanged", "(IIII)V", "onAttachedToWindow", "visibility", "onWindowVisibilityChanged", "(I)V", "setVisibility", "onDetachedFromWindow", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "density", "F", "stepH", "stepV", "dotSize", "cornerR", "rows", "I", "centerRow", "gridOriginX", "gridOriginY", "", "columnHeights", "[F", "textureCurrent", "textureTarget", "atomPos", "atomJitter", "", "atomBirthMs", "[J", "", "atomLifetimeMs", "[I", "atomFade", "", "topMask", "[Z", "bottomMask", "colFade", "lastMaskRetargetMs", "J", "lastTextureRetargetMs", "latestRms", "amplitude", "", RobotInfo.STATUS_STARTED, "Z", "frozen", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "Landroid/graphics/RectF;", "rectF", "Landroid/graphics/RectF;", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "choreographer", "Landroid/view/Choreographer;", "lastRenderNanos", "com/stepos/ailauncher/speech/view/DotWaveVoiceView$b", "frameCallback", "Lcom/stepos/ailauncher/speech/view/DotWaveVoiceView$b;", "pausedForVisibility", "Companion", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DotWaveVoiceView extends View {
    private static final int ALPHA_GRID = 20;
    private static final int ATOM_COUNT = 3;
    private static final long ATOM_FADE_MS = 150;
    private static final float ATOM_JITTER_MAX = 1.0f;
    private static final float ATOM_JITTER_MIN = 0.7f;
    private static final long ATOM_LIFETIME_MS_MAX = 1100;
    private static final long ATOM_LIFETIME_MS_MIN = 600;
    private static final float ATOM_SIGMA = 0.055f;
    private static final float ATOM_SPAWN_CENTER = 0.5f;
    private static final float ATOM_SPAWN_CENTER_BIAS = 0.7f;
    private static final float ATOM_SPAWN_POS_MAX = 0.78f;
    private static final float ATOM_SPAWN_POS_MIN = 0.22f;
    private static final float ATTACK = 0.55f;
    private static final int COLOR_GLOW = -19625;
    private static final int COLOR_PEAK = -42713;
    private static final int COLS = 40;
    private static final float COL_SMOOTH_K = 0.45f;
    private static final float DEFAULT_PAD_H_DP = 14.0f;
    private static final float DEFAULT_PAD_V_DP = 16.0f;
    private static final float EDGE_POWER = 1.8f;
    private static final float GAUSS_SIGMA = 0.55f;
    private static final float HALF_SKIP_PROBABILITY = 0.3f;
    private static final float HEIGHT_BOOST = 1.7f;
    private static final float LOUDNESS_GAIN = 3.0f;
    private static final float LOUDNESS_GAMMA = 0.35f;
    private static final long MASK_RETARGET_INTERVAL_MS = 250;
    private static final float NOISE_FLOOR = 0.006f;
    private static final float POS_GAUSS_SIGMA = 0.3f;
    private static final float RELEASE = 0.18f;
    private static final long RENDER_INTERVAL_NS = 14666666;
    private static final int ROWS = 7;
    private static final int SAFE_ZONE_WIDTH = 6;
    private static final float TEXTURE_AMOUNT = 0.15f;
    private static final float TEXTURE_LERP = 0.25f;
    private static final long TEXTURE_RETARGET_INTERVAL_MS = 70;
    private float amplitude;
    private final long[] atomBirthMs;
    private final float[] atomFade;
    private final float[] atomJitter;
    private final int[] atomLifetimeMs;
    private final float[] atomPos;
    private boolean[] bottomMask;
    private final int centerRow;
    private final Choreographer choreographer;
    private float[] colFade;
    private int cols;
    private float[] columnHeights;
    private float cornerR;
    private final float density;
    private float dotSize;
    private final b frameCallback;
    private boolean frozen;
    private float gridOriginX;
    private float gridOriginY;
    private long lastMaskRetargetMs;
    private long lastRenderNanos;
    private long lastTextureRetargetMs;
    private volatile float latestRms;
    private final Paint paint;
    private boolean pausedForVisibility;
    private final RectF rectF;
    private final int rows;
    private boolean started;
    private float stepH;
    private float stepV;
    private float[] textureCurrent;
    private float[] textureTarget;
    private boolean[] topMask;
    private static final float[] SAFE_ZONE_ALPHAS_F = {0.06f, 0.08f, 0.1f, 0.12f, 0.16f, 0.18f};
    private static final float[] ATOM_SCALE = {1.0f, 0.9f, 0.85f};

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/speech/view/DotWaveVoiceView$b", "Landroid/view/Choreographer$FrameCallback;", "", "frameTimeNanos", "LY8/t;", "doFrame", "(J)V", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Choreographer.FrameCallback {
        public b() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            if (DotWaveVoiceView.this.started) {
                if (!DotWaveVoiceView.this.isShown()) {
                    DotWaveVoiceView.this.pausedForVisibility = true;
                    return;
                }
                DotWaveVoiceView.this.pausedForVisibility = false;
                DotWaveVoiceView.this.choreographer.postFrameCallback(this);
                if (frameTimeNanos - DotWaveVoiceView.this.lastRenderNanos < DotWaveVoiceView.RENDER_INTERVAL_NS) {
                    return;
                }
                DotWaveVoiceView.this.lastRenderNanos = frameTimeNanos;
                DotWaveVoiceView.this.g(frameTimeNanos);
                DotWaveVoiceView.this.invalidate();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DotWaveVoiceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public final void g(long frameTimeNanos) {
        float fM = this.frozen ? 0.0f : m(this.latestRms);
        float f10 = this.amplitude;
        this.amplitude = f10 + ((fM - f10) * (fM > f10 ? 0.55f : 0.18f));
        long j10 = frameTimeNanos / 1000000;
        int i10 = 0;
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = (int) (j10 - this.atomBirthMs[i11]);
            if (i12 >= this.atomLifetimeMs[i11]) {
                t(i11, j10);
                this.atomFade[i11] = 0.0f;
            } else {
                this.atomFade[i11] = h(C5685n.f(i12, 0), this.atomLifetimeMs[i11]);
            }
        }
        if (j10 - this.lastTextureRetargetMs > TEXTURE_RETARGET_INTERVAL_MS) {
            this.lastTextureRetargetMs = j10;
            int i13 = this.cols;
            for (int i14 = 0; i14 < i13; i14++) {
                this.textureTarget[i14] = (float) Math.random();
            }
        }
        int i15 = this.cols;
        for (int i16 = 0; i16 < i15; i16++) {
            float[] fArr = this.textureCurrent;
            float f11 = fArr[i16];
            fArr[i16] = f11 + ((this.textureTarget[i16] - f11) * 0.25f);
        }
        if (j10 - this.lastMaskRetargetMs > 250) {
            this.lastMaskRetargetMs = j10;
            r();
        }
        float f12 = this.centerRow;
        float f13 = 1.05f * f12;
        int i17 = this.cols;
        int i18 = 0;
        while (i18 < i17) {
            int i19 = this.cols;
            float f14 = i19 > 1 ? i18 / (i19 - 1.0f) : 0.5f;
            float fExp = 0.0f;
            for (int i20 = i10; i20 < 3; i20++) {
                float f15 = this.atomPos[i20] - 0.5f;
                float fExp2 = (float) Math.exp((-(f15 * f15)) / 0.18f);
                float f16 = f14 - this.atomPos[i20];
                fExp += this.amplitude * ATOM_SCALE[i20] * this.atomJitter[i20] * this.atomFade[i20] * fExp2 * ((float) Math.exp((-(f16 * f16)) / 0.00605f));
            }
            float fI = C5685n.i(fExp * ((this.textureCurrent[i18] * 0.3f) + 0.85f) * f12 * HEIGHT_BOOST, f13);
            float[] fArr2 = this.columnHeights;
            float f17 = fArr2[i18];
            fArr2[i18] = f17 + ((fI - f17) * COL_SMOOTH_K);
            i18++;
            i10 = 0;
        }
    }

    public final float h(int ageMs, int lifetimeMs) {
        if (ageMs < 150) {
            return C5685n.m(ageMs / F.GESTURE_HEIGHT_DP, 0.0f, 1.0f);
        }
        if (ageMs > lifetimeMs - 150) {
            return C5685n.m((lifetimeMs - ageMs) / F.GESTURE_HEIGHT_DP, 0.0f, 1.0f);
        }
        return 1.0f;
    }

    public final float i(int col, int cols) {
        return col < 6 ? SAFE_ZONE_ALPHAS_F[col] : col >= cols + (-6) ? SAFE_ZONE_ALPHAS_F[(cols - 1) - col] : (float) Math.pow((float) Math.sin((col / (cols - 1.0f)) * 3.141592653589793d), EDGE_POWER);
    }

    public final void j(short[] pcm) {
        p.i(pcm, "pcm");
        if (!this.started || this.frozen) {
            return;
        }
        this.latestRms = n(pcm);
    }

    public final void k() {
        if (this.started) {
            this.frozen = true;
        }
    }

    public final float l(float xNorm) {
        float f10 = xNorm - 0.5f;
        return (float) Math.exp((-(f10 * f10)) / 0.605f);
    }

    public final float m(float rms) {
        if (rms <= NOISE_FLOOR) {
            return 0.0f;
        }
        return C5685n.m(((float) Math.pow(rms - NOISE_FLOOR, 0.35f)) * 3.0f, 0.0f, 1.0f);
    }

    public final float n(short[] samples) {
        if (samples.length == 0) {
            return 0.0f;
        }
        double d10 = 0.0d;
        for (double d11 : samples) {
            d10 += d11 * d11;
        }
        return C5685n.m((float) (Math.sqrt(d10 / samples.length) / 32768.0d), 0.0f, 1.0f);
    }

    public final int o() {
        return (int) (((long) (Math.random() * 500)) + ATOM_LIFETIME_MS_MIN);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        u();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.choreographer.removeFrameCallback(this.frameCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.view.DotWaveVoiceView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        q(w10, h10);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        u();
    }

    public final float p() {
        return C5685n.m((((((((float) Math.random()) + ((float) Math.random())) + ((float) Math.random())) / 3.0f) - 0.5f) * 0.7f) + 0.5f, ATOM_SPAWN_POS_MIN, 0.78f);
    }

    public final void q(int w10, int h10) {
        if (w10 <= 0 || h10 <= 0) {
            return;
        }
        int iF = C5685n.f((w10 - getPaddingLeft()) - getPaddingRight(), 0);
        int iF2 = C5685n.f((h10 - getPaddingTop()) - getPaddingBottom(), 0);
        if (iF == 0 || iF2 == 0) {
            return;
        }
        float f10 = iF / 39.0f;
        this.stepH = f10;
        float f11 = iF2 / 6.0f;
        this.stepV = f11;
        float fMin = Math.min(f10, f11) * 0.55f;
        this.dotSize = fMin;
        this.cornerR = fMin * 0.15f;
        this.gridOriginX = getPaddingLeft();
        this.gridOriginY = getPaddingTop();
        if (40 != this.cols) {
            this.cols = 40;
            this.columnHeights = new float[40];
            float[] fArr = new float[40];
            for (int i10 = 0; i10 < 40; i10++) {
                fArr[i10] = w(i10);
            }
            this.textureCurrent = fArr;
            int i11 = this.cols;
            float[] fArr2 = new float[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                fArr2[i12] = w(this.cols + i12);
            }
            this.textureTarget = fArr2;
            int i13 = this.cols;
            boolean[] zArr = new boolean[i13];
            for (int i14 = 0; i14 < i13; i14++) {
                zArr[i14] = true;
            }
            this.topMask = zArr;
            int i15 = this.cols;
            boolean[] zArr2 = new boolean[i15];
            for (int i16 = 0; i16 < i15; i16++) {
                zArr2[i16] = true;
            }
            this.bottomMask = zArr2;
            int i17 = this.cols;
            float[] fArr3 = new float[i17];
            for (int i18 = 0; i18 < i17; i18++) {
                fArr3[i18] = i(i18, this.cols);
            }
            this.colFade = fArr3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r() {
        /*
            r7 = this;
            int r0 = r7.cols
            r1 = 0
            r2 = r1
        L4:
            if (r2 >= r0) goto L4e
            r3 = 1
            if (r2 <= 0) goto L1e
            boolean[] r4 = r7.topMask
            int r5 = r2 + (-1)
            boolean r6 = r4[r5]
            if (r6 == 0) goto L17
            boolean[] r6 = r7.bottomMask
            boolean r5 = r6[r5]
            if (r5 != 0) goto L1e
        L17:
            r4[r2] = r3
            boolean[] r4 = r7.bottomMask
            r4[r2] = r3
            goto L4b
        L1e:
            double r4 = java.lang.Math.random()
            float r4 = (float) r4
            r5 = 1050253722(0x3e99999a, float:0.3)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 >= 0) goto L33
            boolean[] r4 = r7.topMask
            r4[r2] = r1
            boolean[] r4 = r7.bottomMask
            r4[r2] = r3
            goto L4b
        L33:
            r5 = 1058642330(0x3f19999a, float:0.6)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L43
            boolean[] r4 = r7.topMask
            r4[r2] = r3
            boolean[] r3 = r7.bottomMask
            r3[r2] = r1
            goto L4b
        L43:
            boolean[] r4 = r7.topMask
            r4[r2] = r3
            boolean[] r4 = r7.bottomMask
            r4[r2] = r3
        L4b:
            int r2 = r2 + 1
            goto L4
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.view.DotWaveVoiceView.r():void");
    }

    public final void s() {
        this.latestRms = 0.0f;
        this.amplitude = 0.0f;
        this.lastTextureRetargetMs = 0L;
        this.lastMaskRetargetMs = 0L;
        long jNanoTime = System.nanoTime() / 1000000;
        for (int i10 = 0; i10 < 3; i10++) {
            this.atomPos[i10] = p();
            this.atomJitter[i10] = (((float) Math.random()) * 0.3f) + 0.7f;
            this.atomLifetimeMs[i10] = o();
            this.atomBirthMs[i10] = jNanoTime - ((long) ((i10 / 3) * this.atomLifetimeMs[i10]));
            this.atomFade[i10] = 1.0f;
        }
        int i11 = this.cols;
        for (int i12 = 0; i12 < i11; i12++) {
            this.columnHeights[i12] = 0.0f;
            this.textureCurrent[i12] = w(i12);
            this.textureTarget[i12] = w(this.cols + i12);
        }
        r();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        u();
    }

    public final void t(int i10, long nowMs) {
        this.atomPos[i10] = p();
        this.atomJitter[i10] = (((float) Math.random()) * 0.3f) + 0.7f;
        this.atomLifetimeMs[i10] = o();
        this.atomBirthMs[i10] = nowMs;
    }

    public final void u() {
        if (this.started && isShown()) {
            this.pausedForVisibility = false;
            this.choreographer.removeFrameCallback(this.frameCallback);
            this.choreographer.postFrameCallback(this.frameCallback);
        }
    }

    public final void v() {
        this.frozen = false;
    }

    public final float w(int seed) {
        return (((int) (((seed * 1103515245) + 12345) & 2147483647L)) % 10000) / 10000.0f;
    }

    public final void x() {
        if (this.started) {
            s();
            invalidate();
        } else {
            this.started = true;
            this.frozen = false;
            s();
            this.choreographer.postFrameCallback(this.frameCallback);
        }
    }

    public final void y() {
        if (this.started) {
            this.started = false;
            this.frozen = false;
            this.choreographer.removeFrameCallback(this.frameCallback);
            s();
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DotWaveVoiceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        float f10 = context.getResources().getDisplayMetrics().density;
        this.density = f10;
        this.rows = 7;
        this.centerRow = 7 / 2;
        int i11 = (int) (14.0f * f10);
        int i12 = (int) (f10 * 16.0f);
        setPadding(i11, i12, i11, i12);
        this.columnHeights = new float[0];
        this.textureCurrent = new float[0];
        this.textureTarget = new float[0];
        this.atomPos = new float[3];
        this.atomJitter = new float[3];
        this.atomBirthMs = new long[3];
        this.atomLifetimeMs = new int[3];
        this.atomFade = new float[3];
        this.topMask = new boolean[0];
        this.bottomMask = new boolean[0];
        this.colFade = new float[0];
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.paint = paint;
        this.rectF = new RectF();
        this.choreographer = Choreographer.getInstance();
        this.frameCallback = new b();
    }

    public /* synthetic */ DotWaveVoiceView(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
