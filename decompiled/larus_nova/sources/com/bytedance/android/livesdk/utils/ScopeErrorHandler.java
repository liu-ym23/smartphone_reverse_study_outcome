package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ScopeErrorHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f158782a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ScopeErrorHandler f158783b = null;

    public final class a implements com.bytedance.android.scope.b, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f158784a;

        public a(Function2 r100) {
            this.f158784a = r100;
        }

        @Override // com.bytedance.android.scope.b
        public final /* synthetic */ void a(com.bytedance.android.scope.c.a r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            this.f158784a.invoke(r100, r101);
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof com.bytedance.android.scope.b) == true) goto L5;
        L9:
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == false) goto L9;
            if (Intrinsics.areEqual(this.f158784a, ((FunctionAdapter) r100).getFunctionDelegate()) == false) goto L9;
            return true;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f158784a;
        }

        public final int hashCode() {
            return this.f158784a.hashCode();
        }
    }

    public ScopeErrorHandler() {
    }

    static {
        f158783b = new ScopeErrorHandler();
        f158782a = new AtomicBoolean(false);
    }

    public final void a() {
        if (f158782a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        com.bytedance.android.scope.c r100 = com.bytedance.android.scope.n.f163451a;
        com.bytedance.android.scope.c r101 = com.bytedance.android.scope.n.f163451a;
        a r102 = new a(new ScopeErrorHandler$install$1(this));
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "handler");
        Object r103 = r101.f163436a;
        monitor-enter(r103);
        List<? extends com.bytedance.android.scope.b> r104 = CollectionsKt.toMutableList(r101.f163437b);     // Catch: Throwable -> L11
        r104.add(r102);     // Catch: Throwable -> L11
        r101.f163437b = r104;     // Catch: Throwable -> L11
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r103);
        ALogger.i("ScopeErrorHandler", "global error handler is installed");
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
