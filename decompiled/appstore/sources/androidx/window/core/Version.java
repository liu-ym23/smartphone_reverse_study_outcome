package androidx.window.core;

import com.bytedanceos.common.model.AppInfo;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;

/* JADX INFO: loaded from: classes.dex */
public final class Version implements Comparable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f5223f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Version f5224g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Version f5225h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Version f5226i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Version f5227j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f5232e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Version a() {
            return Version.a();
        }

        public final Version b(String r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            if (o.r(r10) == true) goto L36;
            Matcher r11 = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(r10);
            if (r11.matches() == true) goto L10;
            return null;
        L10:
            String r12 = r11.group(1);
            if (r12 != null) goto L13;
            Integer r13 = null;
        L14:
            if (r13 != null) goto L16;
            return null;
        L16:
            int r14 = r13.intValue();
            String r15 = r11.group(2);
            if (r15 != null) goto L19;
            Integer r16 = null;
        L20:
            if (r16 != null) goto L22;
            return null;
        L22:
            int r17 = r16.intValue();
            String r18 = r11.group(3);
            if (r18 != null) goto L25;
            Integer r19 = null;
        L26:
            if (r19 != null) goto L28;
            return null;
        L28:
            int r20 = r19.intValue();
            if (r11.group(4) == null) goto L32;
            String r21 = r11.group(4);
        L31:
            String r22 = r21;
            q.f(r22, "description");
            return new Version(r14, r17, r20, r22, null);
        L32:
            r21 = "";
            goto L31
        L25:
            r19 = Integer.valueOf(Integer.parseInt(r18));
            goto L26
        L19:
            r16 = Integer.valueOf(Integer.parseInt(r15));
            goto L20
        L13:
            r13 = Integer.valueOf(Integer.parseInt(r12));
            goto L14
        L36:
            return null;
        }

        public a() {
        }
    }

    static {
        f5223f = new a(null);
        f5224g = new Version(0, 0, 0, "");
        f5225h = new Version(0, 1, 0, "");
        Version r10 = new Version(1, 0, 0, "");
        f5226i = r10;
        f5227j = r10;
    }

    public /* synthetic */ Version(int r10, int r11, int r12, String r13, DefaultConstructorMarker r14) {
        this(r10, r11, r12, r13);
    }

    public static final /* synthetic */ Version a() {
        return f5225h;
    }

    public int b(Version r10) {
        q.g(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
        return c().compareTo(r10.c());
    }

    public final BigInteger c() {
        Object r10 = this.f5232e.getValue();
        q.f(r10, "<get-bigInteger>(...)");
        return (BigInteger) r10;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return b((Version) r10);
    }

    public final int d() {
        return this.f5228a;
    }

    public final int e() {
        return this.f5229b;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof Version) == true) goto L5;
        return false;
    L5:
        Version r11 = (Version) r10;
        if (this.f5228a == r11.f5228a) goto L8;
        return false;
    L8:
        if (this.f5229b == r11.f5229b) goto L10;
        return false;
    L10:
        if (this.f5230c != r11.f5230c) goto L15;
        return true;
    L15:
        return false;
    }

    public final int f() {
        return this.f5230c;
    }

    public int hashCode() {
        return ((((527 + this.f5228a) * 31) + this.f5229b) * 31) + this.f5230c;
    }

    public String toString() {
        if (o.r(this.f5231d) == true) goto L5;
        String r10 = q.p("-", this.f5231d);
    L7:
        return this.f5228a + '.' + this.f5229b + '.' + this.f5230c + r10;
    L5:
        r10 = "";
        goto L7
    }

    public Version(int r10, int r11, int r12, String r13) {
        this.f5228a = r10;
        this.f5229b = r11;
        this.f5230c = r12;
        this.f5231d = r13;
        this.f5232e = kotlin.b.b(new Version$bigInteger$2(this));
    }
}
