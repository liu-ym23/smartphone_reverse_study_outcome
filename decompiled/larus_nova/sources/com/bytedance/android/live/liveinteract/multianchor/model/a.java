package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: classes46.dex */
public final class a {
    public static final <T extends vh7.c<T>> vh7.c<T> a(vh7.c<T> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if ((r100 instanceof vh7.e) == false) goto L12;
        Object r101 = ((vh7.e) r100).getFlexInstance();
        if (r101 == null) goto L9;
        return (vh7.c) r101;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<T>");
    L12:
        return r100;
    }
}
