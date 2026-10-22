package bi4;

import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Comparator<Map.Entry<Integer, a.c>> {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(Map.Entry<Integer, a.c> r100, Map.Entry<Integer, a.c> r101) {
        long r102 = r100.getValue().f19122e - r101.getValue().f19122e;
        if (r102 <= 0) goto L5;
        return 1;
    L5:
        if (r102 >= 0) goto L7;
        return -1;
    L7:
        return 0;
    }
}
