package org.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.URL;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.b.b.h;
import org.b.b.j;
import org.b.b.l;
import org.b.b.n;

/* JADX INFO: compiled from: LoggerFactory.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile int f40301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final l f40302b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final h f40303c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f40304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile org.b.c.b f40305e;
    private static final String[] f = null;

    public static /* synthetic */ ServiceLoader lambda$Go6lxe5gmXzU7LPhttjnbTzdZ94(ClassLoader r0) {
        return b(r0);
    }

    static {
        f40302b = new l();
        f40303c = new h();
        f40304d = n.b("slf4j.detectLoggerNameMismatch");
        f = new String[]{"2.0"};
    }

    static List<org.b.c.b> a() {
        ServiceLoader<org.b.c.b> r0 = a(d.class.getClassLoader());
        ArrayList r1 = new ArrayList();
        Iterator<org.b.c.b> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        a(r1, r2);
        goto L4
    L6:
        return r1;
    }

    private static ServiceLoader<org.b.c.b> a(final ClassLoader r2) {
        if (System.getSecurityManager() != null) goto L6;
        return ServiceLoader.load(org.b.c.b.class, r2);
    L6:
        return (ServiceLoader) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new $$Lambda$d$Go6lxe5gmXzU7LPhttjnbTzdZ94(r2)), ServiceLoader.class, "com.obric.aiagent.plugin");
    }

    private static /* synthetic */ ServiceLoader b(ClassLoader r1) {
        return ServiceLoader.load(org.b.c.b.class, r1);
    }

    private static void a(List<org.b.c.b> r2, Iterator<org.b.c.b> r3) {
        ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin")).add((org.b.c.b) ZeusTransformUtils.preCheckCast(((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.aiagent.plugin")).next(), org.b.c.b.class, "com.obric.aiagent.plugin"));     // Catch: ServiceConfigurationError -> L5
        return;
    L5:
        e = move-exception;
        n.c("A SLF4J service provider failed to instantiate:\n" + e.getMessage());
    }

    private d() {
    }

    private static final void e() {
        f();
        if (f40301a != 3) goto L6;
        k();
        return;
    }

    private static final void f() {
        List<org.b.c.b> r0 = a();     // Catch: Exception -> L10
        b(r0);     // Catch: Exception -> L10
        if (r0 != null) goto L5;
    L7:
        f40301a = 4;     // Catch: Exception -> L10
        n.c("No SLF4J providers were found.");     // Catch: Exception -> L10
        n.c("Defaulting to no-operation (NOP) logger implementation");     // Catch: Exception -> L10
        n.c("See https://www.slf4j.org/codes.html#noProviders for further details.");     // Catch: Exception -> L10
        a(b());     // Catch: Exception -> L10
    L8:
        g();     // Catch: Exception -> L10
        return;
    L5:
        if (r0.isEmpty() == true) goto L7;
        f40305e = (org.b.c.b) ZeusTransformUtils.preCheckCast(r0.get(0), org.b.c.b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
        f40305e.c();     // Catch: Exception -> L10
        f40301a = 3;     // Catch: Exception -> L10
        c(r0);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        a(e);
        throw new IllegalStateException("Unexpected initialization failure", e);
    }

    private static void a(Set<URL> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        n.c("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        n.c("Ignoring binding found at [" + ((URL) ZeusTransformUtils.preCheckCast(r6.next(), URL.class, "com.obric.aiagent.plugin")) + "]");
        goto L7
    L9:
        n.c("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    static Set<URL> b() {
        LinkedHashSet r0 = new LinkedHashSet();
        ClassLoader r1 = d.class.getClassLoader();     // Catch: IOException -> L12
        if (r1 != null) goto L7;
        Enumeration<URL> r2 = ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class");     // Catch: IOException -> L12
    L8:
        if (r2.hasMoreElements() == false) goto L14;
        r0.add((URL) ZeusTransformUtils.preCheckCast(r2.nextElement(), URL.class, "com.obric.aiagent.plugin"));     // Catch: IOException -> L12
    L14:
        return r0;
    L7:
        r2 = r1.getResources("org/slf4j/impl/StaticLoggerBinder.class");     // Catch: IOException -> L12
    L12:
        e = move-exception;
        n.a("Error getting resources from path", e);
        goto L14
    }

    private static void g() {
        h();
        i();
        f40302b.d().d();
    }

    private static void h() {
        l r0 = f40302b;
        monitor-enter(r0);
        r0.d().c();     // Catch: Throwable -> L10
        Iterator<j> r1 = r0.d().a().iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        j r2 = (j) ZeusTransformUtils.preCheckCast(r1.next(), j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        r2.a(a(r2.a()));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    static void a(Throwable r1) {
        f40301a = 2;
        n.a("Failed to instantiate SLF4J LoggerFactory", r1);
    }

    private static void i() {
        LinkedBlockingQueue<org.b.a.d> r0 = f40302b.d().b();
        int r1 = r0.size();
        ArrayList r2 = new ArrayList(128);
        int r4 = 0;
    L4:
        if (r0.drainTo(r2, 128) == 0) goto L5;
        Iterator r5 = r2.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        org.b.a.d r6 = (org.b.a.d) ZeusTransformUtils.preCheckCast(r5.next(), org.b.a.d.class, "com.obric.aiagent.plugin");
        a(r6);
        int r7 = r4 + 1;
        if (r4 != 0) goto L12;
        a(r6, r1);
    L12:
        r4 = r7;
        goto L8
    L13:
        r2.clear();
        goto L4
    }

    private static void a(org.b.a.d r1, int r2) {
        if (r1.b().h() == false) goto L6;
        a(r2);
        return;
    L6:
        if (r1.b().j() == true) goto L11;
        j();
        return;
    }

    private static void a(org.b.a.d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        j r0 = r3.b();
        String r1 = r0.a();
        if (r0.i() == true) goto L17;
        if (r0.j() == false) goto L10;
        return;
    L10:
        if (r0.h() == true) goto L12;
        n.c(r1);
        return;
    L12:
        if (r0.a(r3.a()) == false) goto L18;
        r0.a(r3);
        return;
    L18:
        return;
    L17:
        throw new IllegalStateException("Delegate logger cannot be null at this state.");
    }

    private static void j() {
        n.c("The following set of substitute loggers may have been accessed");
        n.c("during the initialization phase. Logging calls during this");
        n.c("phase were not honored. However, subsequent logging calls to these");
        n.c("loggers will work as normally expected.");
        n.c("See also https://www.slf4j.org/codes.html#substituteLogger");
    }

    private static void a(int r2) {
        n.c("A number (" + r2 + ") of logging calls during the initialization phase have been intercepted and are");
        n.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        n.c("See also https://www.slf4j.org/codes.html#replay");
    }

    private static final void k() {
        String r0 = f40305e.b();     // Catch: Throwable -> L11 NoSuchFieldError -> L14
        String[] r1 = f;     // Catch: Throwable -> L11 NoSuchFieldError -> L14
        int r2 = r1.length;     // Catch: Throwable -> L11 NoSuchFieldError -> L14
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 >= r2) goto L8;
        if (r0.startsWith(r1[r3]) == false) goto L7;
        r4 = true;
    L7:
        r3 = r3 + 1;     // Catch: Throwable -> L11 NoSuchFieldError -> L14
        goto L3
    L8:
        if (r4 == true) goto L20;
        n.c("The requested version " + r0 + " by your slf4j binding is not compatible with " + Arrays.asList(f).toString());     // Catch: Throwable -> L11 NoSuchFieldError -> L14
        n.c("See https://www.slf4j.org/codes.html#version_mismatch for further details.");     // Catch: Throwable -> L11 NoSuchFieldError -> L14
        goto L22
    L21:
        return;
    L20:
        return;
    L11:
        th = move-exception;
        n.a("Unexpected problem occured during version sanity check", th);
        return;
    }

    private static boolean a(List<org.b.c.b> r2) {
        if (((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin")).size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static void b(List<org.b.c.b> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (a(r5) == false) goto L11;
        n.c("Class path contains multiple SLF4J providers.");
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        n.c("Found provider [" + ((org.b.c.b) ZeusTransformUtils.preCheckCast(r6.next(), org.b.c.b.class, "com.obric.aiagent.plugin")) + "]");
        goto L6
    L8:
        n.c("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        return;
    }

    private static void c(List<org.b.c.b> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r3.isEmpty() == false) goto L5;
        return;
    L5:
        if (a(r3) == false) goto L9;
        n.c("Actual provider is of type [" + r3.get(0) + "]");
        return;
    }

    public static c a(String r1) {
        return c().a(r1);
    }

    public static c a(Class<?> r4) {
        c r0 = a(r4.getName());
        if (f40304d == false) goto L9;
        Class<?> r1 = n.a();
        if (r1 == null) goto L9;
        if (a(r4, r1) == false) goto L9;
        n.c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[]{r0.a(), r1.getName()}));
        n.c("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
    L9:
        return r0;
    }

    private static boolean a(Class<?> r0, Class<?> r1) {
        return !r1.isAssignableFrom(r0);
    }

    public static a c() {
        return d().a();
    }

    static org.b.c.b d() {
        if (f40301a == 0) goto L5;
    L14:
        int r0 = f40301a;
        if (r0 == 1) goto L31;
        if (r0 == 2) goto L29;
        if (r0 == 3) goto L27;
        if (r0 != 4) goto L25;
        return f40303c;
    L25:
        throw new IllegalStateException("Unreachable code");
    L27:
        return f40305e;
    L29:
        throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
    L31:
        return f40302b;
    L5:
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f40301a != 0) goto L9;
        f40301a = 1;     // Catch: Throwable -> L11
        e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
        goto L14
    }
}
