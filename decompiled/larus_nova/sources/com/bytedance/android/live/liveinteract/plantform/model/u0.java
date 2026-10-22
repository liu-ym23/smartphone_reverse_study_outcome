package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f77254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0 f77255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SeiAppData f77256c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u0) == false) goto L12;
        u0 r101 = (u0) r100;
        if (this.f77254a == r101.f77254a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f77255b, r101.f77255b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f77256c, r101.f77256c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f77254a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        w0 r102 = this.f77255b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        SeiAppData r106 = this.f77256c;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return r105 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiLinkFeedStoreData(roomId=" + this.f77254a + ", responseData=" + this.f77255b + ", seiAppData=" + this.f77256c + ")";
    }

    public u0(long r100, w0 r101, SeiAppData r102) {
        Intrinsics.checkNotNullParameter(r101, OnekeyLoginConstants.CT_KEY_RSP_DATA);
        this.f77254a = r100;
        this.f77255b = r101;
        this.f77256c = r102;
    }
}
