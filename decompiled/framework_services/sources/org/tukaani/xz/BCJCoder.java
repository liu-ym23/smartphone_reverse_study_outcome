package org.tukaani.xz;

/* JADX INFO: loaded from: classes3.dex */
abstract class BCJCoder implements FilterCoder {
    public static final long ARMTHUMB_FILTER_ID = 8;
    public static final long ARM_FILTER_ID = 7;
    public static final long IA64_FILTER_ID = 6;
    public static final long POWERPC_FILTER_ID = 5;
    public static final long SPARC_FILTER_ID = 9;
    public static final long X86_FILTER_ID = 4;

    BCJCoder() {
    }

    public static boolean isBCJFilterID(long filterID) {
        if (filterID >= 4) goto L5;
    L7:
        return false;
    L5:
        if (filterID > 9) goto L7;
        return true;
    }

    @Override // org.tukaani.xz.FilterCoder
    public boolean changesSize() {
        return false;
    }

    @Override // org.tukaani.xz.FilterCoder
    public boolean nonLastOK() {
        return true;
    }

    @Override // org.tukaani.xz.FilterCoder
    public boolean lastOK() {
        return false;
    }
}
