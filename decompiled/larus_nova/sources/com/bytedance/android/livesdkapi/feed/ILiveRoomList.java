package com.bytedance.android.livesdkapi.feed;

import android.os.Bundle;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveRoomList {

    public interface Listener {
        void onChange();

        boolean shouldIntercept();
    }

    void addListener(Listener r100);

    FeedExtra getFeedExtra();

    FeedItem getFeedItem(int r100);

    Bundle getRoomArgs(int r100);

    int indexOf(Bundle r100);

    void removeListener(Listener r100);

    int size();
}
