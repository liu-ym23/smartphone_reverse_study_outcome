package com.bytedance.android.shopping.anchorv4.launcher;

import android.net.Uri;
import com.bytedance.android.shopping.anchorv4.schemav2.o;
import com.bytedance.android.shopping.pre_purchase.arch.launch.j;
import kotlin.jvm.internal.Intrinsics;
import p83.h;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f167006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f167007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f167008c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f167006a, r101.f167006a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f167007b, r101.f167007b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f167008c, r101.f167008c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Uri r100 = this.f167006a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        h r104 = this.f167007b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        o r107 = this.f167008c;
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
        return "LaunchInput(schema=" + this.f167006a + ", pdpParams=" + this.f167007b + ", openPdpListener=" + this.f167008c + ")";
    }

    public a(Uri r100, h r101, o r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "pdpParams");
        Intrinsics.checkNotNullParameter(r102, "openPdpListener");
        this.f167006a = r100;
        this.f167007b = r101;
        this.f167008c = r102;
    }
}
