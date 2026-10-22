package com.bytedance.android.ec.window.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.core.utils.q;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/window/base/view/ECWindowVerticalDashLine;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowVerticalDashLine extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f49866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f49867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f49869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f49870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DashPathEffect f49871f;

    public ECWindowVerticalDashLine(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECWindowVerticalDashLine(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f49866a.setPathEffect(this.f49871f);
        this.f49866a.setStrokeWidth(this.f49869d);
        this.f49866a.setColor(this.f49868c);
        float r101 = this.f49869d / 2;
        int r102 = getHeight();
        this.f49867b.reset();
        this.f49867b.moveTo(r101, 0.0f);
        this.f49867b.lineTo(r101, r102);
        r100.drawPath(this.f49867b, this.f49866a);
    }

    public ECWindowVerticalDashLine(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        this.f49866a = r103;
        this.f49867b = new Path();
        new com.bytedance.android.ec.window.base.repository.vo.a();
        int r104 = (int) 2164210514L;
        this.f49868c = r104;
        this.f49869d = q.a(1);
        float r105 = q.a(1);
        this.f49870e = r105;
        this.f49871f = new DashPathEffect(new float[]{r105, r105}, 0.0f);
        r103.setAntiAlias(true);
        r103.setStrokeWidth(this.f49869d);
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.divider_color});
        r103.setColor(r106.getColor(0, r104));
        r106.recycle();
        r103.setStyle(Paint.Style.STROKE);
    }

    public /* synthetic */ ECWindowVerticalDashLine(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
