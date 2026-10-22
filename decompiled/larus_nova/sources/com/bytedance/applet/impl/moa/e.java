package com.bytedance.applet.impl.moa;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f191980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f191981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f191982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f191983d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f191980a, r101.f191980a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f191981b, r101.f191981b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f191982c, r101.f191982c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f191983d, r101.f191983d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f191980a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f191981b.hashCode()) * 31;
        String r104 = this.f191982c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.f191983d.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MoaQuickReplyPayload(appletId=" + this.f191980a + ", authorizationID=" + this.f191981b + ", authExt=" + this.f191982c + ", serverOption=" + this.f191983d + ')';
    }

    public e(String r100, String r101, String r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r101, "authorizationID");
        Intrinsics.checkNotNullParameter(r103, "serverOption");
        this.f191980a = r100;
        this.f191981b = r101;
        this.f191982c = r102;
        this.f191983d = r103;
    }
}
