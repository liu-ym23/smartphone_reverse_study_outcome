package com.stepos.ability.voicewakeup.training;

import C7.r;
import S7.n;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity$generateAndSaveModel$userModel$1", f = "TrainingActivity.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Ljava/nio/ByteBuffer;", "<anonymous>", "(Lm9/z;)Ljava/nio/ByteBuffer;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TrainingActivity$generateAndSaveModel$userModel$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TrainingActivity f3379a;
    public final /* synthetic */ ByteBuffer b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$generateAndSaveModel$userModel$1(TrainingActivity trainingActivity, ByteBuffer byteBuffer, H7.c cVar) {
        super(2, cVar);
        this.f3379a = trainingActivity;
        this.b = byteBuffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TrainingActivity$generateAndSaveModel$userModel$1(this.f3379a, this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TrainingActivity$generateAndSaveModel$userModel$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Class clsC;
        Result.Failure failureA;
        int iIntValue;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        TrainingActivity trainingActivity = this.f3379a;
        E4.b bVar = (E4.b) trainingActivity.o.getF4884a();
        String keyphrase = trainingActivity.f3372w;
        ShortBuffer[] recordings = (ShortBuffer[]) trainingActivity.f3369s.f752a.toArray(new ShortBuffer[0]);
        bVar.getClass();
        ByteBuffer baseModelData = this.b;
        k.f(baseModelData, "baseModelData");
        k.f(keyphrase, "keyphrase");
        k.f(recordings, "recordings");
        E4.a aVar = E4.a.f472a;
        Class clsB = E4.a.b("com.qualcomm.listen.ListenSoundModel");
        if (clsB != null && (clsC = E4.a.c(clsB.getClassLoader(), "com.qualcomm.listen.ListenTypes$ConfidenceData")) != null) {
            try {
                Object objInvoke = clsB.getMethod("getSizeWhenExtended", ByteBuffer.class, String.class, String.class).invoke(null, E4.b.d(baseModelData), keyphrase, "system_user");
                k.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                iIntValue = ((Integer) objInvoke).intValue();
            } catch (Throwable th) {
                failureA = kotlin.b.a(th);
            }
            if (iIntValue > 0) {
                int i = 65536 + iIntValue;
                int i6 = iIntValue + 65543;
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i6);
                Object objNewInstance = clsC.getDeclaredConstructor(null).newInstance(null);
                Method method = clsB.getMethod("extend", ByteBuffer.class, String.class, String.class, Integer.TYPE, ShortBuffer[].class, ByteBuffer.class, clsC);
                ArrayList arrayList = new ArrayList(recordings.length);
                for (ShortBuffer shortBuffer : recordings) {
                    ShortBuffer shortBufferDuplicate = shortBuffer.duplicate();
                    shortBufferDuplicate.rewind();
                    arrayList.add(shortBufferDuplicate);
                }
                Object objInvoke2 = method.invoke(null, E4.b.d(baseModelData), keyphrase, "system_user", Integer.valueOf(recordings.length), (ShortBuffer[]) arrayList.toArray(new ShortBuffer[0]), byteBufferAllocate, objNewInstance);
                k.d(objInvoke2, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) objInvoke2).intValue() == 0) {
                    int iPosition = byteBufferAllocate.position();
                    if (1 > iPosition || iPosition > i6) {
                        iPosition = Math.min(i6, i);
                    }
                    byteBufferAllocate.limit(iPosition);
                    byteBufferAllocate.rewind();
                    failureA = byteBufferAllocate;
                } else {
                    failureA = null;
                }
                Result.Failure failure = failureA;
                return (ByteBuffer) (failure instanceof Result.Failure ? null : failure);
            }
        }
        return null;
    }
}
