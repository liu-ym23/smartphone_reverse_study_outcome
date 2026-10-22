package c6;

import android.graphics.Bitmap;
import java.util.Map;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f2209a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f2210b;

    public b(Bitmap bitmap, Map map) {
        this.f2209a = bitmap;
        this.f2210b = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2209a.equals(bVar.f2209a) && k.a(this.f2210b, bVar.f2210b);
    }

    public final int hashCode() {
        return this.f2210b.hashCode() + (this.f2209a.hashCode() * 31);
    }

    public final String toString() {
        return "Value(bitmap=" + this.f2209a + ", extras=" + this.f2210b + ')';
    }
}
