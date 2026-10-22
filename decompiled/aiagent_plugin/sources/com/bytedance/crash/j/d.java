package com.bytedance.crash.j;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ProtectorConfigBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONArray f7542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONArray f7543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f7544e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    /* JADX INFO: compiled from: ProtectorConfigBuilder.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7545a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f7546b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f7547c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f7548e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f7549d;

        static /* synthetic */ int a(a r0) {
            return r0.f7549d;
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f7548e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("BOTH", 0, 0);
            f7545a = r0;
            a r1 = new a("ARM64_V8A", 1, 1);
            f7546b = r1;
            a r3 = new a("ARMEABI_V7A", 2, 2);
            f7547c = r3;
            f7548e = new a[]{r0, r1, r3};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f7549d = r3;
        }

        int a() {
            return this.f7549d;
        }
    }

    public d(String r3) {
        this.f7540a = null;
        this.f7541b = null;
        this.f7542c = null;
        this.f7543d = null;
        this.f7544e = null;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        if (r3 == null) goto L9;
        if (c.d(r3) == false) goto L9;
        this.f7540a = r3;
        return;
    L9:
        throw new IllegalArgumentException("invalid scope: " + r3);
    }

    public d a(String r3) {
        if (this.f7542c != null) goto L6;
        this.f7542c = new JSONArray();
    L6:
        if (c.b(r3) == 0) goto L10;
        this.f7542c.put(r3);
        return this;
    L10:
        throw new IllegalArgumentException("invalid signal: " + r3);
    }

    public d b(String r3) {
        return a(r3, null, false);
    }

    public d a(String r2, String r3) {
        return a(r2, r3, false);
    }

    public d a(String r3, String r4, boolean r5) {
        if (this.f7543d != null) goto L5;
        this.f7543d = new JSONArray();
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("elf_name", r3);
        if (r4 != null) goto L8;
    L11:
        r0.put("redacted_match", 1);
    L12:
        if (r5 == false) goto L14;
        r0.put("return_from_current_stack", 1);
    L14:
        this.f7543d.put(r0);
        return this;
    L8:
        if (r4.isEmpty() == true) goto L11;
        r0.put("symbol_name", r4);
        goto L12
    }

    public d a(String r2, long r3) {
        if (this.f7544e != null) goto L6;
        this.f7544e = new JSONObject();
    L6:
        if (c.c(r2) == false) goto L10;
        this.f7544e.put(r2, r3);
        return this;
    L10:
        throw new IllegalArgumentException("invalid register label: " + r2);
    }

    public d a(int r1) {
        this.i = r1;
        return this;
    }

    public d a(a r2) {
        int r3 = r2.a();
        if (r3 != a.a(a.f7545a)) goto L6;
        this.f7541b = "both";
    L11:
        return this;
    L6:
        if (r3 != a.a(a.f7546b)) goto L9;
        this.f7541b = "arm64-v8a";
        goto L11
    L9:
        if (r3 != a.a(a.f7547c)) goto L11;
        this.f7541b = "armeabi-v7a";
        goto L11
    }

    public JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("scope", this.f7540a);
        JSONArray r1 = this.f7542c;
        if (r1 == null) goto L39;
        if (r1.length() == 0) goto L39;
        r0.put("signals", this.f7542c);
        JSONArray r2 = this.f7543d;
        if (r2 == null) goto L37;
        if (r2.length() == 0) goto L37;
        r0.put("backtraces", this.f7543d);
        JSONObject r3 = this.f7544e;
        if (r3 != null) goto L13;
    L15:
        int r4 = this.f;
        if (r4 == (-1)) goto L18;
        r0.put("max_ignore_depth_before_meet_first_match", r4);
    L18:
        int r5 = this.g;
        if (r5 == (-1)) goto L21;
        r0.put("max_resume_count", r5);
    L21:
        int r6 = this.h;
        if (r6 == (-1)) goto L24;
        r0.put("interval_time_ms", r6);
    L24:
        int r7 = this.i;
        if (r7 == (-1)) goto L27;
        r0.put("min_api_level", r7);
    L27:
        int r8 = this.j;
        if (r8 == (-1)) goto L30;
        r0.put("max_api_level", r8);
    L30:
        String r9 = this.f7541b;
        if (r9 != null) goto L33;
    L35:
        return r0;
    L33:
        if (r9.isEmpty() == true) goto L35;
        r0.put("abi", this.f7541b);
        goto L35
    L13:
        if (r3.length() <= 0) goto L15;
        r0.put("registers", this.f7544e);
    L37:
        throw new Exception("empty backtraces");
    L39:
        throw new Exception("empty signals");
    }
}
