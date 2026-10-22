package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import s91.f;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiggTemporaryDataMonitor f100012a;

    public d(DiggTemporaryDataMonitor r100) {
        this.f100012a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        DiggTemporaryDataMonitor r102 = this.f100012a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(o91.b.h.class, "tabType");
        s91.a<f> r103 = r102.f99993a;
        if (r103 == null) goto L5;
        boolean r104 = r103.a(o91.b.h.class);
    L6:
        if (r104 == true) goto L13;
        DiggTemporaryDataMonitor r105 = this.f100012a;
        r105.e((f) r105.f100003j.getValue());
        Disposable r106 = this.f100012a.f100001h;
        if (r106 == null) goto L11;
        r106.dispose();
    L11:
        DiggTemporaryDataMonitor r107 = this.f100012a;
        r107.f100001h = Observable.just("").delay(2000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this));
        return;
    L13:
        return;
    L5:
        r104 = false;
        goto L6
    }
}
