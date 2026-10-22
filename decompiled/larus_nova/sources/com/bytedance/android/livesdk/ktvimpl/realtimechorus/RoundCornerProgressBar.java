package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RoundCornerProgressBar;", "Landroid/view/View;", "", "value", "b", FaceService.girlLabel, "getProgress", "()F", "setProgress", "(F)V", "progress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoundCornerProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f146459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f146460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f146461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f146462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f146463e;

    public final float getProgress() {
        return this.f146460b;
    }

    public RoundCornerProgressBar(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = 2;
        this.f146461c.set(this.f146459a.getStrokeWidth() / r101, this.f146459a.getStrokeWidth() / r101, getWidth() - (this.f146459a.getStrokeWidth() / r101), getHeight() - (this.f146459a.getStrokeWidth() / r101));
        Path r102 = this.f146462d;
        RectF r103 = this.f146461c;
        int r104 = this.f146463e;
        r102.addRoundRect(r103, r104, r104, Path.Direction.CW);
        float r105 = new PathMeasure(this.f146462d, false).getLength();
        this.f146459a.setPathEffect(new DashPathEffect(new float[]{(this.f146460b * r105) / 100, r105}, 0.0f));
        r100.drawPath(this.f146462d, this.f146459a);
    }

    public final void setProgress(float r100) {
        this.f146460b = RangesKt.coerceIn(r100, 0.0f, 100.0f);
        invalidate();
    }

    public RoundCornerProgressBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Paint r102 = new Paint();
        this.f146459a = r102;
        this.f146461c = new RectF();
        this.f146462d = new Path();
        this.f146463e = s1.f(45.0f);
        r102.setColor(-1);
        r102.setStyle(Paint.Style.STROKE);
        r102.setAntiAlias(true);
        r102.setStrokeWidth(s1.f(2.0f));
    }
}
