package defpackage;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.LZMAOutputStream;

/* JADX INFO: loaded from: classes2.dex */
class LZMAEncDemo {
    LZMAEncDemo() {
    }

    public static void main(String[] args) throws Exception {
        LZMA2Options options = new LZMA2Options();
        long inputSize = -1;
        if (args.length < 1) goto L6;
        options.setPreset(Integer.parseInt(args[0]));
    L6:
        if (args.length < 2) goto L8;
        inputSize = Long.parseLong(args[1]);
    L8:
        System.err.println("Encoder memory usage: " + options.getEncoderMemoryUsage() + " KiB");
        System.err.println("Decoder memory usage: " + options.getDecoderMemoryUsage() + " KiB");
        OutputStream out = new BufferedOutputStream(System.out);
        LZMAOutputStream encoder = new LZMAOutputStream(out, options, inputSize);
        byte[] buf = new byte[8192];
    L9:
        int size = System.in.read(buf);
        if (size == (-1)) goto L12;
        encoder.write(buf, 0, size);
        goto L9
    L12:
        encoder.finish();
        out.flush();
    }
}
