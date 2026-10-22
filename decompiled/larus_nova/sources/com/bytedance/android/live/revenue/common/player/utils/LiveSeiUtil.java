package com.bytedance.android.live.revenue.common.player.utils;

import d51.c;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class LiveSeiUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f90915a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap<Integer, JSONObject> f90916b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f90917c = null;

    static {
        f90915a = LazyKt.lazy(LiveSeiUtil$seiOptimizeEnable$2.INSTANCE);
        c r100 = c.A0;
        r100.getClass();
        f90916b = new LinkedHashMap(((Number) c.f466932i0.getValue(r100, c.f466915a[59])).intValue());
        f90917c = LazyKt.lazy(LiveSeiUtil$harmonySeiFixEnable$2.INSTANCE);
    }

    public static JSONObject a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawJson");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        if (((Boolean) f90915a.getValue()).booleanValue() == false) goto L14;
        JSONObject r102 = f90916b.get(Integer.valueOf(r100.hashCode()));     // Catch: Exception -> L16
        if (r102 != null) goto L18;
        r102 = new JSONObject(r100);     // Catch: Exception -> L16
    L18:
        return r102;
    L14:
        r102 = new JSONObject(r100);     // Catch: Exception -> L16
    L21:
        return new JSONObject();
    L8:
        return new JSONObject();
    L5:
        r101 = false;
        goto L6
    }

    public static boolean b(String r100) {
        if (((Boolean) f90917c.getValue()).booleanValue() == false) goto L10;
        if (r100 == null) goto L6;
        boolean r101 = StringsKt.contains$default(r100, "TTLiveSDK_Harmony", false, 2, null);
    L7:
        if (r101 == false) goto L11;
        return true;
    L11:
        return false;
    L6:
        r101 = false;
        goto L7
    L10:
        return false;
    }
}
