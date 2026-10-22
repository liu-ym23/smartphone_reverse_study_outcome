package com.bytedance.android.shopping.mall.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/mall/widget/ECDetectableFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/mall/widget/ECTouchEventDetector;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/mall/widget/ECTouchEventDetector;", "getTouchEventDetector", "()Lcom/bytedance/android/shopping/mall/widget/ECTouchEventDetector;", "setTouchEventDetector", "(Lcom/bytedance/android/shopping/mall/widget/ECTouchEventDetector;)V", "touchEventDetector", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECDetectableFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECTouchEventDetector f178613a;

    public ECDetectableFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECDetectableFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ECTouchEventDetector getTouchEventDetector() {
        return this.f178613a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        ECTouchEventDetector r100 = this.f178613a;
        if (r100 == null) goto L42;
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r110, "motionEvent");
        int r101 = getLeft();
        int r102 = getRight();
        int r103 = (int) r110.getRawX();
        if (r101 > r103) goto L42;
        if (r102 < r103) goto L42;
        int r104 = getTop();
        int r105 = getBottom();
        int r106 = (int) r110.getRawY();
        if (r104 > r106) goto L42;
        if (r105 < r106) goto L42;
        int r107 = r110.getActionMasked();
        if (r107 != 0) goto L15;
        r100.f178617d = System.currentTimeMillis();
        r100.f178618e = (int) r110.getRawX();
        r100.f178619f = (int) r110.getRawY();
        ECTouchEventDetector.a r108 = r100.f178620g;
        r108.f178621a.postDelayed(r108, r108.f178622b.f178615b);
        goto L42
    L15:
        if (r107 == 1) goto L28;
        if (r107 != 2) goto L18;
    L20:
        int r109 = (int) r110.getRawX();
        int r111 = (int) r110.getRawY();
        if (Math.abs(r109 - r100.f178618e) <= ((Number) r100.f178616c.getValue()).intValue()) goto L23;
    L24:
        ECTouchEventDetector.a r112 = r100.f178620g;
        r112.f178621a.removeCallbacks(r112);
    L26:
        if ((System.currentTimeMillis() - r100.f178617d) > r100.f178614a) goto L42;
        r100.f178617d = Long.MAX_VALUE;
        goto L42
    L23:
        if (Math.abs(r111 - r100.f178619f) <= ((Number) r100.f178616c.getValue()).intValue()) goto L26;
    L18:
        if (r107 == 3) goto L20;
    L28:
        long r113 = System.currentTimeMillis() - r100.f178617d;
        long r114 = r100.f178615b;
        if (0 <= r113) goto L32;
    L34:
        int r115 = (int) r110.getRawX();
        int r116 = (int) r110.getRawY();
        int r117 = Math.abs(r115 - r100.f178618e);
        int r118 = Math.abs(r116 - r100.f178619f);
        if (r117 > (((Number) r100.f178616c.getValue()).intValue() * 7)) goto L37;
    L39:
        ECTouchEventDetector.a r119 = r100.f178620g;
        r119.f178621a.removeCallbacks(r119);
        r100.f178617d = Long.MAX_VALUE;
        goto L42
    L37:
        if (r118 >= (r117 / 2)) goto L39;
        r100.c(r100.f178618e, r100.f178619f, r115, r116);
        goto L39
    L32:
        if (r114 <= r113) goto L34;
        r100.a();
    L42:
        return super.dispatchTouchEvent(r110);
    }

    public final void setTouchEventDetector(ECTouchEventDetector r100) {
        this.f178613a = r100;
    }

    public ECDetectableFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ECDetectableFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
