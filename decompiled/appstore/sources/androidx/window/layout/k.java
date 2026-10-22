package androidx.window.layout;

import android.app.Activity;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class k implements WindowMetricsCalculator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f5330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5331b = null;

    static {
        f5330a = new k();
        String r10 = k.class.getSimpleName();
        q.f(r10, "WindowMetricsCalculatorC…at::class.java.simpleName");
        f5331b = r10;
    }

    public k() {
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public j computeCurrentWindowMetrics(Activity r10) {
        q.g(r10, "activity");
        return new j(a.f5296a.a(r10));
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public j computeMaximumWindowMetrics(Activity r10) {
        q.g(r10, "activity");
        return new j(a.f5296a.b(r10));
    }
}
