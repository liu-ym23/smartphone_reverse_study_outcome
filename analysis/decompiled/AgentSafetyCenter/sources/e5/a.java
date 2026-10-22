package e5;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import od.f;
import p.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public e f3496a;

    /* renamed from: b, reason: collision with root package name */
    public e f3497b;

    /* renamed from: c, reason: collision with root package name */
    public e f3498c;

    public abstract b a();

    public final Class b(Class cls) throws ClassNotFoundException {
        e eVar = this.f3498c;
        Class cls2 = (Class) eVar.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        eVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) throws NoSuchMethodException, SecurityException {
        e eVar = this.f3496a;
        Method method = (Method) eVar.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        eVar.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        e eVar = this.f3497b;
        Method method = (Method) eVar.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsB = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsB.getDeclaredMethod("write", cls, a.class);
        eVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i);

    public final Parcelable f(Parcelable parcelable, int i) {
        if (!e(i)) {
            return parcelable;
        }
        return ((b) this).f3500e.readParcelable(b.class.getClassLoader());
    }

    public final c g() {
        String string = ((b) this).f3500e.readString();
        if (string == null) {
            return null;
        }
        try {
            return (c) c(string).invoke(null, a());
        } catch (ClassNotFoundException e10) {
            f.g("VersionedParcel encountered ClassNotFoundException", e10);
            return null;
        } catch (IllegalAccessException e11) {
            f.g("VersionedParcel encountered IllegalAccessException", e11);
            return null;
        } catch (NoSuchMethodException e12) {
            f.g("VersionedParcel encountered NoSuchMethodException", e12);
            return null;
        } catch (InvocationTargetException e13) {
            if (e13.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e13.getCause());
            }
            f.g("VersionedParcel encountered InvocationTargetException", e13);
            return null;
        }
    }

    public abstract void h(int i);

    public final void i(c cVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (cVar == null) {
            ((b) this).f3500e.writeString(null);
            return;
        }
        try {
            ((b) this).f3500e.writeString(b(cVar.getClass()).getName());
            b bVarA = a();
            try {
                d(cVar.getClass()).invoke(null, cVar, bVarA);
                Parcel parcel = bVarA.f3500e;
                int i = bVarA.i;
                if (i >= 0) {
                    int i3 = bVarA.f3499d.get(i);
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i3);
                    parcel.writeInt(iDataPosition - i3);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e10) {
                f.g("VersionedParcel encountered ClassNotFoundException", e10);
            } catch (IllegalAccessException e11) {
                f.g("VersionedParcel encountered IllegalAccessException", e11);
            } catch (NoSuchMethodException e12) {
                f.g("VersionedParcel encountered NoSuchMethodException", e12);
            } catch (InvocationTargetException e13) {
                if (e13.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e13.getCause());
                }
                f.g("VersionedParcel encountered InvocationTargetException", e13);
            }
        } catch (ClassNotFoundException e14) {
            f.g(cVar.getClass().getSimpleName().concat(" does not have a Parcelizer"), e14);
        }
    }
}
