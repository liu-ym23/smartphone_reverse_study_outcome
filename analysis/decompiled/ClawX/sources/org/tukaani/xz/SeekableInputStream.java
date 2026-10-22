package org.tukaani.xz;

import java.io.InputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class SeekableInputStream extends InputStream {
    public abstract long length();

    public abstract long position();

    public abstract void seek(long j4);

    @Override // java.io.InputStream
    public long skip(long j4) {
        if (j4 <= 0) {
            return 0L;
        }
        long length = length();
        long jPosition = position();
        if (jPosition >= length) {
            return 0L;
        }
        long j8 = length - jPosition;
        if (j8 < j4) {
            j4 = j8;
        }
        seek(jPosition + j4);
        return j4;
    }
}
