package A3;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f89a;

    /* renamed from: b, reason: collision with root package name */
    public final g[] f90b;

    /* renamed from: c, reason: collision with root package name */
    public long f91c;

    public f(ThreadFactory threadFactory, int i4) {
        this.f89a = i4;
        this.f90b = new g[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            this.f90b[i5] = new g(threadFactory);
        }
    }
}
