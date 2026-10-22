package J2;

import B0.f;
import com.baidu.mapapi.http.HttpClient;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f884f = f.b("----------------314159265358979323846");

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f885g = f.b(HttpClient.NEWLINE);

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f886h = f.b("\"");

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f887i = f.b(HttpClient.ENDFLAG);

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f888j = f.b("Content-Disposition: form-data; name=");

    /* renamed from: k, reason: collision with root package name */
    public static final byte[] f889k = f.b("Content-Type: ");

    /* renamed from: l, reason: collision with root package name */
    public static final byte[] f890l = f.b("; charset=");

    /* renamed from: m, reason: collision with root package name */
    public static final byte[] f891m = f.b("Content-Transfer-Encoding: ");

    /* renamed from: a, reason: collision with root package name */
    public byte[] f892a;

    /* renamed from: b, reason: collision with root package name */
    public String f893b;

    /* renamed from: c, reason: collision with root package name */
    public String f894c;

    /* renamed from: d, reason: collision with root package name */
    public String f895d;

    /* renamed from: e, reason: collision with root package name */
    public String f896e;

    public static void a(ByteArrayOutputStream byteArrayOutputStream, b[] bVarArr, byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("partBoundary may not be empty");
        }
        int i4 = 0;
        while (true) {
            int length = bVarArr.length;
            byte[] bArr2 = f885g;
            byte[] bArr3 = f887i;
            if (i4 >= length) {
                byteArrayOutputStream.write(bArr3);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr3);
                byteArrayOutputStream.write(bArr2);
                return;
            }
            b bVar = bVarArr[i4];
            bVar.f892a = bArr;
            byteArrayOutputStream.write(bArr3);
            byte[] bArr4 = bVar.f892a;
            if (bArr4 == null) {
                bArr4 = f884f;
            }
            byteArrayOutputStream.write(bArr4);
            byteArrayOutputStream.write(bArr2);
            a aVar = (a) bVar;
            byteArrayOutputStream.write(f888j);
            byte[] bArr5 = f886h;
            byteArrayOutputStream.write(bArr5);
            byteArrayOutputStream.write(f.b(aVar.f893b));
            byteArrayOutputStream.write(bArr5);
            String str = aVar.f883o;
            if (str != null) {
                byteArrayOutputStream.write(a.f881p);
                byteArrayOutputStream.write(bArr5);
                byteArrayOutputStream.write(f.b(str));
                byteArrayOutputStream.write(bArr5);
            }
            String str2 = bVar.f894c;
            if (str2 != null) {
                byteArrayOutputStream.write(bArr2);
                byteArrayOutputStream.write(f889k);
                byteArrayOutputStream.write(f.b(str2));
                String str3 = bVar.f895d;
                if (str3 != null) {
                    byteArrayOutputStream.write(f890l);
                    byteArrayOutputStream.write(f.b(str3));
                }
            }
            String str4 = bVar.f896e;
            if (str4 != null) {
                byteArrayOutputStream.write(bArr2);
                byteArrayOutputStream.write(f891m);
                byteArrayOutputStream.write(f.b(str4));
            }
            byteArrayOutputStream.write(bArr2);
            byteArrayOutputStream.write(bArr2);
            byte[] bArr6 = aVar.f882n;
            if (bArr6.length != 0) {
                byte[] bArr7 = new byte[4096];
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr6);
                while (true) {
                    try {
                        int i5 = byteArrayInputStream.read(bArr7);
                        if (i5 < 0) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr7, 0, i5);
                        }
                    } finally {
                        byteArrayInputStream.close();
                    }
                }
            }
            byteArrayOutputStream.write(bArr2);
            i4++;
        }
    }

    public final String toString() {
        return this.f893b;
    }
}
