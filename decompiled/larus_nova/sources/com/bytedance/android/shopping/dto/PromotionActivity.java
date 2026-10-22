package com.bytedance.android.shopping.dto;

import android.text.TextUtils;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u0006\u0010'\u001a\u00020(J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J{\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00104\u001a\u00020(2\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001e\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006:"}, d2 = {"Lcom/bytedance/android/shopping/dto/PromotionActivity;", "Ljava/io/Serializable;", "text", "", "icon", "url", "detailText", "title", DyPayConstant.KEY_START_TIME, "", "endTime", "serverTime", "cardImage", "logo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;)V", "getCardImage", "()Ljava/lang/String;", "setCardImage", "(Ljava/lang/String;)V", "getDetailText", "setDetailText", "getEndTime", "()J", "setEndTime", "(J)V", "getIcon", "setIcon", "getLogo", "setLogo", "getServerTime", "setServerTime", "getStartTime", "setStartTime", "getText", "setText", "getTitle", d.f25925o, "getUrl", "setUrl", "canBeShown", "", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionActivity implements Serializable {

    @SerializedName("card_image")
    private String cardImage;

    @SerializedName("detail_text")
    private String detailText;

    @SerializedName("end_time")
    private long endTime;

    @SerializedName("icon")
    private String icon;

    @SerializedName("logo")
    private String logo;

    @SerializedName("server_time")
    private long serverTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long startTime;

    @SerializedName("text")
    private String text;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    public PromotionActivity() {
        this(null, null, null, null, null, 0, 0, 0, null, null, 1023, null);
    }

    public static /* synthetic */ PromotionActivity copy$default(PromotionActivity r110, String r111, String r112, String r113, String r114, String r115, long r210, long r211, long r212, String r213, String r214, int r215, Object r216) {
        if ((r215 & 1) == 0) goto L5;
        String r100 = r110.text;
    L7:
        if ((r215 & 2) == 0) goto L9;
        String r101 = r110.icon;
    L11:
        if ((r215 & 4) == 0) goto L13;
        String r102 = r110.url;
    L15:
        if ((r215 & 8) == 0) goto L17;
        String r103 = r110.detailText;
    L19:
        if ((r215 & 16) == 0) goto L21;
        String r104 = r110.title;
    L23:
        if ((r215 & 32) == 0) goto L25;
        long r105 = r110.startTime;
    L27:
        if ((r215 & 64) == 0) goto L29;
        long r106 = r110.endTime;
    L31:
        if ((r215 & 128) == 0) goto L33;
        long r116 = r110.serverTime;
    L35:
        if ((r215 & 256) == 0) goto L37;
        String r117 = r110.cardImage;
    L39:
        if ((r215 & 512) == 0) goto L41;
        String r107 = r110.logo;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r116, r117, r107);
    L41:
        r107 = r214;
        goto L43
    L37:
        r117 = r213;
        goto L39
    L33:
        r116 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
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
        return this.text;
    }

    public final String component10() {
        return this.logo;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.detailText;
    }

    public final String component5() {
        return this.title;
    }

    public final long component6() {
        return this.startTime;
    }

    public final long component7() {
        return this.endTime;
    }

    public final long component8() {
        return this.serverTime;
    }

    public final String component9() {
        return this.cardImage;
    }

    public final PromotionActivity copy(String r110, String r111, String r112, String r113, String r210, long r211, long r212, long r213, String r214, String r215) {
        return new PromotionActivity(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionActivity) == false) goto L26;
        PromotionActivity r101 = (PromotionActivity) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.detailText, r101.detailText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L16;
        return false;
    L16:
        if (this.startTime == r101.startTime) goto L18;
        return false;
    L18:
        if (this.endTime == r101.endTime) goto L20;
        return false;
    L20:
        if (this.serverTime == r101.serverTime) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.cardImage, r101.cardImage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.logo, r101.logo) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.icon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.url;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.detailText;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.title;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        long r116 = this.startTime;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.endTime;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = this.serverTime;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        String r122 = this.cardImage;
        if (r122 == null) goto L25;
        int r123 = r122.hashCode();
    L26:
        int r124 = (r121 + r123) * 31;
        String r125 = this.logo;
        if (r125 == null) goto L30;
        r101 = r125.hashCode();
    L30:
        return r124 + r101;
    L25:
        r123 = 0;
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
        return "PromotionActivity(text=" + this.text + ", icon=" + this.icon + ", url=" + this.url + ", detailText=" + this.detailText + ", title=" + this.title + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", serverTime=" + this.serverTime + ", cardImage=" + this.cardImage + ", logo=" + this.logo + ")";
    }

    public final boolean canBeShown() {
        return !TextUtils.isEmpty(this.text);
    }

    public final String getCardImage() {
        return this.cardImage;
    }

    public final String getDetailText() {
        return this.detailText;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setCardImage(String r100) {
        this.cardImage = r100;
    }

    public final void setDetailText(String r100) {
        this.detailText = r100;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setIcon(String r100) {
        this.icon = r100;
    }

    public final void setLogo(String r100) {
        this.logo = r100;
    }

    public final void setServerTime(long r100) {
        this.serverTime = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public PromotionActivity(String r100, String r101, String r102, String r103, String r104, long r105, long r106, long r110, String r111, String r112) {
        this.text = r100;
        this.icon = r101;
        this.url = r102;
        this.detailText = r103;
        this.title = r104;
        this.startTime = r105;
        this.endTime = r106;
        this.serverTime = r110;
        this.cardImage = r111;
        this.logo = r112;
    }

    public /* synthetic */ PromotionActivity(String r110, String r111, String r112, String r113, String r114, long r210, long r211, long r212, String r213, String r214, int r215, DefaultConstructorMarker r216) {
        String r100 = "";
        if ((r215 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r215 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r215 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r215 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r215 & 16) == 0) goto L21;
        String r105 = "";
    L22:
        long r106 = 0;
        if ((r215 & 32) == 0) goto L25;
        long r115 = 0;
    L27:
        if ((r215 & 64) == 0) goto L29;
        long r116 = 0;
    L31:
        if ((r215 & 128) != 0) goto L35;
        r106 = r212;
    L35:
        if ((r215 & 256) == 0) goto L37;
        String r107 = "";
    L39:
        if ((r215 & 512) != 0) goto L42;
        r100 = r214;
    L42:
        this(r101, r102, r103, r104, r105, r115, r116, r106, r107, r100);
        return;
    L37:
        r107 = r213;
        goto L39
    L29:
        r116 = r211;
        goto L31
    L25:
        r115 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L22
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
