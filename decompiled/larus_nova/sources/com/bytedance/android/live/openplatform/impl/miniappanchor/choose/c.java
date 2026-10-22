package com.bytedance.android.live.openplatform.impl.miniappanchor.choose;

import kotlin.jvm.internal.Intrinsics;
import mh1.p;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f84112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f84113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f84114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f84115d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f84112a, r101.f84112a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f84113b, r101.f84113b) == true) goto L10;
        return false;
    L10:
        if (this.f84114c == r101.f84114c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f84115d, r101.f84115d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        String r100 = this.f84112a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f84113b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f84114c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        p r110 = this.f84115d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MiniAppChooseStartParameter(clickSource=" + this.f84112a + ", liveType=" + this.f84113b + ", supportTalent=" + this.f84114c + ", miniAppOuterHelper=" + this.f84115d + ")";
    }

    public c(String r100, String r101, boolean r102, p r103) {
        Intrinsics.checkNotNullParameter(r100, "clickSource");
        Intrinsics.checkNotNullParameter(r101, "liveType");
        this.f84112a = r100;
        this.f84113b = r101;
        this.f84114c = r102;
        this.f84115d = r103;
    }
}
