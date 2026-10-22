package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.widget.TalkRoomFeedbackView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class e0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TalkRoomFeedbackDialog f71999a;

    public e0(TalkRoomFeedbackDialog r100) {
        this.f71999a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((TalkRoomFeedbackView) this.f71999a.S90(R.id.feedback_view)).setVisibility(0);
        ((TextView) this.f71999a.S90(R.id.tv_feedback_exhibition)).setVisibility(4);
    }
}
