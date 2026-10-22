package com.bytedance.android.live.profit.format.voicechat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/HollowImageView;", "Landroid/widget/ImageView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HollowImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f87715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f87716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f87717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f87718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f87719e;

    public HollowImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HollowImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.save();
        super.onDraw(r100);     // Catch: Throwable -> L6
        r100.drawPath(this.f87715a, this.f87716b);     // Catch: Throwable -> L6
        r100.restoreToCount(r101);
        return;
    L6:
        th = move-exception;
        r100.restoreToCount(r101);
        throw th;
    }

    public HollowImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f87715a = new Path();
        Paint r103 = new Paint(1);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Unit r104 = Unit.INSTANCE;
        this.f87716b = r103;
        setLayerType(1, null);
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.hole_radius}, 0, 0);
        this.f87719e = r105.getDimension(0, 0.0f);
        r105.recycle();
    }

    public /* synthetic */ HollowImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f87717c = r100 / 2.0f;
        this.f87718d = r101 / 2.0f;
        this.f87715a.reset();
        this.f87715a.addCircle(this.f87717c, this.f87718d, this.f87719e, Path.Direction.CW);
    }
}
