package P1;

import android.app.Application;
import java.util.Objects;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Application f4544a;

    public static Application a() {
        Application application = f4544a;
        Objects.requireNonNull(application, "application is not init");
        return application;
    }

    public static String b(int i5, Object... objArr) {
        return objArr == null ? a().getString(i5) : a().getString(i5, objArr);
    }

    public static void c(Application application) {
        Objects.requireNonNull(application, "application is null");
        f4544a = application;
    }
}
