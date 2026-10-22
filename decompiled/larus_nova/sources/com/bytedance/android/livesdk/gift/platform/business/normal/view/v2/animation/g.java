package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f129952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f129953b;

    public g(f r100, Ref.BooleanRef r101) {
        this.f129952a = r100;
        this.f129953b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f129953b.element == true) goto L9;
        this.f129952a.b();     // Catch: Throwable -> L6
        return;
    }
}
