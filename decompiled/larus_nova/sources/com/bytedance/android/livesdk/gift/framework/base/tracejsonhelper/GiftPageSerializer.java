package com.bytedance.android.livesdk.gift.framework.base.tracejsonhelper;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/framework/base/tracejsonhelper/GiftPageSerializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/bytedance/android/livesdk/gift/model/w1;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftPageSerializer implements JsonSerializer<w1> {
    public GiftPageSerializer() {
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(w1 r100, Type r101, JsonSerializationContext r102) {
        w1 r103 = r100;
        JsonObject r104 = new JsonObject();
        boolean r105 = false;
        if (r103 == null) goto L5;
        int r106 = r103.getPageType();
    L6:
        r104.addProperty("page_type", String.valueOf(r106));
        Object r107 = "";
        if (r103 == null) goto L10;
        String r108 = r103.getPageName();
        if (r108 == null) goto L10;
    L11:
        r104.addProperty("page_name", r108);
        if (r103 == null) goto L14;
        r105 = r103.getDisplay();
    L14:
        r104.addProperty("display", String.valueOf(r105));
        if (r103 == null) goto L20;
        List<h1> r109 = r103.getGifts();
        if (r109 == null) goto L20;
        r107 = r109;
    L20:
        r104.addProperty("gifts", String.valueOf(r107));
        return r104;
    L10:
        r108 = "";
        goto L11
    L5:
        r106 = 0;
        goto L6
    }
}
