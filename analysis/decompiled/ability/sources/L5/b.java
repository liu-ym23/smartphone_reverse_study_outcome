package L5;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.json.HTTP;

/* loaded from: classes3.dex */
public abstract class b {
    public static final byte[] f = U7.a.n("----------------314159265358979323846");
    public static final byte[] g = U7.a.n(HTTP.CRLF);
    public static final byte[] h = U7.a.n("\"");
    public static final byte[] i = U7.a.n("--");

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f934j = U7.a.n("Content-Disposition: form-data; name=");
    public static final byte[] k = U7.a.n("Content-Type: ");
    public static final byte[] l = U7.a.n("; charset=");
    public static final byte[] m = U7.a.n("Content-Transfer-Encoding: ");

    /* renamed from: a, reason: collision with root package name */
    public byte[] f935a;
    public String b;
    public String c;
    public String d;
    public String e;

    public static void a(ByteArrayOutputStream byteArrayOutputStream, b[] bVarArr, byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("partBoundary may not be empty");
        }
        int i6 = 0;
        while (true) {
            int length = bVarArr.length;
            byte[] bArr2 = i;
            byte[] bArr3 = g;
            if (i6 >= length) {
                byteArrayOutputStream.write(bArr2);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr2);
                byteArrayOutputStream.write(bArr3);
                return;
            }
            b bVar = bVarArr[i6];
            bVar.f935a = bArr;
            byteArrayOutputStream.write(bArr2);
            byte[] bArr4 = bVar.f935a;
            if (bArr4 == null) {
                bArr4 = f;
            }
            byteArrayOutputStream.write(bArr4);
            byteArrayOutputStream.write(bArr3);
            a aVar = (a) bVar;
            byteArrayOutputStream.write(f934j);
            byte[] bArr5 = h;
            byteArrayOutputStream.write(bArr5);
            byteArrayOutputStream.write(U7.a.n(aVar.b));
            byteArrayOutputStream.write(bArr5);
            String str = aVar.o;
            if (str != null) {
                byteArrayOutputStream.write(a.p);
                byteArrayOutputStream.write(bArr5);
                byteArrayOutputStream.write(U7.a.n(str));
                byteArrayOutputStream.write(bArr5);
            }
            String str2 = bVar.c;
            if (str2 != null) {
                byteArrayOutputStream.write(bArr3);
                byteArrayOutputStream.write(k);
                byteArrayOutputStream.write(U7.a.n(str2));
                String str3 = bVar.d;
                if (str3 != null) {
                    byteArrayOutputStream.write(l);
                    byteArrayOutputStream.write(U7.a.n(str3));
                }
            }
            String str4 = bVar.e;
            if (str4 != null) {
                byteArrayOutputStream.write(bArr3);
                byteArrayOutputStream.write(m);
                byteArrayOutputStream.write(U7.a.n(str4));
            }
            byteArrayOutputStream.write(bArr3);
            byteArrayOutputStream.write(bArr3);
            byte[] bArr6 = aVar.n;
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
            i6++;
        }
    }

    public final String toString() {
        return this.b;
    }
}
