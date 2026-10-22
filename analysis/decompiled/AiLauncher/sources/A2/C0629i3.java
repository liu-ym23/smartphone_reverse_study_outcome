package A2;

import java.util.Objects;

/* renamed from: A2.i3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0629i3 {
    public static void a(Object obj, Object obj2) {
        if (obj == null) {
            Objects.toString(obj2);
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }
}
