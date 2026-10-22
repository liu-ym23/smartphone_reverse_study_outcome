package com.bytedance.android.live.saas.middleware.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/network/NetworkConfig;", "", "retrofit", "Lcom/bytedance/android/live/saas/middleware/network/IRetrofitProvider;", "standalone", "", "cornet", "isCornet2B", "extraParamProvider", "Lcom/bytedance/android/live/saas/middleware/network/IExtraParamProvider;", "(Lcom/bytedance/android/live/saas/middleware/network/IRetrofitProvider;ZZZLcom/bytedance/android/live/saas/middleware/network/IExtraParamProvider;)V", "getCornet", "()Z", "getExtraParamProvider", "()Lcom/bytedance/android/live/saas/middleware/network/IExtraParamProvider;", "getRetrofit", "()Lcom/bytedance/android/live/saas/middleware/network/IRetrofitProvider;", "getStandalone", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NetworkConfig {
    private final boolean cornet;
    private final IExtraParamProvider extraParamProvider;
    private final boolean isCornet2B;
    private final IRetrofitProvider retrofit;
    private final boolean standalone;

    public NetworkConfig(IRetrofitProvider r100, boolean r110) {
        this(r100, r110, false, false, null, 28, null);
    }

    public NetworkConfig(IRetrofitProvider r100, boolean r110, boolean r111) {
        this(r100, r110, r111, false, null, 24, null);
    }

    public NetworkConfig(IRetrofitProvider r100, boolean r110, boolean r111, boolean r112) {
        this(r100, r110, r111, r112, null, 16, null);
    }

    public static /* synthetic */ NetworkConfig copy$default(NetworkConfig r100, IRetrofitProvider r101, boolean r102, boolean r103, boolean r104, IExtraParamProvider r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.retrofit;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.standalone;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.cornet;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isCornet2B;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.extraParamProvider;
    L17:
        IRetrofitProvider r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final IRetrofitProvider component1() {
        return this.retrofit;
    }

    public final boolean component2() {
        return this.standalone;
    }

    public final boolean component3() {
        return this.cornet;
    }

    public final boolean component4() {
        return this.isCornet2B;
    }

    public final IExtraParamProvider component5() {
        return this.extraParamProvider;
    }

    public final NetworkConfig copy(IRetrofitProvider r100, boolean r101, boolean r110, boolean r111, IExtraParamProvider r112) {
        return new NetworkConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof NetworkConfig) == false) goto L16;
        NetworkConfig r101 = (NetworkConfig) r100;
        if (Intrinsics.areEqual(this.retrofit, r101.retrofit) == true) goto L8;
        return false;
    L8:
        if (this.standalone == r101.standalone) goto L10;
        return false;
    L10:
        if (this.cornet == r101.cornet) goto L12;
        return false;
    L12:
        if (this.isCornet2B == r101.isCornet2B) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extraParamProvider, r101.extraParamProvider) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        IRetrofitProvider r100 = this.retrofit;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.standalone;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.cornet;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.isCornet2B;
        if (r111 == true) goto L16;
        r105 = r111;
    L16:
        int r112 = (r110 + r105) * 31;
        IExtraParamProvider r113 = this.extraParamProvider;
        if (r113 == null) goto L20;
        r101 = r113.hashCode();
    L20:
        return r112 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "NetworkConfig(retrofit=" + this.retrofit + ", standalone=" + this.standalone + ", cornet=" + this.cornet + ", isCornet2B=" + this.isCornet2B + ", extraParamProvider=" + this.extraParamProvider + ")";
    }

    public final boolean getCornet() {
        return this.cornet;
    }

    public final IExtraParamProvider getExtraParamProvider() {
        return this.extraParamProvider;
    }

    public final IRetrofitProvider getRetrofit() {
        return this.retrofit;
    }

    public final boolean getStandalone() {
        return this.standalone;
    }

    public final boolean isCornet2B() {
        return this.isCornet2B;
    }

    public NetworkConfig(IRetrofitProvider r100, boolean r101, boolean r102, boolean r103, IExtraParamProvider r104) {
        this.retrofit = r100;
        this.standalone = r101;
        this.cornet = r102;
        this.isCornet2B = r103;
        this.extraParamProvider = r104;
    }

    public /* synthetic */ NetworkConfig(IRetrofitProvider r100, boolean r101, boolean r110, boolean r111, IExtraParamProvider r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 4) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r113 & 8) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r113 & 16) == 0) goto L13;
        r112 = null;
    L13:
        this(r100, r101, r102, r103, r112);
        return;
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }
}
