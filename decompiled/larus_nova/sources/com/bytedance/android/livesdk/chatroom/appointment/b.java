package com.bytedance.android.livesdk.chatroom.appointment;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppointmentAnchorWidget f105104a;

    public b(AppointmentAnchorWidget r100) {
        this.f105104a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        AppointmentAnchorWidget r101 = this.f105104a;
        int r102 = AppointmentAnchorWidget.f105100c;
        r101.getClass();
        int r103 = x8.a.f562881a;
        x8.a.b("AppointmentAnchorWidget", "query subscribe count fail" + ((Throwable) r100), false);
    }
}
