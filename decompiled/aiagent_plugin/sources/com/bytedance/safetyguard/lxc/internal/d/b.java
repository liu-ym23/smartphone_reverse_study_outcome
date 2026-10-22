package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.ActionEgressStatus;
import com.bytedance.safetyguard.lxc.api.SensitiveCategoryInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ActionSecurityPayloadParser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10175a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.o.k f10176b = null;

    /* JADX INFO: compiled from: ActionSecurityPayloadParser.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EnumC0231b f10177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10178b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f10177a == r6.f10177a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f10178b, r6.f10178b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10177a.hashCode() * 31) + this.f10178b.hashCode();
        }

        public String toString() {
            return "AuthorizationRecord(state=" + this.f10177a + ", categoryDesc=" + this.f10178b + ')';
        }

        public a(EnumC0231b r2, String r3) {
            d.h.b.o.e(r2, "state");
            d.h.b.o.e(r3, "categoryDesc");
            this.f10177a = r2;
            this.f10178b = r3;
        }

        public final EnumC0231b a() {
            return this.f10177a;
        }

        public final String b() {
            return this.f10178b;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionSecurityPayloadParser.kt */
    private static final enum EnumC0231b extends Enum<EnumC0231b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0231b f10179a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0231b f10180b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0231b f10181c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0231b[] f10182d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f10183e = null;

        private static final /* synthetic */ EnumC0231b[] a() {
            return new EnumC0231b[]{f10179a, f10180b, f10181c};
        }

        public static EnumC0231b valueOf(String r2) {
            return (EnumC0231b) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0231b.class, r2), EnumC0231b.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0231b[] values() {
            return (EnumC0231b[]) ZeusTransformUtils.preCheckCast(f10182d.clone(), EnumC0231b[].class, "com.obric.aiagent.plugin");
        }

        static {
            f10179a = new EnumC0231b("APPROVED", 0);
            f10180b = new EnumC0231b("DENIED", 1);
            f10181c = new EnumC0231b("UNAPPROVED", 2);
            EnumC0231b[] r0 = a();
            f10182d = r0;
            f10183e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        private EnumC0231b(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ActionSecurityPayloadParser.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10184a = null;

        static {
            int[] r0 = new int[EnumC0231b.values().length];
            r0[EnumC0231b.f10179a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[EnumC0231b.f10180b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[EnumC0231b.f10181c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f10184a = r0;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r2, SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")).getSensitiveCategory(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r3, SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")).getSensitiveCategory(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class e<T> implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r2, SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")).getSensitiveCategory(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r3, SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")).getSensitiveCategory(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class f<T> implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r2, SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")).getSensitiveCategory(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r3, SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")).getSensitiveCategory(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    private b() {
    }

    public final m a(String r11) {
        d.h.b.o.e(r11, "outboundSensitiveDataJson");
        byte[] r0 = r11.getBytes(d.o.d.f38623b);
        d.h.b.o.c(r0, "getBytes(...)");
        if (r0.length > 65536) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L59;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L57;
        JSONObject r2 = new JSONObject(r11);     // Catch: Exception -> L53
        Set<String> r12 = a(r2);
        Map<String, a> r10 = b(r2);
        List r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r13.hasNext() == false) goto L35;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
        a r7 = (a) ZeusTransformUtils.preCheckCast(r10.get(r6), a.class, "com.obric.aiagent.plugin");
        EnumC0231b r8 = null;
        if (r7 == null) goto L16;
        String r9 = r7.b();
    L17:
        SensitiveCategoryInfo r14 = new SensitiveCategoryInfo(r6, r9);
        if (r7 == null) goto L21;
        r8 = r7.a();
    L21:
        if (r8 != null) goto L23;
        int r15 = -1;
    L24:
        if (r15 == (-1)) goto L33;
        if (r15 != 1) goto L27;
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).add(r14);
        goto L12
    L27:
        if (r15 != 2) goto L29;
        ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).add(r14);
        goto L12
    L29:
        if (r15 != 3) goto L12;
    L33:
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).add(r14);
        goto L12
    L23:
        r15 = c.f10184a[r8.ordinal()];
        goto L24
    L16:
        r9 = null;
        goto L17
    L35:
        if (r3.size() <= 1) goto L38;
        d.a.p.a(r3, (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.aiagent.plugin"));
    L38:
        if (r4.size() <= 1) goto L41;
        d.a.p.a(r4, (Comparator) ZeusTransformUtils.preCheckCast(new e(), Comparator.class, "com.obric.aiagent.plugin"));
    L41:
        if (r5.size() <= 1) goto L43;
        d.a.p.a(r5, (Comparator) ZeusTransformUtils.preCheckCast(new f(), Comparator.class, "com.obric.aiagent.plugin"));
    L43:
        ActionEgressStatus.Companion r16 = ActionEgressStatus.Companion;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r19 = r17.iterator();
    L45:
        if (r19.hasNext() == false) goto L47;
        r18.add(((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r19.next(), SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")).getSensitiveCategory());
        goto L45
    L47:
        Set<String> r110 = (Set) ZeusTransformUtils.preCheckCast(r18, Set.class, "com.obric.aiagent.plugin");
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r22 = r20.iterator();
    L49:
        if (r22.hasNext() == false) goto L52;
        r21.add(((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r22.next(), SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")).getSensitiveCategory());
        goto L49
    L52:
        return new m(r16.fromCategories(r110, (Set) ZeusTransformUtils.preCheckCast(r21, Set.class, "com.obric.aiagent.plugin")), r3, r4, r5);
    L53:
        e = move-exception;
        throw new IllegalArgumentException("Action security payload must be a JSON object", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L57:
        throw new IllegalArgumentException("Action security payload must not be blank".toString());
    L59:
        throw new IllegalArgumentException("Action security payload is too large".toString());
    L5:
        r1 = false;
        goto L6
    }

    private final Set<String> a(JSONObject r10) {
        JSONArray r9 = a(r10, "current_sensitive_data");
        if (r9.length() > 256) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L28;
        LinkedHashSet r12 = new LinkedHashSet();
        int r3 = r9.length();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L26;
        Object r6 = r9.get(r4);
        if (ZeusTransformUtils.instanceOf(r6, JSONObject.class) == false) goto L13;
        JSONObject r7 = (JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.aiagent.plugin");
    L14:
        if (r7 == null) goto L24;
        d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(f10175a.c(r7), Iterable.class, "com.obric.aiagent.plugin"));
        if (r12.size() > 256) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L22;
        r4 = r4 + 1;
        goto L9
    L22:
        throw new IllegalArgumentException("Too many current sensitive categories".toString());
    L18:
        r5 = false;
        goto L19
    L24:
        throw new IllegalArgumentException("Action security array entries must be objects");
    L13:
        r7 = null;
        goto L14
    L26:
        return (Set) ZeusTransformUtils.preCheckCast(r12, Set.class, "com.obric.aiagent.plugin");
    L28:
        throw new IllegalArgumentException("Too many current sensitive entries".toString());
    L5:
        r11 = false;
        goto L6
    }

    private final Map<String, a> b(JSONObject r11) {
        JSONArray r10 = a(r11, "sensitive_authorization_list");
        if (r10.length() > 256) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L35;
        LinkedHashMap r13 = new LinkedHashMap();
        int r2 = r10.length();
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L33;
        Object r5 = r10.get(r3);
        if (ZeusTransformUtils.instanceOf(r5, JSONObject.class) == false) goto L13;
        JSONObject r6 = (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin");
    L14:
        if (r6 == null) goto L31;
        b r7 = f10175a;
        a r8 = new a(r7.d(r6), r7.e(r6));
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.c(r6), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L17:
        if (r9.hasNext() == false) goto L29;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin");
        a r15 = (a) ZeusTransformUtils.preCheckCast(r13.get(r14), a.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L21;
    L24:
        boolean r16 = true;
    L25:
        if (r16 == false) goto L28;
        ((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.aiagent.plugin")).put(r14, r8);
        goto L17
    L28:
        throw new IllegalArgumentException("Conflicting sensitive authorization records".toString());
    L21:
        if (d.h.b.o.a(r15, r8) == true) goto L24;
        r16 = false;
        goto L25
    L29:
        r3 = r3 + 1;
        goto L9
    L31:
        throw new IllegalArgumentException("Action security array entries must be objects");
    L13:
        r6 = null;
        goto L14
    L33:
        return (Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.aiagent.plugin");
    L35:
        throw new IllegalArgumentException("Too many sensitive authorization records".toString());
    L5:
        r12 = false;
        goto L6
    }

    private final JSONArray a(JSONObject r1, String r2) {
        if (r1.has(r2) == false) goto L5;
        Object r0 = r1.get(r2);
        if (ZeusTransformUtils.instanceOf(r0, JSONArray.class) == false) goto L9;
        JSONArray r3 = (JSONArray) ZeusTransformUtils.preCheckCast(r0, JSONArray.class, "com.obric.aiagent.plugin");
    L10:
        if (r3 == null) goto L13;
        return r3;
    L13:
        throw new IllegalArgumentException("Action security field must be an array");
    L9:
        r3 = null;
        goto L10
    L5:
        return new JSONArray();
    }

    private final List<String> c(JSONObject r5) {
        if (r5.has("sensitive_category") == false) goto L35;
        Object r6 = r5.get("sensitive_category");
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L8;
        List r4 = d.a.p.a(b((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin")));
    L29:
        return d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin"));
    L8:
        if (ZeusTransformUtils.instanceOf(r6, JSONArray.class) == false) goto L33;
        int r7 = ((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.aiagent.plugin")).length();
        boolean r0 = true;
        if (1 <= r7) goto L12;
    L14:
        r0 = false;
    L15:
        if (r0 == false) goto L31;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(0, ((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.aiagent.plugin")).length()), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r8.iterator();
    L18:
        if (r9.hasNext() == false) goto L27;
        Object r2 = ((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.aiagent.plugin")).get(((al) ZeusTransformUtils.preCheckCast(r9, al.class, "com.obric.aiagent.plugin")).a());
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L22;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L23:
        if (r3 == null) goto L26;
        r1.add(f10175a.b(r3));
        goto L18
    L26:
        throw new IllegalArgumentException("Sensitive category entries must be strings");
    L22:
        r3 = null;
        goto L23
    L27:
        r4 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        goto L29
    L31:
        throw new IllegalArgumentException("Sensitive category list size is invalid".toString());
    L12:
        if (r7 >= 257) goto L14;
    L33:
        throw new IllegalArgumentException("Sensitive category has an invalid type");
    L35:
        throw new IllegalArgumentException("Sensitive category is required".toString());
    }

    private final EnumC0231b d(JSONObject r3) {
        if (r3.has("sensitive_state") == false) goto L17;
        Object r2 = r3.get("sensitive_state");
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L8:
        if (r4 == null) goto L15;
        return EnumC0231b.valueOf(r4);
    L11:
        e = move-exception;
        throw new IllegalArgumentException("Unknown sensitive authorization state", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L15:
        throw new IllegalArgumentException("Sensitive authorization state must be a string");
    L7:
        r4 = null;
        goto L8
    L17:
        throw new IllegalArgumentException("Sensitive authorization state is required".toString());
    }

    private final String e(JSONObject r2) {
        if (r2.has("category_desc") == false) goto L20;
        Object r1 = r2.get("category_desc");
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L7;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L8:
        if (r3 == null) goto L18;
        byte[] r4 = r3.getBytes(d.o.d.f38623b);
        d.h.b.o.c(r4, "getBytes(...)");
        if (r4.length > 1024) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        return r3;
    L16:
        throw new IllegalArgumentException("Sensitive category description is too large".toString());
    L12:
        r5 = false;
        goto L13
    L18:
        throw new IllegalArgumentException("Sensitive category description must be a string");
    L7:
        r3 = null;
        goto L8
    L20:
        throw new IllegalArgumentException("Sensitive category description is required".toString());
    }

    private final String b(String r3) {
        if (f10176b.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException("Sensitive category code is invalid".toString());
    }

    static {
        f10175a = new b();
        f10176b = new d.o.k("^[A-Za-z0-9][A-Za-z0-9_.:-]{0,127}$");
    }
}
