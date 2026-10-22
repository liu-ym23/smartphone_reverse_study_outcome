package o0;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import l0.AbstractC0822a;
import u0.C1152b;

/* renamed from: o0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0893f extends AbstractC0891d {

    /* renamed from: t, reason: collision with root package name */
    private final String f19015t;

    /* renamed from: u, reason: collision with root package name */
    private final int f19016u;

    public C0893f(String str) {
        this(str, AbstractC0822a.f18021f);
    }

    static boolean p1(String str, int i5, char[] cArr) {
        int length = cArr.length;
        if (length + i5 > str.length()) {
            return false;
        }
        for (int i6 = 0; i6 < length; i6++) {
            if (cArr[i6] != str.charAt(i5 + i6)) {
                return false;
            }
        }
        return true;
    }

    static boolean q1(char c6, char c7, char c8, char c9, char c10, char c11, int i5, int i6) {
        if (c6 >= '0' && c6 <= '9' && c7 >= '0' && c7 <= '9' && c8 >= '0' && c8 <= '9' && c9 >= '0' && c9 <= '9') {
            if (c10 == '0') {
                if (c11 < '1' || c11 > '9') {
                    return false;
                }
            } else if (c10 != '1' || (c11 != '0' && c11 != '1' && c11 != '2')) {
                return false;
            }
            if (i5 == 48) {
                return i6 >= 49 && i6 <= 57;
            }
            if (i5 != 49 && i5 != 50) {
                return i5 == 51 && (i6 == 48 || i6 == 49);
            }
            if (i6 >= 48 && i6 <= 57) {
                return true;
            }
        }
        return false;
    }

    private boolean r1(char c6, char c7, char c8, char c9, char c10, char c11) {
        if (c6 == '0') {
            if (c7 < '0' || c7 > '9') {
                return false;
            }
        } else {
            if (c6 != '1') {
                if (c6 == '2' && c7 >= '0' && c7 <= '4') {
                }
                return false;
            }
            if (c7 < '0' || c7 > '9') {
                return false;
            }
        }
        if (c8 < '0' || c8 > '5') {
            if (c8 != '6' || c9 != '0') {
                return false;
            }
        } else if (c9 < '0' || c9 > '9') {
            return false;
        }
        return (c10 < '0' || c10 > '5') ? c10 == '6' && c11 == '0' : c11 >= '0' && c11 <= '9';
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean u1(boolean r42, int r43) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1889
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.C0893f.u1(boolean, int):boolean");
    }

    private void v1(char c6, char c7, char c8, char c9, char c10, char c11, char c12, char c13) {
        Calendar calendar = Calendar.getInstance(this.f19006l, this.f19007m);
        this.f19005k = calendar;
        calendar.set(1, ((c6 - '0') * 1000) + ((c7 - '0') * 100) + ((c8 - '0') * 10) + (c9 - '0'));
        this.f19005k.set(2, (((c10 - '0') * 10) + (c11 - '0')) - 1);
        this.f19005k.set(5, ((c12 - '0') * 10) + (c13 - '0'));
    }

    @Override // o0.AbstractC0891d
    protected final void A0(int i5, char[] cArr, int i6, int i7) {
        this.f19015t.getChars(i5, i7 + i5, cArr, i6);
    }

    @Override // o0.AbstractC0891d
    public final boolean B0(char[] cArr) {
        return p1(this.f19015t, this.f18999e, cArr);
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public final BigDecimal C() {
        char cC0 = C0((this.f19003i + this.f19002h) - 1);
        int i5 = this.f19002h;
        if (cC0 == 'L' || cC0 == 'S' || cC0 == 'B' || cC0 == 'F' || cC0 == 'D') {
            i5--;
        }
        if (i5 > 65535) {
            throw new l0.d("decimal overflow");
        }
        int i6 = this.f19003i;
        char[] cArr = this.f19001g;
        if (i5 < cArr.length) {
            this.f19015t.getChars(i6, i6 + i5, cArr, 0);
            return new BigDecimal(this.f19001g, 0, i5, MathContext.UNLIMITED);
        }
        char[] cArr2 = new char[i5];
        this.f19015t.getChars(i6, i6 + i5, cArr2, 0);
        return new BigDecimal(cArr2, 0, i5, MathContext.UNLIMITED);
    }

    @Override // o0.AbstractC0891d
    public final char C0(int i5) {
        if (i5 >= this.f19016u) {
            return (char) 26;
        }
        return this.f19015t.charAt(i5);
    }

    @Override // o0.AbstractC0891d
    protected final void D0(int i5, int i6, char[] cArr) {
        this.f19015t.getChars(i5, i6 + i5, cArr, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
    
        if (r13 != '.') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
    
        r16.f19008n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0082, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
    
        if (r7 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        if (r13 == '\"') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        r16.f19008n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0089, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        r13 = C0(r12);
        r12 = r3 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0091, code lost:
    
        if (r4 >= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0093, code lost:
    
        r16.f19008n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0095, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0098, code lost:
    
        if (r13 != r17) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009a, code lost:
    
        r16.f18999e = r12;
        r16.f18998d = C0(r12);
        r16.f19008n = 3;
        r16.f18995a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a7, code lost:
    
        if (r6 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00aa, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00af, code lost:
    
        if (o0.AbstractC0891d.I0(r13) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b1, code lost:
    
        r13 = C0(r12);
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b9, code lost:
    
        r16.f19008n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00bb, code lost:
    
        if (r6 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00be, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bf, code lost:
    
        return r4;
     */
    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int E(char r17) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.C0893f.E(char):int");
    }

    @Override // o0.InterfaceC0890c
    public byte[] G() {
        if (this.f18995a != 26) {
            return !this.f19004j ? u0.g.c(this.f19015t, this.f19003i + 1, this.f19002h) : u0.g.b(new String(this.f19001g, 0, this.f19002h));
        }
        int i5 = this.f19003i + 1;
        int i6 = this.f19002h;
        if (i6 % 2 != 0) {
            throw new l0.d("illegal state. " + i6);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = (i8 * 2) + i5;
            char cCharAt = this.f19015t.charAt(i9);
            char cCharAt2 = this.f19015t.charAt(i9 + 1);
            char c6 = '7';
            int i10 = cCharAt - (cCharAt <= '9' ? '0' : '7');
            if (cCharAt2 <= '9') {
                c6 = '0';
            }
            bArr[i8] = (byte) ((i10 << 4) | (cCharAt2 - c6));
        }
        return bArr;
    }

    @Override // o0.AbstractC0891d
    public final int G0(char c6, int i5) {
        return this.f19015t.indexOf(c6, i5);
    }

    @Override // o0.AbstractC0891d
    public boolean H0() {
        int i5 = this.f18999e;
        int i6 = this.f19016u;
        return i5 == i6 || (this.f18998d == 26 && i5 + 1 >= i6);
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public final String N() {
        return !this.f19004j ? n1(this.f19003i + 1, this.f19002h) : new String(this.f19001g, 0, this.f19002h);
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0104  */
    @Override // o0.AbstractC0891d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean S0(char[] r12) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.C0893f.S0(char[]):boolean");
    }

    @Override // o0.AbstractC0891d
    public Date T0(char[] cArr) {
        Date date;
        char cC0;
        long j5;
        Date date2;
        char cC02;
        boolean z5 = false;
        this.f19008n = 0;
        int i5 = this.f18999e;
        char c6 = this.f18998d;
        Date date3 = null;
        if (!p1(this.f19015t, i5, cArr)) {
            this.f19008n = -2;
            return null;
        }
        int length = this.f18999e + cArr.length;
        int i6 = length + 1;
        char cC03 = C0(length);
        boolean z6 = true;
        if (cC03 == '\"') {
            int iG0 = G0('\"', i6);
            if (iG0 == -1) {
                throw new l0.d("unclosed str");
            }
            this.f18999e = i6;
            if (!u1(false, iG0 - i6)) {
                this.f18999e = i5;
                this.f19008n = -1;
                return null;
            }
            date2 = this.f19005k.getTime();
            cC02 = C0(iG0 + 1);
            this.f18999e = i5;
            while (cC02 != ',' && cC02 != '}') {
                if (!AbstractC0891d.I0(cC02)) {
                    this.f19008n = -1;
                    return null;
                }
                int i7 = iG0 + 1;
                char cC04 = C0(iG0 + 2);
                iG0 = i7;
                cC02 = cC04;
            }
            this.f18999e = iG0 + 1;
            this.f18998d = cC02;
            date = null;
        } else {
            char c7 = '9';
            if (cC03 != '-' && (cC03 < '0' || cC03 > '9')) {
                this.f19008n = -1;
                return null;
            }
            if (cC03 == '-') {
                cC03 = C0(i6);
                i6 = length + 2;
                z5 = true;
            }
            if (cC03 < '0' || cC03 > '9') {
                date = null;
                cC0 = cC03;
                j5 = 0;
            } else {
                j5 = cC03 - '0';
                while (true) {
                    int i8 = i6 + 1;
                    date = date3;
                    cC0 = C0(i6);
                    if (cC0 < '0' || cC0 > c7) {
                        break;
                    }
                    j5 = (j5 * 10) + (cC0 - '0');
                    z6 = z6;
                    i6 = i8;
                    date3 = date;
                    c7 = '9';
                }
                if (cC0 == ',' || cC0 == '}') {
                    this.f18999e = i6;
                }
            }
            if (j5 < 0) {
                this.f19008n = -1;
                return date;
            }
            if (z5) {
                j5 = -j5;
            }
            date2 = new Date(j5);
            cC02 = cC0;
        }
        if (cC02 == ',') {
            int i9 = this.f18999e + 1;
            this.f18999e = i9;
            this.f18998d = C0(i9);
            this.f19008n = 3;
            this.f18995a = 16;
            return date2;
        }
        int i10 = this.f18999e + 1;
        this.f18999e = i10;
        char cC05 = C0(i10);
        if (cC05 == ',') {
            this.f18995a = 16;
            int i11 = this.f18999e + 1;
            this.f18999e = i11;
            this.f18998d = C0(i11);
        } else if (cC05 == ']') {
            this.f18995a = 15;
            int i12 = this.f18999e + 1;
            this.f18999e = i12;
            this.f18998d = C0(i12);
        } else if (cC05 == '}') {
            this.f18995a = 13;
            int i13 = this.f18999e + 1;
            this.f18999e = i13;
            this.f18998d = C0(i13);
        } else {
            if (cC05 != 26) {
                this.f18999e = i5;
                this.f18998d = c6;
                this.f19008n = -1;
                return date;
            }
            this.f18995a = 20;
        }
        this.f19008n = 4;
        return date2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
    
        if (r12 != '.') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        r14.f19008n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        if (r4 >= 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
    
        r14.f19008n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
    
        if (r7 == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
    
        if (r12 == '\"') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0071, code lost:
    
        r14.f19008n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0074, code lost:
    
        r15 = r15 + 2;
        r12 = C0(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007a, code lost:
    
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007f, code lost:
    
        if (r12 == ',') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
    
        if (r12 != '}') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0088, code lost:
    
        if (o0.AbstractC0891d.I0(r12) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008a, code lost:
    
        r15 = r11 + 1;
        r12 = C0(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0091, code lost:
    
        r14.f19008n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0094, code lost:
    
        r14.f18999e = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009a, code lost:
    
        if (r12 != ',') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009c, code lost:
    
        r14.f18999e = r11;
        r14.f18998d = C0(r11);
        r14.f19008n = 3;
        r14.f18995a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a9, code lost:
    
        if (r3 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ac, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ad, code lost:
    
        if (r12 != '}') goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00af, code lost:
    
        r14.f18999e = r11;
        r8 = C0(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b5, code lost:
    
        if (r8 != ',') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b7, code lost:
    
        r14.f18995a = 16;
        r15 = r14.f18999e + 1;
        r14.f18999e = r15;
        r14.f18998d = C0(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c7, code lost:
    
        if (r8 != ']') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c9, code lost:
    
        r14.f18995a = 15;
        r15 = r14.f18999e + 1;
        r14.f18999e = r15;
        r14.f18998d = C0(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d9, code lost:
    
        if (r8 != '}') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00db, code lost:
    
        r14.f18995a = 13;
        r15 = r14.f18999e + 1;
        r14.f18999e = r15;
        r14.f18998d = C0(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ed, code lost:
    
        if (r8 != 26) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ef, code lost:
    
        r14.f18995a = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f3, code lost:
    
        r14.f19008n = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00fb, code lost:
    
        if (o0.AbstractC0891d.I0(r8) == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00fd, code lost:
    
        r8 = r14.f18999e + 1;
        r14.f18999e = r8;
        r8 = C0(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0107, code lost:
    
        r14.f18999e = r1;
        r14.f18998d = r2;
        r14.f19008n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x010d, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x010e, code lost:
    
        if (r3 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0111, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0112, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x007a, code lost:
    
        r11 = r15;
     */
    @Override // o0.AbstractC0891d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int Z0(char[] r15) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.C0893f.Z0(char[]):int");
    }

    @Override // o0.AbstractC0891d
    public long b1(char[] cArr) {
        int i5;
        long j5;
        char cC0;
        boolean z5 = false;
        this.f19008n = 0;
        int i6 = this.f18999e;
        char c6 = this.f18998d;
        long j6 = 0;
        if (!p1(this.f19015t, i6, cArr)) {
            this.f19008n = -2;
            return 0L;
        }
        int length = this.f18999e + cArr.length;
        int i7 = length + 1;
        char cC02 = C0(length);
        boolean z6 = cC02 == '\"';
        if (z6) {
            cC02 = C0(i7);
            i7 = length + 2;
        }
        if (cC02 == '-') {
            cC02 = C0(i7);
            i7++;
            z5 = true;
        }
        if (cC02 < '0' || cC02 > '9') {
            this.f18999e = i6;
            this.f18998d = c6;
            this.f19008n = -1;
            return 0L;
        }
        long j7 = cC02 - '0';
        while (true) {
            i5 = i7 + 1;
            j5 = j6;
            cC0 = C0(i7);
            if (cC0 < '0' || cC0 > '9') {
                break;
            }
            j7 = (j7 * 10) + (cC0 - '0');
            i7 = i5;
            j6 = j5;
        }
        if (cC0 == '.') {
            this.f19008n = -1;
            return j5;
        }
        if (z6) {
            if (cC0 != '\"') {
                this.f19008n = -1;
                return j5;
            }
            cC0 = C0(i5);
            i5 = i7 + 2;
        }
        if (cC0 == ',' || cC0 == '}') {
            this.f18999e = i5 - 1;
        }
        if (j7 < j5 && (j7 != Long.MIN_VALUE || !z5)) {
            this.f18999e = i6;
            this.f18998d = c6;
            this.f19008n = -1;
            return j5;
        }
        while (true) {
            if (cC0 == ',') {
                int i8 = this.f18999e + 1;
                this.f18999e = i8;
                this.f18998d = C0(i8);
                this.f19008n = 3;
                this.f18995a = 16;
                if (z5) {
                    return -j7;
                }
            } else if (cC0 == '}') {
                int i9 = this.f18999e + 1;
                this.f18999e = i9;
                char cC03 = C0(i9);
                while (true) {
                    if (cC03 == ',') {
                        this.f18995a = 16;
                        int i10 = this.f18999e + 1;
                        this.f18999e = i10;
                        this.f18998d = C0(i10);
                        break;
                    }
                    if (cC03 == ']') {
                        this.f18995a = 15;
                        int i11 = this.f18999e + 1;
                        this.f18999e = i11;
                        this.f18998d = C0(i11);
                        break;
                    }
                    if (cC03 == '}') {
                        this.f18995a = 13;
                        int i12 = this.f18999e + 1;
                        this.f18999e = i12;
                        this.f18998d = C0(i12);
                        break;
                    }
                    if (cC03 == 26) {
                        this.f18995a = 20;
                        break;
                    }
                    if (!AbstractC0891d.I0(cC03)) {
                        this.f18999e = i6;
                        this.f18998d = c6;
                        this.f19008n = -1;
                        return j5;
                    }
                    int i13 = this.f18999e + 1;
                    this.f18999e = i13;
                    cC03 = C0(i13);
                }
                this.f19008n = 4;
                if (z5) {
                    return -j7;
                }
            } else {
                if (!AbstractC0891d.I0(cC0)) {
                    this.f19008n = -1;
                    return j5;
                }
                this.f18999e = i5;
                char cC04 = C0(i5);
                i5++;
                cC0 = cC04;
            }
        }
        return j7;
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public String c() {
        StringBuilder sb = new StringBuilder();
        int i5 = 1;
        int i6 = 1;
        int i7 = 0;
        while (i7 < this.f18999e) {
            if (this.f19015t.charAt(i7) == '\n') {
                i5++;
                i6 = 1;
            }
            i7++;
            i6++;
        }
        sb.append("pos ");
        sb.append(this.f18999e);
        sb.append(", line ");
        sb.append(i5);
        sb.append(", column ");
        sb.append(i6);
        if (this.f19015t.length() < 65535) {
            sb.append(this.f19015t);
        } else {
            sb.append(this.f19015t.substring(0, ExifInterface.COLOR_SPACE_UNCALIBRATED));
        }
        return sb.toString();
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public double c0(char c6) throws NumberFormatException {
        int i5;
        char cC0;
        boolean z5;
        boolean z6;
        long j5;
        long j6;
        int i6;
        int i7;
        int i8;
        double d6;
        int i9;
        char cC02;
        this.f19008n = 0;
        int i10 = this.f18999e;
        int i11 = i10 + 1;
        char cC03 = C0(i10);
        boolean z7 = cC03 == '\"';
        if (z7) {
            cC03 = C0(i11);
            i11 = i10 + 2;
        }
        boolean z8 = cC03 == '-';
        if (z8) {
            cC03 = C0(i11);
            i11++;
        }
        if (cC03 < '0' || cC03 > '9') {
            boolean z9 = z7;
            if (cC03 == 'n') {
                int i12 = i11 + 1;
                if (C0(i11) == 'u') {
                    int i13 = i11 + 2;
                    if (C0(i12) == 'l') {
                        int i14 = i11 + 3;
                        if (C0(i13) == 'l') {
                            this.f19008n = 5;
                            int i15 = i11 + 4;
                            char cC04 = C0(i14);
                            if (z9 && cC04 == '\"') {
                                cC04 = C0(i15);
                                i15 = i11 + 5;
                            }
                            while (cC04 != ',') {
                                if (cC04 == ']') {
                                    this.f18999e = i15;
                                    this.f18998d = C0(i15);
                                    this.f19008n = 5;
                                    this.f18995a = 15;
                                    return 0.0d;
                                }
                                if (!AbstractC0891d.I0(cC04)) {
                                    this.f19008n = -1;
                                    return 0.0d;
                                }
                                int i16 = i15 + 1;
                                char cC05 = C0(i15);
                                i15 = i16;
                                cC04 = cC05;
                            }
                            this.f18999e = i15;
                            this.f18998d = C0(i15);
                            this.f19008n = 5;
                            this.f18995a = 16;
                            return 0.0d;
                        }
                    }
                }
            }
            this.f19008n = -1;
            return 0.0d;
        }
        long j7 = cC03 - '0';
        while (true) {
            i5 = i11 + 1;
            cC0 = C0(i11);
            if (cC0 < '0' || cC0 > '9') {
                break;
            }
            j7 = (j7 * 10) + (cC0 - '0');
            i11 = i5;
        }
        if (cC0 == '.') {
            int i17 = i11 + 2;
            char cC06 = C0(i5);
            if (cC06 < '0' || cC06 > '9') {
                this.f19008n = -1;
                return 0.0d;
            }
            boolean z10 = true;
            long j8 = (j7 * 10) + (cC06 - '0');
            long j9 = 10;
            while (true) {
                i9 = i17 + 1;
                cC02 = C0(i17);
                if (cC02 < '0' || cC02 > '9') {
                    break;
                }
                j8 = (j8 * 10) + (cC02 - '0');
                j9 *= 10;
                i17 = i9;
                z10 = z10;
            }
            long j10 = j9;
            i5 = i9;
            cC0 = cC02;
            z5 = z10;
            z6 = z7;
            j5 = j8;
            j6 = j10;
        } else {
            z5 = true;
            z6 = z7;
            j5 = j7;
            j6 = 1;
        }
        boolean z11 = (cC0 == 'e' || cC0 == 'E') ? z5 : false;
        if (z11) {
            int i18 = i5 + 1;
            char cC07 = C0(i5);
            if (cC07 == '+' || cC07 == '-') {
                i5 += 2;
                cC0 = C0(i18);
            } else {
                i5 = i18;
                cC0 = cC07;
            }
            while (cC0 >= '0' && cC0 <= '9') {
                char cC08 = C0(i5);
                i5++;
                cC0 = cC08;
            }
        }
        if (!z6) {
            i6 = this.f18999e;
            int i19 = i5;
            i7 = (i5 - i6) - 1;
            i8 = i19;
        } else {
            if (cC0 != '\"') {
                this.f19008n = -1;
                return 0.0d;
            }
            int i20 = i5 + 1;
            char cC09 = C0(i5);
            i6 = this.f18999e + 1;
            i7 = (i20 - i6) - 2;
            i8 = i20;
            cC0 = cC09;
        }
        if (z11 || i7 >= 18) {
            d6 = Double.parseDouble(n1(i6, i7));
        } else {
            d6 = j5 / j6;
            if (z8) {
                d6 = -d6;
            }
        }
        if (cC0 != c6) {
            this.f19008n = -1;
            return d6;
        }
        this.f18999e = i8;
        this.f18998d = C0(i8);
        this.f19008n = 3;
        this.f18995a = 16;
        return d6;
    }

    @Override // o0.AbstractC0891d
    public String c1(char[] cArr) {
        this.f19008n = 0;
        int i5 = this.f18999e;
        char c6 = this.f18998d;
        while (!p1(this.f19015t, this.f18999e, cArr)) {
            if (!AbstractC0891d.I0(this.f18998d)) {
                this.f19008n = -2;
                return m1();
            }
            next();
            while (AbstractC0891d.I0(this.f18998d)) {
                next();
            }
        }
        int length = this.f18999e + cArr.length;
        int i6 = length + 1;
        char cC0 = C0(length);
        int i7 = 0;
        if (cC0 != '\"') {
            while (AbstractC0891d.I0(cC0)) {
                i7++;
                int i8 = i6 + 1;
                char cC02 = C0(i6);
                i6 = i8;
                cC0 = cC02;
            }
            if (cC0 != '\"') {
                this.f19008n = -1;
                return m1();
            }
        }
        int iG0 = G0('\"', i6);
        if (iG0 == -1) {
            throw new l0.d("unclosed str");
        }
        String strN1 = n1(i6, iG0 - i6);
        if (strN1.indexOf(92) != -1) {
            while (true) {
                int i9 = 0;
                for (int i10 = iG0 - 1; i10 >= 0 && C0(i10) == '\\'; i10--) {
                    i9++;
                }
                if (i9 % 2 == 0) {
                    break;
                }
                iG0 = G0('\"', iG0 + 1);
            }
            int i11 = this.f18999e;
            int length2 = iG0 - (((cArr.length + i11) + 1) + i7);
            strN1 = AbstractC0891d.O0(o1(i11 + cArr.length + 1 + i7, length2), length2);
        }
        if ((this.f18997c & EnumC0889b.TrimStringFieldValue.f18991a) != 0) {
            strN1 = strN1.trim();
        }
        char cC03 = C0(iG0 + 1);
        while (cC03 != ',' && cC03 != '}') {
            if (!AbstractC0891d.I0(cC03)) {
                this.f19008n = -1;
                return m1();
            }
            char cC04 = C0(iG0 + 2);
            iG0++;
            cC03 = cC04;
        }
        this.f18999e = iG0 + 1;
        this.f18998d = cC03;
        if (cC03 == ',') {
            int i12 = iG0 + 2;
            this.f18999e = i12;
            this.f18998d = C0(i12);
            this.f19008n = 3;
            return strN1;
        }
        int i13 = iG0 + 2;
        this.f18999e = i13;
        char cC05 = C0(i13);
        if (cC05 == ',') {
            this.f18995a = 16;
            int i14 = this.f18999e + 1;
            this.f18999e = i14;
            this.f18998d = C0(i14);
        } else if (cC05 == ']') {
            this.f18995a = 15;
            int i15 = this.f18999e + 1;
            this.f18999e = i15;
            this.f18998d = C0(i15);
        } else if (cC05 == '}') {
            this.f18995a = 13;
            int i16 = this.f18999e + 1;
            this.f18999e = i16;
            this.f18998d = C0(i16);
        } else {
            if (cC05 != 26) {
                this.f18999e = i5;
                this.f18998d = c6;
                this.f19008n = -1;
                return m1();
            }
            this.f18995a = 20;
        }
        this.f19008n = 4;
        return strN1;
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public long l0(char c6) {
        int i5;
        char cC0;
        this.f19008n = 0;
        int i6 = this.f18999e;
        int i7 = i6 + 1;
        char cC02 = C0(i6);
        boolean z5 = cC02 == '\"';
        if (z5) {
            cC02 = C0(i7);
            i7 = i6 + 2;
        }
        boolean z6 = cC02 == '-';
        if (z6) {
            cC02 = C0(i7);
            i7++;
        }
        if (cC02 >= '0' && cC02 <= '9') {
            long j5 = cC02 - '0';
            while (true) {
                i5 = i7 + 1;
                cC0 = C0(i7);
                if (cC0 < '0' || cC0 > '9') {
                    break;
                }
                j5 = (j5 * 10) + (cC0 - '0');
                i7 = i5;
            }
            if (cC0 == '.') {
                this.f19008n = -1;
                return 0L;
            }
            if (z5) {
                if (cC0 != '\"') {
                    this.f19008n = -1;
                    return 0L;
                }
                cC0 = C0(i5);
                i5 = i7 + 2;
            }
            if (j5 < 0 && (j5 != Long.MIN_VALUE || !z6)) {
                this.f19008n = -1;
                return 0L;
            }
            while (cC0 != c6) {
                if (!AbstractC0891d.I0(cC0)) {
                    this.f19008n = -1;
                    return j5;
                }
                cC0 = C0(i5);
                i5++;
            }
            this.f18999e = i5;
            this.f18998d = C0(i5);
            this.f19008n = 3;
            this.f18995a = 16;
            return z6 ? -j5 : j5;
        }
        if (cC02 == 'n') {
            int i8 = i7 + 1;
            if (C0(i7) == 'u') {
                int i9 = i7 + 2;
                if (C0(i8) == 'l') {
                    int i10 = i7 + 3;
                    if (C0(i9) == 'l') {
                        this.f19008n = 5;
                        int i11 = i7 + 4;
                        char cC03 = C0(i10);
                        if (z5 && cC03 == '\"') {
                            cC03 = C0(i11);
                            i11 = i7 + 5;
                        }
                        while (cC03 != ',') {
                            if (cC03 == ']') {
                                this.f18999e = i11;
                                this.f18998d = C0(i11);
                                this.f19008n = 5;
                                this.f18995a = 15;
                                return 0L;
                            }
                            if (!AbstractC0891d.I0(cC03)) {
                                this.f19008n = -1;
                                return 0L;
                            }
                            char cC04 = C0(i11);
                            i11++;
                            cC03 = cC04;
                        }
                        this.f18999e = i11;
                        this.f18998d = C0(i11);
                        this.f19008n = 5;
                        this.f18995a = 16;
                        return 0L;
                    }
                }
            }
        }
        this.f19008n = -1;
        return 0L;
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public String n0(C0897j c0897j) {
        int iIndexOf;
        if (!this.f19015t.startsWith("\"@type\":\"", this.f18999e) || (iIndexOf = this.f19015t.indexOf(34, this.f18999e + 9)) == -1) {
            return null;
        }
        int i5 = this.f18999e + 9;
        this.f18999e = i5;
        int iCharAt = 0;
        while (i5 < iIndexOf) {
            iCharAt = (iCharAt * 31) + this.f19015t.charAt(i5);
            i5++;
        }
        int i6 = this.f18999e;
        String strZ0 = z0(i6, iIndexOf - i6, iCharAt, c0897j);
        char cCharAt = this.f19015t.charAt(iIndexOf + 1);
        if (cCharAt != ',' && cCharAt != ']') {
            return null;
        }
        int i7 = iIndexOf + 2;
        this.f18999e = i7;
        this.f18998d = this.f19015t.charAt(i7);
        return strZ0;
    }

    @Override // o0.AbstractC0891d
    public final String n1(int i5, int i6) {
        if (!C1152b.f22729b) {
            return this.f19015t.substring(i5, i6 + i5);
        }
        char[] cArr = this.f19001g;
        if (i6 < cArr.length) {
            this.f19015t.getChars(i5, i5 + i6, cArr, 0);
            return new String(this.f19001g, 0, i6);
        }
        char[] cArr2 = new char[i6];
        this.f19015t.getChars(i5, i6 + i5, cArr2, 0);
        return new String(cArr2);
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public final char next() {
        int i5 = this.f18999e + 1;
        this.f18999e = i5;
        char cCharAt = i5 >= this.f19016u ? (char) 26 : this.f19015t.charAt(i5);
        this.f18998d = cCharAt;
        return cCharAt;
    }

    @Override // o0.AbstractC0891d
    public final char[] o1(int i5, int i6) {
        if (C1152b.f22729b) {
            char[] cArr = this.f19001g;
            if (i6 < cArr.length) {
                this.f19015t.getChars(i5, i6 + i5, cArr, 0);
                return this.f19001g;
            }
        }
        char[] cArr2 = new char[i6];
        this.f19015t.getChars(i5, i6 + i5, cArr2, 0);
        return cArr2;
    }

    public boolean s1() {
        return t1(true);
    }

    public boolean t1(boolean z5) {
        return u1(z5, this.f19016u - this.f18999e);
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public final String w0() {
        char cC0 = C0((this.f19003i + this.f19002h) - 1);
        int i5 = this.f19002h;
        if (cC0 == 'L' || cC0 == 'S' || cC0 == 'B' || cC0 == 'F' || cC0 == 'D') {
            i5--;
        }
        return n1(this.f19003i, i5);
    }

    protected void w1(char c6, char c7, char c8, char c9, char c10, char c11) {
        this.f19005k.set(11, ((c6 - '0') * 10) + (c7 - '0'));
        this.f19005k.set(12, ((c8 - '0') * 10) + (c9 - '0'));
        this.f19005k.set(13, ((c10 - '0') * 10) + (c11 - '0'));
    }

    protected void x1(char c6, char c7, char c8) {
        y1(c6, c7, c8, '0', '0');
    }

    protected void y1(char c6, char c7, char c8, char c9, char c10) {
        int i5 = ((((c7 - '0') * 10) + (c8 - '0')) * 3600000) + ((((c9 - '0') * 10) + (c10 - '0')) * 60000);
        if (c6 == '-') {
            i5 = -i5;
        }
        if (this.f19005k.getTimeZone().getRawOffset() != i5) {
            this.f19005k.setTimeZone(new SimpleTimeZone(i5, Integer.toString(i5)));
        }
    }

    @Override // o0.AbstractC0891d
    public final String z0(int i5, int i6, int i7, C0897j c0897j) {
        return c0897j.a(this.f19015t, i5, i6, i7);
    }

    public C0893f(String str, int i5) {
        super(i5);
        this.f19015t = str;
        this.f19016u = str.length();
        this.f18999e = -1;
        next();
        if (this.f18998d == 65279) {
            next();
        }
    }
}
