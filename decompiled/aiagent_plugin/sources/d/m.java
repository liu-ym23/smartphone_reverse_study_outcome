package d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m<A, B> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f38553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f38554b;

    public final A c() {
        return this.f38553a;
    }

    public final B d() {
        return this.f38554b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f38553a, r6.f38553a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f38554b, r6.f38554b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        A r0 = this.f38553a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        B r4 = this.f38554b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public m(A r1, B r2) {
        this.f38553a = r1;
        this.f38554b = r2;
    }

    public final A a() {
        return this.f38553a;
    }

    public final B b() {
        return this.f38554b;
    }

    public String toString() {
        return '(' + this.f38553a + ", " + this.f38554b + ')';
    }
}
