package com.alipay.sdk.m.d0;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class c implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f25271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static DataReportResult f25272e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f25273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BugTrackMessageService f25274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataReportService f25275c;

    public c(Context r100, String r101) {
        this.f25273a = null;
        this.f25274b = null;
        this.f25275c = null;
        aa r102 = new aa();
        r102.a(r101);
        h r103 = new h(r100);
        this.f25273a = r103;
        this.f25274b = (BugTrackMessageService) r103.a(BugTrackMessageService.class, r102);
        this.f25275c = (DataReportService) this.f25273a.a(DataReportService.class, r102);
    }

    public static synchronized c a(Context r100, String r101) {
        monitor-enter(c.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f25271d != null) goto L7;
        f25271d = new c(r100, r101);     // Catch: Throwable -> L10
    L7:
        c r102 = f25271d;     // Catch: Throwable -> L10
        monitor-exit(c.class);
        return r102;
    }

    public static /* synthetic */ DataReportService a(c r100) {
        return r100.f25275c;
    }

    public static /* synthetic */ DataReportResult a() {
        return f25272e;
    }

    public static /* synthetic */ DataReportResult a(DataReportResult r100) {
        f25272e = r100;
        return r100;
    }

    @Override // com.alipay.sdk.m.d0.a
    public DataReportResult a(DataReportRequest r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.f25275c == null) goto L13;
        f25272e = null;
        ThreadMethodProxy.start(new PthreadThreadV2(new b(this, r100), "ay/sdk/m/d0/c"));
        int r101 = 300000;
    L9:
        if (f25272e != null) goto L13;
        if (r101 < 0) goto L13;
        Thread.sleep(50);
        r101 = r101 - 50;
    L13:
        return f25272e;
    }

    @Override // com.alipay.sdk.m.d0.a
    public boolean logCollect(String r100) {
        if (com.alipay.sdk.m.z.a.a(r100) == false) goto L5;
        return false;
    L5:
        BugTrackMessageService r101 = this.f25274b;
        if (r101 == null) goto L16;
        String r102 = r101.logCollect(com.alipay.sdk.m.z.a.f(r100));     // Catch: Throwable -> L9
    L11:
        if (com.alipay.sdk.m.z.a.a(r102) == false) goto L13;
        return false;
    L13:
        return ((Boolean) new JSONObject(r102).get("success")).booleanValue();
    L9:
        r102 = null;
        goto L11
    L16:
        return false;
    }
}
