package h2;

import s.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f5281b = 0;

    /* renamed from: a, reason: collision with root package name */
    public j2.b f5282a;

    static {
        j2.b bVar = j2.b.f6544g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && k.a(this.f5282a, ((b) obj).f5282a);
    }

    public final int hashCode() {
        return this.f5282a.f6545c.hashCode() + f.b(1, f.b(1, k0.a.h(f.b(0, Boolean.hashCode(false) * 31, 31), 31, true), 31), 961);
    }

    public final String toString() {
        return "ImeOptions(singleLine=false, capitalization=" + ((Object) "None") + ", autoCorrect=true, keyboardType=" + ((Object) "Text") + ", imeAction=Default, platformImeOptions=null, hintLocales=" + this.f5282a + ')';
    }
}
