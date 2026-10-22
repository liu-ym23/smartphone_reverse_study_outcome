package com.stepos.ame.sdk;

import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ame/sdk/AMEngineException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/stepos/ame/sdk/AMEError;", "message", "", "cause", "", "<init>", "(Lcom/stepos/ame/sdk/AMEError;Ljava/lang/String;Ljava/lang/Throwable;)V", "getError", "()Lcom/stepos/ame/sdk/AMEError;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AMEngineException extends Exception {
    private final AMEError error;

    public /* synthetic */ AMEngineException(AMEError aMEError, String str, Throwable th, int i10, i iVar) {
        this(aMEError, str, (i10 & 4) != 0 ? null : th);
    }

    public final AMEError getError() {
        return this.error;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AMEngineException(AMEError error, String message, Throwable th) {
        super("[" + error.getCode() + "] " + message, th);
        p.i(error, "error");
        p.i(message, "message");
        this.error = error;
    }
}
