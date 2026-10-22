package com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002\u001a(\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\b¨\u0006\u000b"}, d2 = {"getRawSettingValue", "Lcom/google/gson/JsonElement;", "key", "", "getSettingJsonElement", "settingObj", "", "getSettingsValue", "", "Lkotlin/Pair;", "keys", "infrastructure_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class SettingUtilExtensionKt {
    public static final JsonElement getRawSettingValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Gson r101 = GsonHelper.get();
        Object r102 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r100);
        if (r102 != null) goto L5;
        return null;
    L5:
        if ((r102 instanceof JSONObject) == false) goto L8;
        return GsonProtectorUtils.toJsonTree(r101, GsonProtectorUtils.fromJson(r101, r102.toString(), Object.class));
    L8:
        if ((r102 instanceof JSONArray) == false) goto L11;
        return GsonProtectorUtils.toJsonTree(r101, GsonProtectorUtils.fromJson(r101, r102.toString(), new AnonymousClass1().getType()));
    L11:
        if ((r102 instanceof Boolean) == false) goto L23;
        if (((Boolean) r102).booleanValue() == false) goto L22;
        return GsonProtectorUtils.toJsonTree(r101, 1);
    L22:
        return GsonProtectorUtils.toJsonTree(r101, 0);
    L23:
        return GsonProtectorUtils.toJsonTree(r101, r102);
    }

    private static final JsonElement getSettingJsonElement(Object r100) {
        Gson r101 = GsonHelper.get();
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100 instanceof JSONObject) == false) goto L8;
        return GsonProtectorUtils.toJsonTree(r101, GsonProtectorUtils.fromJson(r101, r100.toString(), Object.class));
    L8:
        if ((r100 instanceof JSONArray) == false) goto L11;
        return GsonProtectorUtils.toJsonTree(r101, GsonProtectorUtils.fromJson(r101, r100.toString(), new C102491().getType()));
    L11:
        if ((r100 instanceof Boolean) == false) goto L23;
        if (((Boolean) r100).booleanValue() == false) goto L22;
        return GsonProtectorUtils.toJsonTree(r101, 1);
    L22:
        return GsonProtectorUtils.toJsonTree(r101, 0);
    L23:
        return GsonProtectorUtils.toJsonTree(r101, r100);
    }

    public static final List<Pair<String, JsonElement>> getSettingsValue(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        String r104 = (String) r103.next();
        JsonElement r105 = getSettingJsonElement(SettingUtil.getRawValue("key_ttlive_sdk_setting", r104));
        if (r105 != null) goto L7;
        r102.add(r104);
        goto L4
    L7:
        r101.add(new Pair(r104, r105));
        goto L4
    L9:
        return r101;
    }
}
