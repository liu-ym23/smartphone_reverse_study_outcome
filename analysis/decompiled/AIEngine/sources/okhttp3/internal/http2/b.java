package okhttp3.internal.http2;

import androidx.datastore.preferences.protobuf.b1;
import bd.i;
import com.stepos.core.common.util.TraceIdKeys;
import com.tonyodev.fetch2core.server.FileResponse;
import hd.c;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;
import okhttp3.internal.http2.d;
import okio.ByteString;
import sd.z;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final hd.a[] f11193a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map<ByteString, Integer> f11194b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        public final z f11197c;

        /* renamed from: f, reason: collision with root package name */
        public int f11200f;

        /* renamed from: g, reason: collision with root package name */
        public int f11201g;

        /* renamed from: a, reason: collision with root package name */
        public int f11195a = 4096;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f11196b = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public hd.a[] f11198d = new hd.a[8];

        /* renamed from: e, reason: collision with root package name */
        public int f11199e = 7;

        public a(d.b bVar) {
            this.f11197c = new z(bVar);
        }

        public final int a(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f11198d.length;
                while (true) {
                    length--;
                    i11 = this.f11199e;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    hd.a aVar = this.f11198d[length];
                    g.c(aVar);
                    int i13 = aVar.f9413c;
                    i10 -= i13;
                    this.f11201g -= i13;
                    this.f11200f--;
                    i12++;
                }
                hd.a[] aVarArr = this.f11198d;
                System.arraycopy(aVarArr, i11 + 1, aVarArr, i11 + 1 + i12, this.f11200f);
                this.f11199e += i12;
            }
            return i12;
        }

        public final ByteString b(int i10) throws IOException {
            if (i10 >= 0) {
                hd.a[] aVarArr = b.f11193a;
                if (i10 <= aVarArr.length - 1) {
                    return aVarArr[i10].f9411a;
                }
            }
            int length = this.f11199e + 1 + (i10 - b.f11193a.length);
            if (length >= 0) {
                hd.a[] aVarArr2 = this.f11198d;
                if (length < aVarArr2.length) {
                    hd.a aVar = aVarArr2[length];
                    g.c(aVar);
                    return aVar.f9411a;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        public final void c(hd.a aVar) {
            this.f11196b.add(aVar);
            int i10 = aVar.f9413c;
            int i11 = this.f11195a;
            if (i10 > i11) {
                hd.a[] aVarArr = this.f11198d;
                b1.G(null, aVarArr, 0, aVarArr.length);
                this.f11199e = this.f11198d.length - 1;
                this.f11200f = 0;
                this.f11201g = 0;
                return;
            }
            a((this.f11201g + i10) - i11);
            int i12 = this.f11200f + 1;
            hd.a[] aVarArr2 = this.f11198d;
            if (i12 > aVarArr2.length) {
                hd.a[] aVarArr3 = new hd.a[aVarArr2.length * 2];
                System.arraycopy(aVarArr2, 0, aVarArr3, aVarArr2.length, aVarArr2.length);
                this.f11199e = this.f11198d.length - 1;
                this.f11198d = aVarArr3;
            }
            int i13 = this.f11199e;
            this.f11199e = i13 - 1;
            this.f11198d[i13] = aVar;
            this.f11200f++;
            this.f11201g += i10;
        }

        public final ByteString d() {
            z source = this.f11197c;
            byte b10 = source.readByte();
            byte[] bArr = i.f3230a;
            int i10 = b10 & 255;
            int i11 = 0;
            boolean z = (b10 & 128) == 128;
            long jE = e(i10, 127);
            if (!z) {
                return source.X(jE);
            }
            sd.e eVar = new sd.e();
            int[] iArr = hd.c.f9419a;
            g.f(source, "source");
            c.a aVar = hd.c.f9421c;
            c.a aVar2 = aVar;
            int i12 = 0;
            for (long j10 = 0; j10 < jE; j10++) {
                byte b11 = source.readByte();
                byte[] bArr2 = i.f3230a;
                i11 = (i11 << 8) | (b11 & 255);
                i12 += 8;
                while (i12 >= 8) {
                    c.a[] aVarArr = aVar2.f9422a;
                    g.c(aVarArr);
                    aVar2 = aVarArr[(i11 >>> (i12 - 8)) & 255];
                    g.c(aVar2);
                    if (aVar2.f9422a == null) {
                        eVar.O0(aVar2.f9423b);
                        i12 -= aVar2.f9424c;
                        aVar2 = aVar;
                    } else {
                        i12 -= 8;
                    }
                }
            }
            while (i12 > 0) {
                c.a[] aVarArr2 = aVar2.f9422a;
                g.c(aVarArr2);
                c.a aVar3 = aVarArr2[(i11 << (8 - i12)) & 255];
                g.c(aVar3);
                int i13 = aVar3.f9424c;
                if (aVar3.f9422a != null || i13 > i12) {
                    break;
                }
                eVar.O0(aVar3.f9423b);
                i12 -= i13;
                aVar2 = aVar;
            }
            return eVar.X(eVar.f11926b);
        }

        public final int e(int i10, int i11) {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                byte b10 = this.f11197c.readByte();
                byte[] bArr = i.f3230a;
                int i14 = b10 & 255;
                if ((b10 & 128) == 0) {
                    return i11 + (i14 << i13);
                }
                i11 += (b10 & 127) << i13;
                i13 += 7;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: okhttp3.internal.http2.b$b, reason: collision with other inner class name */
    public static final class C0122b {

        /* renamed from: a, reason: collision with root package name */
        public final sd.e f11202a;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11204c;

        /* renamed from: g, reason: collision with root package name */
        public int f11208g;
        public int h;

        /* renamed from: b, reason: collision with root package name */
        public int f11203b = Integer.MAX_VALUE;

        /* renamed from: d, reason: collision with root package name */
        public int f11205d = 4096;

        /* renamed from: e, reason: collision with root package name */
        public hd.a[] f11206e = new hd.a[8];

        /* renamed from: f, reason: collision with root package name */
        public int f11207f = 7;

        public C0122b(sd.e eVar) {
            this.f11202a = eVar;
        }

        public final void a(int i10) {
            int i11;
            if (i10 > 0) {
                int length = this.f11206e.length - 1;
                int i12 = 0;
                while (true) {
                    i11 = this.f11207f;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    hd.a aVar = this.f11206e[length];
                    g.c(aVar);
                    i10 -= aVar.f9413c;
                    int i13 = this.h;
                    hd.a aVar2 = this.f11206e[length];
                    g.c(aVar2);
                    this.h = i13 - aVar2.f9413c;
                    this.f11208g--;
                    i12++;
                    length--;
                }
                hd.a[] aVarArr = this.f11206e;
                int i14 = i11 + 1;
                System.arraycopy(aVarArr, i14, aVarArr, i14 + i12, this.f11208g);
                hd.a[] aVarArr2 = this.f11206e;
                int i15 = this.f11207f + 1;
                Arrays.fill(aVarArr2, i15, i15 + i12, (Object) null);
                this.f11207f += i12;
            }
        }

        public final void b(hd.a aVar) {
            int i10 = aVar.f9413c;
            int i11 = this.f11205d;
            if (i10 > i11) {
                hd.a[] aVarArr = this.f11206e;
                b1.G(null, aVarArr, 0, aVarArr.length);
                this.f11207f = this.f11206e.length - 1;
                this.f11208g = 0;
                this.h = 0;
                return;
            }
            a((this.h + i10) - i11);
            int i12 = this.f11208g + 1;
            hd.a[] aVarArr2 = this.f11206e;
            if (i12 > aVarArr2.length) {
                hd.a[] aVarArr3 = new hd.a[aVarArr2.length * 2];
                System.arraycopy(aVarArr2, 0, aVarArr3, aVarArr2.length, aVarArr2.length);
                this.f11207f = this.f11206e.length - 1;
                this.f11206e = aVarArr3;
            }
            int i13 = this.f11207f;
            this.f11207f = i13 - 1;
            this.f11206e[i13] = aVar;
            this.f11208g++;
            this.h += i10;
        }

        public final void c(ByteString data) throws EOFException {
            g.f(data, "data");
            int[] iArr = hd.c.f9419a;
            int iD = data.d();
            long j10 = 0;
            long j11 = 0;
            for (int i10 = 0; i10 < iD; i10++) {
                byte bJ = data.j(i10);
                byte[] bArr = i.f3230a;
                j11 += hd.c.f9420b[bJ & 255];
            }
            int i11 = (int) ((j11 + 7) >> 3);
            int iD2 = data.d();
            sd.e eVar = this.f11202a;
            if (i11 >= iD2) {
                e(data.d(), 127, 0);
                eVar.N0(data);
                return;
            }
            sd.e eVar2 = new sd.e();
            int[] iArr2 = hd.c.f9419a;
            int iD3 = data.d();
            int i12 = 0;
            for (int i13 = 0; i13 < iD3; i13++) {
                byte bJ2 = data.j(i13);
                byte[] bArr2 = i.f3230a;
                int i14 = bJ2 & 255;
                int i15 = hd.c.f9419a[i14];
                byte b10 = hd.c.f9420b[i14];
                j10 = (j10 << b10) | i15;
                i12 += b10;
                while (i12 >= 8) {
                    i12 -= 8;
                    eVar2.O0((int) (j10 >> i12));
                }
            }
            if (i12 > 0) {
                eVar2.O0((int) ((j10 << (8 - i12)) | (255 >>> i12)));
            }
            ByteString byteStringX = eVar2.X(eVar2.f11926b);
            e(byteStringX.d(), 127, TraceIdKeys.MAX_LENGTH);
            eVar.N0(byteStringX);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void d(java.util.ArrayList r14) throws java.io.EOFException {
            /*
                Method dump skipped, instructions count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.b.C0122b.d(java.util.ArrayList):void");
        }

        public final void e(int i10, int i11, int i12) {
            sd.e eVar = this.f11202a;
            if (i10 < i11) {
                eVar.O0(i10 | i12);
                return;
            }
            eVar.O0(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                eVar.O0(128 | (i13 & 127));
                i13 >>>= 7;
            }
            eVar.O0(i13);
        }
    }

    static {
        hd.a aVar = new hd.a(hd.a.f9410i, "");
        ByteString byteString = hd.a.f9408f;
        hd.a aVar2 = new hd.a(byteString, "GET");
        hd.a aVar3 = new hd.a(byteString, "POST");
        ByteString byteString2 = hd.a.f9409g;
        hd.a aVar4 = new hd.a(byteString2, "/");
        hd.a aVar5 = new hd.a(byteString2, "/index.html");
        ByteString byteString3 = hd.a.h;
        hd.a aVar6 = new hd.a(byteString3, "http");
        hd.a aVar7 = new hd.a(byteString3, "https");
        ByteString byteString4 = hd.a.f9407e;
        hd.a[] aVarArr = {aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, new hd.a(byteString4, "200"), new hd.a(byteString4, "204"), new hd.a(byteString4, "206"), new hd.a(byteString4, "304"), new hd.a(byteString4, "400"), new hd.a(byteString4, "404"), new hd.a(byteString4, "500"), new hd.a("accept-charset", ""), new hd.a("accept-encoding", "gzip, deflate"), new hd.a("accept-language", ""), new hd.a("accept-ranges", ""), new hd.a("accept", ""), new hd.a("access-control-allow-origin", ""), new hd.a("age", ""), new hd.a("allow", ""), new hd.a("authorization", ""), new hd.a("cache-control", ""), new hd.a("content-disposition", ""), new hd.a("content-encoding", ""), new hd.a("content-language", ""), new hd.a(FileResponse.FIELD_CONTENT_LENGTH, ""), new hd.a("content-location", ""), new hd.a("content-range", ""), new hd.a("content-type", ""), new hd.a("cookie", ""), new hd.a(FileResponse.FIELD_DATE, ""), new hd.a("etag", ""), new hd.a("expect", ""), new hd.a("expires", ""), new hd.a("from", ""), new hd.a("host", ""), new hd.a("if-match", ""), new hd.a("if-modified-since", ""), new hd.a("if-none-match", ""), new hd.a("if-range", ""), new hd.a("if-unmodified-since", ""), new hd.a("last-modified", ""), new hd.a("link", ""), new hd.a("location", ""), new hd.a("max-forwards", ""), new hd.a("proxy-authenticate", ""), new hd.a("proxy-authorization", ""), new hd.a("range", ""), new hd.a("referer", ""), new hd.a("refresh", ""), new hd.a("retry-after", ""), new hd.a("server", ""), new hd.a("set-cookie", ""), new hd.a("strict-transport-security", ""), new hd.a("transfer-encoding", ""), new hd.a("user-agent", ""), new hd.a("vary", ""), new hd.a("via", ""), new hd.a("www-authenticate", "")};
        f11193a = aVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i10 = 0; i10 < 61; i10++) {
            if (!linkedHashMap.containsKey(aVarArr[i10].f9411a)) {
                linkedHashMap.put(aVarArr[i10].f9411a, Integer.valueOf(i10));
            }
        }
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        g.e(mapUnmodifiableMap, "unmodifiableMap(...)");
        f11194b = mapUnmodifiableMap;
    }

    public static void a(ByteString name) {
        g.f(name, "name");
        int iD = name.d();
        for (int i10 = 0; i10 < iD; i10++) {
            byte bJ = name.j(i10);
            if (65 <= bJ && bJ < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(name.r()));
            }
        }
    }
}
