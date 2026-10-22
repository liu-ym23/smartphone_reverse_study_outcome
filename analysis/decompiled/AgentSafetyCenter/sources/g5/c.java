package g5;

import android.net.Uri;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public Uri f4282a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4283b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!c.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        c cVar = (c) obj;
        return yb.k.a(this.f4282a, cVar.f4282a) && this.f4283b == cVar.f4283b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f4283b) + (this.f4282a.hashCode() * 31);
    }
}
