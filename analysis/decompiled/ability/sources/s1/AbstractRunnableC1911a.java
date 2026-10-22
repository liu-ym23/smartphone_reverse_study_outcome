package s1;

/* renamed from: s1.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractRunnableC1911a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f5977a;
    public final boolean b;
    public final long c;

    public AbstractRunnableC1911a(long j5) {
        this(j5, 0L);
    }

    public AbstractRunnableC1911a(long j5, long j6) {
        this.f5977a = j5;
        this.c = j6;
        if (j6 > 0) {
            this.b = true;
        }
    }
}
