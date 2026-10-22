package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f173242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<InFeedProductV2> f173243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f173244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f173245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f173246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.deepfeed.data.a f173247f;

    public m() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L18;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f173242a, r101.f173242a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173243b, r101.f173243b) == true) goto L10;
        return false;
    L10:
        if (this.f173244c == r101.f173244c) goto L12;
        return false;
    L12:
        if (this.f173245d == r101.f173245d) goto L14;
        return false;
    L14:
        if (this.f173246e == r101.f173246e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f173247f, r101.f173247f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        Boolean r100 = this.f173242a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<InFeedProductV2> r104 = this.f173243b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f173244c;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f173245d;
        if (r111 == true) goto L17;
        r108 = r111;
    L17:
        int r112 = (((r110 + r108) * 31) + this.f173246e) * 31;
        com.bytedance.android.shopping.deepfeed.data.a r113 = this.f173247f;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedProductResponseState(success=" + this.f173242a + ", inFeedProductList=" + this.f173243b + ", hasMore=" + this.f173244c + ", isLoading=" + this.f173245d + ", netType=" + this.f173246e + ", cardUpdateState=" + this.f173247f + ")";
    }

    public m(Boolean r100, List r101, boolean r102, boolean r103, com.bytedance.android.shopping.deepfeed.data.a r104, int r105) {
        if ((r105 & 16) == 0) goto L5;
        int r106 = -1;
    L7:
        if ((r105 & 32) == 0) goto L9;
        r104 = new com.bytedance.android.shopping.deepfeed.data.a(false, 0, false, 7);
    L9:
        Intrinsics.checkNotNullParameter(r104, "cardUpdateState");
        this.f173242a = r100;
        this.f173243b = r101;
        this.f173244c = r102;
        this.f173245d = r103;
        this.f173246e = r106;
        this.f173247f = r104;
        return;
    L5:
        r106 = 0;
        goto L7
    }
}
