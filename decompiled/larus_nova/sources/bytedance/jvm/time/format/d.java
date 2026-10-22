package bytedance.jvm.time.format;

import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.temporal.ValueRange;
import bytedance.jvm.time.temporal.k;
import bytedance.jvm.time.temporal.l;

/* JADX INFO: loaded from: classes28.dex */
public final class d implements bytedance.jvm.time.temporal.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bytedance.jvm.time.chrono.c f21646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ bytedance.jvm.time.temporal.d f21647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ bytedance.jvm.time.chrono.j f21648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ZoneId f21649d;

    @Override // bytedance.jvm.time.temporal.d
    public final /* synthetic */ int get(bytedance.jvm.time.temporal.j r100) {
        return bytedance.jvm.time.temporal.c.a(this, r100);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f21647b);
        String r101 = "";
        if (this.f21648c == null) goto L5;
        String r102 = " with chronology " + this.f21648c;
    L6:
        r100.append(r102);
        if (this.f21649d == null) goto L9;
        r101 = " with zone " + this.f21649d;
    L9:
        r100.append(r101);
        return r100.toString();
    L5:
        r102 = "";
        goto L6
    }

    @Override // bytedance.jvm.time.temporal.d
    public final long getLong(bytedance.jvm.time.temporal.j r100) {
        if (this.f21646a == null) goto L9;
        if (r100.isDateBased() == false) goto L9;
        return this.f21646a.getLong(r100);
    L9:
        return this.f21647b.getLong(r100);
    }

    @Override // bytedance.jvm.time.temporal.d
    public final boolean isSupported(bytedance.jvm.time.temporal.j r100) {
        if (this.f21646a == null) goto L9;
        if (r100.isDateBased() == false) goto L9;
        return this.f21646a.isSupported(r100);
    L9:
        return this.f21647b.isSupported(r100);
    }

    @Override // bytedance.jvm.time.temporal.d
    public <R> R query(l<R> r100) {
        if (r100 != k.f21715b) goto L7;
        return (R) this.f21648c;
    L7:
        if (r100 != k.f21714a) goto L11;
        return (R) this.f21649d;
    L11:
        if (r100 != k.f21716c) goto L15;
        return (R) this.f21647b.query(r100);
    L15:
        return r100.a(this);
    }

    @Override // bytedance.jvm.time.temporal.d
    public final ValueRange range(bytedance.jvm.time.temporal.j r100) {
        if (this.f21646a == null) goto L9;
        if (r100.isDateBased() == false) goto L9;
        return this.f21646a.range(r100);
    L9:
        return this.f21647b.range(r100);
    }

    public d(bytedance.jvm.time.chrono.c r100, bytedance.jvm.time.temporal.d r101, bytedance.jvm.time.chrono.j r102, ZoneId r103) {
        this.f21646a = r100;
        this.f21647b = r101;
        this.f21648c = r102;
        this.f21649d = r103;
    }
}
