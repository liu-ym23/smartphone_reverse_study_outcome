package com.bytedance.android.gamecp.common.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class c1 {
    public static final Uri a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        LinkedHashMap r101 = new LinkedHashMap();
        String r102 = UriProtector.getQueryParameter(r100, "enable_font_scale");
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.put("enable_font_scale", "1");
    L12:
        if ((!r101.isEmpty()) == false) goto L20;
        Uri.Builder r104 = r100.buildUpon();
        Iterator r105 = r101.entrySet().iterator();
    L15:
        if (r105.hasNext() == false) goto L18;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.appendQueryParameter((String) r106.getKey(), (String) r106.getValue());
        goto L15
    L18:
        return r104.build();
    L20:
        return r100;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public static final String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reportParams");
        if (wu.w0.f561408a.getValue().intValue() >= r100.length()) goto L30;
        yr.c.e("SchemaParamHelper", "reportParams length exceed limit");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L28
        JsonObject r102 = null;
        if (StringsKt.contains$default(r100, "potential_support_pkg", false, 2, null) == false) goto L26;
        JsonParser r103 = e0.f57217a;     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r100) == false) goto L31;
        JsonObject r104 = null;
    L11:
        JsonObject r105 = r104.getAsJsonObject("dygame_track_context");     // Catch: Throwable -> L28
        String r106 = r105.get("game_info").getAsString();     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r106) == false) goto L33;
    L15:
        Iterator<String> r107 = r102.keySet().iterator();     // Catch: Throwable -> L28
    L17:
        if (r107.hasNext() == false) goto L19;
        r102.getAsJsonObject(r107.next()).remove("potential_support_pkg");     // Catch: Throwable -> L28
        goto L17
    L19:
        r105.remove("game_info");     // Catch: Throwable -> L28
        r105.addProperty("game_info", r102.toString());     // Catch: Throwable -> L28
        r100 = r104.toString();     // Catch: Throwable -> L28
        goto L26
    L33:
        r102 = e0.f57217a.parse(r106).getAsJsonObject();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw new JsonParseException(th);     // Catch: Throwable -> L28
    L31:
        r104 = e0.f57217a.parse(r100).getAsJsonObject();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw new JsonParseException(th);     // Catch: Throwable -> L28
    L26:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L30:
        return r100;
    }

    public static final String b(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "newParams");
        Uri r102 = UriProtector.parse(r100);
        Uri.Builder r103 = r102.buildUpon();
        Uri.Builder r104 = r103.clearQuery();
        Iterator<String> r105 = UriProtector.getQueryParameterNames(r102).iterator();
    L4:
        if (r105.hasNext() == false) goto L11;
        String r106 = r105.next();
        if (r101.containsKey(r106) == true) goto L4;
        Iterator<String> r107 = UriProtector.getQueryParameters(r102, r106).iterator();
    L9:
        if (r107.hasNext() == false) goto L4;
        r104.appendQueryParameter(r106, r107.next());
        goto L9
    L11:
        Iterator<Map.Entry<String, String>> r108 = r101.entrySet().iterator();
    L13:
        if (r108.hasNext() == false) goto L16;
        Map.Entry<String, String> r109 = r108.next();
        r104.appendQueryParameter(r109.getKey(), r109.getValue());
        goto L13
    L16:
        return r103.toString();
    }

    public static final String c(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        String r102 = "";
        if (r100 != null) goto L5;
        return "";
    L5:
        Uri r103 = a(UriProtector.parse(r100));
        Uri.Builder r104 = f(r103, CollectionsKt.listOf(new String[]{"url", "fallback_url"})).buildUpon();
        String r105 = UriProtector.getQueryParameter(r103, "url");
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r104.appendQueryParameter("url", e(r105, r101));
        String r106 = UriProtector.getQueryParameter(r103, "fallback_url");
        if (TextUtils.isEmpty(r106) == true) goto L16;
        Uri r107 = UriProtector.parse(r106);
        Uri.Builder r108 = f(r107, CollectionsKt.listOf("url")).buildUpon();
        String r109 = UriProtector.getQueryParameter(r107, "url");
        if (r109 == null) goto L14;
        r102 = r109;
    L14:
        r108.appendQueryParameter("url", e(r102, r101));
        r104.appendQueryParameter("fallback_url", r108.toString());
    L16:
        return r104.toString();
    }

    public static final String e(String r100, Map<String, String> r101) {
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        Pair[] r103 = new Pair[3];
        Room r104 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        String r105 = null;
        if (r104 == null) goto L5;
        Long r106 = Long.valueOf(r104.getId());
    L6:
        r103[0] = TuplesKt.to("room_id", String.valueOf(r106));
        Room r107 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r107 == null) goto L9;
        r105 = r107.getOwnerUserId();
    L9:
        r103[1] = TuplesKt.to("anchor_id", String.valueOf(r105));
        r103[2] = TuplesKt.to("user_id", com.bytedance.android.gamecp.host_api.a.b().getUserService().user().getCurrentUserId().toString());
        Iterator r108 = MapsKt.mapOf(r103).entrySet().iterator();
    L11:
        if (r108.hasNext() == false) goto L13;
        Map.Entry r109 = (Map.Entry) r108.next();
        r102.appendQueryParameter((String) r109.getKey(), (String) r109.getValue());
        goto L11
    L13:
        Iterator<Map.Entry<String, String>> r110 = r101.entrySet().iterator();
    L15:
        if (r110.hasNext() == false) goto L18;
        Map.Entry<String, String> r111 = r110.next();
        r102.appendQueryParameter(r111.getKey(), r111.getValue());
        goto L15
    L18:
        return r102.toString();
    L5:
        r106 = null;
        goto L6
    }

    public static final Uri f(Uri r100, List<String> r101) {
        Set<String> r102 = UriProtector.getQueryParameterNames(r100);
        if (r102 != null) goto L5;
        return r100;
    L5:
        Uri.Builder r103 = r100.buildUpon().clearQuery();
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        Object r106 = r105.next();
        if ((!r101.contains((String) r106)) == false) goto L7;
        r104.add(r106);
        goto L7
    L11:
        Iterator r107 = r104.iterator();
    L13:
        if (r107.hasNext() == false) goto L16;
        String r108 = (String) r107.next();
        r103.appendQueryParameter(r108, UriProtector.getQueryParameter(r100, r108));
        goto L13
    L16:
        return r103.build();
    }
}
