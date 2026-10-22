package com.bytedance.android.live.schema.api;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00132\u00060\u0001j\u0002`\u0002:\u0001\u0014B)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\r\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/schema/api/WebcastRedirectException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "code", "I", "getCode", "()I", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "<init>", "(ILjava/lang/String;Ljava/lang/Exception;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WebcastRedirectException extends Exception {
    public static final a Companion = null;
    public static final int ERROR_CONFIG_SOURCE = 1003;
    public static final int MISS_REDIRECT_RULE = 1001;
    public static final int UNKNOWN = 1000;
    public static final int WRONG_SHORT_SCHEMA = 1002;
    private final int code;
    private final Exception exception;
    private final String msg;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final int getCode() {
        return this.code;
    }

    public final Exception getException() {
        return this.exception;
    }

    public final String getMsg() {
        return this.msg;
    }

    public WebcastRedirectException(int r100, String r101, Exception r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        super(r101, r102);
        this.code = r100;
        this.msg = r101;
        this.exception = r102;
    }

    public /* synthetic */ WebcastRedirectException(int r100, String r101, Exception r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
