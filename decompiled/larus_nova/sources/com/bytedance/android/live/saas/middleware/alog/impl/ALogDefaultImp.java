package com.bytedance.android.live.saas.middleware.alog.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;
import com.bytedance.android.live.saas.middleware.alog.config.ALogDefaultConfig;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.lynx.tasm.LynxError;
import com.ss.android.agilelogger.ALog;
import com.ss.android.agilelogger.ALogConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u001c\u0010\u0012\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u001c\u0010\u0015\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u0015\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u0015\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J$\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u001b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0002J$\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010 \u001a\u00020\nH\u0016J1\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#H\u0016¢\u0006\u0002\u0010%J$\u0010&\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J.\u0010(\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010(\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010)\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010*\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010*\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010*\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/alog/impl/ALogDefaultImp;", "Lcom/bytedance/android/live/saas/middleware/alog/ILogProtocol;", "debug", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(ZLandroid/content/Context;)V", "mContext", "mIsDebug", "bundle", "", "priority", "", "tag", "", "Landroid/os/Bundle;", "changeLevel", "level", "d", "msg", MapMonitorConst.EVENT_DESTROY, "e", "tr", "", "flush", "forceLogSharding", "header", RXScreenCaptureService.KEY_INDEX, "initALog", "intent", "Landroid/content/Intent;", "json", "release", "stacktrace", "traceElements", "", "Ljava/lang/StackTraceElement;", "(ILjava/lang/String;[Ljava/lang/StackTraceElement;)V", "thread", "Ljava/lang/Thread;", LynxError.LYNX_THROWABLE, BaseSwitches.V, "w", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class ALogDefaultImp implements ILogProtocol {
    private final Context mContext;
    private final boolean mIsDebug;

    private final void initALog() {
        ALogConfig.b r100 = new ALogConfig.b(this.mContext);
        r100.f406442b = ALogDefaultConfig.getDefaultLogSize(this.mContext);
        r100.f406443c = 2097152;
        r100.f406444d = ALogDefaultConfig.getALogFile(this.mContext);
        ALogConfig r101 = r100.a();
        ALog.setsPackageClassName(ALogDefaultImp.class.getCanonicalName());
        ALog.setDebug(this.mIsDebug);
        ALog.init(r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void destroy() {
        ALog.destroy();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void flush() {
        ALog.flush();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void forceLogSharding() {
        ALog.forceLogSharding();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void release() {
        ALog.release();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void changeLevel(int r100) {
        ALog.changeLevel(r100);
    }

    public ALogDefaultImp(boolean r100, Context r101) {
        this.mIsDebug = r100;
        this.mContext = r101;
        initALog();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void d(String r100, String r101) {
        ALog.d(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void e(String r100, String r101) {
        ALog.e(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void i(String r100, String r101) {
        ALog.i(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void v(String r100, String r101) {
        ALog.v(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void w(String r100, String r101) {
        ALog.w(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void e(String r100, Throwable r101) {
        ALog.e(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void w(String r100, Throwable r101) {
        ALog.w(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void bundle(int r100, String r101, Bundle r102) {
        ALog.bundle(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void e(String r100, String r101, Throwable r102) {
        ALog.e(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void header(int r100, String r101, String r102) {
        ALog.header(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void intent(int r100, String r101, Intent r102) {
        ALog.intent(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void json(int r100, String r101, String r102) {
        ALog.json(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void stacktrace(int r100, String r101, StackTraceElement[] r102) {
        ALog.stacktrace(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void thread(int r100, String r101, Thread r102) {
        ALog.thread(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void throwable(int r100, String r101, Throwable r102) {
        ALog.throwable(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void w(String r100, String r101, Throwable r102) {
        ALog.w(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void throwable(int r100, String r101, String r102, Throwable r103) {
        ALog.throwable(r100, r101, r103);
    }
}
