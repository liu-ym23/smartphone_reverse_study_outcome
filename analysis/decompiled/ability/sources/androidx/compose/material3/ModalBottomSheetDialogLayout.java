package androidx.compose.material3;

import C7.r;
import S7.n;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.window.DialogWindowProvider;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u000256BI\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0015J(\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001f\u0010\u0015J\u000f\u0010 \u001a\u00020\nH\u0014¢\u0006\u0004\b \u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010'R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010(R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010)RA\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u00192\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u00198B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b\u001b\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R$\u00103\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00078\u0014@RX\u0094\u000e¢\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u0010&¨\u00067"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetDialogLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/window/DialogWindowProvider;", "Landroid/content/Context;", "context", "Landroid/view/Window;", "window", "", "shouldDismissOnBackPress", "Lkotlin/Function0;", "LC7/r;", "onDismissRequest", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "predictiveBackProgress", "Lm9/z;", "scope", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/view/Window;ZLS7/a;Landroidx/compose/animation/core/Animatable;Lm9/z;)V", "maybeRegisterBackCallback", "()V", "maybeUnregisterBackCallback", "Landroidx/compose/runtime/CompositionContext;", "parent", "Landroidx/compose/runtime/Composable;", "content", "setContent", "(Landroidx/compose/runtime/CompositionContext;LS7/n;)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/view/Window;", "getWindow", "()Landroid/view/Window;", "Z", "getShouldDismissOnBackPress", "()Z", "LS7/a;", "Landroidx/compose/animation/core/Animatable;", "Lm9/z;", "<set-?>", "content$delegate", "Landroidx/compose/runtime/MutableState;", "getContent", "()LS7/n;", "(LS7/n;)V", "", "backCallback", "Ljava/lang/Object;", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "Api33Impl", "Api34Impl", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ModalBottomSheetDialogLayout extends AbstractComposeView implements DialogWindowProvider {
    private Object backCallback;

    /* renamed from: content$delegate, reason: from kotlin metadata */
    private final MutableState content;
    private final S7.a onDismissRequest;
    private final Animatable<Float, AnimationVector1D> predictiveBackProgress;
    private final InterfaceC1733z scope;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private final boolean shouldDismissOnBackPress;
    private final Window window;

    @RequiresApi(33)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetDialogLayout$Api33Impl;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function0;", "LC7/r;", "onDismissRequest", "Landroid/window/OnBackInvokedCallback;", "createBackCallback", "(LS7/a;)Landroid/window/OnBackInvokedCallback;", "Landroid/view/View;", "view", "backCallback", "maybeRegisterBackCallback", "(Landroid/view/View;Ljava/lang/Object;)V", "maybeUnregisterBackCallback", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        @DoNotInline
        public static final OnBackInvokedCallback createBackCallback(final S7.a onDismissRequest) {
            return new OnBackInvokedCallback() { // from class: androidx.compose.material3.c
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    onDismissRequest.invoke();
                }
            };
        }

        @DoNotInline
        public static final void maybeRegisterBackCallback(View view, Object backCallback) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (!(backCallback instanceof OnBackInvokedCallback) || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) backCallback);
        }

        @DoNotInline
        public static final void maybeUnregisterBackCallback(View view, Object backCallback) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (!(backCallback instanceof OnBackInvokedCallback) || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback((OnBackInvokedCallback) backCallback);
        }
    }

    @RequiresApi(34)
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000e\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetDialogLayout$Api34Impl;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function0;", "LC7/r;", "onDismissRequest", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "predictiveBackProgress", "Lm9/z;", "scope", "Landroid/window/OnBackAnimationCallback;", "createBackCallback", "(LS7/a;Landroidx/compose/animation/core/Animatable;Lm9/z;)Landroid/window/OnBackAnimationCallback;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @DoNotInline
        public static final OnBackAnimationCallback createBackCallback(final S7.a onDismissRequest, final Animatable<Float, AnimationVector1D> predictiveBackProgress, final InterfaceC1733z scope) {
            return new OnBackAnimationCallback() { // from class: androidx.compose.material3.ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1
                public void onBackCancelled() {
                    AbstractC1683A.n(scope, null, new ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackCancelled$1(predictiveBackProgress, null), 3);
                }

                @Override // android.window.OnBackInvokedCallback
                public void onBackInvoked() {
                    onDismissRequest.invoke();
                }

                public void onBackProgressed(BackEvent backEvent) {
                    AbstractC1683A.n(scope, null, new ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackProgressed$1(predictiveBackProgress, backEvent, null), 3);
                }

                public void onBackStarted(BackEvent backEvent) {
                    AbstractC1683A.n(scope, null, new ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackStarted$1(predictiveBackProgress, backEvent, null), 3);
                }
            };
        }
    }

    public ModalBottomSheetDialogLayout(Context context, Window window, boolean z10, S7.a aVar, Animatable<Float, AnimationVector1D> animatable, InterfaceC1733z interfaceC1733z) {
        super(context, null, 0, 6, null);
        this.window = window;
        this.shouldDismissOnBackPress = z10;
        this.onDismissRequest = aVar;
        this.predictiveBackProgress = animatable;
        this.scope = interfaceC1733z;
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1718getLambda2$material3_release(), null, 2, null);
    }

    private final n getContent() {
        return (n) this.content.getValue();
    }

    private final void maybeRegisterBackCallback() {
        if (this.shouldDismissOnBackPress) {
            int i = Build.VERSION.SDK_INT;
            if (this.backCallback == null) {
                this.backCallback = i >= 34 ? Api34Impl.createBackCallback(this.onDismissRequest, this.predictiveBackProgress, this.scope) : Api33Impl.createBackCallback(this.onDismissRequest);
            }
            Api33Impl.maybeRegisterBackCallback(this, this.backCallback);
        }
    }

    private final void maybeUnregisterBackCallback() {
        Api33Impl.maybeUnregisterBackCallback(this, this.backCallback);
        this.backCallback = null;
    }

    private final void setContent(n nVar) {
        this.content.setValue(nVar);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    @Composable
    public void Content(Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(576708319);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i6 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(576708319, i6, -1, "androidx.compose.material3.ModalBottomSheetDialogLayout.Content (ModalBottomSheet.android.kt:352)");
            }
            getContent().invoke(composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.ModalBottomSheetDialogLayout.Content.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    ModalBottomSheetDialogLayout.this.Content(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    @Override // androidx.compose.ui.window.DialogWindowProvider
    public Window getWindow() {
        return this.window;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeRegisterBackCallback();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        maybeUnregisterBackCallback();
    }

    public final void setContent(CompositionContext parent, n content) {
        setParentCompositionContext(parent);
        setContent(content);
        this.shouldCreateCompositionOnAttachedToWindow = true;
        createComposition();
    }
}
