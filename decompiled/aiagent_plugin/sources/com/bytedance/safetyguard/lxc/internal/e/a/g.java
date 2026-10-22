package com.bytedance.safetyguard.lxc.internal.e.a;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LarkAppRegistrationPollStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g implements com.bytedance.safetyguard.lxc.internal.e.a.a.h<c, com.bytedance.safetyguard.lxc.internal.e.a.b, i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10352a = null;
    private static final com.bytedance.safetyguard.lxc.internal.e.a.a.f i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.s<String, Map<String, String>, String, Long, d.c.d<? super r>, Object> f10354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h.a f10355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h.b f10356e;
    private final h.e f;
    private int g;
    private m h;

    /* JADX INFO: compiled from: LarkAppRegistrationPollStrategy.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final com.bytedance.safetyguard.lxc.internal.e.a.b a(JSONObject r16, com.bytedance.safetyguard.lxc.internal.e.c.g r17) {
            d.h.b.o.e(r16, "root");
            h.d r1 = h.d.f10365a;
            JSONObject r2 = r16.optJSONObject("data");
            if (r2 != null) goto L5;
            r2 = r16;
        L5:
            CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.optString("client_id"), CharSequence.class, "com.obric.aiagent.plugin");
            if (d.o.o.d(r3) == false) goto L8;
            r3 = r2.optString("app_id");
        L8:
            String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
            CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.optString("client_secret"), CharSequence.class, "com.obric.aiagent.plugin");
            if (d.o.o.d(r5) == false) goto L11;
            r5 = r2.optString("app_secret");
        L11:
            String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
            JSONObject r7 = r2.optJSONObject("user_info");
            CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.optString("error_description"), CharSequence.class, "com.obric.aiagent.plugin");
            if (d.o.o.d(r8) == false) goto L14;
            r8 = r2.optString("msg");
        L14:
            CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
            if (d.o.o.d(r9) == false) goto L17;
            r9 = r16.optString("msg");
        L17:
            String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
            d.h.b.o.a(r10);
            String r11 = null;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L21;
            r9 = null;
        L21:
            String r12 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
            String r0 = r2.optString(WsConstants.KEY_CONNECTION_ERROR, r16.optString(WsConstants.KEY_CONNECTION_ERROR));
            d.h.b.o.a(r0);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L24;
            String r13 = r0;
        L25:
            if (r17 == null) goto L27;
            r12 = r17.d();
        L27:
            String r14 = r12;
            if (r7 == null) goto L37;
            String r15 = r7.optString("tenant_brand");
            if (r15 == null) goto L37;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L35;
            r15 = null;
        L35:
            if (r15 == null) goto L37;
            SidecarBrand r18 = a(r15);
        L38:
            d.h.b.o.a(r4);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L49;
            d.h.b.o.a(r6);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L49;
            if (r7 == null) goto L48;
            String r19 = r7.optString("open_id");
            if (r19 == null) goto L48;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L48;
            r11 = r19;
        L48:
            com.bytedance.safetyguard.lxc.internal.e.a.a r110 = new com.bytedance.safetyguard.lxc.internal.e.a.a(r4, r6, r11);
        L51:
            return new com.bytedance.safetyguard.lxc.internal.e.a.b(r13, r14, r18, r110, r17);
        L49:
            r110 = null;
        L37:
            r18 = null;
            goto L38
        L24:
            r13 = null;
            goto L25
        }

        private final SidecarBrand a(String r9) {
            if (d.o.o.a(r9, "lark", true) == true) goto L13;
            if (d.o.o.a(r9, "larksuite", true) == true) goto L13;
            if (d.o.o.a(r9, "feishu", true) == false) goto L11;
            return SidecarBrand.FEISHU;
        L11:
            throw new m("app_registration_unknown_tenant_brand", "app registration returned unsupported tenant_brand", null, null, null, 28, null);
        L13:
            return SidecarBrand.LARKSUITE;
        }

        public final m a() {
            return new m("app_registration_brand_mismatch", "app registration tenant_brand does not match credential issuer brand", null, null, null, 28, null);
        }
    }

    /* JADX INFO: compiled from: LarkAppRegistrationPollStrategy.kt */
    @d.c.b.a.f(b = "LarkAppRegistrationPollStrategy.kt", c = {59}, d = "pollOnce", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.LarkAppRegistrationPollStrategy")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f10358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f10359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10360d;

        b(g r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10359c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            this.f10358b = r4;
            this.f10360d |= Integer.MIN_VALUE;
            return this.f10359c.a2(null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public g(String r3, d.h.a.s<? super String, ? super Map<String, String>, ? super String, ? super Long, ? super d.c.d<? super r>, ? extends Object> r4) {
        d.h.a.s<String, Map<String, String>, String, Long, d.c.d<? super r>, Object> r5 = (d.h.a.s) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.s.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "deviceCode");
        d.h.b.o.e(r5, "postForm");
        this.f10353b = r3;
        this.f10354c = r5;
        this.f10355d = h.a.f10362a;
        this.f10356e = h.b.f10363a;
        this.f = h.e.f10366a;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.a.h
    public /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.a.e<c, i> a(c r3, com.bytedance.safetyguard.lxc.internal.e.a.b r4) {
        return a2((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"), (com.bytedance.safetyguard.lxc.internal.e.a.b) ZeusTransformUtils.preCheckCast(r4, com.bytedance.safetyguard.lxc.internal.e.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.a.h
    public /* synthetic */ Object a(c r3, long r4, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.a.c<? extends com.bytedance.safetyguard.lxc.internal.e.a.b>> r6) {
        d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.a.c<com.bytedance.safetyguard.lxc.internal.e.a.b>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a2((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public Object a2(c r10, long r11, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.a.c<com.bytedance.safetyguard.lxc.internal.e.a.b>> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.aiagent.plugin");
        if ((r0.f10360d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10360d -= Integer.MIN_VALUE;
    L8:
        b r7 = r0;
        Object r15 = r7.f10358b;
        Object r1 = d.c.a.b.a();
        int r2 = r7.f10360d;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        g this = (g) ZeusTransformUtils.preCheckCast(r7.f10357a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r15);     // Catch: JSONException -> L22 IOException -> L24 m -> L26
    L20:
        r r12 = (r) ZeusTransformUtils.preCheckCast(r15, r.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        com.bytedance.safetyguard.lxc.internal.e.a.b r16 = f10352a.a(new JSONObject(r12.b()), r12.a().j());     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        this.g = 0;     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        this.h = null;     // Catch: JSONException -> L22 IOException -> L24 m -> L26
    L51:
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.c) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.c.b(r16), com.bytedance.safetyguard.lxc.internal.e.a.a.c.class, "com.obric.aiagent.plugin");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r15);
        d.h.a.s<String, Map<String, String>, String, Long, d.c.d<? super r>, Object> r3 = this.f10354c;     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        String r17 = r10.a().getAccountsBaseUrl() + "/oauth/v1/app/registration";     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        LinkedHashMap r4 = ao.d(new d.m[]{d.s.a("action", "poll"), d.s.a(SensitiveType.DEVICE_CODE, this.f10353b)});     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        Long r6 = d.c.b.a.b.a(r11);     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        r7.f10357a = this;     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        r7.f10360d = 1;     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        r15 = r3.a(r17, r4, "app-registration-poll", r6, r7);     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        if (r15 != r1) goto L20;
        return r1;
    L26:
        e = move-exception;
        String r18 = e.a();
        int r19 = r18.hashCode();
        if (r19 == (-1046606779)) goto L42;
        if (r19 == (-617237321)) goto L38;
        if (r19 == (-294502320)) goto L35;
    L43:
        com.bytedance.safetyguard.lxc.internal.e.a.a.c<com.bytedance.safetyguard.lxc.internal.e.a.b> r9 = (com.bytedance.safetyguard.lxc.internal.e.a.a.c) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.c.a(e), com.bytedance.safetyguard.lxc.internal.e.a.a.c.class, "com.obric.aiagent.plugin");
    L50:
        return r9;
    L35:
        if (r18.equals("network_timeout") == false) goto L43;
    L40:
        this.h = e;
        r9 = (com.bytedance.safetyguard.lxc.internal.e.a.a.c) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.c.C0234c((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), com.bytedance.safetyguard.lxc.internal.e.a.a.c.class, "com.obric.aiagent.plugin");
        goto L50
    L38:
        if (r18.equals("network_error") == true) goto L40;
    L42:
        if (r18.equals("malformed_response") == false) goto L43;
        r9 = this.a(e);
    L24:
        e = move-exception;
        m r110 = this.a(e);
        this.h = r110;
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.c) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.c.C0234c((Throwable) ZeusTransformUtils.preCheckCast(r110, Throwable.class, "com.obric.aiagent.plugin")), com.bytedance.safetyguard.lxc.internal.e.a.a.c.class, "com.obric.aiagent.plugin");
    L22:
        e = move-exception;
        return this.a(this.a(e));
    L7:
        r0 = new b(this, r14);
        goto L8
    }

    private final com.bytedance.safetyguard.lxc.internal.e.a.a.c<com.bytedance.safetyguard.lxc.internal.e.a.b> a(m r3) {
        int r0 = this.g + 1;
        this.g = r0;
        this.h = r3;
        if (r0 < 3) goto L6;
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.c) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.c.a(r3), com.bytedance.safetyguard.lxc.internal.e.a.a.c.class, "com.obric.aiagent.plugin");
    L6:
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.c) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.c.C0234c((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin")), com.bytedance.safetyguard.lxc.internal.e.a.a.c.class, "com.obric.aiagent.plugin");
    }

    private final m a(IOException r11) {
        boolean r10 = ZeusTransformUtils.instanceOf(r11, SocketTimeoutException.class);
        if (r10 == false) goto L5;
        String r0 = "network_timeout";
    L6:
        if (r10 == false) goto L8;
        String r12 = "OAuth request timed out";
    L9:
        String r2 = r0;
        String r3 = r12;
        return new m(r2, r3, "app-registration-poll", new com.bytedance.safetyguard.lxc.internal.e.c.g(null, null, r0, r12, null, null), (Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.aiagent.plugin"));
    L8:
        r12 = "OAuth request failed due to a network error";
        goto L9
    L5:
        r0 = "network_error";
        goto L6
    }

    private final m a(JSONException r9) {
        return new m("malformed_response", "OAuth response was malformed", "app-registration-poll", new com.bytedance.safetyguard.lxc.internal.e.c.g(null, null, "malformed_response", "OAuth response was malformed", null, null), (Throwable) ZeusTransformUtils.preCheckCast(r9, Throwable.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bytedance.safetyguard.lxc.internal.e.a.a.e<c, i> a2(c r9, com.bytedance.safetyguard.lxc.internal.e.a.b r10) {
        d.h.b.o.e(r9, "state");
        d.h.b.o.e(r10, "payload");
        SidecarBrand r8 = r10.c();
        boolean r0 = true;
        if (r8 != null) goto L5;
    L14:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.a(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L17;
    L20:
        if (r0 == false) goto L22;
        com.bytedance.safetyguard.lxc.internal.e.a.a r12 = r10.d();
        if (r12 == null) goto L28;
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.e) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.e.a(new i(r12.a(), r12.b(), r12.c(), r9.a())), com.bytedance.safetyguard.lxc.internal.e.a.a.e.class, "com.obric.aiagent.plugin");
    L28:
        return com.bytedance.safetyguard.lxc.internal.e.a.a.j.a(r10.a(), r10.b(), r9, i, "app-registration-poll", r10.e());
    L22:
        return com.bytedance.safetyguard.lxc.internal.e.a.a.j.a(r10.a(), r10.b(), r9, i, "app-registration-poll", r10.e());
    L17:
        if (d.o.o.d(r11) == true) goto L20;
        r0 = false;
        goto L20
    L5:
        if (r8 == r9.a()) goto L14;
        if (r9.b() == true) goto L11;
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.e) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.e.b(r9.a(r8, true), com.bytedance.safetyguard.lxc.internal.e.a.a.b.f10302b), com.bytedance.safetyguard.lxc.internal.e.a.a.e.class, "com.obric.aiagent.plugin");
    L11:
        if (r10.d() == null) goto L14;
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.e) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.e.c(f10352a.a()), com.bytedance.safetyguard.lxc.internal.e.a.a.e.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.a.h
    public m a() {
        m r8 = this.h;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return new m("timeout", i.c(), "app-registration-poll", null, null, 24, null);
    }

    static {
        f10352a = new a(null);
        i = new com.bytedance.safetyguard.lxc.internal.e.a.a.f("app registration denied by user", "device code expired, please try again", "app registration timed out, please try again");
    }
}
