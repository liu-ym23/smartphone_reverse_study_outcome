package com.bytedance.android.livesdk.gift.framework.base.tracejsonhelper;

import com.bytedance.android.livesdk.gift.model.h1;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/framework/base/tracejsonhelper/GiftSerializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/bytedance/android/livesdk/gift/model/h1;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftSerializer implements JsonSerializer<h1> {
    public GiftSerializer() {
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(h1 r100, Type r101, JsonSerializationContext r102) {
        h1 r103 = r100;
        JsonObject r104 = new JsonObject();
        if (r103 == null) goto L5;
        boolean r105 = r103.isDisplayedOnPanel();
    L6:
        r104.addProperty("is_displayed_on_panel", String.valueOf(r105));
        if (r103 == null) goto L9;
        long r106 = r103.getId();
    L10:
        r104.addProperty("id", String.valueOf(r106));
        return r104;
    L9:
        r106 = 0;
        goto L10
    L5:
        r105 = false;
        goto L6
    }
}
