package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.col.s.ce;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R#\u0010\u0013\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u001cR\u001b\u0010#\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u001c¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeBatteryView;", "Landroid/view/View;", "Landroid/graphics/Paint;", "d", "Lkotlin/Lazy;", "getBorderPaint", "()Landroid/graphics/Paint;", "borderPaint", "e", "getCapPaint", "capPaint", "f", "getContentPaint", "contentPaint", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", ce.f26391f, "getChargingBitmap", "()Landroid/graphics/Bitmap;", "chargingBitmap", "Landroid/graphics/Matrix;", "h", "getChargingMatrix", "()Landroid/graphics/Matrix;", "chargingMatrix", "Landroid/graphics/RectF;", RXScreenCaptureService.KEY_INDEX, "getBorderRectF", "()Landroid/graphics/RectF;", "borderRectF", "l", "getCapRectF", "capRectF", OfficeSDKRequestTag.KEY_NEW_USER, "getContentRectF", "contentRectF", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeBatteryView extends View {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f118844q = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f118845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f118846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f118847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f118848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f118849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f118850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f118851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f118852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f118853i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f118854j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f118855k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f118856l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f118857m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f118858n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f118859o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f118860p;

    public static final class a {
    }

    public LandscapeBatteryView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LandscapeBatteryView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Paint getBorderPaint() {
        return (Paint) this.f118848d.getValue();
    }

    private final RectF getBorderRectF() {
        return (RectF) this.f118853i.getValue();
    }

    private final Paint getCapPaint() {
        return (Paint) this.f118849e.getValue();
    }

    private final RectF getCapRectF() {
        return (RectF) this.f118856l.getValue();
    }

    private final Bitmap getChargingBitmap() {
        return (Bitmap) this.f118851g.getValue();
    }

    private final Matrix getChargingMatrix() {
        return (Matrix) this.f118852h.getValue();
    }

    private final Paint getContentPaint() {
        return (Paint) this.f118850f.getValue();
    }

    private final RectF getContentRectF() {
        return (RectF) this.f118858n.getValue();
    }

    static {
        f118844q = (float) Math.sqrt(2.0f);
    }

    public final void e() {
        getBorderPaint().setStrokeWidth(c(1.0f) * this.f118845a);
        Paint r100 = getContentPaint();
        if (this.f118847c == false) goto L5;
        int r101 = FakePickerAvatarCreator.GREEN;
    L6:
        r100.setColor(r101);
        r100.setAlpha(255);
        Matrix r102 = getChargingMatrix();
        float r103 = (c(12.0f) * this.f118845a) - (c(2.0f) * this.f118845a);
        int r104 = getChargingBitmap().getHeight();
        float r105 = 2;
        r102.setTranslate(((c(20.0f) * this.f118845a) / r105) - (c(3.0f) * this.f118845a), c(1.0f) * this.f118845a);
        float r106 = r103 / r104;
        r102.preScale(r106, r106);
        float r107 = (c(12.0f) * this.f118845a) - (c(2.0f) * this.f118845a);
        float r108 = (c(20.0f) * this.f118845a) - (c(3.0f) * this.f118845a);
        float r109 = c(0.77f) * this.f118845a;
        float r110 = c(1.0f) * this.f118845a;
        float r111 = r109 + r108;
        getBorderRectF().set((getBorderPaint().getStrokeWidth() / r105) + r109, (getBorderPaint().getStrokeWidth() / r105) + r110, r111 - (getBorderPaint().getStrokeWidth() / r105), (r110 + r107) - (getBorderPaint().getStrokeWidth() / r105));
        float r112 = c(2.5f) * this.f118845a;
        float r113 = f118844q;
        this.f118854j = r112 / r113;
        this.f118855k = (c(2.5f) * this.f118845a) / r113;
        float r114 = (c(0.5f) * this.f118845a) + r111;
        float r115 = c(0.96f) * this.f118845a;
        float r116 = c(2.89f) * this.f118845a;
        float r117 = (c(12.0f) * this.f118845a) / r105;
        float r118 = r116 / r105;
        float r119 = r117 - r118;
        this.f118857m = (((float) Math.atan((r118 / c(0.5f)) / this.f118845a)) * 180) / ((float) 3.141592653589793d);
        getCapRectF().set((r111 - (c(0.5f) * this.f118845a)) - r115, r119, r114 + r115, r116 + r119);
        float r120 = c(2.5f) * this.f118845a;
        float r121 = c(2.27f) * this.f118845a;
        getContentRectF().set(r121, r120, (((c(17.0f) * this.f118845a) - (c(3.0f) * this.f118845a)) * this.f118846b) + r121, (r107 - (c(3.0f) * this.f118845a)) + r120);
        this.f118859o = (c(1.0f) * this.f118845a) / r113;
        this.f118860p = (c(1.0f) * this.f118845a) / r113;
        return;
    L5:
        r101 = -1;
        goto L6
    }

    public static final /* synthetic */ Paint a(LandscapeBatteryView r100) {
        return r100.getBorderPaint();
    }

    public static final /* synthetic */ Paint b(LandscapeBatteryView r100) {
        return r100.getCapPaint();
    }

    public static float c(float r100) {
        Resources r101 = Resources.getSystem();
        return r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
    }

    public static int d(int r100) {
        Resources r101 = Resources.getSystem();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        r110.drawRoundRect(getBorderRectF(), this.f118854j, this.f118855k, getBorderPaint());
        RectF r100 = getCapRectF();
        float r101 = this.f118857m;
        r110.drawArc(r100, -r101, r101 * 2, false, getCapPaint());
        r110.drawRoundRect(getContentRectF(), this.f118859o, this.f118860p, getContentPaint());
        if (this.f118847c == false) goto L6;
        r110.drawBitmap(getChargingBitmap(), getChargingMatrix(), null);
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = d(25);
        int r103 = View.MeasureSpec.getMode(r100);
        int r104 = View.MeasureSpec.getSize(r100);
        if (r103 == Integer.MIN_VALUE) goto L7;
        if (r103 != 1073741824) goto L8;
        r102 = r104;
    L8:
        int r105 = d(12);
        int r106 = View.MeasureSpec.getMode(r101);
        int r107 = View.MeasureSpec.getSize(r101);
        if (r106 == Integer.MIN_VALUE) goto L13;
        if (r106 != 1073741824) goto L14;
        r105 = r107;
    L14:
        float r108 = r102;
        float r109 = r105;
        if ((r108 / 20.0f) >= (r109 / 12)) goto L17;
        this.f118845a = r108 / c(20.0f);
        setMeasuredDimension(r102, MathKt.roundToInt(d(12) * this.f118845a));
    L18:
        e();
        return;
    L17:
        this.f118845a = r109 / c(12.0f);
        setMeasuredDimension(MathKt.roundToInt(d(20) * this.f118845a), r105);
        goto L18
    L13:
        r105 = Math.min(r107, r105);
        goto L14
    L7:
        r102 = Math.min(r104, r102);
        goto L8
    }

    public LandscapeBatteryView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f118845a = 1.0f;
        this.f118846b = 1.0f;
        this.f118848d = LazyKt.lazy(LandscapeBatteryView$borderPaint$2.INSTANCE);
        this.f118849e = LazyKt.lazy(new LandscapeBatteryView$capPaint$2(this));
        this.f118850f = LazyKt.lazy(new LandscapeBatteryView$contentPaint$2(this));
        this.f118851g = LazyKt.lazy(new LandscapeBatteryView$chargingBitmap$2(this));
        this.f118852h = LazyKt.lazy(LandscapeBatteryView$chargingMatrix$2.INSTANCE);
        this.f118853i = LazyKt.lazy(LandscapeBatteryView$borderRectF$2.INSTANCE);
        this.f118856l = LazyKt.lazy(LandscapeBatteryView$capRectF$2.INSTANCE);
        this.f118858n = LazyKt.lazy(LandscapeBatteryView$contentRectF$2.INSTANCE);
    }

    public /* synthetic */ LandscapeBatteryView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
