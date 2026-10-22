package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.monitor.room;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f107293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.room.b f107294b;

    public b(d r100, com.bytedance.android.livesdk.room.b r101) {
        this.f107293a = r100;
        this.f107294b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        hl0.a r101 = (hl0.a) r100;
        this.f107293a.z("enter failed ", "failed: server code: " + r101.f485661a + ", errorMsg:" + r101.f485662b + ", logId:" + r101.f485663c);
        d r102 = this.f107293a;
        r102.f107301f = true;
        r102.C(this.f107294b, 1, "errorCode: " + r101.f485661a + ", " + r101.f485662b, "eventHub->enterFailed");
    }
}
