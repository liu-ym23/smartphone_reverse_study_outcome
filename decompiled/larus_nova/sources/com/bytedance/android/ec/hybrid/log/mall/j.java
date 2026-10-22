package com.bytedance.android.ec.hybrid.log.mall;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f47496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f47497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f47498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f47499d;

    public j(Object r100, String r101, p r102) {
        this.f47496a = r100;
        this.f47497b = r101;
        this.f47498c = 4;
        this.f47499d = r102;
    }

    public final void a() {
        Object r100 = this.f47496a;
        if (r100 == null) goto L6;
        String r101 = com.bytedance.android.ec.hybrid.list.util.k.d(r100);
        if (r101 == null) goto L6;
    L7:
        String r102 = this.f47497b + r101;
        int r103 = this.f47498c;
        if (r103 != 3) goto L10;
        Lazy r104 = ECMallLogUtil.f47441a;
        ECMallLogUtil.a(this.f47499d, r102);
        return;
    L10:
        if (r103 != 5) goto L12;
        Lazy r105 = ECMallLogUtil.f47441a;
        p r106 = this.f47499d;
        Intrinsics.checkNotNullParameter(r106, "scene");
        Intrinsics.checkNotNullParameter(r102, "message");
        ((l) ECMallLogUtil.f47442b.getValue()).b(r106, r102);
        return;
    L12:
        if (r103 == 6) goto L14;
        Lazy r107 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(this.f47499d, r102);
        return;
    L14:
        Lazy r108 = ECMallLogUtil.f47441a;
        ECMallLogUtil.b(this.f47499d, r102);
        return;
    L6:
        r101 = "";
        goto L7
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
