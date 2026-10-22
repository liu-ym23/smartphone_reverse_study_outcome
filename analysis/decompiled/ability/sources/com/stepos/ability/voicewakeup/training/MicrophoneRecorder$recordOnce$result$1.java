package com.stepos.ability.voicewakeup.training;

import C7.r;
import S7.n;
import androidx.appcompat.app.AppCompatDelegate;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;

@J7.c(c = "com.stepos.ability.voicewakeup.training.MicrophoneRecorder$recordOnce$result$1", f = "MicrophoneRecorder.kt", l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/Function0;", "LC7/r;", "startCapture", "<anonymous>", "(LS7/a;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class MicrophoneRecorder$recordOnce$result$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3356a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Ref$BooleanRef c;
    public final /* synthetic */ n d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicrophoneRecorder$recordOnce$result$1(Ref$BooleanRef ref$BooleanRef, n nVar, H7.c cVar) {
        super(2, cVar);
        this.c = ref$BooleanRef;
        this.d = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        MicrophoneRecorder$recordOnce$result$1 microphoneRecorder$recordOnce$result$1 = new MicrophoneRecorder$recordOnce$result$1(this.c, this.d, cVar);
        microphoneRecorder$recordOnce$result$1.b = obj;
        return microphoneRecorder$recordOnce$result$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((MicrophoneRecorder$recordOnce$result$1) create((S7.a) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        S7.a aVar = (S7.a) this.b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3356a;
        if (i == 0) {
            kotlin.b.b(obj);
            this.c.f4916a = true;
            this.b = null;
            this.f3356a = 1;
            if (this.d.invoke(aVar, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return r.f317a;
    }
}
