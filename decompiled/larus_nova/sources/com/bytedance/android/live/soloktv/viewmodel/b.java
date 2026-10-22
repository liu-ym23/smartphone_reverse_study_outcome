package com.bytedance.android.live.soloktv.viewmodel;

import com.bytedance.android.live.soloktv.controller.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f101875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f101876b;

    public b() {
        this(null, false, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f101875a, r101.f101875a) == true) goto L8;
        return false;
    L8:
        if (this.f101876b == r101.f101876b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        l r100 = this.f101875a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f101876b;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "MidiUIState(action=" + this.f101875a + ", midiReady=" + this.f101876b + ")";
    }

    public b(l r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this.f101875a = r100;
        this.f101876b = r101;
    }
}
