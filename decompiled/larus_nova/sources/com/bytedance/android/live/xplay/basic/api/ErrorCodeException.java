package com.bytedance.android.live.xplay.basic.api;

import com.bytedance.android.live.broadcastgame.api.openplatform.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\u0018\u00002\u00060\u0001j\u0002`\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/xplay/basic/api/ErrorCodeException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errorCode", "", "errorMsg", "", "cause", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;)V", "code", "getCode", "()I", "Ljava/lang/Integer;", "msg", "getMsg", "()Ljava/lang/String;", "livexplaygamebasic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ErrorCodeException extends RuntimeException {
    private final Integer errorCode;
    private final String errorMsg;

    public ErrorCodeException() {
        this(null, null, null, 7, null);
    }

    public final int getCode() {
        Integer r100 = this.errorCode;
        if (r100 != null) goto L10;
        Throwable r101 = getCause();
        if (r101 != null) goto L11;
        return -1;
    L11:
        return h.a(r101);
    L10:
        return r100.intValue();
    }

    public final String getMsg() {
        String r100 = this.errorMsg;
        if (r100 != null) goto L19;
        Throwable r101 = getCause();
        if (r101 == null) goto L17;
        Intrinsics.checkNotNullParameter(r101, "$this$errorMsg");
        String r102 = r101.getMessage();
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        String r104 = r101.toString();
    L16:
        if (r104 == null) goto L17;
        return r104;
    L15:
        r104 = r101.getMessage();
        goto L16
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
    L17:
        return "";
    L19:
        return r100;
    }

    public ErrorCodeException(Integer r100, String r101, Throwable r102) {
        super(r101, r102);
        this.errorCode = r100;
        this.errorMsg = r101;
    }

    public /* synthetic */ ErrorCodeException(Integer r100, String r101, Throwable r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
