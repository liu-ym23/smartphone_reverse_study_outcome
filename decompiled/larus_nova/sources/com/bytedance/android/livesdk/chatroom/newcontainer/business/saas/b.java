package com.bytedance.android.livesdk.chatroom.newcontainer.business.saas;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.room.enterprocess.IEnterProcessorService;
import com.bytedance.android.live.room.enterprocess.IFeedBizInterceptor;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ls2.c> {
    @Override // gs2.a
    public final String taskID() {
        return "RoomSessionTaskConst_SaaSSessionContainerIntentInitTask";
    }

    @Override // com.bytedance.android.livesdk.room.Task.base.LiveTask
    public final List<String> f() {
        return CollectionsKt.listOf("RoomSessionTaskConst_SessionContainerIntentInitTask");
    }

    @Override // gs2.a
    public final void run() {
        IEnterProcessorService r100 = (IEnterProcessorService) k.f(IEnterProcessorService.class);
        Lifecycle r101 = null;
        if (r100 == null) goto L5;
        IFeedBizInterceptor r102 = r100.feedBizInterceptor();
    L6:
        ls2.d r103 = h();
        if (r103 == null) goto L9;
        ik1.d r104 = (ik1.d) r103.b("RoomSessionTaskConst_live_room_container_data");
    L10:
        if (r102 == null) goto L19;
        ls2.d r105 = h();
        if (r105 == null) goto L14;
        Bundle r106 = r105.f510526o;
    L15:
        if (r104 == null) goto L17;
        Bundle r107 = r104.f490227c;
    L18:
        r102.processHandleIntent(r106, r107);
        goto L19
    L17:
        r107 = null;
        goto L18
    L14:
        r106 = null;
    L19:
        ls2.d r108 = h();
        if (r108 == null) goto L22;
        ik1.b r109 = (ik1.b) r108.b("RoomSessionTaskConst_live_room_inner_feed_data");
    L23:
        if (r109 == null) goto L25;
        ILiveRoomListProvider r110 = r109.f490186c;
    L26:
        if (r110 == null) goto L55;
        if (r102 == null) goto L56;
        ls2.d r111 = h();
        if (r111 == null) goto L31;
        String r112 = r111.f510516e;
    L32:
        ls2.d r113 = h();
        if (r113 == null) goto L35;
        String r114 = r113.f510517f;
    L36:
        ls2.d r115 = h();
        if (r115 == null) goto L39;
        Bundle r116 = r115.f510526o;
    L40:
        if (r104 == null) goto L42;
        Bundle r117 = r104.f490227c;
    L43:
        ls2.d r118 = h();
        if (r118 == null) goto L46;
        Activity r119 = r118.f510523l;
    L48:
        if ((r119 instanceof FragmentActivity) == true) goto L50;
        r119 = null;
    L50:
        FragmentActivity r120 = (FragmentActivity) r119;
        if (r120 == null) goto L53;
        r101 = r120.getLifecycle();
    L53:
        r102.processSetup(r112, r114, r116, r117, r101);
        return;
    L46:
        r119 = null;
        goto L48
    L42:
        r117 = null;
        goto L43
    L39:
        r116 = null;
        goto L40
    L35:
        r114 = null;
        goto L36
    L31:
        r112 = null;
        goto L32
    L56:
        return;
    L55:
        return;
    L25:
        r110 = null;
        goto L26
    L22:
        r109 = null;
        goto L23
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public b() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
