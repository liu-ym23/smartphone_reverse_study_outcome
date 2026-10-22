package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;

/* JADX INFO: loaded from: classes5.dex */
final class FileOperator {
    private final FileChannel fileChannel;

    FileOperator(FileChannel r1) {
        this.fileChannel = r1;
    }

    public void write(long r10, Buffer r12, long r13) throws IOException {
        if (r13 < 0) goto L11;
        if (r13 > r12.size()) goto L11;
    L7:
        if (r13 <= 0) goto L9;
        long r2 = this.fileChannel.transferFrom(r12, r10, r13);
        r10 = r10 + r2;
        r13 = r13 - r2;
        goto L7
    L9:
        return;
    L11:
        throw new IndexOutOfBoundsException();
    }

    public void read(long r10, Buffer r12, long r13) throws IOException {
        if (r13 < 0) goto L9;
    L5:
        if (r13 <= 0) goto L7;
        long r2 = this.fileChannel.transferTo(r10, r13, r12);
        r10 = r10 + r2;
        r13 = r13 - r2;
        goto L5
    L7:
        return;
    L9:
        throw new IndexOutOfBoundsException();
    }
}
