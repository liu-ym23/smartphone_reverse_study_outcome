package u0;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;
import l0.AbstractC0822a;
import l0.C0823b;
import o0.AbstractC0891d;
import o0.C0888a;
import o0.C0892e;
import o0.C0893f;
import o0.C0894g;
import o0.C0895h;
import o0.C0896i;
import o0.C0897j;
import o0.EnumC0889b;
import o0.InterfaceC0890c;
import p0.C0919f;
import p0.InterfaceC0917d;
import p0.t;
import q0.AbstractC0956c;
import q0.AbstractC0964k;
import q0.C0946I;
import q0.C0947J;
import q0.C0950M;
import q0.C0963j;
import q0.InterfaceC0949L;
import q0.InterfaceC0973u;
import q0.InterfaceC0974v;
import q0.S;
import q0.U;
import q0.W;
import q0.X;
import q0.Z;
import q0.a0;
import q0.b0;
import q0.c0;
import q0.d0;
import q0.e0;
import q0.f0;
import q0.i0;

/* renamed from: u0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1151a extends ClassLoader {

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, Class<?>> f22727b = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private static ProtectionDomain f22726a = (ProtectionDomain) AccessController.doPrivileged(new C0250a());

    /* renamed from: u0.a$a, reason: collision with other inner class name */
    static class C0250a implements PrivilegedAction<Object> {
        C0250a() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return C1151a.class.getProtectionDomain();
        }
    }

    static {
        Class<?>[] clsArr = {AbstractC0822a.class, l0.e.class, C0823b.class, l0.g.class, l0.c.class, l0.d.class, l0.h.class, l0.i.class, l0.j.class, l0.l.class, l0.n.class, C1154d.class, o.class, g.class, h.class, k.class, i.class, U.class, C0947J.class, d0.class, a0.class, C0946I.class, e0.class, c0.class, C0950M.class, InterfaceC0949L.class, InterfaceC0974v.class, AbstractC0956c.class, AbstractC0964k.class, S.class, W.class, X.class, i0.class, f0.class, InterfaceC0973u.class, Z.class, b0.class, p0.o.class, C0896i.class, C0888a.class, InterfaceC0890c.class, AbstractC0891d.class, C0895h.class, C0894g.class, C0897j.class, EnumC0889b.class, C0893f.class, C0892e.class, InterfaceC0917d.class, t.class, p0.j.class, p0.i.class, p0.k.class, C0963j.class, p0.l.class, C0919f.class};
        for (int i5 = 0; i5 < 56; i5++) {
            Class<?> cls = clsArr[i5];
            f22727b.put(cls.getName(), cls);
        }
    }

    public C1151a() {
        super(b());
    }

    static ClassLoader b() throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                contextClassLoader.loadClass(AbstractC0822a.class.getName());
                return contextClassLoader;
            } catch (ClassNotFoundException unused) {
            }
        }
        return AbstractC0822a.class.getClassLoader();
    }

    public Class<?> a(String str, byte[] bArr, int i5, int i6) {
        return defineClass(str, bArr, i5, i6, f22726a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public boolean c(Class<?> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        for (?? parent = this; parent != 0; parent = parent.getParent()) {
            if (parent == classLoader) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z5) {
        Class<?> cls = f22727b.get(str);
        return cls != null ? cls : super.loadClass(str, z5);
    }

    public C1151a(ClassLoader classLoader) {
        super(classLoader);
    }
}
