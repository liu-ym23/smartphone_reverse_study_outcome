package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/AudienceGamePromoteRecommendSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "enterFrom", "", "reportParams", "(Ljava/lang/String;Ljava/lang/String;)V", "getEnterFrom", "()Ljava/lang/String;", "getReportParams", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceGamePromoteRecommendSchemaModel extends BaseSchemaModel {

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("report_params")
    private final String reportParams;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.AUDIENCE_GAME_PROMOTE_RECOMMEND_SCHEMA_HOST;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getReportParams() {
        return this.reportParams;
    }

    public AudienceGamePromoteRecommendSchemaModel(String r100, String r101) {
        this.enterFrom = r100;
        this.reportParams = r101;
    }
}
