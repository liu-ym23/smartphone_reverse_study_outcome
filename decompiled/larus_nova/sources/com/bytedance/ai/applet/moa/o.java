package com.bytedance.ai.applet.moa;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2.e f34866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f34867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<Context> f34869d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f34866a, r101.f34866a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34867b, r101.f34867b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34868c, r101.f34868c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34869d, r101.f34869d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f34866a.hashCode() * 31) + this.f34867b.hashCode()) * 31) + this.f34868c.hashCode()) * 31;
        WeakReference<Context> r101 = this.f34869d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MoaGrantingStepContext(grantingData=" + this.f34866a + ", request=" + this.f34867b + ", attemptID=" + this.f34868c + ", uiContextWk=" + this.f34869d + ')';
    }

    public o(u2.e r100, m r101, String r102, WeakReference<Context> r103) {
        Intrinsics.checkNotNullParameter(r100, "grantingData");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "attemptID");
        this.f34866a = r100;
        this.f34867b = r101;
        this.f34868c = r102;
        this.f34869d = r103;
    }
}
