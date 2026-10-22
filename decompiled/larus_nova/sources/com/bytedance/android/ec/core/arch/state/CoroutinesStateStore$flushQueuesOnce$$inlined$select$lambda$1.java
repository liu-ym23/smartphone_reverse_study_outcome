package com.bytedance.android.ec.core.arch.state;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\b\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/core/arch/state/b;", ExifInterface.LATITUDE_SOUTH, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "reducer", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/ec/core/arch/state/CoroutinesStateStore$flushQueuesOnce$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.arch.state.CoroutinesStateStore$flushQueuesOnce$2$1", f = "CoroutinesStateStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CoroutinesStateStore$flushQueuesOnce$$inlined$select$lambda$1 extends SuspendLambda implements Function2<Function1<b, b>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    public CoroutinesStateStore$flushQueuesOnce$$inlined$select$lambda$1(Continuation r100, a r101) {
        this.this$0 = r101;
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        CoroutinesStateStore$flushQueuesOnce$$inlined$select$lambda$1 r102 = new CoroutinesStateStore$flushQueuesOnce$$inlined$select$lambda$1(r101, this.this$0);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Function1<b, b> r100, Continuation<? super Unit> r101) {
        return ((CoroutinesStateStore$flushQueuesOnce$$inlined$select$lambda$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        S r101 = (S) ((Function1) this.L$0).invoke(this.this$0.f43863d);
        if ((!Intrinsics.areEqual(r101, this.this$0.f43863d)) == false) goto L8;
        a r102 = this.this$0;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r102.f43863d = r101;
        this.this$0.f43862c.postValue(r101);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
