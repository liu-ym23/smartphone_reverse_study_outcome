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

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity$startTrainingFlow$1$info$1", f = "TrainingActivity.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TrainingActivity$startTrainingFlow$1$info$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TrainingActivity f3389a;
    public final /* synthetic */ ByteBuffer b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$startTrainingFlow$1$info$1(TrainingActivity trainingActivity, ByteBuffer byteBuffer, H7.c cVar) {
        super(2, cVar);
        this.f3389a = trainingActivity;
        this.b = byteBuffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TrainingActivity$startTrainingFlow$1$info$1(this.f3389a, this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TrainingActivity$startTrainingFlow$1$info$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Result.Failure failureA;
        Object objInvoke;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        ((E4.b) this.f3389a.o.getF4884a()).getClass();
        ByteBuffer baseModelData = this.b;
        k.f(baseModelData, "baseModelData");
        E4.a aVar = E4.a.f472a;
        Class clsB = E4.a.b("com.qualcomm.listen.ListenSoundModel");
        if (clsB == null) {
            return "ERROR: ListenSoundModel not found";
        }
        try {
            objInvoke = clsB.getMethod("query", ByteBuffer.class).invoke(null, E4.b.d(baseModelData));
        } catch (Throwable th) {
            failureA = kotlin.b.a(th);
        }
        if (objInvoke == null) {
            return "ERROR: query() returned null";
        }
        StringBuilder sb = new StringBuilder("SoundModelInfo (" + objInvoke.getClass().getSimpleName() + "):\n");
        E4.b.b(sb, objInvoke, "  ");
        String string = sb.toString();
        k.e(string, "toString(...)");
        Log.i("ListenModelTrainer", "queryModel:\n".concat(string));
        failureA = string;
        Throwable thA = Result.a(failureA);
        Object objK = failureA;
        if (thA != null) {
            Log.e("ListenModelTrainer", "queryModel: exception", thA);
            objK = B7.a.k("ERROR: ", thA.getMessage());
        }
        return (String) objK;
    }
}
