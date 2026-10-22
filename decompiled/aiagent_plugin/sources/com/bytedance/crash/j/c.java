package com.bytedance.crash.j;

import android.os.Build;
import android.util.Pair;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashProtectorConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f7522a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f7523b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f7524c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f7525d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static JSONObject f7526e;
    private static JSONObject f;
    private ArrayList<String> g;
    private ArrayList<String> h;
    private ArrayList<String> i;
    private byte[] j;
    private int k;
    private boolean l;

    /* JADX INFO: compiled from: CrashProtectorConfig.java */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f7528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f7529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f7530d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f7531e;
        int f;
        int g;
        int h;
        int i;
        long j;
        com.bytedance.crash.j.a k;
        com.bytedance.crash.j.a l;
        ArrayList<Pair<Integer, Long>> m;
        final /* synthetic */ c n;

        a(c r3) {
            this.n = r3;
            this.f7529c = 0;
            this.f7530d = 0;
            this.f7531e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.m = null;
        }

        public void a(com.bytedance.crash.j.a r12) {
            r12.d(8);
            int r1 = r12.c();
            int r2 = 0;
            int r3 = r12.c(0);
            r12.b(this.f7529c);
            r12.a(this.f7527a.getBytes().length);
            r12.a(this.f7530d);
            r12.a(this.f7531e);
            r12.a(this.f);
            r12.a(this.g);
            ArrayList<Pair<Integer, Long>> r4 = this.m;
            if (r4 != null) goto L5;
            int r5 = 0;
        L6:
            r12.a(r5);
            r12.b(this.h);
            r12.b(this.i);
            r12.b(this.j);
            int r6 = r12.c(0);
            int r7 = r12.c(0);
            int r8 = r12.c(0);
            int r9 = r12.c(0);
            int r10 = r12.c(0);
            int r11 = r12.c(0);
            r12.a(r6, r12.c() - r1);
            r12.a(this.f7527a.getBytes());
            r12.a(0);
            String r13 = this.f7528b;
            if (r13 != null) goto L9;
        L11:
            r12.a(r8, r12.c() - r1);
            r12.a(this.k.a(), 0, this.k.c());
            r12.a(r9, r12.c() - r1);
            r12.a(this.l.a(), 0, this.l.c());
            ArrayList<Pair<Integer, Long>> r14 = this.m;
            if (r14 != null) goto L14;
        L29:
            r12.d(8);
            r12.a(r3, r12.c() - r1);
            return;
        L14:
            if (r14.isEmpty() == true) goto L29;
            r12.a(r10, r12.c() - r1);
            int r15 = 0;
        L17:
            if (r15 >= this.m.size()) goto L20;
            r12.a(((Integer) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.m.get(r15), Pair.class, "com.obric.aiagent.plugin")).first, Integer.class, "com.obric.aiagent.plugin")).intValue());
            r15 = r15 + 1;
            goto L17
        L20:
            if (c.a(this.n) == false) goto L25;
            r12.d(8);
            r12.a(r11, r12.c() - r1);
        L23:
            if (r2 >= this.m.size()) goto L29;
            r12.b(((Long) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.m.get(r2), Pair.class, "com.obric.aiagent.plugin")).second, Long.class, "com.obric.aiagent.plugin")).longValue());
            r2 = r2 + 1;
            goto L23
        L25:
            r12.d(4);
            r12.a(r11, r12.c() - r1);
        L27:
            if (r2 >= this.m.size()) goto L29;
            r12.b(((Long) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.m.get(r2), Pair.class, "com.obric.aiagent.plugin")).second, Long.class, "com.obric.aiagent.plugin")).intValue());
            r2 = r2 + 1;
            goto L27
        L9:
            if (r13.isEmpty() == true) goto L11;
            r12.a(r7, r12.c() - r1);
            r12.a(this.f7528b.getBytes());
            r12.a(0);
            goto L11
        L5:
            r5 = r4.size();
            goto L6
        }
    }

    /* JADX INFO: compiled from: CrashProtectorConfig.java */
    static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7532a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f7533b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f7534c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f7535d = null;

        static {
            b r0 = new b("ELF_BUILD_ID", 0);
            f7532a = r0;
            b r1 = new b("ELF_PATH", 1);
            f7533b = r1;
            b r3 = new b("ELF_NAME", 2);
            f7534c = r3;
            f7535d = new b[]{r0, r1, r3};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f7535d.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.crash.j.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CrashProtectorConfig.java */
    static final enum EnumC0167c extends Enum<EnumC0167c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0167c f7536a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0167c f7537b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0167c f7538c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0167c[] f7539d = null;

        static {
            EnumC0167c r0 = new EnumC0167c("SYMBOL_ALL", 0);
            f7536a = r0;
            EnumC0167c r1 = new EnumC0167c("SYMBOL_OFFSET", 1);
            f7537b = r1;
            EnumC0167c r3 = new EnumC0167c("SYMBOL_NAME", 2);
            f7538c = r3;
            f7539d = new EnumC0167c[]{r0, r1, r3};
        }

        private EnumC0167c(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0167c valueOf(String r2) {
            return (EnumC0167c) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0167c.class, r2), EnumC0167c.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0167c[] values() {
            return (EnumC0167c[]) ZeusTransformUtils.preCheckCast(f7539d.clone(), EnumC0167c[].class, "com.obric.aiagent.plugin");
        }
    }

    static /* synthetic */ boolean a(c r0) {
        return r0.l;
    }

    static {
        f7522a = new byte[]{80, 82, 79, 84};
        f7523b = new byte[]{48, 48, 52};
        f7524c = new byte[]{120, 86, 52, 18};
        f7525d = Pattern.compile("^com\\.bytedance(\\.\\w+)*$");
        f7526e = null;
        f = null;
    }

    c() {
        this.g = new ArrayList();
        this.j = null;
        this.k = 0;
        this.l = true;
    }

    public byte[] a() {
        return this.j;
    }

    public int b() {
        return this.k;
    }

    public boolean a(JSONObject r2) {
        return a(r2.optString("scope"));
    }

    public boolean a(String r5) {
        if (d(r5) == true) goto L5;
        return false;
    L5:
        Iterator<String> r4 = this.g.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin")).equals(r5) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public static boolean b(JSONObject r3) {
        if (f7526e != null) goto L6;
        f7526e = new JSONObject();
    L6:
        if (f != null) goto L20;
        f = new JSONObject();
    L20:
        String r1 = r3.optString("scope");     // Catch: Exception -> L17
        if (r1.isEmpty() == false) goto L12;
    L16:
        return false;
    L12:
        if (r1.startsWith("com.bytedance.") == false) goto L16;
        f.put(r1, r3);     // Catch: Exception -> L17
        f7526e.put(r1, 1);     // Catch: Exception -> L17
        return true;
    L17:
        e = move-exception;
        r.c("NPTH_PROT", e.getMessage());
        return false;
    }

    public static void c(JSONObject r8) {
        JSONObject r1 = null;
        if (r8 == null) goto L5;
        r1 = r8.optJSONObject("scope_list");
        JSONObject r9 = r8.optJSONObject("config_list");
    L6:
        if (r1 != null) goto L8;
        r1 = new JSONObject();
    L8:
        if (r9 != null) goto L24;
        r9 = new JSONObject();
    L24:
        JSONObject r2 = f;     // Catch: Exception -> L20
        if (r2 == null) goto L18;
        Iterator<String> r3 = r2.keys();     // Catch: Exception -> L20
    L14:
        if (r3.hasNext() == false) goto L18;
        JSONObject r4 = f.optJSONObject((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L20
        if (r4 == null) goto L14;
        String r5 = r4.optString("scope");     // Catch: Exception -> L20
        r9.put(r5, r4);     // Catch: Exception -> L20
        r1.put(r5, 1);     // Catch: Exception -> L20
    L18:
        r1.put("com.bytedance.__default__", 1);     // Catch: Exception -> L20
        r9.put("__default__.unwindstack.maps", "{ \"scope\": \"com.bytedance.__default__.unwindstack.maps\",\"signals\": [\"SIGSEGV\"], \"backtraces\":[ { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack6Global19FindAndReadVariableEPNS_4MapsEPKc\", \"return_from_current_stack\": 1 }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack15GlobalDebugImplINS_7DexFileEmNS_8Uint64_AEE14ForEachSymfileIZNS3_15GetFunctionNameEPNS_4MapsEmPNS_12SharedStringEPmEUlPS1_E_EEbS6_mT_\" }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack15GlobalDebugImplINS_7DexFileEmNS_8Uint64_AEE15GetFunctionNameEPNS_4MapsEmPNS_12SharedStringEPm\" }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack8Unwinder14FillInDexFrameEv\" } ] } ");     // Catch: Exception -> L20
    L22:
        f7526e = r1;
        f = r9;
        r.b("NPTH_PROT", "update config");
        return;
    L20:
        e = move-exception;
        r.c("NPTH_PROT", e.getMessage());
        goto L22
    L5:
        r9 = null;
        goto L6
    }

    public boolean c() {
        return a(f7526e, f);
    }

    private boolean a(JSONObject r8, JSONObject r9) {
        if (d(r8) == true) goto L5;
        return false;
    L5:
        this.l = NativeBridge.g();
        com.bytedance.crash.j.a r10 = new com.bytedance.crash.j.a();
        r10.a(f7522a);
        r10.a(f7523b);
        if (this.l == false) goto L8;
        int r1 = 2;
    L9:
        r10.a(r1);
        r10.a(f7524c);
        int r2 = r10.c(0);
        int r3 = r10.c(0);
        r10.d(8);
        int r4 = r10.c();
        int r11 = a(r10, r9);
        r.b("NPTH_PROT", "config count: " + r11);
        if (r11 > 0) goto L12;
        return false;
    L12:
        r10.a(r3, r10.c() - r4);
        r10.a(r2, r11);
        a(r10);
        this.j = r10.a();
        this.k = r10.c();
        return true;
    L8:
        r1 = 1;
        goto L9
    }

    private void a(com.bytedance.crash.j.a r9) {
        byte[] r0 = new byte[8];
        r9.d(8);
        byte[] r1 = r9.a();
        int r2 = r9.c();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= 8) goto L7;
        r0[r5] = (byte) (r0[r5] ^ r1[r4 + r5]);
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 8;
        goto L3
    L8:
        r9.a(r0);
    }

    private boolean d(JSONObject r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        Iterator<String> r1 = r7.keys();
        this.h = new ArrayList();
        this.i = new ArrayList();
    L6:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L18;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        if (d(r2) == false) goto L6;
        if (r7.optInt(r2) != 0) goto L15;
        r3 = false;
    L15:
        if (r3 == true) goto L16;
        this.i.add(r2);
        goto L6
    L16:
        this.h.add(r2);
        goto L6
    L18:
        r.b("NPTH_PROT", "white list size: " + this.h.size());
        return !this.h.isEmpty();
    }

    private int a(com.bytedance.crash.j.a r6, JSONObject r7) {
        int r0 = 0;
        if (r7 != null) goto L5;
        return 0;
    L5:
        Iterator<String> r1 = r7.keys();
    L7:
        if (r1.hasNext() == false) goto L19;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        JSONObject r3 = r7.optJSONObject(r2);
        if (r3 != null) goto L17;
        String r4 = r7.optString(r2);
        if (r4.isEmpty() == false) goto L21;
    L14:
        if (r3 != null) goto L17;
    L21:
        r3 = new JSONObject(r4);     // Catch: Throwable -> L20
    L17:
        if (b(r6, r3) == false) goto L7;
        r0 = r0 + 1;
        goto L7
    L19:
        return r0;
    }

    private boolean b(com.bytedance.crash.j.a r12, JSONObject r13) {
        if (r13 != null) goto L5;
        return false;
    L5:
        String r1 = r13.optString("scope");
        if (a(r1, this.i, this.h) == true) goto L8;
        return false;
    L8:
        int r2 = r13.optInt("min_api_level", 0);
        int r3 = r13.optInt("max_api_level", 100);
        if (Build.VERSION.SDK_INT >= r2) goto L11;
    L58:
        return false;
    L11:
        if (Build.VERSION.SDK_INT > r3) goto L58;
        JSONArray r4 = r13.optJSONArray("api_levels");
        if (r4 == null) goto L25;
        int r5 = 0;
    L17:
        if (r5 >= r4.length()) goto L22;
        if (Build.VERSION.SDK_INT == r4.optInt(r5)) goto L20;
        r5 = r5 + 1;
        goto L17
    L20:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L25;
        return false;
    L22:
        r6 = false;
    L25:
        a r7 = new a(this);
        r7.f7527a = r1;
        String r8 = r13.optString("abi", "both");
        if (r8.equals("both") == false) goto L28;
    L36:
        JSONArray r9 = r13.optJSONArray("signals");
        if (r9 == null) goto L45;
        int r10 = 0;
    L40:
        if (r10 >= r9.length()) goto L45;
        int r11 = b(r9.optString(r10));
        if (r11 == 0) goto L44;
        r7.j |= 1 << r11;
    L44:
        r10 = r10 + 1;
    L45:
        r7.f7528b = r13.optString("abort_message");
        r7.h = r13.optInt("max_resume_count", 3);
        r7.i = r13.optInt("interval_time_ms", 3000);
        r7.f7531e = r13.optInt("return_frame_index");
        if (r13.optInt("dump_all") == 0) goto L48;
        r7.f7529c |= 1;
    L48:
        int r14 = r13.optInt("max_ignore_depth_before_meet_first_match");
        if (r14 >= 0) goto L51;
        r14 = 0;
    L53:
        r7.f = r14;
        if (a(r7, r13.optJSONArray("backtraces")) == true) goto L56;
        return false;
    L56:
        a(r7, r13.optJSONObject("registers"));
        r7.a(r12);
        this.g.add(r1);
        r.b("NPTH_PROT", "add scope: " + r1);
        return true;
    L51:
        if (r14 <= 255) goto L53;
        r14 = 255;
        goto L53
    L28:
        if (this.l == false) goto L32;
        if (r8.equals("arm64-v8a") == true) goto L36;
    L32:
        if (this.l == false) goto L34;
    L35:
        return false;
    L34:
        if (r8.equals("armeabi-v7a") == true) goto L36;
        goto L35
    }

    public static int b(String r8) {
        if (r8 != null) goto L5;
    L61:
        return 0;
    L5:
        if (r8.isEmpty() == true) goto L61;
        r8.hashCode();
        byte r1 = -1;
        switch(r8.hashCode()) {
            case -1849149425: goto L43;
            case -1849145750: goto L39;
            case -1849142984: goto L35;
            case -1849132964: goto L31;
            case -1489105324: goto L27;
            case -1488651809: goto L23;
            case -1488566542: goto L19;
            case -1488524450: goto L15;
            case -274378251: goto L11;
            default: goto L46;
        };
    L46:
        switch(r1) {
            case 0: goto L60;
            case 1: goto L59;
            case 2: goto L58;
            case 3: goto L56;
            case 4: goto L55;
            case 5: goto L53;
            case 6: goto L51;
            case 7: goto L50;
            case 8: goto L48;
            default: goto L47;
        };
    L47:
        return 0;
    L48:
        return 16;
    L50:
        return 5;
    L51:
        return 11;
    L53:
        return 13;
    L55:
        return 6;
    L56:
        return 31;
    L58:
        return 4;
    L59:
        return 8;
    L60:
        return 7;
    L11:
        if (r8.equals("SIGSTKFLT") == false) goto L46;
        r1 = 8;
        goto L46
    L15:
        if (r8.equals("SIGTRAP") == false) goto L46;
        r1 = 7;
        goto L46
    L19:
        if (r8.equals("SIGSEGV") == false) goto L46;
        r1 = 6;
        goto L46
    L23:
        if (r8.equals("SIGPIPE") == false) goto L46;
        r1 = 5;
        goto L46
    L27:
        if (r8.equals("SIGABRT") == false) goto L46;
        r1 = 4;
        goto L46
    L31:
        if (r8.equals("SIGSYS") == false) goto L46;
        r1 = 3;
        goto L46
    L35:
        if (r8.equals("SIGILL") == false) goto L46;
        r1 = 2;
        goto L46
    L39:
        if (r8.equals("SIGFPE") == false) goto L46;
        r1 = 1;
        goto L46
    L43:
        if (r8.equals("SIGBUS") == false) goto L46;
        r1 = 0;
        goto L46
    }

    public static boolean c(String r4) {
        if (r4.length() == 2) goto L5;
        return false;
    L5:
        char r0 = Character.toLowerCase(r4.charAt(0));
        int r5 = r4.charAt(1) - '0';
        if (r5 >= 0) goto L9;
        return false;
    L9:
        if (r5 >= 8) goto L19;
        if (r0 == 'x') goto L23;
        if (r0 == 'w') goto L23;
        if (r0 == 'd') goto L23;
        if (r0 != 's') goto L19;
    L23:
        return true;
    L19:
        if (r5 < 4) goto L21;
        return false;
    L21:
        if (r0 == 'r') goto L23;
        return false;
    }

    private boolean a(a r13, JSONObject r14) {
        if (r14 != null) goto L5;
        return false;
    L5:
        r13.m = new ArrayList();
        Iterator<String> r1 = r14.keys();
    L7:
        if (r1.hasNext() == false) goto L46;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        if (r2.length() != 2) goto L7;
        char r4 = Character.toLowerCase(r2.charAt(0));
        int r3 = r2.charAt(1) - '0';
        if (r3 < 0) goto L7;
        if (this.l == true) goto L17;
        if (r3 >= 4) goto L7;
        if (r4 != 'r') goto L7;
    L31:
        Long r5 = a(r14.opt(r2));
        if (r5 == null) goto L34;
        long r10 = r5.longValue();
    L39:
        if (r4 == 'w') goto L42;
        if (r4 == 's') goto L42;
        if (r4 == 'r') goto L42;
    L44:
        if (r10 == 0) goto L7;
        r13.m.add(new Pair(Integer.valueOf(r3), Long.valueOf(r10)));
    L42:
        r10 = r10 & 4294967295L;
        goto L44
    L34:
        if (r4 != 'd') goto L36;
        r10 = Double.doubleToLongBits(r14.optDouble(r2));
        goto L39
    L36:
        if (r4 != 's') goto L38;
        r10 = Float.floatToIntBits((float) r14.optDouble(r2));
        goto L39
    L38:
        r10 = r14.optLong(r2);
        goto L39
    L17:
        if (r3 >= 8) goto L7;
        if (r4 == 'x') goto L24;
        if (r4 == 'w') goto L24;
        if (r4 == 'd') goto L24;
        if (r4 != 's') goto L7;
    L24:
        if (r4 == 'd') goto L26;
        if (r4 != 's') goto L31;
    L26:
        r3 = r3 + 34;
        goto L31
    L46:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [int] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8, types: [int] */
    /* JADX WARN: Type inference failed for: r15v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    private boolean a(a r18, JSONArray r19) {
        JSONArray r1 = r19;
        ?? r2 = 0;
        if (r1 != null) goto L5;
        return false;
    L5:
        int r3 = r19.length();
        int r4 = 255;
        if (r3 <= 255) goto L8;
        r3 = 255;
    L8:
        r18.g = r3;
        r18.l = new com.bytedance.crash.j.a();
        com.bytedance.crash.j.a r5 = r18.l;
        r18.k = new com.bytedance.crash.j.a();
        com.bytedance.crash.j.a r6 = r18.k;
        int r7 = -1;
        int r8 = 0;
        int r9 = -1;
    L9:
        if (r8 >= r3) goto L97;
        JSONObject r11 = r1.optJSONObject(r8);
        if (r9 == r7) goto L13;
    L15:
        String r12 = r11.optString("elf_build_id");
        ?? r13 = r11.optString("elf_path");
        String r14 = r11.optString("elf_name");
        if (r12.isEmpty() == true) goto L25;
        r12 = r12.replace(" ", "");
        int r15 = r12.length() / 2;
        byte[] r16 = new byte[r15];
        ?? r17 = r2;
    L18:
        if (r17 >= r15) goto L21;
        int r10 = r17 * 2;
        r16[r17] = (byte) (Integer.parseInt(r12.substring(r10, r10 + 2), 16) & r4);     // Catch: Throwable -> L23
        r17 = r17 + 1;     // Catch: Throwable -> L23
    L23:
        return r2;
    L21:
        b r20 = b.f7532a;     // Catch: Throwable -> L23
    L33:
        if (r16 == null) goto L93;
        if (r16.length >= 256) goto L93;
        byte[] r110 = r6.a();
        ?? r111 = r2;
    L39:
        if (r111 >= r6.c()) goto L56;
        byte r112 = r110[r111];
        byte r21 = r110[r111 + 1];
        if (r112 != r20.ordinal()) goto L54;
        if (r21 != r16.length) goto L54;
        int r22 = 0;
    L46:
        if (r22 >= r16.length) goto L51;
        if (r110[(r111 + 2) + r22] != r16[r22]) goto L49;
        r22 = r22 + 1;
        goto L46
    L49:
        boolean r23 = false;
    L52:
        if (r23 == false) goto L54;
    L51:
        r23 = true;
    L54:
        r111 = r111 + (r21 + 3);
    L56:
        if (r111 > r6.c()) goto L57;
        if (r111 != r6.c()) goto L62;
        r18.f7530d++;
        r6.a(r20.ordinal());
        r6.a(r16.length);
        r6.a(r16);
        r6.a(0);
    L62:
        r5.a((long) r111);
        if (r11.optInt("redacted_match") == 0) goto L66;
        r5.a(EnumC0167c.f7536a.ordinal());
    L89:
        r8 = r8 + 1;
        r1 = r19;
        r2 = 0;
        r4 = 255;
        r7 = -1;
        goto L9
    L66:
        if (r11.has("offset_start") == true) goto L68;
        String r24 = r11.optString("symbol_name");
        if (r24.isEmpty() == true) goto L90;
        r5.a(EnumC0167c.f7538c.ordinal());
        r5.a(r24);
        goto L89
    L90:
        return false;
    L68:
        if (r12.isEmpty() == true) goto L69;
        Long r25 = a(r11.opt("offset_start"));
        if (r25 != null) goto L74;
        r25 = Long.valueOf(r11.optLong("offset_start"));
    L74:
        Long r26 = a(r11.opt("offset_next"));
        if (r26 != null) goto L78;
        r26 = Long.valueOf(r11.optLong("offset_next"));
    L78:
        if (r25.longValue() == 0) goto L84;
        if (r26.longValue() == 0) goto L127;
        if (r25.longValue() >= r26.longValue()) goto L128;
        r5.a(EnumC0167c.f7537b.ordinal());
        r5.a(r25.longValue());
        r5.a(r26.longValue());
        goto L89
    L128:
        return false;
    L127:
        return false;
    L84:
        return false;
    L69:
        return false;
    L57:
        return false;
    L93:
        return r2;
    L25:
        if (r13.isEmpty() == true) goto L31;
        if (r13.charAt(r2) != '/') goto L28;
        r20 = b.f7533b;
        r16 = r13.getBytes();
        goto L33
    L28:
        return r2;
    L31:
        if (r14.isEmpty() == true) goto L95;
        r20 = b.f7534c;
        r16 = r14.getBytes();
        goto L33
    L95:
        return r2;
    L13:
        if (r11.optInt("return_from_current_stack") == 0) goto L15;
        r9 = r8;
        goto L15
    L97:
        if (r9 != r7) goto L99;
        r18.f7529c |= 2;
        return true;
    L99:
        r18.f7531e = r9;
        return true;
    }

    private static Long a(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L8;
        return null;
    L8:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
        if (r4.isEmpty() == false) goto L12;
        return null;
    L12:
        if (r4.startsWith("0x") == true) goto L20;
        if (r4.startsWith("0X") == true) goto L20;
    L18:
        return null;
    L20:
        return Long.valueOf(Long.parseLong(r4.substring(2), 16));
    }

    private static boolean a(String r6, ArrayList<String> r7, ArrayList<String> r8) {
        if (d(r6) == true) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r7.size()) goto L16;
        if (r6.startsWith((String) ZeusTransformUtils.preCheckCast(r7.get(r0), String.class, "com.obric.aiagent.plugin")) == false) goto L15;
        if (((String) ZeusTransformUtils.preCheckCast(r7.get(r0), String.class, "com.obric.aiagent.plugin")).length() == r6.length()) goto L14;
        if (r6.charAt(((String) ZeusTransformUtils.preCheckCast(r7.get(r0), String.class, "com.obric.aiagent.plugin")).length()) != '.') goto L15;
    L14:
        return false;
    L15:
        r0 = r0 + 1;
        goto L7
    L16:
        int r9 = 0;
    L18:
        if (r9 >= r8.size()) goto L28;
        if (r6.startsWith((String) ZeusTransformUtils.preCheckCast(r8.get(r9), String.class, "com.obric.aiagent.plugin")) == false) goto L27;
        if (((String) ZeusTransformUtils.preCheckCast(r8.get(r9), String.class, "com.obric.aiagent.plugin")).length() == r6.length()) goto L25;
        if (r6.charAt(((String) ZeusTransformUtils.preCheckCast(r8.get(r9), String.class, "com.obric.aiagent.plugin")).length()) != '.') goto L27;
        return true;
    L25:
        return true;
    L27:
        r9 = r9 + 1;
        goto L18
    L28:
        return false;
    }

    public static boolean d(String r2) {
        if (r2.length() < 256) goto L5;
    L7:
        return false;
    L5:
        if (f7525d.matcher(r2).matches() == false) goto L7;
        return true;
    }
}
