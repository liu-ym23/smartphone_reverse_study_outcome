package org.tukaani.xz;

/* JADX INFO: loaded from: classes3.dex */
class RawCoder {
    RawCoder() {
    }

    static void validate(FilterCoder[] filters) throws UnsupportedOptionsException {
        int i = 0;
    L4:
        if (i >= (filters.length - 1)) goto L10;
        if (filters[i].nonLastOK() == false) goto L9;
        i = i + 1;
        goto L4
    L9:
        throw new UnsupportedOptionsException("Unsupported XZ filter chain");
    L10:
        int i2 = filters.length;
        if (filters[i2 - 1].lastOK() == false) goto L25;
        int changesSizeCount = 0;
        int i3 = 0;
    L14:
        if (i3 >= filters.length) goto L20;
        if (filters[i3].changesSize() == false) goto L18;
        changesSizeCount = changesSizeCount + 1;
    L18:
        i3 = i3 + 1;
        goto L14
    L20:
        if (changesSizeCount > 3) goto L23;
        return;
    L23:
        throw new UnsupportedOptionsException("Unsupported XZ filter chain");
    L25:
        throw new UnsupportedOptionsException("Unsupported XZ filter chain");
    }
}
