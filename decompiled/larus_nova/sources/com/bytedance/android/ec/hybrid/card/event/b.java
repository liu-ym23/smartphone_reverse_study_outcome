package com.bytedance.android.ec.hybrid.card.event;

import java.util.Map;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Comparable<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f46483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f46485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f46486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f46487f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f46482a, r101.f46482a) == true) goto L8;
        return false;
    L8:
        if (this.f46483b == r101.f46483b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f46484c, r101.f46484c) == true) goto L12;
        return false;
    L12:
        if (this.f46485d == r101.f46485d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f46486e, r101.f46486e) == true) goto L16;
        return false;
    L16:
        if (this.f46487f == r101.f46487f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        String r100 = this.f46482a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f46483b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f46484c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f46485d;
        ?? r109 = 1;
        ?? r110 = r108;
        if (r108 == false) goto L13;
        r110 = 1;
    L13:
        int r111 = (r107 + r110) * 31;
        Map<String, Object> r112 = this.f46486e;
        if (r112 == null) goto L16;
        r101 = r112.hashCode();
    L16:
        int r113 = (r111 + r101) * 31;
        boolean r114 = this.f46487f;
        if (r114 == true) goto L21;
        r109 = r114;
    L21:
        return r113 + r109;
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECEvent(eventName=" + this.f46482a + ", timestamp=" + this.f46483b + ", sceneID=" + this.f46484c + ", isGlobal=" + this.f46485d + ", params=" + this.f46486e + ", isSticky=" + this.f46487f + ")";
    }

    @Override // java.lang.Comparable
    public final int compareTo(b r100) {
        b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        long r102 = this.f46483b;
        if (r102 != r101.f46483b) goto L7;
        return -1;
    L7:
        return ComparisonsKt.compareValues(Long.valueOf(r102), Long.valueOf(r101.f46483b));
    }

    public b(String r100, long r101, String r102, boolean r103, Map<String, ? extends Object> r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, "sceneID");
        this.f46482a = r100;
        this.f46483b = r101;
        this.f46484c = r102;
        this.f46485d = r103;
        this.f46486e = r104;
        this.f46487f = r105;
    }

    public /* synthetic */ b(String r110, long r111, String r112, boolean r113, Map r114, boolean r115, int r116) {
        if ((r116 & 8) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r116 & 16) == 0) goto L9;
        Map r101 = null;
    L11:
        if ((r116 & 32) == 0) goto L13;
        boolean r102 = false;
    L14:
        this(r110, r111, r112, r100, r101, r102);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
