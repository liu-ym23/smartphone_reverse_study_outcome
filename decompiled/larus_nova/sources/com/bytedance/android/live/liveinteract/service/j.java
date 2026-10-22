package com.bytedance.android.live.liveinteract.service;

import android.content.DialogInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataCenter f78611a;

    public j(DataCenter r100) {
        this.f78611a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        DataCenter r102 = this.f78611a;
        if (r102 == null) goto L5;
        r102.put("data_room_video_talk_log_over_for_over_path", "chat_close_icon");
    L5:
        rj0.k.f537953m2.getClass();
        rj0.k r103 = rj0.k.a.a();
        if (r103 == null) goto L9;
        rj0.k.b.a(r103);
        return;
    }
}
