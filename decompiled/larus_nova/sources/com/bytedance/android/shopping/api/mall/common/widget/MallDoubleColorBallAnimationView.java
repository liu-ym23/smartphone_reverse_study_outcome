package com.bytedance.android.shopping.api.mall.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0018\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/widget/MallDoubleColorBallAnimationView;", "Landroid/view/View;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "size", "setProgressBarInfo", "", "progress", "setProgress", "cycleBias", "setCycleBias", "", BaseSwitches.V, "Lkotlin/Lazy;", "getMExpDelay", "()J", "mExpDelay", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallDoubleColorBallAnimationView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f170472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f170473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f170474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f170475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f170476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f170477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f170478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f170479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f170480i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PorterDuffXfermode f170481j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f170482k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f170483l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f170484m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f170485n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f170486o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f170487p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f170488q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f170489r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f170490s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f170491t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f170492u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f170493v;

    private final long getMExpDelay() {
        return ((Number) this.f170493v.getValue()).longValue();
    }

    public final void a() {
        this.f170487p = -1;
        if (this.f170488q > 0) goto L5;
        setProgressBarInfo(getContext().getResources().getDimensionPixelSize(R.dimen.shopping_mall_default_loading_side));
    L5:
        int r100 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.f170488q <= r100) goto L10;
        if (r100 <= 0) goto L10;
        setProgressBarInfo(r100);
    L10:
        if (this.f170480i != null) goto L12;
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        r101.setDither(true);
        r101.setStyle(Paint.Style.FILL);
        this.f170480i = r101;
    L12:
        this.f170484m = true;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f170486o = false;
        this.f170484m = false;
        this.f170482k = 0.0f;
    }

    public MallDoubleColorBallAnimationView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
        b(r100);
    }

    public final void b(Context r100) {
        this.f170478g = ContextCompat.getColor(r100, R.color.shopping_home_loading_color1);
        this.f170479h = ContextCompat.getColor(r100, R.color.shopping_home_loading_color2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f170486o == true) goto L7;
        if (this.f170483l == false) goto L7;
        return;
    L7:
        if (this.f170484m == false) goto L40;
        boolean r100 = false;
        if (this.f170483l == false) goto L18;
        long r101 = System.nanoTime() / ((long) 1000000);
        if (this.f170487p >= 0) goto L14;
        this.f170487p = r101;
    L14:
        float r102 = (r101 - this.f170487p) / this.f170476e;
        this.f170482k = r102;
        int r103 = (int) r102;
        if (((this.f170485n + r103) & 1) != 1) goto L17;
        r100 = true;
    L17:
        this.f170482k = r102 - r103;
        boolean r111 = r100;
    L19:
        float r104 = this.f170482k;
        if (r104 >= 0.5d) goto L22;
        float r105 = (2 * r104) * r104;
    L23:
        float r112 = r105;
        int r106 = this.f170488q;
        int r107 = r110.saveLayer(0.0f, 0.0f, r106, r106, this.f170480i, 31);
        float r108 = (this.f170492u * r112) + this.f170491t;
        if (r112 >= 0.5d) goto L26;
        float r113 = r112 * 2.0f;
    L27:
        float r109 = this.f170472a * r113;
        float r114 = this.f170490s;
        float r115 = (r109 * r114) + r114;
        Paint r116 = this.f170480i;
        Intrinsics.checkNotNull(r116);
        if (r111 == false) goto L30;
        int r117 = this.f170479h;
    L31:
        r116.setColor(r117);
        float r118 = this.f170489r;
        Paint r119 = this.f170480i;
        Intrinsics.checkNotNull(r119);
        r110.drawCircle(r108, r118, r115, r119);
        float r120 = this.f170488q - r108;
        float r121 = this.f170490s;
        float r122 = r121 - ((r113 * this.f170473b) * r121);
        Paint r123 = this.f170480i;
        Intrinsics.checkNotNull(r123);
        if (r111 == false) goto L34;
        int r124 = this.f170478g;
    L35:
        r123.setColor(r124);
        Paint r125 = this.f170480i;
        Intrinsics.checkNotNull(r125);
        r125.setXfermode(this.f170481j);
        float r126 = this.f170489r;
        Paint r127 = this.f170480i;
        Intrinsics.checkNotNull(r127);
        r110.drawCircle(r120, r126, r122, r127);
        Paint r128 = this.f170480i;
        Intrinsics.checkNotNull(r128);
        r128.setXfermode(null);
        r110.restoreToCount(r107);
        if (getMExpDelay() <= 0) goto L38;
        postInvalidateDelayed(getMExpDelay());
        return;
    L38:
        postInvalidateDelayed(this.f170477f);
        return;
    L34:
        r124 = this.f170479h;
        goto L35
    L30:
        r117 = this.f170478g;
        goto L31
    L26:
        float r129 = 2;
        r113 = r129 - (r112 * r129);
        goto L27
    L22:
        float r130 = 2;
        r105 = ((r130 * r104) * (r130 - r104)) - 1;
        goto L23
    L18:
        r111 = false;
        goto L19
    }

    public final void setCycleBias(int r100) {
        this.f170485n = r100;
    }

    public final void setProgress(float r100) {
        if (this.f170484m == true) goto L5;
        a();
    L5:
        this.f170482k = r100;
        this.f170486o = false;
        this.f170483l = false;
        postInvalidate();
    }

    public final void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L5;
        this.f170488q = r100;
        this.f170489r = r100 / 2.0f;
        float r101 = (r100 >> 1) * this.f170475d;
        this.f170490s = r101;
        float r102 = (this.f170474c * r100) + r101;
        this.f170491t = r102;
        this.f170492u = r100 - (r102 * 2);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        a();
        this.f170486o = true;
        this.f170483l = true;
        postInvalidate();
        return;
    L5:
        this.f170486o = false;
        this.f170484m = false;
        this.f170482k = 0.0f;
    }

    public MallDoubleColorBallAnimationView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
        b(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = Math.min(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        if (this.f170488q <= r102) goto L7;
        if (r102 <= 0) goto L8;
        setProgressBarInfo(r102);
        return;
    L8:
        return;
    }

    public MallDoubleColorBallAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f170472a = 0.25f;
        this.f170473b = 0.375f;
        this.f170474c = 0.16f;
        this.f170475d = 0.32f;
        this.f170476e = 400.0f;
        this.f170477f = 17;
        this.f170481j = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.f170487p = -1;
        this.f170488q = -1;
        this.f170493v = LazyKt.lazy(MallDoubleColorBallAnimationView$mExpDelay$2.INSTANCE);
        b(r100);
    }
}
