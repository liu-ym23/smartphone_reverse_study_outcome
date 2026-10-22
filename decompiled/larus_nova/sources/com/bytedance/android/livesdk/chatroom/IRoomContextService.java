package com.bytedance.android.livesdk.chatroom;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001e\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH&J\u001e\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH&J\u001e\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH&J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001e\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH&¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/IRoomContextService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/live/datacontext/DataContext;", "dataContext", "Lcom/bytedance/android/livesdk/chatroom/o;", "getRoomDataContext", "Lcom/bytedance/android/livesdk/chatroom/s;", "getRoomGiftService", "Lcom/bytedance/android/livesdk/chatroom/t;", "getRoomInteractivityService", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "roomId", "Lcom/bytedance/android/livesdk/chatroom/u;", "getRoomMultiLinkService", "Lcom/bytedance/android/livesdk/chatroom/k;", "getBottomToolbarService", "Lcom/bytedance/android/livesdk/chatroom/r;", "getRoomExpService", "Lcom/bytedance/android/livesdkapi/model/BackendGeneratedData;", "getPreEnterRoomBackendData", "Lcom/bytedance/android/livesdk/chatroom/v;", "getRoomProfileService", "Lcom/bytedance/android/livesdk/chatroom/q;", "getRoomDslService", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomContextService extends IService {

    public static final class a {
        public static /* synthetic */ q b(IRoomContextService r100, DataCenter r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.getRoomDslService(r101, 0);
        }

        public static /* synthetic */ t c(IRoomContextService r100, DataCenter r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.getRoomInteractivityService(r101, 0);
        }

        public static /* synthetic */ o a(IRoomContextService r100, DataCenter r101, long r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = 0;
        L9:
            return r100.getRoomDataContext(r101, r102);
        }
    }

    k getBottomToolbarService(DataCenter r100, long r101);

    k getBottomToolbarService(DataContext r100);

    BackendGeneratedData getPreEnterRoomBackendData(long r100);

    o getRoomDataContext(DataCenter r100, long r101);

    o getRoomDataContext(DataContext r100);

    q getRoomDslService(DataCenter r100, long r101);

    q getRoomDslService(DataContext r100);

    r getRoomExpService(DataCenter r100, long r101);

    r getRoomExpService(DataContext r100);

    s getRoomGiftService(DataCenter r100, long r101);

    s getRoomGiftService(DataContext r100);

    t getRoomInteractivityService(DataCenter r100, long r101);

    t getRoomInteractivityService(DataContext r100);

    u getRoomMultiLinkService(DataCenter r100, long r101);

    u getRoomMultiLinkService(DataContext r100);

    v getRoomProfileService(DataCenter r100, long r101);

    v getRoomProfileService(DataContext r100);
}
