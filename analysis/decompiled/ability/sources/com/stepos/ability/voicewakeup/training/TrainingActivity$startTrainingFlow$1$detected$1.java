package com.stepos.ability.voicewakeup.training;

import C7.r;
import S7.n;
import android.util.Log;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity$startTrainingFlow$1$detected$1", f = "TrainingActivity.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TrainingActivity$startTrainingFlow$1$detected$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TrainingActivity f3388a;
    public final /* synthetic */ ByteBuffer b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$startTrainingFlow$1$detected$1(TrainingActivity trainingActivity, ByteBuffer byteBuffer, H7.c cVar) {
        super(2, cVar);
        this.f3388a = trainingActivity;
        this.b = byteBuffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TrainingActivity$startTrainingFlow$1$detected$1(this.f3388a, this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TrainingActivity$startTrainingFlow$1$detected$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        Object objInvoke;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        ((E4.b) this.f3388a.o.getF4884a()).getClass();
        ByteBuffer baseModelData = this.b;
        k.f(baseModelData, "baseModelData");
        E4.a aVar = E4.a.f472a;
        Class clsB = E4.a.b("com.qualcomm.listen.ListenSoundModel");
        if (clsB != null) {
            try {
                objInvoke = clsB.getMethod("query", ByteBuffer.class).invoke(null, E4.b.d(baseModelData));
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            if (objInvoke != null) {
                objA = E4.b.a(0, objInvoke);
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    try {
                        Log.e("ListenModelTrainer", "extractKeyphrase failed", thA);
                    } catch (Throwable th2) {
                        kotlin.b.a(th2);
                    }
                }
                return (String) (objA instanceof Result.Failure ? null : objA);
            }
        }
        return null;
    }
}
