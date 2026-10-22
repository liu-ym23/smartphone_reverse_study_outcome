package com.stepos.stepclaw.memory.upload;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/MemoryUploadException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", OperationResult.EXTRA_MESSAGE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "httpStatus", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "cause", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Throwable;)V", "getHttpStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemoryUploadException extends Exception {
    private final Integer httpStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryUploadException(String message, Integer num, Throwable th) {
        super(message, th);
        p.e(message, "message");
        this.httpStatus = num;
    }

    public final Integer getHttpStatus() {
        return this.httpStatus;
    }

    public /* synthetic */ MemoryUploadException(String str, Integer num, Throwable th, int i8, i iVar) {
        this(str, (i8 & 2) != 0 ? null : num, (i8 & 4) != 0 ? null : th);
    }
}
