package androidx.window.layout;

import android.graphics.Rect;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.window.core.b f5329a;

    public j(androidx.window.core.b r10) {
        q.g(r10, "_bounds");
        this.f5329a = r10;
    }

    public final Rect a() {
        return this.f5329a.f();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        return false;
    L7:
        if (q.b(j.class, r10.getClass()) == true) goto L10;
        return false;
    L10:
        return q.b(this.f5329a, ((j) r10).f5329a);
    }

    public int hashCode() {
        return this.f5329a.hashCode();
    }

    public String toString() {
        return "WindowMetrics { bounds: " + a() + " }";
    }

    public j(Rect r10) {
        q.g(r10, "bounds");
        this(new androidx.window.core.b(r10));
    }
}
