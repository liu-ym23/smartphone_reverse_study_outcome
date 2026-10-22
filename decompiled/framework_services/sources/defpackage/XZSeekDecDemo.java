package defpackage;

import org.tukaani.xz.SeekableFileInputStream;
import org.tukaani.xz.SeekableXZInputStream;

/* JADX INFO: loaded from: classes2.dex */
class XZSeekDecDemo {
    XZSeekDecDemo() {
    }

    public static void main(String[] args) throws Exception {
        SeekableFileInputStream file = new SeekableFileInputStream(args[0]);
        SeekableXZInputStream in = new SeekableXZInputStream(file);
        System.err.println("Number of XZ Streams: " + in.getStreamCount());
        System.err.println("Number of XZ Blocks: " + in.getBlockCount());
        System.err.println("Uncompressed size: " + in.length() + " B");
        System.err.println("Largest XZ Block size: " + in.getLargestBlockSize() + " B");
        System.err.print("List of Check IDs:");
        int checkTypes = in.getCheckTypes();
        int i = 0;
    L4:
        if (i >= 16) goto L9;
        if (((1 << i) & checkTypes) == 0) goto L8;
        System.err.print(" " + i);
    L8:
        i = i + 1;
        goto L4
    L9:
        System.err.println();
        System.err.println("Index memory usage: " + in.getIndexMemoryUsage() + " KiB");
        byte[] buf = new byte[8192];
        if (args.length != 1) goto L15;
    L11:
        int size = in.read(buf);
        if (size == (-1)) goto L25;
        System.out.write(buf, 0, size);
        goto L11
    L25:
        return;
    L15:
        int i2 = 1;
    L17:
        if (i2 >= args.length) goto L34;
        int pos = Integer.parseInt(args[i2]);
        int len = Integer.parseInt(args[i2 + 1]);
        in.seek(pos);
    L19:
        if (len <= 0) goto L24;
        int size2 = in.read(buf, 0, Math.min(len, buf.length));
        if (size2 != (-1)) goto L23;
        System.err.println("Error: End of file reached");
        System.exit(1);
    L23:
        System.out.write(buf, 0, size2);
        len = len - size2;
        goto L19
    L24:
        i2 = i2 + 2;
        goto L17
    }
}
