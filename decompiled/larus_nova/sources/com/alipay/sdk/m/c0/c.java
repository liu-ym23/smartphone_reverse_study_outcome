package com.alipay.sdk.m.c0;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f25263a;

    public c(b r100) {
        this.f25263a = r100;
    }

    public final void com_alipay_sdk_m_c0_c__run$___twin___() {
        b.a(this.f25263a);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.a(e);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com_alipay_sdk_m_c0_c_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_alipay_sdk_m_c0_c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
        r100.com_alipay_sdk_m_c0_c__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
