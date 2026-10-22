package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class VersionedParcel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap f5107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap f5108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayMap f5109c;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable r10) {
            super(r10);
        }
    }

    public VersionedParcel(ArrayMap r10, ArrayMap r11, ArrayMap r12) {
        this.f5107a = r10;
        this.f5108b = r11;
        this.f5109c = r12;
    }

    public abstract void A(byte[] r10);

    public void B(byte[] r10, int r11) {
        w(r11);
        A(r10);
    }

    public abstract void C(CharSequence r10);

    public void D(CharSequence r10, int r11) {
        w(r11);
        C(r10);
    }

    public abstract void E(int r10);

    public void F(int r10, int r11) {
        w(r11);
        E(r10);
    }

    public abstract void G(Parcelable r10);

    public void H(Parcelable r10, int r11) {
        w(r11);
        G(r10);
    }

    public abstract void I(String r10);

    public void J(String r10, int r11) {
        w(r11);
        I(r10);
    }

    public void K(VersionedParcelable r10, VersionedParcel r11) {
        e(r10.getClass()).invoke(null, new Object[]{r10, r11});     // Catch: ClassNotFoundException -> L4 NoSuchMethodException -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L10:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L6:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L8:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L21;
        throw ((RuntimeException) e.getCause());
    L21:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    public void L(VersionedParcelable r10) {
        if (r10 != null) goto L5;
        I(null);
        return;
    L5:
        N(r10);
        VersionedParcel r11 = b();
        K(r10, r11);
        r11.a();
    }

    public void M(VersionedParcelable r10, int r11) {
        w(r11);
        L(r10);
    }

    public final void N(VersionedParcelable r10) {
        I(c(r10.getClass()).getName());
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(r10.getClass().getSimpleName() + " does not have a Parcelizer", e);
    }

    public abstract void a();

    public abstract VersionedParcel b();

    public final Class c(Class r10) {
        Class r11 = (Class) this.f5109c.get(r10.getName());
        if (r11 != null) goto L6;
        Class<?> r12 = Class.forName(String.format("%s.%sParcelizer", new Object[]{r10.getPackage().getName(), r10.getSimpleName()}), false, r10.getClassLoader());
        this.f5109c.put(r10.getName(), r12);
        return r12;
    L6:
        return r11;
    }

    public final Method d(String r10) {
        Method r11 = (Method) this.f5107a.get(r10);
        if (r11 != null) goto L6;
        System.currentTimeMillis();
        Method r12 = Class.forName(r10, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", new Class[]{VersionedParcel.class});
        this.f5107a.put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    public final Method e(Class r10) {
        Method r11 = (Method) this.f5108b.get(r10.getName());
        if (r11 != null) goto L6;
        Class r12 = c(r10);
        System.currentTimeMillis();
        Method r13 = r12.getDeclaredMethod("write", new Class[]{r10, VersionedParcel.class});
        this.f5108b.put(r10.getName(), r13);
        return r13;
    L6:
        return r11;
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public boolean h(boolean r10, int r11) {
        if (m(r11) == true) goto L6;
        return r10;
    L6:
        return g();
    }

    public abstract byte[] i();

    public byte[] j(byte[] r10, int r11) {
        if (m(r11) == true) goto L6;
        return r10;
    L6:
        return i();
    }

    public abstract CharSequence k();

    public CharSequence l(CharSequence r10, int r11) {
        if (m(r11) == true) goto L6;
        return r10;
    L6:
        return k();
    }

    public abstract boolean m(int r10);

    public VersionedParcelable n(String r10, VersionedParcel r11) {
        return (VersionedParcelable) d(r10).invoke(null, new Object[]{r11});
    L4:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L10:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L6:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L8:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L21;
        throw ((RuntimeException) e.getCause());
    L21:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    public abstract int o();

    public int p(int r10, int r11) {
        if (m(r11) == true) goto L6;
        return r10;
    L6:
        return o();
    }

    public abstract Parcelable q();

    public Parcelable r(Parcelable r10, int r11) {
        if (m(r11) == true) goto L6;
        return r10;
    L6:
        return q();
    }

    public abstract String s();

    public String t(String r10, int r11) {
        if (m(r11) == true) goto L6;
        return r10;
    L6:
        return s();
    }

    public VersionedParcelable u() {
        String r10 = s();
        if (r10 != null) goto L7;
        return null;
    L7:
        return n(r10, b());
    }

    public VersionedParcelable v(VersionedParcelable r10, int r11) {
        if (m(r11) == true) goto L6;
        return r10;
    L6:
        return u();
    }

    public abstract void w(int r10);

    public void x(boolean r10, boolean r11) {
    }

    public abstract void y(boolean r10);

    public void z(boolean r10, int r11) {
        w(r11);
        y(r10);
    }
}
