package com.bytedance.android.ec.core.imagex.common;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public final class g {
    public static /* synthetic */ void a(boolean r100, boolean r101, Function0 r102, int r103) {
        AsyncWorker r104 = AsyncWorker.f44552d;
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = false;
    L8:
        r104.b(r100, r101, r102);
    }
}
