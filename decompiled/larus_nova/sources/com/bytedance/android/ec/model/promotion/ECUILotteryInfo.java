package com.bytedance.android.ec.model.promotion;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\u0012\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010.\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010=\u001a\u00020\u0007\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\f\u0012\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bH\u0010IJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\fR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u001aR$\u0010$\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000f\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010'R$\u0010+\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000f\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010'R*\u0010/\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000f\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010'R\u0019\u00109\u001a\u0004\u0018\u0001088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010\u001c\u001a\u0004\b>\u0010\u001e\"\u0004\b?\u0010 R$\u0010@\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010\u000f\u001a\u0004\bA\u0010\u0011\"\u0004\bB\u0010'R\u0019\u0010D\u001a\u0004\u0018\u00010C8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G¨\u0006J"}, d2 = {"Lcom/bytedance/android/ec/model/promotion/ECUILotteryInfo;", "Ljava/io/Serializable;", "", "isNotIn", "isButtonGray", "isLotteryFinish", "needCountDown", "", "getCountDownTime", "isScarceLotteryFinish", "isScarceLotteryWinNotBuy", "isScarceLottery", "", "getScarceLotteryElasticTitle", "activityId", "Ljava/lang/String;", "getActivityId", "()Ljava/lang/String;", "", "lotteryType", "I", "getLotteryType", "()I", "taskType", "getTaskType", "setTaskType", "(I)V", "openTime", "J", "getOpenTime", "()J", "setOpenTime", "(J)V", "userActivityStatus", "getUserActivityStatus", "setUserActivityStatus", "winRecordId", "getWinRecordId", "setWinRecordId", "(Ljava/lang/String;)V", "resultLabel", "getResultLabel", "setResultLabel", "buttonLabel", "getButtonLabel", "setButtonLabel", "", "text", "Ljava/util/List;", "getText", "()Ljava/util/List;", "setText", "(Ljava/util/List;)V", "jumpUrl", "getJumpUrl", "setJumpUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "shortPic", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getShortPic", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "buyTime", "getBuyTime", "setBuyTime", "elasticTitle", "getElasticTitle", "setElasticTitle", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "benefitLabel", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "getBenefitLabel", "()Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "<init>", "(Ljava/lang/String;IIJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;JLjava/lang/String;Lcom/bytedance/android/ec/model/PromotionBenefitLabel;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECUILotteryInfo implements Serializable {
    private final String activityId;
    private final PromotionBenefitLabel benefitLabel;
    private String buttonLabel;
    private long buyTime;
    private String elasticTitle;
    private String jumpUrl;
    private final int lotteryType;
    private long openTime;
    private String resultLabel;
    private final ECUrlModel shortPic;
    private int taskType;
    private List<String> text;
    private int userActivityStatus;
    private String winRecordId;

    public final long getCountDownTime() {
        if (this.userActivityStatus >= 4) goto L8;
        long r100 = this.openTime;
        long r101 = SystemClock.elapsedRealtime();
    L6:
        return r100 - r101;
    L8:
        if (isScarceLottery() == true) goto L10;
        return 0;
    L10:
        if (this.userActivityStatus != 5) goto L14;
        r100 = this.buyTime;
        r101 = SystemClock.elapsedRealtime();
        goto L6
    L14:
        return 0;
    }

    public final String getScarceLotteryElasticTitle() {
        String r100 = this.elasticTitle;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (StringsKt.contains$default(r100, "activity_timer_placeholder", false, 2, null) == false) goto L12;
        String r101 = a(getCountDownTime(), true);
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r101 = "00:00";
    L10:
        return StringsKt.replace$default(r100, "activity_timer_placeholder", r101, false, 4, null);
    L12:
        return r100;
    }

    public final boolean isButtonGray() {
        if (this.userActivityStatus != 7) goto L5;
    L10:
        return true;
    L5:
        if (isScarceLottery() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.userActivityStatus != 8) goto L9;
        goto L9
    }

    public final boolean isLotteryFinish() {
        if (this.userActivityStatus < 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotIn() {
        if (this.userActivityStatus == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isScarceLottery() {
        if (this.lotteryType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isScarceLotteryFinish() {
        int r100 = this.userActivityStatus;
        if (r100 != 4) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 7) goto L8;
        return false;
    }

    public final boolean needCountDown() {
        if (this.userActivityStatus < 4) goto L9;
        if (isScarceLottery() == true) goto L7;
    L11:
        return false;
    L7:
        if (this.userActivityStatus != 5) goto L11;
    L9:
        if (getCountDownTime() <= 0) goto L11;
        return true;
    }

    public final boolean isScarceLotteryWinNotBuy() {
        if (isScarceLottery() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.userActivityStatus != 5) goto L7;
        return true;
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

    public final void setButtonLabel(String r100) {
        this.buttonLabel = r100;
    }

    public final void setBuyTime(long r100) {
        this.buyTime = r100;
    }

    public final void setElasticTitle(String r100) {
        this.elasticTitle = r100;
    }

    public final void setJumpUrl(String r100) {
        this.jumpUrl = r100;
    }

    public final void setOpenTime(long r100) {
        this.openTime = r100;
    }

    public final void setResultLabel(String r100) {
        this.resultLabel = r100;
    }

    public final void setTaskType(int r100) {
        this.taskType = r100;
    }

    public final void setText(List<String> r100) {
        this.text = r100;
    }

    public final void setUserActivityStatus(int r100) {
        this.userActivityStatus = r100;
    }

    public final void setWinRecordId(String r100) {
        this.winRecordId = r100;
    }

    public static String a(long r100, boolean r110) {
        if (r100 <= 0) goto L20;
        StringBuilder r101 = new StringBuilder();
        if (r110 == true) goto L7;
    L12:
        long r102 = r100 / 60000;
        long r103 = r100 - (60000 * r102);
        long r104 = 9;
        if (r102 > r104) goto L15;
        r101.append(0);
    L15:
        r101.append(r102);
        r101.append(":");
        long r105 = r103 / 1000;
        if (r105 > r104) goto L18;
        r101.append(0);
    L18:
        r101.append(r105);
        return r101.toString();
    L7:
        if (r100 <= 3600000) goto L12;
        long r106 = r100 / 3600000;
        r100 = r100 - (3600000 * r106);
        if (r106 > 9) goto L11;
        r101.append(0);
    L11:
        r101.append(r106);
        r101.append(":");
        goto L12
    L20:
        return "";
    }

    public static /* synthetic */ String getCountdownText$default(ECUILotteryInfo r100, long r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.getClass();
        return a(r101, r102);
    }

    public ECUILotteryInfo(String r100, int r101, int r102, long r103, int r104, String r110, String r111, String r112, List<String> r113, String r114, ECUrlModel r115, long r116, String r117, PromotionBenefitLabel r118) {
        this.activityId = r100;
        this.lotteryType = r101;
        this.taskType = r102;
        this.openTime = r103;
        this.userActivityStatus = r104;
        this.winRecordId = r110;
        this.resultLabel = r111;
        this.buttonLabel = r112;
        this.text = r113;
        this.jumpUrl = r114;
        this.shortPic = r115;
        this.buyTime = r116;
        this.elasticTitle = r117;
        this.benefitLabel = r118;
    }

    public /* synthetic */ ECUILotteryInfo(String r210, int r211, int r212, long r213, int r214, String r215, String r216, String r217, List r310, String r311, ECUrlModel r312, long r313, String r314, PromotionBenefitLabel r315, int r316, DefaultConstructorMarker r317) {
        String r100 = null;
        if ((r316 & 1) == 0) goto L5;
        String r101 = null;
    L7:
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
        int r105 = 0;
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r110 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r111 = null;
    L31:
        if ((r316 & 128) == 0) goto L33;
        String r112 = null;
    L35:
        if ((r316 & 256) == 0) goto L37;
        List r113 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r114 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        ECUrlModel r115 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        long r116 = 0;
    L51:
        if ((r316 & 4096) != 0) goto L54;
        r100 = r314;
    L54:
        this(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r100, r315);
        return;
    L49:
        r116 = r313;
        goto L51
    L45:
        r115 = r312;
        goto L47
    L41:
        r114 = r311;
        goto L43
    L37:
        r113 = r310;
        goto L39
    L33:
        r112 = r217;
        goto L35
    L29:
        r111 = r216;
        goto L31
    L25:
        r110 = r215;
        goto L27
    L21:
        r105 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
