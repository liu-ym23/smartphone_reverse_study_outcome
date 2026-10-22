package com.bytedance.android.anniex.scene.next;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f41279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Double f41280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Double f41281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f41282e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f41278a, r101.f41278a) == true) goto L12;
        return false;
    L12:
        if (this.f41279b == r101.f41279b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f41280c, r101.f41280c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f41281d, r101.f41281d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f41282e, r101.f41282e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f41278a.hashCode() * 31;
        if (this.f41279b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        Double r103 = this.f41280c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        Double r107 = this.f41281d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.f41282e;
        if (r110 == null) goto L19;
        r104 = r110.hashCode();
    L19:
        return r109 + r104;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SceneRepeatInput(currentSceneId=" + this.f41278a + ", isFirstShow=" + this.f41279b + ", avgDuration=" + this.f41280c + ", repeatRate=" + this.f41281d + ", extraParams=" + this.f41282e + ')';
    }

    public f(String r100, boolean r101, Double r102, Double r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "currentSceneId");
        this.f41278a = r100;
        this.f41279b = r101;
        this.f41280c = r102;
        this.f41281d = r103;
        this.f41282e = r104;
    }
}
