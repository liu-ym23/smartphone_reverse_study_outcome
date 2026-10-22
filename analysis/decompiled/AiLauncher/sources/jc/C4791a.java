package jc;

import com.stepos.agentframework.chatui.longtext.b;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: jc.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4791a {
    public static int a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[b.THRESHOLD];
        int i10 = 0;
        while (true) {
            int i11 = inputStream.read(bArr);
            if (i11 == -1) {
                return i10;
            }
            outputStream.write(bArr, 0, i11);
            i10 += i11;
        }
    }

    public static void b(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
