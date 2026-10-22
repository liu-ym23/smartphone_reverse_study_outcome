package com.bytedance.ai.bridge.remote;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0004\t\n\u000b\fB\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/remote/RemoteApiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "Business", "Http", "Network", "InvalidResponse", "Lcom/bytedance/ai/bridge/remote/RemoteApiException$Business;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException$Http;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException$InvalidResponse;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException$Network;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class RemoteApiException extends Exception {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/bridge/remote/RemoteApiException$Business;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException;", "code", "", "message", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Business extends RemoteApiException {
        private final Integer code;

        public final Integer getCode() {
            return this.code;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Business(Integer r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "message");
            super(r101, null, 2, 0 == true ? 1 : 0);
            this.code = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/remote/RemoteApiException$Http;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException;", "statusCode", "", "<init>", "(I)V", "getStatusCode", "()I", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Http extends RemoteApiException {
        private final int statusCode;

        public final int getStatusCode() {
            return this.statusCode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Http(int r100) {
            super("HTTP request failed with status " + r100, null, 2, 0 == true ? 1 : 0);
            this.statusCode = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/remote/RemoteApiException$InvalidResponse;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException;", "message", "", "<init>", "(Ljava/lang/String;)V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvalidResponse extends RemoteApiException {
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidResponse(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            super(r100, null, 2, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/remote/RemoteApiException$Network;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException;", "cause", "", "<init>", "(Ljava/lang/Throwable;)V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Network extends RemoteApiException {
        public Network(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "cause");
            String r101 = r100.getMessage();
            if (r101 != null) goto L5;
            r101 = "network request failed";
        L5:
            super(r101, r100, null);
        }
    }

    public RemoteApiException(String r100, Throwable r101, DefaultConstructorMarker r102) {
        super(r100, r101);
    }

    public /* synthetic */ RemoteApiException(String r100, Throwable r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, null);
    }
}
