package com.bytedance.android.ec.opt.asynctask;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f48055a = 0;

    static {
    }

    public static void b(w r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        a(r100, 0);
    }

    public static void a(w r100, int r101) {
        k r102 = r100.r();
        if ((r102 instanceof i) == false) goto L15;
        i r103 = (i) r102;
    L5:
        r103 = r103.parent();
        if ((r103 instanceof r) == false) goto L5;
        if (r101 != 0) goto L10;
        IDispatcher.f48026a.getClass();
        ((c) IDispatcher.Companion.f48027a.getValue()).a(r103, r100, 0);
        return;
    L10:
        if (r101 != 1) goto L17;
        IDispatcher.f48026a.getClass();
        ((c) IDispatcher.Companion.f48027a.getValue()).a(r103, r100, 1);
        return;
    L17:
        return;
    }
}
