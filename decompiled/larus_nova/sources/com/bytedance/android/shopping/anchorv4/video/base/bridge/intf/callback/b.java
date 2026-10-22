package com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f167574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f167575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HeaderMediaModel f167576c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f167574a, r101.f167574a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f167575b, r101.f167575b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f167576c, r101.f167576c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        l r100 = this.f167574a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        s r104 = this.f167575b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        HeaderMediaModel r107 = this.f167576c;
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
        return "HeadVideoInfo(videoViewWrapper=" + this.f167574a + ", headAbility=" + this.f167575b + ", headerMediaModel=" + this.f167576c + ")";
    }

    public b(l r100, s r101, HeaderMediaModel r102) {
        Intrinsics.checkNotNullParameter(r101, "headAbility");
        Intrinsics.checkNotNullParameter(r102, "headerMediaModel");
        this.f167574a = r100;
        this.f167575b = r101;
        this.f167576c = r102;
    }
}
