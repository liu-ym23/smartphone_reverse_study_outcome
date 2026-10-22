package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class q3 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f117345a;

    public q3(Context r100) {
        this.f117345a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        puc.a.runApplication(this.f117345a, "com.ss.android.ugc.aweme", null);
        r100.cancel();
    }
}
