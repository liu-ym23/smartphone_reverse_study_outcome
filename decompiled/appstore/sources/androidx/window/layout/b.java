package androidx.window.layout;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class b implements WindowInfoTrackerDecorator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5297a = null;

    static {
        f5297a = new b();
    }

    public b() {
    }

    @Override // androidx.window.layout.WindowInfoTrackerDecorator
    public WindowInfoTracker decorate(WindowInfoTracker r10) {
        q.g(r10, "tracker");
        return r10;
    }
}
