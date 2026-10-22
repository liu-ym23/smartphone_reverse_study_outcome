package ai4;

import android.app.ApplicationExitInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Comparator<ApplicationExitInfo> {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(ApplicationExitInfo r100, ApplicationExitInfo r101) {
        long r102 = r101.getTimestamp() - r100.getTimestamp();
        if (r102 <= 0) goto L5;
        return 1;
    L5:
        if (r102 != 0) goto L7;
        return 0;
    L7:
        return -1;
    }
}
