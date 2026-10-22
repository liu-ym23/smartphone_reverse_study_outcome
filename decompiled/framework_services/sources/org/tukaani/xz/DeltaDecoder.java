package org.tukaani.xz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
class DeltaDecoder extends DeltaCoder implements FilterDecoder {
    private final int distance;

    DeltaDecoder(byte[] props) throws UnsupportedOptionsException {
        if (props.length != 1) goto L7;
        this.distance = (props[0] & CecDeviceType.INACTIVE) + 1;
        return;
    L7:
        throw new UnsupportedOptionsException("Unsupported Delta filter properties");
    }

    @Override // org.tukaani.xz.FilterDecoder
    public int getMemoryUsage() {
        return 1;
    }

    @Override // org.tukaani.xz.FilterDecoder
    public InputStream getInputStream(InputStream in, ArrayCache arrayCache) {
        return new DeltaInputStream(in, this.distance);
    }
}
