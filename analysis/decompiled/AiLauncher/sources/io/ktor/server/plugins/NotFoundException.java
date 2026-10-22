package io.ktor.server.plugins;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/server/plugins/NotFoundException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "message", "<init>", "(Ljava/lang/String;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NotFoundException extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public NotFoundException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public NotFoundException(String str) {
        super(str);
    }

    public /* synthetic */ NotFoundException(String str, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "Resource not found" : str);
    }
}
