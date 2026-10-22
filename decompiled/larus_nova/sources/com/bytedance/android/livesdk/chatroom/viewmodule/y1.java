package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class y1 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveEndRemindWidget f117679a;

    public y1(LiveEndRemindWidget r100) {
        this.f117679a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        LiveEndRemindWidget r102 = this.f117679a;
        int r103 = LiveEndRemindWidget.f114977d;
        r102.getClass();
        LiveEndRemindWidget.zq("livesdk_anchor_elderly_midnight1_popup_click", "continue");
        r100.dismiss();
    }
}
