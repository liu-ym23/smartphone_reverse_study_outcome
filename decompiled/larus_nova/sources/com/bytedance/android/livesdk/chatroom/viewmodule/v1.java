package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.message.model.kj;

/* JADX INFO: loaded from: classes8.dex */
public final class v1 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveEndRemindWidget f117537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f117538b;

    public v1(LiveEndRemindWidget r100, int r101, kj r102) {
        this.f117537a = r100;
        this.f117538b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (13 != this.f117538b) goto L5;
        LiveEndRemindWidget r102 = this.f117537a;
        int r103 = LiveEndRemindWidget.f114977d;
        r102.getClass();
        LiveEndRemindWidget.zq("livesdk_anchor_elderly_midnight2_popup_click", null);
    L5:
        r100.dismiss();
        LiveEndRemindWidget.xq(this.f117537a);
    }
}
