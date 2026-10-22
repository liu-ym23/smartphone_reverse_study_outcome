package com.android.server.pinner;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
final class PinRangeSourceStream extends PinRangeSource {
    private boolean mDone;
    private final DataInputStream mStream;

    PinRangeSourceStream(InputStream stream) {
        this.mDone = false;
        this.mStream = new DataInputStream(stream);
    }

    @Override // com.android.server.pinner.PinRangeSource
    boolean read(PinnerService.PinRange outPinRange) {
        if (this.mDone == true) goto L9;
        outPinRange.start = this.mStream.readInt();     // Catch: IOException -> L6
        outPinRange.length = this.mStream.readInt();     // Catch: IOException -> L6
    L7:
        this.mDone = true;
    L9:
        return !this.mDone;
    }
}
