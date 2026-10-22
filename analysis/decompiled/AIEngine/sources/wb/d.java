package wb;

import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.ability.speech.PcmDumpBudget;
import gc.q;
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
import java.util.List;
import kotlin.io.FileAlreadyExistsException;
import kotlin.io.FileSystemException;
import kotlin.io.FileWalkDirection;
import kotlin.io.NoSuchFileException;
import kotlin.jvm.internal.g;
import lb.n;
import mb.y;
import wb.c;
import wb.c.b;

/* loaded from: classes.dex */
public final class d extends jd.b {
    public static void S(File file, File file2, boolean z) throws IOException {
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, "The source file doesn't exist.");
        }
        if (file2.exists()) {
            if (!z) {
                throw new FileAlreadyExistsException(file, file2, "The destination file already exists.");
            }
            if (!file2.delete()) {
                throw new FileAlreadyExistsException(file, file2, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (file.isDirectory()) {
            if (!file2.mkdirs()) {
                throw new FileSystemException(file, file2, "Failed to create target directory.");
            }
            return;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                jd.b.n(fileInputStream, fileOutputStream);
                fileOutputStream.close();
                fileInputStream.close();
            } finally {
            }
        } finally {
        }
    }

    public static boolean T(File file) {
        g.f(file, "<this>");
        c.b bVar = new c(file, FileWalkDirection.f10070b, null).new b();
        while (true) {
            boolean z = true;
            while (bVar.hasNext()) {
                File next = bVar.next();
                if (!next.delete() && next.exists()) {
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

    public static String U(File file) {
        g.f(file, "<this>");
        String name = file.getName();
        g.e(name, "getName(...)");
        return q.H0(name, '.', "");
    }

    public static String V(File file) {
        g.f(file, "<this>");
        String name = file.getName();
        g.e(name, "getName(...)");
        int iU0 = q.u0(6, name, ".");
        if (iU0 == -1) {
            return name;
        }
        String strSubstring = name.substring(0, iU0);
        g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final b W(b bVar) {
        File file = bVar.f13653a;
        List<File> list = bVar.f13654b;
        ArrayList arrayList = new ArrayList(list.size());
        for (File file2 : list) {
            String name = file2.getName();
            if (!g.b(name, ".")) {
                if (!g.b(name, "..")) {
                    arrayList.add(file2);
                } else if (arrayList.isEmpty() || g.b(((File) kotlin.collections.a.A0(arrayList)).getName(), "..")) {
                    arrayList.add(file2);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return new b(file, arrayList);
    }

    public static byte[] X(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i10 = (int) length;
            byte[] bArrCopyOf = new byte[i10];
            int i11 = i10;
            int i12 = 0;
            while (i11 > 0) {
                int i13 = fileInputStream.read(bArrCopyOf, i12, i11);
                if (i13 < 0) {
                    break;
                }
                i11 -= i13;
                i12 += i13;
            }
            if (i11 > 0) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i12);
                g.e(bArrCopyOf, "copyOf(...)");
            } else {
                int i14 = fileInputStream.read();
                if (i14 != -1) {
                    a aVar = new a(8193);
                    aVar.write(i14);
                    jd.b.n(fileInputStream, aVar);
                    int size = aVar.size() + i10;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrA = aVar.a();
                    bArrCopyOf = Arrays.copyOf(bArrCopyOf, size);
                    g.e(bArrCopyOf, "copyOf(...)");
                    b1.n(i10, 0, aVar.size(), bArrA, bArrCopyOf);
                }
            }
            fileInputStream.close();
            return bArrCopyOf;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                y.q(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static ArrayList Y(File file) throws IOException {
        Charset charset = gc.a.f9106b;
        g.f(charset, "charset");
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
        try {
            Iterator it = new fc.a(new e(bufferedReader)).iterator();
            while (it.hasNext()) {
                String it2 = (String) it.next();
                g.f(it2, "it");
                arrayList.add(it2);
                n nVar = n.f10413a;
            }
            n nVar2 = n.f10413a;
            bufferedReader.close();
            return arrayList;
        } finally {
        }
    }

    public static String Z(File file, Charset charset) throws IOException {
        g.f(file, "<this>");
        g.f(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strF = jd.b.F(inputStreamReader);
            inputStreamReader.close();
            return strF;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.File a0(java.io.File r11, java.io.File r12) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.g.f(r11, r0)
            java.lang.String r0 = "base"
            kotlin.jvm.internal.g.f(r12, r0)
            java.io.File r0 = new java.io.File
            wb.b r1 = jd.b.L(r11)
            wb.b r1 = W(r1)
            java.util.List<java.io.File> r2 = r1.f13654b
            wb.b r3 = jd.b.L(r12)
            wb.b r3 = W(r3)
            java.util.List<java.io.File> r4 = r3.f13654b
            java.io.File r1 = r1.f13653a
            java.io.File r3 = r3.f13653a
            boolean r1 = r1.equals(r3)
            r3 = 0
            if (r1 != 0) goto L2c
            goto L94
        L2c:
            int r1 = r4.size()
            int r5 = r2.size()
            int r6 = java.lang.Math.min(r5, r1)
            r7 = 0
        L39:
            if (r7 >= r6) goto L4c
            java.lang.Object r8 = r2.get(r7)
            java.lang.Object r9 = r4.get(r7)
            boolean r8 = kotlin.jvm.internal.g.b(r8, r9)
            if (r8 == 0) goto L4c
            int r7 = r7 + 1
            goto L39
        L4c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r8 = r1 + (-1)
            if (r7 > r8) goto L77
        L55:
            java.lang.Object r9 = r4.get(r8)
            java.io.File r9 = (java.io.File) r9
            java.lang.String r9 = r9.getName()
            java.lang.String r10 = ".."
            boolean r9 = kotlin.jvm.internal.g.b(r9, r10)
            if (r9 == 0) goto L68
            goto L94
        L68:
            r6.append(r10)
            if (r8 == r7) goto L72
            char r9 = java.io.File.separatorChar
            r6.append(r9)
        L72:
            if (r8 == r7) goto L77
            int r8 = r8 + (-1)
            goto L55
        L77:
            if (r7 >= r5) goto L90
            if (r7 >= r1) goto L80
            char r1 = java.io.File.separatorChar
            r6.append(r1)
        L80:
            java.util.List r1 = kotlin.collections.a.p0(r7, r2)
            java.lang.String r2 = java.io.File.separator
            java.lang.String r4 = "separator"
            kotlin.jvm.internal.g.e(r2, r4)
            r4 = 124(0x7c, float:1.74E-43)
            kotlin.collections.a.y0(r1, r6, r2, r3, r4)
        L90:
            java.lang.String r3 = r6.toString()
        L94:
            if (r3 == 0) goto L9a
            r0.<init>(r3)
            return r0
        L9a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "this and base files have different roots: "
            r1.<init>(r2)
            r1.append(r11)
            java.lang.String r11 = " and "
            r1.append(r11)
            r1.append(r12)
            r11 = 46
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.d.a0(java.io.File, java.io.File):java.io.File");
    }

    public static c b0(File file) {
        g.f(file, "<this>");
        return new c(file, FileWalkDirection.f10069a, null);
    }

    public static void c0(File file, byte[] array) throws IOException {
        g.f(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            n nVar = n.f10413a;
            fileOutputStream.close();
        } finally {
        }
    }

    public static void d0(File file, String text, Charset charset) throws IOException {
        g.f(file, "<this>");
        g.f(text, "text");
        g.f(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            f0(fileOutputStream, text, charset);
            n nVar = n.f10413a;
            fileOutputStream.close();
        } finally {
        }
    }

    public static /* synthetic */ void e0(File file, String str) throws IOException {
        d0(file, str, gc.a.f9106b);
    }

    public static final void f0(FileOutputStream fileOutputStream, String text, Charset charset) throws IOException {
        g.f(text, "text");
        g.f(charset, "charset");
        if (text.length() < 16384) {
            byte[] bytes = text.getBytes(charset);
            g.e(bytes, "getBytes(...)");
            fileOutputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder charsetEncoderOnUnmappableCharacter = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer charBufferAllocate = CharBuffer.allocate(PcmDumpBudget.HARD_MAX_DIR_MB);
        g.c(charsetEncoderOnUnmappableCharacter);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(PcmDumpBudget.HARD_MAX_DIR_MB * ((int) Math.ceil(charsetEncoderOnUnmappableCharacter.maxBytesPerChar())));
        g.e(byteBufferAllocate, "allocate(...)");
        int i10 = 0;
        int i11 = 0;
        while (i10 < text.length()) {
            int iMin = Math.min(8192 - i11, text.length() - i10);
            int i12 = i10 + iMin;
            char[] cArrArray = charBufferAllocate.array();
            g.e(cArrArray, "array(...)");
            text.getChars(i10, i12, cArrArray, i11);
            charBufferAllocate.limit(iMin + i11);
            i11 = 1;
            if (!charsetEncoderOnUnmappableCharacter.encode(charBufferAllocate, byteBufferAllocate, i12 == text.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            fileOutputStream.write(byteBufferAllocate.array(), 0, byteBufferAllocate.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i11 = 0;
            }
            charBufferAllocate.clear();
            byteBufferAllocate.clear();
            i10 = i12;
        }
    }
}
