package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class l0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TalkRoomFeedbackDialog f72023a;

    public l0(TalkRoomFeedbackDialog r100) {
        this.f72023a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TalkRoomFeedbackDialog r101 = this.f72023a;
        int r102 = TalkRoomFeedbackDialog.f71958r;
        r101.initData();
    }
}
