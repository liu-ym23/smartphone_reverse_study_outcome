package sd;

import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.common.util.TraceIdKeys;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.ByteString;
import okio.SegmentedByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e implements h, g, Cloneable, ByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public a0 f11925a;

    /* renamed from: b, reason: collision with root package name */
    public long f11926b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        public e f11927a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11928b;

        /* renamed from: c, reason: collision with root package name */
        public a0 f11929c;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f11931e;

        /* renamed from: d, reason: collision with root package name */
        public long f11930d = -1;
        public int h = -1;

        /* renamed from: j, reason: collision with root package name */
        public int f11932j = -1;

        public final void a(long j10) {
            e eVar = this.f11927a;
            if (eVar == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.f11928b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j11 = eVar.f11926b;
            if (j10 <= j11) {
                if (j10 < 0) {
                    throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "newSize < 0: ").toString());
                }
                long j12 = j11 - j10;
                while (true) {
                    if (j12 <= 0) {
                        break;
                    }
                    a0 a0Var = eVar.f11925a;
                    kotlin.jvm.internal.g.c(a0Var);
                    a0 a0Var2 = a0Var.f11907g;
                    kotlin.jvm.internal.g.c(a0Var2);
                    int i10 = a0Var2.f11903c;
                    long j13 = i10 - a0Var2.f11902b;
                    if (j13 > j12) {
                        a0Var2.f11903c = i10 - ((int) j12);
                        break;
                    } else {
                        eVar.f11925a = a0Var2.a();
                        b0.a(a0Var2);
                        j12 -= j13;
                    }
                }
                this.f11929c = null;
                this.f11930d = j10;
                this.f11931e = null;
                this.h = -1;
                this.f11932j = -1;
            } else if (j10 > j11) {
                long j14 = j10 - j11;
                int i11 = 1;
                boolean z = true;
                for (long j15 = 0; j14 > j15; j15 = 0) {
                    a0 a0VarM0 = eVar.M0(i11);
                    int iMin = (int) Math.min(j14, 8192 - a0VarM0.f11903c);
                    int i12 = a0VarM0.f11903c + iMin;
                    a0VarM0.f11903c = i12;
                    j14 -= iMin;
                    if (z) {
                        this.f11929c = a0VarM0;
                        this.f11930d = j11;
                        this.f11931e = a0VarM0.f11901a;
                        this.h = i12 - iMin;
                        this.f11932j = i12;
                        z = false;
                    }
                    i11 = 1;
                }
            }
            eVar.f11926b = j10;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f11927a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f11927a = null;
            this.f11929c = null;
            this.f11930d = -1L;
            this.f11931e = null;
            this.h = -1;
            this.f11932j = -1;
        }

        public final int o(long j10) {
            e eVar = this.f11927a;
            if (eVar == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (j10 >= -1) {
                long j11 = eVar.f11926b;
                if (j10 <= j11) {
                    if (j10 == -1 || j10 == j11) {
                        this.f11929c = null;
                        this.f11930d = j10;
                        this.f11931e = null;
                        this.h = -1;
                        this.f11932j = -1;
                        return -1;
                    }
                    a0 a0Var = eVar.f11925a;
                    a0 a0Var2 = this.f11929c;
                    long j12 = 0;
                    if (a0Var2 != null) {
                        long j13 = this.f11930d - (this.h - a0Var2.f11902b);
                        if (j13 > j10) {
                            a0Var2 = a0Var;
                            a0Var = a0Var2;
                            j11 = j13;
                        } else {
                            j12 = j13;
                        }
                    } else {
                        a0Var2 = a0Var;
                    }
                    if (j11 - j10 > j10 - j12) {
                        while (true) {
                            kotlin.jvm.internal.g.c(a0Var2);
                            long j14 = (a0Var2.f11903c - a0Var2.f11902b) + j12;
                            if (j10 < j14) {
                                break;
                            }
                            a0Var2 = a0Var2.f11906f;
                            j12 = j14;
                        }
                    } else {
                        while (j11 > j10) {
                            kotlin.jvm.internal.g.c(a0Var);
                            a0Var = a0Var.f11907g;
                            kotlin.jvm.internal.g.c(a0Var);
                            j11 -= a0Var.f11903c - a0Var.f11902b;
                        }
                        a0Var2 = a0Var;
                        j12 = j11;
                    }
                    if (this.f11928b) {
                        kotlin.jvm.internal.g.c(a0Var2);
                        if (a0Var2.f11904d) {
                            byte[] bArr = a0Var2.f11901a;
                            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                            kotlin.jvm.internal.g.e(bArrCopyOf, "copyOf(...)");
                            a0 a0Var3 = new a0(bArrCopyOf, a0Var2.f11902b, a0Var2.f11903c, false, true);
                            if (eVar.f11925a == a0Var2) {
                                eVar.f11925a = a0Var3;
                            }
                            a0Var2.b(a0Var3);
                            a0 a0Var4 = a0Var3.f11907g;
                            kotlin.jvm.internal.g.c(a0Var4);
                            a0Var4.a();
                            a0Var2 = a0Var3;
                        }
                    }
                    this.f11929c = a0Var2;
                    this.f11930d = j10;
                    kotlin.jvm.internal.g.c(a0Var2);
                    this.f11931e = a0Var2.f11901a;
                    int i10 = a0Var2.f11902b + ((int) (j10 - j12));
                    this.h = i10;
                    int i11 = a0Var2.f11903c;
                    this.f11932j = i11;
                    return i11 - i10;
                }
            }
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "offset=", " > size=");
            sbQ.append(eVar.f11926b);
            throw new ArrayIndexOutOfBoundsException(sbQ.toString());
        }
    }

    public final long C() {
        long j10 = this.f11926b;
        if (j10 == 0) {
            return 0L;
        }
        a0 a0Var = this.f11925a;
        kotlin.jvm.internal.g.c(a0Var);
        a0 a0Var2 = a0Var.f11907g;
        kotlin.jvm.internal.g.c(a0Var2);
        return (a0Var2.f11903c >= 8192 || !a0Var2.f11905e) ? j10 : j10 - (r2 - a0Var2.f11902b);
    }

    public final a C0(a unsafeCursor) {
        kotlin.jvm.internal.g.f(unsafeCursor, "unsafeCursor");
        byte[] bArr = td.a.f13073a;
        if (unsafeCursor == sd.a.f11899a) {
            unsafeCursor = new a();
        }
        if (unsafeCursor.f11927a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.f11927a = this;
        unsafeCursor.f11928b = true;
        return unsafeCursor;
    }

    @Override // sd.g
    public final /* bridge */ /* synthetic */ g D(String str) {
        U0(str);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a4 A[EDGE_INSN: B:44:0x00a4->B:38:0x00a4 BREAK  A[LOOP:0: B:5:0x000c->B:46:?], SYNTHETIC] */
    @Override // sd.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long E0() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.f11926b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lab
            r0 = 0
            r1 = r0
            r6 = r1
            r4 = r2
        Lc:
            sd.a0 r7 = r15.f11925a
            kotlin.jvm.internal.g.c(r7)
            byte[] r8 = r7.f11901a
            int r9 = r7.f11902b
            int r10 = r7.f11903c
        L17:
            if (r9 >= r10) goto L90
            r11 = r8[r9]
            r12 = 48
            if (r11 < r12) goto L26
            r12 = 57
            if (r11 > r12) goto L26
            int r12 = r11 + (-48)
            goto L3b
        L26:
            r12 = 97
            if (r11 < r12) goto L31
            r12 = 102(0x66, float:1.43E-43)
            if (r11 > r12) goto L31
            int r12 = r11 + (-87)
            goto L3b
        L31:
            r12 = 65
            if (r11 < r12) goto L66
            r12 = 70
            if (r11 > r12) goto L66
            int r12 = r11 + (-55)
        L3b:
            r13 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r13 = r13 & r4
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 != 0) goto L4b
            r11 = 4
            long r4 = r4 << r11
            long r11 = (long) r12
            long r4 = r4 | r11
            int r9 = r9 + 1
            int r1 = r1 + 1
            goto L17
        L4b:
            sd.e r15 = new sd.e
            r15.<init>()
            r15.Q0(r4)
            r15.O0(r11)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r15 = r15.J0()
            java.lang.String r1 = "Number too large: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        L66:
            r6 = 1
            if (r1 == 0) goto L6a
            goto L90
        L6a:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            sd.e$a r1 = sd.a.f11899a
            int r1 = r11 >> 4
            r1 = r1 & 15
            char[] r2 = td.b.f13074a
            char r1 = r2[r1]
            r3 = r11 & 15
            char r2 = r2[r3]
            r3 = 2
            char[] r3 = new char[r3]
            r3[r0] = r1
            r3[r6] = r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r0 = r1.concat(r0)
            r15.<init>(r0)
            throw r15
        L90:
            if (r9 != r10) goto L9c
            sd.a0 r8 = r7.a()
            r15.f11925a = r8
            sd.b0.a(r7)
            goto L9e
        L9c:
            r7.f11902b = r9
        L9e:
            if (r6 != 0) goto La4
            sd.a0 r7 = r15.f11925a
            if (r7 != 0) goto Lc
        La4:
            long r2 = r15.f11926b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f11926b = r2
            return r4
        Lab:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: sd.e.E0():long");
    }

    @Override // sd.h
    public final InputStream F0() {
        return new b();
    }

    public final byte[] G0(long j10) throws EOFException {
        if (j10 < 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount: ").toString());
        }
        if (this.f11926b < j10) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j10];
        readFully(bArr);
        return bArr;
    }

    public final short H0() throws EOFException {
        short s8 = readShort();
        a aVar = sd.a.f11899a;
        return (short) (((s8 & 255) << 8) | ((65280 & s8) >>> 8));
    }

    @Override // sd.h
    public final void I(e sink, long j10) throws EOFException {
        kotlin.jvm.internal.g.f(sink, "sink");
        long j11 = this.f11926b;
        if (j11 >= j10) {
            sink.j0(this, j10);
        } else {
            sink.j0(this, j11);
            throw new EOFException();
        }
    }

    public final String I0(long j10, Charset charset) throws EOFException {
        kotlin.jvm.internal.g.f(charset, "charset");
        if (j10 < 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount: ").toString());
        }
        if (this.f11926b < j10) {
            throw new EOFException();
        }
        if (j10 == 0) {
            return "";
        }
        a0 a0Var = this.f11925a;
        kotlin.jvm.internal.g.c(a0Var);
        int i10 = a0Var.f11902b;
        if (i10 + j10 > a0Var.f11903c) {
            return new String(G0(j10), charset);
        }
        int i11 = (int) j10;
        String str = new String(a0Var.f11901a, i10, i11, charset);
        int i12 = a0Var.f11902b + i11;
        a0Var.f11902b = i12;
        this.f11926b -= j10;
        if (i12 == a0Var.f11903c) {
            this.f11925a = a0Var.a();
            b0.a(a0Var);
        }
        return str;
    }

    public final String J0() {
        return I0(this.f11926b, gc.a.f9106b);
    }

    public final int K0() {
        int i10;
        int i11;
        int i12;
        if (this.f11926b == 0) {
            throw new EOFException();
        }
        byte bS = S(0L);
        if ((bS & 128) == 0) {
            i10 = bS & 127;
            i12 = 0;
            i11 = 1;
        } else if ((bS & 224) == 192) {
            i10 = bS & 31;
            i11 = 2;
            i12 = 128;
        } else if ((bS & 240) == 224) {
            i10 = bS & 15;
            i11 = 3;
            i12 = 2048;
        } else {
            if ((bS & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i10 = bS & 7;
            i11 = 4;
            i12 = 65536;
        }
        long j10 = i11;
        if (this.f11926b < j10) {
            StringBuilder sbK = com.stepos.core.ota.d.k(i11, "size < ", ": ");
            sbK.append(this.f11926b);
            sbK.append(" (to read code point prefixed 0x");
            char[] cArr = td.b.f13074a;
            sbK.append(new String(new char[]{cArr[(bS >> 4) & 15], cArr[bS & 15]}));
            sbK.append(')');
            throw new EOFException(sbK.toString());
        }
        for (int i13 = 1; i13 < i11; i13++) {
            long j11 = i13;
            byte bS2 = S(j11);
            if ((bS2 & 192) != 128) {
                skip(j11);
                return 65533;
            }
            i10 = (i10 << 6) | (bS2 & 63);
        }
        skip(j10);
        if (i10 <= 1114111 && ((55296 > i10 || i10 >= 57344) && i10 >= i12)) {
            return i10;
        }
        return 65533;
    }

    public final ByteString L0(int i10) {
        if (i10 == 0) {
            return ByteString.f11312d;
        }
        sd.a.b(this.f11926b, 0L, i10);
        a0 a0Var = this.f11925a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            kotlin.jvm.internal.g.c(a0Var);
            int i14 = a0Var.f11903c;
            int i15 = a0Var.f11902b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            a0Var = a0Var.f11906f;
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[i13 * 2];
        a0 a0Var2 = this.f11925a;
        int i16 = 0;
        while (i11 < i10) {
            kotlin.jvm.internal.g.c(a0Var2);
            bArr[i16] = a0Var2.f11901a;
            i11 += a0Var2.f11903c - a0Var2.f11902b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = a0Var2.f11902b;
            a0Var2.f11904d = true;
            i16++;
            a0Var2 = a0Var2.f11906f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // sd.h
    public final boolean M(long j10) {
        return this.f11926b >= Long.MAX_VALUE;
    }

    public final a0 M0(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        a0 a0Var = this.f11925a;
        if (a0Var == null) {
            a0 a0VarB = b0.b();
            this.f11925a = a0VarB;
            a0VarB.f11907g = a0VarB;
            a0VarB.f11906f = a0VarB;
            return a0VarB;
        }
        a0 a0Var2 = a0Var.f11907g;
        kotlin.jvm.internal.g.c(a0Var2);
        if (a0Var2.f11903c + i10 <= 8192 && a0Var2.f11905e) {
            return a0Var2;
        }
        a0 a0VarB2 = b0.b();
        a0Var2.b(a0VarB2);
        return a0VarB2;
    }

    @Override // sd.h
    public final String N() {
        return x(Long.MAX_VALUE);
    }

    public final void N0(ByteString byteString) {
        kotlin.jvm.internal.g.f(byteString, "byteString");
        byteString.s(this, byteString.d());
    }

    public final void O0(int i10) {
        a0 a0VarM0 = M0(1);
        byte[] bArr = a0VarM0.f11901a;
        int i11 = a0VarM0.f11903c;
        a0VarM0.f11903c = i11 + 1;
        bArr[i11] = (byte) i10;
        this.f11926b++;
    }

    public final void P(e out, long j10, long j11) {
        kotlin.jvm.internal.g.f(out, "out");
        long j12 = j10;
        sd.a.b(this.f11926b, j12, j11);
        if (j11 == 0) {
            return;
        }
        out.f11926b += j11;
        a0 a0Var = this.f11925a;
        while (true) {
            kotlin.jvm.internal.g.c(a0Var);
            long j13 = a0Var.f11903c - a0Var.f11902b;
            if (j12 < j13) {
                break;
            }
            j12 -= j13;
            a0Var = a0Var.f11906f;
        }
        long j14 = j11;
        while (j14 > 0) {
            kotlin.jvm.internal.g.c(a0Var);
            a0 a0VarC = a0Var.c();
            int i10 = a0VarC.f11902b + ((int) j12);
            a0VarC.f11902b = i10;
            a0VarC.f11903c = Math.min(i10 + ((int) j14), a0VarC.f11903c);
            a0 a0Var2 = out.f11925a;
            if (a0Var2 == null) {
                a0VarC.f11907g = a0VarC;
                a0VarC.f11906f = a0VarC;
                out.f11925a = a0VarC;
            } else {
                a0 a0Var3 = a0Var2.f11907g;
                kotlin.jvm.internal.g.c(a0Var3);
                a0Var3.b(a0VarC);
            }
            j14 -= a0VarC.f11903c - a0VarC.f11902b;
            a0Var = a0Var.f11906f;
            j12 = 0;
        }
    }

    public final void P0(long j10) {
        boolean z;
        if (j10 == 0) {
            O0(48);
            return;
        }
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                U0("-9223372036854775808");
                return;
            }
            z = true;
        } else {
            z = false;
        }
        if (j10 >= 100000000) {
            i10 = j10 < 1000000000000L ? j10 < 10000000000L ? j10 < 1000000000 ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS) {
            i10 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z) {
            i10++;
        }
        a0 a0VarM0 = M0(i10);
        byte[] bArr = a0VarM0.f11901a;
        int i11 = a0VarM0.f11903c + i10;
        while (j10 != 0) {
            long j11 = 10;
            i11--;
            bArr[i11] = td.a.f13073a[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z) {
            bArr[i11 - 1] = 45;
        }
        a0VarM0.f11903c += i10;
        this.f11926b += i10;
    }

    public final void Q0(long j10) {
        if (j10 == 0) {
            O0(48);
            return;
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + 3) / 4);
        a0 a0VarM0 = M0(i10);
        byte[] bArr = a0VarM0.f11901a;
        int i11 = a0VarM0.f11903c;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = td.a.f13073a[(int) (15 & j10)];
            j10 >>>= 4;
        }
        a0VarM0.f11903c += i10;
        this.f11926b += i10;
    }

    @Override // sd.h
    public final int R(w options) throws EOFException {
        kotlin.jvm.internal.g.f(options, "options");
        int iB = td.a.b(this, options, false);
        if (iB == -1) {
            return -1;
        }
        skip(options.f11979a[iB].d());
        return iB;
    }

    public final void R0(int i10) {
        a0 a0VarM0 = M0(4);
        byte[] bArr = a0VarM0.f11901a;
        int i11 = a0VarM0.f11903c;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        a0VarM0.f11903c = i11 + 4;
        this.f11926b += 4;
    }

    public final byte S(long j10) {
        sd.a.b(this.f11926b, j10, 1L);
        a0 a0Var = this.f11925a;
        if (a0Var == null) {
            kotlin.jvm.internal.g.c(null);
            throw null;
        }
        long j11 = this.f11926b;
        if (j11 - j10 < j10) {
            while (j11 > j10) {
                a0Var = a0Var.f11907g;
                kotlin.jvm.internal.g.c(a0Var);
                j11 -= a0Var.f11903c - a0Var.f11902b;
            }
            return a0Var.f11901a[(int) ((a0Var.f11902b + j10) - j11)];
        }
        long j12 = 0;
        while (true) {
            int i10 = a0Var.f11903c;
            int i11 = a0Var.f11902b;
            long j13 = (i10 - i11) + j12;
            if (j13 > j10) {
                return a0Var.f11901a[(int) ((i11 + j10) - j12)];
            }
            a0Var = a0Var.f11906f;
            kotlin.jvm.internal.g.c(a0Var);
            j12 = j13;
        }
    }

    public final void S0(int i10) {
        a0 a0VarM0 = M0(2);
        byte[] bArr = a0VarM0.f11901a;
        int i11 = a0VarM0.f11903c;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 1] = (byte) (i10 & 255);
        a0VarM0.f11903c = i11 + 2;
        this.f11926b += 2;
    }

    @Override // sd.h
    public final void T(long j10) throws EOFException {
        if (this.f11926b < j10) {
            throw new EOFException();
        }
    }

    public final void T0(int i10, int i11, String string) {
        char cCharAt;
        kotlin.jvm.internal.g.f(string, "string");
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "beginIndex < 0: ").toString());
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(a0.a.f("endIndex < beginIndex: ", i11, i10, " < ").toString());
        }
        if (i11 > string.length()) {
            StringBuilder sbK = com.stepos.core.ota.d.k(i11, "endIndex > string.length: ", " > ");
            sbK.append(string.length());
            throw new IllegalArgumentException(sbK.toString().toString());
        }
        while (i10 < i11) {
            char cCharAt2 = string.charAt(i10);
            if (cCharAt2 < 128) {
                a0 a0VarM0 = M0(1);
                byte[] bArr = a0VarM0.f11901a;
                int i12 = a0VarM0.f11903c - i10;
                int iMin = Math.min(i11, 8192 - i12);
                int i13 = i10 + 1;
                bArr[i10 + i12] = (byte) cCharAt2;
                while (true) {
                    i10 = i13;
                    if (i10 >= iMin || (cCharAt = string.charAt(i10)) >= 128) {
                        break;
                    }
                    i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) cCharAt;
                }
                int i14 = a0VarM0.f11903c;
                int i15 = (i12 + i10) - i14;
                a0VarM0.f11903c = i14 + i15;
                this.f11926b += i15;
            } else {
                if (cCharAt2 < 2048) {
                    a0 a0VarM02 = M0(2);
                    byte[] bArr2 = a0VarM02.f11901a;
                    int i16 = a0VarM02.f11903c;
                    bArr2[i16] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i16 + 1] = (byte) ((cCharAt2 & '?') | TraceIdKeys.MAX_LENGTH);
                    a0VarM02.f11903c = i16 + 2;
                    this.f11926b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    a0 a0VarM03 = M0(3);
                    byte[] bArr3 = a0VarM03.f11901a;
                    int i17 = a0VarM03.f11903c;
                    bArr3[i17] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i17 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | TraceIdKeys.MAX_LENGTH);
                    bArr3[i17 + 2] = (byte) ((cCharAt2 & '?') | TraceIdKeys.MAX_LENGTH);
                    a0VarM03.f11903c = i17 + 3;
                    this.f11926b += 3;
                } else {
                    int i18 = i10 + 1;
                    char cCharAt3 = i18 < i11 ? string.charAt(i18) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        O0(63);
                        i10 = i18;
                    } else {
                        int i19 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        a0 a0VarM04 = M0(4);
                        byte[] bArr4 = a0VarM04.f11901a;
                        int i20 = a0VarM04.f11903c;
                        bArr4[i20] = (byte) ((i19 >> 18) | 240);
                        bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | TraceIdKeys.MAX_LENGTH);
                        bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | TraceIdKeys.MAX_LENGTH);
                        bArr4[i20 + 3] = (byte) ((i19 & 63) | TraceIdKeys.MAX_LENGTH);
                        a0VarM04.f11903c = i20 + 4;
                        this.f11926b += 4;
                        i10 += 2;
                    }
                }
                i10++;
            }
        }
    }

    public final void U0(String string) {
        kotlin.jvm.internal.g.f(string, "string");
        T0(0, string.length(), string);
    }

    public final void V0(int i10) {
        if (i10 < 128) {
            O0(i10);
            return;
        }
        if (i10 < 2048) {
            a0 a0VarM0 = M0(2);
            byte[] bArr = a0VarM0.f11901a;
            int i11 = a0VarM0.f11903c;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | TraceIdKeys.MAX_LENGTH);
            a0VarM0.f11903c = i11 + 2;
            this.f11926b += 2;
            return;
        }
        if (55296 <= i10 && i10 < 57344) {
            O0(63);
            return;
        }
        if (i10 < 65536) {
            a0 a0VarM02 = M0(3);
            byte[] bArr2 = a0VarM02.f11901a;
            int i12 = a0VarM02.f11903c;
            bArr2[i12] = (byte) ((i10 >> 12) | 224);
            bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | TraceIdKeys.MAX_LENGTH);
            bArr2[i12 + 2] = (byte) ((i10 & 63) | TraceIdKeys.MAX_LENGTH);
            a0VarM02.f11903c = i12 + 3;
            this.f11926b += 3;
            return;
        }
        if (i10 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x".concat(sd.a.e(i10)));
        }
        a0 a0VarM03 = M0(4);
        byte[] bArr3 = a0VarM03.f11901a;
        int i13 = a0VarM03.f11903c;
        bArr3[i13] = (byte) ((i10 >> 18) | 240);
        bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | TraceIdKeys.MAX_LENGTH);
        bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | TraceIdKeys.MAX_LENGTH);
        bArr3[i13 + 3] = (byte) ((i10 & 63) | TraceIdKeys.MAX_LENGTH);
        a0VarM03.f11903c = i13 + 4;
        this.f11926b += 4;
    }

    @Override // sd.h
    public final ByteString X(long j10) throws EOFException {
        if (j10 < 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount: ").toString());
        }
        if (this.f11926b < j10) {
            throw new EOFException();
        }
        if (j10 < 4096) {
            return new ByteString(G0(j10));
        }
        ByteString byteStringL0 = L0((int) j10);
        skip(j10);
        return byteStringL0;
    }

    public final long c0(byte b10, long j10, long j11) {
        a0 a0Var;
        long j12 = 0;
        if (0 > j10 || j10 > j11) {
            StringBuilder sb2 = new StringBuilder("size=");
            sb2.append(this.f11926b);
            a0.a.s(j10, " fromIndex=", " toIndex=", sb2);
            sb2.append(j11);
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        long j13 = this.f11926b;
        if (j11 > j13) {
            j11 = j13;
        }
        if (j10 == j11 || (a0Var = this.f11925a) == null) {
            return -1L;
        }
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                a0Var = a0Var.f11907g;
                kotlin.jvm.internal.g.c(a0Var);
                j13 -= a0Var.f11903c - a0Var.f11902b;
            }
            while (j13 < j11) {
                byte[] bArr = a0Var.f11901a;
                int iMin = (int) Math.min(a0Var.f11903c, (a0Var.f11902b + j11) - j13);
                for (int i10 = (int) ((a0Var.f11902b + j10) - j13); i10 < iMin; i10++) {
                    if (bArr[i10] == b10) {
                        return (i10 - a0Var.f11902b) + j13;
                    }
                }
                j13 += a0Var.f11903c - a0Var.f11902b;
                a0Var = a0Var.f11906f;
                kotlin.jvm.internal.g.c(a0Var);
                j10 = j13;
            }
            return -1L;
        }
        while (true) {
            long j14 = (a0Var.f11903c - a0Var.f11902b) + j12;
            if (j14 > j10) {
                break;
            }
            a0Var = a0Var.f11906f;
            kotlin.jvm.internal.g.c(a0Var);
            j12 = j14;
        }
        while (j12 < j11) {
            byte[] bArr2 = a0Var.f11901a;
            int iMin2 = (int) Math.min(a0Var.f11903c, (a0Var.f11902b + j11) - j12);
            for (int i11 = (int) ((a0Var.f11902b + j10) - j12); i11 < iMin2; i11++) {
                if (bArr2[i11] == b10) {
                    return (i11 - a0Var.f11902b) + j12;
                }
            }
            j12 += a0Var.f11903c - a0Var.f11902b;
            a0Var = a0Var.f11906f;
            kotlin.jvm.internal.g.c(a0Var);
            j10 = j12;
        }
        return -1L;
    }

    @Override // sd.h
    public final long d0(e eVar) {
        long j10 = this.f11926b;
        if (j10 > 0) {
            eVar.j0(this, j10);
        }
        return j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        long j10 = this.f11926b;
        e eVar = (e) obj;
        if (j10 != eVar.f11926b) {
            return false;
        }
        if (j10 == 0) {
            return true;
        }
        a0 a0Var = this.f11925a;
        kotlin.jvm.internal.g.c(a0Var);
        a0 a0Var2 = eVar.f11925a;
        kotlin.jvm.internal.g.c(a0Var2);
        int i10 = a0Var.f11902b;
        int i11 = a0Var2.f11902b;
        long j11 = 0;
        while (j11 < this.f11926b) {
            long jMin = Math.min(a0Var.f11903c - i10, a0Var2.f11903c - i11);
            long j12 = 0;
            while (j12 < jMin) {
                int i12 = i10 + 1;
                int i13 = i11 + 1;
                if (a0Var.f11901a[i10] != a0Var2.f11901a[i11]) {
                    return false;
                }
                j12++;
                i10 = i12;
                i11 = i13;
            }
            if (i10 == a0Var.f11903c) {
                a0Var = a0Var.f11906f;
                kotlin.jvm.internal.g.c(a0Var);
                i10 = a0Var.f11902b;
            }
            if (i11 == a0Var2.f11903c) {
                a0Var2 = a0Var2.f11906f;
                kotlin.jvm.internal.g.c(a0Var2);
                i11 = a0Var2.f11902b;
            }
            j11 += jMin;
        }
        return true;
    }

    @Override // sd.h
    public final boolean f0() {
        return this.f11926b == 0;
    }

    public final long g0(ByteString targetBytes) {
        int i10;
        int i11;
        kotlin.jvm.internal.g.f(targetBytes, "targetBytes");
        a0 a0Var = this.f11925a;
        if (a0Var == null) {
            return -1L;
        }
        long j10 = this.f11926b;
        long j11 = 0;
        if (j10 < 0) {
            while (j10 > 0) {
                a0Var = a0Var.f11907g;
                kotlin.jvm.internal.g.c(a0Var);
                j10 -= a0Var.f11903c - a0Var.f11902b;
            }
            if (targetBytes.d() == 2) {
                byte bJ = targetBytes.j(0);
                byte bJ2 = targetBytes.j(1);
                while (j10 < this.f11926b) {
                    byte[] bArr = a0Var.f11901a;
                    i10 = (int) ((a0Var.f11902b + j11) - j10);
                    int i12 = a0Var.f11903c;
                    while (i10 < i12) {
                        byte b10 = bArr[i10];
                        if (b10 == bJ || b10 == bJ2) {
                            i11 = a0Var.f11902b;
                        } else {
                            i10++;
                        }
                    }
                    j11 = (a0Var.f11903c - a0Var.f11902b) + j10;
                    a0Var = a0Var.f11906f;
                    kotlin.jvm.internal.g.c(a0Var);
                    j10 = j11;
                }
                return -1L;
            }
            byte[] bArrI = targetBytes.i();
            while (j10 < this.f11926b) {
                byte[] bArr2 = a0Var.f11901a;
                i10 = (int) ((a0Var.f11902b + j11) - j10);
                int i13 = a0Var.f11903c;
                while (i10 < i13) {
                    byte b11 = bArr2[i10];
                    for (byte b12 : bArrI) {
                        if (b11 == b12) {
                            i11 = a0Var.f11902b;
                        }
                    }
                    i10++;
                }
                j11 = (a0Var.f11903c - a0Var.f11902b) + j10;
                a0Var = a0Var.f11906f;
                kotlin.jvm.internal.g.c(a0Var);
                j10 = j11;
            }
            return -1L;
        }
        j10 = 0;
        while (true) {
            long j12 = (a0Var.f11903c - a0Var.f11902b) + j10;
            if (j12 > 0) {
                break;
            }
            a0Var = a0Var.f11906f;
            kotlin.jvm.internal.g.c(a0Var);
            j10 = j12;
        }
        if (targetBytes.d() == 2) {
            byte bJ3 = targetBytes.j(0);
            byte bJ4 = targetBytes.j(1);
            while (j10 < this.f11926b) {
                byte[] bArr3 = a0Var.f11901a;
                i10 = (int) ((a0Var.f11902b + j11) - j10);
                int i14 = a0Var.f11903c;
                while (i10 < i14) {
                    byte b13 = bArr3[i10];
                    if (b13 == bJ3 || b13 == bJ4) {
                        i11 = a0Var.f11902b;
                    } else {
                        i10++;
                    }
                }
                j11 = (a0Var.f11903c - a0Var.f11902b) + j10;
                a0Var = a0Var.f11906f;
                kotlin.jvm.internal.g.c(a0Var);
                j10 = j11;
            }
            return -1L;
        }
        byte[] bArrI2 = targetBytes.i();
        while (j10 < this.f11926b) {
            byte[] bArr4 = a0Var.f11901a;
            i10 = (int) ((a0Var.f11902b + j11) - j10);
            int i15 = a0Var.f11903c;
            while (i10 < i15) {
                byte b14 = bArr4[i10];
                for (byte b15 : bArrI2) {
                    if (b14 == b15) {
                        i11 = a0Var.f11902b;
                    }
                }
                i10++;
            }
            j11 = (a0Var.f11903c - a0Var.f11902b) + j10;
            a0Var = a0Var.f11906f;
            kotlin.jvm.internal.g.c(a0Var);
            j10 = j11;
        }
        return -1L;
        return (i10 - i11) + j10;
    }

    public final int hashCode() {
        a0 a0Var = this.f11925a;
        if (a0Var == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = a0Var.f11903c;
            for (int i12 = a0Var.f11902b; i12 < i11; i12++) {
                i10 = (i10 * 31) + a0Var.f11901a[i12];
            }
            a0Var = a0Var.f11906f;
            kotlin.jvm.internal.g.c(a0Var);
        } while (a0Var != this.f11925a);
        return i10;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // sd.c0
    public final void j0(e source, long j10) {
        a0 a0VarB;
        kotlin.jvm.internal.g.f(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        sd.a.b(source.f11926b, 0L, j10);
        while (j10 > 0) {
            a0 a0Var = source.f11925a;
            kotlin.jvm.internal.g.c(a0Var);
            int i10 = a0Var.f11903c;
            a0 a0Var2 = source.f11925a;
            kotlin.jvm.internal.g.c(a0Var2);
            long j11 = i10 - a0Var2.f11902b;
            int i11 = 0;
            if (j10 < j11) {
                a0 a0Var3 = this.f11925a;
                a0 a0Var4 = a0Var3 != null ? a0Var3.f11907g : null;
                if (a0Var4 != null && a0Var4.f11905e) {
                    if ((a0Var4.f11903c + j10) - (a0Var4.f11904d ? 0 : a0Var4.f11902b) <= 8192) {
                        a0 a0Var5 = source.f11925a;
                        kotlin.jvm.internal.g.c(a0Var5);
                        a0Var5.d(a0Var4, (int) j10);
                        source.f11926b -= j10;
                        this.f11926b += j10;
                        return;
                    }
                }
                a0 a0Var6 = source.f11925a;
                kotlin.jvm.internal.g.c(a0Var6);
                int i12 = (int) j10;
                if (i12 <= 0 || i12 > a0Var6.f11903c - a0Var6.f11902b) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i12 >= 1024) {
                    a0VarB = a0Var6.c();
                } else {
                    a0VarB = b0.b();
                    byte[] bArr = a0Var6.f11901a;
                    byte[] bArr2 = a0VarB.f11901a;
                    int i13 = a0Var6.f11902b;
                    b1.s(bArr, bArr2, 0, i13, i13 + i12, 2);
                }
                a0VarB.f11903c = a0VarB.f11902b + i12;
                a0Var6.f11902b += i12;
                a0 a0Var7 = a0Var6.f11907g;
                kotlin.jvm.internal.g.c(a0Var7);
                a0Var7.b(a0VarB);
                source.f11925a = a0VarB;
            }
            a0 a0Var8 = source.f11925a;
            kotlin.jvm.internal.g.c(a0Var8);
            long j12 = a0Var8.f11903c - a0Var8.f11902b;
            source.f11925a = a0Var8.a();
            a0 a0Var9 = this.f11925a;
            if (a0Var9 == null) {
                this.f11925a = a0Var8;
                a0Var8.f11907g = a0Var8;
                a0Var8.f11906f = a0Var8;
            } else {
                a0 a0Var10 = a0Var9.f11907g;
                kotlin.jvm.internal.g.c(a0Var10);
                a0Var10.b(a0Var8);
                a0 a0Var11 = a0Var8.f11907g;
                if (a0Var11 == a0Var8) {
                    throw new IllegalStateException("cannot compact");
                }
                kotlin.jvm.internal.g.c(a0Var11);
                if (a0Var11.f11905e) {
                    int i14 = a0Var8.f11903c - a0Var8.f11902b;
                    a0 a0Var12 = a0Var8.f11907g;
                    kotlin.jvm.internal.g.c(a0Var12);
                    int i15 = 8192 - a0Var12.f11903c;
                    a0 a0Var13 = a0Var8.f11907g;
                    kotlin.jvm.internal.g.c(a0Var13);
                    if (!a0Var13.f11904d) {
                        a0 a0Var14 = a0Var8.f11907g;
                        kotlin.jvm.internal.g.c(a0Var14);
                        i11 = a0Var14.f11902b;
                    }
                    if (i14 <= i15 + i11) {
                        a0 a0Var15 = a0Var8.f11907g;
                        kotlin.jvm.internal.g.c(a0Var15);
                        a0Var8.d(a0Var15, i14);
                        a0Var8.a();
                        b0.a(a0Var8);
                    }
                }
            }
            source.f11926b -= j12;
            this.f11926b += j12;
            j10 -= j12;
        }
    }

    public final void o() throws EOFException {
        skip(this.f11926b);
    }

    @Override // sd.h
    public final String p0(Charset charset) {
        kotlin.jvm.internal.g.f(charset, "charset");
        return I0(this.f11926b, charset);
    }

    @Override // sd.e0
    public final long read(e sink, long j10) {
        kotlin.jvm.internal.g.f(sink, "sink");
        if (j10 < 0) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount < 0: ").toString());
        }
        long j11 = this.f11926b;
        if (j11 == 0) {
            return -1L;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        sink.j0(this, j10);
        return j10;
    }

    @Override // sd.h
    public final byte readByte() throws EOFException {
        if (this.f11926b == 0) {
            throw new EOFException();
        }
        a0 a0Var = this.f11925a;
        kotlin.jvm.internal.g.c(a0Var);
        int i10 = a0Var.f11902b;
        int i11 = a0Var.f11903c;
        int i12 = i10 + 1;
        byte b10 = a0Var.f11901a[i10];
        this.f11926b--;
        if (i12 != i11) {
            a0Var.f11902b = i12;
            return b10;
        }
        this.f11925a = a0Var.a();
        b0.a(a0Var);
        return b10;
    }

    @Override // sd.h
    public final void readFully(byte[] sink) throws EOFException {
        kotlin.jvm.internal.g.f(sink, "sink");
        int i10 = 0;
        while (i10 < sink.length) {
            int i11 = read(sink, i10, sink.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    @Override // sd.h
    public final int readInt() throws EOFException {
        if (this.f11926b < 4) {
            throw new EOFException();
        }
        a0 a0Var = this.f11925a;
        kotlin.jvm.internal.g.c(a0Var);
        int i10 = a0Var.f11902b;
        int i11 = a0Var.f11903c;
        if (i11 - i10 < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = a0Var.f11901a;
        int i12 = i10 + 3;
        int i13 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 2] & 255) << 8);
        int i14 = i10 + 4;
        int i15 = (bArr[i12] & 255) | i13;
        this.f11926b -= 4;
        if (i14 != i11) {
            a0Var.f11902b = i14;
            return i15;
        }
        this.f11925a = a0Var.a();
        b0.a(a0Var);
        return i15;
    }

    @Override // sd.h
    public final long readLong() throws EOFException {
        if (this.f11926b < 8) {
            throw new EOFException();
        }
        a0 a0Var = this.f11925a;
        kotlin.jvm.internal.g.c(a0Var);
        int i10 = a0Var.f11902b;
        int i11 = a0Var.f11903c;
        if (i11 - i10 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = a0Var.f11901a;
        int i12 = i10 + 7;
        long j10 = ((bArr[i10] & 255) << 56) | ((bArr[i10 + 1] & 255) << 48) | ((bArr[i10 + 2] & 255) << 40) | ((bArr[i10 + 3] & 255) << 32) | ((bArr[i10 + 4] & 255) << 24) | ((bArr[i10 + 5] & 255) << 16) | ((bArr[i10 + 6] & 255) << 8);
        int i13 = i10 + 8;
        long j11 = j10 | (bArr[i12] & 255);
        this.f11926b -= 8;
        if (i13 != i11) {
            a0Var.f11902b = i13;
            return j11;
        }
        this.f11925a = a0Var.a();
        b0.a(a0Var);
        return j11;
    }

    @Override // sd.h
    public final short readShort() throws EOFException {
        if (this.f11926b < 2) {
            throw new EOFException();
        }
        a0 a0Var = this.f11925a;
        kotlin.jvm.internal.g.c(a0Var);
        int i10 = a0Var.f11902b;
        int i11 = a0Var.f11903c;
        if (i11 - i10 < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = a0Var.f11901a;
        int i12 = i10 + 1;
        int i13 = (bArr[i10] & 255) << 8;
        int i14 = i10 + 2;
        int i15 = (bArr[i12] & 255) | i13;
        this.f11926b -= 2;
        if (i14 == i11) {
            this.f11925a = a0Var.a();
            b0.a(a0Var);
        } else {
            a0Var.f11902b = i14;
        }
        return (short) i15;
    }

    @Override // sd.g
    public final /* bridge */ /* synthetic */ g s0(long j10) {
        Q0(j10);
        return this;
    }

    @Override // sd.h
    public final void skip(long j10) throws EOFException {
        while (j10 > 0) {
            a0 a0Var = this.f11925a;
            if (a0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j10, a0Var.f11903c - a0Var.f11902b);
            long j11 = iMin;
            this.f11926b -= j11;
            j10 -= j11;
            int i10 = a0Var.f11902b + iMin;
            a0Var.f11902b = i10;
            if (i10 == a0Var.f11903c) {
                this.f11925a = a0Var.a();
                b0.a(a0Var);
            }
        }
    }

    @Override // sd.e0
    public final f0 timeout() {
        return f0.f11935d;
    }

    public final String toString() {
        long j10 = this.f11926b;
        if (j10 <= 2147483647L) {
            return L0((int) j10).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f11926b).toString());
    }

    @Override // sd.g
    public final long u(e0 source) {
        kotlin.jvm.internal.g.f(source, "source");
        long j10 = 0;
        while (true) {
            long j11 = source.read(this, 8192L);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
        }
    }

    @Override // sd.h
    public final String v() {
        long jC0 = c0((byte) 10, 0L, Long.MAX_VALUE);
        if (jC0 != -1) {
            return td.a.a(this, jC0);
        }
        long j10 = this.f11926b;
        if (j10 != 0) {
            return I0(j10, gc.a.f9106b);
        }
        return null;
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final e clone() {
        e eVar = new e();
        if (this.f11926b == 0) {
            return eVar;
        }
        a0 a0Var = this.f11925a;
        kotlin.jvm.internal.g.c(a0Var);
        a0 a0VarC = a0Var.c();
        eVar.f11925a = a0VarC;
        a0VarC.f11907g = a0VarC;
        a0VarC.f11906f = a0VarC;
        for (a0 a0Var2 = a0Var.f11906f; a0Var2 != a0Var; a0Var2 = a0Var2.f11906f) {
            a0 a0Var3 = a0VarC.f11907g;
            kotlin.jvm.internal.g.c(a0Var3);
            kotlin.jvm.internal.g.c(a0Var2);
            a0Var3.b(a0Var2.c());
        }
        eVar.f11926b = this.f11926b;
        return eVar;
    }

    @Override // sd.g
    public final /* bridge */ /* synthetic */ g write(byte[] bArr) {
        m176write(bArr);
        return this;
    }

    @Override // sd.g
    public final /* bridge */ /* synthetic */ g writeByte(int i10) {
        O0(i10);
        return this;
    }

    @Override // sd.g
    public final /* bridge */ /* synthetic */ g writeInt(int i10) {
        R0(i10);
        return this;
    }

    @Override // sd.g
    public final /* bridge */ /* synthetic */ g writeShort(int i10) {
        S0(i10);
        return this;
    }

    @Override // sd.h
    public final String x(long j10) throws EOFException {
        if (j10 < 0) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "limit < 0: ").toString());
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long jC0 = c0((byte) 10, 0L, j11);
        if (jC0 != -1) {
            return td.a.a(this, jC0);
        }
        if (j11 < this.f11926b && S(j11 - 1) == 13 && S(j11) == 10) {
            return td.a.a(this, j11);
        }
        e eVar = new e();
        P(eVar, 0L, Math.min(32, this.f11926b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f11926b, j10) + " content=" + eVar.X(eVar.f11926b).e() + (char) 8230);
    }

    public final boolean x0(long j10, ByteString bytes) {
        kotlin.jvm.internal.g.f(bytes, "bytes");
        int iD = bytes.d();
        if (j10 >= 0 && iD >= 0 && this.f11926b - j10 >= iD && bytes.d() >= iD) {
            for (int i10 = 0; i10 < iD; i10++) {
                if (S(i10 + j10) == bytes.j(i10)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // sd.g
    public final /* bridge */ /* synthetic */ g z0(ByteString byteString) {
        N0(byteString);
        return this;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public final int available() {
            return (int) Math.min(e.this.f11926b, Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream
        public final int read() {
            e eVar = e.this;
            if (eVar.f11926b > 0) {
                return eVar.readByte() & 255;
            }
            return -1;
        }

        public final String toString() {
            return e.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public final int read(byte[] sink, int i10, int i11) {
            kotlin.jvm.internal.g.f(sink, "sink");
            return e.this.read(sink, i10, i11);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }
    }

    @Override // sd.g
    public final /* bridge */ /* synthetic */ g write(byte[] bArr, int i10, int i11) {
        m177write(bArr, i10, i11);
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.g.f(source, "source");
        int iRemaining = source.remaining();
        int i10 = iRemaining;
        while (i10 > 0) {
            a0 a0VarM0 = M0(1);
            int iMin = Math.min(i10, 8192 - a0VarM0.f11903c);
            source.get(a0VarM0.f11901a, a0VarM0.f11903c, iMin);
            i10 -= iMin;
            a0VarM0.f11903c += iMin;
        }
        this.f11926b += iRemaining;
        return iRemaining;
    }

    /* renamed from: write, reason: collision with other method in class */
    public final void m176write(byte[] source) {
        kotlin.jvm.internal.g.f(source, "source");
        m177write(source, 0, source.length);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.g.f(sink, "sink");
        a0 a0Var = this.f11925a;
        if (a0Var == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), a0Var.f11903c - a0Var.f11902b);
        sink.put(a0Var.f11901a, a0Var.f11902b, iMin);
        int i10 = a0Var.f11902b + iMin;
        a0Var.f11902b = i10;
        this.f11926b -= iMin;
        if (i10 == a0Var.f11903c) {
            this.f11925a = a0Var.a();
            b0.a(a0Var);
        }
        return iMin;
    }

    /* renamed from: write, reason: collision with other method in class */
    public final void m177write(byte[] source, int i10, int i11) {
        kotlin.jvm.internal.g.f(source, "source");
        long j10 = i11;
        sd.a.b(source.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            a0 a0VarM0 = M0(1);
            int iMin = Math.min(i12 - i10, 8192 - a0VarM0.f11903c);
            int i13 = i10 + iMin;
            b1.n(a0VarM0.f11903c, i10, i13, source, a0VarM0.f11901a);
            a0VarM0.f11903c += iMin;
            i10 = i13;
        }
        this.f11926b += j10;
    }

    public final int read(byte[] sink, int i10, int i11) {
        kotlin.jvm.internal.g.f(sink, "sink");
        sd.a.b(sink.length, i10, i11);
        a0 a0Var = this.f11925a;
        if (a0Var == null) {
            return -1;
        }
        int iMin = Math.min(i11, a0Var.f11903c - a0Var.f11902b);
        byte[] bArr = a0Var.f11901a;
        int i12 = a0Var.f11902b;
        b1.n(i10, i12, i12 + iMin, bArr, sink);
        int i13 = a0Var.f11902b + iMin;
        a0Var.f11902b = i13;
        this.f11926b -= iMin;
        if (i13 == a0Var.f11903c) {
            this.f11925a = a0Var.a();
            b0.a(a0Var);
        }
        return iMin;
    }

    @Override // sd.h, sd.g
    public final e c() {
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, sd.c0
    public final void close() {
    }

    @Override // sd.g, sd.c0, java.io.Flushable
    public final void flush() {
    }

    @Override // sd.g
    public final g p() {
        return this;
    }
}
