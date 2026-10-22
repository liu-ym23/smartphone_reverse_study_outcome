package com.bytedance.als.exceptions;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/als/exceptions/ComponentNotImplementException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", LynxError.LYNX_THROWABLE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "als_release"}, k = 1, mv = {1, 4, 1})
public final class ComponentNotImplementException extends RuntimeException {
    public ComponentNotImplementException(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        super(r100, r101);
    }
}
