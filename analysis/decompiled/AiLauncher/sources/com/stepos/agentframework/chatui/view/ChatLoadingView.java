package com.stepos.agentframework.chatui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$color;
import com.stepos.agentframework.R$drawable;
import com.stepos.agentframework.R$raw;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.display.k;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import s.C5423E;
import t0.C5502d;

@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n*\u0001R\u0018\u00002\u00020\u0001:\u0001cB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b!\u0010\u001cJ\u0017\u0010$\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0015¢\u0006\u0004\b'\u0010\u0018J\r\u0010(\u001a\u00020\n¢\u0006\u0004\b(\u0010\fJ\r\u0010)\u001a\u00020\n¢\u0006\u0004\b)\u0010\fJ\u000f\u0010*\u001a\u00020\nH\u0002¢\u0006\u0004\b*\u0010\fJ\u000f\u0010+\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010\fJ\u000f\u0010,\u001a\u00020\nH\u0002¢\u0006\u0004\b,\u0010\fJ\u000f\u0010-\u001a\u00020\nH\u0002¢\u0006\u0004\b-\u0010\fJ\u000f\u0010.\u001a\u00020\nH\u0002¢\u0006\u0004\b.\u0010\fJ\u000f\u0010/\u001a\u00020\nH\u0002¢\u0006\u0004\b/\u0010\fJ\u000f\u00100\u001a\u00020\nH\u0002¢\u0006\u0004\b0\u0010\fJ\u000f\u00101\u001a\u00020\nH\u0002¢\u0006\u0004\b1\u0010\fJ\u000f\u00102\u001a\u00020\nH\u0002¢\u0006\u0004\b2\u0010\fJ\u000f\u00103\u001a\u00020\nH\u0002¢\u0006\u0004\b3\u0010\fJ\u0017\u00105\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010;\u001a\u00060:R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u001e\u0010L\u001a\n\u0018\u00010Jj\u0004\u0018\u0001`K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001e\u0010N\u001a\n\u0018\u00010Jj\u0004\u0018\u0001`K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010MR\u0016\u0010O\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010FR\u0016\u0010P\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010FR\u001e\u0010V\u001a\n\u0018\u00010Jj\u0004\u0018\u0001`K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010MR\u0016\u0010W\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010QR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010]\u001a\u0002048\u0002X\u0082D¢\u0006\u0006\n\u0004\b]\u0010XR\u0014\u0010^\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b^\u0010QR\u0014\u0010_\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010`R\u0014\u0010b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010`¨\u0006d"}, d2 = {"Lcom/stepos/agentframework/chatui/view/ChatLoadingView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "onWindowVisibilityChanged", "(I)V", "", UxipConstants.f30680s, "setInGroup", "(Z)V", "", "text", "setStatusText", "(Ljava/lang/CharSequence;)V", "", "startAtMs", "setProcessingStartTime", "(J)V", "setToolText", "Landroid/view/View$OnClickListener;", "listener", "setOnToolClickListener", "(Landroid/view/View$OnClickListener;)V", "expanded", "setArrowExpanded", "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "t", "k", "p", "s", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "n", "r", "u", "o", "q", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(F)I", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/stepos/agentframework/chatui/view/ChatLoadingView$a;", "tvStatus", "Lcom/stepos/agentframework/chatui/view/ChatLoadingView$a;", "divider", "Landroid/view/View;", "Landroid/widget/TextView;", "tvTool", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "ivArrow", "Landroid/widget/ImageView;", "inGroup", "Z", "Landroid/animation/ValueAnimator;", "shimmerAnimator", "Landroid/animation/ValueAnimator;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "refreshLease", "Ljava/lang/AutoCloseable;", "waitModeListener", "desiredPlaying", "processingStartAtMs", "J", "com/stepos/agentframework/chatui/view/ChatLoadingView$b", "processingTicker", "Lcom/stepos/agentframework/chatui/view/ChatLoadingView$b;", "waitDriving", "waitClockToken", "waitShimmerProgress", "F", "lastProcessingTextAtMs", "Lcom/stepos/agentframework/display/k$a;", "waitFrameTick", "Lcom/stepos/agentframework/display/k$a;", "shimmerBandRatio", "shimmerDurationMs", "shimmerBaseColor", "I", "shimmerDimColor", "shimmerHighlightColor", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChatLoadingView extends LinearLayout {
    private boolean desiredPlaying;
    private final View divider;
    private boolean inGroup;
    private final ImageView ivArrow;
    private long lastProcessingTextAtMs;
    private final LottieAnimationView lottieView;
    private long processingStartAtMs;
    private final b processingTicker;
    private AutoCloseable refreshLease;
    private ValueAnimator shimmerAnimator;
    private final float shimmerBandRatio;
    private final int shimmerBaseColor;
    private final int shimmerDimColor;
    private final long shimmerDurationMs;
    private final int shimmerHighlightColor;
    private final a tvStatus;
    private final TextView tvTool;
    private AutoCloseable waitClockToken;
    private boolean waitDriving;
    private final k.a waitFrameTick;
    private AutoCloseable waitModeListener;
    private float waitShimmerProgress;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014¨\u0006 "}, d2 = {"Lcom/stepos/agentframework/chatui/view/ChatLoadingView$a;", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "<init>", "(Lcom/stepos/agentframework/chatui/view/ChatLoadingView;Landroid/content/Context;)V", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "onDraw", "(Landroid/graphics/Canvas;)V", "", "shimmerEnabled", "Z", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "(Z)V", "", "shimmerProgress", "F", "getShimmerProgress", "()F", "c", "(F)V", "Landroid/graphics/Matrix;", "shimmerMatrix", "Landroid/graphics/Matrix;", "Landroid/graphics/LinearGradient;", "gradient", "Landroid/graphics/LinearGradient;", "gradientWidth", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class a extends TextView {
        private LinearGradient gradient;
        private float gradientWidth;
        private boolean shimmerEnabled;
        private final Matrix shimmerMatrix;
        private float shimmerProgress;
        final /* synthetic */ ChatLoadingView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ChatLoadingView chatLoadingView, Context context) {
            super(context);
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0 = chatLoadingView;
            this.shimmerMatrix = new Matrix();
        }

        /* renamed from: a, reason: from getter */
        public final boolean getShimmerEnabled() {
            return this.shimmerEnabled;
        }

        public final void b(boolean z10) {
            this.shimmerEnabled = z10;
        }

        public final void c(float f10) {
            this.shimmerProgress = f10;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            float fMeasureText;
            kotlin.jvm.internal.p.i(canvas, "canvas");
            if (this.shimmerEnabled) {
                TextPaint paint = getPaint();
                CharSequence text = getText();
                String string = text != null ? text.toString() : null;
                if (string == null) {
                    string = "";
                }
                fMeasureText = paint.measureText(string);
            } else {
                fMeasureText = 0.0f;
            }
            if (!this.shimmerEnabled || fMeasureText <= 0.0f) {
                getPaint().setShader(null);
            } else {
                float f10 = fMeasureText * this.this$0.shimmerBandRatio;
                if (this.gradient == null || this.gradientWidth != fMeasureText) {
                    this.gradient = new LinearGradient(0.0f, 0.0f, f10, 0.0f, new int[]{this.this$0.shimmerDimColor, this.this$0.shimmerHighlightColor, this.this$0.shimmerDimColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.gradientWidth = fMeasureText;
                }
                float f11 = (-f10) + (this.shimmerProgress * (fMeasureText + (f10 * 2)));
                this.shimmerMatrix.reset();
                this.shimmerMatrix.setTranslate(f11, 0.0f);
                LinearGradient linearGradient = this.gradient;
                if (linearGradient != null) {
                    linearGradient.setLocalMatrix(this.shimmerMatrix);
                }
                getPaint().setShader(this.gradient);
            }
            super.onDraw(canvas);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/agentframework/chatui/view/ChatLoadingView$b", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatLoadingView.this.processingStartAtMs <= 0) {
                return;
            }
            ChatLoadingView.this.u();
            ChatLoadingView.this.postDelayed(this, 1000L);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChatLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final Y8.t l(ChatLoadingView chatLoadingView) throws Exception {
        chatLoadingView.t();
        return Y8.t.f7040a;
    }

    public static final void v(ChatLoadingView chatLoadingView, long j10) {
        if (chatLoadingView.waitDriving && chatLoadingView.desiredPlaying && chatLoadingView.isAttachedToWindow() && chatLoadingView.isShown()) {
            chatLoadingView.h();
            if (chatLoadingView.processingStartAtMs > 0 && j10 - chatLoadingView.lastProcessingTextAtMs >= 1000) {
                chatLoadingView.lastProcessingTextAtMs = j10;
                chatLoadingView.u();
            }
            M6.c.INSTANCE.r();
        }
    }

    public final void h() {
        Float fValueOf = Float.valueOf(this.lottieView.getDuration());
        if (fValueOf.floatValue() <= 0.0f) {
            fValueOf = null;
        }
        float progress = this.lottieView.getProgress() + (33.0f / (fValueOf != null ? fValueOf.floatValue() : 2000.0f));
        if (progress >= 1.0f) {
            progress -= 1.0f;
        }
        this.lottieView.setProgress(progress);
        float f10 = this.waitShimmerProgress + (33.0f / this.shimmerDurationMs);
        this.waitShimmerProgress = f10;
        if (f10 >= 1.0f) {
            this.waitShimmerProgress = f10 - 1.0f;
        }
        this.tvStatus.c(this.waitShimmerProgress);
        this.tvStatus.invalidate();
    }

    public final void i() throws Exception {
        this.desiredPlaying = false;
        t();
    }

    public final int j(float value) {
        return (int) TypedValue.applyDimension(1, value, getResources().getDisplayMetrics());
    }

    public final void k() throws Exception {
        n();
        if (this.waitDriving) {
            p();
            return;
        }
        this.waitDriving = true;
        M6.c.INSTANCE.j("wait30", true);
        this.lottieView.pauseAnimation();
        r();
        this.tvStatus.b(true);
        p();
    }

    public final void m() throws Exception {
        this.desiredPlaying = true;
        t();
    }

    public final void n() throws Exception {
        AutoCloseable autoCloseable = this.refreshLease;
        if (autoCloseable != null) {
            C5423E.a(autoCloseable);
        }
        this.refreshLease = null;
    }

    public final void o() {
        if (this.processingStartAtMs > 0 && !this.waitDriving) {
            removeCallbacks(this.processingTicker);
            u();
            postDelayed(this.processingTicker, 1000L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() throws Exception {
        super.onAttachedToWindow();
        AutoCloseable autoCloseable = this.waitModeListener;
        if (autoCloseable != null) {
            C5423E.a(autoCloseable);
        }
        this.waitModeListener = com.stepos.agentframework.display.j.INSTANCE.i(this, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatLoadingView.l(this.f23124a);
            }
        });
        t();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() throws Exception {
        super.onDetachedFromWindow();
        AutoCloseable autoCloseable = this.waitModeListener;
        if (autoCloseable != null) {
            C5423E.a(autoCloseable);
        }
        this.waitModeListener = null;
        s();
        this.lottieView.cancelAnimation();
        r();
        q();
        n();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) throws Exception {
        kotlin.jvm.internal.p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        t();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) throws Exception {
        super.onWindowVisibilityChanged(visibility);
        t();
    }

    public final void p() {
        if (this.waitDriving && this.waitClockToken == null) {
            this.lastProcessingTextAtMs = 0L;
            this.waitClockToken = com.stepos.agentframework.display.k.INSTANCE.e(this.waitFrameTick);
        }
    }

    public final void q() {
        removeCallbacks(this.processingTicker);
    }

    public final void r() {
        boolean z10 = this.shimmerAnimator != null || this.tvStatus.getShimmerEnabled();
        ValueAnimator valueAnimator = this.shimmerAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.shimmerAnimator = null;
        this.tvStatus.b(false);
        this.tvStatus.c(0.0f);
        if (z10) {
            this.tvStatus.invalidate();
        }
    }

    public final void s() throws Exception {
        this.waitDriving = false;
        AutoCloseable autoCloseable = this.waitClockToken;
        if (autoCloseable != null) {
            C5423E.a(autoCloseable);
        }
        this.waitClockToken = null;
    }

    public final void setArrowExpanded(boolean expanded) {
        this.ivArrow.setImageResource(expanded ? R$drawable.ic_mcp_expanded : R$drawable.ic_mcp_collapsed);
    }

    public final void setInGroup(boolean value) {
        if (this.inGroup == value) {
            return;
        }
        this.inGroup = value;
        if (value) {
            setBackground(null);
            setPadding(0, j(4.0f), 0, j(4.0f));
        } else {
            int iJ = j(8.0f);
            int iJ2 = j(2.0f);
            setPadding(iJ, iJ2, iJ, iJ2);
        }
    }

    public final void setOnToolClickListener(View.OnClickListener listener) {
        this.ivArrow.setOnClickListener(listener);
        this.tvTool.setOnClickListener(listener);
    }

    public final void setProcessingStartTime(long startAtMs) {
        if (this.processingStartAtMs == startAtMs) {
            return;
        }
        this.processingStartAtMs = startAtMs;
        if (startAtMs <= 0) {
            q();
            return;
        }
        u();
        if (isAttachedToWindow() && isShown()) {
            o();
        }
    }

    public final void setStatusText(CharSequence text) {
        this.tvStatus.setText(text);
        this.tvStatus.setVisibility((text == null || text.length() == 0) ? 8 : 0);
    }

    public final void setToolText(CharSequence text) {
        boolean z10 = text == null || text.length() == 0;
        this.tvTool.setText(text);
        int i10 = z10 ? 8 : 0;
        this.tvTool.setVisibility(i10);
        this.divider.setVisibility(i10);
        this.ivArrow.setVisibility(i10);
    }

    public final void t() throws Exception {
        boolean z10 = isAttachedToWindow() && isShown();
        if (this.desiredPlaying && z10) {
            k();
        } else {
            s();
            this.lottieView.cancelAnimation();
            r();
            n();
        }
        if (this.processingStartAtMs <= 0 || !z10) {
            q();
        } else {
            o();
        }
    }

    public final void u() {
        if (this.processingStartAtMs <= 0) {
            return;
        }
        this.tvStatus.setText(getContext().getString(R$string.chat_processing_duration, C2082l.a(System.currentTimeMillis() - this.processingStartAtMs)));
        this.tvStatus.setVisibility(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLoadingView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.desiredPlaying = true;
        this.processingTicker = new b();
        this.waitFrameTick = new k.a() { // from class: com.stepos.agentframework.chatui.view.i
            @Override // com.stepos.agentframework.display.k.a
            public final void a(long j10) {
                ChatLoadingView.v(this.f23122a, j10);
            }
        };
        this.shimmerBandRatio = 0.35f;
        this.shimmerDurationMs = 1500L;
        int iC = androidx.core.content.a.c(context, R$color.chat_loading_status_text);
        this.shimmerBaseColor = iC;
        this.shimmerDimColor = C5502d.k(iC, 102);
        this.shimmerHighlightColor = iC;
        setOrientation(0);
        setGravity(16);
        int iJ = j(0.0f);
        int iJ2 = j(2.0f);
        setPadding(iJ, iJ2, iJ, iJ2);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(j(24.0f), j(24.0f));
        layoutParams.setMarginEnd(j(8.0f));
        lottieAnimationView.setLayoutParams(layoutParams);
        int iJ3 = j(2.5f);
        lottieAnimationView.setPadding(0, iJ3, iJ3, iJ3);
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setAnimation(R$raw.lottie_chat_loading);
        this.lottieView = lottieAnimationView;
        addView(lottieAnimationView);
        a aVar = new a(this, context);
        aVar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        aVar.setIncludeFontPadding(false);
        aVar.setSingleLine(true);
        aVar.setTypeface(Typeface.create("sans-serif", 0));
        aVar.setText(context.getString(R$string.chat_loading_thinking));
        aVar.setTextColor(iC);
        aVar.setTextSize(2, 14.0f);
        this.tvStatus = aVar;
        addView(aVar);
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(j(1.0f), j(12.0f));
        layoutParams2.setMarginStart(j(8.0f));
        layoutParams2.setMarginEnd(j(8.0f));
        view.setLayoutParams(layoutParams2);
        view.setBackgroundColor(androidx.core.content.a.c(context, R$color.chat_loading_divider));
        view.setVisibility(8);
        this.divider = view;
        addView(view);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setIncludeFontPadding(false);
        textView.setSingleLine(true);
        textView.setTypeface(Typeface.create("sans-serif", 0));
        textView.setText("搜索网页中");
        textView.setTextColor(androidx.core.content.a.c(context, R$color.chat_loading_tool_text));
        textView.setTextSize(2, 14.0f);
        textView.setVisibility(8);
        this.tvTool = textView;
        addView(textView);
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(j(12.0f), j(12.0f));
        layoutParams3.setMarginStart(j(4.0f));
        imageView.setLayoutParams(layoutParams3);
        imageView.setImageResource(R$drawable.ic_chat_loading_arrow);
        imageView.setVisibility(8);
        this.ivArrow = imageView;
        addView(imageView);
    }

    public /* synthetic */ ChatLoadingView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
