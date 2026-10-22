package com.bytedance.android.ec.hybrid.monitor;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)¨\u0006-"}, d2 = {"Lcom/bytedance/android/ec/hybrid/monitor/b;", "", "", "pageName", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "cardName", "e", "setCardName", "cardUrl", "f", "setCardUrl", "", "cardIndex", "I", "d", "()I", "setCardIndex", "(I)V", "", "bindStartTime", "J", "c", "()J", "setBindStartTime", "(J)V", "bindEndTime", "b", "setBindEndTime", "bindDuration", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBindDuration", "", "isFirstBind", "Z", RXScreenCaptureService.KEY_INDEX, "()Z", "setFirstBind", "(Z)V", "isCacheData", "h", "setCacheData", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("bind_duration")
    private long bindDuration;

    @SerializedName("bind_end_time")
    private long bindEndTime;

    @SerializedName("bind_start_time")
    private long bindStartTime;

    @SerializedName("card_index")
    private int cardIndex;

    @SerializedName("card_name")
    private String cardName;

    @SerializedName("card_url")
    private String cardUrl;

    @SerializedName("is_cache_data")
    private boolean isCacheData;

    @SerializedName("is_first_bind")
    private boolean isFirstBind;

    @SerializedName("page_name")
    private String pageName;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L24;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cardName, r101.cardName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cardUrl, r101.cardUrl) == true) goto L12;
        return false;
    L12:
        if (this.cardIndex == r101.cardIndex) goto L14;
        return false;
    L14:
        if (this.bindStartTime == r101.bindStartTime) goto L16;
        return false;
    L16:
        if (this.bindEndTime == r101.bindEndTime) goto L18;
        return false;
    L18:
        if (this.bindDuration == r101.bindDuration) goto L20;
        return false;
    L20:
        if (this.isFirstBind == r101.isFirstBind) goto L22;
        return false;
    L22:
        if (this.isCacheData == r101.isCacheData) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        String r100 = this.pageName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.cardName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.cardUrl;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (((r106 + r101) * 31) + this.cardIndex) * 31;
        long r109 = this.bindStartTime;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.bindEndTime;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.bindDuration;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        boolean r115 = this.isFirstBind;
        ?? r116 = 1;
        ?? r117 = r115;
        if (r115 == false) goto L16;
        r117 = 1;
    L16:
        int r118 = (r114 + r117) * 31;
        boolean r119 = this.isCacheData;
        if (r119 == true) goto L21;
        r116 = r119;
    L21:
        return r118 + r116;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECHybridCardMonitorBean(pageName=" + this.pageName + ", cardName=" + this.cardName + ", cardUrl=" + this.cardUrl + ", cardIndex=" + this.cardIndex + ", bindStartTime=" + this.bindStartTime + ", bindEndTime=" + this.bindEndTime + ", bindDuration=" + this.bindDuration + ", isFirstBind=" + this.isFirstBind + ", isCacheData=" + this.isCacheData + ")";
    }

    public final long a() {
        return this.bindDuration;
    }

    public final long b() {
        return this.bindEndTime;
    }

    public final long c() {
        return this.bindStartTime;
    }

    public final int d() {
        return this.cardIndex;
    }

    public final String e() {
        return this.cardName;
    }

    public final String f() {
        return this.cardUrl;
    }

    public final String g() {
        return this.pageName;
    }

    public final boolean h() {
        return this.isCacheData;
    }

    public final boolean i() {
        return this.isFirstBind;
    }

    public /* synthetic */ b(int r110) {
        this("", "", "", -1, -1, -1, -1, true, false);
    }

    public b(String r100, String r101, String r102, int r103, long r104, long r105, long r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "cardName");
        Intrinsics.checkNotNullParameter(r102, "cardUrl");
        this.pageName = r100;
        this.cardName = r101;
        this.cardUrl = r102;
        this.cardIndex = r103;
        this.bindStartTime = r104;
        this.bindEndTime = r105;
        this.bindDuration = r110;
        this.isFirstBind = r111;
        this.isCacheData = r112;
    }
}
