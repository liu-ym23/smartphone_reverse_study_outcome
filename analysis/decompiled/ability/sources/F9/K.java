package F9;

import java.io.File;
import okio.ByteString;

/* loaded from: classes4.dex */
public abstract class K {
    public static final J Companion = new J();

    @C7.c
    public static final K create(B b, File file) {
        Companion.getClass();
        kotlin.jvm.internal.k.f(file, "file");
        return new H(b, file, 0);
    }

    public abstract long contentLength();

    public abstract B contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(V9.h hVar);

    @C7.c
    public static final K create(B b, ByteString content) {
        Companion.getClass();
        kotlin.jvm.internal.k.f(content, "content");
        return new H(b, content, 1);
    }

    @C7.c
    public static final K create(B b, byte[] content) {
        Companion.getClass();
        kotlin.jvm.internal.k.f(content, "content");
        return J.a(b, content, 0, content.length);
    }

    @C7.c
    public static final K create(B b, byte[] content, int i) {
        Companion.getClass();
        kotlin.jvm.internal.k.f(content, "content");
        return J.a(b, content, i, content.length);
    }

    public static final K create(String str, B b) {
        Companion.getClass();
        return J.b(str, b);
    }

    public static final K create(byte[] bArr) {
        J j5 = Companion;
        j5.getClass();
        kotlin.jvm.internal.k.f(bArr, "<this>");
        return J.c(j5, bArr, null, 0, 7);
    }

    public static final K create(byte[] bArr, B b) {
        J j5 = Companion;
        j5.getClass();
        kotlin.jvm.internal.k.f(bArr, "<this>");
        return J.c(j5, bArr, b, 0, 6);
    }

    public static final K create(byte[] bArr, B b, int i) {
        J j5 = Companion;
        j5.getClass();
        kotlin.jvm.internal.k.f(bArr, "<this>");
        return J.c(j5, bArr, b, i, 4);
    }

    public static final K create(byte[] bArr, B b, int i, int i6) {
        Companion.getClass();
        return J.a(b, bArr, i, i6);
    }

    public static final K create(ByteString byteString, B b) {
        Companion.getClass();
        kotlin.jvm.internal.k.f(byteString, "<this>");
        return new H(b, byteString, 1);
    }

    public static final K create(File file, B b) {
        Companion.getClass();
        kotlin.jvm.internal.k.f(file, "<this>");
        return new H(b, file, 0);
    }

    @C7.c
    public static final K create(B b, String content) {
        Companion.getClass();
        kotlin.jvm.internal.k.f(content, "content");
        return J.b(content, b);
    }

    @C7.c
    public static final K create(B b, byte[] content, int i, int i6) {
        Companion.getClass();
        kotlin.jvm.internal.k.f(content, "content");
        return J.a(b, content, i, i6);
    }
}
