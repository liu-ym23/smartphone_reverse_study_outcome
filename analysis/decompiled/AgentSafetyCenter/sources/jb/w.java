package jb;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w implements d, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public xb.a f6775c;

    /* renamed from: f, reason: collision with root package name */
    public Object f6776f;

    @Override // jb.d
    public final Object getValue() {
        if (this.f6776f == s.f6773a) {
            xb.a aVar = this.f6775c;
            aVar.getClass();
            this.f6776f = aVar.invoke();
            this.f6775c = null;
        }
        return this.f6776f;
    }

    public final String toString() {
        return this.f6776f != s.f6773a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
