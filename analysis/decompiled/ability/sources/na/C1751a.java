package na;

import java.util.Arrays;

/* renamed from: na.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1751a {
    public static final C1751a d = new C1751a("\n\u0085\u2028\u2029");
    public static final C1751a e = new C1751a("\u0000\r\n\u0085\u2028\u2029");
    public static final C1751a f = new C1751a(" \u0000\r\n\u0085\u2028\u2029");
    public static final C1751a g = new C1751a("\t \u0000\r\n\u0085\u2028\u2029");
    public static final C1751a h = new C1751a("\u0000 \t");
    public static final C1751a i = new C1751a("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$,_.!~*'()[]%");

    /* renamed from: j, reason: collision with root package name */
    public static final C1751a f5372j = new C1751a("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_");

    /* renamed from: a, reason: collision with root package name */
    public final String f5373a;
    public final boolean[] b;
    public final boolean c;

    public C1751a(String str) {
        boolean[] zArr = new boolean[128];
        this.b = zArr;
        this.c = false;
        Arrays.fill(zArr, false);
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < str.length(); i6++) {
            int iCodePointAt = str.codePointAt(i6);
            if (iCodePointAt < 128) {
                this.b[iCodePointAt] = true;
            } else {
                sb.appendCodePoint(iCodePointAt);
            }
        }
        if (sb.length() > 0) {
            this.c = true;
            this.f5373a = sb.toString();
        }
    }

    public final boolean a(int i6) {
        return i6 < 128 ? this.b[i6] : this.c && this.f5373a.indexOf(i6) != -1;
    }

    public final boolean b(int i6, String str) {
        return a(i6) || str.indexOf(i6) != -1;
    }

    public final boolean c(int i6) {
        return !a(i6);
    }
}
