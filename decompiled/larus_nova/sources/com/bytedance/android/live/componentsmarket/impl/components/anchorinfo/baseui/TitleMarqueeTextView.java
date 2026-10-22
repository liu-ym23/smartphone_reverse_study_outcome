package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.baseui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0002QRB'\b\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\b\b\u0002\u0010M\u001a\u00020\u0006¢\u0006\u0004\bN\u0010OJ\u0012\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J&\u0010!\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0006J\u001e\u0010$\u001a\u00020\b2\u0016\u0010#\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010\"J\u0018\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u001cH\u0016J\u0006\u0010(\u001a\u00020\bJ\u0010\u0010)\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0003H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u001e\u0010\u0005\u001a\u00020\b2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\"H\u0016J\u0006\u0010/\u001a\u00020\bJ\b\u00100\u001a\u00020\bH\u0016J\n\u00101\u001a\u0004\u0018\u00010\u000bH\u0016J$\u00103\u001a\u00020\b2\u0006\u00102\u001a\u00020\u000b2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\"J\b\u00104\u001a\u0004\u0018\u00010,J\u000e\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0003R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010>R\u0014\u0010E\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bE\u0010@R\u0018\u0010H\u001a\u00020\u0006*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006S"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/anchorinfo/baseui/TitleMarqueeTextView;", "Landroid/widget/FrameLayout;", "", "", "isLoop", "startMarqueeIfNeed", "", "distance", "", "startAnimation", "Lkotlin/Pair;", "", "getMarqueeTextAndWidth", "getEndAnimationText", "text", "getEllipsisStart", "minWidthPx", "setMinWidth", "maxWidthPx", "setMaxWidth", "Landroid/view/View;", "getA11yDescView", "getContent", "setTextWithFading", "setTextWithEllipsis", "setTextWithEllipsisImmediately", "speedPx", "setSpeed", "", "radius", "dx", "dy", "color", "setTextShadow", "Lkotlin/Function1;", SendEventContainerMethodParamModel.EventKinds.onClick, "setOnClickListener", Scraps.INNER_UNIT, "size", "setTextSize", "setUnbold", "setTextColor", "includepad", "setIncludeFontPadding", "Landroid/graphics/Paint;", "getPaint", "action", "cancelMarquee", "cancelAnimation", "getOriginText", "s", "setTextAndMarquee", "getTextPaint", "b", "setNeedLeftEdge", "Lcom/bytedance/android/live/componentsmarket/impl/components/anchorinfo/baseui/TitleMarqueeTextView$FadingEdgeHorizontalScrollView;", "scrollView", "Lcom/bytedance/android/live/componentsmarket/impl/components/anchorinfo/baseui/TitleMarqueeTextView$FadingEdgeHorizontalScrollView;", "Landroid/widget/TextView;", "userNameView", "Landroid/widget/TextView;", "marqueeSpeedPx", "I", "originText", "Ljava/lang/String;", "Landroid/animation/Animator;", "animator", "Landroid/animation/Animator;", "lastTextEndState", "infix", "getDpInt", "(I)I", "dpInt", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FadingEdgeHorizontalScrollView", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TitleMarqueeTextView extends FrameLayout {
    public static final a Companion = null;
    private static final int DEFAULT_SPEED_DP = 24;
    private static final int ELLIPSIS = 2;
    private static final int FADING = 1;
    public static final String TAG = "MarqueeTextView";
    private Animator animator;
    private final String infix;
    private int lastTextEndState;
    private int marqueeSpeedPx;
    private String originText;
    private FadingEdgeHorizontalScrollView scrollView;
    private TextView userNameView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0014J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/anchorinfo/baseui/TitleMarqueeTextView$FadingEdgeHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxWidthPx", "getMaxWidthPx", "()I", "setMaxWidthPx", "(I)V", "needLeftEdge", "", "getNeedLeftEdge", "()Z", "setNeedLeftEdge", "(Z)V", "getLeftFadingEdgeStrength", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FadingEdgeHorizontalScrollView extends HorizontalScrollView {
        private int maxWidthPx;
        private boolean needLeftEdge;

        public static final class a implements View.OnTouchListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f64594a = null;

            static {
                f64594a = new a();
            }

            public a() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View r100, MotionEvent r101) {
                return true;
            }
        }

        public FadingEdgeHorizontalScrollView(Context r100) {
            this(r100, null, 0, 6, null);
        }

        public FadingEdgeHorizontalScrollView(Context r100, AttributeSet r101) {
            this(r100, r101, 0, 4, null);
        }

        @Override // android.widget.HorizontalScrollView, android.view.View
        public float getLeftFadingEdgeStrength() {
            if (this.needLeftEdge == true) goto L7;
            return 0.0f;
        L7:
            return super.getLeftFadingEdgeStrength();
        }

        public final int getMaxWidthPx() {
            return this.maxWidthPx;
        }

        public final boolean getNeedLeftEdge() {
            return this.needLeftEdge;
        }

        public final void setMaxWidthPx(int r100) {
            this.maxWidthPx = r100;
        }

        public final void setNeedLeftEdge(boolean r100) {
            this.needLeftEdge = r100;
        }

        @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
        public void onMeasure(int r100, int r101) {
            if (this.maxWidthPx <= 0) goto L8;
            int r102 = View.MeasureSpec.getMode(r100);
            int r103 = View.MeasureSpec.getSize(r100);
            int r104 = this.maxWidthPx;
            if (r104 <= 0) goto L8;
            if (r103 <= r104) goto L8;
            r100 = View.MeasureSpec.makeMeasureSpec(r104, r102);
        L8:
            super.onMeasure(r100, r101);
        }

        public FadingEdgeHorizontalScrollView(Context r100, AttributeSet r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101, r102);
            setOnTouchListener(a.f64594a);
        }

        public /* synthetic */ FadingEdgeHorizontalScrollView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = 0;
        L8:
            this(r100, r101, r102);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f64595a;

        public b(Function1 r100) {
            this.f64595a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View r100) {
            this.f64595a.invoke(r100);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TitleMarqueeTextView f64596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f64597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f64598c;

        public c(TitleMarqueeTextView r100, String r101, Function1 r102) {
            this.f64596a = r100;
            this.f64597b = r101;
            this.f64598c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TitleMarqueeTextView.access$setOriginText$p(this.f64596a, this.f64597b);     // Catch: Throwable -> L9
            TextView r100 = TitleMarqueeTextView.access$getUserNameView$p(this.f64596a);     // Catch: Throwable -> L9
            if (r100 == null) goto L5;
            r100.setText(this.f64597b);     // Catch: Throwable -> L9
        L5:
            boolean r101 = TitleMarqueeTextView.access$startMarqueeIfNeed(this.f64596a, true);     // Catch: Throwable -> L9
            Function1 r102 = this.f64598c;     // Catch: Throwable -> L9
            if (r102 == null) goto L12;
            Unit r103 = (Unit) r102.invoke(Boolean.valueOf(r101));     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TitleMarqueeTextView f64599a;

        public d(TitleMarqueeTextView r100) {
            this.f64599a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ALogger.i("MarqueeTextView", "setTextWithEllipsis, get end animation text");     // Catch: Throwable -> L6
            TextView r100 = TitleMarqueeTextView.access$getUserNameView$p(this.f64599a);     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.setText(TitleMarqueeTextView.access$getEndAnimationText(this.f64599a));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TitleMarqueeTextView f64600a;

        public e(TitleMarqueeTextView r100) {
            this.f64600a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Integer) == true) goto L5;
            r101 = null;
        L5:
            Integer r102 = (Integer) r101;
            if (r102 == null) goto L11;
            int r103 = r102.intValue();
            FadingEdgeHorizontalScrollView r104 = TitleMarqueeTextView.access$getScrollView$p(this.f64600a);
            if (r104 == null) goto L12;
            r104.scrollTo(r103, 0);
            return;
        L12:
            return;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TitleMarqueeTextView f64601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f64602b;

        public f(TitleMarqueeTextView r100, Function1 r101) {
            this.f64601a = r100;
            this.f64602b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r100 = TitleMarqueeTextView.startMarqueeIfNeed$default(this.f64601a, false, 1, null);     // Catch: Throwable -> L6
            Function1 r101 = this.f64602b;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            Unit r102 = (Unit) r101.invoke(Boolean.valueOf(r100));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public TitleMarqueeTextView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public TitleMarqueeTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    private final String getEndAnimationText() {
        int r100 = getEllipsisStart(this.originText);
        if (r100 <= 0) goto L5;
        TextView r101 = this.userNameView;
        if (r101 == null) goto L40;
        TextPaint r102 = r101.getPaint();
        if (r102 == null) goto L40;
        FadingEdgeHorizontalScrollView r103 = this.scrollView;
        if (r103 == null) goto L14;
        int r104 = r103.getMaxWidthPx();
    L15:
        if (r104 <= 0) goto L20;
        FadingEdgeHorizontalScrollView r105 = this.scrollView;
        if (r105 == null) goto L19;
        int r106 = r105.getMaxWidthPx();
    L21:
        Integer r107 = Integer.valueOf(r106);
    L22:
        if (r107 == null) goto L24;
        int r108 = r107.intValue();
    L25:
        StringBuilder r109 = new StringBuilder("getEndAnimationText, windowLength : ");
        r109.append(r108);
        r109.append(", max witdh ");
        FadingEdgeHorizontalScrollView r110 = this.scrollView;
        if (r110 == null) goto L28;
        Integer r111 = Integer.valueOf(r110.getMaxWidthPx());
    L29:
        r109.append(r111);
        r109.append(", width ");
        r109.append(getWidth());
        ALogger.i("MarqueeTextView", r109.toString());
        String r112 = this.originText;
        if (r112 == null) goto L40;
        StringBuilder r113 = new StringBuilder(r112.subSequence(0, r100));
        r113.append("...");
    L32:
        float r114 = r108;
        if (r102.measureText(r113.toString()) <= r114) goto L36;
        r113.deleteCharAt(r113.length() - 4);
    L36:
        if (r102.measureText(r113.toString()) >= r114) goto L38;
        r113.append(' ');
        goto L36
    L38:
        ALogger.i("MarqueeTextView", "getEndAnimationText, final string is " + r113.toString());
        return r113.toString();
    L28:
        r111 = null;
        goto L29
    L24:
        r108 = 0;
        goto L25
    L19:
        r107 = null;
        goto L22
    L20:
        r106 = getWidth();
        goto L21
    L14:
        r104 = 0;
    L40:
        return null;
    L5:
        return this.originText;
    }

    public void cancelAnimation() {
        Animator r100 = this.animator;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.animator = null;
    }

    public final void cancelMarquee() {
        Animator r100 = this.animator;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        FadingEdgeHorizontalScrollView r101 = this.scrollView;
        if (r101 == null) goto L8;
        r101.scrollTo(0, 0);
    L8:
        TextView r102 = this.userNameView;
        if (r102 == null) goto L12;
        r102.setText(this.originText);
        return;
    }

    public String getContent() {
        TextView r100 = this.userNameView;
        if (r100 == null) goto L7;
        CharSequence r101 = r100.getText();
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public Paint getPaint() {
        TextView r100 = this.userNameView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPaint();
    }

    public final Paint getTextPaint() {
        TextView r100 = this.userNameView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPaint();
    }

    public final void setUnbold() {
        TextView r100 = this.userNameView;
        if (r100 == null) goto L6;
        r100.setTypeface(Typeface.defaultFromStyle(0));
        return;
    }

    private final Pair<String, Integer> getMarqueeTextAndWidth() {
        String r100 = getEndAnimationText();
        String r101 = this.originText + this.infix;
        TextView r102 = this.userNameView;
        if (r102 == null) goto L7;
        TextPaint r103 = r102.getPaint();
        if (r103 == null) goto L7;
        float r104 = r103.measureText(r101);
    L9:
        return TuplesKt.to(r101 + r100, Integer.valueOf((int) r104));
    L7:
        r104 = 0.0f;
        goto L9
    }

    public View getA11yDescView() {
        return this.userNameView;
    }

    public String getOriginText() {
        return this.originText;
    }

    public static final /* synthetic */ String access$getEndAnimationText(TitleMarqueeTextView r100) {
        return r100.getEndAnimationText();
    }

    public static final /* synthetic */ String access$getOriginText$p(TitleMarqueeTextView r100) {
        return r100.originText;
    }

    public static final /* synthetic */ FadingEdgeHorizontalScrollView access$getScrollView$p(TitleMarqueeTextView r100) {
        return r100.scrollView;
    }

    public static final /* synthetic */ TextView access$getUserNameView$p(TitleMarqueeTextView r100) {
        return r100.userNameView;
    }

    private final int getDpInt(int r100) {
        return (int) ((s1.l().density * r100) + 0.5f);
    }

    private final int getEllipsisStart(String r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return -1;
    L12:
        TextView r103 = this.userNameView;
        if (r103 == null) goto L39;
        TextPaint r104 = r103.getPaint();
        if (r104 == null) goto L39;
        FadingEdgeHorizontalScrollView r105 = this.scrollView;
        if (r105 == null) goto L20;
        int r106 = r105.getMaxWidthPx();
    L21:
        if (r106 <= 0) goto L26;
        FadingEdgeHorizontalScrollView r107 = this.scrollView;
        if (r107 == null) goto L25;
        int r108 = r107.getMaxWidthPx();
    L27:
        Integer r109 = Integer.valueOf(r108);
    L28:
        if (r109 == null) goto L39;
        float r110 = r109.intValue();
        if (r104.measureText(r100) > r110) goto L32;
        return 0;
    L32:
        StringBuilder r111 = new StringBuilder();
        int r112 = 0;
    L34:
        if (r101 >= r100.length()) goto L39;
        int r113 = r112 + 1;
        r111.append(r100.charAt(r101));
        if (r104.measureText(r111.toString()) >= r110) goto L37;
        r101 = r101 + 1;
        r112 = r113;
        goto L34
    L37:
        return r112;
    L25:
        r109 = null;
        goto L28
    L26:
        r108 = getWidth();
        goto L27
    L20:
        r106 = 0;
    L39:
        return -1;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    private final boolean startMarqueeIfNeed(boolean r100) {
        int r101 = getEllipsisStart(this.originText);
        if (r101 <= 0) goto L15;
        String r102 = this.originText;
        if (r102 == null) goto L7;
        int r103 = r102.length();
    L8:
        if (r101 >= r103) goto L15;
        cancelAnimation();
        ALogger.i("MarqueeTextView", "startMarqueeIfNeed, get text and width");
        Pair<String, Integer> r104 = getMarqueeTextAndWidth();
        TextView r105 = this.userNameView;
        if (r105 == null) goto L13;
        r105.setText(r104.getFirst());
    L13:
        startAnimation(r104.getSecond().intValue(), r100);
        return true;
    L7:
        r103 = 0;
    L15:
        return false;
    }

    public void setIncludeFontPadding(boolean r100) {
        TextView r101 = this.userNameView;
        if (r101 == null) goto L6;
        r101.setIncludeFontPadding(r100);
        return;
    }

    public void setMaxWidth(int r100) {
        FadingEdgeHorizontalScrollView r101 = this.scrollView;
        if (r101 == null) goto L5;
        r101.setMaxWidthPx(r100);
    L5:
        requestLayout();
        int r102 = this.lastTextEndState;
        if (r102 != 1) goto L9;
        setTextWithFading(this.originText);
        return;
    L9:
        if (r102 != 2) goto L13;
        setTextWithEllipsis(this.originText);
        return;
    }

    public final void setMinWidth(int r100) {
        FadingEdgeHorizontalScrollView r101 = this.scrollView;
        if (r101 == null) goto L5;
        r101.setMinimumWidth(r100);
    L5:
        int r102 = this.lastTextEndState;
        if (r102 != 1) goto L9;
        setTextWithFading(this.originText);
        return;
    L9:
        if (r102 != 2) goto L13;
        setTextWithEllipsis(this.originText);
        return;
    }

    public final void setNeedLeftEdge(boolean r100) {
        FadingEdgeHorizontalScrollView r101 = this.scrollView;
        if (r101 == null) goto L6;
        r101.setNeedLeftEdge(r100);
        return;
    }

    public final void setOnClickListener(Function1<? super View, Unit> r100) {
        TextView r101 = this.userNameView;
        Object r102 = r100;
        if (r101 == null) goto L8;
        if (r100 == null) goto L6;
        r102 = new b(r100);
    L6:
        r101.setOnClickListener((View.OnClickListener) r102);
        return;
    }

    public void setSpeed(int r100) {
        this.marqueeSpeedPx = r100;
    }

    public void setTextColor(int r100) {
        TextView r101 = this.userNameView;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public void setTextWithEllipsis(String r100) {
        this.lastTextEndState = 2;
        FadingEdgeHorizontalScrollView r101 = this.scrollView;
        if (r101 == null) goto L5;
        r101.scrollTo(0, 0);
    L5:
        this.originText = r100;
        post(new d(this));
    }

    public void setTextWithEllipsisImmediately(String r100) {
        this.lastTextEndState = 2;
        FadingEdgeHorizontalScrollView r101 = this.scrollView;
        if (r101 == null) goto L5;
        r101.scrollTo(0, 0);
    L5:
        this.originText = r100;
        TextView r102 = this.userNameView;
        if (r102 == null) goto L9;
        r102.setText(getEndAnimationText());
        return;
    }

    public void setTextWithFading(String r100) {
        this.lastTextEndState = 1;
        FadingEdgeHorizontalScrollView r101 = this.scrollView;
        if (r101 == null) goto L5;
        r101.scrollTo(0, 0);
    L5:
        this.originText = r100;
        TextView r102 = this.userNameView;
        if (r102 == null) goto L9;
        r102.setText(r100);
        return;
    }

    public void startMarqueeIfNeed(Function1<? super Boolean, Unit> r100) {
        post(new f(this, r100));
    }

    public static final /* synthetic */ void access$setOriginText$p(TitleMarqueeTextView r100, String r101) {
        r100.originText = r101;
    }

    public static final /* synthetic */ void access$setScrollView$p(TitleMarqueeTextView r100, FadingEdgeHorizontalScrollView r101) {
        r100.scrollView = r101;
    }

    public static final /* synthetic */ void access$setUserNameView$p(TitleMarqueeTextView r100, TextView r101) {
        r100.userNameView = r101;
    }

    public static final /* synthetic */ boolean access$startMarqueeIfNeed(TitleMarqueeTextView r100, boolean r101) {
        return r100.startMarqueeIfNeed(r101);
    }

    private final void startAnimation(int r100, boolean r101) {
        Animator r102 = this.animator;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        FadingEdgeHorizontalScrollView r103 = this.scrollView;
        if (r103 == null) goto L8;
        r103.scrollTo(0, 0);
    L8:
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{0, r100});
        r104.setInterpolator(new LinearInterpolator());
        r104.setDuration((r100 * 1000) / this.marqueeSpeedPx);
        r104.addUpdateListener(new e(this));
        if (r101 == false) goto L11;
        r104.setRepeatCount(-1);
        r104.setRepeatMode(1);
    L11:
        r104.start();
        Unit r105 = Unit.INSTANCE;
        this.animator = r104;
    }

    public final void setTextAndMarquee(String r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "s");
        post(new c(this, r100, r101));
    }

    public void setTextSize(int r100, float r101) {
        TextView r102 = this.userNameView;
        if (r102 == null) goto L6;
        r102.setTextSize(r100, r101);
        return;
    }

    public TitleMarqueeTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.marqueeSpeedPx = getDpInt(24);
        this.infix = "       ";
        LayoutInflater.from(r100).inflate(R.layout.ttlive_marquee_textview, this, true);
        this.scrollView = (FadingEdgeHorizontalScrollView) findViewById(R.id.scrollView);
        this.userNameView = (TextView) findViewById(R.id.user_name);
    }

    public static /* synthetic */ boolean startMarqueeIfNeed$default(TitleMarqueeTextView r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return r100.startMarqueeIfNeed(r101);
    }

    public final void setTextShadow(float r100, float r101, float r102, int r103) {
        TextView r104 = this.userNameView;
        if (r104 == null) goto L6;
        r104.setShadowLayer(r100, r101, r102, r103);
        return;
    }

    public /* synthetic */ TitleMarqueeTextView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ void startAnimation$default(TitleMarqueeTextView r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.startAnimation(r101, r102);
    }
}
