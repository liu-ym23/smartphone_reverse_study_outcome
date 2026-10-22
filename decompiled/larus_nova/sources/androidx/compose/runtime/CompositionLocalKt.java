package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a \u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a+\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00020\n¢\u0006\u0002\b\f\u001a<\u0010\r\u001a\u00020\u000e2\u001a\u0010\u000f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010\"\u0006\u0012\u0002\b\u00030\u00112\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a,\u0010\r\u001a\u00020\u000e2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00112\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0016\u001a(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"compositionLocalOf", "Landroidx/compose/runtime/ProvidableCompositionLocal;", ExifInterface.GPS_DIRECTION_TRUE, "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "defaultFactory", "Lkotlin/Function0;", "staticCompositionLocalOf", "compositionLocalWithComputedDefaultOf", "defaultComputation", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "CompositionLocalProvider", "", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "content", "Landroidx/compose/runtime/Composable;", "([Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "value", "(Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroidx/compose/runtime/CompositionLocalContext;", "(Landroidx/compose/runtime/CompositionLocalContext;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CompositionLocalKt {
    private static final Unit CompositionLocalProvider$lambda$0(ProvidedValue[] r100, Function2 r101, int r102, Composer r103, int r104) {
        CompositionLocalProvider(r100, r101, r103, RecomposeScopeImplKt.updateChangedFlags(r102 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit CompositionLocalProvider$lambda$1(ProvidedValue r100, Function2 r101, int r102, Composer r103, int r104) {
        CompositionLocalProvider(r100, r101, r103, RecomposeScopeImplKt.updateChangedFlags(r102 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit CompositionLocalProvider$lambda$3(CompositionLocalContext r100, Function2 r101, int r102, Composer r103, int r104) {
        CompositionLocalProvider(r100, r101, r103, RecomposeScopeImplKt.updateChangedFlags(r102 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(ProvidedValue r100, Function2 r101, int r102, Composer r103, int r104) {
        return CompositionLocalProvider$lambda$1(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit b(ProvidedValue[] r100, Function2 r101, int r102, Composer r103, int r104) {
        return CompositionLocalProvider$lambda$0(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit c(CompositionLocalContext r100, Function2 r101, int r102, Composer r103, int r104) {
        return CompositionLocalProvider$lambda$3(r100, r101, r102, r103, r104);
    }

    public static final <T> ProvidableCompositionLocal<T> compositionLocalWithComputedDefaultOf(Function1<? super CompositionLocalAccessorScope, ? extends T> r100) {
        return new ComputedProvidableCompositionLocal(r100);
    }

    public static final <T> ProvidableCompositionLocal<T> staticCompositionLocalOf(Function0<? extends T> r100) {
        return new StaticProvidableCompositionLocal(r100);
    }

    public static final <T> ProvidableCompositionLocal<T> compositionLocalOf(SnapshotMutationPolicy<T> r100, Function0<? extends T> r101) {
        return new DynamicProvidableCompositionLocal(r100, r101);
    }

    public static final void CompositionLocalProvider(final CompositionLocalContext r100, final Function2<? super Composer, ? super Integer, Unit> r101, Composer r102, final int r103) {
        Composer r104 = r102.startRestartGroup(-1162003659);
        if ((r103 & 6) == 0) goto L5;
        int r105 = r103;
    L11:
        if ((r103 & 48) != 0) goto L18;
        if (r104.changedInstance(r101) == false) goto L15;
        int r106 = 32;
    L16:
        r105 = r105 | r106;
        goto L18
    L15:
        r106 = 16;
    L18:
        if ((r105 & 19) == 18) goto L20;
        boolean r107 = true;
    L22:
        if (r104.shouldExecute(r107, r105 & 1) == true) goto L24;
        r104.skipToGroupEnd();
    L34:
        ScopeUpdateScope r108 = r104.endRestartGroup();
        if (r108 == null) goto L39;
        r108.updateScope(new j(r100, r101, r103));
        return;
    L39:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-1162003659, r105, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:408)");
    L26:
        PersistentCompositionLocalMap r109 = r100.getCompositionLocals$runtime();
        ArrayList r110 = new ArrayList(r109.size());
        Iterator<Map.Entry<CompositionLocal<Object>, ValueHolder<Object>>> r111 = r109.entrySet().iterator();
    L28:
        if (r111.hasNext() == false) goto L30;
        Map.Entry<CompositionLocal<Object>, ValueHolder<Object>> r112 = r111.next();
        r110.add(r112.getValue().toProvided(r112.getKey()));
        goto L28
    L30:
        ProvidedValue[] r113 = (ProvidedValue[]) r110.toArray(new ProvidedValue[0]);
        CompositionLocalProvider((ProvidedValue[]) Arrays.copyOf(r113, r113.length), r101, r104, r105 & 112);
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventEnd();
        goto L34
    L20:
        r107 = false;
        goto L22
    L5:
        if (r104.changed(r100) == false) goto L7;
        int r114 = 4;
    L8:
        r105 = r114 | r103;
        goto L11
    L7:
        r114 = 2;
        goto L8
    }

    public static /* synthetic */ ProvidableCompositionLocal compositionLocalOf$default(SnapshotMutationPolicy r100, Function0 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = SnapshotStateKt.structuralEqualityPolicy();
    L6:
        return compositionLocalOf(r100, r101);
    }

    public static final void CompositionLocalProvider(final ProvidedValue<?> r100, final Function2<? super Composer, ? super Integer, Unit> r101, Composer r102, final int r103) {
        Composer r104 = r102.startRestartGroup(-149765515);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-149765515, r103, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:387)");
    L5:
        r104.startProvider(r100);
        r101.invoke(r104, Integer.valueOf((r103 >> 3) & 14));
        r104.endProvider();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        ScopeUpdateScope r105 = r104.endRestartGroup();
        if (r105 == null) goto L12;
        r105.updateScope(new k(r100, r101, r103));
        return;
    }

    public static final void CompositionLocalProvider(final ProvidedValue<?>[] r100, final Function2<? super Composer, ? super Integer, Unit> r101, Composer r102, final int r103) {
        Composer r104 = r102.startRestartGroup(415205898);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(415205898, r103, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:367)");
    L5:
        r104.startProviders(r100);
        r101.invoke(r104, Integer.valueOf((r103 >> 3) & 14));
        r104.endProviders();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        ScopeUpdateScope r105 = r104.endRestartGroup();
        if (r105 == null) goto L12;
        r105.updateScope(new l(r100, r101, r103));
        return;
    }
}
