package com.bytedance.android.livesdk.chatroom.roommanage.manage.bantalk.binder;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;
import py.k;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomBanTalkViewHolder f111421a;

    public d(LiveRoomBanTalkViewHolder r100) {
        this.f111421a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void h(k r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = this.f111421a.f111408c.getLayoutParams();
        int r104 = s1.f(28.0f);
        r103.width = r104;
        r103.height = (r102 * r104) / r101;
        this.f111421a.f111408c.setLayoutParams(r103);
    }
}
