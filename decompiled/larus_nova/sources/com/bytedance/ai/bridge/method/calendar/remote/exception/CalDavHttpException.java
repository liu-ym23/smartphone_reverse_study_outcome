package com.bytedance.ai.bridge.method.calendar.remote.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/remote/exception/CalDavHttpException;", "Lcom/bytedance/ai/bridge/method/calendar/remote/exception/CalDavException;", "response", "Lokhttp3/Response;", "<init>", "(Lokhttp3/Response;)V", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CalDavHttpException extends CalDavException {
    private final int code;

    public final int getCode() {
        return this.code;
    }

    public CalDavHttpException(Response r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        super("Http " + r100.code() + ' ' + r100.message(), null, r100, 2, null);
        this.code = r100.code();
    }

    public CalDavHttpException(int r100, String r110) {
        super("http " + r100 + ' ' + r110, null, null, 6, null);
        this.code = r100;
    }
}
