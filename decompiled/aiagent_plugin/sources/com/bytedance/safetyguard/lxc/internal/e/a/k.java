package com.bytedance.safetyguard.lxc.internal.e.a;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LarkDeviceTokenPollStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k implements com.bytedance.safetyguard.lxc.internal.e.a.a.h<e, d, v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10376a = null;
    private static final com.bytedance.safetyguard.lxc.internal.e.a.a.f h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SidecarBrand f10379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10380e;
    private final d.h.a.a<Long> f;
    private final d.h.a.s<String, Map<String, String>, String, Long, d.c.d<? super r>, Object> g;

    /* JADX INFO: compiled from: LarkDeviceTokenPollStrategy.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final d a(JSONObject r7, d.h.a.a<Long> r8, com.bytedance.safetyguard.lxc.internal.e.c.g r9) {
            d.h.a.a<Long> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r7, "root");
            d.h.b.o.e(r10, "nowMillis");
            JSONObject r0 = r7.optJSONObject("data");
            if (r0 != null) goto L5;
            r0 = r7;
        L5:
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r0.optString("error_description"), CharSequence.class, "com.obric.aiagent.plugin");
            if (d.o.o.d(r2) == false) goto L8;
            r2 = r0.optString("msg");
        L8:
            CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
            if (d.o.o.d(r3) == false) goto L11;
            r3 = r7.optString("msg");
        L11:
            String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
            d.h.b.o.a(r4);
            v r5 = null;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L15;
            r3 = null;
        L15:
            String r6 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
            String r11 = r0.optString(WsConstants.KEY_CONNECTION_ERROR, r7.optString(WsConstants.KEY_CONNECTION_ERROR));
            d.h.b.o.a(r11);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L19;
            r11 = null;
        L19:
            if (r9 == null) goto L21;
            r6 = r9.d();
        L21:
            String r12 = r0.optString("access_token");
            d.h.b.o.c(r12, "optString(...)");
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L25;
            r5 = a(r0, r10);
        L25:
            return new d(r11, r6, r5, r9);
        }

        public final v a(JSONObject r23, d.h.a.a<Long> r24) {
            d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r23, "data");
            d.h.b.o.e(r1, "nowMillis");
            String r3 = r23.optString("access_token");
            d.h.b.o.a(r3);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L5;
            String r10 = r3;
        L6:
            if (r10 == null) goto L46;
            String r4 = r23.optString("refresh_token");
            d.h.b.o.a(r4);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L11;
            r4 = null;
        L11:
            if (r4 != null) goto L13;
            r4 = "";
        L13:
            String r11 = r4;
            long r5 = ((Number) ZeusTransformUtils.preCheckCast(r1.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
            long r12 = r23.optLong("expires_in", 0);
            long r14 = r23.optLong("refresh_expires_in", 0);
            String r2 = r23.optString("open_id");
            d.h.b.o.c(r2, "optString(...)");
            String r6 = r23.optString("name");
            d.h.b.o.a(r6);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L17;
            r6 = null;
        L17:
            if (r6 != null) goto L22;
            r6 = r23.optString("en_name");
            d.h.b.o.a(r6);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L22;
            r6 = null;
        L22:
            long r7 = 0;
            if (r12 <= 0) goto L25;
            long r13 = (r12 * ((long) 1000)) + r5;
            r7 = 0;
        L27:
            if (r14 <= r7) goto L29;
            long r15 = r5 + (r14 * ((long) 1000));
        L30:
            String r0 = r23.optString("scope");
            d.h.b.o.c(r0, "optString(...)");
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{' '}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r16 = r8.iterator();
        L32:
            if (r16.hasNext() == false) goto L34;
            r9.add(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString());
            goto L32
        L34:
            Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r19 = r17.iterator();
        L36:
            if (r19.hasNext() == false) goto L44;
            Object r20 = r19.next();
            if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r20, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L40;
            boolean r21 = true;
        L41:
            if (r21 == false) goto L36;
            r18.add(r20);
            goto L36
        L40:
            r21 = false;
            goto L41
        L44:
            return new v(r2, r6, r10, r11, r13, r15, d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")));
        L29:
            r15 = 4611686018427387903L;
            goto L30
        L25:
            r13 = 4611686018427387903L;
            goto L27
        L46:
            throw new IllegalStateException("OAuth token endpoint did not return access_token");
        L5:
            r10 = null;
            goto L6
        }
    }

    /* JADX INFO: compiled from: LarkDeviceTokenPollStrategy.kt */
    @d.c.b.a.f(b = "LarkDeviceTokenPollStrategy.kt", c = {42}, d = "pollOnce", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.LarkDeviceTokenPollStrategy")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f10382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f10383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10384d;

        b(k r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10383c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            this.f10382b = r4;
            this.f10384d |= Integer.MIN_VALUE;
            return this.f10383c.a2(null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public k(String r3, String r4, SidecarBrand r5, String r6, d.h.a.a<Long> r7, d.h.a.s<? super String, ? super Map<String, String>, ? super String, ? super Long, ? super d.c.d<? super r>, ? extends Object> r8) {
        d.h.a.a<Long> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.s<String, Map<String, String>, String, Long, d.c.d<? super r>, Object> r10 = (d.h.a.s) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.s.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "appId");
        d.h.b.o.e(r4, "appSecret");
        d.h.b.o.e(r5, PlatformConst.BUNDLE_KEY_BRAND);
        d.h.b.o.e(r6, "deviceCode");
        d.h.b.o.e(r9, "nowMillis");
        d.h.b.o.e(r10, "postForm");
        this.f10377b = r3;
        this.f10378c = r4;
        this.f10379d = r5;
        this.f10380e = r6;
        this.f = r9;
        this.g = r10;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.a.h
    public /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.a.e<e, v> a(e r3, d r4) {
        return a2((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.a.h
    public /* synthetic */ Object a(e r3, long r4, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.a.c<? extends d>> r6) {
        d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.a.c<d>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a2((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public Object a2(e r9, long r10, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.a.c<d>> r12) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, b.class) == false) goto L7;
        b r13 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.aiagent.plugin");
        if ((r13.f10384d & Integer.MIN_VALUE) == 0) goto L7;
        r13.f10384d -= Integer.MIN_VALUE;
    L8:
        b r6 = r13;
        Object r14 = r6.f10382b;
        Object r15 = d.c.a.b.a();
        int r1 = r6.f10384d;
        if (r1 == 0) goto L16;
        if (r1 != 1) goto L15;
        k this = (k) ZeusTransformUtils.preCheckCast(r6.f10381a, k.class, "com.obric.aiagent.plugin");
        d.o.a(r14);     // Catch: JSONException -> L22 IOException -> L24 m -> L26
    L20:
        r r16 = (r) ZeusTransformUtils.preCheckCast(r14, r.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L22 IOException -> L24 m -> L26
    L40:
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.c) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.c.b(f10376a.a(new JSONObject(r16.b()), this.f, r16.a().j())), com.bytedance.safetyguard.lxc.internal.e.a.a.c.class, "com.obric.aiagent.plugin");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r14);
        d.h.a.s<String, Map<String, String>, String, Long, d.c.d<? super r>, Object> r2 = this.g;     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        String r17 = this.f10379d.getOpenBaseUrl() + "/open-apis/authen/v2/oauth/token";     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        LinkedHashMap r3 = ao.d(new d.m[]{d.s.a("grant_type", "urn:ietf:params:oauth:grant-type:device_code"), d.s.a(SensitiveType.DEVICE_CODE, this.f10380e), d.s.a("client_id", this.f10377b), d.s.a("client_secret", this.f10378c)});     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        Long r5 = d.c.b.a.b.a(r10);     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        r6.f10381a = this;     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        r6.f10384d = 1;     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        r14 = r2.a(r17, r3, "device-token-poll", r5, r6);     // Catch: JSONException -> L22 IOException -> L24 m -> L26
        if (r14 != r15) goto L20;
        return r15;
    L26:
        e = move-exception;
        if (d.h.b.o.a(e.a(), "network_error") == true) goto L34;
        if (d.h.b.o.a(e.a(), "malformed_response") == true) goto L34;
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.c) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.c.a(e), com.bytedance.safetyguard.lxc.internal.e.a.a.c.class, "com.obric.aiagent.plugin");
    L34:
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.c) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.c.C0234c((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), com.bytedance.safetyguard.lxc.internal.e.a.a.c.class, "com.obric.aiagent.plugin");
    L24:
        e = move-exception;
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.c) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.c.C0234c((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), com.bytedance.safetyguard.lxc.internal.e.a.a.c.class, "com.obric.aiagent.plugin");
    L22:
        e = move-exception;
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.c) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.c.C0234c((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), com.bytedance.safetyguard.lxc.internal.e.a.a.c.class, "com.obric.aiagent.plugin");
    L7:
        r13 = new b(this, r11);
        goto L8
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bytedance.safetyguard.lxc.internal.e.a.a.e<e, v> a2(e r9, d r10) {
        d.h.b.o.e(r9, "state");
        d.h.b.o.e(r10, "payload");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.a(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
        v r12 = r10.c();
        if (r12 == null) goto L17;
        return (com.bytedance.safetyguard.lxc.internal.e.a.a.e) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.a.a.e.a(r12), com.bytedance.safetyguard.lxc.internal.e.a.a.e.class, "com.obric.aiagent.plugin");
    L17:
        return com.bytedance.safetyguard.lxc.internal.e.a.a.j.a(r10.a(), r10.b(), r9, h, "device-token-poll", r10.d());
    L11:
        return com.bytedance.safetyguard.lxc.internal.e.a.a.j.a(r10.a(), r10.b(), r9, h, "device-token-poll", r10.d());
    L5:
        if (d.o.o.d(r8) == true) goto L8;
        r11 = false;
        goto L9
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.a.h
    public m a() {
        return new m("timeout", h.c(), "device-token-poll", null, null, 24, null);
    }

    static {
        f10376a = new a(null);
        h = new com.bytedance.safetyguard.lxc.internal.e.a.a.f("Authorization denied by user", "Device code expired, please try again", "Authorization timed out, please try again");
    }
}
