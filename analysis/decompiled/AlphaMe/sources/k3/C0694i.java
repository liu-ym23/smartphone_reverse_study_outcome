package k3;

import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.util.UTF8Decoder;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.Typography;
import l3.AbstractC0765a;
import l3.AbstractC0766b;
import okhttp3.internal.connection.RealConnection;

/* renamed from: k3.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0694i implements InterfaceC0696k, InterfaceC0695j, Cloneable, ByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public w f13356a;

    /* renamed from: b, reason: collision with root package name */
    public long f13357b;

    @Override // k3.InterfaceC0695j
    public final long A(InterfaceC0680B source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j4 = 0;
        while (true) {
            long j5 = source.read(this, 8192L);
            if (j5 == -1) {
                return j4;
            }
            j4 += j5;
        }
    }

    @Override // k3.InterfaceC0695j
    public final /* bridge */ /* synthetic */ InterfaceC0695j B(int i4, int i5, byte[] bArr) {
        S(i4, i5, bArr);
        return this;
    }

    public final C0692g C(C0692g unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        byte[] bArr = AbstractC0765a.f13505a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (unsafeCursor == AbstractC0685G.f13339a) {
            unsafeCursor = new C0692g();
        }
        if (unsafeCursor.f13347a != null) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor.f13347a = this;
        unsafeCursor.f13348b = true;
        return unsafeCursor;
    }

    public final byte[] D(long j4) throws EOFException {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(AbstractC0351g.n("byteCount: ", j4).toString());
        }
        if (this.f13357b < j4) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j4];
        readFully(bArr);
        return bArr;
    }

    @Override // k3.InterfaceC0696k
    public final void E(long j4) throws EOFException {
        if (this.f13357b < j4) {
            throw new EOFException();
        }
    }

    @Override // k3.InterfaceC0696k
    public final void F(C0694i sink, long j4) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j5 = this.f13357b;
        if (j5 >= j4) {
            sink.write(this, j4);
        } else {
            sink.write(this, j5);
            throw new EOFException();
        }
    }

    @Override // k3.InterfaceC0695j
    public final /* bridge */ /* synthetic */ InterfaceC0695j G(String str) {
        d0(str);
        return this;
    }

    @Override // k3.InterfaceC0695j
    public final /* bridge */ /* synthetic */ InterfaceC0695j H(long j4) {
        W(j4);
        return this;
    }

    public final long I() throws EOFException {
        if (this.f13357b == 0) {
            throw new EOFException();
        }
        int i4 = 0;
        boolean z4 = false;
        long j4 = 0;
        long j5 = -7;
        boolean z5 = false;
        do {
            w wVar = this.f13356a;
            Intrinsics.checkNotNull(wVar);
            byte[] bArr = wVar.f13385a;
            int i5 = wVar.f13386b;
            int i6 = wVar.f13387c;
            while (i5 < i6) {
                byte b4 = bArr[i5];
                byte b5 = (byte) 48;
                if (b4 >= b5 && b4 <= ((byte) 57)) {
                    int i7 = b5 - b4;
                    if (j4 < -922337203685477580L || (j4 == -922337203685477580L && i7 < j5)) {
                        C0694i c0694i = new C0694i();
                        c0694i.W(j4);
                        c0694i.V(b4);
                        if (!z4) {
                            c0694i.readByte();
                        }
                        throw new NumberFormatException("Number too large: ".concat(c0694i.O()));
                    }
                    j4 = (j4 * 10) + i7;
                } else {
                    if (b4 != ((byte) 45) || i4 != 0) {
                        z5 = true;
                        break;
                    }
                    j5--;
                    z4 = true;
                }
                i5++;
                i4++;
            }
            if (i5 == i6) {
                this.f13356a = wVar.a();
                x.a(wVar);
            } else {
                wVar.f13386b = i5;
            }
            if (z5) {
                break;
            }
        } while (this.f13356a != null);
        long j6 = this.f13357b - i4;
        this.f13357b = j6;
        if (i4 >= (z4 ? 2 : 1)) {
            return z4 ? j4 : -j4;
        }
        if (j6 == 0) {
            throw new EOFException();
        }
        StringBuilder sbV = B0.g.v(z4 ? "Expected a digit" : "Expected a digit or '-'", " but was 0x");
        sbV.append(AbstractC0685G.c(l(0L)));
        throw new NumberFormatException(sbV.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c A[EDGE_INSN: B:43:0x009c->B:37:0x009c BREAK  A[LOOP:0: B:5:0x000b->B:45:?], SYNTHETIC] */
    @Override // k3.InterfaceC0696k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long J() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.f13357b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La3
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            k3.w r6 = r14.f13356a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            byte[] r7 = r6.f13385a
            int r8 = r6.f13386b
            int r9 = r6.f13387c
        L16:
            if (r8 >= r9) goto L88
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L27
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L27
            int r11 = r10 - r11
            goto L41
        L27:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L36
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L36
        L31:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L41
        L36:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L6c
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L6c
            goto L31
        L41:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L51
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L16
        L51:
            k3.i r14 = new k3.i
            r14.<init>()
            r14.X(r4)
            r14.V(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r14 = r14.O()
            java.lang.String r1 = "Number too large: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        L6c:
            if (r0 == 0) goto L70
            r1 = 1
            goto L88
        L70:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.<init>(r1)
            java.lang.String r1 = k3.AbstractC0685G.c(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L88:
            if (r8 != r9) goto L94
            k3.w r7 = r6.a()
            r14.f13356a = r7
            k3.x.a(r6)
            goto L96
        L94:
            r6.f13386b = r8
        L96:
            if (r1 != 0) goto L9c
            k3.w r6 = r14.f13356a
            if (r6 != 0) goto Lb
        L9c:
            long r1 = r14.f13357b
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f13357b = r1
            return r4
        La3:
            java.io.EOFException r14 = new java.io.EOFException
            r14.<init>()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.C0694i.J():long");
    }

    @Override // k3.InterfaceC0696k
    public final String K(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return N(this.f13357b, charset);
    }

    @Override // k3.InterfaceC0696k
    public final long L(C0694i sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j4 = this.f13357b;
        if (j4 > 0) {
            sink.write(this, j4);
        }
        return j4;
    }

    @Override // k3.InterfaceC0696k
    public final C0693h M() {
        return new C0693h(this, 0);
    }

    public final String N(long j4, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(AbstractC0351g.n("byteCount: ", j4).toString());
        }
        if (this.f13357b < j4) {
            throw new EOFException();
        }
        if (j4 == 0) {
            return "";
        }
        w wVar = this.f13356a;
        Intrinsics.checkNotNull(wVar);
        int i4 = wVar.f13386b;
        if (i4 + j4 > wVar.f13387c) {
            return new String(D(j4), charset);
        }
        int i5 = (int) j4;
        String str = new String(wVar.f13385a, i4, i5, charset);
        int i6 = wVar.f13386b + i5;
        wVar.f13386b = i6;
        this.f13357b -= j4;
        if (i6 == wVar.f13387c) {
            this.f13356a = wVar.a();
            x.a(wVar);
        }
        return str;
    }

    public final String O() {
        return N(this.f13357b, Charsets.UTF_8);
    }

    public final int P() throws EOFException {
        int i4;
        int i5;
        int i6;
        if (this.f13357b == 0) {
            throw new EOFException();
        }
        byte bL = l(0L);
        if ((bL & ByteCompanionObject.MIN_VALUE) == 0) {
            i4 = bL & ByteCompanionObject.MAX_VALUE;
            i6 = 0;
            i5 = 1;
        } else if ((bL & 224) == 192) {
            i4 = bL & 31;
            i5 = 2;
            i6 = 128;
        } else if ((bL & 240) == 224) {
            i4 = bL & 15;
            i5 = 3;
            i6 = 2048;
        } else {
            if ((bL & 248) != 240) {
                j(1L);
                return 65533;
            }
            i4 = bL & 7;
            i5 = 4;
            i6 = UTF8Decoder.Surrogate.UCS4_MIN;
        }
        long j4 = i5;
        if (this.f13357b < j4) {
            StringBuilder sbT = B0.g.t("size < ", i5, ": ");
            sbT.append(this.f13357b);
            sbT.append(" (to read code point prefixed 0x");
            sbT.append(AbstractC0685G.c(bL));
            sbT.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
            throw new EOFException(sbT.toString());
        }
        for (int i7 = 1; i7 < i5; i7++) {
            long j5 = i7;
            byte bL2 = l(j5);
            if ((bL2 & 192) != 128) {
                j(j5);
                return 65533;
            }
            i4 = (i4 << 6) | (bL2 & 63);
        }
        j(j4);
        if (i4 > 1114111) {
            return 65533;
        }
        if ((55296 > i4 || i4 >= 57344) && i4 >= i6) {
            return i4;
        }
        return 65533;
    }

    public final l Q(int i4) {
        if (i4 == 0) {
            return l.f13358d;
        }
        AbstractC0685G.b(this.f13357b, 0L, i4);
        w wVar = this.f13356a;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            Intrinsics.checkNotNull(wVar);
            int i8 = wVar.f13387c;
            int i9 = wVar.f13386b;
            if (i8 == i9) {
                throw new AssertionError("s.limit == s.pos");
            }
            i6 += i8 - i9;
            i7++;
            wVar = wVar.f13390f;
        }
        byte[][] bArr = new byte[i7][];
        int[] iArr = new int[i7 * 2];
        w wVar2 = this.f13356a;
        int i10 = 0;
        while (i5 < i4) {
            Intrinsics.checkNotNull(wVar2);
            bArr[i10] = wVar2.f13385a;
            i5 += wVar2.f13387c - wVar2.f13386b;
            iArr[i10] = Math.min(i5, i4);
            iArr[i10 + i7] = wVar2.f13386b;
            wVar2.f13388d = true;
            i10++;
            wVar2 = wVar2.f13390f;
        }
        return new y(bArr, iArr);
    }

    public final w R(int i4) {
        if (i4 < 1 || i4 > 8192) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        w wVar = this.f13356a;
        if (wVar == null) {
            w wVarB = x.b();
            this.f13356a = wVarB;
            wVarB.f13391g = wVarB;
            wVarB.f13390f = wVarB;
            return wVarB;
        }
        Intrinsics.checkNotNull(wVar);
        w wVar2 = wVar.f13391g;
        Intrinsics.checkNotNull(wVar2);
        if (wVar2.f13387c + i4 <= 8192 && wVar2.f13389e) {
            return wVar2;
        }
        w wVarB2 = x.b();
        wVar2.b(wVarB2);
        return wVarB2;
    }

    public final void S(int i4, int i5, byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j4 = i5;
        AbstractC0685G.b(source.length, i4, j4);
        int i6 = i5 + i4;
        while (i4 < i6) {
            w wVarR = R(1);
            int iMin = Math.min(i6 - i4, 8192 - wVarR.f13387c);
            int i7 = i4 + iMin;
            ArraysKt.copyInto(source, wVarR.f13385a, wVarR.f13387c, i4, i7);
            wVarR.f13387c += iMin;
            i4 = i7;
        }
        this.f13357b += j4;
    }

    public final void T(l byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.k(this, byteString.c());
    }

    public final void U(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        S(0, source.length, source);
    }

    public final void V(int i4) {
        w wVarR = R(1);
        int i5 = wVarR.f13387c;
        wVarR.f13387c = i5 + 1;
        wVarR.f13385a[i5] = (byte) i4;
        this.f13357b++;
    }

    public final void W(long j4) {
        boolean z4;
        byte[] bArr;
        if (j4 == 0) {
            V(48);
            return;
        }
        int i4 = 1;
        if (j4 < 0) {
            j4 = -j4;
            if (j4 < 0) {
                d0("-9223372036854775808");
                return;
            }
            z4 = true;
        } else {
            z4 = false;
        }
        if (j4 >= 100000000) {
            i4 = j4 < 1000000000000L ? j4 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j4 < 1000000000 ? 9 : 10 : j4 < 100000000000L ? 11 : 12 : j4 < 1000000000000000L ? j4 < 10000000000000L ? 13 : j4 < 100000000000000L ? 14 : 15 : j4 < 100000000000000000L ? j4 < 10000000000000000L ? 16 : 17 : j4 < 1000000000000000000L ? 18 : 19;
        } else if (j4 >= AbstractComponentTracker.LINGERING_TIMEOUT) {
            i4 = j4 < 1000000 ? j4 < 100000 ? 5 : 6 : j4 < 10000000 ? 7 : 8;
        } else if (j4 >= 100) {
            i4 = j4 < 1000 ? 3 : 4;
        } else if (j4 >= 10) {
            i4 = 2;
        }
        if (z4) {
            i4++;
        }
        w wVarR = R(i4);
        int i5 = wVarR.f13387c + i4;
        while (true) {
            bArr = wVarR.f13385a;
            if (j4 == 0) {
                break;
            }
            long j5 = 10;
            i5--;
            bArr[i5] = AbstractC0765a.f13505a[(int) (j4 % j5)];
            j4 /= j5;
        }
        if (z4) {
            bArr[i5 - 1] = (byte) 45;
        }
        wVarR.f13387c += i4;
        this.f13357b += i4;
    }

    public final void X(long j4) {
        if (j4 == 0) {
            V(48);
            return;
        }
        long j5 = (j4 >>> 1) | j4;
        long j6 = j5 | (j5 >>> 2);
        long j7 = j6 | (j6 >>> 4);
        long j8 = j7 | (j7 >>> 8);
        long j9 = j8 | (j8 >>> 16);
        long j10 = j9 | (j9 >>> 32);
        long j11 = j10 - ((j10 >>> 1) & 6148914691236517205L);
        long j12 = ((j11 >>> 2) & 3689348814741910323L) + (j11 & 3689348814741910323L);
        long j13 = ((j12 >>> 4) + j12) & 1085102592571150095L;
        long j14 = j13 + (j13 >>> 8);
        long j15 = j14 + (j14 >>> 16);
        int i4 = (int) ((((j15 & 63) + ((j15 >>> 32) & 63)) + 3) / 4);
        w wVarR = R(i4);
        int i5 = wVarR.f13387c;
        for (int i6 = (i5 + i4) - 1; i6 >= i5; i6--) {
            wVarR.f13385a[i6] = AbstractC0765a.f13505a[(int) (15 & j4)];
            j4 >>>= 4;
        }
        wVarR.f13387c += i4;
        this.f13357b += i4;
    }

    public final void Y(int i4) {
        w wVarR = R(4);
        int i5 = wVarR.f13387c;
        byte[] bArr = wVarR.f13385a;
        bArr[i5] = (byte) ((i4 >>> 24) & 255);
        bArr[i5 + 1] = (byte) ((i4 >>> 16) & 255);
        bArr[i5 + 2] = (byte) ((i4 >>> 8) & 255);
        bArr[i5 + 3] = (byte) (i4 & 255);
        wVarR.f13387c = i5 + 4;
        this.f13357b += 4;
    }

    public final void Z(long j4) {
        w wVarR = R(8);
        int i4 = wVarR.f13387c;
        byte[] bArr = wVarR.f13385a;
        bArr[i4] = (byte) ((j4 >>> 56) & 255);
        bArr[i4 + 1] = (byte) ((j4 >>> 48) & 255);
        bArr[i4 + 2] = (byte) ((j4 >>> 40) & 255);
        bArr[i4 + 3] = (byte) ((j4 >>> 32) & 255);
        bArr[i4 + 4] = (byte) ((j4 >>> 24) & 255);
        bArr[i4 + 5] = (byte) ((j4 >>> 16) & 255);
        bArr[i4 + 6] = (byte) ((j4 >>> 8) & 255);
        bArr[i4 + 7] = (byte) (j4 & 255);
        wVarR.f13387c = i4 + 8;
        this.f13357b += 8;
    }

    public final void a() throws EOFException {
        j(this.f13357b);
    }

    public final void a0(int i4) {
        w wVarR = R(2);
        int i5 = wVarR.f13387c;
        byte[] bArr = wVarR.f13385a;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i5 + 1] = (byte) (i4 & 255);
        wVarR.f13387c = i5 + 2;
        this.f13357b += 2;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C0694i clone() {
        C0694i c0694i = new C0694i();
        if (this.f13357b != 0) {
            w wVar = this.f13356a;
            Intrinsics.checkNotNull(wVar);
            w wVarC = wVar.c();
            c0694i.f13356a = wVarC;
            wVarC.f13391g = wVarC;
            wVarC.f13390f = wVarC;
            for (w wVar2 = wVar.f13390f; wVar2 != wVar; wVar2 = wVar2.f13390f) {
                w wVar3 = wVarC.f13391g;
                Intrinsics.checkNotNull(wVar3);
                Intrinsics.checkNotNull(wVar2);
                wVar3.b(wVar2.c());
            }
            c0694i.f13357b = this.f13357b;
        }
        return c0694i;
    }

    public final void b0(String string, int i4, int i5, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (i4 < 0) {
            throw new IllegalArgumentException(AbstractC0351g.m("beginIndex < 0: ", i4).toString());
        }
        if (i5 < i4) {
            throw new IllegalArgumentException(B0.g.k("endIndex < beginIndex: ", i5, " < ", i4).toString());
        }
        if (i5 > string.length()) {
            StringBuilder sbT = B0.g.t("endIndex > string.length: ", i5, " > ");
            sbT.append(string.length());
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            c0(i4, i5, string);
            return;
        }
        String strSubstring = string.substring(i4, i5);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = strSubstring.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        S(0, bytes.length, bytes);
    }

    @Override // k3.InterfaceC0696k
    public final boolean c(long j4) {
        return this.f13357b >= LongCompanionObject.MAX_VALUE;
    }

    public final void c0(int i4, int i5, String string) {
        char cCharAt;
        Intrinsics.checkNotNullParameter(string, "string");
        if (i4 < 0) {
            throw new IllegalArgumentException(AbstractC0351g.m("beginIndex < 0: ", i4).toString());
        }
        if (i5 < i4) {
            throw new IllegalArgumentException(B0.g.k("endIndex < beginIndex: ", i5, " < ", i4).toString());
        }
        if (i5 > string.length()) {
            StringBuilder sbT = B0.g.t("endIndex > string.length: ", i5, " > ");
            sbT.append(string.length());
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        while (i4 < i5) {
            char cCharAt2 = string.charAt(i4);
            if (cCharAt2 < 128) {
                w wVarR = R(1);
                int i6 = wVarR.f13387c - i4;
                int iMin = Math.min(i5, 8192 - i6);
                int i7 = i4 + 1;
                byte[] bArr = wVarR.f13385a;
                bArr[i4 + i6] = (byte) cCharAt2;
                while (true) {
                    i4 = i7;
                    if (i4 >= iMin || (cCharAt = string.charAt(i4)) >= 128) {
                        break;
                    }
                    i7 = i4 + 1;
                    bArr[i4 + i6] = (byte) cCharAt;
                }
                int i8 = wVarR.f13387c;
                int i9 = (i6 + i4) - i8;
                wVarR.f13387c = i8 + i9;
                this.f13357b += i9;
            } else {
                if (cCharAt2 < 2048) {
                    w wVarR2 = R(2);
                    int i10 = wVarR2.f13387c;
                    byte b4 = (byte) ((cCharAt2 >> 6) | Opcodes.CHECKCAST);
                    byte[] bArr2 = wVarR2.f13385a;
                    bArr2[i10] = b4;
                    bArr2[i10 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    wVarR2.f13387c = i10 + 2;
                    this.f13357b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    w wVarR3 = R(3);
                    int i11 = wVarR3.f13387c;
                    byte[] bArr3 = wVarR3.f13385a;
                    bArr3[i11] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i11 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i11 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    wVarR3.f13387c = i11 + 3;
                    this.f13357b += 3;
                } else {
                    int i12 = i4 + 1;
                    char cCharAt3 = i12 < i5 ? string.charAt(i12) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        V(63);
                        i4 = i12;
                    } else {
                        int i13 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + UTF8Decoder.Surrogate.UCS4_MIN;
                        w wVarR4 = R(4);
                        int i14 = wVarR4.f13387c;
                        byte[] bArr4 = wVarR4.f13385a;
                        bArr4[i14] = (byte) ((i13 >> 18) | 240);
                        bArr4[i14 + 1] = (byte) (((i13 >> 12) & 63) | 128);
                        bArr4[i14 + 2] = (byte) (((i13 >> 6) & 63) | 128);
                        bArr4[i14 + 3] = (byte) ((i13 & 63) | 128);
                        wVarR4.f13387c = i14 + 4;
                        this.f13357b += 4;
                        i4 += 2;
                    }
                }
                i4++;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, k3.z
    public final void close() {
    }

    public final long d() {
        long j4 = this.f13357b;
        if (j4 == 0) {
            return 0L;
        }
        w wVar = this.f13356a;
        Intrinsics.checkNotNull(wVar);
        w wVar2 = wVar.f13391g;
        Intrinsics.checkNotNull(wVar2);
        if (wVar2.f13387c < 8192 && wVar2.f13389e) {
            j4 -= r2 - wVar2.f13386b;
        }
        return j4;
    }

    public final void d0(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        c0(0, string.length(), string);
    }

    public final void e(long j4, C0694i out, long j5) {
        Intrinsics.checkNotNullParameter(out, "out");
        AbstractC0685G.b(this.f13357b, j4, j5);
        if (j5 == 0) {
            return;
        }
        out.f13357b += j5;
        w wVar = this.f13356a;
        while (true) {
            Intrinsics.checkNotNull(wVar);
            long j6 = wVar.f13387c - wVar.f13386b;
            if (j4 < j6) {
                break;
            }
            j4 -= j6;
            wVar = wVar.f13390f;
        }
        while (j5 > 0) {
            Intrinsics.checkNotNull(wVar);
            w wVarC = wVar.c();
            int i4 = wVarC.f13386b + ((int) j4);
            wVarC.f13386b = i4;
            wVarC.f13387c = Math.min(i4 + ((int) j5), wVarC.f13387c);
            w wVar2 = out.f13356a;
            if (wVar2 == null) {
                wVarC.f13391g = wVarC;
                wVarC.f13390f = wVarC;
                out.f13356a = wVarC;
            } else {
                Intrinsics.checkNotNull(wVar2);
                w wVar3 = wVar2.f13391g;
                Intrinsics.checkNotNull(wVar3);
                wVar3.b(wVarC);
            }
            j5 -= wVarC.f13387c - wVarC.f13386b;
            wVar = wVar.f13390f;
            j4 = 0;
        }
    }

    public final void e0(int i4) {
        String strConcatToString;
        int i5 = 0;
        if (i4 < 128) {
            V(i4);
            return;
        }
        if (i4 < 2048) {
            w wVarR = R(2);
            int i6 = wVarR.f13387c;
            byte b4 = (byte) ((i4 >> 6) | Opcodes.CHECKCAST);
            byte[] bArr = wVarR.f13385a;
            bArr[i6] = b4;
            bArr[1 + i6] = (byte) ((i4 & 63) | 128);
            wVarR.f13387c = i6 + 2;
            this.f13357b += 2;
            return;
        }
        if (55296 <= i4 && i4 < 57344) {
            V(63);
            return;
        }
        if (i4 < 65536) {
            w wVarR2 = R(3);
            int i7 = wVarR2.f13387c;
            byte[] bArr2 = wVarR2.f13385a;
            bArr2[i7] = (byte) ((i4 >> 12) | 224);
            bArr2[1 + i7] = (byte) (((i4 >> 6) & 63) | 128);
            bArr2[2 + i7] = (byte) ((i4 & 63) | 128);
            wVarR2.f13387c = i7 + 3;
            this.f13357b += 3;
            return;
        }
        if (i4 <= 1114111) {
            w wVarR3 = R(4);
            int i8 = wVarR3.f13387c;
            byte[] bArr3 = wVarR3.f13385a;
            bArr3[i8] = (byte) ((i4 >> 18) | 240);
            bArr3[1 + i8] = (byte) (((i4 >> 12) & 63) | 128);
            bArr3[2 + i8] = (byte) (((i4 >> 6) & 63) | 128);
            bArr3[3 + i8] = (byte) ((i4 & 63) | 128);
            wVarR3.f13387c = i8 + 4;
            this.f13357b += 4;
            return;
        }
        StringBuilder sb = new StringBuilder("Unexpected code point: 0x");
        if (i4 != 0) {
            char[] cArr = AbstractC0766b.f13506a;
            char[] cArr2 = {cArr[(i4 >> 28) & 15], cArr[(i4 >> 24) & 15], cArr[(i4 >> 20) & 15], cArr[(i4 >> 16) & 15], cArr[(i4 >> 12) & 15], cArr[(i4 >> 8) & 15], cArr[(i4 >> 4) & 15], cArr[i4 & 15]};
            while (i5 < 8 && cArr2[i5] == '0') {
                i5++;
            }
            strConcatToString = StringsKt__StringsJVMKt.concatToString(cArr2, i5, 8);
        } else {
            strConcatToString = "0";
        }
        sb.append(strConcatToString);
        throw new IllegalArgumentException(sb.toString());
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C0694i) {
                long j4 = this.f13357b;
                C0694i c0694i = (C0694i) obj;
                if (j4 == c0694i.f13357b) {
                    if (j4 != 0) {
                        w wVar = this.f13356a;
                        Intrinsics.checkNotNull(wVar);
                        w wVar2 = c0694i.f13356a;
                        Intrinsics.checkNotNull(wVar2);
                        int i4 = wVar.f13386b;
                        int i5 = wVar2.f13386b;
                        long j5 = 0;
                        while (j5 < this.f13357b) {
                            long jMin = Math.min(wVar.f13387c - i4, wVar2.f13387c - i5);
                            long j6 = 0;
                            while (j6 < jMin) {
                                int i6 = i4 + 1;
                                byte b4 = wVar.f13385a[i4];
                                int i7 = i5 + 1;
                                if (b4 == wVar2.f13385a[i5]) {
                                    j6++;
                                    i5 = i7;
                                    i4 = i6;
                                }
                            }
                            if (i4 == wVar.f13387c) {
                                w wVar3 = wVar.f13390f;
                                Intrinsics.checkNotNull(wVar3);
                                i4 = wVar3.f13386b;
                                wVar = wVar3;
                            }
                            if (i5 == wVar2.f13387c) {
                                wVar2 = wVar2.f13390f;
                                Intrinsics.checkNotNull(wVar2);
                                i5 = wVar2.f13386b;
                            }
                            j5 += jMin;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // k3.InterfaceC0696k, k3.InterfaceC0695j
    public final C0694i f() {
        return this;
    }

    @Override // k3.InterfaceC0695j, k3.z, java.io.Flushable
    public final void flush() {
    }

    @Override // k3.InterfaceC0695j
    public final /* bridge */ /* synthetic */ InterfaceC0695j g(long j4) {
        X(j4);
        return this;
    }

    @Override // k3.InterfaceC0696k
    public final l h() {
        return i(this.f13357b);
    }

    public final int hashCode() {
        w wVar = this.f13356a;
        if (wVar == null) {
            return 0;
        }
        int i4 = 1;
        do {
            int i5 = wVar.f13387c;
            for (int i6 = wVar.f13386b; i6 < i5; i6++) {
                i4 = (i4 * 31) + wVar.f13385a[i6];
            }
            wVar = wVar.f13390f;
            Intrinsics.checkNotNull(wVar);
        } while (wVar != this.f13356a);
        return i4;
    }

    @Override // k3.InterfaceC0696k
    public final l i(long j4) throws EOFException {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(AbstractC0351g.n("byteCount: ", j4).toString());
        }
        if (this.f13357b < j4) {
            throw new EOFException();
        }
        if (j4 < 4096) {
            return new l(D(j4));
        }
        l lVarQ = Q((int) j4);
        j(j4);
        return lVarQ;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // k3.InterfaceC0696k
    public final void j(long j4) throws EOFException {
        while (j4 > 0) {
            w wVar = this.f13356a;
            if (wVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j4, wVar.f13387c - wVar.f13386b);
            long j5 = iMin;
            this.f13357b -= j5;
            j4 -= j5;
            int i4 = wVar.f13386b + iMin;
            wVar.f13386b = i4;
            if (i4 == wVar.f13387c) {
                this.f13356a = wVar.a();
                x.a(wVar);
            }
        }
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j k() {
        return this;
    }

    public final byte l(long j4) {
        AbstractC0685G.b(this.f13357b, j4, 1L);
        w wVar = this.f13356a;
        if (wVar == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        }
        long j5 = this.f13357b;
        if (j5 - j4 < j4) {
            while (j5 > j4) {
                wVar = wVar.f13391g;
                Intrinsics.checkNotNull(wVar);
                j5 -= wVar.f13387c - wVar.f13386b;
            }
            Intrinsics.checkNotNull(wVar);
            return wVar.f13385a[(int) ((wVar.f13386b + j4) - j5)];
        }
        long j6 = 0;
        while (true) {
            long j7 = (wVar.f13387c - wVar.f13386b) + j6;
            if (j7 > j4) {
                Intrinsics.checkNotNull(wVar);
                return wVar.f13385a[(int) ((wVar.f13386b + j4) - j6)];
            }
            wVar = wVar.f13390f;
            Intrinsics.checkNotNull(wVar);
            j6 = j7;
        }
    }

    public final long m(byte b4, long j4, long j5) {
        w wVar;
        long j6 = j4;
        long j7 = j5;
        long j8 = 0;
        if (0 > j6 || j6 > j7) {
            throw new IllegalArgumentException(("size=" + this.f13357b + " fromIndex=" + j6 + " toIndex=" + j7).toString());
        }
        long j9 = this.f13357b;
        if (j7 > j9) {
            j7 = j9;
        }
        if (j6 != j7 && (wVar = this.f13356a) != null) {
            if (j9 - j6 < j6) {
                while (j9 > j6) {
                    wVar = wVar.f13391g;
                    Intrinsics.checkNotNull(wVar);
                    j9 -= wVar.f13387c - wVar.f13386b;
                }
                while (j9 < j7) {
                    byte[] bArr = wVar.f13385a;
                    int iMin = (int) Math.min(wVar.f13387c, (wVar.f13386b + j7) - j9);
                    for (int i4 = (int) ((wVar.f13386b + j6) - j9); i4 < iMin; i4++) {
                        if (bArr[i4] == b4) {
                            return (i4 - wVar.f13386b) + j9;
                        }
                    }
                    j9 += wVar.f13387c - wVar.f13386b;
                    wVar = wVar.f13390f;
                    Intrinsics.checkNotNull(wVar);
                    j6 = j9;
                }
            } else {
                while (true) {
                    long j10 = (wVar.f13387c - wVar.f13386b) + j8;
                    if (j10 > j6) {
                        break;
                    }
                    wVar = wVar.f13390f;
                    Intrinsics.checkNotNull(wVar);
                    j8 = j10;
                }
                while (j8 < j7) {
                    byte[] bArr2 = wVar.f13385a;
                    int iMin2 = (int) Math.min(wVar.f13387c, (wVar.f13386b + j7) - j8);
                    for (int i5 = (int) ((wVar.f13386b + j6) - j8); i5 < iMin2; i5++) {
                        if (bArr2[i5] == b4) {
                            return (i5 - wVar.f13386b) + j8;
                        }
                    }
                    j8 += wVar.f13387c - wVar.f13386b;
                    wVar = wVar.f13390f;
                    Intrinsics.checkNotNull(wVar);
                    j6 = j8;
                }
            }
        }
        return -1L;
    }

    @Override // k3.InterfaceC0696k
    public final String n() {
        return y(LongCompanionObject.MAX_VALUE);
    }

    @Override // k3.InterfaceC0696k
    public final byte[] o() {
        return D(this.f13357b);
    }

    @Override // k3.InterfaceC0695j
    public final /* bridge */ /* synthetic */ InterfaceC0695j p(int i4) {
        a0(i4);
        return this;
    }

    @Override // k3.InterfaceC0695j
    public final /* bridge */ /* synthetic */ InterfaceC0695j q(int i4) {
        Y(i4);
        return this;
    }

    @Override // k3.InterfaceC0695j
    public final /* bridge */ /* synthetic */ InterfaceC0695j r(l lVar) {
        T(lVar);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        w wVar = this.f13356a;
        if (wVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), wVar.f13387c - wVar.f13386b);
        sink.put(wVar.f13385a, wVar.f13386b, iMin);
        int i4 = wVar.f13386b + iMin;
        wVar.f13386b = i4;
        this.f13357b -= iMin;
        if (i4 == wVar.f13387c) {
            this.f13356a = wVar.a();
            x.a(wVar);
        }
        return iMin;
    }

    @Override // k3.InterfaceC0696k
    public final byte readByte() {
        if (this.f13357b == 0) {
            throw new EOFException();
        }
        w wVar = this.f13356a;
        Intrinsics.checkNotNull(wVar);
        int i4 = wVar.f13386b;
        int i5 = wVar.f13387c;
        int i6 = i4 + 1;
        byte b4 = wVar.f13385a[i4];
        this.f13357b--;
        if (i6 == i5) {
            this.f13356a = wVar.a();
            x.a(wVar);
        } else {
            wVar.f13386b = i6;
        }
        return b4;
    }

    @Override // k3.InterfaceC0696k
    public final void readFully(byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i4 = 0;
        while (i4 < sink.length) {
            int iW = w(sink, i4, sink.length - i4);
            if (iW == -1) {
                throw new EOFException();
            }
            i4 += iW;
        }
    }

    @Override // k3.InterfaceC0696k
    public final int readInt() throws EOFException {
        if (this.f13357b < 4) {
            throw new EOFException();
        }
        w wVar = this.f13356a;
        Intrinsics.checkNotNull(wVar);
        int i4 = wVar.f13386b;
        int i5 = wVar.f13387c;
        if (i5 - i4 < 4) {
            return (readByte() & UByte.MAX_VALUE) | ((readByte() & UByte.MAX_VALUE) << 24) | ((readByte() & UByte.MAX_VALUE) << 16) | ((readByte() & UByte.MAX_VALUE) << 8);
        }
        byte[] bArr = wVar.f13385a;
        int i6 = i4 + 3;
        int i7 = ((bArr[i4 + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i4] & UByte.MAX_VALUE) << 24) | ((bArr[i4 + 2] & UByte.MAX_VALUE) << 8);
        int i8 = i4 + 4;
        int i9 = i7 | (bArr[i6] & UByte.MAX_VALUE);
        this.f13357b -= 4;
        if (i8 == i5) {
            this.f13356a = wVar.a();
            x.a(wVar);
        } else {
            wVar.f13386b = i8;
        }
        return i9;
    }

    @Override // k3.InterfaceC0696k
    public final long readLong() throws EOFException {
        if (this.f13357b < 8) {
            throw new EOFException();
        }
        w wVar = this.f13356a;
        Intrinsics.checkNotNull(wVar);
        int i4 = wVar.f13386b;
        int i5 = wVar.f13387c;
        if (i5 - i4 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = wVar.f13385a;
        int i6 = i4 + 7;
        long j4 = ((bArr[i4 + 3] & 255) << 32) | ((bArr[i4] & 255) << 56) | ((bArr[i4 + 1] & 255) << 48) | ((bArr[i4 + 2] & 255) << 40) | ((bArr[i4 + 4] & 255) << 24) | ((bArr[i4 + 5] & 255) << 16) | ((bArr[i4 + 6] & 255) << 8);
        int i7 = i4 + 8;
        long j5 = j4 | (bArr[i6] & 255);
        this.f13357b -= 8;
        if (i7 == i5) {
            this.f13356a = wVar.a();
            x.a(wVar);
        } else {
            wVar.f13386b = i7;
        }
        return j5;
    }

    @Override // k3.InterfaceC0696k
    public final short readShort() throws EOFException {
        if (this.f13357b < 2) {
            throw new EOFException();
        }
        w wVar = this.f13356a;
        Intrinsics.checkNotNull(wVar);
        int i4 = wVar.f13386b;
        int i5 = wVar.f13387c;
        if (i5 - i4 < 2) {
            return (short) ((readByte() & UByte.MAX_VALUE) | ((readByte() & UByte.MAX_VALUE) << 8));
        }
        int i6 = i4 + 1;
        byte[] bArr = wVar.f13385a;
        int i7 = (bArr[i4] & UByte.MAX_VALUE) << 8;
        int i8 = i4 + 2;
        int i9 = (bArr[i6] & UByte.MAX_VALUE) | i7;
        this.f13357b -= 2;
        if (i8 == i5) {
            this.f13356a = wVar.a();
            x.a(wVar);
        } else {
            wVar.f13386b = i8;
        }
        return (short) i9;
    }

    @Override // k3.InterfaceC0696k
    public final boolean s() {
        return this.f13357b == 0;
    }

    @Override // k3.InterfaceC0695j
    public final /* bridge */ /* synthetic */ InterfaceC0695j t(int i4) {
        V(i4);
        return this;
    }

    @Override // k3.InterfaceC0680B
    public final C0683E timeout() {
        return C0683E.NONE;
    }

    public final String toString() {
        long j4 = this.f13357b;
        if (j4 <= 2147483647L) {
            return Q((int) j4).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f13357b).toString());
    }

    public final long u(l targetBytes) {
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        w wVar = this.f13356a;
        if (wVar == null) {
            return -1L;
        }
        long j4 = this.f13357b;
        long j5 = 0;
        if (j4 < 0) {
            while (j4 > 0) {
                wVar = wVar.f13391g;
                Intrinsics.checkNotNull(wVar);
                j4 -= wVar.f13387c - wVar.f13386b;
            }
            if (targetBytes.c() == 2) {
                byte bF = targetBytes.f(0);
                byte bF2 = targetBytes.f(1);
                while (j4 < this.f13357b) {
                    byte[] bArr = wVar.f13385a;
                    i4 = (int) ((wVar.f13386b + j5) - j4);
                    int i6 = wVar.f13387c;
                    while (i4 < i6) {
                        byte b4 = bArr[i4];
                        if (b4 == bF || b4 == bF2) {
                            i5 = wVar.f13386b;
                        } else {
                            i4++;
                        }
                    }
                    j5 = (wVar.f13387c - wVar.f13386b) + j4;
                    wVar = wVar.f13390f;
                    Intrinsics.checkNotNull(wVar);
                    j4 = j5;
                }
                return -1L;
            }
            byte[] bArrE = targetBytes.e();
            while (j4 < this.f13357b) {
                byte[] bArr2 = wVar.f13385a;
                i4 = (int) ((wVar.f13386b + j5) - j4);
                int i7 = wVar.f13387c;
                while (i4 < i7) {
                    byte b5 = bArr2[i4];
                    for (byte b6 : bArrE) {
                        if (b5 == b6) {
                            i5 = wVar.f13386b;
                        }
                    }
                    i4++;
                }
                j5 = (wVar.f13387c - wVar.f13386b) + j4;
                wVar = wVar.f13390f;
                Intrinsics.checkNotNull(wVar);
                j4 = j5;
            }
            return -1L;
        }
        j4 = 0;
        while (true) {
            long j6 = (wVar.f13387c - wVar.f13386b) + j4;
            if (j6 > 0) {
                break;
            }
            wVar = wVar.f13390f;
            Intrinsics.checkNotNull(wVar);
            j4 = j6;
        }
        if (targetBytes.c() == 2) {
            byte bF3 = targetBytes.f(0);
            byte bF4 = targetBytes.f(1);
            while (j4 < this.f13357b) {
                byte[] bArr3 = wVar.f13385a;
                i4 = (int) ((wVar.f13386b + j5) - j4);
                int i8 = wVar.f13387c;
                while (i4 < i8) {
                    byte b7 = bArr3[i4];
                    if (b7 == bF3 || b7 == bF4) {
                        i5 = wVar.f13386b;
                    } else {
                        i4++;
                    }
                }
                j5 = (wVar.f13387c - wVar.f13386b) + j4;
                wVar = wVar.f13390f;
                Intrinsics.checkNotNull(wVar);
                j4 = j5;
            }
            return -1L;
        }
        byte[] bArrE2 = targetBytes.e();
        while (j4 < this.f13357b) {
            byte[] bArr4 = wVar.f13385a;
            i4 = (int) ((wVar.f13386b + j5) - j4);
            int i9 = wVar.f13387c;
            while (i4 < i9) {
                byte b8 = bArr4[i4];
                for (byte b9 : bArrE2) {
                    if (b8 == b9) {
                        i5 = wVar.f13386b;
                    }
                }
                i4++;
            }
            j5 = (wVar.f13387c - wVar.f13386b) + j4;
            wVar = wVar.f13390f;
            Intrinsics.checkNotNull(wVar);
            j4 = j5;
        }
        return -1L;
        return (i4 - i5) + j4;
    }

    @Override // k3.InterfaceC0695j
    public final /* bridge */ /* synthetic */ InterfaceC0695j v(byte[] bArr) {
        U(bArr);
        return this;
    }

    public final int w(byte[] sink, int i4, int i5) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        AbstractC0685G.b(sink.length, i4, i5);
        w wVar = this.f13356a;
        if (wVar == null) {
            return -1;
        }
        int iMin = Math.min(i5, wVar.f13387c - wVar.f13386b);
        int i6 = wVar.f13386b;
        ArraysKt.copyInto(wVar.f13385a, sink, i4, i6, i6 + iMin);
        int i7 = wVar.f13386b + iMin;
        wVar.f13386b = i7;
        this.f13357b -= iMin;
        if (i7 == wVar.f13387c) {
            this.f13356a = wVar.a();
            x.a(wVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        int i4 = iRemaining;
        while (i4 > 0) {
            w wVarR = R(1);
            int iMin = Math.min(i4, 8192 - wVarR.f13387c);
            source.get(wVarR.f13385a, wVarR.f13387c, iMin);
            i4 -= iMin;
            wVarR.f13387c += iMin;
        }
        this.f13357b += iRemaining;
        return iRemaining;
    }

    @Override // k3.InterfaceC0695j
    public final InterfaceC0695j x() {
        return this;
    }

    @Override // k3.InterfaceC0696k
    public final String y(long j4) throws EOFException {
        if (j4 < 0) {
            throw new IllegalArgumentException(AbstractC0351g.n("limit < 0: ", j4).toString());
        }
        long j5 = LongCompanionObject.MAX_VALUE;
        if (j4 != LongCompanionObject.MAX_VALUE) {
            j5 = j4 + 1;
        }
        byte b4 = (byte) 10;
        long jM = m(b4, 0L, j5);
        if (jM != -1) {
            return AbstractC0765a.a(this, jM);
        }
        if (j5 < this.f13357b && l(j5 - 1) == ((byte) 13) && l(j5) == b4) {
            return AbstractC0765a.a(this, j5);
        }
        C0694i c0694i = new C0694i();
        e(0L, c0694i, Math.min(32, this.f13357b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f13357b, j4) + " content=" + c0694i.i(c0694i.f13357b).d() + Typography.ellipsis);
    }

    @Override // k3.InterfaceC0696k
    public final int z(t options) throws EOFException {
        Intrinsics.checkNotNullParameter(options, "options");
        int iB = AbstractC0765a.b(this, options, false);
        if (iB == -1) {
            return -1;
        }
        j(options.f13377a[iB].c());
        return iB;
    }

    @Override // k3.z
    public final void write(C0694i source, long j4) {
        w wVar;
        w wVarB;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source != this) {
            AbstractC0685G.b(source.f13357b, 0L, j4);
            while (j4 > 0) {
                w wVar2 = source.f13356a;
                Intrinsics.checkNotNull(wVar2);
                int i4 = wVar2.f13387c;
                w wVar3 = source.f13356a;
                Intrinsics.checkNotNull(wVar3);
                long j5 = i4 - wVar3.f13386b;
                int i5 = 0;
                if (j4 < j5) {
                    w wVar4 = this.f13356a;
                    if (wVar4 != null) {
                        Intrinsics.checkNotNull(wVar4);
                        wVar = wVar4.f13391g;
                    } else {
                        wVar = null;
                    }
                    if (wVar != null && wVar.f13389e) {
                        if ((wVar.f13387c + j4) - (wVar.f13388d ? 0 : wVar.f13386b) <= 8192) {
                            w wVar5 = source.f13356a;
                            Intrinsics.checkNotNull(wVar5);
                            wVar5.d(wVar, (int) j4);
                            source.f13357b -= j4;
                            this.f13357b += j4;
                            return;
                        }
                    }
                    w wVar6 = source.f13356a;
                    Intrinsics.checkNotNull(wVar6);
                    int i6 = (int) j4;
                    if (i6 <= 0) {
                        wVar6.getClass();
                    } else if (i6 <= wVar6.f13387c - wVar6.f13386b) {
                        if (i6 >= 1024) {
                            wVarB = wVar6.c();
                        } else {
                            wVarB = x.b();
                            int i7 = wVar6.f13386b;
                            ArraysKt___ArraysJvmKt.copyInto$default(wVar6.f13385a, wVarB.f13385a, 0, i7, i7 + i6, 2, (Object) null);
                        }
                        wVarB.f13387c = wVarB.f13386b + i6;
                        wVar6.f13386b += i6;
                        w wVar7 = wVar6.f13391g;
                        Intrinsics.checkNotNull(wVar7);
                        wVar7.b(wVarB);
                        source.f13356a = wVarB;
                    }
                    throw new IllegalArgumentException("byteCount out of range".toString());
                }
                w wVar8 = source.f13356a;
                Intrinsics.checkNotNull(wVar8);
                long j6 = wVar8.f13387c - wVar8.f13386b;
                source.f13356a = wVar8.a();
                w wVar9 = this.f13356a;
                if (wVar9 == null) {
                    this.f13356a = wVar8;
                    wVar8.f13391g = wVar8;
                    wVar8.f13390f = wVar8;
                } else {
                    Intrinsics.checkNotNull(wVar9);
                    w wVar10 = wVar9.f13391g;
                    Intrinsics.checkNotNull(wVar10);
                    wVar10.b(wVar8);
                    w wVar11 = wVar8.f13391g;
                    if (wVar11 != wVar8) {
                        Intrinsics.checkNotNull(wVar11);
                        if (wVar11.f13389e) {
                            int i8 = wVar8.f13387c - wVar8.f13386b;
                            w wVar12 = wVar8.f13391g;
                            Intrinsics.checkNotNull(wVar12);
                            int i9 = 8192 - wVar12.f13387c;
                            w wVar13 = wVar8.f13391g;
                            Intrinsics.checkNotNull(wVar13);
                            if (!wVar13.f13388d) {
                                w wVar14 = wVar8.f13391g;
                                Intrinsics.checkNotNull(wVar14);
                                i5 = wVar14.f13386b;
                            }
                            if (i8 <= i9 + i5) {
                                w wVar15 = wVar8.f13391g;
                                Intrinsics.checkNotNull(wVar15);
                                wVar8.d(wVar15, i8);
                                wVar8.a();
                                x.a(wVar8);
                            }
                        }
                    } else {
                        throw new IllegalStateException("cannot compact".toString());
                    }
                }
                source.f13357b -= j6;
                this.f13357b += j6;
                j4 -= j6;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    @Override // k3.InterfaceC0680B
    public final long read(C0694i sink, long j4) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j4 >= 0) {
            long j5 = this.f13357b;
            if (j5 == 0) {
                return -1L;
            }
            if (j4 > j5) {
                j4 = j5;
            }
            sink.write(this, j4);
            return j4;
        }
        throw new IllegalArgumentException(AbstractC0351g.n("byteCount < 0: ", j4).toString());
    }
}
