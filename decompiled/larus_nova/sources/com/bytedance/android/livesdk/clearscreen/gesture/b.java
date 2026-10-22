package com.bytedance.android.livesdk.clearscreen.gesture;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.ViewGroupUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPagerLayout;
import com.bytedance.android.livesdk.utils.f1;
import com.bytedance.android.livesdk.widget.f0;
import com.bytedance.android.livesdk.widget.y;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements y {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f119391t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f119392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f119393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f119394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f119395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f119396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VelocityTracker f119397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f119398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f119399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f119400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f119401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f119402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f119403l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f119404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f119405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f119406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f119407p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f119408q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WeakReference<View> f119409r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.livesdk.widget.b.d f119410s;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.y
    public final f0 getConfig() {
        return this.f119410s;
    }

    public static ViewGroup d(View r100) {
        if ((r100 instanceof PublicScreenAreaPagerLayout) == false) goto L7;
        return (ViewGroup) r100;
    L7:
        if ((r100 instanceof ViewGroup) == false) goto L20;
        ViewGroup r101 = (ViewGroup) r100;
        if (r101.getChildCount() <= 0) goto L24;
        int r102 = r101.getChildCount();
        if (r102 < 0) goto L25;
        int r103 = 0;
    L13:
        View r104 = r101.getChildAt(r103);
        if (r104 == null) goto L18;
        ViewGroup r105 = d(r104);
        if ((r105 instanceof PublicScreenAreaPagerLayout) == false) goto L18;
        return r105;
    L18:
        if (r103 == r102) goto L26;
        r103 = r103 + 1;
        goto L13
    L26:
        return null;
    L25:
        return null;
    L24:
        return null;
    L20:
        return null;
    }

    @Override // com.bytedance.android.livesdk.widget.y
    public final boolean a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        return false;
    }

    public b(final View r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r101, "ctx");
        this.f119392a = "RightScroll2LeaveRoomGestureBehavior";
        this.f119393b = ViewConfiguration.get(r101).getScaledTouchSlop();
        this.f119394c = LazyKt.lazy(RightScroll2LeaveRoomGestureBehavior$minScrollDistance$2.INSTANCE);
        this.f119395d = LazyKt.lazy(RightScroll2LeaveRoomGestureBehavior$minVelocity$2.INSTANCE);
        this.f119396e = ViewConfiguration.getMaximumFlingVelocity();
        this.f119398g = LazyKt.lazy(new RightScroll2LeaveRoomGestureBehavior$exitGestureArea$2(r100));
        this.f119400i = Float.MIN_VALUE;
        this.f119401j = Float.MIN_VALUE;
        this.f119407p = new Rect();
        this.f119410s = com.bytedance.android.livesdk.widget.b.d.f161419c;
    }

    @Override // com.bytedance.android.livesdk.widget.y
    public final boolean b(ViewGroup r100, MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r110, "ev");
        int r101 = r110.getAction() & 255;
        if (r101 != 0) goto L5;
        this.f119400i = r110.getX();
        float r111 = r110.getY();
        this.f119401j = r111;
        this.f119402k = this.f119400i;
        this.f119403l = r111;
        this.f119404m = 0.0f;
        this.f119405n = 0.0f;
        this.f119408q = false;
        this.f119406o = false;
        this.f119399h = ((Rect) this.f119398g.getValue()).contains((int) this.f119400i, (int) this.f119401j);
        WeakReference<View> r112 = this.f119409r;
        if (r112 == null) goto L42;
        if (r112.get() == null) goto L42;
    L47:
        float r113 = this.f119400i;
        float r102 = this.f119401j;
        WeakReference<View> r103 = this.f119409r;
        if (r103 == null) goto L57;
        View r104 = r103.get();
        if (r104 == null) goto L57;
        int r114 = (int) r113;
        int r105 = (int) r102;
        ViewGroupUtils.getDescendantRect(r100, r104, this.f119407p);
        boolean r106 = this.f119407p.contains(r114, r105);     // Catch: Throwable -> L54
        this.f119407p.setEmpty();
        this.f119408q = r106;
        ALogger.d(this.f119392a, "是否点击了公屏：" + this.f119408q);
    L54:
        th = move-exception;
        this.f119407p.setEmpty();
        throw th;
    L57:
        return false;
    L42:
        if (r100 == null) goto L45;
        Object r107 = r100.findViewById(R.id.public_screen_area_pager);
        if (r107 == null) goto L45;
    L46:
        this.f119409r = new WeakReference(r107);
        Unit r115 = Unit.INSTANCE;
    L45:
        r107 = d(r100);
        goto L46
    L5:
        if (r101 != 2) goto L57;
        if (this.f119399h == true) goto L10;
    L36:
        return false;
    L10:
        if (this.f119408q == false) goto L36;
        float r108 = r110.getX();
        float r116 = r110.getY();
        float r109 = r108 - this.f119400i;
        float r117 = r116 - this.f119401j;
        this.f119404m = r108 - this.f119402k;
        this.f119405n = r116 - this.f119403l;
        if (this.f119406o == false) goto L15;
    L21:
        WeakReference<View> r118 = this.f119409r;
        if (r118 == null) goto L28;
        View r119 = r118.get();
        if (r119 == null) goto L28;
        if (r119.canScrollHorizontally(-1) != true) goto L28;
        boolean r120 = true;
    L29:
        ALogger.d(this.f119392a, "onInterceptTouchEvent, dx=" + this.f119404m + ", dy=" + this.f119405n + ", totalDx=" + r109 + ", totalDy=" + r117 + ", touchSlop=" + this.f119393b + ", isScrollRight=" + this.f119406o + ", canPSScrollRight=" + r120);
        this.f119402k = r108;
        this.f119403l = r116;
        if (this.f119406o == false) goto L57;
        if (this.f119408q == false) goto L57;
        if (r120 == true) goto L57;
        ALogger.d(this.f119392a, "开始在公屏上右滑了，拦截事件");
        return true;
    L28:
        r120 = false;
        goto L29
    L15:
        if (Math.abs(r109) > Math.abs(r117)) goto L17;
    L19:
        boolean r121 = false;
    L20:
        this.f119406o = r121;
        goto L21
    L17:
        if (r109 < this.f119393b) goto L19;
        r121 = true;
        goto L20
    }

    @Override // com.bytedance.android.livesdk.widget.y
    public final boolean c(ViewGroup r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r101, "ev");
        y.a.a(r100, r101);
        return false;
    }

    @Override // com.bytedance.android.livesdk.widget.y
    public final boolean onTouchEvent(ViewGroup r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r110, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r111, "ev");
        if (this.f119397f != null) goto L5;
        this.f119397f = VelocityTracker.obtain();
    L5:
        VelocityTracker r112 = this.f119397f;
        if (r112 == null) goto L8;
        r112.addMovement(r111);
    L8:
        int r113 = r111.getAction();
        float r100 = 0.0f;
        boolean r101 = false;
        if (r113 == 0) goto L74;
        boolean r102 = true;
        if (r113 == 1) goto L35;
        if (r113 == 2) goto L22;
        if (r113 != 3) goto L75;
        ALogger.d(this.f119392a, "ACTION_CANCEL");
        VelocityTracker r114 = this.f119397f;
        if (r114 == null) goto L20;
        r114.recycle();
    L20:
        this.f119397f = null;
    L75:
        return r101;
    L22:
        if (this.f119399h == true) goto L24;
        return false;
    L24:
        float r115 = r111.getX();
        float r116 = r111.getY();
        float r103 = r115 - this.f119402k;
        this.f119404m = r103;
        this.f119405n = r116 - this.f119403l;
        if (this.f119406o == false) goto L27;
    L33:
        this.f119402k = r115;
        this.f119403l = r116;
        goto L75
    L27:
        if (Math.abs(r103) > (Math.abs(this.f119405n) * 1.5f)) goto L29;
    L31:
        r102 = false;
    L32:
        this.f119406o = r102;
        goto L33
    L29:
        if ((r115 - this.f119400i) < this.f119393b) goto L31;
    L35:
        if (this.f119399h == false) goto L70;
        VelocityTracker r117 = this.f119397f;
        if (r117 == null) goto L39;
        r117.computeCurrentVelocity(1000, this.f119396e);
    L39:
        if (r117 == null) goto L41;
        float r104 = r117.getYVelocity();
    L42:
        if (r117 == null) goto L44;
        r100 = r117.getXVelocity();
    L44:
        float r118 = r111.getX() - this.f119400i;
        float r119 = r111.getY() - this.f119401j;
        float r105 = this.f119404m;
        if (r105 >= this.f119405n) goto L47;
    L55:
        boolean r106 = false;
    L57:
        if (Math.abs(r100) > Math.abs(r104)) goto L59;
    L61:
        boolean r107 = false;
    L62:
        if (r106 == false) goto L65;
        if (r107 == false) goto L65;
        r101 = true;
    L65:
        ALogger.d(this.f119392a, "onTouchEvent, consume=" + r101 + ", dx=" + this.f119404m + ", dy=" + this.f119405n + ", totalX=" + r118 + ", totalY=" + r119 + "， minScrollDistance=" + ((Number) this.f119394c.getValue()).intValue() + ", isScrollRight=" + this.f119406o + ", velocityX=" + r100 + ", velocityY=" + r104 + ", minVelocity=" + ((Number) this.f119395d.getValue()).intValue() + ", isScrollSatisfy=" + r106 + ", isVelocitySatisfy=" + r107);
        if (r101 == false) goto L70;
        if (f1.a(-1996) == true) goto L70;
        ALogger.d(this.f119392a, "ACTION_UP, 右滑退出直播间");
        xs2.b.a().post(new h1(78));
        goto L70
    L59:
        if (r100 <= ((Number) this.f119395d.getValue()).intValue()) goto L61;
        r107 = true;
        goto L62
    L47:
        if (r105 < 0) goto L55;
        if (this.f119406o == false) goto L55;
        if (r118 <= r119) goto L55;
        if (r118 < ((Number) this.f119394c.getValue()).intValue()) goto L55;
        r106 = true;
        goto L57
    L41:
        r104 = 0.0f;
    L70:
        VelocityTracker r120 = this.f119397f;
        if (r120 == null) goto L73;
        r120.recycle();
    L73:
        this.f119397f = null;
        goto L75
    L74:
        this.f119400i = r111.getX();
        float r121 = r111.getY();
        this.f119401j = r121;
        this.f119402k = this.f119400i;
        this.f119403l = r121;
        this.f119404m = 0.0f;
        this.f119405n = 0.0f;
        this.f119399h = ((Rect) this.f119398g.getValue()).contains((int) this.f119400i, (int) this.f119401j);
        goto L75
    }
}
