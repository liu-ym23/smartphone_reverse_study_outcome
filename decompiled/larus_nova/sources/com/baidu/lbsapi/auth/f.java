package com.baidu.lbsapi.auth;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f30448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f30449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f30450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f30451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ e f30452e;

    public f(e r100, String r101, int r102, String r103, String r104) {
        this.f30452e = r100;
        this.f30448a = r101;
        this.f30449b = r102;
        this.f30450c = r103;
        this.f30451d = r104;
    }

    public void com_baidu_lbsapi_auth_f__run$___twin___() {
        b.a("postWithHttps start Thread id = " + String.valueOf(ThreadMethodProxy.currentThread().getId()));
        e.a(this.f30452e, new i(e.a(this.f30452e)).a(e.b(this.f30452e), this.f30448a, this.f30449b, this.f30450c, this.f30451d));
    }

    @Override // java.lang.Runnable
    public void run() {
        com_baidu_lbsapi_auth_f_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_baidu_lbsapi_auth_f_com_larus_apm_impl_protector_RunnableLancet_run(f r100) {
        r100.com_baidu_lbsapi_auth_f__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
