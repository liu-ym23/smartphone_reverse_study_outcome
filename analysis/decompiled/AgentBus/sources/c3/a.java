package c3;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import s9.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final d f1891a = new d(10);

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f1892b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f1893c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f1894d;

    public static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                a1.a.s(autoCloseable);
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }
}
