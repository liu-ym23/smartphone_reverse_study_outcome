package com.bytedance.android.live.liveinteract.api.utils;

import android.text.TextUtils;
import com.bytedance.android.livesdk.config.b50;
import com.bytedance.android.livesdk.config.ir0;
import com.bytedance.android.livesdk.f2;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class LiveSeiUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f71500a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f71501b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f71502c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FifoMap<Integer, JSONObject> f71503d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f71504e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f71505f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f71506g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final FIFOConcurrentMap<Integer, JSONObject> f71507h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final LiveSeiUtil f71508i = null;

    public LiveSeiUtil() {
    }

    static {
        f71508i = new LiveSeiUtil();
        f71500a = (List) b50.f119844a.getValue();
        f71501b = (List) ir0.f120475a.getValue();
        f71502c = LazyKt.lazy(LiveSeiUtil$seiOptimizeEnable$2.INSTANCE);
        f2 r100 = f2.f123400a;
        f71503d = new FifoMap(r100.getValue().intValue());
        f71504e = LazyKt.lazy(LiveSeiUtil$seiCacheOptimize$2.INSTANCE);
        Lazy r101 = LazyKt.lazy(LiveSeiUtil$seiRemoveOptimize$2.INSTANCE);
        f71505f = r101;
        f71506g = LazyKt.lazy(LiveSeiUtil$harmonySeiFixEnable$2.INSTANCE);
        f71507h = new FIFOConcurrentMap(r100.getValue().intValue(), ((Boolean) r101.getValue()).booleanValue());
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "seiString");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (e(r100) == false) goto L27;
        List<String> r101 = f71501b;
        if (r101 == null) goto L16;
        Iterator<T> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L16;
        String r103 = (String) r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L10;
        if (StringsKt.contains$default(r100, r103, false, 2, null) == false) goto L10;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L28;
        return true;
    L28:
        return false;
    L16:
        r104 = false;
        goto L17
    L27:
        return false;
    }

    public static JSONObject c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawJson");
        if (TextUtils.isEmpty(r100) == true) goto L5;
        if (((Boolean) f71502c.getValue()).booleanValue() == true) goto L9;
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L18
    L20:
        return r101;
    L9:
        if (((Boolean) f71504e.getValue()).booleanValue() == false) goto L13;
        r101 = f71507h.get(Integer.valueOf(r100.hashCode()));     // Catch: Exception -> L18
        if (r101 != null) goto L20;
        r101 = new JSONObject(r100);     // Catch: Exception -> L18
        goto L20
    L13:
        r101 = f71503d.get(Integer.valueOf(r100.hashCode()));     // Catch: Exception -> L18
        if (r101 != null) goto L20;
        r101 = new JSONObject(r100);     // Catch: Exception -> L18
    L23:
        return new JSONObject();
    L5:
        return new JSONObject();
    }

    public static boolean d(String r100) {
        if (((Boolean) f71506g.getValue()).booleanValue() == false) goto L10;
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

    public static boolean e(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((!StringsKt.isBlank(r100)) == false) goto L44;
        int r101 = r100.length() - 1;
        int r102 = 0;
        boolean r103 = false;
    L8:
        if (r102 > r101) goto L23;
        if (r103 == true) goto L11;
        int r104 = r102;
    L13:
        if (Intrinsics.compare(r100.charAt(r104), 32) > 0) goto L15;
        boolean r105 = true;
    L16:
        if (r103 == false) goto L17;
        if (r105 == false) goto L23;
        r101 = r101 - 1;
        goto L8
    L17:
        if (r105 == false) goto L18;
        r102 = r102 + 1;
        goto L8
    L18:
        r103 = true;
        goto L8
    L15:
        r105 = false;
        goto L16
    L11:
        r104 = r101;
    L23:
        String r106 = r100.subSequence(r102, r101 + 1).toString();
        if (StringsKt.startsWith$default(r106, "{", false, 2, null) == false) goto L29;
        if (StringsKt.endsWith$default(r106, com.alipay.sdk.m.u.i.f25855d, false, 2, null) == false) goto L29;
    L32:
        return true;
    L29:
        if (StringsKt.startsWith$default(r106, "[", false, 2, null) == true) goto L31;
        return false;
    L31:
        if (StringsKt.endsWith$default(r106, "]", false, 2, null) == true) goto L32;
        return false;
    L44:
        return false;
    }

    public static JSONObject g(String r100) {
        if (r100 == null) goto L7;
        f71508i.getClass();
        if (((Boolean) f71504e.getValue()).booleanValue() == false) goto L10;
        return f71507h.get(Integer.valueOf(r100.hashCode()));
    L10:
        return f71503d.get(Integer.valueOf(r100.hashCode()));
    L7:
        return null;
    }

    public static Pair a(String r100, JSONObject r101) {
        if (r100 == null) goto L28;
        if (StringsKt.contains$default(r100, "app_data", false, 2, null) != true) goto L28;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L22
        if (r101 != null) goto L10;
        f71508i.getClass();     // Catch: Throwable -> L22
        r101 = c(r100);     // Catch: Throwable -> L22
    L10:
        if (r101.has("info") == true) goto L12;
    L20:
        String r103 = r101.optString("app_data");     // Catch: Throwable -> L22
        String r104 = new Regex("\\\\").replace(r103, "");     // Catch: Throwable -> L22
        return TuplesKt.to(r104, new JSONObject(r104));
    L12:
        if (r101.has("source") == false) goto L20;
        if (TextUtils.equals(r101.optString("source"), "zego") == false) goto L20;
        Object r105 = r101.get("info");     // Catch: Throwable -> L22
        if (r105 == null) goto L19;
        r101 = (JSONObject) r105;     // Catch: Throwable -> L22
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        if (Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th))) == null) goto L28;
        return TuplesKt.to("", null);
    L28:
        return TuplesKt.to("", null);
    }

    public static boolean f(String r100, boolean r101) {
        if (r101 == false) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L27:
        return false;
    L8:
        if (StringsKt.contains$default(r100, "TTLiveSDK_Android", false, 2, null) == false) goto L10;
    L21:
        boolean r102 = true;
    L22:
        if (r102 == true) goto L25;
        r100 = null;
    L25:
        if (r100 == null) goto L27;
        return true;
    L10:
        if (StringsKt.contains$default(r100, "TTLiveSDK_IOS", false, 2, null) == true) goto L21;
        f71508i.getClass();
        if (d(r100) == true) goto L21;
        if (StringsKt.contains$default(r100, "TTLiveSDK_Windows", false, 2, null) == true) goto L21;
        if (StringsKt.contains$default(r100, "app_data", false, 2, null) == true) goto L21;
        if (StringsKt.contains$default(r100, "multi_view_data", false, 2, null) == true) goto L21;
        r102 = false;
        goto L22
    }
}
