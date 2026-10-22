package org.tukaani.xz.rangecoder;

import android.hardware.audio.common.V2_0.AudioFormat;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.CorruptedInputException;

/* JADX INFO: loaded from: classes3.dex */
public final class RangeDecoderFromStream extends RangeDecoder {
    private final DataInputStream inData;

    public RangeDecoderFromStream(InputStream in) throws IOException {
        this.inData = new DataInputStream(in);
        if (this.inData.readUnsignedByte() != 0) goto L7;
        this.code = this.inData.readInt();
        this.range = -1;
        return;
    L7:
        throw new CorruptedInputException();
    }

    public boolean isFinished() {
        if (this.code != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.tukaani.xz.rangecoder.RangeDecoder
    public void normalize() throws IOException {
        if ((this.range & AudioFormat.MAIN_MASK) != 0) goto L6;
        this.code = (this.code << 8) | this.inData.readUnsignedByte();
        this.range <<= 8;
        return;
    }
}
