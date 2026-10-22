package org.tukaani.xz;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
abstract class DeltaCoder implements FilterCoder {
    public static final long FILTER_ID = 3;

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
