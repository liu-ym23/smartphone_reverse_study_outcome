package androidx.collection.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"Landroidx/collection/internal/Lock;", "", "<init>", "()V", "synchronizedImpl", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Lock {
    public Lock() {
    }

    public final <T> T synchronizedImpl(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        monitor-enter(this);
        T r101 = r100.invoke();     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(this);
        InlineMarker.finallyEnd(1);
        return r101;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
