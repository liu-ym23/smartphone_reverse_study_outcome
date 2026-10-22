package d.k;

import d.h.b.h;
import java.io.Serializable;

/* JADX INFO: compiled from: XorWowRandom.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends c implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f38515b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f38516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f38517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f38518e;
    private int f;
    private int g;
    private int h;

    /* JADX INFO: compiled from: XorWowRandom.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f38515b = new a(null);
    }

    public f(int r1, int r2, int r3, int r4, int r5, int r6) {
        this.f38516c = r1;
        this.f38517d = r2;
        this.f38518e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        int r7 = (((r1 | r2) | r3) | r4) | r5;
        int r8 = 0;
        if (r7 == 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L12;
    L8:
        if (r8 >= 64) goto L10;
        b();
        r8 = r8 + 1;
        goto L8
    L10:
        return;
    L12:
        throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
    L5:
        r9 = false;
        goto L6
    }

    public f(int r8, int r9) {
        this(r8, r9, 0, 0, ~r8, (r8 << 10) ^ (r9 >>> 4));
    }

    @Override // d.k.c
    public int b() {
        int r0 = this.f38516c;
        int r1 = r0 ^ (r0 >>> 2);
        this.f38516c = this.f38517d;
        this.f38517d = this.f38518e;
        this.f38518e = this.f;
        int r2 = this.g;
        this.f = r2;
        int r3 = ((r1 ^ (r1 << 1)) ^ r2) ^ (r2 << 4);
        this.g = r3;
        int r4 = this.h + 362437;
        this.h = r4;
        return r3 + r4;
    }

    @Override // d.k.c
    public int a(int r1) {
        return d.a(b(), r1);
    }
}
