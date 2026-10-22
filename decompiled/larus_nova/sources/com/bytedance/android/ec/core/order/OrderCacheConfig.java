package com.bytedance.android.ec.core.order;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001$B?\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\u0004HÆ\u0003JA\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00022\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0011\u001a\u00020\bHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b \u0010\u001b¨\u0006%"}, d2 = {"Lcom/bytedance/android/ec/core/order/OrderCacheConfig;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "", "", "component4", "component5", "cacheDuration", "cacheOpt", "cacheOrderCount", "nodeBlackList", "on", "copy", "toString", "hashCode", "", "other", "equals", "I", "getCacheDuration", "()I", "Z", "getCacheOpt", "()Z", "getCacheOrderCount", "Ljava/util/List;", "getNodeBlackList", "()Ljava/util/List;", "getOn", "<init>", "(IZILjava/util/List;Z)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCacheConfig implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f45283a = null;

    @SerializedName("cache_duration")
    private final int cacheDuration;

    @SerializedName("cache_opt")
    private final boolean cacheOpt;

    @SerializedName("cache_order_count")
    private final int cacheOrderCount;

    @SerializedName("node_black_list")
    private final List<String> nodeBlackList;

    /* JADX INFO: renamed from: on, reason: collision with root package name */
    @SerializedName("on")
    private final boolean f45284on;

    public static final class a {
        public a() {
        }
    }

    public OrderCacheConfig() {
        this(0, false, 0, null, false, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OrderCacheConfig copy$default(OrderCacheConfig r100, int r101, boolean r102, int r103, List r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.cacheDuration;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.cacheOpt;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.cacheOrderCount;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.nodeBlackList;
    L14:
        List r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.f45284on;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.cacheDuration;
    }

    public final boolean component2() {
        return this.cacheOpt;
    }

    public final int component3() {
        return this.cacheOrderCount;
    }

    public final List<String> component4() {
        return this.nodeBlackList;
    }

    public final boolean component5() {
        return this.f45284on;
    }

    public final OrderCacheConfig copy(int r100, boolean r101, int r110, List<String> r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r111, "nodeBlackList");
        return new OrderCacheConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OrderCacheConfig) == false) goto L16;
        OrderCacheConfig r101 = (OrderCacheConfig) r100;
        if (this.cacheDuration == r101.cacheDuration) goto L8;
        return false;
    L8:
        if (this.cacheOpt == r101.cacheOpt) goto L10;
        return false;
    L10:
        if (this.cacheOrderCount == r101.cacheOrderCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nodeBlackList, r101.nodeBlackList) == true) goto L14;
        return false;
    L14:
        if (this.f45284on == r101.f45284on) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r100 = this.cacheDuration * 31;
        boolean r101 = this.cacheOpt;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (((r100 + r103) * 31) + this.cacheOrderCount) * 31;
        List<String> r105 = this.nodeBlackList;
        if (r105 == null) goto L8;
        int r106 = r105.hashCode();
    L9:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f45284on;
        if (r108 == true) goto L14;
        r102 = r108;
    L14:
        return r107 + r102;
    L8:
        r106 = 0;
        goto L9
    }

    public String toString() {
        return "OrderCacheConfig(cacheDuration=" + this.cacheDuration + ", cacheOpt=" + this.cacheOpt + ", cacheOrderCount=" + this.cacheOrderCount + ", nodeBlackList=" + this.nodeBlackList + ", on=" + this.f45284on + ")";
    }

    static {
        Companion = new a();
        f45283a = CollectionsKt.listOf(new String[]{"after_render", "order_list_footer", "order_list_header_sticky", "order_list_scroll", "lower_price_recomendation"});
    }

    public final int getCacheDuration() {
        return this.cacheDuration;
    }

    public final boolean getCacheOpt() {
        return this.cacheOpt;
    }

    public final int getCacheOrderCount() {
        return this.cacheOrderCount;
    }

    public final List<String> getNodeBlackList() {
        return this.nodeBlackList;
    }

    public final boolean getOn() {
        return this.f45284on;
    }

    public OrderCacheConfig(int r100, boolean r101, int r102, List<String> r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r103, "nodeBlackList");
        this.cacheDuration = r100;
        this.cacheOpt = r101;
        this.cacheOrderCount = r102;
        this.nodeBlackList = r103;
        this.f45284on = r104;
    }

    public /* synthetic */ OrderCacheConfig(int r100, boolean r101, int r102, List r103, boolean r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = 86400;
    L5:
        boolean r106 = false;
        if ((r105 & 2) == 0) goto L8;
        boolean r111 = false;
    L10:
        if ((r105 & 4) == 0) goto L12;
        int r107 = 3;
    L14:
        if ((r105 & 8) == 0) goto L16;
        r103 = f45283a;
    L16:
        List r108 = r103;
        if ((r105 & 16) != 0) goto L20;
        r106 = r104;
    L20:
        this(r100, r111, r107, r108, r106);
        return;
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
