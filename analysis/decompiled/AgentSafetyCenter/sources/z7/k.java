package z7;

import androidx.room.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k implements d {
    @Override // z7.d
    public final String a() {
        return "format.regex";
    }

    @Override // z7.d
    public final boolean b(w7.f fVar, q qVar, String str) {
        if (str == null) {
            return true;
        }
        try {
            d8.c.a(str, qVar);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    @Override // z7.d
    public final String getName() {
        return "regex";
    }
}
