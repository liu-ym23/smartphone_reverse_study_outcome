package com.obric.autogui.platforms.miui.a.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.o;
import d.k;
import d.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MiuiScanVirusDeterminationCriteria.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29976a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Long> f29977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f29978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<g> f29979d;

    /* JADX INFO: compiled from: MiuiScanVirusDeterminationCriteria.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final b a() {
            return a("\n        {\n          \"version\": 1,\n          \"match\": \"any\",\n          \"flagsAnyOf\": [1],\n          \"rules\": [\n            {\"id\": \"LevelGreaterThan\", \"type\": \"threat_level_gte\", \"min\": 3},\n            {\"id\": \"TencentThreatName\", \"type\": \"engine_threat_name_in\", \"engine\": \"Tencent\", \"threatNames\": []},\n            {\"id\": \"TencentThreatStartsWith\", \"type\": \"engine_threat_name_starts_with\", \"engine\": \"Tencent\", \"threatNames\": [\"a.gray.sex\"]}\n          ]\n        }\n        ");
        }

        public final b a(String r3) {
            o.e(r3, "json");
            n.a r1 = n.f38560a;     // Catch: Throwable -> L5
            Object r2 = n.f(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).b(r3));     // Catch: Throwable -> L5
        L8:
            if (n.c(r2) == null) goto L12;
            r2 = b.f29976a.b();
        L12:
            return (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
        L5:
            th = move-exception;
            n.a r4 = n.f38560a;
            r2 = n.f(d.o.a(th));
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final b b(String r17) {
            JSONObject r1 = new JSONObject(r17);
            if (r1.has("minThreatLevel") == true) goto L116;
            if (r1.has("engineRules") == true) goto L116;
            String r2 = r1.optString("match", "any");
            o.c(r2, "optString(...)");
            String r3 = r2.toLowerCase(Locale.ROOT);
            o.c(r3, "toLowerCase(...)");
            if (o.a(r3, "all") == false) goto L10;
            e r4 = e.f29992b;
        L11:
            boolean r5 = false;
            boolean r6 = r1.optBoolean("enableForbiddenInstallationFlag", false);
            Set r0 = p.t((Iterable) ZeusTransformUtils.preCheckCast(a(r1.optJSONArray("flagsAnyOf")), Iterable.class, "com.obric.aiagent.plugin"));
            if (r6 == false) goto L14;
            r0.add(1L);
        L14:
            JSONArray r7 = r1.optJSONArray("rules");
            if (r7 != null) goto L17;
            r7 = new JSONArray();
        L17:
            List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            int r9 = r7.length();
            int r10 = 0;
        L18:
            CharSequence r11 = null;
            if (r10 >= r9) goto L114;
            JSONObject r12 = r7.optJSONObject(r10);
            if (r12 == null) goto L112;
            String r13 = r12.optString("type");
            if (r13 != null) goto L26;
            r13 = "";
        L26:
            String r14 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L29;
            boolean r15 = true;
        L30:
            if (r15 == true) goto L112;
            String r16 = r12.optString(DbHelper.COL_ID);
            if (r16 != null) goto L34;
            r16 = "";
        L34:
            CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r18.length() != 0) goto L37;
            boolean r19 = true;
        L38:
            if (r19 == true) goto L41;
            r11 = r18;
        L41:
            String r20 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
            int r110 = r14.hashCode();
            if (r110 == (-211783480)) goto L84;
            if (r110 == (-95073839)) goto L55;
            if (r110 != 204450296) goto L112;
            if (r14.equals("threat_level_gte") == false) goto L112;
            int r21 = r12.optInt("min", -1);
            if (r21 < 0) goto L112;
            r8.add(new h(r20, r21));
            goto L112
        L55:
            if (r14.equals("engine_threat_name_in") == false) goto L112;
            String r22 = r12.optString("engine");
            if (r22 != null) goto L60;
            r22 = "";
        L60:
            String r23 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L63;
            boolean r111 = true;
        L64:
            if (r111 == true) goto L112;
            JSONArray r24 = r12.optJSONArray("threatNames");
            if (r24 != null) goto L68;
            r24 = new JSONArray();
        L68:
            Set r112 = ax.a();
            int r113 = r24.length();
            int r114 = 0;
        L69:
            if (r114 >= r113) goto L80;
            String r115 = r24.optString(r114);
            if (r115 != null) goto L73;
            r115 = "";
        L73:
            String r116 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L76;
            boolean r117 = true;
        L77:
            if (r117 == false) goto L79;
            r112.add(r116);
        L79:
            r114 = r114 + 1;
            goto L69
        L76:
            r117 = false;
            goto L77
        L80:
            Set r25 = ax.a(r112);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L112;
            r8.add(new c(r20, r23, r25));
            goto L112
        L63:
            r111 = false;
            goto L64
        L84:
            if (r14.equals("engine_threat_name_starts_with") == false) goto L112;
            String r26 = r12.optString("engine");
            if (r26 != null) goto L89;
            r26 = "";
        L89:
            String r27 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r27, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L92;
            boolean r118 = true;
        L93:
            if (r118 == true) goto L112;
            JSONArray r28 = r12.optJSONArray("threatNames");
            if (r28 != null) goto L97;
            r28 = new JSONArray();
        L97:
            List r119 = p.a();
            int r120 = r28.length();
            int r121 = 0;
        L98:
            if (r121 >= r120) goto L109;
            String r122 = r28.optString(r121);
            if (r122 != null) goto L102;
            r122 = "";
        L102:
            String r123 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r122, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r123, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L105;
            boolean r124 = true;
        L106:
            if (r124 == false) goto L108;
            r119.add(r123);
        L108:
            r121 = r121 + 1;
            goto L98
        L105:
            r124 = false;
            goto L106
        L109:
            List r29 = p.a(r119);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r29, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L112;
            r8.add(new d(r20, r27, r29));
            goto L112
        L92:
            r118 = false;
            goto L93
        L37:
            r19 = r5;
            goto L38
        L29:
            r15 = r5;
        L112:
            r10 = r10 + 1;
            r5 = false;
            goto L18
        L114:
            return new b(r0, r4, r8, null == true ? 1 : 0);
        L10:
            r4 = e.f29991a;
        L116:
            return a(r1);
        }

        private final b a(JSONObject r15) {
            Integer r14 = Integer.valueOf(r15.optInt("minThreatLevel", -1));
            if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).intValue() < 0) goto L5;
            boolean r0 = true;
        L6:
            d.h.b.h r4 = null;
            if (r0 == true) goto L10;
            r14 = null;
        L10:
            List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            if (r14 == null) goto L13;
            r1.add(new h("legacy_minThreatLevel", r14.intValue()));
        L13:
            JSONArray r16 = r15.optJSONArray("engineRules");
            if (r16 != null) goto L16;
            r16 = new JSONArray();
        L16:
            int r17 = r16.length();
            int r5 = 0;
        L17:
            if (r5 >= r17) goto L49;
            JSONObject r6 = r16.optJSONObject(r5);
            if (r6 == null) goto L47;
            String r7 = r6.optString("engine");
            if (r7 != null) goto L24;
            r7 = "";
        L24:
            String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L27;
            boolean r9 = true;
        L28:
            if (r9 == true) goto L47;
            JSONArray r10 = r6.optJSONArray("threatNames");
            if (r10 != null) goto L32;
            r10 = new JSONArray();
        L32:
            Set r11 = ax.a();
            int r12 = r10.length();
            int r13 = 0;
        L33:
            if (r13 >= r12) goto L44;
            String r18 = r10.optString(r13);
            if (r18 != null) goto L37;
            r18 = "";
        L37:
            String r19 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L40;
            boolean r110 = true;
        L41:
            if (r110 == false) goto L43;
            r11.add(r19);
        L43:
            r13 = r13 + 1;
            goto L33
        L40:
            r110 = false;
            goto L41
        L44:
            Set r20 = ax.a(r11);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L47;
            r1.add(new c("legacy_engineRules_" + r5, r8, r20));
            goto L47
        L27:
            r9 = false;
        L47:
            r5 = r5 + 1;
            goto L17
        L49:
            return new b(ax.a(1L), e.f29991a, r1, r4);
        L5:
            r0 = false;
            goto L6
        }

        private final b b() {
            return new b(ax.a(1L), e.f29991a, p.b(), null);
        }

        private final Set<Long> a(JSONArray r7) {
            if (r7 == null) goto L4;
            Set r6 = ax.a();
            int r0 = 0;
            int r1 = r7.length();
        L6:
            if (r0 >= r1) goto L12;
            long r4 = r7.optLong(r0, 0);
            if (r4 == 0) goto L10;
            r6.add(Long.valueOf(r4));
        L10:
            r0 = r0 + 1;
            goto L6
        L12:
            return ax.a(r6);
        L4:
            return ax.b();
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.miui.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MiuiScanVirusDeterminationCriteria.kt */
    public static final class C0785b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f29980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f29982c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0785b.class) == true) goto L8;
            return false;
        L8:
            C0785b r6 = (C0785b) ZeusTransformUtils.preCheckCast(r5, C0785b.class, "com.obric.aiagent.plugin");
            if (this.f29980a == r6.f29980a) goto L12;
            return false;
        L12:
            if (o.a(this.f29981b, r6.f29981b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f29982c, r6.f29982c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((Boolean.hashCode(this.f29980a) * 31) + this.f29981b.hashCode()) * 31;
            String r2 = this.f29982c;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "Determination(isVirus=" + this.f29980a + ", reason=" + this.f29981b + ", matchedRuleId=" + this.f29982c + ')';
        }

        public C0785b(boolean r2, String r3, String r4) {
            o.e(r3, "reason");
            this.f29980a = r2;
            this.f29981b = r3;
            this.f29982c = r4;
        }

        public /* synthetic */ C0785b(boolean r1, String r2, String r3, int r4, d.h.b.h r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r2, r3);
        }

        public final boolean a() {
            return this.f29980a;
        }

        public final String b() {
            return this.f29981b;
        }
    }

    /* JADX INFO: compiled from: MiuiScanVirusDeterminationCriteria.kt */
    private static final class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<String> f29985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f29986d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29983a, r6.f29983a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f29984b, r6.f29984b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f29985c, r6.f29985c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.f29983a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((r1 * 31) + this.f29984b.hashCode()) * 31) + this.f29985c.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "EngineThreatNameInRule(id=" + this.f29983a + ", engine=" + this.f29984b + ", threatNames=" + this.f29985c + ')';
        }

        public c(String r3, String r4, Set<String> r5) {
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
            o.e(r4, "engine");
            o.e(r6, "threatNames");
            this.f29983a = r3;
            this.f29984b = r4;
            this.f29985c = r6;
            this.f29986d = "engine_threat_name_in";
        }

        public String a() {
            return this.f29983a;
        }

        @Override // com.obric.autogui.platforms.miui.a.a.b.g
        public String getType() {
            return this.f29986d;
        }

        @Override // com.obric.autogui.platforms.miui.a.a.b.g
        public f a(com.miui.guardprovider.c r7) {
            o.e(r7, DownloadFileUtils.MODE_READ);
            n.a r2 = n.f38560a;     // Catch: Throwable -> L5
            c r3 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
            Object r4 = n.f(r7.d());     // Catch: Throwable -> L5
        L8:
            if (n.b(r4) == false) goto L10;
            r4 = null;
        L10:
            String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
            String r6 = "";
            if (r5 != null) goto L14;
            r5 = "";
        L14:
            if (o.a(r5, this.f29984b) == true) goto L33;
            return null;
        L33:
            n.a r8 = n.f38560a;     // Catch: Throwable -> L18
            c r0 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
            Object r9 = n.f(r7.b());     // Catch: Throwable -> L18
        L21:
            if (n.b(r9) == false) goto L23;
            r9 = null;
        L23:
            String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L28;
            r6 = r10;
        L28:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L30;
            return null;
        L30:
            if (this.f29985c.contains(r6) == true) goto L32;
            return null;
        L32:
            return new f(a(), getType(), "engine=" + this.f29984b + ", threatName=" + r6);
        L18:
            th = move-exception;
            n.a r1 = n.f38560a;
            r9 = n.f(d.o.a(th));
        L5:
            th = move-exception;
            n.a r11 = n.f38560a;
            r4 = n.f(d.o.a(th));
            goto L8
        }
    }

    /* JADX INFO: compiled from: MiuiScanVirusDeterminationCriteria.kt */
    private static final class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<String> f29989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f29990d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29987a, r6.f29987a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f29988b, r6.f29988b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f29989c, r6.f29989c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.f29987a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((r1 * 31) + this.f29988b.hashCode()) * 31) + this.f29989c.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "EngineThreatNameStartsWithRule(id=" + this.f29987a + ", engine=" + this.f29988b + ", prefixes=" + this.f29989c + ')';
        }

        public d(String r3, String r4, List<String> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "engine");
            o.e(r6, "prefixes");
            this.f29987a = r3;
            this.f29988b = r4;
            this.f29989c = r6;
            this.f29990d = "engine_threat_name_starts_with";
        }

        public String a() {
            return this.f29987a;
        }

        @Override // com.obric.autogui.platforms.miui.a.a.b.g
        public String getType() {
            return this.f29990d;
        }

        @Override // com.obric.autogui.platforms.miui.a.a.b.g
        public f a(com.miui.guardprovider.c r9) {
            o.e(r9, DownloadFileUtils.MODE_READ);
            n.a r2 = n.f38560a;     // Catch: Throwable -> L5
            d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
            Object r4 = n.f(r9.d());     // Catch: Throwable -> L5
        L8:
            if (n.b(r4) == false) goto L10;
            r4 = null;
        L10:
            String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
            String r6 = "";
            if (r5 != null) goto L14;
            r5 = "";
        L14:
            if (o.a(r5, this.f29988b) == true) goto L46;
            return null;
        L46:
            n.a r7 = n.f38560a;     // Catch: Throwable -> L18
            d r0 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
            Object r10 = n.f(r9.b());     // Catch: Throwable -> L18
        L21:
            if (n.b(r10) == false) goto L23;
            r10 = null;
        L23:
            String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L28;
            r6 = r11;
        L28:
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L30;
            return null;
        L30:
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f29989c, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L32:
            if (r12.hasNext() == false) goto L41;
            Object r1 = r12.next();
            String r8 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
            boolean r13 = true;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L36;
        L38:
            r13 = false;
        L39:
            if (r13 == false) goto L32;
        L42:
            String r14 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
            if (r14 != null) goto L45;
            return null;
        L45:
            return new f(a(), getType(), "engine=" + this.f29988b + ", prefix=" + r14 + ", threatName=" + r6);
        L36:
            if (d.o.o.b(r6, r8, false, 2, null) == false) goto L38;
        L41:
            r1 = null;
        L18:
            th = move-exception;
            n.a r15 = n.f38560a;
            r10 = n.f(d.o.a(th));
        L5:
            th = move-exception;
            n.a r16 = n.f38560a;
            r4 = n.f(d.o.a(th));
            goto L8
        }
    }

    /* JADX INFO: compiled from: MiuiScanVirusDeterminationCriteria.kt */
    private static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f29991a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f29992b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ e[] f29993c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f29994d = null;

        private static final /* synthetic */ e[] a() {
            return new e[]{f29991a, f29992b};
        }

        static {
            f29991a = new e("Any", 0);
            f29992b = new e("All", 1);
            e[] r0 = a();
            f29993c = r0;
            f29994d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f29993c.clone(), e[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: MiuiScanVirusDeterminationCriteria.kt */
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f29997c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29995a, r6.f29995a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f29996b, r6.f29996b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f29997c, r6.f29997c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.f29995a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((r1 * 31) + this.f29996b.hashCode()) * 31) + this.f29997c.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "MatchResult(ruleId=" + this.f29995a + ", ruleType=" + this.f29996b + ", detail=" + this.f29997c + ')';
        }

        public f(String r2, String r3, String r4) {
            o.e(r3, "ruleType");
            o.e(r4, "detail");
            this.f29995a = r2;
            this.f29996b = r3;
            this.f29997c = r4;
        }

        public final String a() {
            return this.f29995a;
        }

        public final String b() {
            return this.f29996b;
        }

        public final String c() {
            return this.f29997c;
        }
    }

    /* JADX INFO: compiled from: MiuiScanVirusDeterminationCriteria.kt */
    private interface g {
        f a(com.miui.guardprovider.c r1);

        String getType();
    }

    /* JADX INFO: compiled from: MiuiScanVirusDeterminationCriteria.kt */
    private static final class h implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f29999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f30000c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
            return false;
        L8:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29998a, r6.f29998a) == true) goto L12;
            return false;
        L12:
            if (this.f29999b == r6.f29999b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f29998a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + Integer.hashCode(this.f29999b);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "ThreatLevelGteRule(id=" + this.f29998a + ", min=" + this.f29999b + ')';
        }

        public h(String r1, int r2) {
            this.f29998a = r1;
            this.f29999b = r2;
            this.f30000c = "threat_level_gte";
        }

        public String a() {
            return this.f29998a;
        }

        @Override // com.obric.autogui.platforms.miui.a.a.b.g
        public String getType() {
            return this.f30000c;
        }

        @Override // com.obric.autogui.platforms.miui.a.a.b.g
        public f a(com.miui.guardprovider.c r6) {
            o.e(r6, DownloadFileUtils.MODE_READ);
            n.a r1 = n.f38560a;     // Catch: Throwable -> L5
            h r2 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
            Object r7 = n.f(Integer.valueOf(r6.a()));     // Catch: Throwable -> L5
        L8:
            if (n.b(r7) == false) goto L10;
            r7 = null;
        L10:
            Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L18;
            int r9 = r8.intValue();
            if (r9 >= this.f29999b) goto L15;
            return null;
        L15:
            return new f(a(), getType(), "min=" + this.f29999b + ", actual=" + r9);
        L18:
            return null;
        L5:
            th = move-exception;
            n.a r3 = n.f38560a;
            r7 = n.f(d.o.a(th));
            goto L8
        }
    }

    /* JADX INFO: compiled from: MiuiScanVirusDeterminationCriteria.kt */
    public /* synthetic */ class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30001a = null;

        static {
            int[] r0 = new int[e.values().length];
            r0[e.f29991a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[e.f29992b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f30001a = r0;
        }
    }

    static {
        f29976a = new a(null);
    }

    public /* synthetic */ b(Set r2, e r3, List r4, d.h.b.h r5) {
        this((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin"), r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    private b(Set<Long> r3, e r4, List<? extends g> r5) {
        Set<Long> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        List<g> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f29977b = r6;
        this.f29978c = r4;
        this.f29979d = r7;
    }

    public final C0785b a(List<com.miui.guardprovider.c> r13) {
        List<com.miui.guardprovider.c> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return new C0785b(false, "no_results", null, 4, null);
    L13:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f29977b, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L35;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r2.hasNext() == false) goto L35;
        com.miui.guardprovider.c r3 = (com.miui.guardprovider.c) ZeusTransformUtils.preCheckCast(r2.next(), com.miui.guardprovider.c.class, "com.obric.aiagent.plugin");
        n.a r4 = n.f38560a;     // Catch: Throwable -> L20
        b r5 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        Object r6 = n.f(Long.valueOf(r3.f()));     // Catch: Throwable -> L20
    L23:
        if (n.b(r6) == false) goto L25;
        r6 = 0L;
    L25:
        long r7 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).longValue();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f29977b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L27:
        if (r8.hasNext() == false) goto L16;
        long r9 = ((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r9 == 0) goto L27;
        if ((r7 & r9) == 0) goto L27;
        return new C0785b(true, "flag_matched(flag=0x" + Long.toHexString(r9) + ')', null);
    L20:
        th = move-exception;
        n.a r10 = n.f38560a;
        r6 = n.f(d.o.a(th));
    L35:
        if (this.f29979d.isEmpty() == true) goto L37;
        int r11 = i.f30001a[this.f29978c.ordinal()];
        if (r11 == 1) goto L46;
        if (r11 != 2) goto L44;
        return c(r14);
    L44:
        throw new k();
    L46:
        return b(r14);
    L37:
        return new C0785b(false, "no_match", null, 4, null);
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final C0785b b(List<com.miui.guardprovider.c> r9) {
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L19;
        com.miui.guardprovider.c r0 = (com.miui.guardprovider.c) ZeusTransformUtils.preCheckCast(r10.next(), com.miui.guardprovider.c.class, "com.obric.aiagent.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f29979d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        f r3 = ((g) ZeusTransformUtils.preCheckCast(r2.next(), g.class, "com.obric.aiagent.plugin")).a(r0);
        if (r3 == null) goto L7;
        String r8 = r3.a();
        if (r8 == null) goto L15;
        String r11 = "id=" + r8 + ", ";
        if (r11 == null) goto L15;
    L17:
        return new C0785b(true, "rule_matched(" + r11 + "type=" + r3.b() + ", detail=" + r3.c() + ')', r3.a());
    L15:
        r11 = "";
        goto L17
    L19:
        return new C0785b(false, "no_match", null, 4, null);
    }

    private final C0785b c(List<com.miui.guardprovider.c> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f29979d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L15;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r11.next(), g.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        if (r0.a((com.miui.guardprovider.c) ZeusTransformUtils.preCheckCast(r4.next(), com.miui.guardprovider.c.class, "com.obric.aiagent.plugin")) == null) goto L7;
        r3 = true;
        goto L7
    L11:
        if (r3 == true) goto L4;
        return new C0785b(false, "no_match", null, 4, null);
    L15:
        return new C0785b(true, "all_rules_matched", null);
    }
}
