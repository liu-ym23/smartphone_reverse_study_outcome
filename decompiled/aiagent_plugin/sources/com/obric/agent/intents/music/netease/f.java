package com.obric.agent.intents.music.netease;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;
import d.x;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import org.json.JSONObject;

/* JADX INFO: compiled from: CloudMusicOpenApiService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private static final String TAG = "CloudMusicOpenApiService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f14802a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f14803b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final am f14804c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlinx.coroutines.f.a f14805d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile String f14806e;

    /* JADX INFO: compiled from: CloudMusicOpenApiService.kt */
    public interface a {
        void a(String r1);

        void b(String r1);
    }

    /* JADX INFO: compiled from: CloudMusicOpenApiService.kt */
    @d.c.b.a.f(b = "CloudMusicOpenApiService.kt", c = {277, 169}, d = "ensureAccessToken", e = "com.obric.agent.intents.music.netease.CloudMusicOpenApiService")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f14810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14811e;

        b(f r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14810d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14809c = r3;
            this.f14811e |= Integer.MIN_VALUE;
            return f.a(this.f14810d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CloudMusicOpenApiService.kt */
    @d.c.b.a.f(b = "CloudMusicOpenApiService.kt", c = {127}, d = "invokeSuspend", e = "com.obric.agent.intents.music.netease.CloudMusicOpenApiService$getAlbumSongs$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<Map<String, ? extends String>, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f14813b;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(Map<String, String> r3, d.c.d<? super String> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            c r4 = new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f14813b = r2;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Map<String, ? extends String> r3, d.c.d<? super String> r4) {
            return a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14812a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            Map r5 = (Map) ZeusTransformUtils.preCheckCast(this.f14813b, Map.class, "com.obric.aiagent.plugin");
            CloudMusicOpenApi r4 = f.a(f.f14802a);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14812a = 1;
            r11 = CloudMusicOpenApi.a.d(r4, r5, false, r7, 2, null);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CloudMusicOpenApiService.kt */
    @d.c.b.a.f(b = "CloudMusicOpenApiService.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.intents.music.netease.CloudMusicOpenApiService$handleResponse$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f14815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14816c;

        d(a r3, String r4, d.c.d<? super d> r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14815b = r6;
            this.f14816c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f14815b, this.f14816c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f14814a != 0) goto L7;
            o.a(r2);
            this.f14815b.a(this.f14816c);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: CloudMusicOpenApiService.kt */
    @d.c.b.a.f(b = "CloudMusicOpenApiService.kt", c = {143, 145, 150, 151, 154}, d = "invokeSuspend", e = "com.obric.agent.intents.music.netease.CloudMusicOpenApiService$launchGet$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f14818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f14819c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.m<Map<String, String>, d.c.d<? super String>, Object> f14820d;

        e(a r3, JSONObject r4, d.h.a.m<? super Map<String, String>, ? super d.c.d<? super String>, ? extends Object> r5, d.c.d<? super e> r6) {
            a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            d.h.a.m<Map<String, String>, d.c.d<? super String>, Object> r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14818b = r7;
            this.f14819c = r4;
            this.f14820d = r8;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f14818b, this.f14819c, this.f14820d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14817a;
            boolean r6 = true;
            if (r1 == 0) goto L19;
            if (r1 == 1) goto L18;
            if (r1 == 2) goto L17;
            if (r1 == 3) goto L13;
            if (r1 == 4) goto L12;
            if (r1 != 5) goto L11;
            o.a(r9);
        L44:
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            o.a(r9);     // Catch: Exception -> L15
            goto L44
        L13:
            o.a(r9);     // Catch: Exception -> L15
        L37:
            String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
            f r2 = f.f14802a;     // Catch: Exception -> L15
            a r4 = this.f14818b;     // Catch: Exception -> L15
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
            this.f14817a = 4;     // Catch: Exception -> L15
            if (f.a(r2, r10, r4, r5) != r0) goto L44;
            return r0;
        L17:
            o.a(r9);
        L33:
            return x.f38692a;
        L18:
            o.a(r9);
        L22:
            String r11 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
            CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L25;
        L28:
            if (r6 == false) goto L34;
            f r12 = f.f14802a;
            a r7 = this.f14818b;
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14817a = 2;
            if (f.a(r12, r7, "获取匿名 accessToken 失败", r8) != r0) goto L33;
            return r0;
        L34:
            f r13 = f.f14802a;     // Catch: Exception -> L15
            String r14 = this.f14819c.toString();     // Catch: Exception -> L15
            d.h.b.o.c(r14, "toString(...)");     // Catch: Exception -> L15
            Map<String, String> r15 = f.a(r13, r14, r11);     // Catch: Exception -> L15
            d.h.a.m<Map<String, String>, d.c.d<? super String>, Object> r16 = this.f14820d;     // Catch: Exception -> L15
            this.f14817a = 3;     // Catch: Exception -> L15
            r9 = r16.invoke(r15, this);     // Catch: Exception -> L15
            if (r9 != r0) goto L37;
            return r0;
        L25:
            if (r3.length() == 0) goto L28;
            r6 = false;
            goto L28
        L19:
            o.a(r9);
            f r17 = f.f14802a;
            d.c.d r18 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14817a = 1;
            r9 = f.a(r17, r18);
            if (r9 != r0) goto L22;
            return r0;
        L15:
            e = move-exception;
            ILogDepend.Companion.e(f.TAG, "launchGet error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            f r19 = f.f14802a;
            a r20 = this.f14818b;
            String r21 = "请求失败: " + e.getMessage();
            d.c.d r22 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14817a = 5;
            if (f.a(r19, r20, r21, r22) != r0) goto L44;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.intents.music.netease.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CloudMusicOpenApiService.kt */
    @d.c.b.a.f(b = "CloudMusicOpenApiService.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.intents.music.netease.CloudMusicOpenApiService$postFailure$2")
    static final class C0295f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f14822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14823c;

        C0295f(a r3, String r4, d.c.d<? super C0295f> r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14822b = r6;
            this.f14823c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0295f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0295f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0295f(this.f14822b, this.f14823c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f14821a != 0) goto L7;
            o.a(r2);
            this.f14822b.b(this.f14823c);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: CloudMusicOpenApiService.kt */
    @d.c.b.a.f(b = "CloudMusicOpenApiService.kt", c = {110}, d = "invokeSuspend", e = "com.obric.agent.intents.music.netease.CloudMusicOpenApiService$searchAlbums$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<Map<String, ? extends String>, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f14825b;

        g(d.c.d<? super g> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(Map<String, String> r3, d.c.d<? super String> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            g r4 = new g((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f14825b = r2;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Map<String, ? extends String> r3, d.c.d<? super String> r4) {
            return a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14824a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            Map r5 = (Map) ZeusTransformUtils.preCheckCast(this.f14825b, Map.class, "com.obric.aiagent.plugin");
            CloudMusicOpenApi r4 = f.a(f.f14802a);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14824a = 1;
            r11 = CloudMusicOpenApi.a.c(r4, r5, false, r7, 2, null);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CloudMusicOpenApiService.kt */
    @d.c.b.a.f(b = "CloudMusicOpenApiService.kt", c = {95}, d = "invokeSuspend", e = "com.obric.agent.intents.music.netease.CloudMusicOpenApiService$searchSongs$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<Map<String, ? extends String>, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f14827b;

        h(d.c.d<? super h> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(Map<String, String> r3, d.c.d<? super String> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            h r4 = new h((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f14827b = r2;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Map<String, ? extends String> r3, d.c.d<? super String> r4) {
            return a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14826a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            Map r5 = (Map) ZeusTransformUtils.preCheckCast(this.f14827b, Map.class, "com.obric.aiagent.plugin");
            CloudMusicOpenApi r4 = f.a(f.f14802a);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14826a = 1;
            r11 = CloudMusicOpenApi.a.b(r4, r5, false, r7, 2, null);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$D-NE5RaWZQBYe7EJaUtKphpKGKQ, reason: not valid java name */
    public static /* synthetic */ CloudMusicOpenApi m85lambda$DNE5RaWZQBYe7EJaUtKphpKGKQ() {
        return b();
    }

    private f() {
    }

    public static final /* synthetic */ CloudMusicOpenApi a(f r0) {
        return r0.a();
    }

    public static final /* synthetic */ Object a(f r2, a r3, String r4, d.c.d r5) {
        return r2.a((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(f r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(f r2, String r3, a r4, d.c.d r5) {
        return r2.a(r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Map a(f r0, String r1, String r2) {
        return r0.a(r1, r2);
    }

    static {
        f14802a = new f();
        f14803b = d.g.a($$Lambda$f$DNE5RaWZQBYe7EJaUtKphpKGKQ.INSTANCE);
        f14804c = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        f14805d = kotlinx.coroutines.f.c.a(false, 1, null);
        f14806e = "";
    }

    private final CloudMusicOpenApi a() {
        Object r2 = f14803b.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (CloudMusicOpenApi) ZeusTransformUtils.preCheckCast(r2, CloudMusicOpenApi.class, "com.obric.aiagent.plugin");
    }

    private static final CloudMusicOpenApi b() {
        return (CloudMusicOpenApi) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.b("https://openapi.music.163.com").a(CloudMusicOpenApi.class), CloudMusicOpenApi.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r4, int r5, int r6, boolean r7, a r8) {
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "keyword");
        d.h.b.o.e(r9, "callback");
        JSONObject r2 = new JSONObject();
        r2.put("keyword", r4);
        r2.put("limit", String.valueOf(r5));
        r2.put("offset", String.valueOf(r6));
        r2.put("qualityFlag", String.valueOf(r7));
        a(r2, r9, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    public final void a(String r4, int r5, int r6, a r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "keyword");
        d.h.b.o.e(r8, "callback");
        JSONObject r2 = new JSONObject();
        r2.put("keyword", r4);
        r2.put("limit", String.valueOf(r5));
        r2.put("offset", String.valueOf(r6));
        a(r2, r8, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    public final void b(String r4, int r5, int r6, boolean r7, a r8) {
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "albumId");
        d.h.b.o.e(r9, "callback");
        JSONObject r2 = new JSONObject();
        r2.put("albumId", r4);
        r2.put("limit", String.valueOf(r5));
        r2.put("offset", String.valueOf(r6));
        r2.put("qualityFlag", String.valueOf(r7));
        a(r2, r9, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    private final void a(JSONObject r8, a r9, d.h.a.m<? super Map<String, String>, ? super d.c.d<? super String>, ? extends Object> r10) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.aiagent.plugin");
        d.h.a.m r11 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.m.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(f14804c, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r7, r8, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r0v9 */
    private final Object a(d.c.d<? super String> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r15, b.class, "com.obric.aiagent.plugin");
        if ((r0.f14811e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f14811e -= Integer.MIN_VALUE;
    L8:
        b r5 = r0;
        Object r13 = r5.f14809c;
        Object r16 = d.c.a.b.a();
        ?? r1 = r5.f14811e;
        boolean r9 = false;
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L21;
        if (r1 != 2) goto L20;
        f r17 = (f) ZeusTransformUtils.preCheckCast(r5.f14808b, f.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r2 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r5.f14807a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        o.a(r13);     // Catch: Throwable -> L15 Exception -> L17
        r1 = r2;
    L44:
        String r18 = r17.a((String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15 Exception -> L17
        ?? r3 = r1;
    L47:
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r19 != null) goto L50;
    L51:
        r9 = true;
    L52:
        if (r9 == true) goto L54;
        f14806e = r18;     // Catch: Throwable -> L15
        ILogDepend.Companion.d(TAG, "anonymousLogin success, cached");     // Catch: Throwable -> L15
        ?? r4 = r3;
    L55:
        r4.b(null);
        return r18;
    L54:
        ILogDepend.Companion.w(TAG, "anonymousLogin failed");     // Catch: Throwable -> L15
        r4 = r3;
        goto L55
    L50:
        if (r19.length() != 0) goto L52;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        kotlinx.coroutines.f.a r6 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r5.f14807a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        o.a(r13);
        kotlinx.coroutines.f.a r7 = r6;
    L34:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(f14806e, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L36;
        boolean r110 = true;
    L37:
        if (r110 == false) goto L40;
        r18 = f14806e;     // Catch: Throwable -> L15
        r4 = r7;
        goto L55
    L40:
        f r111 = f14802a;     // Catch: Throwable -> L15 Exception -> L17
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L15 Exception -> L17
        r8.put("clientId", "a3010100000000003a8e52bf0b4677ce");     // Catch: Throwable -> L15 Exception -> L17
        String r10 = r8.toString();     // Catch: Throwable -> L15 Exception -> L17
        d.h.b.o.c(r10, "toString(...)");     // Catch: Throwable -> L15 Exception -> L17
        Map<String, String> r11 = r111.a(r10, null);     // Catch: Throwable -> L15 Exception -> L17
        CloudMusicOpenApi r12 = r111.a();     // Catch: Throwable -> L15 Exception -> L17
        r5.f14807a = r7;     // Catch: Throwable -> L15 Exception -> L17
        r5.f14808b = r111;     // Catch: Throwable -> L15 Exception -> L17
        r5.f14811e = 2;     // Catch: Throwable -> L15 Exception -> L17
        Object r20 = CloudMusicOpenApi.a.a(r12, r11, false, r5, 2, null);     // Catch: Throwable -> L15 Exception -> L17
        if (r20 != r16) goto L43;
        return r16;
    L43:
        r17 = r111;
        r13 = r20;
        r1 = r7;
        goto L44
    L36:
        r110 = false;
        goto L37
    L22:
        o.a(r13);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(f14806e, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == true) goto L28;
        kotlinx.coroutines.f.a r113 = f14805d;
        r5.f14807a = r113;
        r5.f14811e = 1;
        if (r113.a(null, r5) != r16) goto L32;
        return r16;
    L32:
        r7 = r113;
        goto L34
    L28:
        return f14806e;
    L25:
        r112 = false;
    L17:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "ensureAccessToken error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        r18 = null;
        r3 = r1;
    L15:
        th = move-exception;
        r1.b(null);
        throw th;
    L7:
        r0 = new b(this, r15);
        goto L8
    }

    private final Map<String, String> a(String r4, String r5) {
        String r3 = String.valueOf(System.currentTimeMillis());
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("appId", "a3010100000000003a8e52bf0b4677ce");
        r0.put("bizContent", r4);
        r0.put("signType", "RSA_SHA256");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
        r0.put("accessToken", r5);
    L11:
        r0.put("device", com.obric.agent.intents.music.netease.e.f14798a.c().a().toString());
        r0.put(DBHelper.COL_TIME, r3);
        String r8 = com.obric.agent.intents.music.netease.g.a(com.obric.agent.intents.music.netease.g.a((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")), com.obric.agent.intents.music.netease.e.f14798a.a());
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("sign", r8);
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
    L5:
        if (r6.length() == 0) goto L8;
        r7 = false;
        goto L9
    }

    private final Object a(String r5, a r6, d.c.d<? super x> r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L15;
        Object r4 = a(r8, "响应为空", r9);
        if (r4 != d.c.a.b.a()) goto L14;
        return r4;
    L14:
        return x.f38692a;
    L15:
        JSONObject r2 = new JSONObject(r5);
        int r3 = r2.optInt(MonitorConstants.CODE, -1);
        if (r3 != 200) goto L22;
        Object r10 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r8, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r9);
        if (r10 != d.c.a.b.a()) goto L21;
        return r10;
    L21:
        return x.f38692a;
    L22:
        Object r11 = a(r8, "业务错误 code=" + r3 + " message=" + r2.optString("message"), r9);
        if (r11 != d.c.a.b.a()) goto L26;
        return r11;
    L26:
        return x.f38692a;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final Object a(a r4, String r5, d.c.d<? super x> r6) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Object r8 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0295f(r3, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
        if (r8 != d.c.a.b.a()) goto L6;
        return r8;
    L6:
        return x.f38692a;
    }

    private final String a(String r6) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r7 = true;
    L10:
        if (r7 == false) goto L12;
        return null;
    L12:
        JSONObject r8 = new JSONObject(r6);
        if (r8.optInt(MonitorConstants.CODE, -1) == 200) goto L15;
        return null;
    L15:
        JSONObject r9 = r8.optJSONObject("data");
        if (r9 == null) goto L25;
        String r10 = r9.optString("accessToken");
        if (r10 != null) goto L20;
        return null;
    L20:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L22;
        r1 = true;
    L22:
        if (r1 == true) goto L24;
        return null;
    L24:
        return r10;
    L25:
        return null;
    L5:
        if (r5.length() == 0) goto L8;
        r7 = false;
        goto L10
    }
}
