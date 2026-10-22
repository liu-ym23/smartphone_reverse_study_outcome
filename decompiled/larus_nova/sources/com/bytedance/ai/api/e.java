package com.bytedance.ai.api;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f34007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<d> f34010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f34011e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f34007a, r101.f34007a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34008b, r101.f34008b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34009c, r101.f34009c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34010d, r101.f34010d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f34011e, r101.f34011e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        b r100 = this.f34007a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((((r101 * 31) + this.f34008b.hashCode()) * 31) + this.f34009c.hashCode()) * 31) + this.f34010d.hashCode()) * 31) + this.f34011e.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "AppletBottomSheetConfig(appInfo=" + this.f34007a + ", title=" + this.f34008b + ", content=" + this.f34009c + ", buttons=" + this.f34010d + ", behavior=" + this.f34011e + ')';
    }

    public e(b r100, String r101, String r102, List<d> r103, c r104) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r103, "buttons");
        Intrinsics.checkNotNullParameter(r104, "behavior");
        this.f34007a = r100;
        this.f34008b = r101;
        this.f34009c = r102;
        this.f34010d = r103;
        this.f34011e = r104;
    }
}
