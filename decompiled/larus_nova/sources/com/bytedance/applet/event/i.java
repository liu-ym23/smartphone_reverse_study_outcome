package com.bytedance.applet.event;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f191824a = null;

    static {
        f191824a = CollectionsKt.listOf(new String[]{"db_app_4PuJFXO", "db_app_4PM0PUQ"});
    }

    public static String a(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        String r103 = null;
        if (r102 != null) goto L5;
    L10:
        if (r103 != null) goto L13;
        return "";
    L13:
        return r103;
    L5:
        if (r102.isJsonPrimitive() == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        r103 = r102.getAsString();
        goto L10
    }
}
