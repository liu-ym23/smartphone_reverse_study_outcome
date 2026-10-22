package com.obric.oui.texteffects;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import bg.h;
import com.bytedance.apm.constant.CommonKey;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$array;
import com.obric.common.oui.R$styleable;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.texteffects.core.Direction;
import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.runtime.ExternalViewLayerBinding;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.b0;
import kotlin.collections.y;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.q;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.channels.Channel;
import od.f;
import od.i;
import od.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001kB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\nH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010%J\u000f\u0010(\u001a\u00020\u001dH\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\nH\u0002¢\u0006\u0004\b*\u0010%J\u0017\u0010+\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b+\u0010\u001cJ\u0019\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020!2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b1\u00102J\u0013\u00104\u001a\u00020\u0006*\u000203H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020.2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\b;\u0010<J/\u0010@\u001a\u00020\n2\u0006\u0010=\u001a\u00020.2\u0006\u0010?\u001a\u00020>2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b@\u0010AJ!\u0010B\u001a\u0004\u0018\u00010!2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\bB\u0010CJ\u0015\u0010E\u001a\u0004\u0018\u00010!*\u00020DH\u0002¢\u0006\u0004\bE\u0010FJ\u001f\u0010H\u001a\u00020\u00062\u0006\u0010?\u001a\u00020>2\u0006\u0010G\u001a\u00020!H\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020!2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0006H\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010O\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020\u001dH\u0002¢\u0006\u0004\bO\u0010PJ\u001f\u0010T\u001a\u00020S2\u0006\u0010Q\u001a\u0002062\u0006\u0010R\u001a\u00020\u0006H\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\nH\u0014¢\u0006\u0004\bV\u0010%J\u0017\u0010W\u001a\u00020\n2\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\bW\u0010XJ\u0019\u0010Y\u001a\u00020\n2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\bY\u0010XJ\u0017\u0010Z\u001a\u00020\n2\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\bZ\u0010XJ\u0017\u0010[\u001a\u00020\n2\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b[\u0010XJ\u0015\u0010]\u001a\u00020\n2\u0006\u0010\\\u001a\u00020>¢\u0006\u0004\b]\u0010XJ\u0015\u0010_\u001a\u00020\n2\u0006\u0010^\u001a\u00020>¢\u0006\u0004\b_\u0010XJ\r\u0010`\u001a\u00020\n¢\u0006\u0004\b`\u0010%J\u0015\u0010b\u001a\u00020\n2\u0006\u0010a\u001a\u00020!¢\u0006\u0004\bb\u0010cJ\r\u0010d\u001a\u00020!¢\u0006\u0004\bd\u0010#J\u0015\u0010f\u001a\u00020\n2\u0006\u0010e\u001a\u00020S¢\u0006\u0004\bf\u0010gJ\u0015\u0010h\u001a\u00020\n2\u0006\u0010e\u001a\u00020S¢\u0006\u0004\bh\u0010gJ\u0015\u0010i\u001a\u00020\n2\u0006\u0010e\u001a\u00020S¢\u0006\u0004\bi\u0010gR\u0017\u0010o\u001a\u00020j8\u0006¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u0017\u0010t\u001a\u00020.8\u0006¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u0017\u0010w\u001a\u00020.8\u0006¢\u0006\f\n\u0004\bu\u0010q\u001a\u0004\bv\u0010sR\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020y0x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001b\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001f\u0010\u0082\u0001R\u001b\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0013\u0010\u0082\u0001R\u0017\u0010\u0085\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010`R#\u0010\u0088\u0001\u001a\u000f\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00060\u0086\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000f\u0010\u0087\u0001R\u0013\u0010\u008a\u0001\u001a\u00020.8F¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010s¨\u0006\u008b\u0001"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointGenerateEffectView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "h", "(Landroid/util/AttributeSet;I)V", "typefaceValue", "textStyle", "i", "(II)V", "Landroid/content/res/TypedArray;", "typedArray", "g", "(Landroid/content/res/TypedArray;)V", CommonKey.KEY_VALUE, "Landroid/text/TextUtils$TruncateAt;", "s", "(I)Landroid/text/TextUtils$TruncateAt;", "Lod/k;", "spec", FixCard.FixStyle.KEY_Y, "(Lod/k;)V", "", "playTimeMs", "f", "(Lod/k;J)V", "", "v", "()F", "G", "()V", "n", "m", "t", "()J", "u", "j", "", "bindingKey", "Landroid/view/View;", "M", "(Ljava/lang/String;)Landroid/view/View;", "I", "(Ljava/lang/String;)F", "Lcom/obric/oui/texteffects/core/Direction;", "K", "(Lcom/obric/oui/texteffects/core/Direction;)I", "", "enter", "r", "(Z)Landroid/view/View;", "Landroid/widget/FrameLayout$LayoutParams;", "k", "()Landroid/widget/FrameLayout$LayoutParams;", "view", "", "text", "L", "(Landroid/view/View;Ljava/lang/CharSequence;Lod/k;Ljava/lang/String;)V", FixCard.FixStyle.KEY_X, "(Lod/k;Ljava/lang/String;)Ljava/lang/Float;", "Lod/d;", "J", "(Lod/d;)Ljava/lang/Float;", "fromRatio", "q", "(Ljava/lang/CharSequence;F)I", "o", "(Ljava/lang/CharSequence;)F", "p", "()I", "durationMs", "w", "(J)J", "isLight", "direction", "Lcom/obric/oui/material/b;", "l", "(ZI)Lcom/obric/oui/material/b;", "onDetachedFromWindow", "setText", "(Ljava/lang/CharSequence;)V", "A", "H", "setTextWithEffect", "actualText", "B", "newText", "D", "F", "scale", "setDebugAnimationDurationScale", "(F)V", "getDebugAnimationDurationScale", "config", "setScanIndicatorMaterial", "(Lcom/obric/oui/material/b;)V", "setEnterScanIndicatorMaterial", "setExitScanIndicatorMaterial", "Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "a", "Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "getEffectTextView", "()Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "effectTextView", "b", "Landroid/view/View;", "getExitScanIndicator", "()Landroid/view/View;", "exitScanIndicator", "c", "getEnterScanIndicator", "enterScanIndicator", "", "Lcom/obric/oui/texteffects/runtime/ExternalViewLayerBinding;", "d", "Ljava/util/List;", "externalLayerBindings", "Landroid/animation/ValueAnimator;", "e", "Landroid/animation/ValueAnimator;", "externalAnimator", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "promptGenerateIndicatorRunnable", "pendingContentRewriteRunnable", "debugAnimationDurationScale", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "dp", "getScanIndicator", "scanIndicator", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODimPointGenerateEffectView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f17270j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ODimPointEffectTextView f17271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f17272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f17273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f17274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f17275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f17276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f17277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f17278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1 f17279i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17280a = null;

        static {
            int[] r10 = new int[Direction.values().length];
            r10[Direction.RightToLeft.ordinal()] = 1;
            r10[Direction.LeftToRight.ordinal()] = 2;
            r10[Direction.TopToBottom.ordinal()] = 3;
            r10[Direction.BottomToTop.ordinal()] = 4;
            f17280a = r10;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f17281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f17282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ODimPointGenerateEffectView f17283c;

        public c(Ref$BooleanRef r10, k r11, ODimPointGenerateEffectView r12) {
            this.f17281a = r10;
            this.f17282b = r11;
            this.f17283c = r12;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "animation");
            this.f17281a.element = true;
            e r11 = e.f17314a;
            k r12 = this.f17282b;
            if (e.a() == false) goto L6;
            Log.d(q.p("OUITextEffects/", "DimPointGenerateView"), q.p("external animator cancel spec=", r12.b()));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "animation");
            e r11 = e.f17314a;
            k r12 = this.f17282b;
            Ref$BooleanRef r13 = this.f17281a;
            if (e.a() == false) goto L6;
            Log.d(q.p("OUITextEffects/", "DimPointGenerateView"), "external animator end spec=" + r12.b() + ", canceled=" + r13.element);
        L6:
            if (this.f17281a.element == true) goto L9;
            ODimPointGenerateEffectView.d(this.f17283c);
            return;
        }
    }

    static {
        f17270j = new a(null);
    }

    @JvmOverloads
    public ODimPointGenerateEffectView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final void C(ODimPointGenerateEffectView r10, k r11) {
        q.g(r10, "this$0");
        q.g(r11, "$spec");
        r10.f17276f = null;
        r10.y(r11);
    }

    public static final void E(ODimPointGenerateEffectView r10, CharSequence r11) {
        q.g(r10, "this$0");
        q.g(r11, "$newText");
        r10.f17277g = null;
        r10.D(r11);
    }

    public static /* synthetic */ void a(ODimPointGenerateEffectView r10, k r11) {
        C(r10, r11);
    }

    public static /* synthetic */ void b(ODimPointGenerateEffectView r10, CharSequence r11) {
        E(r10, r11);
    }

    public static /* synthetic */ void c(k r10, ODimPointGenerateEffectView r11, ValueAnimator r12) {
        z(r10, r11, r12);
    }

    public static final /* synthetic */ void d(ODimPointGenerateEffectView r10) {
        r10.u();
    }

    public static final /* synthetic */ float e(ODimPointGenerateEffectView r10, String r11) {
        return r10.I(r11);
    }

    public static final void z(k r10, ODimPointGenerateEffectView r11, ValueAnimator r12) {
        q.g(r10, "$spec");
        q.g(r11, "this$0");
        q.g(r12, "animator");
        long r13 = (long) (r12.getAnimatedFraction() * r10.a());
        if (e.a() == true) goto L5;
    L7:
        r11.f(r10, r13);
        return;
    L5:
        if (e.b() == false) goto L7;
        Log.d(q.p("OUITextEffects/", "DimPointGenerateView"), "external animator update spec=" + r10.b() + ", playTime=" + r13);
        goto L7
    }

    public final void A(CharSequence r10) {
        n();
        m();
        k r11 = pd.a.f23454a.j(true);
        this.f17271a.setDebugAnimationDurationScale(this.f17278h);
        this.f17271a.T(r10);
        View r12 = this.f17273c;
        CharSequence r13 = this.f17271a.getText();
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        L(r12, r13, r11, "enterScanIndicator");
        y(r11);
    }

    public final void B(CharSequence r10) {
        q.g(r10, "actualText");
        n();
        m();
        if (this.f17271a.P() == true) goto L6;
        A(r10);
        return;
    L6:
        G();
        this.f17271a.setDebugAnimationDurationScale(this.f17278h);
        this.f17271a.U(r10);
        final k r11 = pd.a.f23454a.j(true);
        L(this.f17273c, r10, r11, "enterScanIndicator");
        Runnable r12 = new com.obric.oui.texteffects.c(this, r11);
        this.f17276f = r12;
        postDelayed(r12, w(150));
    }

    public final void D(final CharSequence r10) {
        q.g(r10, "newText");
        n();
        m();
        k r11 = pd.a.u(pd.a.f23454a, true, 0.0f, 2, null);
        if (this.f17271a.R() == false) goto L7;
        this.f17271a.W(r10);
        L(this.f17273c, r10, r11, "enterScanIndicator");
        return;
    L7:
        if (this.f17271a.Q() == false) goto L10;
        Runnable r12 = new com.obric.oui.texteffects.b(this, r10);
        this.f17277g = r12;
        postDelayed(r12, t());
        return;
    L10:
        CharSequence r13 = this.f17271a.getText();
        if (r13 != null) goto L13;
        r13 = "";
    L13:
        this.f17271a.setDebugAnimationDurationScale(this.f17278h);
        this.f17271a.W(r10);
        L(this.f17272b, r13, r11, "exitScanIndicator");
        L(this.f17273c, r10, r11, "enterScanIndicator");
        y(r11);
    }

    public final void F() {
        if (e.a() == false) goto L5;
        Log.d(q.p("OUITextEffects/", "DimPointGenerateView"), "stopEffect");
    L5:
        n();
        m();
        G();
        this.f17271a.J();
    }

    public final void G() {
        if (this.f17275e != null) goto L5;
    L7:
        ValueAnimator r10 = this.f17275e;
        if (r10 == null) goto L11;
        r10.cancel();
    L11:
        this.f17275e = null;
        u();
        return;
    L5:
        if (e.a() == false) goto L7;
        Log.d(q.p("OUITextEffects/", "DimPointGenerateView"), "stopExternalAnimator");
        goto L7
    }

    public final void H(CharSequence r10) {
        CharSequence r11 = this.f17271a.getText();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        if (this.f17271a.P() == false) goto L14;
        if (r10.length() <= 0) goto L14;
        B(r10);
        return;
    L14:
        if (TextUtils.equals(r11, r10) == false) goto L19;
        if (r11.length() != 0) goto L23;
        F();
        this.f17271a.setText(r10);
        return;
    L23:
        return;
    L19:
        if (r11.length() != 0) goto L21;
        A(r10);
        return;
    L21:
        D(r10);
    }

    public final float I(String r10) {
        CharSequence r11 = null;
        if (q.b(r10, "exitScanIndicator") == false) goto L8;
        Object r12 = this.f17272b.getTag();
        if ((r12 instanceof CharSequence) == false) goto L12;
        r11 = (CharSequence) r12;
    L12:
        if (r11 != null) goto L14;
        r11 = this.f17271a.getText();
    L14:
        if (r11 != null) goto L17;
        r11 = "";
    L17:
        return h.c(o(r11), 1.0f);
    L8:
        if (q.b(r10, "enterScanIndicator") == false) goto L12;
        Object r13 = this.f17273c.getTag();
        if ((r13 instanceof CharSequence) == false) goto L12;
        r11 = (CharSequence) r13;
        goto L12
    }

    public final Float J(od.d r10) {
        if ((r10 instanceof od.d.C0329d) == false) goto L6;
        return Float.valueOf(((od.d.C0329d) r10).a());
    L6:
        if ((r10 instanceof od.d.c) == true) goto L11;
        return null;
    L11:
        return J(((od.d.c) r10).a());
    }

    public final int K(Direction r10) {
        int r11 = b.f17280a[r10.ordinal()];
        if (r11 != 1) goto L5;
        return 4;
    L5:
        if (r11 == 2) goto L12;
        if (r11 == 3) goto L12;
        if (r11 == 4) goto L12;
        throw new NoWhenBranchMatchedException();
    L12:
        return 3;
    }

    public final void L(View r10, CharSequence r11, k r12, String r13) {
        r10.setTag(r11);
        Float r14 = x(r12, r13);
        if (r14 == null) goto L5;
        float r15 = r14.floatValue();
        int r16 = q(r11, r15);
        int r17 = p();
        ViewGroup.LayoutParams r18 = r10.getLayoutParams();
        if ((r18 instanceof FrameLayout.LayoutParams) == false) goto L11;
        FrameLayout.LayoutParams r19 = (FrameLayout.LayoutParams) r18;
    L13:
        if (r19 != null) goto L16;
        r10.setLayoutParams(new FrameLayout.LayoutParams(r16, r17, 19));
    L20:
        r10.measure(View.MeasureSpec.makeMeasureSpec(r16, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r17, Ints.MAX_POWER_OF_TWO));
        if (e.a() == false) goto L25;
        Log.d(q.p("OUITextEffects/", "DimPointGenerateView"), "update indicator size bindingKey=" + r13 + ", fromRatio=" + r15 + ", text=" + r11 + ", width=" + r16 + ", height=" + r17);
        return;
    L25:
        return;
    L16:
        if (r19.width == r16) goto L18;
    L19:
        r19.width = r16;
        r19.height = r17;
        r19.gravity = 19;
        r10.setLayoutParams(r19);
        goto L20
    L18:
        if (r19.height == r17) goto L20;
    L11:
        r19 = null;
        goto L13
    L5:
        if (e.a() == false) goto L24;
        Log.d(q.p("OUITextEffects/", "DimPointGenerateView"), "skip indicator size update, missing fromRatio bindingKey=" + r13 + ", spec=" + r12.b());
        return;
    }

    public final View M(String r10) {
        if (q.b(r10, "exitScanIndicator") == false) goto L6;
        return this.f17272b;
    L6:
        if (q.b(r10, "enterScanIndicator") == true) goto L11;
        return null;
    L11:
        return this.f17273c;
    }

    public final void f(k r10, long r11) {
        com.obric.oui.texteffects.runtime.d r12 = com.obric.oui.texteffects.runtime.e.f17347a.l(r10, r11);
        com.obric.oui.texteffects.runtime.b.f17329a.a(r12, this.f17274d, v());
    }

    public final void g(TypedArray r10) {
        int r11 = this.f17271a.getPaddingLeft();
        int r12 = this.f17271a.getPaddingTop();
        int r13 = this.f17271a.getPaddingRight();
        int r14 = this.f17271a.getPaddingBottom();
        int r15 = R$styleable.ODimPointGenerateEffectView_android_padding;
        if (r10.hasValue(r15) == false) goto L5;
        Integer r16 = Integer.valueOf(r10.getDimensionPixelSize(r15, 0));
    L6:
        if (r16 == null) goto L9;
        r11 = r16.intValue();
    L9:
        if (r16 == null) goto L12;
        r12 = r16.intValue();
    L12:
        if (r16 == null) goto L15;
        r13 = r16.intValue();
    L15:
        if (r16 == null) goto L18;
        r14 = r16.intValue();
    L18:
        int r17 = R$styleable.ODimPointGenerateEffectView_android_paddingLeft;
        if (r10.hasValue(r17) == false) goto L21;
        r11 = r10.getDimensionPixelSize(r17, r11);
    L21:
        int r18 = R$styleable.ODimPointGenerateEffectView_android_paddingTop;
        if (r10.hasValue(r18) == false) goto L24;
        r12 = r10.getDimensionPixelSize(r18, r12);
    L24:
        int r19 = R$styleable.ODimPointGenerateEffectView_android_paddingRight;
        if (r10.hasValue(r19) == false) goto L27;
        r13 = r10.getDimensionPixelSize(r19, r13);
    L27:
        int r20 = R$styleable.ODimPointGenerateEffectView_android_paddingBottom;
        if (r10.hasValue(r20) == false) goto L30;
        r14 = r10.getDimensionPixelSize(r20, r14);
    L30:
        int r21 = R$styleable.ODimPointGenerateEffectView_android_paddingStart;
        if (r10.hasValue(r21) == false) goto L33;
        r11 = r10.getDimensionPixelSize(r21, r11);
    L33:
        int r22 = R$styleable.ODimPointGenerateEffectView_android_paddingEnd;
        if (r10.hasValue(r22) == false) goto L36;
        r13 = r10.getDimensionPixelSize(r22, r13);
    L36:
        this.f17271a.setPadding(r11, r12, r13, r14);
        return;
    L5:
        r16 = null;
        goto L6
    }

    public final float getDebugAnimationDurationScale() {
        return this.f17278h;
    }

    @NotNull
    public final ODimPointEffectTextView getEffectTextView() {
        return this.f17271a;
    }

    @NotNull
    public final View getEnterScanIndicator() {
        return this.f17273c;
    }

    @NotNull
    public final View getExitScanIndicator() {
        return this.f17272b;
    }

    @NotNull
    public final View getScanIndicator() {
        return this.f17273c;
    }

    public final void h(AttributeSet r10, int r11) {
        if (r10 != null) goto L5;
        if (r11 != 0) goto L5;
        return;
    L5:
        TypedArray r12 = getContext().obtainStyledAttributes(r10, R$styleable.ODimPointGenerateEffectView, r11, 0);
        q.f(r12, "context.obtainStyledAttr…ectView, defStyleAttr, 0)");
        int r13 = R$styleable.ODimPointGenerateEffectView_android_textAppearance;     // Catch: Throwable -> L11
        if (r12.hasValue(r13) == false) goto L13;
        int r14 = r12.getResourceId(r13, 0);     // Catch: Throwable -> L11
        if (r14 == 0) goto L13;
        this.f17271a.setTextAppearance(r14);     // Catch: Throwable -> L11
    L13:
        int r15 = R$styleable.ODimPointGenerateEffectView_android_text;     // Catch: Throwable -> L11
        if (r12.hasValue(r15) == false) goto L16;
        this.f17271a.setText(r12.getText(r15));     // Catch: Throwable -> L11
    L16:
        int r16 = R$styleable.ODimPointGenerateEffectView_android_hint;     // Catch: Throwable -> L11
        if (r12.hasValue(r16) == false) goto L19;
        this.f17271a.setHint(r12.getText(r16));     // Catch: Throwable -> L11
    L19:
        int r17 = R$styleable.ODimPointGenerateEffectView_android_textColor;     // Catch: Throwable -> L11
        if (r12.hasValue(r17) == false) goto L25;
        ColorStateList r18 = r12.getColorStateList(r17);     // Catch: Throwable -> L11
        if (r18 == null) goto L25;
        getEffectTextView().setTextColor(r18);     // Catch: Throwable -> L11
    L25:
        int r19 = R$styleable.ODimPointGenerateEffectView_android_textColorHint;     // Catch: Throwable -> L11
        if (r12.hasValue(r19) == false) goto L31;
        ColorStateList r20 = r12.getColorStateList(r19);     // Catch: Throwable -> L11
        if (r20 == null) goto L31;
        getEffectTextView().setHintTextColor(r20);     // Catch: Throwable -> L11
    L31:
        int r21 = R$styleable.ODimPointGenerateEffectView_android_textSize;     // Catch: Throwable -> L11
        if (r12.hasValue(r21) == false) goto L34;
        ODimPointEffectTextView r22 = this.f17271a;     // Catch: Throwable -> L11
        r22.setTextSize(0, r12.getDimension(r21, r22.getTextSize()));     // Catch: Throwable -> L11
    L34:
        i(r12.getInt(R$styleable.ODimPointGenerateEffectView_android_typeface, -1), r12.getInt(R$styleable.ODimPointGenerateEffectView_android_textStyle, -1));     // Catch: Throwable -> L11
        int r23 = R$styleable.ODimPointGenerateEffectView_android_gravity;     // Catch: Throwable -> L11
        if (r12.hasValue(r23) == false) goto L37;
        ODimPointEffectTextView r24 = this.f17271a;     // Catch: Throwable -> L11
        r24.setGravity(r12.getInt(r23, r24.getGravity()));     // Catch: Throwable -> L11
    L37:
        int r25 = R$styleable.ODimPointGenerateEffectView_android_includeFontPadding;     // Catch: Throwable -> L11
        if (r12.hasValue(r25) == false) goto L40;
        ODimPointEffectTextView r26 = this.f17271a;     // Catch: Throwable -> L11
        r26.setIncludeFontPadding(r12.getBoolean(r25, r26.getIncludeFontPadding()));     // Catch: Throwable -> L11
    L40:
        int r27 = R$styleable.ODimPointGenerateEffectView_android_singleLine;     // Catch: Throwable -> L11
        if (r12.hasValue(r27) == false) goto L43;
        this.f17271a.setSingleLine(r12.getBoolean(r27, true));     // Catch: Throwable -> L11
    L43:
        int r28 = R$styleable.ODimPointGenerateEffectView_android_lines;     // Catch: Throwable -> L11
        if (r12.hasValue(r28) == false) goto L46;
        this.f17271a.setLines(r12.getInt(r28, 1));     // Catch: Throwable -> L11
    L46:
        int r29 = R$styleable.ODimPointGenerateEffectView_android_minLines;     // Catch: Throwable -> L11
        if (r12.hasValue(r29) == false) goto L49;
        this.f17271a.setMinLines(r12.getInt(r29, 1));     // Catch: Throwable -> L11
    L49:
        int r30 = R$styleable.ODimPointGenerateEffectView_android_maxLines;     // Catch: Throwable -> L11
        if (r12.hasValue(r30) == false) goto L52;
        this.f17271a.setMaxLines(r12.getInt(r30, Channel.UNLIMITED));     // Catch: Throwable -> L11
    L52:
        int r31 = R$styleable.ODimPointGenerateEffectView_android_ellipsize;     // Catch: Throwable -> L11
        if (r12.hasValue(r31) == false) goto L55;
        this.f17271a.setEllipsize(s(r12.getInt(r31, 0)));     // Catch: Throwable -> L11
    L55:
        int r32 = R$styleable.ODimPointGenerateEffectView_android_lineSpacingExtra;     // Catch: Throwable -> L11
        if (r12.hasValue(r32) == false) goto L58;
    L59:
        float r33 = r12.getDimension(r32, 0.0f);     // Catch: Throwable -> L11
        float r34 = r12.getFloat(R$styleable.ODimPointGenerateEffectView_android_lineSpacingMultiplier, 1.0f);     // Catch: Throwable -> L11
        this.f17271a.setLineSpacing(r33, r34);     // Catch: Throwable -> L11
    L60:
        int r35 = R$styleable.ODimPointGenerateEffectView_android_letterSpacing;     // Catch: Throwable -> L11
        if (r12.hasValue(r35) == false) goto L63;
        ODimPointEffectTextView r36 = this.f17271a;     // Catch: Throwable -> L11
        r36.setLetterSpacing(r12.getFloat(r35, r36.getLetterSpacing()));     // Catch: Throwable -> L11
    L63:
        g(r12);     // Catch: Throwable -> L11
        r12.recycle();
        return;
    L58:
        if (r12.hasValue(R$styleable.ODimPointGenerateEffectView_android_lineSpacingMultiplier) == false) goto L60;
    L11:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    public final void i(int r10, int r11) {
        if (r11 < 0) goto L4;
        int r12 = r11;
    L6:
        if (r10 != 1) goto L8;
        Typeface r13 = Typeface.SANS_SERIF;
    L15:
        if (r10 >= 0) goto L17;
        if (r11 >= 0) goto L17;
        return;
    L17:
        this.f17271a.setTypeface(r13, r12);
        return;
    L8:
        if (r10 != 2) goto L10;
        r13 = Typeface.SERIF;
        goto L15
    L10:
        if (r10 == 3) goto L12;
        r13 = this.f17271a.getTypeface();
        goto L15
    L12:
        r13 = Typeface.MONOSPACE;
        goto L15
    L4:
        r12 = 0;
        goto L6
    }

    public final void j(k r12) {
        this.f17274d.clear();
        List r13 = r12.d();
        ArrayList r10 = new ArrayList();
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        y.v(r10, ((od.c) r14.next()).c());
        goto L4
    L6:
        ArrayList r15 = new ArrayList();
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        Object r16 = r11.next();
        if ((r16 instanceof od.b.a) == false) goto L8;
        r15.add(r16);
        goto L8
    L12:
        HashSet r17 = new HashSet();
        ArrayList r18 = new ArrayList();
        Iterator r19 = r15.iterator();
    L14:
        if (r19.hasNext() == false) goto L18;
        Object r20 = r19.next();
        if (r17.add(((od.b.a) r20).c()) == false) goto L14;
        r18.add(r20);
        goto L14
    L18:
        Iterator r110 = r18.iterator();
    L20:
        if (r110.hasNext() == false) goto L31;
        final od.b.a r21 = (od.b.a) r110.next();
        View r22 = M(r21.c());
        if (r22 == null) goto L20;
        od.h r23 = r21.d();
        if (r23 == null) goto L28;
        OMaterialHelper.D(r22, l(true, K(r23.a())));
    L28:
        this.f17274d.add(new ExternalViewLayerBinding(r21.c(), r22, new ODimPointGenerateEffectView$bindExternalLayers$3$2(this, r21), 0, 0.0f, 24, null));
        if (e.a() == false) goto L20;
        Log.d(q.p("OUITextEffects/", "DimPointGenerateView"), "bind external layer id=" + r21.a() + ", bindingKey=" + r21.c());
        goto L20
    }

    public final FrameLayout.LayoutParams k() {
        return new FrameLayout.LayoutParams(((Number) this.f17279i.invoke(Float.valueOf(16.0f))).intValue(), p(), 19);
    }

    public final com.obric.oui.material.b l(boolean r16, int r17) {
        com.obric.oui.color.a[] r10 = OMaterialHelper.i(getResources(), R$array.oui_no_gradient_blur_colors, R$array.oui_no_gradient_blur_blend_modes);
        if (r16 == true) goto L6;
        float r11 = BlurToken.Blur_Progress_Thin;
    L8:
        return new com.obric.oui.material.b(null, null, r10, null, null, null, new pc.a(r11, r17, 0.0f, 3, 0.0f, 20, null), null, null, null, 955, null);
    L6:
        r11 = 16.0f;
        goto L8
    }

    public final void m() {
        Runnable r10 = this.f17277g;
        if (r10 == null) goto L6;
        removeCallbacks(r10);
    L6:
        this.f17277g = null;
    }

    public final void n() {
        Runnable r10 = this.f17276f;
        if (r10 == null) goto L6;
        removeCallbacks(r10);
    L6:
        this.f17276f = null;
    }

    public final float o(CharSequence r10) {
        float r11 = h.c((this.f17271a.getWidth() - this.f17271a.getCompoundPaddingLeft()) - this.f17271a.getCompoundPaddingRight(), 0.0f);
        if (this.f17271a.getEllipsize() == null) goto L8;
        if (r11 <= 0.0f) goto L8;
        r10 = TextUtils.ellipsize(r10, this.f17271a.getPaint(), r11, this.f17271a.getEllipsize());
    L8:
        return this.f17271a.getPaint().measureText(r10, 0, r10.length());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        if (e.a() == false) goto L5;
        Log.d(q.p("OUITextEffects/", "DimPointGenerateView"), "onDetachedFromWindow");
    L5:
        F();
        super.onDetachedFromWindow();
    }

    public final int p() {
        Paint.FontMetrics r10 = this.f17271a.getPaint().getFontMetrics();
        return h.d(yf.b.b((float) Math.ceil((r10.descent - r10.ascent) + (((Number) this.f17279i.invoke(Float.valueOf(16.0f))).floatValue() * 2.0f))), 1);
    }

    public final int q(CharSequence r10, float r11) {
        return h.d(yf.b.b((float) Math.ceil(o(r10) * Math.abs(r11))), 1);
    }

    public final View r(boolean r10) {
        View r11 = new View(getContext());
        r11.setAlpha(1.0f);
        r11.setVisibility(4);
        return r11;
    }

    public final TextUtils.TruncateAt s(int r10) {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L19;
        if (r10 == 3) goto L18;
        if (r10 == 4) goto L17;
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

    public final void setDebugAnimationDurationScale(float r10) {
        if (Float.isNaN(r10) == false) goto L5;
    L8:
        float r11 = 1.0f;
    L10:
        if (this.f17278h != r11) goto L12;
        return;
    L12:
        this.f17278h = r11;
        if (e.a() == false) goto L15;
        Log.d(q.p("OUITextEffects/", "DimPointGenerateView"), q.p("setDebugAnimationDurationScale scale=", Float.valueOf(r11)));
    L15:
        this.f17271a.setDebugAnimationDurationScale(r11);
        return;
    L5:
        if (Float.isInfinite(r10) == true) goto L8;
        r11 = h.j(r10, 0.1f, 10.0f);
        goto L10
    }

    public final void setEnterScanIndicatorMaterial(@NotNull com.obric.oui.material.b r10) {
        q.g(r10, "config");
        OMaterialHelper.D(this.f17273c, r10);
    }

    public final void setExitScanIndicatorMaterial(@NotNull com.obric.oui.material.b r10) {
        q.g(r10, "config");
        OMaterialHelper.D(this.f17272b, r10);
    }

    public final void setScanIndicatorMaterial(@NotNull com.obric.oui.material.b r10) {
        q.g(r10, "config");
        setEnterScanIndicatorMaterial(r10);
    }

    public final void setText(@Nullable CharSequence r10) {
        F();
        this.f17271a.setText(r10);
    }

    public final void setTextWithEffect(@Nullable CharSequence r10) {
        H(r10);
    }

    public final long t() {
        return w(h.e(pd.a.u(pd.a.f23454a, true, 0.0f, 2, null).a() - this.f17271a.O(), 1));
    }

    public final void u() {
        Iterator r10 = this.f17274d.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((ExternalViewLayerBinding) r10.next()).d();
        goto L4
    }

    public final float v() {
        Integer r10 = Integer.valueOf(getWidth());
        Integer r11 = null;
        if (r10.intValue() > 0) goto L6;
        r10 = null;
    L6:
        if (r10 != null) goto L23;
        r10 = Integer.valueOf(getMeasuredWidth());
        if (r10.intValue() > 0) goto L11;
        r10 = null;
    L11:
        if (r10 != null) goto L23;
        r10 = Integer.valueOf(this.f17271a.getWidth());
        if (r10.intValue() > 0) goto L16;
        r10 = null;
    L16:
        if (r10 != null) goto L23;
        Integer r12 = Integer.valueOf(this.f17271a.getMeasuredWidth());
        if (r12.intValue() <= 0) goto L20;
        r11 = r12;
    L20:
        if (r11 != null) goto L22;
        int r13 = 0;
    L25:
        return r13;
    L22:
        r13 = r11.intValue();
    L23:
        r13 = r10.intValue();
        goto L25
    }

    public final long w(long r10) {
        return h.d(yf.b.b(r10 * this.f17278h), 1);
    }

    public final Float x(k r10, final String r11) {
        Iterator r12 = SequencesKt___SequencesKt.n(SequencesKt___SequencesKt.j(SequencesKt___SequencesKt.j(SequencesKt___SequencesKt.n(b0.Q(r10.d()), ODimPointGenerateEffectView$scanIndicatorFromRatio$1.INSTANCE), ODimPointGenerateEffectView$scanIndicatorFromRatio$$inlined$filterIsInstance$1.INSTANCE), new ODimPointGenerateEffectView$scanIndicatorFromRatio$2(r11)), ODimPointGenerateEffectView$scanIndicatorFromRatio$3.INSTANCE).iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (((i) r13).c() != EffectProperty.TranslationX) goto L4;
    L9:
        i r14 = (i) r13;
        if (r14 == null) goto L40;
        List r15 = r14.b();
        if (r15 == null) goto L41;
        Iterator r16 = r15.iterator();
        if (r16.hasNext() == true) goto L18;
        Object r17 = null;
    L27:
        f r18 = (f) r17;
        if (r18 == null) goto L42;
        od.d r19 = r18.b();
        if (r19 != null) goto L34;
        return null;
    L34:
        return J(r19);
    L42:
        return null;
    L18:
        r17 = r16.next();
        if (r16.hasNext() == false) goto L27;
        long r20 = ((f) r17).a();
    L22:
        Object r21 = r16.next();
        long r22 = ((f) r21).a();
        if (r20 <= r22) goto L26;
        r17 = r21;
        r20 = r22;
    L26:
        if (r16.hasNext() == true) goto L22;
    L41:
        return null;
    L40:
        return null;
    L8:
        r13 = null;
        goto L9
    }

    public final void y(final k r10) {
        G();
        j(r10);
        Ref$BooleanRef r11 = new Ref$BooleanRef();
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r12.setDuration(w(r10.a()));
        r12.setInterpolator(new LinearInterpolator());
        r12.addUpdateListener(new com.obric.oui.texteffects.a(r10, this));
        r12.addListener(new c(r11, r10, this));
        r12.start();
        this.f17275e = r12;
    }

    @JvmOverloads
    public ODimPointGenerateEffectView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ ODimPointGenerateEffectView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public ODimPointGenerateEffectView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f17274d = new ArrayList();
        this.f17278h = 1.0f;
        Function1<Float, Integer> r13 = new ODimPointGenerateEffectView$dp$1(this);
        this.f17279i = r13;
        if (e.a() == false) goto L5;
        Log.d(q.p("OUITextEffects/", "DimPointGenerateView"), "init DimPointGenerateEffectView");
    L5:
        setClipChildren(false);
        setClipToPadding(false);
        ODimPointEffectTextView r14 = new ODimPointEffectTextView(r10, null, 0, 6, null);
        r14.setGravity(16);
        r14.setIncludeFontPadding(false);
        r14.setSingleLine(true);
        r14.setPadding(r13.invoke(Float.valueOf(16.0f)).intValue(), 0, r13.invoke(Float.valueOf(16.0f)).intValue(), 0);
        this.f17271a = r14;
        h(r11, r12);
        addView(r14, new FrameLayout.LayoutParams(-1, r13.invoke(Float.valueOf(56.0f)).intValue(), 16));
        View r15 = r(false);
        this.f17272b = r15;
        View r16 = r(true);
        this.f17273c = r16;
        addView(r15, k());
        addView(r16, k());
        j(pd.a.u(pd.a.f23454a, true, 0.0f, 2, null));
        u();
    }
}
