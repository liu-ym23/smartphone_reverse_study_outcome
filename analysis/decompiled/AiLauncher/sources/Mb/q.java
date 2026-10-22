package Mb;

import androidx.exifinterface.media.ExifInterface;
import java.io.RandomAccessFile;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"LMb/q;", "LMb/g;", "", "readWrite", "Ljava/io/RandomAccessFile;", "randomAccessFile", "<init>", "(ZLjava/io/RandomAccessFile;)V", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()J", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "n", "(J[BII)I", "LY8/t;", "m", "()V", "e", "Ljava/io/RandomAccessFile;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class q extends AbstractC0969g {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final RandomAccessFile randomAccessFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(boolean z10, RandomAccessFile randomAccessFile) {
        super(z10);
        kotlin.jvm.internal.p.i(randomAccessFile, "randomAccessFile");
        this.randomAccessFile = randomAccessFile;
    }

    @Override // Mb.AbstractC0969g
    public synchronized long A() {
        return this.randomAccessFile.length();
    }

    @Override // Mb.AbstractC0969g
    public synchronized void m() {
        this.randomAccessFile.close();
    }

    @Override // Mb.AbstractC0969g
    public synchronized int n(long fileOffset, byte[] array, int arrayOffset, int byteCount) {
        kotlin.jvm.internal.p.i(array, "array");
        this.randomAccessFile.seek(fileOffset);
        int i10 = 0;
        while (true) {
            if (i10 >= byteCount) {
                break;
            }
            int i11 = this.randomAccessFile.read(array, arrayOffset, byteCount - i10);
            if (i11 != -1) {
                i10 += i11;
            } else if (i10 == 0) {
                return -1;
            }
        }
        return i10;
    }
}
