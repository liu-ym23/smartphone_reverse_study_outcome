package com.bytedance.android.live.room.enterprocess;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.commerce.a;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0091\u0001\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t`\n2\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u001b\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/room/enterprocess/IInteractionBizInterceptor;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "targetRoom", "Landroid/os/Bundle;", "extraArg", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "enterRoomParams", "outAdLiveParams", "Lcom/bytedance/android/livesdk/commerce/a;", "eventParams", "", "", "isSpecialAdRef", "", "processFetchRoomState", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;Landroid/os/Bundle;Lcom/bytedance/ies/sdk/widgets/DataCenter;Ljava/util/HashMap;Ljava/util/HashMap;Lcom/bytedance/android/livesdk/commerce/a;[Ljava/lang/Boolean;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/ies/sdk/widgets/WidgetManager;", "widgetManager", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "processPrepareWidget", "processContinueAfterWidgetLoaded", "doDiggActionWithToken", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInteractionBizInterceptor {
    void doDiggActionWithToken(Context r100);

    void processContinueAfterWidgetLoaded();

    void processFetchRoomState(Room r100, Bundle r101, DataCenter r102, HashMap<String, String> r103, HashMap<String, String> r104, a r105, Boolean[] r106);

    void processPrepareWidget(Context r100, WidgetManager r101, MiddlewareRoomContext r102);
}
