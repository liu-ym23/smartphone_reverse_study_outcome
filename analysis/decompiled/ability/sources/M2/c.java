package M2;

import java.util.Arrays;
import java.util.Optional;

/* loaded from: classes2.dex */
public final class c {
    public static final char[] c;
    public static final char[] d;
    public static final c e;

    /* renamed from: a, reason: collision with root package name */
    public final char[] f962a;
    public final char[] b;

    static {
        char[] cArr = {'T', 't', ' '};
        c = cArr;
        char[] cArr2 = {'.'};
        d = cArr2;
        e = new c(cArr, cArr2);
        new c(new char[]{'T'}, cArr2);
    }

    public c(char[] cArr, char[] cArr2) {
        this.f962a = (char[]) Optional.ofNullable(cArr).orElse(c);
        this.b = (char[]) Optional.ofNullable(cArr2).orElse(d);
    }

    public final String toString() {
        return "ParseConfig{dateTimeSeparators=" + Arrays.toString(this.f962a) + ", fractionSeparators=" + Arrays.toString(this.b) + '}';
    }
}
