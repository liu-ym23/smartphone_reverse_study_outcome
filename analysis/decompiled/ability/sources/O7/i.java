package O7;

import D7.N;
import D7.q;
import D7.t;
import androidx.collection.SieveCacheKt;
import i9.C1566a;
import j9.AbstractC1607a;
import j9.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.io.FileAlreadyExistsException;
import kotlin.io.FileSystemException;
import kotlin.io.FileWalkDirection;
import kotlin.io.NoSuchFileException;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public abstract class i extends N9.j {
    public static void S(File file, File file2) throws IOException {
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, "The source file doesn't exist.");
        }
        if (file2.exists() && !file2.delete()) {
            throw new FileAlreadyExistsException(file, file2, "Tried to overwrite the destination, but failed to delete it.");
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
                M0.i.s(fileInputStream, fileOutputStream);
                fileOutputStream.close();
                fileInputStream.close();
            } finally {
            }
        } finally {
        }
    }

    public static boolean T(File file) {
        FileWalkDirection fileWalkDirection = FileWalkDirection.f4914a;
        f fVar = new f(new h(file));
        while (true) {
            boolean z10 = true;
            while (fVar.hasNext()) {
                File file2 = (File) fVar.next();
                if (!file2.delete() && file2.exists()) {
                    z10 = false;
                } else {
                    if (z10) {
                        break;
                    }
                    z10 = false;
                }
            }
            return z10;
        }
    }

    public static String U(File file) {
        k.f(file, "<this>");
        String name = file.getName();
        k.e(name, "getName(...)");
        return m.M0(name, name);
    }

    public static byte[] V(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > SieveCacheKt.NodeLinkMask) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i = (int) length;
            byte[] bArrCopyOf = new byte[i];
            int i6 = i;
            int i10 = 0;
            while (i6 > 0) {
                int i11 = fileInputStream.read(bArrCopyOf, i10, i6);
                if (i11 < 0) {
                    break;
                }
                i6 -= i11;
                i10 += i11;
            }
            if (i6 > 0) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i10);
                k.e(bArrCopyOf, "copyOf(...)");
            } else {
                int i12 = fileInputStream.read();
                if (i12 != -1) {
                    a aVar = new a(8193);
                    aVar.write(i12);
                    M0.i.s(fileInputStream, aVar);
                    int size = aVar.size() + i;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrB = aVar.b();
                    bArrCopyOf = Arrays.copyOf(bArrCopyOf, size);
                    k.e(bArrCopyOf, "copyOf(...)");
                    q.S(bArrB, i, 0, bArrCopyOf, aVar.size());
                }
            }
            fileInputStream.close();
            return bArrCopyOf;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                N.t(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static ArrayList W(File file) throws IOException {
        Charset charset = AbstractC1607a.f4778a;
        k.f(charset, "charset");
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
        try {
            Iterator it = new C1566a(new t(bufferedReader, 2)).iterator();
            while (it.hasNext()) {
                String it2 = (String) it.next();
                k.f(it2, "it");
                arrayList.add(it2);
            }
            bufferedReader.close();
            return arrayList;
        } finally {
        }
    }

    public static String X(File file, Charset charset) {
        k.f(file, "<this>");
        k.f(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strO1 = S0.b.o1(inputStreamReader);
            inputStreamReader.close();
            return strO1;
        } finally {
        }
    }

    public static void Y(File file, String text) {
        Charset charset = AbstractC1607a.f4778a;
        k.f(file, "<this>");
        k.f(text, "text");
        k.f(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            Z(fileOutputStream, text, charset);
            fileOutputStream.close();
        } finally {
        }
    }

    public static void Z(OutputStream outputStream, String text, Charset charset) throws IOException {
        k.f(text, "text");
        k.f(charset, "charset");
        if (text.length() < 16384) {
            byte[] bytes = text.getBytes(charset);
            k.e(bytes, "getBytes(...)");
            outputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder charsetEncoderOnUnmappableCharacter = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        k.c(charsetEncoderOnUnmappableCharacter);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8192 * ((int) Math.ceil(charsetEncoderOnUnmappableCharacter.maxBytesPerChar())));
        k.e(byteBufferAllocate, "allocate(...)");
        int i = 0;
        int i6 = 0;
        while (i < text.length()) {
            int iMin = Math.min(8192 - i6, text.length() - i);
            int i10 = i + iMin;
            char[] cArrArray = charBufferAllocate.array();
            k.e(cArrArray, "array(...)");
            text.getChars(i, i10, cArrArray, i6);
            charBufferAllocate.limit(iMin + i6);
            i6 = 1;
            if (!charsetEncoderOnUnmappableCharacter.encode(charBufferAllocate, byteBufferAllocate, i10 == text.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            outputStream.write(byteBufferAllocate.array(), 0, byteBufferAllocate.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i6 = 0;
            }
            charBufferAllocate.clear();
            byteBufferAllocate.clear();
            i = i10;
        }
    }
}
