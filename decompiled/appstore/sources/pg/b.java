package pg;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f23468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f23469b;

    public b(long r10, Object r11) {
        this.f23469b = r11;
        this.f23468a = r10;
    }

    public long a() {
        return this.f23468a;
    }

    public Object b() {
        return this.f23469b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L9;
        return false;
    L9:
        if ((r10 instanceof b) == true) goto L11;
        return false;
    L11:
        b r11 = (b) r10;
        if (this.f23468a != r11.f23468a) goto L20;
        Object r12 = this.f23469b;
        Object r13 = r11.f23469b;
        if (r12 == r13) goto L21;
        if (r12 == null) goto L20;
        if (r12.equals(r13) == false) goto L20;
        return true;
    L21:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        long r10 = this.f23468a;
        int r11 = (((int) (r10 ^ (r10 >>> 32))) + 31) * 31;
        Object r12 = this.f23469b;
        if (r12 != null) goto L5;
        int r13 = 0;
    L7:
        return r11 + r13;
    L5:
        r13 = r12.hashCode();
        goto L7
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", new Object[]{Long.valueOf(this.f23468a), this.f23469b.toString()});
    }
}
