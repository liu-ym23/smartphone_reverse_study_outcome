package kotlinx.serialization.json.internal;

import gc.q;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import kotlinx.serialization.MissingFieldException;
import mb.y;
import sc.d;
import uc.e;
import uc.f;
import vc.i;
import vc.l;
import vc.m;
import vc.o;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends sc.a implements f {

    /* renamed from: a, reason: collision with root package name */
    public final uc.a f10146a;

    /* renamed from: b, reason: collision with root package name */
    public final WriteMode f10147b;

    /* renamed from: c, reason: collision with root package name */
    public final m f10148c;

    /* renamed from: d, reason: collision with root package name */
    public int f10149d;

    /* renamed from: e, reason: collision with root package name */
    public final e f10150e;

    /* renamed from: f, reason: collision with root package name */
    public final JsonElementMarker f10151f;

    public b(uc.a aVar, WriteMode writeMode, m mVar, rc.e descriptor) {
        g.f(descriptor, "descriptor");
        this.f10146a = aVar;
        this.f10147b = writeMode;
        this.f10148c = mVar;
        androidx.datastore.preferences.protobuf.f fVar = aVar.f13195b;
        this.f10149d = -1;
        e eVar = aVar.f13194a;
        this.f10150e = eVar;
        this.f10151f = eVar.f13205c ? null : new JsonElementMarker(descriptor);
    }

    @Override // sc.a, sc.d
    public final byte A() {
        m mVar = this.f10148c;
        long jH = mVar.h();
        byte b10 = (byte) jH;
        if (jH == b10) {
            return b10;
        }
        m.n(mVar, "Failed to parse byte for input '" + jH + '\'', 0, 6);
        throw null;
    }

    @Override // sc.a, sc.b
    public final void a(rc.e descriptor) {
        g.f(descriptor, "descriptor");
        if (this.f10146a.f13194a.f13203a && descriptor.e() == 0) {
            while (f(descriptor) != -1) {
            }
        }
        m mVar = this.f10148c;
        if (mVar.u()) {
            y.D(mVar, "");
            throw null;
        }
        mVar.g(this.f10147b.f10142b);
        i iVar = mVar.f13516b;
        int i10 = iVar.f13503c;
        int[] iArr = iVar.f13502b;
        if (iArr[i10] == -2) {
            iArr[i10] = -1;
            iVar.f13503c = i10 - 1;
        }
        int i11 = iVar.f13503c;
        if (i11 != -1) {
            iVar.f13503c = i11 - 1;
        }
    }

    @Override // sc.a, sc.d
    public final sc.b b(rc.e descriptor) {
        g.f(descriptor, "descriptor");
        uc.a aVar = this.f10146a;
        WriteMode writeModeB = o.b(descriptor, aVar);
        m mVar = this.f10148c;
        i iVar = mVar.f13516b;
        int i10 = iVar.f13503c + 1;
        iVar.f13503c = i10;
        Object[] objArr = iVar.f13501a;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i11);
            g.e(objArrCopyOf, "copyOf(...)");
            iVar.f13501a = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(iVar.f13502b, i11);
            g.e(iArrCopyOf, "copyOf(...)");
            iVar.f13502b = iArrCopyOf;
        }
        iVar.f13501a[i10] = descriptor;
        mVar.g(writeModeB.f10141a);
        if (mVar.r() != 4) {
            int iOrdinal = writeModeB.ordinal();
            return (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) ? new b(aVar, writeModeB, mVar, descriptor) : (this.f10147b == writeModeB && aVar.f13194a.f13205c) ? this : new b(aVar, writeModeB, mVar, descriptor);
        }
        m.n(mVar, "Unexpected leading comma", 0, 6);
        throw null;
    }

    @Override // sc.a, sc.b
    public final <T> T c(rc.e descriptor, int i10, pc.a deserializer, T t8) {
        i iVar = this.f10148c.f13516b;
        g.f(descriptor, "descriptor");
        g.f(deserializer, "deserializer");
        boolean z = this.f10147b == WriteMode.f10138e && (i10 & 1) == 0;
        if (z) {
            int[] iArr = iVar.f13502b;
            int i11 = iVar.f13503c;
            if (iArr[i11] == -2) {
                iVar.f13501a[i11] = i.a.f13504a;
            }
        }
        T t10 = (T) super.c(descriptor, i10, deserializer, t8);
        if (z) {
            int[] iArr2 = iVar.f13502b;
            int i12 = iVar.f13503c;
            if (iArr2[i12] != -2) {
                int i13 = i12 + 1;
                iVar.f13503c = i13;
                Object[] objArr = iVar.f13501a;
                if (i13 == objArr.length) {
                    int i14 = i13 * 2;
                    Object[] objArrCopyOf = Arrays.copyOf(objArr, i14);
                    g.e(objArrCopyOf, "copyOf(...)");
                    iVar.f13501a = objArrCopyOf;
                    int[] iArrCopyOf = Arrays.copyOf(iVar.f13502b, i14);
                    g.e(iArrCopyOf, "copyOf(...)");
                    iVar.f13502b = iArrCopyOf;
                }
            }
            Object[] objArr2 = iVar.f13501a;
            int i15 = iVar.f13503c;
            objArr2[i15] = t10;
            iVar.f13502b[i15] = -2;
        }
        return t10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0139, code lost:
    
        r0 = r8.f10125a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x013d, code lost:
    
        if (r15 >= 64) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x013f, code lost:
    
        r0.f13053c |= 1 << r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0146, code lost:
    
        r12 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0149, code lost:
    
        r1 = (r15 >>> 6) - 1;
        r0 = r0.f13054d;
        r0[r1] = (1 << (r15 & 63)) | r0[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0137, code lost:
    
        if (r8 == null) goto L103;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    @Override // sc.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(rc.e r22) {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.b.f(rc.e):int");
    }

    @Override // uc.f
    public final uc.g g() {
        return new a(this.f10146a.f13194a, this.f10148c).b();
    }

    @Override // sc.a, sc.d
    public final int h() {
        m mVar = this.f10148c;
        long jH = mVar.h();
        int i10 = (int) jH;
        if (jH == i10) {
            return i10;
        }
        m.n(mVar, "Failed to parse int for input '" + jH + '\'', 0, 6);
        throw null;
    }

    @Override // sc.a, sc.d
    public final long j() {
        return this.f10148c.h();
    }

    @Override // sc.a, sc.d
    public final short l() {
        m mVar = this.f10148c;
        long jH = mVar.h();
        short s8 = (short) jH;
        if (jH == s8) {
            return s8;
        }
        m.n(mVar, "Failed to parse short for input '" + jH + '\'', 0, 6);
        throw null;
    }

    @Override // sc.a, sc.d
    public final float m() throws NumberFormatException {
        m mVar = this.f10148c;
        String strJ = mVar.j();
        try {
            float f8 = Float.parseFloat(strJ);
            if (!Float.isInfinite(f8) && !Float.isNaN(f8)) {
                return f8;
            }
            y.O(mVar, Float.valueOf(f8));
            throw null;
        } catch (IllegalArgumentException unused) {
            m.n(mVar, "Failed to parse type 'float' for input '" + strJ + '\'', 0, 6);
            throw null;
        }
    }

    @Override // sc.a, sc.d
    public final double n() throws NumberFormatException {
        m mVar = this.f10148c;
        String strJ = mVar.j();
        try {
            double d8 = Double.parseDouble(strJ);
            if (!Double.isInfinite(d8) && !Double.isNaN(d8)) {
                return d8;
            }
            y.O(mVar, Double.valueOf(d8));
            throw null;
        } catch (IllegalArgumentException unused) {
            m.n(mVar, "Failed to parse type 'double' for input '" + strJ + '\'', 0, 6);
            throw null;
        }
    }

    @Override // sc.a, sc.d
    public final boolean o() {
        boolean z;
        boolean z3;
        m mVar = this.f10148c;
        int iT = mVar.t();
        String str = mVar.f13519e;
        if (iT == str.length()) {
            m.n(mVar, "EOF", 0, 6);
            throw null;
        }
        if (str.charAt(iT) == '\"') {
            iT++;
            z = true;
        } else {
            z = false;
        }
        int iS = mVar.s(iT);
        if (iS >= str.length() || iS == -1) {
            m.n(mVar, "EOF", 0, 6);
            throw null;
        }
        int i10 = iS + 1;
        int iCharAt = str.charAt(iS) | ' ';
        if (iCharAt == 102) {
            mVar.c(i10, "alse");
            z3 = false;
        } else {
            if (iCharAt != 116) {
                m.n(mVar, "Expected valid boolean literal prefix, but had '" + mVar.j() + '\'', 0, 6);
                throw null;
            }
            mVar.c(i10, "rue");
            z3 = true;
        }
        if (!z) {
            return z3;
        }
        if (mVar.f13515a == str.length()) {
            m.n(mVar, "EOF", 0, 6);
            throw null;
        }
        if (str.charAt(mVar.f13515a) == '\"') {
            mVar.f13515a++;
            return z3;
        }
        m.n(mVar, "Expected closing quotation mark", 0, 6);
        throw null;
    }

    @Override // sc.a, sc.d
    public final char p() {
        m mVar = this.f10148c;
        String strJ = mVar.j();
        if (strJ.length() == 1) {
            return strJ.charAt(0);
        }
        m.n(mVar, "Expected single char, but got '" + strJ + '\'', 0, 6);
        throw null;
    }

    @Override // sc.a, sc.d
    public final d u(rc.e descriptor) {
        g.f(descriptor, "descriptor");
        return l.a(descriptor) ? new vc.g(this.f10148c, this.f10146a) : this;
    }

    @Override // sc.a, sc.d
    public final String v() {
        boolean z = this.f10150e.f13204b;
        m mVar = this.f10148c;
        return z ? mVar.k() : mVar.i();
    }

    @Override // sc.a, sc.d
    public final boolean x() {
        JsonElementMarker jsonElementMarker = this.f10151f;
        return ((jsonElementMarker != null ? jsonElementMarker.f10126b : false) || this.f10148c.v(true)) ? false : true;
    }

    @Override // sc.a, sc.d
    public final <T> T z(pc.a deserializer) {
        g.f(deserializer, "deserializer");
        try {
            if (!(deserializer instanceof tc.b)) {
                return (T) deserializer.b(this);
            }
            throw null;
        } catch (MissingFieldException e10) {
            String message = e10.getMessage();
            g.c(message);
            if (q.l0(message, "at path", false)) {
                throw e10;
            }
            throw new MissingFieldException(e10.f10121a, e10.getMessage() + " at path: " + this.f10148c.f13516b.a(), e10);
        }
    }
}
