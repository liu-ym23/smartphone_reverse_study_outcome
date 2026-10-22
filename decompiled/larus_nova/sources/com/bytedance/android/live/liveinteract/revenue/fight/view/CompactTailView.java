package com.bytedance.android.live.liveinteract.revenue.fight.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.bytedance.android.live.core.widget.HSImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/view/CompactTailView;", "Lcom/bytedance/android/live/core/widget/HSImageView;", "", "radius", "", "setCircleRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CompactTailView extends HSImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f78208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f78209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f78210c;

    public CompactTailView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f78209b = new Path();
        this.f78210c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = this.f78208a;
        if (r101 <= 0) goto L7;
        float r102 = 2.0f * r101;
        if (getWidth() <= r102) goto L7;
        this.f78209b.reset();
        this.f78209b.moveTo(0.0f, 0.0f);
        this.f78209b.lineTo(0.0f, getHeight());
        this.f78209b.lineTo(getWidth() - r101, getHeight());
        this.f78210c.set(getWidth() - r102, 0.0f, getWidth(), getHeight());
        this.f78209b.arcTo(this.f78210c, 90.0f, -180.0f);
        this.f78209b.close();
        r100.clipPath(this.f78209b);
    L7:
        super.onDraw(r100);
    }

    public final void setCircleRadius(float r100) {
        this.f78208a = r100;
    }

    public CompactTailView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f78209b = new Path();
        this.f78210c = new RectF();
    }

    public CompactTailView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f78209b = new Path();
        this.f78210c = new RectF();
    }
}
