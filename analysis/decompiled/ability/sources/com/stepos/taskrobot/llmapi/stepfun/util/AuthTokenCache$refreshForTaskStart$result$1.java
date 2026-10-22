package com.stepos.taskrobot.llmapi.stepfun.util;

import C7.r;
import J7.c;
import S7.n;
import f6.C1438c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.taskrobot.llmapi.stepfun.util.AuthTokenCache$refreshForTaskStart$result$1", f = "AuthTokenCache.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lkotlin/Pair;", "", "<anonymous>", "(Lm9/z;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class AuthTokenCache$refreshForTaskStart$result$1 extends SuspendLambda implements n {
    final /* synthetic */ C1438c $util;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthTokenCache$refreshForTaskStart$result$1(C1438c c1438c, H7.c<? super AuthTokenCache$refreshForTaskStart$result$1> cVar) {
        super(2, cVar);
        this.$util = c1438c;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        AuthTokenCache$refreshForTaskStart$result$1 authTokenCache$refreshForTaskStart$result$1 = new AuthTokenCache$refreshForTaskStart$result$1(this.$util, cVar);
        authTokenCache$refreshForTaskStart$result$1.L$0 = obj;
        return authTokenCache$refreshForTaskStart$result$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        Object objA2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        b.b(obj);
        try {
            objA = this.$util.a();
        } catch (Throwable th) {
            objA = b.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = "";
        }
        String str = (String) objA;
        try {
            objA2 = this.$util.b();
        } catch (Throwable th2) {
            objA2 = b.a(th2);
        }
        return new Pair(str, (String) (objA2 instanceof Result.Failure ? "" : objA2));
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Pair<String, String>> cVar) {
        return ((AuthTokenCache$refreshForTaskStart$result$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
