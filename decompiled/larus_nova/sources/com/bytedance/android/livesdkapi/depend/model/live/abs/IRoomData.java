package com.bytedance.android.livesdkapi.depend.model.live.abs;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;

/* JADX INFO: loaded from: classes12.dex */
public interface IRoomData extends IRoomType {
    String getAnchorId();

    EpisodeExtraInfo getEpisodeExtra2();

    int getFansMessageStyle();

    int getFollowMessageStyle();

    int getGiftMessageStyle();

    long getId();

    int getOrientation();

    User getOwner();

    RoomAuthStatus getRoomAuthStatus();

    long getRoomId();

    int getShareMessageStyle();

    LiveMode getStreamType();

    boolean isEnableChat(boolean r100);
}
