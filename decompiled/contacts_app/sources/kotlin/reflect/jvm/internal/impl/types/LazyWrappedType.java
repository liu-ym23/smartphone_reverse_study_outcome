package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyWrappedType extends WrappedType {
    private final Function0<KotlinType> computation;
    private final NotNullLazyValue<KotlinType> lazyValue;
    private final StorageManager storageManager;

    public static final /* synthetic */ Function0 access$getComputation$p(LazyWrappedType r0) {
        return r0.computation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r1) {
        return refine(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyWrappedType(StorageManager r2, Function0<? extends KotlinType> r3) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "computation");
        this.storageManager = r2;
        this.computation = r3;
        this.lazyValue = r2.createLazyValue(r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    protected KotlinType getDelegate() {
        return this.lazyValue.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    public boolean isComputed() {
        return this.lazyValue.isComputed();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public LazyWrappedType refine(final KotlinTypeRefiner r4) {
        Intrinsics.checkNotNullParameter(r4, "kotlinTypeRefiner");
        return new LazyWrappedType(this.storageManager, new AnonymousClass1(r4, this));
    }
}
