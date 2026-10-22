package com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/express/exception/SimpleExpressException;", "Ljava/lang/RuntimeException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleExpressException extends RuntimeException {
    public SimpleExpressException(String r100, Throwable r101) {
        super(r100, r101);
    }

    public /* synthetic */ SimpleExpressException(String r100, Throwable r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
