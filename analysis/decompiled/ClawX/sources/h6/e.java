package h6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends h {
    public static final e d;

    static {
        int i8 = k.f3067c;
        int i9 = k.d;
        long j4 = k.f3068e;
        String str = k.f3065a;
        e eVar = new e();
        eVar.f3061c = new c(i8, i9, j4, str);
        d = eVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // a6.b0
    public final String toString() {
        return "Dispatchers.Default";
    }
}
