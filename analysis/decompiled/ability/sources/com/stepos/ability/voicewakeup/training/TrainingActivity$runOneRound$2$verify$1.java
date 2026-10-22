package com.stepos.ability.voicewakeup.training;

import C7.r;
import E4.f;
import S7.n;
import android.os.DeadObjectException;
import j9.m;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity$runOneRound$2$verify$1", f = "TrainingActivity.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LE4/f;", "<anonymous>", "(Lm9/z;)LE4/f;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TrainingActivity$runOneRound$2$verify$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TrainingActivity f3386a;
    public final /* synthetic */ ByteBuffer b;
    public final /* synthetic */ ShortBuffer c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$runOneRound$2$verify$1(TrainingActivity trainingActivity, ByteBuffer byteBuffer, ShortBuffer shortBuffer, H7.c cVar) {
        super(2, cVar);
        this.f3386a = trainingActivity;
        this.b = byteBuffer;
        this.c = shortBuffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TrainingActivity$runOneRound$2$verify$1(this.f3386a, this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TrainingActivity$runOneRound$2$verify$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        String message;
        Object objA2;
        String str;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        TrainingActivity trainingActivity = this.f3386a;
        E4.b bVar = (E4.b) trainingActivity.o.getF4884a();
        String keyphrase = trainingActivity.f3372w;
        ShortBuffer shortBuffer = this.c;
        bVar.getClass();
        ByteBuffer baseModelData = this.b;
        k.f(baseModelData, "baseModelData");
        k.f(keyphrase, "keyphrase");
        if (baseModelData.remaining() == 0) {
            return new f(-9002, "base model buffer is empty", 0, false);
        }
        E4.a aVar = E4.a.f472a;
        Class clsB = E4.a.b("com.qualcomm.listen.ListenSoundModel");
        if (clsB == null) {
            return new f(-9001, "ListenSoundModel not found", 0, false);
        }
        Class clsC = E4.a.c(clsB.getClassLoader(), "com.qualcomm.listen.ListenTypes$QualityCheckInfo");
        if (clsC == null) {
            return new f(-9001, "QualityCheckInfo not found", 0, false);
        }
        Object next = null;
        try {
            Object objNewInstance = clsC.getDeclaredConstructor(null).newInstance(null);
            Method method = clsB.getMethod("verifyUserRecordingQuality", ByteBuffer.class, String.class, ShortBuffer.class, Boolean.TYPE, clsC);
            ByteBuffer byteBufferD = E4.b.d(baseModelData);
            ShortBuffer shortBufferDuplicate = shortBuffer.duplicate();
            shortBufferDuplicate.rewind();
            Object objInvoke = method.invoke(null, byteBufferD, keyphrase, shortBufferDuplicate, Boolean.FALSE, objNewInstance);
            k.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) objInvoke).intValue();
            try {
                Field declaredField = clsC.getDeclaredField("keywordConfidenceLevel");
                declaredField.setAccessible(true);
                objA2 = Integer.valueOf(declaredField.getShort(objNewInstance));
            } catch (Throwable th) {
                objA2 = kotlin.b.a(th);
            }
            if (objA2 instanceof Result.Failure) {
                objA2 = -1;
            }
            int iIntValue2 = ((Number) objA2).intValue();
            boolean z10 = iIntValue == 0 && iIntValue2 >= 50;
            if (iIntValue == -14) {
                str = "设备不支持高通 SVA 声纹训练功能";
            } else if (iIntValue == -11) {
                str = "唤醒词不匹配或 SELinux 权限不足";
            } else if (iIntValue != 0) {
                str = "HAL 返回错误码 " + iIntValue;
            } else if (iIntValue2 < 50) {
                str = "未检测到唤醒词 (confidence=" + iIntValue2 + " < 50)";
            } else {
                str = "";
            }
            objA = new f(iIntValue, str, iIntValue2, z10);
        } catch (Throwable th2) {
            objA = kotlin.b.a(th2);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Iterator it = kotlin.sequences.a.k0(new Ba.f(11), thA).iterator();
            if (it.hasNext()) {
                next = it.next();
                while (it.hasNext()) {
                    next = it.next();
                }
            }
            int i = ((((Throwable) next) instanceof DeadObjectException) || ((message = thA.getMessage()) != null && m.h0(message, "DeadObject", false))) ? -9003 : -9002;
            String message2 = thA.getMessage();
            if (message2 == null) {
                message2 = "invocation failed";
            }
            objA = new f(i, message2, 0, false);
        }
        return (f) objA;
    }
}
