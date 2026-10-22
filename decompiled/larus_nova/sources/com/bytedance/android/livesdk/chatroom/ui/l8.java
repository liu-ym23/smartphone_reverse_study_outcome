package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonSyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class l8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f113670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f113671b = null;

    static {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("1455_new_no_rebate_channel", "task_130004");
        r100.put("ad_reward_stream", "inspire_task");
        r100.put("ad_reward_link_single", "live_cell");
        r100.put("ad_reward_link_single", "video_head");
        r100.put("ad_reward_link_stream", "live_cell");
        r100.put("ad_reward_link_stream", "video_head");
        f113671b = r100;
    }

    @JvmStatic
    public static final s5 b() {
        Map<String, String> r100 = com.bytedance.android.livesdk.utils.s0.f159156a;
        String r101 = "ecom_retain_data";
        Intrinsics.checkNotNullParameter("ecom_retain_data", "key");
        Map<String, String> r102 = com.bytedance.android.livesdk.utils.s0.f159156a;
        if (((HashMap) r102).containsKey("ecom_retain_data") == false) goto L5;
        String r103 = com.bytedance.android.livesdk.utils.s0.a("ecom_retain_data");
    L9:
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L22;
        return null;
    L22:
        s5 r105 = (s5) GsonProtectorUtils.fromJson(GsonHelper.get(), r103, s5.class);     // Catch: JsonSyntaxException -> L19
        r105.f114057a = r101;     // Catch: JsonSyntaxException -> L19
        return r105;
    L19:
        e = move-exception;
        ALogger.e("QuitRoomUtil", e);
        throw e;
    L11:
        if (StringsKt.isBlank(r103) == true) goto L14;
        r104 = false;
        goto L15
    L5:
        r101 = "ad_reward_retain_data";
        Intrinsics.checkNotNullParameter("ad_reward_retain_data", "key");
        if (((HashMap) r102).containsKey("ad_reward_retain_data") == false) goto L8;
        r103 = com.bytedance.android.livesdk.utils.s0.a("ad_reward_retain_data");
        goto L9
    L8:
        r101 = null;
        r103 = null;
        goto L9
    }

    @JvmStatic
    public static final boolean a() {
        com.bytedance.android.livesdk.log.filter.o r100 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r101 = "";
        if (r100.getMap().containsKey("enter_from_merge") == false) goto L5;
        String r102 = r100.getMap().get("enter_from_merge");
    L7:
        if (r100.getMap().containsKey("enter_method") == false) goto L9;
        r101 = r100.getMap().get("enter_method");
    L9:
        Map<String, String> r103 = f113671b;
        if (r103 == null) goto L19;
        if (r103.containsKey(r102) == true) goto L14;
    L17:
        return false;
    L14:
        if (StringsKt.equals$default((String) ((LinkedHashMap) r103).get(r102), r101, false, 2, null) == false) goto L17;
        return true;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L5:
        r102 = "";
        goto L7
    }

    @JvmStatic
    public static final boolean c() {
        s5 r100 = b();
        if (r100 == null) goto L12;
        f113670a = true;
        i6 r101 = r100.b();
        if (r101 == null) goto L13;
        Long r102 = r101.a();
        if (r102 != null) goto L9;
        return false;
    L9:
        if (((int) (r102.longValue() - new Date().getTime())) < 1000) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L12:
        return false;
    }
}
