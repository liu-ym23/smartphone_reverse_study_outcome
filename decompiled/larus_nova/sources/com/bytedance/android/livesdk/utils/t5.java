package com.bytedance.android.livesdk.utils;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class t5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<Context, Long> f159172a = null;

    static {
        f159172a = new WeakHashMap();
    }

    public static HashMap a(DataCenter r100) {
        return (HashMap) r100.get("data_room_business_extra", null);
    L5:
        e = move-exception;
        ALogger.e("RoomParamsUtils", e);
        return null;
    }

    @JvmStatic
    public static final String b(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        HashMap r101 = a(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return (String) r101.get("live_activity");
    }

    public static Map c(JSONObject r100) {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, r100.get(r103).toString());
        goto L4
    L6:
        return r101;
    }

    @JvmStatic
    public static final void d(DataCenter r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L16;
        return;
    L16:
        r100.put("data_room_business_extra", c(new JSONObject(r101)));     // Catch: Exception -> L13
        ALogger.d("RoomParamsUtils", "businessExtra is" + r101);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        ALogger.e("RoomParamsUtils", e);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
