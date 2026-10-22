package bytedance.jvm.time;

import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;

/* JADX INFO: loaded from: classes28.dex */
public final class o implements bytedance.jvm.time.temporal.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ZoneId f21678a;

    @Override // bytedance.jvm.time.temporal.d
    public final /* synthetic */ int get(bytedance.jvm.time.temporal.j r100) {
        return bytedance.jvm.time.temporal.c.a(this, r100);
    }

    @Override // bytedance.jvm.time.temporal.d
    public final boolean isSupported(bytedance.jvm.time.temporal.j r100) {
        return false;
    }

    @Override // bytedance.jvm.time.temporal.d
    public final /* synthetic */ ValueRange range(bytedance.jvm.time.temporal.j r100) {
        return bytedance.jvm.time.temporal.c.c(this, r100);
    }

    public o(ZoneId r100) {
        this.f21678a = r100;
    }

    @Override // bytedance.jvm.time.temporal.d
    public final long getLong(bytedance.jvm.time.temporal.j r100) {
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    }

    @Override // bytedance.jvm.time.temporal.d
    public <R> R query(bytedance.jvm.time.temporal.l<R> r100) {
        if (r100 != bytedance.jvm.time.temporal.k.f21714a) goto L7;
        return (R) this.f21678a;
    L7:
        return (R) bytedance.jvm.time.temporal.c.b(this, r100);
    }
}
