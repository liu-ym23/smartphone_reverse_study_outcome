package androidx.compose.runtime;

import C7.r;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\r\u0010\u000e\u001a>\u0010\u0015\u001a\u00020\u00122\u001a\u0010\u0011\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f\"\u0006\u0012\u0002\b\u00030\u00102\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a.\u0010\u0015\u001a\u00020\u00122\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00102\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0018\u001a*\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u001b¨\u0006\u001c"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/SnapshotMutationPolicy;", PolicySdkConstants.policyFileDir, "Lkotlin/Function0;", "defaultFactory", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "compositionLocalOf", "(Landroidx/compose/runtime/SnapshotMutationPolicy;LS7/a;)Landroidx/compose/runtime/ProvidableCompositionLocal;", "staticCompositionLocalOf", "(LS7/a;)Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "defaultComputation", "compositionLocalWithComputedDefaultOf", "(LS7/k;)Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "Landroidx/compose/runtime/ProvidedValue;", "values", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "CompositionLocalProvider", "([Landroidx/compose/runtime/ProvidedValue;LS7/n;Landroidx/compose/runtime/Composer;I)V", "value", "(Landroidx/compose/runtime/ProvidedValue;LS7/n;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/CompositionLocalContext;", "context", "(Landroidx/compose/runtime/CompositionLocalContext;LS7/n;Landroidx/compose/runtime/Composer;I)V", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionLocalKt {
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void CompositionLocalProvider(ProvidedValue<?>[] providedValueArr, n nVar, Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(415205898);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(415205898, i, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:367)");
        }
        composerStartRestartGroup.startProviders(providedValueArr);
        nVar.invoke(composerStartRestartGroup, Integer.valueOf((i >> 3) & 14));
        composerStartRestartGroup.endProviders();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new e(i, 1, providedValueArr, nVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r CompositionLocalProvider$lambda$0(ProvidedValue[] providedValueArr, n nVar, int i, Composer composer, int i6) {
        CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, nVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r CompositionLocalProvider$lambda$1(ProvidedValue providedValue, n nVar, int i, Composer composer, int i6) {
        CompositionLocalProvider((ProvidedValue<?>) providedValue, nVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r CompositionLocalProvider$lambda$3(CompositionLocalContext compositionLocalContext, n nVar, int i, Composer composer, int i6) {
        CompositionLocalProvider(compositionLocalContext, nVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return r.f317a;
    }

    public static final <T> ProvidableCompositionLocal<T> compositionLocalOf(SnapshotMutationPolicy<T> snapshotMutationPolicy, S7.a aVar) {
        return new DynamicProvidableCompositionLocal(snapshotMutationPolicy, aVar);
    }

    public static /* synthetic */ ProvidableCompositionLocal compositionLocalOf$default(SnapshotMutationPolicy snapshotMutationPolicy, S7.a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            snapshotMutationPolicy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return compositionLocalOf(snapshotMutationPolicy, aVar);
    }

    public static final <T> ProvidableCompositionLocal<T> compositionLocalWithComputedDefaultOf(S7.k kVar) {
        return new ComputedProvidableCompositionLocal(kVar);
    }

    public static final <T> ProvidableCompositionLocal<T> staticCompositionLocalOf(S7.a aVar) {
        return new StaticProvidableCompositionLocal(aVar);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void CompositionLocalProvider(ProvidedValue<?> providedValue, n nVar, Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-149765515);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-149765515, i, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:387)");
        }
        composerStartRestartGroup.startProvider(providedValue);
        nVar.invoke(composerStartRestartGroup, Integer.valueOf((i >> 3) & 14));
        composerStartRestartGroup.endProvider();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new e(i, 0, providedValue, nVar));
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void CompositionLocalProvider(CompositionLocalContext compositionLocalContext, n nVar, Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1162003659);
        int i6 = (i & 6) == 0 ? (composerStartRestartGroup.changed(compositionLocalContext) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i6 & 19) != 18, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1162003659, i6, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:408)");
            }
            PersistentCompositionLocalMap compositionLocals$runtime = compositionLocalContext.getCompositionLocals();
            ArrayList arrayList = new ArrayList(compositionLocals$runtime.size());
            for (Map.Entry<CompositionLocal<Object>, ValueHolder<Object>> entry : compositionLocals$runtime.entrySet()) {
                arrayList.add(entry.getValue().toProvided(entry.getKey()));
            }
            ProvidedValue[] providedValueArr = (ProvidedValue[]) arrayList.toArray(new ProvidedValue[0]);
            CompositionLocalProvider((ProvidedValue<?>[]) Arrays.copyOf(providedValueArr, providedValueArr.length), nVar, composerStartRestartGroup, i6 & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new e(i, 2, compositionLocalContext, nVar));
        }
    }
}
