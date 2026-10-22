package com.bytedance.android.ec.store.utils;

import com.bytedance.android.ec.core.utils.s;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f48667a = 0;

    public e() {
    }

    static {
    }

    public static Integer a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L12;
        Integer r102 = s.b(r100);
        if (r102 == null) goto L12;
        return r102;
    L12:
        return null;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }
}
