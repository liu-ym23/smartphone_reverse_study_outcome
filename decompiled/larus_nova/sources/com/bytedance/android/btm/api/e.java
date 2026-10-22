package com.bytedance.android.btm.api;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Object> f41973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f41974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f41975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f41976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f41977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f41978f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f41973a, r101.f41973a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f41974b, r101.f41974b) == true) goto L10;
        return false;
    L10:
        if (this.f41975c == r101.f41975c) goto L12;
        return false;
    L12:
        if (this.f41976d == r101.f41976d) goto L14;
        return false;
    L14:
        if (this.f41977e == r101.f41977e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f41978f, r101.f41978f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        WeakReference<Object> r100 = this.f41973a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f41974b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f41975c;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f41976d;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f41977e;
        if (r114 == true) goto L20;
        r108 = r114;
    L20:
        int r115 = (r113 + r108) * 31;
        String r116 = this.f41978f;
        if (r116 == null) goto L24;
        r101 = r116.hashCode();
    L24:
        return r115 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BtmPageInstance(pageRef=" + this.f41973a + ", btm=" + this.f41974b + ", auto=" + this.f41975c + ", singleton=" + this.f41976d + ", reuse=" + this.f41977e + ", sourceBtmToken=" + this.f41978f + ")";
    }

    public /* synthetic */ e(WeakReference r100, String r101, boolean r110, String r111, int r112) {
        if ((r112 & 2) == 0) goto L5;
        r101 = "";
    L5:
        String r102 = r101;
        if ((r112 & 4) == 0) goto L8;
        boolean r103 = true;
    L10:
        if ((r112 & 32) == 0) goto L12;
        r111 = null;
    L12:
        this(r100, r102, r103, false, false, r111);
        return;
    L8:
        r103 = r110;
        goto L10
    }

    public e(WeakReference<Object> r100, String r101, boolean r102, boolean r103, boolean r104, String r105) {
        this.f41973a = r100;
        this.f41974b = r101;
        this.f41975c = r102;
        this.f41976d = r103;
        this.f41977e = r104;
        this.f41978f = r105;
    }
}
