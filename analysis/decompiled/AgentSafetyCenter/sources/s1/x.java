package s1;

import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11322a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ g0 f11323b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ b0 f11324c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f11325d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ g0 f11326e;

    @Override // s1.g0
    public final Map b() {
        switch (this.f11322a) {
        }
        return this.f11323b.b();
    }

    @Override // s1.g0
    public final void c() {
        switch (this.f11322a) {
            case 0:
                b0 b0Var = this.f11324c;
                b0Var.i = this.f11325d;
                this.f11326e.c();
                p.f0 f0Var = b0Var.f11213p;
                long[] jArr = f0Var.f9552a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j10 = jArr[i];
                        if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i3 = 8 - ((~(i - length)) >>> 31);
                            for (int i10 = 0; i10 < i3; i10++) {
                                if ((255 & j10) < 128) {
                                    int i11 = (i << 3) + i10;
                                    Object obj = f0Var.f9553b[i11];
                                    w0 w0Var = (w0) f0Var.f9554c[i11];
                                    int i12 = b0Var.f11214q.i(obj);
                                    if (i12 < 0 || i12 >= b0Var.i) {
                                        w0Var.dispose();
                                        f0Var.l(i11);
                                    }
                                }
                                j10 >>= 8;
                            }
                            if (i3 != 8) {
                                break;
                            }
                        }
                        if (i == length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                break;
            default:
                b0 b0Var2 = this.f11324c;
                b0Var2.f11206h = this.f11325d;
                this.f11326e.c();
                b0Var2.c(b0Var2.f11206h);
                break;
        }
    }

    @Override // s1.g0
    public final int d() {
        switch (this.f11322a) {
        }
        return this.f11323b.d();
    }

    @Override // s1.g0
    public final int e() {
        switch (this.f11322a) {
        }
        return this.f11323b.e();
    }

    @Override // s1.g0
    public final xb.l f() {
        switch (this.f11322a) {
        }
        return this.f11323b.f();
    }
}
