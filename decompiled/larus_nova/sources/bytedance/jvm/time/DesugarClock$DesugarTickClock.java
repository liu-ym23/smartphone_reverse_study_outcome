package bytedance.jvm.time;

import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
final class DesugarClock$DesugarTickClock extends Clock implements Serializable {
    private static final long serialVersionUID = 6504659149906368850L;
    private final Clock baseClock;
    private final long tickNanos;

    @Override // bytedance.jvm.time.Clock
    public ZoneId getZone() {
        return this.baseClock.getZone();
    }

    @Override // bytedance.jvm.time.Clock
    public int hashCode() {
        int r100 = this.baseClock.hashCode();
        long r101 = this.tickNanos;
        return r100 ^ ((int) (r101 ^ (r101 >>> 32)));
    }

    @Override // bytedance.jvm.time.Clock
    public Instant instant() {
        long r100 = 0;
        if ((this.tickNanos % 1000000) != 0) goto L14;
        long r101 = this.baseClock.millis();
        long r102 = this.tickNanos / 1000000;
        long r103 = r101 % r102;
        if (r103 == 0) goto L13;
        if ((1 | ((r101 ^ r102) >> 63)) > 0) goto L11;
        r103 = r103 + r102;
    L11:
        r100 = r103;
    L13:
        return Instant.ofEpochMilli(r101 - r100);
    L14:
        Instant r104 = this.baseClock.instant();
        long r105 = r104.getNano();
        long r106 = this.tickNanos;
        long r110 = r105 % r106;
        if (r110 == 0) goto L23;
        if ((((r105 ^ r106) >> 63) | 1) > 0) goto L21;
        r110 = r110 + r106;
    L21:
        r100 = r110;
    L23:
        return r104.minusNanos(r100);
    }

    @Override // bytedance.jvm.time.Clock
    public long millis() {
        long r100 = this.baseClock.millis();
        long r101 = this.tickNanos / 1000000;
        long r102 = r100 % r101;
        long r103 = 0;
        if (r102 == 0) goto L11;
        if ((((r100 ^ r101) >> 63) | 1) > 0) goto L9;
        r102 = r102 + r101;
    L9:
        r103 = r102;
    L11:
        return r100 - r103;
    }

    public String toString() {
        return "DesugarTickClock[" + this.baseClock + "," + Duration.ofNanos(this.tickNanos) + "]";
    }

    @Override // bytedance.jvm.time.Clock
    public boolean equals(Object r100) {
        if ((r100 instanceof DesugarClock$DesugarTickClock) == false) goto L10;
        DesugarClock$DesugarTickClock r101 = (DesugarClock$DesugarTickClock) r100;
        if (this.baseClock.equals(r101.baseClock) == true) goto L7;
        return false;
    L7:
        if (this.tickNanos != r101.tickNanos) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // bytedance.jvm.time.Clock
    public Clock withZone(ZoneId r100) {
        if (r100.equals(this.baseClock.getZone()) == false) goto L6;
        return this;
    L6:
        return new DesugarClock$DesugarTickClock(this.baseClock.withZone(r100), this.tickNanos);
    }

    public DesugarClock$DesugarTickClock(Clock r100, long r101) {
        this.baseClock = r100;
        this.tickNanos = r101;
    }
}
