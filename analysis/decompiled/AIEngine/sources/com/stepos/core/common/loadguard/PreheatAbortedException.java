package com.stepos.core.common.loadguard;

import androidx.lifecycle.j0;
import fc.h;
import java.util.Iterator;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import o6.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PreheatAbortedException extends RuntimeException {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Throwable isCause$lambda$0(Throwable it) {
            g.f(it, "it");
            return it.getCause();
        }

        public final boolean isCause(Throwable th) {
            Iterator it = (th == null ? fc.e.f8799a : new h(new a(8), new j0(th, 7))).iterator();
            while (it.hasNext()) {
                if (((Throwable) it.next()) instanceof PreheatAbortedException) {
                    return true;
                }
            }
            return false;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreheatAbortedException(String message) {
        super(message);
        g.f(message, "message");
    }

    public static final boolean isCause(Throwable th) {
        return Companion.isCause(th);
    }
}
