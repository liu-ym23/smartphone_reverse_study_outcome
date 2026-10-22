package com.obric.oui.privacy.recyclerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import bg.h;
import com.bytedance.apm.constant.CommonKey;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.ttnet.org.chromium.net.PrivateKeyType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 p2\u00020\u0001:\u0001qB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b$\u0010\u0018J\u0017\u0010%\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b%\u0010\u0018J\u000f\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010\u001eJ\u000f\u0010'\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010\u001eJ\u000f\u0010(\u001a\u00020\fH\u0002¢\u0006\u0004\b(\u0010\u001eJ\u000f\u0010)\u001a\u00020\u001fH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u001fH\u0002¢\u0006\u0004\b+\u0010*R*\u00102\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u001f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u0010*\"\u0004\b0\u00101R\"\u00108\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u0010\u001cR*\u0010<\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00198\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00104\u001a\u0004\b:\u00106\"\u0004\b;\u0010\u001cR*\u0010@\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00198\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u00104\u001a\u0004\b>\u00106\"\u0004\b?\u0010\u001cR\u0016\u0010B\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010.R\u0016\u0010D\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010.R\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010OR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010UR\u0016\u0010[\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010ZR\u0016\u0010_\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010.R\u0016\u0010a\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010.R\u0016\u0010c\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010.R\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010.R\u0016\u0010k\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010.R\u0016\u0010m\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u00104R\u0016\u0010o\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u00104¨\u0006r"}, d2 = {"Lcom/obric/oui/privacy/recyclerview/PrivacyTopDownAlphaMaskRecyclerView;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthSpec", "heightSpec", "", "onMeasure", "(II)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "", "animate", "G1", "(Z)V", "onDetachedFromWindow", "()V", "", "targetTop", "targetBottom", "w1", "(FF)V", "A1", "z1", "C1", "F1", "D1", "B1", "()F", "y1", CommonKey.KEY_VALUE, "Q0", "F", "getFadeEdgeLength", "setFadeEdgeLength", "(F)V", "fadeEdgeLength", "R0", "Z", "getDynamicFade", "()Z", "setDynamicFade", "dynamicFade", "S0", "getFadeTop", "setFadeTop", "fadeTop", "T0", "getFadeBottom", "setFadeBottom", "fadeBottom", "U0", "topFadeStrength", "V0", "bottomFadeStrength", "Landroid/graphics/Paint;", "W0", "Landroid/graphics/Paint;", "fadePaint", "Landroid/graphics/PorterDuffXfermode;", "X0", "Landroid/graphics/PorterDuffXfermode;", "dstInXfermode", "Landroid/graphics/LinearGradient;", "Y0", "Landroid/graphics/LinearGradient;", "topShader", "Z0", "bottomShader", "Landroid/graphics/Matrix;", "a1", "Landroid/graphics/Matrix;", "topShaderMatrix", "b1", "bottomShaderMatrix", "c1", "I", "shaderWidth", "d1", "shaderHeight", "e1", "shaderFadeEdgeLength", "f1", "shaderTopStrength", "g1", "shaderBottomStrength", "Landroid/animation/ValueAnimator;", "h1", "Landroid/animation/ValueAnimator;", "animator", "i1", "lastTargetTopStrength", "j1", "lastTargetBottomStrength", "k1", "allowFadeUpdates", "l1", "detectStackTypeChanged", "m1", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacyTopDownAlphaMaskRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final b f16400m1 = null;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final float[] f16401n1 = null;
    public float Q0;
    public boolean R0;
    public boolean S0;
    public boolean T0;
    public float U0;
    public float V0;
    public final Paint W0;
    public final PorterDuffXfermode X0;
    public LinearGradient Y0;
    public LinearGradient Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public final Matrix f16402a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final Matrix f16403b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public int f16404c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int f16405d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public float f16406e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public float f16407f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public float f16408g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public ValueAnimator f16409h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public float f16410i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public float f16411j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f16412k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public boolean f16413l1;

    public static final class a extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrivacyTopDownAlphaMaskRecyclerView f16414a;

        public a(PrivacyTopDownAlphaMaskRecyclerView r10) {
            this.f16414a = r10;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r10, int r11) {
            q.g(r10, "recyclerView");
            if (r11 != 1) goto L6;
            PrivacyTopDownAlphaMaskRecyclerView.v1(this.f16414a, true);
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void b(RecyclerView r10, int r11, int r12) {
            q.g(r10, "recyclerView");
            if (PrivacyTopDownAlphaMaskRecyclerView.u1(this.f16414a) == true) goto L5;
            return;
        L5:
            this.f16414a.G1(true);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    static {
        f16400m1 = new b(null);
        f16401n1 = new float[]{0.0f, 1.0f};
    }

    @JvmOverloads
    public PrivacyTopDownAlphaMaskRecyclerView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final void E1(PrivacyTopDownAlphaMaskRecyclerView r10) {
        q.g(r10, "this$0");
        if (r10.R0 == false) goto L5;
        r10.f16412k1 = false;
        r10.G1(false);
        return;
    L5:
        r10.U0 = 1.0f;
        r10.V0 = 1.0f;
        r10.D1();
        r10.invalidate();
    }

    public static /* synthetic */ void s1(PrivacyTopDownAlphaMaskRecyclerView r10, float r11, float r12, float r13, float r14, ValueAnimator r15) {
        x1(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ void t1(PrivacyTopDownAlphaMaskRecyclerView r10) {
        E1(r10);
    }

    public static final /* synthetic */ boolean u1(PrivacyTopDownAlphaMaskRecyclerView r10) {
        return r10.f16412k1;
    }

    public static final /* synthetic */ void v1(PrivacyTopDownAlphaMaskRecyclerView r10, boolean r11) {
        r10.f16412k1 = r11;
    }

    public static final void x1(PrivacyTopDownAlphaMaskRecyclerView r10, float r11, float r12, float r13, float r14, ValueAnimator r15) {
        q.g(r10, "this$0");
        q.g(r15, "anim");
        Object r16 = r15.getAnimatedValue();
        if (r16 == null) goto L7;
        float r17 = ((Float) r16).floatValue();
        r10.U0 = r11 + ((r12 - r11) * r17);
        r10.V0 = r13 + ((r14 - r13) * r17);
        r10.D1();
        r10.invalidate();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public final void A1(Canvas r10) {
        float r11 = B1();
        if (r11 > 0.0f) goto L5;
        return;
    L5:
        LinearGradient r12 = this.Y0;
        if (r12 != null) goto L8;
        return;
    L8:
        this.f16402a1.reset();
        r12.setLocalMatrix(this.f16402a1);
        this.W0.setShader(r12);
        r10.drawRect(0.0f, 0.0f, getWidth(), r11, this.W0);
    }

    public final float B1() {
        return h.f(this.Q0, getHeight());
    }

    public final void C1() {
        if (this.f16404c1 == getWidth()) goto L5;
    L13:
        F1();
        return;
    L5:
        if (this.f16405d1 != getHeight()) goto L13;
        if (this.f16406e1 != this.Q0) goto L13;
        if (this.f16407f1 != this.U0) goto L13;
        if (this.f16408g1 != this.V0) goto L13;
    }

    public final void D1() {
        this.f16404c1 = -1;
        this.f16405d1 = -1;
        this.f16406e1 = -1.0f;
        this.f16407f1 = Float.NaN;
        this.f16408g1 = Float.NaN;
        this.Y0 = null;
        this.Z0 = null;
    }

    public final void F1() {
        this.f16404c1 = getWidth();
        this.f16405d1 = getHeight();
        this.f16406e1 = this.Q0;
        this.f16407f1 = this.U0;
        this.f16408g1 = this.V0;
        float r10 = B1();
        LinearGradient r11 = null;
        if (getWidth() > 0) goto L5;
    L22:
        this.Y0 = null;
        this.Z0 = null;
        return;
    L5:
        if (getHeight() <= 0) goto L22;
        if (r10 <= 0.0f) goto L22;
        float r12 = h.j(this.U0, 0.0f, 1.0f);
        float r13 = h.j(this.V0, 0.0f, 1.0f);
        int r14 = h.k((int) ((1.0f - r12) * 255.0f), 0, PrivateKeyType.INVALID);
        int r15 = h.k((int) ((1.0f - r13) * 255.0f), 0, PrivateKeyType.INVALID);
        if (r12 > 0.0f) goto L12;
    L14:
        LinearGradient r16 = null;
    L15:
        this.Y0 = r16;
        if (r13 > 0.0f) goto L18;
    L20:
        this.Z0 = r11;
        return;
    L18:
        if (this.Z0 != null) goto L20;
        r11 = new LinearGradient(0.0f, r10, 0.0f, 0.0f, new int[]{Color.argb(r15, 0, 0, 0), Color.argb(PrivateKeyType.INVALID, 0, 0, 0)}, f16401n1, Shader.TileMode.CLAMP);
        goto L20
    L12:
        if (this.Y0 != null) goto L14;
        r16 = new LinearGradient(0.0f, 0.0f, 0.0f, r10, new int[]{Color.argb(r14, 0, 0, 0), Color.argb(PrivateKeyType.INVALID, 0, 0, 0)}, f16401n1, Shader.TileMode.CLAMP);
        goto L15
    }

    public final void G1(boolean r10) {
        boolean r11 = canScrollVertically(-1);
        boolean r12 = canScrollVertically(1);
        float r13 = 0.0f;
        if (this.S0 == false) goto L6;
        if (r11 == false) goto L6;
        float r14 = 1.0f;
    L8:
        if (this.T0 == false) goto L11;
        if (r12 == false) goto L11;
        r13 = 1.0f;
    L11:
        if (r10 == true) goto L13;
        this.f16410i1 = r14;
        this.f16411j1 = r13;
        this.U0 = r14;
        this.V0 = r13;
        D1();
        invalidate();
        return;
    L13:
        if (this.f16410i1 == r14) goto L15;
    L17:
        this.f16410i1 = r14;
        this.f16411j1 = r13;
        w1(r14, r13);
        return;
    L15:
        if (this.f16411j1 != r13) goto L17;
        return;
    L6:
        r14 = 0.0f;
        goto L8
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas r10) {
        q.g(r10, "canvas");
        if (getWidth() > 0) goto L5;
    L31:
        super.draw(r10);
        return;
    L5:
        if (getHeight() <= 0) goto L31;
        if (this.Q0 <= 0.0f) goto L31;
        if (this.S0 == true) goto L14;
        if (this.T0 == true) goto L14;
    L17:
        super.draw(r10);
        return;
    L14:
        if (this.U0 <= 0.0f) goto L16;
    L19:
        C1();
        int r11 = r10.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.draw(r10);
        this.W0.setXfermode(this.X0);
        if (this.S0 == false) goto L25;
        if (this.U0 <= 0.0f) goto L25;
        A1(r10);
    L25:
        if (this.T0 == true) goto L27;
    L29:
        this.W0.setXfermode(null);
        this.W0.setShader(null);
        r10.restoreToCount(r11);
        return;
    L27:
        if (this.V0 <= 0.0f) goto L29;
        z1(r10);
        goto L29
    L16:
        if (this.V0 > 0.0f) goto L19;
        goto L17
    }

    public final boolean getDynamicFade() {
        return this.R0;
    }

    public final boolean getFadeBottom() {
        return this.T0;
    }

    public final float getFadeEdgeLength() {
        return this.Q0;
    }

    public final boolean getFadeTop() {
        return this.S0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r10 = this.f16409h1;
        if (r10 == null) goto L6;
        r10.cancel();
    L6:
        removeCallbacks(null);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if ((getLayoutManager() instanceof LinearLayoutManager) == true) goto L5;
        return;
    L5:
        if (this.f16413l1 == false) goto L27;
        int r12 = computeVerticalScrollRange();
        if (r12 <= 0) goto L28;
        int r13 = 0;
        this.f16413l1 = false;
        if (r12 > ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom())) goto L11;
        boolean r14 = true;
    L12:
        RecyclerView.LayoutManager r15 = getLayoutManager();
        if (r15 == null) goto L25;
        if (((LinearLayoutManager) r15).Z1() == r14) goto L21;
        RecyclerView.LayoutManager r16 = getLayoutManager();
        if (r16 == null) goto L20;
        ((LinearLayoutManager) r16).o2(r14);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
    L21:
        if (r14 == false) goto L23;
        r13 = 2;
    L23:
        setOverScrollMode(r13);
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
    L11:
        r14 = false;
        goto L12
    L28:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        D1();
        post(new kd.a(this));
    }

    public final void setDynamicFade(boolean r10) {
        this.R0 = r10;
    }

    public final void setFadeBottom(boolean r10) {
        if (this.T0 != r10) goto L5;
        return;
    L5:
        this.T0 = r10;
        invalidate();
    }

    public final void setFadeEdgeLength(float r10) {
        float r11 = h.c(r10, 0.0f);
        if (this.Q0 != r11) goto L5;
        return;
    L5:
        this.Q0 = r11;
        D1();
        invalidate();
    }

    public final void setFadeTop(boolean r10) {
        if (this.S0 != r10) goto L5;
        return;
    L5:
        this.S0 = r10;
        invalidate();
    }

    public final void w1(final float r10, final float r11) {
        final float r12 = this.U0;
        final float r13 = this.V0;
        if (r12 == r10) goto L5;
    L7:
        ValueAnimator r14 = this.f16409h1;
        if (r14 == null) goto L11;
        r14.cancel();
    L11:
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r15.setDuration(100);
        r15.addUpdateListener(new kd.b(this, r12, r10, r13, r11));
        this.f16409h1 = r15;
        r15.start();
        return;
    L5:
        if (r13 != r11) goto L7;
    }

    public final float y1() {
        return TypedValue.applyDimension(1, 75.0f, getResources().getDisplayMetrics());
    }

    public final void z1(Canvas r10) {
        float r11 = B1();
        if (r11 > 0.0f) goto L5;
        return;
    L5:
        float r12 = getHeight();
        float r13 = h.c(r12 - r11, 0.0f);
        LinearGradient r14 = this.Z0;
        if (r14 != null) goto L8;
        return;
    L8:
        this.f16403b1.reset();
        this.f16403b1.setTranslate(0.0f, r13);
        r14.setLocalMatrix(this.f16403b1);
        this.W0.setShader(r14);
        r10.drawRect(0.0f, r13, getWidth(), r12, this.W0);
    }

    @JvmOverloads
    public PrivacyTopDownAlphaMaskRecyclerView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ PrivacyTopDownAlphaMaskRecyclerView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public PrivacyTopDownAlphaMaskRecyclerView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.Q0 = y1();
        this.R0 = true;
        this.S0 = true;
        this.T0 = true;
        this.W0 = new Paint(1);
        this.X0 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f16402a1 = new Matrix();
        this.f16403b1 = new Matrix();
        this.f16404c1 = -1;
        this.f16405d1 = -1;
        this.f16406e1 = -1.0f;
        this.f16407f1 = Float.NaN;
        this.f16408g1 = Float.NaN;
        this.f16413l1 = true;
        if (this.R0 == false) goto L6;
        addOnScrollListener(new a(this));
        return;
    }
}
