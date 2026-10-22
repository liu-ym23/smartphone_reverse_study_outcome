package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.live.base.model.message.a5;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001B»\u0001\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010 \u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0015\u0012(\b\u0002\u0010#\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0018¢\u0006\u0004\bB\u0010CJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003J\u0011\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\u0012\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003J)\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0018HÆ\u0003JÄ\u0001\u0010$\u001a\u00020\u00002\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\u001b\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u001d\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\u0010\b\u0002\u0010\u001e\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010 \u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00152(\b\u0002\u0010#\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0018HÆ\u0001¢\u0006\u0004\b$\u0010%J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010(\u001a\u00020'HÖ\u0001J\u0013\u0010*\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001f\u0010\u001a\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058\u0006¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b,\u0010\u0007R\u001f\u0010\u001b\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b1\u00102R\u001f\u0010\u001d\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b3\u0010/R\u001f\u0010\u001e\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8\u0006¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b5\u00106R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u001f\u00100\u001a\u0004\b7\u00102R\u001f\u0010 \u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006¢\u0006\f\n\u0004\b \u0010-\u001a\u0004\b8\u0010/R\u0019\u0010!\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b!\u00109\u001a\u0004\b:\u0010;R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\"\u0010<\u001a\u0004\b=\u0010>R7\u0010#\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00188\u0006¢\u0006\f\n\u0004\b#\u0010?\u001a\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/PrivilegeEntranceInfo;", "", "", "canShowBgPop", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "component1", "()Ljava/lang/Long;", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "component2", "", "component3", "component4", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "component5", "component6", "component7", "Lcom/bytedance/android/live/profit/privilege/model/touch/i;", "component8", "Lcom/bytedance/android/live/profit/privilege/model/touch/c;", "component9", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "component10", "metaId", "panelDetail", "panelUrl", "bubbleText", "bubbleBackgroundImg", "bubbleUrl", "awardTips", "lightInfo", "dynamicInfo", "extra", "copy", "(Ljava/lang/Long;Lcom/bytedance/android/live/base/model/message/a5;Ljava/lang/String;Lcom/bytedance/android/live/base/model/message/a5;Lpy/k;Ljava/lang/String;Lcom/bytedance/android/live/base/model/message/a5;Lcom/bytedance/android/live/profit/privilege/model/touch/i;Lcom/bytedance/android/live/profit/privilege/model/touch/c;Ljava/util/Map;)Lcom/bytedance/android/live/profit/privilege/model/touch/PrivilegeEntranceInfo;", "toString", "", "hashCode", "other", "equals", "Ljava/lang/Long;", "getMetaId", "Lcom/bytedance/android/live/base/model/message/a5;", "getPanelDetail", "()Lcom/bytedance/android/live/base/model/message/a5;", "Ljava/lang/String;", "getPanelUrl", "()Ljava/lang/String;", "getBubbleText", "Lpy/k;", "getBubbleBackgroundImg", "()Lpy/k;", "getBubbleUrl", "getAwardTips", "Lcom/bytedance/android/live/profit/privilege/model/touch/i;", "getLightInfo", "()Lcom/bytedance/android/live/profit/privilege/model/touch/i;", "Lcom/bytedance/android/live/profit/privilege/model/touch/c;", "getDynamicInfo", "()Lcom/bytedance/android/live/profit/privilege/model/touch/c;", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "<init>", "(Ljava/lang/Long;Lcom/bytedance/android/live/base/model/message/a5;Ljava/lang/String;Lcom/bytedance/android/live/base/model/message/a5;Lpy/k;Ljava/lang/String;Lcom/bytedance/android/live/base/model/message/a5;Lcom/bytedance/android/live/profit/privilege/model/touch/i;Lcom/bytedance/android/live/profit/privilege/model/touch/c;Ljava/util/Map;)V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PrivilegeEntranceInfo {
    private final a5 awardTips;
    private final py.k bubbleBackgroundImg;
    private final a5 bubbleText;
    private final String bubbleUrl;
    private final c dynamicInfo;
    private final Map<String, String> extra;
    private final i lightInfo;
    private final Long metaId;
    private final a5 panelDetail;
    private final String panelUrl;

    public PrivilegeEntranceInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrivilegeEntranceInfo copy$default(PrivilegeEntranceInfo r110, Long r111, a5 r112, String r113, a5 r114, py.k r115, String r116, a5 r117, i r118, c r210, Map r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        Long r100 = r110.metaId;
    L7:
        if ((r212 & 2) == 0) goto L9;
        a5 r101 = r110.panelDetail;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.panelUrl;
    L15:
        if ((r212 & 8) == 0) goto L17;
        a5 r103 = r110.bubbleText;
    L19:
        if ((r212 & 16) == 0) goto L21;
        py.k r104 = r110.bubbleBackgroundImg;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.bubbleUrl;
    L27:
        if ((r212 & 64) == 0) goto L29;
        a5 r106 = r110.awardTips;
    L31:
        if ((r212 & 128) == 0) goto L33;
        i r107 = r110.lightInfo;
    L35:
        if ((r212 & 256) == 0) goto L37;
        c r119 = r110.dynamicInfo;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Map r108 = r110.extra;
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

    public final Long component1() {
        return this.metaId;
    }

    public final Map<String, String> component10() {
        return this.extra;
    }

    public final a5 component2() {
        return this.panelDetail;
    }

    public final String component3() {
        return this.panelUrl;
    }

    public final a5 component4() {
        return this.bubbleText;
    }

    public final py.k component5() {
        return this.bubbleBackgroundImg;
    }

    public final String component6() {
        return this.bubbleUrl;
    }

    public final a5 component7() {
        return this.awardTips;
    }

    public final i component8() {
        return this.lightInfo;
    }

    public final c component9() {
        return this.dynamicInfo;
    }

    public final PrivilegeEntranceInfo copy(Long r110, a5 r111, String r112, a5 r113, py.k r114, String r115, a5 r116, i r210, c r211, Map<String, String> r212) {
        return new PrivilegeEntranceInfo(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PrivilegeEntranceInfo) == false) goto L26;
        PrivilegeEntranceInfo r101 = (PrivilegeEntranceInfo) r100;
        if (Intrinsics.areEqual(this.metaId, r101.metaId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.panelDetail, r101.panelDetail) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.panelUrl, r101.panelUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bubbleText, r101.bubbleText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bubbleBackgroundImg, r101.bubbleBackgroundImg) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bubbleUrl, r101.bubbleUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.awardTips, r101.awardTips) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.lightInfo, r101.lightInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.dynamicInfo, r101.dynamicInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        Long r100 = this.metaId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a5 r104 = this.panelDetail;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.panelUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        a5 r110 = this.bubbleText;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        py.k r113 = this.bubbleBackgroundImg;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.bubbleUrl;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        a5 r119 = this.awardTips;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        i r122 = this.lightInfo;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        c r125 = this.dynamicInfo;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, String> r128 = this.extra;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PrivilegeEntranceInfo(metaId=" + this.metaId + ", panelDetail=" + this.panelDetail + ", panelUrl=" + this.panelUrl + ", bubbleText=" + this.bubbleText + ", bubbleBackgroundImg=" + this.bubbleBackgroundImg + ", bubbleUrl=" + this.bubbleUrl + ", awardTips=" + this.awardTips + ", lightInfo=" + this.lightInfo + ", dynamicInfo=" + this.dynamicInfo + ", extra=" + this.extra + ")";
    }

    public final boolean canShowBgPop() {
        py.k r100 = this.bubbleBackgroundImg;
        if (r100 == null) goto L7;
        List<String> r101 = r100.getUrls();
        if (r101 == null) goto L7;
        int r102 = r101.size();
    L8:
        if (r102 <= 0) goto L11;
        return true;
    L11:
        return false;
    L7:
        r102 = 0;
        goto L8
    }

    public final a5 getAwardTips() {
        return this.awardTips;
    }

    public final py.k getBubbleBackgroundImg() {
        return this.bubbleBackgroundImg;
    }

    public final a5 getBubbleText() {
        return this.bubbleText;
    }

    public final String getBubbleUrl() {
        return this.bubbleUrl;
    }

    public final c getDynamicInfo() {
        return this.dynamicInfo;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final i getLightInfo() {
        return this.lightInfo;
    }

    public final Long getMetaId() {
        return this.metaId;
    }

    public final a5 getPanelDetail() {
        return this.panelDetail;
    }

    public final String getPanelUrl() {
        return this.panelUrl;
    }

    public PrivilegeEntranceInfo(Long r100, a5 r101, String r102, a5 r103, py.k r104, String r105, a5 r106, i r107, c r108, Map<String, String> r110) {
        this.metaId = r100;
        this.panelDetail = r101;
        this.panelUrl = r102;
        this.bubbleText = r103;
        this.bubbleBackgroundImg = r104;
        this.bubbleUrl = r105;
        this.awardTips = r106;
        this.lightInfo = r107;
        this.dynamicInfo = r108;
        this.extra = r110;
    }

    public /* synthetic */ PrivilegeEntranceInfo(Long r110, a5 r111, String r112, a5 r113, py.k r114, String r115, a5 r116, i r117, c r210, Map r211, int r212, DefaultConstructorMarker r213) {
        Map r100 = null;
        if ((r212 & 1) == 0) goto L5;
        Long r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        a5 r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        a5 r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        py.k r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        a5 r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        i r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        c r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
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
