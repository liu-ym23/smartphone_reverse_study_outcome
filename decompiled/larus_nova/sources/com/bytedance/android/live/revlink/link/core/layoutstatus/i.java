package com.bytedance.android.live.revlink.link.core.layoutstatus;

import com.bytedance.android.livesdk.link.model.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f98298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f98299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MainBackupStreamStatus f98300c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L12;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f98298a, r101.f98298a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f98299b, r101.f98299b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f98300c, r101.f98300c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f98298a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        p r104 = this.f98299b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        MainBackupStreamStatus r107 = this.f98300c;
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
        return "MainBackupStreamHandle(interactId=" + this.f98298a + ", linkUser=" + this.f98299b + ", status=" + this.f98300c + ")";
    }

    public i(String r100, p r101, MainBackupStreamStatus r102) {
        Intrinsics.checkNotNullParameter(r102, "status");
        this.f98298a = r100;
        this.f98299b = r101;
        this.f98300c = r102;
    }
}
