package q0;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import q.f;

/* renamed from: q0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0822a {

    /* renamed from: a, reason: collision with root package name */
    public final f f13975a;

    /* renamed from: b, reason: collision with root package name */
    public final f f13976b;

    /* renamed from: c, reason: collision with root package name */
    public final f f13977c;

    public AbstractC0822a(f fVar, f fVar2, f fVar3) {
        this.f13975a = fVar;
        this.f13976b = fVar2;
        this.f13977c = fVar3;
    }

    public abstract C0823b a();

    public final Class b(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        f fVar = this.f13977c;
        Class cls2 = (Class) fVar.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        fVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) throws NoSuchMethodException, SecurityException {
        f fVar = this.f13975a;
        Method method = (Method) fVar.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, AbstractC0822a.class.getClassLoader()).getDeclaredMethod("read", AbstractC0822a.class);
        fVar.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        String name = cls.getName();
        f fVar = this.f13976b;
        Method method = (Method) fVar.get(name);
        if (method != null) {
            return method;
        }
        Class clsB = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsB.getDeclaredMethod("write", cls, AbstractC0822a.class);
        fVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i4);

    public final int f(int i4, int i5) {
        return !e(i5) ? i4 : ((C0823b) this).f13979e.readInt();
    }

    public final Parcelable g(Parcelable parcelable, int i4) {
        if (!e(i4)) {
            return parcelable;
        }
        return ((C0823b) this).f13979e.readParcelable(C0823b.class.getClassLoader());
    }

    public final InterfaceC0824c h() {
        String string = ((C0823b) this).f13979e.readString();
        if (string == null) {
            return null;
        }
        try {
            return (InterfaceC0824c) c(string).invoke(null, a());
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e6);
        } catch (InvocationTargetException e7) {
            if (e7.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e7.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e7);
        }
    }

    public abstract void i(int i4);

    public final void j(int i4, int i5) {
        i(i5);
        ((C0823b) this).f13979e.writeInt(i4);
    }

    public final void k(InterfaceC0824c interfaceC0824c) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (interfaceC0824c == null) {
            ((C0823b) this).f13979e.writeString(null);
            return;
        }
        try {
            ((C0823b) this).f13979e.writeString(b(interfaceC0824c.getClass()).getName());
            C0823b c0823bA = a();
            try {
                d(interfaceC0824c.getClass()).invoke(null, interfaceC0824c, c0823bA);
                int i4 = c0823bA.f13983i;
                if (i4 >= 0) {
                    int i5 = c0823bA.f13978d.get(i4);
                    Parcel parcel = c0823bA.f13979e;
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i5);
                    parcel.writeInt(iDataPosition - i5);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
            } catch (NoSuchMethodException e6) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e6);
            } catch (InvocationTargetException e7) {
                if (!(e7.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e7);
                }
                throw ((RuntimeException) e7.getCause());
            }
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException(interfaceC0824c.getClass().getSimpleName().concat(" does not have a Parcelizer"), e8);
        }
    }
}
