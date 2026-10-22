package com.bytedance.android.livesdk.ktvimpl.feed;

import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface a {
    List<LinkPlayerInfo> getFeedGuestList();

    IRoom getFeedRoom();

    void setFeedGuestList(List<? extends LinkPlayerInfo> r100);
}
