package com.obric.aiagent.skill.credentials.api;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.Ext;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: LarkCLIIntentsAuthFlowManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l {
    private static final String TAG = "LarkCLIAuthFlowMgr";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f18971a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f18972b = null;

    /* JADX INFO: compiled from: LarkCLIIntentsAuthFlowManager.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f18973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final w<c> f18974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final w<x> f18975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicBoolean f18976d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f18973a, r6.f18973a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f18974b, r6.f18974b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f18975c, r6.f18975c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f18976d, r6.f18976d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f18973a.hashCode() * 31) + this.f18974b.hashCode()) * 31) + this.f18975c.hashCode()) * 31) + this.f18976d.hashCode();
        }

        public String toString() {
            return "AuthFlow(request=" + this.f18973a + ", result=" + this.f18974b + ", authFlowEntered=" + this.f18975c + ", takeoverNotified=" + this.f18976d + ')';
        }

        public a(b r3, w<c> r4, w<x> r5, AtomicBoolean r6) {
            w<c> r7 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
            w<x> r8 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, Ext.KEY_REQUEST);
            d.h.b.o.e(r7, "result");
            d.h.b.o.e(r8, "authFlowEntered");
            d.h.b.o.e(r6, "takeoverNotified");
            this.f18973a = r3;
            this.f18974b = r7;
            this.f18975c = r8;
            this.f18976d = r6;
        }

        public final b a() {
            return this.f18973a;
        }

        public final w<c> b() {
            return this.f18974b;
        }

        public /* synthetic */ a(b r2, w r3, w r4, AtomicBoolean r5, int r6, d.h.b.h r7) {
            w r8 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
            w r9 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
            if ((r6 & 4) == 0) goto L6;
            r9 = y.a(null, 1, null);
        L6:
            if ((r6 & 8) == 0) goto L8;
            r5 = new AtomicBoolean(false);
        L8:
            this(r2, r8, r9, r5);
        }

        public final w<x> c() {
            return this.f18975c;
        }

        public final AtomicBoolean d() {
            return this.f18976d;
        }
    }

    /* JADX INFO: compiled from: LarkCLIIntentsAuthFlowManager.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f18978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f18979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<String> f18980d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<String> f18981e;
        private final e f;
        private final String g;
        private final boolean h;

        public static /* synthetic */ b a(b r10, String r11, long r12, String r14, List r15, List r16, e r17, String r18, boolean r19, int r20, Object r21) {
            List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
            List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
            if ((r20 & 1) == 0) goto L5;
            String r4 = r10.f18977a;
        L7:
            if ((r20 & 2) == 0) goto L9;
            long r5 = r10.f18978b;
        L11:
            if ((r20 & 4) == 0) goto L13;
            String r7 = r10.f18979c;
        L15:
            if ((r20 & 8) == 0) goto L18;
            r2 = r10.f18980d;
        L18:
            if ((r20 & 16) == 0) goto L21;
            r3 = r10.f18981e;
        L21:
            if ((r20 & 32) == 0) goto L23;
            e r8 = r10.f;
        L25:
            if ((r20 & 64) == 0) goto L27;
            String r9 = r10.g;
        L29:
            if ((r20 & 128) == 0) goto L31;
            boolean r1 = r10.h;
        L33:
            return r10.a(r4, r5, r7, r2, r3, r8, r9, r1);
        L31:
            r1 = r19;
            goto L33
        L27:
            r9 = r18;
            goto L29
        L23:
            r8 = r17;
            goto L25
        L13:
            r7 = r14;
            goto L15
        L9:
            r5 = r12;
            goto L11
        L5:
            r4 = r11;
            goto L7
        }

        public final b a(String r13, long r14, String r16, List<String> r17, List<String> r18, e r19, String r20, boolean r21) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r13, "authSessionId");
            d.h.b.o.e(r16, "reason");
            d.h.b.o.e(r7, "requestedScopes");
            d.h.b.o.e(r8, "missingScopes");
            d.h.b.o.e(r19, "authType");
            d.h.b.o.e(r20, "authorizeReason");
            return new b(r13, r14, r16, r7, r8, r19, r20, r21);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f18977a, r10.f18977a) == true) goto L12;
            return false;
        L12:
            if (this.f18978b == r10.f18978b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f18979c, r10.f18979c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f18980d, r10.f18980d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f18981e, r10.f18981e) == true) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L27;
            return false;
        L27:
            if (d.h.b.o.a(this.g, r10.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r10.h) goto L32;
            return false;
        L32:
            return true;
        }

        public int hashCode() {
            return (((((((((((((this.f18977a.hashCode() * 31) + Long.hashCode(this.f18978b)) * 31) + this.f18979c.hashCode()) * 31) + this.f18980d.hashCode()) * 31) + this.f18981e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Boolean.hashCode(this.h);
        }

        public String toString() {
            return "AuthRequest(authSessionId=" + this.f18977a + ", questionId=" + this.f18978b + ", reason=" + this.f18979c + ", requestedScopes=" + this.f18980d + ", missingScopes=" + this.f18981e + ", authType=" + this.f + ", authorizeReason=" + this.g + ", requiresAppSetup=" + this.h + ')';
        }

        public b(String r3, long r4, String r6, List<String> r7, List<String> r8, e r9, String r10, boolean r11) {
            List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "authSessionId");
            d.h.b.o.e(r6, "reason");
            d.h.b.o.e(r12, "requestedScopes");
            d.h.b.o.e(r13, "missingScopes");
            d.h.b.o.e(r9, "authType");
            d.h.b.o.e(r10, "authorizeReason");
            this.f18977a = r3;
            this.f18978b = r4;
            this.f18979c = r6;
            this.f18980d = r12;
            this.f18981e = r13;
            this.f = r9;
            this.g = r10;
            this.h = r11;
        }

        public /* synthetic */ b(String r14, long r15, String r17, List r18, List r19, e r20, String r21, boolean r22, int r23, d.h.b.h r24) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
            if ((r23 & 1) == 0) goto L5;
            String r4 = "";
        L7:
            if ((r23 & 128) == 0) goto L9;
            boolean r12 = true;
        L10:
            this(r4, r15, r17, r8, r9, r20, r21, r12);
            return;
        L9:
            r12 = r22;
            goto L10
        L5:
            r4 = r14;
            goto L7
        }

        public final String a() {
            return this.f18977a;
        }

        public final String b() {
            return this.f18979c;
        }

        public final List<String> c() {
            return this.f18980d;
        }

        public final List<String> d() {
            return this.f18981e;
        }

        public final e e() {
            return this.f;
        }

        public final String f() {
            return this.g;
        }

        public final boolean g() {
            return this.h;
        }
    }

    /* JADX INFO: compiled from: LarkCLIIntentsAuthFlowManager.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f18982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f18984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f18985d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f18982a == r6.f18982a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f18983b, r6.f18983b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f18984c, r6.f18984c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f18985d, r6.f18985d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f18982a.hashCode() * 31) + this.f18983b.hashCode()) * 31;
            String r1 = this.f18984c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f18985d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "AuthResult(status=" + this.f18982a + ", message=" + this.f18983b + ", errorType=" + this.f18984c + ", errorSubtype=" + this.f18985d + ')';
        }

        public c(d r2, String r3, String r4, String r5) {
            d.h.b.o.e(r2, "status");
            d.h.b.o.e(r3, "message");
            this.f18982a = r2;
            this.f18983b = r3;
            this.f18984c = r4;
            this.f18985d = r5;
        }

        public /* synthetic */ c(d r2, String r3, String r4, String r5, int r6, d.h.b.h r7) {
            if ((r6 & 4) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 8) == 0) goto L8;
            r5 = null;
        L8:
            this(r2, r3, r4, r5);
        }

        public final d a() {
            return this.f18982a;
        }

        public final String b() {
            return this.f18983b;
        }

        public final String c() {
            return this.f18984c;
        }

        public final String d() {
            return this.f18985d;
        }
    }

    /* JADX INFO: compiled from: LarkCLIIntentsAuthFlowManager.kt */
    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f18986a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f18987b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f18988c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f18989d = null;
        private static final /* synthetic */ d[] f = null;
        private static final /* synthetic */ d.d.a g = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f18990e;

        private static final /* synthetic */ d[] b() {
            return new d[]{f18986a, f18987b, f18988c, f18989d};
        }

        private d(String r1, int r2, String r3) {
            super(r1, r2);
            this.f18990e = r3;
        }

        public final String a() {
            return this.f18990e;
        }

        static {
            f18986a = new d("COMPLETED", 0, "completed");
            f18987b = new d("CANCELED", 1, "canceled");
            f18988c = new d("FAILED", 2, "failed");
            f18989d = new d("EXPIRED", 3, "expired");
            d[] r0 = b();
            f = r0;
            g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f.clone(), d[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: LarkCLIIntentsAuthFlowManager.kt */
    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f18991a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f18992b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f18993c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ e[] f18994e = null;
        private static final /* synthetic */ d.d.a f = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f18995d;

        private static final /* synthetic */ e[] b() {
            return new e[]{f18991a, f18992b, f18993c};
        }

        private e(String r1, int r2, String r3) {
            super(r1, r2);
            this.f18995d = r3;
        }

        public final String a() {
            return this.f18995d;
        }

        static {
            f18991a = new e("NONE", 0, OProtocolTextEffectTextView.EffectNameNone);
            f18992b = new e("LOGIN_AND_CONSENT", 1, "login_and_consent");
            f18993c = new e("INCREMENTAL_CONSENT", 2, "incremental_consent");
            e[] r0 = b();
            f18994e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f18994e.clone(), e[].class, "com.obric.aiagent.plugin");
        }
    }

    private l() {
    }

    static {
        f18971a = new l();
        f18972b = new ConcurrentHashMap();
    }

    public final a a(b r30) {
        d.h.b.o.e(r30, Ext.KEY_REQUEST);
        a r0 = a();
        if (r0 != null) goto L5;
    L16:
        r0 = null;
    L18:
        if (r0 == null) goto L21;
        ILogDepend.Companion.i(TAG, "reuse flow session=" + r0.a().a() + " authType=" + r0.a().e().a() + " requiresAppSetup=" + r0.a().g() + " missingScopes=" + r0.a().d());
        return r0;
    L21:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r30.a(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r1) == false) goto L24;
        r1 = f18971a.b();
    L24:
        a r2 = new a(b.a(r30, (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin"), 0, null, null, null, null, null, false, 254, null), y.a(null, 1, null), null, null, 12, null);
        Collection<a> r3 = f18972b.values();
        d.h.b.o.c(r3, "<get-values>(...)");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L26:
        if (r4.hasNext() == false) goto L28;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "replace active flow oldSession=" + r5.a().a() + " newSession=" + r2.a().a());
        r5.b().a(new c(d.f18988c, "Authorization request was replaced.", "auth_flow_replaced", null, 8, null));
        goto L26
    L28:
        ConcurrentHashMap<String, a> r6 = f18972b;
        r6.clear();
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin")).put(r2.a().a(), r2);
        ILogDepend.Companion.i(TAG, "register flow session=" + r2.a().a() + " authType=" + r2.a().e().a() + " authorizeReason=" + r2.a().f() + " requiresAppSetup=" + r2.a().g() + " scopeCount=" + r2.a().c().size() + " missingScopes=" + r2.a().d());
        return r2;
    L5:
        if (r0.b().i() == false) goto L7;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == false) goto L16;
    L7:
        if (r0.a().e() != r30.e()) goto L13;
        if (r0.a().g() != r30.g()) goto L13;
        if (d.h.b.o.a(p.q((Iterable) ZeusTransformUtils.preCheckCast(r0.a().d(), Iterable.class, "com.obric.aiagent.plugin")), p.q((Iterable) ZeusTransformUtils.preCheckCast(r30.d(), Iterable.class, "com.obric.aiagent.plugin"))) == false) goto L13;
        r7 = true;
        goto L14
    }

    public final boolean a(String r5) {
        d.h.b.o.e(r5, "authSessionId");
        a r0 = (a) ZeusTransformUtils.preCheckCast(f18972b.get(r5), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        l r4 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "mark takeover notified ignored, missing flow session=" + r5);
        return false;
    L6:
        boolean r6 = r0.d().compareAndSet(false, true);
        ILogDepend.Companion.i(TAG, "mark takeover notified session=" + r5 + " marked=" + r6);
        return r6;
    }

    public final boolean b(String r5) {
        d.h.b.o.e(r5, "authSessionId");
        a r0 = (a) ZeusTransformUtils.preCheckCast(f18972b.get(r5), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        l r4 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "mark auth flow entered ignored, missing flow session=" + r5);
        return false;
    L6:
        boolean r6 = r0.c().a(x.f38692a);
        ILogDepend.Companion.i(TAG, "mark auth flow entered session=" + r5 + " marked=" + r6);
        return r6;
    }

    public final a a() {
        Collection<a> r4 = f18972b.values();
        d.h.b.o.c(r4, "<get-values>(...)");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r0 = r5.next();
        if ((!((a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin")).b().i()) == false) goto L4;
    L9:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L12;
        return null;
    L12:
        return r6;
    L8:
        r0 = null;
        goto L9
    }

    public final boolean a(String r5, c r6) {
        d.h.b.o.e(r5, "authSessionId");
        d.h.b.o.e(r6, "result");
        a r0 = (a) ZeusTransformUtils.preCheckCast(f18972b.remove(r5), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        l r4 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "complete ignored, missing flow session=" + r5 + " status=" + r6.a().a());
        return false;
    L6:
        r0.b().a(r6);
        ILogDepend.Companion.i(TAG, "complete flow session=" + r5 + " status=" + r6.a().a() + " errorType=" + r6.c() + " errorSubtype=" + r6.d());
        return true;
    }

    public final boolean a(c r3) {
        d.h.b.o.e(r3, "result");
        a r0 = a();
        if (r0 != null) goto L7;
        l r2 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "complete active ignored, no active flow status=" + r3.a().a());
        return false;
    L7:
        return a(r0.a().a(), r3);
    }

    public final boolean a(String r9, String r10) {
        d.h.b.o.e(r9, "message");
        return a(new c(d.f18988c, r9, r10, null, 8, null));
    }

    public final boolean c(String r9) {
        d.h.b.o.e(r9, "authSessionId");
        return a(r9, new c(d.f18989d, "Authorization expired.", null, null, 12, null));
    }

    private final String b() {
        StringBuilder r7 = new StringBuilder().append("auth_");
        String r1 = UUID.randomUUID().toString();
        d.h.b.o.c(r1, "toString(...)");
        return r7.append(d.o.o.e(d.o.o.a(r1, "-", "", false, 4, null), 12)).toString();
    }
}
