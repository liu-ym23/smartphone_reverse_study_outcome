package androidx.core.util;

import C7.r;
import H7.c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LH7/c;", "LC7/r;", "Ljava/lang/Runnable;", "asRunnable", "(LH7/c;)Ljava/lang/Runnable;", "core-ktx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RunnableKt {
    public static final Runnable asRunnable(c<? super r> cVar) {
        return new ContinuationRunnable(cVar);
    }
}
