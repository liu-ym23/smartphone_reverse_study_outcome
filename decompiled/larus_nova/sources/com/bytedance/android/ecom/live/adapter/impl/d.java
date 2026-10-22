package com.bytedance.android.ecom.live.adapter.impl;

import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements ji.a {
    public d() {
    }

    @Override // ji.a
    public final void log(int r100, String r101, String r102) {
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r100 != 2) goto L5;
        if (r103 == null) goto L35;
        r103.v(r101, r102);
        return;
    L35:
        return;
    L5:
        if (r100 != 3) goto L7;
        if (r103 == null) goto L33;
        r103.d(r101, r102);
        return;
    L33:
        return;
    L7:
        if (r100 != 4) goto L9;
        if (r103 == null) goto L31;
        r103.i(r101, r102);
        return;
    L31:
        return;
    L9:
        if (r100 != 5) goto L11;
        if (r103 == null) goto L29;
        r103.w(r101, r102);
        return;
    L29:
        return;
    L11:
        if (r100 == 6) goto L14;
        if (r103 == null) goto L25;
        r103.v(r101, r102);
        return;
    L25:
        return;
    L14:
        if (r103 == null) goto L27;
        r103.e(r101, r102);
        return;
    }
}
