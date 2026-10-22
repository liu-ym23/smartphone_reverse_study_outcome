package ja;

import androidx.datastore.preferences.protobuf.b1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f9750f = b1.a("----------------314159265358979323846");

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f9751g = b1.a("\r\n");
    public static final byte[] h = b1.a("\"");

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f9752i = b1.a("--");

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f9753j = b1.a("Content-Disposition: form-data; name=");

    /* renamed from: k, reason: collision with root package name */
    public static final byte[] f9754k = b1.a("Content-Type: ");

    /* renamed from: l, reason: collision with root package name */
    public static final byte[] f9755l = b1.a("; charset=");

    /* renamed from: m, reason: collision with root package name */
    public static final byte[] f9756m = b1.a("Content-Transfer-Encoding: ");

    /* renamed from: a, reason: collision with root package name */
    public byte[] f9757a;

    /* renamed from: b, reason: collision with root package name */
    public String f9758b;

    /* renamed from: c, reason: collision with root package name */
    public String f9759c;

    /* renamed from: d, reason: collision with root package name */
    public String f9760d;

    /* renamed from: e, reason: collision with root package name */
    public String f9761e;

    public static void a(ByteArrayOutputStream byteArrayOutputStream, b[] bVarArr, byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("partBoundary may not be empty");
        }
        int i10 = 0;
        while (true) {
            int length = bVarArr.length;
            byte[] bArr2 = f9752i;
            byte[] bArr3 = f9751g;
            if (i10 >= length) {
                byteArrayOutputStream.write(bArr2);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr2);
                byteArrayOutputStream.write(bArr3);
                return;
            }
            b bVar = bVarArr[i10];
            bVar.f9757a = bArr;
            byteArrayOutputStream.write(bArr2);
            byte[] bArr4 = bVar.f9757a;
            if (bArr4 == null) {
                bArr4 = f9750f;
            }
            byteArrayOutputStream.write(bArr4);
            byteArrayOutputStream.write(bArr3);
            a aVar = (a) bVar;
            byteArrayOutputStream.write(f9753j);
            byte[] bArr5 = h;
            byteArrayOutputStream.write(bArr5);
            byteArrayOutputStream.write(b1.a(aVar.f9758b));
            byteArrayOutputStream.write(bArr5);
            String str = aVar.f9749o;
            if (str != null) {
                byteArrayOutputStream.write(a.f9747p);
                byteArrayOutputStream.write(bArr5);
                byteArrayOutputStream.write(b1.a(str));
                byteArrayOutputStream.write(bArr5);
            }
            String str2 = bVar.f9759c;
            if (str2 != null) {
                byteArrayOutputStream.write(bArr3);
                byteArrayOutputStream.write(f9754k);
                byteArrayOutputStream.write(b1.a(str2));
                String str3 = bVar.f9760d;
                if (str3 != null) {
                    byteArrayOutputStream.write(f9755l);
                    byteArrayOutputStream.write(b1.a(str3));
                }
            }
            String str4 = bVar.f9761e;
            if (str4 != null) {
                byteArrayOutputStream.write(bArr3);
                byteArrayOutputStream.write(f9756m);
                byteArrayOutputStream.write(b1.a(str4));
            }
            byteArrayOutputStream.write(bArr3);
            byteArrayOutputStream.write(bArr3);
            byte[] bArr6 = aVar.f9748n;
            if (bArr6.length != 0) {
                byte[] bArr7 = new byte[4096];
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr6);
                while (true) {
                    try {
                        int i11 = byteArrayInputStream.read(bArr7);
                        if (i11 < 0) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr7, 0, i11);
                        }
                    } finally {
                        byteArrayInputStream.close();
                    }
                }
            }
            byteArrayOutputStream.write(bArr3);
            i10++;
        }
    }

    public final String toString() {
        return this.f9758b;
    }
}
