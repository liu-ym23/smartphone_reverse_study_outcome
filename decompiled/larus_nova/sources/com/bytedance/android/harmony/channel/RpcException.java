package com.bytedance.android.harmony.channel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/harmony/channel/RpcException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "rpcCategory", "", "rpcMessage", "rpcExtra", "", "cause", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V", "getRpcCategory", "()Ljava/lang/String;", "getRpcExtra", "()Ljava/lang/Object;", "getRpcMessage", "runtime"}, k = 1, mv = {1, 1, 16})
public final class RpcException extends RuntimeException {
    private final String rpcCategory;
    private final Object rpcExtra;
    private final String rpcMessage;

    public final String getRpcCategory() {
        return this.rpcCategory;
    }

    public final Object getRpcExtra() {
        return this.rpcExtra;
    }

    public final String getRpcMessage() {
        return this.rpcMessage;
    }

    public RpcException(String r100, String r101, Object r102, Throwable r103) {
        super("category = " + r100 + ", message = " + r101 + ", extra = " + r102, r103);
        this.rpcCategory = r100;
        this.rpcMessage = r101;
        this.rpcExtra = r102;
    }

    public /* synthetic */ RpcException(String r100, String r101, Object r102, Throwable r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
