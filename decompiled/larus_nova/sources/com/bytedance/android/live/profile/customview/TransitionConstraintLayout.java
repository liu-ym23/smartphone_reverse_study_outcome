package com.bytedance.android.live.profile.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u0006¢\u0006\u0004\b<\u0010=J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010&\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u001f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010.\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020'8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R.\u00106\u001a\u0004\u0018\u00010/2\b\u0010\u0007\u001a\u0004\u0018\u00010/8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/profile/customview/TransitionConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/graphics/PorterDuff$Mode;", "newMode", "", "setXfermode", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getTransitionType", "()I", "setTransitionType", "(I)V", "transitionType", "Landroid/graphics/RectF;", "b", "Landroid/graphics/RectF;", "getDstRectF", "()Landroid/graphics/RectF;", "setDstRectF", "(Landroid/graphics/RectF;)V", "dstRectF", "Landroid/graphics/PointF;", "c", "Landroid/graphics/PointF;", "getStartPoint", "()Landroid/graphics/PointF;", "setStartPoint", "(Landroid/graphics/PointF;)V", "startPoint", "", "d", FaceService.girlLabel, "getOffset", "()F", "setOffset", "(F)V", "offset", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "paint", "Landroid/graphics/Bitmap;", "f", "Landroid/graphics/Bitmap;", "getSrcBitmap", "()Landroid/graphics/Bitmap;", "setSrcBitmap", "(Landroid/graphics/Bitmap;)V", "srcBitmap", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f85989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f85990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PointF f85991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f85992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f85993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f85994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PorterDuffXfermode f85995g;

    public static final class a {
    }

    static {
    }

    public TransitionConstraintLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TransitionConstraintLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final RectF getDstRectF() {
        return this.f85990b;
    }

    public final float getOffset() {
        return this.f85992d;
    }

    public final Paint getPaint() {
        return this.f85993e;
    }

    public final Bitmap getSrcBitmap() {
        return this.f85994f;
    }

    public final PointF getStartPoint() {
        return this.f85991c;
    }

    public final int getTransitionType() {
        return this.f85989a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    L4:
        e = move-exception;
        ALogger.e("TransitionConstraintLayout", "dispatchTouchEvent error", e);
        SafetyGuard.a(null, e, null);
        return false;
    }

    @Override // android.view.View
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.draw(r110);
        if (this.f85989a != 0) goto L5;
        return;
    L5:
        ALogger.i("TransitionConstraintLayout", "draw type: " + this.f85989a);
        int r100 = this.f85989a;
        if (r100 != 1) goto L8;
        Bitmap r101 = this.f85994f;
        if (r101 == null) goto L22;
        this.f85993e.setXfermode(this.f85995g);
        r110.drawBitmap(r101, null, this.f85990b, this.f85993e);
        this.f85993e.setXfermode(null);
        return;
    L22:
        return;
    L8:
        if (r100 != 2) goto L20;
        Bitmap r102 = this.f85994f;
        if (r102 == null) goto L21;
        RectF r103 = new RectF(0.0f, 0.0f, this.f85990b.left, getHeight());
        RectF r104 = this.f85990b;
        RectF r105 = new RectF(r104.left, 0.0f, r104.right, r104.top);
        RectF r106 = new RectF(this.f85990b.right, 0.0f, getWidth(), getHeight());
        RectF r107 = this.f85990b;
        RectF r108 = new RectF(r107.left, r107.bottom, r107.right, getHeight());
        this.f85993e.setXfermode(this.f85995g);
        this.f85993e.setColor(0);
        r110.drawRect(r103, this.f85993e);
        r110.drawRect(r105, this.f85993e);
        r110.drawRect(r106, this.f85993e);
        r110.drawRect(r108, this.f85993e);
        this.f85993e.setColor(-1);
        r110.drawBitmap(r102, null, this.f85990b, this.f85993e);
        this.f85993e.setXfermode(null);
        return;
    L21:
        return;
    }

    public final void setDstRectF(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        ALogger.i("TransitionConstraintLayout", "set dstRectF: " + r100);
        this.f85990b = r100;
        invalidate();
    }

    public final void setOffset(float r100) {
        ALogger.i("TransitionConstraintLayout", "set offset: " + r100);
        this.f85992d = r100;
        PointF r101 = this.f85991c;
        float r102 = r101.x;
        float r103 = r101.y;
        setDstRectF(new RectF(r102 - r100, r103 - r100, r102 + r100, r103 + r100));
        invalidate();
    }

    public final void setPaint(Paint r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        ALogger.i("TransitionConstraintLayout", "set paint, some info: " + r100.getStyle());
        this.f85993e = r100;
        invalidate();
    }

    public final void setSrcBitmap(Bitmap r100) {
        ALogger.i("TransitionConstraintLayout", "set srcBitmap");
        this.f85994f = r100;
        invalidate();
    }

    public final void setStartPoint(PointF r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        ALogger.i("TransitionConstraintLayout", "set startPoint: " + r100);
        this.f85991c = r100;
        setOffset(this.f85992d);
        invalidate();
    }

    public final void setTransitionType(int r100) {
        ALogger.i("TransitionConstraintLayout", "set transitionType: " + r100);
        if (r100 == 0) goto L5;
        setWillNotDraw(false);
    L5:
        this.f85989a = r100;
        invalidate();
    }

    public final void setXfermode(PorterDuff.Mode r100) {
        Intrinsics.checkNotNullParameter(r100, "newMode");
        ALogger.i("TransitionConstraintLayout", "set xfermode: " + r100);
        this.f85995g = new PorterDuffXfermode(r100);
        invalidate();
    }

    public TransitionConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f85990b = new RectF();
        this.f85991c = new PointF(0.0f, 0.0f);
        Paint r103 = new Paint();
        r103.setStyle(Paint.Style.FILL);
        Unit r104 = Unit.INSTANCE;
        this.f85993e = r103;
        this.f85995g = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    public /* synthetic */ TransitionConstraintLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
