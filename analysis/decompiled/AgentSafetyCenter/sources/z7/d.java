package z7;

import androidx.room.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface d {
    String a();

    default boolean b(w7.f fVar, q qVar, String str) {
        return matches(str);
    }

    String getName();

    default boolean matches(String str) {
        return true;
    }
}
