package Q3;

/* loaded from: classes.dex */
public enum d implements G3.c<Object> {
    INSTANCE;

    public static void d(Q4.b<?> bVar) {
        bVar.e(INSTANCE);
        bVar.a();
    }

    public static void e(Throwable th, Q4.b<?> bVar) {
        bVar.e(INSTANCE);
        bVar.onError(th);
    }

    @Override // G3.b
    public int b(int i5) {
        return i5 & 2;
    }

    @Override // Q4.c
    public void cancel() {
    }

    @Override // G3.f
    public void clear() {
    }

    @Override // Q4.c
    public void h(long j5) {
        g.k(j5);
    }

    @Override // G3.f
    public boolean isEmpty() {
        return true;
    }

    @Override // G3.f
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // G3.f
    public Object poll() {
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }
}
