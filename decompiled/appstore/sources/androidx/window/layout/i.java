package androidx.window.layout;

import java.util.List;
import kotlin.collections.b0;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f5328a;

    public i(List r10) {
        q.g(r10, "displayFeatures");
        this.f5328a = r10;
    }

    public final List a() {
        return this.f5328a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        return false;
    L7:
        if (q.b(i.class, r10.getClass()) == true) goto L10;
        return false;
    L10:
        return q.b(this.f5328a, ((i) r10).f5328a);
    }

    public int hashCode() {
        return this.f5328a.hashCode();
    }

    public String toString() {
        return b0.h0(this.f5328a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
