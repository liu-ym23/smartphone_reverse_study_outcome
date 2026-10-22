package com.bytedance.android.livesdk.chatroom.methodchannel.ablity;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.livestate.ILiveStateService;
import com.bytedance.android.livesdkapi.livestate.LiveStateRequest;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class SaasCheckLiveRoomMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f106839a = 0;

    public static final class a {
    }

    static {
    }

    public static ng2.h a(JSONArray r100) {
        ng2.h r101 = new ng2.h();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L19;
        Object r104 = r100.get(r103);
        if (r104 == null) goto L18;
        JSONObject r105 = (JSONObject) r104;
        if (r105.has("open_user_id") == false) goto L16;
        if (r105.has("distribution_scene") == false) goto L16;
        ((ArrayList) r101.f519051a).add(r105.optString("open_user_id"));
        ((ArrayList) r101.f519052b).add(Long.valueOf(r105.optLong("distribution_scene")));
        String r106 = r105.optString("relative_log_id");
        if ((!StringsKt.isBlank(r106)) == false) goto L13;
        ((ArrayList) r101.f519053c).add(r106);
    L13:
        int r107 = r105.optInt("is_living", -1);
        if (r107 == (-1)) goto L16;
        ((ArrayList) r101.f519054d).add(Integer.valueOf(r107));
    L16:
        r103 = r103 + 1;
        goto L3
    L18:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    L19:
        return r101;
    }

    public static boolean b(Object... r110) {
        Intrinsics.checkNotNullParameter(r110, "args");
        Object r100 = r110[1];
        if ((r100 instanceof sy.b) == true) goto L55;
        return false;
    L55:
        if (r100 == null) goto L51;
        final sy.b r101 = (sy.b) r100;     // Catch: Exception -> L52
        Object r102 = r110[0];     // Catch: Exception -> L47
        if ((r102 instanceof JSONArray) == false) goto L46;
        if (r102 == null) goto L44;
        final ng2.h r103 = a((JSONArray) r102);     // Catch: Exception -> L47
        if (((ArrayList) r103.f519051a).size() != 0) goto L15;
    L41:
        r101.onFail();
        return false;
    L15:
        if (((ArrayList) r103.f519051a).size() != ((ArrayList) r103.f519052b).size()) goto L41;
        if (((ArrayList) r103.f519053c).size() == ((ArrayList) r103.f519051a).size()) goto L21;
        ((ArrayList) r103.f519053c).clear();
    L21:
        if (((ArrayList) r103.f519054d).size() == ((ArrayList) r103.f519051a).size()) goto L24;
        ((ArrayList) r103.f519054d).clear();
    L24:
        if (r110.length < 3) goto L38;
        Object r104 = r110[2];
        if ((r104 instanceof Long) == false) goto L38;
        if (r104 == null) goto L37;
        if (((Long) r104).longValue() <= 0) goto L38;
        Object r111 = r110[2];
        if (r111 == null) goto L35;
        long r105 = ((Long) r111).longValue();
    L39:
        ((ILiveStateService) jc1.k.n(ILiveStateService.class)).checkRoomStatus(new LiveStateRequest.Builder().eagerUserIds(r103.f519051a).eagerSceneIds(r103.f519052b).requestIds(r103.f519053c).isLiving(r103.f519054d).requestNetWorkTimeOut(r105).callback(new SaasCheckLiveRoomMethod$invoke$request$1(r103, r101)).errorCallback(new SaasCheckLiveRoomMethod$invoke$request$2(r101)).build());
        return true;
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L37:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L38:
        r105 = 2000;
        goto L39
    L44:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");     // Catch: Exception -> L47
    L46:
        throw new IllegalArgumentException("参数解析异常，第一个参数需要是JSONArray");     // Catch: Exception -> L47
    L47:
        e = move-exception;
        ALogger.e("SaasCheckLiveRoomMethod", "解析房间参数异常 exception=" + e);
        e.toString();
        r101.onFail();
        return false;
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.api.callback.CommonCallback<org.json.JSONArray, kotlin.String>");     // Catch: Exception -> L52
    L52:
        e = move-exception;
        ALogger.e("SaasCheckLiveRoomMethod", "解析Callback参数异常 exception=" + e);
        return false;
    }
}
