package com.bytedance.android.ec.hybrid.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB\u001b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/hybrid/ui/ECHoleOverMaskView;", "Landroid/view/View;", "", "d", "Lkotlin/Lazy;", "getStatusBarHeight", "()I", "statusBarHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHoleOverMaskView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f47651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f47652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f47653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f47654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f47655e;

    public static final class a {
    }

    static {
    }

    private final int getStatusBarHeight() {
        return ((Number) this.f47654d.getValue()).intValue();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        int r101 = (this.f47653c & 16777215) | (0 << 24);
        int[] r102 = this.f47655e;
        int r103 = r102[1];
        getLocationOnScreen(r102);
        int r104 = this.f47655e[1];
        r100.drawColor(r101);
        r100.drawRect(this.f47651a, this.f47652b);
    }

    public ECHoleOverMaskView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f47651a = new RectF();
        Paint r102 = new Paint(1);
        this.f47652b = r102;
        this.f47653c = ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT);
        this.f47654d = LazyKt.lazy(ECHoleOverMaskView$statusBarHeight$2.INSTANCE);
        this.f47655e = new int[2];
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }
}
