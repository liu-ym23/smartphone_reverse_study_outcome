package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.text.TextUtils;
import android.widget.Button;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.widget.TalkRoomFeedbackView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class g0 implements TalkRoomFeedbackView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TalkRoomFeedbackDialog f72004a;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.widget.TalkRoomFeedbackView.a
    public final void a() {
        TalkRoomFeedbackDialog r100 = this.f72004a;
        int r101 = TalkRoomFeedbackDialog.f71958r;
        r100.Z90();
        if (TextUtils.isEmpty(((TalkRoomFeedbackView) this.f72004a.S90(R.id.feedback_view)).getSelectedTag()) == false) goto L7;
        Button r102 = (Button) this.f72004a.S90(R.id.ttlive_submit);
        if (r102 == null) goto L10;
        r102.setAlpha(0.34f);
    L10:
        TalkRoomFeedbackDialog.V90(this.f72004a, "enter");
        return;
    L7:
        Button r103 = (Button) this.f72004a.S90(R.id.ttlive_submit);
        if (r103 == null) goto L10;
        r103.setAlpha(1.0f);
        goto L10
    }

    public g0(TalkRoomFeedbackDialog r100) {
        this.f72004a = r100;
    }
}
