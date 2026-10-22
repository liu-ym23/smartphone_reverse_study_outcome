package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J·\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020\u0005HÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0016\u0010\u0013\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019¨\u0006C"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECPromotionLotteryInfo;", "Ljava/io/Serializable;", "activityId", "", "lotteryType", "", "taskType", "openTime", "", "serverTime", "userActivityStatus", "winRecordId", "resultLabel", "buttonLabel", "text", "", "jumpUrl", "shortPic", "Lcom/bytedance/android/ec/model/ECUrlModel;", "buyTime", "elasticTitle", "benefitLabel", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "(Ljava/lang/String;IIJJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;JLjava/lang/String;Lcom/bytedance/android/ec/model/PromotionBenefitLabel;)V", "getActivityId", "()Ljava/lang/String;", "getBenefitLabel", "()Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "getButtonLabel", "getBuyTime", "()J", "getElasticTitle", "getJumpUrl", "getLotteryType", "()I", "getOpenTime", "getResultLabel", "getServerTime", "getShortPic", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getTaskType", "getText", "()Ljava/util/List;", "getUserActivityStatus", "getWinRecordId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionLotteryInfo implements Serializable {

    @SerializedName("activity_id")
    private final String activityId;

    @SerializedName("benefit_label")
    private final PromotionBenefitLabel benefitLabel;

    @SerializedName("button_label")
    private final String buttonLabel;

    @SerializedName("buy_time")
    private final long buyTime;

    @SerializedName("elastic_title")
    private final String elasticTitle;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("lottery_type")
    private final int lotteryType;

    @SerializedName("open_time")
    private final long openTime;

    @SerializedName("result_label")
    private final String resultLabel;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName("short_pic")
    private final ECUrlModel shortPic;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    private final int taskType;

    @SerializedName("text")
    private final List<String> text;

    @SerializedName("user_activity_status")
    private final int userActivityStatus;

    @SerializedName("win_record_id")
    private final String winRecordId;

    public ECPromotionLotteryInfo() {
        this(null, 0, 0, 0, 0, 0, null, null, null, null, null, null, 0, null, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECPromotionLotteryInfo copy$default(ECPromotionLotteryInfo r110, String r111, int r112, int r113, long r210, long r211, int r212, String r213, String r214, String r215, List r216, String r217, ECUrlModel r310, long r311, String r312, PromotionBenefitLabel r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = r110.activityId;
    L7:
        if ((r314 & 2) == 0) goto L9;
        int r101 = r110.lotteryType;
    L11:
        if ((r314 & 4) == 0) goto L13;
        int r102 = r110.taskType;
    L15:
        if ((r314 & 8) == 0) goto L17;
        long r103 = r110.openTime;
    L19:
        if ((r314 & 16) == 0) goto L21;
        long r104 = r110.serverTime;
    L23:
        if ((r314 & 32) == 0) goto L25;
        int r105 = r110.userActivityStatus;
    L27:
        if ((r314 & 64) == 0) goto L29;
        String r114 = r110.winRecordId;
    L31:
        if ((r314 & 128) == 0) goto L33;
        String r115 = r110.resultLabel;
    L35:
        if ((r314 & 256) == 0) goto L37;
        String r116 = r110.buttonLabel;
    L39:
        if ((r314 & 512) == 0) goto L41;
        List r117 = r110.text;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r118 = r110.jumpUrl;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        ECUrlModel r119 = r110.shortPic;
    L50:
        ECUrlModel r316 = r119;
        String r218 = r118;
        if ((r314 & 4096) == 0) goto L53;
        long r120 = r110.buyTime;
    L54:
        long r317 = r120;
        if ((r314 & 8192) == 0) goto L57;
        String r121 = r110.elasticTitle;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        PromotionBenefitLabel r106 = r110.benefitLabel;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r114, r115, r116, r117, r218, r316, r317, r121, r106);
    L61:
        r106 = r313;
        goto L63
    L57:
        r121 = r312;
        goto L59
    L53:
        r120 = r311;
        goto L54
    L49:
        r119 = r310;
        goto L50
    L45:
        r118 = r217;
        goto L47
    L41:
        r117 = r216;
        goto L43
    L37:
        r116 = r215;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.activityId;
    }

    public final List<String> component10() {
        return this.text;
    }

    public final String component11() {
        return this.jumpUrl;
    }

    public final ECUrlModel component12() {
        return this.shortPic;
    }

    public final long component13() {
        return this.buyTime;
    }

    public final String component14() {
        return this.elasticTitle;
    }

    public final PromotionBenefitLabel component15() {
        return this.benefitLabel;
    }

    public final int component2() {
        return this.lotteryType;
    }

    public final int component3() {
        return this.taskType;
    }

    public final long component4() {
        return this.openTime;
    }

    public final long component5() {
        return this.serverTime;
    }

    public final int component6() {
        return this.userActivityStatus;
    }

    public final String component7() {
        return this.winRecordId;
    }

    public final String component8() {
        return this.resultLabel;
    }

    public final String component9() {
        return this.buttonLabel;
    }

    public final ECPromotionLotteryInfo copy(String r210, int r211, int r212, long r213, long r214, int r215, String r216, String r310, String r311, List<String> r312, String r313, ECUrlModel r314, long r315, String r316, PromotionBenefitLabel r317) {
        return new ECPromotionLotteryInfo(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECPromotionLotteryInfo) == false) goto L36;
        ECPromotionLotteryInfo r101 = (ECPromotionLotteryInfo) r100;
        if (Intrinsics.areEqual(this.activityId, r101.activityId) == true) goto L8;
        return false;
    L8:
        if (this.lotteryType == r101.lotteryType) goto L10;
        return false;
    L10:
        if (this.taskType == r101.taskType) goto L12;
        return false;
    L12:
        if (this.openTime == r101.openTime) goto L14;
        return false;
    L14:
        if (this.serverTime == r101.serverTime) goto L16;
        return false;
    L16:
        if (this.userActivityStatus == r101.userActivityStatus) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.winRecordId, r101.winRecordId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.resultLabel, r101.resultLabel) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.buttonLabel, r101.buttonLabel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.shortPic, r101.shortPic) == true) goto L30;
        return false;
    L30:
        if (this.buyTime == r101.buyTime) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.elasticTitle, r101.elasticTitle) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.benefitLabel, r101.benefitLabel) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public int hashCode() {
        String r100 = this.activityId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.lotteryType) * 31) + this.taskType) * 31;
        long r104 = this.openTime;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.serverTime;
        int r107 = (((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.userActivityStatus) * 31;
        String r108 = this.winRecordId;
        if (r108 == null) goto L9;
        int r109 = r108.hashCode();
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = this.resultLabel;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (r110 + r112) * 31;
        String r114 = this.buttonLabel;
        if (r114 == null) goto L17;
        int r115 = r114.hashCode();
    L18:
        int r116 = (r113 + r115) * 31;
        List<String> r117 = this.text;
        if (r117 == null) goto L21;
        int r118 = r117.hashCode();
    L22:
        int r119 = (r116 + r118) * 31;
        String r120 = this.jumpUrl;
        if (r120 == null) goto L25;
        int r121 = r120.hashCode();
    L26:
        int r122 = (r119 + r121) * 31;
        ECUrlModel r123 = this.shortPic;
        if (r123 == null) goto L29;
        int r124 = r123.hashCode();
    L30:
        int r125 = (r122 + r124) * 31;
        long r126 = this.buyTime;
        int r127 = (r125 + ((int) (r126 ^ (r126 >>> 32)))) * 31;
        String r128 = this.elasticTitle;
        if (r128 == null) goto L33;
        int r129 = r128.hashCode();
    L34:
        int r130 = (r127 + r129) * 31;
        PromotionBenefitLabel r131 = this.benefitLabel;
        if (r131 == null) goto L38;
        r101 = r131.hashCode();
    L38:
        return r130 + r101;
    L33:
        r129 = 0;
        goto L34
    L29:
        r124 = 0;
        goto L30
    L25:
        r121 = 0;
        goto L26
    L21:
        r118 = 0;
        goto L22
    L17:
        r115 = 0;
        goto L18
    L13:
        r112 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECPromotionLotteryInfo(activityId=" + this.activityId + ", lotteryType=" + this.lotteryType + ", taskType=" + this.taskType + ", openTime=" + this.openTime + ", serverTime=" + this.serverTime + ", userActivityStatus=" + this.userActivityStatus + ", winRecordId=" + this.winRecordId + ", resultLabel=" + this.resultLabel + ", buttonLabel=" + this.buttonLabel + ", text=" + this.text + ", jumpUrl=" + this.jumpUrl + ", shortPic=" + this.shortPic + ", buyTime=" + this.buyTime + ", elasticTitle=" + this.elasticTitle + ", benefitLabel=" + this.benefitLabel + ")";
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final PromotionBenefitLabel getBenefitLabel() {
        return this.benefitLabel;
    }

    public final String getButtonLabel() {
        return this.buttonLabel;
    }

    public final long getBuyTime() {
        return this.buyTime;
    }

    public final String getElasticTitle() {
        return this.elasticTitle;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final int getLotteryType() {
        return this.lotteryType;
    }

    public final long getOpenTime() {
        return this.openTime;
    }

    public final String getResultLabel() {
        return this.resultLabel;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final ECUrlModel getShortPic() {
        return this.shortPic;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final List<String> getText() {
        return this.text;
    }

    public final int getUserActivityStatus() {
        return this.userActivityStatus;
    }

    public final String getWinRecordId() {
        return this.winRecordId;
    }

    public ECPromotionLotteryInfo(String r100, int r101, int r102, long r103, long r104, int r110, String r111, String r112, String r113, List<String> r114, String r115, ECUrlModel r116, long r117, String r210, PromotionBenefitLabel r211) {
        this.activityId = r100;
        this.lotteryType = r101;
        this.taskType = r102;
        this.openTime = r103;
        this.serverTime = r104;
        this.userActivityStatus = r110;
        this.winRecordId = r111;
        this.resultLabel = r112;
        this.buttonLabel = r113;
        this.text = r114;
        this.jumpUrl = r115;
        this.shortPic = r116;
        this.buyTime = r117;
        this.elasticTitle = r210;
        this.benefitLabel = r211;
    }

    public /* synthetic */ ECPromotionLotteryInfo(String r110, int r210, int r211, long r212, long r213, int r214, String r215, String r216, String r217, List r310, String r311, ECUrlModel r312, long r313, String r314, PromotionBenefitLabel r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = null;
    L6:
        int r101 = 0;
        if ((r316 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r316 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r316 & 8) == 0) goto L17;
        long r104 = 0;
    L19:
        if ((r316 & 16) == 0) goto L21;
        long r111 = 0;
    L23:
        if ((r316 & 32) != 0) goto L27;
        r101 = r214;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r105 = null;
    L31:
        if ((r316 & 128) == 0) goto L33;
        String r112 = null;
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        List r114 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r106 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        ECUrlModel r107 = null;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        long r115 = 0;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        String r108 = null;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        PromotionBenefitLabel r109 = null;
    L62:
        this(r100, r102, r103, r104, r111, r101, r105, r112, r113, r114, r106, r107, r115, r108, r109);
        return;
    L61:
        r109 = r315;
        goto L62
    L57:
        r108 = r314;
        goto L59
    L53:
        r115 = r313;
        goto L55
    L49:
        r107 = r312;
        goto L51
    L45:
        r106 = r311;
        goto L47
    L41:
        r114 = r310;
        goto L43
    L37:
        r113 = r217;
        goto L39
    L33:
        r112 = r216;
        goto L35
    L29:
        r105 = r215;
        goto L31
    L21:
        r111 = r213;
        goto L23
    L17:
        r104 = r212;
        goto L19
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
