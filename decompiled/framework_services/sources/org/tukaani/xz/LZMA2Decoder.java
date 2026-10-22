package org.tukaani.xz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
class LZMA2Decoder extends LZMA2Coder implements FilterDecoder {
    private int dictSize;

    LZMA2Decoder(byte[] props) throws UnsupportedOptionsException {
        if (props.length != 1) goto L9;
        if ((props[0] & CecDeviceType.INACTIVE) > 37) goto L9;
        this.dictSize = (props[0] & 1) | 2;
        this.dictSize <<= (props[0] >>> 1) + 11;
        return;
    L9:
        throw new UnsupportedOptionsException("Unsupported LZMA2 properties");
    }

    @Override // org.tukaani.xz.FilterDecoder
    public int getMemoryUsage() {
        return LZMA2InputStream.getMemoryUsage(this.dictSize);
    }

    @Override // org.tukaani.xz.FilterDecoder
    public InputStream getInputStream(InputStream in, ArrayCache arrayCache) {
        return new LZMA2InputStream(in, this.dictSize, null, arrayCache);
    }
}
