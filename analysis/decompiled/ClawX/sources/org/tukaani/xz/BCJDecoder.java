package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.simple.ARM;
import org.tukaani.xz.simple.ARM64;
import org.tukaani.xz.simple.ARMThumb;
import org.tukaani.xz.simple.IA64;
import org.tukaani.xz.simple.PowerPC;
import org.tukaani.xz.simple.RISCVDecoder;
import org.tukaani.xz.simple.SPARC;
import org.tukaani.xz.simple.X86;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class BCJDecoder extends BCJCoder implements FilterDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long filterID;
    private final int startOffset;

    public BCJDecoder(long j4, byte[] bArr) throws UnsupportedOptionsException {
        this.filterID = j4;
        if (bArr.length == 0) {
            this.startOffset = 0;
            return;
        }
        if (bArr.length != 4) {
            throw new UnsupportedOptionsException("Unsupported BCJ filter properties");
        }
        int i8 = 0;
        for (int i9 = 0; i9 < 4; i9++) {
            i8 |= (bArr[i9] & 255) << (i9 * 8);
        }
        this.startOffset = i8;
    }

    @Override // org.tukaani.xz.FilterDecoder
    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) {
        long j4 = this.filterID;
        return new SimpleInputStream(inputStream, j4 == 4 ? new X86(false, this.startOffset) : j4 == 5 ? new PowerPC(false, this.startOffset) : j4 == 6 ? new IA64(false, this.startOffset) : j4 == 7 ? new ARM(false, this.startOffset) : j4 == 8 ? new ARMThumb(false, this.startOffset) : j4 == 9 ? new SPARC(false, this.startOffset) : j4 == 10 ? new ARM64(false, this.startOffset) : j4 == 11 ? new RISCVDecoder(this.startOffset) : null);
    }

    @Override // org.tukaani.xz.FilterDecoder
    public int getMemoryUsage() {
        return SimpleInputStream.getMemoryUsage();
    }
}
