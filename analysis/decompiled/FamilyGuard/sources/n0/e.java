package n0;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    int f18867a;

    /* renamed from: b, reason: collision with root package name */
    int f18868b;

    /* renamed from: c, reason: collision with root package name */
    int f18869c;

    /* renamed from: d, reason: collision with root package name */
    long f18870d;

    /* renamed from: e, reason: collision with root package name */
    String f18871e;

    /* renamed from: f, reason: collision with root package name */
    String f18872f;

    /* renamed from: g, reason: collision with root package name */
    String f18873g;

    /* renamed from: h, reason: collision with root package name */
    int f18874h;

    /* renamed from: i, reason: collision with root package name */
    e f18875i;

    e() {
    }

    boolean a(e eVar) {
        int i5 = this.f18868b;
        if (i5 != 1) {
            if (i5 != 15) {
                if (i5 == 12) {
                    return eVar.f18871e.equals(this.f18871e) && eVar.f18872f.equals(this.f18872f);
                }
                if (i5 != 13) {
                    switch (i5) {
                        case 3:
                        case 4:
                            return eVar.f18869c == this.f18869c;
                        case 5:
                        case 6:
                            break;
                        case 7:
                        case 8:
                            break;
                        default:
                            return eVar.f18871e.equals(this.f18871e) && eVar.f18872f.equals(this.f18872f) && eVar.f18873g.equals(this.f18873g);
                    }
                }
            }
            return eVar.f18870d == this.f18870d;
        }
        return eVar.f18871e.equals(this.f18871e);
    }

    void b(int i5) {
        this.f18868b = 3;
        this.f18869c = i5;
        this.f18874h = (3 + i5) & Integer.MAX_VALUE;
    }

    void c(int i5, String str, String str2, String str3) {
        this.f18868b = i5;
        this.f18871e = str;
        this.f18872f = str2;
        this.f18873g = str3;
        if (i5 != 1 && i5 != 7 && i5 != 8) {
            if (i5 == 12) {
                this.f18874h = (i5 + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
                return;
            } else if (i5 != 13) {
                this.f18874h = (i5 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
                return;
            }
        }
        this.f18874h = (i5 + str.hashCode()) & Integer.MAX_VALUE;
    }

    e(int i5, e eVar) {
        this.f18867a = i5;
        this.f18868b = eVar.f18868b;
        this.f18869c = eVar.f18869c;
        this.f18870d = eVar.f18870d;
        this.f18871e = eVar.f18871e;
        this.f18872f = eVar.f18872f;
        this.f18873g = eVar.f18873g;
        this.f18874h = eVar.f18874h;
    }
}
