package org.threeten.bp.format;

import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TemporalAccessor f23197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Locale f23198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f23199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23200d;

    public static class a extends ig.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ org.threeten.bp.chrono.a f23201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TemporalAccessor f23202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ org.threeten.bp.chrono.e f23203c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ZoneId f23204d;

        public a(org.threeten.bp.chrono.a r10, TemporalAccessor r11, org.threeten.bp.chrono.e r12, ZoneId r13) {
            this.f23201a = r10;
            this.f23202b = r11;
            this.f23203c = r12;
            this.f23204d = r13;
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public long getLong(TemporalField r10) {
            if (this.f23201a == null) goto L9;
            if (r10.isDateBased() == false) goto L9;
            return this.f23201a.getLong(r10);
        L9:
            return this.f23202b.getLong(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public boolean isSupported(TemporalField r10) {
            if (this.f23201a == null) goto L9;
            if (r10.isDateBased() == false) goto L9;
            return this.f23201a.isSupported(r10);
        L9:
            return this.f23202b.isSupported(r10);
        }

        @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
        public Object query(TemporalQuery r10) {
            if (r10 != org.threeten.bp.temporal.b.a()) goto L7;
            return this.f23203c;
        L7:
            if (r10 != org.threeten.bp.temporal.b.g()) goto L11;
            return this.f23204d;
        L11:
            if (r10 != org.threeten.bp.temporal.b.e()) goto L15;
            return this.f23202b.query(r10);
        L15:
            return r10.queryFrom(this);
        }

        @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
        public ValueRange range(TemporalField r10) {
            if (this.f23201a == null) goto L9;
            if (r10.isDateBased() == false) goto L9;
            return this.f23201a.range(r10);
        L9:
            return this.f23202b.range(r10);
        }
    }

    public c(TemporalAccessor r10, DateTimeFormatter r11) {
        this.f23197a = a(r10, r11);
        this.f23198b = r11.h();
        this.f23199c = r11.g();
    }

    public static TemporalAccessor a(TemporalAccessor r10, DateTimeFormatter r11) {
        org.threeten.bp.chrono.e r12 = r11.f();
        ZoneId r13 = r11.k();
        if (r12 != null) goto L6;
        if (r13 != null) goto L6;
        return r10;
    L6:
        org.threeten.bp.chrono.e r14 = (org.threeten.bp.chrono.e) r10.query(org.threeten.bp.temporal.b.a());
        ZoneId r15 = (ZoneId) r10.query(org.threeten.bp.temporal.b.g());
        org.threeten.bp.chrono.a r16 = null;
        if (ig.d.c(r14, r12) == false) goto L10;
        r12 = null;
    L10:
        if (ig.d.c(r15, r13) == false) goto L12;
        r13 = null;
    L12:
        if (r12 != null) goto L15;
        if (r13 != null) goto L15;
        return r10;
    L15:
        if (r12 == null) goto L17;
        org.threeten.bp.chrono.e r17 = r12;
    L18:
        if (r13 == null) goto L21;
        r15 = r13;
    L21:
        if (r13 != null) goto L23;
    L37:
        if (r12 == null) goto L55;
        if (r10.isSupported(ChronoField.EPOCH_DAY) == false) goto L42;
        r16 = r17.date(r10);
        goto L55
    L42:
        if (r12 != IsoChronology.INSTANCE) goto L44;
        if (r14 == null) goto L55;
    L44:
        ChronoField[] r18 = ChronoField.values();
        int r19 = r18.length;
        int r20 = 0;
    L45:
        if (r20 >= r19) goto L55;
        ChronoField r21 = r18[r20];
        if (r21.isDateBased() == false) goto L53;
        if (r10.isSupported(r21) == false) goto L53;
        throw new DateTimeException("Invalid override chronology for temporal: " + r12 + " " + r10);
    L53:
        r20 = r20 + 1;
    L55:
        return new a(r16, r10, r17, r15);
    L23:
        if (r10.isSupported(ChronoField.INSTANT_SECONDS) == false) goto L29;
        if (r17 != null) goto L28;
        r17 = IsoChronology.INSTANCE;
    L28:
        return r17.zonedDateTime(Instant.from(r10), r13);
    L29:
        ZoneId r22 = r13.normalized();
        ZoneOffset r23 = (ZoneOffset) r10.query(org.threeten.bp.temporal.b.d());
        if ((r22 instanceof ZoneOffset) == false) goto L37;
        if (r23 == null) goto L37;
        if (r22.equals(r23) == true) goto L37;
        throw new DateTimeException("Invalid override zone for temporal: " + r13 + " " + r10);
    L17:
        r17 = r14;
        goto L18
    }

    public void b() {
        this.f23200d--;
    }

    public Locale c() {
        return this.f23198b;
    }

    public e d() {
        return this.f23199c;
    }

    public TemporalAccessor e() {
        return this.f23197a;
    }

    public Long f(TemporalField r10) {
        return Long.valueOf(this.f23197a.getLong(r10));
    L4:
        e = move-exception;
        if (this.f23200d <= 0) goto L9;
        return null;
    L9:
        throw e;
    }

    public Object g(TemporalQuery r10) {
        Object r11 = this.f23197a.query(r10);
        if (r11 == null) goto L5;
    L9:
        return r11;
    L5:
        if (this.f23200d != 0) goto L9;
        throw new DateTimeException("Unable to extract value: " + this.f23197a.getClass());
    }

    public void h() {
        this.f23200d++;
    }

    public String toString() {
        return this.f23197a.toString();
    }
}
