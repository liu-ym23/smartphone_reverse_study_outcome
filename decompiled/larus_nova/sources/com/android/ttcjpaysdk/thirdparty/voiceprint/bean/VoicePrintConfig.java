package com.android.ttcjpaysdk.thirdparty.voiceprint.bean;

import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000fHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÂ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003Jm\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\u0006\u0010+\u001a\u00020\u000bJ\t\u0010,\u001a\u00020\u000bHÖ\u0001J\u0006\u0010-\u001a\u00020\tJ\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006/"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintConfig;", "Ljava/io/Serializable;", "merchantId", "", "appId", "memberBizOrderNo", "verifyType", "voiceText", "useDenoise", "", "verifyGroupNum", "", "bizScene", "tipsText", "encryptScene", "Lcom/android/ttcjpaysdk/base/encrypt/CJEncryptScene;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/encrypt/CJEncryptScene;)V", "getAppId", "()Ljava/lang/String;", "getBizScene", "getEncryptScene", "()Lcom/android/ttcjpaysdk/base/encrypt/CJEncryptScene;", "getMemberBizOrderNo", "getMerchantId", "getTipsText", "getUseDenoise", "()Z", "getVerifyType", "getVoiceText", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getVerifyGroupNum", "hashCode", "isInvalid", "toString", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoicePrintConfig implements Serializable {
    private final String appId;
    private final String bizScene;
    private final CJEncryptScene encryptScene;
    private final String memberBizOrderNo;
    private final String merchantId;
    private final String tipsText;
    private final boolean useDenoise;
    private final int verifyGroupNum;
    private final String verifyType;
    private final String voiceText;

    public VoicePrintConfig() {
        this(null, null, null, null, null, false, 0, null, null, null, 1023, null);
    }

    private final int component7() {
        return this.verifyGroupNum;
    }

    public static /* synthetic */ VoicePrintConfig copy$default(VoicePrintConfig r110, String r111, String r112, String r113, String r114, String r115, boolean r116, int r117, String r118, String r210, CJEncryptScene r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.merchantId;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.appId;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.memberBizOrderNo;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.verifyType;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.voiceText;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r105 = r110.useDenoise;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r106 = r110.verifyGroupNum;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.bizScene;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.tipsText;
    L39:
        if ((r212 & 512) == 0) goto L41;
        CJEncryptScene r108 = r110.encryptScene;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
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
        return this.merchantId;
    }

    public final CJEncryptScene component10() {
        return this.encryptScene;
    }

    public final String component2() {
        return this.appId;
    }

    public final String component3() {
        return this.memberBizOrderNo;
    }

    public final String component4() {
        return this.verifyType;
    }

    public final String component5() {
        return this.voiceText;
    }

    public final boolean component6() {
        return this.useDenoise;
    }

    public final String component8() {
        return this.bizScene;
    }

    public final String component9() {
        return this.tipsText;
    }

    public final VoicePrintConfig copy(String r110, String r111, String r112, String r113, String r114, boolean r115, int r116, String r210, String r211, CJEncryptScene r212) {
        Intrinsics.checkNotNullParameter(r110, "merchantId");
        Intrinsics.checkNotNullParameter(r111, "appId");
        Intrinsics.checkNotNullParameter(r112, "memberBizOrderNo");
        Intrinsics.checkNotNullParameter(r113, "verifyType");
        Intrinsics.checkNotNullParameter(r114, "voiceText");
        Intrinsics.checkNotNullParameter(r210, "bizScene");
        Intrinsics.checkNotNullParameter(r211, "tipsText");
        Intrinsics.checkNotNullParameter(r212, "encryptScene");
        return new VoicePrintConfig(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VoicePrintConfig) == true) goto L8;
        return false;
    L8:
        VoicePrintConfig r101 = (VoicePrintConfig) r100;
        if (Intrinsics.areEqual(this.merchantId, r101.merchantId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.memberBizOrderNo, r101.memberBizOrderNo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.verifyType, r101.verifyType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.voiceText, r101.voiceText) == true) goto L24;
        return false;
    L24:
        if (this.useDenoise == r101.useDenoise) goto L27;
        return false;
    L27:
        if (this.verifyGroupNum == r101.verifyGroupNum) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bizScene, r101.bizScene) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.tipsText, r101.tipsText) == true) goto L36;
        return false;
    L36:
        if (this.encryptScene == r101.encryptScene) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.merchantId.hashCode() * 31) + this.appId.hashCode()) * 31) + this.memberBizOrderNo.hashCode()) * 31) + this.verifyType.hashCode()) * 31) + this.voiceText.hashCode()) * 31;
        if (this.useDenoise == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((((((r100 + r101) * 31) + this.verifyGroupNum) * 31) + this.bizScene.hashCode()) * 31) + this.tipsText.hashCode()) * 31) + this.encryptScene.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "VoicePrintConfig(merchantId=" + this.merchantId + ", appId=" + this.appId + ", memberBizOrderNo=" + this.memberBizOrderNo + ", verifyType=" + this.verifyType + ", voiceText=" + this.voiceText + ", useDenoise=" + this.useDenoise + ", verifyGroupNum=" + this.verifyGroupNum + ", bizScene=" + this.bizScene + ", tipsText=" + this.tipsText + ", encryptScene=" + this.encryptScene + ')';
    }

    public final int getVerifyGroupNum() {
        int r100 = this.verifyGroupNum;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        String r101 = this.verifyType;
        if (Intrinsics.areEqual(r101, VoicePrintOperation.OPEN.getValue()) == false) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return 5;
    L11:
        Intrinsics.areEqual(r101, VoicePrintOperation.VERIFY.getValue());
        return 1;
    L8:
        r102 = Intrinsics.areEqual(r101, VoicePrintOperation.UPDATE.getValue());
        goto L9
    }

    public final boolean isInvalid() {
        if (StringsKt.isBlank(this.merchantId) == false) goto L5;
    L14:
        return true;
    L5:
        if (StringsKt.isBlank(this.appId) == true) goto L14;
        if (StringsKt.isBlank(this.memberBizOrderNo) == true) goto L14;
        if (StringsKt.isBlank(this.verifyType) == true) goto L14;
        if (StringsKt.isBlank(this.voiceText) == true) goto L14;
        return false;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getBizScene() {
        return this.bizScene;
    }

    public final CJEncryptScene getEncryptScene() {
        return this.encryptScene;
    }

    public final String getMemberBizOrderNo() {
        return this.memberBizOrderNo;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final String getTipsText() {
        return this.tipsText;
    }

    public final boolean getUseDenoise() {
        return this.useDenoise;
    }

    public final String getVerifyType() {
        return this.verifyType;
    }

    public final String getVoiceText() {
        return this.voiceText;
    }

    public VoicePrintConfig(String r100, String r101, String r102, String r103, String r104, boolean r105, int r106, String r107, String r110, CJEncryptScene r111) {
        Intrinsics.checkNotNullParameter(r100, "merchantId");
        Intrinsics.checkNotNullParameter(r101, "appId");
        Intrinsics.checkNotNullParameter(r102, "memberBizOrderNo");
        Intrinsics.checkNotNullParameter(r103, "verifyType");
        Intrinsics.checkNotNullParameter(r104, "voiceText");
        Intrinsics.checkNotNullParameter(r107, "bizScene");
        Intrinsics.checkNotNullParameter(r110, "tipsText");
        Intrinsics.checkNotNullParameter(r111, "encryptScene");
        this.merchantId = r100;
        this.appId = r101;
        this.memberBizOrderNo = r102;
        this.verifyType = r103;
        this.voiceText = r104;
        this.useDenoise = r105;
        this.verifyGroupNum = r106;
        this.bizScene = r107;
        this.tipsText = r110;
        this.encryptScene = r111;
    }

    public /* synthetic */ VoicePrintConfig(String r110, String r111, String r112, String r113, String r114, boolean r115, int r116, String r117, String r210, CJEncryptScene r211, int r212, DefaultConstructorMarker r213) {
        String r100 = "";
        if ((r212 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r106 = true;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r212 & 256) != 0) goto L39;
        r100 = r210;
    L39:
        if ((r212 & 512) == 0) goto L41;
        CJEncryptScene r109 = CJEncryptScene.TRADE_VERIFY;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100, r109);
        return;
    L41:
        r109 = r211;
        goto L42
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
