package androidx.window.layout;

import android.app.Activity;
import androidx.annotation.RestrictTo;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculator;", "", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/j;", "computeCurrentWindowMetrics", "(Landroid/app/Activity;)Landroidx/window/layout/j;", "computeMaximumWindowMetrics", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WindowMetricsCalculator {

    @NotNull
    public static final Companion Companion = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f5294a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Function1 f5295b;

        static {
            f5294a = new Companion();
            f5295b = WindowMetricsCalculator$Companion$decorator$1.INSTANCE;
        }

        public Companion() {
        }

        public final WindowMetricsCalculator a() {
            return (WindowMetricsCalculator) f5295b.invoke(k.f5330a);
        }

        public final void b(WindowMetricsCalculatorDecorator r10) {
            q.g(r10, "overridingDecorator");
            f5295b = new WindowMetricsCalculator$Companion$overrideDecorator$1(r10);
        }

        public final void c() {
            f5295b = WindowMetricsCalculator$Companion$reset$1.INSTANCE;
        }
    }

    static {
        Companion = Companion.f5294a;
    }

    @JvmStatic
    @NotNull
    static WindowMetricsCalculator getOrCreate() {
        return Companion.a();
    }

    @JvmStatic
    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    static void overrideDecorator(@NotNull WindowMetricsCalculatorDecorator r10) {
        Companion.b(r10);
    }

    @JvmStatic
    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    static void reset() {
        Companion.c();
    }

    @NotNull
    j computeCurrentWindowMetrics(@NotNull Activity r10);

    @NotNull
    j computeMaximumWindowMetrics(@NotNull Activity r10);
}
