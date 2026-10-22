package ja;

import g5.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f6748b = ac.a.f("----------------314159265358979323846");

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f6749c = ac.a.f("\r\n");

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f6750d = ac.a.f("\"");

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f6751e = ac.a.f("--");

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f6752f = ac.a.f("Content-Disposition: form-data; name=");

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f6753g = ac.a.f("Content-Type: ");

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f6754h = ac.a.f("; charset=");
    public static final byte[] i = ac.a.f("Content-Transfer-Encoding: ");

    /* renamed from: a, reason: collision with root package name */
    public byte[] f6755a;

    public static void a(ByteArrayOutputStream byteArrayOutputStream, b[] bVarArr, byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            f.s("partBoundary may not be empty");
            return;
        }
        int i3 = 0;
        while (true) {
            int length = bVarArr.length;
            byte[] bArr2 = f6751e;
            byte[] bArr3 = f6749c;
            if (i3 >= length) {
                byteArrayOutputStream.write(bArr2);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr2);
                byteArrayOutputStream.write(bArr3);
                return;
            }
            b bVar = bVarArr[i3];
            bVar.f6755a = bArr;
            byteArrayOutputStream.write(bArr2);
            byte[] bArr4 = bVar.f6755a;
            if (bArr4 == null) {
                bArr4 = f6748b;
            }
            byteArrayOutputStream.write(bArr4);
            byteArrayOutputStream.write(bArr3);
            a aVar = (a) bVar;
            byteArrayOutputStream.write(f6752f);
            byte[] bArr5 = f6750d;
            byteArrayOutputStream.write(bArr5);
            byteArrayOutputStream.write(ac.a.f("data"));
            byteArrayOutputStream.write(bArr5);
            String str = aVar.f6747m;
            byteArrayOutputStream.write(a.f6743n);
            byteArrayOutputStream.write(bArr5);
            byteArrayOutputStream.write(ac.a.f(str));
            byteArrayOutputStream.write(bArr5);
            String str2 = aVar.f6744j;
            byteArrayOutputStream.write(bArr3);
            byteArrayOutputStream.write(f6753g);
            byteArrayOutputStream.write(ac.a.f(str2));
            String str3 = aVar.f6745k;
            byteArrayOutputStream.write(f6754h);
            byteArrayOutputStream.write(ac.a.f(str3));
            byteArrayOutputStream.write(bArr3);
            byteArrayOutputStream.write(i);
            byteArrayOutputStream.write(ac.a.f("binary"));
            byteArrayOutputStream.write(bArr3);
            byteArrayOutputStream.write(bArr3);
            byte[] bArr6 = aVar.f6746l;
            if (bArr6.length != 0) {
                byte[] bArr7 = new byte[4096];
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr6);
                while (true) {
                    try {
                        int i10 = byteArrayInputStream.read(bArr7);
                        if (i10 < 0) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr7, 0, i10);
                        }
                    } finally {
                        byteArrayInputStream.close();
                    }
                }
            }
            byteArrayOutputStream.write(bArr3);
            i3++;
        }
    }

    public final String toString() {
        return "data";
    }
}
