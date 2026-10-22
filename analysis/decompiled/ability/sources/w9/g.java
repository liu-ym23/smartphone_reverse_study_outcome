package w9;

import s9.AbstractC1921a;

/* loaded from: classes4.dex */
public abstract class g {
    public static final a5.d b;
    public static final a5.d c;
    public static final a5.d d;
    public static final a5.d e;

    /* renamed from: a, reason: collision with root package name */
    public static final int f6856a = AbstractC1921a.j(100, 12, "kotlinx.coroutines.semaphore.maxSpinCycles");
    public static final int f = AbstractC1921a.j(16, 12, "kotlinx.coroutines.semaphore.segmentSize");

    static {
        int i = 6;
        b = new a5.d("PERMIT", i);
        c = new a5.d("TAKEN", i);
        d = new a5.d("BROKEN", i);
        e = new a5.d("CANCELLED", i);
    }
}
