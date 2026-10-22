package q0;

import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TimeZone;
import l0.AbstractC0822a;
import o0.C0888a;
import o0.InterfaceC0890c;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.libpag.BuildConfig;

/* renamed from: q0.K, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0948K implements U, InterfaceC0973u, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static final C0948K f19691a = new C0948K();

    /* renamed from: b, reason: collision with root package name */
    private static final DateTimeFormatter f19692b = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    /* renamed from: c, reason: collision with root package name */
    private static final DateTimeFormatter f19693c = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /* renamed from: d, reason: collision with root package name */
    private static final DateTimeFormatter f19694d = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");

    /* renamed from: e, reason: collision with root package name */
    private static final DateTimeFormatter f19695e = DateTimeFormat.forPattern("yyyy年M月d日 HH:mm:ss");

    /* renamed from: f, reason: collision with root package name */
    private static final DateTimeFormatter f19696f = DateTimeFormat.forPattern("yyyy年M月d日 H时m分s秒");

    /* renamed from: g, reason: collision with root package name */
    private static final DateTimeFormatter f19697g = DateTimeFormat.forPattern("yyyy년M월d일 HH:mm:ss");

    /* renamed from: h, reason: collision with root package name */
    private static final DateTimeFormatter f19698h = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");

    /* renamed from: i, reason: collision with root package name */
    private static final DateTimeFormatter f19699i = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");

    /* renamed from: j, reason: collision with root package name */
    private static final DateTimeFormatter f19700j = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss");

    /* renamed from: k, reason: collision with root package name */
    private static final DateTimeFormatter f19701k = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");

    /* renamed from: l, reason: collision with root package name */
    private static final DateTimeFormatter f19702l = DateTimeFormat.forPattern("yyyyMMdd");

    /* renamed from: m, reason: collision with root package name */
    private static final DateTimeFormatter f19703m = DateTimeFormat.forPattern("yyyy/MM/dd");

    /* renamed from: n, reason: collision with root package name */
    private static final DateTimeFormatter f19704n = DateTimeFormat.forPattern("yyyy年M月d日");

    /* renamed from: o, reason: collision with root package name */
    private static final DateTimeFormatter f19705o = DateTimeFormat.forPattern("yyyy년M월d일");

    /* renamed from: p, reason: collision with root package name */
    private static final DateTimeFormatter f19706p = DateTimeFormat.forPattern("MM/dd/yyyy");

    /* renamed from: q, reason: collision with root package name */
    private static final DateTimeFormatter f19707q = DateTimeFormat.forPattern("dd/MM/yyyy");

    /* renamed from: r, reason: collision with root package name */
    private static final DateTimeFormatter f19708r = DateTimeFormat.forPattern("dd.MM.yyyy");

    /* renamed from: s, reason: collision with root package name */
    private static final DateTimeFormatter f19709s = DateTimeFormat.forPattern("dd-MM-yyyy");

    /* renamed from: t, reason: collision with root package name */
    private static final DateTimeFormatter f19710t = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withZone(DateTimeZone.getDefault());

    /* renamed from: u, reason: collision with root package name */
    private static final DateTimeFormatter f19711u = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

    private void j(e0 e0Var, ReadablePartial readablePartial, String str) {
        e0Var.h0((str.equals("yyyy-MM-dd'T'HH:mm:ss") ? f19711u : DateTimeFormat.forPattern(str)).print(readablePartial));
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
            strV = ((i5 & iB) != 0 || c0946i.A(f0Var)) ? "yyyy-MM-dd'T'HH:mm:ss" : c0946i.A(f0.WriteDateUseDateFormat) ? AbstractC0822a.f18020e : localDateTime.getMillisOfSecond() == 0 ? "yyyy-MM-dd'T'HH:mm:ss.SSS" : "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
        }
        if (strV != null) {
            j(e0Var, localDateTime, strV);
        } else {
            e0Var.X(localDateTime.toDateTime(DateTimeZone.forTimeZone(AbstractC0822a.f18016a)).toInstant().getMillis());
        }
    }

    @Override // q0.InterfaceC0973u
    public void c(C0946I c0946i, Object obj, C0963j c0963j) {
        j(c0946i.f19676k, (ReadablePartial) obj, c0963j.b());
    }

    @Override // p0.t
    public int d() {
        return 4;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        return (T) f(c0888a, type, obj, null, 0);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, org.joda.time.LocalDateTime] */
    public <T> T f(C0888a c0888a, Type type, Object obj, String str, int i5) {
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() == 8) {
            interfaceC0890c.nextToken();
            return null;
        }
        if (interfaceC0890c.U() == 4) {
            String strN = interfaceC0890c.N();
            interfaceC0890c.nextToken();
            DateTimeFormatter dateTimeFormatterForPattern = str != null ? "yyyy-MM-dd HH:mm:ss".equals(str) ? f19692b : DateTimeFormat.forPattern(str) : null;
            if (BuildConfig.FLAVOR.equals(strN)) {
                return null;
            }
            if (type == LocalDateTime.class) {
                return (strN.length() == 10 || strN.length() == 8) ? (T) h(strN, str, dateTimeFormatterForPattern).toLocalDateTime(LocalTime.MIDNIGHT) : (T) g(strN, dateTimeFormatterForPattern);
            }
            if (type == LocalDate.class) {
                return strN.length() == 23 ? (T) LocalDateTime.parse(strN).toLocalDate() : (T) h(strN, str, dateTimeFormatterForPattern);
            }
            if (type == LocalTime.class) {
                return strN.length() == 23 ? (T) LocalDateTime.parse(strN).toLocalTime() : (T) LocalTime.parse(strN);
            }
            if (type == DateTime.class) {
                if (dateTimeFormatterForPattern == f19692b) {
                    dateTimeFormatterForPattern = f19710t;
                }
                return (T) i(strN, dateTimeFormatterForPattern);
            }
            if (type == DateTimeZone.class) {
                return (T) DateTimeZone.forID(strN);
            }
            if (type == Period.class) {
                return (T) Period.parse(strN);
            }
            if (type == Duration.class) {
                return (T) Duration.parse(strN);
            }
            if (type == Instant.class) {
                int i6 = 0;
                while (true) {
                    if (i6 < strN.length()) {
                        char cCharAt = strN.charAt(i6);
                        if (cCharAt < '0' || cCharAt > '9') {
                            break;
                        }
                        i6++;
                    } else if (strN.length() > 8 && strN.length() < 19) {
                        return (T) new Instant(Long.parseLong(strN));
                    }
                }
                return (T) Instant.parse(strN);
            }
            if (type == DateTimeFormatter.class) {
                return (T) DateTimeFormat.forPattern(strN);
            }
        } else {
            if (interfaceC0890c.U() == 2) {
                long jF = interfaceC0890c.f();
                interfaceC0890c.nextToken();
                TimeZone timeZone = AbstractC0822a.f18016a;
                if (timeZone == null) {
                    timeZone = TimeZone.getDefault();
                }
                if (type == DateTime.class) {
                    return (T) new DateTime(jF, DateTimeZone.forTimeZone(timeZone));
                }
                ?? r7 = (T) new LocalDateTime(jF, DateTimeZone.forTimeZone(timeZone));
                if (type == LocalDateTime.class) {
                    return r7;
                }
                if (type == LocalDate.class) {
                    return (T) r7.toLocalDate();
                }
                if (type == LocalTime.class) {
                    return (T) r7.toLocalTime();
                }
                if (type == Instant.class) {
                    return (T) new Instant(jF);
                }
                throw new UnsupportedOperationException();
            }
            if (interfaceC0890c.U() != 12) {
                throw new UnsupportedOperationException();
            }
            l0.e eVarN0 = c0888a.n0();
            if (type == Instant.class) {
                Object obj2 = eVarN0.get("epochSecond");
                if (obj2 instanceof Number) {
                    return (T) Instant.ofEpochSecond(u0.o.C0((Number) obj2));
                }
                Object obj3 = eVarN0.get("millis");
                if (obj3 instanceof Number) {
                    return (T) Instant.ofEpochMilli(u0.o.C0((Number) obj3));
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0128 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected org.joda.time.LocalDateTime g(java.lang.String r17, org.joda.time.format.DateTimeFormatter r18) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.C0948K.g(java.lang.String, org.joda.time.format.DateTimeFormatter):org.joda.time.LocalDateTime");
    }

    protected LocalDate h(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = f19702l;
            }
            int i5 = 0;
            if (str.length() == 10) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter = f19703m;
                }
                char cCharAt3 = str.charAt(0);
                char cCharAt4 = str.charAt(1);
                char cCharAt5 = str.charAt(2);
                char cCharAt6 = str.charAt(3);
                char cCharAt7 = str.charAt(5);
                if (cCharAt5 == '/' && cCharAt7 == '/') {
                    int i6 = ((cCharAt6 - '0') * 10) + (cCharAt - '0');
                    if (((cCharAt3 - '0') * 10) + (cCharAt4 - '0') > 12) {
                        dateTimeFormatter3 = f19707q;
                    } else if (i6 > 12) {
                        dateTimeFormatter3 = f19706p;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = f19706p;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = f19707q;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (cCharAt5 == '.' && cCharAt7 == '.') {
                    dateTimeFormatter = f19708r;
                } else if (cCharAt5 == '-' && cCharAt7 == '-') {
                    dateTimeFormatter = f19709s;
                }
            }
            if (str.length() >= 9) {
                char cCharAt8 = str.charAt(4);
                if (cCharAt8 == 24180) {
                    dateTimeFormatter2 = f19704n;
                } else if (cCharAt8 == 45380) {
                    dateTimeFormatter2 = f19705o;
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
                    return new LocalDateTime(Long.parseLong(str), DateTimeZone.forTimeZone(AbstractC0822a.f18016a)).toLocalDate();
                }
            }
        }
        return dateTimeFormatter == null ? LocalDate.parse(str) : LocalDate.parse(str, dateTimeFormatter);
    }

    protected DateTime i(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 == ':' && cCharAt5 == ':') {
                    if (cCharAt == '-' && cCharAt2 == '-') {
                        if (cCharAt3 == 'T') {
                            dateTimeFormatter = f19711u;
                        } else if (cCharAt3 == ' ') {
                            dateTimeFormatter = f19692b;
                        }
                    } else if (cCharAt == '/' && cCharAt2 == '/') {
                        dateTimeFormatter = f19694d;
                    } else {
                        char cCharAt6 = str.charAt(0);
                        char cCharAt7 = str.charAt(1);
                        char cCharAt8 = str.charAt(2);
                        char cCharAt9 = str.charAt(3);
                        char cCharAt10 = str.charAt(5);
                        if (cCharAt8 == '/' && cCharAt10 == '/') {
                            int i5 = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                            if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                                dateTimeFormatter = f19699i;
                            } else if (i5 > 12) {
                                dateTimeFormatter = f19698h;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = f19698h;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = f19699i;
                                }
                            }
                        } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                            dateTimeFormatter = f19700j;
                        } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                            dateTimeFormatter = f19701k;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char cCharAt11 = str.charAt(4);
                if (cCharAt11 == 24180) {
                    dateTimeFormatter = str.charAt(str.length() - 1) == 31186 ? f19696f : f19695e;
                } else if (cCharAt11 == 45380) {
                    dateTimeFormatter = f19697g;
                }
            }
        }
        return dateTimeFormatter == null ? DateTime.parse(str) : DateTime.parse(str, dateTimeFormatter);
    }
}
