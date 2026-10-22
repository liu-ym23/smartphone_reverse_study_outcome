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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/view/PlatformFooterSkeletonView;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformFooterSkeletonView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f183189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f183190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f183191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f183192d;

    public PlatformFooterSkeletonView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PlatformFooterSkeletonView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        r110.drawColor(this.f183189a);
        float r100 = getWidth() / this.f183191c;
        r110.save();
        r110.scale(r100, r100);
        float r101 = this.f183192d;
        r110.drawRoundRect(16.0f, 8.0f, 359.0f, 52.0f, r101, r101, this.f183190b);
        r110.restore();
    }

    public PlatformFooterSkeletonView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f183189a = ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT);
        Paint r103 = new Paint(1);
        r103.setColor(ColorProtector.parseColor("#F8F8F8"));
        r103.setStyle(Paint.Style.FILL);
        Unit r104 = Unit.INSTANCE;
        this.f183190b = r103;
        this.f183191c = 375.0f;
        this.f183192d = 44.0f;
    }

    public /* synthetic */ PlatformFooterSkeletonView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
