package com.stepos.ability.voicewakeup.training;

import C7.r;
import S7.n;
import android.util.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.voicewakeup.training.MicrophoneRecorder$acquire$2", f = "MicrophoneRecorder.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lkotlin/Result;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class MicrophoneRecorder$acquire$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3350a;
    public final /* synthetic */ a b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicrophoneRecorder$acquire$2(a aVar, H7.c cVar) {
        super(2, cVar);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        MicrophoneRecorder$acquire$2 microphoneRecorder$acquire$2 = new MicrophoneRecorder$acquire$2(this.b, cVar);
        microphoneRecorder$acquire$2.f3350a = obj;
        return microphoneRecorder$acquire$2;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((MicrophoneRecorder$acquire$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        try {
            this.b.f3394a.invoke();
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.w("MicrophoneRecorder", "stop voice wakeup failed", thA);
        }
        return new Result(objA);
    }
}
