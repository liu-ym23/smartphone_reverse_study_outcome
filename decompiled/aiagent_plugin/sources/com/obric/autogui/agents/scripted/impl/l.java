package com.obric.autogui.agents.scripted.impl;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ScriptBlockManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements com.obric.autogui.agents.vlm.models.impl.e.f.b {
    private static final String TAG = "Script-ScriptBlockManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f27011a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Keva f27012b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, c> f27013c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> f27014d = null;

    /* JADX INFO: compiled from: ScriptBlockManager.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("implements")
        private final Map<String, b> f27015a;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27015a, r6.f27015a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f27015a.hashCode();
        }

        public String toString() {
            return "AbilityBlockData(implements=" + this.f27015a + ')';
        }

        public a(Map<String, b> r3) {
            Map<String, b> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "implements");
            this.f27015a = r4;
        }

        public /* synthetic */ a(Map r2, int r3, d.h.b.h r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            if ((r3 & 1) == 0) goto L5;
            r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        L5:
            this(r5);
        }

        public final Map<String, b> a() {
            return this.f27015a;
        }
    }

    /* JADX INFO: compiled from: ScriptBlockManager.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("failureCount")
        private int f27016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("lastFailureTime")
        private long f27017b;

        public b() {
            this(0, 0, 3, null);
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
            return false;
        L8:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
            if (this.f27016a == r8.f27016a) goto L12;
            return false;
        L12:
            if (this.f27017b == r8.f27017b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f27016a) * 31) + Long.hashCode(this.f27017b);
        }

        public String toString() {
            return "ImplementBlockData(failureCount=" + this.f27016a + ", lastFailureTime=" + this.f27017b + ')';
        }

        public b(int r1, long r2) {
            this.f27016a = r1;
            this.f27017b = r2;
        }

        public /* synthetic */ b(int r1, long r2, int r4, d.h.b.h r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = 0;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r2 = 0;
        L8:
            this(r1, r2);
        }

        public final int a() {
            return this.f27016a;
        }

        public final void a(int r1) {
            this.f27016a = r1;
        }

        public final void a(long r1) {
            this.f27017b = r1;
        }
    }

    /* JADX INFO: compiled from: ScriptBlockManager.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("abilities")
        private final Map<String, a> f27018a;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27018a, r6.f27018a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f27018a.hashCode();
        }

        public String toString() {
            return "UserBlockData(abilities=" + this.f27018a + ')';
        }

        public c(Map<String, a> r3) {
            Map<String, a> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "abilities");
            this.f27018a = r4;
        }

        public /* synthetic */ c(Map r2, int r3, d.h.b.h r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            if ((r3 & 1) == 0) goto L5;
            r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        L5:
            this(r5);
        }

        public final Map<String, a> a() {
            return this.f27018a;
        }
    }

    /* JADX INFO: renamed from: lambda$3vGWY0039mGiWu1mJUTVixg2-Ws, reason: not valid java name */
    public static /* synthetic */ a m727lambda$3vGWY0039mGiWu1mJUTVixg2Ws(d.h.a.b r0, Object r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ b lambda$87CZUbH5Z34VUCHhnP2x5CmlSjg(d.h.a.b r0, Object r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ ConcurrentHashMap lambda$8iYj67QC_XXsMYpFqBohDGyzCu0(d.h.a.b r0, Object r1) {
        return f(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$AP4-nUbNl1FJ2jdPKH59JgMhlZg, reason: not valid java name */
    public static /* synthetic */ b m728lambda$AP4nUbNl1FJ2jdPKH59JgMhlZg(String r0) {
        return h(r0);
    }

    public static /* synthetic */ a lambda$G0_pCtpUrOuIpkZM8WNtj5mPG4A(String r0) {
        return g(r0);
    }

    /* JADX INFO: renamed from: lambda$I-YC0OI6hzcfTp_VGRvhq8OhsoQ, reason: not valid java name */
    public static /* synthetic */ a m729lambda$IYC0OI6hzcfTp_VGRvhq8OhsoQ(d.h.a.b r0, Object r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$KKJe9Z-0__Z0Xu4NaKMWBRKL5YY, reason: not valid java name */
    public static /* synthetic */ Integer m730lambda$KKJe9Z0__Z0Xu4NaKMWBRKL5YY(d.h.a.m r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ ConcurrentHashMap lambda$QkoHXYrq6XCgg1X0_lm8wNKOEjU(String r0) {
        return k(r0);
    }

    public static /* synthetic */ b lambda$ayATs93LlmkM6DnrLsgSnLYQpSw(d.h.a.b r0, Object r1) {
        return e(r0, r1);
    }

    public static /* synthetic */ c lambda$eaYFLr1W7ZEvY7WQlatC20ZIln0(String r0) {
        return f(r0);
    }

    public static /* synthetic */ a lambda$iVM8mWauwL7oZC6U4GvHoOI3Jls(String r0) {
        return i(r0);
    }

    /* JADX INFO: renamed from: lambda$p2-3SVuML5j9Pba8dr2ImvElN6E, reason: not valid java name */
    public static /* synthetic */ b m731lambda$p23SVuML5j9Pba8dr2ImvElN6E(String r0) {
        return j(r0);
    }

    public static /* synthetic */ Integer lambda$tvv05YD8S3UE5D1kAJSW9nY3YTc(int r0, z.a r1, String r2, Integer r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$zc-xa761qcvj-YOcXgww4DpEyFY, reason: not valid java name */
    public static /* synthetic */ c m732lambda$zcxa761qcvjYOcXgww4DpEyFY(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    public final int a() {
        return 5;
    }

    private l() {
    }

    static {
        f27011a = new l();
        Keva r0 = Keva.getRepo("script_block_manager", 0);
        d.h.b.o.c(r0, "getRepo(...)");
        f27012b = r0;
        f27013c = new ConcurrentHashMap();
        f27014d = new ConcurrentHashMap();
    }

    private final String c() {
        return com.obric.aiagent.utils.a.a.f22293a.b();
    }

    private final String d(String r2) {
        return "script_block_" + r2;
    }

    private static final c a(d.h.a.b r2, Object r3) {
        return (c) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), c.class, "com.obric.aiagent.plugin");
    }

    private final c e(String r3) {
        ConcurrentHashMap<String, c> r2 = f27013c;
        final $$Lambda$l$eaYFLr1W7ZEvY7WQlatC20ZIln0 r0 = $$Lambda$l$eaYFLr1W7ZEvY7WQlatC20ZIln0.INSTANCE;
        c r4 = r2.computeIfAbsent(r3, new $$Lambda$l$zcxa761qcvjYOcXgww4DpEyFY(r0));
        d.h.b.o.c(r4, "computeIfAbsent(...)");
        return (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final c f(String r6) {
        d.h.b.o.e(r6, DbHelper.COL_ID);
        Map r2 = null;
        Object[] r3 = 0;
        Object[] r4 = 0;
        Object[] r5 = 0;
        Object[] r7 = 0;
        Object[] r8 = 0;
        String r0 = f27012b.getString(f27011a.d(r6), null);
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        int r9 = 1;
        if (r1 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == true) goto L17;
        c r11 = (c) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r0, new ScriptBlockManager$getUserData$1$type$1().getType()), c.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        if (r11 != null) goto L20;
        return new c(r7 == true ? 1 : 0, r9, r5 == true ? 1 : 0);
    L20:
        return r11;
    L14:
        e = move-exception;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "parse json failed for user " + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return new c(r4 == true ? 1 : 0, r9, r3 == true ? 1 : 0);
    L17:
        return new c(r2, r9, r8 == true ? 1 : 0);
    L5:
        if (r1.length() == 0) goto L8;
        r10 = false;
        goto L9
    }

    private final boolean a(String r2, c r3) {
        f27012b.storeString(d(r2), new Gson().toJson(r3));     // Catch: Exception -> L4
        return true;
    L4:
        e = move-exception;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "save user data failed for user " + r2, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.f.b
    public synchronized void a(String r8, String r9) {
        monitor-enter(this);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        boolean r1 = false;
        if (r0 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L24;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r3 != null) goto L14;
    L15:
        r1 = true;
    L16:
        if (r1 == true) goto L24;
        String r4 = c();     // Catch: Throwable -> L26
        c r5 = e(r4);     // Catch: Throwable -> L26
        Map<String, a> r6 = r5.a();     // Catch: Throwable -> L26
        final $$Lambda$l$G0_pCtpUrOuIpkZM8WNtj5mPG4A r7 = $$Lambda$l$G0_pCtpUrOuIpkZM8WNtj5mPG4A.INSTANCE;     // Catch: Throwable -> L26
        a r10 = r6.computeIfAbsent(r8, new $$Lambda$l$IYC0OI6hzcfTp_VGRvhq8OhsoQ(r7));     // Catch: Throwable -> L26
        d.h.b.o.c(r10, "computeIfAbsent(...)");     // Catch: Throwable -> L26
        Map<String, b> r11 = ((a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L26
        final $$Lambda$l$AP4nUbNl1FJ2jdPKH59JgMhlZg r12 = $$Lambda$l$AP4nUbNl1FJ2jdPKH59JgMhlZg.INSTANCE;     // Catch: Throwable -> L26
        b r13 = r11.computeIfAbsent(r9, new $$Lambda$l$87CZUbH5Z34VUCHhnP2x5CmlSjg(r12));     // Catch: Throwable -> L26
        d.h.b.o.c(r13, "computeIfAbsent(...)");     // Catch: Throwable -> L26
        b r14 = (b) ZeusTransformUtils.preCheckCast(r13, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        r14.a(r14.a() + 1);     // Catch: Throwable -> L26
        r14.a(System.currentTimeMillis());     // Catch: Throwable -> L26
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L21;
        Loog.INSTANCE.w(TAG, "recordPersistentFailure: ability=" + r8 + ", implementName=" + r9 + ", userId=" + r4 + ", count=" + r14.a());     // Catch: Throwable -> L26
    L21:
        a(r4, r5);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L14:
        if (r3.length() != 0) goto L16;
    L24:
        monitor-exit(this);
        return;
    L6:
        if (r0.length() == 0) goto L9;
        r2 = false;
    L26:
        th = move-exception;
        throw th;
    }

    private static final a b(d.h.a.b r2, Object r3) {
        return (a) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), a.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final a g(String r2) {
        d.h.b.o.e(r2, "it");
        return new a(null, 1, 0 == true ? 1 : 0);
    }

    private static final b c(d.h.a.b r2, Object r3) {
        return (b) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), b.class, "com.obric.aiagent.plugin");
    }

    private static final b h(String r7) {
        d.h.b.o.e(r7, "it");
        return new b(0, 0, 3, null);
    }

    public final synchronized List<String> a(String r10) {
        monitor-enter(this);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r0 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L14;
        List<String> r11 = d.a.p.b();     // Catch: Throwable -> L37
        monitor-exit(this);
        return r11;
    L14:
        String r2 = c();     // Catch: Throwable -> L37
        a r3 = (a) ZeusTransformUtils.preCheckCast(e(r2).a().get(r10), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r3 != null) goto L19;
        List<String> r12 = d.a.p.b();     // Catch: Throwable -> L37
        monitor-exit(this);
        return r12;
    L19:
        Map<String, b> r4 = r3.a();     // Catch: Throwable -> L37
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        Iterator<Map.Entry<String, b>> r6 = r4.entrySet().iterator();     // Catch: Throwable -> L37
    L21:
        if (r6.hasNext() == false) goto L28;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (((b) ZeusTransformUtils.preCheckCast(r7.getValue(), b.class, "com.obric.aiagent.plugin")).a() < 5) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == false) goto L21;
        r5.put(r7.getKey(), r7.getValue());     // Catch: Throwable -> L37
        goto L21
    L25:
        r8 = false;
        goto L26
    L28:
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r5.size()), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        Iterator r13 = r5.entrySet().iterator();     // Catch: Throwable -> L37
    L30:
        if (r13.hasNext() == false) goto L32;
        r9.add((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L37
        goto L30
    L32:
        List<String> r14 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L35;
        Loog.INSTANCE.d(TAG, "getBlockedImplementNames: abilityName=" + r10 + ", list=" + r14 + ", userId=" + r2);     // Catch: Throwable -> L37
    L35:
        monitor-exit(this);
        return r14;
    L6:
        if (r0.length() == 0) goto L9;
        r1 = false;
    L37:
        th = move-exception;
        throw th;
    }

    public final JsonArray b(String r4) {
        List<String> r3 = a(r4);
        JsonArray r5 = new JsonArray();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.add((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        return r5;
    }

    private final boolean b(String r6, String r7) {
        String r0 = c();
        c r1 = e(r0);
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.a().get(r6), a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L16;
        r2.a().remove(r7);
        if (r2.a().isEmpty() == false) goto L8;
        r1.a().remove(r6);
    L8:
        if (a(r0, r1) == true) goto L12;
        f27013c.remove(r0);
        return false;
    L12:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L17;
        Loog.INSTANCE.d(TAG, "clearFailureRecord: abilityName=" + r6 + ", implementName=" + r7 + ", userId=" + r0);
        return true;
    L17:
        return true;
    L16:
        return true;
    }

    public final synchronized boolean a(String r7, String r8, int r9) {
        monitor-enter(this);
        d.h.b.o.e(r7, "abilityName");     // Catch: Throwable -> L29
        d.h.b.o.e(r8, "implementName");     // Catch: Throwable -> L29
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L25;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L25;
        if (r9 < 0) goto L25;
        if (r9 != 0) goto L13;
        boolean r10 = b(r7, r8);     // Catch: Throwable -> L29
        monitor-exit(this);
        return r10;
    L13:
        String r0 = c();     // Catch: Throwable -> L29
        c r2 = e(r0);     // Catch: Throwable -> L29
        Map<String, a> r3 = r2.a();     // Catch: Throwable -> L29
        final $$Lambda$l$iVM8mWauwL7oZC6U4GvHoOI3Jls r4 = $$Lambda$l$iVM8mWauwL7oZC6U4GvHoOI3Jls.INSTANCE;     // Catch: Throwable -> L29
        a r5 = r3.computeIfAbsent(r7, new $$Lambda$l$3vGWY0039mGiWu1mJUTVixg2Ws(r4));     // Catch: Throwable -> L29
        d.h.b.o.c(r5, "computeIfAbsent(...)");     // Catch: Throwable -> L29
        Map<String, b> r6 = ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L29
        final $$Lambda$l$p23SVuML5j9Pba8dr2ImvElN6E r11 = $$Lambda$l$p23SVuML5j9Pba8dr2ImvElN6E.INSTANCE;     // Catch: Throwable -> L29
        b r12 = r6.computeIfAbsent(r8, new $$Lambda$l$ayATs93LlmkM6DnrLsgSnLYQpSw(r11));     // Catch: Throwable -> L29
        d.h.b.o.c(r12, "computeIfAbsent(...)");     // Catch: Throwable -> L29
        b r13 = (b) ZeusTransformUtils.preCheckCast(r12, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        r13.a(r9);     // Catch: Throwable -> L29
        r13.a(System.currentTimeMillis());     // Catch: Throwable -> L29
        if (a(r0, r2) == true) goto L19;
        f27013c.remove(r0);     // Catch: Throwable -> L29
        monitor-exit(this);
        return false;
    L19:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L22;
        Loog.INSTANCE.d(TAG, "setPersistentFailureCountForDebug: abilityName=" + r7 + ", implementName=" + r8 + ", failureCount=" + r9 + ", userId=" + r0);     // Catch: Throwable -> L29
    L22:
        monitor-exit(this);
        return true;
    L25:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L27;
        Loog.INSTANCE.w(TAG, "setPersistentFailureCountForDebug: invalid input, abilityName=" + r7 + ", implementName=" + r8 + ", failureCount=" + r9);     // Catch: Throwable -> L29
    L27:
        monitor-exit(this);
        return false;
    L29:
        th = move-exception;
        throw th;
    }

    private static final a d(d.h.a.b r2, Object r3) {
        return (a) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), a.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final a i(String r2) {
        d.h.b.o.e(r2, "it");
        return new a(null, 1, 0 == true ? 1 : 0);
    }

    private static final b e(d.h.a.b r2, Object r3) {
        return (b) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), b.class, "com.obric.aiagent.plugin");
    }

    private static final b j(String r7) {
        d.h.b.o.e(r7, "it");
        return new b(0, 0, 3, null);
    }

    public final synchronized void b() {
        monitor-enter(this);
        String r0 = c();     // Catch: Throwable -> L8
        f27013c.remove(r0);     // Catch: Throwable -> L8
        f27012b.erase(d(r0));     // Catch: Throwable -> L8
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L6;
        Loog.INSTANCE.d(TAG, "clearAll for userId=" + r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.f.b
    public boolean a(String r8, String r9, boolean r10) {
        d.h.b.o.e(r8, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r9, "ability");
        int r2 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L9;
    L25:
        Loog.INSTANCE.w(TAG, "checkAndUpdateSessionBlock: invalid sessionId=" + r8 + " or ability=" + r9);
        return false;
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == true) goto L25;
        if (r10 == false) goto L16;
        return true;
    L16:
        final int r12 = com.obric.autogui.agents.scripted.c.b.f26918a.t();
        ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> r13 = f27014d;
        final $$Lambda$l$QkoHXYrq6XCgg1X0_lm8wNKOEjU r1 = $$Lambda$l$QkoHXYrq6XCgg1X0_lm8wNKOEjU.INSTANCE;
        ConcurrentHashMap<String, Integer> r14 = r13.computeIfAbsent(r8, new $$Lambda$l$8iYj67QC_XXsMYpFqBohDGyzCu0(r1));
        d.h.b.o.c(r14, "computeIfAbsent(...)");
        ConcurrentHashMap r15 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r14, ConcurrentHashMap.class, "com.obric.aiagent.plugin");
        final z.a r3 = new z.a();
        final d.h.a.m r4 = new $$Lambda$l$tvv05YD8S3UE5D1kAJSW9nY3YTc(r12, r3);
        r15.compute(r9, new $$Lambda$l$KKJe9Z0__Z0Xu4NaKMWBRKL5YY(r4));
        if (r3.f38499a == false) goto L19;
        Loog.INSTANCE.w(TAG, "sessionId=" + r8 + ", ability=" + r9 + " reached session block threshold (" + r12 + "), will block");
    L24:
        return r3.f38499a;
    L19:
        Integer r16 = (Integer) ZeusTransformUtils.preCheckCast(r15.get(r9), Integer.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L22;
        r2 = r16.intValue();
    L22:
        Loog.INSTANCE.d(TAG, "sessionId=" + r8 + ", ability=" + r9 + " block count: " + r2 + '/' + r12);
        goto L24
    L11:
        r11 = false;
        goto L12
    L5:
        r7 = false;
        goto L7
    }

    private static final ConcurrentHashMap f(d.h.a.b r2, Object r3) {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    }

    private static final ConcurrentHashMap k(String r1) {
        d.h.b.o.e(r1, "it");
        return new ConcurrentHashMap();
    }

    private static final Integer a(d.h.a.m r2, Object r3, Object r4) {
        return (Integer) ZeusTransformUtils.preCheckCast(((d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin")).invoke(r3, r4), Integer.class, "com.obric.aiagent.plugin");
    }

    private static final Integer a(int r1, z.a r2, String r3, Integer r4) {
        d.h.b.o.e(r3, "<unused var>");
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L7:
        if (r5 < r1) goto L10;
        r2.f38499a = true;
        return Integer.valueOf(r5);
    L10:
        return Integer.valueOf(r5 + 1);
    L5:
        r5 = 0;
        goto L7
    }

    public final void c(String r3) {
        d.h.b.o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        f27014d.remove(r3);
        Loog.INSTANCE.d(TAG, "clearSessionData for sessionId=" + r3);
    }
}
