package com.bytedance.android.livesdkapi.feed;

/* JADX INFO: loaded from: classes12.dex */
public class LiveRoomListDataSource implements ILiveRoomListDataSource {
    private static LiveRoomListDataSource instance;
    private ILiveRoomListProvider mCurrentLiveRoomListProvider;

    static {
        instance = new LiveRoomListDataSource();
    }

    public LiveRoomListDataSource() {
        this.mCurrentLiveRoomListProvider = null;
    }

    public static LiveRoomListDataSource instance() {
        return instance;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource
    public ILiveRoomListProvider getLiveRoomListProvider() {
        return this.mCurrentLiveRoomListProvider;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource
    public void setCurrentRoomList(ILiveRoomListProvider r100) {
        this.mCurrentLiveRoomListProvider = r100;
    }
}
