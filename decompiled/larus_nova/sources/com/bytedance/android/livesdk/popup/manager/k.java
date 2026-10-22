package com.bytedance.android.livesdk.popup.manager;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePopupWindowManager f156309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LivePopupInfo f156310b;

    public k(LivePopupWindowManager r100, LivePopupInfo r101) {
        this.f156309a = r100;
        this.f156310b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LivePopupInfo.State r101 = (LivePopupInfo.State) r100;
        if (r101 == null) goto L17;
        int r102 = g.f156305a[r101.ordinal()];
        if (r102 != 1) goto L8;
        com.bytedance.android.livesdk.e.b().a();
        long r103 = this.f156310b.f156279c;
        if (r103 <= 0) goto L16;
        RxUtilKt.c(RxUtilKt.h(Observable.timer(r103, TimeUnit.SECONDS)).takeUntil(this.f156310b.f156278b.filter(h.f156306a)).subscribe(new i(this), j.f156308a), this.f156309a.f156293a);
        return;
    L16:
        return;
    L8:
        if (r102 != 2) goto L18;
        this.f156309a.f156294b.remove(this.f156310b);
        com.bytedance.android.livesdk.e.b().d();
        this.f156309a.d();
        return;
    L18:
        return;
    }
}
