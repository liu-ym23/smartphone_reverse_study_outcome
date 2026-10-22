package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.BasicArrayCache;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZInputStream;
import org.tukaani.xz.XZOutputStream;

/* JADX INFO: loaded from: classes2.dex */
class TestAllocSpeed implements Runnable {
    private static boolean compressing;
    private static volatile IOException exception;
    private static int repeats;
    private static final byte[] testdata = null;
    private static int testdataSize;
    private final Random rng;

    static {
        testdata = new byte[1048576];
        exception = null;
    }

    public TestAllocSpeed(long seed) {
        this.rng = new Random(seed);
    }

    private void compress() throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(testdataSize + 1024);
        LZMA2Options options = new LZMA2Options();
        options.setDictSize(1 << (this.rng.nextInt(6) + 16));
        int i = 0;
    L4:
        if (i >= repeats) goto L7;
        XZOutputStream out = new XZOutputStream(byteStream, options);
        out.write(testdata, 0, testdataSize);
        out.finish();
        i = i + 1;
        goto L4
    }

    private void decompress() throws IOException {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(testdata, 0, testdataSize);
        byte[] outbuf = new byte[8192];
        int i = 0;
    L4:
        if (i >= repeats) goto L11;
        byteStream.reset();
        XZInputStream in = new XZInputStream(byteStream);
    L7:
        if (in.read(outbuf) > 0) goto L7;
        i = i + 1;
        goto L4
    }

    @Override // java.lang.Runnable
    public void run() {
    L5:
        e = move-exception;
        exception = e;
        return;
    L3:
        if (compressing == false) goto L7;
        compress();     // Catch: IOException -> L5
    L11:
        return;
    L7:
        decompress();     // Catch: IOException -> L5
        goto L11
    }

    public static void main(String[] args) throws Exception {
        compressing = Boolean.parseBoolean(args[0]);
        repeats = Integer.parseInt(args[1]);
        int threadCount = Integer.parseInt(args[2]);
        if (threadCount < 1) goto L18;
        if (threadCount > 64) goto L18;
        testdataSize = System.in.read(testdata);
        ArrayCache.setDefaultCache(BasicArrayCache.getInstance());
        Thread[] threads = new Thread[threadCount];
        int i = 0;
    L7:
        if (i >= threadCount) goto L9;
        threads[i] = new Thread(new TestAllocSpeed(i));
        threads[i].start();
        i = i + 1;
        goto L7
    L9:
        int i2 = 0;
    L10:
        if (i2 >= threadCount) goto L13;
        threads[i2].join();
        i2 = i2 + 1;
        goto L10
    L13:
        if (exception != null) goto L16;
        return;
    L16:
        throw exception;
    L18:
        throw new Exception("Thread count must be 1-64");
    }
}
