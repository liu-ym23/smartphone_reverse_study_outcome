package d.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: FileReadWrite.kt */
/* JADX INFO: loaded from: classes4.dex */
class m extends l {

    /* JADX INFO: compiled from: FileReadWrite.kt */
    static final class a extends d.h.b.p implements d.h.a.b<String, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f38465a;

        a(ArrayList<String> r1) {
            this.f38465a = r1;
            super(1);
        }

        public final void a(String r2) {
            d.h.b.o.e(r2, "it");
            this.f38465a.add(r2);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(String r3) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final byte[] c(File r12) {
        d.h.b.o.e(r12, "<this>");
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r12), Closeable.class, "com.obric.aiagent.plugin");
        FileInputStream r1 = (FileInputStream) ZeusTransformUtils.preCheckCast(r0, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        long r3 = r12.length();     // Catch: Throwable -> L27
        if (r3 > 2147483647L) goto L26;
        int r4 = (int) r3;
        byte[] r5 = new byte[r4];     // Catch: Throwable -> L27
        int r7 = r4;
        int r8 = 0;
    L8:
        if (r7 <= 0) goto L13;
        int r9 = r1.read(r5, r8, r7);     // Catch: Throwable -> L27
        if (r9 < 0) goto L13;
        r7 = r7 - r9;
        r8 = r8 + r9;
    L13:
        if (r7 <= 0) goto L15;
        r5 = Arrays.copyOf(r5, r8);     // Catch: Throwable -> L27
        d.h.b.o.c(r5, "copyOf(...)");     // Catch: Throwable -> L27
    L21:
        c.a(r0, null);
        return r5;
    L15:
        int r10 = r1.read();     // Catch: Throwable -> L27
        if (r10 == (-1)) goto L21;
        e r11 = new e(8193);     // Catch: Throwable -> L27
        r11.write(r10);     // Catch: Throwable -> L27
        b.a((InputStream) ZeusTransformUtils.preCheckCast(r1, InputStream.class, "com.obric.aiagent.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r11, OutputStream.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L27
        int r2 = r11.size() + r4;     // Catch: Throwable -> L27
        if (r2 < 0) goto L24;
        byte[] r13 = r11.a();     // Catch: Throwable -> L27
        byte[] r6 = Arrays.copyOf(r5, r2);     // Catch: Throwable -> L27
        d.h.b.o.c(r6, "copyOf(...)");     // Catch: Throwable -> L27
        r5 = d.a.i.a(r13, r6, r4, 0, r11.size());     // Catch: Throwable -> L27
        goto L21
    L24:
        throw new OutOfMemoryError("File " + r12 + " is too big to fit in memory.");     // Catch: Throwable -> L27
    L26:
        throw new OutOfMemoryError("File " + r12 + " is too big (" + r3 + " bytes) to fit in memory.");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        c.a(r0, th);
        throw th;
    }

    public static final void a(File r2, byte[] r3) {
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r3, "array");
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r2), Closeable.class, "com.obric.aiagent.plugin");
        ((FileOutputStream) ZeusTransformUtils.preCheckCast(r4, FileOutputStream.class, "com.obric.aiagent.plugin")).write(r3);     // Catch: Throwable -> L6
        x r5 = x.f38692a;     // Catch: Throwable -> L6
        c.a(r4, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        c.a(r4, th);
        throw th;
    }

    public static final String a(File r3, Charset r4) {
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r4, "charset");
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r3), InputStream.class, "com.obric.aiagent.plugin"), r4), Closeable.class, "com.obric.aiagent.plugin");
        String r6 = t.a((Reader) ZeusTransformUtils.preCheckCast((InputStreamReader) ZeusTransformUtils.preCheckCast(r5, InputStreamReader.class, "com.obric.aiagent.plugin"), Reader.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L6
        c.a(r5, null);
        return r6;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        c.a(r5, th);
        throw th;
    }

    public static /* synthetic */ String a(File r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = d.o.d.f38623b;
    L6:
        return k.a(r0, r1);
    }

    public static /* synthetic */ void a(File r0, String r1, Charset r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = d.o.d.f38623b;
    L5:
        k.a(r0, r1, r2);
    }

    public static final void a(File r3, String r4, Charset r5) {
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r4, "text");
        d.h.b.o.e(r5, "charset");
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r3), Closeable.class, "com.obric.aiagent.plugin");
        k.a((OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r6, FileOutputStream.class, "com.obric.aiagent.plugin"), OutputStream.class, "com.obric.aiagent.plugin"), r4, r5);     // Catch: Throwable -> L6
        x r7 = x.f38692a;     // Catch: Throwable -> L6
        c.a(r6, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        c.a(r6, th);
        throw th;
    }

    public static /* synthetic */ void b(File r0, String r1, Charset r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = d.o.d.f38623b;
    L5:
        k.b(r0, r1, r2);
    }

    public static final void b(File r3, String r4, Charset r5) {
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r4, "text");
        d.h.b.o.e(r5, "charset");
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r3, true), Closeable.class, "com.obric.aiagent.plugin");
        k.a((OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r6, FileOutputStream.class, "com.obric.aiagent.plugin"), OutputStream.class, "com.obric.aiagent.plugin"), r4, r5);     // Catch: Throwable -> L6
        x r7 = x.f38692a;     // Catch: Throwable -> L6
        c.a(r6, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        c.a(r6, th);
        throw th;
    }

    public static final void a(OutputStream r9, String r10, Charset r11) {
        d.h.b.o.e(r9, "<this>");
        d.h.b.o.e(r10, "text");
        d.h.b.o.e(r11, "charset");
        if (r10.length() >= 16384) goto L6;
        byte[] r12 = r10.getBytes(r11);
        d.h.b.o.c(r12, "getBytes(...)");
        r9.write(r12);
        return;
    L6:
        CharsetEncoder r13 = k.a(r11);
        CharBuffer r1 = CharBuffer.allocate(8192);
        d.h.b.o.a(r13);
        ByteBuffer r0 = k.a(8192, r13);
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r3 >= r10.length()) goto L22;
        int r5 = Math.min(8192 - r4, r10.length() - r3);
        int r6 = r3 + r5;
        char[] r7 = r1.array();
        d.h.b.o.c(r7, "array(...)");
        r10.getChars(r3, r6, r7, r4);
        r1.limit(r5 + r4);
        r4 = 1;
        if (r6 != r10.length()) goto L12;
        boolean r8 = true;
    L14:
        if (r13.encode(r1, r0, r8).isUnderflow() == false) goto L21;
        r9.write(r0.array(), 0, r0.position());
        if (r1.position() == r1.limit()) goto L18;
        r1.put(0, r1.get());
    L19:
        r1.clear();
        r0.clear();
        r3 = r6;
        goto L8
    L18:
        r4 = 0;
        goto L19
    L21:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r8 = false;
        goto L14
    }

    public static final CharsetEncoder a(Charset r1) {
        d.h.b.o.e(r1, "<this>");
        return r1.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    public static final ByteBuffer a(int r2, CharsetEncoder r3) {
        d.h.b.o.e(r3, "encoder");
        ByteBuffer r4 = ByteBuffer.allocate(r2 * ((int) Math.ceil(r3.maxBytesPerChar())));
        d.h.b.o.c(r4, "allocate(...)");
        return r4;
    }

    public static final void a(File r4, Charset r5, d.h.a.b<? super String, x> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "charset");
        d.h.b.o.e(r7, "action");
        t.a((Reader) ZeusTransformUtils.preCheckCast(new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r4), InputStream.class, "com.obric.aiagent.plugin"), r5), Reader.class, "com.obric.aiagent.plugin")), Reader.class, "com.obric.aiagent.plugin"), r7);
    }

    public static /* synthetic */ List b(File r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = d.o.d.f38623b;
    L6:
        return k.b(r0, r1);
    }

    public static final List<String> b(File r4, Charset r5) {
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "charset");
        ArrayList r0 = new ArrayList();
        k.a(r4, r5, (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r0), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }
}
