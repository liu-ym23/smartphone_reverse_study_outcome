package com.bytedance.android.live.liveinteract.linkpanel.viewbinder;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBaseUser f75112a;

    public b(IBaseUser r100) {
        this.f75112a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        xs2.b.a().post(new UserProfileEvent(this.f75112a).setClickUserPosition(UserProfileEvent.POSITION_LINKED_AUDIENCE).setReportSource("audience_audio").setReportType(UserProfileEvent.DATA_TYPE_CARD_LINKED_AUDIENCE));
    }
}
