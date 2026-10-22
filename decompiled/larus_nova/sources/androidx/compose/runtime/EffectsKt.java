package androidx.compose.runtime;

import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a&\u0010\n\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e\u001a0\u0010\n\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0011\u001a:\u0010\n\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0013\u001aD\u0010\n\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0015\u001a>\u0010\n\u001a\u00020\u00012\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u0017\"\u0004\u0018\u00010\u00102\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0018\u001a6\u0010\u0019\u001a\u00020\u00012'\u0010\u001a\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001b¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001e\u001a@\u0010\u0019\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102'\u0010\u001a\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001b¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001f\u001aJ\u0010\u0019\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102'\u0010\u001a\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001b¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010 \u001aT\u0010\u0019\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102'\u0010\u001a\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001b¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010!\u001aN\u0010\u0019\u001a\u00020\u00012\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u0017\"\u0004\u0018\u00010\u00102'\u0010\u001a\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001b¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\"\u001a\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001\u001a#\u0010(\u001a\u00020\u001c2\u0013\b\u0006\u0010)\u001a\r\u0012\u0004\u0012\u00020%0\u0003¢\u0006\u0002\b*H\u0087\b¢\u0006\u0002\u0010+\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"SideEffect", "", "effect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "InternalDisposableEffectScope", "Landroidx/compose/runtime/DisposableEffectScope;", "DisposableEffectNoParamError", "", "LaunchedEffectNoParamError", "DisposableEffect", "Lkotlin/Function1;", "Landroidx/compose/runtime/DisposableEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key1", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "keys", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LaunchedEffect", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "createCompositionCoroutineScope", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", ComposerHelper.CONFIG_TYPE_COMPOSER, "Landroidx/compose/runtime/Composer;", "rememberCoroutineScope", "getContext", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlinx/coroutines/CoroutineScope;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EffectsKt {
    private static final String DisposableEffectNoParamError = "DisposableEffect must provide one or more 'key' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.";
    private static final DisposableEffectScope InternalDisposableEffectScope = null;
    private static final String LaunchedEffectNoParamError = "LaunchedEffect must provide one or more 'key' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    private static final Unit LaunchedEffect$lambda$4(Function2 r100, int r101, Composer r102, int r103) {
        LaunchedEffect(r100, r102, RecomposeScopeImplKt.updateChangedFlags(r101 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r100, int r101, Composer r102, int r103) {
        return LaunchedEffect$lambda$4(r100, r101, r102, r103);
    }

    static {
        InternalDisposableEffectScope = new DisposableEffectScope();
    }

    public static final /* synthetic */ DisposableEffectScope access$getInternalDisposableEffectScope$p() {
        return InternalDisposableEffectScope;
    }

    public static final CoroutineScope createCompositionCoroutineScope(CoroutineContext r100, Composer r101) {
        if (r100.get(Job.Key) == null) goto L6;
        CompletableJob r102 = JobKt.Job$default(null, 1, null);
        r102.completeExceptionally(new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job"));
        return CoroutineScopeKt.CoroutineScope(r102);
    L6:
        return new RememberedCoroutineScope(r101.getApplyCoroutineContext(), r100);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = DisposableEffectNoParamError)
    public static final void DisposableEffect(Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> r100, Composer r101, int r102) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(-904483903, r102, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:120)");
    L6:
        throw new IllegalStateException(DisposableEffectNoParamError.toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = LaunchedEffectNoParamError)
    public static final void LaunchedEffect(final Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r100, Composer r101, final int r102) {
        Composer r103 = r101.startRestartGroup(-805415771);
        int r104 = r102 & 1;
        if (r104 == 0) goto L5;
        boolean r105 = true;
    L7:
        if (r103.shouldExecute(r105, r104) == true) goto L9;
        r103.skipToGroupEnd();
        ScopeUpdateScope r106 = r103.endRestartGroup();
        if (r106 == null) goto L17;
        r106.updateScope(new o(r100, r102));
        return;
    L17:
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventStart(-805415771, r102, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:325)");
    L12:
        throw new IllegalStateException(LaunchedEffectNoParamError.toString());
    L5:
        r105 = false;
        goto L7
    }

    public static final void SideEffect(Function0<Unit> r100, Composer r101, int r102) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1288466761, r102, -1, "androidx.compose.runtime.SideEffect (Effects.kt:51)");
    L5:
        r101.recordSideEffect(r100);
        if (ComposerKt.isTraceInProgress() == false) goto L9;
        ComposerKt.traceEventEnd();
        return;
    }

    public static final void DisposableEffect(Object[] r100, Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> r101, Composer r102, int r103) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1307627122, r103, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:264)");
    L5:
        Object[] r104 = Arrays.copyOf(r100, r100.length);
        int r105 = r104.length;
        int r106 = 0;
        boolean r107 = false;
    L6:
        if (r106 >= r105) goto L8;
        r107 = r107 | r102.changed(r104[r106]);
        r106 = r106 + 1;
        goto L6
    L8:
        Object r108 = r102.rememberedValue();
        if (r107 == false) goto L11;
    L12:
        r102.updateRememberedValue(new DisposableEffectImpl(r101));
    L14:
        if (ComposerKt.isTraceInProgress() == false) goto L18;
        ComposerKt.traceEventEnd();
        return;
    L18:
        return;
    L11:
        if (r108 != Composer.Companion.getEmpty()) goto L14;
        goto L12
    }

    public static final void LaunchedEffect(Object[] r100, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r101, Composer r102, int r103) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-139560008, r103, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:407)");
    L5:
        CoroutineContext r104 = r102.getApplyCoroutineContext();
        Object[] r105 = Arrays.copyOf(r100, r100.length);
        int r106 = r105.length;
        int r107 = 0;
        boolean r108 = false;
    L6:
        if (r107 >= r106) goto L8;
        r108 = r108 | r102.changed(r105[r107]);
        r107 = r107 + 1;
        goto L6
    L8:
        Object r109 = r102.rememberedValue();
        if (r108 == false) goto L11;
    L12:
        r102.updateRememberedValue(new LaunchedEffectImpl(r104, r101));
    L14:
        if (ComposerKt.isTraceInProgress() == false) goto L18;
        ComposerKt.traceEventEnd();
        return;
    L18:
        return;
    L11:
        if (r109 != Composer.Companion.getEmpty()) goto L14;
        goto L12
    }

    public static final CoroutineScope rememberCoroutineScope(Function0<? extends CoroutineContext> r100, Composer r101, int r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        r100 = AnonymousClass1.INSTANCE;
    L5:
        Object r104 = r101.rememberedValue();
        if (r104 != Composer.Companion.getEmpty()) goto L9;
        r104 = createCompositionCoroutineScope(r100.invoke(), r101);
        r101.updateRememberedValue(r104);
    L9:
        return (CoroutineScope) r104;
    }

    public static final void DisposableEffect(Object r100, Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> r101, Composer r102, int r103) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1371986847, r103, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:153)");
    L5:
        boolean r104 = r102.changed(r100);
        Object r105 = r102.rememberedValue();
        if (r104 == false) goto L8;
    L9:
        r105 = new DisposableEffectImpl(r101);
        r102.updateRememberedValue(r105);
    L10:
        DisposableEffectImpl r106 = (DisposableEffectImpl) r105;
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
        return;
    L14:
        return;
    L8:
        if (r105 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    public static final void LaunchedEffect(Object r100, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r101, Composer r102, int r103) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1179185413, r103, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:341)");
    L5:
        CoroutineContext r104 = r102.getApplyCoroutineContext();
        boolean r105 = r102.changed(r100);
        Object r106 = r102.rememberedValue();
        if (r105 == false) goto L8;
    L9:
        r106 = new LaunchedEffectImpl(r104, r101);
        r102.updateRememberedValue(r106);
    L10:
        LaunchedEffectImpl r107 = (LaunchedEffectImpl) r106;
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
        return;
    L14:
        return;
    L8:
        if (r106 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    public static final void DisposableEffect(Object r100, Object r101, Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> r102, Composer r103, int r104) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1429097729, r104, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:190)");
    L5:
        boolean r105 = r103.changed(r100) | r103.changed(r101);
        Object r106 = r103.rememberedValue();
        if (r105 == false) goto L8;
    L9:
        r106 = new DisposableEffectImpl(r102);
        r103.updateRememberedValue(r106);
    L10:
        DisposableEffectImpl r107 = (DisposableEffectImpl) r106;
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
        return;
    L14:
        return;
    L8:
        if (r106 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    public static final void LaunchedEffect(Object r100, Object r101, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r102, Composer r103, int r104) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(590241125, r104, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:360)");
    L5:
        CoroutineContext r105 = r103.getApplyCoroutineContext();
        boolean r106 = r103.changed(r100) | r103.changed(r101);
        Object r107 = r103.rememberedValue();
        if (r106 == false) goto L8;
    L9:
        r107 = new LaunchedEffectImpl(r105, r102);
        r103.updateRememberedValue(r107);
    L10:
        LaunchedEffectImpl r108 = (LaunchedEffectImpl) r107;
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
        return;
    L14:
        return;
    L8:
        if (r107 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    public static final void DisposableEffect(Object r100, Object r101, Object r102, Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> r103, Composer r104, int r105) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1239538271, r105, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:228)");
    L5:
        boolean r106 = (r104.changed(r100) | r104.changed(r101)) | r104.changed(r102);
        Object r107 = r104.rememberedValue();
        if (r106 == false) goto L8;
    L9:
        r107 = new DisposableEffectImpl(r103);
        r104.updateRememberedValue(r107);
    L10:
        DisposableEffectImpl r108 = (DisposableEffectImpl) r107;
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
        return;
    L14:
        return;
    L8:
        if (r107 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    public static final void LaunchedEffect(Object r100, Object r101, Object r102, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r103, Composer r104, int r105) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-54093371, r105, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:384)");
    L5:
        CoroutineContext r106 = r104.getApplyCoroutineContext();
        boolean r107 = (r104.changed(r100) | r104.changed(r101)) | r104.changed(r102);
        Object r108 = r104.rememberedValue();
        if (r107 == false) goto L8;
    L9:
        r108 = new LaunchedEffectImpl(r106, r103);
        r104.updateRememberedValue(r108);
    L10:
        LaunchedEffectImpl r109 = (LaunchedEffectImpl) r108;
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
        return;
    L14:
        return;
    L8:
        if (r108 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }
}
