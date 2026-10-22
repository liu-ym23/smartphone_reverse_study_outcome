package ae;

import android.graphics.Rect;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f99a;

    public c(b r10) {
        q.g(r10, "_bounds");
        this.f99a = r10;
    }

    public final Rect a() {
        return this.f99a.a();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        return false;
    L7:
        if (q.b(c.class, r10.getClass()) == true) goto L10;
        return false;
    L10:
        return q.b(this.f99a, ((c) r10).f99a);
    }

    public int hashCode() {
        return this.f99a.hashCode();
    }

    public String toString() {
        return "WindowMetrics { bounds: " + a() + " }";
    }

    public c(Rect r10) {
        q.g(r10, "bounds");
        this(new b(r10));
    }
}
