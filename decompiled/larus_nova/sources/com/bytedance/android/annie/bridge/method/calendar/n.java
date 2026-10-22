package com.bytedance.android.annie.bridge.method.calendar;

import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import e7.f0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f38615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f38616b;

    public n(g r100, f0 r101) {
        this.f38615a = r100;
        this.f38616b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        g r101 = this.f38615a;
        CreateCalendarEventResultModel r102 = new CreateCalendarEventResultModel();
        f0 r103 = this.f38616b;
        r102.a(CreateCalendarEventResultModel.Code.Failed);
        r102.b("delete calendar event failed. error msg = " + ((Throwable) r100).getMessage() + ", request id = " + r103.getIdentifier());
        r101.finishWithResult(r102);
    }
}
