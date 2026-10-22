package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class a0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSLandscapeTabsWidget f159941a;

    public a0(VSLandscapeTabsWidget r100) {
        this.f159941a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ALogger.i("LiveMultiTab", "未收到动画回调，直接启动加载");
        VSLandscapeTabsWidget r102 = this.f159941a;
        if (r102.f159925w == true) goto L5;
        VSLandscapeTabsWidget.Yq(r102);
    L5:
        VSLandscapeTabsWidget r103 = this.f159941a;
        r103.f159925w = true;
        CompositeDisposable r104 = r103.f159924v;
        if (r104 != null) goto L8;
        return;
    L8:
        if (r104.isDisposed() == true) goto L14;
        CompositeDisposable r105 = this.f159941a.f159924v;
        if (r105 == null) goto L15;
        r105.dispose();
        return;
    L15:
        return;
    }
}
