package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* JADX INFO: compiled from: FastServiceLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f39412a = null;

    static {
        f39412a = new q();
    }

    private q() {
    }

    public final List<MainDispatcherFactory> a() {
        if (r.a() == false) goto L5;
        ArrayList r2 = new ArrayList(2);     // Catch: Throwable -> L20
        MainDispatcherFactory r4 = null;
        MainDispatcherFactory r3 = (MainDispatcherFactory) ZeusTransformUtils.preCheckCast(MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0])), MainDispatcherFactory.class, "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L10 Throwable -> L20
    L11:
        if (r3 == null) goto L23;
        r2.add(r3);     // Catch: Throwable -> L20
    L23:
        r4 = (MainDispatcherFactory) ZeusTransformUtils.preCheckCast(MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0])), MainDispatcherFactory.class, "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L22 Throwable -> L20
    L16:
        if (r4 == null) goto L18;
        r2.add(r4);     // Catch: Throwable -> L20
    L18:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    L10:
        r3 = null;
    L21:
        return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
    L5:
        return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
    }

    private final <S> List<S> b(Class<S> r1, ClassLoader r2) {
        return a(r1, r2);
    L5:
        return d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(ServiceLoader.load(r1, r2), Iterable.class, "com.obric.aiagent.plugin"));
    }

    public final <S> List<S> a(Class<S> r5, ClassLoader r6) {
        ArrayList r4 = Collections.list(r6.getResources("META-INF/services/" + r5.getName()));
        d.h.b.o.c(r4, "list(...)");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        d.a.p.a(r0, (Iterable) ZeusTransformUtils.preCheckCast(f39412a.a((URL) ZeusTransformUtils.preCheckCast(r8.next(), URL.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        Set r9 = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L15;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L13;
        r1.add(f39412a.a((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin"), r6, r5));
        goto L10
    L13:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L15:
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }

    private final <S> S a(String r1, ClassLoader r2, Class<S> r3) {
        Class<?> r4 = Class.forName(r1, false, r2);
        if (r3.isAssignableFrom(r4) == false) goto L7;
        return r3.cast(r4.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    L7:
        throw new IllegalArgumentException(("Expected service of class " + r3 + ", but found " + r4).toString());
    }

    private final List<String> a(URL r6) {
        String r5 = r6.toString();
        if (d.o.o.b(r5, "jar", false, 2, null) == false) goto L25;
        String r7 = d.o.o.a(d.o.o.b(r5, "jar:file:", null, 2, null), '!', null, 2, null);
        String r8 = d.o.o.b(r5, "!/", null, 2, null);
        JarFile r0 = new JarFile(r7, false);
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r0.getInputStream(new ZipEntry(r8)), "UTF-8"), Reader.class, "com.obric.aiagent.plugin")), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        BufferedReader r10 = (BufferedReader) ZeusTransformUtils.preCheckCast(r9, BufferedReader.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        List<String> r11 = f39412a.a(r10);     // Catch: Throwable -> L12
        d.f.c.a(r9, null);     // Catch: Throwable -> L17
        r0.close();     // Catch: Throwable -> L10
        return r11;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        d.f.c.a(r9, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L22
        throw th;
    L22:
        th = move-exception;
        d.a.a(th, th);
        throw th;
    L25:
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r6.openStream()), Reader.class, "com.obric.aiagent.plugin")), Closeable.class, "com.obric.aiagent.plugin");
        BufferedReader r13 = (BufferedReader) ZeusTransformUtils.preCheckCast(r12, BufferedReader.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        List<String> r14 = f39412a.a(r13);     // Catch: Throwable -> L29
        d.f.c.a(r12, null);
        return r14;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        d.f.c.a(r12, th);
        throw th;
    }

    private final List<String> a(BufferedReader r9) {
        Set r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
    L3:
        String r0 = r9.readLine();
        if (r0 == null) goto L6;
        String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r0, "#", null, 2, null), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        int r4 = 0;
    L9:
        if (r4 >= r2.length()) goto L20;
        char r5 = r2.charAt(r4);
        if (r5 != '.') goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L18;
        r4 = r4 + 1;
        goto L9
    L18:
        boolean r7 = false;
    L21:
        if (r7 == false) goto L28;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L25;
        r3 = true;
    L25:
        if (r3 == false) goto L3;
        r8.add(r1);
        goto L3
    L28:
        throw new IllegalArgumentException(("Illegal service provider class name: " + r1).toString());
    L13:
        if (Character.isJavaIdentifierPart(r5) == true) goto L16;
        r6 = false;
        goto L17
    L20:
        r7 = true;
        goto L21
    L6:
        return d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin"));
    }
}
