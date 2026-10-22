package c6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final i f1140a = new i();

    public static c a(int i8, a aVar, int i9) {
        if ((i9 & 2) != 0) {
            aVar = a.f1102a;
        }
        if (i8 == -2) {
            if (aVar != a.f1102a) {
                return new n(1, aVar);
            }
            g.f1138i.getClass();
            return new c(f.f1137b);
        }
        if (i8 != -1) {
            return i8 != 0 ? i8 != Integer.MAX_VALUE ? aVar == a.f1102a ? new c(i8) : new n(i8, aVar) : new c(Integer.MAX_VALUE) : aVar == a.f1102a ? new c(0) : new n(1, aVar);
        }
        if (aVar == a.f1102a) {
            return new n(1, a.f1103b);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }
}
