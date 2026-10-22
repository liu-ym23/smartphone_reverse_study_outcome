package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/scope/d;", "p1", "", "p2", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/scope/d;Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ScopeErrorHandler$install$1 extends FunctionReferenceImpl implements Function2<com.bytedance.android.scope.d, Throwable, Unit> {
    public ScopeErrorHandler$install$1(ScopeErrorHandler r100) {
        super(2, r100, ScopeErrorHandler.class, "handleException", "handleException(Lcom/bytedance/android/scope/ErrorHandlerContext;Ljava/lang/Throwable;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.scope.d r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r101, "p2");
        ScopeErrorHandler r102 = (ScopeErrorHandler) this.receiver;
        AtomicBoolean r103 = ScopeErrorHandler.f158782a;
        r102.getClass();
        SafetyGuard.a(null, r101, "Scope global error handler");
        if (com.bytedance.android.live.core.utils.v.b() == true) goto L6;
        r100.suppress();
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.scope.d r100, Throwable r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
