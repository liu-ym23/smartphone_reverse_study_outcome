package com.bytedance.android.ec.hybrid.monitor;

import com.bytedance.android.ec.hybrid.list.util.k;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f47551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f47552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f47553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f47554d;

    public c(Map r100, Map r101, String r102) {
        this.f47551a = r100;
        this.f47552b = r101;
        this.f47553c = "ECLynxCard";
        this.f47554d = r102;
    }

    public final void a() {
        String r100 = k.d(this.f47551a);
        String r101 = k.d(this.f47552b);
        yj.h r102 = (yj.h) ECHybridLogUtil.f47525a.getValue();
        if (r102 == null) goto L6;
        r102.log(this.f47553c, "jsbName: " + this.f47554d + ", callParams: " + r100 + ", backStr: " + r101);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
