package androidx.lifecycle;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", WidgetCostModule.TYPE_ON_CREATE, "", "owner", "Landroidx/lifecycle/LifecycleOwner;", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DefaultLifecycleObserver extends LifecycleObserver {

    /* JADX INFO: renamed from: androidx.lifecycle.DefaultLifecycleObserver$-CC, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    public final /* synthetic */ class CC {
        public static void $default$onCreate(DefaultLifecycleObserver r100, LifecycleOwner r101) {
            Intrinsics.checkNotNullParameter(r101, "owner");
        }

        public static void $default$onDestroy(DefaultLifecycleObserver r100, LifecycleOwner r101) {
            Intrinsics.checkNotNullParameter(r101, "owner");
        }

        public static void $default$onPause(DefaultLifecycleObserver r100, LifecycleOwner r101) {
            Intrinsics.checkNotNullParameter(r101, "owner");
        }

        public static void $default$onResume(DefaultLifecycleObserver r100, LifecycleOwner r101) {
            Intrinsics.checkNotNullParameter(r101, "owner");
        }

        public static void $default$onStart(DefaultLifecycleObserver r100, LifecycleOwner r101) {
            Intrinsics.checkNotNullParameter(r101, "owner");
        }

        public static void $default$onStop(DefaultLifecycleObserver r100, LifecycleOwner r101) {
            Intrinsics.checkNotNullParameter(r101, "owner");
        }
    }

    void onCreate(LifecycleOwner r100);

    void onDestroy(LifecycleOwner r100);

    void onPause(LifecycleOwner r100);

    void onResume(LifecycleOwner r100);

    void onStart(LifecycleOwner r100);

    void onStop(LifecycleOwner r100);
}
