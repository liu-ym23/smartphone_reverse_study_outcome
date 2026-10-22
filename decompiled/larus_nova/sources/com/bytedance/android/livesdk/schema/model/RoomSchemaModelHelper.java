package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/RoomSchemaModelHelper;", "", "()V", "getNewSchemaModel", "Lcom/bytedance/android/livesdk/schema/model/RoomSchemaMode;", "args", "Lorg/json/JSONObject;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomSchemaModelHelper {
    public static final RoomSchemaModelHelper INSTANCE = null;

    private RoomSchemaModelHelper() {
    }

    static {
        INSTANCE = new RoomSchemaModelHelper();
    }

    public final RoomSchemaMode getNewSchemaModel(JSONObject r100) {
        return (RoomSchemaMode) GsonHelper.getDefault().fromJson(String.valueOf(r100), RoomSchemaMode.class);
    L4:
        e = move-exception;
        ALogger.e("RoomSchemaModelHelper", e);
        return null;
    }
}
