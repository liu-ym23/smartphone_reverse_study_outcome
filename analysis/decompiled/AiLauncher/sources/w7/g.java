package w7;

import Z8.r;
import android.graphics.drawable.Drawable;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import s7.m;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ-\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J=\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ9\u0010 \u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001d\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b \u0010!R\u001a\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010*\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010-\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u001d\u00100\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u0010)R\u001d\u00102\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010'\u001a\u0004\b1\u0010)R\u001d\u00104\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b3\u0010)R\u0016\u00106\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00105R\u0011\u00109\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lw7/g;", "", "<init>", "()V", "Landroid/graphics/drawable/Drawable;", "drawable", "", "name", "", UxipConstants.f30680s, "LY8/t;", "r", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;F)V", "v", "v1", "v2", "s", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;FF)V", "v3", "t", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;FFF)V", AMapLocationStaticsEntity.IPV4, "u", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;FFFF)V", "", "w", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;I)V", "Ljava/lang/reflect/Method;", "method", "", "args", "", "k", "(Ljava/lang/reflect/Method;Landroid/graphics/drawable/Drawable;[Ljava/lang/Object;)Z", "Ljava/lang/Class;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Class;", "clazz", "c", "LY8/h;", "f", "()Ljava/lang/reflect/Method;", "methodSetFloat", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_COMMAND, "methodSetFloat2", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "methodSetFloat3", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "methodSetFloat4", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "methodSetInt", "Z", "loggedMethods", "l", "()Z", "isAvailable", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f43114a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> clazz;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Y8.h methodSetFloat;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Y8.h methodSetFloat2;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Y8.h methodSetFloat3;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Y8.h methodSetFloat4;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Y8.h methodSetInt;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static boolean loggedMethods;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.android.internal.graphics.drawable.StepOSEffectDrawable");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        clazz = cls;
        methodSetFloat = C4848b.b(new InterfaceC5063a() { // from class: w7.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g.p();
            }
        });
        methodSetFloat2 = C4848b.b(new InterfaceC5063a() { // from class: w7.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g.m();
            }
        });
        methodSetFloat3 = C4848b.b(new InterfaceC5063a() { // from class: w7.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g.n();
            }
        });
        methodSetFloat4 = C4848b.b(new InterfaceC5063a() { // from class: w7.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g.o();
            }
        });
        methodSetInt = C4848b.b(new InterfaceC5063a() { // from class: w7.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g.q();
            }
        });
    }

    public static final Method m() {
        Class<?> cls = clazz;
        if (cls == null) {
            return null;
        }
        Class cls2 = Float.TYPE;
        return cls.getDeclaredMethod("setFloat2Uniform", String.class, cls2, cls2);
    }

    public static final Method n() {
        Class<?> cls = clazz;
        if (cls == null) {
            return null;
        }
        Class cls2 = Float.TYPE;
        return cls.getDeclaredMethod("setFloat3Uniform", String.class, cls2, cls2, cls2);
    }

    public static final Method o() {
        Class<?> cls = clazz;
        if (cls == null) {
            return null;
        }
        Class cls2 = Float.TYPE;
        return cls.getDeclaredMethod("setFloat4Uniform", String.class, cls2, cls2, cls2, cls2);
    }

    public static final Method p() {
        Class<?> cls = clazz;
        if (cls != null) {
            return cls.getDeclaredMethod("setFloatUniform", String.class, Float.TYPE);
        }
        return null;
    }

    public static final Method q() {
        Class<?> cls = clazz;
        if (cls != null) {
            return cls.getDeclaredMethod("setIntUniform", String.class, Integer.TYPE);
        }
        return null;
    }

    public final Method f() {
        return (Method) methodSetFloat.getValue();
    }

    public final Method g() {
        return (Method) methodSetFloat2.getValue();
    }

    public final Method h() {
        return (Method) methodSetFloat3.getValue();
    }

    public final Method i() {
        return (Method) methodSetFloat4.getValue();
    }

    public final Method j() {
        return (Method) methodSetInt.getValue();
    }

    public final boolean k(Method method, Drawable drawable, Object... args) {
        if (method == null) {
            return false;
        }
        if (!loggedMethods) {
            loggedMethods = true;
            m mVar = m.f40102a;
            Method methodF = f();
            String name = methodF != null ? methodF.getName() : null;
            Method methodJ = j();
            String name2 = methodJ != null ? methodJ.getName() : null;
            Method methodG = g();
            mVar.a("SF", "methods: float=" + name + " int=" + name2 + " float2=" + (methodG != null ? methodG.getName() : null));
        }
        try {
            method.invoke(drawable, Arrays.copyOf(args, args.length));
            return true;
        } catch (Throwable th) {
            m.f(m.f40102a, "SF", "invoke " + method.getName() + "(" + r.w0(args, null, null, null, 0, null, null, 63, null) + ") failed: " + th.getClass().getSimpleName() + ": " + th.getMessage(), null, 4, null);
            return false;
        }
    }

    public final boolean l() {
        return clazz != null;
    }

    public final void r(Drawable drawable, String name, float value) {
        p.i(drawable, "drawable");
        p.i(name, "name");
        k(f(), drawable, name, Float.valueOf(value));
    }

    public final void s(Drawable drawable, String name, float v12, float v22) {
        p.i(drawable, "drawable");
        p.i(name, "name");
        k(g(), drawable, name, Float.valueOf(v12), Float.valueOf(v22));
    }

    public final void t(Drawable drawable, String name, float v12, float v22, float v32) {
        p.i(drawable, "drawable");
        p.i(name, "name");
        k(h(), drawable, name, Float.valueOf(v12), Float.valueOf(v22), Float.valueOf(v32));
    }

    public final void u(Drawable drawable, String name, float v12, float v22, float v32, float v42) {
        p.i(drawable, "drawable");
        p.i(name, "name");
        k(i(), drawable, name, Float.valueOf(v12), Float.valueOf(v22), Float.valueOf(v32), Float.valueOf(v42));
    }

    public final void v(Drawable drawable, String name, float value) {
        p.i(drawable, "drawable");
        p.i(name, "name");
        if (k(f(), drawable, name, Float.valueOf(value))) {
            return;
        }
        k(j(), drawable, name, Integer.valueOf((int) value));
    }

    public final void w(Drawable drawable, String name, int value) {
        p.i(drawable, "drawable");
        p.i(name, "name");
        k(j(), drawable, name, Integer.valueOf(value));
    }
}
