package a60;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001:\u0001@R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR*\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R*\u0010-\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010$\u001a\u0004\b.\u0010&\"\u0004\b/\u0010(R*\u00100\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010$\u001a\u0004\b1\u0010&\"\u0004\b2\u0010(R\"\u00103\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u000b\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR\"\u00106\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u000b\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\"\u0010<\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u000b\u001a\u0004\b=\u0010\r\"\u0004\b>\u0010\u000fR\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\b¨\u0006B"}, d2 = {"La60/e;", "", "", "enable", "Z", "e", "()Z", "setEnable", "(Z)V", "", "uploadStrategy", "I", ce.f26396k, "()I", "setUploadStrategy", "(I)V", "La60/a;", "batchConfig", "La60/a;", "b", "()La60/a;", "setBatchConfig", "(La60/a;)V", "La60/b;", "batchConfigV2", "La60/b;", "c", "()La60/b;", "setBatchConfigV2", "(La60/b;)V", "defaultExpire", "d", "setDefaultExpire", "", "La60/c;", "filterRules", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "setFilterRules", "(Ljava/util/List;)V", "", "eventBlockList", "getEventBlockList", "setEventBlockList", "businessBlockList", "getBusinessBlockList", "setBusinessBlockList", "productIdBlockList", "getProductIdBlockList", "setProductIdBlockList", "uploadRouteStrategy", ce.f26395j, "setUploadRouteStrategy", "maxPacketSize", "h", "setMaxPacketSize", "enableUselessLoopOpt", "f", "setEnableUselessLoopOpt", "maxUselessLoopCount", RXScreenCaptureService.KEY_INDEX, "setMaxUselessLoopCount", "asyncUpload", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAsyncUpload", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("async_upload")
    private boolean asyncUpload;

    @SerializedName("upload_strategy_batch_config")
    private a60.a batchConfig;

    @SerializedName("upload_strategy_batch_config_v2")
    private b batchConfigV2;

    @SerializedName("business_type_blocklist")
    private List<String> businessBlockList;

    @SerializedName("default_expire")
    private int defaultExpire;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_useless_loop_opt")
    private boolean enableUselessLoopOpt;

    @SerializedName("event_type_blocklist")
    private List<String> eventBlockList;

    @SerializedName("filter_rules")
    private List<c> filterRules;

    @SerializedName("max_packet_size")
    private int maxPacketSize;

    @SerializedName("max_useless_loop_count")
    private int maxUselessLoopCount;

    @SerializedName("product_id_blocklist")
    private List<String> productIdBlockList;

    @SerializedName("upload_route_strategy")
    private int uploadRouteStrategy;

    @SerializedName("upload_strategy")
    private int uploadStrategy;

    public static final class a {
    }

    static {
    }

    public e() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L34;
        e r101 = (e) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.uploadStrategy == r101.uploadStrategy) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.batchConfig, r101.batchConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.batchConfigV2, r101.batchConfigV2) == true) goto L14;
        return false;
    L14:
        if (this.defaultExpire == r101.defaultExpire) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.filterRules, r101.filterRules) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.eventBlockList, r101.eventBlockList) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.businessBlockList, r101.businessBlockList) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.productIdBlockList, r101.productIdBlockList) == true) goto L24;
        return false;
    L24:
        if (this.uploadRouteStrategy == r101.uploadRouteStrategy) goto L26;
        return false;
    L26:
        if (this.maxPacketSize == r101.maxPacketSize) goto L28;
        return false;
    L28:
        if (this.enableUselessLoopOpt == r101.enableUselessLoopOpt) goto L30;
        return false;
    L30:
        if (this.maxUselessLoopCount == r101.maxUselessLoopCount) goto L32;
        return false;
    L32:
        if (this.asyncUpload == r101.asyncUpload) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v30 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = ((r102 * 31) + this.uploadStrategy) * 31;
        a60.a r104 = this.batchConfig;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        b r108 = this.batchConfigV2;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (((r107 + r109) * 31) + this.defaultExpire) * 31;
        List<c> r111 = this.filterRules;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        List<String> r114 = this.eventBlockList;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        List<String> r117 = this.businessBlockList;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        List<String> r120 = this.productIdBlockList;
        if (r120 == null) goto L28;
        r105 = r120.hashCode();
    L28:
        int r121 = (((((r119 + r105) * 31) + this.uploadRouteStrategy) * 31) + this.maxPacketSize) * 31;
        boolean r122 = this.enableUselessLoopOpt;
        ?? r123 = r122;
        if (r122 == false) goto L31;
        r123 = 1;
    L31:
        int r124 = (((r121 + r123) * 31) + this.maxUselessLoopCount) * 31;
        boolean r125 = this.asyncUpload;
        if (r125 == true) goto L36;
        r101 = r125;
    L36:
        return r124 + r101;
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "TraceMonitorConfig(enable=" + this.enable + ", uploadStrategy=" + this.uploadStrategy + ", batchConfig=" + this.batchConfig + ", batchConfigV2=" + this.batchConfigV2 + ", defaultExpire=" + this.defaultExpire + ", filterRules=" + this.filterRules + ", eventBlockList=" + this.eventBlockList + ", businessBlockList=" + this.businessBlockList + ", productIdBlockList=" + this.productIdBlockList + ", uploadRouteStrategy=" + this.uploadRouteStrategy + ", maxPacketSize=" + this.maxPacketSize + ", enableUselessLoopOpt=" + this.enableUselessLoopOpt + ", maxUselessLoopCount=" + this.maxUselessLoopCount + ", asyncUpload=" + this.asyncUpload + ")";
    }

    public final boolean a() {
        return this.asyncUpload;
    }

    public final a60.a b() {
        return this.batchConfig;
    }

    public final b c() {
        return this.batchConfigV2;
    }

    public final int d() {
        return this.defaultExpire;
    }

    public final boolean e() {
        return this.enable;
    }

    public final boolean f() {
        return this.enableUselessLoopOpt;
    }

    public final List<c> g() {
        return this.filterRules;
    }

    public final int h() {
        return this.maxPacketSize;
    }

    public final int i() {
        return this.maxUselessLoopCount;
    }

    public final int j() {
        return this.uploadRouteStrategy;
    }

    public final int k() {
        return this.uploadStrategy;
    }

    public e(Object r100) {
        a60.a r101 = new a60.a(0);
        b r102 = new b(0);
        List<c> r103 = CollectionsKt.emptyList();
        List<String> r104 = CollectionsKt.emptyList();
        List<String> r105 = CollectionsKt.emptyList();
        List<String> r106 = CollectionsKt.emptyList();
        this.enable = false;
        this.uploadStrategy = 0;
        this.batchConfig = r101;
        this.batchConfigV2 = r102;
        this.defaultExpire = 30;
        this.filterRules = r103;
        this.eventBlockList = r104;
        this.businessBlockList = r105;
        this.productIdBlockList = r106;
        this.uploadRouteStrategy = 1;
        this.maxPacketSize = UnixStat.LINK_FLAG;
        this.enableUselessLoopOpt = false;
        this.maxUselessLoopCount = 3;
        this.asyncUpload = true;
    }
}
