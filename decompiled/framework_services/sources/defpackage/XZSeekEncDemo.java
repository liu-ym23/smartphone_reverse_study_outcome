package defpackage;

import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZOutputStream;

/* JADX INFO: loaded from: classes2.dex */
class XZSeekEncDemo {
    XZSeekEncDemo() {
    }

    public static void main(String[] args) throws Exception {
        LZMA2Options options = new LZMA2Options();
        if (args.length < 1) goto L5;
        options.setPreset(Integer.parseInt(args[0]));
    L5:
        int blockSize = 1048576;
        if (args.length < 2) goto L8;
        blockSize = Integer.parseInt(args[1]);
    L8:
        options.setDictSize(Math.min(options.getDictSize(), Math.max(4096, blockSize)));
        System.err.println("Encoder memory usage: " + options.getEncoderMemoryUsage() + " KiB");
        System.err.println("Decoder memory usage: " + options.getDecoderMemoryUsage() + " KiB");
        System.err.println("Block size:           " + blockSize + " B");
        XZOutputStream out = new XZOutputStream(System.out, options);
        byte[] buf = new byte[8192];
        int left = blockSize;
    L9:
        int size = System.in.read(buf, 0, Math.min(buf.length, left));
        if (size == (-1)) goto L11;
        out.write(buf, 0, size);
        left = left - size;
        if (left != 0) goto L9;
        out.endBlock();
        left = blockSize;
        goto L9
    L11:
        out.finish();
    }
}
