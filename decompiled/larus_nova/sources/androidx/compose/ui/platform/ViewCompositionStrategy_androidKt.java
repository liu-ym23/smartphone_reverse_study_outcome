package androidx.compose.ui.platform;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"installForLifecycle", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ViewCompositionStrategy_androidKt {
    public static /* synthetic */ void a(AbstractComposeView r100, LifecycleOwner r101, Lifecycle.Event r102) {
        installForLifecycle$lambda$1(r100, r101, r102);
    }

    public static final /* synthetic */ Function0 access$installForLifecycle(AbstractComposeView r100, Lifecycle r101) {
        return installForLifecycle(r100, r101);
    }

    private static final Function0<Unit> installForLifecycle(final AbstractComposeView r100, final Lifecycle r101) {
        if (r101.getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        final LifecycleEventObserver r103 = new r(r100);
        r101.addObserver(r103);
        return new AnonymousClass2(r101, r103);
    L10:
        throw new IllegalStateException(("Cannot configure " + r100 + " to disposeComposition at Lifecycle ON_DESTROY: " + r101 + "is already destroyed").toString());
    L5:
        r102 = false;
        goto L6
    }

    private static final void installForLifecycle$lambda$1(AbstractComposeView r100, LifecycleOwner r101, Lifecycle.Event r102) {
        if (r102 != Lifecycle.Event.ON_DESTROY) goto L6;
        r100.disposeComposition();
        return;
    }
}
