package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/LinkMicDynamicEventSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "()V", "bizId", "", "getBizId", "()Ljava/lang/String;", "extra", "getExtra", "requestPage", "getRequestPage", "roomId", "getRoomId", "toUserId", "getToUserId", "type", "getType", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkMicDynamicEventSchemaModel extends BaseSchemaModel {

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    private final String bizId;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("request_page")
    private final String requestPage;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName(a.KEY_TO_USER_ID)
    private final String toUserId;

    @SerializedName("type")
    private final String type;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.LINKMIC_DYNAMIC_EVENT;
    }

    public LinkMicDynamicEventSchemaModel() {
    }

    public final String getBizId() {
        return this.bizId;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getRequestPage() {
        return this.requestPage;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getToUserId() {
        return this.toUserId;
    }

    public final String getType() {
        return this.type;
    }
}
