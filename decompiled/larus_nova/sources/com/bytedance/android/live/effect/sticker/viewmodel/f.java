package com.bytedance.android.live.effect.sticker.viewmodel;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StickerPreviewStatus f68824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Sticker f68825b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f68824a, r101.f68824a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f68825b, r101.f68825b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        StickerPreviewStatus r100 = this.f68824a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Sticker r104 = this.f68825b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StickerPreviewStatusInfo(status=" + this.f68824a + ", sticker=" + this.f68825b + ")";
    }

    public f(StickerPreviewStatus r100, Sticker r101) {
        Intrinsics.checkNotNullParameter(r100, "status");
        this.f68824a = r100;
        this.f68825b = r101;
    }
}
