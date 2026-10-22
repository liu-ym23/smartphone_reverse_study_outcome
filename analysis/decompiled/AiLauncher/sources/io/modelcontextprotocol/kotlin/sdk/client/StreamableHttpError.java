package io.modelcontextprotocol.kotlin.sdk.client;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/client/StreamableHttpError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "code", "", "message", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StreamableHttpError extends Exception {
    private final Integer code;

    /* JADX WARN: Multi-variable type inference failed */
    public StreamableHttpError() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final Integer getCode() {
        return this.code;
    }

    public /* synthetic */ StreamableHttpError(Integer num, String str, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : str);
    }

    public StreamableHttpError(Integer num, String str) {
        super("Streamable HTTP error: " + str);
        this.code = num;
    }
}
