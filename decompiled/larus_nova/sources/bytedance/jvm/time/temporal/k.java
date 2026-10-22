package bytedance.jvm.time.temporal;

import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;

/* JADX INFO: loaded from: classes28.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21714a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f21715b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f21716c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f21717d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f21718e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f21719f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f21720g = null;

    public class a implements l<ZoneId> {
        public a() {
        }

        public final String toString() {
            return "ZoneId";
        }

        @Override // bytedance.jvm.time.temporal.l
        public final ZoneId a(bytedance.jvm.time.temporal.d r100) {
            return (ZoneId) r100.query(k.f21714a);
        }
    }

    public class b implements l<bytedance.jvm.time.chrono.j> {
        public b() {
        }

        public final String toString() {
            return "Chronology";
        }

        @Override // bytedance.jvm.time.temporal.l
        public final bytedance.jvm.time.chrono.j a(bytedance.jvm.time.temporal.d r100) {
            return (bytedance.jvm.time.chrono.j) r100.query(k.f21715b);
        }
    }

    public class c implements l<m> {
        public c() {
        }

        public final String toString() {
            return "Precision";
        }

        @Override // bytedance.jvm.time.temporal.l
        public final m a(bytedance.jvm.time.temporal.d r100) {
            return (m) r100.query(k.f21716c);
        }
    }

    public class d implements l<ZoneOffset> {
        public d() {
        }

        public final String toString() {
            return "ZoneOffset";
        }

        @Override // bytedance.jvm.time.temporal.l
        public final ZoneOffset a(bytedance.jvm.time.temporal.d r100) {
            ChronoField r101 = ChronoField.OFFSET_SECONDS;
            if (r100.isSupported(r101) == true) goto L7;
            return null;
        L7:
            return ZoneOffset.ofTotalSeconds(r100.get(r101));
        }
    }

    public class e implements l<ZoneId> {
        public e() {
        }

        public final String toString() {
            return "Zone";
        }

        @Override // bytedance.jvm.time.temporal.l
        public final ZoneId a(bytedance.jvm.time.temporal.d r100) {
            ZoneId r101 = (ZoneId) r100.query(k.f21714a);
            if (r101 == null) goto L6;
            return r101;
        L6:
            return (ZoneId) r100.query(k.f21717d);
        }
    }

    public class f implements l<LocalDate> {
        public f() {
        }

        public final String toString() {
            return "LocalDate";
        }

        @Override // bytedance.jvm.time.temporal.l
        public final LocalDate a(bytedance.jvm.time.temporal.d r100) {
            ChronoField r101 = ChronoField.EPOCH_DAY;
            if (r100.isSupported(r101) == true) goto L7;
            return null;
        L7:
            return LocalDate.ofEpochDay(r100.getLong(r101));
        }
    }

    public class g implements l<LocalTime> {
        public g() {
        }

        public final String toString() {
            return "LocalTime";
        }

        @Override // bytedance.jvm.time.temporal.l
        public final LocalTime a(bytedance.jvm.time.temporal.d r100) {
            ChronoField r101 = ChronoField.NANO_OF_DAY;
            if (r100.isSupported(r101) == true) goto L7;
            return null;
        L7:
            return LocalTime.ofNanoOfDay(r100.getLong(r101));
        }
    }

    static {
        f21714a = new a();
        f21715b = new b();
        f21716c = new c();
        f21717d = new d();
        f21718e = new e();
        f21719f = new f();
        f21720g = new g();
    }
}
