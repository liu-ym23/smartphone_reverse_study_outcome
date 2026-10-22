package m1;

import android.view.KeyEvent;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public KeyEvent f8187a;

    public final boolean equals(Object obj) {
        return (obj instanceof b) && k.a(this.f8187a, ((b) obj).f8187a);
    }

    public final int hashCode() {
        return this.f8187a.hashCode();
    }

    public final String toString() {
        return "KeyEvent(nativeKeyEvent=" + this.f8187a + ')';
    }
}
