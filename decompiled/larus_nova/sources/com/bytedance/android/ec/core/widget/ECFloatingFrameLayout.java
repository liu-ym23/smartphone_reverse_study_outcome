package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.l0;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0003\u0007\u0019\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u00028\u0014X\u0094D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECFloatingFrameLayout;", "Landroid/widget/FrameLayout;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getAutoToEdge", "()Z", "setAutoToEdge", "(Z)V", "autoToEdge", "marginEdge", "I", "getMarginEdge", "()I", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECFloatingFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f45917m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f45918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f45919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f45920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f45921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f45922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f45923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f45924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f45925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f45926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f45927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f45928k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f45929l;

    public static final class a {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f45930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECFloatingFrameLayout f45931b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f45931b.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ECFloatingFrameLayout r100) {
            this.f45931b = r100;
            this.f45930a = new Handler(Looper.getMainLooper());
        }
    }

    public final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f45932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f45933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f45934c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f45935d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ECFloatingFrameLayout f45936e;

        public final void a() {
            if (this.f45936e.getRootView() != null) goto L5;
            return;
        L5:
            if (this.f45936e.getRootView().getParent() == null) goto L13;
            float r100 = RangesKt.coerceAtMost(1.0f, (System.currentTimeMillis() - this.f45935d) / 400.0f);
            float r101 = (this.f45933b - this.f45936e.getX()) * r100;
            float r102 = (this.f45934c - this.f45936e.getY()) * r100;
            ECFloatingFrameLayout r103 = this.f45936e;
            int r104 = ECFloatingFrameLayout.f45917m;
            r103.setX(r103.getX() + r101);
            r103.setY(r103.getY() + r102);
            if (r100 >= 1) goto L12;
            this.f45932a.post(this);
            return;
        L12:
            return;
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

        public c(ECFloatingFrameLayout r100) {
            this.f45936e = r100;
            this.f45932a = new Handler(Looper.getMainLooper());
        }
    }

    static {
    }

    public ECFloatingFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECFloatingFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public int getMarginEdge() {
        return 0;
    }

    public final void b() {
        Point r100 = l0.f(getContext());
        if (r100 == null) goto L6;
        this.f45924g = r100.x - getWidth();
        this.f45925h = r100.y;
        return;
    }

    public boolean getAutoToEdge() {
        return this.f45918a;
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = getMarginEdge();
    L5:
        c r102 = this.f45923f;
        Intrinsics.checkNotNull(r102);
        float r103 = getY();
        r102.f45933b = r101;
        r102.f45934c = r103;
        r102.f45935d = System.currentTimeMillis();
        r102.f45932a.post(r102);
        return;
    L4:
        r101 = this.f45924g - getMarginEdge();
        goto L5
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        b();
        a(this.f45927j);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        int r102 = r100.getAction();
        if (r102 != 0) goto L8;
        this.f45921d = getX();
        this.f45922e = getY();
        this.f45919b = r100.getRawX();
        this.f45920c = r100.getRawY();
        System.currentTimeMillis();
        b r103 = this.f45928k;
        r103.f45930a.postDelayed(r103, ViewConfiguration.getLongPressTimeout());
        b();
        c r104 = this.f45923f;
        if (r104 == null) goto L32;
        r104.f45932a.removeCallbacks(r104);
    L32:
        return true;
    L8:
        if (r102 == 1) goto L22;
        if (r102 != 2) goto L32;
        setX((this.f45921d + r100.getRawX()) - this.f45919b);
        float r105 = (this.f45922e + r100.getRawY()) - this.f45920c;
        float r106 = this.f45926i;
        if (r105 >= r106) goto L15;
        r105 = r106;
    L15:
        if (r105 <= (this.f45925h - getHeight())) goto L17;
        r105 = this.f45925h - getHeight();
    L17:
        setY(r105);
        if (Math.abs(r100.getRawX() - this.f45919b) <= this.f45929l) goto L20;
    L21:
        b r107 = this.f45928k;
        r107.f45930a.removeCallbacks(r107);
        goto L32
    L20:
        if (Math.abs(r100.getRawY() - this.f45920c) <= this.f45929l) goto L32;
    L22:
        b r108 = this.f45928k;
        r108.f45930a.removeCallbacks(r108);
        if (getAutoToEdge() == true) goto L25;
    L28:
        System.currentTimeMillis();
        goto L32
    L25:
        if (getX() >= (this.f45924g / 2)) goto L27;
        r101 = true;
    L27:
        this.f45927j = r101;
        a(r101);
        goto L28
    }

    public void setAutoToEdge(boolean r100) {
        this.f45918a = r100;
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

    public ECFloatingFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f45918a = true;
        this.f45927j = true;
        this.f45928k = new b(this);
        this.f45929l = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f45923f = new c(this);
        this.f45926i = eh.b.b(r100);
        setClickable(true);
        setLongClickable(true);
        b();
    }

    public /* synthetic */ ECFloatingFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
