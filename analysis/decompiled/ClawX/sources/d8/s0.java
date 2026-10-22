package d8;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s0 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public byte[] f2158f;

    /* renamed from: g, reason: collision with root package name */
    public int f2159g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f2160h;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f2161j = new ArrayList();

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        int iF = uVar.f();
        this.f2159g = uVar.f();
        int iD = uVar.d();
        this.f2158f = uVar.b(iF);
        this.f2160h = uVar.b(iD);
        while (uVar.f2171a.remaining() > 0) {
            this.f2161j.add(new x1(uVar));
        }
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        if (p2.a()) {
            sb.append("( ");
        }
        String str = p2.a() ? "\n\t" : " ";
        sb.append(this.f2159g);
        sb.append(" ");
        sb.append(b8.h.O(this.f2158f));
        sb.append(str);
        sb.append(a.a.f0(this.f2160h));
        ArrayList arrayList = this.f2161j;
        if (!arrayList.isEmpty()) {
            sb.append(str);
        }
        sb.append((String) arrayList.stream().map(new z(3)).collect(Collectors.joining(str)));
        if (p2.a()) {
            sb.append(" )");
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(final b0.j jVar, n nVar, final boolean z) {
        jVar.m(this.f2158f.length);
        jVar.m(this.f2159g);
        jVar.j(this.f2160h.length);
        jVar.h(this.f2158f);
        jVar.h(this.f2160h);
        this.f2161j.forEach(new Consumer() { // from class: d8.r0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((x1) obj).j(jVar, null, z);
            }
        });
    }
}
