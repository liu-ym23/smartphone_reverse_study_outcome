package com.bytedance.android.livesdkapi.feed;

import android.os.Bundle;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feed.b;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomFlushInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
public abstract class ILiveRoomListProvider implements ILiveRoomList {
    public int flushTimes;
    protected final Set<ILiveRoomList.Listener> mListeners;

    public interface ReplaceFeedItemsCallback {
        void onDeduplication(String r100);

        void onFail(String r100, Exception r101);

        void onSuccess(List<FeedItem> r100);

        void preloadNextRoom();
    }

    public void addPreloadRooms(List<Room> r100) {
    }

    public void alterSpecificItem(int r100, FeedItem r101) {
    }

    public void configReplaceExtra(b r100) {
    }

    public void delayParseAndDispatch() {
    }

    public Bundle getBundle() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveRoomList
    public FeedExtra getFeedExtra() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveRoomList
    public FeedItem getFeedItem(int r100) {
        return null;
    }

    public List<FeedItem> getFeedItems() {
        return null;
    }

    public List<FeedItem> getHideBucketFeedItems() {
        return null;
    }

    public abstract List<Room> getRoomList();

    public void init() {
    }

    public void insertAntiItem(FeedItem r100, Room r101, Bundle r102, int r103) {
    }

    public void insertFeedItem(FeedItem r100, Room r101, Bundle r102, Long r103) {
    }

    public void insertFeedItemForIndex(FeedItem r100, Room r101, Bundle r102, int r103, Function1<Boolean, Unit> r104) {
    }

    public abstract void loadMore(int r100);

    public void parseRoomInfo(List<FeedItem> r100, FeedExtra r101, Boolean r102) {
    }

    public void preLoad(int r100) {
    }

    public void preloadPersonalizedRoomList(String r100) {
    }

    public void removeAntiItem(FeedItem r100) {
    }

    public void removeFeedItem(FeedItem r100) {
    }

    public abstract void removeRoom(long r100);

    public void replaceFeedItems(int r100, int r101, List<FeedItem> r102, List<FeedItem> r103, ReplaceFeedItemsCallback r104) {
    }

    public void dispatchChange() {
        Iterator<ILiveRoomList.Listener> r100 = this.mListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onChange();
        goto L4
    }

    public List<Room> getPreloadRooms() {
        return new ArrayList();
    }

    public void release() {
        this.mListeners.clear();
    }

    public boolean shouldInterceptCallBack() {
        Iterator<ILiveRoomList.Listener> r100 = this.mListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (r100.next().shouldIntercept() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public ILiveRoomListProvider() {
        this.mListeners = new HashSet();
        this.flushTimes = 1;
    }

    public String providerType() {
        return getClass().getSimpleName();
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveRoomList
    public void addListener(ILiveRoomList.Listener r100) {
        this.mListeners.add(r100);
    }

    public RoomFlushInfo getRoomFlushInfo(int r100) {
        return new RoomFlushInfo(this.flushTimes, r100 + 1);
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveRoomList
    public void removeListener(ILiveRoomList.Listener r100) {
        this.mListeners.remove(r100);
    }
}
