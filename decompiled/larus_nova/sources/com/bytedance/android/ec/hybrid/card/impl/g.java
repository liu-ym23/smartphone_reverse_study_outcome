package com.bytedance.android.ec.hybrid.card.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxView f46532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.hybrid.card.api.c f46533b;

    public g(LynxView r100, com.bytedance.android.ec.hybrid.card.api.c r101) {
        this.f46532a = r100;
        this.f46533b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LynxView r100 = this.f46532a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        String r101 = this.f46533b.f46380c;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L6
        Map<String, Object> r102 = this.f46533b.f46379b;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L6
        r100.ssrHydrateUrl(r101, r102);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
