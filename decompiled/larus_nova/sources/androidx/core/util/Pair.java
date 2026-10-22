package androidx.core.util;

import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes3.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public int hashCode() {
        F r100 = this.first;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        S r103 = this.second;
        if (r103 == null) goto L11;
        r101 = r103.hashCode();
    L11:
        return r102 ^ r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "Pair{" + this.first + " " + this.second + i.f25855d;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Pair) == true) goto L5;
        return false;
    L5:
        Pair r101 = (Pair) r100;
        if (ObjectsCompat.equals(r101.first, this.first) == true) goto L8;
        return false;
    L8:
        if (ObjectsCompat.equals(r101.second, this.second) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public Pair(F r100, S r101) {
        this.first = r100;
        this.second = r101;
    }

    public static <A, B> Pair<A, B> create(A r100, B r101) {
        return new Pair(r100, r101);
    }
}
