package com.bytedance.android.live.effect.sticker.viewmodel;

import com.bytedance.android.livesdkapi.depend.model.StickerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f68826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StickerType f68828c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (this.f68826a == r101.f68826a) goto L8;
        return false;
    L8:
        if (this.f68827b == r101.f68827b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f68828c, r101.f68828c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f68826a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f68827b) * 31;
        StickerType r102 = this.f68828c;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "StickerShowParamsV2(stickerId=" + this.f68826a + ", position=" + this.f68827b + ", stickerType=" + this.f68828c + ")";
    }

    public g(long r100, int r101, StickerType r102) {
        Intrinsics.checkNotNullParameter(r102, "stickerType");
        this.f68826a = r100;
        this.f68827b = r101;
        this.f68828c = r102;
    }
}
