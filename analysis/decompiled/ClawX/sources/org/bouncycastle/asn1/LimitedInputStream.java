package org.bouncycastle.asn1;

import java.io.InputStream;

/* loaded from: classes.dex */
abstract class LimitedInputStream extends InputStream {
    protected final InputStream _in;
    private int _limit;

    public LimitedInputStream(InputStream inputStream, int i8) {
        this._in = inputStream;
        this._limit = i8;
    }

    public int getLimit() {
        return this._limit;
    }

    public void setParentEofDetect(boolean z) {
        InputStream inputStream = this._in;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            ((IndefiniteLengthInputStream) inputStream).setEofOn00(z);
        }
    }
}
