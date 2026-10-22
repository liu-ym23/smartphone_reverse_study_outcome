package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \b2\u00020\u0001:\u0001\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/window/layout/WindowInfoTracker;", "", "Landroid/app/Activity;", "activity", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/i;", "windowLayoutInfo", "(Landroid/app/Activity;)Lkotlinx/coroutines/flow/Flow;", "Companion", "a", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WindowInfoTracker {

    @NotNull
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f5287a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final boolean f5288b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f5289c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static WindowInfoTrackerDecorator f5290d;

        static {
            f5287a = new a();
            f5289c = u.b(WindowInfoTracker.class).getSimpleName();
            f5290d = b.f5297a;
        }

        public a() {
        }

        public final WindowInfoTracker a(Context r10) {
            q.g(r10, "context");
            WindowInfoTrackerImpl r11 = new WindowInfoTrackerImpl(k.f5330a, d(r10));
            return f5290d.decorate(r11);
        }

        public final void b(WindowInfoTrackerDecorator r10) {
            q.g(r10, "overridingDecorator");
            f5290d = r10;
        }

        public final void c() {
            f5290d = b.f5297a;
        }

        public final WindowBackend d(Context r10) {
            q.g(r10, "context");
            c r11 = null;
            WindowLayoutComponent r12 = SafeWindowLayoutComponentProvider.f5263a.m();     // Catch: Throwable -> L8
            if (r12 == null) goto L11;
            r11 = new c(r12);     // Catch: Throwable -> L8
        L11:
            if (r11 == null) goto L13;
            return r11;
        L13:
            return f.f5315c.a(r10);
        L9:
            if (f5288b == false) goto L11;
            Log.d(f5289c, "Failed to load WindowExtensions");
            goto L11
        }
    }

    static {
        Companion = a.f5287a;
    }

    @JvmStatic
    @JvmName(name = "getOrCreate")
    @NotNull
    static WindowInfoTracker getOrCreate(@NotNull Context r10) {
        return Companion.a(r10);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static void overrideDecorator(@NotNull WindowInfoTrackerDecorator r10) {
        Companion.b(r10);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static void reset() {
        Companion.c();
    }

    @NotNull
    Flow<i> windowLayoutInfo(@NotNull Activity r10);
}
