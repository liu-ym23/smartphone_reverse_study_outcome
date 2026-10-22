package b2;

import com.google.android.datatransport.Priority;

/* loaded from: classes2.dex */
public abstract class c<T> {
    public static <T> c<T> d(T t10) {
        return new C1446a(null, t10, Priority.DEFAULT);
    }

    public static <T> c<T> e(T t10) {
        return new C1446a(null, t10, Priority.VERY_LOW);
    }

    public abstract Integer a();

    public abstract T b();

    public abstract Priority c();
}
