package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/OpenDanmuGameSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", ReportConstant.COMMON_ACTION_TYPE, "", "appId", "gameName", "source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionType", "()Ljava/lang/String;", "getAppId", "getGameName", "getSource", "getSchemaHost", "toString", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenDanmuGameSchemaModel extends BaseSchemaModel {

    @SerializedName("action_type")
    private final String actionType;

    @SerializedName("app_id")
    private final String appId;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    private final String gameName;

    @SerializedName("source")
    private final String source;

    public OpenDanmuGameSchemaModel() {
        this(null, null, null, null, 15, null);
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.OPEN_DANMU_GAME;
    }

    public String toString() {
        return "OpenDanmuGameSchemaModel(actionType=" + this.actionType + ", appId=" + this.appId + ", gameName=" + this.gameName + ", source=" + this.source + ')';
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getSource() {
        return this.source;
    }

    public OpenDanmuGameSchemaModel(String r100, String r101, String r102, String r103) {
        this.actionType = r100;
        this.appId = r101;
        this.gameName = r102;
        this.source = r103;
    }

    public /* synthetic */ OpenDanmuGameSchemaModel(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
