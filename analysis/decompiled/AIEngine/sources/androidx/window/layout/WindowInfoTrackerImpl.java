package androidx.window.layout;

import android.app.Activity;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WindowInfoTrackerImpl implements l {

    /* renamed from: b, reason: collision with root package name */
    public final k f2715b;

    public WindowInfoTrackerImpl(n windowMetricsCalculator, k kVar) {
        kotlin.jvm.internal.g.f(windowMetricsCalculator, "windowMetricsCalculator");
        this.f2715b = kVar;
    }

    public final Flow<m> a(Activity activity) {
        return FlowKt.flow(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, activity, null));
    }
}
