package com.bytedance.android.livesdk.gift.framework.base.tracejsonhelper;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.h1;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import vz1.e;
import vz1.h;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/framework/base/tracejsonhelper/DialogIconModelSerializer;", "Lcom/google/gson/JsonSerializer;", "Lvz1/e;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DialogIconModelSerializer implements JsonSerializer<e> {
    public DialogIconModelSerializer() {
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(e r100, Type r101, JsonSerializationContext r102) {
        e r103 = r100;
        JsonObject r104 = new JsonObject();
        Object r105 = "";
        if (r103 == null) goto L7;
        h1 r106 = r103.f557650a;
        if (r106 == null) goto L7;
        Object r107 = Long.valueOf(r106.getId());
    L8:
        r104.addProperty(PbRequest.SwitchType.GIFT, String.valueOf(r107));
        if (r103 == null) goto L11;
        boolean r108 = r103.f557654e;
    L12:
        r104.addProperty("isProp", String.valueOf(r108));
        if (r103 == null) goto L18;
        h r109 = r103.f557656g;
        if (r109 == null) goto L18;
        r105 = r109;
    L18:
        r104.addProperty("propInfo", String.valueOf(r105));
        return r104;
    L11:
        r108 = false;
    L7:
        r107 = "";
        goto L8
    }
}
