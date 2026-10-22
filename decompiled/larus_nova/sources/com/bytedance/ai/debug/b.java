package com.bytedance.ai.debug;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f36196d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f36197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f36198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f36199c;

    public static final class a {
        public static b a(String r100) {
            return new b(true, true, r100);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f36197a == r101.f36197a) goto L12;
        return false;
    L12:
        if (this.f36198b == r101.f36198b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f36199c, r101.f36199c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f36197a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f36198b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        String r104 = this.f36199c;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AIDebugCommandResult(handled=" + this.f36197a + ", success=" + this.f36198b + ", message=" + this.f36199c + ')';
    }

    public b(boolean r100, boolean r101, String r102) {
        this.f36197a = r100;
        this.f36198b = r101;
        this.f36199c = r102;
    }
}
