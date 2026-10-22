package d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class r<A, B, C> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f38686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f38687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C f38688c;

    public final A d() {
        return this.f38686a;
    }

    public final B e() {
        return this.f38687b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == true) goto L8;
        return false;
    L8:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f38686a, r6.f38686a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f38687b, r6.f38687b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f38688c, r6.f38688c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final C f() {
        return this.f38688c;
    }

    public int hashCode() {
        A r0 = this.f38686a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        B r4 = this.f38687b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        C r7 = this.f38688c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public r(A r1, B r2, C r3) {
        this.f38686a = r1;
        this.f38687b = r2;
        this.f38688c = r3;
    }

    public final A a() {
        return this.f38686a;
    }

    public final B b() {
        return this.f38687b;
    }

    public final C c() {
        return this.f38688c;
    }

    public String toString() {
        return '(' + this.f38686a + ", " + this.f38687b + ", " + this.f38688c + ')';
    }
}
