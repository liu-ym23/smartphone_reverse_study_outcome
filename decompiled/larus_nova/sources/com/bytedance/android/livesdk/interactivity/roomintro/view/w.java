package com.bytedance.android.livesdk.interactivity.roomintro.view;

import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;

/* JADX INFO: loaded from: classes9.dex */
public final class w implements LiveSwitchButton.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomIntroDialogV2 f140747a;

    public w(RoomIntroDialogV2 r100) {
        this.f140747a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
    public final void d0(LiveSwitchButton r100, boolean r101) {
        RoomIntroDialogV2 r102 = this.f140747a;
        int r103 = RoomIntroDialogV2.f140697u;
        r102.X90(r101);
        if (r101 == true) goto L6;
        RoomIntroDialogV2.W90(this.f140747a, false);
        return;
    }
}
