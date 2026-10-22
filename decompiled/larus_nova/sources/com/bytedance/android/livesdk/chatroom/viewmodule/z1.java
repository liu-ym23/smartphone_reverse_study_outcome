package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.message.model.kj;

/* JADX INFO: loaded from: classes8.dex */
public final class z1 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveEndRemindWidget f117684a;

    public z1(LiveEndRemindWidget r100, kj r101) {
        this.f117684a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        LiveEndRemindWidget r102 = this.f117684a;
        int r103 = LiveEndRemindWidget.f114977d;
        r102.getClass();
        LiveEndRemindWidget.zq("livesdk_anchor_elderly_midnight1_popup_click", "close");
        LiveEndRemindWidget.xq(this.f117684a);
        r100.dismiss();
    }
}
