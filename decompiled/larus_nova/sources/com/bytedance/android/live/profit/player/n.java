package com.bytedance.android.live.profit.player;

import com.bytedance.android.livesdkapi.depend.live.player.MaskSrc;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlayPriority f88341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<MaskSrc> f88342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<List<String>, Unit> f88343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f88344d;

    public n() {
        this(null, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L14;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f88341a, r101.f88341a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f88342b, r101.f88342b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f88343c, r101.f88343c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f88344d, r101.f88344d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        PlayPriority r100 = this.f88341a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<MaskSrc> r104 = this.f88342b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Function1<List<String>, Unit> r107 = this.f88343c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        l r110 = this.f88344d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Mp4PlayConfig(priority=" + this.f88341a + ", maskSrc=" + this.f88342b + ", onElementClick=" + this.f88343c + ", callback=" + this.f88344d + ")";
    }

    public n(List r100, Function1 r101, l r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        PlayPriority r104 = PlayPriority.Normal;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r100 = null;
    L10:
        if ((r103 & 4) == 0) goto L13;
        r101 = Mp4PlayConfig$1.INSTANCE;
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = new m();
    L15:
        Intrinsics.checkNotNullParameter(r104, "priority");
        Intrinsics.checkNotNullParameter(r101, "onElementClick");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f88341a = r104;
        this.f88342b = r100;
        this.f88343c = r101;
        this.f88344d = r102;
        return;
    L5:
        r104 = null;
        goto L7
    }
}
