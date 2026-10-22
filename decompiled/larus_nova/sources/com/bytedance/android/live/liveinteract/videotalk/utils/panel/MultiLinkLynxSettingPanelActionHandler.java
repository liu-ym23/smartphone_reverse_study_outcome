package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import android.app.Application;
import android.content.SharedPreferences;
import com.bytedance.android.live.browser.jsbridge.newmethods.v5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.SettingUtilExtensionKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiLinkLynxSettingPanelActionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f79826a = null;

    static {
        f79826a = LazyKt.lazy(MultiLinkLynxSettingPanelActionHandler$switchSceneFrequencyUtil$2.INSTANCE);
    }

    public static JsonObject a(JsonObject r100) {
        if (r100.has("local_data") == false) goto L17;
        JsonObject r101 = new JsonObject();     // Catch: Exception -> L10
        Application r102 = jc1.a.b();     // Catch: Exception -> L10
        ExecutorService r103 = v5.f63689a;     // Catch: Exception -> L10
        SharedPreferences r104 = r102.getSharedPreferences("js_kv_methods_20191113", 0);     // Catch: Exception -> L10
        Iterator<JsonElement> r105 = r100.get("local_data").getAsJsonArray().iterator();     // Catch: Exception -> L10
    L6:
        if (r105.hasNext() == false) goto L9;
        String r106 = r105.next().getAsString();     // Catch: Exception -> L10
        r101.addProperty(r106, r104.getString(r106, ""));     // Catch: Exception -> L10
        goto L6
    L9:
        return r101;
    L10:
        ALogger.w("LynxSettingPanelHandler", "handleLinkLynxPanelJsbGetAction call local_data not array");
        return null;
    L17:
        return null;
    }

    public static JsonObject b(JsonObject r100) {
        if (r100.has("setting_list") == false) goto L22;
        JsonObject r101 = new JsonObject();     // Catch: Exception -> L14
        JsonArray r102 = r100.get("setting_list").getAsJsonArray();     // Catch: Exception -> L14
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));     // Catch: Exception -> L14
        Iterator<JsonElement> r104 = r102.iterator();     // Catch: Exception -> L14
    L6:
        if (r104.hasNext() == false) goto L8;
        r103.add(r104.next().getAsString());     // Catch: Exception -> L14
        goto L6
    L8:
        Iterator<T> r105 = SettingUtilExtensionKt.getSettingsValue(r103).iterator();     // Catch: Exception -> L14
    L9:
        if (r105.hasNext() == false) goto L13;
        Pair r106 = (Pair) r105.next();     // Catch: Exception -> L14
        r101.add((String) r106.getFirst(), (JsonElement) r106.getSecond());     // Catch: Exception -> L14
        goto L9
    L13:
        return r101;
    L14:
        e = move-exception;
        ALogger.w("LynxSettingPanelHandler", "getSettingRecordFromLocal call fail " + e.getMessage());
        return null;
    L22:
        return null;
    }
}
