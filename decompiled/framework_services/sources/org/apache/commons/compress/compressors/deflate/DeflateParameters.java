package org.apache.commons.compress.compressors.deflate;

/* JADX INFO: loaded from: classes3.dex */
public class DeflateParameters {
    private int compressionLevel;
    private boolean zlibHeader;

    public DeflateParameters() {
        this.zlibHeader = true;
        this.compressionLevel = -1;
    }

    public boolean withZlibHeader() {
        return this.zlibHeader;
    }

    public void setWithZlibHeader(boolean zlibHeader) {
        this.zlibHeader = zlibHeader;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int compressionLevel) {
        if (compressionLevel < (-1)) goto L9;
        if (compressionLevel > 9) goto L9;
        this.compressionLevel = compressionLevel;
        return;
    L9:
        throw new IllegalArgumentException("Invalid Deflate compression level: " + compressionLevel);
    }
}
