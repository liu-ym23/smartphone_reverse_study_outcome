package com.bytedance.android.live.core.utils;

import android.os.Handler;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f66202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f66203b;

    public k1(r72.i r100) {
        this.f66202a = "checkAndPreloadDrawableRunnable";
        this.f66203b = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = this.f66202a;
        Runnable r102 = this.f66203b;
        Intrinsics.checkNotNullParameter(r102, "runnable");
        if (r101 != null) goto L6;
        r101 = "UnKnown";
    L6:
        if (v.a() == false) goto L8;
        r102 = new l1(r102, r101);
    L8:
        ((Handler) MainPostOptUtils.f66069a.getValue()).post(r102);
    }
}
