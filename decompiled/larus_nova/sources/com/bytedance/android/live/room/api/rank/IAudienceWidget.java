package com.bytedance.android.live.room.api.rank;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import java.util.List;
import q46.a;

/* JADX INFO: loaded from: classes47.dex */
public interface IAudienceWidget extends IWidget, a {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    /* synthetic */ Context getContext();

    void ii(List<x71.a> r100);

    void sn(boolean r100, long r101, String r102, String r103);
}
