package com.bytedance.android.live.saas.middleware.npth;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/npth/NpthConfig;", "", "standalone", "", "isToBVersion", "appId", "", "params", "", "(ZZLjava/lang/String;Ljava/util/Map;)V", "getAppId", "()Ljava/lang/String;", "()Z", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "getStandalone", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NpthConfig {
    private final String appId;
    private final boolean isToBVersion;
    private Map<String, ? extends Object> params;
    private final boolean standalone;

    public NpthConfig() {
        this(false, false, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NpthConfig copy$default(NpthConfig r100, boolean r101, boolean r102, String r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.standalone;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.isToBVersion;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.appId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.params;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.standalone;
    }

    public final boolean component2() {
        return this.isToBVersion;
    }

    public final String component3() {
        return this.appId;
    }

    public final Map<String, Object> component4() {
        return this.params;
    }

    public final NpthConfig copy(boolean r100, boolean r101, String r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r103, "params");
        return new NpthConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof NpthConfig) == false) goto L14;
        NpthConfig r101 = (NpthConfig) r100;
        if (this.standalone == r101.standalone) goto L8;
        return false;
    L8:
        if (this.isToBVersion == r101.isToBVersion) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        boolean r100 = this.standalone;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.isToBVersion;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        String r106 = this.appId;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (r105 + r108) * 31;
        Map<String, ? extends Object> r110 = this.params;
        if (r110 == null) goto L17;
        r107 = r110.hashCode();
    L17:
        return r109 + r107;
    L12:
        r108 = 0;
        goto L13
    }

    public String toString() {
        return "NpthConfig(standalone=" + this.standalone + ", isToBVersion=" + this.isToBVersion + ", appId=" + this.appId + ", params=" + this.params + ")";
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final boolean getStandalone() {
        return this.standalone;
    }

    public final boolean isToBVersion() {
        return this.isToBVersion;
    }

    public final void setParams(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.params = r100;
    }

    public NpthConfig(boolean r100, boolean r101, String r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r103, "params");
        this.standalone = r100;
        this.isToBVersion = r101;
        this.appId = r102;
        this.params = r103;
    }

    public /* synthetic */ NpthConfig(boolean r100, boolean r101, String r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = MapsKt.emptyMap();
    L14:
        this(r100, r101, r102, r103);
    }
}
