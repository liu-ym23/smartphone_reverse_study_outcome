package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l implements com.bytedance.android.annie.api.data.subscribe.g<JsonObject> {
    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final com.bytedance.android.annie.api.data.subscribe.g<JsonObject> c() {
        return this;
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ char d() {
        return '.';
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement f(String r100, JsonElement r101) {
        return com.bytedance.android.annie.api.data.subscribe.f.c(this, r100, r101);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* bridge */ /* synthetic */ JsonObject g() {
        return null;
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement h(List r100, JsonElement r101) {
        return com.bytedance.android.annie.api.data.subscribe.f.d(r100, r101);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.g.j r100 = com.bytedance.android.live.browser.jsbridge.i.g.j.f63220b;
        return "storage";
    }

    public l() {
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final JsonElement a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (TextUtils.isEmpty(r100) == true) goto L7;
        Intrinsics.checkNotNullParameter(r100, "key");
        SharedPreferences r101 = s1.getContext().getSharedPreferences("js_kv_methods_20191113", 0);
        JsonObject r102 = new JsonObject();
        r102.addProperty(r100, r101.getString(r100, ""));
        return r102;
    L7:
        return com.bytedance.android.annie.api.data.subscribe.f.a(this, r100);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final JsonElement e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "url");
        return a(r100);
    }
}
