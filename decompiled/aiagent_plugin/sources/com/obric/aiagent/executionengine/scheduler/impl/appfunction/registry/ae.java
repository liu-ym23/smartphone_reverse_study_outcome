package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import android.app.Application;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: AppFunctionSkillSourceReader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ae {
    private static final String TAG = "AppFunctionSkillSource";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ae f18213a = null;

    /* JADX INFO: compiled from: AppFunctionSkillSourceReader.kt */
    private interface a {

        /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.ae$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AppFunctionSkillSourceReader.kt */
        public static final class C0379a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f18214a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0379a.class) == true) goto L8;
                return false;
            L8:
                C0379a r6 = (C0379a) ZeusTransformUtils.preCheckCast(r5, C0379a.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f18214a, r6.f18214a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f18214a.hashCode();
            }

            public String toString() {
                return "Content(value=" + this.f18214a + ')';
            }

            public C0379a(String r2) {
                d.h.b.o.e(r2, "value");
                this.f18214a = r2;
            }

            public final String a() {
                return this.f18214a;
            }
        }

        /* JADX INFO: compiled from: AppFunctionSkillSourceReader.kt */
        public static final class b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f18215a = null;

            static {
                f18215a = new b();
            }

            private b() {
            }
        }

        /* JADX INFO: compiled from: AppFunctionSkillSourceReader.kt */
        public static final class c implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f18216a = null;

            static {
                f18216a = new c();
            }

            private c() {
            }
        }
    }

    static {
        f18213a = new ae();
    }

    private ae() {
    }

    public final List<ad> a(List<m> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "entries");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        Object r1 = r9.next();
        String r2 = ((m) ZeusTransformUtils.preCheckCast(r1, m.class, "com.obric.aiagent.plugin")).c();
        Object r3 = r8.get(r2);
        if (r3 != null) goto L8;
        r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r8.put(r2, r3);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin")).add(r1);
        goto L4
    L9:
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r8.entrySet().iterator();
    L11:
        if (r11.hasNext() == false) goto L16;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin");
        List<m> r13 = (List) ZeusTransformUtils.preCheckCast(r4.getValue(), List.class, "com.obric.aiagent.plugin");
        ad r14 = f18213a.a(r12, r13);
        if (r14 == null) goto L11;
        r10.add(r14);
        goto L11
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
    }

    private final ad a(String r6, List<m> r7) {
        List<m> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r8.isEmpty() == false) goto L5;
        return null;
    L5:
        a r0 = a(r6);
        if (d.h.b.o.a(r0, a.c.f18216a) == false) goto L9;
        return b(r6, r8);
    L9:
        if (d.h.b.o.a(r0, a.b.f18215a) == false) goto L12;
        return null;
    L12:
        if (ZeusTransformUtils.instanceOf(r0, a.C0379a.class) == false) goto L20;
        String r3 = b(((a.C0379a) ZeusTransformUtils.preCheckCast(r0, a.C0379a.class, "com.obric.aiagent.plugin")).a());
        if (r3 != null) goto L18;
        ae r5 = (ae) ZeusTransformUtils.preCheckCast(this, ae.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "skip package=" + r6 + ": com.obric.skill markdown has no valid name");
        return null;
    L18:
        return new ad(r6, r8, r3, (ac) ZeusTransformUtils.preCheckCast(new ac.a(((a.C0379a) ZeusTransformUtils.preCheckCast(r0, a.C0379a.class, "com.obric.aiagent.plugin")).a()), ac.class, "com.obric.aiagent.plugin"));
    L20:
        throw new d.k();
    }

    private final ad b(String r9, List<m> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        c r1 = d.f18246a.a(r9);
        if (r1 != null) goto L6;
        ae r8 = (ae) ZeusTransformUtils.preCheckCast(this, ae.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "skip package=" + r9 + ": app metadata unavailable");
        return null;
    L6:
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r1.b(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r6 = null;
    L10:
        if (r6 != null) goto L14;
        ae r12 = (ae) ZeusTransformUtils.preCheckCast(this, ae.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "skip package=" + r9 + ": app metadata has no skill name");
        return null;
    L14:
        return new ad(r9, r11, r6, (ac) ZeusTransformUtils.preCheckCast(new ac.b(r1), ac.class, "com.obric.aiagent.plugin"));
    }

    private final a a(String r8) {
        PackageManager r1 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();
        List<PackageManager.Property> r3 = r1.queryApplicationProperty("com.obric.skill");     // Catch: Exception -> L52
        d.h.b.o.c(r3, "queryApplicationProperty(...)");     // Catch: Exception -> L52
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L52
    L5:
        if (r4.hasNext() == false) goto L9;
        Object r5 = r4.next();     // Catch: Exception -> L52
        if (d.h.b.o.a(((PackageManager.Property) ZeusTransformUtils.preCheckCast(r5, PackageManager.Property.class, "com.obric.aiagent.plugin")).getPackageName(), r8) == false) goto L5;
    L10:
        PackageManager.Property r6 = (PackageManager.Property) ZeusTransformUtils.preCheckCast(r5, PackageManager.Property.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L52
        if (r6 == null) goto L13;
        String r7 = r6.getString();
        if (r7 == null) goto L17;
        String r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L18:
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L21;
    L24:
        boolean r11 = true;
    L26:
        if ((!r11) == true) goto L30;
        r9 = null;
    L30:
        if (r9 != null) goto L61;
        ae r12 = (ae) ZeusTransformUtils.preCheckCast(this, ae.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "skip package=" + r8 + ": com.obric.skill has no asset name");
        return (a) ZeusTransformUtils.preCheckCast(a.b.f18215a, a.class, "com.obric.aiagent.plugin");
    L61:
        Resources r13 = r1.getResourcesForApplication(r8);     // Catch: Exception -> L49
        d.h.b.o.c(r13, "getResourcesForApplication(...)");     // Catch: Exception -> L49
        InputStream r14 = r13.getAssets().open(r9);     // Catch: Exception -> L49
        d.h.b.o.c(r14, "open(...)");     // Catch: Exception -> L49
        Charset r2 = StandardCharsets.UTF_8;     // Catch: Exception -> L49
        d.h.b.o.c(r2, "UTF_8");     // Catch: Exception -> L49
        Reader r15 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r14, r2), Reader.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49
        if (ZeusTransformUtils.instanceOf(r15, BufferedReader.class) == false) goto L36;
        BufferedReader r16 = (BufferedReader) ZeusTransformUtils.preCheckCast(r15, BufferedReader.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49
    L37:
        Closeable r17 = (Closeable) ZeusTransformUtils.preCheckCast(r16, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49
        String r18 = d.f.t.a((Reader) ZeusTransformUtils.preCheckCast((BufferedReader) ZeusTransformUtils.preCheckCast(r17, BufferedReader.class, "com.obric.aiagent.plugin"), Reader.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L44
        d.f.c.a(r17, null);     // Catch: Exception -> L49
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L42;
        ILogDepend.Companion.w(TAG, "skip package=" + r8 + ": assets/" + r9 + " is empty");     // Catch: Exception -> L49
        return (a) ZeusTransformUtils.preCheckCast(a.b.f18215a, a.class, "com.obric.aiagent.plugin");
    L42:
        ILogDepend.Companion.i(TAG, "read package=" + r8 + " skill markdown from assets/" + r9);     // Catch: Exception -> L49
        return (a) ZeusTransformUtils.preCheckCast(new a.C0379a(r18), a.class, "com.obric.aiagent.plugin");
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        d.f.c.a(r17, th);     // Catch: Exception -> L49
        throw th;     // Catch: Exception -> L49
    L36:
        r16 = new BufferedReader(r15, 8192);     // Catch: Exception -> L49
    L49:
        e = move-exception;
        ILogDepend.Companion.w(TAG, "skip package=" + r8 + ": read assets/" + r9 + " failed: " + e.getMessage());
        return (a) ZeusTransformUtils.preCheckCast(a.b.f18215a, a.class, "com.obric.aiagent.plugin");
    L21:
        if (r10.length() == 0) goto L24;
        r11 = false;
        goto L26
    L17:
        r9 = null;
        goto L18
    L13:
        return (a) ZeusTransformUtils.preCheckCast(a.c.f18216a, a.class, "com.obric.aiagent.plugin");
    L9:
        r5 = null;
    L52:
        e = move-exception;
        ILogDepend.Companion.w(TAG, "query com.obric.skill failed for " + r8 + ": " + e.getMessage());
        return (a) ZeusTransformUtils.preCheckCast(a.c.f18216a, a.class, "com.obric.aiagent.plugin");
    }

    private final String b(String r13) {
        List<String> r12 = d.o.o.g((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.b(d.o.o.a(d.o.o.a(r13, "\r\n", "\n", false, 4, null), '\r', '\n', false, 4, null), new char[]{65279, '\n'}), CharSequence.class, "com.obric.aiagent.plugin"));
        String r14 = (String) ZeusTransformUtils.preCheckCast(d.a.p.l(r12), String.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L5;
        String r15 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L7:
        if (d.h.b.o.a(r15, "---") == true) goto L9;
        return null;
    L9:
        Iterator r16 = d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"), 1).iterator();
        int r5 = 0;
    L11:
        if (r16.hasNext() == false) goto L26;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin");
        Character r7 = d.o.o.i((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r7 != null) goto L15;
    L17:
        boolean r8 = false;
    L18:
        if (r8 == false) goto L20;
    L22:
        boolean r9 = false;
    L23:
        if (r9 == true) goto L27;
        r5 = r5 + 1;
    L27:
        if (r5 >= 0) goto L29;
        return null;
    L29:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r12.subList(1, r5 + 1), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L31:
        if (r17.hasNext() == false) goto L57;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin");
        Character r2 = d.o.o.i((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r2 != null) goto L35;
    L37:
        boolean r3 = false;
    L38:
        if (r3 == false) goto L40;
    L39:
        String r19 = null;
    L47:
        if (r19 == null) goto L31;
        return r19;
    L40:
        int r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"), ':', 0, false, 6, null);
        if (r4 <= 0) goto L39;
        String r10 = r18.substring(0, r4);
        d.h.b.o.c(r10, "substring(...)");
        String r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).toString().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r11, "toLowerCase(...)");
        if (d.h.b.o.a(r11, "name") == false) goto L39;
        ae r20 = f18213a;
        String r110 = r18.substring(r4 + 1);
        d.h.b.o.c(r110, "substring(...)");
        r19 = r20.c(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.aiagent.plugin")).toString());
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L39;
    L35:
        if (d.o.a.a(r2.charValue()) != true) goto L37;
        r3 = true;
        goto L38
    L57:
        return null;
    L20:
        if (d.h.b.o.a(d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString(), "---") == false) goto L22;
        r9 = true;
        goto L23
    L15:
        if (d.o.a.a(r7.charValue()) != true) goto L17;
        r8 = true;
        goto L18
    L26:
        r5 = -1;
        goto L27
    L5:
        r15 = null;
        goto L7
    }

    private final String c(String r10) {
        if (r10.length() < 2) goto L11;
        if (d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) != '\'') goto L11;
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) != '\'') goto L11;
        String r3 = r10.substring(1, d.o.o.e((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")));
        d.h.b.o.c(r3, "substring(...)");
        return d.o.o.a(r3, "''", "'", false, 4, null);
    L11:
        if (r10.length() < 2) goto L19;
        if (d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) != '\"') goto L19;
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) != '\"') goto L19;
        String r11 = r10.substring(1, d.o.o.e((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")));
        d.h.b.o.c(r11, "substring(...)");
        return d(r11);
    L19:
        return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r10, " #", null, 2, null), CharSequence.class, "com.obric.aiagent.plugin")).toString();
    }

    private final String d(String r6) {
        StringBuilder r5 = new StringBuilder();
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= r7.length()) goto L22;
        char r3 = r7.charAt(r1);
        if (r2 == true) goto L8;
        if (r3 != '\\') goto L20;
        r2 = true;
    L21:
        r1 = r1 + 1;
        goto L4
    L20:
        r5.append(r3);
        goto L21
    L8:
        if (r3 != 'n') goto L10;
        r3 = '\n';
    L17:
        r5.append(r3);
        r2 = false;
        goto L21
    L10:
        if (r3 != 'r') goto L12;
        r3 = '\r';
        goto L17
    L12:
        if (r3 != 't') goto L17;
        r3 = '\t';
        goto L17
    L22:
        if (r2 == false) goto L24;
        r5.append('\\');
    L24:
        String r8 = r5.toString();
        d.h.b.o.c(r8, "toString(...)");
        return r8;
    }
}
