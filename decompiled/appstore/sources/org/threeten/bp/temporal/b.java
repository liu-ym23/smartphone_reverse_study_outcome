package org.threeten.bp.temporal;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TemporalQuery f23236a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TemporalQuery f23237b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TemporalQuery f23238c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TemporalQuery f23239d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TemporalQuery f23240e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TemporalQuery f23241f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final TemporalQuery f23242g = null;

    public static class a implements TemporalQuery {
        public a() {
        }

        public ZoneId a(TemporalAccessor r10) {
            return (ZoneId) r10.query(this);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    /* JADX INFO: renamed from: org.threeten.bp.temporal.b$b, reason: collision with other inner class name */
    public static class C0335b implements TemporalQuery {
        public C0335b() {
        }

        public org.threeten.bp.chrono.e a(TemporalAccessor r10) {
            return (org.threeten.bp.chrono.e) r10.query(this);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static class c implements TemporalQuery {
        public c() {
        }

        public TemporalUnit a(TemporalAccessor r10) {
            return (TemporalUnit) r10.query(this);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static class d implements TemporalQuery {
        public d() {
        }

        public ZoneId a(TemporalAccessor r10) {
            ZoneId r11 = (ZoneId) r10.query(b.f23236a);
            if (r11 == null) goto L6;
            return r11;
        L6:
            return (ZoneId) r10.query(b.f23240e);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static class e implements TemporalQuery {
        public e() {
        }

        public ZoneOffset a(TemporalAccessor r10) {
            ChronoField r11 = ChronoField.OFFSET_SECONDS;
            if (r10.isSupported(r11) == true) goto L5;
            return null;
        L5:
            return ZoneOffset.ofTotalSeconds(r10.get(r11));
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static class f implements TemporalQuery {
        public f() {
        }

        public LocalDate a(TemporalAccessor r10) {
            ChronoField r11 = ChronoField.EPOCH_DAY;
            if (r10.isSupported(r11) == true) goto L5;
            return null;
        L5:
            return LocalDate.ofEpochDay(r10.getLong(r11));
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static class g implements TemporalQuery {
        public g() {
        }

        public LocalTime a(TemporalAccessor r10) {
            ChronoField r11 = ChronoField.NANO_OF_DAY;
            if (r10.isSupported(r11) == true) goto L5;
            return null;
        L5:
            return LocalTime.ofNanoOfDay(r10.getLong(r11));
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    static {
        f23236a = new a();
        f23237b = new C0335b();
        f23238c = new c();
        f23239d = new d();
        f23240e = new e();
        f23241f = new f();
        f23242g = new g();
    }

    public static final TemporalQuery a() {
        return f23237b;
    }

    public static final TemporalQuery b() {
        return f23241f;
    }

    public static final TemporalQuery c() {
        return f23242g;
    }

    public static final TemporalQuery d() {
        return f23240e;
    }

    public static final TemporalQuery e() {
        return f23238c;
    }

    public static final TemporalQuery f() {
        return f23239d;
    }

    public static final TemporalQuery g() {
        return f23236a;
    }
}
