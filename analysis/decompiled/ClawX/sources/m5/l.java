package m5;

import a6.y;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import k4.v;
import k4.z;
import kotlin.jvm.internal.p;

/* loaded from: classes.dex */
public abstract class l extends v {
    public static String A0(File file) {
        String name = file.getName();
        p.d(name, "getName(...)");
        return x5.n.P1(name, ".");
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, java.util.List] */
    public static final c B0(c cVar) {
        File file = cVar.f3908a;
        ?? r62 = cVar.f3909b;
        ArrayList arrayList = new ArrayList(r62.size());
        for (File file2 : r62) {
            String name = file2.getName();
            if (!p.a(name, ".")) {
                if (!p.a(name, "..")) {
                    arrayList.add(file2);
                } else if (arrayList.isEmpty() || p.a(((File) c5.m.B0(arrayList)).getName(), "..")) {
                    arrayList.add(file2);
                }
            }
        }
        return new c(file, arrayList);
    }

    public static byte[] C0(File file) throws IOException {
        p.e(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i8 = (int) length;
            byte[] bArrCopyOf = new byte[i8];
            int i9 = i8;
            int i10 = 0;
            while (i9 > 0) {
                int i11 = fileInputStream.read(bArrCopyOf, i10, i9);
                if (i11 < 0) {
                    break;
                }
                i9 -= i11;
                i10 += i11;
            }
            if (i9 > 0) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i10);
                p.d(bArrCopyOf, "copyOf(...)");
            } else {
                int i12 = fileInputStream.read();
                if (i12 != -1) {
                    b bVar = new b(8193);
                    bVar.write(i12);
                    v.u(fileInputStream, bVar);
                    int size = bVar.size() + i8;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrA = bVar.a();
                    bArrCopyOf = Arrays.copyOf(bArrCopyOf, size);
                    p.d(bArrCopyOf, "copyOf(...)");
                    c5.l.U(i8, bArrA, 0, bArrCopyOf, bVar.size());
                }
            }
            fileInputStream.close();
            return bArrCopyOf;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                z.h(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static ArrayList D0(File file) throws IOException {
        Charset charset = x5.a.f6276a;
        p.e(file, "<this>");
        p.e(charset, "charset");
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
        try {
            Iterator it = new w5.a(new c5.k(2, bufferedReader)).iterator();
            while (it.hasNext()) {
                String it2 = (String) it.next();
                p.e(it2, "it");
                arrayList.add(it2);
            }
            bufferedReader.close();
            return arrayList;
        } finally {
        }
    }

    public static String E0(File file, Charset charset) throws IOException {
        p.e(file, "<this>");
        p.e(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strC = z.C(inputStreamReader);
            inputStreamReader.close();
            return strC;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String F0(java.io.File r10, java.io.File r11) {
        /*
            m5.c r0 = k4.v.o0(r10)
            m5.c r0 = B0(r0)
            java.lang.Object r1 = r0.f3909b
            m5.c r2 = k4.v.o0(r11)
            m5.c r2 = B0(r2)
            java.lang.Object r3 = r2.f3909b
            java.io.File r0 = r0.f3908a
            java.io.File r2 = r2.f3908a
            boolean r0 = r0.equals(r2)
            r2 = 0
            if (r0 != 0) goto L20
            goto L88
        L20:
            int r0 = r3.size()
            int r4 = r1.size()
            int r5 = java.lang.Math.min(r4, r0)
            r6 = 0
        L2d:
            if (r6 >= r5) goto L40
            java.lang.Object r7 = r1.get(r6)
            java.lang.Object r8 = r3.get(r6)
            boolean r7 = kotlin.jvm.internal.p.a(r7, r8)
            if (r7 == 0) goto L40
            int r6 = r6 + 1
            goto L2d
        L40:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r7 = r0 + (-1)
            if (r6 > r7) goto L6b
        L49:
            java.lang.Object r8 = r3.get(r7)
            java.io.File r8 = (java.io.File) r8
            java.lang.String r8 = r8.getName()
            java.lang.String r9 = ".."
            boolean r8 = kotlin.jvm.internal.p.a(r8, r9)
            if (r8 == 0) goto L5c
            goto L88
        L5c:
            r5.append(r9)
            if (r7 == r6) goto L66
            char r8 = java.io.File.separatorChar
            r5.append(r8)
        L66:
            if (r7 == r6) goto L6b
            int r7 = r7 + (-1)
            goto L49
        L6b:
            if (r6 >= r4) goto L84
            if (r6 >= r0) goto L74
            char r0 = java.io.File.separatorChar
            r5.append(r0)
        L74:
            java.util.List r0 = c5.m.r0(r1, r6)
            java.lang.String r1 = java.io.File.separator
            java.lang.String r3 = "separator"
            kotlin.jvm.internal.p.d(r1, r3)
            r3 = 124(0x7c, float:1.74E-43)
            c5.m.z0(r0, r5, r1, r2, r3)
        L84:
            java.lang.String r2 = r5.toString()
        L88:
            if (r2 == 0) goto L8b
            return r2
        L8b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "this and base files have different roots: "
            r1.<init>(r2)
            r1.append(r10)
            java.lang.String r10 = " and "
            r1.append(r10)
            r1.append(r11)
            r10 = 46
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.l.F0(java.io.File, java.io.File):java.lang.String");
    }

    public static void G0(File file, String text, Charset charset) {
        p.e(file, "<this>");
        p.e(text, "text");
        p.e(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            I0(fileOutputStream, text, charset);
            fileOutputStream.close();
        } finally {
        }
    }

    public static final void I0(FileOutputStream fileOutputStream, String text, Charset charset) throws IOException {
        p.e(text, "text");
        p.e(charset, "charset");
        if (text.length() < 16384) {
            byte[] bytes = text.getBytes(charset);
            p.d(bytes, "getBytes(...)");
            fileOutputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder charsetEncoderOnUnmappableCharacter = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        p.b(charsetEncoderOnUnmappableCharacter);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8192 * ((int) Math.ceil(charsetEncoderOnUnmappableCharacter.maxBytesPerChar())));
        p.d(byteBufferAllocate, "allocate(...)");
        int i8 = 0;
        int i9 = 0;
        while (i8 < text.length()) {
            int iMin = Math.min(8192 - i9, text.length() - i8);
            int i10 = i8 + iMin;
            char[] cArrArray = charBufferAllocate.array();
            p.d(cArrArray, "array(...)");
            text.getChars(i8, i10, cArrArray, i9);
            charBufferAllocate.limit(iMin + i9);
            i9 = 1;
            if (!charsetEncoderOnUnmappableCharacter.encode(charBufferAllocate, byteBufferAllocate, i10 == text.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            fileOutputStream.write(byteBufferAllocate.array(), 0, byteBufferAllocate.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i9 = 0;
            }
            charBufferAllocate.clear();
            byteBufferAllocate.clear();
            i8 = i10;
        }
    }

    public static void w0(File file, String text, Charset charset) {
        p.e(file, "<this>");
        p.e(text, "text");
        p.e(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            I0(fileOutputStream, text, charset);
            fileOutputStream.close();
        } finally {
        }
    }

    public static void x0(File file, File file2) throws IOException {
        y yVar = new y(13);
        if (!file.exists()) {
            yVar.invoke(file, new a(file, null, "The source file doesn't exist."));
            throw null;
        }
        try {
            h hVar = new h(new j(file, k.f3923a, new com.stepos.stepclaw.c(5, yVar)));
            while (hVar.hasNext()) {
                File file3 = (File) hVar.next();
                if (!file3.exists()) {
                    yVar.invoke(file3, new a(file3, null, "The source file doesn't exist."));
                    throw null;
                }
                File file4 = new File(file2, F0(file3, file));
                if (file4.exists() && (!file3.isDirectory() || !file4.isDirectory())) {
                    if (file4.isDirectory()) {
                        if (!z0(file4)) {
                            yVar.invoke(file4, new a(file3, file4, "The destination file already exists."));
                            throw null;
                        }
                    } else if (!file4.delete()) {
                        yVar.invoke(file4, new a(file3, file4, "The destination file already exists."));
                        throw null;
                    }
                }
                if (file3.isDirectory()) {
                    file4.mkdirs();
                } else {
                    y0(file3, file4);
                    if (file4.length() != file3.length()) {
                        yVar.invoke(file3, new IOException("Source file wasn't copied completely, length of destination file differs."));
                        throw null;
                    }
                }
            }
        } catch (o unused) {
        }
    }

    public static void y0(File file, File target) throws IOException {
        p.e(target, "target");
        if (!file.exists()) {
            throw new a(file, null, "The source file doesn't exist.");
        }
        if (target.exists() && !target.delete()) {
            throw new a(file, target, "Tried to overwrite the destination, but failed to delete it.");
        }
        if (file.isDirectory()) {
            if (!target.mkdirs()) {
                throw new androidx.datastore.preferences.protobuf.k(file, target, "Failed to create target directory.");
            }
            return;
        }
        File parentFile = target.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(target);
            try {
                v.u(fileInputStream, fileOutputStream);
                fileOutputStream.close();
                fileInputStream.close();
            } finally {
            }
        } finally {
        }
    }

    public static boolean z0(File file) {
        p.e(file, "<this>");
        h hVar = new h(new j(file, k.f3924b, null));
        while (true) {
            boolean z = true;
            while (hVar.hasNext()) {
                File file2 = (File) hVar.next();
                if (!file2.delete() && file2.exists()) {
                    z = false;
                } else {
                    if (z) {
                        break;
                    }
                    z = false;
                }
            }
            return z;
        }
    }
}
