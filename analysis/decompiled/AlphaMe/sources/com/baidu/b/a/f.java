package com.baidu.b.a;

/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    public static int f4714a = 5;

    /* renamed from: b, reason: collision with root package name */
    public static int f4715b = 40;

    /* renamed from: c, reason: collision with root package name */
    private b f4716c;

    public f() {
        b bVar = new b(f4715b);
        this.f4716c = bVar;
        bVar.a(0, f4715b, true);
    }

    public void a(b bVar, int i4, int i5, int i6) {
        b bVarC = this.f4716c.c(i4, i4 + i5);
        if (i6 == 0) {
            bVarC.a(bVar);
        } else if (i6 == 2) {
            bVarC.d(bVar);
        } else if (i6 != 3) {
            bVarC.c(bVar);
        } else {
            bVarC.b(bVar);
        }
        for (int i7 = 0; i7 < i5; i7++) {
            this.f4716c.a(i4 + i7, bVarC.c(i7));
        }
    }

    public byte[] a() {
        return this.f4716c.a();
    }
}
