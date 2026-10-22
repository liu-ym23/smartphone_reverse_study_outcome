package androidx.versionedparcelable;

import android.os.Parcelable;
import h0.InterfaceC0745a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import q.C0933a;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final C0933a<String, Method> f11602a;

    /* renamed from: b, reason: collision with root package name */
    protected final C0933a<String, Method> f11603b;

    /* renamed from: c, reason: collision with root package name */
    protected final C0933a<String, Class> f11604c;

    public a(C0933a<String, Method> c0933a, C0933a<String, Method> c0933a2, C0933a<String, Class> c0933a3) {
        this.f11602a = c0933a;
        this.f11603b = c0933a2;
        this.f11604c = c0933a3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N(InterfaceC0745a interfaceC0745a) {
        try {
            I(c(interfaceC0745a.getClass()).getName());
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException(interfaceC0745a.getClass().getSimpleName() + " does not have a Parcelizer", e6);
        }
    }

    private Class c(Class<? extends InterfaceC0745a> cls) throws ClassNotFoundException {
        Class cls2 = this.f11604c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f11604c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) throws NoSuchMethodException, SecurityException {
        Method method = this.f11602a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f11602a.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method e(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method = this.f11603b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, a.class);
        this.f11603b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i5) {
        w(i5);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i5) {
        w(i5);
        C(charSequence);
    }

    protected abstract void E(int i5);

    public void F(int i5, int i6) {
        w(i6);
        E(i5);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i5) {
        w(i5);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i5) {
        w(i5);
        I(str);
    }

    protected <T extends InterfaceC0745a> void K(T t5, a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            e(t5.getClass()).invoke(null, t5, aVar);
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e6);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e7);
        } catch (NoSuchMethodException e8) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e8);
        } catch (InvocationTargetException e9) {
            if (!(e9.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e9);
            }
            throw ((RuntimeException) e9.getCause());
        }
    }

    protected void L(InterfaceC0745a interfaceC0745a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (interfaceC0745a == null) {
            I(null);
            return;
        }
        N(interfaceC0745a);
        a aVarB = b();
        K(interfaceC0745a, aVarB);
        aVarB.a();
    }

    public void M(InterfaceC0745a interfaceC0745a, int i5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        w(i5);
        L(interfaceC0745a);
    }

    protected abstract void a();

    protected abstract a b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z5, int i5) {
        return !m(i5) ? z5 : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i5) {
        return !m(i5) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i5) {
        return !m(i5) ? charSequence : k();
    }

    protected abstract boolean m(int i5);

    protected <T extends InterfaceC0745a> T n(String str, a aVar) {
        try {
            return (T) d(str).invoke(null, aVar);
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e6);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e7);
        } catch (NoSuchMethodException e8) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e8);
        } catch (InvocationTargetException e9) {
            if (e9.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e9.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e9);
        }
    }

    protected abstract int o();

    public int p(int i5, int i6) {
        return !m(i6) ? i5 : o();
    }

    protected abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t5, int i5) {
        return !m(i5) ? t5 : (T) q();
    }

    protected abstract String s();

    public String t(String str, int i5) {
        return !m(i5) ? str : s();
    }

    protected <T extends InterfaceC0745a> T u() {
        String strS = s();
        if (strS == null) {
            return null;
        }
        return (T) n(strS, b());
    }

    public <T extends InterfaceC0745a> T v(T t5, int i5) {
        return !m(i5) ? t5 : (T) u();
    }

    protected abstract void w(int i5);

    public void x(boolean z5, boolean z6) {
    }

    protected abstract void y(boolean z5);

    public void z(boolean z5, int i5) {
        w(i5);
        y(z5);
    }
}
