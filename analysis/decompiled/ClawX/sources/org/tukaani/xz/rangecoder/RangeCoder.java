package org.tukaani.xz.rangecoder;

import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class RangeCoder {
    static final int BIT_MODEL_TOTAL = 2048;
    static final int BIT_MODEL_TOTAL_BITS = 11;
    static final int MOVE_BITS = 5;
    static final short PROB_INIT = 1024;
    static final int SHIFT_BITS = 8;
    static final int TOP_MASK = -16777216;

    public static final void initProbs(short[] sArr) {
        Arrays.fill(sArr, PROB_INIT);
    }
}
