package androidx.core.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Pair.java */
/* JADX INFO: loaded from: classes.dex */
public class e<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f1371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f1372b;

    public e(F r1, S r2) {
        this.f1371a = r1;
        this.f1372b = r2;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, e.class) == true) goto L5;
        return false;
    L5:
        e r5 = (e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin");
        if (d.a(r5.f1371a, this.f1371a) == true) goto L8;
        return false;
    L8:
        if (d.a(r5.f1372b, this.f1372b) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        F r0 = this.f1371a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        S r3 = this.f1372b;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return r2 ^ r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Pair{" + this.f1371a + " " + this.f1372b + "}";
    }

    public static <A, B> e<A, B> a(A r1, B r2) {
        return new e(r1, r2);
    }
}
