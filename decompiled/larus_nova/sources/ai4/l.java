package ai4;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements FilenameFilter {
    public l() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        if (r101.split("_").length != 2) goto L6;
        return true;
    L6:
        return false;
    }
}
