package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECStoreVerticalDashLine;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreVerticalDashLine extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f48838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f48839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.ec.store.repository.vo.d f48840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f48841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f48842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f48843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DashPathEffect f48844g;

    public ECStoreVerticalDashLine(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECStoreVerticalDashLine(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f48838a.setPathEffect(this.f48844g);
        this.f48838a.setStrokeWidth(this.f48842e);
        this.f48838a.setColor(this.f48841d);
        float r101 = this.f48842e / 2;
        int r102 = getHeight();
        this.f48839b.reset();
        this.f48839b.moveTo(r101, 0.0f);
        this.f48839b.lineTo(r101, r102);
        r100.drawPath(this.f48839b, this.f48838a);
    }

    public ECStoreVerticalDashLine(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        this.f48838a = r103;
        this.f48839b = new Path();
        this.f48840c = new com.bytedance.android.ec.store.repository.vo.d();
        int r104 = (int) 2164210514L;
        this.f48841d = r104;
        this.f48842e = com.bytedance.android.ec.core.utils.q.a(1);
        float r105 = com.bytedance.android.ec.core.utils.q.a(1);
        this.f48843f = r105;
        this.f48844g = new DashPathEffect(new float[]{r105, r105}, 0.0f);
        r103.setAntiAlias(true);
        r103.setStrokeWidth(this.f48842e);
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.divider_color});
        r103.setColor(r106.getColor(0, r104));
        r106.recycle();
        r103.setStyle(Paint.Style.STROKE);
    }

    public /* synthetic */ ECStoreVerticalDashLine(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
