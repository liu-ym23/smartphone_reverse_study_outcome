package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Limit.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class FlowKt__LimitKt$dropWhile$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.BooleanRef $matched;
    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$dropWhile$1$1(Ref.BooleanRef r1, FlowCollector<? super T> r2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3) {
        this.$matched = r1;
        this.$this_unsafeFlow = r2;
        this.$predicate = r3;
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
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof FlowKt__LimitKt$dropWhile$1$1$emit$1) == false) goto L7;
        FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = (FlowKt__LimitKt$dropWhile$1$1$emit$1) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L16;
        if (r2 != 3) goto L15;
        ResultKt.throwOnFailure(r9);
    L34:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r7 = (T) r0.L$1;
        FlowKt__LimitKt$dropWhile$1$1<T> this = (FlowKt__LimitKt$dropWhile$1$1) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L29:
        if (((Boolean) r9).booleanValue() == true) goto L36;
        this.$matched.element = true;
        FlowCollector<T> r6 = this.$this_unsafeFlow;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
        if (r6.emit(r7, r0) != r1) goto L34;
        return r1;
    L36:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r9);
    L24:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r9);
        if (this.$matched.element == false) goto L25;
        FlowCollector<T> r10 = this.$this_unsafeFlow;
        r0.label = 1;
        if (r10.emit(r7, r0) != r1) goto L24;
        return r1;
    L25:
        Function2<T, Continuation<? super Boolean>, Object> r11 = this.$predicate;
        r0.L$0 = this;
        r0.L$1 = r7;
        r0.label = 2;
        r9 = r11.invoke(r7, r0);
        if (r9 != r1) goto L29;
        return r1;
    L7:
        r0 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, r8);
        goto L8
    }
}
