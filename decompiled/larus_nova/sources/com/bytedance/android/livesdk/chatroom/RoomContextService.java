package com.bytedance.android.livesdk.chatroom;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/RoomContextService;", "Lcom/bytedance/android/livesdk/chatroom/IRoomContextService;", "Lcom/bytedance/live/datacontext/DataContext;", "dataContext", "Lcom/bytedance/android/livesdk/chatroom/o;", "getRoomDataContext", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "roomId", "Lcom/bytedance/android/livesdk/chatroom/s;", "getRoomGiftService", "Lcom/bytedance/android/livesdk/chatroom/t;", "getRoomInteractivityService", "Lcom/bytedance/android/livesdk/chatroom/u;", "getRoomMultiLinkService", "Lcom/bytedance/android/livesdk/chatroom/k;", "getBottomToolbarService", "Lcom/bytedance/android/livesdk/chatroom/v;", "getRoomProfileService", "Lcom/bytedance/android/livesdk/chatroom/q;", "getRoomDslService", "Lcom/bytedance/android/livesdk/chatroom/r;", "getRoomExpService", "Lcom/bytedance/android/livesdkapi/model/BackendGeneratedData;", "getPreEnterRoomBackendData", "<init>", "()V", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomContextService implements IRoomContextService {
    public RoomContextService() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public k getBottomToolbarService(DataContext r100) {
        Intrinsics.checkNotNullParameter(r100, "dataContext");
        return new l0(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public BackendGeneratedData getPreEnterRoomBackendData(long r100) {
        IRoomModuleService r101 = (IRoomModuleService) jc1.k.f(IRoomModuleService.class);
        if (r101 == null) goto L9;
        hn1.b r102 = r101.getPreEnterRoomManager();
        if (r102 == null) goto L9;
        MutableLiveData<BackendGeneratedData> r103 = r102.getPreEnterRoomBackendData(r100);
        if (r103 == null) goto L9;
        return r103.getValue();
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public o getRoomDataContext(DataContext r100) {
        return new q0(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public q getRoomDslService(DataContext r100) {
        Intrinsics.checkNotNullParameter(r100, "dataContext");
        return new r0(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public r getRoomExpService(DataContext r100) {
        Intrinsics.checkNotNullParameter(r100, "dataContext");
        return new s0(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public s getRoomGiftService(DataContext r100) {
        Intrinsics.checkNotNullParameter(r100, "dataContext");
        return new t0(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public t getRoomInteractivityService(DataContext r100) {
        return new v0(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public u getRoomMultiLinkService(DataContext r100) {
        return new w0(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public v getRoomProfileService(DataContext r100) {
        Intrinsics.checkNotNullParameter(r100, "dataContext");
        return new x0(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public k getBottomToolbarService(DataCenter r100, long r101) {
        return new l0(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public o getRoomDataContext(DataCenter r100, long r101) {
        return new q0(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public q getRoomDslService(DataCenter r100, long r101) {
        return new r0(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public r getRoomExpService(DataCenter r100, long r101) {
        return new s0(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public s getRoomGiftService(DataCenter r100, long r101) {
        return new t0(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public t getRoomInteractivityService(DataCenter r100, long r101) {
        return new v0(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public u getRoomMultiLinkService(DataCenter r100, long r101) {
        return new w0(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.IRoomContextService
    public v getRoomProfileService(DataCenter r100, long r101) {
        return new x0(r100, r101);
    }
}
