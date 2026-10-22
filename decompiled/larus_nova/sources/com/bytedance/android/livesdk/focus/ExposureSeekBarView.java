package com.bytedance.android.livesdk.focus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/focus/ExposureSeekBarView;", "Landroid/view/View;", "", "distance", "", "setProgress", "getSeekBarTotalLength", "getProgress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExposureSeekBarView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f125286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f125287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bitmap f125288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f125289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f125290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f125291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f125292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f125293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f125294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f125295j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f125296k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f125297l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f125298m;

    public ExposureSeekBarView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ExposureSeekBarView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final float getProgress() {
        return this.f125293h;
    }

    public final float getSeekBarTotalLength() {
        return this.f125286a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        float r100 = this.f125292g;
        float r101 = this.f125293h;
        float r111 = this.f125286a;
        float r112 = this.f125287b;
        double r113 = ((double) r100) + ((0.5d - ((double) r101)) * ((double) (r111 - (2 * r112))));
        float r102 = this.f125290e;
        float r114 = r102 + ((this.f125289d - r102) * r101);
        if (this.f125296k == false) goto L10;
        float r115 = (float) r113;
        double r103 = ((double) r100) - (((double) r111) * 0.5d);
        float r104 = r115 - r112;
        if (r104 <= r103) goto L7;
        float r105 = this.f125291f;
        r110.drawLine(r105, r104, r105, (float) r103, this.f125294i);
    L7:
        double r106 = ((double) this.f125292g) + (((double) this.f125286a) * 0.5d);
        float r107 = r115 + this.f125287b;
        if (r106 <= r107) goto L10;
        float r108 = this.f125291f;
        r110.drawLine(r108, (float) r106, r108, r107, this.f125294i);
    L10:
        float r109 = this.f125291f;
        double r116 = r114;
        double r117 = r113 - r116;
        double r118 = r113 + r116;
        Rect r119 = this.f125297l;
        r119.left = 0;
        r119.top = 0;
        r119.right = this.f125288c.getWidth();
        r119.bottom = this.f125288c.getHeight();
        Rect r120 = this.f125298m;
        r120.left = (int) (r109 - r114);
        r120.top = (int) r117;
        r120.right = (int) (r109 + r114);
        r120.bottom = (int) r118;
        r110.drawBitmap(this.f125288c, this.f125297l, r120, this.f125294i);
    }

    public final void setProgress(float r100) {
        float r101 = this.f125293h + ((r100 / this.f125295j) / this.f125286a);
        if (r101 <= 1) goto L6;
        this.f125293h = 1.0f;
    L9:
        this.f125296k = true;
        invalidate();
        return;
    L6:
        if (r101 >= 0) goto L8;
        this.f125293h = 0.0f;
        goto L9
    L8:
        this.f125293h = r101;
        goto L9
    }

    public ExposureSeekBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f125286a = UtilityKotlinExtentionsKt.h(120);
        float r103 = UtilityKotlinExtentionsKt.h(1.5f);
        this.f125287b = UtilityKotlinExtentionsKt.h(16);
        this.f125288c = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ttlive_icon_exposure);
        this.f125289d = UtilityKotlinExtentionsKt.h(11.5f);
        this.f125290e = UtilityKotlinExtentionsKt.h(8.5f);
        this.f125293h = 0.5f;
        Paint r104 = new Paint();
        this.f125294i = r104;
        this.f125295j = 10;
        this.f125297l = new Rect();
        this.f125298m = new Rect();
        r104.setColor(-1);
        r104.setStrokeWidth(r103);
        r104.setStrokeCap(Paint.Cap.ROUND);
        r104.setStrokeJoin(Paint.Join.ROUND);
        r104.setAntiAlias(true);
    }

    public /* synthetic */ ExposureSeekBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
