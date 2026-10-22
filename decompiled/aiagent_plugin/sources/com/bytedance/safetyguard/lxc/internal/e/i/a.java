package com.bytedance.safetyguard.lxc.internal.e.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import d.a.p;
import d.c.b.a.l;
import d.h.b.o;
import d.l.n;
import d.m;
import d.s;
import d.x;
import java.security.Key;
import java.security.KeyStore;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AndroidKeystoreCredentialStore.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a implements com.bytedance.safetyguard.lxc.internal.e.i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0246a f10873a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f10875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedPreferences f10876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f10877e;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AndroidKeystoreCredentialStore.kt */
    private static final class C0246a {
        public /* synthetic */ C0246a(d.h.b.h r1) {
            this();
        }

        private C0246a() {
        }
    }

    /* JADX INFO: compiled from: AndroidKeystoreCredentialStore.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f10878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f10879b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f10878a, r6.f10878a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f10879b, r6.f10879b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f10878a) * 31) + Arrays.hashCode(this.f10879b);
        }

        public String toString() {
            return "EncryptedPayload(iv=" + Arrays.toString(this.f10878a) + ", payload=" + Arrays.toString(this.f10879b) + ')';
        }

        public b(byte[] r2, byte[] r3) {
            o.e(r2, "iv");
            o.e(r3, "payload");
            this.f10878a = r2;
            this.f10879b = r3;
        }

        public final byte[] a() {
            return this.f10878a;
        }

        public final byte[] b() {
            return this.f10879b;
        }
    }

    /* JADX INFO: compiled from: AndroidKeystoreCredentialStore.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0247a f10880a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bytedance.safetyguard.lxc.internal.e.i.c f10881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LinkedHashMap<m<String, String>, com.bytedance.safetyguard.lxc.internal.e.i.d> f10882c;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.i.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AndroidKeystoreCredentialStore.kt */
        public static final class C0247a {
            public /* synthetic */ C0247a(d.h.b.h r1) {
                this();
            }

            private C0247a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final c a(JSONObject r22) {
                o.e(r22, "root");
                JSONObject r1 = r22.optJSONObject("app");
                if (r1 == null) goto L6;
                com.bytedance.safetyguard.lxc.internal.e.i.c r2 = c(r1);
                if (r2 == null) goto L6;
            L7:
                String r4 = null;
                c r3 = new c(r2, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
                JSONArray r0 = r22.optJSONArray("tokens");
                if (r0 != null) goto L10;
                r0 = new JSONArray();
            L10:
                int r5 = r0.length();
                int r6 = 0;
            L11:
                if (r6 >= r5) goto L29;
                JSONObject r7 = r0.getJSONObject(r6);
                JSONArray r8 = r7.optJSONArray("scopes");
                if (r8 != null) goto L15;
                r8 = new JSONArray();
            L15:
                String r11 = r7.getString("appId");
                o.c(r11, "getString(...)");
                String r12 = r7.getString("openId");
                o.c(r12, "getString(...)");
                String r10 = r7.optString("name");
                o.a(r10);
                if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L18;
                String r13 = r10;
            L19:
                String r14 = r7.getString("accessToken");
                o.c(r14, "getString(...)");
                String r15 = r7.getString("refreshToken");
                o.c(r15, "getString(...)");
                long r16 = r7.getLong("accessTokenExpiresAtMillis");
                long r18 = r7.getLong("refreshTokenExpiresAtMillis");
                Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(n.b(0, r8.length()), Iterable.class, "com.obric.aiagent.plugin");
                Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
                Iterator r19 = r9.iterator();
            L21:
                if (r19.hasNext() == false) goto L23;
                r17.add(r8.getString(((al) ZeusTransformUtils.preCheckCast(r19, al.class, "com.obric.aiagent.plugin")).a()));
                goto L21
            L23:
                com.bytedance.safetyguard.lxc.internal.e.i.d r20 = new com.bytedance.safetyguard.lxc.internal.e.i.d(r11, r12, r13, r14, r15, r16, r18, p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")));
                if (r2 != null) goto L26;
            L27:
                ((Map) ZeusTransformUtils.preCheckCast(r3.b(), Map.class, "com.obric.aiagent.plugin")).put(s.a(r20.a(), r20.b()), r20);
            L28:
                r6 = r6 + 1;
                r4 = null;
                goto L11
            L26:
                if (o.a(r20.a(), r2.a()) == false) goto L28;
            L18:
                r13 = r4;
                goto L19
            L29:
                return r3;
            L6:
                r2 = b(r22);
                goto L7
            }

            private final com.bytedance.safetyguard.lxc.internal.e.i.c b(JSONObject r8) {
                JSONArray r7 = r8.optJSONArray("apps");
                Object r0 = null;
                if (r7 != null) goto L6;
                return null;
            L6:
                if (r7.length() != 0) goto L8;
                return null;
            L8:
                String r9 = r8.optString("currentAppId");
                o.a(r9);
                if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L12;
                r9 = null;
            L12:
                Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(n.b(0, r7.length()), Iterable.class, "com.obric.aiagent.plugin");
                Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
                Iterator r2 = r1.iterator();
            L14:
                if (r2.hasNext() == false) goto L16;
                int r4 = ((al) ZeusTransformUtils.preCheckCast(r2, al.class, "com.obric.aiagent.plugin")).a();
                C0247a r5 = c.f10880a;
                JSONObject r6 = r7.getJSONObject(r4);
                o.c(r6, "getJSONObject(...)");
                r3.add(r5.c(r6));
                goto L14
            L16:
                List r10 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
                if (r9 == null) goto L26;
                Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            L20:
                if (r11.hasNext() == false) goto L24;
                Object r12 = r11.next();
                if (o.a(((com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r12, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin")).a(), r9) == false) goto L20;
                r0 = r12;
            L24:
                com.bytedance.safetyguard.lxc.internal.e.i.c r13 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r0, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
                if (r13 == null) goto L26;
            L28:
                return r13;
            L26:
                r13 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(p.p(r10), com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
                if (r13 != null) goto L28;
                throw new IllegalStateException("Legacy credential store contains multiple apps without a current app");
            }

            private final com.bytedance.safetyguard.lxc.internal.e.i.c c(JSONObject r7) {
                String r1 = r7.getString("appId");
                o.c(r1, "getString(...)");
                String r2 = r7.getString("appSecret");
                o.c(r2, "getString(...)");
                String r0 = r7.getString(PlatformConst.BUNDLE_KEY_BRAND);
                o.c(r0, "getString(...)");
                SidecarBrand r3 = SidecarBrand.valueOf(r0);
                String r6 = r7.optString("currentUserOpenId");
                o.a(r6);
                String r5 = null;
                if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
                r6 = null;
            L6:
                String r8 = r7.optString("currentUserName");
                o.a(r8);
                if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L10;
                r5 = r8;
            L10:
                return new com.bytedance.safetyguard.lxc.internal.e.i.c(r1, r2, r3, r6, r5);
            }
        }

        static {
            f10880a = new C0247a(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f10881b, r6.f10881b) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f10882c, r6.f10882c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            com.bytedance.safetyguard.lxc.internal.e.i.c r0 = this.f10881b;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f10882c.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "VaultState(app=" + this.f10881b + ", tokens=" + this.f10882c + ')';
        }

        public c(com.bytedance.safetyguard.lxc.internal.e.i.c r2, LinkedHashMap<m<String, String>, com.bytedance.safetyguard.lxc.internal.e.i.d> r3) {
            o.e(r3, "tokens");
            this.f10881b = r2;
            this.f10882c = r3;
        }

        public final com.bytedance.safetyguard.lxc.internal.e.i.c a() {
            return this.f10881b;
        }

        public final void a(com.bytedance.safetyguard.lxc.internal.e.i.c r1) {
            this.f10881b = r1;
        }

        public /* synthetic */ c(com.bytedance.safetyguard.lxc.internal.e.i.c r1, LinkedHashMap r2, int r3, d.h.b.h r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = null;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = new LinkedHashMap();
        L8:
            this(r1, r2);
        }

        public final LinkedHashMap<m<String, String>, com.bytedance.safetyguard.lxc.internal.e.i.d> b() {
            return this.f10882c;
        }

        public final JSONObject c() {
            JSONObject r0 = new JSONObject();
            r0.put("schemaVersion", 2);
            com.bytedance.safetyguard.lxc.internal.e.i.c r1 = this.f10881b;
            if (r1 == null) goto L5;
            JSONObject r2 = b(r1);
        L6:
            r0.put("app", r2);
            Collection<com.bytedance.safetyguard.lxc.internal.e.i.d> r8 = this.f10882c.values();
            o.c(r8, "<get-values>(...)");
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r10 = r9.iterator();
        L8:
            if (r10.hasNext() == false) goto L10;
            com.bytedance.safetyguard.lxc.internal.e.i.d r4 = (com.bytedance.safetyguard.lxc.internal.e.i.d) ZeusTransformUtils.preCheckCast(r10.next(), com.bytedance.safetyguard.lxc.internal.e.i.d.class, "com.obric.aiagent.plugin");
            r3.add(new JSONObject().put("appId", r4.a()).put("openId", r4.b()).put("name", r4.c()).put("accessToken", r4.d()).put("refreshToken", r4.e()).put("accessTokenExpiresAtMillis", r4.f()).put("refreshTokenExpiresAtMillis", r4.g()).put("scopes", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(p.o((Iterable) ZeusTransformUtils.preCheckCast(r4.h(), Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin"))));
            goto L8
        L10:
            r0.put("tokens", new JSONArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
            return r0;
        L5:
            r2 = null;
            goto L6
        }

        private final JSONObject b(com.bytedance.safetyguard.lxc.internal.e.i.c r3) {
            return new JSONObject().put("appId", r3.a()).put("appSecret", r3.b()).put(PlatformConst.BUNDLE_KEY_BRAND, r3.c().name()).put("currentUserOpenId", r3.d()).put("currentUserName", r3.e());
        }
    }

    /* JADX INFO: compiled from: AndroidKeystoreCredentialStore.kt */
    @d.c.b.a.f(b = "AndroidKeystoreCredentialStore.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.vault.AndroidKeystoreCredentialStore$deleteApp$2")
    static final class d extends l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f10884b;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10884b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f10884b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f10883a != 0) goto L21;
            d.o.a(r6);
            Object r7 = a.a(this.f10884b);
            a r5 = this.f10884b;
            monitor-enter(r7);
            c r0 = a.b(r5);     // Catch: Throwable -> L17
            boolean r2 = true;
            if (r0.a() == null) goto L9;
            boolean r1 = true;
        L10:
            r0.a(null);     // Catch: Throwable -> L17
            r0.b().clear();     // Catch: Throwable -> L17
            a.a(r5, r0);     // Catch: Throwable -> L17
            if (r1 == true) goto L14;
            r2 = false;
        L14:
            Boolean r8 = d.c.b.a.b.a(r2);     // Catch: Throwable -> L17
            monitor-exit(r7);
            return r8;
        L9:
            r1 = false;
        L17:
            th = move-exception;
            throw th;
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AndroidKeystoreCredentialStore.kt */
    @d.c.b.a.f(b = "AndroidKeystoreCredentialStore.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.vault.AndroidKeystoreCredentialStore$deleteUserToken$2")
    static final class e extends l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f10886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10887c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f10888d;

        e(a r3, String r4, String r5, d.c.d<? super e> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10886b = r3;
            this.f10887c = r4;
            this.f10888d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f10886b, this.f10887c, this.f10888d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            d.c.a.b.a();
            if (this.f10885a != 0) goto L35;
            d.o.a(r18);
            Object r1 = a.a(this.f10886b);
            a r2 = this.f10886b;
            String r3 = this.f10887c;
            String r0 = this.f10888d;
            monitor-enter(r1);
            c r4 = a.b(r2);     // Catch: Throwable -> L31
            boolean r6 = true;
            if (r4.b().remove(s.a(r3, r0)) == null) goto L9;
            boolean r5 = true;
        L10:
            com.bytedance.safetyguard.lxc.internal.e.i.c r8 = r4.a();     // Catch: Throwable -> L31
            if (r8 != null) goto L13;
        L24:
            a.a(r2, r4);     // Catch: Throwable -> L31
            if (r5 == true) goto L28;
            r6 = false;
        L28:
            Boolean r7 = d.c.b.a.b.a(r6);     // Catch: Throwable -> L31
            monitor-exit(r1);
            return r7;
        L13:
            if (o.a(r8.a(), r3) == true) goto L15;
        L17:
            boolean r9 = false;
        L18:
            if (r9 == true) goto L21;
            r8 = null;
        L21:
            com.bytedance.safetyguard.lxc.internal.e.i.c r10 = r8;
            if (r10 == null) goto L24;
            r4.a(com.bytedance.safetyguard.lxc.internal.e.i.c.a(r10, null, null, null, null, null, 7, null));     // Catch: Throwable -> L31
            goto L24
        L15:
            if (o.a(r8.d(), r0) == false) goto L17;
            r9 = true;
            goto L18
        L9:
            r5 = false;
        L31:
            th = move-exception;
            throw th;
        L35:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AndroidKeystoreCredentialStore.kt */
    @d.c.b.a.f(b = "AndroidKeystoreCredentialStore.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.vault.AndroidKeystoreCredentialStore$getApp$2")
    static final class f extends l implements d.h.a.m<am, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.i.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f10890b;

        f(a r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10890b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.i.c> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f10890b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.i.c> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f10889a != 0) goto L13;
            d.o.a(r2);
            Object r3 = a.a(this.f10890b);
            a r1 = this.f10890b;
            monitor-enter(r3);
            com.bytedance.safetyguard.lxc.internal.e.i.c r4 = a.b(r1).a();     // Catch: Throwable -> L9
            monitor-exit(r3);
            return r4;
        L9:
            th = move-exception;
            throw th;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AndroidKeystoreCredentialStore.kt */
    @d.c.b.a.f(b = "AndroidKeystoreCredentialStore.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.vault.AndroidKeystoreCredentialStore$getUserToken$2")
    static final class g extends l implements d.h.a.m<am, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.i.d>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f10892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f10894d;

        g(a r3, String r4, String r5, d.c.d<? super g> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10892b = r3;
            this.f10893c = r4;
            this.f10894d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.i.d> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f10892b, this.f10893c, this.f10894d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.i.d> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f10891a != 0) goto L13;
            d.o.a(r3);
            Object r4 = a.a(this.f10892b);
            a r0 = this.f10892b;
            String r1 = this.f10893c;
            String r2 = this.f10894d;
            monitor-enter(r4);
            com.bytedance.safetyguard.lxc.internal.e.i.d r5 = (com.bytedance.safetyguard.lxc.internal.e.i.d) ZeusTransformUtils.preCheckCast(a.b(r0).b().get(s.a(r1, r2)), com.bytedance.safetyguard.lxc.internal.e.i.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            monitor-exit(r4);
            return r5;
        L9:
            th = move-exception;
            throw th;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AndroidKeystoreCredentialStore.kt */
    @d.c.b.a.f(b = "AndroidKeystoreCredentialStore.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.vault.AndroidKeystoreCredentialStore$saveApp$2")
    static final class h extends l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f10896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.i.c f10897c;

        h(a r3, com.bytedance.safetyguard.lxc.internal.e.i.c r4, d.c.d<? super h> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10896b = r3;
            this.f10897c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f10896b, this.f10897c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f10895a != 0) goto L21;
            d.o.a(r5);
            Object r6 = a.a(this.f10896b);
            a r0 = this.f10896b;
            com.bytedance.safetyguard.lxc.internal.e.i.c r4 = this.f10897c;
            monitor-enter(r6);
            c r1 = a.b(r0);     // Catch: Throwable -> L17
            com.bytedance.safetyguard.lxc.internal.e.i.c r2 = r1.a();     // Catch: Throwable -> L17
            if (r2 == null) goto L9;
            String r3 = r2.a();     // Catch: Throwable -> L17
        L11:
            if (o.a(r3, r4.a()) == true) goto L13;
            r1.b().clear();     // Catch: Throwable -> L17
        L13:
            r1.a(r4);     // Catch: Throwable -> L17
            a.a(r0, r1);     // Catch: Throwable -> L17
            x r7 = x.f38692a;     // Catch: Throwable -> L17
            monitor-exit(r6);
            return x.f38692a;
        L9:
            r3 = null;
        L17:
            th = move-exception;
            throw th;
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AndroidKeystoreCredentialStore.kt */
    @d.c.b.a.f(b = "AndroidKeystoreCredentialStore.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.vault.AndroidKeystoreCredentialStore$saveUserToken$2")
    static final class i extends l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f10899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.i.d f10900c;

        i(a r3, com.bytedance.safetyguard.lxc.internal.e.i.d r4, d.c.d<? super i> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10899b = r3;
            this.f10900c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f10899b, this.f10900c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            d.c.a.b.a();
            if (this.f10898a != 0) goto L22;
            d.o.a(r11);
            Object r12 = a.a(this.f10899b);
            a r0 = this.f10899b;
            com.bytedance.safetyguard.lxc.internal.e.i.d r10 = this.f10900c;
            monitor-enter(r12);
            c r1 = a.b(r0);     // Catch: Throwable -> L18
            com.bytedance.safetyguard.lxc.internal.e.i.c r2 = r1.a();     // Catch: Throwable -> L18
            if (r2 == null) goto L17;
            if (o.a(r2.a(), r10.a()) == false) goto L15;
            ((Map) ZeusTransformUtils.preCheckCast(r1.b(), Map.class, "com.obric.aiagent.plugin")).put(s.a(r10.a(), r10.b()), r10);     // Catch: Throwable -> L18
            r1.a(com.bytedance.safetyguard.lxc.internal.e.i.c.a(r2, null, null, null, r10.b(), r10.c(), 7, null));     // Catch: Throwable -> L18
            a.a(r0, r1);     // Catch: Throwable -> L18
            x r13 = x.f38692a;     // Catch: Throwable -> L18
            monitor-exit(r12);
            return x.f38692a;
        L15:
            throw new IllegalArgumentException("Token appId does not match the configured app".toString());     // Catch: Throwable -> L18
        L17:
            throw new IllegalStateException("Cannot save a user token before configuring an app".toString());     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f10873a = new C0246a(null);
    }

    public a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "alias");
        this.f10874b = r4;
        Context r6 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f10875c = r6;
        this.f10876d = r6.getSharedPreferences("safetyguard_sidecar_credentials", 0);
        this.f10877e = new Object();
    }

    public /* synthetic */ a(Context r2, String r3, int r4, d.h.b.h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = "safetyguard_lark_sidecar_credentials";
    L5:
        this(r6, r3);
    }

    public static final /* synthetic */ Object a(a r0) {
        return r0.f10877e;
    }

    public static final /* synthetic */ void a(a r0, c r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ c b(a r0) {
        return r0.a();
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.i.b
    public Object a(com.bytedance.safetyguard.lxc.internal.e.i.c r5, d.c.d<? super x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Object r4 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
        if (r4 != d.c.a.b.a()) goto L6;
        return r4;
    L6:
        return x.f38692a;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.i.b
    public Object a(d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.i.c> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.i.b
    public Object b(d.c.d<? super Boolean> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.i.b
    public Object a(com.bytedance.safetyguard.lxc.internal.e.i.d r5, d.c.d<? super x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Object r4 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
        if (r4 != d.c.a.b.a()) goto L6;
        return r4;
    L6:
        return x.f38692a;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.i.b
    public Object a(String r5, String r6, d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.i.d> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, r5, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r8);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.i.b
    public Object b(String r5, String r6, d.c.d<? super Boolean> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r5, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final c a() {
        com.bytedance.safetyguard.lxc.internal.e.i.c r2 = null;
        Object[] r3 = 0;
        Object[] r4 = 0;
        Object[] r5 = 0;
        Object[] r6 = 0;
        Object[] r7 = 0;
        String r0 = this.f10876d.getString("payload", null);
        int r1 = 3;
        if (r0 == null) goto L5;
        String r8 = this.f10876d.getString("iv", null);
        if (r8 == null) goto L9;
        byte[] r9 = Base64.getDecoder().decode(r8);
        o.c(r9, "decode(...)");
        byte[] r10 = Base64.getDecoder().decode(r0);
        o.c(r10, "decode(...)");
        String r11 = a(r9, r10);
        return c.f10880a.a(new JSONObject(r11));
    L9:
        return new c(r5 == true ? 1 : 0, r4 == true ? 1 : 0, r1, r3 == true ? 1 : 0);
    L5:
        return new c(r2, r7 == true ? 1 : 0, r1, r6 == true ? 1 : 0);
    }

    private final void a(c r3) {
        String r4 = r3.c().toString();
        o.c(r4, "toString(...)");
        b r5 = a(r4);
        this.f10876d.edit().putString("iv", Base64.getEncoder().encodeToString(r5.a())).putString("payload", Base64.getEncoder().encodeToString(r5.b())).apply();
    }

    private final b a(String r4) {
        Cipher r0 = Cipher.getInstance("AES/GCM/NoPadding");
        r0.init(1, (Key) ZeusTransformUtils.preCheckCast(b(), Key.class, "com.obric.aiagent.plugin"));
        byte[] r1 = r0.getIV();
        o.c(r1, "getIV(...)");
        byte[] r5 = r4.getBytes(d.o.d.f38623b);
        o.c(r5, "getBytes(...)");
        byte[] r6 = r0.doFinal(r5);
        o.c(r6, "doFinal(...)");
        return new b(r1, r6);
    }

    private final String a(byte[] r5, byte[] r6) {
        Cipher r0 = Cipher.getInstance("AES/GCM/NoPadding");
        r0.init(2, (Key) ZeusTransformUtils.preCheckCast(b(), Key.class, "com.obric.aiagent.plugin"), (AlgorithmParameterSpec) ZeusTransformUtils.preCheckCast(new GCMParameterSpec(128, r5), AlgorithmParameterSpec.class, "com.obric.aiagent.plugin"));
        byte[] r4 = r0.doFinal(r6);
        o.c(r4, "doFinal(...)");
        return new String(r4, d.o.d.f38623b);
    }

    private final SecretKey b() {
        KeyStore r1 = KeyStore.getInstance("AndroidKeyStore");
        SecretKey r2 = null;
        r1.load(null);
        Key r3 = r1.getKey(this.f10874b, null);
        if (ZeusTransformUtils.instanceOf(r3, SecretKey.class) == false) goto L5;
        r2 = (SecretKey) ZeusTransformUtils.preCheckCast(r3, SecretKey.class, "com.obric.aiagent.plugin");
    L5:
        if (r2 == null) goto L7;
        return r2;
    L7:
        KeyGenerator r0 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, "AndroidKeyStore");
        r0.init((AlgorithmParameterSpec) ZeusTransformUtils.preCheckCast(new KeyGenParameterSpec.Builder(this.f10874b, 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setRandomizedEncryptionRequired(true).build(), AlgorithmParameterSpec.class, "com.obric.aiagent.plugin"));
        SecretKey r5 = r0.generateKey();
        o.c(r5, "generateKey(...)");
        return r5;
    }
}
