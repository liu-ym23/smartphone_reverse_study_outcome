package y2;

import e3.C1417f;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* renamed from: y2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2129b extends PrintWriter {

    /* renamed from: a, reason: collision with root package name */
    public MessageDigest f6889a;
    public Charset b;
    public C1417f c;

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(int i) {
        super.write(i);
        MessageDigest messageDigest = this.f6889a;
        if (messageDigest != null) {
            messageDigest.update((byte) i);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(String str, int i, int i6) {
        super.write(str, i, i6);
        MessageDigest messageDigest = this.f6889a;
        if (messageDigest != null) {
            C1417f c1417f = this.c;
            if (c1417f == null || c1417f.a(str)) {
                messageDigest.update(this.b.encode(CharBuffer.wrap(str, i, i6 + i)).array());
            }
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(char[] cArr, int i, int i6) {
        super.write(cArr, i, i6);
        MessageDigest messageDigest = this.f6889a;
        if (messageDigest != null) {
            messageDigest.update(this.b.encode(CharBuffer.wrap(cArr)).array());
        }
    }
}
