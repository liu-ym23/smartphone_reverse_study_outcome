package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import com.bytedance.android.live.core.log.ALogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements com.bytedance.android.annie.api.data.subscribe.g<JsonObject> {
    public f() {
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement a(String r100) {
        return com.bytedance.android.annie.api.data.subscribe.f.a(this, r100);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ com.bytedance.android.annie.api.data.subscribe.g<JsonObject> c() {
        return com.bytedance.android.annie.api.data.subscribe.f.e(this);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ char d() {
        return '.';
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement e(String r100, String r101) {
        return com.bytedance.android.annie.api.data.subscribe.f.b(this, r100, r101);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement f(String r100, JsonElement r101) {
        return com.bytedance.android.annie.api.data.subscribe.f.c(this, r100, r101);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement h(List r100, JsonElement r101) {
        return com.bytedance.android.annie.api.data.subscribe.f.d(r100, r101);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final JsonObject g() {
        boolean r100 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ca0.l r101 = ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).getGiftWallPreRequestManager();
        JsonElement r102 = null;
        if (r101 == null) goto L5;
        JsonObject r103 = r101.h();
    L6:
        StringBuilder r104 = new StringBuilder("currentState uid=");
        if (r103 == null) goto L9;
        r102 = r103.get("user_id");
    L9:
        r104.append(r102);
        ALogger.w("ttlive_gift_exhibition", r104.toString());
        return r103;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final String key() {
        int r100 = com.bytedance.android.live.browser.jsbridge.i.g.e.f63215b;
        return "gift_exhibition_data";
    }
}
