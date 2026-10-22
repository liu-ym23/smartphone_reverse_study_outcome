package com.bytedance.android.livesdk.ktvimpl.multichorus.model;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MusicPanel f145933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f145934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f145935c;

    public a() {
        this(null, "", "");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f145933a, r101.f145933a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f145934b, r101.f145934b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f145935c, r101.f145935c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        MusicPanel r100 = this.f145933a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f145934b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f145935c;
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
        return "ApplyMultiChorusData(musicPanel=" + this.f145933a + ", clickPosition=" + this.f145934b + ", clickButton=" + this.f145935c + ")";
    }

    public a(MusicPanel r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "clickPosition");
        Intrinsics.checkNotNullParameter(r102, "clickButton");
        this.f145933a = r100;
        this.f145934b = r101;
        this.f145935c = r102;
    }
}
