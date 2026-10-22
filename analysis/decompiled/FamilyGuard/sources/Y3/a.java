package Y3;

import V3.v;
import i4.InterfaceC0761a;
import j4.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: Y3.a$a, reason: collision with other inner class name */
    public static final class C0092a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0761a<v> f6499a;

        C0092a(InterfaceC0761a<v> interfaceC0761a) {
            this.f6499a = interfaceC0761a;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f6499a.invoke();
        }
    }

    public static final Thread a(boolean z5, boolean z6, ClassLoader classLoader, String str, int i5, InterfaceC0761a<v> interfaceC0761a) {
        k.g(interfaceC0761a, "block");
        C0092a c0092a = new C0092a(interfaceC0761a);
        if (z6) {
            c0092a.setDaemon(true);
        }
        if (i5 > 0) {
            c0092a.setPriority(i5);
        }
        if (str != null) {
            c0092a.setName(str);
        }
        if (classLoader != null) {
            c0092a.setContextClassLoader(classLoader);
        }
        if (z5) {
            c0092a.start();
        }
        return c0092a;
    }

    public static /* synthetic */ Thread b(boolean z5, boolean z6, ClassLoader classLoader, String str, int i5, InterfaceC0761a interfaceC0761a, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = true;
        }
        if ((i6 & 2) != 0) {
            z6 = false;
        }
        if ((i6 & 4) != 0) {
            classLoader = null;
        }
        if ((i6 & 8) != 0) {
            str = null;
        }
        if ((i6 & 16) != 0) {
            i5 = -1;
        }
        int i7 = i5;
        String str2 = str;
        return a(z5, z6, classLoader, str2, i7, interfaceC0761a);
    }
}
