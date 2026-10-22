package com.bytedance.safetyguard.lxc.internal.e.a;

import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.KevaImpl;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
/* JADX INFO: loaded from: classes.dex */
public final class x implements com.bytedance.safetyguard.lxc.internal.e.a.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10415a = null;
    private static final d.o.k p = null;
    private static final d.o.k q = null;
    private static final d.o.k r = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<Long> f10418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.a<Long> f10419e;
    private final com.bytedance.safetyguard.lxc.internal.a.e f;
    private final com.bytedance.safetyguard.lxc.internal.e.a.n g;
    private final com.bytedance.safetyguard.lxc.internal.e.a.s h;
    private final com.bytedance.safetyguard.lxc.internal.e.a.q i;
    private final com.bytedance.safetyguard.lxc.internal.e.a.h.a j;
    private final com.bytedance.safetyguard.lxc.internal.e.a.h.b k;
    private final com.bytedance.safetyguard.lxc.internal.e.a.h.c l;
    private final com.bytedance.safetyguard.lxc.internal.e.a.h.e m;
    private final com.bytedance.safetyguard.lxc.internal.e.a.h.d n;
    private final com.bytedance.safetyguard.lxc.internal.e.a.a.i o;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.a.x$1, reason: invalid class name */
    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f10420a = null;

        static {
            f10420a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        public final Long a() {
            return Long.valueOf(System.currentTimeMillis());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.a.x$2, reason: invalid class name */
    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    /* synthetic */ class AnonymousClass2 extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass2 f10421a = null;

        static {
            f10421a = new AnonymousClass2();
        }

        AnonymousClass2() {
            super(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);
        }

        public final Long a() {
            return Long.valueOf(SystemClock.elapsedRealtime());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10422a = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.e.c.b.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.e.c.b.f10716a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[com.bytedance.safetyguard.lxc.internal.e.c.b.f10717b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[com.bytedance.safetyguard.lxc.internal.e.c.b.f10718c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[com.bytedance.safetyguard.lxc.internal.e.c.b.f10719d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[com.bytedance.safetyguard.lxc.internal.e.c.b.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[com.bytedance.safetyguard.lxc.internal.e.c.b.f10720e.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f10422a = r0;
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {106}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient$beginAppRegistration$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.f>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ x f10425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SidecarBrand f10426d;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.a.x$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SidecarBrand f10427a;

            AnonymousClass1(SidecarBrand r1) {
                this.f10427a = r1;
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }

            public final String a() {
                return "component=oauth event=app_registration_begin_started outcome=pending brand=" + this.f10427a.name();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.a.x$c$2, reason: invalid class name */
        /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
        static final class AnonymousClass2 extends d.h.b.p implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SidecarBrand f10428a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ x f10429b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ JSONObject f10430c;

            AnonymousClass2(SidecarBrand r1, x r2, JSONObject r3) {
                this.f10428a = r1;
                this.f10429b = r2;
                this.f10430c = r3;
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }

            public final String a() {
                StringBuilder r0 = new StringBuilder().append("component=oauth event=app_registration_begin_finished outcome=success brand=").append(this.f10428a.name()).append(" expiresInSec=").append(x.b(this.f10429b, this.f10430c)).append(" intervalSec=");
                JSONObject r1 = this.f10430c;
                x.e(this.f10429b);
                return r0.append(r1.optInt("interval", 5)).toString();
            }
        }

        c(x r3, SidecarBrand r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10425c = r3;
            this.f10426d = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.f> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f10425c, this.f10426d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.f> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r22) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f10424b;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            com.bytedance.safetyguard.lxc.internal.e.c.a r3 = (com.bytedance.safetyguard.lxc.internal.e.c.a) ZeusTransformUtils.preCheckCast(this.f10423a, com.bytedance.safetyguard.lxc.internal.e.c.a.class, "com.obric.aiagent.plugin");
            d.o.a(r22);
            Object r4 = r22;
            com.bytedance.safetyguard.lxc.internal.e.c.a r8 = r3;
        L12:
            com.bytedance.safetyguard.lxc.internal.e.a.r r7 = (com.bytedance.safetyguard.lxc.internal.e.a.r) ZeusTransformUtils.preCheckCast(r4, com.bytedance.safetyguard.lxc.internal.e.a.r.class, "com.obric.aiagent.plugin");
            x r5 = this.f10425c;
            JSONObject r6 = x.a(r5, x.a(r5, r7, r8));
            x.e(this.f10425c);
            String r9 = r6.optString(SensitiveType.DEVICE_CODE);
            d.h.b.o.a(r9);
            String r10 = null;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L17;
            r9 = null;
        L17:
            if (r9 == null) goto L26;
            x.e(this.f10425c);
            String r11 = r6.optString("user_code");
            d.h.b.o.a(r11);
            if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L21;
            r10 = r11;
        L21:
            if (r10 == null) goto L24;
            x.a(this.f10425c, r8, r7.a());
            x.a(this.f10425c).a("UrlConnectionLarkOAuthClient", (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f10426d, this.f10425c, r6), d.h.a.a.class, "com.obric.aiagent.plugin"));
            String r12 = x.a(this.f10425c, this.f10426d, r10);
            int r13 = x.b(this.f10425c, r6);
            x.e(this.f10425c);
            return new com.bytedance.safetyguard.lxc.internal.e.a.f(r9, r12, r13, r6.optInt("interval", 5));
        L24:
            x r14 = this.f10425c;
            StringBuilder r15 = new StringBuilder().append("app registration did not return ");
            x.e(this.f10425c);
            x.a(r14, r7, r8, r15.append("user_code").toString(), null, 8, null);
            throw new d.d();
        L26:
            x r16 = this.f10425c;
            StringBuilder r17 = new StringBuilder().append("app registration did not return ");
            x.e(this.f10425c);
            x.a(r16, r7, r8, r17.append(SensitiveType.DEVICE_CODE).toString(), null, 8, null);
            throw new d.d();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r22);
            x.a(this.f10425c).a("UrlConnectionLarkOAuthClient", (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f10426d), d.h.a.a.class, "com.obric.aiagent.plugin"));
            URL r18 = new URL(SidecarBrand.FEISHU.getAccountsBaseUrl() + "/oauth/v1/app/registration");
            x r19 = this.f10425c;
            x.b(r19);
            com.bytedance.safetyguard.lxc.internal.e.c.a r20 = x.a(r19, "app-registration-begin", "POST", r18, this.f10426d, null, null, null, false, 240, null);
            x r21 = this.f10425c;
            x.b(r21);
            x.c(this.f10425c);
            x.d(this.f10425c);
            x.c(this.f10425c);
            x.d(this.f10425c);
            x.c(this.f10425c);
            x.d(this.f10425c);
            x.c(this.f10425c);
            x.d(this.f10425c);
            Map r110 = (Map) ZeusTransformUtils.preCheckCast(ao.d(new d.m[]{d.s.a("action", "begin"), d.s.a("archetype", "PersonalAgent"), d.s.a("auth_method", "client_secret"), d.s.a("request_user_info", "open_id tenant_brand")}), Map.class, "com.obric.aiagent.plugin");
            d.c.d r111 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10423a = r20;
            this.f10424b = 1;
            r4 = x.a(r21, r18, "app-registration-begin", r110, r20, null, null, null, null, null, false, r111, 496, null);
            if (r4 != r1) goto L11;
            return r1;
        L11:
            r8 = r20;
            goto L12
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {572}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient$executeForm$3")
    static final class d extends d.c.b.a.l implements d.h.a.b<d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.p>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x f10432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.o f10433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ URL f10434d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f10435e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;

        d(x r3, com.bytedance.safetyguard.lxc.internal.e.a.o r4, URL r5, Map<String, String> r6, String r7, String r8, d.c.d<? super d> r9) {
            Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10432b = r3;
            this.f10433c = r4;
            this.f10434d = r5;
            this.f10435e = r10;
            this.f = r7;
            this.g = r8;
            super(1, r11);
        }

        public final Object a(d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.p> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r11) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f10432b, this.f10433c, this.f10434d, this.f10435e, this.f, this.g, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.p> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10431a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L15:
            return (com.bytedance.safetyguard.lxc.internal.e.a.p) ZeusTransformUtils.preCheckCast(r8, com.bytedance.safetyguard.lxc.internal.e.a.p.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            com.bytedance.safetyguard.lxc.internal.e.a.n r9 = x.j(this.f10432b);
            if (r9 == null) goto L11;
            URL r2 = this.f10434d;
            Map<String, String> r3 = this.f10435e;
            String r4 = this.f;
            String r7 = this.g;
            Map r5 = ao.b();
            String r6 = r2.toString();
            d.h.b.o.c(r6, "toString(...)");
            String r10 = r9.a(r6, r3, r4, r7);
            Charset r11 = StandardCharsets.UTF_8;
            d.h.b.o.c(r11, "UTF_8");
            byte[] r12 = r10.getBytes(r11);
            d.h.b.o.c(r12, "getBytes(...)");
            return new com.bytedance.safetyguard.lxc.internal.e.a.p(200, r5, r12);
        L11:
            com.bytedance.safetyguard.lxc.internal.e.a.q r13 = x.k(this.f10432b);
            com.bytedance.safetyguard.lxc.internal.e.a.o r14 = this.f10433c;
            d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.p> r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10431a = 1;
            r8 = r13.a(r14, r15);
            if (r8 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    static final class e extends d.h.b.p implements d.h.a.b<Map.Entry<? extends String, ? extends String>, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f10436a;

        e(x r1) {
            this.f10436a = r1;
            super(1);
        }

        public final CharSequence a(Map.Entry<String, String> r6) {
            Map.Entry r7 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r6, Map.Entry.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r7, "it");
            return (CharSequence) ZeusTransformUtils.preCheckCast(x.b(this.f10436a, (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.aiagent.plugin")) + '=' + x.b(this.f10436a, (String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends String> r3) {
            return a((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {615}, d = "executeRequest", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10439c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f10440d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f10441e;
        Object f;
        Object g;
        boolean h;
        long i;
        /* synthetic */ Object j;
        final /* synthetic */ x k;
        int l;

        f(x r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            this.j = r11;
            this.l |= Integer.MIN_VALUE;
            return x.a(this.k, null, null, null, null, null, null, false, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {611}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient$executeRequest$2")
    static final class g extends d.c.b.a.l implements d.h.a.b<d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.p>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x f10443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.o f10444c;

        g(x r3, com.bytedance.safetyguard.lxc.internal.e.a.o r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10443b = r3;
            this.f10444c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.p> r3) {
            return ((g) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f10443b, this.f10444c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.p> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10442a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.bytedance.safetyguard.lxc.internal.e.a.q r7 = x.k(this.f10443b);
            com.bytedance.safetyguard.lxc.internal.e.a.o r2 = this.f10444c;
            d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.p> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10442a = 1;
            r6 = r7.a(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {368}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient$getTenantAccessToken$2")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.t>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10447c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f10448d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ SidecarBrand f10449e;
        final /* synthetic */ x f;

        h(String r3, String r4, SidecarBrand r5, x r6, d.c.d<? super h> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10447c = r3;
            this.f10448d = r4;
            this.f10449e = r5;
            this.f = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.t> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f10447c, this.f10448d, this.f10449e, this.f, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.t> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r23) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f10446b;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            com.bytedance.safetyguard.lxc.internal.e.c.a r3 = (com.bytedance.safetyguard.lxc.internal.e.c.a) ZeusTransformUtils.preCheckCast(this.f10445a, com.bytedance.safetyguard.lxc.internal.e.c.a.class, "com.obric.aiagent.plugin");
            d.o.a(r23);
            Object r5 = r23;
            com.bytedance.safetyguard.lxc.internal.e.c.a r8 = r3;
        L12:
            com.bytedance.safetyguard.lxc.internal.e.a.r r7 = (com.bytedance.safetyguard.lxc.internal.e.a.r) ZeusTransformUtils.preCheckCast(r5, com.bytedance.safetyguard.lxc.internal.e.a.r.class, "com.obric.aiagent.plugin");
            x r4 = this.f;
            JSONObject r6 = x.a(r4, x.a(r4, r7, r8));
            String r9 = r6.optString("tenant_access_token");
            d.h.b.o.a(r9);
            if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
            r9 = null;
        L16:
            if (r9 == null) goto L19;
            x.a(this.f, r8, r7.a());
            return new com.bytedance.safetyguard.lxc.internal.e.a.t(r9, ((Number) ZeusTransformUtils.preCheckCast(x.g(this.f).invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() + (r6.optLong("expire", 7200) * 1000));
        L19:
            x.a(this.f, r7, r8, "tenant token endpoint did not return tenant_access_token", null, 8, null);
            throw new d.d();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r23);
            JSONObject r10 = new JSONObject().put("app_id", this.f10447c).put("app_secret", this.f10448d);
            URL r11 = new URL(this.f10449e.getOpenBaseUrl() + "/open-apis/auth/v3/tenant_access_token/internal");
            x r12 = this.f;
            com.bytedance.safetyguard.lxc.internal.e.c.a r13 = x.a(r12, "tenant-token", "POST", r11, this.f10449e, x.a(r12).a(this.f10447c), null, null, false, 224, null);
            x r14 = this.f;
            d.h.b.o.a(r10);
            Set r15 = ax.a(new String[]{this.f10447c, this.f10448d});
            d.c.d r16 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10445a = r13;
            this.f10446b = 1;
            r5 = x.a(r14, r11, "tenant-token", r10, r13, r15, false, r16);
            if (r5 != r1) goto L11;
            return r1;
        L11:
            r8 = r13;
            goto L12
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {493}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient$getUserInfo$3")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.m<? extends String, ? extends String>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SidecarBrand f10452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ x f10453d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f10454e;
        final /* synthetic */ String f;

        i(SidecarBrand r3, x r4, String r5, String r6, d.c.d<? super i> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10452c = r3;
            this.f10453d = r4;
            this.f10454e = r5;
            this.f = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.m<String, String>> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f10452c, this.f10453d, this.f10454e, this.f, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.m<? extends String, ? extends String>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r29) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f10451b;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            com.bytedance.safetyguard.lxc.internal.e.c.a r3 = (com.bytedance.safetyguard.lxc.internal.e.c.a) ZeusTransformUtils.preCheckCast(this.f10450a, com.bytedance.safetyguard.lxc.internal.e.c.a.class, "com.obric.aiagent.plugin");
            d.o.a(r29);
            Object r4 = r29;
            com.bytedance.safetyguard.lxc.internal.e.c.a r7 = r3;
        L12:
            com.bytedance.safetyguard.lxc.internal.e.a.r r6 = (com.bytedance.safetyguard.lxc.internal.e.a.r) ZeusTransformUtils.preCheckCast(r4, com.bytedance.safetyguard.lxc.internal.e.a.r.class, "com.obric.aiagent.plugin");
            x r5 = this.f10453d;
            JSONObject r8 = x.a(r5, x.a(r5, r6, r7));
            String r9 = r8.optString("open_id", r8.optString("openId"));
            d.h.b.o.a(r9);
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L20;
            x.a(this.f10453d, r7, r6.a());
            String r0 = r8.optString("name");
            d.h.b.o.a(r0);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L19;
            r0 = null;
        L19:
            return d.s.a(r9, r0);
        L20:
            x.a(this.f10453d, r6, r7, "user info endpoint did not return open_id", null, 8, null);
            throw new d.d();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r29);
            URL r10 = new URL(this.f10452c.getOpenBaseUrl() + "/open-apis/authen/v1/user_info");
            x r11 = this.f10453d;
            com.bytedance.safetyguard.lxc.internal.e.c.a r12 = x.a(r11, "user-info", "GET", r10, this.f10452c, x.a(r11).a(this.f10454e), null, null, false, 224, null);
            x r13 = this.f10453d;
            com.bytedance.safetyguard.lxc.internal.e.a.o r17 = new com.bytedance.safetyguard.lxc.internal.e.a.o("GET", r10, ao.a(d.s.a("Authorization", "Bearer " + this.f)), new byte[0], x.h(this.f10453d), x.i(this.f10453d));
            Set r20 = ax.a(new String[]{this.f10454e, this.f});
            d.c.d r25 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10450a = r12;
            this.f10451b = 1;
            r4 = x.a(r13, r17, "user-info", r12, r20, null, null, false, null, r25, 176, null);
            if (r4 != r1) goto L11;
            return r1;
        L11:
            r7 = r12;
            goto L12
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    static final class j extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.c.a f10455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.c.c f10456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10457c;

        j(com.bytedance.safetyguard.lxc.internal.e.c.a r1, com.bytedance.safetyguard.lxc.internal.e.c.c r2, String r3) {
            this.f10455a = r1;
            this.f10456b = r2;
            this.f10457c = r3;
            super(0);
        }

        public final String a() {
            return com.bytedance.safetyguard.lxc.internal.e.c.f.a(this.f10455a, this.f10456b) + this.f10457c;
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    static final class k extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SidecarBrand f10458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f10460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f10461d;

        k(SidecarBrand r1, String r2, int r3, int r4) {
            this.f10458a = r1;
            this.f10459b = r2;
            this.f10460c = r3;
            this.f10461d = r4;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=oauth event=app_registration_poll_started outcome=pending brand=" + this.f10458a.name() + " deviceRef=" + this.f10459b + " expiresInSec=" + this.f10460c + " intervalSec=" + this.f10461d;
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {163}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient$pollAppRegistration$3")
    static final class l extends d.c.b.a.l implements d.h.a.m<com.bytedance.safetyguard.lxc.internal.e.a.w, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.i>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f10463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ x f10464c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SidecarBrand f10465d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10466e;
        final /* synthetic */ int f;
        final /* synthetic */ String g;
        final /* synthetic */ String h;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.a.x$l$1, reason: invalid class name */
        /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
        @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {185}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient$pollAppRegistration$3$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.s<String, Map<String, ? extends String>, String, Long, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.r>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f10467a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f10468b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f10469c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f10470d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ long f10471e;
            final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.w f;
            final /* synthetic */ x g;
            final /* synthetic */ SidecarBrand h;
            final /* synthetic */ String i;
            final /* synthetic */ String j;

            AnonymousClass1(com.bytedance.safetyguard.lxc.internal.e.a.w r3, x r4, SidecarBrand r5, String r6, String r7, d.c.d<? super AnonymousClass1> r8) {
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                this.f = r3;
                this.g = r4;
                this.h = r5;
                this.i = r6;
                this.j = r7;
                super(5, r9);
            }

            @Override // d.h.a.s
            public /* synthetic */ Object a(String r10, Map<String, ? extends String> r11, String r12, Long r13, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.r> r14) {
                return a((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).longValue(), (d.c.d) ZeusTransformUtils.preCheckCast(r14, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(String r8, Map<String, String> r9, String r10, long r11, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.r> r13) {
                Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r14 = new AnonymousClass1(this.f, this.g, this.h, this.i, this.j, r6);
                r14.f10468b = r8;
                r14.f10469c = r12;
                r14.f10470d = r10;
                r14.f10471e = r11;
                return r14.invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r22) {
                Object r0 = d.c.a.b.a();
                int r2 = this.f10467a;
                if (r2 == 0) goto L11;
                if (r2 != 1) goto L10;
                d.o.a(r22);     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                Object r3 = r22;
            L18:
                this.f.a((com.bytedance.safetyguard.lxc.internal.e.a.r) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.e.a.r.class, "com.obric.aiagent.plugin"));     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                return (com.bytedance.safetyguard.lxc.internal.e.a.r) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.e.a.r.class, "com.obric.aiagent.plugin");
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                d.o.a(r22);
                String r4 = (String) ZeusTransformUtils.preCheckCast(this.f10468b, String.class, "com.obric.aiagent.plugin");
                Map r9 = (Map) ZeusTransformUtils.preCheckCast(this.f10469c, Map.class, "com.obric.aiagent.plugin");
                String r8 = (String) ZeusTransformUtils.preCheckCast(this.f10470d, String.class, "com.obric.aiagent.plugin");
                long r5 = this.f10471e;
                com.bytedance.safetyguard.lxc.internal.e.a.w r7 = this.f;
                r7.a(r7.a() + 1);
                URL r10 = new URL(r4);
                x r6 = this.g;
                String r11 = r10.getHost();
                d.h.b.o.c(r11, "getHost(...)");
                SidecarBrand r12 = x.a(r6, r11);
                if (r12 != null) goto L14;
                r12 = this.h;
            L14:
                x r13 = this.g;
                com.bytedance.safetyguard.lxc.internal.e.c.a r14 = x.a(r13, r8, "POST", r10, r12, null, this.i, d.c.b.a.b.a(this.f.a()), true, 16, null);
                x r15 = this.g;     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                Long r16 = d.c.b.a.b.a(r5);     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                Set r17 = ax.a(this.j);     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                d.c.d r18 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                this.f10468b = null;     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                this.f10469c = null;     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                this.f10467a = 1;     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                r3 = x.a(r15, r10, r8, r9, r14, null, r16, r17, null, null, false, r18, 400, null);     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                if (r3 != r0) goto L18;
                return r0;
            L7:
                e = move-exception;
                this.f.a(e);
                throw e;
            }
        }

        l(x r3, SidecarBrand r4, int r5, int r6, String r7, String r8, d.c.d<? super l> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10464c = r3;
            this.f10465d = r4;
            this.f10466e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            super(2, r10);
        }

        public final Object a(com.bytedance.safetyguard.lxc.internal.e.a.w r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.i> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            l r13 = new l(this.f10464c, this.f10465d, this.f10466e, this.f, this.g, this.h, r9);
            r13.f10463b = r11;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r13, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.bytedance.safetyguard.lxc.internal.e.a.w r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.i> r4) {
            return a((com.bytedance.safetyguard.lxc.internal.e.a.w) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.e.a.w.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r21) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f10462a;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            d.o.a(r21);
            return r21;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r21);
            com.bytedance.safetyguard.lxc.internal.e.a.w r7 = (com.bytedance.safetyguard.lxc.internal.e.a.w) ZeusTransformUtils.preCheckCast(this.f10463b, com.bytedance.safetyguard.lxc.internal.e.a.w.class, "com.obric.aiagent.plugin");
            com.bytedance.safetyguard.lxc.internal.e.a.a.i r3 = x.f(this.f10464c);
            com.bytedance.safetyguard.lxc.internal.e.a.c r4 = new com.bytedance.safetyguard.lxc.internal.e.a.c(this.f10465d, false, 2, null);
            com.bytedance.safetyguard.lxc.internal.e.a.a.d r10 = new com.bytedance.safetyguard.lxc.internal.e.a.a.d(this.f10466e, this.f, com.bytedance.safetyguard.lxc.internal.e.a.a.a.f10297a, 0, null, 8, null);
            com.bytedance.safetyguard.lxc.internal.e.a.a.h r6 = (com.bytedance.safetyguard.lxc.internal.e.a.a.h) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.g(this.g, (d.h.a.s) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7, this.f10464c, this.f10465d, this.h, this.g, null), d.h.a.s.class, "com.obric.aiagent.plugin")), com.bytedance.safetyguard.lxc.internal.e.a.a.h.class, "com.obric.aiagent.plugin");
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10462a = 1;
            Object r0 = r3.a(r4, r10, r6, r5);
            if (r0 != r1) goto L12;
            return r1;
        L12:
            return r0;
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {293, 343}, d = "pollDeviceToken", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient")
    static final class m extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10474c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f10475d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f10476e;
        final /* synthetic */ x f;
        int g;

        m(x r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            this.f10476e = r10;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, null, null, 0, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    static final class n extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SidecarBrand f10477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f10480d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10481e;

        n(SidecarBrand r1, String r2, String r3, int r4, int r5) {
            this.f10477a = r1;
            this.f10478b = r2;
            this.f10479c = r3;
            this.f10480d = r4;
            this.f10481e = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=oauth event=device_token_poll_started outcome=pending brand=" + this.f10477a.name() + " appRef=" + this.f10478b + " deviceRef=" + this.f10479c + " expiresInSec=" + this.f10480d + " intervalSec=" + this.f10481e;
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {299}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient$pollDeviceToken$token$1")
    static final class o extends d.c.b.a.l implements d.h.a.m<com.bytedance.safetyguard.lxc.internal.e.a.w, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.v>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f10483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ x f10484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f10485d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10486e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ SidecarBrand h;
        final /* synthetic */ String i;
        final /* synthetic */ String j;
        final /* synthetic */ String k;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.a.x$o$1, reason: invalid class name */
        /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
        @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {327}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient$pollDeviceToken$token$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.s<String, Map<String, ? extends String>, String, Long, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.r>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f10487a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f10488b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f10489c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f10490d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ long f10491e;
            final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.w f;
            final /* synthetic */ x g;
            final /* synthetic */ SidecarBrand h;
            final /* synthetic */ String i;
            final /* synthetic */ String j;
            final /* synthetic */ String k;
            final /* synthetic */ String l;
            final /* synthetic */ String m;

            AnonymousClass1(com.bytedance.safetyguard.lxc.internal.e.a.w r3, x r4, SidecarBrand r5, String r6, String r7, String r8, String r9, String r10, d.c.d<? super AnonymousClass1> r11) {
                d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
                this.f = r3;
                this.g = r4;
                this.h = r5;
                this.i = r6;
                this.j = r7;
                this.k = r8;
                this.l = r9;
                this.m = r10;
                super(5, r12);
            }

            @Override // d.h.a.s
            public /* synthetic */ Object a(String r10, Map<String, ? extends String> r11, String r12, Long r13, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.r> r14) {
                return a((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).longValue(), (d.c.d) ZeusTransformUtils.preCheckCast(r14, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(String r14, Map<String, String> r15, String r16, long r17, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.r> r19) {
                Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
                d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r2 = new AnonymousClass1(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, r12);
                r2.f10488b = r14;
                r2.f10489c = r1;
                r2.f10490d = r16;
                r2.f10491e = r17;
                return r2.invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r21) {
                Object r0 = d.c.a.b.a();
                int r2 = this.f10487a;
                if (r2 == 0) goto L11;
                if (r2 != 1) goto L10;
                d.o.a(r21);     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                Object r3 = r21;
            L15:
                this.f.a((com.bytedance.safetyguard.lxc.internal.e.a.r) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.e.a.r.class, "com.obric.aiagent.plugin"));     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                return (com.bytedance.safetyguard.lxc.internal.e.a.r) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.e.a.r.class, "com.obric.aiagent.plugin");
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                d.o.a(r21);
                String r4 = (String) ZeusTransformUtils.preCheckCast(this.f10488b, String.class, "com.obric.aiagent.plugin");
                Map r9 = (Map) ZeusTransformUtils.preCheckCast(this.f10489c, Map.class, "com.obric.aiagent.plugin");
                String r8 = (String) ZeusTransformUtils.preCheckCast(this.f10490d, String.class, "com.obric.aiagent.plugin");
                long r5 = this.f10491e;
                com.bytedance.safetyguard.lxc.internal.e.a.w r7 = this.f;
                r7.a(r7.a() + 1);
                URL r10 = new URL(r4);
                com.bytedance.safetyguard.lxc.internal.e.c.a r11 = x.a(this.g, r8, "POST", r10, this.h, this.i, this.j, d.c.b.a.b.a(this.f.a()), true);
                x r6 = this.g;     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                Long r12 = d.c.b.a.b.a(r5);     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                Set r13 = ax.a(new String[]{this.k, this.l, this.m});     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                d.c.d r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                this.f10488b = null;     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                this.f10489c = null;     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                this.f10487a = 1;     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                r3 = x.a(r6, r10, r8, r9, r11, null, r12, r13, null, null, false, r17, 400, null);     // Catch: com.bytedance.safetyguard.lxc.internal.e.a.m -> L7
                if (r3 != r0) goto L15;
                return r0;
            L7:
                e = move-exception;
                this.f.a(e);
                throw e;
            }
        }

        o(x r3, int r4, int r5, String r6, String r7, SidecarBrand r8, String r9, String r10, String r11, d.c.d<? super o> r12) {
            d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10484c = r3;
            this.f10485d = r4;
            this.f10486e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            super(2, r13);
        }

        public final Object a(com.bytedance.safetyguard.lxc.internal.e.a.w r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.v> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r14, d.c.d<?> r15) {
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
            o r16 = new o(this.f10484c, this.f10485d, this.f10486e, this.f, this.g, this.h, this.i, this.j, this.k, r12);
            r16.f10483b = r14;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r16, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.bytedance.safetyguard.lxc.internal.e.a.w r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.v> r4) {
            return a((com.bytedance.safetyguard.lxc.internal.e.a.w) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.e.a.w.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r26) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f10482a;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            d.o.a(r26);
            return r26;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r26);
            com.bytedance.safetyguard.lxc.internal.e.a.w r7 = (com.bytedance.safetyguard.lxc.internal.e.a.w) ZeusTransformUtils.preCheckCast(this.f10483b, com.bytedance.safetyguard.lxc.internal.e.a.w.class, "com.obric.aiagent.plugin");
            com.bytedance.safetyguard.lxc.internal.e.a.a.i r3 = x.f(this.f10484c);
            com.bytedance.safetyguard.lxc.internal.e.a.e r4 = com.bytedance.safetyguard.lxc.internal.e.a.e.f10347a;
            com.bytedance.safetyguard.lxc.internal.e.a.a.d r6 = new com.bytedance.safetyguard.lxc.internal.e.a.a.d(this.f10485d, this.f10486e, com.bytedance.safetyguard.lxc.internal.e.a.a.a.f10298b, 0, d.c.b.a.b.a(600), 8, null);
            com.bytedance.safetyguard.lxc.internal.e.a.a.h r5 = (com.bytedance.safetyguard.lxc.internal.e.a.a.h) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.k(this.f, this.g, this.h, this.i, x.g(this.f10484c), (d.h.a.s) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7, this.f10484c, this.h, this.j, this.k, this.f, this.g, this.i, null), d.h.a.s.class, "com.obric.aiagent.plugin")), com.bytedance.safetyguard.lxc.internal.e.a.a.h.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10482a = 1;
            Object r0 = r3.a(r4, r6, r5, r8);
            if (r0 != r1) goto L12;
            return r1;
        L12:
            return r0;
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    /* synthetic */ class p extends d.h.b.l implements d.h.a.m<Long, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f10492a = null;

        static {
            f10492a = new p();
        }

        p() {
            super(2, kotlinx.coroutines.ax.class, "delay", "delay(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
        }

        public final Object a(long r2, d.c.d<? super d.x> r4) {
            return kotlinx.coroutines.ax.a(r2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Long r5, d.c.d<? super d.x> r6) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue(), (d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {450}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient$postToken$2")
    static final class q extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.v>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SidecarBrand f10495c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ x f10496d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f10497e;
        final /* synthetic */ String f;
        final /* synthetic */ JSONObject g;
        final /* synthetic */ Set<String> h;

        q(SidecarBrand r3, x r4, String r5, String r6, JSONObject r7, Set<String> r8, d.c.d<? super q> r9) {
            Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10495c = r3;
            this.f10496d = r4;
            this.f10497e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r10;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.v> r4) {
            return ((q) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new q(this.f10495c, this.f10496d, this.f10497e, this.f, this.g, this.h, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.v> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            Object r0 = d.c.a.b.a();
            int r3 = this.f10494b;
            if (r3 == 0) goto L8;
            if (r3 != 1) goto L7;
            com.bytedance.safetyguard.lxc.internal.e.c.a r1 = (com.bytedance.safetyguard.lxc.internal.e.c.a) ZeusTransformUtils.preCheckCast(this.f10493a, com.bytedance.safetyguard.lxc.internal.e.c.a.class, "com.obric.aiagent.plugin");
            d.o.a(r18);
            Object r4 = r18;
            com.bytedance.safetyguard.lxc.internal.e.c.a r8 = r1;
        L12:
            com.bytedance.safetyguard.lxc.internal.e.a.r r7 = (com.bytedance.safetyguard.lxc.internal.e.a.r) ZeusTransformUtils.preCheckCast(r4, com.bytedance.safetyguard.lxc.internal.e.a.r.class, "com.obric.aiagent.plugin");
            x r2 = this.f10496d;
            JSONObject r5 = x.a(r2, x.a(r2, r7, r8));
            String r6 = r5.optString("access_token");
            d.h.b.o.c(r6, "optString(...)");
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L25;
            x.a(this.f10496d, r7, r8, "OAuth token endpoint did not return access_token", null, 8, null);
            throw new d.d();
        L25:
            com.bytedance.safetyguard.lxc.internal.e.a.v r9 = x.c(this.f10496d, r5);     // Catch: IllegalStateException -> L17 JSONException -> L20
            x.a(this.f10496d, r8, r7.a());
            return r9;
        L17:
            e = move-exception;
            x.a(this.f10496d, r7, r8, "OAuth response was malformed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            throw new d.d();
        L20:
            e = move-exception;
            x.a(this.f10496d, r7, r8, "OAuth response was malformed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            throw new d.d();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r18);
            URL r10 = new URL(this.f10495c.getOpenBaseUrl() + "/open-apis/authen/v2/oauth/token");
            x r11 = this.f10496d;
            com.bytedance.safetyguard.lxc.internal.e.c.a r14 = x.a(r11, this.f10497e, "POST", r10, this.f10495c, x.a(r11).a(this.f), null, null, false, 224, null);
            x r12 = this.f10496d;
            String r13 = this.f10497e;
            JSONObject r15 = this.g;
            Set<String> r16 = this.h;
            d.c.d r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10493a = r14;
            this.f10494b = 1;
            r4 = x.a(r12, r10, r13, r15, r14, r16, false, r17);
            if (r4 != r0) goto L11;
            return r0;
        L11:
            r8 = r14;
            goto L12
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {BDAbstractUpload.KeyIsTotalRequestTimeout}, d = "refreshAccessToken", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient")
    static final class r extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f10499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ x f10500c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10501d;

        r(x r3, d.c.d<? super r> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10500c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10499b = r3;
            this.f10501d |= Integer.MIN_VALUE;
            return this.f10500c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    /* synthetic */ class s extends d.h.b.l implements d.h.a.b<CharSequence, Boolean> {
        s(Object r8) {
            super(1, r8, d.o.k.class, "matches", "matches(Ljava/lang/CharSequence;)Z", 0);
        }

        public final Boolean a(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "p0");
            return Boolean.valueOf(((d.o.k) ZeusTransformUtils.preCheckCast(this.receiver, d.o.k.class, "com.obric.aiagent.plugin")).a(r4));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(CharSequence r3) {
            return a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {240}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient$requestDeviceAuthorization$2")
    static final class t extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.j>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10505d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ x f10506e;
        final /* synthetic */ Set<String> f;
        final /* synthetic */ String g;
        final /* synthetic */ String h;
        final /* synthetic */ SidecarBrand i;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.a.x$t$1, reason: invalid class name */
        /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SidecarBrand f10507a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f10508b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Set<String> f10509c;

            AnonymousClass1(SidecarBrand r3, String r4, Set<String> r5) {
                Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
                this.f10507a = r3;
                this.f10508b = r4;
                this.f10509c = r6;
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }

            public final String a() {
                return "component=oauth event=device_authorization_started outcome=pending brand=" + this.f10507a.name() + " appRef=" + this.f10508b + " scopeCount=" + this.f10509c.size();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.a.x$t$2, reason: invalid class name */
        /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
        static final class AnonymousClass2 extends d.h.b.p implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SidecarBrand f10510a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f10511b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.j f10512c;

            AnonymousClass2(SidecarBrand r1, String r2, com.bytedance.safetyguard.lxc.internal.e.a.j r3) {
                this.f10510a = r1;
                this.f10511b = r2;
                this.f10512c = r3;
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }

            public final String a() {
                return "component=oauth event=device_authorization_finished outcome=success brand=" + this.f10510a.name() + " appRef=" + this.f10511b + " expiresInSec=" + this.f10512c.c() + " intervalSec=" + this.f10512c.d();
            }
        }

        t(x r3, Set<String> r4, String r5, String r6, SidecarBrand r7, d.c.d<? super t> r8) {
            Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10506e = r3;
            this.f = r9;
            this.g = r5;
            this.h = r6;
            this.i = r7;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.j> r4) {
            return ((t) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new t(this.f10506e, this.f, this.g, this.h, this.i, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.j> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r31) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f10505d;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            com.bytedance.safetyguard.lxc.internal.e.c.a r3 = (com.bytedance.safetyguard.lxc.internal.e.c.a) ZeusTransformUtils.preCheckCast(this.f10504c, com.bytedance.safetyguard.lxc.internal.e.c.a.class, "com.obric.aiagent.plugin");
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f10503b, String.class, "com.obric.aiagent.plugin");
            Set r6 = (Set) ZeusTransformUtils.preCheckCast(this.f10502a, Set.class, "com.obric.aiagent.plugin");
            d.o.a(r31);
            Object r8 = r31;
            com.bytedance.safetyguard.lxc.internal.e.c.a r11 = r3;
            Set r17 = r6;
        L12:
            com.bytedance.safetyguard.lxc.internal.e.a.r r10 = (com.bytedance.safetyguard.lxc.internal.e.a.r) ZeusTransformUtils.preCheckCast(r8, com.bytedance.safetyguard.lxc.internal.e.a.r.class, "com.obric.aiagent.plugin");
            JSONObject r5 = x.a(this.f10506e, x.a(this.f10506e, r10, r11));
            String r7 = r5.optString(SensitiveType.DEVICE_CODE);
            d.h.b.o.a(r7);
            String r9 = null;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L15;
            String r13 = r7;
        L16:
            if (r13 == null) goto L25;
            String r12 = r5.optString("verification_uri_complete");
            d.h.b.o.a(r12);
            if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L20;
            r9 = r12;
        L20:
            if (r9 != null) goto L22;
            String r14 = r5.optString("verification_uri");
        L23:
            d.h.b.o.a(r14);
            com.bytedance.safetyguard.lxc.internal.e.a.j r15 = new com.bytedance.safetyguard.lxc.internal.e.a.j(r13, r14, r5.optInt("expires_in", 240), r5.optInt("interval", 5), r17);
            x.a(this.f10506e, r11, r10.a());
            x.a(this.f10506e).a("UrlConnectionLarkOAuthClient", (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.i, r4, r15), d.h.a.a.class, "com.obric.aiagent.plugin"));
            return r15;
        L22:
            r14 = r9;
            goto L23
        L25:
            x.a(this.f10506e, r10, r11, "device authorization did not return device_code", null, 8, null);
            throw new d.d();
        L15:
            r13 = null;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r31);
            Set r16 = x.a(this.f10506e, this.f);
            r4 = x.a(this.f10506e).a(this.g);
            x.a(this.f10506e).a("UrlConnectionLarkOAuthClient", (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.i, r4, r16), d.h.a.a.class, "com.obric.aiagent.plugin"));
            StringBuilder r18 = new StringBuilder().append("Basic ");
            Base64.Encoder r19 = Base64.getEncoder();
            String r20 = this.g + ':' + this.h;
            Charset r110 = StandardCharsets.UTF_8;
            d.h.b.o.c(r110, "UTF_8");
            byte[] r21 = r20.getBytes(r110);
            d.h.b.o.c(r21, "getBytes(...)");
            String r22 = r18.append(r19.encodeToString(r21)).toString();
            URL r111 = new URL(this.i.getAccountsBaseUrl() + "/oauth/v1/device_authorization");
            com.bytedance.safetyguard.lxc.internal.e.c.a r112 = x.a(this.f10506e, "device-authorization-begin", "POST", r111, this.i, r4, null, null, false, 224, null);
            LinkedHashMap r23 = ao.d(new d.m[]{d.s.a("client_id", this.g), d.s.a("scope", d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null))});
            Set r113 = ax.a(new String[]{this.g, this.h});
            int r24 = r16.size();
            String r114 = x.b(this.f10506e, r16);
            x r115 = this.f10506e;
            Map r116 = (Map) ZeusTransformUtils.preCheckCast(r23, Map.class, "com.obric.aiagent.plugin");
            Integer r117 = d.c.b.a.b.a(r24);
            d.c.d r25 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10502a = r16;
            this.f10503b = r4;
            this.f10504c = r112;
            this.f10505d = 1;
            r8 = x.a(r115, r111, "device-authorization-begin", r116, r112, r22, null, r113, r117, r114, false, r25, 32, null);
            if (r8 != r1) goto L11;
            return r1;
        L11:
            r17 = r16;
            r11 = r112;
            goto L12
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    @d.c.b.a.f(b = "UrlConnectionLarkOAuthClient.kt", c = {812}, d = "runLoggedPoll", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthClient")
    static final class u<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f10516d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f10517e;
        Object f;
        long g;
        /* synthetic */ Object h;
        final /* synthetic */ x i;
        int j;

        u(x r3, d.c.d<? super u> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.h = r8;
            this.j |= Integer.MIN_VALUE;
            return x.a(this.i, null, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    static final class v extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f10518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SidecarBrand f10520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f10521d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f10522e;
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.w f;
        final /* synthetic */ long g;

        v(x r1, String r2, SidecarBrand r3, String r4, String r5, com.bytedance.safetyguard.lxc.internal.e.a.w r6, long r7) {
            this.f10518a = r1;
            this.f10519b = r2;
            this.f10520c = r3;
            this.f10521d = r4;
            this.f10522e = r5;
            this.f = r6;
            this.g = r7;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            x r0 = this.f10518a;
            return x.a(r0, "success", this.f10519b, this.f10520c, this.f10521d, this.f10522e, this.f, x.a(r0, this.g), null, 128, null);
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    static final class w extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f10523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SidecarBrand f10525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f10526d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f10527e;
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.w f;
        final /* synthetic */ long g;

        w(x r1, String r2, SidecarBrand r3, String r4, String r5, com.bytedance.safetyguard.lxc.internal.e.a.w r6, long r7) {
            this.f10523a = r1;
            this.f10524b = r2;
            this.f10525c = r3;
            this.f10526d = r4;
            this.f10527e = r5;
            this.f = r6;
            this.g = r7;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            x r0 = this.f10523a;
            return x.a(r0, "cancelled", this.f10524b, this.f10525c, this.f10526d, this.f10527e, this.f, x.a(r0, this.g), null, 128, null);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.a.x$x, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    static final class C0235x extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f10528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.m f10529b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10530c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SidecarBrand f10531d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f10532e;
        final /* synthetic */ String f;
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.w g;
        final /* synthetic */ long h;

        C0235x(x r1, com.bytedance.safetyguard.lxc.internal.e.a.m r2, String r3, SidecarBrand r4, String r5, String r6, com.bytedance.safetyguard.lxc.internal.e.a.w r7, long r8) {
            this.f10528a = r1;
            this.f10529b = r2;
            this.f10530c = r3;
            this.f10531d = r4;
            this.f10532e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            x r0 = this.f10528a;
            if (d.h.b.o.a(this.f10529b.a(), "timeout") == false) goto L5;
        L8:
            String r1 = "timeout";
        L10:
            return x.a(r0, r1, this.f10530c, this.f10531d, this.f10532e, this.f, this.g, x.a(this.f10528a, this.h), this.f10529b);
        L5:
            if (d.h.b.o.a(this.f10529b.a(), "network_timeout") == true) goto L8;
            r1 = "failed";
            goto L10
        }
    }

    /* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
    static final class y extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f10533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SidecarBrand f10535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f10536d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f10537e;
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.w f;
        final /* synthetic */ long g;

        y(x r1, String r2, SidecarBrand r3, String r4, String r5, com.bytedance.safetyguard.lxc.internal.e.a.w r6, long r7) {
            this.f10533a = r1;
            this.f10534b = r2;
            this.f10535c = r3;
            this.f10536d = r4;
            this.f10537e = r5;
            this.f = r6;
            this.g = r7;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            x r0 = this.f10533a;
            return x.a(r0, "failed", this.f10534b, this.f10535c, this.f10536d, this.f10537e, this.f, x.a(r0, this.g), null, 128, null);
        }
    }

    public x() {
        this(0, 0, null, null, null, null, null, null, 255, null);
    }

    public x(int r3, int r4, d.h.a.a<Long> r5, d.h.a.a<Long> r6, com.bytedance.safetyguard.lxc.internal.a.e r7, com.bytedance.safetyguard.lxc.internal.e.a.n r8, com.bytedance.safetyguard.lxc.internal.e.a.s r9, com.bytedance.safetyguard.lxc.internal.e.a.q r10) {
        d.h.a.a<Long> r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<Long> r12 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r13 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.a.n r14 = (com.bytedance.safetyguard.lxc.internal.e.a.n) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.safetyguard.lxc.internal.e.a.n.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.a.s r15 = (com.bytedance.safetyguard.lxc.internal.e.a.s) ZeusTransformUtils.wrapperContextForParams(r9, com.bytedance.safetyguard.lxc.internal.e.a.s.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.a.q r16 = (com.bytedance.safetyguard.lxc.internal.e.a.q) ZeusTransformUtils.wrapperContextForParams(r10, com.bytedance.safetyguard.lxc.internal.e.a.q.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "nowMillis");
        d.h.b.o.e(r12, "monotonicMillis");
        d.h.b.o.e(r13, "logger");
        d.h.b.o.e(r16, "httpTransport");
        this.f10416b = r3;
        this.f10417c = r4;
        this.f10418d = r11;
        this.f10419e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = com.bytedance.safetyguard.lxc.internal.e.a.h.a.f10362a;
        this.k = com.bytedance.safetyguard.lxc.internal.e.a.h.b.f10363a;
        this.l = com.bytedance.safetyguard.lxc.internal.e.a.h.c.f10364a;
        this.m = com.bytedance.safetyguard.lxc.internal.e.a.h.e.f10366a;
        this.n = com.bytedance.safetyguard.lxc.internal.e.a.h.d.f10365a;
        this.o = new com.bytedance.safetyguard.lxc.internal.e.a.a.i(r12, (d.h.a.m) ZeusTransformUtils.preCheckCast(p.f10492a, d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ long a(x r0, long r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ SidecarBrand a(x r0, String r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.a.e a(x r0) {
        return r0.f;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.c.a a(x r0, String r1, String r2, URL r3, SidecarBrand r4, String r5, String r6, Integer r7, boolean r8) {
        return r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static final /* synthetic */ Object a(x r12, com.bytedance.safetyguard.lxc.internal.e.a.o r13, String r14, com.bytedance.safetyguard.lxc.internal.e.c.a r15, Set r16, Integer r17, String r18, boolean r19, d.h.a.b r20, d.c.d r21) {
        return r12.a(r13, r14, r15, (Set) ZeusTransformUtils.wrapperContextForParams(r16, Set.class, "com.obric.aiagent.plugin"), r17, r18, r19, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(x r9, String r10, SidecarBrand r11, String r12, String r13, d.h.a.m r14, d.c.d r15) {
        return r9.a(r10, r11, r12, r13, (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.m.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(x r10, URL r11, String r12, JSONObject r13, com.bytedance.safetyguard.lxc.internal.e.c.a r14, Set r15, boolean r16, d.c.d r17) {
        return r10.a(r11, r12, r13, r14, (Set) ZeusTransformUtils.wrapperContextForParams(r15, Set.class, "com.obric.aiagent.plugin"), r16, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(x r0, SidecarBrand r1, String r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ String a(x r0, String r1, String r2, SidecarBrand r3, String r4, String r5, com.bytedance.safetyguard.lxc.internal.e.a.w r6, long r7, com.bytedance.safetyguard.lxc.internal.e.a.m r9) {
        return r0.a(r1, r2, r3, r4, r5, r6, r7, r9);
    }

    public static final /* synthetic */ Void a(x r0, com.bytedance.safetyguard.lxc.internal.e.a.r r1, com.bytedance.safetyguard.lxc.internal.e.c.a r2, String r3, Throwable r4) {
        return r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Set a(x r2, Set r3) {
        return r2.a((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ JSONObject a(x r0, com.bytedance.safetyguard.lxc.internal.e.a.r r1, com.bytedance.safetyguard.lxc.internal.e.c.a r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ JSONObject a(x r0, JSONObject r1) {
        return r0.c(r1);
    }

    public static final /* synthetic */ void a(x r0, com.bytedance.safetyguard.lxc.internal.e.c.a r1, com.bytedance.safetyguard.lxc.internal.e.c.c r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ int b(x r0, JSONObject r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.h.b b(x r0) {
        return r0.k;
    }

    public static final /* synthetic */ String b(x r0, String r1) {
        return r0.c(r1);
    }

    public static final /* synthetic */ String b(x r2, Set r3) {
        return r2.b((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.h.a c(x r0) {
        return r0.j;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.v c(x r0, JSONObject r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.h.e d(x r0) {
        return r0.m;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.h.d e(x r0) {
        return r0.n;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.a.i f(x r0) {
        return r0.o;
    }

    public static final /* synthetic */ d.h.a.a g(x r0) {
        return r0.f10418d;
    }

    public static final /* synthetic */ int h(x r0) {
        return r0.f10416b;
    }

    public static final /* synthetic */ int i(x r0) {
        return r0.f10417c;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.n j(x r0) {
        return r0.g;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.q k(x r0) {
        return r0.i;
    }

    public /* synthetic */ x(int r13, int r14, d.h.a.a r15, d.h.a.a r16, com.bytedance.safetyguard.lxc.internal.a.e r17, com.bytedance.safetyguard.lxc.internal.e.a.n r18, com.bytedance.safetyguard.lxc.internal.e.a.s r19, com.bytedance.safetyguard.lxc.internal.e.a.q r20, int r21, d.h.b.h r22) {
        d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r4 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r17, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.a.n r5 = (com.bytedance.safetyguard.lxc.internal.e.a.n) ZeusTransformUtils.wrapperContextForParams(r18, com.bytedance.safetyguard.lxc.internal.e.a.n.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.a.s r6 = (com.bytedance.safetyguard.lxc.internal.e.a.s) ZeusTransformUtils.wrapperContextForParams(r19, com.bytedance.safetyguard.lxc.internal.e.a.s.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.a.q r7 = (com.bytedance.safetyguard.lxc.internal.e.a.q) ZeusTransformUtils.wrapperContextForParams(r20, com.bytedance.safetyguard.lxc.internal.e.a.q.class, "com.obric.aiagent.plugin");
        if ((r21 & 1) == 0) goto L5;
        int r8 = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
    L7:
        if ((r21 & 2) == 0) goto L9;
        int r9 = 30000;
    L11:
        if ((r21 & 4) == 0) goto L14;
        r1 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f10420a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L14:
        if ((r21 & 8) == 0) goto L17;
        r3 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass2.f10421a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L17:
        if ((r21 & 16) == 0) goto L20;
        r4 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.a.d.f9723a, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
    L20:
        if ((r21 & 32) == 0) goto L23;
        r5 = null;
    L23:
        if ((r21 & 64) == 0) goto L26;
        r6 = null;
    L26:
        if ((r21 & 128) == 0) goto L28;
        r7 = (com.bytedance.safetyguard.lxc.internal.e.a.q) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.e.a.y.f10538a, com.bytedance.safetyguard.lxc.internal.e.a.q.class, "com.obric.aiagent.plugin");
    L28:
        this(r8, r9, r1, r3, r4, r5, r6, r7);
        return;
    L9:
        r9 = r14;
        goto L11
    L5:
        r8 = r13;
        goto L7
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.l
    public Object a(SidecarBrand r5, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.f> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.l
    public Object a(SidecarBrand r15, String r16, int r17, int r18, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.i> r19) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        int r3 = d.l.n.c(r17, 1);
        String r11 = this.f.a(r16);
        this.f.a("UrlConnectionLarkOAuthClient", (d.h.a.a) ZeusTransformUtils.preCheckCast(new k(r15, r11, r18, r3), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return a(this, "app-registration-poll", r15, null, r11, (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(this, r15, r3, r18, r16, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r10, 4, null);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.l
    public Object a(String r10, String r11, SidecarBrand r12, Set<String> r13, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.j> r14) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new t(this, r4, r10, r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r15);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.l
    public Object a(String r21, String r22, SidecarBrand r23, String r24, int r25, int r26, Set<String> r27, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.v> r28) {
        x r11 = this;
        String r12 = r21;
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r27, Set.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, m.class) == false) goto L7;
        m r1 = (m) ZeusTransformUtils.preCheckCast(r0, m.class, "com.obric.aiagent.plugin");
        if ((r1.g & Integer.MIN_VALUE) == 0) goto L7;
        r1.g -= Integer.MIN_VALUE;
    L8:
        m r15 = r1;
        Object r2 = r15.f10476e;
        Object r10 = d.c.a.b.a();
        int r3 = r15.g;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        com.bytedance.safetyguard.lxc.internal.e.a.v r4 = (com.bytedance.safetyguard.lxc.internal.e.a.v) ZeusTransformUtils.preCheckCast(r15.f10473b, com.bytedance.safetyguard.lxc.internal.e.a.v.class, "com.obric.aiagent.plugin");
        Collection r5 = (Set) ZeusTransformUtils.preCheckCast(r15.f10472a, Set.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L24:
        d.m r6 = (d.m) ZeusTransformUtils.preCheckCast(r2, d.m.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.a(), String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.b(), String.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r4.g(), Collection.class, "com.obric.aiagent.plugin");
        if (r13.isEmpty() == true) goto L29;
        r5 = r13;
    L29:
        return com.bytedance.safetyguard.lxc.internal.e.a.v.a(r4, r7, r8, null, null, 0, 0, (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.aiagent.plugin"), 60, null);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Set r16 = (Set) ZeusTransformUtils.preCheckCast(r15.f10475d, Set.class, "com.obric.aiagent.plugin");
        SidecarBrand r9 = (SidecarBrand) ZeusTransformUtils.preCheckCast(r15.f10474c, SidecarBrand.class, "com.obric.aiagent.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r15.f10473b, String.class, "com.obric.aiagent.plugin");
        x r18 = (x) ZeusTransformUtils.preCheckCast(r15.f10472a, x.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        SidecarBrand r19 = r9;
        r12 = r17;
        r11 = r18;
        Object r20 = r10;
    L20:
        com.bytedance.safetyguard.lxc.internal.e.a.v r29 = (com.bytedance.safetyguard.lxc.internal.e.a.v) ZeusTransformUtils.preCheckCast(r2, com.bytedance.safetyguard.lxc.internal.e.a.v.class, "com.obric.aiagent.plugin");
        String r30 = r29.c();
        r15.f10472a = r16;
        r15.f10473b = r29;
        r15.f10474c = null;
        r15.f10475d = null;
        r15.g = 2;
        Object r31 = r11.b(r19, r12, r30, r15);
        if (r31 != r20) goto L23;
        return r20;
    L23:
        r4 = r29;
        r2 = r31;
        r5 = r16;
        goto L24
    L16:
        d.o.a(r2);
        int r32 = d.l.n.c(r25, 1);
        String r110 = r11.f.a(r12);
        String r111 = r11.f.a(r24);
        r11.f.a("UrlConnectionLarkOAuthClient", (d.h.a.a) ZeusTransformUtils.preCheckCast(new n(r23, r110, r111, r26, r32), d.h.a.a.class, "com.obric.aiagent.plugin"));
        d.h.a.m r33 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(this, r32, r26, r21, r22, r23, r24, r110, r111, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r15.f10472a = r11;
        r15.f10473b = r12;
        r19 = r23;
        r15.f10474c = r19;
        r15.f10475d = r14;
        r15.g = 1;
        r2 = a("device-token-poll", r23, r110, r111, r33, r15);
        r20 = r10;
        if (r2 != r20) goto L19;
        return r20;
    L19:
        r16 = r14;
    L7:
        r1 = new m(r11, r0);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.l
    public Object a(SidecarBrand r10, String r11, String r12, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.t> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r11, r12, r10, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r14);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.l
    public Object a(com.bytedance.safetyguard.lxc.internal.e.a.u r20, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.v> r21) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, r.class) == false) goto L7;
        r r2 = (r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.aiagent.plugin");
        if ((r2.f10501d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f10501d -= Integer.MIN_VALUE;
    L8:
        r r9 = r2;
        Object r1 = r9.f10499b;
        Object r3 = d.c.a.b.a();
        int r4 = r9.f10501d;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        com.bytedance.safetyguard.lxc.internal.e.a.u r5 = (com.bytedance.safetyguard.lxc.internal.e.a.u) ZeusTransformUtils.preCheckCast(r9.f10498a, com.bytedance.safetyguard.lxc.internal.e.a.u.class, "com.obric.aiagent.plugin");
        d.o.a(r1);
        Object r6 = r1;
        com.bytedance.safetyguard.lxc.internal.e.a.u r7 = r5;
    L21:
        return com.bytedance.safetyguard.lxc.internal.e.a.v.a((com.bytedance.safetyguard.lxc.internal.e.a.v) ZeusTransformUtils.preCheckCast(r6, com.bytedance.safetyguard.lxc.internal.e.a.v.class, "com.obric.aiagent.plugin"), r7.d(), null, null, null, 0, 0, null, 126, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r1);
        JSONObject r8 = new JSONObject().put("grant_type", "refresh_token").put("client_id", r20.b()).put("client_secret", r20.c()).put("refresh_token", r20.e());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r20.f(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L17;
        r8.put("scope", d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r20.f(), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
    L17:
        SidecarBrand r10 = r20.a();
        d.h.b.o.a(r8);
        String r11 = r20.b();
        Set<String> r12 = ax.a(new String[]{r20.b(), r20.c(), r20.d(), r20.e()});
        r7 = r20;
        r9.f10498a = r7;
        r9.f10501d = 1;
        r6 = a(r10, "refresh-token", r8, r11, r12, r9);
        if (r6 != r3) goto L21;
        return r3;
    L7:
        r2 = new r(this, r0);
        goto L8
    }

    private final Object a(SidecarBrand r13, String r14, JSONObject r15, String r16, Set<String> r17, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.v> r18) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r17, Set.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new q(r13, this, r14, r16, r15, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r0);
    }

    private final com.bytedance.safetyguard.lxc.internal.e.a.v a(JSONObject r2) {
        return com.bytedance.safetyguard.lxc.internal.e.a.k.f10376a.a(r2, this.f10418d);
    }

    private final Object b(SidecarBrand r10, String r11, String r12, d.c.d<? super d.m<String, String>> r13) {
        d.c.d<? super d.m<String, String>> r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.a.s r0 = this.h;
        if (r0 == null) goto L7;
        return r0.a(r10, r12, r14);
    L7:
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r10, this, r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r14);
    }

    static /* synthetic */ Object a(x r15, URL r16, String r17, Map r18, com.bytedance.safetyguard.lxc.internal.e.c.a r19, String r20, Long r21, Set r22, Integer r23, String r24, boolean r25, d.c.d r26, int r27, Object r28) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        Set<String> r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r22, Set.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.r> r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r27 & 16) == 0) goto L5;
        String r8 = null;
    L7:
        if ((r27 & 32) == 0) goto L9;
        Long r9 = null;
    L11:
        if ((r27 & 64) == 0) goto L13;
        r1 = ax.b();
    L13:
        Set<String> r10 = r1;
        if ((r27 & 128) == 0) goto L16;
        Integer r11 = null;
    L18:
        if ((r27 & 256) == 0) goto L20;
        String r12 = null;
    L22:
        if ((r27 & 512) == 0) goto L24;
        boolean r13 = true;
    L26:
        return r15.a(r16, r17, r6, r19, r8, r9, r10, r11, r12, r13, r14);
    L24:
        r13 = r25;
        goto L26
    L20:
        r12 = r24;
        goto L22
    L16:
        r11 = r23;
        goto L18
    L9:
        r9 = r21;
        goto L11
    L5:
        r8 = r20;
        goto L7
    }

    private final Object a(URL r21, String r22, Map<String, String> r23, com.bytedance.safetyguard.lxc.internal.e.c.a r24, String r25, Long r26, Set<String> r27, Integer r28, String r29, boolean r30, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.r> r31) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r27, Set.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.r> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        String r2 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r4.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("&", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.b.class, "com.obric.aiagent.plugin"), 30, null);
        Charset r3 = StandardCharsets.UTF_8;
        d.h.b.o.c(r3, "UTF_8");
        byte[] r15 = r2.getBytes(r3);
        d.h.b.o.c(r15, "getBytes(...)");
        LinkedHashMap r5 = ao.d(new d.m[]{d.s.a(DownloadHelper.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=utf-8")});
        if (r25 == null) goto L5;
        ((Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin")).put("Authorization", r25);
    L5:
        com.bytedance.safetyguard.lxc.internal.e.a.o r18 = new com.bytedance.safetyguard.lxc.internal.e.a.o("POST", r21, (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin"), r15, a(this.f10416b, r26), a(this.f10417c, r26));
        Set r0 = ax.a();
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin"));
        if (r25 == null) goto L9;
        r0.add(r25);
        r0.add(d.o.o.b(r25, ' ', r25));
    L9:
        return a(r18, r22, r24, ax.a(r0), r28, r29, r30, (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this, r18, r21, r4, r25, r22, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r10);
    }

    private final Object a(URL r18, String r19, JSONObject r20, com.bytedance.safetyguard.lxc.internal.e.c.a r21, Set<String> r22, boolean r23, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.r> r24) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r22, Set.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        String r1 = r20.toString();
        d.h.b.o.c(r1, "toString(...)");
        Charset r2 = StandardCharsets.UTF_8;
        d.h.b.o.c(r2, "UTF_8");
        byte[] r14 = r1.getBytes(r2);
        d.h.b.o.c(r14, "getBytes(...)");
        return a(this, new com.bytedance.safetyguard.lxc.internal.e.a.o("POST", r18, ao.a(d.s.a(DownloadHelper.CONTENT_TYPE, "application/json; charset=utf-8")), r14, this.f10416b, this.f10417c), r19, r21, r4, null, null, r23, null, r9, 176, null);
    }

    private final Object a(com.bytedance.safetyguard.lxc.internal.e.a.o r29, String r30, com.bytedance.safetyguard.lxc.internal.e.c.a r31, Set<String> r32, Integer r33, String r34, boolean r35, d.h.a.b<? super d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.p>, ? extends Object> r36, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.r> r37) {
        x r1 = this;
        Set r0 = (Set) ZeusTransformUtils.wrapperContextForParams(r32, Set.class, "com.obric.aiagent.plugin");
        d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r36, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r37, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, f.class) == false) goto L7;
        f r5 = (f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin");
        if ((r5.l & Integer.MIN_VALUE) == 0) goto L7;
        r5.l -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.j;
        Object r7 = d.c.a.b.a();
        int r8 = r5.l;
        if (r8 == 0) goto L18;
        if (r8 != 1) goto L17;
        long r9 = r5.i;
        boolean r2 = r5.h;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r5.g, String.class, "com.obric.aiagent.plugin");
        Integer r11 = (Integer) ZeusTransformUtils.preCheckCast(r5.f, Integer.class, "com.obric.aiagent.plugin");
        Set r12 = (Set) ZeusTransformUtils.preCheckCast(r5.f10441e, Set.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.c.a r13 = (com.bytedance.safetyguard.lxc.internal.e.c.a) ZeusTransformUtils.preCheckCast(r5.f10440d, com.bytedance.safetyguard.lxc.internal.e.c.a.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r5.f10439c, String.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.a.o r15 = (com.bytedance.safetyguard.lxc.internal.e.a.o) ZeusTransformUtils.preCheckCast(r5.f10438b, com.bytedance.safetyguard.lxc.internal.e.a.o.class, "com.obric.aiagent.plugin");
        x r16 = (x) ZeusTransformUtils.preCheckCast(r5.f10437a, x.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: IOException -> L14 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        boolean r17 = r2;
        String r18 = r10;
        r1 = r16;
        long r19 = r9;
        String r20 = r14;
    L101:
        com.bytedance.safetyguard.lxc.internal.e.a.p r21 = (com.bytedance.safetyguard.lxc.internal.e.a.p) ZeusTransformUtils.preCheckCast(r6, com.bytedance.safetyguard.lxc.internal.e.a.p.class, "com.obric.aiagent.plugin");     // Catch: IOException -> L57 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        com.bytedance.safetyguard.lxc.internal.e.c.c r22 = r1.a(com.bytedance.safetyguard.lxc.internal.e.c.f.a(r21.a(), r21.b(), r21.c(), r15.d().length, r1.a(r19), true, r12), r20, r21.c());     // Catch: IOException -> L55 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        com.bytedance.safetyguard.lxc.internal.e.a.r r23 = new com.bytedance.safetyguard.lxc.internal.e.a.r(r21.c(), r22);     // Catch: IOException -> L55 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        int r24 = b.f10422a[r22.a().ordinal()];     // Catch: IOException -> L55 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        boolean r110 = true;
        if (r24 != 1) goto L38;
        if (r17 == false) goto L54;
        a(r1, r13, r22, r11, r18, null, 16, null);     // Catch: IOException -> L50 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
    L54:
        return r23;
    L38:
        if (r24 != 2) goto L40;
        a(r1, r13, r22, r11, r18, null, 16, null);     // Catch: IOException -> L50 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        goto L54
    L40:
        if (r24 != 3) goto L42;
    L47:
        a(r1, r13, r22, r11, r18, null, 16, null);     // Catch: IOException -> L50 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        throw r1.a(r20, r22);     // Catch: IOException -> L50 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
    L42:
        if (r24 == 4) goto L47;
        if (r24 == 5) goto L47;
        throw new IllegalStateException("Unexpected HTTP diagnostic outcome: " + r22.a());     // Catch: IOException -> L50 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
    L50:
        e = e;
    L77:
        if (r1.a(r20) == true) goto L79;
    L81:
        boolean r25 = false;
    L82:
        if (r25 == false) goto L84;
        String r26 = "network_timeout";
    L85:
        if (r25 == false) goto L87;
        String r27 = "OAuth request timed out";
    L88:
        com.bytedance.safetyguard.lxc.internal.e.c.g r111 = new com.bytedance.safetyguard.lxc.internal.e.c.g(null, null, r26, r27, null, null);
        if (r25 == false) goto L91;
        com.bytedance.safetyguard.lxc.internal.e.c.b r28 = com.bytedance.safetyguard.lxc.internal.e.c.b.g;
    L92:
        r1.a(r13, new com.bytedance.safetyguard.lxc.internal.e.c.c(r28, null, r15.d().length, 0, r1.a(r19), null, null, null, null, r111), r11, r18, e.getClass().getName());
        throw new com.bytedance.safetyguard.lxc.internal.e.a.m(r26, r27, r20, r111, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L91:
        r28 = com.bytedance.safetyguard.lxc.internal.e.c.b.f10720e;
        goto L92
    L87:
        r27 = "OAuth request failed due to a network error";
        goto L88
    L84:
        r26 = "network_error";
        goto L85
    L79:
        if (ZeusTransformUtils.instanceOf(e, SocketTimeoutException.class) == false) goto L81;
        r25 = r110;
    L55:
        e = e;
        r110 = true;
    L57:
        e = e;
        r110 = true;
    L14:
        e = e;
        r18 = r10;
        r1 = r16;
        r19 = r9;
        r110 = true;
        r20 = r14;
        goto L77
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r6);
        long r38 = ((Number) ZeusTransformUtils.preCheckCast(r1.f10419e.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        r5.f10437a = r1;     // Catch: IOException -> L69 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        com.bytedance.safetyguard.lxc.internal.e.a.o r39 = r29;
        r5.f10438b = r39;     // Catch: IOException -> L67 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        r20 = r30;
        r5.f10439c = r20;     // Catch: IOException -> L65 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        com.bytedance.safetyguard.lxc.internal.e.c.a r112 = r31;
        r5.f10440d = r112;     // Catch: IOException -> L63 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        r5.f10441e = r0;     // Catch: IOException -> L63 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        Integer r113 = r33;
        r5.f = r113;     // Catch: IOException -> L61 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        r18 = r34;
        r5.g = r18;     // Catch: IOException -> L59 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        r17 = r35;
        r5.h = r17;     // Catch: IOException -> L59 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        r5.i = r38;     // Catch: IOException -> L59 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        r5.l = 1;     // Catch: IOException -> L59 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        Object r40 = r3.invoke(r5);     // Catch: IOException -> L59 com.bytedance.safetyguard.lxc.internal.e.a.m -> L94 CancellationException -> L96
        if (r40 != r7) goto L32;
        return r7;
    L32:
        r19 = r38;
        r13 = r112;
        r12 = r0;
        r6 = r40;
        r11 = r113;
        r15 = r39;
    L59:
        e = e;
    L75:
        r110 = true;
        r19 = r38;
        r13 = r112;
        r11 = r113;
        r15 = r39;
    L61:
        e = e;
    L74:
        r18 = r34;
    L63:
        e = e;
    L73:
        r113 = r33;
    L65:
        e = e;
    L72:
        r112 = r31;
    L67:
        e = e;
    L71:
        r20 = r30;
    L69:
        e = e;
        r39 = r29;
    L94:
        e = move-exception;
        throw e;
    L96:
        e = move-exception;
        throw e;
    L7:
        r5 = new f(r1, r4);
        goto L8
    }

    static /* synthetic */ Object a(x r13, com.bytedance.safetyguard.lxc.internal.e.a.o r14, String r15, com.bytedance.safetyguard.lxc.internal.e.c.a r16, Set r17, Integer r18, String r19, boolean r20, d.h.a.b r21, d.c.d r22, int r23, Object r24) {
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r17, Set.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.p>, ? extends Object> r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.r> r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r23 & 16) == 0) goto L5;
        Integer r8 = null;
    L7:
        if ((r23 & 32) == 0) goto L9;
        String r9 = null;
    L11:
        if ((r23 & 64) == 0) goto L13;
        boolean r10 = true;
    L15:
        if ((r23 & 128) == 0) goto L17;
        d.h.a.b<? super d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.p>, ? extends Object> r11 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new g(r13, r14, null), d.h.a.b.class, "com.obric.aiagent.plugin");
    L19:
        return r13.a(r14, r15, r16, r7, r8, r9, r10, r11, r12);
    L17:
        r11 = r1;
        goto L19
    L13:
        r10 = r20;
        goto L15
    L9:
        r9 = r19;
        goto L11
    L5:
        r8 = r18;
        goto L7
    }

    private final JSONObject a(com.bytedance.safetyguard.lxc.internal.e.a.r r4, com.bytedance.safetyguard.lxc.internal.e.c.a r5) {
        return new JSONObject(r4.b());
    L4:
        e = move-exception;
        a(r4, r5, "OAuth response was malformed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw new d.d();
    }

    static /* synthetic */ Void a(x r0, com.bytedance.safetyguard.lxc.internal.e.a.r r1, com.bytedance.safetyguard.lxc.internal.e.c.a r2, String r3, Throwable r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.a(r1, r2, r3, r4);
    }

    private final Void a(com.bytedance.safetyguard.lxc.internal.e.a.r r24, com.bytedance.safetyguard.lxc.internal.e.c.a r25, String r26, Throwable r27) {
        Integer r1 = r24.a().b();
        com.bytedance.safetyguard.lxc.internal.e.c.g r0 = r24.a().j();
        if (r0 == null) goto L5;
        String r5 = r0.e();
    L6:
        com.bytedance.safetyguard.lxc.internal.e.c.g r2 = r24.a().j();
        if (r2 == null) goto L9;
        String r6 = r2.f();
    L10:
        com.bytedance.safetyguard.lxc.internal.e.c.g r14 = new com.bytedance.safetyguard.lxc.internal.e.c.g(r1, null, "malformed_response", r26, r5, r6);
        a(this, r25, com.bytedance.safetyguard.lxc.internal.e.c.c.a(r24.a(), com.bytedance.safetyguard.lxc.internal.e.c.b.f, null, 0, 0, 0, null, null, null, null, r14, 510, null), null, null, null, 28, null);
        throw new com.bytedance.safetyguard.lxc.internal.e.a.m("malformed_response", r26, r25.b(), r14, r27);
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    private final com.bytedance.safetyguard.lxc.internal.e.a.m a(String r9, com.bytedance.safetyguard.lxc.internal.e.c.c r10) {
        com.bytedance.safetyguard.lxc.internal.e.c.g r4 = r10.j();
        int r8 = b.f10422a[r10.a().ordinal()];
        if (r8 != 5) goto L5;
        String r11 = "malformed_response";
    L23:
        String r1 = r11;
        if (r4 == null) goto L29;
        String r12 = r4.d();
        if (r12 == null) goto L29;
    L39:
        return new com.bytedance.safetyguard.lxc.internal.e.a.m(r1, r12, r9, r4, null, 16, null);
    L29:
        int r13 = b.f10422a[r10.a().ordinal()];
        if (r13 == 3) goto L34;
        if (r13 == 5) goto L33;
        r12 = "OAuth request was rejected by the upstream service";
        goto L39
    L33:
        r12 = "OAuth response was malformed";
        goto L39
    L34:
        StringBuilder r14 = new StringBuilder().append("OAuth request failed with HTTP status ");
        Object r15 = r10.b();
        if (r15 != null) goto L37;
        r15 = SensitiveType.UNKNOWN;
    L37:
        r12 = r14.append(r15).toString();
        goto L39
    L5:
        if (r8 == 6) goto L21;
        if (r4 == null) goto L15;
        r11 = r4.c();
        if (r11 == null) goto L15;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L13;
        r11 = null;
    L13:
        if (r11 != null) goto L23;
    L15:
        if (r10.a() != com.bytedance.safetyguard.lxc.internal.e.c.b.f10718c) goto L20;
        StringBuilder r16 = new StringBuilder().append("http_");
        Object r2 = r10.b();
        if (r2 != null) goto L19;
        r2 = WsConstants.KEY_CONNECTION_ERROR;
    L19:
        r11 = r16.append(r2).toString();
        goto L23
    L20:
        r11 = "oauth_error";
        goto L23
    L21:
        r11 = "network_error";
        goto L23
    }

    private final void a(com.bytedance.safetyguard.lxc.internal.e.c.a r9, com.bytedance.safetyguard.lxc.internal.e.c.c r10) {
        a(this, r9, r10, null, null, null, 28, null);
    }

    static /* synthetic */ void a(x r7, com.bytedance.safetyguard.lxc.internal.e.c.a r8, com.bytedance.safetyguard.lxc.internal.e.c.c r9, Integer r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        Integer r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r13 & 16) == 0) goto L13;
        String r6 = null;
    L14:
        r7.a(r8, r9, r4, r5, r6);
        return;
    L13:
        r6 = r12;
        goto L14
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    private final void a(com.bytedance.safetyguard.lxc.internal.e.c.a r7, com.bytedance.safetyguard.lxc.internal.e.c.c r8, Integer r9, String r10, String r11) {
        com.bytedance.safetyguard.lxc.internal.e.c.g r0 = r8.j();
        if (r0 == null) goto L5;
        String r1 = r0.c();
    L7:
        if (r7.l() == true) goto L9;
    L11:
        StringBuilder r2 = new StringBuilder();
        if (r9 == null) goto L15;
        r2.append(" scopeCount=" + ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue());
    L15:
        if (d.h.b.o.a(r1, "invalid_scope") == false) goto L25;
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L19;
    L22:
        boolean r13 = true;
    L23:
        if (r13 == true) goto L25;
        r2.append(" requestedScopes=" + r10);
        goto L25
    L19:
        if (d.o.o.d(r12) == true) goto L22;
        r13 = false;
    L25:
        if (r11 != null) goto L27;
    L32:
        String r14 = r2.toString();
        d.h.b.o.c(r14, "toString(...)");
        d.h.a.a<String> r3 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new j(r7, r8, r14), d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r8.a() != com.bytedance.safetyguard.lxc.internal.e.c.b.f10716a) goto L36;
        this.f.a("UrlConnectionLarkOAuthClient", r3);
        return;
    L36:
        if (r8.a() != com.bytedance.safetyguard.lxc.internal.e.c.b.f10717b) goto L39;
        this.f.a("UrlConnectionLarkOAuthClient", r3);
        return;
    L39:
        if (r7.l() == false) goto L48;
        if (r8.a() != com.bytedance.safetyguard.lxc.internal.e.c.b.f10720e) goto L43;
    L46:
        this.f.a("UrlConnectionLarkOAuthClient", r3);
        return;
    L43:
        if (r8.a() == com.bytedance.safetyguard.lxc.internal.e.c.b.g) goto L46;
        if (r8.a() == com.bytedance.safetyguard.lxc.internal.e.c.b.f) goto L46;
    L48:
        if (r7.l() == true) goto L54;
        com.bytedance.safetyguard.lxc.internal.a.e.a.a(this.f, "UrlConnectionLarkOAuthClient", null, r3, 2, null);
        return;
    L54:
        return;
    L27:
        if (q.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L30;
        r11 = null;
    L30:
        if (r11 == null) goto L32;
        r2.append(" exceptionClass=" + r11);
        goto L32
    L9:
        if (d.h.b.o.a(r1, "authorization_pending") == false) goto L11;
        return;
    L5:
        r1 = null;
        goto L7
    }

    static /* synthetic */ Object a(x r9, String r10, SidecarBrand r11, String r12, String r13, d.h.a.m r14, d.c.d r15, int r16, Object r17) {
        d.h.a.m r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r16 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        return r9.a(r10, r11, r5, r6, r7, r8);
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    private final <T> Object a(String r21, SidecarBrand r22, String r23, String r24, d.h.a.m<? super com.bytedance.safetyguard.lxc.internal.e.a.w, ? super d.c.d<? super T>, ? extends Object> r25, d.c.d<? super T> r26) {
        x r1 = this;
        d.h.a.m r0 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r25, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, u.class) == false) goto L7;
        u r4 = (u) ZeusTransformUtils.preCheckCast(r3, u.class, "com.obric.aiagent.plugin");
        if ((r4.j & Integer.MIN_VALUE) == 0) goto L7;
        r4.j -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.h;
        Object r6 = d.c.a.b.a();
        int r7 = r4.j;
        if (r7 == 0) goto L22;
        if (r7 != 1) goto L21;
        long r8 = r4.g;
        com.bytedance.safetyguard.lxc.internal.e.a.w r2 = (com.bytedance.safetyguard.lxc.internal.e.a.w) ZeusTransformUtils.preCheckCast(r4.f, com.bytedance.safetyguard.lxc.internal.e.a.w.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.f10517e, String.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.f10516d, String.class, "com.obric.aiagent.plugin");
        SidecarBrand r11 = (SidecarBrand) ZeusTransformUtils.preCheckCast(r4.f10515c, SidecarBrand.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r4.f10514b, String.class, "com.obric.aiagent.plugin");
        x r13 = (x) ZeusTransformUtils.preCheckCast(r4.f10513a, x.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L14 com.bytedance.safetyguard.lxc.internal.e.a.m -> L16 CancellationException -> L18
        Object r14 = r5;
        com.bytedance.safetyguard.lxc.internal.e.a.w r15 = r2;
        r1 = r13;
        long r16 = r8;
        String r17 = r12;
    L106:
        x r20 = r1;
        String r27 = r17;
        r1.f.a("UrlConnectionLarkOAuthClient", (d.h.a.a) ZeusTransformUtils.preCheckCast(new v(r1, r17, r11, r10, r9, r15, r16), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L39 com.bytedance.safetyguard.lxc.internal.e.a.m -> L41 CancellationException -> L43
        return r14;
    L41:
        e = e;
    L50:
        String r18 = r27;
        com.bytedance.safetyguard.lxc.internal.e.a.w r19 = r15;
        long r110 = r16;
        String r111 = r9;
        String r112 = r10;
        SidecarBrand r113 = r11;
        x r114 = r20;
    L92:
        com.bytedance.safetyguard.lxc.internal.a.e.a.a(r114.f, "UrlConnectionLarkOAuthClient", null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new C0235x(r114, e, r18, r113, r112, r111, r19, r110), d.h.a.a.class, "com.obric.aiagent.plugin"), 2, null);
        throw e;
    L43:
        e = e;
    L53:
        r12 = r27;
        com.bytedance.safetyguard.lxc.internal.e.a.w r115 = r15;
        long r116 = r16;
        String r117 = r9;
        String r118 = r10;
        SidecarBrand r119 = r11;
        x r120 = r20;
    L100:
        r120.f.b("UrlConnectionLarkOAuthClient", (d.h.a.a) ZeusTransformUtils.preCheckCast(new w(r120, r12, r119, r118, r117, r115, r116), d.h.a.a.class, "com.obric.aiagent.plugin"));
        throw e;
    L39:
        th = th;
    L47:
        x r121 = r20;
        String r122 = r27;
        com.bytedance.safetyguard.lxc.internal.e.a.w r123 = r15;
        long r124 = r16;
        String r125 = r9;
        String r126 = r10;
        SidecarBrand r127 = r11;
    L84:
        r121.f.b("UrlConnectionLarkOAuthClient", th, (d.h.a.a) ZeusTransformUtils.preCheckCast(new y(r121, r122, r127, r126, r125, r123, r124), d.h.a.a.class, "com.obric.aiagent.plugin"));
        throw th;
    L48:
        e = e;
        r20 = r1;
        r27 = r17;
    L51:
        e = e;
        r20 = r1;
        r27 = r17;
    L45:
        th = th;
        r20 = r1;
        r27 = r17;
        goto L47
    L16:
        e = e;
        r19 = r2;
        r110 = r8;
        r111 = r9;
        r112 = r10;
        r113 = r11;
        r18 = r12;
        r114 = r13;
    L18:
        e = e;
        r115 = r2;
        r116 = r8;
        r117 = r9;
        r118 = r10;
        r119 = r11;
        r120 = r13;
    L14:
        th = th;
        r123 = r2;
        r121 = r13;
        r124 = r8;
        r125 = r9;
        r126 = r10;
        r127 = r11;
        r122 = r12;
        goto L84
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        d.o.a(r5);
        r15 = new com.bytedance.safetyguard.lxc.internal.e.a.w(0, 0, 0, 0, 0, null, 63, null);
        long r28 = ((Number) ZeusTransformUtils.preCheckCast(r1.f10419e.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        r4.f10513a = r1;     // Catch: Throwable -> L78 com.bytedance.safetyguard.lxc.internal.e.a.m -> L86 CancellationException -> L94
        r17 = r21;
        r4.f10514b = r17;     // Catch: Throwable -> L72 com.bytedance.safetyguard.lxc.internal.e.a.m -> L74 CancellationException -> L76
        SidecarBrand r128 = r22;
        r4.f10515c = r128;     // Catch: Throwable -> L66 com.bytedance.safetyguard.lxc.internal.e.a.m -> L68 CancellationException -> L70
        String r129 = r23;
        r4.f10516d = r129;     // Catch: Throwable -> L60 com.bytedance.safetyguard.lxc.internal.e.a.m -> L62 CancellationException -> L64
        String r130 = r24;
        r4.f10517e = r130;     // Catch: Throwable -> L54 com.bytedance.safetyguard.lxc.internal.e.a.m -> L56 CancellationException -> L58
        r4.f = r15;     // Catch: Throwable -> L54 com.bytedance.safetyguard.lxc.internal.e.a.m -> L56 CancellationException -> L58
        r4.g = r28;     // Catch: Throwable -> L54 com.bytedance.safetyguard.lxc.internal.e.a.m -> L56 CancellationException -> L58
        r4.j = 1;     // Catch: Throwable -> L54 com.bytedance.safetyguard.lxc.internal.e.a.m -> L56 CancellationException -> L58
        r14 = r0.invoke(r15, r4);     // Catch: Throwable -> L54 com.bytedance.safetyguard.lxc.internal.e.a.m -> L56 CancellationException -> L58
        if (r14 != r6) goto L34;
        return r6;
    L34:
        r16 = r28;
        r11 = r128;
        r10 = r129;
        r9 = r130;
        goto L106
    L56:
        e = e;
    L91:
        r19 = r15;
        r110 = r28;
        r112 = r129;
        r111 = r130;
        r114 = r1;
        r18 = r17;
        r113 = r128;
    L58:
        e = e;
    L99:
        r115 = r15;
        r116 = r28;
        r117 = r130;
        r120 = r1;
        r118 = r129;
        r119 = r128;
        r12 = r17;
    L54:
        th = th;
    L83:
        r123 = r15;
        r124 = r28;
        r127 = r128;
        r126 = r129;
        r125 = r130;
        r121 = r1;
        r122 = r17;
        goto L84
    L62:
        e = e;
    L90:
        r130 = r24;
    L64:
        e = e;
    L98:
        r130 = r24;
    L60:
        th = th;
    L82:
        r130 = r24;
        goto L83
    L68:
        e = e;
    L89:
        r129 = r23;
    L70:
        e = e;
    L97:
        r129 = r23;
    L66:
        th = th;
    L81:
        r129 = r23;
        goto L82
    L74:
        e = e;
    L88:
        r128 = r22;
    L76:
        e = e;
    L96:
        r128 = r22;
    L72:
        th = th;
    L80:
        r128 = r22;
        goto L81
    L86:
        e = e;
        r17 = r21;
    L94:
        e = e;
        r17 = r21;
    L78:
        th = th;
        r17 = r21;
    L7:
        r4 = new u(r1, r3);
        goto L8
    }

    static /* synthetic */ String a(x r11, String r12, String r13, SidecarBrand r14, String r15, String r16, com.bytedance.safetyguard.lxc.internal.e.a.w r17, long r18, com.bytedance.safetyguard.lxc.internal.e.a.m r20, int r21, Object r22) {
        if ((r21 & 128) == 0) goto L5;
        com.bytedance.safetyguard.lxc.internal.e.a.m r10 = null;
    L7:
        return r11.a(r12, r13, r14, r15, r16, r17, r18, r10);
    L5:
        r10 = r20;
        goto L7
    }

    private final String a(String r8, String r9, SidecarBrand r10, String r11, String r12, com.bytedance.safetyguard.lxc.internal.e.a.w r13, long r14, com.bytedance.safetyguard.lxc.internal.e.a.m r16) {
        if (r16 == null) goto L6;
        com.bytedance.safetyguard.lxc.internal.e.c.g r3 = r16.c();
        if (r3 == null) goto L6;
    L7:
        StringBuilder r4 = new StringBuilder();
        r4.append("component=oauth event=poll_finished outcome=" + r8 + " operation=" + r9 + " brand=" + r10.name());
        if (r11 == null) goto L10;
        r4.append(" appRef=" + r11);
    L10:
        if (r12 == null) goto L12;
        r4.append(" deviceRef=" + r12);
    L12:
        r4.append(" attempts=" + r13.a());
        r4.append(" pendingCount=" + r13.b());
        r4.append(" slowDownCount=" + r13.c());
        r4.append(" networkRetryCount=" + r13.d());
        r4.append(" malformedRetryCount=" + r13.e());
        r4.append(" durationMs=" + r14);
        if (d.h.b.o.a(r8, "success") == false) goto L15;
    L60:
        String r0 = r4.toString();
        d.h.b.o.c(r0, "toString(...)");
        return r0;
    L15:
        if (d.h.b.o.a(r8, "cancelled") == true) goto L60;
        if (r3 == null) goto L21;
        Integer r1 = r3.a();
        if (r1 == null) goto L21;
        r4.append(" httpStatus=" + ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue());
    L21:
        if (r3 == null) goto L25;
        Integer r2 = r3.b();
        if (r2 == null) goto L25;
        r4.append(" upstreamCode=" + ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue());
    L25:
        String r5 = null;
        if (r3 == null) goto L29;
        String r6 = r3.c();
        if (r6 == null) goto L29;
    L32:
        if (r6 != null) goto L34;
    L39:
        if (r3 == null) goto L48;
        String r7 = r3.e();
        if (r7 == null) goto L48;
        if (r.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L46;
        r7 = null;
    L46:
        if (r7 == null) goto L48;
        r4.append(" logId=" + r7);
    L48:
        if (r3 == null) goto L56;
        String r15 = r3.f();
        if (r15 == null) goto L56;
        if (r.a((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L54;
        r5 = r15;
    L54:
        if (r5 == null) goto L56;
        r4.append(" requestId=" + r5);
    L56:
        if (r3 == null) goto L60;
        String r17 = r3.d();
        if (r17 == null) goto L60;
        r4.append(" errorDescription=\"");
        r4.append(d.o.o.e(d.o.o.a(d.o.o.a(r17, "\\", "\\\\", false, 4, null), "\"", "\\\"", false, 4, null), 512));
        r4.append('\"');
        goto L60
    L34:
        if (r.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L37;
        r6 = null;
    L37:
        if (r6 == null) goto L39;
        r4.append(" oauthError=" + r6);
    L29:
        if (r16 == null) goto L31;
        r6 = r16.a();
        goto L32
    L31:
        r6 = null;
    L6:
        r3 = r13.f();
        goto L7
    }

    private final Set<String> a(Set<String> r9) {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(ax.b((Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin"), "offline_access"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        d.a.p.a(r10, (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"), new char[]{',', ' '}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r12, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13.add(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        goto L8
    L10:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r15.iterator();
    L12:
        if (r17.hasNext() == false) goto L20;
        Object r1 = r17.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L12;
        r16.add(r1);
        goto L12
    L16:
        r2 = false;
        goto L17
    L20:
        return (Set) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin");
    }

    private final String b(Set<String> r11) {
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r13 = d.n.m.c(d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(new s(p), d.h.a.b.class, "com.obric.aiagent.plugin")), 50).a();
        int r1 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
        int r3 = (r2.length() + (!r12.isEmpty() ? 1 : 0)) + r1;
        if (r3 > 1024) goto L4;
        ((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).add(r2);
        r1 = r3;
        goto L4
    L9:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L12;
        r12 = null;
    L12:
        if (r12 != null) goto L14;
        return null;
    L14:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    }

    private final int b(JSONObject r2) {
        int r1 = r2.optInt("expire_in", 0);
        if (r1 <= 0) goto L6;
        return r1;
    L6:
        return r2.optInt("expires_in", 300);
    }

    private final JSONObject c(JSONObject r1) {
        JSONObject r0 = r1.optJSONObject("data");
        if (r0 != null) goto L6;
        return r1;
    L6:
        return r0;
    }

    private final com.bytedance.safetyguard.lxc.internal.e.c.c a(com.bytedance.safetyguard.lxc.internal.e.c.c r20, String r21, byte[] r22) {
        if (a(r21) == true) goto L6;
        return r20;
    L6:
        if (r20.b() != null) goto L8;
    L12:
        boolean r0 = false;
    L14:
        if (r20.a() == com.bytedance.safetyguard.lxc.internal.e.c.b.f) goto L17;
        if (r0 == true) goto L17;
        return r20;
    L17:
        com.bytedance.safetyguard.lxc.internal.e.c.b r1 = com.bytedance.safetyguard.lxc.internal.e.c.b.f;
        Integer r12 = r20.b();
        com.bytedance.safetyguard.lxc.internal.e.c.g r2 = r20.j();
        if (r2 == null) goto L20;
        String r16 = r2.e();
    L21:
        com.bytedance.safetyguard.lxc.internal.e.c.g r3 = r20.j();
        if (r3 == null) goto L24;
        String r17 = r3.f();
    L26:
        return com.bytedance.safetyguard.lxc.internal.e.c.c.a(r20, r1, null, 0, 0, 0, null, null, null, null, new com.bytedance.safetyguard.lxc.internal.e.c.g(r12, null, "malformed_response", "OAuth response was malformed", r16, r17), 510, null);
    L24:
        r17 = null;
        goto L26
    L20:
        r16 = null;
        goto L21
    L8:
        if (new d.l.j(200, 299).a(r20.b().intValue()) == false) goto L12;
        if (a(r22) == false) goto L12;
        r0 = true;
        goto L14
    }

    private final boolean a(byte[] r4) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        Charset r1 = StandardCharsets.UTF_8;     // Catch: Throwable -> L4
        d.h.b.o.c(r1, "UTF_8");     // Catch: Throwable -> L4
        Object r5 = d.n.f(new JSONObject(new String(r4, r1)));     // Catch: Throwable -> L4
    L7:
        if (d.n.b(r5) == false) goto L9;
        r5 = null;
    L9:
        JSONObject r6 = (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L12;
        return false;
    L12:
        JSONObject r2 = r6.optJSONObject("data");
        if (r2 == null) goto L17;
        Boolean r3 = d(r2);
        if (r3 == null) goto L17;
        return r3.booleanValue();
    L17:
        Boolean r7 = d(r6);
        if (r7 != null) goto L20;
        return false;
    L20:
        return r7.booleanValue();
    L4:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L7
    }

    private final Boolean d(JSONObject r8) {
        String[] r7 = {MonitorConstants.CODE, "error_code"};
        boolean r0 = false;
        int r1 = 0;
    L4:
        if (r1 >= 2) goto L37;
        String r2 = r7[r1];
        if (r8.has(r2) == false) goto L36;
        if (r8.isNull(r2) == true) goto L36;
        Object r9 = r8.opt(r2);
        if (ZeusTransformUtils.instanceOf(r9, Number.class) == false) goto L30;
        double r10 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).doubleValue();
        if (Double.isInfinite(r10) == false) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == false) goto L35;
        if ((r10 % 1.0d) != 0.0d) goto L22;
        boolean r4 = true;
    L23:
        if (r4 == false) goto L35;
        if (r10 < (-2.147483648E9d)) goto L35;
        if (r10 > 2.147483647E9d) goto L35;
    L28:
        r0 = true;
        goto L35
    L22:
        r4 = false;
    L35:
        return Boolean.valueOf(!r0);
    L15:
        if (Double.isNaN(r10) == true) goto L17;
        r3 = true;
        goto L18
    L30:
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L35;
        d.h.b.o.a(r9);
        if (d.o.o.d(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString()) == null) goto L35;
    L36:
        r1 = r1 + 1;
        goto L4
    L37:
        return null;
    }

    private final boolean a(String r1) {
        if (d.h.b.o.a(r1, "app-registration-begin") == false) goto L5;
    L8:
        return true;
    L5:
        if (d.h.b.o.a(r1, "app-registration-poll") == true) goto L8;
        return false;
    }

    private final String a(SidecarBrand r2, String r3) {
        return r2.getOpenBaseUrl() + "/page/cli?user_code=" + c(r3);
    }

    static /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.c.a a(x r12, String r13, String r14, URL r15, SidecarBrand r16, String r17, String r18, Integer r19, boolean r20, int r21, Object r22) {
        if ((r21 & 16) == 0) goto L5;
        String r8 = null;
    L7:
        if ((r21 & 32) == 0) goto L9;
        String r9 = null;
    L11:
        if ((r21 & 64) == 0) goto L13;
        Integer r10 = null;
    L15:
        if ((r21 & 128) == 0) goto L17;
        boolean r11 = false;
    L19:
        return r12.a(r13, r14, r15, r16, r8, r9, r10, r11);
    L17:
        r11 = r20;
        goto L19
    L13:
        r10 = r19;
        goto L15
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }

    private final com.bytedance.safetyguard.lxc.internal.e.c.a a(String r17, String r18, URL r19, SidecarBrand r20, String r21, String r22, Integer r23, boolean r24) {
        String r4 = r19.getHost();
        d.h.b.o.c(r4, "getHost(...)");
        return new com.bytedance.safetyguard.lxc.internal.e.c.a("oauth", r17, r18, r4, r19.getPath(), r20.name(), r21, r22, null, null, r23, r24, 768, null);
    }

    private final SidecarBrand b(String r5) {
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(SidecarBrand.getEntries(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (d.o.o.a(new URL(((SidecarBrand) ZeusTransformUtils.preCheckCast(r0, SidecarBrand.class, "com.obric.aiagent.plugin")).getAccountsBaseUrl()).getHost(), r5, true) == false) goto L4;
    L10:
        return (SidecarBrand) ZeusTransformUtils.preCheckCast(r0, SidecarBrand.class, "com.obric.aiagent.plugin");
    L8:
        r0 = null;
        goto L10
    }

    private final String c(String r1) {
        String r0 = URLEncoder.encode(r1, "UTF-8");
        d.h.b.o.c(r0, "encode(...)");
        return r0;
    }

    private final int a(int r5, Long r6) {
        if (r6 != null) goto L4;
        return r5;
    L4:
        return (int) d.l.n.b(d.l.n.a(r6.longValue(), 1), r5);
    }

    private final long a(long r3) {
        return d.l.n.a(((Number) ZeusTransformUtils.preCheckCast(this.f10419e.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - r3, 0);
    }

    static {
        f10415a = new a(null);
        p = new d.o.k("[A-Za-z0-9:_\\-.]+");
        q = new d.o.k("[A-Za-z0-9_.$]+");
        r = new d.o.k("[A-Za-z0-9._:-]{1,128}");
    }
}
