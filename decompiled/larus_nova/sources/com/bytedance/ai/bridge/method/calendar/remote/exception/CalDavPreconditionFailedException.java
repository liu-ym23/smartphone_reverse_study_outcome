package com.bytedance.ai.bridge.method.calendar.remote.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0013\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/remote/exception/CalDavPreconditionFailedException;", "Lcom/bytedance/ai/bridge/method/calendar/remote/exception/CalDavHttpException;", "response", "Lokhttp3/Response;", "<init>", "(Lokhttp3/Response;)V", "message", "", "(Ljava/lang/String;)V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalDavPreconditionFailedException extends CalDavHttpException {
    public CalDavPreconditionFailedException(Response r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        super(r100);
    }

    public CalDavPreconditionFailedException(String r100) {
        super(412, r100);
    }
}
