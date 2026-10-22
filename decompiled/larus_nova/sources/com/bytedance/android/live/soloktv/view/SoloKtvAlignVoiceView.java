package com.bytedance.android.live.soloktv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\t\u001a\u00020\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/soloktv/view/SoloKtvAlignVoiceView;", "Landroid/view/View;", "", "align", "", "setCurrentAlign", "Lkotlin/Function2;", "", "alignChangedCallback", "setAlignChangedCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvAlignVoiceView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f101758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f101759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f101760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f101761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f101762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f101763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f101764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f101765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f101766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f101767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f101768k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function2<? super Integer, ? super Boolean, Unit> f101769l;

    public SoloKtvAlignVoiceView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SoloKtvAlignVoiceView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(MotionEvent r100) {
        int r101 = (int) ((r100.getX() - (getWidth() / 2.0f)) / this.f101767j);
        int r102 = this.f101759b;
        int r103 = -r102;
        if (r101 < r103) goto L6;
        if (r101 > r102) goto L6;
        this.f101758a = r101;
    L10:
        Function2<? super Integer, ? super Boolean, Unit> r104 = this.f101769l;
        if (r104 == null) goto L13;
        Unit r105 = r104.invoke(Integer.valueOf(this.f101758a), Boolean.FALSE);
    L13:
        invalidate();
        return;
    L6:
        if (r101 >= r103) goto L8;
        this.f101758a = r103;
        goto L10
    L8:
        if (r101 <= r102) goto L10;
        this.f101758a = r102;
        goto L10
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = getMeasuredHeight() / 2.0f;
        r100.drawLine(0.0f, r101, getMeasuredWidth(), r101, this.f101763f);
        int r102 = this.f101758a;
        if (r102 <= 0) goto L6;
        float r103 = getMeasuredWidth() / 2.0f;
        float r104 = (getMeasuredWidth() / 2.0f) + (this.f101762e * this.f101758a);
    L5:
        float r105 = r104;
        float r106 = r103;
    L10:
        if (r105 <= r106) goto L12;
        r100.drawLine(r106, r101, r105, r101, this.f101764g);
    L12:
        r100.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.f101760c / 2.0f, this.f101765h);
        if (this.f101758a != 0) goto L15;
        float r107 = getMeasuredWidth() / 2.0f;
    L16:
        r100.drawCircle(r107, getMeasuredHeight() / 2.0f, this.f101761d / 2.0f, this.f101766i);
        return;
    L15:
        r107 = (getMeasuredWidth() / 2.0f) + (this.f101758a * this.f101767j);
        goto L16
    L6:
        if (r102 >= 0) goto L8;
        r103 = (getMeasuredWidth() / 2.0f) + (this.f101762e * this.f101758a);
        r104 = getMeasuredWidth() / 2.0f;
        goto L5
    L8:
        r106 = 0.0f;
        r105 = 0.0f;
        goto L10
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getActionMasked());
    L6:
        if (r101 != null) goto L9;
    L11:
        if (r101 != null) goto L14;
    L31:
        if (r101 != null) goto L34;
    L36:
        if (r101 != null) goto L39;
    L43:
        return true;
    L39:
        if (r101.intValue() != 3) goto L43;
    L40:
        Function2<? super Integer, ? super Boolean, Unit> r102 = this.f101769l;
        if (r102 == null) goto L43;
        Unit r103 = r102.invoke(Integer.valueOf(this.f101758a), Boolean.TRUE);
        goto L43
    L34:
        if (r101.intValue() != 1) goto L36;
    L14:
        if (r101.intValue() != 2) goto L31;
        a(r100);
        if (this.f101758a <= 0) goto L20;
        if (this.f101768k <= r100.getX()) goto L20;
    L24:
        if (Math.abs(this.f101758a) > 10) goto L30;
        this.f101758a = 0;
        Function2<? super Integer, ? super Boolean, Unit> r104 = this.f101769l;
        if (r104 == null) goto L28;
        Unit r105 = r104.invoke(0, Boolean.TRUE);
    L28:
        invalidate();
        return false;
    L30:
        this.f101768k = r100.getX();
        System.currentTimeMillis();
    L20:
        if (this.f101758a >= 0) goto L30;
        if (this.f101768k >= r100.getX()) goto L30;
    L9:
        if (r101.intValue() != 0) goto L11;
        r100.getX();
        getWidth();
        this.f101768k = r100.getX();
        a(r100);
        goto L43
    L4:
        r101 = null;
        goto L6
    }

    public final void setAlignChangedCallback(Function2<? super Integer, ? super Boolean, Unit> r100) {
        this.f101769l = r100;
    }

    public final void setCurrentAlign(int r100) {
        this.f101758a = r100;
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f101762e = getMeasuredWidth() / (this.f101759b * 2.0f);
        this.f101767j = (getMeasuredWidth() - this.f101761d) / (this.f101759b * 2.0f);
    }

    public SoloKtvAlignVoiceView(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        this.f101759b = 300;
        Paint r112 = new Paint();
        this.f101763f = r112;
        Paint r101 = new Paint();
        this.f101764g = r101;
        Paint r102 = new Paint();
        this.f101765h = r102;
        Paint r103 = new Paint();
        this.f101766i = r103;
        TypedArray r104 = r100.obtainStyledAttributes(r110, new int[]{R.attr.alignColor, R.attr.alignPointerSize, R.attr.bgColor, R.attr.bgSize, R.attr.middlePointerSize, R.attr.pointerColor});
        this.f101760c = r104.getDimensionPixelSize(4, (int) UtilityKotlinExtentionsKt.h(6));
        this.f101761d = r104.getDimensionPixelSize(1, (int) UtilityKotlinExtentionsKt.h(21));
        int r113 = r104.getDimensionPixelSize(3, (int) UtilityKotlinExtentionsKt.h(3));
        int r105 = r104.getColor(2, ColorProtector.parseColor("#29FFFFFF"));
        int r106 = r104.getColor(0, ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
        int r107 = r104.getColor(5, -1);
        r104.recycle();
        float r108 = r113;
        r112.setStrokeWidth(r108);
        r112.setStrokeCap(Paint.Cap.ROUND);
        r112.setAntiAlias(true);
        r112.setColor(r105);
        r101.setStrokeWidth(r108);
        r101.setStrokeCap(Paint.Cap.ROUND);
        r101.setAntiAlias(true);
        r101.setColor(r106);
        r102.setColor(r107);
        r102.setAntiAlias(true);
        r103.setColor(r107);
        r103.setAntiAlias(true);
    }

    public /* synthetic */ SoloKtvAlignVoiceView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
