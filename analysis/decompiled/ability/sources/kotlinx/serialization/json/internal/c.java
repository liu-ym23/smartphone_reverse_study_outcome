package kotlinx.serialization.json.internal;

import C9.AbstractC0200b;
import C9.i;
import C9.j;
import C9.l;
import D9.s;
import D9.t;
import E9.e;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import x9.InterfaceC2123a;
import z9.g;

/* loaded from: classes4.dex */
public final class c extends A9.a implements j {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0200b f5269a;
    public final WriteMode b;
    public final t c;
    public final e d;
    public int e;
    public Q.a f;
    public final i g;
    public final a h;

    public c(AbstractC0200b abstractC0200b, WriteMode writeMode, t tVar, g descriptor, Q.a aVar) {
        k.f(descriptor, "descriptor");
        this.f5269a = abstractC0200b;
        this.b = writeMode;
        this.c = tVar;
        this.d = abstractC0200b.b;
        this.e = -1;
        this.f = aVar;
        i iVar = abstractC0200b.f321a;
        this.g = iVar;
        this.h = iVar.e ? null : new a(descriptor);
    }

    @Override // C9.j
    public final l a() {
        return new b(this.f5269a.f321a, this.c).b();
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Serializable, java.lang.Object, java.lang.Object[]] */
    @Override // A9.a, A9.e
    public final A9.c beginStructure(g descriptor) {
        k.f(descriptor, "descriptor");
        AbstractC0200b abstractC0200b = this.f5269a;
        WriteMode writeModeP = D9.j.p(abstractC0200b, descriptor);
        t tVar = this.c;
        D9.l lVar = (D9.l) tVar.d;
        int i = lVar.b + 1;
        lVar.b = i;
        Object[] objArr = (Object[]) lVar.c;
        if (i == objArr.length) {
            int i6 = i * 2;
            ?? CopyOf = Arrays.copyOf(objArr, i6);
            k.e(CopyOf, "copyOf(...)");
            lVar.c = CopyOf;
            int[] iArrCopyOf = Arrays.copyOf((int[]) lVar.d, i6);
            k.e(iArrCopyOf, "copyOf(...)");
            lVar.d = iArrCopyOf;
        }
        ((Object[]) lVar.c)[i] = descriptor;
        tVar.h(writeModeP.f5266a);
        if (tVar.r() != 4) {
            int iOrdinal = writeModeP.ordinal();
            return (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) ? new c(abstractC0200b, writeModeP, tVar, descriptor, this.f) : (this.b == writeModeP && abstractC0200b.f321a.e) ? this : new c(abstractC0200b, writeModeP, tVar, descriptor, this.f);
        }
        t.o(tVar, "Unexpected leading comma", 0, null, 6);
        throw null;
    }

    @Override // A9.a, A9.e
    public final boolean decodeBoolean() {
        boolean z10;
        boolean z11;
        t tVar = this.c;
        int iU = tVar.u();
        String str = (String) tVar.e;
        if (iU == str.length()) {
            t.o(tVar, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(iU) == '\"') {
            iU++;
            z10 = true;
        } else {
            z10 = false;
        }
        int iT = tVar.t(iU);
        if (iT >= str.length() || iT == -1) {
            t.o(tVar, "EOF", 0, null, 6);
            throw null;
        }
        int i = iT + 1;
        int iCharAt = str.charAt(iT) | ' ';
        if (iCharAt == 102) {
            tVar.d(i, "alse");
            z11 = false;
        } else {
            if (iCharAt != 116) {
                t.o(tVar, "Expected valid boolean literal prefix, but had '" + tVar.k() + '\'', 0, null, 6);
                throw null;
            }
            tVar.d(i, "rue");
            z11 = true;
        }
        if (!z10) {
            return z11;
        }
        if (tVar.c == str.length()) {
            t.o(tVar, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(tVar.c) == '\"') {
            tVar.c++;
            return z11;
        }
        t.o(tVar, "Expected closing quotation mark", 0, null, 6);
        throw null;
    }

    @Override // A9.a, A9.e
    public final byte decodeByte() {
        t tVar = this.c;
        long jI = tVar.i();
        byte b = (byte) jI;
        if (jI == b) {
            return b;
        }
        t.o(tVar, "Failed to parse byte for input '" + jI + '\'', 0, null, 6);
        throw null;
    }

    @Override // A9.a, A9.e
    public final char decodeChar() {
        t tVar = this.c;
        String strK = tVar.k();
        if (strK.length() == 1) {
            return strK.charAt(0);
        }
        t.o(tVar, androidx.compose.foundation.b.m('\'', "Expected single char, but got '", strK), 0, null, 6);
        throw null;
    }

    @Override // A9.a, A9.e
    public final double decodeDouble() throws NumberFormatException {
        t tVar = this.c;
        String strK = tVar.k();
        try {
            double d = Double.parseDouble(strK);
            if (!Double.isInfinite(d) && !Double.isNaN(d)) {
                return d;
            }
            D9.j.q(tVar, Double.valueOf(d));
            throw null;
        } catch (IllegalArgumentException unused) {
            t.o(tVar, androidx.compose.foundation.b.m('\'', "Failed to parse type 'double' for input '", strK), 0, null, 6);
            throw null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x012b, code lost:
    
        if (r8 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x012d, code lost:
    
        r0 = r8.f5267a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0131, code lost:
    
        if (r13 >= 64) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0133, code lost:
    
        r0.c |= 1 << r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x013a, code lost:
    
        r12 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x013d, code lost:
    
        r1 = (r13 >>> 6) - 1;
        r0 = r0.d;
        r0[r1] = r0[r1] | (1 << (r13 & 63));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // A9.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int decodeElementIndex(z9.g r23) throws java.lang.IllegalStateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 775
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.c.decodeElementIndex(z9.g):int");
    }

    @Override // A9.a, A9.e
    public final int decodeEnum(g enumDescriptor) {
        k.f(enumDescriptor, "enumDescriptor");
        return D9.j.j(enumDescriptor, this.f5269a, decodeString(), " at path " + ((D9.l) this.c.d).b());
    }

    @Override // A9.a, A9.e
    public final float decodeFloat() throws NumberFormatException {
        t tVar = this.c;
        String strK = tVar.k();
        try {
            float f = Float.parseFloat(strK);
            if (!Float.isInfinite(f) && !Float.isNaN(f)) {
                return f;
            }
            D9.j.q(tVar, Float.valueOf(f));
            throw null;
        } catch (IllegalArgumentException unused) {
            t.o(tVar, androidx.compose.foundation.b.m('\'', "Failed to parse type 'float' for input '", strK), 0, null, 6);
            throw null;
        }
    }

    @Override // A9.a, A9.e
    public final A9.e decodeInline(g descriptor) {
        k.f(descriptor, "descriptor");
        return s.a(descriptor) ? new D9.i(this.c, this.f5269a) : super.decodeInline(descriptor);
    }

    @Override // A9.a, A9.e
    public final int decodeInt() {
        t tVar = this.c;
        long jI = tVar.i();
        int i = (int) jI;
        if (jI == i) {
            return i;
        }
        t.o(tVar, "Failed to parse int for input '" + jI + '\'', 0, null, 6);
        throw null;
    }

    @Override // A9.a, A9.e
    public final long decodeLong() {
        return this.c.i();
    }

    @Override // A9.a, A9.e
    public final boolean decodeNotNullMark() {
        a aVar = this.h;
        return ((aVar != null ? aVar.b : false) || this.c.w(true)) ? false : true;
    }

    @Override // A9.a, A9.e
    public final Void decodeNull() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.Serializable, java.lang.Object, java.lang.Object[]] */
    @Override // A9.a, A9.c
    public final Object decodeSerializableElement(g descriptor, int i, InterfaceC2123a deserializer, Object obj) {
        D9.l lVar = (D9.l) this.c.d;
        k.f(descriptor, "descriptor");
        k.f(deserializer, "deserializer");
        boolean z10 = this.b == WriteMode.e && (i & 1) == 0;
        if (z10) {
            int[] iArr = (int[]) lVar.d;
            int i6 = lVar.b;
            if (iArr[i6] == -2) {
                ((Object[]) lVar.c)[i6] = D9.k.f441a;
            }
        }
        Object objDecodeSerializableElement = super.decodeSerializableElement(descriptor, i, deserializer, obj);
        if (z10) {
            int[] iArr2 = (int[]) lVar.d;
            int i10 = lVar.b;
            if (iArr2[i10] != -2) {
                int i11 = i10 + 1;
                lVar.b = i11;
                Object[] objArr = (Object[]) lVar.c;
                if (i11 == objArr.length) {
                    int i12 = i11 * 2;
                    ?? CopyOf = Arrays.copyOf(objArr, i12);
                    k.e(CopyOf, "copyOf(...)");
                    lVar.c = CopyOf;
                    int[] iArrCopyOf = Arrays.copyOf((int[]) lVar.d, i12);
                    k.e(iArrCopyOf, "copyOf(...)");
                    lVar.d = iArrCopyOf;
                }
            }
            Object[] objArr2 = (Object[]) lVar.c;
            int i13 = lVar.b;
            objArr2[i13] = objDecodeSerializableElement;
            ((int[]) lVar.d)[i13] = -2;
        }
        return objDecodeSerializableElement;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014d  */
    @Override // A9.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object decodeSerializableValue(x9.InterfaceC2123a r11) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.c.decodeSerializableValue(x9.a):java.lang.Object");
    }

    @Override // A9.a, A9.e
    public final short decodeShort() {
        t tVar = this.c;
        long jI = tVar.i();
        short s5 = (short) jI;
        if (jI == s5) {
            return s5;
        }
        t.o(tVar, "Failed to parse short for input '" + jI + '\'', 0, null, 6);
        throw null;
    }

    @Override // A9.a, A9.e
    public final String decodeString() {
        boolean z10 = this.g.c;
        t tVar = this.c;
        return z10 ? tVar.l() : tVar.j();
    }

    @Override // A9.a, A9.c
    public final void endStructure(g descriptor) {
        k.f(descriptor, "descriptor");
        if (descriptor.d() == 0 && D9.j.k(this.f5269a, descriptor)) {
            while (decodeElementIndex(descriptor) != -1) {
            }
        }
        t tVar = this.c;
        if (tVar.v()) {
            D9.j.l(tVar, "");
            throw null;
        }
        tVar.h(this.b.b);
        D9.l lVar = (D9.l) tVar.d;
        int i = lVar.b;
        int[] iArr = (int[]) lVar.d;
        if (iArr[i] == -2) {
            iArr[i] = -1;
            lVar.b = i - 1;
        }
        int i6 = lVar.b;
        if (i6 != -1) {
            lVar.b = i6 - 1;
        }
    }

    @Override // A9.c
    public final e getSerializersModule() {
        return this.d;
    }
}
