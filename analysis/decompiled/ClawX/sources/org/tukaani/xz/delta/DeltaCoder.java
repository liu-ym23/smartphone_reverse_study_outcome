package org.tukaani.xz.delta;

import a8.b;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
abstract class DeltaCoder {
    static final int DISTANCE_MAX = 256;
    static final int DISTANCE_MIN = 1;
    final int distance;
    final byte[] history;

    public DeltaCoder(int i8) {
        if (i8 < 1 || i8 > 256) {
            throw new IllegalArgumentException(b.j(i8, "Invalid distance: "));
        }
        this.distance = i8;
        this.history = new byte[i8];
    }
}
