package x0;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import x0.InterfaceC1277a;

/* renamed from: x0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1281e implements InterfaceC1277a {

    /* renamed from: u, reason: collision with root package name */
    private static final String f23762u = "e";

    /* renamed from: a, reason: collision with root package name */
    private int[] f23763a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f23764b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC1277a.InterfaceC0257a f23765c;

    /* renamed from: d, reason: collision with root package name */
    private ByteBuffer f23766d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f23767e;

    /* renamed from: f, reason: collision with root package name */
    private short[] f23768f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f23769g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f23770h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f23771i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f23772j;

    /* renamed from: k, reason: collision with root package name */
    private int f23773k;

    /* renamed from: l, reason: collision with root package name */
    private C1279c f23774l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f23775m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f23776n;

    /* renamed from: o, reason: collision with root package name */
    private int f23777o;

    /* renamed from: p, reason: collision with root package name */
    private int f23778p;

    /* renamed from: q, reason: collision with root package name */
    private int f23779q;

    /* renamed from: r, reason: collision with root package name */
    private int f23780r;

    /* renamed from: s, reason: collision with root package name */
    private Boolean f23781s;

    /* renamed from: t, reason: collision with root package name */
    private Bitmap.Config f23782t;

    public C1281e(InterfaceC1277a.InterfaceC0257a interfaceC0257a, C1279c c1279c, ByteBuffer byteBuffer, int i5) {
        this(interfaceC0257a);
        r(c1279c, byteBuffer, i5);
    }

    private int j(int i5, int i6, int i7) {
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = i5; i13 < this.f23778p + i5; i13++) {
            byte[] bArr = this.f23771i;
            if (i13 >= bArr.length || i13 >= i6) {
                break;
            }
            int i14 = this.f23763a[bArr[i13] & 255];
            if (i14 != 0) {
                i8 += (i14 >> 24) & 255;
                i9 += (i14 >> 16) & 255;
                i10 += (i14 >> 8) & 255;
                i11 += i14 & 255;
                i12++;
            }
        }
        int i15 = i5 + i7;
        for (int i16 = i15; i16 < this.f23778p + i15; i16++) {
            byte[] bArr2 = this.f23771i;
            if (i16 >= bArr2.length || i16 >= i6) {
                break;
            }
            int i17 = this.f23763a[bArr2[i16] & 255];
            if (i17 != 0) {
                i8 += (i17 >> 24) & 255;
                i9 += (i17 >> 16) & 255;
                i10 += (i17 >> 8) & 255;
                i11 += i17 & 255;
                i12++;
            }
        }
        if (i12 == 0) {
            return 0;
        }
        return ((i8 / i12) << 24) | ((i9 / i12) << 16) | ((i10 / i12) << 8) | (i11 / i12);
    }

    private void k(C1278b c1278b) {
        int i5;
        int i6;
        int i7;
        int i8;
        int[] iArr = this.f23772j;
        int i9 = c1278b.f23737d;
        int i10 = this.f23778p;
        int i11 = i9 / i10;
        int i12 = c1278b.f23735b / i10;
        int i13 = c1278b.f23736c / i10;
        int i14 = c1278b.f23734a / i10;
        boolean z5 = this.f23773k == 0;
        int i15 = this.f23780r;
        int i16 = this.f23779q;
        byte[] bArr = this.f23771i;
        int[] iArr2 = this.f23763a;
        Boolean bool = this.f23781s;
        int i17 = 8;
        int i18 = 0;
        int i19 = 0;
        int i20 = 1;
        while (i19 < i11) {
            int[] iArr3 = iArr;
            if (c1278b.f23738e) {
                if (i18 >= i11) {
                    int i21 = i20 + 1;
                    i5 = i11;
                    if (i21 == 2) {
                        i20 = i21;
                        i18 = 4;
                    } else if (i21 == 3) {
                        i20 = i21;
                        i17 = 4;
                        i18 = 2;
                    } else if (i21 != 4) {
                        i20 = i21;
                    } else {
                        i20 = i21;
                        i18 = 1;
                        i17 = 2;
                    }
                } else {
                    i5 = i11;
                }
                i6 = i18 + i17;
            } else {
                i5 = i11;
                i6 = i18;
                i18 = i19;
            }
            int i22 = i18 + i12;
            boolean z6 = i10 == 1;
            if (i22 < i16) {
                int i23 = i22 * i15;
                int i24 = i23 + i14;
                int i25 = i24 + i13;
                int i26 = i23 + i15;
                if (i26 < i25) {
                    i25 = i26;
                }
                i7 = i6;
                int i27 = i19 * i10 * c1278b.f23736c;
                if (z6) {
                    int i28 = i24;
                    while (i28 < i25) {
                        int i29 = i28;
                        int i30 = iArr2[bArr[i27] & 255];
                        if (i30 != 0) {
                            iArr3[i29] = i30;
                        } else if (z5 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i27 += i10;
                        i28 = i29 + 1;
                    }
                } else {
                    int i31 = ((i25 - i24) * i10) + i27;
                    i8 = i10;
                    int i32 = i24;
                    while (i32 < i25) {
                        int i33 = i25;
                        int iJ = j(i27, i31, c1278b.f23736c);
                        if (iJ != 0) {
                            iArr3[i32] = iJ;
                        } else if (z5 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i27 += i8;
                        i32++;
                        i25 = i33;
                    }
                    i19++;
                    i10 = i8;
                    iArr = iArr3;
                    i11 = i5;
                    i18 = i7;
                }
            } else {
                i7 = i6;
            }
            i8 = i10;
            i19++;
            i10 = i8;
            iArr = iArr3;
            i11 = i5;
            i18 = i7;
        }
        if (this.f23781s == null) {
            this.f23781s = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    private void l(C1278b c1278b) {
        C1278b c1278b2 = c1278b;
        int[] iArr = this.f23772j;
        int i5 = c1278b2.f23737d;
        int i6 = c1278b2.f23735b;
        int i7 = c1278b2.f23736c;
        int i8 = c1278b2.f23734a;
        boolean z5 = this.f23773k == 0;
        int i9 = this.f23780r;
        byte[] bArr = this.f23771i;
        int[] iArr2 = this.f23763a;
        int i10 = 0;
        byte b6 = -1;
        while (i10 < i5) {
            int i11 = (i10 + i6) * i9;
            int i12 = i11 + i8;
            int i13 = i12 + i7;
            int i14 = i11 + i9;
            if (i14 < i13) {
                i13 = i14;
            }
            int i15 = c1278b2.f23736c * i10;
            int i16 = i12;
            while (i16 < i13) {
                byte b7 = bArr[i15];
                int[] iArr3 = iArr;
                int i17 = b7 & 255;
                if (i17 != b6) {
                    int i18 = iArr2[i17];
                    if (i18 != 0) {
                        iArr3[i16] = i18;
                    } else {
                        b6 = b7;
                    }
                }
                i15++;
                i16++;
                iArr = iArr3;
            }
            i10++;
            c1278b2 = c1278b;
        }
        this.f23781s = Boolean.valueOf(this.f23781s == null && z5 && b6 != -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v15, types: [short] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private void m(C1278b c1278b) {
        int i5;
        int i6;
        byte[] bArr;
        short s5;
        C1281e c1281e = this;
        if (c1278b != null) {
            c1281e.f23766d.position(c1278b.f23743j);
        }
        if (c1278b == null) {
            C1279c c1279c = c1281e.f23774l;
            i5 = c1279c.f23750f;
            i6 = c1279c.f23751g;
        } else {
            i5 = c1278b.f23736c;
            i6 = c1278b.f23737d;
        }
        int i7 = i5 * i6;
        byte[] bArr2 = c1281e.f23771i;
        if (bArr2 == null || bArr2.length < i7) {
            c1281e.f23771i = c1281e.f23765c.e(i7);
        }
        byte[] bArr3 = c1281e.f23771i;
        if (c1281e.f23768f == null) {
            c1281e.f23768f = new short[RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
        }
        short[] sArr = c1281e.f23768f;
        if (c1281e.f23769g == null) {
            c1281e.f23769g = new byte[RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
        }
        byte[] bArr4 = c1281e.f23769g;
        if (c1281e.f23770h == null) {
            c1281e.f23770h = new byte[4097];
        }
        byte[] bArr5 = c1281e.f23770h;
        int iQ = c1281e.q();
        int i8 = 1 << iQ;
        int i9 = i8 + 1;
        int i10 = i8 + 2;
        int i11 = iQ + 1;
        int i12 = (1 << i11) - 1;
        byte b6 = 0;
        for (int i13 = 0; i13 < i8; i13++) {
            sArr[i13] = 0;
            bArr4[i13] = (byte) i13;
        }
        byte[] bArr6 = c1281e.f23767e;
        int i14 = i11;
        int i15 = i10;
        int i16 = i12;
        int i17 = 0;
        int iP = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = -1;
        while (true) {
            if (i17 >= i7) {
                break;
            }
            if (iP == 0) {
                iP = c1281e.p();
                if (iP <= 0) {
                    c1281e.f23777o = 3;
                    break;
                }
                i18 = b6;
            }
            i20 += (bArr6[i18] & 255) << i19;
            i18++;
            iP--;
            int i25 = i19 + 8;
            int i26 = i15;
            int i27 = i14;
            int i28 = i24;
            short[] sArr2 = sArr;
            int i29 = i22;
            while (true) {
                bArr = bArr4;
                if (i25 < i27) {
                    i15 = i26;
                    i22 = i29;
                    break;
                }
                int i30 = i20 & i16;
                i20 >>= i27;
                i25 -= i27;
                if (i30 == i8) {
                    i27 = i11;
                    i26 = i10;
                    i16 = i12;
                    bArr4 = bArr;
                    i28 = -1;
                } else {
                    if (i30 == i9) {
                        i22 = i29;
                        i15 = i26;
                        break;
                    }
                    byte[] bArr7 = bArr5;
                    if (i28 == -1) {
                        bArr3[i21] = bArr[i30];
                        i21++;
                        i17++;
                        i28 = i30;
                        i29 = i28;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                    } else {
                        if (i30 >= i26) {
                            bArr7[i23] = (byte) i29;
                            i23++;
                            s5 = i28;
                        } else {
                            s5 = i30;
                        }
                        while (s5 >= i8) {
                            bArr7[i23] = bArr[s5];
                            i23++;
                            s5 = sArr2[s5];
                        }
                        int i31 = bArr[s5] & 255;
                        byte b7 = (byte) i31;
                        bArr3[i21] = b7;
                        while (true) {
                            i21++;
                            i17++;
                            if (i23 <= 0) {
                                break;
                            }
                            i23--;
                            bArr3[i21] = bArr7[i23];
                        }
                        if (i26 < 4096) {
                            sArr2[i26] = (short) i28;
                            bArr[i26] = b7;
                            i26++;
                            if ((i26 & i16) == 0 && i26 < 4096) {
                                i27++;
                                i16 += i26;
                            }
                        }
                        i28 = i30;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                        i29 = i31;
                    }
                }
            }
            i19 = i25;
            sArr = sArr2;
            bArr4 = bArr;
            b6 = 0;
            i24 = i28;
            i14 = i27;
            c1281e = this;
        }
        Arrays.fill(bArr3, i21, i7, b6);
    }

    private Bitmap o() {
        Boolean bool = this.f23781s;
        Bitmap bitmapA = this.f23765c.a(this.f23780r, this.f23779q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f23782t);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    private int p() {
        int iQ = q();
        if (iQ <= 0) {
            return iQ;
        }
        ByteBuffer byteBuffer = this.f23766d;
        byteBuffer.get(this.f23767e, 0, Math.min(iQ, byteBuffer.remaining()));
        return iQ;
    }

    private int q() {
        return this.f23766d.get() & 255;
    }

    private Bitmap s(C1278b c1278b, C1278b c1278b2) {
        int i5;
        int i6;
        Bitmap bitmap;
        int[] iArr = this.f23772j;
        int i7 = 0;
        if (c1278b2 == null) {
            Bitmap bitmap2 = this.f23775m;
            if (bitmap2 != null) {
                this.f23765c.c(bitmap2);
            }
            this.f23775m = null;
            Arrays.fill(iArr, 0);
        }
        if (c1278b2 != null && c1278b2.f23740g == 3 && this.f23775m == null) {
            Arrays.fill(iArr, 0);
        }
        if (c1278b2 != null && (i6 = c1278b2.f23740g) > 0) {
            if (i6 == 2) {
                if (!c1278b.f23739f) {
                    C1279c c1279c = this.f23774l;
                    int i8 = c1279c.f23756l;
                    if (c1278b.f23744k == null || c1279c.f23754j != c1278b.f23741h) {
                        i7 = i8;
                    }
                } else if (this.f23773k == 0) {
                    this.f23781s = Boolean.TRUE;
                }
                int i9 = c1278b2.f23737d;
                int i10 = this.f23778p;
                int i11 = i9 / i10;
                int i12 = c1278b2.f23735b / i10;
                int i13 = c1278b2.f23736c / i10;
                int i14 = c1278b2.f23734a / i10;
                int i15 = this.f23780r;
                int i16 = (i12 * i15) + i14;
                int i17 = (i11 * i15) + i16;
                while (i16 < i17) {
                    int i18 = i16 + i13;
                    for (int i19 = i16; i19 < i18; i19++) {
                        iArr[i19] = i7;
                    }
                    i16 += this.f23780r;
                }
            } else if (i6 == 3 && (bitmap = this.f23775m) != null) {
                int i20 = this.f23780r;
                bitmap.getPixels(iArr, 0, i20, 0, 0, i20, this.f23779q);
            }
        }
        m(c1278b);
        if (c1278b.f23738e || this.f23778p != 1) {
            k(c1278b);
        } else {
            l(c1278b);
        }
        if (this.f23776n && ((i5 = c1278b.f23740g) == 0 || i5 == 1)) {
            if (this.f23775m == null) {
                this.f23775m = o();
            }
            Bitmap bitmap3 = this.f23775m;
            int i21 = this.f23780r;
            bitmap3.setPixels(iArr, 0, i21, 0, 0, i21, this.f23779q);
        }
        Bitmap bitmapO = o();
        int i22 = this.f23780r;
        bitmapO.setPixels(iArr, 0, i22, 0, 0, i22, this.f23779q);
        return bitmapO;
    }

    @Override // x0.InterfaceC1277a
    public ByteBuffer a() {
        return this.f23766d;
    }

    @Override // x0.InterfaceC1277a
    public synchronized Bitmap b() {
        try {
            if (this.f23774l.f23747c <= 0 || this.f23773k < 0) {
                String str = f23762u;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, frameCount=" + this.f23774l.f23747c + ", framePointer=" + this.f23773k);
                }
                this.f23777o = 1;
            }
            int i5 = this.f23777o;
            if (i5 != 1 && i5 != 2) {
                this.f23777o = 0;
                if (this.f23767e == null) {
                    this.f23767e = this.f23765c.e(255);
                }
                C1278b c1278b = this.f23774l.f23749e.get(this.f23773k);
                int i6 = this.f23773k - 1;
                C1278b c1278b2 = i6 >= 0 ? this.f23774l.f23749e.get(i6) : null;
                int[] iArr = c1278b.f23744k;
                if (iArr == null) {
                    iArr = this.f23774l.f23745a;
                }
                this.f23763a = iArr;
                if (iArr != null) {
                    if (c1278b.f23739f) {
                        System.arraycopy(iArr, 0, this.f23764b, 0, iArr.length);
                        int[] iArr2 = this.f23764b;
                        this.f23763a = iArr2;
                        iArr2[c1278b.f23741h] = 0;
                    }
                    return s(c1278b, c1278b2);
                }
                String str2 = f23762u;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No valid color table found for frame #" + this.f23773k);
                }
                this.f23777o = 1;
                return null;
            }
            String str3 = f23762u;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, status=" + this.f23777o);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // x0.InterfaceC1277a
    public void c() {
        this.f23773k = (this.f23773k + 1) % this.f23774l.f23747c;
    }

    @Override // x0.InterfaceC1277a
    public void clear() {
        this.f23774l = null;
        byte[] bArr = this.f23771i;
        if (bArr != null) {
            this.f23765c.d(bArr);
        }
        int[] iArr = this.f23772j;
        if (iArr != null) {
            this.f23765c.f(iArr);
        }
        Bitmap bitmap = this.f23775m;
        if (bitmap != null) {
            this.f23765c.c(bitmap);
        }
        this.f23775m = null;
        this.f23766d = null;
        this.f23781s = null;
        byte[] bArr2 = this.f23767e;
        if (bArr2 != null) {
            this.f23765c.d(bArr2);
        }
    }

    @Override // x0.InterfaceC1277a
    public int d() {
        return this.f23774l.f23747c;
    }

    @Override // x0.InterfaceC1277a
    public int e() {
        int i5;
        if (this.f23774l.f23747c <= 0 || (i5 = this.f23773k) < 0) {
            return 0;
        }
        return n(i5);
    }

    @Override // x0.InterfaceC1277a
    public void f(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f23782t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    @Override // x0.InterfaceC1277a
    public void g() {
        this.f23773k = -1;
    }

    @Override // x0.InterfaceC1277a
    public int h() {
        return this.f23773k;
    }

    @Override // x0.InterfaceC1277a
    public int i() {
        return this.f23766d.limit() + this.f23771i.length + (this.f23772j.length * 4);
    }

    public int n(int i5) {
        if (i5 < 0) {
            return -1;
        }
        C1279c c1279c = this.f23774l;
        if (i5 < c1279c.f23747c) {
            return c1279c.f23749e.get(i5).f23742i;
        }
        return -1;
    }

    public synchronized void r(C1279c c1279c, ByteBuffer byteBuffer, int i5) {
        try {
            if (i5 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i5);
            }
            int iHighestOneBit = Integer.highestOneBit(i5);
            this.f23777o = 0;
            this.f23774l = c1279c;
            this.f23773k = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f23766d = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.f23766d.order(ByteOrder.LITTLE_ENDIAN);
            this.f23776n = false;
            Iterator<C1278b> it = c1279c.f23749e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f23740g == 3) {
                    this.f23776n = true;
                    break;
                }
            }
            this.f23778p = iHighestOneBit;
            int i6 = c1279c.f23750f;
            this.f23780r = i6 / iHighestOneBit;
            int i7 = c1279c.f23751g;
            this.f23779q = i7 / iHighestOneBit;
            this.f23771i = this.f23765c.e(i6 * i7);
            this.f23772j = this.f23765c.b(this.f23780r * this.f23779q);
        } catch (Throwable th) {
            throw th;
        }
    }

    public C1281e(InterfaceC1277a.InterfaceC0257a interfaceC0257a) {
        this.f23764b = new int[256];
        this.f23782t = Bitmap.Config.ARGB_8888;
        this.f23765c = interfaceC0257a;
        this.f23774l = new C1279c();
    }
}
