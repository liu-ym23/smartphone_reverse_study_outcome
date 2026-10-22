package com.bytedance.ai.api.model.floating;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.byted.cast.common.CastMonitor;
import com.bytedance.ai.utils.l;
import com.bytedance.common.utility.UIUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 U2\u00020\u0001:\u0003STUB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010(\u001a\u00020)H\u0002J\u0012\u0010*\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0014J\b\u0010/\u001a\u00020\u0017H\u0002J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0007H\u0016J\u0010\u00102\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00103\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002J\u001e\u00104\u001a\u00020)2\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u000106J\u0006\u00107\u001a\u00020)J\u001c\u00108\u001a\u00020)2\b\b\u0002\u00109\u001a\u00020\u00172\b\b\u0002\u0010:\u001a\u00020\u0017H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0014J\u0018\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0012\u0010C\u001a\u00020)2\b\u0010D\u001a\u0004\u0018\u00010EH\u0014J\u0012\u0010F\u001a\u00020)2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u000e\u0010I\u001a\u00020)2\u0006\u0010<\u001a\u00020\u0007J\u0018\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0007H\u0014J0\u0010M\u001a\u00020)2\u0006\u0010N\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/bytedance/ai/api/model/floating/FloatingView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOriginalRawX", "", "mOriginalRawY", "mOriginalX", "mOriginalY", "mLastTouchDownTime", "", "mMoveAnimator", "Lcom/bytedance/ai/api/model/floating/FloatingView$MoveAnimator;", "mScreenWidth", "mScreenHeight", "mStatusBarHeight", "isNearestLeft", "", "longClickRunnable", "Lcom/bytedance/ai/api/model/floating/FloatingView$LongClickRunnable;", "scaledTouchSlop", "autoToEdge", "getAutoToEdge", "()Z", "setAutoToEdge", "(Z)V", "hasFirstDraw", "firstPos", "", "getFirstPos", "()D", "setFirstPos", "(D)V", "nowWidth", "init", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "dealClickEvent", "dealLongClickEvent", "isClickEvent", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "updateViewPosition", "changeOriginalTouchParams", "updateSize", "screenHeightRange", "Landroid/util/Pair;", "resetLocation", "moveToEdge", "isLeft", "isWidthChange", "onSizeChanged", "w", "h", "oldw", "oldh", "move", "deltaX", "deltaY", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "addWebView", "view", "Landroid/view/View;", "setRealWidth", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "LongClickRunnable", "MoveAnimator", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FloatingView extends FrameLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f34020p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f34021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f34022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f34023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f34024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f34025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f34026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f34027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f34028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f34029i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f34030j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f34031k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f34032l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f34033m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public double f34034n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f34035o;

    public static final class a {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f34036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FloatingView f34037b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f34037b.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(FloatingView r100) {
            this.f34037b = r100;
            this.f34036a = new Handler(Looper.getMainLooper());
        }
    }

    public final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f34038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f34039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f34040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f34041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34042e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FloatingView f34043f;

        public final void a() {
            if (this.f34043f.getRootView() != null) goto L5;
            return;
        L5:
            if (this.f34043f.getRootView().getParent() != null) goto L8;
            return;
        L8:
            if (this.f34042e == false) goto L10;
            float r100 = 1.0f;
        L11:
            float r101 = (this.f34039b - this.f34043f.getX()) * r100;
            float r102 = (this.f34040c - this.f34043f.getY()) * r100;
            FloatingView r103 = this.f34043f;
            int r104 = FloatingView.f34020p;
            r103.setX(r103.getX() + r101);
            r103.setY(r103.getY() + r102);
            if (r100 >= 1.0f) goto L16;
            this.f34038a.post(this);
            return;
        L16:
            return;
        L10:
            r100 = Math.min(1.0f, (System.currentTimeMillis() - this.f34041d) / 400.0f);
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(FloatingView r100) {
            this.f34043f = r100;
            this.f34038a = new Handler(Looper.getMainLooper());
        }
    }

    static {
    }

    public FloatingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FloatingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static /* synthetic */ void a(FloatingView r100) {
        setRealWidth$lambda$0(r100);
    }

    public final boolean b() {
        if (getX() >= (this.f34026f / 2)) goto L5;
        boolean r100 = true;
    L6:
        this.f34029i = r100;
        return r100;
    L5:
        r100 = false;
        goto L6
    }

    public final void d() {
        float r100 = getY() + getHeight();
        int r101 = this.f34027g;
        if (r100 > r101) goto L5;
        return;
    L5:
        if (r101 <= getHeight()) goto L9;
        setY(this.f34027g - getHeight());
        return;
    }

    public final boolean getAutoToEdge() {
        return this.f34032l;
    }

    public final double getFirstPos() {
        return this.f34034n;
    }

    private static final void setRealWidth$lambda$0(FloatingView r100) {
        r100.requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.getAction();
        if (r101 != 0) goto L8;
        this.f34023c = getX();
        this.f34024d = getY();
        this.f34021a = r100.getRawX();
        this.f34022b = r100.getRawY();
        System.currentTimeMillis();
        b r102 = this.f34030j;
        r102.f34036a.postDelayed(r102, ViewConfiguration.getLongPressTimeout());
        e(null);
        c r103 = this.f34025e;
        if (r103 == null) goto L31;
        r103.f34038a.removeCallbacks(r103);
    L31:
        return super.dispatchTouchEvent(r100);
    L8:
        if (r101 != 1) goto L10;
        b r104 = this.f34030j;
        r104.f34036a.removeCallbacks(r104);
        if (this.f34032l == false) goto L26;
        c(this, false, false, 3);
    L26:
        System.currentTimeMillis();
        goto L31
    L10:
        if (r101 != 2) goto L31;
        setX((this.f34023c + r100.getRawX()) - this.f34021a);
        float r105 = (this.f34024d + r100.getRawY()) - this.f34022b;
        float r106 = this.f34028h;
        if (r105 >= r106) goto L16;
        r105 = r106;
    L16:
        if (r105 <= (this.f34027g - getHeight())) goto L18;
        r105 = this.f34027g - getHeight();
    L18:
        setY(r105);
        if (Math.abs(r100.getRawX() - this.f34021a) <= this.f34031k) goto L21;
    L22:
        b r107 = this.f34030j;
        r107.f34036a.removeCallbacks(r107);
        goto L31
    L21:
        if (Math.abs(r100.getRawY() - this.f34022b) <= this.f34031k) goto L31;
        goto L22
    }

    public final void e(Pair<Integer, Integer> r100) {
        this.f34026f = l.c(null) - getWidth();
        if (r100 != null) goto L6;
        return;
    L6:
        if (((Number) r100.first).intValue() <= 0) goto L9;
        this.f34028h = ((Number) r100.first).intValue();
    L9:
        if (((Number) r100.second).intValue() <= 0) goto L12;
        this.f34027g = ((Number) r100.second).intValue();
        return;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        e(null);
        c(this, this.f34029i, false, 2);
    }

    public final void setAutoToEdge(boolean r100) {
        this.f34032l = r100;
    }

    public final void setFirstPos(double r100) {
        this.f34034n = r100;
    }

    public final void setRealWidth(int r100) {
        this.f34035o = r100;
        post(new i2.b(this));
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(0);
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        getChildAt(r102).setVisibility(0);
        r102 = r102 + 1;
        goto L3
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(this.f34035o, getMeasuredHeight());
    }

    public FloatingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f34027g = l.b(null);
        this.f34028h = UIUtils.getStatusBarHeight(r100);
        this.f34029i = true;
        this.f34030j = new b(this);
        this.f34031k = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f34032l = true;
        this.f34034n = 0.5d;
        this.f34025e = new c(this);
        setClickable(true);
        setLongClickable(true);
        e(null);
    }

    public /* synthetic */ FloatingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void c(FloatingView r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        r101 = r100.b();
    L5:
        int r104 = 0;
        if ((r103 & 2) == 0) goto L8;
        r102 = false;
    L8:
        if (r101 == true) goto L11;
        r104 = 0 + r100.f34026f;
    L11:
        float r105 = r104;
        c r106 = r100.f34025e;
        if (r106 == null) goto L15;
        float r107 = r100.getY();
        r106.f34039b = r105;
        r106.f34040c = r107;
        r106.f34041d = System.currentTimeMillis();
        r106.f34042e = r102;
        r106.f34038a.post(r106);
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        e(null);
        if (this.f34033m == true) goto L6;
        this.f34033m = true;
        int r104 = this.f34027g;
        int r105 = this.f34028h;
        setY((((r104 - r105) - r101) * (1 - ((float) this.f34034n))) + r105);
    L6:
        if (b() == false) goto L8;
        setX(0.0f);
        return;
    L8:
        c r106 = this.f34025e;
        if (r106 == null) goto L11;
        r106.f34038a.removeCallbacks(r106);
    L11:
        c(this, false, true, 1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (b() == false) goto L5;
        setX(0.0f);
        return;
    L5:
        setX((l.c(null) - this.f34035o) - 0.0f);
        if (getX() >= 0.0f) goto L10;
        setX(0.0f);
        return;
    }
}
