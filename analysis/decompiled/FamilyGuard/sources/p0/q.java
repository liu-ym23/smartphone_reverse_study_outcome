package p0;

import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.TimeZone;
import l0.AbstractC0822a;
import o0.C0888a;
import o0.C0893f;
import o0.InterfaceC0890c;
import org.libpag.BuildConfig;
import q0.C0946I;
import q0.C0963j;
import q0.InterfaceC0973u;
import q0.U;
import q0.e0;
import q0.f0;

/* loaded from: classes.dex */
public class q extends AbstractC0918e implements U, InterfaceC0973u, t {

    /* renamed from: a, reason: collision with root package name */
    public static final q f19317a = new q();

    /* renamed from: b, reason: collision with root package name */
    private static final DateTimeFormatter f19318b = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /* renamed from: c, reason: collision with root package name */
    private static final DateTimeFormatter f19319c = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /* renamed from: d, reason: collision with root package name */
    private static final DateTimeFormatter f19320d = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /* renamed from: e, reason: collision with root package name */
    private static final DateTimeFormatter f19321e = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");

    /* renamed from: f, reason: collision with root package name */
    private static final DateTimeFormatter f19322f = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");

    /* renamed from: g, reason: collision with root package name */
    private static final DateTimeFormatter f19323g = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");

    /* renamed from: h, reason: collision with root package name */
    private static final DateTimeFormatter f19324h = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    /* renamed from: i, reason: collision with root package name */
    private static final DateTimeFormatter f19325i = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /* renamed from: j, reason: collision with root package name */
    private static final DateTimeFormatter f19326j = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    /* renamed from: k, reason: collision with root package name */
    private static final DateTimeFormatter f19327k = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /* renamed from: l, reason: collision with root package name */
    private static final DateTimeFormatter f19328l = DateTimeFormatter.ofPattern("yyyyMMdd");

    /* renamed from: m, reason: collision with root package name */
    private static final DateTimeFormatter f19329m = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /* renamed from: n, reason: collision with root package name */
    private static final DateTimeFormatter f19330n = DateTimeFormatter.ofPattern("yyyy年M月d日");

    /* renamed from: o, reason: collision with root package name */
    private static final DateTimeFormatter f19331o = DateTimeFormatter.ofPattern("yyyy년M월d일");

    /* renamed from: p, reason: collision with root package name */
    private static final DateTimeFormatter f19332p = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /* renamed from: q, reason: collision with root package name */
    private static final DateTimeFormatter f19333q = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /* renamed from: r, reason: collision with root package name */
    private static final DateTimeFormatter f19334r = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /* renamed from: s, reason: collision with root package name */
    private static final DateTimeFormatter f19335s = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /* renamed from: t, reason: collision with root package name */
    private static final DateTimeFormatter f19336t = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

    /* renamed from: u, reason: collision with root package name */
    private static final DateTimeFormatter f19337u = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static Object g(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (str == null) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        return LocalDateTime.parse(obj.toString(), DateTimeFormatter.ofPattern(str));
    }

    private void k(e0 e0Var, TemporalAccessor temporalAccessor, String str) {
        if ("unixtime".equals(str)) {
            if (temporalAccessor instanceof ChronoZonedDateTime) {
                e0Var.V((int) ((ChronoZonedDateTime) temporalAccessor).toEpochSecond());
                return;
            } else if (temporalAccessor instanceof LocalDateTime) {
                e0Var.V((int) ((LocalDateTime) temporalAccessor).atZone(AbstractC0822a.f18016a.toZoneId()).toEpochSecond());
                return;
            }
        }
        if ("millis".equals(str)) {
            Instant instant = temporalAccessor instanceof ChronoZonedDateTime ? ((ChronoZonedDateTime) temporalAccessor).toInstant() : temporalAccessor instanceof LocalDateTime ? ((LocalDateTime) temporalAccessor).atZone(AbstractC0822a.f18016a.toZoneId()).toInstant() : null;
            if (instant != null) {
                e0Var.X(instant.toEpochMilli());
                return;
            }
        }
        e0Var.h0((str == "yyyy-MM-dd'T'HH:mm:ss" ? f19337u : DateTimeFormatter.ofPattern(str)).format(temporalAccessor));
    }

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.Y();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type != LocalDateTime.class) {
            e0Var.h0(obj.toString());
            return;
        }
        f0 f0Var = f0.UseISO8601DateFormat;
        int iB = f0Var.b();
        LocalDateTime localDateTime = (LocalDateTime) obj;
        String strV = c0946i.v();
        if (strV == null) {
            strV = "yyyy-MM-dd'T'HH:mm:ss";
            if ((i5 & iB) == 0 && !c0946i.A(f0Var)) {
                if (c0946i.A(f0.WriteDateUseDateFormat)) {
                    strV = (c0946i.w() == null || c0946i.w().length() <= 0) ? AbstractC0822a.f18020e : c0946i.w();
                } else {
                    int nano = localDateTime.getNano();
                    if (nano != 0) {
                        strV = nano % 1000000 == 0 ? "yyyy-MM-dd'T'HH:mm:ss.SSS" : "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
                    }
                }
            }
        }
        if (strV != null) {
            k(e0Var, localDateTime, strV);
        } else {
            e0Var.X(localDateTime.atZone(AbstractC0822a.f18016a.toZoneId()).toInstant().toEpochMilli());
        }
    }

    @Override // q0.InterfaceC0973u
    public void c(C0946I c0946i, Object obj, C0963j c0963j) {
        k(c0946i.f19676k, (TemporalAccessor) obj, c0963j.b());
    }

    @Override // p0.t
    public int d() {
        return 4;
    }

    @Override // p0.AbstractC0918e
    public <T> T f(C0888a c0888a, Type type, Object obj, String str, int i5) {
        Long lP;
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() == 8) {
            interfaceC0890c.nextToken();
            return null;
        }
        if (interfaceC0890c.U() == 4) {
            String strN = interfaceC0890c.N();
            interfaceC0890c.nextToken();
            DateTimeFormatter dateTimeFormatterOfPattern = str != null ? "yyyy-MM-dd HH:mm:ss".equals(str) ? f19318b : DateTimeFormatter.ofPattern(str) : null;
            if (BuildConfig.FLAVOR.equals(strN)) {
                return null;
            }
            if (type == LocalDateTime.class) {
                return (strN.length() == 10 || strN.length() == 8) ? (T) LocalDateTime.of(i(strN, str, dateTimeFormatterOfPattern), LocalTime.MIN) : (T) h(strN, dateTimeFormatterOfPattern);
            }
            if (type == LocalDate.class) {
                if (strN.length() != 23) {
                    return (T) i(strN, str, dateTimeFormatterOfPattern);
                }
                LocalDateTime localDateTime = LocalDateTime.parse(strN);
                return (T) LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
            }
            int i6 = 0;
            if (type == LocalTime.class) {
                if (strN.length() == 23) {
                    LocalDateTime localDateTime2 = LocalDateTime.parse(strN);
                    return (T) LocalTime.of(localDateTime2.getHour(), localDateTime2.getMinute(), localDateTime2.getSecond(), localDateTime2.getNano());
                }
                while (true) {
                    if (i6 < strN.length()) {
                        char cCharAt = strN.charAt(i6);
                        if (cCharAt < '0' || cCharAt > '9') {
                            break;
                        }
                        i6++;
                    } else if (strN.length() > 8 && strN.length() < 19) {
                        return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(strN)), AbstractC0822a.f18016a.toZoneId()).toLocalTime();
                    }
                }
                return (T) LocalTime.parse(strN);
            }
            if (type == ZonedDateTime.class) {
                if (dateTimeFormatterOfPattern == f19318b) {
                    dateTimeFormatterOfPattern = f19336t;
                }
                if (dateTimeFormatterOfPattern == null && strN.length() <= 19) {
                    C0893f c0893f = new C0893f(strN);
                    TimeZone timeZoneO = c0888a.f18948f.O();
                    c0893f.k1(timeZoneO);
                    if (c0893f.t1(false)) {
                        return (T) ZonedDateTime.ofInstant(c0893f.F0().getTime().toInstant(), timeZoneO.toZoneId());
                    }
                }
                return (T) j(strN, dateTimeFormatterOfPattern);
            }
            if (type == OffsetDateTime.class) {
                return (T) OffsetDateTime.parse(strN);
            }
            if (type == OffsetTime.class) {
                return (T) OffsetTime.parse(strN);
            }
            if (type == ZoneId.class) {
                return (T) ZoneId.of(strN);
            }
            if (type == Period.class) {
                return (T) Period.parse(strN);
            }
            if (type == Duration.class) {
                return (T) Duration.parse(strN);
            }
            if (type == Instant.class) {
                while (true) {
                    if (i6 < strN.length()) {
                        char cCharAt2 = strN.charAt(i6);
                        if (cCharAt2 < '0' || cCharAt2 > '9') {
                            break;
                        }
                        i6++;
                    } else if (strN.length() > 8 && strN.length() < 19) {
                        return (T) Instant.ofEpochMilli(Long.parseLong(strN));
                    }
                }
                return (T) Instant.parse(strN);
            }
        } else {
            if (interfaceC0890c.U() == 2) {
                long jF = interfaceC0890c.f();
                interfaceC0890c.nextToken();
                if ("unixtime".equals(str)) {
                    jF *= 1000;
                } else if ("yyyyMMddHHmmss".equals(str)) {
                    int i7 = (int) (jF / 10000000000L);
                    int i8 = (int) ((jF / 100000000) % 100);
                    int i9 = (int) ((jF / 1000000) % 100);
                    int i10 = (int) ((jF / 10000) % 100);
                    int i11 = (int) ((jF / 100) % 100);
                    int i12 = (int) (jF % 100);
                    if (type == LocalDateTime.class) {
                        return (T) LocalDateTime.of(i7, i8, i9, i10, i11, i12);
                    }
                }
                if (type == LocalDateTime.class) {
                    return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(jF), AbstractC0822a.f18016a.toZoneId());
                }
                if (type == LocalDate.class) {
                    return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(jF), AbstractC0822a.f18016a.toZoneId()).toLocalDate();
                }
                if (type == LocalTime.class) {
                    return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(jF), AbstractC0822a.f18016a.toZoneId()).toLocalTime();
                }
                if (type == ZonedDateTime.class) {
                    return (T) ZonedDateTime.ofInstant(Instant.ofEpochMilli(jF), AbstractC0822a.f18016a.toZoneId());
                }
                if (type == Instant.class) {
                    return (T) Instant.ofEpochMilli(jF);
                }
                throw new UnsupportedOperationException();
            }
            if (interfaceC0890c.U() != 12) {
                throw new UnsupportedOperationException();
            }
            l0.e eVarN0 = c0888a.n0();
            if (type == Instant.class) {
                Object obj2 = eVarN0.get("epochSecond");
                Object obj3 = eVarN0.get("nano");
                boolean z5 = obj2 instanceof Number;
                if (z5 && (obj3 instanceof Number)) {
                    return (T) Instant.ofEpochSecond(u0.o.C0((Number) obj2), u0.o.C0((Number) obj3));
                }
                if (z5) {
                    return (T) Instant.ofEpochSecond(u0.o.C0((Number) obj2));
                }
            } else if (type == Duration.class && (lP = eVarN0.P("seconds")) != null) {
                return (T) Duration.ofSeconds(lP.longValue(), eVarN0.Q("nano"));
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.time.LocalDateTime h(java.lang.String r17, java.time.format.DateTimeFormatter r18) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.q.h(java.lang.String, java.time.format.DateTimeFormatter):java.time.LocalDateTime");
    }

    protected LocalDate i(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = f19328l;
            }
            int i5 = 0;
            if (str.length() == 10) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter = f19329m;
                }
                char cCharAt3 = str.charAt(0);
                char cCharAt4 = str.charAt(1);
                char cCharAt5 = str.charAt(2);
                char cCharAt6 = str.charAt(3);
                char cCharAt7 = str.charAt(5);
                if (cCharAt5 == '/' && cCharAt7 == '/') {
                    int i6 = ((cCharAt6 - '0') * 10) + (cCharAt - '0');
                    if (((cCharAt3 - '0') * 10) + (cCharAt4 - '0') > 12) {
                        dateTimeFormatter3 = f19333q;
                    } else if (i6 > 12) {
                        dateTimeFormatter3 = f19332p;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = f19332p;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = f19333q;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (cCharAt5 == '.' && cCharAt7 == '.') {
                    dateTimeFormatter = f19334r;
                } else if (cCharAt5 == '-' && cCharAt7 == '-') {
                    dateTimeFormatter = f19335s;
                }
            }
            if (str.length() >= 9) {
                char cCharAt8 = str.charAt(4);
                if (cCharAt8 == 24180) {
                    dateTimeFormatter2 = f19330n;
                } else if (cCharAt8 == 45380) {
                    dateTimeFormatter2 = f19331o;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            while (true) {
                if (i5 < str.length()) {
                    char cCharAt9 = str.charAt(i5);
                    if (cCharAt9 < '0' || cCharAt9 > '9') {
                        break;
                    }
                    i5++;
                } else if (str.length() > 8 && str.length() < 19) {
                    return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), AbstractC0822a.f18016a.toZoneId()).toLocalDate();
                }
            }
        }
        return dateTimeFormatter == null ? LocalDate.parse(str) : LocalDate.parse(str, dateTimeFormatter);
    }

    protected ZonedDateTime j(String str, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            int i5 = 0;
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 == ':' && cCharAt5 == ':') {
                    if (cCharAt == '-' && cCharAt2 == '-') {
                        if (cCharAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (cCharAt3 == ' ') {
                            dateTimeFormatter = f19318b;
                        }
                    } else if (cCharAt == '/' && cCharAt2 == '/') {
                        dateTimeFormatter = f19320d;
                    } else {
                        char cCharAt6 = str.charAt(0);
                        char cCharAt7 = str.charAt(1);
                        char cCharAt8 = str.charAt(2);
                        char cCharAt9 = str.charAt(3);
                        char cCharAt10 = str.charAt(5);
                        if (cCharAt8 == '/' && cCharAt10 == '/') {
                            int i6 = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                            if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                                dateTimeFormatter = f19325i;
                            } else if (i6 > 12) {
                                dateTimeFormatter = f19324h;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = f19324h;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = f19325i;
                                }
                            }
                        } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                            dateTimeFormatter = f19326j;
                        } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                            dateTimeFormatter = f19327k;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char cCharAt11 = str.charAt(4);
                if (cCharAt11 == 24180) {
                    dateTimeFormatter2 = str.charAt(str.length() - 1) == 31186 ? f19322f : f19321e;
                } else if (cCharAt11 == 45380) {
                    dateTimeFormatter2 = f19323g;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            while (true) {
                if (i5 < str.length()) {
                    char cCharAt12 = str.charAt(i5);
                    if (cCharAt12 < '0' || cCharAt12 > '9') {
                        break;
                    }
                    i5++;
                } else if (str.length() > 8 && str.length() < 19) {
                    return ZonedDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), AbstractC0822a.f18016a.toZoneId());
                }
            }
        }
        return dateTimeFormatter == null ? ZonedDateTime.parse(str) : ZonedDateTime.parse(str, dateTimeFormatter);
    }
}
