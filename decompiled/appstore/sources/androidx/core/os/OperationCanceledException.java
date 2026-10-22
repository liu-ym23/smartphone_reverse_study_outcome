package androidx.core.os;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(@Nullable String r10) {
        super(androidx.core.util.b.d(r10, "The operation has been canceled."));
    }
}
