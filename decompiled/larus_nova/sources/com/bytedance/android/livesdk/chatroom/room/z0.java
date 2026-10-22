package com.bytedance.android.livesdk.chatroom.room;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class z0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SchemaStreamRequestManager f111177a;

    public z0(SchemaStreamRequestManager r100) {
        this.f111177a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f111177a.d();
        SchemaStreamRequestManager r101 = this.f111177a;
        String r102 = "request failed : " + ((Throwable) r100).getMessage();
        r101.getClass();
        SchemaStreamRequestManager.a(r102);
    }
}
