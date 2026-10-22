package com.bytedance.ai.debugscene;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f36303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f36304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f36305d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f36302a, r101.f36302a) == true) goto L12;
        return false;
    L12:
        if (this.f36303b == r101.f36303b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f36304c, r101.f36304c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f36305d, r101.f36305d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f36302a.hashCode() * 31;
        if (this.f36303b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f36304c;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return ((r102 + r104) * 31) + this.f36305d.hashCode();
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AIDebugCommandCompletion(action=" + this.f36302a + ", success=" + this.f36303b + ", message=" + this.f36304c + ", data=" + this.f36305d + ')';
    }

    public a(String r100, boolean r101, String r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r103, "data");
        this.f36302a = r100;
        this.f36303b = r101;
        this.f36304c = r102;
        this.f36305d = r103;
    }
}
