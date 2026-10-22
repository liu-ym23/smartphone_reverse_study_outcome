package p7;

import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends m7.n {

    /* renamed from: d, reason: collision with root package name */
    public static final i f9873d = new i();

    /* renamed from: a, reason: collision with root package name */
    public HashMap f9874a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f9875b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f9876c;

    @Override // m7.n
    public final Object read(u7.a aVar) {
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        String strW = aVar.W();
        Enum r02 = (Enum) this.f9874a.get(strW);
        return r02 == null ? (Enum) this.f9875b.get(strW) : r02;
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        Enum r22 = (Enum) obj;
        cVar.S(r22 == null ? null : (String) this.f9876c.get(r22));
    }
}
