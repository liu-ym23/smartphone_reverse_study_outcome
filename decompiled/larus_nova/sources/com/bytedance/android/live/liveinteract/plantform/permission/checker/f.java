package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import android.app.Activity;
import android.os.Build;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f77363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Cert f77364b;

    public f(Activity r100, qh0.d r101, TokenCert r102) {
        this.f77363a = r100;
        this.f77364b = r102;
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
        if (Intrinsics.areEqual("SO-04J", Build.MODEL) == false) goto L9;
        this.f77363a.recreate();     // Catch: Throwable -> L6
        return;
    }
}
