package com.bytedance.android.gamecp.business.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/business/view/CircleProgressBar;", "Landroid/widget/ProgressBar;", "Lcom/bytedance/android/gamecp/business/view/CircleProgressBar$Status;", "getStatus", "status", "", "setStatus", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Status", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CircleProgressBar extends ProgressBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f56434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f56435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f56436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f56437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f56438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f56439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Status f56440g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/view/CircleProgressBar$Status;", "", "Pause", "DownLoading", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Status extends Enum<Status> {
        public static final Status DownLoading = null;
        public static final Status Pause = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f56441a = null;

        static {
            Status r100 = new Status("Pause", 0);
            Pause = r100;
            Status r101 = new Status("DownLoading", 1);
            DownLoading = r101;
            f56441a = new Status[]{r100, r101};
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public static Status[] values() {
            return (Status[]) f56441a.clone();
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public CircleProgressBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CircleProgressBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final Status getStatus() {
        return this.f56440g;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas r110) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "canvas");     // Catch: Throwable -> L10
        super.onDraw(r110);     // Catch: Throwable -> L10
        r110.save();     // Catch: Throwable -> L10
        r110.translate(getPaddingStart(), getPaddingTop());     // Catch: Throwable -> L10
        float r100 = 2;
        int r101 = (int) (this.f56438e * r100);     // Catch: Throwable -> L10
        Resources r102 = getContext().getResources();     // Catch: Throwable -> L10
        if (this.f56440g != Status.Pause) goto L6;
        int r103 = R.drawable.gamecp_progress_pause;
    L7:
        Drawable r104 = r102.getDrawable(r103);     // Catch: Throwable -> L10
        r104.setBounds(0, 0, r101, r101);     // Catch: Throwable -> L10
        r104.draw(r110);     // Catch: Throwable -> L10
        Paint r105 = this.f56439f;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L10
        r105.setStyle(Paint.Style.STROKE);     // Catch: Throwable -> L10
        Paint r106 = this.f56439f;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L10
        r106.setColor(this.f56434a);     // Catch: Throwable -> L10
        Paint r107 = this.f56439f;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L10
        r107.setStrokeWidth(this.f56436c);     // Catch: Throwable -> L10
        float r108 = this.f56438e;     // Catch: Throwable -> L10
        Paint r109 = this.f56439f;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L10
        r110.drawCircle(r108, r108, r108, r109);     // Catch: Throwable -> L10
        Paint r111 = this.f56439f;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L10
        r111.setColor(this.f56435b);     // Catch: Throwable -> L10
        Paint r112 = this.f56439f;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L10
        r112.setStrokeWidth(this.f56437d);     // Catch: Throwable -> L10
        float r113 = ((getProgress() * 1.0f) / getMax()) * 360;     // Catch: Throwable -> L10
        float r114 = this.f56438e;     // Catch: Throwable -> L10
        RectF r115 = new RectF(0.0f, 0.0f, r114 * r100, r114 * r100);     // Catch: Throwable -> L10
        Paint r116 = this.f56439f;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r116);     // Catch: Throwable -> L10
        r110.drawArc(r115, -90.0f, r113, false, r116);     // Catch: Throwable -> L10
        r110.restore();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r103 = R.drawable.gamecp_progress_downloading;
    L10:
        th = move-exception;
        throw th;
    }

    public final void setStatus(Status r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        if (this.f56440g != r100) goto L5;
        return;
    L5:
        this.f56440g = r100;
        invalidate();
    }

    public static float a(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r102 = r100.getResources();
        return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int r100, int r101) {
        monitor-enter(this);
        int r102 = View.MeasureSpec.getMode(r100);     // Catch: Throwable -> L11
        int r103 = View.MeasureSpec.getMode(r101);     // Catch: Throwable -> L11
        float r104 = Math.max(this.f56437d, this.f56436c);     // Catch: Throwable -> L11
        if (r103 == 1073741824) goto L6;
        r101 = View.MeasureSpec.makeMeasureSpec((int) (((getPaddingTop() + getPaddingBottom()) + (this.f56438e * 2)) + r104), 1073741824);     // Catch: Throwable -> L11
    L6:
        if (r102 == 1073741824) goto L8;
        r100 = View.MeasureSpec.makeMeasureSpec((int) (((getPaddingLeft() + getPaddingRight()) + (this.f56438e * 2)) + r104), 1073741824);     // Catch: Throwable -> L11
    L8:
        super.onMeasure(r100, r101);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public CircleProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f56440g = Status.DownLoading;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.defaultColor, R.attr.defaultHeight, R.attr.radius, R.attr.reachedColor, R.attr.reachedHeight});
        this.f56434a = r103.getColor(0, ColorProtector.parseColor("#D8D8D8"));
        this.f56435b = r103.getColor(3, ColorProtector.parseColor("#1296DB"));
        this.f56436c = r103.getDimension(1, a(r100, 2.5f));
        this.f56437d = r103.getDimension(4, a(r100, 2.5f));
        this.f56438e = r103.getDimension(2, a(r100, 8.0f));
        r103.recycle();
        Paint r104 = new Paint();
        this.f56439f = r104;
        Intrinsics.checkNotNull(r104);
        r104.setAntiAlias(true);
        Paint r105 = this.f56439f;
        Intrinsics.checkNotNull(r105);
        r105.setDither(true);
        Paint r106 = this.f56439f;
        Intrinsics.checkNotNull(r106);
        r106.setStyle(Paint.Style.STROKE);
        Paint r107 = this.f56439f;
        Intrinsics.checkNotNull(r107);
        r107.setStrokeCap(Paint.Cap.ROUND);
    }

    public /* synthetic */ CircleProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
