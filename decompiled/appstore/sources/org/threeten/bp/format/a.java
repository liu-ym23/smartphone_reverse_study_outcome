package org.threeten.bp.format;

import com.bytedance.apm.battery.config.BatteryFactorConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends ig.c implements TemporalAccessor, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f23176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.threeten.bp.chrono.e f23177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ZoneId f23178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.threeten.bp.chrono.a f23179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LocalTime f23180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Period f23182g;

    public a() {
        this.f23176a = new HashMap();
    }

    public a a(TemporalField r10, long r11) {
        ig.d.h(r10, "field");
        Long r12 = h(r10);
        if (r12 == null) goto L10;
        if (r12.longValue() == r11) goto L10;
        throw new DateTimeException("Conflict found: " + r10 + " " + r12 + " differs from " + r10 + " " + r11 + ": " + this);
    L10:
        return m(r10, r11);
    }

    public void b(LocalTime r10) {
        this.f23180e = r10;
    }

    public void c(org.threeten.bp.chrono.a r10) {
        this.f23179d = r10;
    }

    public Object d(TemporalQuery r10) {
        return r10.queryFrom(this);
    }

    public final void e(LocalDate r10) {
        if (r10 == null) goto L16;
        c(r10);
        Iterator r11 = this.f23176a.keySet().iterator();
    L5:
        if (r11.hasNext() == false) goto L28;
        TemporalField r12 = (TemporalField) r11.next();
        if ((r12 instanceof ChronoField) == false) goto L5;
        if (r12.isDateBased() == false) goto L5;
        long r13 = r10.getLong(r12);     // Catch: DateTimeException -> L17
        Long r14 = (Long) this.f23176a.get(r12);
        if (r13 == r14.longValue()) goto L5;
        throw new DateTimeException("Conflict found: Field " + r12 + " " + r13 + " differs from " + r12 + " " + r14 + " derived from " + r10);
    L28:
        return;
    }

    public final void f() {
        if (this.f23176a.size() <= 0) goto L15;
        org.threeten.bp.chrono.a r10 = this.f23179d;
        if (r10 == null) goto L9;
        LocalTime r11 = this.f23180e;
        if (r11 == null) goto L9;
        g(r10.atTime(r11));
        return;
    L9:
        if (r10 == null) goto L11;
        g(r10);
        return;
    L11:
        TemporalAccessor r12 = this.f23180e;
        if (r12 == null) goto L18;
        g(r12);
        return;
    L18:
        return;
    }

    public final void g(TemporalAccessor r10) {
        Iterator r11 = this.f23176a.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        Map.Entry r12 = (Map.Entry) r11.next();
        TemporalField r13 = (TemporalField) r12.getKey();
        long r14 = ((Long) r12.getValue()).longValue();
        if (r10.isSupported(r13) == false) goto L4;
        long r15 = r10.getLong(r13);     // Catch: RuntimeException -> L14
        if (r15 != r14) goto L12;
        r11.remove();
        goto L4
    L12:
        throw new DateTimeException("Cross check failed: " + r13 + " " + r15 + " vs " + r13 + " " + r14);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        ig.d.h(r10, "field");
        Long r11 = h(r10);
        if (r11 != null) goto L19;
        org.threeten.bp.chrono.a r12 = this.f23179d;
        if (r12 != null) goto L7;
    L10:
        LocalTime r13 = this.f23180e;
        if (r13 == null) goto L17;
        if (r13.isSupported(r10) == false) goto L17;
        return this.f23180e.getLong(r10);
    L17:
        throw new DateTimeException("Field not found: " + r10);
    L7:
        if (r12.isSupported(r10) == false) goto L10;
        return this.f23179d.getLong(r10);
    L19:
        return r11.longValue();
    }

    public final Long h(TemporalField r10) {
        return (Long) this.f23176a.get(r10);
    }

    public final void i(ResolverStyle r10) {
        if ((this.f23177b instanceof IsoChronology) == false) goto L5;
        e(IsoChronology.INSTANCE.resolveDate(this.f23176a, r10));
        return;
    L5:
        Map r11 = this.f23176a;
        ChronoField r12 = ChronoField.EPOCH_DAY;
        if (r11.containsKey(r12) == false) goto L10;
        e(LocalDate.ofEpochDay(((Long) this.f23176a.remove(r12)).longValue()));
        return;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (this.f23176a.containsKey(r10) == true) goto L15;
        org.threeten.bp.chrono.a r11 = this.f23179d;
        if (r11 != null) goto L10;
    L11:
        LocalTime r12 = this.f23180e;
        if (r12 != null) goto L14;
        return false;
    L14:
        if (r12.isSupported(r10) == true) goto L15;
        return false;
    L10:
        if (r11.isSupported(r10) == false) goto L11;
    L15:
        return true;
    }

    public final void j() {
        if (this.f23176a.containsKey(ChronoField.INSTANT_SECONDS) == false) goto L11;
        ZoneId r10 = this.f23178c;
        if (r10 == null) goto L7;
        k(r10);
        return;
    L7:
        Long r11 = (Long) this.f23176a.get(ChronoField.OFFSET_SECONDS);
        if (r11 == null) goto L13;
        k(ZoneOffset.ofTotalSeconds(r11.intValue()));
        return;
    L13:
        return;
    }

    public final void k(ZoneId r10) {
        Map r11 = this.f23176a;
        ChronoField r12 = ChronoField.INSTANT_SECONDS;
        org.threeten.bp.chrono.d r13 = this.f23177b.zonedDateTime(Instant.ofEpochSecond(((Long) r11.remove(r12)).longValue()), r10);
        if (this.f23179d != null) goto L5;
        c(r13.toLocalDate());
    L6:
        a(ChronoField.SECOND_OF_DAY, r13.toLocalTime().toSecondOfDay());
        return;
    L5:
        s(r12, r13.toLocalDate());
        goto L6
    }

    public final void l(ResolverStyle r14) {
        Map r10 = this.f23176a;
        ChronoField r11 = ChronoField.CLOCK_HOUR_OF_DAY;
        long r12 = 0;
        if (r10.containsKey(r11) == false) goto L16;
        long r13 = ((Long) this.f23176a.remove(r11)).longValue();
        if (r14 != ResolverStyle.LENIENT) goto L7;
    L12:
        ChronoField r15 = ChronoField.HOUR_OF_DAY;
        if (r13 != 24) goto L15;
        r13 = 0;
    L15:
        a(r15, r13);
        goto L16
    L7:
        if (r14 == ResolverStyle.SMART) goto L9;
    L11:
        r11.checkValidValue(r13);
        goto L12
    L9:
        if (r13 != 0) goto L11;
    L16:
        Map r16 = this.f23176a;
        ChronoField r17 = ChronoField.CLOCK_HOUR_OF_AMPM;
        if (r16.containsKey(r17) == false) goto L31;
        long r18 = ((Long) this.f23176a.remove(r17)).longValue();
        if (r14 != ResolverStyle.LENIENT) goto L21;
    L26:
        ChronoField r19 = ChronoField.HOUR_OF_AMPM;
        if (r18 == 12) goto L30;
        r12 = r18;
    L30:
        a(r19, r12);
        goto L31
    L21:
        if (r14 == ResolverStyle.SMART) goto L23;
    L25:
        r17.checkValidValue(r18);
        goto L26
    L23:
        if (r18 != 0) goto L25;
    L31:
        ResolverStyle r20 = ResolverStyle.LENIENT;
        if (r14 == r20) goto L39;
        Map r21 = this.f23176a;
        ChronoField r22 = ChronoField.AMPM_OF_DAY;
        if (r21.containsKey(r22) == false) goto L36;
        r22.checkValidValue(((Long) this.f23176a.get(r22)).longValue());
    L36:
        Map r23 = this.f23176a;
        ChronoField r24 = ChronoField.HOUR_OF_AMPM;
        if (r23.containsKey(r24) == false) goto L39;
        r24.checkValidValue(((Long) this.f23176a.get(r24)).longValue());
    L39:
        Map r25 = this.f23176a;
        ChronoField r26 = ChronoField.AMPM_OF_DAY;
        if (r25.containsKey(r26) == false) goto L44;
        Map r27 = this.f23176a;
        ChronoField r28 = ChronoField.HOUR_OF_AMPM;
        if (r27.containsKey(r28) == false) goto L44;
        long r29 = ((Long) this.f23176a.remove(r26)).longValue();
        a(ChronoField.HOUR_OF_DAY, (r29 * 12) + ((Long) this.f23176a.remove(r28)).longValue());
    L44:
        Map r30 = this.f23176a;
        ChronoField r31 = ChronoField.NANO_OF_DAY;
        if (r30.containsKey(r31) == false) goto L50;
        long r32 = ((Long) this.f23176a.remove(r31)).longValue();
        if (r14 == r20) goto L49;
        r31.checkValidValue(r32);
    L49:
        a(ChronoField.SECOND_OF_DAY, r32 / 1000000000);
        a(ChronoField.NANO_OF_SECOND, r32 % 1000000000);
    L50:
        Map r33 = this.f23176a;
        ChronoField r34 = ChronoField.MICRO_OF_DAY;
        if (r33.containsKey(r34) == false) goto L56;
        long r35 = ((Long) this.f23176a.remove(r34)).longValue();
        if (r14 == r20) goto L55;
        r34.checkValidValue(r35);
    L55:
        a(ChronoField.SECOND_OF_DAY, r35 / BatteryFactorConfig.WIFI_BPS);
        a(ChronoField.MICRO_OF_SECOND, r35 % BatteryFactorConfig.WIFI_BPS);
    L56:
        Map r36 = this.f23176a;
        ChronoField r37 = ChronoField.MILLI_OF_DAY;
        if (r36.containsKey(r37) == false) goto L62;
        long r38 = ((Long) this.f23176a.remove(r37)).longValue();
        if (r14 == r20) goto L61;
        r37.checkValidValue(r38);
    L61:
        a(ChronoField.SECOND_OF_DAY, r38 / 1000);
        a(ChronoField.MILLI_OF_SECOND, r38 % 1000);
    L62:
        Map r39 = this.f23176a;
        ChronoField r40 = ChronoField.SECOND_OF_DAY;
        if (r39.containsKey(r40) == false) goto L68;
        long r41 = ((Long) this.f23176a.remove(r40)).longValue();
        if (r14 == r20) goto L67;
        r40.checkValidValue(r41);
    L67:
        a(ChronoField.HOUR_OF_DAY, r41 / 3600);
        a(ChronoField.MINUTE_OF_HOUR, (r41 / 60) % 60);
        a(ChronoField.SECOND_OF_MINUTE, r41 % 60);
    L68:
        Map r42 = this.f23176a;
        ChronoField r43 = ChronoField.MINUTE_OF_DAY;
        if (r42.containsKey(r43) == false) goto L74;
        long r44 = ((Long) this.f23176a.remove(r43)).longValue();
        if (r14 == r20) goto L73;
        r43.checkValidValue(r44);
    L73:
        a(ChronoField.HOUR_OF_DAY, r44 / 60);
        a(ChronoField.MINUTE_OF_HOUR, r44 % 60);
    L74:
        if (r14 == r20) goto L81;
        Map r110 = this.f23176a;
        ChronoField r45 = ChronoField.MILLI_OF_SECOND;
        if (r110.containsKey(r45) == false) goto L78;
        r45.checkValidValue(((Long) this.f23176a.get(r45)).longValue());
    L78:
        Map r111 = this.f23176a;
        ChronoField r46 = ChronoField.MICRO_OF_SECOND;
        if (r111.containsKey(r46) == false) goto L81;
        r46.checkValidValue(((Long) this.f23176a.get(r46)).longValue());
    L81:
        Map r112 = this.f23176a;
        ChronoField r47 = ChronoField.MILLI_OF_SECOND;
        if (r112.containsKey(r47) == false) goto L86;
        Map r113 = this.f23176a;
        ChronoField r48 = ChronoField.MICRO_OF_SECOND;
        if (r113.containsKey(r48) == false) goto L86;
        a(r48, (((Long) this.f23176a.remove(r47)).longValue() * 1000) + (((Long) this.f23176a.get(r48)).longValue() % 1000));
    L86:
        Map r114 = this.f23176a;
        ChronoField r49 = ChronoField.MICRO_OF_SECOND;
        if (r114.containsKey(r49) == false) goto L92;
        Map r115 = this.f23176a;
        ChronoField r50 = ChronoField.NANO_OF_SECOND;
        if (r115.containsKey(r50) == false) goto L92;
        a(r49, ((Long) this.f23176a.get(r50)).longValue() / 1000);
        this.f23176a.remove(r49);
    L92:
        if (this.f23176a.containsKey(r47) == false) goto L97;
        Map r116 = this.f23176a;
        ChronoField r51 = ChronoField.NANO_OF_SECOND;
        if (r116.containsKey(r51) == false) goto L97;
        a(r47, ((Long) this.f23176a.get(r51)).longValue() / BatteryFactorConfig.WIFI_BPS);
        this.f23176a.remove(r47);
    L97:
        if (this.f23176a.containsKey(r49) == false) goto L100;
        a(ChronoField.NANO_OF_SECOND, ((Long) this.f23176a.remove(r49)).longValue() * 1000);
        return;
    L100:
        if (this.f23176a.containsKey(r47) == false) goto L104;
        a(ChronoField.NANO_OF_SECOND, ((Long) this.f23176a.remove(r47)).longValue() * BatteryFactorConfig.WIFI_BPS);
        return;
    }

    public final a m(TemporalField r10, long r11) {
        this.f23176a.put(r10, Long.valueOf(r11));
        return this;
    }

    public a n(ResolverStyle r10, Set r11) {
        if (r11 == null) goto L4;
        this.f23176a.keySet().retainAll(r11);
    L4:
        j();
        i(r10);
        l(r10);
        if (o(r10) == false) goto L7;
        j();
        i(r10);
        l(r10);
    L7:
        t(r10);
        f();
        Period r12 = this.f23182g;
        if (r12 != null) goto L10;
    L16:
        p();
        q();
        return this;
    L10:
        if (r12.isZero() == true) goto L16;
        org.threeten.bp.chrono.a r13 = this.f23179d;
        if (r13 == null) goto L16;
        if (this.f23180e == null) goto L16;
        this.f23179d = r13.plus(this.f23182g);
        this.f23182g = Period.ZERO;
        goto L16
    }

    public final boolean o(ResolverStyle r10) {
        int r11 = 0;
    L4:
        if (r11 >= 100) goto L35;
        Iterator r12 = this.f23176a.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L35;
        TemporalField r13 = (TemporalField) ((Map.Entry) r12.next()).getKey();
        TemporalAccessor r14 = r13.resolve(this.f23176a, this, r10);
        if (r14 != null) goto L11;
        if (this.f23176a.containsKey(r13) == true) goto L7;
    L23:
        r11 = r11 + 1;
        goto L4
    L11:
        if ((r14 instanceof org.threeten.bp.chrono.d) == false) goto L21;
        org.threeten.bp.chrono.d r15 = (org.threeten.bp.chrono.d) r14;
        ZoneId r16 = this.f23178c;
        if (r16 != null) goto L16;
        this.f23178c = r15.getZone();
    L17:
        r14 = r15.toLocalDateTime();
        goto L21
    L16:
        if (r16.equals(r15.getZone()) == true) goto L17;
        throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + this.f23178c);
    L21:
        if ((r14 instanceof org.threeten.bp.chrono.a) == false) goto L25;
        s(r13, (org.threeten.bp.chrono.a) r14);
        goto L23
    L25:
        if ((r14 instanceof LocalTime) == false) goto L28;
        r(r13, (LocalTime) r14);
        goto L23
    L28:
        if ((r14 instanceof org.threeten.bp.chrono.b) == false) goto L31;
        org.threeten.bp.chrono.b r17 = (org.threeten.bp.chrono.b) r14;
        s(r13, r17.toLocalDate());
        r(r13, r17.toLocalTime());
        goto L23
    L31:
        throw new DateTimeException("Unknown type: " + r14.getClass().getName());
    L35:
        if (r11 == 100) goto L40;
        if (r11 <= 0) goto L51;
        return true;
    L51:
        return false;
    L40:
        throw new DateTimeException("Badly written field");
    }

    public final void p() {
        if (this.f23180e == null) goto L5;
        return;
    L5:
        if (this.f23176a.containsKey(ChronoField.INSTANT_SECONDS) == false) goto L7;
    L10:
        Map r10 = this.f23176a;
        ChronoField r11 = ChronoField.NANO_OF_SECOND;
        if (r10.containsKey(r11) == false) goto L13;
        long r12 = ((Long) this.f23176a.get(r11)).longValue();
        this.f23176a.put(ChronoField.MICRO_OF_SECOND, Long.valueOf(r12 / 1000));
        this.f23176a.put(ChronoField.MILLI_OF_SECOND, Long.valueOf(r12 / BatteryFactorConfig.WIFI_BPS));
        return;
    L13:
        this.f23176a.put(r11, 0L);
        this.f23176a.put(ChronoField.MICRO_OF_SECOND, 0L);
        this.f23176a.put(ChronoField.MILLI_OF_SECOND, 0L);
        return;
    L7:
        if (this.f23176a.containsKey(ChronoField.SECOND_OF_DAY) == true) goto L10;
        if (this.f23176a.containsKey(ChronoField.SECOND_OF_MINUTE) == true) goto L10;
    }

    public final void q() {
        org.threeten.bp.chrono.a r10 = this.f23179d;
        if (r10 == null) goto L13;
        LocalTime r11 = this.f23180e;
        if (r11 != null) goto L7;
        return;
    L7:
        if (this.f23178c == null) goto L9;
        org.threeten.bp.chrono.d r12 = r10.atTime(r11).atZone(this.f23178c);
        ChronoField r13 = ChronoField.INSTANT_SECONDS;
        long r14 = r12.getLong(r13);
        this.f23176a.put(r13, Long.valueOf(r14));
        return;
    L9:
        Long r15 = (Long) this.f23176a.get(ChronoField.OFFSET_SECONDS);
        if (r15 == null) goto L16;
        ZoneOffset r16 = ZoneOffset.ofTotalSeconds(r15.intValue());
        org.threeten.bp.chrono.d r17 = this.f23179d.atTime(this.f23180e).atZone(r16);
        ChronoField r18 = ChronoField.INSTANT_SECONDS;
        long r19 = r17.getLong(r18);
        this.f23176a.put(r18, Long.valueOf(r19));
        return;
    L16:
        return;
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public Object query(TemporalQuery r10) {
        if (r10 != org.threeten.bp.temporal.b.g()) goto L7;
        return this.f23178c;
    L7:
        if (r10 != org.threeten.bp.temporal.b.a()) goto L11;
        return this.f23177b;
    L11:
        if (r10 != org.threeten.bp.temporal.b.b()) goto L17;
        org.threeten.bp.chrono.a r11 = this.f23179d;
        if (r11 != null) goto L15;
        return null;
    L15:
        return LocalDate.from(r11);
    L17:
        if (r10 != org.threeten.bp.temporal.b.c()) goto L21;
        return this.f23180e;
    L21:
        if (r10 == org.threeten.bp.temporal.b.f()) goto L31;
        if (r10 == org.threeten.bp.temporal.b.d()) goto L31;
        if (r10 != org.threeten.bp.temporal.b.e()) goto L29;
        return null;
    L29:
        return r10.queryFrom(this);
    L31:
        return r10.queryFrom(this);
    }

    public final void r(TemporalField r10, LocalTime r11) {
        long r12 = r11.toNanoOfDay();
        Long r13 = (Long) this.f23176a.put(ChronoField.NANO_OF_DAY, Long.valueOf(r12));
        if (r13 != null) goto L5;
        return;
    L5:
        if (r13.longValue() != r12) goto L8;
        return;
    L8:
        throw new DateTimeException("Conflict found: " + LocalTime.ofNanoOfDay(r13.longValue()) + " differs from " + r11 + " while resolving  " + r10);
    }

    public final void s(TemporalField r10, org.threeten.bp.chrono.a r11) {
        if (this.f23177b.equals(r11.getChronology()) == false) goto L13;
        long r12 = r11.toEpochDay();
        Long r13 = (Long) this.f23176a.put(ChronoField.EPOCH_DAY, Long.valueOf(r12));
        if (r13 != null) goto L7;
        return;
    L7:
        if (r13.longValue() != r12) goto L10;
        return;
    L10:
        throw new DateTimeException("Conflict found: " + LocalDate.ofEpochDay(r13.longValue()) + " differs from " + LocalDate.ofEpochDay(r12) + " while resolving  " + r10);
    L13:
        throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.f23177b);
    }

    public final void t(ResolverStyle r19) {
        Map r10 = this.f23176a;
        ChronoField r11 = ChronoField.HOUR_OF_DAY;
        Long r12 = (Long) r10.get(r11);
        Map r13 = this.f23176a;
        ChronoField r14 = ChronoField.MINUTE_OF_HOUR;
        Long r15 = (Long) r13.get(r14);
        Map r16 = this.f23176a;
        ChronoField r17 = ChronoField.SECOND_OF_MINUTE;
        Long r18 = (Long) r16.get(r17);
        Map r20 = this.f23176a;
        ChronoField r21 = ChronoField.NANO_OF_SECOND;
        Long r22 = (Long) r20.get(r21);
        if (r12 != null) goto L5;
        return;
    L5:
        if (r15 != null) goto L9;
        if (r18 != null) goto L8;
        if (r22 == null) goto L9;
        return;
    L8:
        return;
    L9:
        if (r15 == null) goto L14;
        if (r18 != null) goto L14;
        if (r22 == null) goto L14;
        return;
    L14:
        if (r19 != ResolverStyle.LENIENT) goto L16;
        long r23 = r12.longValue();
        if (r15 == null) goto L49;
        if (r18 == null) goto L48;
        if (r22 != null) goto L47;
        r22 = 0L;
    L47:
        long r24 = ig.d.j(ig.d.j(ig.d.j(ig.d.m(r23, 3600000000000L), ig.d.m(r15.longValue(), 60000000000L)), ig.d.m(r18.longValue(), 1000000000)), r22.longValue());
        int r25 = (int) ig.d.d(r24, 86400000000000L);
        b(LocalTime.ofNanoOfDay(ig.d.g(r24, 86400000000000L)));
        this.f23182g = Period.ofDays(r25);
    L50:
        this.f23176a.remove(r11);
        this.f23176a.remove(r14);
        this.f23176a.remove(r17);
        this.f23176a.remove(r21);
        return;
    L48:
        long r26 = ig.d.j(ig.d.m(r23, 3600), ig.d.m(r15.longValue(), 60));
        int r27 = (int) ig.d.d(r26, 86400);
        b(LocalTime.ofSecondOfDay(ig.d.g(r26, 86400)));
        this.f23182g = Period.ofDays(r27);
        goto L50
    L49:
        int r28 = ig.d.p(ig.d.d(r23, 24));
        b(LocalTime.of(ig.d.f(r23, 24), 0));
        this.f23182g = Period.ofDays(r28);
        goto L50
    L16:
        if (r19 == ResolverStyle.SMART) goto L18;
    L29:
        int r29 = r11.checkValidIntValue(r12.longValue());
        if (r15 == null) goto L39;
        int r30 = r14.checkValidIntValue(r15.longValue());
        if (r18 == null) goto L37;
        int r31 = r17.checkValidIntValue(r18.longValue());
        if (r22 == null) goto L36;
        b(LocalTime.of(r29, r30, r31, r21.checkValidIntValue(r22.longValue())));
        goto L50
    L36:
        b(LocalTime.of(r29, r30, r31));
        goto L50
    L37:
        if (r22 != null) goto L50;
        b(LocalTime.of(r29, r30));
        goto L50
    L39:
        if (r18 != null) goto L50;
        if (r22 != null) goto L50;
        b(LocalTime.of(r29, 0));
        goto L50
    L18:
        if (r12.longValue() != 24) goto L29;
        if (r15 != null) goto L21;
    L22:
        if (r18 != null) goto L24;
    L25:
        if (r22 != null) goto L27;
    L28:
        r12 = 0L;
        this.f23182g = Period.ofDays(1);
        goto L29
    L27:
        if (r22.longValue() != 0) goto L29;
    L24:
        if (r18.longValue() != 0) goto L29;
    L21:
        if (r15.longValue() != 0) goto L29;
        goto L22
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder(128);
        r10.append("DateTimeBuilder[");
        if (this.f23176a.size() <= 0) goto L5;
        r10.append("fields=");
        r10.append(this.f23176a);
    L5:
        r10.append(", ");
        r10.append(this.f23177b);
        r10.append(", ");
        r10.append(this.f23178c);
        r10.append(", ");
        r10.append(this.f23179d);
        r10.append(", ");
        r10.append(this.f23180e);
        r10.append(']');
        return r10.toString();
    }
}
