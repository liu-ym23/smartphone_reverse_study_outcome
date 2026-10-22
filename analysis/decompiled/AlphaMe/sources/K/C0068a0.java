package K;

import android.view.View;
import android.view.ViewGroup;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* renamed from: K.a0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0068a0 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f948a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f949b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f950c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0068a0(View view, Continuation continuation) {
        super(2, continuation);
        this.f950c = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0068a0 c0068a0 = new C0068a0(this.f950c, continuation);
        c0068a0.f949b = obj;
        return c0068a0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0068a0) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f948a;
        View view = this.f950c;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.f949b;
            this.f949b = sequenceScope;
            this.f948a = 1;
            if (sequenceScope.yield(view, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            sequenceScope = (SequenceScope) this.f949b;
            ResultKt.throwOnFailure(obj);
        }
        if (view instanceof ViewGroup) {
            X x4 = new X((ViewGroup) view, 1);
            this.f949b = null;
            this.f948a = 2;
            if (sequenceScope.yieldAll(x4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
