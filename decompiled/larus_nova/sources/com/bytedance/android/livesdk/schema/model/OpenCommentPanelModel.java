package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/OpenCommentPanelModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "()V", "requestSource", "", "hint", "defaultContent", "roomId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDefaultContent", "()Ljava/lang/String;", "getHint", "getRequestSource", "getRoomId", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenCommentPanelModel extends BaseSchemaModel {

    @SerializedName("content")
    private final String defaultContent;

    @SerializedName(SelectInfo.PLACEHOLDER)
    private final String hint;

    @SerializedName("request_source")
    private final String requestSource;

    @SerializedName("room_id")
    private final String roomId;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.OPEN_COMMENT_PANEL;
    }

    public OpenCommentPanelModel() {
        this("", "", "", "");
    }

    public final String getDefaultContent() {
        return this.defaultContent;
    }

    public final String getHint() {
        return this.hint;
    }

    public final String getRequestSource() {
        return this.requestSource;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public OpenCommentPanelModel(String r100, String r101, String r102, String r103) {
        this.requestSource = r100;
        this.hint = r101;
        this.defaultContent = r102;
        this.roomId = r103;
    }
}
