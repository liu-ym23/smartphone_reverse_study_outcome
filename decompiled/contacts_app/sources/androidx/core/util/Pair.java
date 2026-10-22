package androidx.core.util;

import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F r1, S r2) {
        this.first = r1;
        this.second = r2;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof Pair) == true) goto L5;
        return false;
    L5:
        Pair r5 = (Pair) r4;
        if (ObjectsCompat.equals(r5.first, this.first) == true) goto L8;
        return false;
    L8:
        if (ObjectsCompat.equals(r5.second, this.second) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        F r0 = this.first;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        S r3 = this.second;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return r2 ^ r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Pair{" + this.first + HanziToPinyin.Token.SEPARATOR + this.second + "}";
    }

    public static <A, B> Pair<A, B> create(A r1, B r2) {
        return new Pair(r1, r2);
    }
}
