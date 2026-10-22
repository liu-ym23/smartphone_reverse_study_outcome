package F9;

import java.io.EOFException;
import java.util.List;
import java.util.regex.Pattern;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class D extends K {
    public static final B e;
    public static final B f;
    public static final byte[] g;
    public static final byte[] h;
    public static final byte[] i;

    /* renamed from: a, reason: collision with root package name */
    public final ByteString f599a;
    public final List b;
    public final B c;
    public long d;

    static {
        Pattern pattern = B.e;
        e = AbstractC0226d.g("multipart/mixed");
        AbstractC0226d.g("multipart/alternative");
        AbstractC0226d.g("multipart/digest");
        AbstractC0226d.g("multipart/parallel");
        f = AbstractC0226d.g("multipart/form-data");
        g = new byte[]{58, 32};
        h = new byte[]{13, 10};
        i = new byte[]{45, 45};
    }

    public D(ByteString boundaryByteString, B type, List list) {
        kotlin.jvm.internal.k.f(boundaryByteString, "boundaryByteString");
        kotlin.jvm.internal.k.f(type, "type");
        this.f599a = boundaryByteString;
        this.b = list;
        Pattern pattern = B.e;
        this.c = AbstractC0226d.g(type + "; boundary=" + boundaryByteString.j());
        this.d = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long b(V9.h hVar, boolean z10) throws EOFException {
        V9.g gVar;
        V9.h gVar2;
        if (z10) {
            gVar2 = new V9.g();
            gVar = gVar2;
        } else {
            gVar = 0;
            gVar2 = hVar;
        }
        List list = this.b;
        int size = list.size();
        long j5 = 0;
        int i6 = 0;
        while (true) {
            ByteString byteString = this.f599a;
            byte[] bArr = i;
            byte[] bArr2 = h;
            if (i6 >= size) {
                kotlin.jvm.internal.k.c(gVar2);
                gVar2.write(bArr);
                gVar2.A(byteString);
                gVar2.write(bArr);
                gVar2.write(bArr2);
                if (!z10) {
                    return j5;
                }
                kotlin.jvm.internal.k.c(gVar);
                long j6 = j5 + gVar.b;
                gVar.b();
                return j6;
            }
            C c = (C) list.get(i6);
            w wVar = c.f598a;
            K k = c.b;
            kotlin.jvm.internal.k.c(gVar2);
            gVar2.write(bArr);
            gVar2.A(byteString);
            gVar2.write(bArr2);
            int size2 = wVar.size();
            for (int i10 = 0; i10 < size2; i10++) {
                gVar2.m(wVar.e(i10)).write(g).m(wVar.h(i10)).write(bArr2);
            }
            B bContentType = k.contentType();
            if (bContentType != null) {
                gVar2.m("Content-Type: ").m(bContentType.f597a).write(bArr2);
            }
            long jContentLength = k.contentLength();
            if (jContentLength != -1) {
                gVar2.m("Content-Length: ").u(jContentLength).write(bArr2);
            } else if (z10) {
                kotlin.jvm.internal.k.c(gVar);
                gVar.b();
                return -1L;
            }
            gVar2.write(bArr2);
            if (z10) {
                j5 += jContentLength;
            } else {
                k.writeTo(gVar2);
            }
            gVar2.write(bArr2);
            i6++;
        }
    }

    @Override // F9.K
    public final long contentLength() throws EOFException {
        long j5 = this.d;
        if (j5 != -1) {
            return j5;
        }
        long jB = b(null, true);
        this.d = jB;
        return jB;
    }

    @Override // F9.K
    public final B contentType() {
        return this.c;
    }

    @Override // F9.K
    public final void writeTo(V9.h sink) throws EOFException {
        kotlin.jvm.internal.k.f(sink, "sink");
        b(sink, false);
    }
}
