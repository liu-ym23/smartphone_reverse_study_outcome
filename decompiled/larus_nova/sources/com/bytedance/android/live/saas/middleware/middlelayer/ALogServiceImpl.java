package com.bytedance.android.live.saas.middleware.middlelayer;

import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;
import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pm0.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J-\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/middlelayer/ALogServiceImpl;", "Lpm0/a;", "", "tag", "msg", "", "d", "e", "", LynxError.LYNX_THROWABLE, RXScreenCaptureService.KEY_INDEX, "", "priority", "", "Ljava/lang/StackTraceElement;", "traceElement", "stacktrace", "(ILjava/lang/String;[Ljava/lang/StackTraceElement;)V", BaseSwitches.V, "w", "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class ALogServiceImpl implements a {
    public ALogServiceImpl() {
    }

    @Override // pm0.a
    public void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    @Override // pm0.a
    public void e(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // pm0.a
    public void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.i(r100, r101);
        return;
    }

    public void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.v(r100, r101);
        return;
    }

    public void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.w(r100, r101);
        return;
    }

    @Override // pm0.a
    public void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // pm0.a
    public void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogProtocol r102 = BDLiveSdk.getALog();
        if (r102 == null) goto L6;
        r102.w(r100, r101);
        return;
    }

    @Override // pm0.a
    public void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r103 == null) goto L6;
        r103.e(r100, r101, r102);
        return;
    }

    @Override // pm0.a
    public void stacktrace(int r100, String r101, StackTraceElement[] r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "traceElement");
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r103 == null) goto L6;
        r103.stacktrace(r100, r101, r102);
        return;
    }

    public void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        ILogProtocol r103 = BDLiveSdk.getALog();
        if (r103 == null) goto L6;
        r103.w(r100, r101, r102);
        return;
    }
}
