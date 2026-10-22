package com.stepos.stepclaw.memory.embedding;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbeddingException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", OperationResult.EXTRA_MESSAGE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "httpStatus", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getHttpStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EmbeddingException extends Exception {
    private final Integer httpStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmbeddingException(String message, Integer num) {
        super(message);
        p.e(message, "message");
        this.httpStatus = num;
    }

    public final Integer getHttpStatus() {
        return this.httpStatus;
    }

    public /* synthetic */ EmbeddingException(String str, Integer num, int i8, kotlin.jvm.internal.i iVar) {
        this(str, (i8 & 2) != 0 ? null : num);
    }
}
