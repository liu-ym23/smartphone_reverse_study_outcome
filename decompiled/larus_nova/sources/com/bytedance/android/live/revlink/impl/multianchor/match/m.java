package com.bytedance.android.live.revlink.impl.multianchor.match;

/* JADX INFO: loaded from: classes47.dex */
public final class m {
    public static final c a() {
        MultiPkMatchContext r100 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<c> r101 = r100.getMatchStatus();
        if (r101 == null) goto L9;
        c r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return new c.C1460c();
    }
}
