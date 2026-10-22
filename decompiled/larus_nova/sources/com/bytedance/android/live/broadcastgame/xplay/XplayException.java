package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "code", "I", "getCode", "()I", "Lcom/bytedance/android/live/broadcastgame/xplay/q;", "errorInfo", "Lcom/bytedance/android/live/broadcastgame/xplay/q;", "getErrorInfo", "()Lcom/bytedance/android/live/broadcastgame/xplay/q;", "", "retryable", "Z", "getRetryable", "()Z", "", "userHint", "Ljava/lang/String;", "getUserHint", "()Ljava/lang/String;", "<init>", "(Lcom/bytedance/android/live/broadcastgame/xplay/q;ZLjava/lang/String;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayException extends RuntimeException {
    private final int code;
    private final q errorInfo;
    private final boolean retryable;
    private final String userHint;

    public final int getCode() {
        return this.code;
    }

    public final q getErrorInfo() {
        return this.errorInfo;
    }

    public final boolean getRetryable() {
        return this.retryable;
    }

    public final String getUserHint() {
        return this.userHint;
    }

    public XplayException(q r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "errorInfo");
        Intrinsics.checkNotNullParameter(r102, "userHint");
        String r103 = r100.b() + " (code=" + r100.a() + ", retryable=" + r101 + ", userHint=" + r102 + ')';
        ErrorCodeException r104 = r100.f62338b;
        if (r104 == null) goto L5;
        Throwable r105 = r104.getCause();
    L6:
        super(r103, r105);
        this.errorInfo = r100;
        this.retryable = r101;
        this.userHint = r102;
        this.code = r100.a();
        return;
    L5:
        r105 = null;
        goto L6
    }

    public /* synthetic */ XplayException(q r100, boolean r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = true;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = "";
    L8:
        this(r100, r101, r102);
    }
}
