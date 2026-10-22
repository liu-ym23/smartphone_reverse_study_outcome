package com.bytedance.android.livesdk.gift.framework.base.tracejsonhelper;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/framework/base/tracejsonhelper/UserSerializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserSerializer implements JsonSerializer<IBaseUser> {
    public UserSerializer() {
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(IBaseUser r100, Type r101, JsonSerializationContext r102) {
        IBaseUser r103 = r100;
        JsonObject r104 = new JsonObject();
        if (r103 == null) goto L6;
        String r105 = r103.getIdString();
        if (r105 == null) goto L6;
    L7:
        r104.addProperty("id", r105);
        String r106 = "";
        if (r103 == null) goto L11;
        String r107 = r103.getNickName();
        if (r107 == null) goto L11;
    L12:
        r104.addProperty(InstantPlayContext.NICKNAME, r107);
        if (r103 == null) goto L16;
        String r108 = r103.getIdString();
        if (r108 == null) goto L16;
    L17:
        r104.addProperty("id_str", r108);
        if (r103 == null) goto L23;
        String r109 = r103.getWebcastUid();
        if (r109 == null) goto L23;
        r106 = r109;
    L23:
        r104.addProperty("webcast_uid", r106);
        return r104;
    L16:
        r108 = "";
    L11:
        r107 = "";
    L6:
        r105 = "0";
        goto L7
    }
}
