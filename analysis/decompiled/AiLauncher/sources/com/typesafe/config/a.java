package com.typesafe.config;

import b8.InterfaceC1455a;
import b8.l;
import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.C;
import com.typesafe.config.impl.C3903i;
import java.io.File;
import java.net.URL;

/* loaded from: classes4.dex */
public final class a {
    public static ClassLoader a(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            return contextClassLoader;
        }
        throw new ConfigException.BugOrBroken("Context class loader is not set for the current thread; if Thread.currentThread().getContextClassLoader() returns null, you must pass a ClassLoader explicitly to ConfigFactory." + str);
    }

    public static InterfaceC1455a b() {
        return e().booleanValue() ? n().f(o()) : o();
    }

    public static InterfaceC1455a c(ClassLoader classLoader) {
        return b();
    }

    public static l d(l lVar, String str) {
        return lVar.d() == null ? lVar.i(a(str)) : lVar;
    }

    public static Boolean e() {
        return Boolean.valueOf(Boolean.parseBoolean(System.getProperties().getProperty("config.override_with_env_vars")));
    }

    public static InterfaceC1455a f(ClassLoader classLoader, InterfaceC1455a interfaceC1455a, b bVar) {
        return c(classLoader).f(interfaceC1455a).f(C3903i.h(classLoader)).D(bVar);
    }

    public static InterfaceC1455a g(String str) {
        return h(str, l.b(), b.a());
    }

    public static InterfaceC1455a h(String str, l lVar, b bVar) {
        l lVarD = d(lVar, "load");
        return f(lVarD.d(), l(str, lVarD), bVar);
    }

    public static InterfaceC1455a i(File file) {
        return j(file, l.b());
    }

    public static InterfaceC1455a j(File file, l lVar) {
        return C.l(file, lVar).r().k();
    }

    public static InterfaceC1455a k(File file, l lVar) {
        return C3903i.v(file, lVar).k();
    }

    public static InterfaceC1455a l(String str, l lVar) {
        return C3903i.w(str, lVar).k();
    }

    public static InterfaceC1455a m(URL url, l lVar) {
        return C.q(url, lVar).r().k();
    }

    public static InterfaceC1455a n() {
        return C3903i.l();
    }

    public static InterfaceC1455a o() {
        return C3903i.x();
    }
}
