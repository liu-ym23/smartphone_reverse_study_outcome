package com.stepos.agentframework.chatui.view;

import Z8.C1174w;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$color;
import com.stepos.agentframework.display.k;
import io.ktor.http.LinkHeader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import s.C5423E;
import v9.C5685n;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 .2\u00020\u0001:\u0002/0B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010%\u001a\n\u0018\u00010#j\u0004\u0018\u0001`$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010'\u001a\n\u0018\u00010#j\u0004\u0018\u0001`$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/stepos/agentframework/chatui/view/u0;", "", "", "Landroid/widget/TextView;", "targets", "<init>", "(Ljava/util/List;)V", "LY8/t;", "e", "()V", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "fraction", Const.INTENT_KEY_UMID, "(F)V", "Ljava/util/List;", LinkHeader.Parameters.Anchor, "Landroid/widget/TextView;", "", "shimmerTextColor", "I", "dimColor", "highlightColor", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "", "Lcom/stepos/agentframework/chatui/view/u0$b;", "shaders", "Ljava/util/Map;", "", "running", "Z", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "waitClockToken", "Ljava/lang/AutoCloseable;", "waitModeListener", "", "waitPhaseBaseMs", "J", "Lcom/stepos/agentframework/display/k$a;", "waitFrameTick", "Lcom/stepos/agentframework/display/k$a;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class u0 {
    private static final a Companion = new a(null);

    @Deprecated
    public static final long DURATION_MS = 1500;
    private final TextView anchor;
    private ValueAnimator animator;
    private final int dimColor;
    private final int highlightColor;
    private boolean running;
    private final Map<TextView, b> shaders;
    private final int shimmerTextColor;
    private final List<TextView> targets;
    private AutoCloseable waitClockToken;
    private final k.a waitFrameTick;
    private AutoCloseable waitModeListener;
    private long waitPhaseBaseMs;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatui/view/u0$a;", "", "<init>", "()V", "", "DURATION_MS", "J", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/agentframework/chatui/view/u0$b;", "", "", "restingColor", "<init>", "(I)V", "I", "e", "()I", "", "applied", "Z", Const.INTENT_KEY_APIKEY, "()Z", "f", "(Z)V", "Landroid/graphics/LinearGradient;", "gradient", "Landroid/graphics/LinearGradient;", "c", "()Landroid/graphics/LinearGradient;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/graphics/LinearGradient;)V", "", "band", "F", Const.INTENT_KEY_PKGNAME, "()F", Const.INTENT_KEY_BACKGROUND_COMMAND, "(F)V", "Landroid/graphics/Matrix;", "matrix", "Landroid/graphics/Matrix;", Const.INTENT_KEY_UMID, "()Landroid/graphics/Matrix;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        private boolean applied;
        private LinearGradient gradient;
        private final int restingColor;
        private float band = -1.0f;
        private final Matrix matrix = new Matrix();

        public b(int i10) {
            this.restingColor = i10;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getApplied() {
            return this.applied;
        }

        /* renamed from: b, reason: from getter */
        public final float getBand() {
            return this.band;
        }

        /* renamed from: c, reason: from getter */
        public final LinearGradient getGradient() {
            return this.gradient;
        }

        /* renamed from: d, reason: from getter */
        public final Matrix getMatrix() {
            return this.matrix;
        }

        /* renamed from: e, reason: from getter */
        public final int getRestingColor() {
            return this.restingColor;
        }

        public final void f(boolean z10) {
            this.applied = z10;
        }

        public final void g(float f10) {
            this.band = f10;
        }

        public final void h(LinearGradient linearGradient) {
            this.gradient = linearGradient;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u0(List<? extends TextView> targets) {
        kotlin.jvm.internal.p.i(targets, "targets");
        this.targets = targets;
        TextView textView = (TextView) Z8.F.q0(targets);
        this.anchor = textView;
        this.shimmerTextColor = Color.argb(0.6f, 1.0f, 1.0f, 1.0f);
        this.dimColor = androidx.core.content.a.c(textView.getContext(), R$color.chat_tool_call_shimmer_dim);
        this.highlightColor = androidx.core.content.a.c(textView.getContext(), R$color.chat_tool_call_shimmer_highlight);
        List<? extends TextView> list = targets;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(obj, new b(((TextView) obj).getCurrentTextColor()));
        }
        this.shaders = linkedHashMap;
        this.waitFrameTick = new k.a() { // from class: com.stepos.agentframework.chatui.view.t0
            @Override // com.stepos.agentframework.display.k.a
            public final void a(long j10) {
                u0.k(this.f23144a, j10);
            }
        };
    }

    public static final Y8.t f(u0 u0Var) throws Exception {
        u0Var.i();
        return Y8.t.f7040a;
    }

    public static final void j(u0 u0Var, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        u0Var.d(((Float) animatedValue).floatValue());
    }

    public static final void k(u0 u0Var, long j10) {
        if (u0Var.waitPhaseBaseMs == 0) {
            u0Var.waitPhaseBaseMs = j10;
        }
        u0Var.d(((j10 - u0Var.waitPhaseBaseMs) % 1500) / 1500.0f);
    }

    public final void d(float fraction) {
        Iterator<T> it = this.targets.iterator();
        float fMax = 0.0f;
        while (it.hasNext()) {
            if (((TextView) it.next()).getVisibility() == 0) {
                fMax = Math.max(fMax, r3.getRight());
            }
        }
        if (fMax <= 0.0f) {
            return;
        }
        float f10 = fMax * 0.35f;
        float f11 = (-f10) + ((fMax + (2 * f10)) * fraction);
        for (TextView textView : this.targets) {
            if (textView.getVisibility() == 0) {
                b bVar = (b) kotlin.collections.a.j(this.shaders, textView);
                if (!bVar.getApplied()) {
                    textView.setTextColor(this.shimmerTextColor);
                    bVar.f(true);
                }
                if (bVar.getGradient() == null || bVar.getBand() != f10) {
                    int i10 = this.dimColor;
                    bVar.h(new LinearGradient(0.0f, 0.0f, f10, 0.0f, new int[]{i10, this.highlightColor, i10}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
                    bVar.g(f10);
                }
                bVar.getMatrix().setTranslate(f11 - textView.getLeft(), 0.0f);
                LinearGradient gradient = bVar.getGradient();
                if (gradient != null) {
                    gradient.setLocalMatrix(bVar.getMatrix());
                }
                textView.getPaint().setShader(bVar.getGradient());
                textView.invalidate();
            }
        }
    }

    public final void e() throws Exception {
        if (this.running) {
            return;
        }
        this.running = true;
        this.waitModeListener = com.stepos.agentframework.display.j.INSTANCE.i(this.anchor, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.r0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return u0.f(this.f23137a);
            }
        });
        i();
    }

    public final void g() throws Exception {
        this.running = false;
        AutoCloseable autoCloseable = this.waitModeListener;
        if (autoCloseable != null) {
            C5423E.a(autoCloseable);
        }
        this.waitModeListener = null;
        h();
        for (TextView textView : this.targets) {
            b bVar = (b) kotlin.collections.a.j(this.shaders, textView);
            if (textView.getPaint().getShader() != null) {
                textView.getPaint().setShader(null);
                textView.invalidate();
            }
            if (bVar.getApplied()) {
                textView.setTextColor(bVar.getRestingColor());
                bVar.f(false);
            }
        }
    }

    public final void h() throws Exception {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
        AutoCloseable autoCloseable = this.waitClockToken;
        if (autoCloseable != null) {
            C5423E.a(autoCloseable);
        }
        this.waitClockToken = null;
    }

    public final void i() throws Exception {
        if (this.running) {
            if (com.stepos.agentframework.display.j.INSTANCE.p(this.anchor)) {
                ValueAnimator valueAnimator = this.animator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.animator = null;
                if (this.waitClockToken == null) {
                    this.waitPhaseBaseMs = 0L;
                    this.waitClockToken = com.stepos.agentframework.display.k.INSTANCE.e(this.waitFrameTick);
                    return;
                }
                return;
            }
            AutoCloseable autoCloseable = this.waitClockToken;
            if (autoCloseable != null) {
                C5423E.a(autoCloseable);
            }
            this.waitClockToken = null;
            ValueAnimator valueAnimator2 = this.animator;
            if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.setDuration(1500L);
                valueAnimatorOfFloat.setRepeatCount(-1);
                valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.agentframework.chatui.view.s0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        u0.j(this.f23141a, valueAnimator3);
                    }
                });
                valueAnimatorOfFloat.start();
                this.animator = valueAnimatorOfFloat;
            }
        }
    }
}
