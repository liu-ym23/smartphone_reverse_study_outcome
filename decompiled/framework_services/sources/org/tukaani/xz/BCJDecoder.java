package org.tukaani.xz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.InputStream;
import org.tukaani.xz.simple.ARM;
import org.tukaani.xz.simple.ARMThumb;
import org.tukaani.xz.simple.IA64;
import org.tukaani.xz.simple.PowerPC;
import org.tukaani.xz.simple.SPARC;
import org.tukaani.xz.simple.SimpleFilter;
import org.tukaani.xz.simple.X86;

/* JADX INFO: loaded from: classes3.dex */
class BCJDecoder extends BCJCoder implements FilterDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long filterID;
    private final int startOffset;

    static {
    }

    BCJDecoder(long filterID, byte[] props) throws UnsupportedOptionsException {
        this.filterID = filterID;
        if (props.length != 0) goto L6;
        this.startOffset = 0;
        return;
    L6:
        if (props.length != 4) goto L13;
        int n = 0;
        int i = 0;
    L8:
        if (i >= 4) goto L10;
        n = n | ((props[i] & CecDeviceType.INACTIVE) << (i * 8));
        i = i + 1;
        goto L8
    L10:
        this.startOffset = n;
        return;
    L13:
        throw new UnsupportedOptionsException("Unsupported BCJ filter properties");
    }

    @Override // org.tukaani.xz.FilterDecoder
    public int getMemoryUsage() {
        return SimpleInputStream.getMemoryUsage();
    }

    @Override // org.tukaani.xz.FilterDecoder
    public InputStream getInputStream(InputStream in, ArrayCache arrayCache) {
        SimpleFilter simpleFilter = null;
        if (this.filterID != 4) goto L6;
        simpleFilter = new X86(false, this.startOffset);
    L22:
        return new SimpleInputStream(in, simpleFilter);
    L6:
        if (this.filterID != 5) goto L9;
        simpleFilter = new PowerPC(false, this.startOffset);
        goto L22
    L9:
        if (this.filterID != 6) goto L12;
        simpleFilter = new IA64(false, this.startOffset);
        goto L22
    L12:
        if (this.filterID != 7) goto L15;
        simpleFilter = new ARM(false, this.startOffset);
        goto L22
    L15:
        if (this.filterID != 8) goto L18;
        simpleFilter = new ARMThumb(false, this.startOffset);
        goto L22
    L18:
        if (this.filterID != 9) goto L22;
        simpleFilter = new SPARC(false, this.startOffset);
        goto L22
    }
}
