package ad;

import java.io.File;
import java.io.FileDescriptor;
import java.nio.charset.Charset;
import okio.ByteString;
import sd.x;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class s {
    public static final a Companion = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static bd.e a(l lVar, byte[] bArr, int i10, int i11) {
            kotlin.jvm.internal.g.f(bArr, "<this>");
            bd.i.a(bArr.length, i10, i11);
            return new bd.e(lVar, bArr, i11, i10);
        }

        public static bd.e b(String str, l lVar) {
            kotlin.jvm.internal.g.f(str, "<this>");
            Charset charset = gc.a.f9106b;
            if (lVar != null) {
                Charset charsetA = l.a(lVar);
                if (charsetA == null) {
                    String str2 = lVar + "; charset=utf-8";
                    kotlin.jvm.internal.g.f(str2, "<this>");
                    try {
                        lVar = bd.d.a(str2);
                    } catch (IllegalArgumentException unused) {
                        lVar = null;
                    }
                } else {
                    charset = charsetA;
                }
            }
            byte[] bytes = str.getBytes(charset);
            kotlin.jvm.internal.g.e(bytes, "getBytes(...)");
            return a(lVar, bytes, 0, bytes.length);
        }

        public static /* synthetic */ bd.e c(a aVar, byte[] bArr, l lVar, int i10, int i11) {
            if ((i11 & 1) != 0) {
                lVar = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            int length = bArr.length;
            aVar.getClass();
            return a(lVar, bArr, i10, length);
        }
    }

    public static final s create(l lVar, File file) {
        Companion.getClass();
        kotlin.jvm.internal.g.f(file, "file");
        return new o(lVar, file);
    }

    public static final s gzip(s sVar) {
        Companion.getClass();
        kotlin.jvm.internal.g.f(sVar, "<this>");
        return new q(sVar);
    }

    public long contentLength() {
        return -1L;
    }

    public abstract l contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(sd.g gVar);

    public static final s create(l lVar, String content) {
        Companion.getClass();
        kotlin.jvm.internal.g.f(content, "content");
        return a.b(content, lVar);
    }

    public static final s create(l lVar, ByteString content) {
        Companion.getClass();
        kotlin.jvm.internal.g.f(content, "content");
        return new bd.f(lVar, content);
    }

    public static final s create(l lVar, byte[] content) {
        Companion.getClass();
        kotlin.jvm.internal.g.f(content, "content");
        return a.a(lVar, content, 0, content.length);
    }

    public static final s create(l lVar, byte[] content, int i10) {
        Companion.getClass();
        kotlin.jvm.internal.g.f(content, "content");
        return a.a(lVar, content, i10, content.length);
    }

    public static final s create(FileDescriptor fileDescriptor, l lVar) {
        Companion.getClass();
        kotlin.jvm.internal.g.f(fileDescriptor, "<this>");
        return new r(fileDescriptor, lVar);
    }

    public static final s create(String str, l lVar) {
        Companion.getClass();
        return a.b(str, lVar);
    }

    public static final s create(x xVar, sd.l fileSystem, l lVar) {
        Companion.getClass();
        kotlin.jvm.internal.g.f(xVar, "<this>");
        kotlin.jvm.internal.g.f(fileSystem, "fileSystem");
        return new p(xVar, fileSystem, lVar);
    }

    public static final s create(byte[] bArr) {
        a aVar = Companion;
        aVar.getClass();
        kotlin.jvm.internal.g.f(bArr, "<this>");
        return a.c(aVar, bArr, null, 0, 7);
    }

    public static final s create(byte[] bArr, l lVar) {
        a aVar = Companion;
        aVar.getClass();
        kotlin.jvm.internal.g.f(bArr, "<this>");
        return a.c(aVar, bArr, lVar, 0, 6);
    }

    public static final s create(byte[] bArr, l lVar, int i10) {
        a aVar = Companion;
        aVar.getClass();
        kotlin.jvm.internal.g.f(bArr, "<this>");
        return a.c(aVar, bArr, lVar, i10, 4);
    }

    public static final s create(byte[] bArr, l lVar, int i10, int i11) {
        Companion.getClass();
        return a.a(lVar, bArr, i10, i11);
    }

    public static final s create(ByteString byteString, l lVar) {
        Companion.getClass();
        kotlin.jvm.internal.g.f(byteString, "<this>");
        return new bd.f(lVar, byteString);
    }

    public static final s create(File file, l lVar) {
        Companion.getClass();
        kotlin.jvm.internal.g.f(file, "<this>");
        return new o(lVar, file);
    }

    public static final s create(l lVar, byte[] content, int i10, int i11) {
        Companion.getClass();
        kotlin.jvm.internal.g.f(content, "content");
        return a.a(lVar, content, i10, i11);
    }
}
