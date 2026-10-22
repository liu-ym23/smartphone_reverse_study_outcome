package com.bytedance.android.livesdk.ktvimpl.mv;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f146077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f146078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f146079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f146080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f146081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f146082f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f146082f, ((m) r100).f146082f) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f146082f;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "MvReportEvent(vId=" + this.f146082f + ")";
    }

    public m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "vId");
        this.f146082f = r100;
    }
}
