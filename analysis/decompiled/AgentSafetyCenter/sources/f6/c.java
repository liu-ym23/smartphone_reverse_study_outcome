package f6;

import android.content.Context;
import android.util.DisplayMetrics;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements h {

    /* renamed from: c, reason: collision with root package name */
    public Context f3918c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && k.a(this.f3918c, ((c) obj).f3918c);
    }

    @Override // f6.h
    public final Object g(t5.f fVar) {
        DisplayMetrics displayMetrics = this.f3918c.getResources().getDisplayMetrics();
        a aVarA = id.k.a(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new g(aVarA, aVarA);
    }

    public final int hashCode() {
        return this.f3918c.hashCode();
    }
}
