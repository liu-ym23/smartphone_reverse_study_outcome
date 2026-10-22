package com.bytedance.android.livesdk.chatroom.replay.session.video.task;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f109948a;

    public c(e r100) {
        this.f109948a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f109948a.f109950b.f118130d.f118069w.setValue("click");
    }
}
