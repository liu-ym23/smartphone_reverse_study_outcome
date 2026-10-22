package com.bytedance.android.live.room.enterprocess;

import android.os.Bundle;
import com.bytedance.android.livesdk.commerce.a;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.ies.sdk.widgets.DataCenter;
import is2.g;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JU\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0014\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u001c\u0010\u001a\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/room/enterprocess/IRoomBizInterceptor;", "", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "enterRoomParams", "Lcom/bytedance/android/livesdk/commerce/a;", "eventParams", "", "", "isSpecialAdRef", "", "processFetchRoomState", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Ljava/util/HashMap;Lcom/bytedance/android/livesdk/commerce/a;[Ljava/lang/Boolean;)V", "Landroid/os/Bundle;", "targetRoomArgs", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "targetRoom", "processShowInteractionFragment", "Lcom/bytedance/android/livesdkapi/depend/model/live/room/RoomBaseSession;", "roomBaseSession", "", "Lis2/g;", "getExtraLifecycleObserverV2", "processOnCreate", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomBizInterceptor {
    List<g> getExtraLifecycleObserverV2(RoomBaseSession r100);

    void processFetchRoomState(DataCenter r100, HashMap<String, String> r101, a r102, Boolean[] r103);

    void processOnCreate(Bundle r100, DataCenter r101);

    void processShowInteractionFragment(Bundle r100, DataCenter r101, Room r102);
}
