package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bg\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\u000f\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00018\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@BX\u0086\u000e¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010#R\u0017\u0010\u0005\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u001a\u0010.\u001a\u00028\u00008@X\u0080\u0004¢\u0006\f\u0012\u0004\b-\u0010+\u001a\u0004\b,\u0010)R\u0014\u00100\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u0010#¨\u00061"}, d2 = {"Landroidx/compose/runtime/ProvidedValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/runtime/CompositionLocal;", "compositionLocal", "value", "", "explicitNull", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "mutationPolicy", "Landroidx/compose/runtime/MutableState;", "state", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "compute", "isDynamic", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/CompositionLocal;Ljava/lang/Object;ZLandroidx/compose/runtime/SnapshotMutationPolicy;Landroidx/compose/runtime/MutableState;LS7/k;Z)V", "ifNotAlreadyProvided$runtime", "()Landroidx/compose/runtime/ProvidedValue;", "ifNotAlreadyProvided", "Landroidx/compose/runtime/CompositionLocal;", "getCompositionLocal", "()Landroidx/compose/runtime/CompositionLocal;", "Z", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "getMutationPolicy$runtime", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "Landroidx/compose/runtime/MutableState;", "getState$runtime", "()Landroidx/compose/runtime/MutableState;", "LS7/k;", "getCompute$runtime", "()LS7/k;", "isDynamic$runtime", "()Z", "providedValue", "Ljava/lang/Object;", "canOverride", "getCanOverride", "getValue", "()Ljava/lang/Object;", "getValue$annotations", "()V", "getEffectiveValue$runtime", "getEffectiveValue$runtime$annotations", "effectiveValue", "isStatic$runtime", "isStatic", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProvidedValue<T> {
    public static final int $stable = 8;
    private boolean canOverride = true;
    private final CompositionLocal<T> compositionLocal;
    private final S7.k compute;
    private final boolean explicitNull;
    private final boolean isDynamic;
    private final SnapshotMutationPolicy<T> mutationPolicy;
    private final T providedValue;
    private final MutableState<T> state;

    public ProvidedValue(CompositionLocal<T> compositionLocal, T t9, boolean z10, SnapshotMutationPolicy<T> snapshotMutationPolicy, MutableState<T> mutableState, S7.k kVar, boolean z11) {
        this.compositionLocal = compositionLocal;
        this.explicitNull = z10;
        this.mutationPolicy = snapshotMutationPolicy;
        this.state = mutableState;
        this.compute = kVar;
        this.isDynamic = z11;
        this.providedValue = t9;
    }

    public static /* synthetic */ void getEffectiveValue$runtime$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public final boolean getCanOverride() {
        return this.canOverride;
    }

    public final CompositionLocal<T> getCompositionLocal() {
        return this.compositionLocal;
    }

    /* renamed from: getCompute$runtime, reason: from getter */
    public final S7.k getCompute() {
        return this.compute;
    }

    public final T getEffectiveValue$runtime() {
        if (this.explicitNull) {
            return null;
        }
        MutableState<T> mutableState = this.state;
        if (mutableState != null) {
            return mutableState.getValue();
        }
        T t9 = this.providedValue;
        if (t9 != null) {
            return t9;
        }
        ComposerKt.composeRuntimeError("Unexpected form of a provided value");
        throw new KotlinNothingValueException();
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

    public final ProvidedValue<T> ifNotAlreadyProvided$runtime() {
        this.canOverride = false;
        return this;
    }

    /* renamed from: isDynamic$runtime, reason: from getter */
    public final boolean getIsDynamic() {
        return this.isDynamic;
    }

    public final boolean isStatic$runtime() {
        return (this.explicitNull || getValue() != null) && !this.isDynamic;
    }
}
