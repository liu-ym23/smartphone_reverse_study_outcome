package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: AppFunction16Compact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "AppFunction16Compact";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18187a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppFunction16Compact.kt */
    private static final class C0378a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18189b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0378a.class) == true) goto L8;
            return false;
        L8:
            C0378a r6 = (C0378a) ZeusTransformUtils.preCheckCast(r5, C0378a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f18188a, r6.f18188a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f18189b, r6.f18189b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f18188a.hashCode() * 31) + this.f18189b.hashCode();
        }

        public String toString() {
            return "EntryKey(packageName=" + this.f18188a + ", functionId=" + this.f18189b + ')';
        }

        public C0378a(String r2, String r3) {
            d.h.b.o.e(r2, "packageName");
            d.h.b.o.e(r3, "functionId");
            this.f18188a = r2;
            this.f18189b = r3;
        }
    }

    /* JADX INFO: compiled from: AppFunction16Compact.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JsonObject f18191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<String, String> f18192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final h f18193d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final i f18194e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f18190a, r6.f18190a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f18191b, r6.f18191b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f18192c, r6.f18192c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f18193d, r6.f18193d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f18194e, r6.f18194e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            String r0 = this.f18190a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            JsonObject r4 = this.f18191b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((((r3 + r5) * 31) + this.f18192c.hashCode()) * 31) + this.f18193d.hashCode()) * 31;
            i r7 = this.f18194e;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "XmlMetadata(description=" + this.f18190a + ", parametersSchema=" + this.f18191b + ", obricParameterTypes=" + this.f18192c + ", components=" + this.f18193d + ", returnSchema=" + this.f18194e + ')';
        }

        public b(String r3, JsonObject r4, Map<String, String> r5, h r6, i r7) {
            Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r8, "obricParameterTypes");
            d.h.b.o.e(r6, "components");
            this.f18190a = r3;
            this.f18191b = r4;
            this.f18192c = r8;
            this.f18193d = r6;
            this.f18194e = r7;
        }

        public final String a() {
            return this.f18190a;
        }

        public final JsonObject b() {
            return this.f18191b;
        }

        public final Map<String, String> c() {
            return this.f18192c;
        }

        public final h d() {
            return this.f18193d;
        }

        public final i e() {
            return this.f18194e;
        }
    }

    /* JADX INFO: compiled from: AppFunction16Compact.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<c> f18196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final StringBuilder f18197c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f18195a, r6.f18195a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f18196b, r6.f18196b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f18197c, r6.f18197c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f18195a.hashCode() * 31) + this.f18196b.hashCode()) * 31) + this.f18197c.hashCode();
        }

        public String toString() {
            return "XmlNode(name=" + this.f18195a + ", children=" + this.f18196b + ", text=" + this.f18197c + ')';
        }

        public c(String r3, List<c> r4, StringBuilder r5) {
            List<c> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "name");
            d.h.b.o.e(r6, "children");
            d.h.b.o.e(r5, "text");
            this.f18195a = r3;
            this.f18196b = r6;
            this.f18197c = r5;
        }

        public /* synthetic */ c(String r2, List r3, StringBuilder r4, int r5, d.h.b.h r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            if ((r5 & 2) == 0) goto L6;
            r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = new StringBuilder();
        L8:
            this(r2, r7, r4);
        }

        public final List<c> a() {
            return this.f18196b;
        }

        public final StringBuilder b() {
            return this.f18197c;
        }

        public final c a(String r5) {
            d.h.b.o.e(r5, "name");
            Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f18196b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r4.hasNext() == false) goto L8;
            Object r1 = r4.next();
            if (d.h.b.o.a(((c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin")).f18195a, r5) == false) goto L4;
        L10:
            return (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        L8:
            r1 = null;
            goto L10
        }

        public final List<c> b(String r5) {
            d.h.b.o.e(r5, "name");
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f18196b, Iterable.class, "com.obric.aiagent.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r6 = r4.iterator();
        L4:
            if (r6.hasNext() == false) goto L9;
            Object r2 = r6.next();
            if (d.h.b.o.a(((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin")).f18195a, r5) == false) goto L4;
            r0.add(r2);
            goto L4
        L9:
            return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        }

        public final String c(String r2) {
            d.h.b.o.e(r2, "name");
            c r1 = a(r2);
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.c();
        }

        public final String c() {
            String r2 = this.f18197c.toString();
            d.h.b.o.c(r2, "toString(...)");
            String r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L10;
            return null;
        L10:
            return r3;
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: AppFunction16Compact.kt */
    /* synthetic */ class d extends d.h.b.l implements d.h.a.b<String, String> {
        d(Object r8) {
            super(1, r8, a.class, "normalizeAssetName", "normalizeAssetName(Ljava/lang/String;)Ljava/lang/String;", 0);
        }

        public final String a(String r3) {
            d.h.b.o.e(r3, "p0");
            return a.a((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ String invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f18187a = new a();
    }

    public static /* synthetic */ boolean lambda$KMygEZi4BIIcJpoahCn1qUX58sQ(String r0) {
        return d(r0);
    }

    public static /* synthetic */ String lambda$PHDJgkqfMzAECeYf74ki98xhvnc(PackageManager.Property r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$W4q5Vt0h4XqrXSSNJoPubFtEfDA(String r0, PackageManager.Property r1) {
        return a(r0, r1);
    }

    private a() {
    }

    public static final /* synthetic */ String a(a r0, String r1) {
        return r0.a(r1);
    }

    public final List<m> a(List<m> r19) {
        List<m> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "entries");
        if (Build.VERSION.SDK_INT == 36) goto L5;
        return r0;
    L5:
        if (r0.isEmpty() == true) goto L57;
        d.n.j r2 = d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"));
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.a();
    L9:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        String r6 = ((m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin")).c();
        Object r7 = r3.get(r6);
        if (r7 != null) goto L13;
        r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r3.put(r6, r7);
    L13:
        ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin")).add(r5);
        goto L9
    L14:
        HashMap r8 = new HashMap();
        Iterator r9 = r3.entrySet().iterator();
    L16:
        if (r9.hasNext() == false) goto L26;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.aiagent.plugin");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10.getValue(), List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new HashSet(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L19:
        if (r14.hasNext() == false) goto L21;
        r13.add(((m) ZeusTransformUtils.preCheckCast(r14.next(), m.class, "com.obric.aiagent.plugin")).d());
        goto L19
    L21:
        HashSet r15 = (HashSet) ZeusTransformUtils.preCheckCast(r13, HashSet.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<String, b>> r16 = f18187a.a(r11, (Set) ZeusTransformUtils.preCheckCast(r15, Set.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L23:
        if (r16.hasNext() == false) goto L16;
        Map.Entry r17 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.getKey(), String.class, "com.obric.aiagent.plugin");
        b r20 = (b) ZeusTransformUtils.preCheckCast(r17.getValue(), b.class, "com.obric.aiagent.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin")).put(new C0378a(r11, r18), r20);
        goto L23
    L26:
        if (r8.isEmpty() == false) goto L28;
        return r0;
    L28:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r22 = r1.iterator();
    L30:
        if (r22.hasNext() == false) goto L46;
        m r23 = (m) ZeusTransformUtils.preCheckCast(r22.next(), m.class, "com.obric.aiagent.plugin");
        b r24 = (b) ZeusTransformUtils.preCheckCast(r8.get(new C0378a(r23.c(), r23.d())), b.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L44;
        String r110 = r23.f();
        if (r110 != null) goto L37;
        r110 = r24.a();
    L37:
        JsonObject r111 = r24.b();
        if (r111 != null) goto L40;
        r111 = r23.g();
    L40:
        Map r112 = ao.a(r24.c(), r23.h());
        h r113 = new h(ao.a(r23.i().a(), r24.d().a()));
        i r25 = r24.e();
        if (r25 != null) goto L43;
        r25 = r23.j();
    L43:
        r23 = m.a(r23, null, null, null, null, null, r110, r111, r112, r113, r25, 31, null);
    L44:
        r21.add(r23);
        goto L30
    L46:
        return (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin");
    L57:
        return r0;
    }

    private final Map<String, b> a(final String r12, Set<String> r13) {
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin");
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L25
        a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        Application r3 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        List<PackageManager.Property> r4 = r3.getPackageManager().queryServiceProperty("android.app.appfunctions.v2");     // Catch: Throwable -> L25
        d.h.b.o.c(r4, "queryServiceProperty(...)");     // Catch: Throwable -> L25
        List r5 = d.n.m.g(d.n.m.j(d.n.m.a(d.n.m.d(d.n.m.e(d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")), new $$Lambda$a$W4q5Vt0h4XqrXSSNJoPubFtEfDA(r12)), $$Lambda$a$PHDJgkqfMzAECeYf74ki98xhvnc.INSTANCE), (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r11), d.h.a.b.class, "com.obric.aiagent.plugin")), $$Lambda$a$KMygEZi4BIIcJpoahCn1qUX58sQ.INSTANCE)));     // Catch: Throwable -> L25
        if (r5.isEmpty() == false) goto L7;
        ILogDepend.Companion.w(TAG, "no android.app.appfunctions.v2 property for " + r12);     // Catch: Throwable -> L25
        return ao.b();
    L7:
        ApplicationInfo r6 = r3.getPackageManager().getApplicationInfo(r12, 0);     // Catch: Throwable -> L25
        d.h.b.o.c(r6, "getApplicationInfo(...)");     // Catch: Throwable -> L25
        List r7 = d.a.p.a();     // Catch: Throwable -> L25
        r7.add(r6.sourceDir);     // Catch: Throwable -> L25
        String[] r8 = r6.splitSourceDirs;     // Catch: Throwable -> L25
        if (r8 == null) goto L10;
        d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin"), r8);     // Catch: Throwable -> L25
    L10:
        List<String> r9 = d.a.p.a(r7);     // Catch: Throwable -> L25
        HashMap r10 = new HashMap();     // Catch: Throwable -> L25
        Iterator r15 = r5.iterator();     // Catch: Throwable -> L25
    L12:
        if (r15.hasNext() == false) goto L23;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L16
        Set r18 = r10.keySet();     // Catch: Throwable -> L16
        d.h.b.o.c(r18, "<get-keys>(...)");     // Catch: Throwable -> L16
        r10.putAll(r11.a(r9, r16, ax.a(r14, (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L16
        Object r19 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L16
    L18:
        Throwable r20 = d.n.c(r19);     // Catch: Throwable -> L25
        if (r20 == null) goto L22;
        ILogDepend.Companion.w(TAG, "read " + r12 + "/assets/" + r16 + " failed: " + r20.getMessage());     // Catch: Throwable -> L25
    L22:
        if (r10.keySet().containsAll((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")) == false) goto L12;
    L16:
        th = move-exception;
        d.n.a r21 = d.n.f38560a;     // Catch: Throwable -> L25
        r19 = d.n.f(d.o.a(th));     // Catch: Throwable -> L25
    L23:
        Object r110 = d.n.f(r10);     // Catch: Throwable -> L25
    L27:
        Throwable r111 = d.n.c(r110);
        if (r111 == null) goto L32;
        ILogDepend.Companion.w(TAG, "load metadata for " + r12 + " failed: " + r111.getMessage());
        r110 = ao.b();
    L32:
        return (Map) ZeusTransformUtils.preCheckCast(r110, Map.class, "com.obric.aiagent.plugin");
    L25:
        th = move-exception;
        d.n.a r112 = d.n.f38560a;
        r110 = d.n.f(d.o.a(th));
        goto L27
    }

    private static final boolean a(String r0, PackageManager.Property r1) {
        return d.h.b.o.a(r1.getPackageName(), r0);
    }

    private static final String a(PackageManager.Property r0) {
        return r0.getString();
    }

    private static final boolean d(String r2) {
        d.h.b.o.e(r2, "it");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final String a(String r3) {
        return d.o.o.a(d.o.o.a(r3, (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.aiagent.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast("assets/", CharSequence.class, "com.obric.aiagent.plugin"));
    }

    private final Map<String, b> a(List<String> r5, String r6, Set<String> r7) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        String r9 = "assets/" + r6;
        Iterator r10 = r4.iterator();
    L4:
        if (r10.hasNext() == false) goto L26;
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipFile((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin")), Closeable.class, "com.obric.aiagent.plugin");
        ZipFile r1 = (ZipFile) ZeusTransformUtils.preCheckCast(r11, ZipFile.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        ZipEntry r2 = r1.getEntry(r9);     // Catch: Throwable -> L20
        if (r2 != null) goto L10;
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L20
        d.f.c.a(r11, null);
        goto L4
    L10:
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r1.getInputStream(r2), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        InputStream r13 = (InputStream) ZeusTransformUtils.preCheckCast(r12, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        a r0 = f18187a;     // Catch: Throwable -> L15
        d.h.b.o.a(r13);     // Catch: Throwable -> L15
        Map<String, b> r14 = r0.a(r13, r8);     // Catch: Throwable -> L15
        d.f.c.a(r12, null);     // Catch: Throwable -> L20
        d.f.c.a(r11, null);
        return r14;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        d.f.c.a(r12, th);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        d.f.c.a(r11, th);
        throw th;
    L26:
        throw new IllegalStateException(r9 + " not found in package APKs");
    }

    private final Map<String, b> a(InputStream r12, Set<String> r13) {
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin");
        if (r14.isEmpty() == true) goto L5;
        c r15 = a(r12);
        if (r15 == null) goto L9;
        h r11 = a(r15);
        HashMap r0 = new HashMap();
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15.b("appfunction"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r16.hasNext() == false) goto L22;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r16.next(), c.class, "com.obric.aiagent.plugin");
        String r3 = r2.c("functionid");
        if (r3 != null) goto L18;
        r3 = r2.c(DbHelper.COL_ID);
        if (r3 == null) goto L12;
    L18:
        String r8 = r3;
        if (r14.contains(r8) == false) goto L12;
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
        String r4 = r2.c("description");
        a r5 = f18187a;
        r9.put(r8, new b(r4, r5.b(r2.b("parameters")), r5.c(r2.b("parameters")), r11, r5.c(r2)));
        goto L12
    L22:
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
    L9:
        return ao.b();
    L5:
        return ao.b();
    }

    private final h a(c r6) {
        c r5 = r6.a("appfunctioncomponentmetadatadocument");
        if (r5 == null) goto L5;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5.b("datatypes"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L22;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r8.next(), c.class, "com.obric.aiagent.plugin");
        String r3 = r2.c("name");
        if (r3 != null) goto L12;
    L11:
        d.m r4 = null;
    L19:
        if (r4 == null) goto L8;
        r0.add(r4);
        goto L8
    L12:
        c r9 = r2.a("datatypemetadata");
        if (r9 == null) goto L11;
        i r10 = f18187a.d(r9);
        if (r10 == null) goto L11;
        r4 = d.s.a(r3, r10);
        goto L19
    L22:
        return new h(ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")));
    L5:
        return new h(null, 1, null);
    }

    private final JsonObject b(List<c> r9) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if (r8.isEmpty() == false) goto L6;
        return null;
    L6:
        JsonObject r10 = new JsonObject();
        JsonArray r1 = new JsonArray();
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r11.hasNext() == false) goto L27;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r11.next(), c.class, "com.obric.aiagent.plugin");
        String r3 = r2.c("name");
        if (r3 == null) goto L8;
        c r4 = r2.a("datatypemetadata");
        if (r4 == null) goto L8;
        a r5 = f18187a;
        if (r5.b(r4) != null) goto L8;
        r10.add(r3, (JsonElement) ZeusTransformUtils.preCheckCast(r5.a(r4, r2.c("description")), JsonElement.class, "com.obric.aiagent.plugin"));
        String r6 = r2.c("isrequired");
        boolean r7 = false;
        if (r6 == null) goto L20;
        boolean r12 = d.h.b.o.a(d.o.o.f(r6), true);
    L21:
        String r13 = r4.c("isnullable");
        if (r13 == null) goto L24;
        r7 = d.h.b.o.a(d.o.o.f(r13), true);
    L24:
        if (r12 == true) goto L26;
        if (r7 == true) goto L8;
    L26:
        r1.add(r3);
        goto L8
    L20:
        r12 = false;
        goto L21
    L27:
        JsonObject r14 = new JsonObject();
        r14.addProperty("type", "object");
        r14.add("properties", (JsonElement) ZeusTransformUtils.preCheckCast(r10, JsonElement.class, "com.obric.aiagent.plugin"));
        r14.add("required", (JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.aiagent.plugin"));
        return r14;
    }

    private final Map<String, String> c(List<c> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Map r6 = ao.a();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L16;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r7.next(), c.class, "com.obric.aiagent.plugin");
        String r2 = r1.c("name");
        if (r2 == null) goto L4;
        c r3 = r1.a("datatypemetadata");
        if (r3 == null) goto L4;
        String r8 = f18187a.b(r3);
        if (r8 == null) goto L4;
        r6.put(r2, r8);
        goto L4
    L16:
        return ao.a(r6);
    }

    private final String b(c r4) {
        String r3 = r4.c("type");
        if (r3 == null) goto L5;
        Integer r5 = d.o.o.d(r3);
    L7:
        if (r5 == null) goto L12;
        if (r5.intValue() != 3) goto L12;
    L29:
        String r6 = r4.c("objectqualifiedname");
    L30:
        if (r6 != null) goto L32;
        return null;
    L32:
        if (d.a.i.b(n.a(), r6) == true) goto L34;
        return null;
    L34:
        return r6;
    L12:
        if (r5 == null) goto L17;
        if (r5.intValue() == 12) goto L29;
    L17:
        if (r5 == null) goto L23;
        if (r5.intValue() == 14) goto L29;
    L23:
        if (r5 != null) goto L26;
    L28:
        r6 = null;
        goto L30
    L26:
        if (r5.intValue() != 11) goto L28;
        r6 = r4.c("datatypereference");
        goto L30
    L5:
        r5 = null;
        goto L7
    }

    static /* synthetic */ JsonObject a(a r0, c r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2);
    }

    private final JsonObject a(c r14, String r15) {
        String r1 = r14.c("type");
        if (r1 == null) goto L5;
        Integer r2 = d.o.o.d(r1);
    L7:
        if (r2 == null) goto L13;
        if (r2.intValue() != 1) goto L13;
        JsonObject r13 = b(WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE);
    L95:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r14.b("enumvalues"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L97:
        if (r17.hasNext() == false) goto L101;
        String r3 = ((c) ZeusTransformUtils.preCheckCast(r17.next(), c.class, "com.obric.aiagent.plugin")).c();
        if (r3 == null) goto L97;
        r0.add(r3);
        goto L97
    L101:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L108;
        JsonArray r4 = new JsonArray();
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L105:
        if (r19.hasNext() == false) goto L107;
        r4.add((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.aiagent.plugin"));
        goto L105
    L107:
        d.x r110 = d.x.f38692a;
        r13.add("enum", (JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"));
    L108:
        if (r15 != null) goto L110;
    L115:
        return r13;
    L110:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L113;
        r15 = null;
    L113:
        if (r15 == null) goto L115;
        r13.addProperty("description", r15);
    L13:
        if (r2 == null) goto L18;
        if (r2.intValue() != 2) goto L18;
    L94:
        r13 = b(WsChannelMultiProcessSharedProvider.STRING_TYPE);
    L18:
        if (r2 == null) goto L24;
        if (r2.intValue() == 8) goto L94;
    L24:
        if (r2 == null) goto L29;
        if (r2.intValue() != 4) goto L29;
    L93:
        r13 = b("number");
    L29:
        if (r2 == null) goto L35;
        if (r2.intValue() == 5) goto L93;
    L35:
        if (r2 == null) goto L40;
        if (r2.intValue() != 6) goto L40;
    L92:
        r13 = b(WsChannelMultiProcessSharedProvider.INT_TYPE);
    L40:
        if (r2 == null) goto L46;
        if (r2.intValue() == 7) goto L92;
    L46:
        if (r2 == null) goto L61;
        if (r2.intValue() != 10) goto L61;
        r13 = new JsonObject();
        r13.addProperty("type", "array");
        c r5 = r14.a("itemtype");
        if (r5 == null) goto L54;
        c r6 = r5.a("datatypemetadata");
        if (r6 == null) goto L54;
    L55:
        if (r6 == null) goto L58;
        JsonObject r7 = a(f18187a, r6, null, 2, null);
        if (r7 == null) goto L58;
    L59:
        r13.add("items", (JsonElement) ZeusTransformUtils.preCheckCast(r7, JsonElement.class, "com.obric.aiagent.plugin"));
    L58:
        r7 = new JsonObject();
    L54:
        r6 = r14.a("itemtype");
    L61:
        if (r2 == null) goto L86;
        if (r2.intValue() != 3) goto L86;
        r13 = new JsonObject();
        r13.addProperty("type", "object");
        JsonObject r8 = new JsonObject();
        JsonArray r9 = new JsonArray();
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r14.b("properties"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L67:
        if (r10.hasNext() == false) goto L84;
        c r11 = (c) ZeusTransformUtils.preCheckCast(r10.next(), c.class, "com.obric.aiagent.plugin");
        String r12 = r11.c("name");
        if (r12 == null) goto L67;
        c r111 = r11.a("datatypemetadata");
        if (r111 == null) goto L75;
        JsonObject r20 = f18187a.a(r111, r11.c("description"));
        if (r20 == null) goto L75;
    L76:
        r8.add(r12, (JsonElement) ZeusTransformUtils.preCheckCast(r20, JsonElement.class, "com.obric.aiagent.plugin"));
        if (r111 == null) goto L67;
        String r21 = r111.c("isnullable");
        if (r21 == null) goto L81;
        boolean r22 = d.h.b.o.a(d.o.o.f(r21), true);
    L82:
        if (r22 == true) goto L67;
        r9.add(r12);
        goto L67
    L81:
        r22 = false;
    L75:
        r20 = new JsonObject();
        goto L76
    L84:
        r13.add("properties", (JsonElement) ZeusTransformUtils.preCheckCast(r8, JsonElement.class, "com.obric.aiagent.plugin"));
        r13.add("required", (JsonElement) ZeusTransformUtils.preCheckCast(r9, JsonElement.class, "com.obric.aiagent.plugin"));
    L86:
        if (r2 != null) goto L89;
    L91:
        r13 = new JsonObject();
        goto L95
    L89:
        if (r2.intValue() != 11) goto L91;
        r13 = b("object");
        goto L95
    L5:
        r2 = null;
        goto L7
    }

    private final JsonObject b(String r2) {
        JsonObject r1 = new JsonObject();
        r1.addProperty("type", r2);
        return r1;
    }

    private final i c(c r2) {
        c r3 = r2.a("response");
        if (r3 == null) goto L9;
        c r4 = r3.a("valuetype");
        if (r4 != null) goto L8;
        return null;
    L8:
        return d(r4);
    L9:
        return null;
    }

    private final i d(c r12) {
        String r0 = r12.c("isnullable");
        if (r0 == null) goto L5;
        boolean r1 = d.h.b.o.a(d.o.o.f(r0), true);
    L6:
        boolean r6 = r1;
        String r2 = r12.c("description");
        String r3 = "";
        if (r2 != null) goto L9;
        String r7 = "";
    L10:
        String r4 = r12.c("type");
        if (r4 == null) goto L15;
        Integer r5 = d.o.o.d(r4);
        if (r5 == null) goto L15;
        int r8 = r5.intValue();
    L16:
        Collection r9 = null;
        t r10 = null;
        String r11 = null;
        e r13 = null;
        r13 = null;
        r13 = null;
        Collection r14 = null;
        switch(r8) {
            case 0: goto L130;
            case 1: goto L179;
            case 2: goto L178;
            case 3: goto L105;
            case 4: goto L176;
            case 5: goto L175;
            case 6: goto L174;
            case 7: goto L88;
            case 8: goto L77;
            case 9: goto L180;
            case 10: goto L66;
            case 11: goto L61;
            case 12: goto L46;
            case 13: goto L37;
            case 14: goto L19;
            default: goto L180;
        };
    L19:
        String r15 = r12.c("objectqualifiedname");
        if (r15 == null) goto L167;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r12.b("oneof"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r16, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L23:
        if (r18.hasNext() == false) goto L29;
        c r19 = (c) ZeusTransformUtils.preCheckCast(r18.next(), c.class, "com.obric.aiagent.plugin");
        c r20 = r19.a("datatypemetadata");
        if (r20 == null) goto L28;
        r19 = r20;
    L28:
        r17.add(r19);
        goto L23
    L29:
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        a r21 = f18187a;
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r111 = r110.iterator();
    L31:
        if (r111.hasNext() == false) goto L35;
        i r23 = r21.d((c) ZeusTransformUtils.preCheckCast(r111.next(), c.class, "com.obric.aiagent.plugin"));
        if (r23 == null) goto L31;
        r22.add(r23);
        goto L31
    L35:
        r10 = new t((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.aiagent.plugin"), r15, r6, r7);
    L167:
        return (i) ZeusTransformUtils.preCheckCast(r10, i.class, "com.obric.aiagent.plugin");
    L37:
        String r112 = r12.c("objectqualifiedname");
        if (r112 != null) goto L40;
    L44:
        r11 = "android.app.PendingIntent";
    L168:
        return (i) ZeusTransformUtils.preCheckCast(new u(r11, r6, r7), i.class, "com.obric.aiagent.plugin");
    L40:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r112, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L42;
        r11 = r112;
    L42:
        if (r11 == null) goto L44;
    L46:
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r12.b("allof"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r24, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r26 = r24.iterator();
    L48:
        if (r26.hasNext() == false) goto L54;
        c r27 = (c) ZeusTransformUtils.preCheckCast(r26.next(), c.class, "com.obric.aiagent.plugin");
        c r28 = r27.a("datatypemetadata");
        if (r28 == null) goto L53;
        r27 = r28;
    L53:
        r25.add(r27);
        goto L48
    L54:
        Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r30 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r31 = r29.iterator();
    L56:
        if (r31.hasNext() == false) goto L169;
        i r32 = d((c) ZeusTransformUtils.preCheckCast(r31.next(), c.class, "com.obric.aiagent.plugin"));
        if (r32 == null) goto L56;
        r30.add(r32);
        goto L56
    L169:
        return (i) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.b((List) ZeusTransformUtils.preCheckCast(r30, List.class, "com.obric.aiagent.plugin"), r12.c("objectqualifiedname"), r6, r7), i.class, "com.obric.aiagent.plugin");
    L61:
        String r113 = r12.c("datatypereference");
        if (r113 == null) goto L170;
        r3 = r113;
    L170:
        return (i) ZeusTransformUtils.preCheckCast(new v(r3, r6, r7), i.class, "com.obric.aiagent.plugin");
    L66:
        c r114 = r12.a("itemtype");
        if (r114 == null) goto L171;
        c r33 = r114.a("datatypemetadata");
        if (r33 == null) goto L72;
        r114 = r33;
    L72:
        if (r114 == null) goto L171;
        i r115 = d(r114);
        if (r115 == null) goto L171;
        r13 = new e(r115, r6, r7);
    L171:
        return (i) ZeusTransformUtils.preCheckCast(r13, i.class, "com.obric.aiagent.plugin");
    L77:
        Iterable r116 = (Iterable) ZeusTransformUtils.preCheckCast(r12.b("enumvalues"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r117 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r118 = r116.iterator();
    L79:
        if (r118.hasNext() == false) goto L83;
        String r34 = ((c) ZeusTransformUtils.preCheckCast(r118.next(), c.class, "com.obric.aiagent.plugin")).c();
        if (r34 == null) goto L79;
        r117.add(r34);
        goto L79
    L83:
        Collection r119 = (Collection) ZeusTransformUtils.preCheckCast(d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r117, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin");
        if (r119.isEmpty() == true) goto L172;
        r14 = r119;
    L172:
        return (i) ZeusTransformUtils.preCheckCast(new ah(r6, r7, (Set) ZeusTransformUtils.preCheckCast(r14, Set.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin");
    L88:
        Iterable r120 = (Iterable) ZeusTransformUtils.preCheckCast(r12.b("enumvalues"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r121 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r122 = r120.iterator();
    L90:
        if (r122.hasNext() == false) goto L97;
        String r35 = ((c) ZeusTransformUtils.preCheckCast(r122.next(), c.class, "com.obric.aiagent.plugin")).c();
        if (r35 == null) goto L94;
        Integer r36 = d.o.o.d(r35);
    L95:
        if (r36 == null) goto L90;
        r121.add(r36);
        goto L90
    L94:
        r36 = null;
        goto L95
    L97:
        Collection r123 = (Collection) ZeusTransformUtils.preCheckCast(d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r121, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin");
        if (r123.isEmpty() == true) goto L173;
        r9 = r123;
    L173:
        return (i) ZeusTransformUtils.preCheckCast(new p(r6, r7, (Set) ZeusTransformUtils.preCheckCast(r9, Set.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin");
    L105:
        Iterable r124 = (Iterable) ZeusTransformUtils.preCheckCast(r12.b("properties"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r37 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r125 = r124.iterator();
    L107:
        if (r125.hasNext() == false) goto L120;
        c r38 = (c) ZeusTransformUtils.preCheckCast(r125.next(), c.class, "com.obric.aiagent.plugin");
        String r39 = r38.c("name");
        if (r39 != null) goto L111;
    L110:
        d.m r40 = null;
    L118:
        if (r40 == null) goto L107;
        r37.add(r40);
        goto L107
    L111:
        c r41 = r38.a("datatypemetadata");
        if (r41 == null) goto L110;
        i r42 = f18187a.d(r41);
        if (r42 == null) goto L110;
        r40 = d.s.a(r39, r42);
        goto L118
    L120:
        Map r43 = ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r37, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        Iterable r126 = (Iterable) ZeusTransformUtils.preCheckCast(r12.b("required"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r44 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r127 = r126.iterator();
    L122:
        if (r127.hasNext() == false) goto L177;
        String r45 = ((c) ZeusTransformUtils.preCheckCast(r127.next(), c.class, "com.obric.aiagent.plugin")).c();
        if (r45 == null) goto L122;
        r44.add(r45);
        goto L122
    L177:
        return (i) ZeusTransformUtils.preCheckCast(new s(r43, d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r44, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), r12.c("objectqualifiedname"), r6, r7), i.class, "com.obric.aiagent.plugin");
    L180:
        return null;
    L174:
        return (i) ZeusTransformUtils.preCheckCast(new q(r6, r7), i.class, "com.obric.aiagent.plugin");
    L175:
        return (i) ZeusTransformUtils.preCheckCast(new o(r6, r7), i.class, "com.obric.aiagent.plugin");
    L176:
        return (i) ZeusTransformUtils.preCheckCast(new j(r6, r7), i.class, "com.obric.aiagent.plugin");
    L178:
        return (i) ZeusTransformUtils.preCheckCast(new g(r6, r7), i.class, "com.obric.aiagent.plugin");
    L179:
        return (i) ZeusTransformUtils.preCheckCast(new f(r6, r7), i.class, "com.obric.aiagent.plugin");
    L130:
        return (i) ZeusTransformUtils.preCheckCast(new ai(r6, r7), i.class, "com.obric.aiagent.plugin");
    L15:
        r8 = -1;
        goto L16
    L9:
        r7 = r2;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private final c a(InputStream r13) {
        XmlPullParser r0 = XmlPullParserFactory.newInstance().newPullParser();
        c r1 = null;
        r0.setInput(r13, null);
        ArrayList r14 = new ArrayList();
        int r2 = r0.getEventType();
    L4:
        if (r2 == 1) goto L31;
        if (r2 != 2) goto L8;
        String r3 = r0.getName();
        d.h.b.o.c(r3, "getName(...)");
        c r4 = new c(c(r3), null, null, 6, null);
        c r5 = (c) ZeusTransformUtils.preCheckCast(d.a.p.n((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L27;
        List<c> r6 = r5.a();
        if (r6 == null) goto L27;
        r6.add(r4);
    L27:
        r14.add(r4);
        if (r1 != null) goto L30;
        r1 = r4;
    L30:
        r2 = r0.next();
        goto L4
    L8:
        if (r2 == 3) goto L20;
        if (r2 != 4) goto L12;
    L14:
        c r7 = (c) ZeusTransformUtils.preCheckCast(d.a.p.n((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L30;
        StringBuilder r8 = r7.b();
        if (r8 == null) goto L30;
        r8.append(r0.getText());
        goto L30
    L12:
        if (r2 == 5) goto L14;
    L20:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L30;
        r14.remove(d.a.p.b((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin")));
        goto L30
    L31:
        return r1;
    }

    private final String c(String r15) {
        String r14 = d.o.o.a(d.o.o.a(d.o.o.b(r15, ':', null, 2, null), "_", "", false, 4, null), "-", "", false, 4, null).toLowerCase(Locale.ROOT);
        d.h.b.o.c(r14, "toLowerCase(...)");
        return r14;
    }
}
