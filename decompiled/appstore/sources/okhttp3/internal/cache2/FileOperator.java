package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;

/* JADX INFO: loaded from: classes4.dex */
final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel r10) {
        this.fileChannel = r10;
    }

    public void read(long r10, Buffer r12, long r13) throws IOException {
        if (r13 < 0) goto L9;
    L5:
        if (r13 <= 0) goto L7;
        long r11 = this.fileChannel.transferTo(r10, r13, r12);
        r10 = r10 + r11;
        r13 = r13 - r11;
        goto L5
    L7:
        return;
    L9:
        throw new IndexOutOfBoundsException();
    }

    public void write(long r10, Buffer r12, long r13) throws IOException {
        if (r13 < 0) goto L11;
        if (r13 > r12.size()) goto L11;
    L7:
        if (r13 <= 0) goto L9;
        long r11 = this.fileChannel.transferFrom(r12, r10, r13);
        r10 = r10 + r11;
        r13 = r13 - r11;
        goto L7
    L9:
        return;
    L11:
        throw new IndexOutOfBoundsException();
    }
}
