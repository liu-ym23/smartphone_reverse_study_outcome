package android.view.compose;

import S7.n;
import android.R;
import android.view.C0764ViewTreeLifecycleOwner;
import android.view.C0765ViewTreeViewModelStoreOwner;
import android.view.C0812ViewTreeSavedStateRegistryOwner;
import android.view.ComponentActivity;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.ComposeView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/activity/ComponentActivity;", "Landroidx/compose/runtime/CompositionContext;", "parent", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "setContent", "(Landroidx/activity/ComponentActivity;Landroidx/compose/runtime/CompositionContext;LS7/n;)V", "setOwners", "(Landroidx/activity/ComponentActivity;)V", "Landroid/view/ViewGroup$LayoutParams;", "DefaultActivityContentLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "activity-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComponentActivityKt {
    private static final ViewGroup.LayoutParams DefaultActivityContentLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void setContent(ComponentActivity componentActivity, CompositionContext compositionContext, n nVar) {
        View childAt = ((ViewGroup) componentActivity.getWindow().getDecorView().findViewById(R.id.content)).getChildAt(0);
        ComposeView composeView = childAt instanceof ComposeView ? (ComposeView) childAt : null;
        if (composeView != null) {
            composeView.setParentCompositionContext(compositionContext);
            composeView.setContent(nVar);
            return;
        }
        ComposeView composeView2 = new ComposeView(componentActivity, null, 0, 6, null);
        composeView2.setParentCompositionContext(compositionContext);
        composeView2.setContent(nVar);
        setOwners(componentActivity);
        componentActivity.setContentView(composeView2, DefaultActivityContentLayoutParams);
    }

    public static /* synthetic */ void setContent$default(ComponentActivity componentActivity, CompositionContext compositionContext, n nVar, int i, Object obj) {
        if ((i & 1) != 0) {
            compositionContext = null;
        }
        setContent(componentActivity, compositionContext, nVar);
    }

    private static final void setOwners(ComponentActivity componentActivity) {
        View decorView = componentActivity.getWindow().getDecorView();
        if (C0764ViewTreeLifecycleOwner.get(decorView) == null) {
            C0764ViewTreeLifecycleOwner.set(decorView, componentActivity);
        }
        if (C0765ViewTreeViewModelStoreOwner.get(decorView) == null) {
            C0765ViewTreeViewModelStoreOwner.set(decorView, componentActivity);
        }
        if (C0812ViewTreeSavedStateRegistryOwner.get(decorView) == null) {
            C0812ViewTreeSavedStateRegistryOwner.set(decorView, componentActivity);
        }
    }
}
