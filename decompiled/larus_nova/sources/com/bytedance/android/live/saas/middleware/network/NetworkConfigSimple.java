package com.bytedance.android.live.saas.middleware.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/network/NetworkConfigSimple;", "", "standalone", "", "cornet", "isCornet2B", "extraParamProvider", "Lcom/bytedance/android/live/saas/middleware/network/IExtraParamProvider;", "(ZZZLcom/bytedance/android/live/saas/middleware/network/IExtraParamProvider;)V", "getCornet", "()Z", "getExtraParamProvider", "()Lcom/bytedance/android/live/saas/middleware/network/IExtraParamProvider;", "getStandalone", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NetworkConfigSimple {
    private final boolean cornet;
    private final IExtraParamProvider extraParamProvider;
    private final boolean isCornet2B;
    private final boolean standalone;

    public static /* synthetic */ NetworkConfigSimple copy$default(NetworkConfigSimple r100, boolean r101, boolean r102, boolean r103, IExtraParamProvider r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.standalone;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.cornet;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.isCornet2B;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.extraParamProvider;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.standalone;
    }

    public final boolean component2() {
        return this.cornet;
    }

    public final boolean component3() {
        return this.isCornet2B;
    }

    public final IExtraParamProvider component4() {
        return this.extraParamProvider;
    }

    public final NetworkConfigSimple copy(boolean r100, boolean r101, boolean r102, IExtraParamProvider r103) {
        return new NetworkConfigSimple(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof NetworkConfigSimple) == false) goto L14;
        NetworkConfigSimple r101 = (NetworkConfigSimple) r100;
        if (this.standalone == r101.standalone) goto L8;
        return false;
    L8:
        if (this.cornet == r101.cornet) goto L10;
        return false;
    L10:
        if (this.isCornet2B == r101.isCornet2B) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraParamProvider, r101.extraParamProvider) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean r100 = this.standalone;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.cornet;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.isCornet2B;
        if (r107 == true) goto L12;
        r101 = r107;
    L12:
        int r108 = (r106 + r101) * 31;
        IExtraParamProvider r109 = this.extraParamProvider;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L17:
        return r108 + r110;
    L15:
        r110 = 0;
        goto L17
    }

    public String toString() {
        return "NetworkConfigSimple(standalone=" + this.standalone + ", cornet=" + this.cornet + ", isCornet2B=" + this.isCornet2B + ", extraParamProvider=" + this.extraParamProvider + ")";
    }

    public final boolean getCornet() {
        return this.cornet;
    }

    public final IExtraParamProvider getExtraParamProvider() {
        return this.extraParamProvider;
    }

    public final boolean getStandalone() {
        return this.standalone;
    }

    public final boolean isCornet2B() {
        return this.isCornet2B;
    }

    public NetworkConfigSimple(boolean r100, boolean r101, boolean r102, IExtraParamProvider r103) {
        this.standalone = r100;
        this.cornet = r101;
        this.isCornet2B = r102;
        this.extraParamProvider = r103;
    }

    public /* synthetic */ NetworkConfigSimple(boolean r100, boolean r101, boolean r102, IExtraParamProvider r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }
}
