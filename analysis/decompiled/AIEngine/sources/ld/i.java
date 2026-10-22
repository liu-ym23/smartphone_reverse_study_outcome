package ld;

import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i implements j {

    /* renamed from: a, reason: collision with root package name */
    public final a f10429a;

    /* renamed from: b, reason: collision with root package name */
    public j f10430b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        boolean a(SSLSocket sSLSocket);

        j b(SSLSocket sSLSocket);
    }

    public i(a aVar) {
        this.f10429a = aVar;
    }

    @Override // ld.j
    public final boolean a(SSLSocket sSLSocket) {
        return this.f10429a.a(sSLSocket);
    }

    @Override // ld.j
    public final boolean b() {
        return true;
    }

    @Override // ld.j
    public final String c(SSLSocket sSLSocket) {
        j jVarG = g(sSLSocket);
        if (jVarG != null) {
            return jVarG.c(sSLSocket);
        }
        return null;
    }

    @Override // ld.j
    public final void f(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        j jVarG = g(sSLSocket);
        if (jVarG != null) {
            jVarG.f(sSLSocket, str, list);
        }
    }

    public final synchronized j g(SSLSocket sSLSocket) {
        try {
            if (this.f10430b == null && this.f10429a.a(sSLSocket)) {
                this.f10430b = this.f10429a.b(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f10430b;
    }
}
