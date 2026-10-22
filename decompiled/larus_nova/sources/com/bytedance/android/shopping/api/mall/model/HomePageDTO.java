package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b6\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0001EB\u0081\u0001\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bB\u0010CJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rHÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0012\u0010\tJ\u008a\u0001\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\u0013\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010/\u001a\u0004\b0\u00101R$\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010/\u001a\u0004\b2\u00101\"\u0004\b3\u00104R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010-\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010A¨\u0006F"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/HomePageDTO;", "", "Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;", "component1", "", "component2", "", "component3", "component4", "()Ljava/lang/Integer;", "", "component5", "component6", "", "component7", "", "Lcom/bytedance/android/shopping/api/mall/model/ChunkedSectionData;", "component8", "component9", "bff", "hasMore", EffectConfiguration.KEY_CURSOR, "statusCode", "statusMessage", "chunkedSection", "serverTiming", "chunkDataList", "dataReuseStatus", "copy", "(Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;ZILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/model/HomePageDTO;", "toString", "hashCode", "other", "equals", "Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;", "getBff", "()Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;", "setBff", "(Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;)V", "Z", "getHasMore", "()Z", "I", "getCursor", "()I", "Ljava/lang/Integer;", "getStatusCode", "Ljava/lang/String;", "getStatusMessage", "()Ljava/lang/String;", "getChunkedSection", "setChunkedSection", "(Ljava/lang/String;)V", "Ljava/util/Map;", "getServerTiming", "()Ljava/util/Map;", "setServerTiming", "(Ljava/util/Map;)V", "Ljava/util/List;", "getChunkDataList", "()Ljava/util/List;", "setChunkDataList", "(Ljava/util/List;)V", "getDataReuseStatus", "setDataReuseStatus", "(Ljava/lang/Integer;)V", "<init>", "(Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;ZILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/Integer;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HomePageDTO {
    public static final a Companion = null;
    public static final int DATA_REUSE_AI_PREFETCH_EXPIRED = 1;
    public static final int DATA_REUSE_UNEXPOSED = 2;

    @SerializedName("bff_data")
    private HomePageBffDTO bff;

    @SerializedName("chunked_data_list")
    private List<ChunkedSectionData> chunkDataList;

    @SerializedName("chunked_section")
    private String chunkedSection;

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private final int cursor;

    @SerializedName("data_reuse_status")
    private Integer dataReuseStatus;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("server_time")
    private Map<String, ? extends Object> serverTiming;

    @SerializedName("status_code")
    private final Integer statusCode;

    @SerializedName("status_message")
    private final String statusMessage;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public HomePageDTO() {
        this(null, false, 0, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomePageDTO copy$default(HomePageDTO r110, HomePageBffDTO r111, boolean r112, int r113, Integer r114, String r115, String r116, Map r117, List r118, Integer r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        HomePageBffDTO r100 = r110.bff;
    L7:
        if ((r210 & 2) == 0) goto L9;
        boolean r101 = r110.hasMore;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = r110.cursor;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r103 = r110.statusCode;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.statusMessage;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.chunkedSection;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Map r106 = r110.serverTiming;
    L31:
        if ((r210 & 128) == 0) goto L33;
        List r107 = r110.chunkDataList;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Integer r108 = r110.dataReuseStatus;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
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

    public final HomePageBffDTO component1() {
        return this.bff;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final int component3() {
        return this.cursor;
    }

    public final Integer component4() {
        return this.statusCode;
    }

    public final String component5() {
        return this.statusMessage;
    }

    public final String component6() {
        return this.chunkedSection;
    }

    public final Map<String, Object> component7() {
        return this.serverTiming;
    }

    public final List<ChunkedSectionData> component8() {
        return this.chunkDataList;
    }

    public final Integer component9() {
        return this.dataReuseStatus;
    }

    public final HomePageDTO copy(HomePageBffDTO r110, boolean r111, int r112, Integer r113, String r114, String r115, Map<String, ? extends Object> r116, List<ChunkedSectionData> r117, Integer r210) {
        return new HomePageDTO(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HomePageDTO) == false) goto L24;
        HomePageDTO r101 = (HomePageDTO) r100;
        if (Intrinsics.areEqual(this.bff, r101.bff) == true) goto L8;
        return false;
    L8:
        if (this.hasMore == r101.hasMore) goto L10;
        return false;
    L10:
        if (this.cursor == r101.cursor) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statusCode, r101.statusCode) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.statusMessage, r101.statusMessage) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.chunkedSection, r101.chunkedSection) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.serverTiming, r101.serverTiming) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.chunkDataList, r101.chunkDataList) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.dataReuseStatus, r101.dataReuseStatus) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    public int hashCode() {
        HomePageBffDTO r100 = this.bff;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.hasMore;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (((r103 + r105) * 31) + this.cursor) * 31;
        Integer r107 = this.statusCode;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.statusMessage;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.chunkedSection;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        Map<String, ? extends Object> r116 = this.serverTiming;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        List<ChunkedSectionData> r119 = this.chunkDataList;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.dataReuseStatus;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        return r121 + r101;
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
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "HomePageDTO(bff=" + this.bff + ", hasMore=" + this.hasMore + ", cursor=" + this.cursor + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", chunkedSection=" + this.chunkedSection + ", serverTiming=" + this.serverTiming + ", chunkDataList=" + this.chunkDataList + ", dataReuseStatus=" + this.dataReuseStatus + ")";
    }

    public final HomePageBffDTO getBff() {
        return this.bff;
    }

    public final List<ChunkedSectionData> getChunkDataList() {
        return this.chunkDataList;
    }

    public final String getChunkedSection() {
        return this.chunkedSection;
    }

    public final int getCursor() {
        return this.cursor;
    }

    public final Integer getDataReuseStatus() {
        return this.dataReuseStatus;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final Map<String, Object> getServerTiming() {
        return this.serverTiming;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final void setBff(HomePageBffDTO r100) {
        this.bff = r100;
    }

    public final void setChunkDataList(List<ChunkedSectionData> r100) {
        this.chunkDataList = r100;
    }

    public final void setChunkedSection(String r100) {
        this.chunkedSection = r100;
    }

    public final void setDataReuseStatus(Integer r100) {
        this.dataReuseStatus = r100;
    }

    public final void setServerTiming(Map<String, ? extends Object> r100) {
        this.serverTiming = r100;
    }

    public HomePageDTO(HomePageBffDTO r100, boolean r101, int r102, Integer r103, String r104, String r105, Map<String, ? extends Object> r106, List<ChunkedSectionData> r107, Integer r108) {
        this.bff = r100;
        this.hasMore = r101;
        this.cursor = r102;
        this.statusCode = r103;
        this.statusMessage = r104;
        this.chunkedSection = r105;
        this.serverTiming = r106;
        this.chunkDataList = r107;
        this.dataReuseStatus = r108;
    }

    public /* synthetic */ HomePageDTO(HomePageBffDTO r110, boolean r111, int r112, Integer r113, String r114, String r115, Map r116, List r117, Integer r210, int r211, DefaultConstructorMarker r212) {
        List r100 = null;
        if ((r211 & 1) == 0) goto L5;
        HomePageBffDTO r101 = null;
    L7:
        if ((r211 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r211 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r211 & 8) == 0) goto L17;
        Integer r104 = 0;
    L19:
        if ((r211 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r211 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r211 & 64) == 0) goto L29;
        Map r107 = null;
    L31:
        if ((r211 & 128) != 0) goto L35;
        r100 = r117;
    L35:
        if ((r211 & 256) == 0) goto L37;
        Integer r108 = 0;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r100, r108);
        return;
    L37:
        r108 = r210;
        goto L38
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
