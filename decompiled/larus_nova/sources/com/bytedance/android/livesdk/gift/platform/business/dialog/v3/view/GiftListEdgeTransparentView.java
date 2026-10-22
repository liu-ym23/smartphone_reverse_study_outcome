package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view;

import a02.a;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/GiftListEdgeTransparentView;", "Landroid/widget/LinearLayout;", "La02/a;", "c", "La02/a;", "getTouchInterceptor", "()La02/a;", "setTouchInterceptor", "(La02/a;)V", "touchInterceptor", "", "h", FaceService.girlLabel, "getTopDrawSize", "()F", "setTopDrawSize", "(F)V", "topDrawSize", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftListEdgeTransparentView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f128591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f128592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f128593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f128594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f128595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f128596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f128597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f128598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f128599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f128600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f128601k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f128602l;

    public GiftListEdgeTransparentView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GiftListEdgeTransparentView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        Paint r100 = this.f128594d;
        if (r100 == null) goto L6;
        float r101 = this.f128597g;
        r100.setShader(new LinearGradient(0.0f, r101, 0.0f, r101 + this.f128598h, this.f128595e, this.f128596f, Shader.TileMode.CLAMP));
        return;
    }

    public final float getTopDrawSize() {
        return this.f128598h;
    }

    public final a getTouchInterceptor() {
        return this.f128593c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        a r101 = this.f128593c;
        if (r101 == null) goto L9;
        if (r101.a(r100) != true) goto L9;
        return false;
    L9:
        return super.dispatchTouchEvent(r100);
    }

    public final void setTopDrawSize(float r100) {
        this.f128598h = r100;
    }

    public final void setTouchInterceptor(a r100) {
        this.f128593c = r100;
    }

    public GiftListEdgeTransparentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f128595e = new int[]{-1, 0};
        this.f128596f = new float[]{0.0f, 1.0f};
        this.f128600j = new int[]{-1, 0};
        this.f128601k = new float[]{0.0f, 1.0f};
        Paint r103 = new Paint(1);
        this.f128594d = r103;
        r103.setStyle(Paint.Style.FILL);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint r104 = new Paint(1);
        this.f128599i = r104;
        r104.setStyle(Paint.Style.FILL);
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r110, View r111, long r112) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f128598h <= 0.0f) goto L5;
    L8:
        int r100 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        boolean r113 = super.drawChild(r110, r111, r112);
        float r114 = this.f128598h;
        if (r114 <= 0.0f) goto L14;
        Paint r101 = this.f128594d;
        if (r101 == null) goto L14;
        float r102 = this.f128597g;
        r110.drawRect(0.0f, r102, this.f128591a, r102 + r114, r101);
    L14:
        if (this.f128602l <= 0.0f) goto L18;
        Paint r103 = this.f128599i;
        if (r103 == null) goto L18;
        int r115 = r110.save();
        r110.rotate(180.0f, this.f128591a / 2.0f, this.f128592b / 2.0f);
        r110.drawRect(0.0f, 0.0f, this.f128591a, this.f128602l, r103);
        r110.restoreToCount(r115);
    L18:
        r110.restoreToCount(r100);
        return r113;
    L5:
        if (this.f128602l > 0.0f) goto L8;
        return super.drawChild(r110, r111, r112);
    }

    public /* synthetic */ GiftListEdgeTransparentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        a();
        Paint r101 = this.f128599i;
        if (r101 == null) goto L5;
        r101.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f128602l, this.f128600j, this.f128601k, Shader.TileMode.CLAMP));
    L5:
        this.f128591a = getWidth();
        this.f128592b = getHeight();
    }
}
