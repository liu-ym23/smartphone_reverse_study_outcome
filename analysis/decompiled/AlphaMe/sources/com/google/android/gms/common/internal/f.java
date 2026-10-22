package com.google.android.gms.common.internal;

import S.InterfaceC0096b;
import androidx.lifecycle.n0;
import androidx.lifecycle.q0;
import e0.C0549b;
import h3.InterfaceC0593b;
import h3.InterfaceC0615y;
import h3.V;
import h3.b0;
import h3.g0;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import l0.C0754h;

/* loaded from: classes.dex */
public final class f implements InterfaceC0096b, q0, InterfaceC0593b, InterfaceC0615y, k0.f {

    /* renamed from: a, reason: collision with root package name */
    public static f f9806a;

    /* renamed from: b, reason: collision with root package name */
    public static f f9807b;

    public static synchronized f b() {
        try {
            if (f9806a == null) {
                f9806a = new f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9806a;
    }

    @Override // androidx.lifecycle.q0
    public n0 a(Class cls) {
        return new C0549b();
    }

    @Override // h3.InterfaceC0593b
    public V authenticate(g0 g0Var, b0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return null;
    }

    @Override // k0.f
    public k0.g create(k0.e configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return new C0754h(configuration.f13327a, configuration.f13328b, configuration.f13329c, configuration.f13330d, configuration.f13331e);
    }

    @Override // h3.InterfaceC0615y
    public List lookup(String hostname) throws UnknownHostException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        try {
            InetAddress[] allByName = InetAddress.getAllByName(hostname);
            Intrinsics.checkNotNullExpressionValue(allByName, "getAllByName(hostname)");
            return ArraysKt.toList(allByName);
        } catch (NullPointerException e4) {
            UnknownHostException unknownHostException = new UnknownHostException(Intrinsics.stringPlus("Broken system behaviour for dns lookup of ", hostname));
            unknownHostException.initCause(e4);
            throw unknownHostException;
        }
    }
}
