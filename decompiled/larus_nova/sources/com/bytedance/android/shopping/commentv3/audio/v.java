package com.bytedance.android.shopping.commentv3.audio;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f172643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f172644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IAction f172645c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L12;
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f172643a, r101.f172643a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f172644b, r101.f172644b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f172645c, r101.f172645c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f172643a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e r104 = this.f172644b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        IAction r107 = this.f172645c;
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
        return "PlayRequest(sliceId=" + this.f172643a + ", audioInfo=" + this.f172644b + ", onStopAction=" + this.f172645c + ")";
    }

    public v(String r100, e r101, IAction r102) {
        Intrinsics.checkNotNullParameter(r100, "sliceId");
        Intrinsics.checkNotNullParameter(r101, "audioInfo");
        this.f172643a = r100;
        this.f172644b = r101;
        this.f172645c = r102;
    }
}
