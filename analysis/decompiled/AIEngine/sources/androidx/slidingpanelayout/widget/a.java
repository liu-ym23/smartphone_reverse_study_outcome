package androidx.slidingpanelayout.widget;

import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import androidx.window.layout.WindowInfoTrackerImpl;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.Job;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final WindowInfoTrackerImpl f2624a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f2625b;

    /* renamed from: c, reason: collision with root package name */
    public Job f2626c;

    /* renamed from: d, reason: collision with root package name */
    public SlidingPaneLayout.a f2627d;

    public a(WindowInfoTrackerImpl windowInfoTrackerImpl, Executor executor) {
        g.f(executor, "executor");
        this.f2624a = windowInfoTrackerImpl;
        this.f2625b = executor;
    }
}
