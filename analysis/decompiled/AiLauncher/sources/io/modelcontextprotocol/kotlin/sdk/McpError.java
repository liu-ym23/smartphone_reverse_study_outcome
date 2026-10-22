package io.modelcontextprotocol.kotlin.sdk;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/McpError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "code", "", "message", "Lqb/D;", "data", "<init>", "(ILjava/lang/String;Lqb/D;)V", "I", "getCode", "()I", "Lqb/D;", "getData", "()Lqb/D;", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class McpError extends Exception {
    private final int code;
    private final qb.D data;
    private final String message;

    public /* synthetic */ McpError(int i10, String str, qb.D d10, int i11, kotlin.jvm.internal.i iVar) {
        this(i10, str, (i11 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }

    public final int getCode() {
        return this.code;
    }

    public final qb.D getData() {
        return this.data;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public McpError(int i10, String message, qb.D data) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(data, "data");
        this.code = i10;
        this.data = data;
        this.message = "MCP error " + i10 + ": " + message;
    }
}
