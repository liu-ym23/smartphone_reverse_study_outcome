package M9;

/* loaded from: classes4.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name */
    public int f975a;
    public final int[] b = new int[10];

    public final int a() {
        if ((this.f975a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    public final void b(B other) {
        kotlin.jvm.internal.k.f(other, "other");
        for (int i = 0; i < 10; i++) {
            if (((1 << i) & other.f975a) != 0) {
                c(i, other.b[i]);
            }
        }
    }

    public final void c(int i, int i6) {
        if (i >= 0) {
            int[] iArr = this.b;
            if (i >= iArr.length) {
                return;
            }
            this.f975a = (1 << i) | this.f975a;
            iArr[i] = i6;
        }
    }
}
