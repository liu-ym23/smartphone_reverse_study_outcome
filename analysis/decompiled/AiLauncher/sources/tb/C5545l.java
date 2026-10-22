package tb;

import La.H;
import Z8.C1173v;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.client.utils.CacheControl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.text.Regex;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import zb.C6479c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0017\u0018\u0000 *2\u00020\u0001:\u0001\u001cB[\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\tH\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0006\u0010#R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b\u0007\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\b\u0010\u0018R\u0017\u0010\n\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b\n\u0010&R\u0017\u0010\u000b\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b \u0010%\u001a\u0004\b\u000b\u0010&R\u0017\u0010\f\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b'\u0010%\u001a\u0004\b\f\u0010&R\u0017\u0010\r\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b\r\u0010&R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b\u000e\u0010\u0018¨\u0006+"}, d2 = {"Ltb/l;", "", "", "name", UxipConstants.f30680s, "", "expiresAt", "domain", "path", "", "secure", "httpOnly", "persistent", "hostOnly", "sameSite", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "forObsoleteRfc2965", "f", "(Z)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "e", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_COMMAND, "c", "J", "()J", Const.INTENT_KEY_UMID, "Z", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5545l {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f42201l = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f42202m = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f42203n = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f42204o = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String value;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long expiresAt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String domain;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final String path;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final boolean secure;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final boolean httpOnly;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final boolean persistent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final boolean hostOnly;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final String sameSite;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010!\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0016H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010&R\u001c\u0010)\u001a\n (*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010+\u001a\n (*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*R\u001c\u0010,\u001a\n (*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u001c\u0010-\u001a\n (*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010*¨\u0006."}, d2 = {"Ltb/l$a;", "", "<init>", "()V", "Ltb/v;", "url", "", "setCookie", "Ltb/l;", "c", "(Ltb/v;Ljava/lang/String;)Ltb/l;", "", "currentTimeMillis", Const.INTENT_KEY_UMID, "(JLtb/v;Ljava/lang/String;)Ltb/l;", "Ltb/u;", "headers", "", "e", "(Ltb/v;Ltb/u;)Ljava/util/List;", "urlHost", "domain", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Z", "s", "", "pos", "limit", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;II)J", "input", "invert", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;IIZ)I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)J", "f", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "YEAR_PATTERN", "Ljava/util/regex/Pattern;", "MONTH_PATTERN", "DAY_OF_MONTH_PATTERN", "TIME_PATTERN", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.l$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int a(String input, int pos, int limit, boolean invert) {
            while (pos < limit) {
                char cCharAt = input.charAt(pos);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!invert)) {
                    return pos;
                }
                pos++;
            }
            return limit;
        }

        public final boolean b(String urlHost, String domain) {
            if (kotlin.jvm.internal.p.d(urlHost, domain)) {
                return true;
            }
            return La.D.K(urlHost, domain, false, 2, null) && urlHost.charAt((urlHost.length() - domain.length()) - 1) == '.' && !ub.l.a(urlHost);
        }

        public final C5545l c(v url, String setCookie) {
            kotlin.jvm.internal.p.i(url, "url");
            kotlin.jvm.internal.p.i(setCookie, "setCookie");
            return d(System.currentTimeMillis(), url, setCookie);
        }

        public final C5545l d(long currentTimeMillis, v url, String setCookie) throws NumberFormatException {
            long j10;
            kotlin.jvm.internal.p.i(url, "url");
            kotlin.jvm.internal.p.i(setCookie, "setCookie");
            int iJ = ub.n.j(setCookie, ';', 0, 0, 6, null);
            int iJ2 = ub.n.j(setCookie, '=', 0, iJ, 2, null);
            C5545l c5545l = null;
            if (iJ2 == iJ) {
                return null;
            }
            String strC = ub.n.C(setCookie, 0, iJ2, 1, null);
            if (strC.length() == 0 || ub.n.n(strC) != -1) {
                return null;
            }
            String strB = ub.n.B(setCookie, iJ2 + 1, iJ);
            if (ub.n.n(strB) != -1) {
                return null;
            }
            int i10 = iJ + 1;
            int length = setCookie.length();
            String strF = null;
            String str = null;
            String str2 = null;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = true;
            long jH = -1;
            long jG = 253402300799999L;
            while (i10 < length) {
                int iH = ub.n.h(setCookie, ';', i10, length);
                int iH2 = ub.n.h(setCookie, '=', i10, iH);
                String strB2 = ub.n.B(setCookie, i10, iH2);
                String strB3 = iH2 < iH ? ub.n.B(setCookie, iH2 + 1, iH) : "";
                C5545l c5545l2 = c5545l;
                if (La.D.L(strB2, "expires", true)) {
                    try {
                        jG = g(strB3, 0, strB3.length());
                        z11 = true;
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (La.D.L(strB2, CacheControl.MAX_AGE, true)) {
                    jH = h(strB3);
                    z11 = true;
                } else if (La.D.L(strB2, "domain", true)) {
                    strF = f(strB3);
                    z13 = false;
                } else if (La.D.L(strB2, "path", true)) {
                    str = strB3;
                } else if (La.D.L(strB2, "secure", true)) {
                    z12 = true;
                } else if (La.D.L(strB2, "httponly", true)) {
                    z10 = true;
                } else if (La.D.L(strB2, "samesite", true)) {
                    str2 = strB3;
                }
                i10 = iH + 1;
                c5545l = c5545l2;
            }
            C5545l c5545l3 = c5545l;
            if (jH == Long.MIN_VALUE) {
                j10 = Long.MIN_VALUE;
            } else if (jH != -1) {
                long j11 = currentTimeMillis + (jH <= 9223372036854775L ? jH * 1000 : Long.MAX_VALUE);
                j10 = (j11 < currentTimeMillis || j11 > 253402300799999L) ? 253402300799999L : j11;
            } else {
                j10 = jG;
            }
            String host = url.getHost();
            if (strF == null) {
                strF = host;
            } else if (!b(host, strF)) {
                return c5545l3;
            }
            if (host.length() != strF.length() && PublicSuffixDatabase.INSTANCE.c().c(strF) == null) {
                return c5545l3;
            }
            String strSubstring = "/";
            if (str == null || !La.D.X(str, "/", false, 2, c5545l3)) {
                String strC2 = url.c();
                int iA0 = H.A0(strC2, JsonPointer.SEPARATOR, 0, false, 6, null);
                if (iA0 != 0) {
                    strSubstring = strC2.substring(0, iA0);
                    kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                }
                str = strSubstring;
            }
            return new C5545l(strC, strB, j10, strF, str, z12, z10, z11, z13, str2, null);
        }

        public final List<C5545l> e(v url, u headers) {
            kotlin.jvm.internal.p.i(url, "url");
            kotlin.jvm.internal.p.i(headers, "headers");
            List<String> listL = headers.l("Set-Cookie");
            int size = listL.size();
            List<C5545l> listUnmodifiableList = null;
            ArrayList arrayList = null;
            for (int i10 = 0; i10 < size; i10++) {
                C5545l c5545lC = c(url, listL.get(i10));
                if (c5545lC != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c5545lC);
                }
            }
            if (arrayList != null) {
                listUnmodifiableList = Collections.unmodifiableList(arrayList);
                kotlin.jvm.internal.p.h(listUnmodifiableList, "unmodifiableList(...)");
            }
            return listUnmodifiableList == null ? C1173v.m() : listUnmodifiableList;
        }

        public final String f(String s10) {
            if (La.D.K(s10, ".", false, 2, null)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String strK = ub.l.k(H.R0(s10, "."));
            if (strK != null) {
                return strK;
            }
            throw new IllegalArgumentException();
        }

        public final long g(String s10, int pos, int limit) throws NumberFormatException {
            int iA = a(s10, pos, limit, false);
            Matcher matcher = C5545l.f42204o.matcher(s10);
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int iU0 = -1;
            int i13 = -1;
            int i14 = -1;
            while (iA < limit) {
                int iA2 = a(s10, iA + 1, limit, true);
                matcher.region(iA, iA2);
                if (i11 == -1 && matcher.usePattern(C5545l.f42204o).matches()) {
                    String strGroup = matcher.group(1);
                    kotlin.jvm.internal.p.h(strGroup, "group(...)");
                    i11 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    kotlin.jvm.internal.p.h(strGroup2, "group(...)");
                    i13 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    kotlin.jvm.internal.p.h(strGroup3, "group(...)");
                    i14 = Integer.parseInt(strGroup3);
                } else if (i12 == -1 && matcher.usePattern(C5545l.f42203n).matches()) {
                    String strGroup4 = matcher.group(1);
                    kotlin.jvm.internal.p.h(strGroup4, "group(...)");
                    i12 = Integer.parseInt(strGroup4);
                } else if (iU0 == -1 && matcher.usePattern(C5545l.f42202m).matches()) {
                    String strGroup5 = matcher.group(1);
                    kotlin.jvm.internal.p.h(strGroup5, "group(...)");
                    Locale US = Locale.US;
                    kotlin.jvm.internal.p.h(US, "US");
                    String lowerCase = strGroup5.toLowerCase(US);
                    kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
                    String strPattern = C5545l.f42202m.pattern();
                    kotlin.jvm.internal.p.h(strPattern, "pattern(...)");
                    iU0 = H.u0(strPattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i10 == -1 && matcher.usePattern(C5545l.f42201l).matches()) {
                    String strGroup6 = matcher.group(1);
                    kotlin.jvm.internal.p.h(strGroup6, "group(...)");
                    i10 = Integer.parseInt(strGroup6);
                }
                iA = a(s10, iA2 + 1, limit, false);
            }
            if (70 <= i10 && i10 < 100) {
                i10 += AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR;
            }
            if (i10 >= 0 && i10 < 70) {
                i10 += 2000;
            }
            if (i10 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (iU0 == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i12 || i12 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i11 < 0 || i11 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i13 < 0 || i13 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i14 < 0 || i14 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(ub.q.f42673a);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i10);
            gregorianCalendar.set(2, iU0 - 1);
            gregorianCalendar.set(5, i12);
            gregorianCalendar.set(11, i11);
            gregorianCalendar.set(12, i13);
            gregorianCalendar.set(13, i14);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        public final long h(String s10) throws NumberFormatException {
            try {
                long j10 = Long.parseLong(s10);
                if (j10 <= 0) {
                    return Long.MIN_VALUE;
                }
                return j10;
            } catch (NumberFormatException e10) {
                if (new Regex("-?\\d+").k(s10)) {
                    return La.D.X(s10, O6.l.DATE_SEPARATOR, false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e10;
            }
        }

        public Companion() {
        }
    }

    public /* synthetic */ C5545l(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13, String str5, kotlin.jvm.internal.i iVar) {
        this(str, str2, j10, str3, str4, z10, z11, z12, z13, str5);
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C5545l)) {
            return false;
        }
        C5545l c5545l = (C5545l) other;
        return kotlin.jvm.internal.p.d(c5545l.name, this.name) && kotlin.jvm.internal.p.d(c5545l.value, this.value) && c5545l.expiresAt == this.expiresAt && kotlin.jvm.internal.p.d(c5545l.domain, this.domain) && kotlin.jvm.internal.p.d(c5545l.path, this.path) && c5545l.secure == this.secure && c5545l.httpOnly == this.httpOnly && c5545l.persistent == this.persistent && c5545l.hostOnly == this.hostOnly && kotlin.jvm.internal.p.d(c5545l.sameSite, this.sameSite);
    }

    public final String f(boolean forObsoleteRfc2965) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.name);
        sb2.append('=');
        sb2.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(C6479c.b(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb2.append("; domain=");
            if (forObsoleteRfc2965) {
                sb2.append(".");
            }
            sb2.append(this.domain);
        }
        sb2.append("; path=");
        sb2.append(this.path);
        if (this.secure) {
            sb2.append("; secure");
        }
        if (this.httpOnly) {
            sb2.append("; httponly");
        }
        if (this.sameSite != null) {
            sb2.append("; samesite=");
            sb2.append(this.sameSite);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    /* renamed from: g, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int iHashCode = (((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + Long.hashCode(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + Boolean.hashCode(this.secure)) * 31) + Boolean.hashCode(this.httpOnly)) * 31) + Boolean.hashCode(this.persistent)) * 31) + Boolean.hashCode(this.hostOnly)) * 31;
        String str = this.sameSite;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return f(false);
    }

    public C5545l(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13, String str5) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j10;
        this.domain = str3;
        this.path = str4;
        this.secure = z10;
        this.httpOnly = z11;
        this.persistent = z12;
        this.hostOnly = z13;
        this.sameSite = str5;
    }
}
