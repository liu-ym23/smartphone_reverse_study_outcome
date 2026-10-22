package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.log.ALogger;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, String> f78837a = null;

    static {
        f78837a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(9, "bgm"), TuplesKt.to(8, "ksong"), TuplesKt.to(10, "ktv"), TuplesKt.to(Integer.MAX_VALUE, "order_by_user"), TuplesKt.to(11, "rechargeable_normal"), TuplesKt.to(6, "sing_challenge"), TuplesKt.to(5, "boom"), TuplesKt.to(7, "grouppk"), TuplesKt.to(16, "room_grouppk"), TuplesKt.to(21, "music"), TuplesKt.to(17, "self_discipline"), TuplesKt.to(13, "enlarge"), TuplesKt.to(23, "pk_chorus"), TuplesKt.to(19, "request_song"), TuplesKt.to(34, "guest_starwish"), TuplesKt.to(31, "danmu"), TuplesKt.to(39, "chorus_concert"), TuplesKt.to(38, "zhuzhu"), TuplesKt.to(42, "interact_acting")});
    }

    public static final void a(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$set");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.put(r101, r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        ALogger.e("InteractLogUtils", e);
    }
}
