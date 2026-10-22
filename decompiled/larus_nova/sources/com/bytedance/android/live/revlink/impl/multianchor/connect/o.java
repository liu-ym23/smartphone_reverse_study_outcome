package com.bytedance.android.live.revlink.impl.multianchor.connect;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f93204c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, String> f93205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f93206b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L10;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f93205a, r101.f93205a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f93206b, r101.f93206b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Map<Long, String> r100 = this.f93205a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f93206b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ForwardData(" + this.f93205a.keySet() + ", src=" + this.f93206b + ')';
    }

    public o(Map<Long, String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomMap");
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f93205a = r100;
        this.f93206b = r101;
    }
}
