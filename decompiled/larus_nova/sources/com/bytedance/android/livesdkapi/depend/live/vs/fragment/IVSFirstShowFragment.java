package com.bytedance.android.livesdkapi.depend.live.vs.fragment;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes12.dex */
public interface IVSFirstShowFragment extends IVSItemBaseFragment {
    IRoom getCurRoom();

    ILiveRoomPlayFragment.LiveRoomListener getLiveRoomListener();

    void prePullStream();

    void preRequestRoomEnter();

    void preRequestRoomPreload(boolean r100);

    void setLiveRoomListener(ILiveRoomPlayFragment.LiveRoomListener r100);

    void stopPlayerForNextRoomPrePullStream();

    void stopRoomWithoutReleasePlayer();
}
