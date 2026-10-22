package com.bytedance.android.anniex.container.util;

import com.bytedance.anniex.bd.foundation.impl.m;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f40615a = 0;

    static {
    }

    public static m b(Integer r100) {
        if (r100 == null) goto L4;
        int r101 = r100.intValue();
        return new m((r101 >> 16) & 255, (r101 >> 8) & 255, r101 & 255, (r101 >> 24) & 255);
    L4:
        return null;
    }

    public static com.bytedance.salamander.anniex.g a(Integer r100, Integer r101, Integer r102) {
        com.bytedance.salamander.anniex.g r103 = new com.bytedance.salamander.anniex.g();
        if (r100 == null) goto L7;
        m r104 = b(r100);
        if (r104 == null) goto L7;
        r103.f268073a = r104;
    L7:
        if (r101 == null) goto L11;
        m r105 = b(r101);
        if (r105 == null) goto L11;
        r103.f268074b = r105;
    L11:
        if (r102 == null) goto L15;
        m r106 = b(r102);
        if (r106 == null) goto L15;
        r103.f268075c = r106;
    L15:
        return r103;
    }
}
