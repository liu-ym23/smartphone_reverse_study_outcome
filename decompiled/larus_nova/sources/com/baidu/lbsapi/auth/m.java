package com.baidu.lbsapi.auth;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Hashtable;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f30472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f30473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f30474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f30475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ Hashtable f30476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f30477f;

    public m(LBSAuthManager r100, int r101, boolean r102, String r103, String r104, Hashtable r105) {
        this.f30477f = r100;
        this.f30472a = r101;
        this.f30473b = r102;
        this.f30474c = r103;
        this.f30475d = r104;
        this.f30476e = r105;
    }

    public void com_baidu_lbsapi_auth_m__run$___twin___() {
        b.a("status = " + this.f30472a + "; forced = " + this.f30473b + "checkAK = " + LBSAuthManager.a(this.f30477f, this.f30474c, this.f30475d));
        int r100 = this.f30472a;
        if (r100 != 601) goto L5;
    L29:
        b.a("authenticate sendAuthRequest");
        String[] r101 = d.b(LBSAuthManager.b());
        if (r101 != null) goto L32;
    L34:
        LBSAuthManager.a(this.f30477f, this.f30473b, this.f30474c, this.f30476e, this.f30475d, LBSAuthManager.c(), LBSAuthManager.d(), LBSAuthManager.e(), LBSAuthManager.f());
        return;
    L32:
        if (r101.length <= 1) goto L34;
        b.a("authStrings.length:" + r101.length);
        b.a("more sha1 auth");
        LBSAuthManager.a(this.f30477f, this.f30473b, this.f30474c, this.f30476e, r101, this.f30475d, LBSAuthManager.c(), LBSAuthManager.d(), LBSAuthManager.e(), LBSAuthManager.f());
        return;
    L5:
        if (this.f30473b == true) goto L29;
        if (r100 == (-1)) goto L29;
        if (LBSAuthManager.a(this.f30477f, this.f30474c, this.f30475d) == true) goto L29;
        if (602 != this.f30472a) goto L27;
        b.a("authenticate wait ");
        Object r102 = LBSAuthManager.g();
        monitor-enter(r102);
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
    L23:
        monitor-exit(r102);     // Catch: Throwable -> L19
    L28:
        LBSAuthManager.a(this.f30477f, this.f30474c, null, this.f30475d);
        return;
    L19:
        th = move-exception;
        throw th;
    L16:
        if (LBSAuthManager.h() == true) goto L23;
        LBSAuthManager.g().wait();     // Catch: Throwable -> L19 InterruptedException -> L21
    L27:
        b.a("authenticate else");
        goto L28
    }

    @Override // java.lang.Runnable
    public void run() {
        com_baidu_lbsapi_auth_m_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_baidu_lbsapi_auth_m_com_larus_apm_impl_protector_RunnableLancet_run(m r100) {
        r100.com_baidu_lbsapi_auth_m__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
