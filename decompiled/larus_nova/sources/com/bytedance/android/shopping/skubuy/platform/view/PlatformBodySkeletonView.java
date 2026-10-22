package com.bytedance.android.shopping.skubuy.platform.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/view/PlatformBodySkeletonView;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformBodySkeletonView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f183173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f183174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f183175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f183176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f183177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f183178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f183179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f183180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f183181i;

    public PlatformBodySkeletonView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PlatformBodySkeletonView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.drawColor(this.f183173a);
        float r101 = getWidth() / this.f183176d;
        r100.save();
        r100.scale(r101, r101);
        float r102 = this.f183177e;
        r100.drawRoundRect(0.0f, 0.0f, 375.0f, 154.0f, r102, r102, this.f183175c);
        float r103 = this.f183178f;
        r100.drawRoundRect(16.0f, 16.0f, 358.0f, 40.0f, r103, r103, this.f183174b);
        float r104 = this.f183178f;
        r100.drawRoundRect(16.0f, 64.0f, 90.0f, 138.0f, r104, r104, this.f183174b);
        float r105 = this.f183181i;
        r100.drawRoundRect(102.0f, 64.0f, 238.0f, 88.0f, r105, r105, this.f183174b);
        float r106 = this.f183181i;
        r100.drawRoundRect(102.0f, 100.0f, 238.0f, 124.0f, r106, r106, this.f183174b);
        float r107 = this.f183180h;
        r100.drawRoundRect(0.0f, 162.0f, 375.0f, 654.0f, r107, r107, this.f183175c);
        float r108 = this.f183179g;
        r100.drawRoundRect(16.0f, 178.0f, 90.0f, 198.0f, r108, r108, this.f183174b);
        float r109 = this.f183181i;
        r100.drawRoundRect(16.0f, 210.0f, 122.0f, 359.0f, r109, r109, this.f183174b);
        float r110 = this.f183181i;
        r100.drawRoundRect(134.0f, 210.0f, 240.0f, 359.0f, r110, r110, this.f183174b);
        float r111 = this.f183181i;
        r100.drawRoundRect(252.0f, 210.0f, 358.0f, 359.0f, r111, r111, this.f183174b);
        float r112 = this.f183179g;
        r100.drawRoundRect(16.0f, 383.0f, 90.0f, 403.0f, r112, r112, this.f183174b);
        float r113 = this.f183179g;
        r100.drawRoundRect(16.0f, 407.0f, 240.0f, 441.0f, r113, r113, this.f183174b);
        r100.restore();
    }

    public PlatformBodySkeletonView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f183173a = ColorProtector.parseColor("#F5F6F9");
        Paint r103 = new Paint(1);
        r103.setColor(ColorProtector.parseColor("#F8F8F8"));
        r103.setStyle(Paint.Style.FILL);
        Unit r104 = Unit.INSTANCE;
        this.f183174b = r103;
        Paint r105 = new Paint(1);
        r105.setColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        r105.setStyle(Paint.Style.FILL);
        this.f183175c = r105;
        this.f183176d = 375.0f;
        this.f183177e = 16.0f;
        this.f183178f = 8.0f;
        this.f183179g = 4.0f;
        this.f183180h = 12.0f;
        this.f183181i = 6.0f;
    }

    public /* synthetic */ PlatformBodySkeletonView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
