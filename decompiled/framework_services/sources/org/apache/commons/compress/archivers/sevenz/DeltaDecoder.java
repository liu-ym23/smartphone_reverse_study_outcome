package org.apache.commons.compress.archivers.sevenz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.tukaani.xz.DeltaOptions;
import org.tukaani.xz.FinishableWrapperOutputStream;

/* JADX INFO: loaded from: classes3.dex */
class DeltaDecoder extends CoderBase {
    DeltaDecoder() {
        super(new Class[]{Number.class});
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
        return new DeltaOptions(getOptionsFromCoder(coder)).getInputStream(in);
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    OutputStream encode(OutputStream out, Object options) throws IOException {
        int distance = CoderBase.numberOptionOrDefault(options, 1);
        return new DeltaOptions(distance).getOutputStream(new FinishableWrapperOutputStream(out));
    L5:
        ex = move-exception;
        throw new IOException(ex.getMessage());
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    byte[] getOptionsAsProperties(Object options) {
        return new byte[]{(byte) (CoderBase.numberOptionOrDefault(options, 1) - 1)};
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    Object getOptionsFromCoder(Coder coder, InputStream in) {
        return Integer.valueOf(getOptionsFromCoder(coder));
    }

    private int getOptionsFromCoder(Coder coder) {
        if (coder.properties != null) goto L5;
    L9:
        return 1;
    L5:
        if (coder.properties.length == 0) goto L9;
        return (coder.properties[0] & CecDeviceType.INACTIVE) + 1;
    }
}
