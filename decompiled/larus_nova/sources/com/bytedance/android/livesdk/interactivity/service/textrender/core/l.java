package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import java.util.Comparator;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements Comparator<m> {
    public l() {
    }

    @Override // java.util.Comparator
    public final int compare(m r100, m r101) {
        m r102 = r100;
        m r103 = r101;
        if (r102 == null) goto L7;
        if (r103 == null) goto L7;
        return r102.f141026b - r103.f141026b;
    L7:
        return 0;
    }
}
