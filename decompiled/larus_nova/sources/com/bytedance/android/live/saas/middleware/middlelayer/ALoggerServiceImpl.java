package com.bytedance.android.live.saas.middleware.middlelayer;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.lynx.tasm.LynxError;
import com.ss.alog.middleware.ALogService;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J/\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010 J$\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\"\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010#\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010$\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J&\u0010$\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010$\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/middlelayer/ALoggerServiceImpl;", "Lcom/ss/alog/middleware/ALogService;", "()V", "bundle", "", "priority", "", "tag", "", "Landroid/os/Bundle;", "changeLevel", "level", "d", "msg", MapMonitorConst.EVENT_DESTROY, "e", LynxError.LYNX_THROWABLE, "", "flush", "forceLogSharding", "header", RXScreenCaptureService.KEY_INDEX, "init", "customName", "intent", "Landroid/content/Intent;", "json", "release", "statcktrace", "traceElements", "", "Ljava/lang/StackTraceElement;", "(ILjava/lang/String;[Ljava/lang/StackTraceElement;)V", "thread", "Ljava/lang/Thread;", BaseSwitches.V, "w", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class ALoggerServiceImpl extends ALogService {
    @Override // com.ss.alog.middleware.IALogProtocol
    public void init() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void init(String r100) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void destroy() {
        ILogProtocol r100 = BDLiveSdk.getALog();
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void flush() {
        ILogProtocol r100 = BDLiveSdk.getALog();
        if (r100 == null) goto L6;
        r100.flush();
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void forceLogSharding() {
        ILogProtocol r100 = BDLiveSdk.getALog();
        if (r100 == null) goto L6;
        r100.forceLogSharding();
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void release() {
        ILogProtocol r100 = BDLiveSdk.getALog();
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public ALoggerServiceImpl() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void changeLevel(int r100) {
        ILogProtocol r101 = BDLiveSdk.getALog();
        if (r101 == null) goto L6;
        r101.changeLevel(r100);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void d(String r100, String r101) {
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void e(String r100, String r101) {
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void i(String r100, String r101) {
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.i(r100, r101);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void v(String r100, String r101) {
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.v(r100, r101);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void w(String r100, String r101) {
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.w(r100, r101);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void e(String r100, Throwable r101) {
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void w(String r100, Throwable r101) {
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.w(r100, r101);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void bundle(int r100, String r101, Bundle r102) {
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r103 == null) goto L6;
        r103.bundle(r100, r101, r102);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void e(String r100, String r101, Throwable r102) {
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r103 == null) goto L6;
        r103.e(r100, r101, r102);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void header(int r100, String r101, String r102) {
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r103 == null) goto L6;
        r103.header(r100, r101, r102);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void intent(int r100, String r101, Intent r102) {
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r103 == null) goto L6;
        r103.intent(r100, r101, r102);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void json(int r100, String r101, String r102) {
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r103 == null) goto L6;
        r103.json(r100, r101, r102);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void statcktrace(int r100, String r101, StackTraceElement[] r102) {
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r103 == null) goto L6;
        r103.stacktrace(r100, r101, r102);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void thread(int r100, String r101, Thread r102) {
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r103 == null) goto L6;
        r103.thread(r100, r101, r102);
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void throwable(int r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r103 == null) goto L6;
        r103.stacktrace(r100, r101, r102.getStackTrace());
        return;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void w(String r100, String r101, Throwable r102) {
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r103 == null) goto L6;
        r103.w(r100, r101, r102);
        return;
    }
}
