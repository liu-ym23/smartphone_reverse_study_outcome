package z3;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements a4.a, y {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6410b = new a(0);

    /* renamed from: c, reason: collision with root package name */
    public static final a f6411c = new a(1);
    public static final a d = new a(2);

    /* renamed from: e, reason: collision with root package name */
    public static final a f6412e = new a(3);

    /* renamed from: f, reason: collision with root package name */
    public static final a f6413f = new a(4);

    /* renamed from: g, reason: collision with root package name */
    public static final a f6414g = new a(5);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6415a;

    public /* synthetic */ a(int i8) {
        this.f6415a = i8;
    }

    @Override // z3.y
    public Object a(p5.l lVar) {
        lVar.invoke(new a(6));
        return new p0();
    }

    @Override // z3.y
    public void b(Object obj, t3.c scope) {
        p0 plugin = (p0) obj;
        kotlin.jvm.internal.p.e(plugin, "plugin");
        kotlin.jvm.internal.p.e(scope, "scope");
        scope.f5570e.f(f4.f.f2607k, new a4.h(plugin, scope, null, 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a4.a
    public void c(t3.c client, h5.i iVar) throws v4.c {
        k4.v vVar;
        androidx.emoji2.text.r rVar;
        switch (this.f6415a) {
            case 0:
                kotlin.jvm.internal.p.e(client, "client");
                client.f5573h.f(h4.b.f3012i, new a4.m((p5.p) iVar, 2, null));
                return;
            case 1:
                p5.q qVar = (p5.q) iVar;
                kotlin.jvm.internal.p.e(client, "client");
                androidx.emoji2.text.r rVar2 = new androidx.emoji2.text.r("ObservableContent", 2);
                f4.f fVar = client.f5570e;
                androidx.emoji2.text.r reference = f4.f.f2606j;
                ArrayList arrayList = fVar.f5970a;
                kotlin.jvm.internal.p.e(reference, "reference");
                f5.c cVar = null;
                if (!fVar.e(rVar2)) {
                    int iC = fVar.c(reference);
                    if (iC == -1) {
                        throw new v4.c("Phase " + reference + " was not registered for this pipeline");
                    }
                    int i8 = iC + 1;
                    int iJ0 = c5.n.j0(arrayList);
                    if (i8 <= iJ0) {
                        while (true) {
                            Object obj = arrayList.get(i8);
                            v4.d dVar = obj instanceof v4.d ? (v4.d) obj : null;
                            if (dVar != null && (vVar = dVar.f5968b) != null) {
                                v4.h hVar = vVar instanceof v4.h ? (v4.h) vVar : null;
                                if (hVar != null && (rVar = hVar.f5975a) != null && rVar.equals(reference)) {
                                    iC = i8;
                                }
                                if (i8 != iJ0) {
                                    i8++;
                                }
                            }
                        }
                    }
                    arrayList.add(iC + 1, new v4.d(rVar2, new v4.h(reference)));
                }
                fVar.f(rVar2, new b(qVar, cVar, 0));
                return;
            case 2:
                p5.q qVar2 = (p5.q) iVar;
                kotlin.jvm.internal.p.e(client, "client");
                androidx.emoji2.text.r rVar3 = new androidx.emoji2.text.r("BeforeReceive", 2);
                h4.b bVar = client.f5571f;
                androidx.emoji2.text.r reference2 = h4.b.f3013j;
                bVar.getClass();
                kotlin.jvm.internal.p.e(reference2, "reference");
                if (!bVar.e(rVar3)) {
                    int iC2 = bVar.c(reference2);
                    if (iC2 == -1) {
                        throw new v4.c("Phase " + reference2 + " was not registered for this pipeline");
                    }
                    bVar.f5970a.add(iC2, new v4.d(rVar3, new v4.i()));
                }
                bVar.f(rVar3, new u0(qVar2, null, 0));
                return;
            case 3:
                kotlin.jvm.internal.p.e(client, "client");
                client.f5570e.f(f4.f.f2606j, new b((p5.q) iVar, null, 1));
                return;
            case 4:
                kotlin.jvm.internal.p.e(client, "client");
                client.f5570e.f(f4.f.f2603g, new u0((p5.q) iVar, null, 1));
                return;
            default:
                kotlin.jvm.internal.p.e(client, "client");
                client.f5570e.f(f4.f.f2603g, new u0((p5.q) iVar, null, 2));
                return;
        }
    }

    @Override // z3.y
    public r4.a getKey() {
        return p0.f6493c;
    }
}
