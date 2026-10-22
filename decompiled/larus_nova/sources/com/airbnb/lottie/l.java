package com.airbnb.lottie;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class l<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f24812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f24813b;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f24812a, this.f24813b});
    }

    public l(V r100) {
        this.f24812a = r100;
        this.f24813b = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        V r102 = this.f24812a;
        if (r102 != null) goto L11;
    L13:
        Throwable r103 = this.f24813b;
        if (r103 != null) goto L16;
    L19:
        return false;
    L16:
        if (r101.f24813b == null) goto L19;
        return r103.toString().equals(this.f24813b.toString());
    L11:
        if (r102.equals(r101.f24812a) == false) goto L13;
        return true;
    }

    public l(Throwable r100) {
        this.f24813b = r100;
        this.f24812a = null;
    }
}
