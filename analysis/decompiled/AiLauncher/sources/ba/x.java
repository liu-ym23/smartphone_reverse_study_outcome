package ba;

import Z8.F;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes5.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f15368a = new x();

    public static final CharSequence l(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return f15368a.c(it);
    }

    public final String[] b(String... signatures) {
        kotlin.jvm.internal.p.i(signatures, "signatures");
        ArrayList arrayList = new ArrayList(signatures.length);
        for (String str : signatures) {
            arrayList.add("<init>(" + str + ")V");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final String c(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return 'L' + str + ';';
    }

    public final Set<String> d(String internalName, String... signatures) {
        kotlin.jvm.internal.p.i(internalName, "internalName");
        kotlin.jvm.internal.p.i(signatures, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : signatures) {
            linkedHashSet.add(internalName + '.' + str);
        }
        return linkedHashSet;
    }

    public final Set<String> e(String name, String... signatures) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(signatures, "signatures");
        return d(h(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public final Set<String> f(String name, String... signatures) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(signatures, "signatures");
        return d(i(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public final String g(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return "java/util/function/" + name;
    }

    public final String h(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return "java/lang/" + name;
    }

    public final String i(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return "java/util/" + name;
    }

    public final String j(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return "java/util/concurrent/atomic/" + name;
    }

    public final String k(String name, List<String> parameters, String ret) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(parameters, "parameters");
        kotlin.jvm.internal.p.i(ret, "ret");
        return name + '(' + F.A0(parameters, "", null, null, 0, null, w.f15367a, 30, null) + ')' + c(ret);
    }

    public final String m(String internalName, String jvmDescriptor) {
        kotlin.jvm.internal.p.i(internalName, "internalName");
        kotlin.jvm.internal.p.i(jvmDescriptor, "jvmDescriptor");
        return internalName + '.' + jvmDescriptor;
    }
}
