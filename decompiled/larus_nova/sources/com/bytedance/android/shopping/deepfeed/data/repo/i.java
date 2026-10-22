package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f173197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InFeedProductV2 f173198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<InFeedProductV2> f173199c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L12;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f173197a, r101.f173197a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173198b, r101.f173198b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f173199c, r101.f173199c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f173197a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        InFeedProductV2 r104 = this.f173198b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<InFeedProductV2> r107 = this.f173199c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedCouponWaistRefreshResult(sessionId=" + this.f173197a + ", packCard=" + this.f173198b + ", feedCards=" + this.f173199c + ")";
    }

    public i(String r100, InFeedProductV2 r101, List<InFeedProductV2> r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "feedCards");
        this.f173197a = r100;
        this.f173198b = r101;
        this.f173199c = r102;
    }
}
