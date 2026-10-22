package ad;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.text.Regex;
import okio.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m extends s {

    /* renamed from: e, reason: collision with root package name */
    public static final l f104e = bd.d.a("multipart/mixed");

    /* renamed from: f, reason: collision with root package name */
    public static final l f105f;

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f106g;
    public static final byte[] h;

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f107i;

    /* renamed from: a, reason: collision with root package name */
    public final ByteString f108a;

    /* renamed from: b, reason: collision with root package name */
    public final List<b> f109b;

    /* renamed from: c, reason: collision with root package name */
    public final l f110c;

    /* renamed from: d, reason: collision with root package name */
    public long f111d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final ByteString f112a;

        /* renamed from: b, reason: collision with root package name */
        public l f113b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f114c;

        public a() {
            String string = UUID.randomUUID().toString();
            kotlin.jvm.internal.g.e(string, "toString(...)");
            ByteString byteString = ByteString.f11312d;
            this.f112a = ByteString.a.b(string);
            this.f113b = m.f104e;
            this.f114c = new ArrayList();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final okhttp3.f f115a;

        /* renamed from: b, reason: collision with root package name */
        public final s f116b;

        public b(okhttp3.f fVar, s sVar) {
            this.f115a = fVar;
            this.f116b = sVar;
        }
    }

    static {
        bd.d.a("multipart/alternative");
        bd.d.a("multipart/digest");
        bd.d.a("multipart/parallel");
        f105f = bd.d.a("multipart/form-data");
        f106g = new byte[]{58, 32};
        h = new byte[]{13, 10};
        f107i = new byte[]{45, 45};
    }

    public m(ByteString boundaryByteString, l type, List<b> list) {
        kotlin.jvm.internal.g.f(boundaryByteString, "boundaryByteString");
        kotlin.jvm.internal.g.f(type, "type");
        this.f108a = boundaryByteString;
        this.f109b = list;
        String str = type + "; boundary=" + boundaryByteString.r();
        kotlin.jvm.internal.g.f(str, "<this>");
        this.f110c = bd.d.a(str);
        this.f111d = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long a(sd.g gVar, boolean z) throws EOFException {
        sd.e eVar;
        sd.g eVar2;
        if (z) {
            eVar2 = new sd.e();
            eVar = eVar2;
        } else {
            eVar = 0;
            eVar2 = gVar;
        }
        List<b> list = this.f109b;
        int size = list.size();
        long j10 = 0;
        int i10 = 0;
        while (true) {
            ByteString byteString = this.f108a;
            byte[] bArr = f107i;
            byte[] bArr2 = h;
            if (i10 >= size) {
                kotlin.jvm.internal.g.c(eVar2);
                eVar2.write(bArr);
                eVar2.z0(byteString);
                eVar2.write(bArr);
                eVar2.write(bArr2);
                if (!z) {
                    return j10;
                }
                kotlin.jvm.internal.g.c(eVar);
                long j11 = j10 + eVar.f11926b;
                eVar.o();
                return j11;
            }
            b bVar = list.get(i10);
            okhttp3.f fVar = bVar.f115a;
            s sVar = bVar.f116b;
            kotlin.jvm.internal.g.c(eVar2);
            eVar2.write(bArr);
            eVar2.z0(byteString);
            eVar2.write(bArr2);
            int size2 = fVar.size();
            for (int i11 = 0; i11 < size2; i11++) {
                eVar2.D(fVar.b(i11)).write(f106g).D(fVar.g(i11)).write(bArr2);
            }
            l lVarContentType = sVar.contentType();
            if (lVarContentType != null) {
                sd.g gVarD = eVar2.D("Content-Type: ");
                Regex regex = bd.d.f3219a;
                gVarD.D(lVarContentType.f100a).write(bArr2);
            }
            long jContentLength = sVar.contentLength();
            if (jContentLength == -1 && z) {
                kotlin.jvm.internal.g.c(eVar);
                eVar.o();
                return -1L;
            }
            eVar2.write(bArr2);
            if (z) {
                j10 += jContentLength;
            } else {
                sVar.writeTo(eVar2);
            }
            eVar2.write(bArr2);
            i10++;
        }
    }

    @Override // ad.s
    public final long contentLength() throws EOFException {
        long j10 = this.f111d;
        if (j10 != -1) {
            return j10;
        }
        long jA = a(null, true);
        this.f111d = jA;
        return jA;
    }

    @Override // ad.s
    public final l contentType() {
        return this.f110c;
    }

    @Override // ad.s
    public final boolean isOneShot() {
        List<b> list = this.f109b;
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((b) it.next()).f116b.isOneShot()) {
                return true;
            }
        }
        return false;
    }

    @Override // ad.s
    public final void writeTo(sd.g sink) throws EOFException {
        kotlin.jvm.internal.g.f(sink, "sink");
        a(sink, false);
    }
}
