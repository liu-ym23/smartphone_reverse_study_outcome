package com.bytedance.android.sdk.bdticketguard.data;

import com.bytedance.android.sdk.bdticketguard.l1;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f163619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f163620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f163621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f163622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l1 f163623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l1 f163624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f163625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f163626h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f163627i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f163628j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<? extends Pair<String, ? extends Throwable>> f163629k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f163630l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f163631m;

    public g() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L49:
        return true;
    L5:
        if ((r100 instanceof g) == false) goto L48;
        g r101 = (g) r100;
        if (this.f163619a != r101.f163619a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L48;
        if (Intrinsics.areEqual(this.f163620b, r101.f163620b) == false) goto L48;
        if (this.f163621c != r101.f163621c) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L48;
        if (this.f163622d != r101.f163622d) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L48;
        if (Intrinsics.areEqual(this.f163623e, r101.f163623e) == false) goto L48;
        if (Intrinsics.areEqual(this.f163624f, r101.f163624f) == false) goto L48;
        if (Intrinsics.areEqual(this.f163625g, r101.f163625g) == false) goto L48;
        if (Intrinsics.areEqual(this.f163626h, r101.f163626h) == false) goto L48;
        if (this.f163627i != r101.f163627i) goto L34;
        boolean r105 = true;
    L35:
        if (r105 == false) goto L48;
        if (this.f163628j != r101.f163628j) goto L39;
        boolean r106 = true;
    L40:
        if (r106 == false) goto L48;
        if (Intrinsics.areEqual(this.f163629k, r101.f163629k) == false) goto L48;
        if (Intrinsics.areEqual(this.f163630l, r101.f163630l) == false) goto L48;
        if (Intrinsics.areEqual(this.f163631m, r101.f163631m) == false) goto L48;
    L39:
        r106 = false;
        goto L40
    L34:
        r105 = false;
        goto L35
    L21:
        r104 = false;
        goto L22
    L16:
        r103 = false;
        goto L17
    L9:
        r102 = false;
    L48:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f163619a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f163620b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f163621c;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f163622d;
        if (r111 == true) goto L16;
        r101 = r111;
    L16:
        int r112 = (r110 + r101) * 31;
        l1 r113 = this.f163623e;
        if (r113 == null) goto L19;
        int r114 = r113.hashCode();
    L20:
        int r115 = (r112 + r114) * 31;
        l1 r116 = this.f163624f;
        if (r116 == null) goto L23;
        int r117 = r116.hashCode();
    L24:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.f163625g;
        if (r119 == null) goto L27;
        int r120 = r119.hashCode();
    L28:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f163626h;
        if (r122 == null) goto L31;
        int r123 = r122.hashCode();
    L32:
        int r124 = (((r121 + r123) * 31) + this.f163627i) * 31;
        long r125 = this.f163628j;
        int r126 = (r124 + ((int) (r125 ^ (r125 >>> 32)))) * 31;
        List<? extends Pair<String, ? extends Throwable>> r127 = this.f163629k;
        if (r127 == null) goto L35;
        int r128 = r127.hashCode();
    L36:
        int r129 = (r126 + r128) * 31;
        Boolean r130 = this.f163630l;
        if (r130 == null) goto L39;
        int r131 = r130.hashCode();
    L40:
        int r132 = (r129 + r131) * 31;
        String r133 = this.f163631m;
        if (r133 == null) goto L44;
        r105 = r133.hashCode();
    L44:
        return r132 + r105;
    L39:
        r131 = 0;
        goto L40
    L35:
        r128 = 0;
        goto L36
    L31:
        r123 = 0;
        goto L32
    L27:
        r120 = 0;
        goto L28
    L23:
        r117 = 0;
        goto L24
    L19:
        r114 = 0;
        goto L20
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "TeeKeyLoadData(isLoadSeparated=" + this.f163619a + ", loadStage=" + this.f163620b + ", pubKeyResult=" + this.f163621c + ", privKeyResult=" + this.f163622d + ", loadPrivateKeySystemResult=" + this.f163623e + ", loadPublicKeySystemResult=" + this.f163624f + ", keyPairRecoveryEnabledMethods=" + this.f163625g + ", keyPairSource=" + this.f163626h + ", keyPairSourceIndex=" + this.f163627i + ", fixKeyPairDurationNs=" + this.f163628j + ", failedKeyRecoveryMethods=" + this.f163629k + ", recoveredWithSpPublicKey=" + this.f163630l + ", recoveryPhaseTimes=" + this.f163631m + ")";
    }

    public g(Object r100) {
        List<String> r101 = CollectionsKt.emptyList();
        List<? extends Pair<String, ? extends Throwable>> r102 = CollectionsKt.emptyList();
        this.f163619a = false;
        this.f163620b = "";
        this.f163621c = false;
        this.f163622d = false;
        this.f163623e = null;
        this.f163624f = null;
        this.f163625g = r101;
        this.f163626h = "none";
        this.f163627i = -1;
        this.f163628j = 0;
        this.f163629k = r102;
        this.f163630l = null;
        this.f163631m = "";
    }
}
