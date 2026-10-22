package com.bytedance.android.livesdkapi.roomset;

import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&J(\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&J$\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0007H&J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H&J\"\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aH&J\u001a\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005H&¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/roomset/IRoomSetManager;", "Lcom/bytedance/android/live/base/IService;", "getCurrentRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getLogTag", "", "logCoreFlow", "", "msg", "extras", "", "", "logExtraFlow", "onChangeRoom", "sourceRoom", "destRoom", "reason", LiveCommonConstants.REASON_ON_DEDTROY, "onInit", "bundle", "Landroid/os/Bundle;", "tag", "onInnerRoomsChange", "mListProvider", "Lcom/bytedance/android/livesdkapi/feed/ILiveRoomListProvider;", "incrRooms", "", "onStartFirstRoom", "room", "position", "", "onStop", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomSetManager extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logCoreFlow$default(IRoomSetManager r100, String r101, Map r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.logCoreFlow(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logCoreFlow");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logExtraFlow$default(IRoomSetManager r100, String r101, Map r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.logExtraFlow(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logExtraFlow");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onInnerRoomsChange$default(IRoomSetManager r100, ILiveRoomListProvider r101, List r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.onInnerRoomsChange(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onInnerRoomsChange");
        }
    }

    Room getCurrentRoom();

    String getLogTag();

    void logCoreFlow(String r100, Map<String, ? extends Object> r101);

    void logExtraFlow(String r100, Map<String, ? extends Object> r101);

    void onChangeRoom(Room r100, Room r101, String r102);

    void onDestroy();

    void onInit(Bundle r100, String r101);

    void onInnerRoomsChange(ILiveRoomListProvider r100, List<Room> r101);

    void onStartFirstRoom(Room r100, int r101);

    void onStop(String r100);
}
