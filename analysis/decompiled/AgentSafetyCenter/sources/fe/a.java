package fe;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f4070d = new a("\n\u0085\u2028\u2029");

    /* renamed from: e, reason: collision with root package name */
    public static final a f4071e = new a("\u0000\r\n\u0085\u2028\u2029");

    /* renamed from: f, reason: collision with root package name */
    public static final a f4072f = new a(" \u0000\r\n\u0085\u2028\u2029");

    /* renamed from: g, reason: collision with root package name */
    public static final a f4073g = new a("\t \u0000\r\n\u0085\u2028\u2029");

    /* renamed from: h, reason: collision with root package name */
    public static final a f4074h = new a("\u0000 \t");
    public static final a i = new a("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$,_.!~*'()[]%");

    /* renamed from: j, reason: collision with root package name */
    public static final a f4075j = new a("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_");

    /* renamed from: a, reason: collision with root package name */
    public final String f4076a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean[] f4077b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4078c;

    public a(String str) {
        boolean[] zArr = new boolean[128];
        this.f4077b = zArr;
        this.f4078c = false;
        Arrays.fill(zArr, false);
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < str.length(); i3++) {
            int iCodePointAt = str.codePointAt(i3);
            if (iCodePointAt < 128) {
                this.f4077b[iCodePointAt] = true;
            } else {
                sb2.appendCodePoint(iCodePointAt);
            }
        }
        if (sb2.length() > 0) {
            this.f4078c = true;
            this.f4076a = sb2.toString();
        }
    }

    public final boolean a(int i3) {
        return i3 < 128 ? this.f4077b[i3] : this.f4078c && this.f4076a.indexOf(i3) != -1;
    }

    public final boolean b(int i3, String str) {
        return a(i3) || str.indexOf(i3) != -1;
    }

    public final boolean c(int i3) {
        return !a(i3);
    }
}
