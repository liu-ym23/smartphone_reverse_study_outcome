package com.bytedance.android.anniex.detect;

import android.net.Uri;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a36.c f40675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Uri f40676d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f40673a, r101.f40673a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f40674b, r101.f40674b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f40675c, r101.f40675c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f40676d, r101.f40676d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f40673a.hashCode() * 31) + this.f40674b.hashCode()) * 31) + this.f40675c.hashCode()) * 31) + this.f40676d.hashCode();
    }

    public final String toString() {
        return "BlankDetectorItemConfig bdhmBid=" + this.f40673a + ", urlBase=" + this.f40674b;
    }

    public final a36.c getIdentifier() {
        return this.f40675c;
    }

    public e(String r100, String r101, a36.a r102, Uri r103) {
        Intrinsics.checkNotNullParameter(r100, "bdhmBid");
        Intrinsics.checkNotNullParameter(r101, "urlBase");
        Intrinsics.checkNotNullParameter(r102, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r103, "originUri");
        this.f40673a = r100;
        this.f40674b = r101;
        this.f40675c = r102;
        this.f40676d = r103;
    }
}
