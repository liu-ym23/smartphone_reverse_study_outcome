package d.f;

import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: FileReadWrite.kt */
/* JADX INFO: loaded from: classes4.dex */
final class e extends ByteArrayOutputStream {
    public e(int r1) {
        super(r1);
    }

    public final byte[] a() {
        byte[] r1 = this.buf;
        d.h.b.o.c(r1, "buf");
        return r1;
    }
}
