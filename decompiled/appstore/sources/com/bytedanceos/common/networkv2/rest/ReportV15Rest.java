package com.bytedanceos.common.networkv2.rest;

import com.bytedanceos.common.ad.entity.req.ReqReportEntity;
import com.bytedanceos.common.networkv2.entity.ReportBaseEntity;
import com.bytedanceos.common.networkv2.service.ReportV15Service;
import com.bytedanceos.common.networkv2.subscriber.NSubscriber;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes2.dex */
public class ReportV15Rest extends AbstractRest {
    private static volatile ReportV15Rest sInstance;
    private ReportV15Service mService;

    private ReportV15Rest() {
        init();
    }

    public static ReportV15Rest instance() {
        if (sInstance != null) goto L16;
        monitor-enter(ReportV15Rest.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new ReportV15Rest();     // Catch: Throwable -> L9
    L11:
        monitor-exit(ReportV15Rest.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public String getBaseUrl() {
        return "";
    }

    public void reportLog(ReqReportEntity r10, NSubscriber<ReportBaseEntity> r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 != null) goto L6;
        r11 = new AnonymousClass1(this);
    L6:
        RequestBody r12 = RequestBody.c(MediaType.c("application/json; charset=utf-8"), new Gson().toJson(r10));
        this.mService.reportLog(r12).a(schedulersTransformer()).f(this.parseFun).q(r11);
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public void setService() {
        this.mService = (ReportV15Service) this.retrofit.d(ReportV15Service.class);
    }
}
