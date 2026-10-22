package tc;

import kotlin.uuid.Uuid;
import rc.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p1 implements pc.a<Uuid> {

    /* renamed from: a, reason: collision with root package name */
    public static final p1 f13031a = new p1();

    /* renamed from: b, reason: collision with root package name */
    public static final v0 f13032b = new v0("kotlin.uuid.Uuid", d.i.f11785a);

    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        Uuid value = (Uuid) obj;
        kotlin.jvm.internal.g.f(value, "value");
        kVar.B(value.toString());
    }

    @Override // pc.a
    public final Object b(sc.d dVar) {
        String uuidString = dVar.v();
        kotlin.jvm.internal.g.f(uuidString, "uuidString");
        if (uuidString.length() != 36) {
            throw new IllegalArgumentException("Expected a 36-char string in the standard uuid format.");
        }
        long jB = gc.d.b(0, 8, uuidString);
        androidx.datastore.preferences.protobuf.b1.b(8, uuidString);
        long jB2 = gc.d.b(9, 13, uuidString);
        androidx.datastore.preferences.protobuf.b1.b(13, uuidString);
        long jB3 = gc.d.b(14, 18, uuidString);
        androidx.datastore.preferences.protobuf.b1.b(18, uuidString);
        long jB4 = gc.d.b(19, 23, uuidString);
        androidx.datastore.preferences.protobuf.b1.b(23, uuidString);
        long j10 = (jB << 32) | (jB2 << 16) | jB3;
        long jB5 = gc.d.b(24, 36, uuidString) | (jB4 << 48);
        return (j10 == 0 && jB5 == 0) ? Uuid.f10106c : new Uuid(j10, jB5);
    }

    @Override // pc.c
    public final rc.e d() {
        return f13032b;
    }
}
