package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermissionGrantedItem f116753a;

    public a(PermissionGrantedItem r100) {
        this.f116753a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        qk1.a r100 = this.f116753a.f116721b;
        if (r100 == null) goto L6;
        r100.f533454a.clear();
        return;
    }
}
