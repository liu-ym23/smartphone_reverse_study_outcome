package org.apache.commons.compress.archivers.sevenz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.LZMA2InputStream;
import org.tukaani.xz.LZMA2Options;

/* JADX INFO: loaded from: classes3.dex */
class LZMA2Decoder extends CoderBase {
    LZMA2Decoder() {
        super(new Class[]{LZMA2Options.class, Number.class});
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
        int dictionarySize = getDictionarySize(coder);     // Catch: IllegalArgumentException -> L4
        return new LZMA2InputStream(in, dictionarySize);
    L4:
        ex = move-exception;
        throw new IOException(ex.getMessage());
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    OutputStream encode(OutputStream out, Object opts) throws IOException {
        LZMA2Options options = getOptions(opts);
        FinishableOutputStream wrapped = new FinishableWrapperOutputStream(out);
        return options.getOutputStream(wrapped);
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    byte[] getOptionsAsProperties(Object opts) {
        int dictSize = getDictSize(opts);
        int lead = Integer.numberOfLeadingZeros(dictSize);
        int secondBit = (dictSize >>> (30 - lead)) - 2;
        return new byte[]{(byte) (((19 - lead) * 2) + secondBit)};
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    Object getOptionsFromCoder(Coder coder, InputStream in) {
        return Integer.valueOf(getDictionarySize(coder));
    }

    private int getDictSize(Object opts) {
        if ((opts instanceof LZMA2Options) == false) goto L7;
        return ((LZMA2Options) opts).getDictSize();
    L7:
        return numberOptionOrDefault(opts);
    }

    private int getDictionarySize(Coder coder) throws IllegalArgumentException {
        int dictionarySizeBits = coder.properties[0] & CecDeviceType.INACTIVE;
        if ((dictionarySizeBits & (-64)) != 0) goto L14;
        if (dictionarySizeBits > 40) goto L12;
        if (dictionarySizeBits != 40) goto L10;
        return -1;
    L10:
        return ((dictionarySizeBits & 1) | 2) << ((dictionarySizeBits / 2) + 11);
    L12:
        throw new IllegalArgumentException("Dictionary larger than 4GiB maximum size");
    L14:
        throw new IllegalArgumentException("Unsupported LZMA2 property bits");
    }

    private LZMA2Options getOptions(Object opts) throws IOException {
        if ((opts instanceof LZMA2Options) == true) goto L5;
        LZMA2Options options = new LZMA2Options();
        options.setDictSize(numberOptionOrDefault(opts));
        return options;
    L5:
        return (LZMA2Options) opts;
    }

    private int numberOptionOrDefault(Object opts) {
        return CoderBase.numberOptionOrDefault(opts, 8388608);
    }
}
