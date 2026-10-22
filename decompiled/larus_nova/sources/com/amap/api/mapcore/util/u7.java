package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class u7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f28119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile List<String> f28120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, b> f28121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Random f28122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f28123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static List<h8> f28124f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f28125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f28126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        double f28127c;

        private a() {
        }

        public /* synthetic */ a(byte r100) {
            this();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        z7 f28128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f28129b;

        private b() {
        }

        public /* synthetic */ b(byte r100) {
            this();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map<String, List<a>> f28130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map<String, String> f28131b;

        public final int hashCode() {
            Map<String, List<a>> r100 = this.f28130a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            Map<String, String> r103 = this.f28131b;
            if (r103 == null) goto L10;
            r101 = r103.hashCode();
        L10:
            return r102 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        private c() {
            this.f28130a = new HashMap(8);
            this.f28131b = new HashMap(8);
        }

        public /* synthetic */ c(byte r100) {
            this();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L15:
            return false;
        L8:
            if (c.class != r100.getClass()) goto L15;
            c r101 = (c) r100;
            if (this.f28130a.equals(r101.f28130a) == false) goto L15;
            if (this.f28131b.equals(r101.f28131b) == false) goto L15;
            return true;
        }
    }

    static {
        f28119a = new ConcurrentHashMap(8);
        f28120b = Collections.synchronizedList(new ArrayList(8));
        f28121c = new ConcurrentHashMap(8);
        f28122d = new Random();
        f28123e = new ConcurrentHashMap(8);
        f28124f = Collections.synchronizedList(new ArrayList(16));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0031 -> B:20:0x0029). Please report as a decompilation issue!!! */
    public static void a() {
        Context r100 = m5.f27564c;     // Catch: Throwable -> L29
        if (r100 != null) goto L5;
        return;
    L5:
        ArrayList r101 = null;
        List<h8> r102 = f28124f;     // Catch: Throwable -> L28
        monitor-enter(r102);     // Catch: Throwable -> L28
        List<h8> r103 = f28124f;     // Catch: Throwable -> L19
        if (r103 != null) goto L11;
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L19
        goto L26
    L11:
        if (r103.size() <= 0) goto L17;
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L19
        r104.addAll(f28124f);     // Catch: Throwable -> L15
        f28124f.clear();     // Catch: Throwable -> L15
        r101 = r104;
    L15:
        Throwable th10 = th;
    L30:
        monitor-exit(r102);     // Catch: Throwable -> L24
        throw th10;     // Catch: Throwable -> L23
    L23:
        r101 = r104;
    L24:
        th = move-exception;
        ArrayList r105 = r104;
        th = th;
        r101 = r105;
    L20:
        Throwable r106 = th;
        r104 = r101;
        th10 = r106;
    L19:
        th = th;
    L26:
        i8.a(r101, r100);     // Catch: Throwable -> L29
        return;
    }

    private static boolean a(List<a> r110) {
        if (r110 != null) goto L5;
    L41:
        return false;
    L5:
        if (r110.size() <= 0) goto L41;
        Iterator<a> r100 = r110.iterator();
    L9:
        if (r100.hasNext() == false) goto L41;
        a r101 = r100.next();
        if (r101 != null) goto L14;
    L38:
        boolean r102 = false;
    L39:
        if (r102 == false) goto L9;
        return true;
    L14:
        if (r101.f28127c == 1.0d) goto L38;
        long r103 = System.currentTimeMillis();
        if (TextUtils.isEmpty(r101.f28125a) == true) goto L38;
        if (r101.f28126b <= 0) goto L38;
        String r104 = r101.f28125a;
        int r105 = x5.f28335d;
        SimpleDateFormat r106 = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);     // Catch: ParseException -> L23
        Calendar r107 = Calendar.getInstance();     // Catch: ParseException -> L23
        Calendar r108 = Calendar.getInstance();     // Catch: ParseException -> L23
        r108.setTime(r106.parse(r104));     // Catch: ParseException -> L23
        r107.set(r107.get(1), r107.get(2), r107.get(5), r108.get(11), r108.get(12), r108.get(13));     // Catch: ParseException -> L23
    L25:
        long r109 = r103 - r107.getTimeInMillis();
        if (r109 <= 0) goto L38;
        if (r109 >= (r101.f28126b * 1000)) goto L38;
        if (r101.f28127c != AudioStats.AUDIO_AMPLITUDE_NONE) goto L33;
    L37:
        r102 = true;
        goto L39
    L33:
        if (f28122d != null) goto L35;
        f28122d = new Random();
    L35:
        f28122d.setSeed(((long) UUID.randomUUID().hashCode()) + r103);
        if (f28122d.nextDouble() <= r101.f28127c) goto L38;
    L23:
        e = move-exception;
        p6.a(e, "ut", "ctt");
        r107 = null;
        goto L25
    }

    private static synchronized void a(String r100) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.amap.api.mapcore.util.u7> r0 = com.amap.api.mapcore.util.u7.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.u7$c> r1 = com.amap.api.mapcore.util.u7.f28119a     // Catch: java.lang.Throwable -> L32
            boolean r1 = r1.containsKey(r4)     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L10
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.u7$c> r1 = com.amap.api.mapcore.util.u7.f28119a     // Catch: java.lang.Throwable -> L32
            r1.remove(r4)     // Catch: java.lang.Throwable -> L32
        L10:
            android.content.Context r1 = com.amap.api.mapcore.util.m5.f27564c     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = "Yb3Blbl9odHRwX2NvbnRyb2w"
            android.content.SharedPreferences$Editor r1 = com.amap.api.mapcore.util.m7.a(r1, r2)     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L2d
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L21
            goto L2d
        L21:
            r1.remove(r4)     // Catch: java.lang.Throwable -> L25
            goto L2d
        L25:
            r4 = move-exception
            java.lang.String r2 = "sp"
            java.lang.String r3 = "rk"
            com.amap.api.mapcore.util.p6.a(r4, r2, r3)     // Catch: java.lang.Throwable -> L32
        L2d:
            com.amap.api.mapcore.util.m7.a(r1)     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)
            return
        L32:
            r4 = move-exception
            java.lang.String r1 = "hlUtil"
            java.lang.String r2 = "rc"
            com.amap.api.mapcore.util.p6.a(r4, r1, r2)     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r0)
            return
        L3c:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.u7.a(java.lang.String):void");
    }

    private static void a(c r110, JSONObject r111) {
        JSONArray r112 = r111.optJSONArray("block");     // Catch: Throwable -> L30
        if (r112 != null) goto L6;
        return;
    L6:
        HashMap r100 = new HashMap(8);     // Catch: Throwable -> L30
        byte r101 = 0;
        int r102 = 0;
    L8:
        if (r102 >= r112.length()) goto L28;
        JSONObject r103 = r112.optJSONObject(r102);     // Catch: Throwable -> L30
        if (r103 == null) goto L27;
        String r104 = r103.optString("api");     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r104) == true) goto L27;
        if (r104.startsWith(HTTP.URL_DEFAULT) == true) goto L17;
        r104 = HTTP.URL_DEFAULT.concat(r104);     // Catch: Throwable -> L30
    L17:
        if (r104.endsWith(HTTP.URL_DEFAULT) == false) goto L19;
        r104 = r104.substring(0, r104.length() - 1);     // Catch: Throwable -> L30
    L19:
        JSONArray r105 = r103.optJSONArray("periods");     // Catch: Throwable -> L30
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L30
        int r107 = 0;
    L21:
        if (r107 >= r105.length()) goto L26;
        JSONObject r108 = r105.optJSONObject(r107);     // Catch: Throwable -> L30
        if (r108 == null) goto L25;
        a r109 = new a(r101);     // Catch: Throwable -> L30
        r109.f28125a = r108.optString(GearStrategyConsts.EV_SELECT_BEGIN);     // Catch: Throwable -> L30
        r109.f28126b = r108.optInt("duration");     // Catch: Throwable -> L30
        r109.f28127c = r108.optDouble("percent");     // Catch: Throwable -> L30
        r106.add(r109);     // Catch: Throwable -> L30
    L25:
        r107 = r107 + 1;     // Catch: Throwable -> L30
        goto L21
    L26:
        r100.put(r104, r106);     // Catch: Throwable -> L30
    L27:
        r102 = r102 + 1;     // Catch: Throwable -> L30
        goto L8
    L28:
        r110.f28130a = r100;     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        p6.a(th, "hlUtil", "pbr");
    }

    public static synchronized String b(String r100, String r101) throws k5 {
        monitor-enter(u7.class);
        System.currentTimeMillis();     // Catch: Throwable -> L49 k5 -> L53
        if (TextUtils.isEmpty(r101) == false) goto L7;
    L47:
        monitor-exit(u7.class);
        return r100;
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L47;
        Context r102 = m5.f27564c;     // Catch: Throwable -> L49 k5 -> L53
    L23:
        th = move-exception;
        p6.a(th, "hlUtil", "llhl");     // Catch: Throwable -> L49 k5 -> L53
    L26:
        if (f28119a != null) goto L28;
    L45:
        monitor-exit(u7.class);
        return r100;
    L28:
        if (f28119a.size() <= 0) goto L45;
        if (f28119a.containsKey(r101) == true) goto L34;
        monitor-exit(u7.class);
        return r100;
    L34:
        c r103 = f28119a.get(r101);     // Catch: Throwable -> L49 k5 -> L53
        if (r103 != null) goto L39;
        monitor-exit(u7.class);
        return r100;
    L39:
        if (a(r100, r103, r101) == true) goto L44;
        String r104 = b(r100, r103, r101);     // Catch: Throwable -> L49 k5 -> L53
        monitor-exit(u7.class);
        return r104;
    L44:
        throw new k5("服务QPS超限");     // Catch: Throwable -> L49 k5 -> L53
    L11:
        if (f28120b != null) goto L13;
        f28120b = Collections.synchronizedList(new ArrayList(8));     // Catch: Throwable -> L23
    L13:
        if (r102 == null) goto L26;
        if (f28120b.contains(r101) == true) goto L26;
        f28120b.add(r101);     // Catch: Throwable -> L23
        String r105 = m7.a(r102, "Yb3Blbl9odHRwX2NvbnRyb2w", r101);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r105) == true) goto L26;
        a(r101, new JSONObject(r105));     // Catch: Throwable -> L23
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        throw th;
    L53:
        e = move-exception;
        throw e;     // Catch: Throwable -> L55
    L49:
        th = move-exception;
        p6.a(th, "hlUtil", "pcr");     // Catch: Throwable -> L55
        return r100;
    }

    public static void a(URL r110, z7 r111) {
        if (f28121c != null) goto L6;
        f28121c = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L6:
        Map<String, List<String>> r100 = r111.f28592b;     // Catch: Throwable -> L29
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.containsKey("nb") == false) goto L32;
        List<String> r101 = r111.f28592b.get("nb");     // Catch: Throwable -> L29
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.size() <= 0) goto L34;
        byte r102 = 0;
        String[] r103 = r101.get(0).split("#");     // Catch: Throwable -> L29
        if (r103.length >= 2) goto L18;
        return;
    L18:
        int r104 = Integer.parseInt(r103[0]);     // Catch: Throwable -> L29
        long r105 = Integer.parseInt(r103[1]);     // Catch: Throwable -> L29
        b r106 = new b(r102);     // Catch: Throwable -> L29
        r106.f28128a = r111;     // Catch: Throwable -> L29
        if (r105 > 0) goto L21;
        r105 = 30;
    L21:
        r106.f28129b = SystemClock.elapsedRealtime() + (r105 * 1000);     // Catch: Throwable -> L29
        if (r104 != 1) goto L25;
        f28121c.put("app", r106);     // Catch: Throwable -> L29
        return;
    L25:
        if (r104 != 2) goto L35;
        if (r110 == null) goto L36;
        f28121c.put(r110.getPath(), r106);     // Catch: Throwable -> L29
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L32:
        return;
    }

    public static z7 a(String r100, String r110) {
        if (f28121c != null) goto L7;
        return null;
    L7:
        if (f28121c.containsKey("app") == false) goto L14;
        b r101 = f28121c.get("app");     // Catch: Throwable -> L26
        if (SystemClock.elapsedRealtime() > r101.f28129b) goto L12;
        z7 r102 = r101.f28128a;     // Catch: Throwable -> L26
        a(true, r110, r100, 1);     // Catch: Throwable -> L26
        return r102;
    L12:
        f28121c.remove("app");     // Catch: Throwable -> L26
        goto L25
    L14:
        if (TextUtils.isEmpty(r100) == false) goto L16;
        return null;
    L16:
        Uri r103 = Uri.parse(r100);     // Catch: Throwable -> L26
        if (r103 == null) goto L25;
        String r104 = r103.getPath();     // Catch: Throwable -> L26
        if (f28121c.containsKey(r104) == false) goto L25;
        b r105 = f28121c.get(r104);     // Catch: Throwable -> L26
        if (SystemClock.elapsedRealtime() > r105.f28129b) goto L24;
        z7 r106 = r105.f28128a;     // Catch: Throwable -> L26
        a(true, r110, r100, 2);     // Catch: Throwable -> L26
        return r106;
    L24:
        f28121c.remove(r104);     // Catch: Throwable -> L26
    L25:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(String r100, JSONObject r110) {
        int r101 = 0;
        c r102 = new c(0 == true ? 1 : 0);     // Catch: Throwable -> L32
        a(r102, r110);     // Catch: Throwable -> L32
        JSONObject r111 = r110.optJSONObject("domainMap");     // Catch: Throwable -> L16
        if (r111 == null) goto L19;
        JSONArray r103 = r111.names();     // Catch: Throwable -> L16
        if (r103 == null) goto L19;
        HashMap r104 = new HashMap(8);     // Catch: Throwable -> L16
        int r105 = r103.length();     // Catch: Throwable -> L16
    L12:
        if (r101 >= r105) goto L14;
        String r106 = r103.optString(r101);     // Catch: Throwable -> L16
        r104.put(r106, r111.optString(r106));     // Catch: Throwable -> L16
        r101 = r101 + 1;     // Catch: Throwable -> L16
        goto L12
    L14:
        r102.f28131b = r104;     // Catch: Throwable -> L16
    L19:
        if (r102.f28131b == null) goto L21;
    L36:
    L29:
        th = move-exception;
        p6.a(th, "hlUtil", "ucr");     // Catch: Throwable -> L32
        return;
    L25:
        if (f28119a != null) goto L27;
        f28119a = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L27:
        f28119a.put(r100, r102);     // Catch: Throwable -> L29
        goto L40
    L39:
        return;
    L21:
        if (r102.f28130a != null) goto L36;
        a(r100);     // Catch: Throwable -> L32
        return;
    L16:
        th = move-exception;
        p6.a(th, "hlUtil", "pdr");     // Catch: Throwable -> L32
    }

    public static void a(boolean r100, String r101) {
        Context r102 = m5.f27564c;     // Catch: Throwable -> L18
        if (r102 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L18
        r103.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L18
        if (r100 == false) goto L13;
        r103.put("type", m6.f27618f);     // Catch: Throwable -> L18
    L14:
        r103.put("name", r101);     // Catch: Throwable -> L18
        r103.put("version", m6.a(r101));     // Catch: Throwable -> L18
        String r104 = r103.toString();     // Catch: Throwable -> L18
        h8 r105 = new h8(r102, "core", EventConstant.Value.AUTH_VERSION_2, "O005");     // Catch: Throwable -> L18
        r105.a(r104);     // Catch: Throwable -> L18
        i8.a(r105, r102);     // Catch: Throwable -> L18
        return;
    L13:
        r103.put("type", m6.f27617e);     // Catch: Throwable -> L18
        goto L14
    L22:
        return;
    }

    public static synchronized void a(w5 r100, JSONObject r101) {
        monitor-enter(u7.class);
        if (r100 != null) goto L32;
        monitor-exit(u7.class);
        return;
    L32:
        String r102 = r100.d();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r102) == false) goto L11;
        monitor-exit(u7.class);
        return;
    L11:
        if (r101 != null) goto L14;
        a(r102);     // Catch: Throwable -> L23
    L14:
        if (m5.a(r101.optString("able", null), false) == true) goto L18;
        a(r102);     // Catch: Throwable -> L23
        monitor-exit(u7.class);
        return;
    L18:
        Context r103 = m5.f27564c;     // Catch: Throwable -> L23
        m7.a(r103, "Yb3Blbl9odHRwX2NvbnRyb2w", r102, r101.toString());     // Catch: Throwable -> L23
        a(r102, r101);     // Catch: Throwable -> L23
        monitor-exit(u7.class);
        return;
    L23:
        th = move-exception;
        p6.a(th, "hlUtil", "par");     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        throw th;
    }

    private static void a(String r100, String r101, String r102) {
        Context r103 = m5.f27564c;     // Catch: Throwable -> L35
        if (r103 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        if (f28123e != null) goto L10;
        f28123e = new ConcurrentHashMap(8);     // Catch: Throwable -> L35
    L10:
        ConcurrentHashMap<String, String> r104 = f28123e;     // Catch: Throwable -> L35
        monitor-enter(r104);     // Catch: Throwable -> L35
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L13:
        if (f28123e.containsKey(r101) == false) goto L16;
        monitor-exit(r104);     // Catch: Throwable -> L31
        return;
    L16:
        f28123e.put(r101, r102);     // Catch: Throwable -> L31
        monitor-exit(r104);     // Catch: Throwable -> L31
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L35
        r105.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L35
        r105.put("type", m6.f27621i);     // Catch: Throwable -> L35
        r105.put("name", r100);     // Catch: Throwable -> L35
        r105.put("version", m6.a(r100));     // Catch: Throwable -> L35
        r105.put("hostname", r101 + "#" + r102);     // Catch: Throwable -> L35
        String r106 = r105.toString();     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r106) == false) goto L29;
        return;
    L29:
        h8 r107 = new h8(r103, "core", EventConstant.Value.AUTH_VERSION_2, "O005");     // Catch: Throwable -> L35
        r107.a(r106);     // Catch: Throwable -> L35
        i8.a(r107, r103);     // Catch: Throwable -> L35
        return;
    }

    private static String b(String r100, c r101, String r102) {
        Map<String, String> r103 = r101.f28131b;     // Catch: Throwable -> L12
        if (r103 != null) goto L5;
    L11:
        return r100;
    L5:
        if (r103.size() <= 0) goto L11;
        Uri r104 = Uri.parse(r100);     // Catch: Throwable -> L12
        String r105 = r104.getAuthority();     // Catch: Throwable -> L12
        if (r103.containsKey(r105) == false) goto L17;
        String r106 = r103.get(r105);     // Catch: Throwable -> L12
        r100 = r104.buildUpon().authority(r106).toString();     // Catch: Throwable -> L12
        a(r102, r105, r106);     // Catch: Throwable -> L12
        return r100;
    L17:
        return r100;
    L12:
        th = move-exception;
        p6.a(th, "hlUtil", "pdr");
        return r100;
    }

    private static boolean a(String r100, c r101, String r102) {
        Map<String, List<a>> r103 = r101.f28130a;     // Catch: Throwable -> L24
        if (r103 != null) goto L6;
    L23:
        return false;
    L6:
        if (r103.size() <= 0) goto L23;
        if (r103.containsKey("*") == false) goto L17;
        Iterator<Map.Entry<String, List<a>>> r104 = r103.entrySet().iterator();     // Catch: Throwable -> L24
    L12:
        if (r104.hasNext() == false) goto L26;
        if (a(r104.next().getValue()) == false) goto L12;
        a(false, r102, r100, 1);     // Catch: Throwable -> L24
        return true;
    L26:
        return false;
    L17:
        String r105 = Uri.parse(r100).getPath();     // Catch: Throwable -> L24
        if (r103.containsKey(r105) == false) goto L26;
        if (a(r103.get(r105)) == false) goto L26;
        a(false, r102, r100, 2);     // Catch: Throwable -> L24
        return true;
    L24:
        th = move-exception;
        p6.a(th, "hlUtil", "inb");
        goto L26
    }

    private static void a(boolean r100, String r101, String r102, int r103) {
        Context r104 = m5.f27564c;     // Catch: Throwable -> L35
        if (r104 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L41;
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L35
        r105.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L35
        String r106 = m6.a(r101);     // Catch: Throwable -> L35
        if (r100 == false) goto L17;
        r105.put("type", m6.f27620h);     // Catch: Throwable -> L35
    L18:
        r105.put("name", r101);     // Catch: Throwable -> L35
        r105.put("version", r106);     // Catch: Throwable -> L35
        r105.put("uri", Uri.parse(r102).getPath());     // Catch: Throwable -> L35
        r105.put("blockLevel", r103);     // Catch: Throwable -> L35
        String r107 = r105.toString();     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r107) == false) goto L21;
        return;
    L21:
        h8 r108 = new h8(r104, "core", EventConstant.Value.AUTH_VERSION_2, "O005");     // Catch: Throwable -> L35
        r108.a(r107);     // Catch: Throwable -> L35
        if (f28124f != null) goto L24;
        f28124f = Collections.synchronizedList(new ArrayList(16));     // Catch: Throwable -> L35
    L24:
        List<h8> r109 = f28124f;     // Catch: Throwable -> L35
        monitor-enter(r109);     // Catch: Throwable -> L35
        f28124f.add(r108);     // Catch: Throwable -> L31
        if (f28124f.size() < 15) goto L29;
        a();     // Catch: Throwable -> L31
    L29:
        monitor-exit(r109);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
        goto L42
    L17:
        r105.put("type", m6.f27619g);     // Catch: Throwable -> L35
        goto L18
    L41:
        return;
    }
}
