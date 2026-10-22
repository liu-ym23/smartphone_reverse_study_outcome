package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.amap.api.col.s.ce;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001b\u0010\u001fR\u001f\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/LiveGiftViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", ce.f26391f, "Landroid/view/ViewConfiguration;", "getConfiguration", "()Landroid/view/ViewConfiguration;", "configuration", "", "h", "I", "getTouchSlop", "()I", "setTouchSlop", "(I)V", "touchSlop", "", RXScreenCaptureService.KEY_INDEX, "D", "getScrollAngle", "()D", "setScrollAngle", "(D)V", "scrollAngle", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGiftViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f126687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f126688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f126689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f126690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f126691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f126692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewConfiguration f126693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f126694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f126695i;

    public final ViewConfiguration getConfiguration() {
        return this.f126693g;
    }

    public final double getScrollAngle() {
        return this.f126695i;
    }

    public final int getTouchSlop() {
        return this.f126694h;
    }

    public LiveGiftViewPager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f126691e = -1;
        this.f126692f = -1;
        ViewConfiguration r101 = ViewConfiguration.get(getContext());
        this.f126693g = r101;
        this.f126694h = r101.getScaledPagingTouchSlop();
        this.f126695i = -1.0d;
        this.f126695i = ((Number) nz1.a.Z.getValue(null, nz1.a.f521324a[50])).doubleValue();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        int r100 = r110.getAction() & 255;
        if (r100 != 3) goto L5;
    L28:
        return false;
    L5:
        if (r100 == 1) goto L28;
        if (r100 != 0) goto L9;
        this.f126687a = r110.getX();
        this.f126688b = r110.getX();
        this.f126689c = r110.getY();
        this.f126690d = r110.getY();
        this.f126692f = r110.getPointerId(0);
        return super.onInterceptTouchEvent(r110);
    L9:
        if (r100 != 2) goto L11;
        int r101 = this.f126692f;
        if (r101 != this.f126691e) goto L15;
        return false;
    L15:
        int r102 = r110.findPointerIndex(r101);
        float r103 = r110.getX(r102) - this.f126687a;
        float r104 = Math.abs(r103);
        float r105 = r110.getY(r102);
        float r106 = Math.abs(r105 - this.f126690d);
        if (r104 > this.f126694h) goto L18;
    L25:
        return false;
    L18:
        if ((((double) r104) * Math.tan(Math.toRadians(this.f126695i))) <= r106) goto L25;
        if (r103 <= 0) goto L22;
        float r107 = this.f126688b + this.f126694h;
    L23:
        this.f126687a = r107;
        this.f126689c = r105;
        return super.onInterceptTouchEvent(r110);
    L22:
        r107 = this.f126688b - this.f126694h;
        goto L23
    L11:
        return super.onInterceptTouchEvent(r110);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        int r100 = r110.getAction() & 255;
        if (r100 != 0) goto L5;
        this.f126687a = r110.getX();
        this.f126688b = r110.getX();
        this.f126689c = r110.getY();
        this.f126690d = r110.getY();
        this.f126692f = r110.getPointerId(0);
        return super.onTouchEvent(r110);
    L5:
        if (r100 != 2) goto L7;
        int r101 = r110.findPointerIndex(this.f126692f);
        if (r101 != (-1)) goto L11;
        return false;
    L11:
        float r102 = r110.getX(r101);
        float r103 = Math.abs(r102 - this.f126687a);
        float r104 = r110.getY(r101);
        float r105 = Math.abs(r104 - this.f126689c);
        if (r103 <= this.f126694h) goto L22;
        if ((((double) r103) * Math.tan(Math.toRadians(this.f126695i))) <= r105) goto L22;
        float r106 = this.f126688b;
        if ((r102 - r106) <= 0) goto L18;
        float r107 = r106 + this.f126694h;
    L19:
        this.f126687a = r107;
        this.f126689c = r104;
        return super.onTouchEvent(r110);
    L18:
        r107 = r106 - this.f126694h;
    L22:
        return super.onTouchEvent(r110);
    L7:
        return super.onTouchEvent(r110);
    }

    public final void setScrollAngle(double r100) {
        this.f126695i = r100;
    }

    public final void setTouchSlop(int r100) {
        this.f126694h = r100;
    }

    public LiveGiftViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f126691e = -1;
        this.f126692f = -1;
        ViewConfiguration r102 = ViewConfiguration.get(getContext());
        this.f126693g = r102;
        this.f126694h = r102.getScaledPagingTouchSlop();
        this.f126695i = -1.0d;
        this.f126695i = ((Number) nz1.a.Z.getValue(null, nz1.a.f521324a[50])).doubleValue();
    }
}
