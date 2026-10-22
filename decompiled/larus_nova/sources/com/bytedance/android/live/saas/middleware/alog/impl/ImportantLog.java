package com.bytedance.android.live.saas.middleware.alog.impl;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\nH\u0016J\u0011\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0096\u0001J)\u0010\r\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u000e*\u0004\u0018\u00010\t0\t2\u000e\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\t0\tH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0005H\u0096\u0001J\u001c\u0010\u0011\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\u0011\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0011\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J$\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J)\u0010\u0017\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u000e*\u0004\u0018\u00010\t0\t2\u000e\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\t0\tH\u0096\u0001J$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J\t\u0010\u001b\u001a\u00020\u0005H\u0096\u0001J1\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010 J$\u0010!\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J.\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\u0013H\u0016J)\u0010$\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u000e*\u0004\u0018\u00010\t0\t2\u000e\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\t0\tH\u0096\u0001J\u001c\u0010%\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J&\u0010%\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010%\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0014\u0010&\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/alog/impl/ImportantLog;", "Lcom/bytedance/android/live/saas/middleware/alog/ILogProtocol;", "aLogService", "(Lcom/bytedance/android/live/saas/middleware/alog/ILogProtocol;)V", "bundle", "", "priority", "", "tag", "", "Landroid/os/Bundle;", "changeLevel", "level", "d", "kotlin.jvm.PlatformType", "msg", MapMonitorConst.EVENT_DESTROY, "e", "tr", "", "flush", "forceLogSharding", "header", RXScreenCaptureService.KEY_INDEX, "intent", "Landroid/content/Intent;", "json", "release", "stacktrace", "traceElements", "", "Ljava/lang/StackTraceElement;", "(ILjava/lang/String;[Ljava/lang/StackTraceElement;)V", "thread", "Ljava/lang/Thread;", LynxError.LYNX_THROWABLE, BaseSwitches.V, "w", "withPrefix", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class ImportantLog implements ILogProtocol {
    private final ILogProtocol aLogService;

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void changeLevel(int r100) {
        this.aLogService.changeLevel(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void d(String r100, String r101) {
        this.aLogService.d(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void destroy() {
        this.aLogService.destroy();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void flush() {
        this.aLogService.flush();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void forceLogSharding() {
        this.aLogService.forceLogSharding();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void i(String r100, String r101) {
        this.aLogService.i(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void release() {
        this.aLogService.release();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void v(String r100, String r101) {
        this.aLogService.v(r100, r101);
    }

    public ImportantLog(ILogProtocol r100) {
        Intrinsics.checkNotNullParameter(r100, "aLogService");
        this.aLogService = r100;
    }

    private final String withPrefix(String r100) {
        return "LIVE_SAAS_WARNING_" + r100;
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void e(String r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        withPrefix(r100);
        this.aLogService.e(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void w(String r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        withPrefix(r100);
        this.aLogService.w(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void e(String r100, Throwable r101) {
        withPrefix(r100);
        this.aLogService.e(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void w(String r100, Throwable r101) {
        withPrefix(r100);
        this.aLogService.w(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void bundle(int r100, String r101, Bundle r102) {
        if (r100 < 6) goto L6;
        withPrefix(r101);
        String.valueOf(r102);
    L8:
        this.aLogService.bundle(r100, r101, r102);
        return;
    L6:
        if (r100 < 5) goto L8;
        withPrefix(r101);
        String.valueOf(r102);
        goto L8
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void e(String r100, String r101, Throwable r102) {
        withPrefix(r100);
        this.aLogService.e(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void header(int r100, String r101, String r102) {
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 < 6) goto L8;
        withPrefix(r101);
    L10:
        this.aLogService.header(r100, r101, r102);
        return;
    L8:
        if (r100 < 5) goto L10;
        withPrefix(r101);
        goto L10
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void intent(int r100, String r101, Intent r102) {
        if (r100 < 6) goto L6;
        withPrefix(r101);
        String.valueOf(r102);
    L8:
        this.aLogService.intent(r100, r101, r102);
        return;
    L6:
        if (r100 < 5) goto L8;
        withPrefix(r101);
        String.valueOf(r102);
        goto L8
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void json(int r100, String r101, String r102) {
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 < 6) goto L8;
        withPrefix(r101);
    L10:
        this.aLogService.json(r100, r101, r102);
        return;
    L8:
        if (r100 < 5) goto L10;
        withPrefix(r101);
        goto L10
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void stacktrace(int r110, String r111, StackTraceElement[] r112) {
        if (r112 != null) goto L4;
        return;
    L4:
        int r100 = 0;
        if (r110 < 6) goto L15;
        withPrefix(r111);
        ArrayList r101 = new ArrayList(r112.length);
        int r102 = r112.length;
    L7:
        if (r100 >= r102) goto L13;
        StackTraceElement r103 = r112[r100];
        if (r103 == null) goto L11;
        String r104 = r103.toString();
    L12:
        r101.add(r104);
        r100 = r100 + 1;
        goto L7
    L11:
        r104 = null;
        goto L12
    L13:
        CollectionsKt.joinToString$default(r101, ";\n", null, null, 0, null, null, 62, null);
    L24:
        this.aLogService.stacktrace(r110, r111, r112);
        return;
    L15:
        if (r110 < 5) goto L24;
        withPrefix(r111);
        ArrayList r105 = new ArrayList(r112.length);
        int r106 = r112.length;
    L17:
        if (r100 >= r106) goto L23;
        StackTraceElement r107 = r112[r100];
        if (r107 == null) goto L21;
        String r108 = r107.toString();
    L22:
        r105.add(r108);
        r100 = r100 + 1;
        goto L17
    L21:
        r108 = null;
        goto L22
    L23:
        CollectionsKt.joinToString$default(r105, ";\n", null, null, 0, null, null, 62, null);
        goto L24
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void thread(int r100, String r101, Thread r102) {
        if (r100 < 6) goto L6;
        withPrefix(r101);
        String.valueOf(r102);
    L8:
        this.aLogService.thread(r100, r101, r102);
        return;
    L6:
        if (r100 < 5) goto L8;
        withPrefix(r101);
        String.valueOf(r102);
        goto L8
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void throwable(int r100, String r101, Throwable r102) {
        if (r100 < 6) goto L6;
        withPrefix(r101);
    L8:
        this.aLogService.throwable(r100, r101, r102);
        return;
    L6:
        if (r100 < 5) goto L8;
        withPrefix(r101);
        goto L8
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void w(String r100, String r101, Throwable r102) {
        withPrefix(r100);
        this.aLogService.w(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void throwable(int r100, String r101, String r102, Throwable r103) {
        if (r100 < 6) goto L6;
        withPrefix(r101);
    L8:
        this.aLogService.throwable(r100, r101, r103);
        return;
    L6:
        if (r100 < 5) goto L8;
        withPrefix(r101);
        goto L8
    }
}
