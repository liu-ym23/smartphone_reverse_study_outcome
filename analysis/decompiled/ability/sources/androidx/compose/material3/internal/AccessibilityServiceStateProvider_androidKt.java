package androidx.compose.material3.internal;

import C7.r;
import S7.k;
import S7.n;
import android.content.Context;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.accessibility.AccessibilityManager;
import android.view.compose.LocalLifecycleOwnerKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a)\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a=\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"", "listenToTouchExplorationState", "listenToSwitchAccessState", "Landroidx/compose/runtime/State;", "rememberAccessibilityServiceState", "(ZZLandroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Function1;", "Landroidx/lifecycle/Lifecycle$Event;", "LC7/r;", "handleEvent", "Lkotlin/Function0;", "onDispose", "ObserveState", "(Landroidx/lifecycle/LifecycleOwner;LS7/k;LS7/a;Landroidx/compose/runtime/Composer;II)V", "", "SwitchAccessActivityName", "Ljava/lang/String;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AccessibilityServiceStateProvider_androidKt {
    private static final String SwitchAccessActivityName = "SwitchAccess";

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void ObserveState(final LifecycleOwner lifecycleOwner, k kVar, S7.a aVar, Composer composer, final int i, final int i6) {
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1868327245);
        if ((i6 & 1) != 0) {
            i10 = i | 6;
        } else if ((i & 6) == 0) {
            i10 = (composerStartRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        int i11 = i6 & 2;
        if (i11 != 0) {
            i10 |= 48;
        } else if ((i & 48) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(kVar) ? 32 : 16;
        }
        int i12 = i6 & 4;
        if (i12 != 0) {
            i10 |= 384;
        } else if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(aVar) ? 256 : 128;
        }
        if ((i10 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i11 != 0) {
                kVar = new k() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt.ObserveState.1
                    public final void invoke(Lifecycle.Event event) {
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Lifecycle.Event) obj);
                        return r.f317a;
                    }
                };
            }
            if (i12 != 0) {
                aVar = new S7.a() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt.ObserveState.2
                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2663invoke() {
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2663invoke();
                        return r.f317a;
                    }
                };
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1868327245, i10, -1, "androidx.compose.material3.internal.ObserveState (AccessibilityServiceStateProvider.android.kt:74)");
            }
            boolean zChangedInstance = ((i10 & 112) == 32) | composerStartRestartGroup.changedInstance(lifecycleOwner) | ((i10 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new AccessibilityServiceStateProvider_androidKt$ObserveState$3$1(lifecycleOwner, kVar, aVar);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.DisposableEffect(lifecycleOwner, (k) objRememberedValue, composerStartRestartGroup, i10 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final k kVar2 = kVar;
        final S7.a aVar2 = aVar;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt.ObserveState.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i13) {
                    AccessibilityServiceStateProvider_androidKt.ObserveState(lifecycleOwner, kVar2, aVar2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
                }
            });
        }
    }

    @Composable
    public static final State<Boolean> rememberAccessibilityServiceState(boolean z10, boolean z11, Composer composer, int i, int i6) {
        boolean z12 = true;
        if ((i6 & 1) != 0) {
            z10 = true;
        }
        if ((i6 & 2) != 0) {
            z11 = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1771705152, i, -1, "androidx.compose.material3.internal.rememberAccessibilityServiceState (AccessibilityServiceStateProvider.android.kt:46)");
        }
        Object systemService = ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getSystemService("accessibility");
        kotlin.jvm.internal.k.d(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        final AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        boolean z13 = (((i & 14) ^ 6) > 4 && composer.changed(z10)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(z11)) && (i & 48) != 32) {
            z12 = false;
        }
        boolean z14 = z13 | z12;
        Object objRememberedValue = composer.rememberedValue();
        if (z14 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Listener(z10, z11);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Listener listener = (Listener) objRememberedValue;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        boolean zChanged = composer.changed(listener) | composer.changedInstance(accessibilityManager);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new k() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$rememberAccessibilityServiceState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Lifecycle.Event) obj);
                    return r.f317a;
                }

                public final void invoke(Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_RESUME) {
                        listener.register(accessibilityManager);
                    }
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        k kVar = (k) objRememberedValue2;
        boolean zChanged2 = composer.changed(listener) | composer.changedInstance(accessibilityManager);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new S7.a() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$rememberAccessibilityServiceState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2664invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2664invoke() {
                    listener.unregister(accessibilityManager);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ObserveState(lifecycleOwner, kVar, (S7.a) objRememberedValue3, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return listener;
    }
}
