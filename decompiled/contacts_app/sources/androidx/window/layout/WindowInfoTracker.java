package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: WindowInfoTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Landroidx/window/layout/WindowInfoTracker;", "", "windowLayoutInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", "activity", "Landroid/app/Activity;", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WindowInfoTracker {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: WindowInfoTracker.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0007J\b\u0010\u0010\u001a\u00020\u000eH\u0007J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/window/layout/WindowInfoTracker$Companion;", "", "()V", "DEBUG", "", "TAG", "", "decorator", "Landroidx/window/layout/WindowInfoTrackerDecorator;", "getOrCreate", "Landroidx/window/layout/WindowInfoTracker;", "context", "Landroid/content/Context;", "overrideDecorator", "", "overridingDecorator", "reset", "windowBackend", "Landroidx/window/layout/WindowBackend;", "windowBackend$window_release", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final boolean DEBUG = false;
        private static final String TAG = null;
        private static WindowInfoTrackerDecorator decorator;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            TAG = Reflection.getOrCreateKotlinClass(WindowInfoTracker.class).getSimpleName();
            decorator = EmptyDecorator.INSTANCE;
        }

        @JvmStatic
        public final WindowInfoTracker getOrCreate(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            WindowInfoTrackerImpl r0 = new WindowInfoTrackerImpl(WindowMetricsCalculatorCompat.INSTANCE, windowBackend$window_release(r3));
            return decorator.decorate(r0);
        }

        public final WindowBackend windowBackend$window_release(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            WindowBackend r2 = null;
            WindowLayoutComponent r0 = SafeWindowLayoutComponentProvider.INSTANCE.getWindowLayoutComponent();     // Catch: Throwable -> L8
            if (r0 == null) goto L12;
            r2 = new ExtensionWindowLayoutInfoBackend(r0);     // Catch: Throwable -> L8
        L12:
            if (r2 != null) goto L15;
            r2 = SidecarWindowBackend.Companion.getInstance(r3);
        L15:
            return r2;
        L9:
            if (DEBUG == false) goto L11;
            Log.d(TAG, "Failed to load WindowExtensions");
        L11:
            ExtensionWindowLayoutInfoBackend r1 = (ExtensionWindowLayoutInfoBackend) null;
            goto L12
        }

        @JvmStatic
        public final void overrideDecorator(WindowInfoTrackerDecorator r1) {
            Intrinsics.checkNotNullParameter(r1, "overridingDecorator");
            decorator = r1;
        }

        @JvmStatic
        public final void reset() {
            decorator = EmptyDecorator.INSTANCE;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @JvmStatic
    static WindowInfoTracker getOrCreate(Context r1) {
        return Companion.getOrCreate(r1);
    }

    @JvmStatic
    static void overrideDecorator(WindowInfoTrackerDecorator r1) {
        Companion.overrideDecorator(r1);
    }

    @JvmStatic
    static void reset() {
        Companion.reset();
    }

    Flow<WindowLayoutInfo> windowLayoutInfo(Activity r1);
}
