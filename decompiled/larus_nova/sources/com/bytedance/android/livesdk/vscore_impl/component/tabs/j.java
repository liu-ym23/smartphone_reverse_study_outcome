package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTabsPageAdapter f159965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f159966b;

    public j(LiveTabsPageAdapter r100, boolean r101) {
        this.f159965a = r100;
        this.f159966b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if (this.f159965a.f159853j.isEmpty() == false) goto L11;
        LiveTabsPageAdapter r102 = this.f159965a;
        String r103 = r102.f159847d;
        CompositeDisposable r104 = r102.f159851h;
        if (r104 != null) goto L7;
        return;
    L7:
        if (r104.isDisposed() == true) goto L19;
        CompositeDisposable r105 = this.f159965a.f159851h;
        if (r105 == null) goto L20;
        r105.dispose();
        return;
    L20:
        return;
    L19:
        return;
    L11:
        ALogger.i(this.f159965a.f159847d, "schedule load annie in interval task.");
        a r106 = this.f159965a.f159853j.pop();
        if (this.f159966b == true) goto L14;
    L16:
        this.f159965a.h(r106.f159951b);
        return;
    L14:
        if (r106.f159940e == false) goto L16;
        ALogger.i(this.f159965a.f159847d, "skip preload " + r106.f159952c + " due to disablePreload");
        this.f159965a.i();
    }
}
