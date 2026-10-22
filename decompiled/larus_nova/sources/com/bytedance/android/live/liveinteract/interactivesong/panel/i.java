package com.bytedance.android.live.liveinteract.interactivesong.panel;

import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IOrderSingMVInfo f74152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f74153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f74154c;

    public i() {
        this(null, 0, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L12;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f74152a, r101.f74152a) == true) goto L8;
        return false;
    L8:
        if (this.f74153b == r101.f74153b) goto L10;
        return false;
    L10:
        if (this.f74154c == r101.f74154c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        IOrderSingMVInfo r100 = this.f74152a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f74153b;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return ((r102 + r104) * 31) + this.f74154c;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSingMvPanel(mvInfo=" + this.f74152a + ", isSelected=" + this.f74153b + ", playStatus=" + this.f74154c + ")";
    }

    public i(IOrderSingMVInfo r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = 0;
    L8:
        this.f74152a = r100;
        this.f74153b = false;
        this.f74154c = r101;
    }
}
