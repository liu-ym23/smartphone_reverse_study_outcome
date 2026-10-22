package d8;

import java.io.Serializable;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d0 implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final int f1976a;

    public d0(int i8) {
        w2.c(i8, "code");
        this.f1976a = i8;
    }

    public abstract void a(u uVar);

    public abstract String b();

    public abstract void c(b0.j jVar);

    public final boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        if (this.f1976a != d0Var.f1976a) {
            return false;
        }
        b0.j jVar = new b0.j(2);
        c(jVar);
        byte[] bArrF = jVar.f();
        b0.j jVar2 = new b0.j(2);
        d0Var.c(jVar2);
        return Arrays.equals(bArrF, jVar2.f());
    }

    public final int hashCode() {
        b0.j jVar = new b0.j(2);
        c(jVar);
        int i8 = 0;
        for (byte b9 : jVar.f()) {
            i8 += (i8 << 3) + (b9 & 255);
        }
        return i8;
    }

    public final String toString() {
        return "{" + c0.f1963a.d(this.f1976a) + ": " + b() + "}";
    }
}
