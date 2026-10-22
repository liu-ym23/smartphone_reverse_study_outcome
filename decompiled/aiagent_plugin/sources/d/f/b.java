package d.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: IOStreams.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ long a(InputStream r0, OutputStream r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 8192;
    L6:
        return a(r0, r1, r2);
    }

    public static final long a(InputStream r5, OutputStream r6, int r7) {
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "out");
        byte[] r8 = new byte[r7];
        int r0 = r5.read(r8);
        long r1 = 0;
    L3:
        if (r0 < 0) goto L5;
        r6.write(r8, 0, r0);
        r1 = r1 + ((long) r0);
        r0 = r5.read(r8);
        goto L3
    L5:
        return r1;
    }

    public static final byte[] a(InputStream r5) {
        d.h.b.o.e(r5, "<this>");
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(Math.max(8192, r5.available()));
        a(r5, (OutputStream) ZeusTransformUtils.preCheckCast(r0, OutputStream.class, "com.obric.aiagent.plugin"), 0, 2, null);
        byte[] r6 = r0.toByteArray();
        d.h.b.o.c(r6, "toByteArray(...)");
        return r6;
    }
}
