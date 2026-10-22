package com.bytedance.android.livesdk.arch.task;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/arch/task/TaskFailureException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", LynxError.LYNX_THROWABLE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "toolbarservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TaskFailureException extends Exception {
    private final Throwable throwable;

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public TaskFailureException(String r100, Throwable r101) {
        super(r100, r101);
        this.throwable = r101;
    }
}
