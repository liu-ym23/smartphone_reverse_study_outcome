package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Landroidx/window/layout/WindowInfoTracker;", "", "windowLayoutInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", "activity", "Landroid/app/Activity;", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WindowInfoTracker {
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: androidx.window.layout.WindowInfoTracker$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            Companion r100 = WindowInfoTracker.Companion;
        }

        @JvmStatic
        public static WindowInfoTracker getOrCreate(Context r100) {
            return WindowInfoTracker.Companion.getOrCreate(r100);
        }

        @JvmStatic
        public static void overrideDecorator(WindowInfoTrackerDecorator r100) {
            WindowInfoTracker.Companion.overrideDecorator(r100);
        }

        @JvmStatic
        public static void reset() {
            WindowInfoTracker.Companion.reset();
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0007J\b\u0010\u0017\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\t\u001a\u0004\u0018\u00010\n8@X\u0080\u0084\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Landroidx/window/layout/WindowInfoTracker$Companion;", "", "()V", "DEBUG", "", "TAG", "", "decorator", "Landroidx/window/layout/WindowInfoTrackerDecorator;", "extensionBackend", "Landroidx/window/layout/WindowBackend;", "getExtensionBackend$window_release$annotations", "getExtensionBackend$window_release", "()Landroidx/window/layout/WindowBackend;", "extensionBackend$delegate", "Lkotlin/Lazy;", "getOrCreate", "Landroidx/window/layout/WindowInfoTracker;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "overrideDecorator", "", "overridingDecorator", BasicTestActionHandler.TEST_ACTION_RESET, "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final boolean DEBUG = false;
        private static final String TAG = null;
        private static WindowInfoTrackerDecorator decorator;
        private static final Lazy<ExtensionWindowLayoutInfoBackend> extensionBackend$delegate = null;

        private Companion() {
        }

        public static /* synthetic */ void getExtensionBackend$window_release$annotations() {
        }

        static {
            $$INSTANCE = new Companion();
            TAG = Reflection.getOrCreateKotlinClass(WindowInfoTracker.class).getSimpleName();
            extensionBackend$delegate = LazyKt.lazy(WindowInfoTracker$Companion$extensionBackend$2.INSTANCE);
            decorator = EmptyDecorator.INSTANCE;
        }

        public final WindowBackend getExtensionBackend$window_release() {
            return extensionBackend$delegate.getValue();
        }

        @JvmStatic
        public final void reset() {
            decorator = EmptyDecorator.INSTANCE;
        }

        public static final /* synthetic */ boolean access$getDEBUG$p() {
            return DEBUG;
        }

        public static final /* synthetic */ String access$getTAG$p() {
            return TAG;
        }

        @JvmStatic
        public final WindowInfoTracker getOrCreate(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            WindowBackend r101 = getExtensionBackend$window_release();
            if (r101 != null) goto L5;
            r101 = SidecarWindowBackend.Companion.getInstance(r100);
        L5:
            WindowInfoTrackerImpl r102 = new WindowInfoTrackerImpl(WindowMetricsCalculatorCompat.INSTANCE, r101);
            return decorator.decorate(r102);
        }

        @JvmStatic
        public final void overrideDecorator(WindowInfoTrackerDecorator r100) {
            Intrinsics.checkNotNullParameter(r100, "overridingDecorator");
            decorator = r100;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Flow<WindowLayoutInfo> windowLayoutInfo(Activity r100);
}
