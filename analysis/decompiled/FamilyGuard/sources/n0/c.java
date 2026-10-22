package n0;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    int f18845a;

    /* renamed from: b, reason: collision with root package name */
    int f18846b;

    /* renamed from: c, reason: collision with root package name */
    final C0871a f18847c;

    /* renamed from: d, reason: collision with root package name */
    e[] f18848d;

    /* renamed from: e, reason: collision with root package name */
    int f18849e;

    /* renamed from: f, reason: collision with root package name */
    final e f18850f;

    /* renamed from: g, reason: collision with root package name */
    final e f18851g;

    /* renamed from: h, reason: collision with root package name */
    final e f18852h;

    /* renamed from: i, reason: collision with root package name */
    private int f18853i;

    /* renamed from: j, reason: collision with root package name */
    private int f18854j;

    /* renamed from: k, reason: collision with root package name */
    String f18855k;

    /* renamed from: l, reason: collision with root package name */
    private int f18856l;

    /* renamed from: m, reason: collision with root package name */
    private int f18857m;

    /* renamed from: n, reason: collision with root package name */
    private int[] f18858n;

    /* renamed from: o, reason: collision with root package name */
    d f18859o;

    /* renamed from: p, reason: collision with root package name */
    d f18860p;

    /* renamed from: q, reason: collision with root package name */
    i f18861q;

    /* renamed from: r, reason: collision with root package name */
    i f18862r;

    public c() {
        this(0);
    }

    private e a(e eVar) {
        e[] eVarArr = this.f18848d;
        e eVar2 = eVarArr[eVar.f18874h % eVarArr.length];
        while (eVar2 != null && (eVar2.f18868b != eVar.f18868b || !eVar.a(eVar2))) {
            eVar2 = eVar2.f18875i;
        }
        return eVar2;
    }

    private e g(String str) {
        this.f18851g.c(8, str, null, null);
        e eVarA = a(this.f18851g);
        if (eVarA != null) {
            return eVarA;
        }
        this.f18847c.c(8, h(str));
        int i5 = this.f18846b;
        this.f18846b = i5 + 1;
        e eVar = new e(i5, this.f18851g);
        i(eVar);
        return eVar;
    }

    private void i(e eVar) {
        if (this.f18846b > this.f18849e) {
            int length = this.f18848d.length;
            int i5 = (length * 2) + 1;
            e[] eVarArr = new e[i5];
            for (int i6 = length - 1; i6 >= 0; i6--) {
                e eVar2 = this.f18848d[i6];
                while (eVar2 != null) {
                    int i7 = eVar2.f18874h % i5;
                    e eVar3 = eVar2.f18875i;
                    eVar2.f18875i = eVarArr[i7];
                    eVarArr[i7] = eVar2;
                    eVar2 = eVar3;
                }
            }
            this.f18848d = eVarArr;
            this.f18849e = (int) (i5 * 0.75d);
        }
        int i8 = eVar.f18874h;
        e[] eVarArr2 = this.f18848d;
        int length2 = i8 % eVarArr2.length;
        eVar.f18875i = eVarArr2[length2];
        eVarArr2[length2] = eVar;
    }

    public e b(String str) {
        this.f18851g.c(7, str, null, null);
        e eVarA = a(this.f18851g);
        if (eVarA != null) {
            return eVarA;
        }
        this.f18847c.c(7, h(str));
        int i5 = this.f18846b;
        this.f18846b = i5 + 1;
        e eVar = new e(i5, this.f18851g);
        i(eVar);
        return eVar;
    }

    e c(Object obj) {
        if (!(obj instanceof Integer)) {
            if (obj instanceof String) {
                return g((String) obj);
            }
            if (obj instanceof j) {
                j jVar = (j) obj;
                return b(jVar.f18904a == 10 ? jVar.f() : jVar.d());
            }
            throw new IllegalArgumentException("value " + obj);
        }
        int iIntValue = ((Integer) obj).intValue();
        this.f18850f.b(iIntValue);
        e eVarA = a(this.f18850f);
        if (eVarA != null) {
            return eVarA;
        }
        this.f18847c.d(3).f(iIntValue);
        int i5 = this.f18846b;
        this.f18846b = i5 + 1;
        e eVar = new e(i5, this.f18850f);
        i(eVar);
        return eVar;
    }

    e d(String str, String str2, String str3) {
        this.f18852h.c(9, str, str2, str3);
        e eVarA = a(this.f18852h);
        if (eVarA != null) {
            return eVarA;
        }
        int i5 = b(str).f18867a;
        this.f18847c.c(9, i5).g(f(str2, str3).f18867a);
        int i6 = this.f18846b;
        this.f18846b = i6 + 1;
        e eVar = new e(i6, this.f18852h);
        i(eVar);
        return eVar;
    }

    e e(String str, String str2, String str3, boolean z5) {
        int i5 = z5 ? 11 : 10;
        this.f18852h.c(i5, str, str2, str3);
        e eVarA = a(this.f18852h);
        if (eVarA != null) {
            return eVarA;
        }
        this.f18847c.c(i5, b(str).f18867a).g(f(str2, str3).f18867a);
        int i6 = this.f18846b;
        this.f18846b = i6 + 1;
        e eVar = new e(i6, this.f18852h);
        i(eVar);
        return eVar;
    }

    public e f(String str, String str2) {
        this.f18851g.c(12, str, str2, null);
        e eVarA = a(this.f18851g);
        if (eVarA != null) {
            return eVarA;
        }
        int iH = h(str);
        this.f18847c.c(12, iH).g(h(str2));
        int i5 = this.f18846b;
        this.f18846b = i5 + 1;
        e eVar = new e(i5, this.f18851g);
        i(eVar);
        return eVar;
    }

    public int h(String str) {
        this.f18850f.c(1, str, null, null);
        e eVarA = a(this.f18850f);
        if (eVarA == null) {
            this.f18847c.d(1).h(str);
            int i5 = this.f18846b;
            this.f18846b = i5 + 1;
            eVarA = new e(i5, this.f18850f);
            i(eVarA);
        }
        return eVarA.f18867a;
    }

    public byte[] j() {
        int iM = (this.f18857m * 2) + 24;
        int i5 = 0;
        for (d dVar = this.f18859o; dVar != null; dVar = dVar.f18863a) {
            i5++;
            iM += dVar.a();
        }
        int i6 = 0;
        for (i iVar = this.f18861q; iVar != null; iVar = iVar.f18885a) {
            i6++;
            iM += iVar.m();
        }
        C0871a c0871a = new C0871a(iM + this.f18847c.f18838b);
        c0871a.f(-889275714).f(this.f18845a);
        C0871a c0871aG = c0871a.g(this.f18846b);
        C0871a c0871a2 = this.f18847c;
        c0871aG.e(c0871a2.f18837a, 0, c0871a2.f18838b);
        c0871a.g(this.f18853i & (-393217)).g(this.f18854j).g(this.f18856l);
        c0871a.g(this.f18857m);
        for (int i7 = 0; i7 < this.f18857m; i7++) {
            c0871a.g(this.f18858n[i7]);
        }
        c0871a.g(i5);
        for (d dVar2 = this.f18859o; dVar2 != null; dVar2 = dVar2.f18863a) {
            dVar2.b(c0871a);
        }
        c0871a.g(i6);
        for (i iVar2 = this.f18861q; iVar2 != null; iVar2 = iVar2.f18885a) {
            iVar2.n(c0871a);
        }
        c0871a.g(0);
        return c0871a.f18837a;
    }

    public void k(int i5, int i6, String str, String str2, String[] strArr) {
        this.f18845a = i5;
        this.f18853i = i6;
        this.f18854j = b(str).f18867a;
        this.f18855k = str;
        this.f18856l = str2 == null ? 0 : b(str2).f18867a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.f18857m = length;
        this.f18858n = new int[length];
        for (int i7 = 0; i7 < this.f18857m; i7++) {
            this.f18858n[i7] = b(strArr[i7]).f18867a;
        }
    }

    private c(int i5) {
        this.f18846b = 1;
        this.f18847c = new C0871a();
        this.f18848d = new e[256];
        this.f18849e = (int) (r5.length * 0.75d);
        this.f18850f = new e();
        this.f18851g = new e();
        this.f18852h = new e();
    }
}
