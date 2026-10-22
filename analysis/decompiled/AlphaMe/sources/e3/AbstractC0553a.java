package e3;

import Z2.AbstractC0114a;
import d3.AbstractC0539a;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* renamed from: e3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0553a {
    public static void a(Function2 function2, AbstractC0114a abstractC0114a, AbstractC0114a abstractC0114a2) {
        try {
            Continuation continuationIntercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, abstractC0114a, abstractC0114a2));
            Result.Companion companion = Result.INSTANCE;
            AbstractC0539a.a(continuationIntercepted, Result.m22constructorimpl(Unit.INSTANCE), null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            abstractC0114a2.resumeWith(Result.m22constructorimpl(ResultKt.createFailure(th)));
            throw th;
        }
    }
}
