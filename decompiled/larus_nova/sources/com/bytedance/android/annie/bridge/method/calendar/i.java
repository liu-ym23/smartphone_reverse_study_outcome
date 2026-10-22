package com.bytedance.android.annie.bridge.method.calendar;

import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f38607a;

    public i(g r100) {
        this.f38607a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        CreateCalendarEventResultModel.Code r101 = (CreateCalendarEventResultModel.Code) r100;
        CreateCalendarEventResultModel.Code r102 = CreateCalendarEventResultModel.Code.Success;
        if (r101 != r102) goto L5;
        g r103 = this.f38607a;
        CreateCalendarEventResultModel r104 = new CreateCalendarEventResultModel();
        r104.a(r102);
        r104.b("create calendar success!");
        r103.finishWithResult(r104);
        return;
    L5:
        g r105 = this.f38607a;
        CreateCalendarEventResultModel r106 = new CreateCalendarEventResultModel();
        r106.a(CreateCalendarEventResultModel.Code.Failed);
        r106.b("create calendar failed!");
        r105.finishWithResult(r106);
    }
}
