package com.bytedance.android.livesdk.common;

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

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/common/RoundRectLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoundRectLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f119679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f119680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f119681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f119682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f119683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f119684f;

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public RoundRectLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f119679a = new Path();
        new Paint(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = this.f119680b;
        float r102 = this.f119681c;
        float r103 = this.f119683e;
        float r104 = this.f119682d;
        this.f119679a.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), new float[]{r101, r101, r102, r102, r103, r103, r104, r104}, Path.Direction.CW);
        r100.clipPath(this.f119679a);
        super.dispatchDraw(r100);
    }

    public RoundRectLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        this(r100);
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.leftBottomRoundRect, R.attr.leftTopRoundRect, R.attr.rightBottomRoundRect, R.attr.rightTopRoundRect, R.attr.roundRect});
        float r103 = r102.getDimension(4, this.f119684f);
        this.f119684f = r103;
        this.f119680b = r102.getDimension(1, this.f119680b);
        this.f119681c = r102.getDimension(3, this.f119681c);
        this.f119683e = r102.getDimension(2, this.f119683e);
        this.f119682d = r102.getDimension(0, this.f119682d);
        if (r103 == 0.0f) goto L5;
        this.f119680b = r103;
        this.f119681c = r103;
        this.f119683e = r103;
        this.f119682d = r103;
    L5:
        r102.recycle();
    }
}
