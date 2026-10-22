package org.tukaani.xz.delta;

/* JADX INFO: loaded from: classes3.dex */
abstract class DeltaCoder {
    static final int DISTANCE_MASK = 255;
    static final int DISTANCE_MAX = 256;
    static final int DISTANCE_MIN = 1;
    final int distance;
    final byte[] history;
    int pos;

    DeltaCoder(int distance) {
        this.history = new byte[256];
        this.pos = 0;
        if (distance < 1) goto L8;
        if (distance > 256) goto L8;
        this.distance = distance;
        return;
    L8:
        throw new IllegalArgumentException();
    }
}
