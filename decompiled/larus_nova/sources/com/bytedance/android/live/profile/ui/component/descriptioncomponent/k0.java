package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import com.bytedance.android.live.room.api.view.SimpleIndicatorTextSwitcher;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class k0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0.a f86549a;

    public k0(l0.a r100) {
        this.f86549a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        SimpleIndicatorTextSwitcher r102 = this.f86549a.f86567a.f86554e;
        if (r102 == null) goto L5;
        r102.showNext();
    L5:
        Disposable r103 = this.f86549a.f86567a.f86560k;
        if (r103 != null) goto L8;
        return;
    L8:
        if ((!r103.isDisposed()) == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L15;
        r103.dispose();
        return;
    }
}
