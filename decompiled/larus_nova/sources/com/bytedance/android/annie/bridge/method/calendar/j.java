package com.bytedance.android.annie.bridge.method.calendar;

import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f38608a;

    public j(g r100) {
        this.f38608a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        g r101 = this.f38608a;
        CreateCalendarEventResultModel r102 = new CreateCalendarEventResultModel();
        r102.a(CreateCalendarEventResultModel.Code.Failed);
        r102.b("create calendar failed with unknown error, error msg = " + ((Throwable) r100).getMessage());
        r101.finishWithResult(r102);
    }
}
