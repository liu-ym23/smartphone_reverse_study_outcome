package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00028\u0000H ¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0002\u0010\u000bJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0002\u0010\u000bJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0002\b\u0012H\u0086\u0004J1\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0014H\u0010¢\u0006\u0002\b\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/ProvidableCompositionLocal;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/CompositionLocal;", "defaultFactory", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "defaultProvidedValue", "Landroidx/compose/runtime/ProvidedValue;", "value", "defaultProvidedValue$runtime", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "provides", "providesDefault", "providesComputed", "compute", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "updatedStateOf", "Landroidx/compose/runtime/ValueHolder;", "previous", "updatedStateOf$runtime", "valueHolderOf", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ProvidableCompositionLocal<T> extends CompositionLocal<T> {
    public static final int $stable = 0;

    public abstract ProvidedValue<T> defaultProvidedValue$runtime(T r100);

    public ProvidableCompositionLocal(Function0<? extends T> r100) {
        super(r100, null);
    }

    private final ValueHolder<T> valueHolderOf(ProvidedValue<T> r100) {
        if (r100.isDynamic$runtime() == false) goto L12;
        MutableState<T> r101 = r100.getState$runtime();
        if (r101 != null) goto L19;
        T r102 = r100.getValue();
        SnapshotMutationPolicy<T> r103 = r100.getMutationPolicy$runtime();
        if (r103 != null) goto L9;
        r103 = SnapshotStateKt.structuralEqualityPolicy();
    L9:
        r101 = SnapshotStateKt.mutableStateOf(r102, r103);
    L19:
        return new DynamicValueHolder(r101);
    L12:
        if (r100.getCompute$runtime() == null) goto L15;
        return new ComputedValueHolder(r100.getCompute$runtime());
    L15:
        if (r100.getState$runtime() == null) goto L18;
        return new DynamicValueHolder(r100.getState$runtime());
    L18:
        return new StaticValueHolder(r100.getEffectiveValue$runtime());
    }

    public final ProvidedValue<T> provides(T r100) {
        return defaultProvidedValue$runtime(r100);
    }

    public final ProvidedValue<T> providesComputed(Function1<? super CompositionLocalAccessorScope, ? extends T> r110) {
        return new ProvidedValue(this, null, false, null, null, r110, false);
    }

    public final ProvidedValue<T> providesDefault(T r100) {
        return defaultProvidedValue$runtime(r100).ifNotAlreadyProvided$runtime();
    }

    @Override // androidx.compose.runtime.CompositionLocal
    public ValueHolder<T> updatedStateOf$runtime(ProvidedValue<T> r100, ValueHolder<T> r101) {
        DynamicValueHolder r102 = null;
        if ((r101 instanceof DynamicValueHolder) == false) goto L8;
        if (r100.isDynamic$runtime() == false) goto L19;
        r102 = (DynamicValueHolder) r101;
        r102.getState().setValue(r100.getEffectiveValue$runtime());
    L19:
        if (r102 == null) goto L21;
        return r102;
    L21:
        return valueHolderOf(r100);
    L8:
        if ((r101 instanceof StaticValueHolder) == false) goto L15;
        if (r100.isStatic$runtime() == false) goto L19;
        StaticValueHolder r103 = (StaticValueHolder) r101;
        boolean r104 = Intrinsics.areEqual(r100.getEffectiveValue$runtime(), r103.getValue());
        Object r105 = r103;
        if (r104 == false) goto L19;
    L13:
        r102 = (ValueHolder<T>) r105;
        goto L19
    L15:
        if ((r101 instanceof ComputedValueHolder) == false) goto L19;
        Function1<CompositionLocalAccessorScope, T> r106 = r100.getCompute$runtime();
        ComputedValueHolder r107 = (ComputedValueHolder) r101;
        Function1<CompositionLocalAccessorScope, T> r108 = r107.getCompute();
        r105 = r107;
        if (r106 != r108) goto L19;
        goto L19
    }
}
