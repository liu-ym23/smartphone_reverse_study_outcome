package com.bytedance.android.shopping.anchorv4.bottom;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f165891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f165892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f165893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f165894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f165895e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L16;
        x r101 = (x) r100;
        if (this.f165891a == r101.f165891a) goto L8;
        return false;
    L8:
        if (this.f165892b == r101.f165892b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f165893c, r101.f165893c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f165894d, r101.f165894d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f165895e, r101.f165895e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        long r100 = this.f165891a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f165892b;
        ?? r103 = r102;
        if (r102 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r101 + r103) * 31;
        String r105 = this.f165893c;
        int r106 = 0;
        if (r105 == null) goto L8;
        int r107 = r105.hashCode();
    L9:
        int r108 = (r104 + r107) * 31;
        CompositeDisposable r109 = this.f165894d;
        if (r109 == null) goto L12;
        int r110 = r109.hashCode();
    L13:
        int r111 = (r108 + r110) * 31;
        Object r112 = this.f165895e;
        if (r112 == null) goto L17;
        r106 = r112.hashCode();
    L17:
        return r111 + r106;
    L12:
        r110 = 0;
        goto L13
    L8:
        r107 = 0;
        goto L9
    }

    public final String toString() {
        return "CollectNativeParam(pageResumeTime=" + this.f165891a + ", expanded=" + this.f165892b + ", location=" + this.f165893c + ", compositeDisposable=" + this.f165894d + ", descriptionVO=" + this.f165895e + ")";
    }

    public /* synthetic */ x(long r100, boolean r110, CompositeDisposable r111, Object r112) {
        this(r100, r110, "top", r111, r112);
    }

    public x(long r100, boolean r101, String r102, CompositeDisposable r103, Object r104) {
        Intrinsics.checkNotNullParameter(r102, "location");
        Intrinsics.checkNotNullParameter(r103, "compositeDisposable");
        this.f165891a = r100;
        this.f165892b = r101;
        this.f165893c = r102;
        this.f165894d = r103;
        this.f165895e = r104;
    }
}
