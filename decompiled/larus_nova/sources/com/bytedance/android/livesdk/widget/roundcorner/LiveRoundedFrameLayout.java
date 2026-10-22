package com.bytedance.android.livesdk.widget.roundcorner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/widget/roundcorner/LiveRoundedFrameLayout;", "Landroid/widget/FrameLayout;", "", "radius", "", "setRadius", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getMClipBackground", "()Z", "setMClipBackground", "(Z)V", "mClipBackground", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoundedFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f162028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f162029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f162030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f162031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f162032e;

    public LiveRoundedFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveRoundedFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void invalidate() {
        this.f162030c.reset();
        this.f162030c.addRoundRect(this.f162029b, this.f162031d, Path.Direction.CW);
        this.f162030c.close();
        super.invalidate();
    }

    public final boolean getMClipBackground() {
        return this.f162028a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = r110.save();
        super.dispatchDraw(r110);
        this.f162032e.setColor(-1);
        this.f162032e.setStyle(Paint.Style.FILL);
        if (Build.VERSION.SDK_INT > 27) goto L5;
        this.f162032e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r110.drawPath(this.f162030c, this.f162032e);
    L6:
        r110.restoreToCount(r100);
        return;
    L5:
        this.f162032e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Path r101 = new Path();
        r101.addRect(0.0f, 0.0f, this.f162029b.width(), this.f162029b.height(), Path.Direction.CW);
        r101.op(this.f162030c, Path.Op.DIFFERENCE);
        r110.drawPath(r101, this.f162032e);
        goto L6
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f162028a == false) goto L5;
        int r101 = r100.save();
        r100.clipPath(this.f162030c);
        super.draw(r100);
        r100.restoreToCount(r101);
        return;
    L5:
        super.draw(r100);
    }

    public final void setMClipBackground(boolean r100) {
        this.f162028a = r100;
    }

    public final void setRadius(int r100) {
        if (r100 < 0) goto L18;
        if (r100 < 0) goto L19;
        if (r100 < 0) goto L20;
        if (r100 < 0) goto L21;
        float[] r101 = this.f162031d;
        float r102 = r100;
        if (r101[0] == r102) goto L10;
    L16:
        r101[0] = r102;
        r101[1] = r102;
        r101[2] = r102;
        r101[3] = r102;
        r101[4] = r102;
        r101[5] = r102;
        r101[6] = r102;
        r101[7] = r102;
        postInvalidate();
        return;
    L10:
        if (r101[2] != r102) goto L16;
        if (r101[4] != r102) goto L16;
        if (r101[6] != r102) goto L16;
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public LiveRoundedFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f162029b = new RectF();
        this.f162030c = new Path();
        this.f162031d = new float[8];
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setColor(-1);
        Unit r104 = Unit.INSTANCE;
        this.f162032e = r103;
    }

    public /* synthetic */ LiveRoundedFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f162029b.set(0.0f, 0.0f, r100, r101);
        this.f162030c.reset();
        this.f162030c.addRoundRect(this.f162029b, this.f162031d, Path.Direction.CW);
        this.f162030c.close();
    }
}
