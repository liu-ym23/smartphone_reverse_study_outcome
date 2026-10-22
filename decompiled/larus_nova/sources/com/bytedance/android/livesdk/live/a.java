package com.bytedance.android.livesdk.live;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.m0;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f147266a = 0;

    static {
    }

    @JvmStatic
    public static final String a(String r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        if (r100 == null) goto L6;
        JSONObject r103 = new JSONObject(r100);     // Catch: Throwable -> L12
    L7:
        if (r103 == null) goto L9;
        String r104 = r103.toString();     // Catch: Throwable -> L12
    L10:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r105) == true) goto L19;
        r101 = r105;
    L19:
        return (String) r101;
    L9:
        r104 = null;
        goto L10
    L6:
        r103 = null;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static boolean c(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static String b(Long r100, List r110, int r111, Bundle r112, Integer r113, Long r114, int r115) {
        Object r101 = null;
        if ((r115 & 2) == 0) goto L6;
        r110 = null;
    L6:
        if ((r115 & 4) == 0) goto L9;
        r111 = -1;
    L9:
        if ((r115 & 8) == 0) goto L12;
        r112 = null;
    L12:
        if ((r115 & 16) == 0) goto L15;
        r113 = null;
    L15:
        if ((r115 & 32) == 0) goto L65;
        r114 = null;
    L65:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L57
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L57
        boolean r104 = true;
        if (r100 != null) goto L21;
    L29:
        if (r110 != null) goto L31;
    L39:
        if (r111 <= 0) goto L41;
        r103.put("hide_bucket_count", r111);     // Catch: Throwable -> L57
    L41:
        if (r112 == null) goto L51;
        Bundle r105 = m0.a(r112);     // Catch: Throwable -> L57
        if (r105 == null) goto L51;
        String r106 = r105.getString("filter_info");     // Catch: Throwable -> L57
        if (r106 == null) goto L51;
        if (TextUtils.isEmpty(r106) == true) goto L51;
        r103.put("filter_info", new JSONObject(r106));     // Catch: Exception -> L50 Throwable -> L57
    L51:
        if (r113 == null) goto L53;
        r103.put("hot_update_type", r113.intValue());     // Catch: Throwable -> L57
    L53:
        if (r114 == null) goto L55;
        r103.put("gid", r114.longValue());     // Catch: Throwable -> L57
    L55:
        Object r107 = Result.m9449constructorimpl(r103.toString());     // Catch: Throwable -> L57
    L60:
        if (Result.m9455isFailureimpl(r107) == true) goto L64;
        r101 = r107;
    L64:
        return (String) r101;
    L31:
        if (r110.size() > 0) goto L34;
        r104 = false;
    L34:
        if (r104 == true) goto L37;
        r110 = null;
    L37:
        if (r110 == null) goto L39;
        r103.put("hide_bucket_gids", new JSONArray(r110));     // Catch: Throwable -> L57
        goto L39
    L21:
        if (r100.longValue() <= 0) goto L23;
        boolean r108 = true;
    L24:
        if (r108 == true) goto L27;
        r100 = null;
    L27:
        if (r100 == null) goto L29;
        r103.put("livehead_video_gid", r100.longValue());     // Catch: Throwable -> L57
        goto L29
    L23:
        r108 = false;
    L57:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L60
    }
}
