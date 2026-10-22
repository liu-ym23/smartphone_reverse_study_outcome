package org.tukaani.xz.common;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class Util {
    public static final long BACKWARD_SIZE_MAX = 17179869184L;
    public static final int BLOCK_HEADER_SIZE_MAX = 1024;
    public static final int STREAM_HEADER_SIZE = 12;
    public static final long VLI_MAX = Long.MAX_VALUE;
    public static final int VLI_SIZE_MAX = 9;

    public static int getVLISize(long j4) {
        int i8 = 0;
        do {
            i8++;
            j4 >>= 7;
        } while (j4 != 0);
        return i8;
    }
}
