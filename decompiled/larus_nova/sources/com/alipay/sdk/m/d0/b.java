package com.alipay.sdk.m.d0;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataReportRequest f25269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f25270b;

    public b(c r100, DataReportRequest r101) {
        this.f25270b = r100;
        this.f25269a = r101;
    }

    public void com_alipay_sdk_m_d0_b__run$___twin___() {
        c.a(c.a(this.f25270b).reportData(this.f25269a));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c.a(new DataReportResult());
        c.a().success = false;
        c.a().resultCode = "static data rpc upload error, " + com.alipay.sdk.m.z.a.a(th);
        com.alipay.sdk.m.z.a.a(th);
    }

    @Override // java.lang.Runnable
    public void run() {
        com_alipay_sdk_m_d0_b_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_alipay_sdk_m_d0_b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
        r100.com_alipay_sdk_m_d0_b__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
