package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected;

import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f145079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f145080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f145081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, k> f145082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f145083e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (this.f145079a == r101.f145079a) goto L8;
        return false;
    L8:
        if (this.f145080b == r101.f145080b) goto L10;
        return false;
    L10:
        if (this.f145081c == r101.f145081c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f145082d, r101.f145082d) == true) goto L14;
        return false;
    L14:
        if (this.f145083e == r101.f145083e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f145079a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f145080b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f145081c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        HashMap<String, k> r110 = this.f145082d;
        if (r110 == null) goto L14;
        int r111 = r110.hashCode();
    L15:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f145083e;
        if (r113 == true) goto L20;
        r101 = r113;
    L20:
        return r112 + r101;
    L14:
        r111 = 0;
        goto L15
    }

    public final String toString() {
        return "ExtraMusicData(isAdmin=" + this.f145079a + ", isInChorus=" + this.f145080b + ", multiChorusJoined=" + this.f145081c + ", multiChorusInfo=" + this.f145082d + ", firstSongHasNoCopyright=" + this.f145083e + ")";
    }

    public final boolean a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "newData");
        if (this.f145083e == r100.f145083e) goto L6;
        return false;
    L6:
        if (((Boolean) h.f556164k1.getValue(null, h.f556082a[113(0x71, float:1.58E-43)])).booleanValue() == false) goto L18;
        if (this.f145079a == r100.f145079a) goto L10;
        return false;
    L10:
        if (this.f145080b == r100.f145080b) goto L12;
        return false;
    L12:
        if (this.f145081c == r100.f145081c) goto L14;
        return false;
    L14:
        if (KtvUtilsKt.r(this.f145082d, r100.f145082d) == false) goto L26;
        return true;
    L26:
        return false;
    L18:
        if (this.f145079a == r100.f145079a) goto L20;
        return false;
    L20:
        if (this.f145080b != r100.f145080b) goto L28;
        return true;
    L28:
        return false;
    }

    public a(boolean r100, boolean r101, boolean r102, HashMap<String, k> r103, boolean r104) {
        this.f145079a = r100;
        this.f145080b = r101;
        this.f145081c = r102;
        this.f145082d = r103;
        this.f145083e = r104;
    }
}
