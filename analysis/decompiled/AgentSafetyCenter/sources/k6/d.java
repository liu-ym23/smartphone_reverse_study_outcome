package k6;

import java.util.Arrays;
import java.util.Optional;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f7264c;

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f7265d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f7266e;

    /* renamed from: a, reason: collision with root package name */
    public final char[] f7267a;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f7268b;

    static {
        char[] cArr = {'T', 't', ' '};
        f7264c = cArr;
        char[] cArr2 = {'.'};
        f7265d = cArr2;
        f7266e = new d(cArr, cArr2);
        new d(new char[]{'T'}, cArr2);
    }

    public d(char[] cArr, char[] cArr2) {
        this.f7267a = (char[]) Optional.ofNullable(cArr).orElse(f7264c);
        this.f7268b = (char[]) Optional.ofNullable(cArr2).orElse(f7265d);
    }

    public final String toString() {
        return "ParseConfig{dateTimeSeparators=" + Arrays.toString(this.f7267a) + ", fractionSeparators=" + Arrays.toString(this.f7268b) + '}';
    }
}
