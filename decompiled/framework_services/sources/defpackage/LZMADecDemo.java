package defpackage;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.LZMAInputStream;

/* JADX INFO: loaded from: classes2.dex */
class LZMADecDemo {
    LZMADecDemo() {
    }

    public static void main(String[] args) {
        byte[] buf = new byte[8192];
    L13:
        e = move-exception;
        System.err.println("LZMADecDemo: Cannot open null: " + e.getMessage());
        System.exit(1);
        return;
    L9:
        e = move-exception;
        System.err.println("LZMADecDemo: Error decompressing from null: " + e.getMessage());
        System.exit(1);
        return;
    L4:
        if (args.length != 0) goto L16;
        InputStream in = new LZMAInputStream(System.in);     // Catch: IOException -> L9 EOFException -> L11 FileNotFoundException -> L13
    L6:
        int size = in.read(buf);     // Catch: IOException -> L9 EOFException -> L11 FileNotFoundException -> L13
        if (size == (-1)) goto L43;
        System.out.write(buf, 0, size);     // Catch: IOException -> L9 EOFException -> L11 FileNotFoundException -> L13
        goto L6
    L43:
        return;
    L16:
        int i = 0;
    L18:
        if (i >= args.length) goto L46;
        String name = args[i];     // Catch: IOException -> L9 EOFException -> L11 FileNotFoundException -> L13
        InputStream in2 = new FileInputStream(name);     // Catch: IOException -> L9 EOFException -> L11 FileNotFoundException -> L13
        in2 = new LZMAInputStream(new BufferedInputStream(in2));     // Catch: Throwable -> L25
    L21:
        int size2 = in2.read(buf);     // Catch: Throwable -> L25
        if (size2 == (-1)) goto L28;
        System.out.write(buf, 0, size2);     // Catch: Throwable -> L25
        goto L21
    L28:
        in2.close();     // Catch: IOException -> L9 EOFException -> L11 FileNotFoundException -> L13
        i = i + 1;     // Catch: IOException -> L9 EOFException -> L11 FileNotFoundException -> L13
    L25:
        th = move-exception;
        in2.close();     // Catch: IOException -> L9 EOFException -> L11 FileNotFoundException -> L13
        throw th;     // Catch: IOException -> L9 EOFException -> L11 FileNotFoundException -> L13
    L46:
        return;
    L33:
        System.err.println("LZMADecDemo: Unexpected end of input on null");
        System.exit(1);
    }
}
