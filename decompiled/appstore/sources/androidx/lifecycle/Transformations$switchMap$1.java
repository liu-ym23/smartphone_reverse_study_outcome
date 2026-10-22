package androidx.lifecycle;

import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "X", "Y", CommonKey.KEY_VALUE, "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class Transformations$switchMap$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Ref$ObjectRef<LiveData> $liveData;
    final /* synthetic */ u $result;
    final /* synthetic */ Function1<Object, LiveData> $transform;

    public Transformations$switchMap$1(Function1<Object, LiveData> r10, Ref$ObjectRef<LiveData> r11, u r12) {
        this.$transform = r10;
        this.$liveData = r11;
        this.$result = r12;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, androidx.lifecycle.LiveData, java.lang.Object] */
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
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r10) {
        LiveData r11 = this.$transform.invoke(r10);
        LiveData r12 = this.$liveData.element;
        if (r12 == r11) goto L10;
        if (r12 == null) goto L6;
        u r13 = this.$result;
        kotlin.jvm.internal.q.d(r12);
        r13.r(r12);
    L6:
        this.$liveData.element = r11;
        if (r11 == 0) goto L11;
        u r14 = this.$result;
        kotlin.jvm.internal.q.d(r11);
        final u r15 = this.$result;
        r14.q(r11, new Transformations.a(new AnonymousClass1(r15)));
        return;
    L11:
        return;
    }
}
