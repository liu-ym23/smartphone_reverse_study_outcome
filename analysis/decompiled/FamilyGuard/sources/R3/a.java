package R3;

/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    final int f4979a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f4980b;

    /* renamed from: c, reason: collision with root package name */
    Object[] f4981c;

    /* renamed from: d, reason: collision with root package name */
    int f4982d;

    public a(int i5) {
        this.f4979a = i5;
        Object[] objArr = new Object[i5 + 1];
        this.f4980b = objArr;
        this.f4981c = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <U> boolean a(Q4.b<? super U> r4) {
        /*
            r3 = this;
            java.lang.Object[] r0 = r3.f4980b
            int r3 = r3.f4979a
        L4:
            r1 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r1 >= r3) goto L19
            r2 = r0[r1]
            if (r2 != 0) goto Le
            goto L19
        Le:
            boolean r2 = R3.g.b(r2, r4)
            if (r2 == 0) goto L16
            r3 = 1
            return r3
        L16:
            int r1 = r1 + 1
            goto L7
        L19:
            r0 = r0[r3]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: R3.a.a(Q4.b):boolean");
    }

    public void b(T t5) {
        int i5 = this.f4979a;
        int i6 = this.f4982d;
        if (i6 == i5) {
            Object[] objArr = new Object[i5 + 1];
            this.f4981c[i5] = objArr;
            this.f4981c = objArr;
            i6 = 0;
        }
        this.f4981c[i6] = t5;
        this.f4982d = i6 + 1;
    }

    public void c(T t5) {
        this.f4980b[0] = t5;
    }
}
