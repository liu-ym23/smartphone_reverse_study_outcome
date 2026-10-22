package org.tensorflow.lite.task.processor;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NearestNeighbor {
    public abstract ByteBuffer a();

    public abstract float b();

    public NearestNeighbor() {
    }

    static NearestNeighbor create(byte[] r1, float r2) {
        ByteBuffer r3 = ByteBuffer.wrap(r1);
        r3.order(ByteOrder.nativeOrder());
        return new a(r3, r2);
    }
}
