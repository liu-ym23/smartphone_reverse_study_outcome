package androidx.compose.runtime;

import C7.r;
import S7.n;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import m9.AbstractC1683A;
import m9.C1727t;
import m9.InterfaceC1733z;
import m9.b0;
import m9.d0;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001d\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\b\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\b\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0004\b\b\u0010\f\u001a7\u0010\b\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0004\b\b\u0010\u000e\u001aA\u0010\b\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0004\b\b\u0010\u0010\u001a;\u0010\b\u001a\u00020\u00012\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\u0011\"\u0004\u0018\u00010\n2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0004\b\b\u0010\u0013\u001a3\u0010\u0018\u001a\u00020\u00012\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a=\u0010\u0018\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u001a\u001aG\u0010\u0018\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u001b\u001aQ\u0010\u0018\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u001c\u001aK\u0010\u0018\u001a\u00020\u00012\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\u0011\"\u0004\u0018\u00010\n2\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u001d\u001a\u001f\u0010\"\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b\"\u0010#\u001a%\u0010&\u001a\u00020\u00152\u0013\b\u0006\u0010%\u001a\r\u0012\u0004\u0012\u00020\u001e0\u0000¢\u0006\u0002\b$H\u0087\b¢\u0006\u0004\b&\u0010'\"\u0014\u0010(\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)\"\u0014\u0010+\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,\"\u0014\u0010-\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010,¨\u0006."}, d2 = {"Lkotlin/Function0;", "LC7/r;", "effect", "SideEffect", "(LS7/a;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function1;", "Landroidx/compose/runtime/DisposableEffectScope;", "Landroidx/compose/runtime/DisposableEffectResult;", "DisposableEffect", "(LS7/k;Landroidx/compose/runtime/Composer;I)V", "", "key1", "(Ljava/lang/Object;LS7/k;Landroidx/compose/runtime/Composer;I)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;LS7/k;Landroidx/compose/runtime/Composer;I)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;LS7/k;Landroidx/compose/runtime/Composer;I)V", "", "keys", "([Ljava/lang/Object;LS7/k;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function2;", "Lm9/z;", "LH7/c;", "block", "LaunchedEffect", "(LS7/n;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;LS7/n;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Ljava/lang/Object;LS7/n;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;LS7/n;Landroidx/compose/runtime/Composer;I)V", "([Ljava/lang/Object;LS7/n;Landroidx/compose/runtime/Composer;I)V", "LH7/h;", "coroutineContext", "Landroidx/compose/runtime/Composer;", "composer", "createCompositionCoroutineScope", "(LH7/h;Landroidx/compose/runtime/Composer;)Lm9/z;", "Landroidx/compose/runtime/DisallowComposableCalls;", "getContext", "rememberCoroutineScope", "(LS7/a;Landroidx/compose/runtime/Composer;II)Lm9/z;", "InternalDisposableEffectScope", "Landroidx/compose/runtime/DisposableEffectScope;", "", "DisposableEffectNoParamError", "Ljava/lang/String;", "LaunchedEffectNoParamError", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EffectsKt {
    private static final String DisposableEffectNoParamError = "DisposableEffect must provide one or more 'key' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.";
    private static final DisposableEffectScope InternalDisposableEffectScope = new DisposableEffectScope();
    private static final String LaunchedEffectNoParamError = "LaunchedEffect must provide one or more 'key' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    @C7.c
    @Composable
    public static final void DisposableEffect(S7.k kVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-904483903, i, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:120)");
        }
        throw new IllegalStateException(DisposableEffectNoParamError);
    }

    @C7.c
    @Composable
    public static final void LaunchedEffect(n nVar, Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-805415771);
        int i6 = i & 1;
        if (composerStartRestartGroup.shouldExecute(i6 != 0, i6)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-805415771, i, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:325)");
            }
            throw new IllegalStateException(LaunchedEffectNoParamError);
        }
        composerStartRestartGroup.skipToGroupEnd();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new android.view.compose.h(nVar, i, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LaunchedEffect$lambda$4(n nVar, int i, Composer composer, int i6) {
        LaunchedEffect(nVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return r.f317a;
    }

    @Composable
    public static final void SideEffect(S7.a aVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1288466761, i, -1, "androidx.compose.runtime.SideEffect (Effects.kt:51)");
        }
        composer.recordSideEffect(aVar);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    public static final InterfaceC1733z createCompositionCoroutineScope(H7.h hVar, Composer composer) {
        if (hVar.get(b0.f5325a) == null) {
            return new RememberedCoroutineScope(composer.getApplyCoroutineContext(), hVar);
        }
        d0 d0VarA = kotlinx.coroutines.a.a();
        d0VarA.U(new C1727t(new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job"), false));
        return AbstractC1683A.b(d0VarA);
    }

    @Composable
    public static final InterfaceC1733z rememberCoroutineScope(S7.a aVar, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            aVar = new S7.a() { // from class: androidx.compose.runtime.EffectsKt.rememberCoroutineScope.1
                @Override // S7.a
                public final EmptyCoroutineContext invoke() {
                    return EmptyCoroutineContext.f4908a;
                }
            };
        }
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = createCompositionCoroutineScope((H7.h) aVar.invoke(), composer);
            composer.updateRememberedValue(objRememberedValue);
        }
        return (InterfaceC1733z) objRememberedValue;
    }

    @Composable
    public static final void DisposableEffect(Object obj, S7.k kVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1371986847, i, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:153)");
        }
        boolean zChanged = composer.changed(obj);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new DisposableEffectImpl(kVar);
            composer.updateRememberedValue(objRememberedValue);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    @Composable
    public static final void LaunchedEffect(Object obj, n nVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1179185413, i, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:341)");
        }
        H7.h applyCoroutineContext = composer.getApplyCoroutineContext();
        boolean zChanged = composer.changed(obj);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new LaunchedEffectImpl(applyCoroutineContext, nVar);
            composer.updateRememberedValue(objRememberedValue);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    @Composable
    public static final void DisposableEffect(Object obj, Object obj2, S7.k kVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1429097729, i, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:190)");
        }
        boolean zChanged = composer.changed(obj) | composer.changed(obj2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new DisposableEffectImpl(kVar);
            composer.updateRememberedValue(objRememberedValue);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    @Composable
    public static final void LaunchedEffect(Object obj, Object obj2, n nVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(590241125, i, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:360)");
        }
        H7.h applyCoroutineContext = composer.getApplyCoroutineContext();
        boolean zChanged = composer.changed(obj) | composer.changed(obj2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new LaunchedEffectImpl(applyCoroutineContext, nVar);
            composer.updateRememberedValue(objRememberedValue);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    @Composable
    public static final void DisposableEffect(Object obj, Object obj2, Object obj3, S7.k kVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1239538271, i, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:228)");
        }
        boolean zChanged = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new DisposableEffectImpl(kVar);
            composer.updateRememberedValue(objRememberedValue);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    @Composable
    public static final void LaunchedEffect(Object obj, Object obj2, Object obj3, n nVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-54093371, i, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:384)");
        }
        H7.h applyCoroutineContext = composer.getApplyCoroutineContext();
        boolean zChanged = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new LaunchedEffectImpl(applyCoroutineContext, nVar);
            composer.updateRememberedValue(objRememberedValue);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    @Composable
    public static final void DisposableEffect(Object[] objArr, S7.k kVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1307627122, i, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:264)");
        }
        boolean zChanged = false;
        for (Object obj : Arrays.copyOf(objArr, objArr.length)) {
            zChanged |= composer.changed(obj);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(kVar));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    @Composable
    public static final void LaunchedEffect(Object[] objArr, n nVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-139560008, i, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:407)");
        }
        H7.h applyCoroutineContext = composer.getApplyCoroutineContext();
        boolean zChanged = false;
        for (Object obj : Arrays.copyOf(objArr, objArr.length)) {
            zChanged |= composer.changed(obj);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, nVar));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
