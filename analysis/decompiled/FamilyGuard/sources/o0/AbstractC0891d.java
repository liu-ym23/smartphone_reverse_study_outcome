package o0;

import com.stepos.digitalwellbeing.server.net.category.CategoryEntity;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import l0.AbstractC0822a;
import org.libpag.BuildConfig;

/* renamed from: o0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0891d implements InterfaceC0890c, Closeable {

    /* renamed from: q, reason: collision with root package name */
    private static final ThreadLocal<char[]> f18992q = new ThreadLocal<>();

    /* renamed from: r, reason: collision with root package name */
    protected static final char[] f18993r = ("\"" + AbstractC0822a.f18018c + "\":\"").toCharArray();

    /* renamed from: s, reason: collision with root package name */
    protected static final int[] f18994s = new int[CategoryEntity.NEWS];

    /* renamed from: a, reason: collision with root package name */
    protected int f18995a;

    /* renamed from: b, reason: collision with root package name */
    protected int f18996b;

    /* renamed from: c, reason: collision with root package name */
    protected int f18997c;

    /* renamed from: d, reason: collision with root package name */
    protected char f18998d;

    /* renamed from: e, reason: collision with root package name */
    protected int f18999e;

    /* renamed from: f, reason: collision with root package name */
    protected int f19000f;

    /* renamed from: g, reason: collision with root package name */
    protected char[] f19001g;

    /* renamed from: h, reason: collision with root package name */
    protected int f19002h;

    /* renamed from: i, reason: collision with root package name */
    protected int f19003i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f19004j;

    /* renamed from: o, reason: collision with root package name */
    protected String f19009o;

    /* renamed from: k, reason: collision with root package name */
    protected Calendar f19005k = null;

    /* renamed from: l, reason: collision with root package name */
    protected TimeZone f19006l = AbstractC0822a.f18016a;

    /* renamed from: m, reason: collision with root package name */
    protected Locale f19007m = AbstractC0822a.f18017b;

    /* renamed from: n, reason: collision with root package name */
    public int f19008n = 0;

    /* renamed from: p, reason: collision with root package name */
    protected int f19010p = 0;

    static {
        for (int i5 = 48; i5 <= 57; i5++) {
            f18994s[i5] = i5 - 48;
        }
        for (int i6 = 97; i6 <= 102; i6++) {
            f18994s[i6] = i6 - 87;
        }
        for (int i7 = 65; i7 <= 70; i7++) {
            f18994s[i7] = i7 - 55;
        }
    }

    public AbstractC0891d(int i5) {
        this.f19009o = null;
        this.f18997c = i5;
        if ((i5 & EnumC0889b.InitStringFieldAsEmpty.f18991a) != 0) {
            this.f19009o = BuildConfig.FLAVOR;
        }
        char[] cArr = f18992q.get();
        this.f19001g = cArr;
        if (cArr == null) {
            this.f19001g = new char[512];
        }
    }

    public static boolean I0(char c6) {
        if (c6 <= ' ') {
            return c6 == ' ' || c6 == '\n' || c6 == '\r' || c6 == '\t' || c6 == '\f' || c6 == '\b';
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String O0(char[] r16, int r17) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.AbstractC0891d.O0(char[], int):java.lang.String");
    }

    private void h1() {
        char next;
        char next2;
        this.f19003i = this.f18999e;
        this.f19004j = false;
        while (true) {
            char next3 = next();
            if (next3 == '\'') {
                this.f18995a = 4;
                next();
                return;
            }
            if (next3 != 26) {
                boolean z5 = true;
                if (next3 == '\\') {
                    if (!this.f19004j) {
                        this.f19004j = true;
                        int i5 = this.f19002h;
                        char[] cArr = this.f19001g;
                        if (i5 > cArr.length) {
                            char[] cArr2 = new char[i5 * 2];
                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                            this.f19001g = cArr2;
                        }
                        D0(this.f19003i + 1, this.f19002h, this.f19001g);
                    }
                    char next4 = next();
                    if (next4 == '\"') {
                        N0('\"');
                    } else if (next4 != '\'') {
                        if (next4 != 'F') {
                            if (next4 == '\\') {
                                N0('\\');
                            } else if (next4 == 'b') {
                                N0('\b');
                            } else if (next4 != 'f') {
                                if (next4 == 'n') {
                                    N0('\n');
                                } else if (next4 == 'r') {
                                    N0('\r');
                                } else if (next4 != 'x') {
                                    switch (next4) {
                                        case '/':
                                            N0('/');
                                            break;
                                        case '0':
                                            N0((char) 0);
                                            break;
                                        case '1':
                                            N0((char) 1);
                                            break;
                                        case '2':
                                            N0((char) 2);
                                            break;
                                        case '3':
                                            N0((char) 3);
                                            break;
                                        case '4':
                                            N0((char) 4);
                                            break;
                                        case '5':
                                            N0((char) 5);
                                            break;
                                        case '6':
                                            N0((char) 6);
                                            break;
                                        case '7':
                                            N0((char) 7);
                                            break;
                                        default:
                                            switch (next4) {
                                                case 't':
                                                    N0('\t');
                                                    break;
                                                case 'u':
                                                    N0((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                    break;
                                                case 'v':
                                                    N0((char) 11);
                                                    break;
                                                default:
                                                    this.f18998d = next4;
                                                    throw new l0.d("unclosed single-quote string");
                                            }
                                    }
                                } else {
                                    next = next();
                                    next2 = next();
                                    boolean z6 = (next >= '0' && next <= '9') || (next >= 'a' && next <= 'f') || (next >= 'A' && next <= 'F');
                                    if ((next2 < '0' || next2 > '9') && ((next2 < 'a' || next2 > 'f') && (next2 < 'A' || next2 > 'F'))) {
                                        z5 = false;
                                    }
                                    if (z6 && z5) {
                                        int[] iArr = f18994s;
                                        N0((char) ((iArr[next] * 16) + iArr[next2]));
                                    }
                                }
                            }
                        }
                        N0('\f');
                    } else {
                        N0('\'');
                    }
                } else if (this.f19004j) {
                    int i6 = this.f19002h;
                    char[] cArr3 = this.f19001g;
                    if (i6 == cArr3.length) {
                        N0(next3);
                    } else {
                        this.f19002h = i6 + 1;
                        cArr3[i6] = next3;
                    }
                } else {
                    this.f19002h++;
                }
            } else {
                if (H0()) {
                    throw new l0.d("unclosed single-quote string");
                }
                N0((char) 26);
            }
        }
        throw new l0.d("invalid escape character \\x" + next + next2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:108:0x007b A[SYNTHETIC] */
    @Override // o0.InterfaceC0890c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(int r11) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.AbstractC0891d.A(int):void");
    }

    protected abstract void A0(int i5, char[] cArr, int i6, int i7);

    protected abstract boolean B0(char[] cArr);

    @Override // o0.InterfaceC0890c
    public abstract BigDecimal C();

    public abstract char C0(int i5);

    @Override // o0.InterfaceC0890c
    public final String D(C0897j c0897j) {
        j0();
        char c6 = this.f18998d;
        if (c6 == '\"') {
            return V(c0897j, '\"');
        }
        if (c6 == '\'') {
            if (I(EnumC0889b.AllowSingleQuotes)) {
                return V(c0897j, '\'');
            }
            throw new l0.d("syntax error");
        }
        if (c6 == '}') {
            next();
            this.f18995a = 13;
            return null;
        }
        if (c6 == ',') {
            next();
            this.f18995a = 16;
            return null;
        }
        if (c6 == 26) {
            this.f18995a = 20;
            return null;
        }
        if (I(EnumC0889b.AllowUnQuotedFieldNames)) {
            return x(c0897j);
        }
        throw new l0.d("syntax error");
    }

    protected abstract void D0(int i5, int i6, char[] cArr);

    @Override // o0.InterfaceC0890c
    public int E(char c6) {
        int i5;
        int i6;
        char cC0;
        this.f19008n = 0;
        char cC02 = C0(this.f18999e);
        boolean z5 = cC02 == '\"';
        if (z5) {
            cC02 = C0(this.f18999e + 1);
            i5 = 2;
        } else {
            i5 = 1;
        }
        boolean z6 = cC02 == '-';
        if (z6) {
            cC02 = C0(this.f18999e + i5);
            i5++;
        }
        if (cC02 >= '0' && cC02 <= '9') {
            int i7 = cC02 - '0';
            while (true) {
                i6 = i5 + 1;
                cC0 = C0(this.f18999e + i5);
                if (cC0 < '0' || cC0 > '9') {
                    break;
                }
                i7 = (i7 * 10) + (cC0 - '0');
                i5 = i6;
            }
            if (cC0 == '.') {
                this.f19008n = -1;
                return 0;
            }
            if (i7 < 0) {
                this.f19008n = -1;
                return 0;
            }
            while (true) {
                if (cC0 == c6) {
                    int i8 = this.f18999e + i6;
                    this.f18999e = i8;
                    this.f18998d = C0(i8);
                    this.f19008n = 3;
                    this.f18995a = 16;
                    if (z6) {
                        return -i7;
                    }
                } else if (I0(cC0)) {
                    char cC03 = C0(this.f18999e + i6);
                    i6++;
                    cC0 = cC03;
                } else {
                    this.f19008n = -1;
                    if (z6) {
                        return -i7;
                    }
                }
            }
            return i7;
        }
        if (cC02 != 'n' || C0(this.f18999e + i5) != 'u' || C0(this.f18999e + i5 + 1) != 'l' || C0(this.f18999e + i5 + 2) != 'l') {
            this.f19008n = -1;
            return 0;
        }
        this.f19008n = 5;
        int i9 = i5 + 4;
        char cC04 = C0(this.f18999e + i5 + 3);
        if (z5 && cC04 == '\"') {
            cC04 = C0(this.f18999e + i9);
            i9 = i5 + 5;
        }
        while (cC04 != ',') {
            if (cC04 == ']') {
                int i10 = this.f18999e + i9;
                this.f18999e = i10;
                this.f18998d = C0(i10);
                this.f19008n = 5;
                this.f18995a = 15;
                return 0;
            }
            if (!I0(cC04)) {
                this.f19008n = -1;
                return 0;
            }
            cC04 = C0(this.f18999e + i9);
            i9++;
        }
        int i11 = this.f18999e + i9;
        this.f18999e = i11;
        this.f18998d = C0(i11);
        this.f19008n = 5;
        this.f18995a = 16;
        return 0;
    }

    public double E0() {
        return Double.parseDouble(w0());
    }

    public Calendar F0() {
        return this.f19005k;
    }

    public abstract int G0(char c6, int i5);

    public abstract boolean H0();

    @Override // o0.InterfaceC0890c
    public final boolean I(EnumC0889b enumC0889b) {
        return isEnabled(enumC0889b.f18991a);
    }

    protected void J0(String str, Object... objArr) {
        this.f18995a = 1;
    }

    public final boolean K0(char[] cArr) {
        while (!B0(cArr)) {
            if (!I0(this.f18998d)) {
                return false;
            }
            next();
        }
        int length = this.f18999e + cArr.length;
        this.f18999e = length;
        char cC0 = C0(length);
        this.f18998d = cC0;
        if (cC0 == '{') {
            next();
            this.f18995a = 12;
        } else if (cC0 == '[') {
            next();
            this.f18995a = 14;
        } else if (cC0 == 'S' && C0(this.f18999e + 1) == 'e' && C0(this.f18999e + 2) == 't' && C0(this.f18999e + 3) == '[') {
            int i5 = this.f18999e + 3;
            this.f18999e = i5;
            this.f18998d = C0(i5);
            this.f18995a = 21;
        } else {
            nextToken();
        }
        return true;
    }

    @Override // o0.InterfaceC0890c
    public final void L(int i5) {
        M0(':');
    }

    public final void L0() {
        while (I0(this.f18998d)) {
            next();
        }
        char c6 = this.f18998d;
        if (c6 == '_' || c6 == '$' || Character.isLetter(c6)) {
            e1();
        } else {
            nextToken();
        }
    }

    public final void M0(char c6) {
        this.f19002h = 0;
        while (true) {
            char c7 = this.f18998d;
            if (c7 == c6) {
                next();
                nextToken();
                return;
            }
            if (c7 != ' ' && c7 != '\n' && c7 != '\r' && c7 != '\t' && c7 != '\f' && c7 != '\b') {
                throw new l0.d("not match " + c6 + " - " + this.f18998d + ", info : " + c());
            }
            next();
        }
    }

    @Override // o0.InterfaceC0890c
    public abstract String N();

    protected final void N0(char c6) {
        int i5 = this.f19002h;
        char[] cArr = this.f19001g;
        if (i5 >= cArr.length) {
            int length = cArr.length * 2;
            if (length < i5) {
                length = i5 + 1;
            }
            char[] cArr2 = new char[length];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.f19001g = cArr2;
        }
        char[] cArr3 = this.f19001g;
        int i6 = this.f19002h;
        this.f19002h = i6 + 1;
        cArr3[i6] = c6;
    }

    @Override // o0.InterfaceC0890c
    public TimeZone O() {
        return this.f19006l;
    }

    public long P0(char[] cArr) {
        this.f19008n = 0;
        if (!B0(cArr)) {
            this.f19008n = -2;
            return 0L;
        }
        int length = cArr.length;
        int i5 = length + 1;
        if (C0(this.f18999e + length) != '\"') {
            this.f19008n = -1;
            return 0L;
        }
        long j5 = -3750763034362895579L;
        while (true) {
            int i6 = i5 + 1;
            char cC0 = C0(this.f18999e + i5);
            if (cC0 == '\"') {
                int i7 = i5 + 2;
                char cC02 = C0(this.f18999e + i6);
                if (cC02 == ',') {
                    int i8 = this.f18999e + i7;
                    this.f18999e = i8;
                    this.f18998d = C0(i8);
                    this.f19008n = 3;
                    return j5;
                }
                if (cC02 != '}') {
                    this.f19008n = -1;
                    return 0L;
                }
                int i9 = i5 + 3;
                char cC03 = C0(this.f18999e + i7);
                if (cC03 == ',') {
                    this.f18995a = 16;
                    int i10 = this.f18999e + i9;
                    this.f18999e = i10;
                    this.f18998d = C0(i10);
                } else if (cC03 == ']') {
                    this.f18995a = 15;
                    int i11 = this.f18999e + i9;
                    this.f18999e = i11;
                    this.f18998d = C0(i11);
                } else if (cC03 == '}') {
                    this.f18995a = 13;
                    int i12 = this.f18999e + i9;
                    this.f18999e = i12;
                    this.f18998d = C0(i12);
                } else {
                    if (cC03 != 26) {
                        this.f19008n = -1;
                        return 0L;
                    }
                    this.f18995a = 20;
                    this.f18999e += i5 + 2;
                    this.f18998d = (char) 26;
                }
                this.f19008n = 4;
                return j5;
            }
            j5 = (j5 ^ ((cC0 < 'A' || cC0 > 'Z') ? cC0 : cC0 + ' ')) * 1099511628211L;
            if (cC0 == '\\') {
                this.f19008n = -1;
                return 0L;
            }
            i5 = i6;
        }
    }

    public final void Q0() {
        if (this.f18998d != 'f') {
            throw new l0.d("error parse false");
        }
        next();
        if (this.f18998d != 'a') {
            throw new l0.d("error parse false");
        }
        next();
        if (this.f18998d != 'l') {
            throw new l0.d("error parse false");
        }
        next();
        if (this.f18998d != 's') {
            throw new l0.d("error parse false");
        }
        next();
        if (this.f18998d != 'e') {
            throw new l0.d("error parse false");
        }
        next();
        char c6 = this.f18998d;
        if (c6 != ' ' && c6 != ',' && c6 != '}' && c6 != ']' && c6 != '\n' && c6 != '\r' && c6 != '\t' && c6 != 26 && c6 != '\f' && c6 != '\b' && c6 != ':' && c6 != '/') {
            throw new l0.d("scan false error");
        }
        this.f18995a = 7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
    
        r2 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.math.BigInteger R0(char[] r22) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.AbstractC0891d.R0(char[]):java.math.BigInteger");
    }

    @Override // o0.InterfaceC0890c
    public final Number S() {
        char c6;
        long j5;
        long j6;
        boolean z5 = false;
        if (this.f19003i == -1) {
            this.f19003i = 0;
        }
        int i5 = this.f19003i;
        int i6 = this.f19002h + i5;
        char cC0 = C0(i6 - 1);
        if (cC0 == 'B') {
            i6--;
            c6 = 'B';
        } else if (cC0 == 'L') {
            i6--;
            c6 = 'L';
        } else if (cC0 != 'S') {
            c6 = ' ';
        } else {
            i6--;
            c6 = 'S';
        }
        if (C0(this.f19003i) == '-') {
            i5++;
            j5 = Long.MIN_VALUE;
            z5 = true;
        } else {
            j5 = -9223372036854775807L;
        }
        if (i5 < i6) {
            j6 = -(C0(i5) - '0');
            i5++;
        } else {
            j6 = 0;
        }
        while (i5 < i6) {
            int i7 = i5 + 1;
            int iC0 = C0(i5) - '0';
            if (j6 < -922337203685477580L) {
                return new BigInteger(w0(), 10);
            }
            long j7 = j6 * 10;
            long j8 = iC0;
            if (j7 < j5 + j8) {
                return new BigInteger(w0(), 10);
            }
            j6 = j7 - j8;
            i5 = i7;
        }
        if (!z5) {
            long j9 = -j6;
            return (j9 > 2147483647L || c6 == 'L') ? Long.valueOf(j9) : c6 == 'S' ? Short.valueOf((short) j9) : c6 == 'B' ? Byte.valueOf((byte) j9) : Integer.valueOf((int) j9);
        }
        if (i5 > this.f19003i + 1) {
            return (j6 < -2147483648L || c6 == 'L') ? Long.valueOf(j6) : c6 == 'S' ? Short.valueOf((short) j6) : c6 == 'B' ? Byte.valueOf((byte) j6) : Integer.valueOf((int) j6);
        }
        throw new l0.d("illegal number format : " + w0());
    }

    public boolean S0(char[] cArr) {
        int i5;
        boolean z5;
        this.f19008n = 0;
        if (!B0(cArr)) {
            this.f19008n = -2;
            return false;
        }
        int length = cArr.length;
        int i6 = length + 1;
        char cC0 = C0(this.f18999e + length);
        if (cC0 == 't') {
            int i7 = length + 2;
            if (C0(this.f18999e + i6) != 'r') {
                this.f19008n = -1;
                return false;
            }
            int i8 = length + 3;
            if (C0(this.f18999e + i7) != 'u') {
                this.f19008n = -1;
                return false;
            }
            i5 = length + 4;
            if (C0(this.f18999e + i8) != 'e') {
                this.f19008n = -1;
                return false;
            }
            z5 = true;
        } else {
            if (cC0 != 'f') {
                this.f19008n = -1;
                return false;
            }
            int i9 = length + 2;
            if (C0(this.f18999e + i6) != 'a') {
                this.f19008n = -1;
                return false;
            }
            int i10 = length + 3;
            if (C0(this.f18999e + i9) != 'l') {
                this.f19008n = -1;
                return false;
            }
            int i11 = length + 4;
            if (C0(this.f18999e + i10) != 's') {
                this.f19008n = -1;
                return false;
            }
            i5 = length + 5;
            if (C0(this.f18999e + i11) != 'e') {
                this.f19008n = -1;
                return false;
            }
            z5 = false;
        }
        int i12 = i5 + 1;
        char cC02 = C0(this.f18999e + i5);
        if (cC02 == ',') {
            int i13 = this.f18999e + i12;
            this.f18999e = i13;
            this.f18998d = C0(i13);
            this.f19008n = 3;
            this.f18995a = 16;
            return z5;
        }
        if (cC02 != '}') {
            this.f19008n = -1;
            return false;
        }
        int i14 = i5 + 2;
        char cC03 = C0(this.f18999e + i12);
        if (cC03 == ',') {
            this.f18995a = 16;
            int i15 = this.f18999e + i14;
            this.f18999e = i15;
            this.f18998d = C0(i15);
        } else if (cC03 == ']') {
            this.f18995a = 15;
            int i16 = this.f18999e + i14;
            this.f18999e = i16;
            this.f18998d = C0(i16);
        } else if (cC03 == '}') {
            this.f18995a = 13;
            int i17 = this.f18999e + i14;
            this.f18999e = i17;
            this.f18998d = C0(i17);
        } else {
            if (cC03 != 26) {
                this.f19008n = -1;
                return false;
            }
            this.f18995a = 20;
            this.f18999e += i5 + 1;
            this.f18998d = (char) 26;
        }
        this.f19008n = 4;
        return z5;
    }

    @Override // o0.InterfaceC0890c
    public float T() throws NumberFormatException {
        char cCharAt;
        String strW0 = w0();
        float f5 = Float.parseFloat(strW0);
        if ((f5 != 0.0f && f5 != Float.POSITIVE_INFINITY) || (cCharAt = strW0.charAt(0)) <= '0' || cCharAt > '9') {
            return f5;
        }
        throw new l0.d("float overflow : " + strW0);
    }

    public Date T0(char[] cArr) {
        char cC0;
        int i5;
        long j5;
        Date date;
        int i6;
        char cC02;
        boolean z5 = false;
        this.f19008n = 0;
        if (!B0(cArr)) {
            this.f19008n = -2;
            return null;
        }
        int length = cArr.length;
        int i7 = length + 1;
        char cC03 = C0(this.f18999e + length);
        if (cC03 == '\"') {
            int iG0 = G0('\"', this.f18999e + cArr.length + 1);
            if (iG0 == -1) {
                throw new l0.d("unclosed str");
            }
            int length2 = this.f18999e + cArr.length + 1;
            String strN1 = n1(length2, iG0 - length2);
            if (strN1.indexOf(92) != -1) {
                while (true) {
                    int i8 = 0;
                    for (int i9 = iG0 - 1; i9 >= 0 && C0(i9) == '\\'; i9--) {
                        i8++;
                    }
                    if (i8 % 2 == 0) {
                        break;
                    }
                    iG0 = G0('\"', iG0 + 1);
                }
                int i10 = this.f18999e;
                int length3 = iG0 - ((cArr.length + i10) + 1);
                strN1 = O0(o1(i10 + cArr.length + 1, length3), length3);
            }
            int i11 = this.f18999e;
            int length4 = i7 + (iG0 - ((cArr.length + i11) + 1)) + 1;
            i5 = length4 + 1;
            cC0 = C0(i11 + length4);
            C0893f c0893f = new C0893f(strN1);
            try {
                if (!c0893f.t1(false)) {
                    this.f19008n = -1;
                    return null;
                }
                date = c0893f.F0().getTime();
            } finally {
                c0893f.close();
            }
        } else {
            if (cC03 != '-' && (cC03 < '0' || cC03 > '9')) {
                this.f19008n = -1;
                return null;
            }
            if (cC03 == '-') {
                cC03 = C0(this.f18999e + i7);
                i7 = length + 2;
                z5 = true;
            }
            if (cC03 < '0' || cC03 > '9') {
                cC0 = cC03;
                i5 = i7;
                j5 = 0;
            } else {
                j5 = cC03 - '0';
                while (true) {
                    i6 = i7 + 1;
                    cC02 = C0(this.f18999e + i7);
                    if (cC02 < '0' || cC02 > '9') {
                        break;
                    }
                    j5 = (j5 * 10) + (cC02 - '0');
                    i7 = i6;
                }
                cC0 = cC02;
                i5 = i6;
            }
            if (j5 < 0) {
                this.f19008n = -1;
                return null;
            }
            if (z5) {
                j5 = -j5;
            }
            date = new Date(j5);
        }
        if (cC0 == ',') {
            int i12 = this.f18999e + i5;
            this.f18999e = i12;
            this.f18998d = C0(i12);
            this.f19008n = 3;
            return date;
        }
        if (cC0 != '}') {
            this.f19008n = -1;
            return null;
        }
        int i13 = i5 + 1;
        char cC04 = C0(this.f18999e + i5);
        if (cC04 == ',') {
            this.f18995a = 16;
            int i14 = this.f18999e + i13;
            this.f18999e = i14;
            this.f18998d = C0(i14);
        } else if (cC04 == ']') {
            this.f18995a = 15;
            int i15 = this.f18999e + i13;
            this.f18999e = i15;
            this.f18998d = C0(i15);
        } else if (cC04 == '}') {
            this.f18995a = 13;
            int i16 = this.f18999e + i13;
            this.f18999e = i16;
            this.f18998d = C0(i16);
        } else {
            if (cC04 != 26) {
                this.f19008n = -1;
                return null;
            }
            this.f18995a = 20;
            this.f18999e += i5;
            this.f18998d = (char) 26;
        }
        this.f19008n = 4;
        return date;
    }

    @Override // o0.InterfaceC0890c
    public final int U() {
        return this.f18995a;
    }

    public BigDecimal U0(char[] cArr) {
        int i5;
        char cC0;
        int length;
        int i6;
        this.f19008n = 0;
        if (!B0(cArr)) {
            this.f19008n = -2;
            return null;
        }
        int length2 = cArr.length;
        int i7 = length2 + 1;
        char cC02 = C0(this.f18999e + length2);
        boolean z5 = cC02 == '\"';
        if (z5) {
            cC02 = C0(this.f18999e + i7);
            i7 = length2 + 2;
        }
        if (cC02 == '-') {
            cC02 = C0(this.f18999e + i7);
            i7++;
        }
        if (cC02 < '0' || cC02 > '9') {
            if (cC02 != 'n' || C0(this.f18999e + i7) != 'u' || C0(this.f18999e + i7 + 1) != 'l' || C0(this.f18999e + i7 + 2) != 'l') {
                this.f19008n = -1;
                return null;
            }
            this.f19008n = 5;
            int i8 = i7 + 4;
            char cC03 = C0(this.f18999e + i7 + 3);
            if (z5 && cC03 == '\"') {
                cC03 = C0(this.f18999e + i8);
                i8 = i7 + 5;
            }
            while (cC03 != ',') {
                if (cC03 == '}') {
                    int i9 = this.f18999e + i8;
                    this.f18999e = i9;
                    this.f18998d = C0(i9);
                    this.f19008n = 5;
                    this.f18995a = 13;
                    return null;
                }
                if (!I0(cC03)) {
                    this.f19008n = -1;
                    return null;
                }
                cC03 = C0(this.f18999e + i8);
                i8++;
            }
            int i10 = this.f18999e + i8;
            this.f18999e = i10;
            this.f18998d = C0(i10);
            this.f19008n = 5;
            this.f18995a = 16;
            return null;
        }
        while (true) {
            i5 = i7 + 1;
            cC0 = C0(this.f18999e + i7);
            if (cC0 < '0' || cC0 > '9') {
                break;
            }
            i7 = i5;
        }
        if (cC0 == '.') {
            int i11 = i7 + 2;
            char cC04 = C0(this.f18999e + i5);
            if (cC04 < '0' || cC04 > '9') {
                this.f19008n = -1;
                return null;
            }
            while (true) {
                i5 = i11 + 1;
                cC0 = C0(this.f18999e + i11);
                if (cC0 < '0' || cC0 > '9') {
                    break;
                }
                i11 = i5;
            }
        }
        if (cC0 == 'e' || cC0 == 'E') {
            int i12 = i5 + 1;
            cC0 = C0(this.f18999e + i5);
            if (cC0 == '+' || cC0 == '-') {
                i5 += 2;
                cC0 = C0(this.f18999e + i12);
            } else {
                i5 = i12;
            }
            while (cC0 >= '0' && cC0 <= '9') {
                char cC05 = C0(this.f18999e + i5);
                i5++;
                cC0 = cC05;
            }
        }
        if (!z5) {
            int i13 = this.f18999e;
            length = cArr.length + i13;
            i6 = ((i13 + i5) - length) - 1;
        } else {
            if (cC0 != '\"') {
                this.f19008n = -1;
                return null;
            }
            int i14 = i5 + 1;
            cC0 = C0(this.f18999e + i5);
            int i15 = this.f18999e;
            length = cArr.length + i15 + 1;
            i6 = ((i15 + i14) - length) - 2;
            i5 = i14;
        }
        if (i6 > 65535) {
            throw new l0.d("scan decimal overflow");
        }
        char[] cArrO1 = o1(length, i6);
        BigDecimal bigDecimal = new BigDecimal(cArrO1, 0, cArrO1.length, MathContext.UNLIMITED);
        if (cC0 == ',') {
            int i16 = this.f18999e + i5;
            this.f18999e = i16;
            this.f18998d = C0(i16);
            this.f19008n = 3;
            this.f18995a = 16;
            return bigDecimal;
        }
        if (cC0 != '}') {
            this.f19008n = -1;
            return null;
        }
        int i17 = i5 + 1;
        char cC06 = C0(this.f18999e + i5);
        if (cC06 == ',') {
            this.f18995a = 16;
            int i18 = this.f18999e + i17;
            this.f18999e = i18;
            this.f18998d = C0(i18);
        } else if (cC06 == ']') {
            this.f18995a = 15;
            int i19 = this.f18999e + i17;
            this.f18999e = i19;
            this.f18998d = C0(i19);
        } else if (cC06 == '}') {
            this.f18995a = 13;
            int i20 = this.f18999e + i17;
            this.f18999e = i20;
            this.f18998d = C0(i20);
        } else {
            if (cC06 != 26) {
                this.f19008n = -1;
                return null;
            }
            this.f18995a = 20;
            this.f18999e += i5;
            this.f18998d = (char) 26;
        }
        this.f19008n = 4;
        return bigDecimal;
    }

    @Override // o0.InterfaceC0890c
    public final String V(C0897j c0897j, char c6) throws NumberFormatException {
        String strC;
        this.f19003i = this.f18999e;
        this.f19002h = 0;
        boolean z5 = false;
        int i5 = 0;
        while (true) {
            char next = next();
            if (next == c6) {
                this.f18995a = 4;
                if (z5) {
                    strC = c0897j.c(this.f19001g, 0, this.f19002h, i5);
                } else {
                    int i6 = this.f19003i;
                    strC = z0(i6 == -1 ? 0 : i6 + 1, this.f19002h, i5, c0897j);
                }
                this.f19002h = 0;
                next();
                return strC;
            }
            if (next == 26) {
                throw new l0.d("unclosed.str");
            }
            if (next == '\\') {
                if (!z5) {
                    int i7 = this.f19002h;
                    char[] cArr = this.f19001g;
                    if (i7 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i7 <= length) {
                            i7 = length;
                        }
                        char[] cArr2 = new char[i7];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f19001g = cArr2;
                    }
                    A0(this.f19003i + 1, this.f19001g, 0, this.f19002h);
                    z5 = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i5 = (i5 * 31) + 34;
                    N0('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i5 = (i5 * 31) + 92;
                            N0('\\');
                        } else if (next2 == 'b') {
                            i5 = (i5 * 31) + 8;
                            N0('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i5 = (i5 * 31) + 10;
                                N0('\n');
                            } else if (next2 == 'r') {
                                i5 = (i5 * 31) + 13;
                                N0('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i5 = (i5 * 31) + 47;
                                        N0('/');
                                        break;
                                    case '0':
                                        i5 = (i5 * 31) + next2;
                                        N0((char) 0);
                                        break;
                                    case '1':
                                        i5 = (i5 * 31) + next2;
                                        N0((char) 1);
                                        break;
                                    case '2':
                                        i5 = (i5 * 31) + next2;
                                        N0((char) 2);
                                        break;
                                    case '3':
                                        i5 = (i5 * 31) + next2;
                                        N0((char) 3);
                                        break;
                                    case '4':
                                        i5 = (i5 * 31) + next2;
                                        N0((char) 4);
                                        break;
                                    case '5':
                                        i5 = (i5 * 31) + next2;
                                        N0((char) 5);
                                        break;
                                    case '6':
                                        i5 = (i5 * 31) + next2;
                                        N0((char) 6);
                                        break;
                                    case '7':
                                        i5 = (i5 * 31) + next2;
                                        N0((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i5 = (i5 * 31) + 9;
                                                N0('\t');
                                                break;
                                            case 'u':
                                                int i8 = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i5 = (i5 * 31) + i8;
                                                N0((char) i8);
                                                break;
                                            case 'v':
                                                i5 = (i5 * 31) + 11;
                                                N0((char) 11);
                                                break;
                                            default:
                                                this.f18998d = next2;
                                                throw new l0.d("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char next3 = next();
                                this.f18998d = next3;
                                char next4 = next();
                                this.f18998d = next4;
                                int[] iArr = f18994s;
                                char c7 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i5 = (i5 * 31) + c7;
                                N0(c7);
                            }
                        }
                    }
                    i5 = (i5 * 31) + 12;
                    N0('\f');
                } else {
                    i5 = (i5 * 31) + 39;
                    N0('\'');
                }
            } else {
                i5 = (i5 * 31) + next;
                if (z5) {
                    int i9 = this.f19002h;
                    char[] cArr3 = this.f19001g;
                    if (i9 == cArr3.length) {
                        N0(next);
                    } else {
                        this.f19002h = i9 + 1;
                        cArr3[i9] = next;
                    }
                } else {
                    this.f19002h++;
                }
            }
        }
    }

    public final double V0(char[] cArr) throws NumberFormatException {
        int i5;
        char cC0;
        long j5;
        int length;
        int i6;
        double d6;
        this.f19008n = 0;
        if (!B0(cArr)) {
            this.f19008n = -2;
            return 0.0d;
        }
        int length2 = cArr.length;
        int i7 = length2 + 1;
        char cC02 = C0(this.f18999e + length2);
        boolean z5 = cC02 == '\"';
        if (z5) {
            cC02 = C0(this.f18999e + i7);
            i7 = length2 + 2;
        }
        boolean z6 = cC02 == '-';
        if (z6) {
            cC02 = C0(this.f18999e + i7);
            i7++;
        }
        if (cC02 < '0' || cC02 > '9') {
            boolean z7 = z5;
            if (cC02 != 'n' || C0(this.f18999e + i7) != 'u' || C0(this.f18999e + i7 + 1) != 'l' || C0(this.f18999e + i7 + 2) != 'l') {
                this.f19008n = -1;
                return 0.0d;
            }
            this.f19008n = 5;
            int i8 = i7 + 4;
            char cC03 = C0(this.f18999e + i7 + 3);
            if (z7 && cC03 == '\"') {
                int i9 = i7 + 5;
                cC03 = C0(this.f18999e + i8);
                i8 = i9;
            }
            while (cC03 != ',') {
                if (cC03 == '}') {
                    int i10 = this.f18999e + i8;
                    this.f18999e = i10;
                    this.f18998d = C0(i10);
                    this.f19008n = 5;
                    this.f18995a = 13;
                    return 0.0d;
                }
                if (!I0(cC03)) {
                    this.f19008n = -1;
                    return 0.0d;
                }
                int i11 = i8 + 1;
                cC03 = C0(this.f18999e + i8);
                i8 = i11;
            }
            int i12 = this.f18999e + i8;
            this.f18999e = i12;
            this.f18998d = C0(i12);
            this.f19008n = 5;
            this.f18995a = 16;
            return 0.0d;
        }
        boolean z8 = z5;
        long j6 = cC02 - '0';
        while (true) {
            i5 = i7 + 1;
            cC0 = C0(this.f18999e + i7);
            if (cC0 < '0' || cC0 > '9') {
                break;
            }
            j6 = (j6 * 10) + (cC0 - '0');
            i7 = i5;
        }
        if (cC0 == '.') {
            int i13 = i7 + 2;
            char cC04 = C0(this.f18999e + i5);
            if (cC04 < '0' || cC04 > '9') {
                this.f19008n = -1;
                return 0.0d;
            }
            j6 = (j6 * 10) + (cC04 - '0');
            j5 = 10;
            while (true) {
                i5 = i13 + 1;
                cC0 = C0(this.f18999e + i13);
                if (cC0 < '0' || cC0 > '9') {
                    break;
                }
                j6 = (j6 * 10) + (cC0 - '0');
                j5 *= 10;
                i13 = i5;
            }
        } else {
            j5 = 1;
        }
        boolean z9 = cC0 == 'e' || cC0 == 'E';
        if (z9) {
            int i14 = i5 + 1;
            cC0 = C0(this.f18999e + i5);
            if (cC0 == '+' || cC0 == '-') {
                i5 += 2;
                cC0 = C0(this.f18999e + i14);
            } else {
                i5 = i14;
            }
            while (cC0 >= '0' && cC0 <= '9') {
                char cC05 = C0(this.f18999e + i5);
                i5++;
                cC0 = cC05;
            }
        }
        if (!z8) {
            int i15 = this.f18999e;
            length = cArr.length + i15;
            i6 = ((i15 + i5) - length) - 1;
        } else {
            if (cC0 != '\"') {
                this.f19008n = -1;
                return 0.0d;
            }
            int i16 = i5 + 1;
            cC0 = C0(this.f18999e + i5);
            int i17 = this.f18999e;
            length = cArr.length + i17 + 1;
            i6 = ((i17 + i16) - length) - 2;
            i5 = i16;
        }
        if (z9 || i6 >= 17) {
            d6 = Double.parseDouble(n1(length, i6));
        } else {
            d6 = j6 / j5;
            if (z6) {
                d6 = -d6;
            }
        }
        if (cC0 == ',') {
            int i18 = this.f18999e + i5;
            this.f18999e = i18;
            this.f18998d = C0(i18);
            this.f19008n = 3;
            this.f18995a = 16;
            return d6;
        }
        if (cC0 != '}') {
            this.f19008n = -1;
            return 0.0d;
        }
        int i19 = i5 + 1;
        char cC06 = C0(this.f18999e + i5);
        if (cC06 == ',') {
            this.f18995a = 16;
            int i20 = this.f18999e + i19;
            this.f18999e = i20;
            this.f18998d = C0(i20);
        } else if (cC06 == ']') {
            this.f18995a = 15;
            int i21 = this.f18999e + i19;
            this.f18999e = i21;
            this.f18998d = C0(i21);
        } else if (cC06 == '}') {
            this.f18995a = 13;
            int i22 = this.f18999e + i19;
            this.f18999e = i22;
            this.f18998d = C0(i22);
        } else {
            if (cC06 != 26) {
                this.f19008n = -1;
                return 0.0d;
            }
            this.f18995a = 20;
            this.f18999e += i5;
            this.f18998d = (char) 26;
        }
        this.f19008n = 4;
        return d6;
    }

    @Override // o0.InterfaceC0890c
    public String W(char c6) {
        this.f19008n = 0;
        char cC0 = C0(this.f18999e);
        if (cC0 == 'n') {
            if (C0(this.f18999e + 1) != 'u' || C0(this.f18999e + 2) != 'l' || C0(this.f18999e + 3) != 'l') {
                this.f19008n = -1;
                return null;
            }
            if (C0(this.f18999e + 4) != c6) {
                this.f19008n = -1;
                return null;
            }
            int i5 = this.f18999e + 5;
            this.f18999e = i5;
            this.f18998d = C0(i5);
            this.f19008n = 3;
            return null;
        }
        int i6 = 1;
        while (cC0 != '\"') {
            if (!I0(cC0)) {
                this.f19008n = -1;
                return m1();
            }
            cC0 = C0(this.f18999e + i6);
            i6++;
        }
        int i7 = this.f18999e + i6;
        int iG0 = G0('\"', i7);
        if (iG0 == -1) {
            throw new l0.d("unclosed str");
        }
        String strN1 = n1(this.f18999e + i6, iG0 - i7);
        if (strN1.indexOf(92) != -1) {
            while (true) {
                int i8 = 0;
                for (int i9 = iG0 - 1; i9 >= 0 && C0(i9) == '\\'; i9--) {
                    i8++;
                }
                if (i8 % 2 == 0) {
                    break;
                }
                iG0 = G0('\"', iG0 + 1);
            }
            int i10 = iG0 - i7;
            strN1 = O0(o1(this.f18999e + 1, i10), i10);
        }
        int i11 = i6 + (iG0 - i7) + 1;
        int i12 = i11 + 1;
        char cC02 = C0(this.f18999e + i11);
        while (cC02 != c6) {
            if (!I0(cC02)) {
                if (cC02 == ']') {
                    int i13 = this.f18999e + i12;
                    this.f18999e = i13;
                    this.f18998d = C0(i13);
                    this.f19008n = -1;
                }
                return strN1;
            }
            cC02 = C0(this.f18999e + i12);
            i12++;
        }
        int i14 = this.f18999e + i12;
        this.f18999e = i14;
        this.f18998d = C0(i14);
        this.f19008n = 3;
        this.f18995a = 16;
        return strN1;
    }

    public final float W0(char[] cArr) throws NumberFormatException {
        int i5;
        char cC0;
        long j5;
        int length;
        int i6;
        float f5;
        this.f19008n = 0;
        if (!B0(cArr)) {
            this.f19008n = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i7 = length2 + 1;
        char cC02 = C0(this.f18999e + length2);
        boolean z5 = cC02 == '\"';
        if (z5) {
            cC02 = C0(this.f18999e + i7);
            i7 = length2 + 2;
        }
        boolean z6 = cC02 == '-';
        if (z6) {
            cC02 = C0(this.f18999e + i7);
            i7++;
        }
        if (cC02 < '0' || cC02 > '9') {
            boolean z7 = z5;
            if (cC02 != 'n' || C0(this.f18999e + i7) != 'u' || C0(this.f18999e + i7 + 1) != 'l' || C0(this.f18999e + i7 + 2) != 'l') {
                this.f19008n = -1;
                return 0.0f;
            }
            this.f19008n = 5;
            int i8 = i7 + 4;
            char cC03 = C0(this.f18999e + i7 + 3);
            if (z7 && cC03 == '\"') {
                int i9 = i7 + 5;
                cC03 = C0(this.f18999e + i8);
                i8 = i9;
            }
            while (cC03 != ',') {
                if (cC03 == '}') {
                    int i10 = this.f18999e + i8;
                    this.f18999e = i10;
                    this.f18998d = C0(i10);
                    this.f19008n = 5;
                    this.f18995a = 13;
                    return 0.0f;
                }
                if (!I0(cC03)) {
                    this.f19008n = -1;
                    return 0.0f;
                }
                int i11 = i8 + 1;
                cC03 = C0(this.f18999e + i8);
                i8 = i11;
            }
            int i12 = this.f18999e + i8;
            this.f18999e = i12;
            this.f18998d = C0(i12);
            this.f19008n = 5;
            this.f18995a = 16;
            return 0.0f;
        }
        boolean z8 = z5;
        long j6 = cC02 - '0';
        while (true) {
            i5 = i7 + 1;
            cC0 = C0(this.f18999e + i7);
            if (cC0 < '0' || cC0 > '9') {
                break;
            }
            j6 = (j6 * 10) + (cC0 - '0');
            i7 = i5;
        }
        if (cC0 == '.') {
            int i13 = i7 + 2;
            char cC04 = C0(this.f18999e + i5);
            if (cC04 < '0' || cC04 > '9') {
                this.f19008n = -1;
                return 0.0f;
            }
            j6 = (j6 * 10) + (cC04 - '0');
            j5 = 10;
            while (true) {
                i5 = i13 + 1;
                cC0 = C0(this.f18999e + i13);
                if (cC0 < '0' || cC0 > '9') {
                    break;
                }
                j6 = (j6 * 10) + (cC0 - '0');
                j5 *= 10;
                i13 = i5;
            }
        } else {
            j5 = 1;
        }
        boolean z9 = cC0 == 'e' || cC0 == 'E';
        if (z9) {
            int i14 = i5 + 1;
            cC0 = C0(this.f18999e + i5);
            if (cC0 == '+' || cC0 == '-') {
                i5 += 2;
                cC0 = C0(this.f18999e + i14);
            } else {
                i5 = i14;
            }
            while (cC0 >= '0' && cC0 <= '9') {
                char cC05 = C0(this.f18999e + i5);
                i5++;
                cC0 = cC05;
            }
        }
        if (!z8) {
            int i15 = this.f18999e;
            length = cArr.length + i15;
            i6 = ((i15 + i5) - length) - 1;
        } else {
            if (cC0 != '\"') {
                this.f19008n = -1;
                return 0.0f;
            }
            int i16 = i5 + 1;
            cC0 = C0(this.f18999e + i5);
            int i17 = this.f18999e;
            length = cArr.length + i17 + 1;
            i6 = ((i17 + i16) - length) - 2;
            i5 = i16;
        }
        if (z9 || i6 >= 17) {
            f5 = Float.parseFloat(n1(length, i6));
        } else {
            f5 = (float) (j6 / j5);
            if (z6) {
                f5 = -f5;
            }
        }
        if (cC0 == ',') {
            int i18 = this.f18999e + i5;
            this.f18999e = i18;
            this.f18998d = C0(i18);
            this.f19008n = 3;
            this.f18995a = 16;
            return f5;
        }
        if (cC0 != '}') {
            this.f19008n = -1;
            return 0.0f;
        }
        int i19 = i5 + 1;
        char cC06 = C0(this.f18999e + i5);
        if (cC06 == ',') {
            this.f18995a = 16;
            int i20 = this.f18999e + i19;
            this.f18999e = i20;
            this.f18998d = C0(i20);
        } else if (cC06 == ']') {
            this.f18995a = 15;
            int i21 = this.f18999e + i19;
            this.f18999e = i21;
            this.f18998d = C0(i21);
        } else if (cC06 == '}') {
            this.f18995a = 13;
            int i22 = this.f18999e + i19;
            this.f18999e = i22;
            this.f18998d = C0(i22);
        } else {
            if (cC06 != 26) {
                this.f19008n = -1;
                return 0.0f;
            }
            this.f18999e += i5;
            this.f18995a = 20;
            this.f18998d = (char) 26;
        }
        this.f19008n = 4;
        return f5;
    }

    @Override // o0.InterfaceC0890c
    public Enum<?> X(Class<?> cls, C0897j c0897j, char c6) {
        String strI1 = i1(c0897j, c6);
        if (strI1 == null) {
            return null;
        }
        return Enum.valueOf(cls, strI1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
    
        r20.f19008n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a3, code lost:
    
        return r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01af, code lost:
    
        r17 = r4;
        r20.f19008n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01b4, code lost:
    
        return r17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float[] X0(char[] r21) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.AbstractC0891d.X0(char[]):float[]");
    }

    @Override // o0.InterfaceC0890c
    public int Y() {
        return this.f18997c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b1, code lost:
    
        r22.f19008n = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b3, code lost:
    
        return r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0134, code lost:
    
        r5 = r20 + 1;
        r2 = C0(r22.f18999e + r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x013f, code lost:
    
        if (r4 == r3.length) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0141, code lost:
    
        r7 = new float[r4];
        java.lang.System.arraycopy(r3, 0, r7, 0, r4);
        r3 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0148, code lost:
    
        if (r8 < r6.length) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x014a, code lost:
    
        r6 = new float[(r6.length * 3) / 2][];
        java.lang.System.arraycopy(r3, 0, r6, 0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0154, code lost:
    
        r4 = r8 + 1;
        r6[r8] = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x015a, code lost:
    
        if (r2 != ',') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x015c, code lost:
    
        r3 = C0(r22.f18999e + r5);
        r2 = r20 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x016b, code lost:
    
        if (r2 != ']') goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x016d, code lost:
    
        r3 = C0(r22.f18999e + r5);
        r2 = r20 + 2;
        r8 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x017b, code lost:
    
        r3 = r2;
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0193, code lost:
    
        r22.f19008n = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0196, code lost:
    
        return r16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float[][] Y0(char[] r23) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.AbstractC0891d.Y0(char[]):float[][]");
    }

    public int Z0(char[] cArr) {
        int i5;
        char cC0;
        this.f19008n = 0;
        if (!B0(cArr)) {
            this.f19008n = -2;
            return 0;
        }
        int length = cArr.length;
        int i6 = length + 1;
        char cC02 = C0(this.f18999e + length);
        boolean z5 = cC02 == '-';
        if (z5) {
            cC02 = C0(this.f18999e + i6);
            i6 = length + 2;
        }
        if (cC02 < '0' || cC02 > '9') {
            this.f19008n = -1;
            return 0;
        }
        int i7 = cC02 - '0';
        while (true) {
            i5 = i6 + 1;
            cC0 = C0(this.f18999e + i6);
            if (cC0 < '0' || cC0 > '9') {
                break;
            }
            i7 = (i7 * 10) + (cC0 - '0');
            i6 = i5;
        }
        if (cC0 == '.') {
            this.f19008n = -1;
            return 0;
        }
        if ((i7 < 0 || i5 > cArr.length + 14) && !(i7 == Integer.MIN_VALUE && i5 == 17 && z5)) {
            this.f19008n = -1;
            return 0;
        }
        if (cC0 == ',') {
            int i8 = this.f18999e + i5;
            this.f18999e = i8;
            this.f18998d = C0(i8);
            this.f19008n = 3;
            this.f18995a = 16;
            if (z5) {
                return -i7;
            }
        } else {
            if (cC0 != '}') {
                this.f19008n = -1;
                return 0;
            }
            int i9 = i6 + 2;
            char cC03 = C0(this.f18999e + i5);
            if (cC03 == ',') {
                this.f18995a = 16;
                int i10 = this.f18999e + i9;
                this.f18999e = i10;
                this.f18998d = C0(i10);
            } else if (cC03 == ']') {
                this.f18995a = 15;
                int i11 = this.f18999e + i9;
                this.f18999e = i11;
                this.f18998d = C0(i11);
            } else if (cC03 == '}') {
                this.f18995a = 13;
                int i12 = this.f18999e + i9;
                this.f18999e = i12;
                this.f18998d = C0(i12);
            } else {
                if (cC03 != 26) {
                    this.f19008n = -1;
                    return 0;
                }
                this.f18995a = 20;
                this.f18999e += i6 + 1;
                this.f18998d = (char) 26;
            }
            this.f19008n = 4;
            if (z5) {
                return -i7;
            }
        }
        return i7;
    }

    @Override // o0.InterfaceC0890c
    public final int a() {
        return this.f18996b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x011d, code lost:
    
        r16 = r4;
        r19.f19008n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0121, code lost:
    
        return r16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] a1(char[] r20) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.AbstractC0891d.a1(char[]):int[]");
    }

    public long b1(char[] cArr) {
        int i5;
        char cC0;
        boolean z5 = false;
        this.f19008n = 0;
        if (!B0(cArr)) {
            this.f19008n = -2;
            return 0L;
        }
        int length = cArr.length;
        int i6 = length + 1;
        char cC02 = C0(this.f18999e + length);
        if (cC02 == '-') {
            cC02 = C0(this.f18999e + i6);
            i6 = length + 2;
            z5 = true;
        }
        if (cC02 < '0' || cC02 > '9') {
            this.f19008n = -1;
            return 0L;
        }
        long j5 = cC02 - '0';
        while (true) {
            i5 = i6 + 1;
            cC0 = C0(this.f18999e + i6);
            if (cC0 < '0' || cC0 > '9') {
                break;
            }
            j5 = (j5 * 10) + (cC0 - '0');
            i6 = i5;
        }
        if (cC0 == '.') {
            this.f19008n = -1;
            return 0L;
        }
        if (i5 - cArr.length >= 21 || (j5 < 0 && !(j5 == Long.MIN_VALUE && z5))) {
            this.f19008n = -1;
            return 0L;
        }
        if (cC0 == ',') {
            int i7 = this.f18999e + i5;
            this.f18999e = i7;
            this.f18998d = C0(i7);
            this.f19008n = 3;
            this.f18995a = 16;
            if (z5) {
                return -j5;
            }
        } else {
            if (cC0 != '}') {
                this.f19008n = -1;
                return 0L;
            }
            int i8 = i6 + 2;
            char cC03 = C0(this.f18999e + i5);
            if (cC03 == ',') {
                this.f18995a = 16;
                int i9 = this.f18999e + i8;
                this.f18999e = i9;
                this.f18998d = C0(i9);
            } else if (cC03 == ']') {
                this.f18995a = 15;
                int i10 = this.f18999e + i8;
                this.f18999e = i10;
                this.f18998d = C0(i10);
            } else if (cC03 == '}') {
                this.f18995a = 13;
                int i11 = this.f18999e + i8;
                this.f18999e = i11;
                this.f18998d = C0(i11);
            } else {
                if (cC03 != 26) {
                    this.f19008n = -1;
                    return 0L;
                }
                this.f18995a = 20;
                this.f18999e += i6 + 1;
                this.f18998d = (char) 26;
            }
            this.f19008n = 4;
            if (z5) {
                return -j5;
            }
        }
        return j5;
    }

    @Override // o0.InterfaceC0890c
    public String c() {
        return BuildConfig.FLAVOR;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00ca -> B:49:0x00ba). Please report as a decompilation issue!!! */
    @Override // o0.InterfaceC0890c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double c0(char r25) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.AbstractC0891d.c0(char):double");
    }

    public String c1(char[] cArr) {
        this.f19008n = 0;
        if (!B0(cArr)) {
            this.f19008n = -2;
            return m1();
        }
        int length = cArr.length;
        int i5 = length + 1;
        if (C0(this.f18999e + length) != '\"') {
            this.f19008n = -1;
            return m1();
        }
        int iG0 = G0('\"', this.f18999e + cArr.length + 1);
        if (iG0 == -1) {
            throw new l0.d("unclosed str");
        }
        int length2 = this.f18999e + cArr.length + 1;
        String strN1 = n1(length2, iG0 - length2);
        if (strN1.indexOf(92) != -1) {
            while (true) {
                int i6 = 0;
                for (int i7 = iG0 - 1; i7 >= 0 && C0(i7) == '\\'; i7--) {
                    i6++;
                }
                if (i6 % 2 == 0) {
                    break;
                }
                iG0 = G0('\"', iG0 + 1);
            }
            int i8 = this.f18999e;
            int length3 = iG0 - ((cArr.length + i8) + 1);
            strN1 = O0(o1(i8 + cArr.length + 1, length3), length3);
        }
        int i9 = this.f18999e;
        int length4 = i5 + (iG0 - ((cArr.length + i9) + 1)) + 1;
        int i10 = length4 + 1;
        char cC0 = C0(i9 + length4);
        if (cC0 == ',') {
            int i11 = this.f18999e + i10;
            this.f18999e = i11;
            this.f18998d = C0(i11);
            this.f19008n = 3;
            return strN1;
        }
        if (cC0 != '}') {
            this.f19008n = -1;
            return m1();
        }
        int i12 = length4 + 2;
        char cC02 = C0(this.f18999e + i10);
        if (cC02 == ',') {
            this.f18995a = 16;
            int i13 = this.f18999e + i12;
            this.f18999e = i13;
            this.f18998d = C0(i13);
        } else if (cC02 == ']') {
            this.f18995a = 15;
            int i14 = this.f18999e + i12;
            this.f18999e = i14;
            this.f18998d = C0(i14);
        } else if (cC02 == '}') {
            this.f18995a = 13;
            int i15 = this.f18999e + i12;
            this.f18999e = i15;
            this.f18998d = C0(i15);
        } else {
            if (cC02 != 26) {
                this.f19008n = -1;
                return m1();
            }
            this.f18995a = 20;
            this.f18999e += length4 + 1;
            this.f18998d = (char) 26;
        }
        this.f19008n = 4;
        return strN1;
    }

    @Override // o0.InterfaceC0890c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.f19001g;
        if (cArr.length <= 8192) {
            f18992q.set(cArr);
        }
        this.f19001g = null;
    }

    @Override // o0.InterfaceC0890c
    public final char d0() {
        return this.f18998d;
    }

    public final void d1() {
        char next;
        if (this.f18998d != 'x') {
            throw new l0.d("illegal state. " + this.f18998d);
        }
        next();
        if (this.f18998d != '\'') {
            throw new l0.d("illegal state. " + this.f18998d);
        }
        this.f19003i = this.f18999e;
        next();
        if (this.f18998d == '\'') {
            next();
            this.f18995a = 26;
            return;
        }
        while (true) {
            next = next();
            if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                break;
            } else {
                this.f19002h++;
            }
        }
        if (next == '\'') {
            this.f19002h++;
            next();
            this.f18995a = 26;
        } else {
            throw new l0.d("illegal state. " + next);
        }
    }

    public final void e1() {
        this.f19003i = this.f18999e - 1;
        this.f19004j = false;
        do {
            this.f19002h++;
            next();
        } while (Character.isLetterOrDigit(this.f18998d));
        String strN = N();
        if ("null".equalsIgnoreCase(strN)) {
            this.f18995a = 8;
            return;
        }
        if ("new".equals(strN)) {
            this.f18995a = 9;
            return;
        }
        if ("true".equals(strN)) {
            this.f18995a = 6;
            return;
        }
        if ("false".equals(strN)) {
            this.f18995a = 7;
            return;
        }
        if ("undefined".equals(strN)) {
            this.f18995a = 23;
            return;
        }
        if ("Set".equals(strN)) {
            this.f18995a = 21;
        } else if ("TreeSet".equals(strN)) {
            this.f18995a = 22;
        } else {
            this.f18995a = 18;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005c -> B:11:0x002e). Please report as a decompilation issue!!! */
    @Override // o0.InterfaceC0890c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long f() {
        /*
            r13 = this;
            int r0 = r13.f19003i
            r1 = -1
            r2 = 0
            if (r0 != r1) goto L8
            r13.f19003i = r2
        L8:
            int r0 = r13.f19003i
            int r1 = r13.f19002h
            int r1 = r1 + r0
            char r3 = r13.C0(r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L1d
            int r0 = r0 + 1
            r2 = -9223372036854775808
            r3 = r2
            r2 = r5
            goto L22
        L1d:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L22:
            if (r0 >= r1) goto L30
            int r6 = r0 + 1
            char r0 = r13.C0(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r7 = (long) r0
        L2e:
            r0 = r6
            goto L32
        L30:
            r7 = 0
        L32:
            if (r0 >= r1) goto L73
            int r6 = r0 + 1
            char r0 = r13.C0(r0)
            r9 = 76
            if (r0 == r9) goto L72
            r9 = 83
            if (r0 == r9) goto L72
            r9 = 66
            if (r0 != r9) goto L47
            goto L72
        L47:
            int r0 = r0 + (-48)
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 < 0) goto L68
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r3 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L5e
            long r7 = r7 - r9
            goto L2e
        L5e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = r13.w0()
            r0.<init>(r13)
            throw r0
        L68:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = r13.w0()
            r0.<init>(r13)
            throw r0
        L72:
            r0 = r6
        L73:
            if (r2 == 0) goto L85
            int r1 = r13.f19003i
            int r1 = r1 + r5
            if (r0 <= r1) goto L7b
            return r7
        L7b:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = r13.w0()
            r0.<init>(r13)
            throw r0
        L85:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.AbstractC0891d.f():long");
    }

    public final void f1() {
        g1(true);
    }

    public final void g1(boolean z5) {
        if (this.f18998d != 'n') {
            throw new l0.d("error parse null or new");
        }
        next();
        char c6 = this.f18998d;
        if (c6 != 'u') {
            if (c6 != 'e') {
                throw new l0.d("error parse new");
            }
            next();
            if (this.f18998d != 'w') {
                throw new l0.d("error parse new");
            }
            next();
            char c7 = this.f18998d;
            if (c7 != ' ' && c7 != ',' && c7 != '}' && c7 != ']' && c7 != '\n' && c7 != '\r' && c7 != '\t' && c7 != 26 && c7 != '\f' && c7 != '\b') {
                throw new l0.d("scan new error");
            }
            this.f18995a = 9;
            return;
        }
        next();
        if (this.f18998d != 'l') {
            throw new l0.d("error parse null");
        }
        next();
        if (this.f18998d != 'l') {
            throw new l0.d("error parse null");
        }
        next();
        char c8 = this.f18998d;
        if (c8 != ' ' && c8 != ',' && c8 != '}' && c8 != ']' && c8 != '\n' && c8 != '\r' && c8 != '\t' && c8 != 26 && ((c8 != ':' || !z5) && c8 != '\f' && c8 != '\b')) {
            throw new l0.d("scan null error");
        }
        this.f18995a = 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009f A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a1 -> B:39:0x0091). Please report as a decompilation issue!!! */
    @Override // o0.InterfaceC0890c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.math.BigDecimal h0(char r19) {
        /*
            Method dump skipped, instructions count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.AbstractC0891d.h0(char):java.math.BigDecimal");
    }

    public String i1(C0897j c0897j, char c6) {
        int i5 = 0;
        this.f19008n = 0;
        char cC0 = C0(this.f18999e);
        if (cC0 == 'n') {
            if (C0(this.f18999e + 1) != 'u' || C0(this.f18999e + 2) != 'l' || C0(this.f18999e + 3) != 'l') {
                this.f19008n = -1;
                return null;
            }
            if (C0(this.f18999e + 4) != c6) {
                this.f19008n = -1;
                return null;
            }
            int i6 = this.f18999e + 5;
            this.f18999e = i6;
            this.f18998d = C0(i6);
            this.f19008n = 3;
            return null;
        }
        if (cC0 != '\"') {
            this.f19008n = -1;
            return null;
        }
        int i7 = 1;
        while (true) {
            int i8 = i7 + 1;
            char cC02 = C0(this.f18999e + i7);
            if (cC02 == '\"') {
                int i9 = this.f18999e;
                int i10 = i9 + 1;
                String strZ0 = z0(i10, ((i9 + i8) - i10) - 1, i5, c0897j);
                int i11 = i7 + 2;
                char cC03 = C0(this.f18999e + i8);
                while (cC03 != c6) {
                    if (!I0(cC03)) {
                        this.f19008n = -1;
                        return strZ0;
                    }
                    cC03 = C0(this.f18999e + i11);
                    i11++;
                }
                int i12 = this.f18999e + i11;
                this.f18999e = i12;
                this.f18998d = C0(i12);
                this.f19008n = 3;
                return strZ0;
            }
            i5 = (i5 * 31) + cC02;
            if (cC02 == '\\') {
                this.f19008n = -1;
                return null;
            }
            i7 = i8;
        }
    }

    @Override // o0.InterfaceC0890c
    public final boolean isEnabled(int i5) {
        return (this.f18997c & i5) != 0;
    }

    @Override // o0.InterfaceC0890c
    public final void j0() {
        while (true) {
            char c6 = this.f18998d;
            if (c6 > '/') {
                return;
            }
            if (c6 == ' ' || c6 == '\r' || c6 == '\n' || c6 == '\t' || c6 == '\f' || c6 == '\b') {
                next();
            } else if (c6 != '/') {
                return;
            } else {
                l1();
            }
        }
    }

    public final void j1() {
        if (this.f18998d != 't') {
            throw new l0.d("error parse true");
        }
        next();
        if (this.f18998d != 'r') {
            throw new l0.d("error parse true");
        }
        next();
        if (this.f18998d != 'u') {
            throw new l0.d("error parse true");
        }
        next();
        if (this.f18998d != 'e') {
            throw new l0.d("error parse true");
        }
        next();
        char c6 = this.f18998d;
        if (c6 != ' ' && c6 != ',' && c6 != '}' && c6 != ']' && c6 != '\n' && c6 != '\r' && c6 != '\t' && c6 != 26 && c6 != '\f' && c6 != '\b' && c6 != ':' && c6 != '/') {
            throw new l0.d("scan true error");
        }
        this.f18995a = 6;
    }

    @Override // o0.InterfaceC0890c
    public final void k0() {
        this.f19002h = 0;
    }

    public void k1(TimeZone timeZone) {
        this.f19006l = timeZone;
    }

    @Override // o0.InterfaceC0890c
    public long l0(char c6) {
        int i5;
        int i6;
        char cC0;
        char c7;
        this.f19008n = 0;
        char cC02 = C0(this.f18999e);
        boolean z5 = cC02 == '\"';
        if (z5) {
            cC02 = C0(this.f18999e + 1);
            i5 = 2;
        } else {
            i5 = 1;
        }
        boolean z6 = cC02 == '-';
        if (z6) {
            cC02 = C0(this.f18999e + i5);
            i5++;
        }
        if (cC02 < '0' || cC02 > '9') {
            if (cC02 != 'n' || C0(this.f18999e + i5) != 'u' || C0(this.f18999e + i5 + 1) != 'l' || C0(this.f18999e + i5 + 2) != 'l') {
                this.f19008n = -1;
                return 0L;
            }
            this.f19008n = 5;
            int i7 = i5 + 4;
            char cC03 = C0(this.f18999e + i5 + 3);
            if (z5 && cC03 == '\"') {
                cC03 = C0(this.f18999e + i7);
                i7 = i5 + 5;
            }
            while (cC03 != ',') {
                if (cC03 == ']') {
                    int i8 = this.f18999e + i7;
                    this.f18999e = i8;
                    this.f18998d = C0(i8);
                    this.f19008n = 5;
                    this.f18995a = 15;
                    return 0L;
                }
                if (!I0(cC03)) {
                    this.f19008n = -1;
                    return 0L;
                }
                cC03 = C0(this.f18999e + i7);
                i7++;
            }
            int i9 = this.f18999e + i7;
            this.f18999e = i9;
            this.f18998d = C0(i9);
            this.f19008n = 5;
            this.f18995a = 16;
            return 0L;
        }
        long j5 = cC02 - '0';
        while (true) {
            i6 = i5 + 1;
            cC0 = C0(this.f18999e + i5);
            if (cC0 < '0' || cC0 > '9') {
                break;
            }
            j5 = (j5 * 10) + (cC0 - '0');
            i5 = i6;
        }
        if (cC0 == '.') {
            this.f19008n = -1;
            return 0L;
        }
        if (j5 < 0 && (j5 != Long.MIN_VALUE || !z6)) {
            throw new NumberFormatException(n1(this.f18999e, i5));
        }
        if (!z5) {
            c7 = c6;
        } else {
            if (cC0 != '\"') {
                this.f19008n = -1;
                return 0L;
            }
            cC0 = C0(this.f18999e + i6);
            c7 = c6;
            i6 = i5 + 2;
        }
        while (cC0 != c7) {
            if (!I0(cC0)) {
                this.f19008n = -1;
                return j5;
            }
            cC0 = C0(this.f18999e + i6);
            i6++;
        }
        int i10 = this.f18999e + i6;
        this.f18999e = i10;
        this.f18998d = C0(i10);
        this.f19008n = 3;
        this.f18995a = 16;
        return z6 ? -j5 : j5;
    }

    protected void l1() {
        char c6;
        next();
        char c7 = this.f18998d;
        if (c7 == '/') {
            do {
                next();
                c6 = this.f18998d;
                if (c6 == '\n') {
                    next();
                    return;
                }
            } while (c6 != 26);
            return;
        }
        if (c7 != '*') {
            throw new l0.d("invalid comment");
        }
        next();
        while (true) {
            char c8 = this.f18998d;
            if (c8 == 26) {
                return;
            }
            if (c8 == '*') {
                next();
                if (this.f18998d == '/') {
                    next();
                    return;
                }
            } else {
                next();
            }
        }
    }

    @Override // o0.InterfaceC0890c
    public boolean m() {
        int i5 = 0;
        while (true) {
            char cC0 = C0(i5);
            if (cC0 == 26) {
                this.f18995a = 20;
                return true;
            }
            if (!I0(cC0)) {
                return false;
            }
            i5++;
        }
    }

    @Override // o0.InterfaceC0890c
    public final void m0() {
        M0(':');
    }

    public final String m1() {
        return this.f19009o;
    }

    @Override // o0.InterfaceC0890c
    public String n0(C0897j c0897j) {
        return null;
    }

    public abstract String n1(int i5, int i6);

    @Override // o0.InterfaceC0890c
    public abstract char next();

    @Override // o0.InterfaceC0890c
    public final void nextToken() {
        this.f19002h = 0;
        while (true) {
            this.f18996b = this.f18999e;
            char c6 = this.f18998d;
            if (c6 == '/') {
                l1();
            } else {
                if (c6 == '\"') {
                    u();
                    return;
                }
                if (c6 == ',') {
                    next();
                    this.f18995a = 16;
                    return;
                }
                if (c6 >= '0' && c6 <= '9') {
                    w();
                    return;
                }
                if (c6 != '-') {
                    switch (c6) {
                        case '\b':
                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                        case ' ':
                            next();
                            break;
                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
                            if (!I(EnumC0889b.AllowSingleQuotes)) {
                                throw new l0.d("Feature.AllowSingleQuotes is false");
                            }
                            h1();
                            return;
                        case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
                            next();
                            this.f18995a = 10;
                            return;
                        case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
                            next();
                            this.f18995a = 11;
                            return;
                        case '+':
                            next();
                            w();
                            return;
                        case '.':
                            next();
                            this.f18995a = 25;
                            return;
                        case ':':
                            next();
                            this.f18995a = 17;
                            return;
                        case ';':
                            next();
                            this.f18995a = 24;
                            return;
                        case 'N':
                        case 'S':
                        case 'T':
                        case 'u':
                            e1();
                            return;
                        case '[':
                            next();
                            this.f18995a = 14;
                            return;
                        case ']':
                            next();
                            this.f18995a = 15;
                            return;
                        case 'f':
                            Q0();
                            return;
                        case 'n':
                            f1();
                            return;
                        case 't':
                            j1();
                            return;
                        case 'x':
                            d1();
                            return;
                        case '{':
                            next();
                            this.f18995a = 12;
                            return;
                        case '}':
                            next();
                            this.f18995a = 13;
                            return;
                        default:
                            if (H0()) {
                                if (this.f18995a == 20) {
                                    throw new l0.d("EOF error");
                                }
                                this.f18995a = 20;
                                int i5 = this.f18999e;
                                this.f18996b = i5;
                                this.f19000f = i5;
                                return;
                            }
                            char c7 = this.f18998d;
                            if (c7 > 31 && c7 != 127) {
                                J0("illegal.char", String.valueOf((int) c7));
                                next();
                                return;
                            } else {
                                next();
                                break;
                            }
                            break;
                    }
                } else {
                    w();
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    @Override // o0.InterfaceC0890c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o(char r10) {
        /*
            r9 = this;
            r0 = 0
            r9.f19008n = r0
            int r1 = r9.f18999e
            char r1 = r9.C0(r1)
            r2 = 116(0x74, float:1.63E-43)
            r3 = 5
            r4 = 101(0x65, float:1.42E-43)
            r5 = -1
            r6 = 3
            r7 = 2
            r8 = 1
            if (r1 != r2) goto L40
            int r1 = r9.f18999e
            int r1 = r1 + r8
            char r1 = r9.C0(r1)
            r2 = 114(0x72, float:1.6E-43)
            if (r1 != r2) goto L3d
            int r1 = r9.f18999e
            int r1 = r1 + r7
            char r1 = r9.C0(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L3d
            int r1 = r9.f18999e
            int r1 = r1 + r6
            char r1 = r9.C0(r1)
            if (r1 != r4) goto L3d
            int r0 = r9.f18999e
            int r0 = r0 + 4
            char r1 = r9.C0(r0)
        L3b:
            r0 = r8
            goto L96
        L3d:
            r9.f19008n = r5
            return r0
        L40:
            r2 = 102(0x66, float:1.43E-43)
            if (r1 != r2) goto L7b
            int r1 = r9.f18999e
            int r1 = r1 + r8
            char r1 = r9.C0(r1)
            r2 = 97
            if (r1 != r2) goto L78
            int r1 = r9.f18999e
            int r1 = r1 + r7
            char r1 = r9.C0(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L78
            int r1 = r9.f18999e
            int r1 = r1 + r6
            char r1 = r9.C0(r1)
            r2 = 115(0x73, float:1.61E-43)
            if (r1 != r2) goto L78
            int r1 = r9.f18999e
            int r1 = r1 + 4
            char r1 = r9.C0(r1)
            if (r1 != r4) goto L78
            int r1 = r9.f18999e
            int r1 = r1 + r3
            char r1 = r9.C0(r1)
            r3 = 6
            goto L96
        L78:
            r9.f19008n = r5
            return r0
        L7b:
            r2 = 49
            if (r1 != r2) goto L88
            int r0 = r9.f18999e
            int r0 = r0 + r8
            char r1 = r9.C0(r0)
            r3 = r7
            goto L3b
        L88:
            r2 = 48
            if (r1 != r2) goto L95
            int r1 = r9.f18999e
            int r1 = r1 + r8
            char r1 = r9.C0(r1)
            r3 = r7
            goto L96
        L95:
            r3 = r8
        L96:
            if (r1 != r10) goto La6
            int r10 = r9.f18999e
            int r10 = r10 + r3
            r9.f18999e = r10
            char r10 = r9.C0(r10)
            r9.f18998d = r10
            r9.f19008n = r6
            return r0
        La6:
            boolean r1 = I0(r1)
            if (r1 == 0) goto Lb7
            int r1 = r9.f18999e
            int r2 = r3 + 1
            int r1 = r1 + r3
            char r1 = r9.C0(r1)
            r3 = r2
            goto L96
        Lb7:
            r9.f19008n = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.AbstractC0891d.o(char):boolean");
    }

    @Override // o0.InterfaceC0890c
    public final String o0() {
        return C0894g.a(this.f18995a);
    }

    protected abstract char[] o1(int i5, int i6);

    @Override // o0.InterfaceC0890c
    public final Number p0(boolean z5) {
        char cC0 = C0((this.f19003i + this.f19002h) - 1);
        try {
            return cC0 == 'F' ? Float.valueOf(Float.parseFloat(w0())) : cC0 == 'D' ? Double.valueOf(Double.parseDouble(w0())) : z5 ? C() : Double.valueOf(E0());
        } catch (NumberFormatException e6) {
            throw new l0.d(e6.getMessage() + ", " + c());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00c7 -> B:49:0x00b7). Please report as a decompilation issue!!! */
    @Override // o0.InterfaceC0890c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float r(char r23) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.AbstractC0891d.r(char):float");
    }

    @Override // o0.InterfaceC0890c
    public Locale s0() {
        return this.f19007m;
    }

    @Override // o0.InterfaceC0890c
    public final void u() {
        char next;
        char next2;
        this.f19003i = this.f18999e;
        this.f19004j = false;
        while (true) {
            char next3 = next();
            if (next3 == '\"') {
                this.f18995a = 4;
                this.f18998d = next();
                return;
            }
            if (next3 != 26) {
                boolean z5 = true;
                if (next3 == '\\') {
                    if (!this.f19004j) {
                        this.f19004j = true;
                        int i5 = this.f19002h;
                        char[] cArr = this.f19001g;
                        if (i5 >= cArr.length) {
                            int length = cArr.length * 2;
                            if (i5 <= length) {
                                i5 = length;
                            }
                            char[] cArr2 = new char[i5];
                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                            this.f19001g = cArr2;
                        }
                        D0(this.f19003i + 1, this.f19002h, this.f19001g);
                    }
                    char next4 = next();
                    if (next4 == '\"') {
                        N0('\"');
                    } else if (next4 != '\'') {
                        if (next4 != 'F') {
                            if (next4 == '\\') {
                                N0('\\');
                            } else if (next4 == 'b') {
                                N0('\b');
                            } else if (next4 != 'f') {
                                if (next4 == 'n') {
                                    N0('\n');
                                } else if (next4 == 'r') {
                                    N0('\r');
                                } else if (next4 != 'x') {
                                    switch (next4) {
                                        case '/':
                                            N0('/');
                                            break;
                                        case '0':
                                            N0((char) 0);
                                            break;
                                        case '1':
                                            N0((char) 1);
                                            break;
                                        case '2':
                                            N0((char) 2);
                                            break;
                                        case '3':
                                            N0((char) 3);
                                            break;
                                        case '4':
                                            N0((char) 4);
                                            break;
                                        case '5':
                                            N0((char) 5);
                                            break;
                                        case '6':
                                            N0((char) 6);
                                            break;
                                        case '7':
                                            N0((char) 7);
                                            break;
                                        default:
                                            switch (next4) {
                                                case 't':
                                                    N0('\t');
                                                    break;
                                                case 'u':
                                                    N0((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                    break;
                                                case 'v':
                                                    N0((char) 11);
                                                    break;
                                                default:
                                                    this.f18998d = next4;
                                                    throw new l0.d("unclosed string : " + next4);
                                            }
                                    }
                                } else {
                                    next = next();
                                    next2 = next();
                                    boolean z6 = (next >= '0' && next <= '9') || (next >= 'a' && next <= 'f') || (next >= 'A' && next <= 'F');
                                    if ((next2 < '0' || next2 > '9') && ((next2 < 'a' || next2 > 'f') && (next2 < 'A' || next2 > 'F'))) {
                                        z5 = false;
                                    }
                                    if (z6 && z5) {
                                        int[] iArr = f18994s;
                                        N0((char) ((iArr[next] * 16) + iArr[next2]));
                                    }
                                }
                            }
                        }
                        N0('\f');
                    } else {
                        N0('\'');
                    }
                } else if (this.f19004j) {
                    int i6 = this.f19002h;
                    char[] cArr3 = this.f19001g;
                    if (i6 == cArr3.length) {
                        N0(next3);
                    } else {
                        this.f19002h = i6 + 1;
                        cArr3[i6] = next3;
                    }
                } else {
                    this.f19002h++;
                }
            } else {
                if (H0()) {
                    throw new l0.d("unclosed string : " + next3);
                }
                N0((char) 26);
            }
        }
        throw new l0.d("invalid escape character \\x" + next + next2);
    }

    @Override // o0.InterfaceC0890c
    public final boolean u0() {
        return this.f19002h == 4 && C0(this.f19003i + 1) == '$' && C0(this.f19003i + 2) == 'r' && C0(this.f19003i + 3) == 'e' && C0(this.f19003i + 4) == 'f';
    }

    @Override // o0.InterfaceC0890c
    public final int v() {
        int i5;
        boolean z5;
        int i6 = 0;
        if (this.f19003i == -1) {
            this.f19003i = 0;
        }
        int i7 = this.f19003i;
        int i8 = this.f19002h + i7;
        if (C0(i7) == '-') {
            i7++;
            i5 = Integer.MIN_VALUE;
            z5 = true;
        } else {
            i5 = -2147483647;
            z5 = false;
        }
        if (i7 < i8) {
            i6 = -(C0(i7) - '0');
            i7++;
        }
        while (i7 < i8) {
            int i9 = i7 + 1;
            char cC0 = C0(i7);
            if (cC0 == 'L' || cC0 == 'S' || cC0 == 'B') {
                i7 = i9;
                break;
            }
            int i10 = cC0 - '0';
            if (i6 < -214748364) {
                throw new NumberFormatException(w0());
            }
            int i11 = i6 * 10;
            if (i11 < i5 + i10) {
                throw new NumberFormatException(w0());
            }
            i6 = i11 - i10;
            i7 = i9;
        }
        if (!z5) {
            return -i6;
        }
        if (i7 > this.f19003i + 1) {
            return i6;
        }
        throw new NumberFormatException(w0());
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c6  */
    @Override // o0.InterfaceC0890c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w() {
        /*
            Method dump skipped, instructions count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.AbstractC0891d.w():void");
    }

    @Override // o0.InterfaceC0890c
    public abstract String w0();

    @Override // o0.InterfaceC0890c
    public final String x(C0897j c0897j) {
        if (this.f18995a == 1 && this.f18996b == 0 && this.f18999e == 1) {
            this.f18999e = 0;
        }
        boolean[] zArr = u0.g.f22756d;
        int i5 = this.f18998d;
        if (i5 < zArr.length && !zArr[i5]) {
            throw new l0.d("illegal identifier : " + this.f18998d + c());
        }
        boolean[] zArr2 = u0.g.f22757e;
        this.f19003i = this.f18999e;
        this.f19002h = 1;
        while (true) {
            char next = next();
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i5 = (i5 * 31) + next;
            this.f19002h++;
        }
        this.f18998d = C0(this.f18999e);
        this.f18995a = 18;
        if (this.f19002h == 4 && i5 == 3392903 && C0(this.f19003i) == 'n' && C0(this.f19003i + 1) == 'u' && C0(this.f19003i + 2) == 'l' && C0(this.f19003i + 3) == 'l') {
            return null;
        }
        return c0897j == null ? n1(this.f19003i, this.f19002h) : z0(this.f19003i, this.f19002h, i5, c0897j);
    }

    public abstract String z0(int i5, int i6, int i7, C0897j c0897j);
}
