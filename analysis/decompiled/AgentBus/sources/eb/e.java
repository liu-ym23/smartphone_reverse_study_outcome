package eb;

import ab.c0;
import java.io.IOException;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final n f3258a;

    /* renamed from: b, reason: collision with root package name */
    public final ab.a f3259b;

    /* renamed from: c, reason: collision with root package name */
    public final i f3260c;

    /* renamed from: d, reason: collision with root package name */
    public d1.b f3261d;

    /* renamed from: e, reason: collision with root package name */
    public p f3262e;

    /* renamed from: f, reason: collision with root package name */
    public int f3263f;

    /* renamed from: g, reason: collision with root package name */
    public int f3264g;

    /* renamed from: h, reason: collision with root package name */
    public int f3265h;

    /* renamed from: i, reason: collision with root package name */
    public c0 f3266i;

    public e(n nVar, ab.a aVar, i iVar) {
        q7.k.e(nVar, "connectionPool");
        this.f3258a = nVar;
        this.f3259b = aVar;
        this.f3260c = iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x02c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final eb.m a(int r13, int r14, int r15, int r16, boolean r17, boolean r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 865
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: eb.e.a(int, int, int, int, boolean, boolean):eb.m");
    }

    public final boolean b(ab.p pVar) {
        q7.k.e(pVar, "url");
        ab.p pVar2 = this.f3259b.f493h;
        return pVar.f592e == pVar2.f592e && q7.k.a(pVar.f591d, pVar2.f591d);
    }

    public final void c(IOException iOException) {
        q7.k.e(iOException, "e");
        this.f3266i = null;
        if ((iOException instanceof hb.c0) && ((hb.c0) iOException).f4274f == 8) {
            this.f3263f++;
        } else if (iOException instanceof hb.a) {
            this.f3264g++;
        } else {
            this.f3265h++;
        }
    }
}
