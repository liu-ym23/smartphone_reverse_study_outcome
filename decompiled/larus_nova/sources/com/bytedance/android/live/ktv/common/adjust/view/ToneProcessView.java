package com.bytedance.android.live.ktv.common.adjust.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/ktv/common/adjust/view/ToneProcessView;", "Landroid/view/View;", "", "color", "", "setHighLightColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ToneProcessView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f69445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f69446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f69447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f69448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f69449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f69450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f69451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f69452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f69453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f69454j;

    public ToneProcessView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ToneProcessView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        int r101 = getWidth();
        int r102 = this.f69450f;
        this.f69449e = (r101 - (this.f69448d * r102)) / (r102 - 1);
        int r103 = 1;
        if (1 > r102) goto L12;
    L4:
        float r104 = r103 - 1;
        int r105 = this.f69448d;
        float r106 = (this.f69449e + r105) * r104;
        RectF r107 = this.f69453i;
        r107.left = r106;
        r107.right = r106 + r105;
        r107.top = (getHeight() - this.f69447c) - (r104 * this.f69452h);
        this.f69453i.bottom = getHeight();
        if (r103 != this.f69454j) goto L8;
        if (r100 == null) goto L10;
        RectF r108 = this.f69453i;
        float r109 = this.f69451g;
        r100.drawRoundRect(r108, r109, r109, this.f69445a);
    L10:
        if (r103 == r102) goto L14;
        r103 = r103 + 1;
        goto L4
    L14:
        return;
    L8:
        if (r100 == null) goto L10;
        RectF r110 = this.f69453i;
        float r111 = this.f69451g;
        r100.drawRoundRect(r110, r111, r111, this.f69446b);
        goto L10
    }

    public final void setHighLightColor(int r100) {
        this.f69445a.setColor(r100);
        invalidate();
    }

    public ToneProcessView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        r103.setDither(true);
        r103.setAntiAlias(true);
        r103.setStyle(Paint.Style.FILL_AND_STROKE);
        Unit r104 = Unit.INSTANCE;
        this.f69445a = r103;
        Paint r105 = new Paint();
        r105.setDither(true);
        r105.setAntiAlias(true);
        r105.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f69446b = r105;
        this.f69453i = new RectF();
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.bar_radius, R.attr.highlight_color, R.attr.max_height, R.attr.min_height, R.attr.normal_color, R.attr.stroke_width, R.attr.tone_interval, R.attr.tone_num});
        r103.setColor(r106.getColor(1, s1.h(R.color.ttlive_ktv_tone_highlight_bar_color)));
        r105.setColor(r106.getColor(4, ColorProtector.parseColor("#898A8F")));
        int r107 = r106.getInteger(7, 9);
        this.f69450f = r107;
        this.f69448d = r106.getDimensionPixelSize(5, s1.f(3.0f));
        this.f69451g = r106.getDimensionPixelSize(0, s1.f(22.0f));
        float r108 = r106.getDimensionPixelSize(3, s1.f(3.0f));
        this.f69447c = r108;
        float r109 = r106.getDimensionPixelSize(2, s1.f(18.0f));
        r106.recycle();
        this.f69454j = (r107 / 2) + 1;
        this.f69452h = (r109 - r108) / (r107 - 1);
    }

    public /* synthetic */ ToneProcessView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
