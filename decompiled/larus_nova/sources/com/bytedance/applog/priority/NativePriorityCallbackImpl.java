package com.bytedance.applog.priority;

import android.webkit.ValueCallback;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010,\u001a\u00020\u0001\u0012\u0006\u00101\u001a\u000200\u0012\u0018\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\t05¢\u0006\u0004\b?\u0010@J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J4\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0016J8\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0019\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016JH\u0010\"\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\u001c\u0010&\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010(\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010+\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010,\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R)\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\t058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0017\u0010;\u001a\u00020:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/bytedance/applog/priority/NativePriorityCallbackImpl;", "Lcom/bytedance/applog/priority/PriorityCallback;", "", "getHeaderJson", "", "getOpaquePayloadJson", "url", "", "buffer", "Lkotlin/Pair;", "keyIv", "Lcom/bytedance/applog/priority/PriorityHttpResponse;", "doHttpPost", "", "reqId", "key", CJPayFingerprintSharedPrefUtils.KEY_IV, "", "isNetworkAvailable", "", "level", "message", "", "printLog", "count", "monitorIncreaseStats", "isMonitorEnabled", "stage", "priorityName", "groupId", "eventType", "event", "monitorId", "localTimeMs", "monitorStage", "isStageEnabled", "s", "stackInfo", "monitorError", "delaySeconds", "monitorLatency", "isolateKey", "value", "allowIsolateReport", "priorityCallback", "Lcom/bytedance/applog/priority/PriorityCallback;", "getPriorityCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "Lcom/bytedance/applog/log/a;", "logger", "Lcom/bytedance/applog/log/a;", "getLogger", "()Lcom/bytedance/applog/log/a;", "Landroid/webkit/ValueCallback;", "onHttpCallback", "Landroid/webkit/ValueCallback;", "getOnHttpCallback", "()Landroid/webkit/ValueCallback;", "Ljava/util/concurrent/ExecutorService;", "httpThreadPool", "Ljava/util/concurrent/ExecutorService;", "getHttpThreadPool", "()Ljava/util/concurrent/ExecutorService;", "<init>", "(Lcom/bytedance/applog/priority/PriorityCallback;Lcom/bytedance/applog/log/a;Landroid/webkit/ValueCallback;)V", "priority_release"}, k = 1, mv = {1, 6, 0})
public final class NativePriorityCallbackImpl implements PriorityCallback {
    private final ExecutorService httpThreadPool;
    private final com.bytedance.applog.log.a logger;
    private final ValueCallback<Pair<Long, PriorityHttpResponse>> onHttpCallback;
    private final PriorityCallback priorityCallback;

    public static /* synthetic */ void a(NativePriorityCallbackImpl r100, String r101, String r102, String r103, byte[] r104, long r105) {
        m8295doHttpPost$lambda0(r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void printLog(int r100, String r101) {
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String getHeaderJson() {
        return this.priorityCallback.getHeaderJson();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public Object getOpaquePayloadJson() {
        return this.priorityCallback.getOpaquePayloadJson();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isMonitorEnabled() {
        return this.priorityCallback.isMonitorEnabled();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isNetworkAvailable() {
        return this.priorityCallback.isNetworkAvailable();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isStageEnabled() {
        return this.priorityCallback.isStageEnabled();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String isolateKey() {
        return this.priorityCallback.isolateKey();
    }

    public final ExecutorService getHttpThreadPool() {
        return this.httpThreadPool;
    }

    public final com.bytedance.applog.log.a getLogger() {
        return this.logger;
    }

    public final ValueCallback<Pair<Long, PriorityHttpResponse>> getOnHttpCallback() {
        return this.onHttpCallback;
    }

    public final PriorityCallback getPriorityCallback() {
        return this.priorityCallback;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean allowIsolateReport(String r100, String r101) {
        return this.priorityCallback.allowIsolateReport(r100, r101);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorError(String r100, String r101) {
        this.priorityCallback.monitorError(r100, r101);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorIncreaseStats(String r100, int r101) {
        this.priorityCallback.monitorIncreaseStats(r100, r101);
    }

    public NativePriorityCallbackImpl(PriorityCallback r100, com.bytedance.applog.log.a r101, ValueCallback<Pair<Long, PriorityHttpResponse>> r102) {
        Intrinsics.checkNotNullParameter(r100, "priorityCallback");
        Intrinsics.checkNotNullParameter(r101, "logger");
        Intrinsics.checkNotNullParameter(r102, "onHttpCallback");
        this.priorityCallback = r100;
        this.logger = r101;
        this.onHttpCallback = r102;
        this.httpThreadPool = PThreadExecutorsUtils.newFixedThreadPool(3, new DefaultThreadFactory("NativePriorityCallbackImpl"));
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public PriorityHttpResponse doHttpPost(final String r100, byte[] r101, Pair<String, String> r102) {
        this.logger.a("NativePriorityCallbackImpl", new AnonymousClass1(r100));
        return null;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorLatency(int r100, int r101, int r102) {
        this.priorityCallback.monitorLatency(r100, r101, r102);
    }

    public final PriorityHttpResponse doHttpPost(final String r110, final long r111, final byte[] r112, final String r113, final String r114) {
        this.httpThreadPool.submit(new d(this, r113, r114, r110, r112, r111));
        return new PriorityHttpResponse(200, "", "");
    }

    /* JADX INFO: renamed from: doHttpPost$lambda-0, reason: not valid java name */
    private static final void m8295doHttpPost$lambda0(NativePriorityCallbackImpl r100, String r101, String r102, String r103, byte[] r104, final long r105) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.logger.a("NativePriorityCallbackImpl:doHttpPost", new NativePriorityCallbackImpl$doHttpPost$2$1(r105));
        boolean r106 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r107 = true;
    L9:
        if (r107 == true) goto L17;
        if (r102 != null) goto L12;
    L13:
        r106 = true;
    L14:
        if (r106 == true) goto L17;
        Pair<String, String> r108 = TuplesKt.to(r101, r102);
    L18:
        PriorityHttpResponse r109 = r100.priorityCallback.doHttpPost(r103, r104, r108);
        r100.onHttpCallback.onReceiveValue(new Pair(Long.valueOf(r105), r109));
        return;
    L12:
        if (r102.length() != 0) goto L14;
    L17:
        r108 = null;
        goto L18
    L5:
        if (r101.length() == 0) goto L8;
        r107 = false;
        goto L9
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorStage(String r110, String r111, int r112, int r113, String r114, String r115, long r116) {
        this.priorityCallback.monitorStage(r110, r111, r112, r113, r114, r115, r116);
    }
}
