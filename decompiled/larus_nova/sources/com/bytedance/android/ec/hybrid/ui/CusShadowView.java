package com.bytedance.android.ec.hybrid.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.hybrid.tools.UIToolsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB\u001b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/hybrid/ui/CusShadowView;", "Landroid/view/View;", "Landroid/graphics/RectF;", "d", "Lkotlin/Lazy;", "getRectF", "()Landroid/graphics/RectF;", "rectF", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CusShadowView extends View {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f47645e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f47646f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f47647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f47648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f47649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f47650d;

    public static final class a {
    }

    private final RectF getRectF() {
        return (RectF) this.f47650d.getValue();
    }

    static {
        f47645e = UIToolsKt.a(13);
        f47646f = UIToolsKt.a(2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        RectF r101 = getRectF();
        int r102 = f47645e;
        r100.drawRoundRect(r101, r102, r102, this.f47649c);
        r100.drawRoundRect(getRectF(), r102, r102, this.f47648b);
    }

    public CusShadowView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setLayerType(1, null);
        this.f47647a = new RectF();
        Paint r102 = new Paint(1);
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Unit r103 = Unit.INSTANCE;
        this.f47648b = r102;
        Paint r104 = new Paint(1);
        r104.setShadowLayer(50.0f, 10.0f, 10.0f, ColorProtector.parseColor("#CC888888"));
        this.f47649c = r104;
        this.f47650d = LazyKt.lazy(new CusShadowView$rectF$2(this));
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(View.resolveSize(getWidth(), r100), View.resolveSize(getHeight(), r101));
    }
}
