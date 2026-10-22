package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f25113a;

    public c(b r100) {
        this.f25113a = r100;
    }

    public final void com_alipay_apmobilesecuritysdk_f_c__run$___twin___() {
        Process.setThreadPriority(0);     // Catch: Exception -> L15 Throwable -> L12
    L5:
        if (b.a(this.f25113a).isEmpty() == true) goto L10;
        Runnable r100 = (Runnable) b.a(this.f25113a).get(0);     // Catch: Exception -> L15 Throwable -> L12
        b.a(this.f25113a).remove(0);     // Catch: Exception -> L15 Throwable -> L12
        if (r100 == null) goto L5;
        r100.run();     // Catch: Exception -> L15 Throwable -> L12
    L12:
        th = move-exception;
        b.b(this.f25113a);
        throw th;
    L10:
        b.b(this.f25113a);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com_alipay_apmobilesecuritysdk_f_c_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_alipay_apmobilesecuritysdk_f_c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
        r100.com_alipay_apmobilesecuritysdk_f_c__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
