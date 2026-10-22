package com.bytedance.android.livesdk.common;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
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

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0002fgB'\b\u0007\u0012\u0006\u0010_\u001a\u00020^\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010`\u0012\b\b\u0002\u0010b\u001a\u00020\u0005¢\u0006\u0004\bc\u0010dJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0014J0\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u0010$\u001a\u00020\u0003J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0005H\u0016J\u001e\u0010)\u001a\u00020\u00072\u0016\u0010(\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u0007\u0018\u00010'J\u0018\u0010-\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0005H\u0016J\u0010\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0003H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\u0010\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0003H\u0016J\u001e\u0010\u0004\u001a\u00020\u00072\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010'H\u0016J\u0010\u0010\u0004\u001a\u00020\u00072\u0006\u00108\u001a\u000207H\u0016J\b\u00109\u001a\u00020\u0007H\u0016J\u0006\u0010:\u001a\u00020\u0007J\b\u0010;\u001a\u00020\u0007H\u0016J\u0010\u0010=\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0003H\u0016J\n\u0010>\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER$\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010@R\u0018\u0010N\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010@R\u0016\u0010$\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010TR\u0014\u0010U\u001a\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\bU\u0010OR\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010VR\"\u0010W\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010T\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0018\u0010]\u001a\u00020\u0005*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\¨\u0006h"}, d2 = {"Lcom/bytedance/android/livesdk/common/MatchMarqueeTextView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/common/j;", "", "startMarqueeIfNeed", "", "distance", "", "startAnimation", "Lkotlin/Pair;", "", "getMarqueeTextAndWidth", "getEndAnimationText", "text", "getEllipsisStart", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onLayout", "setTextWithEllipsis", "setTextWithFading", "setTextWithFadingMode", "", "duration", "setAnimationDuration", "setTextWithEllipsisImmediately", "maxWidthPx", "setMaxWidth", "Landroid/view/View;", "getA11yDescView", "getContent", "isInAnimation", "speedPx", "setSpeed", "Lkotlin/Function1;", SendEventContainerMethodParamModel.EventKinds.onClick, "setOnClickListener", Scraps.INNER_UNIT, "", "size", "setTextSize", "color", "setTextColor", "includepad", "setIncludeFontPadding", "Landroid/graphics/Paint;", "getPaint", "needEdge", "textNeedLeftEdge", "action", "Lcom/bytedance/android/livesdk/common/j$a;", "marqueeCallback", "scrollToOrigin", BasicTestActionHandler.TEST_ACTION_RESET, "cancelAnimation", "isScrollEnd", "setScrollEnd", "getOriginText", "lastWidth", "I", "animDuration", "J", "Lcom/bytedance/android/livesdk/common/MatchMarqueeTextView$FadingEdgeHorizontalScrollView;", "scrollView", "Lcom/bytedance/android/livesdk/common/MatchMarqueeTextView$FadingEdgeHorizontalScrollView;", "Lcom/bytedance/android/livesdk/common/MatchTitleTextView;", "realTextView", "Lcom/bytedance/android/livesdk/common/MatchTitleTextView;", "getRealTextView", "()Lcom/bytedance/android/livesdk/common/MatchTitleTextView;", "setRealTextView", "(Lcom/bytedance/android/livesdk/common/MatchTitleTextView;)V", "marqueeSpeedPx", "originText", "Ljava/lang/String;", "Landroid/animation/Animator;", "animator", "Landroid/animation/Animator;", "lastTextEndState", "Z", "infix", "Lcom/bytedance/android/livesdk/common/j$a;", "isScrollEndFinish", "()Z", "setScrollEndFinish", "(Z)V", "getDpInt", "(I)I", "dpInt", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FadingEdgeHorizontalScrollView", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchMarqueeTextView extends FrameLayout implements j {
    public static final a Companion = null;
    private static final int DEFAULT_SPEED_DP = 24;
    private static final int ELLIPSIS = 2;
    private static final int FADING = 1;
    private long animDuration;
    private Animator animator;
    private final String infix;
    private boolean isInAnimation;
    private boolean isScrollEndFinish;
    private int lastTextEndState;
    private int lastWidth;
    private j.a marqueeCallback;
    private int marqueeSpeedPx;
    private String originText;
    private MatchTitleTextView realTextView;
    private FadingEdgeHorizontalScrollView scrollView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/common/MatchMarqueeTextView$FadingEdgeHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "needLeftEdge", "", "getNeedLeftEdge", "()Z", "setNeedLeftEdge", "(Z)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getLeftFadingEdgeStrength", "", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FadingEdgeHorizontalScrollView extends HorizontalScrollView {
        private boolean needLeftEdge;

        public FadingEdgeHorizontalScrollView(Context r100) {
            this(r100, null, 0, 6, null);
        }

        public FadingEdgeHorizontalScrollView(Context r100, AttributeSet r101) {
            this(r100, r101, 0, 4, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "ev");
            return false;
        }

        @Override // android.widget.HorizontalScrollView, android.view.View
        public float getLeftFadingEdgeStrength() {
            if (this.needLeftEdge == false) goto L5;
            return 1.0f;
        L5:
            return 0.0f;
        }

        public final boolean getNeedLeftEdge() {
            return this.needLeftEdge;
        }

        public final void setNeedLeftEdge(boolean r100) {
            this.needLeftEdge = r100;
        }

        public FadingEdgeHorizontalScrollView(Context r100, AttributeSet r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101, r102);
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
        public final /* synthetic */ Function1 f119672a;

        public b(Function1 r100) {
            this.f119672a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View r100) {
            this.f119672a.invoke(r100);
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatchMarqueeTextView f119673a;

        public c(MatchMarqueeTextView r100) {
            this.f119673a = r100;
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
            MatchTitleTextView r104 = this.f119673a.getRealTextView();
            if (r104 == null) goto L12;
            r104.scrollTo(r103, 0);
            return;
        L12:
            return;
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatchMarqueeTextView f119674a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public d(MatchMarqueeTextView r100) {
            this.f119674a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            MatchMarqueeTextView.access$setInAnimation$p(this.f119674a, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            MatchMarqueeTextView.access$setInAnimation$p(this.f119674a, false);
            j.a r101 = MatchMarqueeTextView.access$getMarqueeCallback$p(this.f119674a);
            if (r101 == null) goto L6;
            r101.onEnd();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            MatchMarqueeTextView.access$setInAnimation$p(this.f119674a, true);
        }
    }

    public static final class e implements j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f119675a;

        @Override // com.bytedance.android.livesdk.common.j.a
        public final void onEnd() {
        }

        @Override // com.bytedance.android.livesdk.common.j.a
        public final void onStart() {
            Function1 r100 = this.f119675a;
            if (r100 == null) goto L6;
            Unit r101 = (Unit) r100.invoke(Boolean.TRUE);
            return;
        }

        public e(Function1 r100) {
            this.f119675a = r100;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatchMarqueeTextView f119676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j.a f119677b;

        public f(MatchMarqueeTextView r100, j.a r101) {
            this.f119676a = r100;
            this.f119677b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MatchMarqueeTextView.access$setMarqueeCallback$p(this.f119676a, this.f119677b);     // Catch: Throwable -> L4
            MatchMarqueeTextView.access$startMarqueeIfNeed(this.f119676a);     // Catch: Throwable -> L4
            this.f119677b.onStart();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public MatchMarqueeTextView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public MatchMarqueeTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    private final String getEndAnimationText() {
        int r100 = getEllipsisStart(this.originText);
        if (r100 <= 0) goto L5;
        MatchTitleTextView r101 = this.realTextView;
        if (r101 == null) goto L30;
        TextPaint r102 = r101.getPaint();
        if (r102 == null) goto L30;
        int r103 = getWidth();
        if (r103 <= 0) goto L14;
        String r104 = this.originText;
        if (r104 == null) goto L30;
        StringBuilder r105 = new StringBuilder(r104.subSequence(0, r100));
        r105.append("...");
    L18:
        float r106 = r103;
        if (r102.measureText(r105.toString()) <= r106) goto L26;
        if ((r105.length() - 4) < 0) goto L23;
        r105.deleteCharAt(r105.length() - 4);
        goto L18
    L23:
        return r105.toString();
    L26:
        if (r102.measureText(r105.toString()) >= r106) goto L29;
        r105.append(' ');
        goto L26
    L29:
        return r105.toString();
    L14:
        return this.originText;
    L30:
        return null;
    L5:
        return this.originText;
    }

    private final boolean startMarqueeIfNeed() {
        int r100 = getEllipsisStart(this.originText);
        if (r100 <= 0) goto L15;
        String r101 = this.originText;
        if (r101 == null) goto L7;
        int r102 = r101.length();
    L8:
        if (r100 >= r102) goto L15;
        cancelAnimation();
        Pair<String, Integer> r103 = getMarqueeTextAndWidth();
        MatchTitleTextView r104 = this.realTextView;
        if (r104 == null) goto L13;
        r104.setText(r103.getFirst());
    L13:
        startAnimation(r103.getSecond().intValue());
        return true;
    L7:
        r102 = 0;
    L15:
        return false;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void cancelAnimation() {
        Animator r100 = this.animator;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.animator = null;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public String getContent() {
        MatchTitleTextView r100 = this.realTextView;
        if (r100 == null) goto L7;
        CharSequence r101 = r100.getText();
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public Paint getPaint() {
        MatchTitleTextView r100 = this.realTextView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPaint();
    }

    public final void reset() {
        MatchTitleTextView r100 = this.realTextView;
        if (r100 == null) goto L6;
        r100.x();
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void scrollToOrigin() {
        MatchTitleTextView r100 = this.realTextView;
        if (r100 == null) goto L5;
        r100.x();
    L5:
        FadingEdgeHorizontalScrollView r101 = this.scrollView;
        if (r101 == null) goto L9;
        r101.scrollTo(0, 0);
        return;
    }

    private final Pair<String, Integer> getMarqueeTextAndWidth() {
        String r100 = getEndAnimationText();
        String r101 = this.originText + this.infix;
        float r102 = 0.0f;
        if (this.isScrollEndFinish == false) goto L10;
        MatchTitleTextView r103 = this.realTextView;
        if (r103 == null) goto L9;
        TextPaint r104 = r103.getPaint();
        if (r104 == null) goto L9;
        r102 = r104.measureText(r101);
    L9:
        int r105 = ((int) r102) - getWidth();
    L17:
        return TuplesKt.to(r101 + r100, Integer.valueOf(r105));
    L10:
        MatchTitleTextView r106 = this.realTextView;
        if (r106 == null) goto L15;
        TextPaint r107 = r106.getPaint();
        if (r107 == null) goto L15;
        r102 = r107.measureText(r101);
    L15:
        r105 = (int) r102;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.common.j
    public View getA11yDescView() {
        return this.realTextView;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public String getOriginText() {
        return this.originText;
    }

    public final MatchTitleTextView getRealTextView() {
        return this.realTextView;
    }

    public final boolean isInAnimation() {
        return this.isInAnimation;
    }

    public final boolean isScrollEndFinish() {
        return this.isScrollEndFinish;
    }

    public static final /* synthetic */ j.a access$getMarqueeCallback$p(MatchMarqueeTextView r100) {
        return r100.marqueeCallback;
    }

    public static final /* synthetic */ boolean access$isInAnimation$p(MatchMarqueeTextView r100) {
        return r100.isInAnimation;
    }

    public static final /* synthetic */ boolean access$startMarqueeIfNeed(MatchMarqueeTextView r100) {
        return r100.startMarqueeIfNeed();
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
        MatchTitleTextView r103 = this.realTextView;
        if (r103 == null) goto L27;
        TextPaint r104 = r103.getPaint();
        if (r104 == null) goto L27;
        float r105 = getWidth();
        if (r104.measureText(r100) > r105) goto L20;
        return 0;
    L20:
        StringBuilder r106 = new StringBuilder();
        int r107 = 0;
    L22:
        if (r101 >= r100.length()) goto L27;
        int r108 = r107 + 1;
        r106.append(r100.charAt(r101));
        if (r104.measureText(r106.toString()) >= r105) goto L25;
        r101 = r101 + 1;
        r107 = r108;
        goto L22
    L25:
        return r107;
    L27:
        return -1;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    private final void startAnimation(int r100) {
        Animator r101 = this.animator;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        MatchTitleTextView r102 = this.realTextView;
        if (r102 == null) goto L8;
        r102.scrollTo(0, 0);
    L8:
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{0, r100});
        r103.setInterpolator(new LinearInterpolator());
        long r104 = this.animDuration;
        if (r104 > 0) goto L12;
        r104 = (r100 * 1000) / this.marqueeSpeedPx;
    L12:
        r103.setDuration(r104);
        r103.addUpdateListener(new c(this));
        r103.addListener(new d(this));
        r103.start();
        Unit r105 = Unit.INSTANCE;
        this.animator = r103;
    }

    public void setAnimationDuration(long r100) {
        this.animDuration = r100;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setIncludeFontPadding(boolean r100) {
        MatchTitleTextView r101 = this.realTextView;
        if (r101 == null) goto L6;
        r101.setIncludeFontPadding(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setMaxWidth(int r100) {
        MatchTitleTextView r101 = this.realTextView;
        if (r101 == null) goto L5;
        r101.setMaxWidth(r100);
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

    public final void setOnClickListener(Function1<? super View, Unit> r100) {
        MatchTitleTextView r101 = this.realTextView;
        Object r102 = r100;
        if (r101 == null) goto L8;
        if (r100 == null) goto L6;
        r102 = new b(r100);
    L6:
        r101.setOnClickListener((View.OnClickListener) r102);
        return;
    }

    public final void setRealTextView(MatchTitleTextView r100) {
        this.realTextView = r100;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setScrollEnd(boolean r100) {
        this.isScrollEndFinish = r100;
    }

    public final void setScrollEndFinish(boolean r100) {
        this.isScrollEndFinish = r100;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setSpeed(int r100) {
        this.marqueeSpeedPx = r100;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextColor(int r100) {
        MatchTitleTextView r101 = this.realTextView;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextWithEllipsis(String r100) {
        setTextWithEllipsisImmediately(r100);
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextWithEllipsisImmediately(String r100) {
        if (this.isInAnimation == false) goto L7;
        Animator r101 = this.animator;
        if (r101 == null) goto L7;
        r101.cancel();
    L7:
        this.lastTextEndState = 2;
        MatchTitleTextView r102 = this.realTextView;
        if (r102 == null) goto L10;
        r102.x();
    L10:
        this.originText = r100;
        MatchTitleTextView r103 = this.realTextView;
        if (r103 == null) goto L14;
        r103.setText(getEndAnimationText());
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextWithFading(String r100) {
        setTextWithEllipsisImmediately(r100);
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextWithFadingMode(String r100) {
        this.lastTextEndState = 1;
        this.originText = r100;
        MatchTitleTextView r101 = this.realTextView;
        if (r101 == null) goto L5;
        r101.setText(r100);
    L5:
        FadingEdgeHorizontalScrollView r102 = this.scrollView;
        if (r102 == null) goto L9;
        r102.scrollTo(0, 0);
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void startMarqueeIfNeed(j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "marqueeCallback");
        post(new f(this, r100));
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void textNeedLeftEdge(boolean r100) {
        FadingEdgeHorizontalScrollView r101 = this.scrollView;
        if (r101 == null) goto L5;
        r101.setNeedLeftEdge(r100);
    L5:
        if (r100 == false) goto L13;
        FadingEdgeHorizontalScrollView r102 = this.scrollView;
        if (r102 == null) goto L9;
        r102.setFadingEdgeLength(getDpInt(20));
    L9:
        FadingEdgeHorizontalScrollView r103 = this.scrollView;
        if (r103 == null) goto L14;
        r103.setScrollbarFadingEnabled(true);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void startMarqueeIfNeed(Function1<? super Boolean, Unit> r100) {
        startMarqueeIfNeed(new e(r100));
    }

    public static final /* synthetic */ void access$setInAnimation$p(MatchMarqueeTextView r100, boolean r101) {
        r100.isInAnimation = r101;
    }

    public static final /* synthetic */ void access$setMarqueeCallback$p(MatchMarqueeTextView r100, j.a r101) {
        r100.marqueeCallback = r101;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextSize(int r100, float r101) {
        MatchTitleTextView r102 = this.realTextView;
        if (r102 == null) goto L6;
        r102.setTextSize(r100, r101);
        return;
    }

    public MatchMarqueeTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.lastWidth = -1;
        this.animDuration = -1;
        this.marqueeSpeedPx = getDpInt(24);
        this.infix = "       ";
        LayoutInflater.from(r100).inflate(R.layout.ttlive_match_marquee_textview, this, true);
        this.scrollView = (FadingEdgeHorizontalScrollView) findViewById(R.id.scrollView);
        this.realTextView = (MatchTitleTextView) findViewById(R.id.match_real_text_view);
    }

    public /* synthetic */ MatchMarqueeTextView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.lastWidth != getWidth()) goto L5;
        return;
    L5:
        if (this.isInAnimation == true) goto L21;
        this.lastWidth = getWidth();
        String r105 = this.originText;
        if (r105 != null) goto L9;
        return;
    L9:
        if (r105.length() <= 0) goto L11;
        boolean r106 = true;
    L12:
        if (r106 != true) goto L23;
        MatchTitleTextView r107 = this.realTextView;
        if (r107 == null) goto L16;
        r107.x();
    L16:
        MatchTitleTextView r108 = this.realTextView;
        if (r108 == null) goto L24;
        r108.setText(getEndAnimationText());
        return;
    L24:
        return;
    L23:
        return;
    L11:
        r106 = false;
        goto L12
    }
}
