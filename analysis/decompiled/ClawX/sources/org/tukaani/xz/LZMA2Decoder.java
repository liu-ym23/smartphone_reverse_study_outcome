package org.tukaani.xz;

import java.io.InputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class LZMA2Decoder extends LZMA2Coder implements FilterDecoder {
    private int dictSize;

    public LZMA2Decoder(byte[] bArr) throws UnsupportedOptionsException {
        if (bArr.length == 1) {
            byte b9 = bArr[0];
            if ((b9 & 255) <= 37) {
                int i8 = (b9 & 1) | 2;
                this.dictSize = i8;
                this.dictSize = i8 << ((b9 >>> 1) + 11);
                return;
            }
        }
        throw new UnsupportedOptionsException("Unsupported LZMA2 properties");
    }

    @Override // org.tukaani.xz.FilterDecoder
    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) {
        return new LZMA2InputStream(inputStream, this.dictSize, null, arrayCache);
    }

    @Override // org.tukaani.xz.FilterDecoder
    public int getMemoryUsage() {
        return LZMA2InputStream.getMemoryUsage(this.dictSize);
    }
}
