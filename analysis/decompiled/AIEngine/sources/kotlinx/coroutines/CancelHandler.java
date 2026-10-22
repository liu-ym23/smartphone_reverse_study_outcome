package kotlinx.coroutines;

import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface CancelHandler extends NotCompleted {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class UserSupplied implements CancelHandler {
        private final l<Throwable, n> handler;

        /* JADX WARN: Multi-variable type inference failed */
        public UserSupplied(l<? super Throwable, n> lVar) {
            this.handler = lVar;
        }

        @Override // kotlinx.coroutines.CancelHandler
        public void invoke(Throwable th) {
            this.handler.invoke(th);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + DebugStringsKt.getClassSimpleName(this.handler) + '@' + DebugStringsKt.getHexAddress(this) + ']';
        }
    }

    void invoke(Throwable th);
}
