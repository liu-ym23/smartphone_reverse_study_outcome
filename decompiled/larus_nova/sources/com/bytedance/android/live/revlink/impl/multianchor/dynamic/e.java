package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.bytedance.android.live.link.data.RevPkResult;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.x2;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public static final JSONObject c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJSONObject");
        return new JSONObject(GsonProtectorUtils.toJson(l97.a.f508113a, r100));
    }

    public static final JSONObject d(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJsonObject");
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, ?>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, ?> r103 = r102.next();
        r101.put(r103.getKey(), new f(r103.getValue()));
        goto L4
    L6:
        return r101;
    }

    public static final String e(vh7.c<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJsonString");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(l97.a.f508113a.toJson(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9456isSuccessimpl(r102) == true) goto L10;
        return "";
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        String r103 = (String) r102;
        if (r103 != null) goto L16;
        return "";
    L16:
        return r103;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final int f(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 != null) goto L15;
    L17:
        return 0;
    L15:
        if (r100.intValue() != 0) goto L17;
        return 3;
    L10:
        if (r100.intValue() != 2) goto L12;
    L19:
        return r100.intValue();
    L5:
        if (r100.intValue() != 1) goto L7;
        goto L7
    }

    public static final HybridType getType(zy0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$type");
        xy0.a<?> r101 = r100.g();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.o();
    }

    public static final JSONObject a(int r110, com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b r111) {
        JSONObject r100 = new JSONObject();
        r100.put("state", r110);
        if (r111 == null) goto L5;
        IBaseBattleSetting r101 = r111.getBattleSettings();
    L6:
        r100.put("battle_settings", r101);
        if (r111 == null) goto L9;
        Map<String, IBattleUserInfo> r102 = r111.getBattleUserInfoMap();
    L10:
        r100.put("play_anchor_list", r102);
        if (r111 == null) goto L15;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r103 = r111.getSkinConfig();
        if (r103 == null) goto L15;
        Long r104 = Long.valueOf(r103.f92697a);
    L16:
        r100.put("skin_type", r104);
        if (r111 == null) goto L21;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r105 = r111.getSkinConfig();
        if (r105 == null) goto L21;
        x2 r106 = r105.f92698b;
    L22:
        r100.put("skin_config", r106);
        if (r111 == null) goto L27;
        LiveData<Long> r107 = r111.I();
        if (r107 == null) goto L27;
        Long r108 = r107.getValue();
    L28:
        r100.put("remain_time", r108);
        r100.put("result", r111.getPkResult().getValue());
        if (r111.getPkResult().getValue() == null) goto L31;
    L73:
        Map<String, Long> r112 = r111.getUserIdToTeamId();
        if (r112 == null) goto L79;
        LinkedHashMap r109 = new LinkedHashMap(MapsKt.mapCapacity(r112.size()));
        Iterator<T> r113 = r112.entrySet().iterator();
    L77:
        if (r113.hasNext() == false) goto L80;
        Map.Entry r114 = (Map.Entry) r113.next();
        r109.put(r114.getKey(), Integer.valueOf(((int) ((Number) r114.getValue()).longValue()) - 1));
    L80:
        r100.put("team_info", r109);
        Intrinsics.checkNotNullParameter(r111, "$this$getPlayScoresJSONObject");
        JSONObject r115 = new JSONObject();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r116 = r111.getScoreState().getValue();
        if (r116 == null) goto L89;
        List<af2.b> r117 = r116.b();
        if (r117 == null) goto L89;
        List<af2.b> r118 = r117;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator<T> r120 = r118.iterator();
    L86:
        if (r120.hasNext() == false) goto L88;
        r119.add(new JSONObject(GsonProtectorUtils.toJson(l97.a.f508113a, (af2.b) r120.next())));
        goto L86
    L88:
        int r121 = com.bytedance.revenue.platform.api.core.b.f267506a;
        r115.put("battle_scores", JSONObject.wrap(r119));
    L89:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r122 = r111.getScoreState().getValue();
        if (r122 == null) goto L94;
        n3 r123 = r122.a();
        if (r123 == null) goto L94;
        JSONObject r124 = c(r123);
    L95:
        r115.put("pve_data", r124);
        r100.put("play_scores", r115);
        r100.put("team_task", r111.getTeamTaskLynxData().getValue());
        r100.put("contribution_list", null);
        r100.put("channel_id", r111.G());
        return r100;
    L94:
        r124 = null;
        goto L95
    L79:
        r109 = null;
        goto L80
    L31:
        if (r110 == RevPkState.PK.ordinal()) goto L73;
        if (r102 == null) goto L36;
        IBattleUserInfo r125 = r102.get(r111.getAnchorId());
        if (r125 == null) goto L36;
        Integer r126 = Integer.valueOf(r125.getPkResult());
    L38:
        if (r102 == null) goto L40;
        int r127 = r102.size();
    L42:
        if (r127 <= 2) goto L67;
        if (r102 == null) goto L57;
        Iterator<Map.Entry<String, IBattleUserInfo>> r128 = r102.entrySet().iterator();
        boolean r129 = true;
    L46:
        if (r128.hasNext() == false) goto L58;
        Map.Entry<String, IBattleUserInfo> r130 = r128.next();
        String r131 = r130.getKey();
        IBattleUserInfo r132 = r130.getValue();
        if (r132 == null) goto L50;
        Integer r133 = Integer.valueOf(r132.getPkResult());
    L51:
        int r134 = r133.intValue();
        if (r126 == null) goto L56;
        if (r134 == r126.intValue()) goto L46;
    L56:
        r129 = false;
        goto L46
    L50:
        r133 = null;
    L58:
        if (r129 == false) goto L60;
        int r135 = RevPkResult.EVEN.ordinal();
    L64:
        Integer r136 = Integer.valueOf(r135);
    L66:
        r100.put("result", r136);
        goto L73
    L60:
        if (r102 == null) goto L65;
        IBattleUserInfo r137 = r102.get(r111.getAnchorId());
        if (r137 == null) goto L65;
        r135 = r137.getPkResult();
    L65:
        r136 = null;
        goto L66
    L57:
        r129 = true;
        goto L58
    L67:
        if (r102 == null) goto L71;
        IBattleUserInfo r138 = r102.get(r111.getAnchorId());
        if (r138 == null) goto L71;
        Integer r139 = Integer.valueOf(r138.getPkResult());
    L72:
        r100.put("result", r139);
    L71:
        r139 = null;
        goto L72
    L40:
        r127 = 0;
    L36:
        r126 = null;
    L27:
        r108 = null;
    L21:
        r106 = null;
    L15:
        r104 = null;
        goto L16
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public static final MediatorLiveData b(LiveData r100, String r101, FormatType r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$sendDataToLynxMulti");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "formatMap");
        MediatorLiveData r103 = new MediatorLiveData();
        r103.addSource(r100, new d(r103, r101, r102));
        return r103;
    }
}
