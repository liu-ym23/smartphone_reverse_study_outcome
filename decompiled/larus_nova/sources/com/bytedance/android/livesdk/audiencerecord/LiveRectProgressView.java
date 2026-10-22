package com.bytedance.android.livesdk.audiencerecord;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\"\u0010\u000f\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/audiencerecord/LiveRectProgressView;", "Landroid/view/View;", "", "progress", "", "setProgress", "maxProgress", "setMaxProgress", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getWidth$livesdk_saasRelease", "()I", "setWidth$livesdk_saasRelease", "(I)V", "width", "b", "getHeight$livesdk_saasRelease", "setHeight$livesdk_saasRelease", "height", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRectProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f104022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f104023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f104024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f104025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f104026e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f104027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f104028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f104029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f104030i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f104031j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f104032k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Path f104033l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Path f104034m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f104035n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f104036o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RectF f104037p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Path f104038q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float[] f104039r;

    public LiveRectProgressView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveRectProgressView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getHeight$livesdk_saasRelease() {
        return this.f104023b;
    }

    public final int getWidth$livesdk_saasRelease() {
        return this.f104022a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        this.f104038q.reset();
        RectF r100 = this.f104037p;
        if (r100 == null) goto L5;
        this.f104038q.addRoundRect(r100, this.f104039r, Path.Direction.CW);
    L5:
        r110.clipPath(this.f104038q);
        super.onDraw(r110);
        float r101 = 2;
        this.f104024c = (int) (((this.f104022a + this.f104023b) - UtilityKotlinExtentionsKt.h(4)) * r101);
        this.f104033l.reset();
        float r102 = 1;
        this.f104033l.moveTo(UtilityKotlinExtentionsKt.h(r102), UtilityKotlinExtentionsKt.h(r102));
        this.f104033l.lineTo(this.f104022a - UtilityKotlinExtentionsKt.h(r102), UtilityKotlinExtentionsKt.h(r102));
        this.f104033l.lineTo(this.f104022a - UtilityKotlinExtentionsKt.h(r102), this.f104023b - UtilityKotlinExtentionsKt.h(r102));
        this.f104033l.lineTo(UtilityKotlinExtentionsKt.h(r102), this.f104023b - UtilityKotlinExtentionsKt.h(r102));
        this.f104033l.lineTo(UtilityKotlinExtentionsKt.h(r102), UtilityKotlinExtentionsKt.h(r102));
        this.f104033l.close();
        r110.drawPath(this.f104033l, this.f104032k);
        float r103 = this.f104025d;
        if (r103 != 0.0f) goto L8;
        return;
    L8:
        this.f104029h = (this.f104024c * this.f104026e) / r103;
        this.f104027f = 0.0f;
        this.f104028g = 0.0f;
        this.f104035n = UtilityKotlinExtentionsKt.h(r102);
        this.f104036o = UtilityKotlinExtentionsKt.h(r102);
        this.f104034m.reset();
        this.f104034m.moveTo(UtilityKotlinExtentionsKt.h(r102), UtilityKotlinExtentionsKt.h(r102));
        int r104 = 1;
    L9:
        if (r104 > 4) goto L33;
        float r105 = this.f104027f;
        int r106 = r104 % 2;
        if (r106 != 1) goto L13;
        float r107 = this.f104022a;
    L14:
        float r108 = r105 + (r107 - UtilityKotlinExtentionsKt.h(r101));
        this.f104028g = r108;
        float r109 = this.f104029h;
        if (r109 <= r108) goto L20;
        if (r106 != 1) goto L18;
        float r111 = this.f104022a;
    L19:
        float r112 = r111 - UtilityKotlinExtentionsKt.h(r101);
    L21:
        this.f104030i = r112;
        if (r112 <= 0) goto L33;
        if (r106 != 1) goto L29;
        if (this.f104035n != UtilityKotlinExtentionsKt.h(r102)) goto L27;
        this.f104035n += this.f104030i;
    L32:
        this.f104034m.lineTo(this.f104035n, this.f104036o);
        this.f104027f = this.f104028g;
        r104 = r104 + 1;
        goto L9
    L27:
        this.f104035n -= this.f104030i;
        goto L32
    L29:
        if (this.f104036o != UtilityKotlinExtentionsKt.h(r102)) goto L31;
        this.f104036o += this.f104030i;
        goto L32
    L31:
        this.f104036o -= this.f104030i;
        goto L32
    L18:
        r111 = this.f104023b;
        goto L19
    L20:
        r112 = r109 - this.f104027f;
        goto L21
    L13:
        r107 = this.f104023b;
    L33:
        r110.drawPath(this.f104034m, this.f104031j);
    }

    public final void setHeight$livesdk_saasRelease(int r100) {
        this.f104023b = r100;
    }

    public final void setMaxProgress(float r100) {
        this.f104025d = r100;
    }

    public final void setProgress(float r100) {
        this.f104026e = r100;
        invalidate();
    }

    public final void setWidth$livesdk_saasRelease(int r100) {
        this.f104022a = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f104022a = View.MeasureSpec.getSize(r100);
        this.f104023b = View.MeasureSpec.getSize(r101);
    }

    public LiveRectProgressView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f104025d = 100.0f;
        this.f104026e = 100.0f;
        Paint r103 = new Paint();
        this.f104031j = r103;
        Paint r104 = new Paint();
        this.f104032k = r104;
        this.f104033l = new Path();
        this.f104034m = new Path();
        this.f104038q = new Path();
        this.f104039r = new float[]{UtilityKotlinExtentionsKt.h(r1), UtilityKotlinExtentionsKt.h(r1), UtilityKotlinExtentionsKt.h(r1), UtilityKotlinExtentionsKt.h(r1), UtilityKotlinExtentionsKt.h(r1), UtilityKotlinExtentionsKt.h(r1), UtilityKotlinExtentionsKt.h(r1), UtilityKotlinExtentionsKt.h(r1)};
        float r105 = 2;
        r103.setStrokeWidth(UtilityKotlinExtentionsKt.h(r105));
        r103.setStyle(Paint.Style.STROKE);
        r103.setColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        r103.setStrokeCap(Paint.Cap.ROUND);
        r103.setAntiAlias(true);
        r104.setStrokeWidth(UtilityKotlinExtentionsKt.h(r105));
        r104.setStyle(Paint.Style.STROKE);
        r104.setColor(ColorProtector.parseColor("#80FFFFFF"));
        r104.setStrokeCap(Paint.Cap.ROUND);
        r104.setAntiAlias(true);
    }

    public /* synthetic */ LiveRectProgressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f104037p = new RectF(0.0f, 0.0f, r100, r101);
    }
}
