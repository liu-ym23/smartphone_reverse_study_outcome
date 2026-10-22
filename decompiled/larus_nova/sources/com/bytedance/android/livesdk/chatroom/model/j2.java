package com.bytedance.android.livesdk.chatroom.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f106956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<r> f106957b;

    public j2() {
        ArrayList r100 = new ArrayList();
        this.f106956a = 3;
        this.f106957b = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j2) == false) goto L10;
        j2 r101 = (j2) r100;
        if (Intrinsics.areEqual(this.f106956a, r101.f106956a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f106957b, r101.f106957b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f106956a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<r> r104 = this.f106957b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MicDressButton(switch=" + this.f106956a + ", buttonInfo=" + this.f106957b + ")";
    }
}
