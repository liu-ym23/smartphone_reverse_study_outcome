package com.bytedance.android.live.revlink.impl.multianchor.match;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public static final c a(MultiPkMatchContext r100) {
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.m<c> r101 = r100.getMatchStatus();
        if (r101 == null) goto L8;
        c r102 = r101.getValue();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return new c.C1460c();
    }
}
