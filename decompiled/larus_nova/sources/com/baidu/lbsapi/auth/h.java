package com.baidu.lbsapi.auth;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f30456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f30457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f30458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f30459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ g f30460e;

    public h(g r100, String r101, int r102, String r103, String r104) {
        this.f30460e = r100;
        this.f30456a = r101;
        this.f30457b = r102;
        this.f30458c = r103;
        this.f30459d = r104;
    }

    public void com_baidu_lbsapi_auth_h__run$___twin___() {
        g r100 = this.f30460e;
        g.a(r100, g.a(r100), this.f30456a, this.f30457b, this.f30458c, this.f30459d);
    }

    @Override // java.lang.Runnable
    public void run() {
        com_baidu_lbsapi_auth_h_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_baidu_lbsapi_auth_h_com_larus_apm_impl_protector_RunnableLancet_run(h r100) {
        r100.com_baidu_lbsapi_auth_h__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
