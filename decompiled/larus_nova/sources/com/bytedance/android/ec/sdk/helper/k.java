package com.bytedance.android.ec.sdk.helper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static cl.d f48126a;

    public static cl.d a() {
        if (ECAppInfoService.f48114e.isLocalTest() == false) goto L13;
        cl.d r100 = f48126a;
        if (r100 != null) goto L7;
    L8:
        cl.d.f24079a.getClass();
        cl.d r101 = cl.d.a.b();
        if (r101 != null) goto L11;
        r101 = new a();
    L11:
        f48126a = r101;
        goto L13
    L7:
        if (Intrinsics.areEqual(a.class, r100.getClass()) == true) goto L8;
    L13:
        return f48126a;
    }

    static {
    }
}
