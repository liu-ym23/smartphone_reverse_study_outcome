package X1;

import java.util.Arrays;
import java.util.Optional;

/* loaded from: classes.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f6840c;

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f6841d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f6842e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f6843f;

    /* renamed from: a, reason: collision with root package name */
    public final char[] f6844a;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f6845b;

    static {
        char[] cArr = {'T', 't', ' '};
        f6840c = cArr;
        char[] cArr2 = {'.'};
        f6841d = cArr2;
        f6842e = new d(cArr, cArr2);
        f6843f = new d(new char[]{'T'}, cArr2);
    }

    public d(char[] cArr, char[] cArr2) {
        this.f6844a = (char[]) Optional.ofNullable(cArr).orElse(f6840c);
        this.f6845b = (char[]) Optional.ofNullable(cArr2).orElse(f6841d);
    }

    public char[] a() {
        return this.f6844a;
    }

    public char[] b() {
        return this.f6845b;
    }

    public boolean c(char c10) {
        for (char c11 : this.f6844a) {
            if (c11 == c10) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        return true;
    }

    public boolean e(char c10) {
        for (char c11 : this.f6845b) {
            if (c11 == c10) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "ParseConfig{dateTimeSeparators=" + Arrays.toString(this.f6844a) + ", fractionSeparators=" + Arrays.toString(this.f6845b) + '}';
    }
}
