package com.bytedance.android.gamecp.hybrid_impl.lynx;

import android.util.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jw.b f57604a;

    public f(jw.b r100) {
        this.f57604a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        yr.b.b(4, "GameCpAnnieXManager", "initAnnieX error: " + r101.getMessage());
        jw.b r102 = this.f57604a;
        if (r102 == null) goto L6;
        r102.a(false, "init exception " + Log.getStackTraceString(r101));
        return;
    }
}
