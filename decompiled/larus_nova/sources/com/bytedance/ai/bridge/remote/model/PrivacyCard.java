package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JQ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/PrivacyCard;", "Ljava/io/Serializable;", "doubaoMiniAppKey", "", "doubaoMiniAppName", "doubaoMiniAppIcon", "doubaoMiniAppVersion", "doubaoMiniAppDescription", "privacyInfo", "Lcom/bytedance/ai/bridge/remote/model/PrivacyInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/PrivacyInfo;)V", "getDoubaoMiniAppKey", "()Ljava/lang/String;", "getDoubaoMiniAppName", "getDoubaoMiniAppIcon", "getDoubaoMiniAppVersion", "getDoubaoMiniAppDescription", "getPrivacyInfo", "()Lcom/bytedance/ai/bridge/remote/model/PrivacyInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrivacyCard implements Serializable {

    @SerializedName("DoubaoMiniAppDescription")
    private final String doubaoMiniAppDescription;

    @SerializedName("DoubaoMiniAppIcon")
    private final String doubaoMiniAppIcon;

    @SerializedName("DoubaoMiniAppKey")
    private final String doubaoMiniAppKey;

    @SerializedName("DoubaoMiniAppName")
    private final String doubaoMiniAppName;

    @SerializedName("DoubaoMiniAppVersion")
    private final String doubaoMiniAppVersion;

    @SerializedName("PrivacyInfo")
    private final PrivacyInfo privacyInfo;

    public PrivacyCard() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ PrivacyCard copy$default(PrivacyCard r100, String r101, String r102, String r103, String r104, String r105, PrivacyInfo r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.doubaoMiniAppKey;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.doubaoMiniAppName;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.doubaoMiniAppIcon;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.doubaoMiniAppVersion;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.doubaoMiniAppDescription;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.privacyInfo;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.doubaoMiniAppKey;
    }

    public final String component2() {
        return this.doubaoMiniAppName;
    }

    public final String component3() {
        return this.doubaoMiniAppIcon;
    }

    public final String component4() {
        return this.doubaoMiniAppVersion;
    }

    public final String component5() {
        return this.doubaoMiniAppDescription;
    }

    public final PrivacyInfo component6() {
        return this.privacyInfo;
    }

    public final PrivacyCard copy(String r100, String r110, String r111, String r112, String r113, PrivacyInfo r114) {
        return new PrivacyCard(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PrivacyCard) == true) goto L8;
        return false;
    L8:
        PrivacyCard r101 = (PrivacyCard) r100;
        if (Intrinsics.areEqual(this.doubaoMiniAppKey, r101.doubaoMiniAppKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.doubaoMiniAppName, r101.doubaoMiniAppName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.doubaoMiniAppIcon, r101.doubaoMiniAppIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.doubaoMiniAppVersion, r101.doubaoMiniAppVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.doubaoMiniAppDescription, r101.doubaoMiniAppDescription) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.privacyInfo, r101.privacyInfo) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.doubaoMiniAppKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.doubaoMiniAppName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.doubaoMiniAppIcon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.doubaoMiniAppVersion;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.doubaoMiniAppDescription;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        PrivacyInfo r116 = this.privacyInfo;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PrivacyCard(doubaoMiniAppKey=" + this.doubaoMiniAppKey + ", doubaoMiniAppName=" + this.doubaoMiniAppName + ", doubaoMiniAppIcon=" + this.doubaoMiniAppIcon + ", doubaoMiniAppVersion=" + this.doubaoMiniAppVersion + ", doubaoMiniAppDescription=" + this.doubaoMiniAppDescription + ", privacyInfo=" + this.privacyInfo + ')';
    }

    public final String getDoubaoMiniAppDescription() {
        return this.doubaoMiniAppDescription;
    }

    public final String getDoubaoMiniAppIcon() {
        return this.doubaoMiniAppIcon;
    }

    public final String getDoubaoMiniAppKey() {
        return this.doubaoMiniAppKey;
    }

    public final String getDoubaoMiniAppName() {
        return this.doubaoMiniAppName;
    }

    public final String getDoubaoMiniAppVersion() {
        return this.doubaoMiniAppVersion;
    }

    public final PrivacyInfo getPrivacyInfo() {
        return this.privacyInfo;
    }

    public PrivacyCard(String r100, String r101, String r102, String r103, String r104, PrivacyInfo r105) {
        this.doubaoMiniAppKey = r100;
        this.doubaoMiniAppName = r101;
        this.doubaoMiniAppIcon = r102;
        this.doubaoMiniAppVersion = r103;
        this.doubaoMiniAppDescription = r104;
        this.privacyInfo = r105;
    }

    public /* synthetic */ PrivacyCard(String r100, String r101, String r102, String r103, String r110, PrivacyInfo r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        PrivacyInfo r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
