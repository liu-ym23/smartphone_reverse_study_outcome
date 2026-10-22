package com.bytedance.android.ec.hybrid.log.mall;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f47492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f47493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f47494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f47495d;

    public i(Object r100, Object r101, String r102, String r103) {
        this.f47492a = r100;
        this.f47493b = r101;
        this.f47494c = r102;
        this.f47495d = r103;
    }

    public final void a() {
        String r100 = com.bytedance.android.ec.hybrid.list.util.k.d(this.f47492a);
        String r101 = com.bytedance.android.ec.hybrid.list.util.k.d(this.f47493b);
        Lazy r102 = ECMallLogUtil.f47441a;
        ECMallLogUtil.f(4, e.b.f47470b, this.f47494c + " request api key is " + this.f47495d + ", request is " + r100 + ", header is " + r101, null, 24);
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
