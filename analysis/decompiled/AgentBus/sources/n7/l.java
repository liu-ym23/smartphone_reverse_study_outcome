package n7;

import d7.q;
import fi.iki.elonen.NanoHTTPD;
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

/* loaded from: classes.dex */
public abstract class l extends m {
    public static void J(File file, File file2) throws IOException {
        q7.k.e(file, "<this>");
        q7.k.e(file2, "target");
        if (!file.exists()) {
            throw new d(file, null, "The source file doesn't exist.");
        }
        if (file2.exists() && !file2.delete()) {
            throw new d(file, file2, "Tried to overwrite the destination, but failed to delete it.");
        }
        if (file.isDirectory()) {
            if (!file2.mkdirs()) {
                throw new androidx.datastore.preferences.protobuf.l(file, file2, "Failed to create target directory.");
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
                a.f(fileInputStream, fileOutputStream);
                fileOutputStream.close();
                fileInputStream.close();
            } finally {
            }
        } finally {
        }
    }

    public static void K(File file) {
        q7.k.e(file, "<this>");
        k kVar = k.f6870f;
        i iVar = new i(new fa.i(file));
        while (true) {
            boolean z4 = true;
            while (iVar.hasNext()) {
                File file2 = (File) iVar.next();
                if (!file2.delete() && file2.exists()) {
                    z4 = false;
                } else if (z4) {
                    break;
                } else {
                    z4 = false;
                }
            }
            return;
        }
    }

    public static byte[] L(File file) {
        q7.k.e(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i2 = (int) length;
            byte[] bArrCopyOf = new byte[i2];
            int i10 = i2;
            int i11 = 0;
            while (i10 > 0) {
                int i12 = fileInputStream.read(bArrCopyOf, i11, i10);
                if (i12 < 0) {
                    break;
                }
                i10 -= i12;
                i11 += i12;
            }
            if (i10 > 0) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i11);
                q7.k.d(bArrCopyOf, "copyOf(...)");
            } else {
                int i13 = fileInputStream.read();
                if (i13 != -1) {
                    c cVar = new c(8193);
                    cVar.write(i13);
                    a.f(fileInputStream, cVar);
                    int size = cVar.size() + i2;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrB = cVar.b();
                    bArrCopyOf = Arrays.copyOf(bArrCopyOf, size);
                    q7.k.d(bArrCopyOf, "copyOf(...)");
                    d7.n.V(i2, 0, cVar.size(), bArrB, bArrCopyOf);
                }
            }
            fileInputStream.close();
            return bArrCopyOf;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.d(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static ArrayList M(File file) throws IOException {
        Charset charset = ga.a.f4005a;
        q7.k.e(charset, "charset");
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
        try {
            Iterator it = new fa.a(new q(4, bufferedReader)).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                q7.k.e(str, "it");
                arrayList.add(str);
            }
            bufferedReader.close();
            return arrayList;
        } finally {
        }
    }

    public static String N(File file) throws IOException {
        Charset charset = ga.a.f4005a;
        q7.k.e(file, "<this>");
        q7.k.e(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strW = o.w(inputStreamReader);
            inputStreamReader.close();
            return strW;
        } finally {
        }
    }

    public static File O(File file, String str) {
        int length;
        int iQ0;
        q7.k.e(file, "<this>");
        q7.k.e(str, "relative");
        File file2 = new File(str);
        String path = file2.getPath();
        q7.k.d(path, "getPath(...)");
        char c10 = File.separatorChar;
        int iQ02 = ga.k.q0(path, c10, 0, 4);
        if (iQ02 != 0) {
            length = (iQ02 <= 0 || path.charAt(iQ02 + (-1)) != ':') ? (iQ02 == -1 && ga.k.n0(path, ':')) ? path.length() : 0 : iQ02 + 1;
        } else if (path.length() <= 1 || path.charAt(1) != c10 || (iQ0 = ga.k.q0(path, c10, 2, 4)) < 0) {
            length = 1;
        } else {
            int iQ03 = ga.k.q0(path, c10, iQ0 + 1, 4);
            length = iQ03 >= 0 ? iQ03 + 1 : path.length();
        }
        if (length > 0) {
            return file2;
        }
        String string = file.toString();
        q7.k.d(string, "toString(...)");
        if ((string.length() == 0) || ga.k.n0(string, c10)) {
            return new File(string + file2);
        }
        return new File(string + c10 + file2);
    }

    public static void P(File file, byte[] bArr) throws IOException {
        q7.k.e(file, "<this>");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } finally {
        }
    }

    public static void Q(File file, String str) throws IOException {
        Charset charset = ga.a.f4005a;
        q7.k.e(file, "<this>");
        q7.k.e(str, "text");
        q7.k.e(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            R(fileOutputStream, str, charset);
            fileOutputStream.close();
        } finally {
        }
    }

    public static final void R(FileOutputStream fileOutputStream, String str, Charset charset) throws IOException {
        q7.k.e(str, "text");
        q7.k.e(charset, "charset");
        if (str.length() < 16384) {
            byte[] bytes = str.getBytes(charset);
            q7.k.d(bytes, "getBytes(...)");
            fileOutputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder charsetEncoderOnUnmappableCharacter = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer charBufferAllocate = CharBuffer.allocate(NanoHTTPD.HTTPSession.BUFSIZE);
        q7.k.b(charsetEncoderOnUnmappableCharacter);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(NanoHTTPD.HTTPSession.BUFSIZE * ((int) Math.ceil(charsetEncoderOnUnmappableCharacter.maxBytesPerChar())));
        q7.k.d(byteBufferAllocate, "allocate(...)");
        int i2 = 0;
        int i10 = 0;
        while (i2 < str.length()) {
            int iMin = Math.min(8192 - i10, str.length() - i2);
            int i11 = i2 + iMin;
            char[] cArrArray = charBufferAllocate.array();
            q7.k.d(cArrArray, "array(...)");
            str.getChars(i2, i11, cArrArray, i10);
            charBufferAllocate.limit(iMin + i10);
            i10 = 1;
            if (!charsetEncoderOnUnmappableCharacter.encode(charBufferAllocate, byteBufferAllocate, i11 == str.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            fileOutputStream.write(byteBufferAllocate.array(), 0, byteBufferAllocate.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i10 = 0;
            }
            charBufferAllocate.clear();
            byteBufferAllocate.clear();
            i2 = i11;
        }
    }
}
