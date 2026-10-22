package com.bytedance.android.ec.core.anchorv3;

/* JADX INFO: loaded from: classes43.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43817a = 0;

    static {
    }

    public static boolean a(Integer r100) {
        if (r100 == null) goto L9;
        r100.intValue();
        if ((com.bytedance.android.ec.core.abtest.d.g() & r100.intValue()) != r100.intValue()) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (com.bytedance.android.ec.core.abtest.d.g() <= 0) goto L13;
        return true;
    L13:
        return false;
    }
}
