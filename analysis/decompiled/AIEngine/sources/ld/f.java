package ld;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kd.h;
import okhttp3.Protocol;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class f implements j {

    /* renamed from: e, reason: collision with root package name */
    public static final e f10422e = new e();

    /* renamed from: a, reason: collision with root package name */
    public final Class<? super SSLSocket> f10423a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f10424b;

    /* renamed from: c, reason: collision with root package name */
    public final Method f10425c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f10426d;

    public f(Class<? super SSLSocket> cls) throws NoSuchMethodException, SecurityException {
        this.f10423a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        kotlin.jvm.internal.g.e(declaredMethod, "getDeclaredMethod(...)");
        this.f10424b = declaredMethod;
        cls.getMethod("setHostname", String.class);
        this.f10425c = cls.getMethod("getAlpnSelectedProtocol", null);
        this.f10426d = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // ld.j
    public final boolean a(SSLSocket sSLSocket) {
        return this.f10423a.isInstance(sSLSocket);
    }

    @Override // ld.j
    public final boolean b() {
        int i10 = kd.b.f9964a;
        return false;
    }

    @Override // ld.j
    public final String c(SSLSocket sSLSocket) {
        if (this.f10423a.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.f10425c.invoke(sSLSocket, null);
                if (bArr != null) {
                    return new String(bArr, gc.a.f9106b);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                Throwable cause = e11.getCause();
                if (!(cause instanceof NullPointerException) || !kotlin.jvm.internal.g.b(((NullPointerException) cause).getMessage(), "ssl == null")) {
                    throw new AssertionError(e11);
                }
            }
        }
        return null;
    }

    @Override // ld.j
    public final void f(SSLSocket sSLSocket, String str, List<? extends Protocol> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f10423a.isInstance(sSLSocket)) {
            try {
                this.f10424b.invoke(sSLSocket, Boolean.TRUE);
                Method method = this.f10426d;
                kd.h.Companion.getClass();
                method.invoke(sSLSocket, h.a.b(list));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }
    }
}
