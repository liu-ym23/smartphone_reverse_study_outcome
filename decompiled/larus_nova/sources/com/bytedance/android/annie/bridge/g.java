package com.bytedance.android.annie.bridge;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f38457a = 0;

    static {
    }

    public static void a(JsonObject r100, JsonObject r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L27
        Unit r103 = null;
        if (r100 == null) goto L25;
        JsonPrimitive r104 = r100.getAsJsonPrimitive("jsb_invoke_back_mode");     // Catch: Throwable -> L27
        if (r104 == null) goto L25;
        if (r104.isNumber() == true) goto L10;
        r104 = null;
    L10:
        if (r104 == null) goto L25;
        Number r105 = r104.getAsNumber();     // Catch: Throwable -> L27
        if (r105 == null) goto L25;
        Integer r106 = Integer.valueOf(r105.intValue());     // Catch: Throwable -> L27
        if (r106 != null) goto L16;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == true) goto L22;
        r105 = null;
    L22:
        if (r105 == null) goto L25;
        if (r101 == null) goto L25;
        r101.addProperty("__jsb_invoke_back_mode", r105);     // Catch: Throwable -> L27
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L27
        goto L25
    L16:
        if (r106.intValue() <= 0) goto L18;
        r107 = true;
    L25:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void b(JSONObject r100, JSONObject r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        boolean r103 = false;
        if (r100 == null) goto L5;
        Integer r104 = Integer.valueOf(r100.optInt("jsb_invoke_back_mode", 0));     // Catch: Throwable -> L16
    L7:
        if (r104 != null) goto L9;
    L11:
        if (r103 == false) goto L14;
        if (r101 == null) goto L14;
        r101.putOpt("__jsb_invoke_back_mode", 1);     // Catch: Throwable -> L16
    L14:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
        return;
    L9:
        if (r104.intValue() <= 0) goto L11;
        r103 = true;
        goto L11
    L5:
        r104 = null;
    L16:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
