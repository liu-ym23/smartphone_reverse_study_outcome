package jb;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public Throwable f6761c;

    public final boolean equals(Object obj) {
        return (obj instanceof h) && yb.k.a(this.f6761c, ((h) obj).f6761c);
    }

    public final int hashCode() {
        return this.f6761c.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f6761c + ')';
    }
}
