package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b;\u0010<J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0017\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0087\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\n2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\u0013\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010%R%\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0016\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u0017\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0018\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u00101R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u0019\u00102\u001a\u0004\b3\u00104R\u0017\u0010\u001a\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b5\u0010+R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u001b\u00106\u001a\u0004\b7\u00108R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b9\u0010.R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b:\u0010.¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowBuffCardData;", "", "", "component1", "", "", "component2", "", "component3", "component4", "Lcom/bytedance/android/livesdk/gift/model/h1;", "component5", "", "Lcom/bytedance/android/livesdk/gift/model/l1;", "component6", "component7", "Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "component8", "component9", "component10", "canShow", "params", "defaultBuffLevel", "defaultJumpSchema", PbRequest.SwitchType.GIFT, "buffInfo", "pageType", "giftMarketingInfo", "bannerInfo", "giftSceneMarketingInfo", "copy", "toString", "hashCode", "other", "equals", "Z", "getCanShow", "()Z", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "I", "getDefaultBuffLevel", "()I", "Ljava/lang/String;", "getDefaultJumpSchema", "()Ljava/lang/String;", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", "Ljava/util/List;", "getBuffInfo", "()Ljava/util/List;", "getPageType", "Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "getGiftMarketingInfo", "()Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "getBannerInfo", "getGiftSceneMarketingInfo", "<init>", "(ZLjava/util/Map;ILjava/lang/String;Lcom/bytedance/android/livesdk/gift/model/h1;Ljava/util/List;ILcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;Ljava/lang/String;Ljava/lang/String;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowBuffCardData {
    private final String bannerInfo;
    private final List<l1> buffInfo;
    private final boolean canShow;
    private final int defaultBuffLevel;
    private final String defaultJumpSchema;
    private final h1 gift;
    private final IGiftMarketingInfo giftMarketingInfo;
    private final String giftSceneMarketingInfo;
    private final int pageType;
    private final Map<String, Object> params;

    public ShowBuffCardData() {
        this(false, null, 0, null, null, null, 0, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowBuffCardData copy$default(ShowBuffCardData r110, boolean r111, Map r112, int r113, String r114, h1 r115, List r116, int r117, IGiftMarketingInfo r118, String r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        boolean r100 = r110.canShow;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Map r101 = r110.params;
    L11:
        if ((r212 & 4) == 0) goto L13;
        int r102 = r110.defaultBuffLevel;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.defaultJumpSchema;
    L19:
        if ((r212 & 16) == 0) goto L21;
        h1 r104 = r110.gift;
    L23:
        if ((r212 & 32) == 0) goto L25;
        List r105 = r110.buffInfo;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r106 = r110.pageType;
    L31:
        if ((r212 & 128) == 0) goto L33;
        IGiftMarketingInfo r107 = r110.giftMarketingInfo;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.bannerInfo;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.giftSceneMarketingInfo;
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

    public final boolean component1() {
        return this.canShow;
    }

    public final String component10() {
        return this.giftSceneMarketingInfo;
    }

    public final Map<String, Object> component2() {
        return this.params;
    }

    public final int component3() {
        return this.defaultBuffLevel;
    }

    public final String component4() {
        return this.defaultJumpSchema;
    }

    public final h1 component5() {
        return this.gift;
    }

    public final List<l1> component6() {
        return this.buffInfo;
    }

    public final int component7() {
        return this.pageType;
    }

    public final IGiftMarketingInfo component8() {
        return this.giftMarketingInfo;
    }

    public final String component9() {
        return this.bannerInfo;
    }

    public final ShowBuffCardData copy(boolean r110, Map<String, ? extends Object> r111, int r112, String r113, h1 r114, List<? extends l1> r115, int r116, IGiftMarketingInfo r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r113, "defaultJumpSchema");
        Intrinsics.checkNotNullParameter(r114, PbRequest.SwitchType.GIFT);
        Intrinsics.checkNotNullParameter(r115, "buffInfo");
        return new ShowBuffCardData(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShowBuffCardData) == false) goto L26;
        ShowBuffCardData r101 = (ShowBuffCardData) r100;
        if (this.canShow == r101.canShow) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L10;
        return false;
    L10:
        if (this.defaultBuffLevel == r101.defaultBuffLevel) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultJumpSchema, r101.defaultJumpSchema) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.gift, r101.gift) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.buffInfo, r101.buffInfo) == true) goto L18;
        return false;
    L18:
        if (this.pageType == r101.pageType) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.giftMarketingInfo, r101.giftMarketingInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bannerInfo, r101.bannerInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.giftSceneMarketingInfo, r101.giftSceneMarketingInfo) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    public int hashCode() {
        boolean r100 = this.canShow;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Map<String, Object> r103 = this.params;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (((r102 + r105) * 31) + this.defaultBuffLevel) * 31;
        String r107 = this.defaultJumpSchema;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        h1 r110 = this.gift;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        List<l1> r113 = this.buffInfo;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (((r112 + r114) * 31) + this.pageType) * 31;
        IGiftMarketingInfo r116 = this.giftMarketingInfo;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        String r119 = this.bannerInfo;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        String r122 = this.giftSceneMarketingInfo;
        if (r122 == null) goto L33;
        r104 = r122.hashCode();
    L33:
        return r121 + r104;
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "ShowBuffCardData(canShow=" + this.canShow + ", params=" + this.params + ", defaultBuffLevel=" + this.defaultBuffLevel + ", defaultJumpSchema=" + this.defaultJumpSchema + ", gift=" + this.gift + ", buffInfo=" + this.buffInfo + ", pageType=" + this.pageType + ", giftMarketingInfo=" + this.giftMarketingInfo + ", bannerInfo=" + this.bannerInfo + ", giftSceneMarketingInfo=" + this.giftSceneMarketingInfo + ")";
    }

    public final String getBannerInfo() {
        return this.bannerInfo;
    }

    public final List<l1> getBuffInfo() {
        return this.buffInfo;
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    public final int getDefaultBuffLevel() {
        return this.defaultBuffLevel;
    }

    public final String getDefaultJumpSchema() {
        return this.defaultJumpSchema;
    }

    public final h1 getGift() {
        return this.gift;
    }

    public final IGiftMarketingInfo getGiftMarketingInfo() {
        return this.giftMarketingInfo;
    }

    public final String getGiftSceneMarketingInfo() {
        return this.giftSceneMarketingInfo;
    }

    public final int getPageType() {
        return this.pageType;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShowBuffCardData(boolean r100, Map<String, ? extends Object> r101, int r102, String r103, h1 r104, List<? extends l1> r105, int r106, IGiftMarketingInfo r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r103, "defaultJumpSchema");
        Intrinsics.checkNotNullParameter(r104, PbRequest.SwitchType.GIFT);
        Intrinsics.checkNotNullParameter(r105, "buffInfo");
        this.canShow = r100;
        this.params = r101;
        this.defaultBuffLevel = r102;
        this.defaultJumpSchema = r103;
        this.gift = r104;
        this.buffInfo = r105;
        this.pageType = r106;
        this.giftMarketingInfo = r107;
        this.bannerInfo = r110;
        this.giftSceneMarketingInfo = r111;
    }

    public /* synthetic */ ShowBuffCardData(boolean r110, Map r111, int r112, String r113, h1 r114, List r115, int r116, IGiftMarketingInfo r117, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        int r100 = 0;
        if ((r212 & 1) == 0) goto L5;
        boolean r101 = false;
    L6:
        String r102 = null;
        if ((r212 & 2) == 0) goto L9;
        Map r103 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r212 & 16) == 0) goto L21;
        h1 r106 = (h1) f.c(h1.class);
    L23:
        if ((r212 & 32) == 0) goto L25;
        List r107 = CollectionsKt.emptyList();
    L27:
        if ((r212 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r212 & 128) == 0) goto L33;
        IGiftMarketingInfo r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r102 = r211;
    L42:
        this(r101, r103, r104, r105, r106, r107, r100, r108, r118, r102);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
