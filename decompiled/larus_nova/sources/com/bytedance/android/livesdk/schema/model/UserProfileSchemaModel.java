package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b#\b\u0007\u0018\u00002\u00020\u0001BÃ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0017J\b\u0010,\u001a\u00020\u0003H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\t\u0010\u001dR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b#\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/UserProfileSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "userId", "", "id", "type", "secUserId", "secUid", "clickUserPosition", "isFromRecommendDialog", "", "interactLogLabel", "eventModule", "source", "reportSource", "reportTypeForLog", "commontReportModel", "fromFallback", "vsFollowPosition", "mysteryMan", "ktvChallengePlayerType", "isAnonymous", "order", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getClickUserPosition", "()Ljava/lang/String;", "getCommontReportModel", "getEventModule", "getFromFallback", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getInteractLogLabel", "getKtvChallengePlayerType", "getMysteryMan", "getOrder", "getReportSource", "getReportTypeForLog", "getSecUid", "getSecUserId", "getSource", "getType", "getUserId", "getVsFollowPosition", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserProfileSchemaModel extends BaseSchemaModel {

    @SerializedName("click_user_position")
    private final String clickUserPosition;

    @SerializedName("commont_report_model")
    private final String commontReportModel;

    @SerializedName("event_module")
    private final String eventModule;

    @SerializedName("from_fallback")
    private final Integer fromFallback;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f157919id;

    @SerializedName("interact_log_label")
    private final String interactLogLabel;

    @SerializedName(a.KEY_IS_ANONYMOUS)
    private final String isAnonymous;

    @SerializedName("is_from_recommend_dialog")
    private final Integer isFromRecommendDialog;

    @SerializedName("ktv_challenge_player_type")
    private final String ktvChallengePlayerType;

    @SerializedName("mystery_man")
    private final String mysteryMan;

    @SerializedName("order")
    private final Integer order;

    @SerializedName("report_source")
    private final String reportSource;

    @SerializedName("report_type_for_log")
    private final String reportTypeForLog;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("sec_user_id")
    private final String secUserId;

    @SerializedName("source")
    private final String source;

    @SerializedName("type")
    private final String type;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName("vs_follow_position")
    private final String vsFollowPosition;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.USER_PROFILE_SCHEMA_HOST;
    }

    public final String getClickUserPosition() {
        return this.clickUserPosition;
    }

    public final String getCommontReportModel() {
        return this.commontReportModel;
    }

    public final String getEventModule() {
        return this.eventModule;
    }

    public final Integer getFromFallback() {
        return this.fromFallback;
    }

    public final String getId() {
        return this.f157919id;
    }

    public final String getInteractLogLabel() {
        return this.interactLogLabel;
    }

    public final String getKtvChallengePlayerType() {
        return this.ktvChallengePlayerType;
    }

    public final String getMysteryMan() {
        return this.mysteryMan;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final String getReportSource() {
        return this.reportSource;
    }

    public final String getReportTypeForLog() {
        return this.reportTypeForLog;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final String getSecUserId() {
        return this.secUserId;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getVsFollowPosition() {
        return this.vsFollowPosition;
    }

    public final String isAnonymous() {
        return this.isAnonymous;
    }

    public final Integer isFromRecommendDialog() {
        return this.isFromRecommendDialog;
    }

    public UserProfileSchemaModel(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, String r110, String r111, String r112, String r113, String r114, String r115, Integer r116, String r117, String r118, String r119, String r210, Integer r211) {
        this.userId = r100;
        this.f157919id = r101;
        this.type = r102;
        this.secUserId = r103;
        this.secUid = r104;
        this.clickUserPosition = r105;
        this.isFromRecommendDialog = r106;
        this.interactLogLabel = r110;
        this.eventModule = r111;
        this.source = r112;
        this.reportSource = r113;
        this.reportTypeForLog = r114;
        this.commontReportModel = r115;
        this.fromFallback = r116;
        this.vsFollowPosition = r117;
        this.mysteryMan = r118;
        this.ktvChallengePlayerType = r119;
        this.isAnonymous = r210;
        this.order = r211;
    }
}
