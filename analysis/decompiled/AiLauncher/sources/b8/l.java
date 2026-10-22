package b8;

import com.typesafe.config.ConfigSyntax;

/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final ConfigSyntax f15286a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15287b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f15288c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1457c f15289d;

    /* renamed from: e, reason: collision with root package name */
    public final ClassLoader f15290e;

    public l(ConfigSyntax configSyntax, String str, boolean z10, InterfaceC1457c interfaceC1457c, ClassLoader classLoader) {
        this.f15286a = configSyntax;
        this.f15287b = str;
        this.f15288c = z10;
        this.f15289d = interfaceC1457c;
        this.f15290e = classLoader;
    }

    public static l b() {
        return new l(null, null, true, null, null);
    }

    public l a(InterfaceC1457c interfaceC1457c) {
        if (interfaceC1457c == null) {
            throw new NullPointerException("null includer passed to appendIncluder");
        }
        InterfaceC1457c interfaceC1457c2 = this.f15289d;
        return interfaceC1457c2 == interfaceC1457c ? this : interfaceC1457c2 != null ? j(interfaceC1457c2.e(interfaceC1457c)) : j(interfaceC1457c);
    }

    public boolean c() {
        return this.f15288c;
    }

    public ClassLoader d() {
        ClassLoader classLoader = this.f15290e;
        return classLoader == null ? Thread.currentThread().getContextClassLoader() : classLoader;
    }

    public InterfaceC1457c e() {
        return this.f15289d;
    }

    public String f() {
        return this.f15287b;
    }

    public ConfigSyntax g() {
        return this.f15286a;
    }

    public l h(boolean z10) {
        return this.f15288c == z10 ? this : new l(this.f15286a, this.f15287b, z10, this.f15289d, this.f15290e);
    }

    public l i(ClassLoader classLoader) {
        return this.f15290e == classLoader ? this : new l(this.f15286a, this.f15287b, this.f15288c, this.f15289d, classLoader);
    }

    public l j(InterfaceC1457c interfaceC1457c) {
        return this.f15289d == interfaceC1457c ? this : new l(this.f15286a, this.f15287b, this.f15288c, interfaceC1457c, this.f15290e);
    }

    public l k(String str) {
        String str2 = this.f15287b;
        return (str2 != str && (str2 == null || str == null || !str2.equals(str))) ? new l(this.f15286a, str, this.f15288c, this.f15289d, this.f15290e) : this;
    }

    public l l(ConfigSyntax configSyntax) {
        return this.f15286a == configSyntax ? this : new l(configSyntax, this.f15287b, this.f15288c, this.f15289d, this.f15290e);
    }
}
