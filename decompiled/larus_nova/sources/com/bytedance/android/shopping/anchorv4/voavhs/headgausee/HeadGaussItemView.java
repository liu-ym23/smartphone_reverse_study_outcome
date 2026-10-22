package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.utils.d0;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class HeadGaussItemView extends ImageView implements fa3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f168988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ fa3.b f168989b;

    private final com.bytedance.android.shopping.anchorv4.voavhs.blur.f getBlurManager() {
        return (com.bytedance.android.shopping.anchorv4.voavhs.blur.f) this.f168988a.getValue();
    }

    @Override // fa3.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f168989b.add(r100);
        return r100;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f168989b.a();
    }

    public HeadGaussItemView(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f168989b = new fa3.b();
        this.f168988a = LazyKt.lazy(new HeadGaussItemView$blurManager$2(r100));
        setLayoutParams(new ViewGroup.LayoutParams(-1, d0.a()));
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public static Bitmap a(HeadGaussItemView r100, Bitmap r101) {
        return r100.getBlurManager().a(r101, k1.m(r100.getContext()), k1.p(), 1.0f, 16777215, new com.bytedance.android.shopping.anchorv4.voavhs.blur.d(0, 0, 0, r101.getHeight() - k1.p()));
    }

    public static void b(HeadGaussItemView r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        if (r101.isRecycled() == true) goto L13;
        fa3.c.a(Single.just(Bitmap.createBitmap(r101)).observeOn(Schedulers.computation()).map(new a(r100)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r100, null), c.f168998a), r100);
        return;
    L7:
        th = move-exception;
        ECExceptionMonitor.e(th);
        return;
    }
}
