package com.typesafe.config.impl;

import b8.InterfaceC1456b;
import b8.InterfaceC1457c;
import b8.InterfaceC1458d;
import b8.InterfaceC1459e;
import b8.InterfaceC1460f;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigSyntax;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class O implements z {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1457c f31778a;

    public interface a {
        b8.m a(String str, b8.l lVar);
    }

    public static class b implements z {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1457c f31779a;

        public b(InterfaceC1457c interfaceC1457c) {
            this.f31779a = interfaceC1457c;
        }

        @Override // b8.InterfaceC1459e
        public b8.j a(InterfaceC1456b interfaceC1456b, File file) {
            InterfaceC1457c interfaceC1457c = this.f31779a;
            return interfaceC1457c instanceof InterfaceC1459e ? ((InterfaceC1459e) interfaceC1457c).a(interfaceC1456b, file) : O.h(interfaceC1456b, file);
        }

        @Override // b8.InterfaceC1460f
        public b8.j b(InterfaceC1456b interfaceC1456b, URL url) {
            InterfaceC1457c interfaceC1457c = this.f31779a;
            return interfaceC1457c instanceof InterfaceC1460f ? ((InterfaceC1460f) interfaceC1457c).b(interfaceC1456b, url) : O.j(interfaceC1456b, url);
        }

        @Override // b8.InterfaceC1457c
        public b8.j c(InterfaceC1456b interfaceC1456b, String str) {
            return this.f31779a.c(interfaceC1456b, str);
        }

        @Override // b8.InterfaceC1458d
        public b8.j d(InterfaceC1456b interfaceC1456b, String str) {
            InterfaceC1457c interfaceC1457c = this.f31779a;
            return interfaceC1457c instanceof InterfaceC1458d ? ((InterfaceC1458d) interfaceC1457c).d(interfaceC1456b, str) : O.i(interfaceC1456b, str);
        }

        @Override // b8.InterfaceC1457c
        public InterfaceC1457c e(InterfaceC1457c interfaceC1457c) {
            return this;
        }
    }

    public static class c implements a {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1456b f31780a;

        public c(InterfaceC1456b interfaceC1456b) {
            this.f31780a = interfaceC1456b;
        }

        @Override // com.typesafe.config.impl.O.a
        public b8.m a(String str, b8.l lVar) {
            b8.m mVarA = this.f31780a.a(str);
            if (mVarA != null) {
                return mVarA;
            }
            return C.m(str, "include was not found: '" + str + "'", lVar);
        }
    }

    public O(InterfaceC1457c interfaceC1457c) {
        this.f31778a = interfaceC1457c;
    }

    public static b8.l f(b8.l lVar) {
        return lVar.l(null).k(null).h(true);
    }

    public static b8.j g(a aVar, String str, b8.l lVar) {
        boolean z10;
        if (str.endsWith(".conf") || str.endsWith(".json") || str.endsWith(".properties")) {
            b8.m mVarA = aVar.a(str, lVar);
            return mVarA.b(mVarA.c().h(lVar.c()));
        }
        b8.m mVarA2 = aVar.a(str + ".conf", lVar);
        b8.m mVarA3 = aVar.a(str + ".json", lVar);
        b8.m mVarA4 = aVar.a(str + ".properties", lVar);
        ArrayList arrayList = new ArrayList();
        ConfigSyntax configSyntaxG = lVar.g();
        b8.j jVarK0 = SimpleConfigObject.K0(M.r(str));
        boolean z11 = true;
        if (configSyntaxG == null || configSyntaxG == ConfigSyntax.CONF) {
            try {
                jVarK0 = mVarA2.b(mVarA2.c().h(false).l(ConfigSyntax.CONF));
                z10 = true;
            } catch (ConfigException.IO e10) {
                arrayList.add(e10);
            }
        } else {
            z10 = false;
        }
        if (configSyntaxG == null || configSyntaxG == ConfigSyntax.JSON) {
            try {
                jVarK0 = jVarK0.n0(mVarA3.b(mVarA3.c().h(false).l(ConfigSyntax.JSON)));
                z10 = true;
            } catch (ConfigException.IO e11) {
                arrayList.add(e11);
            }
        }
        if (configSyntaxG == null || configSyntaxG == ConfigSyntax.PROPERTIES) {
            try {
                jVarK0 = jVarK0.n0(mVarA4.b(mVarA4.c().h(false).l(ConfigSyntax.PROPERTIES)));
            } catch (ConfigException.IO e12) {
                arrayList.add(e12);
            }
        } else {
            z11 = z10;
        }
        if (lVar.c() || z11) {
            if (!z11 && C3903i.B()) {
                C3903i.A("Did not find '" + str + "' with any extension (.conf, .json, .properties); but '" + str + "' is allowed to be missing. Exceptions from load attempts should have been logged above.");
            }
            return jVarK0;
        }
        if (C3903i.B()) {
            C3903i.A("Did not find '" + str + "' with any extension (.conf, .json, .properties); exceptions should have been logged above.");
        }
        if (arrayList.isEmpty()) {
            throw new ConfigException.BugOrBroken("should not be reached: nothing found but no exceptions thrown");
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append(((Throwable) it.next()).getMessage());
            sb2.append(", ");
        }
        sb2.setLength(sb2.length() - 2);
        throw new ConfigException.IO(M.r(str), sb2.toString(), (Throwable) arrayList.get(0));
    }

    public static b8.j h(InterfaceC1456b interfaceC1456b, File file) {
        return com.typesafe.config.a.k(file, interfaceC1456b.b()).K();
    }

    public static b8.j i(InterfaceC1456b interfaceC1456b, String str) {
        return com.typesafe.config.a.l(str, interfaceC1456b.b()).K();
    }

    public static b8.j j(InterfaceC1456b interfaceC1456b, URL url) {
        return com.typesafe.config.a.m(url, interfaceC1456b.b()).K();
    }

    public static b8.j k(InterfaceC1456b interfaceC1456b, String str) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException unused) {
            url = null;
        }
        return url != null ? j(interfaceC1456b, url) : g(new c(interfaceC1456b), str, interfaceC1456b.b());
    }

    public static z l(InterfaceC1457c interfaceC1457c) {
        return interfaceC1457c instanceof z ? (z) interfaceC1457c : new b(interfaceC1457c);
    }

    @Override // b8.InterfaceC1459e
    public b8.j a(InterfaceC1456b interfaceC1456b, File file) {
        b8.j jVarH = h(interfaceC1456b, file);
        InterfaceC1457c interfaceC1457c = this.f31778a;
        return (interfaceC1457c == null || !(interfaceC1457c instanceof InterfaceC1459e)) ? jVarH : jVarH.n0(((InterfaceC1459e) interfaceC1457c).a(interfaceC1456b, file));
    }

    @Override // b8.InterfaceC1460f
    public b8.j b(InterfaceC1456b interfaceC1456b, URL url) {
        b8.j jVarJ = j(interfaceC1456b, url);
        InterfaceC1457c interfaceC1457c = this.f31778a;
        return (interfaceC1457c == null || !(interfaceC1457c instanceof InterfaceC1460f)) ? jVarJ : jVarJ.n0(((InterfaceC1460f) interfaceC1457c).b(interfaceC1456b, url));
    }

    @Override // b8.InterfaceC1457c
    public b8.j c(InterfaceC1456b interfaceC1456b, String str) {
        b8.j jVarK = k(interfaceC1456b, str);
        InterfaceC1457c interfaceC1457c = this.f31778a;
        return interfaceC1457c != null ? jVarK.n0(interfaceC1457c.c(interfaceC1456b, str)) : jVarK;
    }

    @Override // b8.InterfaceC1458d
    public b8.j d(InterfaceC1456b interfaceC1456b, String str) {
        b8.j jVarI = i(interfaceC1456b, str);
        InterfaceC1457c interfaceC1457c = this.f31778a;
        return (interfaceC1457c == null || !(interfaceC1457c instanceof InterfaceC1458d)) ? jVarI : jVarI.n0(((InterfaceC1458d) interfaceC1457c).d(interfaceC1456b, str));
    }

    @Override // b8.InterfaceC1457c
    public InterfaceC1457c e(InterfaceC1457c interfaceC1457c) {
        if (this == interfaceC1457c) {
            throw new ConfigException.BugOrBroken("trying to create includer cycle");
        }
        InterfaceC1457c interfaceC1457c2 = this.f31778a;
        return interfaceC1457c2 == interfaceC1457c ? this : interfaceC1457c2 != null ? new O(interfaceC1457c2.e(interfaceC1457c)) : new O(interfaceC1457c);
    }
}
