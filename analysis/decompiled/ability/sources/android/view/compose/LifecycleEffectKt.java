package android.view.compose;

import C7.c;
import C7.r;
import S7.a;
import S7.k;
import android.view.Lifecycle;
import android.view.LifecycleEventObserver;
import android.view.LifecycleOwner;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.m;
import androidx.core.app.NotificationCompat;
import androidx.core.view.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a/\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a7\u0010\u000f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001aA\u0010\u000f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0012\u001aK\u0010\u000f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0014\u001aE\u0010\u000f\u001a\u00020\u00052\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0015\"\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0017\u001a-\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0018\u001a3\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a7\u0010\u001e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u000bH\u0007¢\u0006\u0004\b\u001e\u0010\u0010\u001aA\u0010\u001e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u000bH\u0007¢\u0006\u0004\b\u001e\u0010\u0012\u001aK\u0010\u001e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u000bH\u0007¢\u0006\u0004\b\u001e\u0010\u0014\u001aE\u0010\u001e\u001a\u00020\u00052\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0015\"\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u000bH\u0007¢\u0006\u0004\b\u001e\u0010\u0017\u001a-\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u000bH\u0007¢\u0006\u0004\b\u001e\u0010\u0018\u001a3\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001c2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u000bH\u0003¢\u0006\u0004\b\u001f\u0010 \"\u0014\u0010\"\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#\"\u0014\u0010$\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010#¨\u0006&²\u0006\u0012\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/lifecycle/Lifecycle$Event;", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Function0;", "LC7/r;", "onEvent", "LifecycleEventEffect", "(Landroidx/lifecycle/Lifecycle$Event;Landroidx/lifecycle/LifecycleOwner;LS7/a;Landroidx/compose/runtime/Composer;II)V", "", "key1", "Lkotlin/Function1;", "Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;", "Landroidx/lifecycle/compose/LifecycleStopOrDisposeEffectResult;", "effects", "LifecycleStartEffect", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;LS7/k;Landroidx/compose/runtime/Composer;II)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;LS7/k;Landroidx/compose/runtime/Composer;II)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;LS7/k;Landroidx/compose/runtime/Composer;II)V", "", "keys", "([Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;LS7/k;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/lifecycle/LifecycleOwner;LS7/k;Landroidx/compose/runtime/Composer;II)V", "scope", "LifecycleStartEffectImpl", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;LS7/k;Landroidx/compose/runtime/Composer;I)V", "Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;", "Landroidx/lifecycle/compose/LifecyclePauseOrDisposeEffectResult;", "LifecycleResumeEffect", "LifecycleResumeEffectImpl", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;LS7/k;Landroidx/compose/runtime/Composer;I)V", "", "LifecycleStartEffectNoParamError", "Ljava/lang/String;", "LifecycleResumeEffectNoParamError", "currentOnEvent", "lifecycle-runtime-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LifecycleEffectKt {
    private static final String LifecycleResumeEffectNoParamError = "LifecycleResumeEffect must provide one or more 'key' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";
    private static final String LifecycleStartEffectNoParamError = "LifecycleStartEffect must provide one or more 'key' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dd  */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleEventEffect(androidx.lifecycle.Lifecycle.Event r7, android.view.LifecycleOwner r8, S7.a r9, androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.compose.LifecycleEffectKt.LifecycleEventEffect(androidx.lifecycle.Lifecycle$Event, androidx.lifecycle.LifecycleOwner, S7.a, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final a LifecycleEventEffect$lambda$0(State<? extends a> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult LifecycleEventEffect$lambda$4$lambda$3(final LifecycleOwner lifecycleOwner, final Lifecycle.Event event, final State state, DisposableEffectScope disposableEffectScope) {
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.compose.d
            @Override // android.view.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event2) {
                LifecycleEffectKt.LifecycleEventEffect$lambda$4$lambda$3$lambda$1(event, state, lifecycleOwner2, event2);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$lambda$4$lambda$3$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LifecycleEventEffect$lambda$4$lambda$3$lambda$1(Lifecycle.Event event, State state, LifecycleOwner lifecycleOwner, Lifecycle.Event event2) {
        if (event2 == event) {
            LifecycleEventEffect$lambda$0(state).invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleEventEffect$lambda$5(Lifecycle.Event event, LifecycleOwner lifecycleOwner, a aVar, int i, int i6, Composer composer, int i10) {
        LifecycleEventEffect(event, lifecycleOwner, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c5  */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleResumeEffect(java.lang.Object r8, android.view.LifecycleOwner r9, S7.k r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, androidx.lifecycle.LifecycleOwner, S7.k, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleResumeEffect$lambda$22(Object obj, LifecycleOwner lifecycleOwner, k kVar, int i, int i6, Composer composer, int i10) {
        LifecycleResumeEffect(obj, lifecycleOwner, kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleResumeEffect$lambda$24(Object obj, Object obj2, LifecycleOwner lifecycleOwner, k kVar, int i, int i6, Composer composer, int i10) {
        LifecycleResumeEffect(obj, obj2, lifecycleOwner, kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleResumeEffect$lambda$26(Object obj, Object obj2, Object obj3, LifecycleOwner lifecycleOwner, k kVar, int i, int i6, Composer composer, int i10) {
        LifecycleResumeEffect(obj, obj2, obj3, lifecycleOwner, kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleResumeEffect$lambda$28(Object[] objArr, LifecycleOwner lifecycleOwner, k kVar, int i, int i6, Composer composer, int i10) {
        LifecycleResumeEffect(objArr, lifecycleOwner, kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleResumeEffect$lambda$29(LifecycleOwner lifecycleOwner, k kVar, int i, int i6, Composer composer, int i10) {
        LifecycleResumeEffect(lifecycleOwner, kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }

    @Composable
    private static final void LifecycleResumeEffectImpl(LifecycleOwner lifecycleOwner, LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, k kVar, Composer composer, int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(912823238);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(lifecycleResumePauseEffectScope) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(kVar) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i6 & 147) != 146, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(912823238, i6, -1, "androidx.lifecycle.compose.LifecycleResumeEffectImpl (LifecycleEffect.kt:663)");
            }
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(lifecycleResumePauseEffectScope) | ((i6 & 896) == 256) | composerStartRestartGroup.changedInstance(lifecycleOwner);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new R3.k(lifecycleOwner, lifecycleResumePauseEffectScope, kVar, 4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.DisposableEffect(lifecycleOwner, lifecycleResumePauseEffectScope, (k) objRememberedValue, composerStartRestartGroup, i6 & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new m(lifecycleOwner, lifecycleResumePauseEffectScope, kVar, i, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult LifecycleResumeEffectImpl$lambda$34$lambda$33(final LifecycleOwner lifecycleOwner, LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, k kVar, DisposableEffectScope disposableEffectScope) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final e eVar = new e(lifecycleResumePauseEffectScope, ref$ObjectRef, kVar, 2);
        lifecycleOwner.getLifecycle().addObserver(eVar);
        return new DisposableEffectResult() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffectImpl$lambda$34$lambda$33$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lifecycleOwner.getLifecycle().removeObserver(eVar);
                LifecyclePauseOrDisposeEffectResult lifecyclePauseOrDisposeEffectResult = (LifecyclePauseOrDisposeEffectResult) ref$ObjectRef.f4920a;
                if (lifecyclePauseOrDisposeEffectResult != null) {
                    lifecyclePauseOrDisposeEffectResult.runPauseOrOnDisposeEffect();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LifecycleResumeEffectImpl$lambda$34$lambda$33$lambda$31(LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, Ref$ObjectRef ref$ObjectRef, k kVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 3) {
            ref$ObjectRef.f4920a = kVar.invoke(lifecycleResumePauseEffectScope);
        } else {
            if (i != 4) {
                return;
            }
            LifecyclePauseOrDisposeEffectResult lifecyclePauseOrDisposeEffectResult = (LifecyclePauseOrDisposeEffectResult) ref$ObjectRef.f4920a;
            if (lifecyclePauseOrDisposeEffectResult != null) {
                lifecyclePauseOrDisposeEffectResult.runPauseOrOnDisposeEffect();
            }
            ref$ObjectRef.f4920a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleResumeEffectImpl$lambda$35(LifecycleOwner lifecycleOwner, LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, k kVar, int i, Composer composer, int i6) {
        LifecycleResumeEffectImpl(lifecycleOwner, lifecycleResumePauseEffectScope, kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c5  */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleStartEffect(java.lang.Object r8, android.view.LifecycleOwner r9, S7.k r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, androidx.lifecycle.LifecycleOwner, S7.k, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleStartEffect$lambda$11(Object obj, Object obj2, Object obj3, LifecycleOwner lifecycleOwner, k kVar, int i, int i6, Composer composer, int i10) {
        LifecycleStartEffect(obj, obj2, obj3, lifecycleOwner, kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleStartEffect$lambda$13(Object[] objArr, LifecycleOwner lifecycleOwner, k kVar, int i, int i6, Composer composer, int i10) {
        LifecycleStartEffect(objArr, lifecycleOwner, kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleStartEffect$lambda$14(LifecycleOwner lifecycleOwner, k kVar, int i, int i6, Composer composer, int i10) {
        LifecycleStartEffect(lifecycleOwner, kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleStartEffect$lambda$7(Object obj, LifecycleOwner lifecycleOwner, k kVar, int i, int i6, Composer composer, int i10) {
        LifecycleStartEffect(obj, lifecycleOwner, kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleStartEffect$lambda$9(Object obj, Object obj2, LifecycleOwner lifecycleOwner, k kVar, int i, int i6, Composer composer, int i10) {
        LifecycleStartEffect(obj, obj2, lifecycleOwner, kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }

    @Composable
    private static final void LifecycleStartEffectImpl(LifecycleOwner lifecycleOwner, LifecycleStartStopEffectScope lifecycleStartStopEffectScope, k kVar, Composer composer, int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(228371534);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(lifecycleStartStopEffectScope) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(kVar) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i6 & 147) != 146, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(228371534, i6, -1, "androidx.lifecycle.compose.LifecycleStartEffectImpl (LifecycleEffect.kt:340)");
            }
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(lifecycleStartStopEffectScope) | ((i6 & 896) == 256) | composerStartRestartGroup.changedInstance(lifecycleOwner);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new R3.k(lifecycleOwner, lifecycleStartStopEffectScope, kVar, 3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.DisposableEffect(lifecycleOwner, lifecycleStartStopEffectScope, (k) objRememberedValue, composerStartRestartGroup, i6 & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new m(lifecycleOwner, lifecycleStartStopEffectScope, kVar, i, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult LifecycleStartEffectImpl$lambda$19$lambda$18(final LifecycleOwner lifecycleOwner, LifecycleStartStopEffectScope lifecycleStartStopEffectScope, k kVar, DisposableEffectScope disposableEffectScope) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final e eVar = new e(lifecycleStartStopEffectScope, ref$ObjectRef, kVar, 1);
        lifecycleOwner.getLifecycle().addObserver(eVar);
        return new DisposableEffectResult() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffectImpl$lambda$19$lambda$18$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lifecycleOwner.getLifecycle().removeObserver(eVar);
                LifecycleStopOrDisposeEffectResult lifecycleStopOrDisposeEffectResult = (LifecycleStopOrDisposeEffectResult) ref$ObjectRef.f4920a;
                if (lifecycleStopOrDisposeEffectResult != null) {
                    lifecycleStopOrDisposeEffectResult.runStopOrDisposeEffect();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LifecycleStartEffectImpl$lambda$19$lambda$18$lambda$16(LifecycleStartStopEffectScope lifecycleStartStopEffectScope, Ref$ObjectRef ref$ObjectRef, k kVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            ref$ObjectRef.f4920a = kVar.invoke(lifecycleStartStopEffectScope);
        } else {
            if (i != 2) {
                return;
            }
            LifecycleStopOrDisposeEffectResult lifecycleStopOrDisposeEffectResult = (LifecycleStopOrDisposeEffectResult) ref$ObjectRef.f4920a;
            if (lifecycleStopOrDisposeEffectResult != null) {
                lifecycleStopOrDisposeEffectResult.runStopOrDisposeEffect();
            }
            ref$ObjectRef.f4920a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r LifecycleStartEffectImpl$lambda$20(LifecycleOwner lifecycleOwner, LifecycleStartStopEffectScope lifecycleStartStopEffectScope, k kVar, int i, Composer composer, int i6) {
        LifecycleStartEffectImpl(lifecycleOwner, lifecycleStartStopEffectScope, kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e3  */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleResumeEffect(java.lang.Object r9, java.lang.Object r10, android.view.LifecycleOwner r11, S7.k r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, S7.k, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e3  */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleStartEffect(java.lang.Object r9, java.lang.Object r10, android.view.LifecycleOwner r11, S7.k r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, S7.k, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ff  */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleResumeEffect(java.lang.Object r9, java.lang.Object r10, java.lang.Object r11, android.view.LifecycleOwner r12, S7.k r13, androidx.compose.runtime.Composer r14, int r15, int r16) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, S7.k, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ff  */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleStartEffect(java.lang.Object r9, java.lang.Object r10, java.lang.Object r11, android.view.LifecycleOwner r12, S7.k r13, androidx.compose.runtime.Composer r14, int r15, int r16) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, S7.k, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cd A[LOOP:1: B:57:0x00cb->B:58:0x00cd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0103  */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleResumeEffect(java.lang.Object[] r8, android.view.LifecycleOwner r9, S7.k r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object[], androidx.lifecycle.LifecycleOwner, S7.k, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cd A[LOOP:1: B:57:0x00cb->B:58:0x00cd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0103  */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleStartEffect(java.lang.Object[] r8, android.view.LifecycleOwner r9, S7.k r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object[], androidx.lifecycle.LifecycleOwner, S7.k, androidx.compose.runtime.Composer, int, int):void");
    }

    @c
    @Composable
    public static final void LifecycleResumeEffect(LifecycleOwner lifecycleOwner, k kVar, Composer composer, int i, int i6) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-747476210);
        int i10 = i & 1;
        if (!composerStartRestartGroup.shouldExecute(i10 != 0, i10)) {
            composerStartRestartGroup.skipToGroupEnd();
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new C0770b(lifecycleOwner, kVar, i, i6, 1));
                return;
            }
            return;
        }
        composerStartRestartGroup.startDefaults();
        if (i10 != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
            composerStartRestartGroup.skipToGroupEnd();
            if ((i6 & 1) != 0) {
                i &= -15;
            }
        } else if ((i6 & 1) != 0) {
            i &= -15;
        }
        composerStartRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-747476210, i, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:656)");
        }
        throw new IllegalStateException(LifecycleResumeEffectNoParamError);
    }

    @c
    @Composable
    public static final void LifecycleStartEffect(LifecycleOwner lifecycleOwner, k kVar, Composer composer, int i, int i6) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-50807951);
        int i10 = i & 1;
        if (!composerStartRestartGroup.shouldExecute(i10 != 0, i10)) {
            composerStartRestartGroup.skipToGroupEnd();
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new C0770b(lifecycleOwner, kVar, i, i6, 0));
                return;
            }
            return;
        }
        composerStartRestartGroup.startDefaults();
        if (i10 != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
            composerStartRestartGroup.skipToGroupEnd();
            if ((i6 & 1) != 0) {
                i &= -15;
            }
        } else if ((i6 & 1) != 0) {
            i &= -15;
        }
        composerStartRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-50807951, i, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:333)");
        }
        throw new IllegalStateException(LifecycleStartEffectNoParamError);
    }
}
