package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f77488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f77489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkApplyType f77490c;

    public i0() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i0) == false) goto L12;
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f77488a, r101.f77488a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f77489b, r101.f77489b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f77490c, r101.f77490c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f77488a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f77489b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LinkApplyType r107 = this.f77490c;
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
        return "PreApplyData(fromSource=" + this.f77488a + ", applySource=" + this.f77489b + ", applyType=" + this.f77490c + ")";
    }

    public i0(String r100, Integer r101, LinkApplyType r102) {
        this.f77488a = r100;
        this.f77489b = r101;
        this.f77490c = r102;
    }
}
