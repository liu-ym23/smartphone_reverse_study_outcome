package kotlin.io;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final long a(InputStream r10, OutputStream r11, int r12) {
        q.g(r10, "<this>");
        q.g(r11, "out");
        byte[] r13 = new byte[r12];
        int r14 = r10.read(r13);
        long r15 = 0;
    L3:
        if (r14 < 0) goto L5;
        r11.write(r13, 0, r14);
        r15 = r15 + ((long) r14);
        r14 = r10.read(r13);
        goto L3
    L5:
        return r15;
    }
}
