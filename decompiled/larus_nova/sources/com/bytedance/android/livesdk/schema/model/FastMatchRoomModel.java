package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/FastMatchRoomModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "roomId", "", "matchScene", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getMatchScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRoomId", "()Ljava/lang/String;", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FastMatchRoomModel extends BaseSchemaModel {

    @SerializedName("match_scene")
    private final Integer matchScene;

    @SerializedName("room_id")
    private final String roomId;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.FAST_MATCH_ROOM_SCHEMA_HOST;
    }

    public final Integer getMatchScene() {
        return this.matchScene;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public FastMatchRoomModel(String r100, Integer r101) {
        this.roomId = r100;
        this.matchScene = r101;
    }
}
