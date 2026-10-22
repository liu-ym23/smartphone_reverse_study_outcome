package O7;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a extends ByteArrayOutputStream {
    public final byte[] b() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        k.e(buf, "buf");
        return buf;
    }
}
