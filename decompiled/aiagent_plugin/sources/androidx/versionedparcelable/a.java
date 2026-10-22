package androidx.versionedparcelable;

import android.os.IBinder;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VersionedParcel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    private static final String TAG = "VersionedParcel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final androidx.b.a<String, Method> f2898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final androidx.b.a<String, Method> f2899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final androidx.b.a<String, Class> f2900c;

    public abstract void a(int r1);

    public abstract void a(Parcelable r1);

    public abstract void a(CharSequence r1);

    public abstract void a(String r1);

    public abstract void a(boolean r1);

    public void a(boolean r1, boolean r2) {
    }

    public abstract void a(byte[] r1);

    public boolean a() {
        return false;
    }

    public abstract void b();

    public abstract boolean b(int r1);

    public abstract a c();

    public abstract void c(int r1);

    public abstract int d();

    public abstract String e();

    public abstract byte[] f();

    public abstract CharSequence g();

    public abstract <T extends Parcelable> T h();

    public abstract boolean i();

    public a(androidx.b.a<String, Method> r1, androidx.b.a<String, Method> r2, androidx.b.a<String, Class> r3) {
        this.f2898a = r1;
        this.f2899b = r2;
        this.f2900c = r3;
    }

    public void a(boolean r1, int r2) {
        c(r2);
        a(r1);
    }

    public void a(byte[] r1, int r2) {
        c(r2);
        a(r1);
    }

    public void a(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        c(r4);
        a(r5);
    }

    public void a(int r1, int r2) {
        c(r2);
        a(r1);
    }

    public void a(String r1, int r2) {
        c(r2);
        a(r1);
    }

    public void a(Parcelable r3, int r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        c(r4);
        a(r5);
    }

    public boolean b(boolean r1, int r2) {
        if (b(r2) == true) goto L6;
        return r1;
    L6:
        return i();
    }

    public int b(int r1, int r2) {
        if (b(r2) == true) goto L6;
        return r1;
    L6:
        return d();
    }

    public String b(String r1, int r2) {
        if (b(r2) == true) goto L6;
        return r1;
    L6:
        return e();
    }

    public byte[] b(byte[] r1, int r2) {
        if (b(r2) == true) goto L6;
        return r1;
    L6:
        return f();
    }

    public <T extends Parcelable> T b(T r3, int r4) {
        T r5 = (T) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (b(r4) == true) goto L6;
        return r5;
    L6:
        return (T) h();
    }

    public CharSequence b(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (b(r4) == true) goto L6;
        return r5;
    L6:
        return g();
    }

    private <T> int getType(T r2) {
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        return 4;
    L7:
        if (ZeusTransformUtils.instanceOf(r2, Parcelable.class) == false) goto L11;
        return 2;
    L11:
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L15;
        return 1;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, Serializable.class) == false) goto L19;
        return 3;
    L19:
        if (ZeusTransformUtils.instanceOf(r2, IBinder.class) == false) goto L23;
        return 5;
    L23:
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L27;
        return 7;
    L27:
        if (ZeusTransformUtils.instanceOf(r2, Float.class) == false) goto L31;
        return 8;
    L31:
        throw new IllegalArgumentException(r2.getClass().getName() + " cannot be VersionedParcelled");
    }

    public void a(c r3, int r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        c(r4);
        a(r5);
    }

    public void a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        a(null);
        return;
    L6:
        b(r4);
        a r0 = c();
        a(r4, r0);
        r0.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        a(b(r4.getClass()).getName());
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(r4.getClass().getSimpleName() + " does not have a Parcelizer", e);
    }

    public <T extends c> T b(T r3, int r4) {
        T r5 = (T) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        if (b(r4) == true) goto L6;
        return r5;
    L6:
        return (T) j();
    }

    public <T extends c> T j() {
        String r0 = e();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) a(r0, c());
    }

    public <T extends c> T a(String r4, a r5) {
        return (T) ZeusTransformUtils.preCheckCast(b(r4).invoke(null, new Object[]{r5}), c.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L18:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L8:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L11:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), RuntimeException.class) == false) goto L17;
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(e.getCause(), RuntimeException.class, "com.obric.aiagent.plugin"));
    L17:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    public <T extends c> void a(T r5, a r6) {
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
        a(r7.getClass()).invoke(null, new Object[]{r7, r6});     // Catch: ClassNotFoundException -> L5 NoSuchMethodException -> L8 InvocationTargetException -> L11 IllegalAccessException -> L18
        return;
    L5:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L18:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L8:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L11:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), RuntimeException.class) == false) goto L17;
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(e.getCause(), RuntimeException.class, "com.obric.aiagent.plugin"));
    L17:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    private Method b(String r5) {
        Method r1 = (Method) ZeusTransformUtils.preCheckCast(this.f2898a.get(r5), Method.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        System.currentTimeMillis();
        Method r2 = Class.forName(r5, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[]{a.class});
        this.f2898a.put(r5, r2);
        return r2;
    L6:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method a(Class r5) {
        Method r0 = (Method) ZeusTransformUtils.preCheckCast(this.f2899b.get(r5.getName()), Method.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        Class r1 = b(r5);
        System.currentTimeMillis();
        Method r2 = r1.getDeclaredMethod("write", new Class[]{r5, a.class});
        this.f2899b.put(r5.getName(), r2);
        return r2;
    L6:
        return r0;
    }

    private Class b(Class<? extends c> r5) {
        Class r0 = (Class) ZeusTransformUtils.preCheckCast(this.f2900c.get(r5.getName()), Class.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        Class<?> r1 = Class.forName(String.format("%s.%sParcelizer", new Object[]{r5.getPackage().getName(), r5.getSimpleName()}), false, r5.getClassLoader());
        this.f2900c.put(r5.getName(), r1);
        return r1;
    L6:
        return r0;
    }
}
