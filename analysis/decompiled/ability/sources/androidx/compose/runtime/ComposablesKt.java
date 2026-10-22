package androidx.compose.runtime;

import S7.n;
import S7.o;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NotImplementedError;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0013\b\u0004\u0010\u0003\u001a\r\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0002\b\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0013\b\u0004\u0010\u0003\u001a\r\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0002\b\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\b\u001a?\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0013\b\u0004\u0010\u0003\u001a\r\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0002\b\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\n\u001aI\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0013\b\u0004\u0010\u0003\u001a\r\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0002\b\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\f\u001aC\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\r\"\u0004\u0018\u00010\u00062\u0013\b\u0004\u0010\u0003\u001a\r\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0002\b\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\u000f\u001aA\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\r\"\u0004\u0018\u00010\u00062\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a-\u0010\u0016\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0013\b\u0004\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001b\u001aY\u0010\"\u001a\u00020\u0014\"\b\b\u0000\u0010\u0000*\u00020\u0006\"\u000e\b\u0001\u0010\u001d\u0018\u0001*\u0006\u0012\u0002\b\u00030\u001c2\u000e\b\b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u001d\u0010!\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 \u0012\u0004\u0012\u00020\u00140\u001f¢\u0006\u0002\b\u0002H\u0087\b¢\u0006\u0004\b\"\u0010#\u001aY\u0010$\u001a\u00020\u0014\"\b\b\u0000\u0010\u0000*\u00020\u0006\"\u000e\b\u0001\u0010\u001d\u0018\u0001*\u0006\u0012\u0002\b\u00030\u001c2\u000e\b\b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u001d\u0010!\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 \u0012\u0004\u0012\u00020\u00140\u001f¢\u0006\u0002\b\u0002H\u0087\b¢\u0006\u0004\b$\u0010#\u001an\u0010\"\u001a\u00020\u0014\"\n\b\u0000\u0010\u0000*\u0004\u0018\u00010\u0006\"\u000e\b\u0001\u0010\u001d\u0018\u0001*\u0006\u0012\u0002\b\u00030\u001c2\u000e\b\b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u001d\u0010!\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 \u0012\u0004\u0012\u00020\u00140\u001f¢\u0006\u0002\b\u00022\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0004\b\"\u0010%\u001an\u0010$\u001a\u00020\u0014\"\n\b\u0000\u0010\u0000*\u0004\u0018\u00010\u0006\"\u000e\b\u0001\u0010\u001d\u0018\u0001*\u0006\u0012\u0002\b\u00030\u001c2\u000e\b\b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u001d\u0010!\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 \u0012\u0004\u0012\u00020\u00140\u001f¢\u0006\u0002\b\u00022\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0004\b$\u0010%\u001a\u0089\u0001\u0010\"\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u001d\u0018\u0001*\u0006\u0012\u0002\b\u00030\u001c2\u000e\b\b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u001d\u0010!\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 \u0012\u0004\u0012\u00020\u00140\u001f¢\u0006\u0002\b\u00022\u001f\b\b\u0010'\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\u0004\u0012\u00020\u00140\u001f¢\u0006\u0002\b\u00102\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0004\b\"\u0010(\u001a\u0089\u0001\u0010$\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u001d\u0018\u0001*\u0006\u0012\u0002\b\u00030\u001c2\u000e\b\b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u001d\u0010!\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 \u0012\u0004\u0012\u00020\u00140\u001f¢\u0006\u0002\b\u00022\u001f\b\b\u0010'\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\u0004\u0012\u00020\u00140\u001f¢\u0006\u0002\b\u00102\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0004\b$\u0010(\u001a\u000f\u0010)\u001a\u00020\u0014H\u0001¢\u0006\u0004\b)\u0010*\u001a\u000f\u0010,\u001a\u00020+H\u0007¢\u0006\u0004\b,\u0010-\"\u0011\u00101\u001a\u00020.8G¢\u0006\u0006\u001a\u0004\b/\u00100\"\u001a\u00104\u001a\u00020+8GX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010*\u001a\u0004\b2\u0010-\"\u0011\u00108\u001a\u0002058G¢\u0006\u0006\u001a\u0004\b6\u00107\"\u0017\u0010=\u001a\u0002098G¢\u0006\f\u0012\u0004\b<\u0010*\u001a\u0004\b:\u0010;\"\u001a\u0010B\u001a\u00020>8GX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010*\u001a\u0004\b?\u0010@\"\u0015\u0010G\u001a\u00060Cj\u0002`D8G¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006H"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "Landroidx/compose/runtime/DisallowComposableCalls;", "calculation", "remember", "(LS7/a;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "", "key1", "(Ljava/lang/Object;LS7/a;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key2", "(Ljava/lang/Object;Ljava/lang/Object;LS7/a;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;LS7/a;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "", "keys", "([Ljava/lang/Object;LS7/a;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "Landroidx/compose/runtime/Composable;", "block", "key", "([Ljava/lang/Object;LS7/n;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "LC7/r;", "content", "ReusableContent", "(Ljava/lang/Object;LS7/n;Landroidx/compose/runtime/Composer;I)V", "", "active", "ReusableContentHost", "(ZLS7/n;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Applier;", ExifInterface.LONGITUDE_EAST, "factory", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "update", "ComposeNode", "(LS7/a;LS7/k;Landroidx/compose/runtime/Composer;I)V", "ReusableComposeNode", "(LS7/a;LS7/k;LS7/n;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/SkippableUpdater;", "skippableUpdate", "(LS7/a;LS7/k;LS7/o;LS7/n;Landroidx/compose/runtime/Composer;I)V", "invalidApplier", "()V", "Landroidx/compose/runtime/CompositionContext;", "rememberCompositionContext", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/Composer;", "getCurrentComposer", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/Composer;", "currentComposer", "getCurrentCompositionContext", "getCurrentCompositionContext$annotations", "currentCompositionContext", "Landroidx/compose/runtime/RecomposeScope;", "getCurrentRecomposeScope", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/RecomposeScope;", "currentRecomposeScope", "Landroidx/compose/runtime/CompositionLocalContext;", "getCurrentCompositionLocalContext", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionLocalContext;", "getCurrentCompositionLocalContext$annotations", "currentCompositionLocalContext", "", "getCurrentCompositeKeyHash", "(Landroidx/compose/runtime/Composer;I)I", "getCurrentCompositeKeyHash$annotations", "currentCompositeKeyHash", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "getCurrentCompositeKeyHashCode", "(Landroidx/compose/runtime/Composer;I)J", "currentCompositeKeyHashCode", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposablesKt {
    @Composable
    public static final <T, E extends Applier<?>> void ComposeNode(S7.a aVar, S7.k kVar, Composer composer, int i) {
        composer.getApplier();
        kotlin.jvm.internal.k.m();
        throw null;
    }

    @Composable
    public static final <T, E extends Applier<?>> void ReusableComposeNode(S7.a aVar, S7.k kVar, Composer composer, int i) {
        composer.getApplier();
        kotlin.jvm.internal.k.m();
        throw null;
    }

    @Composable
    public static final void ReusableContent(Object obj, n nVar, Composer composer, int i) {
        composer.startReusableGroup(ComposerKt.reuseKey, obj);
        nVar.invoke(composer, Integer.valueOf((i >> 3) & 14));
        composer.endReusableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ReusableContentHost(boolean z10, n nVar, Composer composer, int i) {
        composer.startReusableGroup(ComposerKt.reuseKey, Boolean.valueOf(z10));
        boolean zChanged = composer.changed(z10);
        if (z10) {
            nVar.invoke(composer, Integer.valueOf((i >> 3) & 14));
        } else {
            composer.deactivateToEndGroup(zChanged);
        }
        composer.endReusableGroup();
    }

    @Composable
    @ReadOnlyComposable
    public static final Composer getCurrentComposer(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-554250212, i, -1, "androidx.compose.runtime.<get-currentComposer> (Composables.kt:180)");
        }
        throw new NotImplementedError("Implemented as an intrinsic");
    }

    @Composable
    public static final int getCurrentCompositeKeyHash(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(524444915, i, -1, "androidx.compose.runtime.<get-currentCompositeKeyHash> (Composables.kt:241)");
        }
        int compoundKeyHash = composer.getCompoundKeyHash();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return compoundKeyHash;
    }

    @C7.c
    public static /* synthetic */ void getCurrentCompositeKeyHash$annotations() {
    }

    @Composable
    public static final long getCurrentCompositeKeyHashCode(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-168259424, i, -1, "androidx.compose.runtime.<get-currentCompositeKeyHashCode> (Composables.kt:257)");
        }
        long compositeKeyHashCode = composer.getCompositeKeyHashCode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return compositeKeyHashCode;
    }

    @Composable
    @ReadOnlyComposable
    public static final CompositionContext getCurrentCompositionContext(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1645225943, i, -1, "androidx.compose.runtime.<get-currentCompositionContext> (Composables.kt:195)");
        }
        ControlledComposition composition = composer.getComposition();
        kotlin.jvm.internal.k.d(composition, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
        CompositionContext parent = ((CompositionImpl) composition).getParent();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return parent;
    }

    @InternalComposeApi
    public static /* synthetic */ void getCurrentCompositionContext$annotations() {
    }

    @Composable
    public static final CompositionLocalContext getCurrentCompositionLocalContext(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-43352356, i, -1, "androidx.compose.runtime.<get-currentCompositionLocalContext> (Composables.kt:220)");
        }
        CompositionLocalContext compositionLocalContext = new CompositionLocalContext(composer.buildContext().getCompositionLocalScope$runtime());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return compositionLocalContext;
    }

    public static /* synthetic */ void getCurrentCompositionLocalContext$annotations() {
    }

    @Composable
    @ReadOnlyComposable
    public static final RecomposeScope getCurrentRecomposeScope(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(394957799, i, -1, "androidx.compose.runtime.<get-currentRecomposeScope> (Composables.kt:205)");
        }
        RecomposeScope recomposeScope = composer.getRecomposeScope();
        if (recomposeScope == null) {
            throw new IllegalStateException("no recompose scope found");
        }
        composer.recordUsed(recomposeScope);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return recomposeScope;
    }

    public static final void invalidApplier() {
        throw new IllegalStateException("Invalid applier");
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> T key(Object[] objArr, n nVar, Composer composer, int i) {
        return (T) nVar.invoke(composer, Integer.valueOf((i >> 3) & 14));
    }

    @Composable
    public static final <T> T remember(Object obj, S7.a aVar, Composer composer, int i) {
        boolean zChanged = composer.changed(obj);
        T t9 = (T) composer.rememberedValue();
        if (!zChanged && t9 != Composer.INSTANCE.getEmpty()) {
            return t9;
        }
        T t10 = (T) aVar.invoke();
        composer.updateRememberedValue(t10);
        return t10;
    }

    @Composable
    public static final CompositionContext rememberCompositionContext(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1165786124, i, -1, "androidx.compose.runtime.rememberCompositionContext (Composables.kt:505)");
        }
        CompositionContext compositionContextBuildContext = composer.buildContext();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return compositionContextBuildContext;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T, E extends Applier<?>> void ComposeNode(S7.a aVar, S7.k kVar, n nVar, Composer composer, int i) {
        composer.getApplier();
        kotlin.jvm.internal.k.m();
        throw null;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T, E extends Applier<?>> void ReusableComposeNode(S7.a aVar, S7.k kVar, n nVar, Composer composer, int i) {
        composer.getApplier();
        kotlin.jvm.internal.k.m();
        throw null;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <T, E extends Applier<?>> void ComposeNode(S7.a aVar, S7.k kVar, o oVar, n nVar, Composer composer, int i) {
        composer.getApplier();
        kotlin.jvm.internal.k.m();
        throw null;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <T, E extends Applier<?>> void ReusableComposeNode(S7.a aVar, S7.k kVar, o oVar, n nVar, Composer composer, int i) {
        composer.getApplier();
        kotlin.jvm.internal.k.m();
        throw null;
    }

    @Composable
    public static final <T> T remember(Object obj, Object obj2, S7.a aVar, Composer composer, int i) {
        boolean zChanged = composer.changed(obj) | composer.changed(obj2);
        T t9 = (T) composer.rememberedValue();
        if (!zChanged && t9 != Composer.INSTANCE.getEmpty()) {
            return t9;
        }
        T t10 = (T) aVar.invoke();
        composer.updateRememberedValue(t10);
        return t10;
    }

    @Composable
    public static final <T> T remember(Object obj, Object obj2, Object obj3, S7.a aVar, Composer composer, int i) {
        boolean zChanged = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        T t9 = (T) composer.rememberedValue();
        if (!zChanged && t9 != Composer.INSTANCE.getEmpty()) {
            return t9;
        }
        T t10 = (T) aVar.invoke();
        composer.updateRememberedValue(t10);
        return t10;
    }

    @Composable
    public static final <T> T remember(Object[] objArr, S7.a aVar, Composer composer, int i) {
        boolean zChanged = false;
        for (Object obj : objArr) {
            zChanged |= composer.changed(obj);
        }
        T t9 = (T) composer.rememberedValue();
        if (!zChanged && t9 != Composer.INSTANCE.getEmpty()) {
            return t9;
        }
        T t10 = (T) aVar.invoke();
        composer.updateRememberedValue(t10);
        return t10;
    }

    @Composable
    public static final <T> T remember(S7.a aVar, Composer composer, int i) {
        T t9 = (T) composer.rememberedValue();
        if (t9 != Composer.INSTANCE.getEmpty()) {
            return t9;
        }
        T t10 = (T) aVar.invoke();
        composer.updateRememberedValue(t10);
        return t10;
    }
}
