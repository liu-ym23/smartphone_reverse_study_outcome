package com.bytedance.android.gamecp.business.gamedetail.component.minigamebar;

import com.bytedance.ies.sve_core.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f54556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54557b;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.gamedetail.component.minigamebar.a$a, reason: collision with other inner class name */
    public static final class C0888a {
    }

    static {
    }

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f54556a == r101.f54556a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54557b, r101.f54557b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f54556a * 31;
        String r101 = this.f54557b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "InstantRunMiniGameIntent(enterFrom=" + this.f54556a + ", gameId=" + this.f54557b + ")";
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        this.f54556a = 2;
        this.f54557b = r100;
    }
}
