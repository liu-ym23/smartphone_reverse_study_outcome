package u3;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f24839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f24841c;

    public a() {
        this(0);
    }

    public long a() {
        return this.f24839a;
    }

    public final long b() {
        return this.f24841c;
    }

    public final boolean c() {
        return this.f24840b;
    }

    public void d(long r10, long r11) {
        this.f24839a = r10;
        this.f24841c = r11;
        if (r11 <= 0) goto L6;
        this.f24840b = true;
        return;
    }

    public a(long r10) {
        this(r10, 0);
    }

    public a(long r10, long r11) {
        this.f24839a = r10;
        this.f24841c = r11;
        if (r11 <= 0) goto L6;
        this.f24840b = true;
        return;
    }
}
