package org.tukaani.xz;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class RawCoder {
    public static void validate(FilterCoder[] filterCoderArr) throws UnsupportedOptionsException {
        for (int i8 = 0; i8 < filterCoderArr.length - 1; i8++) {
            if (!filterCoderArr[i8].nonLastOK()) {
                throw new UnsupportedOptionsException("Unsupported XZ filter chain");
            }
        }
        if (!filterCoderArr[filterCoderArr.length - 1].lastOK()) {
            throw new UnsupportedOptionsException("Unsupported XZ filter chain");
        }
        int i9 = 0;
        for (FilterCoder filterCoder : filterCoderArr) {
            if (filterCoder.changesSize()) {
                i9++;
            }
        }
        if (i9 > 3) {
            throw new UnsupportedOptionsException("Unsupported XZ filter chain");
        }
    }
}
