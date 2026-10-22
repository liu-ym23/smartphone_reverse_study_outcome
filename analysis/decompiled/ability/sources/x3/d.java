package x3;

/* loaded from: classes3.dex */
public interface d {
    String a();

    default boolean b(u3.f fVar, G6.c cVar, String str) {
        return matches(str);
    }

    String getName();

    default boolean matches(String str) {
        return true;
    }
}
