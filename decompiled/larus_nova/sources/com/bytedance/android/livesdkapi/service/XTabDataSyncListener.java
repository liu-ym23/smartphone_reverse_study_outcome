package com.bytedance.android.livesdkapi.service;

import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\u0003H&J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/XTabDataSyncListener;", "", "onInnerLiveRoomFinish", "", "position", "", "roomId", "", "onInnerLoadMore", "onInnerPositionChange", "lastPosition", "onRemoveRoom", "onRestoreItem", "onStoreItem", "roomList", "", "", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface XTabDataSyncListener {
    void onInnerLiveRoomFinish(int r100, long r101);

    void onInnerLoadMore();

    void onInnerPositionChange(int r100, long r101, int r102);

    void onRemoveRoom(long r100);

    void onRestoreItem();

    void onStoreItem(Set<String> r100);
}
