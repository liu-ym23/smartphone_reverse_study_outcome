package androidx.lifecycle;

import com.byted.cast.common.TeaEventTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¨\u0006\u0007"}, d2 = {"checkLifecycleStateTransition", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "current", "Landroidx/lifecycle/Lifecycle$State;", TeaEventTrack.ACTION_DRAMA_NEXT, "lifecycle-runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LifecycleRegistryKt {
    public static final void checkLifecycleStateTransition(LifecycleOwner r100, Lifecycle.State r101, Lifecycle.State r102) {
        androidx_lifecycle_LifecycleRegistryKt_com_larus_home_impl_utils_LifecycleRegistryLancet_checkLifecycleStateTransition(r100, r101, r102);
    }

    public static final void androidx_lifecycle_LifecycleRegistryKt__checkLifecycleStateTransition$___twin___(LifecycleOwner r100, Lifecycle.State r101, Lifecycle.State r102) {
        Intrinsics.checkNotNullParameter(r101, "current");
        Intrinsics.checkNotNullParameter(r102, TeaEventTrack.ACTION_DRAMA_NEXT);
        if (r101 == Lifecycle.State.INITIALIZED) goto L5;
    L9:
        Lifecycle.State r103 = Lifecycle.State.DESTROYED;
        if (r101 != r103) goto L15;
        if (r101 != r102) goto L14;
        return;
    L14:
        throw new IllegalStateException(("State is '" + r103 + "' and cannot be moved to `" + r102 + "` in component " + r100).toString());
    L15:
        return;
    L5:
        if (r102 != Lifecycle.State.DESTROYED) goto L9;
        throw new IllegalStateException(("State must be at least '" + Lifecycle.State.CREATED + "' to be moved to '" + r102 + "' in component " + r100).toString());
    }

    public static void androidx_lifecycle_LifecycleRegistryKt_com_larus_home_impl_utils_LifecycleRegistryLancet_checkLifecycleStateTransition(LifecycleOwner r100, Lifecycle.State r101, Lifecycle.State r102) {
        if (r101 == Lifecycle.State.INITIALIZED) goto L5;
        return;
    L5:
        if (r102 == Lifecycle.State.DESTROYED) goto L8;
        return;
    L8:
        throw new IllegalStateException("State must be at least 'CREATED' to be moved to " + r102 + " in component " + r100);
    }
}
