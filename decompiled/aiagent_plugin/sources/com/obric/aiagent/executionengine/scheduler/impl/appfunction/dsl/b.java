package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import android.app.ActivityOptions;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.AppFunctionCallResult;
import com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionInvoker;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.AppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.f;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AppFunctionDslEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "AppFunctionDslEngine";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, IAppFunctionConvert> f18160b = null;

    /* JADX INFO: compiled from: AppFunctionDslEngine.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JsonElement f18161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JsonElement f18162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LinkedHashMap<String, C0377b> f18163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final LinkedHashMap<String, JsonElement> f18164d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f18161a, r6.f18161a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f18162b, r6.f18162b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f18163c, r6.f18163c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f18164d, r6.f18164d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f18161a.hashCode() * 31) + this.f18162b.hashCode()) * 31) + this.f18163c.hashCode()) * 31) + this.f18164d.hashCode();
        }

        public String toString() {
            return "ExecutionContext(intentParams=" + this.f18161a + ", requestExt=" + this.f18162b + ", nodeResults=" + this.f18163c + ", nodeOutputJson=" + this.f18164d + ')';
        }

        public a(JsonElement r2, JsonElement r3, LinkedHashMap<String, C0377b> r4, LinkedHashMap<String, JsonElement> r5) {
            o.e(r2, "intentParams");
            o.e(r3, "requestExt");
            o.e(r4, "nodeResults");
            o.e(r5, "nodeOutputJson");
            this.f18161a = r2;
            this.f18162b = r3;
            this.f18163c = r4;
            this.f18164d = r5;
        }

        public final JsonElement a() {
            return this.f18161a;
        }

        public final JsonElement b() {
            return this.f18162b;
        }

        public /* synthetic */ a(JsonElement r1, JsonElement r2, LinkedHashMap r3, LinkedHashMap r4, int r5, h r6) {
            if ((r5 & 4) == 0) goto L6;
            r3 = new LinkedHashMap();
        L6:
            if ((r5 & 8) == 0) goto L8;
            r4 = new LinkedHashMap();
        L8:
            this(r1, r2, r3, r4);
        }

        public final LinkedHashMap<String, C0377b> c() {
            return this.f18163c;
        }

        public final LinkedHashMap<String, JsonElement> d() {
            return this.f18164d;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppFunctionDslEngine.kt */
    private static final class C0377b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f18165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f18167c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f18168d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final PendingIntent f18169e;
        private final String f;

        public static /* synthetic */ C0377b a(C0377b r4, boolean r5, int r6, String r7, String r8, PendingIntent r9, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.f18165a;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.f18166b;
        L8:
            int r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.f18167c;
        L11:
            String r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.f18168d;
        L14:
            String r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.f18169e;
        L17:
            PendingIntent r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.f;
        L20:
            boolean r14 = r5;
            return r4.a(r14, r13, r0, r1, r2, r10);
        }

        public final C0377b a(boolean r8, int r9, String r10, String r11, PendingIntent r12, String r13) {
            return new C0377b(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0377b.class) == true) goto L8;
            return false;
        L8:
            C0377b r6 = (C0377b) ZeusTransformUtils.preCheckCast(r5, C0377b.class, "com.obric.aiagent.plugin");
            if (this.f18165a == r6.f18165a) goto L12;
            return false;
        L12:
            if (this.f18166b == r6.f18166b) goto L15;
            return false;
        L15:
            if (o.a(this.f18167c, r6.f18167c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f18168d, r6.f18168d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f18169e, r6.f18169e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((Boolean.hashCode(this.f18165a) * 31) + Integer.hashCode(this.f18166b)) * 31;
            String r1 = this.f18167c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f18168d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            PendingIntent r8 = this.f18169e;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.f;
            if (r11 == null) goto L19;
            r2 = r11.hashCode();
        L19:
            return r10 + r2;
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "NodeResult(success=" + this.f18165a + ", code=" + this.f18166b + ", message=" + this.f18167c + ", outputJson=" + this.f18168d + ", pendingIntent=" + this.f18169e + ", providerPackage=" + this.f + ')';
        }

        public C0377b(boolean r1, int r2, String r3, String r4, PendingIntent r5, String r6) {
            this.f18165a = r1;
            this.f18166b = r2;
            this.f18167c = r3;
            this.f18168d = r4;
            this.f18169e = r5;
            this.f = r6;
        }

        public /* synthetic */ C0377b(boolean r8, int r9, String r10, String r11, PendingIntent r12, String r13, int r14, h r15) {
            if ((r14 & 2) == 0) goto L5;
            r9 = 0;
        L5:
            int r2 = r9;
            if ((r14 & 4) == 0) goto L8;
            String r3 = null;
        L10:
            if ((r14 & 8) == 0) goto L12;
            String r4 = null;
        L14:
            if ((r14 & 16) == 0) goto L16;
            PendingIntent r5 = null;
        L18:
            if ((r14 & 32) == 0) goto L20;
            String r6 = null;
        L21:
            this(r8, r2, r3, r4, r5, r6);
            return;
        L20:
            r6 = r13;
            goto L21
        L16:
            r5 = r12;
            goto L18
        L12:
            r4 = r11;
            goto L14
        L8:
            r3 = r10;
            goto L10
        }

        public final boolean a() {
            return this.f18165a;
        }

        public final int b() {
            return this.f18166b;
        }

        public final String c() {
            return this.f18167c;
        }

        public final String d() {
            return this.f18168d;
        }

        public final PendingIntent e() {
            return this.f18169e;
        }

        public final String f() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: AppFunctionDslEngine.kt */
    @f(b = "AppFunctionDslEngine.kt", c = {78}, d = "execute", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.AppFunctionDslEngine")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18173d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f18174e;
        Object f;
        Object g;
        Object h;
        Object i;
        long j;
        long k;
        /* synthetic */ Object l;
        final /* synthetic */ b m;
        int n;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.m = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.l = r7;
            this.n |= Integer.MIN_VALUE;
            return this.m.a(null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppFunctionDslEngine.kt */
    @f(b = "AppFunctionDslEngine.kt", c = {188}, d = "executeConvertNode", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.AppFunctionDslEngine")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f18175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f18176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f18177c;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18176b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            this.f18175a = r10;
            this.f18177c |= Integer.MIN_VALUE;
            return b.a(this.f18176b, null, null, null, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppFunctionDslEngine.kt */
    @f(b = "AppFunctionDslEngine.kt", c = {160}, d = "executeFunctionNode", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.AppFunctionDslEngine")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f18180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f18181d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f18182e;

        e(b r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18181d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18180c = r3;
            this.f18182e |= Integer.MIN_VALUE;
            return b.a(this.f18181d, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private static final double a(double r0, double r2) {
        return r0 + r2;
    }

    private static final double b(double r0, double r2) {
        return r0 * r2;
    }

    public static /* synthetic */ double lambda$1u3y7osbk92LUdMDuoOLdrN6Jy0(double r0, double r2) {
        return a(r0, r2);
    }

    public static /* synthetic */ double lambda$blRS2nSPL4RmqZpR30Bsm5QY2fI(double r0, double r2) {
        return b(r0, r2);
    }

    public static /* synthetic */ CharSequence lambda$zmslW_Es69AHMyKE0Y9H1SZqze0(JsonElement r0) {
        return h(r0);
    }

    private b() {
    }

    public static final /* synthetic */ Object a(b r2, AppFunctionNode r3, JsonObject r4, IAppFunctionInvoker r5, d.c.d r6) {
        return r2.a(r3, r4, (IAppFunctionInvoker) ZeusTransformUtils.wrapperContextForParams(r5, IAppFunctionInvoker.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r10, AppFunctionNode r11, JsonObject r12, a r13, AppAction r14, com.obric.aiagent.executionengine.scheduler.impl.job.c r15, long r16, d.c.d r18) {
        return r10.a(r11, r12, r13, r14, r15, r16, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f18159a = new b();
        f18160b = new ConcurrentHashMap();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0281 -> B:80:0x0295). Please report as a decompilation issue!!! */
    public final Object a(AppAction r33, com.obric.aiagent.executionengine.scheduler.impl.job.c r34, long r35, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r37) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r37, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L7;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
        if ((r5.n & Integer.MIN_VALUE) == 0) goto L7;
        r5.n -= Integer.MIN_VALUE;
    L8:
        Object r1 = r5.l;
        Object r6 = d.c.a.b.a();
        int r7 = r5.n;
        String r9 = TAG;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        long r2 = r5.k;
        long r10 = r5.j;
        AppFunctionNode r3 = (AppFunctionNode) ZeusTransformUtils.preCheckCast(r5.i, AppFunctionNode.class, "com.obric.aiagent.plugin");
        Iterator<AppFunctionNode> r8 = (Iterator) ZeusTransformUtils.preCheckCast(r5.h, Iterator.class, "com.obric.aiagent.plugin");
        a r12 = (a) ZeusTransformUtils.preCheckCast(r5.g, a.class, "com.obric.aiagent.plugin");
        AppFunctionResultNode r13 = (AppFunctionResultNode) ZeusTransformUtils.preCheckCast(r5.f, AppFunctionResultNode.class, "com.obric.aiagent.plugin");
        IAppFunctionInvoker r14 = (IAppFunctionInvoker) ZeusTransformUtils.preCheckCast(r5.f18174e, IAppFunctionInvoker.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r5.f18173d, String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.scheduler.impl.job.c r4 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r5.f18172c, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        AppAction r15 = (AppAction) ZeusTransformUtils.preCheckCast(r5.f18171b, AppAction.class, "com.obric.aiagent.plugin");
        b r16 = (b) ZeusTransformUtils.preCheckCast(r5.f18170a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r1);     // Catch: Throwable -> L14
        long r18 = r2;
        String r17 = TAG;
        long r19 = r10;
        com.obric.aiagent.executionengine.scheduler.impl.job.c r20 = r4;
        String r110 = r11;
        Iterator<AppFunctionNode> r21 = r8;
        Object r22 = r6;
        a r23 = r12;
    L80:
        C0377b r24 = (C0377b) ZeusTransformUtils.preCheckCast(r1, C0377b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L62
        ((Map) ZeusTransformUtils.preCheckCast(r23.c(), Map.class, "com.obric.aiagent.plugin")).put(r3.getId(), r24);     // Catch: Throwable -> L62
        AppAction r32 = r15;
        ((Map) ZeusTransformUtils.preCheckCast(r23.d(), Map.class, "com.obric.aiagent.plugin")).put(r3.getId(), r16.b(r24.d()));     // Catch: Throwable -> L62
        if (r24.a() == true) goto L58;
        ILogDepend.Companion.e(r17, "DSL node failed: node=" + r3.getId() + ", code=" + r24.b() + ", msg=" + r24.c());     // Catch: Throwable -> L62
        return r16.a(r23, r13, r24, r20, r110, r19, r18);
    L58:
        PendingIntent r25 = r24.e();     // Catch: Throwable -> L62
        if (r25 == null) goto L61;
        f18159a.a(r25);     // Catch: Throwable -> L62
    L61:
        AppAction r26 = r32;
        com.obric.aiagent.executionengine.scheduler.impl.job.c r111 = r20;
        String r112 = r110;
        AppFunctionResultNode r113 = r13;
        r9 = r17;
        long r27 = r19;
        long r28 = r18;
        Iterator<AppFunctionNode> r29 = r21;
        a r30 = r23;
        r6 = r22;
        Iterator<AppFunctionNode> r31 = r29;
    L84:
    L69:
        th = th;
    L36:
        r17 = r9;
    L73:
        ILogDepend.Companion.e(r17, "DSL execution failed", th);
        String r36 = th.getMessage();
        if (r36 != null) goto L77;
        r36 = "AppFunction DSL execution failed";
    L77:
        return r16.a(r36, r27);
    L47:
        if (r31.hasNext() == false) goto L64;
        AppFunctionNode r114 = (AppFunctionNode) ZeusTransformUtils.preCheckCast(r31.next(), AppFunctionNode.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L69
        JsonObject r115 = r16.a(r114, r30);     // Catch: Throwable -> L69
        r5.f18170a = r16;     // Catch: Throwable -> L69
        r5.f18171b = r26;     // Catch: Throwable -> L69
        r5.f18172c = r111;     // Catch: Throwable -> L69
        r5.f18173d = r112;     // Catch: Throwable -> L69
        r5.f18174e = r14;     // Catch: Throwable -> L69
        r5.f = r113;     // Catch: Throwable -> L69
        r5.g = r30;     // Catch: Throwable -> L69
        r5.h = r31;     // Catch: Throwable -> L69
        r5.i = r114;     // Catch: Throwable -> L69
        r5.j = r27;     // Catch: Throwable -> L69
        r17 = r9;
        AppFunctionResultNode r116 = r113;
        long r38 = r28;
        r5.k = r38;     // Catch: Throwable -> L67
        Iterator<AppFunctionNode> r39 = r31;
        r5.n = 1;     // Catch: Throwable -> L67
        Object r40 = r16.a(r114, r115, r30, r26, r111, r27, r14, r5);     // Catch: Throwable -> L67
        if (r40 != r6) goto L53;
        return r6;
    L53:
        r18 = r38;
        r20 = r111;
        r110 = r112;
        a r210 = r30;
        r21 = r39;
        long r310 = r27;
        r15 = r26;
        r1 = r40;
        r3 = r114;
        r13 = r116;
        r19 = r310;
        r22 = r6;
        r23 = r210;
    L67:
        th = th;
        goto L73
    L64:
        r17 = r9;
        AppFunctionResultNode r117 = r113;
        long r41 = r28;
        Collection<C0377b> r42 = r30.c().values();     // Catch: Throwable -> L67
        o.c(r42, "<get-values>(...)");     // Catch: Throwable -> L67
        Object r43 = p.g((Iterable) ZeusTransformUtils.preCheckCast(r42, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L67
        o.c(r43, "last(...)");     // Catch: Throwable -> L67
        return r16.a(r30, r117, (C0377b) ZeusTransformUtils.preCheckCast(r43, C0377b.class, "com.obric.aiagent.plugin"), r111, r112, r27, r41);
    L62:
        th = th;
        r27 = r19;
    L14:
        th = th;
        r17 = TAG;
        r27 = r10;
        goto L73
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r1);
        String r44 = r33.getAction();
        AppFunctionIntentMapping r45 = com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.a.f18157a.a(r44);
        if (r45 != null) goto L22;
        ILogDepend.Companion.e(TAG, "no AppFunction DSL mapping found for intent=" + r44);
        return a("no AppFunction DSL mapping: " + r44, r35);
    L22:
        IAppFunctionInvoker r46 = (IAppFunctionInvoker) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppFunctionInvoker.class), IAppFunctionInvoker.class, "com.obric.aiagent.plugin");
        if (r46 == null) goto L25;
        r113 = r45.getResult();
        long r118 = System.currentTimeMillis();     // Catch: Throwable -> L71
        JsonElement r119 = b(r33.getParams());     // Catch: Throwable -> L71
        IMAppActionExt r120 = r34.b().getExt();     // Catch: Throwable -> L71
        if (r120 != null) goto L86;
        JsonObject r121 = new JsonObject();     // Catch: Throwable -> L71
    L38:
        a r47 = new a(r119, (JsonElement) ZeusTransformUtils.preCheckCast(r121, JsonElement.class, "com.obric.aiagent.plugin"), null, null, 12, null);     // Catch: Throwable -> L71
        ILogDepend.Companion r48 = ILogDepend.Companion;     // Catch: Throwable -> L71
        StringBuilder r49 = new StringBuilder().append("execute DSL intent=").append(r44).append(", nodes=");     // Catch: Throwable -> L71
        Iterable r122 = (Iterable) ZeusTransformUtils.preCheckCast(r45.getFunctions(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
        Collection r123 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r122, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
        Iterator r124 = r122.iterator();     // Catch: Throwable -> L71
    L40:
        if (r124.hasNext() == false) goto L43;
        String r125 = r44;
        r123.add(((AppFunctionNode) ZeusTransformUtils.preCheckCast(r124.next(), AppFunctionNode.class, "com.obric.aiagent.plugin")).getId());     // Catch: Throwable -> L34
        r44 = r125;
    L34:
        th = th;
        r16 = this;
        r27 = r35;
        goto L36
    L43:
        String r126 = r44;
        r48.i(TAG, r49.append((List) ZeusTransformUtils.preCheckCast(r123, List.class, "com.obric.aiagent.plugin")).append(", jobId=").append(r34.e()).toString());     // Catch: Throwable -> L71
        r27 = r35;
        r31 = r45.getFunctions().iterator();     // Catch: Throwable -> L71
        r14 = r46;
        r28 = r118;
        r112 = r126;
        r26 = r33;
        r111 = r34;
        r30 = r47;
        r16 = this;
        goto L84
    L86:
        r121 = new JsonObject();     // Catch: Throwable -> L34
        Iterator r50 = ((Map) ZeusTransformUtils.preCheckCast(r120, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();     // Catch: Throwable -> L34
    L31:
        if (r50.hasNext() == false) goto L38;
        Iterator r127 = r50;
        Map.Entry r51 = (Map.Entry) ZeusTransformUtils.preCheckCast(r50.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        r121.addProperty((String) ZeusTransformUtils.preCheckCast(r51.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r51.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
        r50 = r127;
    L71:
        th = th;
        r17 = TAG;
        r16 = this;
        r27 = r35;
        goto L73
    L25:
        return a("IAppFunctionInvoker unavailable", r35);
    L7:
        r5 = new c(this, r0);
        goto L8
    }

    private final com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c a(a r1, AppFunctionResultNode r2, C0377b r3, com.obric.aiagent.executionengine.scheduler.impl.job.c r4, String r5, long r6, long r8) {
        IntentResult<?> r0 = a(r1, r2, r3);
        if (r0.getRet() != 201) goto L15;
        String r7 = r3.f();
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L7;
    L10:
        boolean r10 = true;
    L11:
        if (r10 == true) goto L13;
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.a.a.f18146a.a(r4.d(), r7, r5);
        goto L15
    L13:
        ILogDepend.Companion.w(TAG, "privacy 201 but no provider pkg, skip consent watch: intent=" + r5);
        goto L15
    L7:
        if (r9.length() == 0) goto L10;
        r10 = false;
    L15:
        return com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a.a(r0, r6, Long.valueOf(System.currentTimeMillis() - r8));
    }

    private final Object a(AppFunctionNode r12, JsonObject r13, a r14, AppAction r15, com.obric.aiagent.executionengine.scheduler.impl.job.c r16, long r17, IAppFunctionInvoker r19, d.c.d<? super C0377b> r20) {
        IAppFunctionInvoker r0 = (IAppFunctionInvoker) ZeusTransformUtils.wrapperContextForParams(r19, IAppFunctionInvoker.class, "com.obric.aiagent.plugin");
        d.c.d<? super C0377b> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (a(r12) == false) goto L7;
        return a(r12, r13, r14, r15, r16, r17, r10);
    L7:
        if (b(r12) == false) goto L11;
        return a(r12, r13, r0, r10);
    L11:
        throw new IllegalArgumentException("Unknown DSL node type: " + r12.getType());
    }

    private final Object a(AppFunctionNode r20, JsonObject r21, IAppFunctionInvoker r22, d.c.d<? super C0377b> r23) {
        b r0 = this;
        IAppFunctionInvoker r1 = (IAppFunctionInvoker) ZeusTransformUtils.wrapperContextForParams(r22, IAppFunctionInvoker.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L7;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        if ((r4.f18182e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f18182e -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f18180c;
        Object r6 = d.c.a.b.a();
        int r7 = r4.f18182e;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.c.a r2 = (com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.c.a) ZeusTransformUtils.preCheckCast(r4.f18179b, com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.c.a.class, "com.obric.aiagent.plugin");
        b r8 = (b) ZeusTransformUtils.preCheckCast(r4.f18178a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.c.a r9 = r2;
        r0 = r8;
        Object r10 = r5;
    L26:
        return C0377b.a(r0.a((AppFunctionCallResult) ZeusTransformUtils.preCheckCast(r10, AppFunctionCallResult.class, "com.obric.aiagent.plugin")), false, 0, null, null, null, r9.a(), 31, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r5);
        r9 = com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.c.f18183a.a(r20);
        if (r9 != null) goto L19;
        return new C0377b(false, -2002, "no AppFunction resolved for node=" + r20.getId() + " (schema=" + r20.getSchemaCategory() + '/' + r20.getSchemaName() + ", pkg=" + r20.getPackageName() + ", fn=" + r20.getFunctionId() + ')', null, null, null, 56, null);
    L19:
        if (com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.d.f18186a.a(r9.a(), r20.getAuthorizedSignatures()) == true) goto L22;
        ILogDepend.Companion.e(TAG, "signature check failed for node=" + r20.getId() + ", pkg=" + r9.a());
        return new C0377b(false, -2002, "signature not authorized: " + r9.a(), null, null, null, 56, null);
    L22:
        String r11 = r9.a();
        String r12 = r9.b();
        String r13 = r21.toString();
        o.c(r13, "toString(...)");
        r4.f18178a = r0;
        r4.f18179b = r9;
        r4.f18182e = 1;
        r10 = r1.execute(r11, r12, r13, r4);
        if (r10 != r6) goto L26;
        return r6;
    L7:
        r4 = new e(r0, r3);
        goto L8
    }

    private final Object a(AppFunctionNode r25, JsonObject r26, a r27, AppAction r28, com.obric.aiagent.executionengine.scheduler.impl.job.c r29, long r30, d.c.d<? super C0377b> r32) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r32, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L7;
        d r2 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        if ((r2.f18177c & Integer.MIN_VALUE) == 0) goto L7;
        r2.f18177c -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f18175a;
        Object r3 = d.c.a.b.a();
        int r4 = r2.f18177c;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        d.o.a(r1);
    L35:
        AppFunctionConvertResult r5 = (AppFunctionConvertResult) ZeusTransformUtils.preCheckCast(r1, AppFunctionConvertResult.class, "com.obric.aiagent.plugin");
        return new C0377b(r5.getSuccess(), r5.getCode(), r5.getMessage(), r5.getOutputJson(), null, null, 48, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r1);
        String r6 = r25.getConverterClassName();
        IAppFunctionConvert r7 = null;
        if (r6 != null) goto L17;
    L22:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == true) goto L37;
        if (r7 == null) goto L37;
        AppFunctionConvertRequest r12 = new AppFunctionConvertRequest(r28.getAction(), r29.d(), r29.c(), r30, r29.e(), r25.getId(), r6, r26.toString(), com.obric.aiagent.executionengine.utils.e.a().toJson(r27.c()), r25.getExtras(), null, 1024, null);
        r2.f18177c = 1;
        r1 = r7.execute(r12, r2);
        if (r1 != r3) goto L35;
        return r3;
    L37:
        ILogDepend.Companion.e(TAG, "no AppFunction convert impl found: node=" + r25.getId() + ", class=" + r6);
        return new C0377b(false, -2002, "no convert impl: " + r6, null, null, null, 56, null);
    L25:
        if (d.o.o.d(r8) == true) goto L28;
        r9 = false;
        goto L29
    L17:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L19;
        String r10 = r6;
    L20:
        if (r10 == null) goto L22;
        r7 = f18159a.a(r10);
        goto L22
    L19:
        r10 = null;
    L7:
        r2 = new d(this, r0);
        goto L8
    }

    private final IAppFunctionConvert a(String r7) {
        IAppFunctionConvert r0 = (IAppFunctionConvert) ZeusTransformUtils.preCheckCast(f18160b.get(r7), IAppFunctionConvert.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L24;
        return r0;
    L24:
        n.a r1 = n.f38560a;     // Catch: Throwable -> L12
        b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        Constructor r8 = ZeusTransformUtils.forName(r7, "com.obric.aiagent.plugin").getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L12
        r8.setAccessible(true);     // Catch: Throwable -> L12
        Object r9 = r8.newInstance(new Object[0]);     // Catch: Throwable -> L12
        if (ZeusTransformUtils.instanceOf(r9, IAppFunctionConvert.class) == false) goto L9;
        IAppFunctionConvert r10 = (IAppFunctionConvert) ZeusTransformUtils.preCheckCast(r9, IAppFunctionConvert.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
    L10:
        Object r11 = n.f(r10);     // Catch: Throwable -> L12
    L14:
        Throwable r2 = n.c(r11);
        if (r2 == null) goto L18;
        ILogDepend.Companion.e(TAG, "create AppFunction convert failed: " + r7, r2);
    L18:
        if (n.b(r11) == false) goto L20;
        r11 = null;
    L20:
        IAppFunctionConvert r12 = (IAppFunctionConvert) ZeusTransformUtils.preCheckCast(r11, IAppFunctionConvert.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L26;
        ((Map) ZeusTransformUtils.preCheckCast(f18160b, Map.class, "com.obric.aiagent.plugin")).put(r7, r12);
        return r12;
    L26:
        return null;
    L9:
        r10 = null;
    L12:
        th = move-exception;
        n.a r3 = n.f38560a;
        r11 = n.f(d.o.a(th));
        goto L14
    }

    private final boolean a(AppFunctionNode r4) {
        if (o.a(r4.getType(), "convert") == true) goto L13;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.getConverterClassName(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        return false;
    L7:
        if (d.o.o.d(r3) == true) goto L10;
        r5 = false;
    L13:
        return true;
    }

    private final boolean b(AppFunctionNode r5) {
        if (o.a(r5.getType(), "function") == true) goto L21;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.getFunctionId(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
    L10:
        boolean r6 = true;
    L11:
        if (r6 == false) goto L21;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.getSchemaName(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == false) goto L21;
        return false;
    L15:
        if (d.o.o.d(r7) == true) goto L18;
        r8 = false;
        goto L19
    L7:
        if (d.o.o.d(r4) == true) goto L10;
        r6 = false;
    L21:
        return true;
    }

    private final C0377b a(AppFunctionCallResult r11) {
        boolean r0 = false;
        if (r11.isStandardResult() == false) goto L8;
        Integer r10 = r11.getStandardCode();
        if (r10 == null) goto L7;
        int r12 = r10.intValue();
    L9:
        int r3 = r12;
    L10:
        String r13 = r11.getStandardMessage();
        if (r13 != null) goto L13;
        r13 = r11.getErrorMessage();
    L13:
        String r4 = r13;
        if (r11.isSuccess() == false) goto L18;
        if (r3 != 0) goto L18;
        r0 = true;
    L18:
        return new C0377b(r0, r3, r4, r11.getReturnJson(), r11.getPendingIntent(), null, 32, null);
    L7:
        r3 = 0;
        goto L10
    L8:
        r12 = r11.getCode();
        goto L9
    }

    private final IntentResult<Object> a(a r20, AppFunctionResultNode r21, C0377b r22) {
        Integer r1 = Integer.valueOf(r22.b());
        int r4 = 0;
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue() == 0) goto L5;
        boolean r2 = true;
    L6:
        Map<String, AppFunctionValueMapping> r5 = null;
        if (r2 == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L16;
        int r3 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue();
        b r6 = f18159a;
        if (r21 == null) goto L14;
        List<AppFunctionCodeMapping> r7 = r21.getCodeMappings();
    L15:
        r4 = r6.a(r7, r3, r22.c());
        goto L16
    L14:
        r7 = null;
    L16:
        int r8 = r4;
        if (r8 != 0) goto L22;
        if (r21 == null) goto L20;
        AppFunctionEntityTemplate r9 = r21.getEntity();
    L21:
        Object r10 = a(r9, r20);
    L23:
        ConcurrentHashMap<String, String> r11 = new ConcurrentHashMap();
        if (r21 == null) goto L26;
        r5 = r21.getExt();
    L26:
        if (r5 != null) goto L28;
        r5 = ao.b();
    L28:
        Iterator<Map.Entry<String, AppFunctionValueMapping>> r12 = r5.entrySet().iterator();
    L30:
        if (r12.hasNext() == false) goto L34;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.aiagent.plugin");
        AppFunctionValueMapping r15 = (AppFunctionValueMapping) ZeusTransformUtils.preCheckCast(r13.getValue(), AppFunctionValueMapping.class, "com.obric.aiagent.plugin");
        b r16 = f18159a;
        JsonElement r17 = r16.a(r15, r20);
        if (r17 == null) goto L30;
        r11.put(r14, r16.c(r17));
        goto L30
    L34:
        IntentResult<Object> r0 = new IntentResult(r8, null, null, r22.c(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        r0.setEntity(r10);
        r0.setExt(r11);
        return r0;
    L20:
        r9 = null;
        goto L21
    L22:
        r10 = null;
        goto L23
    L5:
        r2 = false;
        goto L6
    }

    private final int a(List<AppFunctionCodeMapping> r6, int r7, String r8) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
        return r7;
    L11:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r11.hasNext() == false) goto L30;
        Object r12 = r11.next();
        AppFunctionCodeMapping r3 = (AppFunctionCodeMapping) ZeusTransformUtils.preCheckCast(r12, AppFunctionCodeMapping.class, "com.obric.aiagent.plugin");
        if (r3.getSrcCode() == null) goto L22;
        Integer r4 = r3.getSrcCode();
        if (r4 != null) goto L20;
    L26:
        boolean r13 = false;
    L28:
        if (r13 == false) goto L13;
    L31:
        AppFunctionCodeMapping r14 = (AppFunctionCodeMapping) ZeusTransformUtils.preCheckCast(r12, AppFunctionCodeMapping.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L34;
        return r7;
    L34:
        ILogDepend.Companion.i(TAG, "map result code: " + r7 + " -> " + r14.getResultCode());
        return r14.getResultCode();
    L20:
        if (r4.intValue() != r7) goto L26;
    L22:
        if (r3.getSrcMessage() != null) goto L24;
    L27:
        r13 = true;
        goto L28
    L24:
        if (o.a(r3.getSrcMessage(), r8) == false) goto L26;
    L30:
        r12 = null;
        goto L31
    L5:
        if (r9.isEmpty() == true) goto L8;
        r10 = false;
        goto L9
    }

    private final Object a(AppFunctionEntityTemplate r12, a r13) {
        if (r12 != null) goto L5;
        return null;
    L5:
        Integer r2 = r12.getEntityType();
        if (r2 == null) goto L39;
        int r3 = r2.intValue();
        EntityClassData r5 = (EntityClassData) ZeusTransformUtils.preCheckCast(EntityType.INSTANCE.getClassMap().get(Integer.valueOf(r3)), EntityClassData.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L37;
        Class r6 = r5.getClazz();
        if (r6 == null) goto L37;
        JsonObject r7 = new JsonObject();
        r7.addProperty(DbHelper.COL_ID, "");
        r7.addProperty("createTime", "");
        r7.addProperty("createTimeStamp", (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(System.currentTimeMillis()), Number.class, "com.obric.aiagent.plugin"));
        r7.addProperty("lastModifiedTime", "");
        r7.addProperty("lastModifiedTimeStamp", (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(System.currentTimeMillis()), Number.class, "com.obric.aiagent.plugin"));
        r7.addProperty("type", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r3), Number.class, "com.obric.aiagent.plugin"));
        Iterator<Map.Entry<String, AppFunctionValueMapping>> r14 = r12.getFields().entrySet().iterator();
    L14:
        if (r14.hasNext() == false) goto L41;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin");
        AppFunctionValueMapping r9 = (AppFunctionValueMapping) ZeusTransformUtils.preCheckCast(r4.getValue(), AppFunctionValueMapping.class, "com.obric.aiagent.plugin");
        b r10 = f18159a;
        JsonElement r11 = r10.a(r9, r13);
        if (r11 != null) goto L18;
    L22:
        r11 = r10.a(r9);
    L23:
        if (r11 == null) goto L14;
        r7.add(r8, r11);
        goto L14
    L18:
        if (r11.isJsonNull() == false) goto L21;
        r11 = null;
    L21:
        if (r11 != null) goto L23;
    L41:
        n.a r15 = n.f38560a;     // Catch: Throwable -> L27
        b r16 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        Object r17 = n.f((AppEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r7, JsonElement.class, "com.obric.aiagent.plugin"), r6), AppEntity.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27
    L29:
        Throwable r18 = n.c(r17);
        if (r18 == null) goto L33;
        ILogDepend.Companion.e(TAG, "build AppFunction DSL entity failed: " + r7, r18);
    L33:
        if (n.b(r17) == false) goto L36;
        return null;
    L36:
        return r17;
    L27:
        th = move-exception;
        n.a r19 = n.f38560a;
        r17 = n.f(d.o.a(th));
    L37:
        b r110 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "unknown AppFunction DSL entity type: " + r3);
        return null;
    L39:
        b r111 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "AppFunction DSL entity type is null");
        return null;
    }

    private final JsonElement a(AppFunctionValueMapping r4) {
        JsonElement r3 = r4.getDefaultValue();
        if (r3 != null) goto L5;
    L10:
        String r5 = r4.getTargetType();
        if (r5 == null) goto L13;
        String r6 = r5.toLowerCase(Locale.ROOT);
        o.c(r6, "toLowerCase(...)");
    L14:
        if (r6 != null) goto L16;
        return null;
    L16:
        switch(r6.hashCode()) {
            case -1325958191: goto L38;
            case -891985903: goto L34;
            case 104431: goto L30;
            case 3029738: goto L26;
            case 3327612: goto L22;
            case 64711720: goto L19;
            default: goto L47;
        };
    L47:
        return null;
    L19:
        if (r6.equals(WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE) == true) goto L44;
        return null;
    L44:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(false), JsonElement.class, "com.obric.aiagent.plugin");
    L22:
        if (r6.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == true) goto L43;
        return null;
    L43:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(0L, Number.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L26:
        if (r6.equals("bool") == true) goto L44;
        return null;
    L30:
        if (r6.equals("int") == true) goto L45;
        return null;
    L45:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(0, Number.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L34:
        if (r6.equals(WsChannelMultiProcessSharedProvider.STRING_TYPE) == true) goto L46;
        return null;
    L46:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(""), JsonElement.class, "com.obric.aiagent.plugin");
    L38:
        if (r6.equals("double") == true) goto L41;
        return null;
    L41:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Double.valueOf(0.0d), Number.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L13:
        r6 = null;
        goto L14
    L5:
        if (r3.isJsonNull() == false) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L10;
        return r3;
    }

    private final JsonObject a(AppFunctionNode r5, a r6) {
        Map<String, AppFunctionValueMapping> r4 = r5.getParams();
        if (r4 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
    L14:
        JsonObject r8 = new JsonObject();
        Map<String, AppFunctionValueMapping> r9 = r5.getParams();
        if (r9 != null) goto L17;
        r9 = ao.b();
    L17:
        Iterator<Map.Entry<String, AppFunctionValueMapping>> r10 = r9.entrySet().iterator();
    L19:
        if (r10.hasNext() == false) goto L23;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        AppFunctionValueMapping r2 = (AppFunctionValueMapping) ZeusTransformUtils.preCheckCast(r0.getValue(), AppFunctionValueMapping.class, "com.obric.aiagent.plugin");
        JsonElement r3 = f18159a.a(r2, r6);
        if (r3 == null) goto L19;
        r8.add(r1, r3);
        goto L19
    L23:
        return r8;
    L11:
        if (r6.a().isJsonObject() == false) goto L14;
        JsonObject r11 = r6.a().getAsJsonObject();
        o.c(r11, "getAsJsonObject(...)");
        return r11;
    L5:
        if (r4.isEmpty() == true) goto L8;
        r7 = false;
        goto L9
    }

    private final JsonElement a(AppFunctionValueMapping r7, a r8) {
        AppFunctionValueMapping r0 = r7.getCond();
        if (r0 == null) goto L13;
        b r6 = f18159a;
        if (r6.b(r0, r8) == false) goto L7;
        AppFunctionValueMapping r1 = r7.getWhenTrue();
    L8:
        if (r1 == null) goto L35;
        JsonElement r9 = r6.a(r1, r8);
        if (r9 != null) goto L12;
        return null;
    L12:
        return r6.b(r9, r7.getTargetType());
    L35:
        return null;
    L7:
        r1 = r7.getWhenFalse();
        goto L8
    L13:
        Map<String, AppFunctionValueMapping> r2 = r7.getFields();
        boolean r3 = false;
        if (r2 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == false) goto L22;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.getOp(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L26;
    L27:
        r3 = true;
    L28:
        if (r3 == false) goto L30;
        JsonElement r10 = d(r7, r8);
        if (r10 != null) goto L34;
        return null;
    L34:
        return b(r10, r7.getTargetType());
    L30:
        return e(r7, r8);
    L26:
        if (d.o.o.d(r5) == false) goto L28;
    L22:
        return c(r7, r8);
    L16:
        if (r2.isEmpty() == true) goto L19;
        r4 = false;
        goto L20
    }

    private final boolean b(AppFunctionValueMapping r1, a r2) {
        return b(a(r1, r2));
    }

    private final JsonElement c(AppFunctionValueMapping r5, a r6) {
        JsonObject r4 = new JsonObject();
        Map<String, AppFunctionValueMapping> r7 = r5.getFields();
        if (r7 != null) goto L5;
        r7 = ao.b();
    L5:
        Iterator<Map.Entry<String, AppFunctionValueMapping>> r8 = r7.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        AppFunctionValueMapping r1 = (AppFunctionValueMapping) ZeusTransformUtils.preCheckCast(r0.getValue(), AppFunctionValueMapping.class, "com.obric.aiagent.plugin");
        JsonElement r3 = f18159a.a(r1, r6);
        if (r3 == null) goto L7;
        r4.add(r2, r3);
        goto L7
    L12:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin");
    }

    private final JsonElement d(AppFunctionValueMapping r4, a r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.getRef(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L18;
        JsonElement r3 = a(r4.getRef(), r5);
        if (f18159a.a(r3) == false) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L16;
        return r3;
    L16:
        return r4.getDefaultValue();
    L18:
        return r4.getValue();
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final JsonElement e(AppFunctionValueMapping r19, a r20) {
        List<AppFunctionValueMapping> r2 = r19.getArgs();
        if (r2 == null) goto L9;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r4.add(f18159a.a((AppFunctionValueMapping) ZeusTransformUtils.preCheckCast(r5.next(), AppFunctionValueMapping.class, "com.obric.aiagent.plugin"), r20));
        goto L6
    L8:
        List<? extends JsonElement> r1 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
    L10:
        String r6 = r19.getOp();
        if (r6 == null) goto L13;
        String r7 = r6.toLowerCase(Locale.ROOT);
        o.c(r7, "toLowerCase(...)");
    L14:
        if (r7 == null) goto L272;
        double r8 = 0.0d;
        String r9 = "";
        boolean r10 = true;
        boolean r11 = false;
        boolean r12 = false;
        r12 = false;
        int r13 = 0;
        r13 = 0;
        r11 = false;
        switch(r7.hashCode()) {
            case -2060248300: goto L269;
            case -1956743580: goto L260;
            case -1945355755: goto L251;
            case -1511383467: goto L240;
            case -1354795244: goto L236;
            case -1331463047: goto L232;
            case -1268779017: goto L224;
            case -1154857536: goto L214;
            case -868540373: goto L205;
            case 33: goto L196;
            case 42: goto L192;
            case 43: goto L188;
            case 45: goto L185;
            case 47: goto L182;
            case 60: goto L171;
            case 62: goto L160;
            case 1084: goto L149;
            case 1216: goto L134;
            case 1921: goto L123;
            case 1952: goto L112;
            case 1983: goto L101;
            case 3244: goto L98;
            case 3294: goto L95;
            case 3309: goto L92;
            case 3449: goto L89;
            case 3464: goto L86;
            case 3511: goto L83;
            case 3555: goto L69;
            case 3968: goto L66;
            case 96417: goto L63;
            case 96727: goto L60;
            case 99473: goto L57;
            case 108484: goto L54;
            case 108944: goto L45;
            case 109267: goto L42;
            case 114240: goto L39;
            case 96634189: goto L35;
            case 111603192: goto L32;
            case 303432716: goto L28;
            case 653829668: goto L25;
            case 921111605: goto L22;
            case 1614538977: goto L19;
            default: goto L283;
        };
    L283:
        JsonPrimitive r14 = null;
    L273:
        if (r14 != null) goto L275;
        return null;
    L275:
        return b((JsonElement) ZeusTransformUtils.preCheckCast(r14, JsonElement.class, "com.obric.aiagent.plugin"), r19.getTargetType());
    L19:
        if (r7.equals("not_empty") == false) goto L284;
    L30:
        r14 = new JsonPrimitive(Boolean.valueOf(!a((JsonElement) ZeusTransformUtils.preCheckCast(p.l(r1), JsonElement.class, "com.obric.aiagent.plugin"))));
        goto L273
    L284:
        r14 = null;
        goto L273
    L22:
        if (r7.equals("negative") == false) goto L285;
    L47:
        JsonElement r15 = (JsonElement) ZeusTransformUtils.preCheckCast(p.l(r1), JsonElement.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L52;
        Double r16 = f(r15);
        if (r16 == null) goto L52;
        r8 = r16.doubleValue();
    L52:
        r14 = new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Double.valueOf(-r8), Number.class, "com.obric.aiagent.plugin"));
        goto L273
    L285:
        r14 = null;
        goto L273
    L25:
        if (r7.equals("multiply") == false) goto L286;
    L194:
        r14 = a(r1, 1.0d, $$Lambda$b$blRS2nSPL4RmqZpR30Bsm5QY2fI.INSTANCE);
        goto L273
    L286:
        r14 = null;
        goto L273
    L28:
        if (r7.equals("is_not_empty") == true) goto L30;
        r14 = null;
        goto L273
    L32:
        if (r7.equals("is_empty") == false) goto L288;
    L37:
        r14 = new JsonPrimitive(Boolean.valueOf(a((JsonElement) ZeusTransformUtils.preCheckCast(p.l(r1), JsonElement.class, "com.obric.aiagent.plugin"))));
        goto L273
    L288:
        r14 = null;
        goto L273
    L35:
        if (r7.equals("empty") == true) goto L37;
        r14 = null;
        goto L273
    L39:
        if (r7.equals("sub") == false) goto L290;
    L271:
        r14 = b(r1);
        goto L273
    L290:
        r14 = null;
        goto L273
    L42:
        if (r7.equals("not") == false) goto L291;
    L198:
        JsonElement r17 = (JsonElement) ZeusTransformUtils.preCheckCast(p.l(r1), JsonElement.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L203;
        Boolean r18 = g(r17);
        if (r18 == null) goto L203;
        r12 = r18.booleanValue();
    L203:
        r14 = new JsonPrimitive(Boolean.valueOf(!r12));
        goto L273
    L291:
        r14 = null;
        goto L273
    L45:
        if (r7.equals("neg") == true) goto L47;
        r14 = null;
        goto L273
    L54:
        if (r7.equals("mul") == true) goto L194;
        r14 = null;
        goto L273
    L57:
        if (r7.equals("div") == false) goto L294;
    L234:
        r14 = c(r1);
        goto L273
    L294:
        r14 = null;
        goto L273
    L60:
        if (r7.equals("and") == false) goto L295;
    L136:
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r21, Collection.class) == true) goto L139;
    L141:
        Iterator r22 = r21.iterator();
    L143:
        if (r22.hasNext() == false) goto L147;
        if (f18159a.b((JsonElement) ZeusTransformUtils.preCheckCast(r22.next(), JsonElement.class, "com.obric.aiagent.plugin")) == true) goto L143;
        r10 = false;
    L147:
        r14 = new JsonPrimitive(Boolean.valueOf(r10));
        goto L273
    L139:
        if (((Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L141;
    L295:
        r14 = null;
        goto L273
    L63:
        if (r7.equals("add") == false) goto L296;
    L190:
        r14 = a(r1, 0.0d, $$Lambda$b$1u3y7osbk92LUdMDuoOLdrN6Jy0.INSTANCE);
        goto L273
    L296:
        r14 = null;
        goto L273
    L66:
        if (r7.equals("||") == false) goto L297;
    L71:
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r23, Collection.class) == true) goto L74;
    L76:
        Iterator r24 = r23.iterator();
    L78:
        if (r24.hasNext() == false) goto L75;
        if (f18159a.b((JsonElement) ZeusTransformUtils.preCheckCast(r24.next(), JsonElement.class, "com.obric.aiagent.plugin")) == false) goto L78;
    L81:
        r14 = new JsonPrimitive(Boolean.valueOf(r10));
    L75:
        r10 = false;
        goto L81
    L74:
        if (((Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L76;
    L297:
        r14 = null;
        goto L273
    L69:
        if (r7.equals("or") == true) goto L71;
        r14 = null;
        goto L273
    L83:
        if (r7.equals("ne") == false) goto L299;
    L151:
        Integer r25 = a(r1);
        if (r25 != null) goto L155;
    L158:
        r14 = new JsonPrimitive(Boolean.valueOf(r10));
        goto L273
    L155:
        if (r25.intValue() != 0) goto L158;
        r10 = false;
        goto L158
    L299:
        r14 = null;
        goto L273
    L86:
        if (r7.equals("lt") == false) goto L300;
    L173:
        Integer r26 = a(r1);
        if (r26 == null) goto L176;
        int r27 = r26.intValue();
    L177:
        if (r27 < 0) goto L180;
        r10 = false;
    L180:
        r14 = new JsonPrimitive(Boolean.valueOf(r10));
        goto L273
    L176:
        r27 = 0;
        goto L177
    L300:
        r14 = null;
        goto L273
    L89:
        if (r7.equals("le") == false) goto L301;
    L125:
        Integer r28 = a(r1);
        if (r28 == null) goto L128;
        int r29 = r28.intValue();
    L129:
        if (r29 <= 0) goto L132;
        r10 = false;
    L132:
        r14 = new JsonPrimitive(Boolean.valueOf(r10));
        goto L273
    L128:
        r29 = 1;
        goto L129
    L301:
        r14 = null;
        goto L273
    L92:
        if (r7.equals("gt") == false) goto L302;
    L162:
        Integer r30 = a(r1);
        if (r30 == null) goto L165;
        int r31 = r30.intValue();
    L166:
        if (r31 > 0) goto L169;
        r10 = false;
    L169:
        r14 = new JsonPrimitive(Boolean.valueOf(r10));
        goto L273
    L165:
        r31 = 0;
        goto L166
    L302:
        r14 = null;
        goto L273
    L95:
        if (r7.equals("ge") == false) goto L303;
    L103:
        Integer r32 = a(r1);
        if (r32 == null) goto L106;
        int r33 = r32.intValue();
    L107:
        if (r33 >= 0) goto L110;
        r10 = false;
    L110:
        r14 = new JsonPrimitive(Boolean.valueOf(r10));
        goto L273
    L106:
        r33 = -1;
        goto L107
    L303:
        r14 = null;
        goto L273
    L98:
        if (r7.equals("eq") == false) goto L304;
    L114:
        Integer r34 = a(r1);
        if (r34 != null) goto L118;
    L120:
        r10 = false;
    L121:
        r14 = new JsonPrimitive(Boolean.valueOf(r10));
        goto L273
    L118:
        if (r34.intValue() != 0) goto L120;
    L304:
        r14 = null;
        goto L273
    L101:
        if (r7.equals(">=") == true) goto L103;
        r14 = null;
        goto L273
    L112:
        if (r7.equals("==") == true) goto L114;
        r14 = null;
        goto L273
    L123:
        if (r7.equals("<=") == true) goto L125;
        r14 = null;
        goto L273
    L134:
        if (r7.equals("&&") == true) goto L136;
        r14 = null;
        goto L273
    L149:
        if (r7.equals("!=") == true) goto L151;
        r14 = null;
        goto L273
    L160:
        if (r7.equals(">") == true) goto L162;
        r14 = null;
        goto L273
    L171:
        if (r7.equals("<") == true) goto L173;
        r14 = null;
        goto L273
    L182:
        if (r7.equals("/") == true) goto L234;
        r14 = null;
        goto L273
    L185:
        if (r7.equals("-") == true) goto L271;
        r14 = null;
        goto L273
    L188:
        if (r7.equals("+") == true) goto L190;
        r14 = null;
        goto L273
    L192:
        if (r7.equals("*") == true) goto L194;
        r14 = null;
        goto L273
    L196:
        if (r7.equals("!") == true) goto L198;
        r14 = null;
        goto L273
    L205:
        if (r7.equals("to_int") == false) goto L317;
        JsonElement r35 = (JsonElement) ZeusTransformUtils.preCheckCast(p.l(r1), JsonElement.class, "com.obric.aiagent.plugin");
        if (r35 == null) goto L212;
        Integer r36 = d(r35);
        if (r36 == null) goto L212;
        r13 = r36.intValue();
    L212:
        r14 = new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r13), Number.class, "com.obric.aiagent.plugin"));
        goto L273
    L317:
        r14 = null;
        goto L273
    L214:
        if (r7.equals("to_long") == false) goto L318;
        JsonElement r37 = (JsonElement) ZeusTransformUtils.preCheckCast(p.l(r1), JsonElement.class, "com.obric.aiagent.plugin");
        if (r37 == null) goto L221;
        Long r38 = e(r37);
        if (r38 == null) goto L221;
        long r39 = r38.longValue();
    L222:
        r14 = new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r39), Number.class, "com.obric.aiagent.plugin"));
    L221:
        r39 = 0;
        goto L222
    L318:
        r14 = null;
        goto L273
    L224:
        if (r7.equals("format") == false) goto L319;
        String r40 = r19.getTemplate();
        if (r40 == null) goto L230;
        r9 = r40;
    L230:
        r14 = new JsonPrimitive(a(r9, r1));
        goto L273
    L319:
        r14 = null;
        goto L273
    L232:
        if (r7.equals("divide") == true) goto L234;
        r14 = null;
        goto L273
    L236:
        if (r7.equals("concat") == false) goto L321;
        r14 = new JsonPrimitive(p.a((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$b$zmslW_Es69AHMyKE0Y9H1SZqze0.INSTANCE, 30, null));
        goto L273
    L321:
        r14 = null;
        goto L273
    L240:
        if (r7.equals("to_string") == false) goto L322;
        JsonElement r41 = (JsonElement) ZeusTransformUtils.preCheckCast(p.l(r1), JsonElement.class, "com.obric.aiagent.plugin");
        if (r41 == null) goto L245;
        String r42 = c(r41);
    L246:
        if (r42 == null) goto L249;
        r9 = r42;
    L249:
        r14 = new JsonPrimitive(r9);
        goto L273
    L245:
        r42 = null;
        goto L246
    L322:
        r14 = null;
        goto L273
    L251:
        if (r7.equals("to_double") == false) goto L323;
        JsonElement r43 = (JsonElement) ZeusTransformUtils.preCheckCast(p.l(r1), JsonElement.class, "com.obric.aiagent.plugin");
        if (r43 == null) goto L258;
        Double r44 = f(r43);
        if (r44 == null) goto L258;
        r8 = r44.doubleValue();
    L258:
        r14 = new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Double.valueOf(r8), Number.class, "com.obric.aiagent.plugin"));
        goto L273
    L323:
        r14 = null;
        goto L273
    L260:
        if (r7.equals("to_boolean") == false) goto L324;
        JsonElement r45 = (JsonElement) ZeusTransformUtils.preCheckCast(p.l(r1), JsonElement.class, "com.obric.aiagent.plugin");
        if (r45 == null) goto L267;
        Boolean r46 = g(r45);
        if (r46 == null) goto L267;
        r11 = r46.booleanValue();
    L267:
        r14 = new JsonPrimitive(Boolean.valueOf(r11));
        goto L273
    L324:
        r14 = null;
        goto L273
    L269:
        if (r7.equals("subtract") == true) goto L271;
        r14 = null;
        goto L273
    L272:
        r14 = null;
        goto L273
    L13:
        r7 = null;
        goto L14
    L9:
        r1 = p.a(d(AppFunctionValueMapping.copy$default(r19, null, null, null, null, null, null, null, null, null, null, null, 1975, null), r20));
        goto L10
    }

    private static final CharSequence h(JsonElement r2) {
        if (r2 == null) goto L4;
        String r3 = f18159a.c(r2);
    L5:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
    L4:
        r3 = null;
        goto L5
    }

    private final Integer a(List<? extends JsonElement> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        JsonElement r0 = (JsonElement) ZeusTransformUtils.preCheckCast(p.d(r6, 0), JsonElement.class, "com.obric.aiagent.plugin");
        JsonElement r7 = (JsonElement) ZeusTransformUtils.preCheckCast(p.d(r6, 1), JsonElement.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        Double r2 = f(r0);
    L6:
        if (r7 == null) goto L8;
        Double r3 = f(r7);
    L9:
        if (r2 == null) goto L13;
        if (r3 == null) goto L13;
        return Integer.valueOf(Double.compare(r2.doubleValue(), r3.doubleValue()));
    L13:
        if (r0 == null) goto L15;
        String r1 = c(r0);
    L16:
        if (r7 == null) goto L18;
        String r4 = c(r7);
    L19:
        if (r1 == null) goto L23;
        if (r4 == null) goto L23;
        return Integer.valueOf(r1.compareTo(r4));
    L23:
        return null;
    L18:
        r4 = null;
        goto L19
    L15:
        r1 = null;
        goto L16
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    private final JsonElement a(String r12, a r13) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        String r2 = "$";
        if (o.a(r12, "$") == true) goto L15;
        List<String> r14 = c(r12);
        String r4 = (String) ZeusTransformUtils.preCheckCast(p.l(r14), String.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L20;
        return null;
    L20:
        if (o.a(r4, "intent_params") == false) goto L23;
        JsonElement r15 = r13.a();
    L26:
        if (r15 != null) goto L29;
        return null;
    L29:
        if (r14.size() == 1) goto L33;
        r2 = '$' + p.a((Iterable) ZeusTransformUtils.preCheckCast(p.b((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), 1), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(".", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(".", CharSequence.class, "com.obric.aiagent.plugin"), null, 0, null, null, 60, null);
    L33:
        return a(r15, r2);
    L23:
        if (o.a(r4, "request_ext") == false) goto L25;
        r15 = r13.b();
        goto L26
    L25:
        r15 = (JsonElement) ZeusTransformUtils.preCheckCast(r13.d().get(r4), JsonElement.class, "com.obric.aiagent.plugin");
        goto L26
    L15:
        return r13.a();
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    private final JsonPrimitive a(List<? extends JsonElement> r3, double r4, m<? super Double, ? super Double, Double> r6) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.aiagent.plugin");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        JsonElement r8 = (JsonElement) ZeusTransformUtils.preCheckCast(r7.next(), JsonElement.class, "com.obric.aiagent.plugin");
        Double r9 = Double.valueOf(r4);
        if (r8 == null) goto L10;
        Double r10 = f18159a.f(r8);
        if (r10 == null) goto L10;
        double r11 = r10.doubleValue();
    L11:
        r4 = ((Number) ZeusTransformUtils.preCheckCast(r5.invoke(r9, Double.valueOf(r11)), Number.class, "com.obric.aiagent.plugin")).doubleValue();
    L10:
        r11 = 0.0d;
        goto L11
    L13:
        return new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Double.valueOf(r4), Number.class, "com.obric.aiagent.plugin"));
    }

    private final JsonPrimitive b(List<? extends JsonElement> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        JsonElement r0 = (JsonElement) ZeusTransformUtils.preCheckCast(p.l(r10), JsonElement.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        Double r8 = f(r0);
        if (r8 == null) goto L7;
        double r4 = r8.doubleValue();
    L8:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(p.b((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), 1), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r11.hasNext() == false) goto L19;
        JsonElement r12 = (JsonElement) ZeusTransformUtils.preCheckCast(r11.next(), JsonElement.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L16;
        Double r13 = f18159a.f(r12);
        if (r13 == null) goto L16;
        double r6 = r13.doubleValue();
    L17:
        r4 = r4 - r6;
    L16:
        r6 = 0.0d;
        goto L17
    L19:
        return new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Double.valueOf(r4), Number.class, "com.obric.aiagent.plugin"));
    L7:
        r4 = 0.0d;
        goto L8
    }

    private final JsonPrimitive c(List<? extends JsonElement> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        JsonElement r0 = (JsonElement) ZeusTransformUtils.preCheckCast(p.l(r10), JsonElement.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        Double r8 = f(r0);
        if (r8 == null) goto L7;
        double r4 = r8.doubleValue();
    L8:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(p.b((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), 1), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r11.hasNext() == false) goto L25;
        JsonElement r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r11.next(), JsonElement.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L16;
        Double r2 = f18159a.f(r1);
        if (r2 == null) goto L16;
        double r6 = r2.doubleValue();
    L18:
        if (r6 != 0.0d) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == true) goto L10;
        r4 = r4 / r6;
        goto L10
    L20:
        r3 = false;
    L16:
        r6 = 1.0d;
        goto L18
    L25:
        return new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Double.valueOf(r4), Number.class, "com.obric.aiagent.plugin"));
    L7:
        r4 = 0.0d;
        goto L8
    }

    private final String a(String r9, List<? extends JsonElement> r10) {
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r11 = 0;
        String r1 = r9;
    L4:
        if (r8.hasNext() == false) goto L15;
        Object r12 = r8.next();
        int r7 = r11 + 1;
        if (r11 >= 0) goto L8;
        p.c();
    L8:
        JsonElement r13 = (JsonElement) ZeusTransformUtils.preCheckCast(r12, JsonElement.class, "com.obric.aiagent.plugin");
        String r2 = new StringBuilder().append('{').append(r11).append('}').toString();
        if (r13 == null) goto L11;
        String r14 = f18159a.c(r13);
    L12:
        if (r14 != null) goto L14;
        r14 = "";
    L14:
        r1 = d.o.o.a(r1, r2, r14, false, 4, null);
        r11 = r7;
        goto L4
    L11:
        r14 = null;
        goto L12
    L15:
        return r1;
    }

    private final void a(PendingIntent r10) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L8
        b r9 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        ActivityOptions r11 = ActivityOptions.makeBasic();     // Catch: Throwable -> L8
        if (Build.VERSION.SDK_INT < 34) goto L6;
        r11.setPendingIntentBackgroundActivityStartMode(1);     // Catch: Throwable -> L8
    L6:
        r10.send((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 0, null, null, null, null, r11.toBundle());     // Catch: Throwable -> L8
        Object r12 = n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = n.c(r12);
        if (r13 == null) goto L16;
        ILogDepend.Companion.e(TAG, "send pendingIntent failed", r13);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        n.a r14 = n.f38560a;
        r12 = n.f(d.o.a(th));
        goto L10
    }

    private final com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c a(String r16, long r17) {
        return com.obric.aiagent.executionengine.scheduler.impl.a.d.a(com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a, new IntentResult(-2002, null, null, r16, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null), r17, null, 4, null);
    }

    private final JsonElement b(String r3) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L14
        b r4 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Object r5 = n.f(new JsonParser().parse(r3));     // Catch: Throwable -> L14
    L16:
        JsonObject r6 = new JsonObject();
        if (n.b(r5) == false) goto L19;
        r5 = r6;
    L19:
        o.c(r5, "getOrDefault(...)");
        return (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin");
    L14:
        th = move-exception;
        n.a r7 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L16
    L11:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonObject(), JsonElement.class, "com.obric.aiagent.plugin");
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final JsonElement a(JsonElement r6, String r7) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L50:
        return r6;
    L11:
        if (o.a(r7, "$") == true) goto L50;
        Iterator<String> r5 = c(r7).iterator();
    L15:
        if (r5.hasNext() == false) goto L50;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L19;
    L21:
        boolean r2 = false;
    L23:
        if (r2 == false) goto L25;
        r6 = r6.getAsJsonObject().get(r8);
    L48:
        if (r6 != null) goto L15;
        return null;
    L25:
        if (r6 != null) goto L27;
    L29:
        boolean r3 = false;
    L30:
        if (r3 == false) goto L47;
        Integer r9 = d.o.o.d(r8);
        if (r9 == null) goto L47;
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r6 == null) goto L47;
        JsonArray r11 = r6.getAsJsonArray();
        if (r11 == null) goto L47;
        if (r10 >= 0) goto L39;
    L41:
        boolean r4 = false;
    L42:
        if (r4 == true) goto L45;
        r11 = null;
    L45:
        if (r11 == null) goto L47;
        r6 = r11.get(r10);
        goto L48
    L39:
        if (r10 >= r11.size()) goto L41;
        r4 = true;
    L47:
        r6 = null;
        goto L48
    L27:
        if (r6.isJsonArray() != true) goto L29;
        r3 = true;
        goto L30
    L19:
        if (r6.isJsonObject() != true) goto L21;
        r2 = true;
        goto L23
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final List<String> c(String r21) {
        String r0 = d.o.o.a(d.o.o.a(r21, (CharSequence) ZeusTransformUtils.preCheckCast("$.", CharSequence.class, "com.obric.aiagent.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast("$", CharSequence.class, "com.obric.aiagent.plugin"));
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"."}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L26;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
    L11:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L8;
        int r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), '[', 0, false, 6, null);
        if (r7 < 0) goto L17;
        if (r7 <= 0) goto L22;
        String r8 = r3.substring(0, r7);
        o.c(r8, "substring(...)");
        r1.add(r8);
    L22:
        int r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), ']', r7, false, 4, null);
        if (r9 < 0) goto L24;
        String r10 = r3.substring(r7 + 1, r9);
        o.c(r10, "substring(...)");
        r1.add(r10);
        r3 = r3.substring(r9 + 1);
        o.c(r3, "substring(...)");
        goto L11
    L24:
        String r4 = r3.substring(r7);
        o.c(r4, "substring(...)");
        r1.add(r4);
    L18:
        r3 = "";
        goto L11
    L17:
        r1.add(r3);
        goto L18
    L13:
        r6 = false;
        goto L14
    L26:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r5.iterator();
    L28:
        if (r12.hasNext() == false) goto L33;
        Object r13 = r12.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L28;
        r11.add(r13);
        goto L28
    L33:
        return (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
    L5:
        return p.b();
    }

    private final boolean a(JsonElement r5) {
        if (r5 == null) goto L24;
        if (r5.isJsonNull() == true) goto L24;
        if (r5.isJsonPrimitive() == false) goto L16;
        if (r5.getAsJsonPrimitive().isString() == false) goto L16;
        String r1 = r5.getAsString();
        o.c(r1, "getAsString(...)");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L24;
    L13:
        r2 = false;
    L16:
        if (r5.isJsonArray() == false) goto L20;
        if (r5.getAsJsonArray().size() == 0) goto L24;
    L20:
        if (r5.isJsonObject() == true) goto L22;
        return false;
    L22:
        if (r5.getAsJsonObject().size() == 0) goto L24;
        return false;
    L24:
        return true;
    }

    private final boolean b(JsonElement r5) {
        boolean r1 = false;
        if (a(r5) == false) goto L6;
        return false;
    L6:
        if (r5 != null) goto L8;
    L20:
        return true;
    L8:
        if (r5.isJsonPrimitive() == false) goto L20;
        JsonPrimitive r2 = r5.getAsJsonPrimitive();
        if (r2.isBoolean() == true) goto L12;
        Double r4 = f(r5);
        if (r4 == null) goto L20;
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).doubleValue() != 0.0d) goto L19;
        r1 = true;
    L19:
        return !r1;
    L12:
        return r2.getAsBoolean();
    }

    private final String c(JsonElement r1) {
        if (r1.isJsonPrimitive() == false) goto L5;
        String r0 = r1.getAsJsonPrimitive().getAsString();
        String r2 = "getAsString(...)";
    L6:
        o.c(r0, r2);
        return r0;
    L5:
        r0 = r1.toString();
        r2 = "toString(...)";
        goto L6
    }

    private final Integer d(JsonElement r2) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L4
        Object r3 = n.f(Integer.valueOf(r2.getAsInt()));     // Catch: Throwable -> L4
    L7:
        if (n.b(r3) == false) goto L10;
        r3 = null;
    L10:
        return (Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.aiagent.plugin");
    L4:
        th = move-exception;
        n.a r4 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L7
    }

    private final Long e(JsonElement r2) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L4
        Object r3 = n.f(Long.valueOf(r2.getAsLong()));     // Catch: Throwable -> L4
    L7:
        if (n.b(r3) == false) goto L10;
        r3 = null;
    L10:
        return (Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.aiagent.plugin");
    L4:
        th = move-exception;
        n.a r4 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L7
    }

    private final Double f(JsonElement r2) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L4
        Object r3 = n.f(Double.valueOf(r2.getAsDouble()));     // Catch: Throwable -> L4
    L7:
        if (n.b(r3) == false) goto L10;
        r3 = null;
    L10:
        return (Double) ZeusTransformUtils.preCheckCast(r3, Double.class, "com.obric.aiagent.plugin");
    L4:
        th = move-exception;
        n.a r4 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L7
    }

    private final Boolean g(JsonElement r2) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L4
        Object r3 = n.f(Boolean.valueOf(r2.getAsBoolean()));     // Catch: Throwable -> L4
    L7:
        if (n.b(r3) == false) goto L10;
        r3 = null;
    L10:
        return (Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin");
    L4:
        th = move-exception;
        n.a r4 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L7
    }

    private final JsonElement b(JsonElement r4, String r5) {
        if (r5 == null) goto L4;
        String r6 = r5.toLowerCase(Locale.ROOT);
        o.c(r6, "toLowerCase(...)");
    L5:
        if (r6 == null) goto L47;
        int r1 = 0;
        boolean r2 = false;
        switch(r6.hashCode()) {
            case -1325958191: goto L39;
            case -891985903: goto L35;
            case 104431: goto L28;
            case 3029738: goto L21;
            case 3327612: goto L13;
            case 64711720: goto L10;
            default: goto L52;
        };
    L52:
        return r4;
    L10:
        if (r6.equals(WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE) == false) goto L53;
    L23:
        Boolean r3 = g(r4);
        if (r3 == null) goto L49;
        r2 = r3.booleanValue();
    L49:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(Boolean.valueOf(r2)), JsonElement.class, "com.obric.aiagent.plugin");
    L53:
        return r4;
    L13:
        if (r6.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L54;
        Long r7 = e(r4);
        if (r7 == null) goto L18;
        long r8 = r7.longValue();
    L48:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r8), Number.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L18:
        r8 = 0;
        goto L48
    L54:
        return r4;
    L21:
        if (r6.equals("bool") == true) goto L23;
        return r4;
    L28:
        if (r6.equals("int") == false) goto L56;
        Integer r9 = d(r4);
        if (r9 == null) goto L50;
        r1 = r9.intValue();
    L50:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r1), Number.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L56:
        return r4;
    L35:
        if (r6.equals(WsChannelMultiProcessSharedProvider.STRING_TYPE) == true) goto L51;
        return r4;
    L51:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(c(r4)), JsonElement.class, "com.obric.aiagent.plugin");
    L39:
        if (r6.equals("double") == false) goto L58;
        Double r10 = f(r4);
        if (r10 == null) goto L44;
        double r11 = r10.doubleValue();
    L46:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Double.valueOf(r11), Number.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L44:
        r11 = 0.0d;
        goto L46
    L58:
        return r4;
    L47:
        return r4;
    L4:
        r6 = null;
        goto L5
    }
}
