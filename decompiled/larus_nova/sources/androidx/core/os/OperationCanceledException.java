package androidx.core.os;

import androidx.core.util.ObjectsCompat;

/* JADX INFO: loaded from: classes17.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String r100) {
        super(ObjectsCompat.toString(r100, "The operation has been canceled."));
    }
}
