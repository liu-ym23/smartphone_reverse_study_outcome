package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECShopMarqueeLogoView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopMarqueeLogoView extends SimpleDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f184517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f184518b;

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f184517a.reset();
        this.f184518b.reset();
        float r101 = com.bytedance.android.ec.core.utils.q.a(Float.valueOf(12.0f));
        float r102 = getWidth() / 2;
        float r103 = getWidth() / 2;
        this.f184517a.addCircle(r102, r102, r102, Path.Direction.CW);
        this.f184518b.addCircle(-10.0f, r103, r101, Path.Direction.CW);
        this.f184517a.op(this.f184518b, Path.Op.DIFFERENCE);
        r100.clipPath(this.f184517a);
        super.onDraw(r100);
    }

    public ECShopMarqueeLogoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f184517a = new Path();
        this.f184518b = new Path();
    }
}
