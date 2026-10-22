package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bl\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b\u0012\u0019\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r¢\u0006\u0002\b\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\b+R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R'\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r¢\u0006\u0002\b\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0010\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0017\u0010\u0005\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010#\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00078G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u001a\u0010%\u001a\u00028\u00008@X\u0080\u0004¢\u0006\f\u0012\u0004\b&\u0010 \u001a\u0004\b'\u0010\"R\u0014\u0010(\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001c¨\u0006,"}, d2 = {"Landroidx/compose/runtime/ProvidedValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "compositionLocal", "Landroidx/compose/runtime/CompositionLocal;", "value", "explicitNull", "", "mutationPolicy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "state", "Landroidx/compose/runtime/MutableState;", "compute", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "isDynamic", "<init>", "(Landroidx/compose/runtime/CompositionLocal;Ljava/lang/Object;ZLandroidx/compose/runtime/SnapshotMutationPolicy;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function1;Z)V", "getCompositionLocal", "()Landroidx/compose/runtime/CompositionLocal;", "getMutationPolicy$runtime", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "getState$runtime", "()Landroidx/compose/runtime/MutableState;", "getCompute$runtime", "()Lkotlin/jvm/functions/Function1;", "isDynamic$runtime", "()Z", "providedValue", "Ljava/lang/Object;", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "canOverride", "getCanOverride", "effectiveValue", "getEffectiveValue$runtime$annotations", "getEffectiveValue$runtime", "isStatic", "isStatic$runtime", "ifNotAlreadyProvided", "ifNotAlreadyProvided$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProvidedValue<T> {
    public static final int $stable = 8;
    private boolean canOverride;
    private final CompositionLocal<T> compositionLocal;
    private final Function1<CompositionLocalAccessorScope, T> compute;
    private final boolean explicitNull;
    private final boolean isDynamic;
    private final SnapshotMutationPolicy<T> mutationPolicy;
    private final T providedValue;
    private final MutableState<T> state;

    public static /* synthetic */ void getEffectiveValue$runtime$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public final ProvidedValue<T> ifNotAlreadyProvided$runtime() {
        this.canOverride = false;
        return this;
    }

    public final T getEffectiveValue$runtime() {
        if (this.explicitNull == false) goto L5;
        return null;
    L5:
        MutableState<T> r100 = this.state;
        if (r100 != null) goto L13;
        T r101 = this.providedValue;
        if (r101 != null) goto L14;
        ComposerKt.composeRuntimeError("Unexpected form of a provided value");
        throw new KotlinNothingValueException();
    L14:
        return r101;
    L13:
        return r100.getValue();
    }

    public final boolean isStatic$runtime() {
        if (this.explicitNull == true) goto L7;
        if (getValue() != null) goto L7;
    L9:
        return false;
    L7:
        if (this.isDynamic == true) goto L9;
        return true;
    }

    public final boolean getCanOverride() {
        return this.canOverride;
    }

    public final CompositionLocal<T> getCompositionLocal() {
        return this.compositionLocal;
    }

    public final Function1<CompositionLocalAccessorScope, T> getCompute$runtime() {
        return this.compute;
    }

    public final SnapshotMutationPolicy<T> getMutationPolicy$runtime() {
        return this.mutationPolicy;
    }

    public final MutableState<T> getState$runtime() {
        return this.state;
    }

    public final T getValue() {
        return this.providedValue;
    }

    public final boolean isDynamic$runtime() {
        return this.isDynamic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProvidedValue(CompositionLocal<T> r100, T r101, boolean r102, SnapshotMutationPolicy<T> r103, MutableState<T> r104, Function1<? super CompositionLocalAccessorScope, ? extends T> r105, boolean r106) {
        this.compositionLocal = r100;
        this.explicitNull = r102;
        this.mutationPolicy = r103;
        this.state = r104;
        this.compute = r105;
        this.isDynamic = r106;
        this.providedValue = r101;
        this.canOverride = true;
    }
}
