package s6;

import java.util.ArrayList;
import kotlin.jvm.internal.p;
import n6.n;
import n6.s;
import n6.u;
import r6.o;
import r6.r;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final o f5245a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f5246b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5247c;
    public final r6.g d;

    /* renamed from: e, reason: collision with root package name */
    public final s f5248e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5249f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5250g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5251h;

    /* renamed from: i, reason: collision with root package name */
    public int f5252i;

    public h(o oVar, ArrayList arrayList, int i8, r6.g gVar, s sVar, int i9, int i10, int i11) {
        this.f5245a = oVar;
        this.f5246b = arrayList;
        this.f5247c = i8;
        this.d = gVar;
        this.f5248e = sVar;
        this.f5249f = i9;
        this.f5250g = i10;
        this.f5251h = i11;
    }

    public static h a(h hVar, int i8, r6.g gVar, s sVar, int i9) {
        if ((i9 & 1) != 0) {
            i8 = hVar.f5247c;
        }
        int i10 = i8;
        if ((i9 & 2) != 0) {
            gVar = hVar.d;
        }
        r6.g gVar2 = gVar;
        if ((i9 & 4) != 0) {
            sVar = hVar.f5248e;
        }
        s request = sVar;
        int i11 = hVar.f5249f;
        int i12 = hVar.f5250g;
        int i13 = hVar.f5251h;
        p.e(request, "request");
        return new h(hVar.f5245a, hVar.f5246b, i10, gVar2, request, i11, i12, i13);
    }

    public final u b(s request) {
        p.e(request, "request");
        ArrayList arrayList = this.f5246b;
        int size = arrayList.size();
        int i8 = this.f5247c;
        if (i8 >= size) {
            throw new IllegalStateException("Check failed.");
        }
        this.f5252i++;
        r6.g gVar = this.d;
        if (gVar != null) {
            if (!((r) gVar.f5142b.b()).e(request.f4128a)) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i8 - 1) + " must retain the same host and port").toString());
            }
            if (this.f5252i != 1) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i8 - 1) + " must call proceed() exactly once").toString());
            }
        }
        int i9 = i8 + 1;
        h hVarA = a(this, i9, null, request, 58);
        n nVar = (n) arrayList.get(i8);
        u uVarA = nVar.a(hVarA);
        if (uVarA == null) {
            throw new NullPointerException("interceptor " + nVar + " returned null");
        }
        if (gVar == null || i9 >= arrayList.size() || hVarA.f5252i == 1) {
            return uVarA;
        }
        throw new IllegalStateException(("network interceptor " + nVar + " must call proceed() exactly once").toString());
    }
}
