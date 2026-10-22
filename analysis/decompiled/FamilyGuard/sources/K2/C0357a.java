package K2;

import android.graphics.drawable.Drawable;
import com.stepos.minor.Minor;
import java.util.Arrays;

/* renamed from: K2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0357a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0357a f3616a = new C0357a();

    /* renamed from: b, reason: collision with root package name */
    public static final Class<?> f3617b;

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?> f3618c;

    /* renamed from: d, reason: collision with root package name */
    public static final Class<?> f3619d;

    static {
        L2.e eVar = L2.e.f3817a;
        f3617b = eVar.l();
        f3618c = eVar.k();
        f3619d = eVar.j();
    }

    private C0357a() {
    }

    public static final void a(Drawable drawable, String str, Class<?>[] clsArr, Object... objArr) {
        j4.k.g(drawable, "glass");
        j4.k.g(str, Minor.COLUMN_NAME);
        j4.k.g(clsArr, "types");
        j4.k.g(objArr, "args");
        L2.e.f3817a.g(drawable, str, clsArr, Arrays.copyOf(objArr, objArr.length));
    }

    public static final boolean b() {
        return L2.e.f3817a.n();
    }

    public static final void c(Drawable drawable, int i5) {
        j4.k.g(drawable, "glass");
        a(drawable, "setBlurRadius", new Class[]{f3617b}, Integer.valueOf(i5));
    }

    public static final void d(Drawable drawable, int i5) {
        j4.k.g(drawable, "glass");
        a(drawable, "setColor", new Class[]{f3617b}, Integer.valueOf(i5));
    }

    public static final void e(Drawable drawable, float f5) {
        j4.k.g(drawable, "glass");
        a(drawable, "setCornerRadius", new Class[]{f3618c}, Float.valueOf(f5));
    }
}
