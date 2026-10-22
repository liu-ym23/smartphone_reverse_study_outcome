package n0;

/* loaded from: classes.dex */
public class i implements h {

    /* renamed from: a, reason: collision with root package name */
    i f18885a;

    /* renamed from: b, reason: collision with root package name */
    final c f18886b;

    /* renamed from: c, reason: collision with root package name */
    private int f18887c;

    /* renamed from: d, reason: collision with root package name */
    private final int f18888d;

    /* renamed from: e, reason: collision with root package name */
    private final int f18889e;

    /* renamed from: f, reason: collision with root package name */
    int f18890f;

    /* renamed from: g, reason: collision with root package name */
    int[] f18891g;

    /* renamed from: h, reason: collision with root package name */
    private C0871a f18892h = new C0871a();

    /* renamed from: i, reason: collision with root package name */
    private int f18893i;

    /* renamed from: j, reason: collision with root package name */
    private int f18894j;

    public i(c cVar, int i5, String str, String str2, String str3, String[] strArr) {
        if (cVar.f18861q == null) {
            cVar.f18861q = this;
        } else {
            cVar.f18862r.f18885a = this;
        }
        cVar.f18862r = this;
        this.f18886b = cVar;
        this.f18887c = i5;
        this.f18888d = cVar.h(str);
        this.f18889e = cVar.h(str2);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.f18890f = length;
        this.f18891g = new int[length];
        for (int i6 = 0; i6 < this.f18890f; i6++) {
            this.f18891g[i6] = cVar.b(strArr[i6]).f18867a;
        }
    }

    @Override // n0.h
    public void a(int i5, int i6) {
        this.f18892h.d(132).b(i5, i6);
    }

    @Override // n0.h
    public void b(int i5, String str) {
        this.f18892h.c(i5, this.f18886b.b(str).f18867a);
    }

    @Override // n0.h
    public void c(int i5, String str, String str2, String str3) {
        this.f18892h.c(i5, this.f18886b.d(str, str2, str3).f18867a);
    }

    @Override // n0.h
    public void d(int i5, int i6) {
        this.f18892h.b(i5, i6);
    }

    @Override // n0.h
    public void e(int i5) {
        this.f18892h.d(i5);
    }

    @Override // n0.h
    public void f(int i5, int i6) {
        this.f18893i = i5;
        this.f18894j = i6;
    }

    @Override // n0.h
    public void g(int i5, int i6) {
        if (i6 < 4 && i5 != 169) {
            this.f18892h.d((i5 < 54 ? ((i5 - 21) << 2) + 26 : ((i5 - 54) << 2) + 59) + i6);
        } else if (i6 >= 256) {
            this.f18892h.d(196).c(i5, i6);
        } else {
            this.f18892h.b(i5, i6);
        }
    }

    @Override // n0.h
    public void h(int i5, f fVar) {
        if ((fVar.f18876a & 2) != 0 && fVar.f18877b - this.f18892h.f18838b < -32768) {
            throw new UnsupportedOperationException();
        }
        this.f18892h.d(i5);
        C0871a c0871a = this.f18892h;
        fVar.b(this, c0871a, c0871a.f18838b - 1, i5 == 200);
    }

    @Override // n0.h
    public void i(int i5, String str, String str2, String str3) {
        boolean z5 = i5 == 185;
        e eVarE = this.f18886b.e(str, str2, str3, z5);
        int iB = eVarE.f18869c;
        if (!z5) {
            this.f18892h.c(i5, eVarE.f18867a);
            return;
        }
        if (iB == 0) {
            iB = j.b(str3);
            eVarE.f18869c = iB;
        }
        this.f18892h.c(185, eVarE.f18867a).b(iB >> 2, 0);
    }

    @Override // n0.h
    public void j() {
    }

    @Override // n0.h
    public void k(Object obj) {
        e eVarC = this.f18886b.c(obj);
        int i5 = eVarC.f18867a;
        int i6 = eVarC.f18868b;
        if (i6 == 5 || i6 == 6) {
            this.f18892h.c(20, i5);
        } else if (i5 >= 256) {
            this.f18892h.c(19, i5);
        } else {
            this.f18892h.b(18, i5);
        }
    }

    @Override // n0.h
    public void l(f fVar) {
        C0871a c0871a = this.f18892h;
        fVar.c(this, c0871a.f18838b, c0871a.f18837a);
    }

    final int m() {
        int i5;
        if (this.f18892h.f18838b > 0) {
            this.f18886b.h("Code");
            i5 = this.f18892h.f18838b + 26;
        } else {
            i5 = 8;
        }
        if (this.f18890f <= 0) {
            return i5;
        }
        this.f18886b.h("Exceptions");
        return i5 + (this.f18890f * 2) + 8;
    }

    final void n(C0871a c0871a) {
        c0871a.g(this.f18887c & (-393217)).g(this.f18888d).g(this.f18889e);
        int i5 = this.f18892h.f18838b > 0 ? 1 : 0;
        if (this.f18890f > 0) {
            i5++;
        }
        c0871a.g(i5);
        int i6 = this.f18892h.f18838b;
        if (i6 > 0) {
            c0871a.g(this.f18886b.h("Code")).f(i6 + 12);
            c0871a.g(this.f18893i).g(this.f18894j);
            C0871a c0871aF = c0871a.f(this.f18892h.f18838b);
            C0871a c0871a2 = this.f18892h;
            c0871aF.e(c0871a2.f18837a, 0, c0871a2.f18838b);
            c0871a.g(0);
            c0871a.g(0);
        }
        if (this.f18890f > 0) {
            c0871a.g(this.f18886b.h("Exceptions")).f((this.f18890f * 2) + 2);
            c0871a.g(this.f18890f);
            for (int i7 = 0; i7 < this.f18890f; i7++) {
                c0871a.g(this.f18891g[i7]);
            }
        }
    }
}
