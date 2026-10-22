package com.bytedance.android.livesdkapi.multilink;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.message.model.gc;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J&\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH&J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H&J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H&J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0019H&J \u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0019H&J \u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0019H&J \u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0019H&J\b\u0010\u001e\u001a\u00020\fH&J*\u0010$\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\fH&¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/multilink/IMultiLinkWRDSPreloadService;", "Lcom/bytedance/android/live/base/IService;", "", "scene", "", "", "publisherRoomId", "", "registerPublisher", "clearTargetScene", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "", "needFetchListV2", "Lcom/bytedance/android/livesdkapi/depend/message/RoomLinkMicSyncData;", "getRoomLinkMicSyncData", "removeRoomLinkMicSyncData", "roomid", "Lcom/bytedance/android/livesdkapi/multilink/RoomLinkMicSyncDataPreloadBizListener;", "listener", "addRoomLinkMicSyncDataBizListener", "roomId", "removeRoomLinkMicSyncDataBizListener", "Lcom/bytedance/android/livesdk/message/model/gc;", "getBgMsg", "Lcom/bytedance/android/livesdkapi/multilink/MultiLinkMsgPreloadBizListener;", "addBgMsgBizListener", "removeBgMsgBizListener", "addLinkMicMsgBizListener", "removeLinkMicMsgBizListener", "enableStatusBarMarginOpt", "subTag", "", "hashCode", "content", "needHighLight", "printALogger", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMultiLinkWRDSPreloadService extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ RoomLinkMicSyncData getRoomLinkMicSyncData$default(IMultiLinkWRDSPreloadService r100, String r101, IRoom r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = true;
        L7:
            return r100.getRoomLinkMicSyncData(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRoomLinkMicSyncData");
        }

        public static /* synthetic */ void printALogger$default(IMultiLinkWRDSPreloadService r100, String r101, int r102, String r103, boolean r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = false;
        L6:
            r100.printALogger(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: printALogger");
        }
    }

    void addBgMsgBizListener(String r100, long r101, MultiLinkMsgPreloadBizListener r102);

    void addLinkMicMsgBizListener(String r100, long r101, MultiLinkMsgPreloadBizListener r102);

    void addRoomLinkMicSyncDataBizListener(String r100, long r101, RoomLinkMicSyncDataPreloadBizListener r102);

    void clearTargetScene(String r100);

    boolean enableStatusBarMarginOpt();

    gc getBgMsg(String r100, IRoom r101);

    RoomLinkMicSyncData getRoomLinkMicSyncData(String r100, IRoom r101, boolean r102);

    void printALogger(String r100, int r101, String r102, boolean r103);

    void registerPublisher(String r100, List<Long> r101);

    void removeBgMsgBizListener(String r100, long r101, MultiLinkMsgPreloadBizListener r102);

    void removeLinkMicMsgBizListener(String r100, long r101, MultiLinkMsgPreloadBizListener r102);

    void removeRoomLinkMicSyncData(String r100, IRoom r101);

    void removeRoomLinkMicSyncDataBizListener(String r100, long r101, RoomLinkMicSyncDataPreloadBizListener r102);
}
