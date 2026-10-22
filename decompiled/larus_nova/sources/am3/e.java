package am3;

import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.UByte;

/* JADX INFO: loaded from: classes14.dex */
public abstract class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f4365a = null;

    public e() {
    }

    static {
        f4365a = Charset.forName("UTF-8");
    }

    @Override // am3.f
    public final long readLongLe() throws IOException {
        long r100 = 0;
        int r101 = 0;
    L4:
        if (r101 >= 8) goto L6;
        r100 = r100 | ((((long) readByte()) & 255) << (r101 * 8));
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // am3.f
    public final int readIntLe() throws IOException {
        byte r100 = readByte();
        byte r101 = readByte();
        byte r102 = readByte();
        byte r103 = readByte();
        return (((r100 & UByte.MAX_VALUE) | ((r101 & UByte.MAX_VALUE) << 8)) | ((r102 & UByte.MAX_VALUE) << 16)) | ((r103 & UByte.MAX_VALUE) << 24);
    }
}
