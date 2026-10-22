package k4;

import java.util.Set;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j implements a0 {

    /* renamed from: c, reason: collision with root package name */
    public static final j f3624c = new j();

    @Override // r4.j
    public final Set a() {
        return c5.u.f1094a;
    }

    @Override // r4.j
    public final void b(p5.p pVar) {
        v.x(this, pVar);
    }

    @Override // r4.j
    public final boolean c() {
        return true;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a0) && ((a0) obj).isEmpty();
    }

    @Override // r4.j
    public final boolean isEmpty() {
        return true;
    }

    public final String toString() {
        return "Parameters " + c5.u.f1094a;
    }
}
