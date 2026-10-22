package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp;

import com.bytedance.android.livesdk.livecommerce.utils.t0;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements yk2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f152762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super yk2.a, ? super Boolean, Unit> f152763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f152764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f152765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f152766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final yk2.b f152767f;

    @Override // yk2.a
    public final void release() {
        this.f152763b = null;
        this.f152762a.clear();
    }

    @Override // yk2.a
    public final void start() {
        if (this.f152762a.size() != 0) goto L14;
        long r100 = this.f152765d;
        long r101 = this.f152766e;
        yk2.b r102 = this.f152767f;
        if ((r102 instanceof WebpAnimatedWidget) == true) goto L7;
        r102 = null;
    L7:
        WebpAnimatedWidget r103 = (WebpAnimatedWidget) r102;
        if (r103 != null) goto L10;
    L12:
        int r104 = t0.f153116a;
        Disposable r105 = t0.a(r100, r101, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        Intrinsics.checkNotNullParameter(r105, "$this$disposeOnClear");
        this.f152762a.add(r105);
        System.currentTimeMillis();
        return;
    L10:
        if (r103.f152755h != true) goto L12;
        r100 = r101;
        goto L12
    }

    @Override // yk2.a
    public final void stop() {
        this.f152762a.clear();
    }

    public b(WebpAnimatedWidget r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f152765d = 0;
        this.f152766e = 10;
        this.f152767f = r100;
        this.f152762a = new CompositeDisposable();
        this.f152764c = true;
    }
}
