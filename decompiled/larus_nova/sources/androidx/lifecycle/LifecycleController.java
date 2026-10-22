package androidx.lifecycle;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0082\bJ\b\u0010\u0010\u001a\u00020\u000fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/lifecycle/LifecycleController;", "", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "minState", "Landroidx/lifecycle/Lifecycle$State;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "parentJob", "Lkotlinx/coroutines/Job;", "<init>", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "handleDestroy", "", VideoEventOneOutSync.END_TYPE_FINISH, "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public static /* synthetic */ void a(LifecycleController r100, Job r101, LifecycleOwner r102, Lifecycle.Event r103) {
        observer$lambda$0(r100, r101, r102, r103);
    }

    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }

    private final void handleDestroy(Job r100) {
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
        finish();
    }

    public LifecycleController(Lifecycle r100, Lifecycle.State r101, DispatchQueue r102, final Job r103) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r101, "minState");
        Intrinsics.checkNotNullParameter(r102, "dispatchQueue");
        Intrinsics.checkNotNullParameter(r103, "parentJob");
        this.lifecycle = r100;
        this.minState = r101;
        this.dispatchQueue = r102;
        LifecycleEventObserver r104 = new h(this, r103);
        this.observer = r104;
        if (r100.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
        finish();
        return;
    L5:
        r100.addObserver(r104);
    }

    private static final void observer$lambda$0(LifecycleController r100, Job r101, LifecycleOwner r102, Lifecycle.Event r103) {
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r103, "<unused var>");
        if (r102.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        r100.finish();
        return;
    L6:
        if (r102.getLifecycle().getCurrentState().compareTo(r100.minState) >= 0) goto L8;
        r100.dispatchQueue.pause();
        return;
    L8:
        r100.dispatchQueue.resume();
    }
}
