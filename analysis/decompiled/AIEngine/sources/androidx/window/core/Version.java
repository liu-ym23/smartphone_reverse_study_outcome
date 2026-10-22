package androidx.window.core;

import gc.q;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.b;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Version implements Comparable<Version> {
    public static final Version h;

    /* renamed from: a, reason: collision with root package name */
    public final int f2682a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2683b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2684c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2685d;

    /* renamed from: e, reason: collision with root package name */
    public final d f2686e = b.b(new zb.a<BigInteger>() { // from class: androidx.window.core.Version$bigInteger$2
        {
            super(0);
        }

        @Override // zb.a
        public final BigInteger invoke() {
            Version version = this.f2687a;
            return BigInteger.valueOf(version.f2682a).shiftLeft(32).or(BigInteger.valueOf(version.f2683b)).shiftLeft(32).or(BigInteger.valueOf(version.f2684c));
        }
    });

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static Version a(String str) {
            if (str != null && !q.t0(str)) {
                Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    Integer numValueOf = strGroup == null ? null : Integer.valueOf(Integer.parseInt(strGroup));
                    if (numValueOf != null) {
                        int iIntValue = numValueOf.intValue();
                        String strGroup2 = matcher.group(2);
                        Integer numValueOf2 = strGroup2 == null ? null : Integer.valueOf(Integer.parseInt(strGroup2));
                        if (numValueOf2 != null) {
                            int iIntValue2 = numValueOf2.intValue();
                            String strGroup3 = matcher.group(3);
                            Integer numValueOf3 = strGroup3 == null ? null : Integer.valueOf(Integer.parseInt(strGroup3));
                            if (numValueOf3 != null) {
                                int iIntValue3 = numValueOf3.intValue();
                                String description = matcher.group(4) != null ? matcher.group(4) : "";
                                g.e(description, "description");
                                return new Version(iIntValue, description, iIntValue2, iIntValue3);
                            }
                        }
                    }
                }
            }
            return null;
        }
    }

    static {
        new Version(0, "", 0, 0);
        h = new Version(0, "", 1, 0);
        new Version(1, "", 0, 0);
    }

    public Version(int i10, String str, int i11, int i12) {
        this.f2682a = i10;
        this.f2683b = i11;
        this.f2684c = i12;
        this.f2685d = str;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Version version) {
        Version other = version;
        g.f(other, "other");
        Object value = this.f2686e.getValue();
        g.e(value, "<get-bigInteger>(...)");
        Object value2 = other.f2686e.getValue();
        g.e(value2, "<get-bigInteger>(...)");
        return ((BigInteger) value).compareTo((BigInteger) value2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return this.f2682a == version.f2682a && this.f2683b == version.f2683b && this.f2684c == version.f2684c;
    }

    public final int hashCode() {
        return ((((527 + this.f2682a) * 31) + this.f2683b) * 31) + this.f2684c;
    }

    public final String toString() {
        String str = this.f2685d;
        String strK = !q.t0(str) ? g.k(str, "-") : "";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f2682a);
        sb2.append('.');
        sb2.append(this.f2683b);
        sb2.append('.');
        return ai.onnxruntime.a.j(strK, this.f2684c, sb2);
    }
}
