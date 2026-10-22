package org.tukaani.xz;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class CountingInputStream extends CloseIgnoringInputStream {
    private long size;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
        this.size = 0L;
    }

    public long getSize() {
        return this.size;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i8 = ((FilterInputStream) this).in.read();
        if (i8 != -1) {
            long j4 = this.size;
            if (j4 >= 0) {
                this.size = j4 + 1;
            }
        }
        return i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        int i10 = ((FilterInputStream) this).in.read(bArr, i8, i9);
        if (i10 > 0) {
            long j4 = this.size;
            if (j4 >= 0) {
                this.size = j4 + i10;
            }
        }
        return i10;
    }
}
