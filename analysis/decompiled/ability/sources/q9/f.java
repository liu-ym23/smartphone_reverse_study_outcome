package q9;

import kotlinx.coroutines.flow.internal.ChildCancelledException;
import s9.o;

/* loaded from: classes4.dex */
public final class f extends o {
    @Override // kotlinx.coroutines.c
    public final boolean E(Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return A(th);
    }
}
