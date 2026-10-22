package z4;

/* renamed from: z4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1351c extends C1354f {

    /* renamed from: i, reason: collision with root package name */
    public static final C1351c f24108i = new C1351c();

    private C1351c() {
        super(l.f24121c, l.f24122d, l.f24123e, l.f24119a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // s4.AbstractC1056E
    public String toString() {
        return "Dispatchers.Default";
    }
}
