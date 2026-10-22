package P;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.x;

/* loaded from: classes.dex */
public interface m<T> extends x {

    /* renamed from: b, reason: collision with root package name */
    public static final Config.a<String> f5353b = Config.a.a("camerax.core.target.name", String.class);

    /* renamed from: c, reason: collision with root package name */
    public static final Config.a<Class<?>> f5354c = Config.a.a("camerax.core.target.class", Class.class);

    default String Z() {
        return (String) a(f5353b);
    }

    default String w(String str) {
        return (String) g(f5353b, str);
    }
}
