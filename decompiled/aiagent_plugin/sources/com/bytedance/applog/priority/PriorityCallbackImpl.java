package com.bytedance.applog.priority;

import android.content.Context;
import com.bytedance.applog.e;
import com.bytedance.applog.monitor.v3.h;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.applog.util.p;
import com.bytedance.bdinstall.aw;
import com.bytedance.common.utility.i;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PriorityCallbackImpl implements PriorityCallback {
    private static final List<String> loggerTags = null;
    private final com.bytedance.applog.c appLogInstance;

    static {
        loggerTags = Collections.singletonList("PriorityCallbackImpl");
    }

    public PriorityCallbackImpl(com.bytedance.applog.c r1) {
        this.appLogInstance = r1;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String getHeaderJson() {
        this.appLogInstance.Z().a(loggerTags, "****** priority callback get header json...", new Object[0]);
        JSONObject r4 = this.appLogInstance.r();
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.toString();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public PriorityHttpResponse doHttpPost(String r12, byte[] r13) {
        long r0 = System.currentTimeMillis();
        this.appLogInstance.Z().a(loggerTags, "****** priority callback do http post, url: {}, buffer: {}", new Object[]{r12, new String(r13)});
        HashMap r2 = new HashMap();
        if (this.appLogInstance.L() == null) goto L9;
        e r3 = this.appLogInstance.L().a(r13);     // Catch: Throwable -> L6
        r13 = r3.a();     // Catch: Throwable -> L6
        r2.putAll(r3.c());     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        this.appLogInstance.Z().a(loggerTags, "****** log compress toBytes failed", th, new Object[0]);
        this.appLogInstance.N().increaseStats(j.M);
    L9:
        if (this.appLogInstance.k() == false) goto L26;
        r13 = this.appLogInstance.V().a().b(r13);
        r2.remove(DownloadHelper.CONTENT_ENCODING);
        r2.put(DownloadHelper.CONTENT_TYPE, "application/octet-stream;tt-data=a");
    L26:
        String r14 = this.appLogInstance.q().a(this.appLogInstance.U().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.appLogInstance.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r12), r13, r2);     // Catch: Throwable -> L17
        if (p.a(r14) == false) goto L15;
        PriorityHttpResponse r4 = new PriorityHttpResponse(200, "", r14);     // Catch: Throwable -> L17
    L25:
    L23:
        this.appLogInstance.Z().b(loggerTags, "****** priority request cost {}ms", new Object[]{Long.valueOf(System.currentTimeMillis() - r0)});
        return r4;
    L15:
        r4 = new PriorityHttpResponse(0, "response empty", null);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, aw.class) == false) goto L21;
        aw r5 = (aw) ZeusTransformUtils.preCheckCast(th, aw.class, "com.obric.aiagent.plugin");
        int r6 = r5.a();
        String r7 = r5.getMessage();
        this.appLogInstance.Z().a(loggerTags, "****** send resultCode: " + r6, th, new Object[0]);
        r4 = new PriorityHttpResponse(r6, r7, null);
    L22:
        this.appLogInstance.N().sendError("send priority log error, url: " + r12, new Throwable(r4.toString()));
        goto L23
    L21:
        r4 = new PriorityHttpResponse(0, th.toString(), null);
        goto L22
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isNetworkAvailable() {
        return i.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.appLogInstance.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void printLog(int r3, String r4) {
        String r5 = "****** " + r4;
        if (r3 != 2) goto L5;
        this.appLogInstance.Z().a(loggerTags, r5, new Object[0]);
        return;
    L5:
        if (r3 != 3) goto L7;
        this.appLogInstance.Z().c(loggerTags, r5, new Object[0]);
        return;
    L7:
        if (r3 == 4) goto L9;
        this.appLogInstance.Z().b(loggerTags, r5, new Object[0]);
        return;
    L9:
        this.appLogInstance.Z().d(loggerTags, r5, new Object[0]);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorIncreaseStats(String r1, int r2) {
        this.appLogInstance.N().increaseStats(r1, r2);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isMonitorEnabled() {
        return this.appLogInstance.N().isEnabled();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorStage(String r12, String r13, int r14, int r15, String r16, String r17, long r18) {
        com.bytedance.applog.monitor.c.a(this.appLogInstance.N(), com.bytedance.applog.monitor.v3.a.a(r12), new h(r13, r14, r16, r17, r18, com.bytedance.applog.monitor.v3.i.a(r15)));
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isStageEnabled() {
        return this.appLogInstance.N().isStageEnabled();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorError(String r2, String r3) {
        this.appLogInstance.N().sendError(r2, new Throwable(r3));
    }
}
