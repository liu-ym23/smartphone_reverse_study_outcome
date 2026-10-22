package com.bytedance.android.window.shop.widget.holderprocessor;

import android.os.SystemClock;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends gr3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f190041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WindowLayoutType f190042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f190043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<WindowLayoutType> f190044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f190045e;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function0<? extends WindowLayoutType> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutTypeFetcher");
        Intrinsics.checkNotNullParameter(r101, "changedNotifier");
        this.f190044d = r100;
        this.f190045e = r101;
    }

    @Override // gr3.d
    public final void a(ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r100, com.bytedance.android.window.shop.repository.tab.entity.f r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "vo");
        WindowLayoutType r103 = this.f190044d.invoke();
        if (this.f190042b == r103) goto L6;
    L7:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L19;
        this.f190042b = this.f190044d.invoke();
        this.f190043c = SystemClock.elapsedRealtime();
        Disposable r105 = this.f190041a;
        if (r105 != null) goto L13;
    L17:
        this.f190041a = bg4.b.b(Observable.timer(1000, TimeUnit.MILLISECONDS)).subscribe(new g(this), h.f190047a);
        return;
    L13:
        if (r105.isDisposed() == true) goto L17;
        Disposable r106 = this.f190041a;
        if (r106 == null) goto L17;
        r106.dispose();
        goto L17
    L19:
        return;
    L6:
        if ((SystemClock.elapsedRealtime() - this.f190043c) > 1000) goto L7;
        r104 = false;
        goto L9
    }
}
