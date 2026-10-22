package com.bytedance.ai.applet.login;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Object> f34761d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f34758a, r101.f34758a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34759b, r101.f34759b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34760c, r101.f34760c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34761d, r101.f34761d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f34758a.hashCode() * 31) + this.f34759b.hashCode()) * 31) + this.f34760c.hashCode()) * 31) + this.f34761d.hashCode();
    }

    public final String toString() {
        return "LocalQSMusicConfig(clientKey=" + this.f34758a + ", scope=" + this.f34759b + ", state=" + this.f34760c + ", traceInfo=" + this.f34761d + ')';
    }

    public i(String r100, String r101, String r102, HashMap<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "clientKey");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "state");
        Intrinsics.checkNotNullParameter(r103, "traceInfo");
        this.f34758a = r100;
        this.f34759b = r101;
        this.f34760c = r102;
        this.f34761d = r103;
    }
}
