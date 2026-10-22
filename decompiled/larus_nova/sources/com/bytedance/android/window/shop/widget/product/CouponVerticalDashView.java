package com.bytedance.android.window.shop.widget.product;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/window/shop/widget/product/CouponVerticalDashView;", "Landroid/view/View;", "Lcom/bytedance/android/window/shop/widget/product/CouponVerticalDashView$a;", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/window/shop/widget/product/CouponVerticalDashView$a;", "getConfig", "()Lcom/bytedance/android/window/shop/widget/product/CouponVerticalDashView$a;", "setConfig", "(Lcom/bytedance/android/window/shop/widget/product/CouponVerticalDashView$a;)V", "config", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponVerticalDashView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f190076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f190077b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f190078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f190079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f190080c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Float.compare(this.f190078a, r101.f190078a) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.f190079b, r101.f190079b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.f190080c, r101.f190080c) == 0) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            return (((Float.floatToIntBits(this.f190078a) * 31) + Float.floatToIntBits(this.f190079b)) * 31) + Float.floatToIntBits(this.f190080c);
        }

        public final String toString() {
            return "Config(dashHeight=" + this.f190078a + ", dashGap=" + this.f190079b + ", offset=" + this.f190080c + ")";
        }

        public a(float r100, float r101, float r102) {
            this.f190078a = r100;
            this.f190079b = r101;
            this.f190080c = r102;
        }
    }

    public final a getConfig() {
        return this.f190076a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        a r101 = this.f190076a;
        if (r101 != null) goto L5;
        return;
    L5:
        float r102 = r101.f190080c;
    L7:
        if (r102 >= getHeight()) goto L9;
        r100.drawRect(0.0f, r102, getWidth(), r102 + r101.f190078a, this.f190077b);
        r102 = r102 + (r101.f190078a + r101.f190079b);
        goto L7
    }

    public final void setConfig(a r100) {
        this.f190076a = r100;
    }

    public CouponVerticalDashView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Paint r102 = new Paint();
        r102.setColor((int) 4294946745L);
        r102.setStyle(Paint.Style.FILL_AND_STROKE);
        Unit r103 = Unit.INSTANCE;
        this.f190077b = r102;
    }
}
