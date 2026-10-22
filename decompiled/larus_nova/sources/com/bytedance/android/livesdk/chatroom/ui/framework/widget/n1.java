package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class n1 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserCompositeWidget f113448a;

    public n1(UserCompositeWidget r100) {
        this.f113448a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        UserCompositeWidget r101 = this.f113448a;
        int r102 = UserCompositeWidget.f113266f;
        r101.wq("query_user_holding_living");
        this.f113448a.getClass();
        zg1.h1 r103 = new zg1.h1(8);
        xs2.b.a().post(r103);
    }
}
