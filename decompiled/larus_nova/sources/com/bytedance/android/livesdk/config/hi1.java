package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/hi1;", "", "", EventConstant.Key.MODULE, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "enableTrace", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "openSlardar", "d", "openTea", "e", "openLiveTrace", "c", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class hi1 {

    @SerializedName("enable_trace")
    private final boolean enableTrace;

    @SerializedName(EventConstant.Key.MODULE)
    private final String module;

    @SerializedName("open_live_trace")
    private final boolean openLiveTrace;

    @SerializedName("open_slardar")
    private final boolean openSlardar;

    @SerializedName("open_tea")
    private final boolean openTea;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof hi1) == false) goto L16;
        hi1 r101 = (hi1) r100;
        if (Intrinsics.areEqual(this.module, r101.module) == true) goto L8;
        return false;
    L8:
        if (this.enableTrace == r101.enableTrace) goto L10;
        return false;
    L10:
        if (this.openSlardar == r101.openSlardar) goto L12;
        return false;
    L12:
        if (this.openTea == r101.openTea) goto L14;
        return false;
    L14:
        if (this.openLiveTrace == r101.openLiveTrace) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        String r100 = this.module;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.enableTrace;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.openSlardar;
        ?? r108 = r107;
        if (r107 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.openTea;
        ?? r111 = r110;
        if (r110 == false) goto L15;
        r111 = 1;
    L15:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.openLiveTrace;
        if (r113 == true) goto L20;
        r104 = r113;
    L20:
        return r112 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "TraceModuleConfig(module=" + this.module + ", enableTrace=" + this.enableTrace + ", openSlardar=" + this.openSlardar + ", openTea=" + this.openTea + ", openLiveTrace=" + this.openLiveTrace + ")";
    }

    public final boolean a() {
        return this.enableTrace;
    }

    public final String b() {
        return this.module;
    }

    public final boolean c() {
        return this.openLiveTrace;
    }

    public final boolean d() {
        return this.openSlardar;
    }

    public final boolean e() {
        return this.openTea;
    }
}
