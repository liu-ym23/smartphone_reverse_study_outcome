package org.tukaani.xz.rangecoder;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class RangeEncoderToStream extends RangeEncoder {
    private final OutputStream out;

    public RangeEncoderToStream(OutputStream outputStream) {
        this.out = outputStream;
        reset();
    }

    @Override // org.tukaani.xz.rangecoder.RangeEncoder
    public void writeByte(int i8) throws IOException {
        this.out.write(i8);
    }
}
