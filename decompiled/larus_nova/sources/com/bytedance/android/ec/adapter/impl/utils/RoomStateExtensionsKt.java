package com.bytedance.android.ec.adapter.impl.utils;

import android.os.Bundle;
import com.bytedance.android.ec.adapter.api.state.ECEcomData;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdkapi.TTInternalBusinessService;
import com.bytedance.android.livesdkapi.room.state.AppState;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.room.state.UserState;
import com.bytedance.android.livesdkapi.service.IInternalBusinessService;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class RoomStateExtensionsKt {
    public static final com.bytedance.android.ec.adapter.api.state.a a(IRoomState r210) {
        if (r210 != null) goto L5;
        return null;
    L5:
        Map<String, String> r100 = r210.getEnterRoomParams();
        Map<String, String> r101 = r210.getReportParams();
        if (r210.getEnterRoomParams().containsKey("tmp_log_extra_for_inner") == false) goto L22;
        r100 = MapsKt.toMutableMap(r100);
        String r102 = r100.get("tmp_log_extra_for_inner");
        if (r102 == null) goto L21;
        JSONObject r103 = z1.g(r102);
        if (r103 == null) goto L21;
        r101 = MapsKt.toMutableMap(r210.getReportParams());
        if (r101.containsKey("log_extra") == true) goto L17;
        String r104 = a2.d(r103.optString("log_extra"));
        if (r104 == null) goto L17;
        r101.put("log_extra", r104);
    L17:
        if (r101.containsKey("creative_id") == true) goto L21;
        String r105 = a2.d(r103.optString("creative_id"));
        if (r105 == null) goto L21;
        r101.put("creative_id", r105);
    L21:
        r100.remove("tmp_log_extra_for_inner");
    L22:
        Map<String, String> r110 = r101;
        int r106 = r210.getItemType();
        boolean r107 = r210.isAnchor();
        boolean r108 = r210.isPortrait();
        String r111 = r210.getRoomId();
        String r112 = r210.getRoomAnchorId();
        boolean r113 = r210.isFollowed();
        boolean r114 = r210.isReplayOpen();
        Function0<Boolean> r115 = r210.isLoginFunc();
        int r116 = r210.getStreamType();
        Bundle r117 = r210.getExtra();
        int r118 = r210.getLiveSdkVersion();
        return new com.bytedance.android.ec.adapter.api.state.a(r106, r107, r108, "", r111, r112, "", r113, r114, r115, r116, r110, r117, r118, r100, r210.isKtvFun(), r210.isInInteractionGameFun(), RoomStateExtensionsKt$trans$2.INSTANCE, null, r210.getEnterFromSpecialAd(), RoomStateExtensionsKt$trans$3.INSTANCE, new ECEcomData(null));
    }

    public static final com.bytedance.android.ec.adapter.api.state.c b(final UserState r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$trans");
        IInternalBusinessService r100 = TTInternalBusinessService.Companion.getBusinessService();
        if (r100 == null) goto L5;
        AppState r101 = r100.getAppState();
    L6:
        r110.getUserName();
        r110.getAvatarUrl();
        String r102 = r110.getOpenId();
        if (r102 != null) goto L9;
        String r103 = "";
    L10:
        String r104 = r110.getSecUid();
        if (r104 != null) goto L13;
        String r105 = "";
    L14:
        if (r101 == null) goto L19;
        String r106 = r101.getClientKey();
        if (r106 == null) goto L19;
        String r107 = r106;
    L20:
        if (r101 == null) goto L23;
        String r108 = r101.getAppName();
        if (r108 == null) goto L23;
    L24:
        Function0<Boolean> r109 = new RoomStateExtensionsKt$trans$5(r110);
        Map<String, String> r111 = r110.getReportParams();
        if (r111 != null) goto L27;
        r111 = MapsKt.emptyMap();
    L27:
        Map<String, String> r112 = r111;
        Bundle r113 = r110.getExtra();
        if (r113 != null) goto L30;
        r113 = new Bundle();
    L30:
        String r114 = r103;
        String r115 = r105;
        String r116 = r107;
        String r117 = r108;
        return new com.bytedance.android.ec.adapter.api.state.c(r114, r115, r116, r117, r109, r112, r113);
    L23:
        r108 = "";
    L19:
        r107 = "";
        goto L20
    L13:
        r105 = r104;
        goto L14
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
