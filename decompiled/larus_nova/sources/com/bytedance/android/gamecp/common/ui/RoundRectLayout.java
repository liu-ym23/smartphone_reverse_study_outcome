package com.bytedance.android.gamecp.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/common/ui/RoundRectLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoundRectLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f56939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f56940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f56941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f56942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f56943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f56944f;

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public RoundRectLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f56939a = new Path();
        new Paint(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = this.f56940b;
        float r102 = this.f56941c;
        float r103 = this.f56943e;
        float r104 = this.f56942d;
        this.f56939a.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), new float[]{r101, r101, r102, r102, r103, r103, r104, r104}, Path.Direction.CW);
        r100.clipPath(this.f56939a);
        super.dispatchDraw(r100);
    }

    public RoundRectLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        this(r100);
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.cornerRadius, R.attr.fillColor, R.attr.leftBottomRound, R.attr.leftTopRound, R.attr.rightBottomRound, R.attr.rightTopRound, R.attr.round, R.attr.roundCorner});
        float r103 = r102.getDimension(7, this.f56944f);
        this.f56944f = r103;
        this.f56940b = r102.getDimension(3, this.f56940b);
        this.f56941c = r102.getDimension(5, this.f56941c);
        this.f56943e = r102.getDimension(4, this.f56943e);
        this.f56942d = r102.getDimension(2, this.f56942d);
        if (r103 == 0.0f) goto L5;
        this.f56940b = r103;
        this.f56941c = r103;
        this.f56943e = r103;
        this.f56942d = r103;
    L5:
        r102.recycle();
    }
}
