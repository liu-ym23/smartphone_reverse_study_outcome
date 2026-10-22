package a4;

import kotlin.jvm.internal.p;
import p5.q;
import p5.s;
import z3.p0;
import z3.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i implements a {

    /* renamed from: b, reason: collision with root package name */
    public static final i f110b = new i(0);

    /* renamed from: c, reason: collision with root package name */
    public static final i f111c = new i(1);
    public static final i d = new i(2);

    /* renamed from: e, reason: collision with root package name */
    public static final i f112e = new i(3);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f113a;

    public /* synthetic */ i(int i8) {
        this.f113a = i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a4.a
    public final void c(t3.c client, h5.i iVar) {
        int i8 = 0;
        f5.c cVar = null;
        switch (this.f113a) {
            case 0:
                q qVar = (q) iVar;
                p.e(client, "client");
                z3.a aVar = p0.f6492b;
                r4.a aVar2 = z.f6527a;
                r4.d dVar = (r4.d) client.f5574j.d(z.f6527a);
                Object objD = dVar != null ? dVar.d(p0.f6493c) : null;
                if (objD != null) {
                    ((p0) objD).f6494a.add(new h(qVar, client, cVar, i8));
                    return;
                }
                throw new IllegalStateException("Plugin " + aVar + " is not installed. Consider using `install(" + p0.f6493c + ")` in client config first.");
            case 1:
                p.e(client, "client");
                client.f5570e.f(f4.f.f2603g, new j((p5.p) iVar, i8, cVar));
                return;
            case 2:
                p.e(client, "client");
                client.f5570e.f(f4.f.f2605i, new j((s) iVar, 1, cVar));
                return;
            default:
                p.e(client, "client");
                client.f5571f.f(h4.b.f3015l, new m((s) iVar, i8, cVar));
                return;
        }
    }
}
