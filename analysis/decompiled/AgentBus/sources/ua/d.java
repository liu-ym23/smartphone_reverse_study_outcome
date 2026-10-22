package ua;

import d7.z;
import java.util.List;
import n7.o;

/* loaded from: classes.dex */
public interface d {
    int a(String str);

    String b();

    int c();

    String d(int i2);

    default boolean e() {
        return false;
    }

    default boolean g() {
        return false;
    }

    default List getAnnotations() {
        return z.f2978f;
    }

    o getKind();

    List h(int i2);

    d i(int i2);

    boolean j(int i2);
}
