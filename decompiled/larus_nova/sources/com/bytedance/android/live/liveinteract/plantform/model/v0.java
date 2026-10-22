package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f77257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ILinkPlayerInfoBridge> f77258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SeiAppData f77259c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v0) == false) goto L12;
        v0 r101 = (v0) r100;
        if (this.f77257a == r101.f77257a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f77258b, r101.f77258b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f77259c, r101.f77259c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f77257a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<ILinkPlayerInfoBridge> r102 = this.f77258b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        SeiAppData r106 = this.f77259c;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return r105 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiLinkFeedStoreDataV2(roomId=" + this.f77257a + ", linkPlayerInfoList=" + this.f77258b + ", seiAppData=" + this.f77259c + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v0(long r100, List<? extends ILinkPlayerInfoBridge> r101, SeiAppData r102) {
        Intrinsics.checkNotNullParameter(r101, "linkPlayerInfoList");
        this.f77257a = r100;
        this.f77258b = r101;
        this.f77259c = r102;
    }
}
