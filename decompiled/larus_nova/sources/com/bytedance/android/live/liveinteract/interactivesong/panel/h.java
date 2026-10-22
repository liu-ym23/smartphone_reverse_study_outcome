package com.bytedance.android.live.liveinteract.interactivesong.panel;

import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f74150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IOrderSingMVInfo f74151b;

    public h() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f74150a, r101.f74150a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f74151b, r101.f74151b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f74150a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        IOrderSingMVInfo r104 = this.f74151b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MvSelectedBean(tabName=" + this.f74150a + ", mvInfo=" + this.f74151b + ")";
    }

    public h(String r100, IOrderSingMVInfo r101) {
        this.f74150a = r100;
        this.f74151b = r101;
    }
}
