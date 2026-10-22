package ad;

import java.util.Date;
import java.util.regex.Pattern;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f76k = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f77l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f78m = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f79n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    public final String f80a;

    /* renamed from: b, reason: collision with root package name */
    public final String f81b;

    /* renamed from: c, reason: collision with root package name */
    public final long f82c;

    /* renamed from: d, reason: collision with root package name */
    public final String f83d;

    /* renamed from: e, reason: collision with root package name */
    public final String f84e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f85f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f86g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f87i;

    /* renamed from: j, reason: collision with root package name */
    public final String f88j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static int a(String str, int i10, int i11, boolean z) {
            while (i10 < i11) {
                char cCharAt = str.charAt(i10);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z)) {
                    return i10;
                }
                i10++;
            }
            return i11;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x00a2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static long b(int r14, java.lang.String r15) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 323
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ad.f.a.b(int, java.lang.String):long");
        }
    }

    public f(String str, String str2, long j10, String str3, String str4, boolean z, boolean z3, boolean z10, boolean z11, String str5) {
        this.f80a = str;
        this.f81b = str2;
        this.f82c = j10;
        this.f83d = str3;
        this.f84e = str4;
        this.f85f = z;
        this.f86g = z3;
        this.h = z10;
        this.f87i = z11;
        this.f88j = str5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.g.b(fVar.f80a, this.f80a) && kotlin.jvm.internal.g.b(fVar.f81b, this.f81b) && fVar.f82c == this.f82c && kotlin.jvm.internal.g.b(fVar.f83d, this.f83d) && kotlin.jvm.internal.g.b(fVar.f84e, this.f84e) && fVar.f85f == this.f85f && fVar.f86g == this.f86g && fVar.h == this.h && fVar.f87i == this.f87i && kotlin.jvm.internal.g.b(fVar.f88j, this.f88j);
    }

    @IgnoreJRERequirement
    public final int hashCode() {
        int iF = ai.onnxruntime.a.f(ai.onnxruntime.a.f(ai.onnxruntime.a.f(ai.onnxruntime.a.f(v1.d.a(v1.d.a(a0.a.c(v1.d.a(v1.d.a(527, 31, this.f80a), 31, this.f81b), this.f82c, 31), 31, this.f83d), 31, this.f84e), 31, this.f85f), 31, this.f86g), 31, this.h), 31, this.f87i);
        String str = this.f88j;
        return iF + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f80a);
        sb2.append('=');
        sb2.append(this.f81b);
        if (this.h) {
            long j10 = this.f82c;
            if (j10 == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                String str = fd.c.f8834a.get().format(new Date(j10));
                kotlin.jvm.internal.g.e(str, "format(...)");
                sb2.append(str);
            }
        }
        if (!this.f87i) {
            sb2.append("; domain=");
            sb2.append(this.f83d);
        }
        sb2.append("; path=");
        sb2.append(this.f84e);
        if (this.f85f) {
            sb2.append("; secure");
        }
        if (this.f86g) {
            sb2.append("; httponly");
        }
        String str2 = this.f88j;
        if (str2 != null) {
            sb2.append("; samesite=");
            sb2.append(str2);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }
}
