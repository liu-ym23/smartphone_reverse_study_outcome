package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.message.model.za;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes46.dex */
public final class n extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f76467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ch0.c f76468c;

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        ch0.c r100 = this.f76468c;
        IKtvService r101 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r101 == null) goto L5;
        za r102 = r101.ktvCurrentSingerOrderInfo();
    L6:
        r100.f23718a = r102;
        a().W0(this.f76468c);
        IKtvService r103 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r103 == null) goto L14;
        com.bytedance.live.datacontext.k<fd2.z> r104 = r103.ktvComponentSingerChangedEvent();
        if (r104 == null) goto L15;
        Disposable r105 = r104.onEvent().subscribe(new m(this));
        if (r105 == null) goto L16;
        RxUtilKt.c(r105, this.f76467b);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.f76467b.dispose();
    }

    public n() {
        this.f76467b = new CompositeDisposable();
        this.f76468c = new ch0.c();
    }
}
