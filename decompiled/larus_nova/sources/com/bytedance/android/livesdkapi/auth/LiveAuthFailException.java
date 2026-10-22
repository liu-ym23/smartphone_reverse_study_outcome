package com.bytedance.android.livesdkapi.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/auth/LiveAuthFailException;", "", "message", "", "authErrorCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthErrorCode", "()Ljava/lang/String;", "setAuthErrorCode", "(Ljava/lang/String;)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAuthFailException extends Throwable {
    private String authErrorCode;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveAuthFailException() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final String getAuthErrorCode() {
        return this.authErrorCode;
    }

    public final void setAuthErrorCode(String r100) {
        this.authErrorCode = r100;
    }

    public LiveAuthFailException(String r100, String r101) {
        super(r100);
        this.authErrorCode = r101;
    }

    public /* synthetic */ LiveAuthFailException(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
