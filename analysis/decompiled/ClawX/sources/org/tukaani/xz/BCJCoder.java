package org.tukaani.xz;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
abstract class BCJCoder implements FilterCoder {
    public static final long ARM64_FILTER_ID = 10;
    public static final long ARMTHUMB_FILTER_ID = 8;
    public static final long ARM_FILTER_ID = 7;
    public static final long IA64_FILTER_ID = 6;
    public static final long POWERPC_FILTER_ID = 5;
    public static final long RISCV_FILTER_ID = 11;
    public static final long SPARC_FILTER_ID = 9;
    public static final long X86_FILTER_ID = 4;

    public static boolean isBCJFilterID(long j4) {
        return j4 >= 4 && j4 <= 11;
    }

    @Override // org.tukaani.xz.FilterCoder
    public boolean changesSize() {
        return false;
    }

    @Override // org.tukaani.xz.FilterCoder
    public boolean lastOK() {
        return false;
    }

    @Override // org.tukaani.xz.FilterCoder
    public boolean nonLastOK() {
        return true;
    }
}
