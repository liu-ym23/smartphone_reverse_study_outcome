package androidx.compose.ui.precompose;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/precompose/LifecycleOwnerDelegate;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "()V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", NewBroadcastMonitor.STAGE.LIFECYCLE, "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "realLifecycleOwner", "realLifecycleReachStart", "", "bindRealLifecycleOwner", "", "lifecycleOwner", "onStateChanged", "source", "event", "Landroidx/lifecycle/Lifecycle$Event;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifecycleOwnerDelegate implements LifecycleOwner, LifecycleEventObserver {
    public static final int $stable = 8;
    private final LifecycleRegistry lifecycle;
    private final LifecycleRegistry lifecycleRegistry;
    private LifecycleOwner realLifecycleOwner;
    private boolean realLifecycleReachStart;

    public LifecycleOwnerDelegate() {
        LifecycleRegistry r100 = new LifecycleRegistry(this);
        this.lifecycleRegistry = r100;
        this.lifecycle = r100;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return getLifecycle();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public LifecycleRegistry getLifecycle() {
        return this.lifecycle;
    }

    public final void bindRealLifecycleOwner(LifecycleOwner r100) {
        if (this.lifecycleRegistry.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleOwner r101 = this.realLifecycleOwner;
        if (r101 == null) goto L10;
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L10;
        r102.removeObserver(this);
    L10:
        this.realLifecycleOwner = r100;
        this.realLifecycleReachStart = false;
        r100.getLifecycle().addObserver(this);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        if (this.lifecycleRegistry.getCurrentState() != Lifecycle.State.DESTROYED) goto L9;
        r100.getLifecycle().removeObserver(this);
        if (this.realLifecycleOwner != r100) goto L20;
        this.realLifecycleOwner = null;
        this.realLifecycleReachStart = false;
        return;
    L20:
        return;
    L9:
        if (this.realLifecycleReachStart == false) goto L12;
        this.lifecycleRegistry.handleLifecycleEvent(r101);
    L12:
        if (r101.getTargetState().isAtLeast(Lifecycle.State.STARTED) == false) goto L15;
        this.realLifecycleReachStart = true;
    L15:
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L21;
        r100.getLifecycle().removeObserver(this);
        if (this.realLifecycleOwner != r100) goto L22;
        this.realLifecycleOwner = null;
        this.realLifecycleReachStart = false;
        return;
    L22:
        return;
    }
}
