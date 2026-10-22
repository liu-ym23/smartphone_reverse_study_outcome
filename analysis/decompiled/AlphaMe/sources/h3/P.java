package h3;

import java.io.EOFException;
import java.util.List;
import java.util.regex.Pattern;
import k3.C0694i;
import k3.InterfaceC0695j;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class P extends Z {

    /* renamed from: e, reason: collision with root package name */
    public static final M f12742e;

    /* renamed from: f, reason: collision with root package name */
    public static final M f12743f;

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f12744g;

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f12745h;

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f12746i;

    /* renamed from: a, reason: collision with root package name */
    public final k3.l f12747a;

    /* renamed from: b, reason: collision with root package name */
    public final List f12748b;

    /* renamed from: c, reason: collision with root package name */
    public final M f12749c;

    /* renamed from: d, reason: collision with root package name */
    public long f12750d;

    static {
        Pattern pattern = M.f12732d;
        f12742e = C0611u.o("multipart/mixed");
        C0611u.o("multipart/alternative");
        C0611u.o("multipart/digest");
        C0611u.o("multipart/parallel");
        f12743f = C0611u.o("multipart/form-data");
        f12744g = new byte[]{58, 32};
        f12745h = new byte[]{13, 10};
        f12746i = new byte[]{45, 45};
    }

    public P(k3.l boundaryByteString, M type, List parts) {
        Intrinsics.checkNotNullParameter(boundaryByteString, "boundaryByteString");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(parts, "parts");
        this.f12747a = boundaryByteString;
        this.f12748b = parts;
        Pattern pattern = M.f12732d;
        this.f12749c = C0611u.o(type + "; boundary=" + boundaryByteString.j());
        this.f12750d = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long a(InterfaceC0695j interfaceC0695j, boolean z4) throws EOFException {
        C0694i c0694i;
        InterfaceC0695j c0694i2;
        if (z4) {
            c0694i2 = new C0694i();
            c0694i = c0694i2;
        } else {
            c0694i = 0;
            c0694i2 = interfaceC0695j;
        }
        List list = this.f12748b;
        int size = list.size();
        long j4 = 0;
        int i4 = 0;
        while (true) {
            k3.l lVar = this.f12747a;
            byte[] bArr = f12746i;
            byte[] bArr2 = f12745h;
            if (i4 >= size) {
                Intrinsics.checkNotNull(c0694i2);
                c0694i2.v(bArr);
                c0694i2.r(lVar);
                c0694i2.v(bArr);
                c0694i2.v(bArr2);
                if (!z4) {
                    return j4;
                }
                Intrinsics.checkNotNull(c0694i);
                long j5 = j4 + c0694i.f13357b;
                c0694i.a();
                return j5;
            }
            int i5 = i4 + 1;
            O o4 = (O) list.get(i4);
            H h4 = o4.f12740a;
            Intrinsics.checkNotNull(c0694i2);
            c0694i2.v(bArr);
            c0694i2.r(lVar);
            c0694i2.v(bArr2);
            if (h4 != null) {
                int size2 = h4.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    c0694i2.G(h4.c(i6)).v(f12744g).G(h4.f(i6)).v(bArr2);
                }
            }
            Z z5 = o4.f12741b;
            M mContentType = z5.contentType();
            if (mContentType != null) {
                c0694i2.G("Content-Type: ").G(mContentType.f12734a).v(bArr2);
            }
            long jContentLength = z5.contentLength();
            if (jContentLength != -1) {
                c0694i2.G("Content-Length: ").H(jContentLength).v(bArr2);
            } else if (z4) {
                Intrinsics.checkNotNull(c0694i);
                c0694i.a();
                return -1L;
            }
            c0694i2.v(bArr2);
            if (z4) {
                j4 += jContentLength;
            } else {
                z5.writeTo(c0694i2);
            }
            c0694i2.v(bArr2);
            i4 = i5;
        }
    }

    @Override // h3.Z
    public final long contentLength() throws EOFException {
        long j4 = this.f12750d;
        if (j4 != -1) {
            return j4;
        }
        long jA = a(null, true);
        this.f12750d = jA;
        return jA;
    }

    @Override // h3.Z
    public final M contentType() {
        return this.f12749c;
    }

    @Override // h3.Z
    public final void writeTo(InterfaceC0695j sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        a(sink, false);
    }
}
