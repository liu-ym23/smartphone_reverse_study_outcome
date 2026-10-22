package com.bytedance.android.livesdkapi.depend.message.wrds;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PreviewCjRpMessage.CjRp")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\u0081\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001e\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001a¨\u0006@"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/wrds/FansRedPacket;", "", "id", "", DyPayConstant.KEY_START_TIME, "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "delayTime", "status", "type", "iconUrl", "text", "totalAmount", "leftAmount", "totalNum", "leftNum", "(Ljava/lang/String;JJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJ)V", "getDelayTime", "()J", "setDelayTime", "(J)V", "getExpireTime", "setExpireTime", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getId", "setId", "getLeftAmount", "setLeftAmount", "getLeftNum", "setLeftNum", "getStartTime", "setStartTime", "getStatus", "setStatus", "getText", "setText", "getTotalAmount", "setTotalAmount", "getTotalNum", "setTotalNum", "getType", "setType", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansRedPacket implements h {

    @SerializedName("display_delay_seconds")
    protected long delayTime;

    @SerializedName("expire_time")
    protected long expireTime;

    @SerializedName("icon")
    protected String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("rp_order_no")
    protected String f162573id;

    @SerializedName("left_amount")
    protected long leftAmount;

    @SerializedName("left_num")
    protected long leftNum;

    @SerializedName("send_time")
    protected long startTime;

    @SerializedName("status")
    protected long status;

    @SerializedName("text")
    protected String text;

    @SerializedName("total_amount")
    protected long totalAmount;

    @SerializedName("total_num")
    protected long totalNum;

    @SerializedName("currency")
    protected String type;

    public FansRedPacket(String r100, long r101, long r110, long r111, long r112, String r113, String r114, String r115, long r210, long r211, long r212, long r213) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r113, "type");
        Intrinsics.checkNotNullParameter(r114, "iconUrl");
        Intrinsics.checkNotNullParameter(r115, "text");
        this.f162573id = r100;
        this.startTime = r101;
        this.expireTime = r110;
        this.delayTime = r111;
        this.status = r112;
        this.type = r113;
        this.iconUrl = r114;
        this.text = r115;
        this.totalAmount = r210;
        this.leftAmount = r211;
        this.totalNum = r212;
        this.leftNum = r213;
    }

    public static /* synthetic */ FansRedPacket copy$default(FansRedPacket r110, String r111, long r112, long r210, long r211, long r212, String r213, String r214, String r215, long r216, long r310, long r311, long r312, int r313, Object r314) {
        if ((r313 & 1) == 0) goto L5;
        String r100 = r110.f162573id;
    L7:
        if ((r313 & 2) == 0) goto L9;
        long r101 = r110.startTime;
    L11:
        if ((r313 & 4) == 0) goto L13;
        long r102 = r110.expireTime;
    L15:
        if ((r313 & 8) == 0) goto L17;
        long r103 = r110.delayTime;
    L19:
        if ((r313 & 16) == 0) goto L21;
        long r104 = r110.status;
    L23:
        if ((r313 & 32) == 0) goto L25;
        String r113 = r110.type;
    L27:
        if ((r313 & 64) == 0) goto L29;
        String r114 = r110.iconUrl;
    L31:
        if ((r313 & 128) == 0) goto L33;
        String r115 = r110.text;
    L35:
        if ((r313 & 256) == 0) goto L37;
        long r116 = r110.totalAmount;
    L38:
        long r217 = r116;
        if ((r313 & 512) == 0) goto L41;
        long r117 = r110.leftAmount;
    L42:
        long r315 = r117;
        if ((r313 & 1024) == 0) goto L45;
        long r118 = r110.totalNum;
    L46:
        long r316 = r118;
        if ((r313 & 2048) == 0) goto L49;
        long r119 = r110.leftNum;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r113, r114, r115, r217, r315, r316, r119);
    L49:
        r119 = r312;
        goto L51
    L45:
        r118 = r311;
        goto L46
    L41:
        r117 = r310;
        goto L42
    L37:
        r116 = r216;
        goto L38
    L33:
        r115 = r215;
        goto L35
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.f162573id;
    }

    public final long component10() {
        return this.leftAmount;
    }

    public final long component11() {
        return this.totalNum;
    }

    public final long component12() {
        return this.leftNum;
    }

    public final long component2() {
        return this.startTime;
    }

    public final long component3() {
        return this.expireTime;
    }

    public final long component4() {
        return this.delayTime;
    }

    public final long component5() {
        return this.status;
    }

    public final String component6() {
        return this.type;
    }

    public final String component7() {
        return this.iconUrl;
    }

    public final String component8() {
        return this.text;
    }

    public final long component9() {
        return this.totalAmount;
    }

    public final FansRedPacket copy(String r210, long r211, long r212, long r213, long r310, String r311, String r312, String r313, long r314, long r315, long r410, long r411) {
        Intrinsics.checkNotNullParameter(r210, "id");
        Intrinsics.checkNotNullParameter(r311, "type");
        Intrinsics.checkNotNullParameter(r312, "iconUrl");
        Intrinsics.checkNotNullParameter(r313, "text");
        return new FansRedPacket(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r410, r411);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FansRedPacket) == false) goto L30;
        FansRedPacket r101 = (FansRedPacket) r100;
        if (Intrinsics.areEqual(this.f162573id, r101.f162573id) == true) goto L8;
        return false;
    L8:
        if (this.startTime == r101.startTime) goto L10;
        return false;
    L10:
        if (this.expireTime == r101.expireTime) goto L12;
        return false;
    L12:
        if (this.delayTime == r101.delayTime) goto L14;
        return false;
    L14:
        if (this.status == r101.status) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L22;
        return false;
    L22:
        if (this.totalAmount == r101.totalAmount) goto L24;
        return false;
    L24:
        if (this.leftAmount == r101.leftAmount) goto L26;
        return false;
    L26:
        if (this.totalNum == r101.totalNum) goto L28;
        return false;
    L28:
        if (this.leftNum == r101.leftNum) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        String r100 = this.f162573id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.startTime;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.expireTime;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.delayTime;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.status;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.type;
        if (r111 == null) goto L9;
        int r112 = r111.hashCode();
    L10:
        int r113 = (r110 + r112) * 31;
        String r114 = this.iconUrl;
        if (r114 == null) goto L13;
        int r115 = r114.hashCode();
    L14:
        int r116 = (r113 + r115) * 31;
        String r117 = this.text;
        if (r117 == null) goto L17;
        r101 = r117.hashCode();
    L17:
        int r118 = (r116 + r101) * 31;
        long r119 = this.totalAmount;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.leftAmount;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        long r123 = this.totalNum;
        int r124 = (r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31;
        long r125 = this.leftNum;
        return r124 + ((int) (r125 ^ (r125 >>> 32)));
    L13:
        r115 = 0;
        goto L14
    L9:
        r112 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FansRedPacket(id=" + this.f162573id + ", startTime=" + this.startTime + ", expireTime=" + this.expireTime + ", delayTime=" + this.delayTime + ", status=" + this.status + ", type=" + this.type + ", iconUrl=" + this.iconUrl + ", text=" + this.text + ", totalAmount=" + this.totalAmount + ", leftAmount=" + this.leftAmount + ", totalNum=" + this.totalNum + ", leftNum=" + this.leftNum + ")";
    }

    public FansRedPacket() {
        this.f162573id = "";
        this.startTime = 0;
        this.expireTime = 0;
        this.delayTime = 0;
        this.status = 0;
        this.type = "";
        this.iconUrl = "";
        this.text = "";
        this.totalAmount = 0;
        this.leftAmount = 0;
        this.totalNum = 0;
        this.leftNum = 0;
    }

    public final long getDelayTime() {
        return this.delayTime;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getId() {
        return this.f162573id;
    }

    public final long getLeftAmount() {
        return this.leftAmount;
    }

    public final long getLeftNum() {
        return this.leftNum;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getStatus() {
        return this.status;
    }

    public final String getText() {
        return this.text;
    }

    public final long getTotalAmount() {
        return this.totalAmount;
    }

    public final long getTotalNum() {
        return this.totalNum;
    }

    public final String getType() {
        return this.type;
    }

    public FansRedPacket(g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L19;
        switch(r103) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L7:
        this.leftNum = r100.j();
        r102 = r102 | 128;
        goto L3
    L8:
        this.totalNum = r100.j();
        r102 = r102 | 64;
        goto L3
    L9:
        this.leftAmount = r100.j();
        r102 = r102 | 32;
        goto L3
    L10:
        this.totalAmount = r100.j();
        r102 = r102 | 16;
        goto L3
    L11:
        this.text = am3.h.c(r100);
        goto L3
    L12:
        this.iconUrl = am3.h.c(r100);
        goto L3
    L13:
        this.type = am3.h.c(r100);
        goto L3
    L14:
        this.status = r100.j();
        r102 = r102 | 8;
        goto L3
    L15:
        this.delayTime = r100.j();
        r102 = r102 | 4;
        goto L3
    L16:
        this.expireTime = r100.j();
        r102 = r102 | 2;
        goto L3
    L17:
        this.startTime = r100.j();
        r102 = r102 | 1;
        goto L3
    L18:
        this.f162573id = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L19:
        r100.d(r101);
        if (this.f162573id != null) goto L23;
        this.f162573id = "";
    L23:
        if ((r102 & 1) != 0) goto L26;
        this.startTime = 0;
    L26:
        if ((r102 & 2) != 0) goto L29;
        this.expireTime = 0;
    L29:
        if ((r102 & 4) != 0) goto L32;
        this.delayTime = 0;
    L32:
        if ((r102 & 8) != 0) goto L35;
        this.status = 0;
    L35:
        if (this.type != null) goto L38;
        this.type = "";
    L38:
        if (this.iconUrl != null) goto L41;
        this.iconUrl = "";
    L41:
        if (this.text != null) goto L44;
        this.text = "";
    L44:
        if ((r102 & 16) != 0) goto L47;
        this.totalAmount = 0;
    L47:
        if ((r102 & 32) != 0) goto L50;
        this.leftAmount = 0;
    L50:
        if ((r102 & 64) != 0) goto L53;
        this.totalNum = 0;
    L53:
        if ((r102 & 128) != 0) goto L84;
        this.leftNum = 0;
        return;
    }

    public final void setDelayTime(long r100) {
        this.delayTime = r100;
    }

    public final void setExpireTime(long r100) {
        this.expireTime = r100;
    }

    public final void setIconUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.iconUrl = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f162573id = r100;
    }

    public final void setLeftAmount(long r100) {
        this.leftAmount = r100;
    }

    public final void setLeftNum(long r100) {
        this.leftNum = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setStatus(long r100) {
        this.status = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public final void setTotalAmount(long r100) {
        this.totalAmount = r100;
    }

    public final void setTotalNum(long r100) {
        this.totalNum = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public /* synthetic */ FansRedPacket(String r210, long r211, long r212, long r213, long r214, String r310, String r311, String r312, long r313, long r314, long r315, long r410, int r411, DefaultConstructorMarker r412) {
        String r100 = "";
        if ((r411 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r411 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r411 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r411 & 8) == 0) goto L17;
        long r110 = 0;
    L19:
        if ((r411 & 16) == 0) goto L21;
        long r111 = 0;
    L23:
        if ((r411 & 32) == 0) goto L25;
        String r104 = "";
    L27:
        if ((r411 & 64) == 0) goto L29;
        String r112 = "";
    L31:
        if ((r411 & 128) != 0) goto L35;
        r100 = r312;
    L35:
        if ((r411 & 256) == 0) goto L37;
        long r113 = 0;
    L39:
        if ((r411 & 512) == 0) goto L41;
        long r105 = 0;
    L42:
        long r114 = r105;
        if ((r411 & 1024) == 0) goto L45;
        long r106 = 0;
    L47:
        if ((r411 & 2048) == 0) goto L49;
        long r115 = 0;
    L50:
        this(r101, r102, r103, r110, r111, r104, r112, r100, r113, r114, r106, r115);
        return;
    L49:
        r115 = r410;
        goto L50
    L45:
        r106 = r315;
        goto L47
    L41:
        r105 = r314;
        goto L42
    L37:
        r113 = r313;
        goto L39
    L29:
        r112 = r311;
        goto L31
    L25:
        r104 = r310;
        goto L27
    L21:
        r111 = r214;
        goto L23
    L17:
        r110 = r213;
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
