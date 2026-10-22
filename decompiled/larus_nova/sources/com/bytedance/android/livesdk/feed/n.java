package com.bytedance.android.livesdk.feed;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class n<T> implements k<T> {
    public n() {
    }

    @Override // com.bytedance.android.livesdk.feed.k
    public final boolean a(List<T> r100, List<T> r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r100 != r101) goto L9;
        return true;
    L9:
        if (r100 == null) goto L30;
        if (r101 == null) goto L30;
        if (r100.size() != r101.size()) goto L30;
        int r102 = 0;
    L16:
        if (r102 >= r100.size()) goto L29;
        Object r103 = ListProtector.get(r100, r102);
        Object r104 = ListProtector.get(r101, r102);
        if (r103 != null) goto L21;
        if (r104 != null) goto L21;
        boolean r105 = true;
    L26:
        if (r105 == false) goto L27;
        r102 = r102 + 1;
        goto L16
    L27:
        return false;
    L21:
        if (r103 == null) goto L25;
        if (r104 == null) goto L25;
        r105 = r103.equals(r104);
    L25:
        r105 = false;
        goto L26
    L29:
        return true;
    L30:
        return false;
    }
}
