package ai4;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements FilenameFilter {
    public j() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, r101);
        if (r102.isDirectory() == false) goto L7;
        com.bytedance.crash.util.h.b(r102);
        return false;
    L7:
        return false;
    }
}
