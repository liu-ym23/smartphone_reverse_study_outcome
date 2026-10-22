package com.bytedance.android.gamecp.common.ui.popup.manager;

import com.bytedance.android.gamecp.common.utils.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePopupWindowManager f57049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LivePopupInfo f57050b;

    public h(LivePopupWindowManager r100, LivePopupInfo r101) {
        this.f57049a = r100;
        this.f57050b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LivePopupInfo.State r101 = (LivePopupInfo.State) r100;
        if (r101 == null) goto L23;
        int r102 = e.f57046a[r101.ordinal()];
        if (r102 != 1) goto L8;
        m r103 = m.a();
        r103.getClass();
        m.f57238c++;
        r103.b();
        long r104 = this.f57050b.f57028c;
        if (r104 <= 0) goto L22;
        Observable<Long> r105 = Observable.timer(r104, TimeUnit.SECONDS);
        Intrinsics.checkNotNullParameter(r105, "$this$observeOnUi");
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r105.observeOn(AndroidSchedulers.mainThread()).takeUntil(this.f57050b.f57027b.filter(f.f57047a)).subscribe(new g(this)), this.f57049a.f57038a);
        return;
    L22:
        return;
    L8:
        if (r102 != 2) goto L24;
        this.f57049a.f57039b.remove(this.f57050b);
        m r106 = m.a();
        r106.getClass();
        m.f57238c--;
        if (m.f57238c >= 0) goto L14;
        m.f57238c = 0;
    L14:
        if (m.f57238c != 0) goto L16;
        r106.b();
    L16:
        this.f57049a.b();
        return;
    L24:
        return;
    }
}
