package com.obric.autogui.evaluation.a;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.EventsUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.o.k;
import d.x;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: SignedCallingHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "SignedCalling";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f29074a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f29075b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f29076c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f29077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f29078e;

    /* JADX INFO: compiled from: SignedCallingHandler.kt */
    public interface a {
        Object a(Context r1, Intent r2, d.c.d<? super com.obric.autogui.common.e> r3);

        String b();
    }

    /* JADX INFO: compiled from: SignedCallingHandler.kt */
    @d.c.b.a.f(b = "SignedCallingHandler.kt", c = {EventsUtils.FEAT_TYPE_NFC_EVENT}, d = "handle", e = "com.obric.autogui.evaluation.signedcalling.SignedCallingHandler")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f29080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f29081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29082d;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29081c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29080b = r3;
            this.f29082d |= Integer.MIN_VALUE;
            return d.a(this.f29081c, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SignedCallingHandler.kt */
    @d.c.b.a.f(b = "SignedCallingHandler.kt", c = {65}, d = "invokeSuspend", e = "com.obric.autogui.evaluation.signedcalling.SignedCallingHandler$onReceive$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f29084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f29085c;

        c(Context r3, Intent r4, d.c.d<? super c> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29084b = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.f29085c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f29084b, this.f29085c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f29083a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            d r8 = d.f29074a;
            Context r2 = this.f29084b;
            Intent r3 = this.f29085c;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29083a = 1;
            if (d.a(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$fmt8zJeEuZtdynVSu_0lABARg-U, reason: not valid java name */
    public static /* synthetic */ boolean m808lambda$fmt8zJeEuZtdynVSu_0lABARgU(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$r2SukvBdN9K-mA94gsNyZUEun1U, reason: not valid java name */
    public static /* synthetic */ boolean m809lambda$r2SukvBdN9KmA94gsNyZUEun1U(long r0, Map.Entry r2) {
        return a(r0, r2);
    }

    private d() {
    }

    public static final /* synthetic */ Object a(d r2, Context r3, Intent r4, d.c.d r5) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f29074a = new d();
        f29075b = new ConcurrentHashMap();
        f29076c = new ConcurrentHashMap();
    }

    public final void a(a r3) {
        a r2 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "executor");
        ((Map) ZeusTransformUtils.preCheckCast(f29075b, Map.class, "com.obric.aiagent.plugin")).put(r2.b(), r2);
    }

    public final void a(Context r4, Intent r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        d.h.b.o.e(r5, MemorySourceLinkType.INTENT);
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new c(r3, r5, null), m.class, "com.obric.aiagent.plugin"));
    }

    private final Object a(Context r8, Intent r9, d.c.d<? super x> r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r12, b.class, "com.obric.aiagent.plugin");
        if ((r0.f29082d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f29082d -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f29080b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f29082d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r0.f29079a, String.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L36:
        com.obric.autogui.common.e r14 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r14.g() == true) goto L39;
        Loog.INSTANCE.e(TAG, "instruction=" + r7 + " failed: " + r14);
    L41:
        return x.f38692a;
    L39:
        Loog.INSTANCE.i(TAG, "instruction=" + r7 + " done");
        goto L41
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r13);
        String r15 = r9.getStringExtra("instruction");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L24;
        Loog.INSTANCE.e(TAG, "missing instruction");
        return x.f38692a;
    L24:
        com.obric.autogui.common.e r16 = a(r9);
        if (r16.g() == true) goto L28;
        Loog.INSTANCE.e(TAG, "signature verify failed: " + r16);
        return x.f38692a;
    L28:
        a r17 = (a) ZeusTransformUtils.preCheckCast(f29075b.get(r15), a.class, "com.obric.aiagent.plugin");
        if (r17 != null) goto L32;
        Loog.INSTANCE.w(TAG, "no executor for instruction=" + r15);
        return x.f38692a;
    L32:
        r0.f29079a = r15;
        r0.f29082d = 1;
        Object r18 = r17.a(r11, r9, r0);
        if (r18 != r2) goto L35;
        return r2;
    L35:
        r13 = r18;
        r7 = r15;
        goto L36
    L17:
        if (d.o.o.d(r4) == true) goto L20;
        r5 = false;
    L7:
        r0 = new b(this, r12);
        goto L8
    }

    private final com.obric.autogui.common.e a(Intent r15) {
        String r0 = r15.getStringExtra("signature");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r3 = true;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        String r4 = r15.getStringExtra("instruction");
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        String r6 = r4;
        String r5 = r15.getStringExtra("signed_content");
        if (r5 != null) goto L18;
        r5 = a(r15, r6);
    L18:
        PublicKey r7 = a();
        if (r7 == null) goto L21;
        byte[] r8 = Base64.decode(r0, 0);     // Catch: Throwable -> L51
        Charset r9 = StandardCharsets.UTF_8;
        d.h.b.o.c(r9, "UTF_8");
        byte[] r10 = r5.getBytes(r9);
        d.h.b.o.c(r10, "getBytes(...)");
        d.h.b.o.a(r8);
        if (a(r7, r10, r8) == false) goto L26;
        String r11 = b(r15);
        if (r11 == null) goto L32;
        Long r12 = d.o.o.e(r11);
        if (r12 == null) goto L32;
        long r13 = r12.longValue();
    L33:
        long r14 = r13;
        long r16 = System.currentTimeMillis();
        if (r14 > 0) goto L36;
    L39:
        String r17 = r15.getStringExtra("nonce");
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L42;
    L45:
        if (r3 == true) goto L50;
        com.obric.autogui.common.e r19 = a(r6, r17, r16, r14);
        if (r19.g() == true) goto L50;
        return r19;
    L50:
        return com.obric.autogui.common.e.f29014b.a();
    L42:
        if (d.o.o.d(r18) == true) goto L45;
        r3 = false;
        goto L45
    L36:
        if (Math.abs(r16 - r14) <= 300000) goto L39;
        return com.obric.autogui.common.e.f29014b.b("timestamp out of range");
    L32:
        r13 = -1;
        goto L33
    L26:
        return com.obric.autogui.common.e.f29014b.b("signature mismatch");
    L52:
        return com.obric.autogui.common.e.f29014b.b("signature decoding failed");
    L21:
        return com.obric.autogui.common.e.f29014b.b("public key not configured");
    L11:
        return com.obric.autogui.common.e.f29014b.b("signature missing");
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    private final String a(Intent r10, String r11) {
        String r0 = r10.getStringExtra("payload");
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r9 = b(r10);
        if (r9 != null) goto L8;
        r9 = "0";
    L8:
        String r12 = r10.getStringExtra("nonce");
        if (r12 == null) goto L13;
        r1 = r12;
    L13:
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(p.b(new String[]{r11, r0, r9, r1}), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    }

    private final String b(Intent r3) {
        String r0 = r3.getStringExtra(DBHelper.COL_TIME);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r3.hasExtra(DBHelper.COL_TIME) == true) goto L10;
        return null;
    L10:
        return String.valueOf(r3.getLongExtra(DBHelper.COL_TIME, 0));
    }

    private final com.obric.autogui.common.e a(String r3, String r4, long r5, long r7) {
        a(r5);
        String r2 = r3 + '|' + r4;
        if (r7 <= 0) goto L5;
        long r8 = r7 + 300000;
    L6:
        ConcurrentHashMap<String, Long> r6 = f29076c;
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(r6.putIfAbsent(r2, Long.valueOf(r8)), Long.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        if (r9.longValue() > r5) goto L16;
        if (r6.replace(r2, r9, Long.valueOf(r8)) == true) goto L15;
    L16:
        return com.obric.autogui.common.e.f29014b.b("nonce replay detected");
    L15:
        return com.obric.autogui.common.e.f29014b.a();
    L5:
        r8 = r5 + 300000;
        goto L6
    }

    private final void a(final long r2) {
        Set<Map.Entry<String, Long>> r1 = f29076c.entrySet();
        final d.h.a.b r0 = new $$Lambda$d$r2SukvBdN9KmA94gsNyZUEun1U(r2);
        r1.removeIf(new $$Lambda$d$fmt8zJeEuZtdynVSu_0lABARgU(r0));
    }

    private static final boolean a(long r2, Map.Entry r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "it");
        if (((Number) ZeusTransformUtils.preCheckCast(r5.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue() > r2) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean a(d.h.a.b r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private final PublicKey a() {
        b();
        String r0 = f29077d;
        PublicKey r12 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(d.o.o.a(r0, "-----BEGIN PUBLIC KEY-----", "", false, 4, null), "-----END PUBLIC KEY-----", "", false, 4, null), CharSequence.class, "com.obric.aiagent.plugin");
        String r2 = new k("\\s").a(r1, "");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L18;
        return null;
    L18:
        X509EncodedKeySpec r3 = new X509EncodedKeySpec(Base64.decode(r2, 0));
        r12 = KeyFactory.getInstance("RSA").generatePublic((KeySpec) ZeusTransformUtils.preCheckCast(r3, KeySpec.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
        goto L21
    L20:
        return r12;
    L13:
        return KeyFactory.getInstance("EC").generatePublic((KeySpec) ZeusTransformUtils.preCheckCast(r3, KeySpec.class, "com.obric.aiagent.plugin"));
    L21:
        return r12;
    }

    private final void b() {
        if (f29077d == null) goto L5;
        return;
    L5:
        if (f29078e == true) goto L43;
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L9:
        if (f29077d == null) goto L11;
    L34:
        monitor-exit(this);
        return;
    L11:
        if (f29078e == true) goto L34;
        boolean r0 = true;
        f29078e = true;     // Catch: Throwable -> L36
        String r1 = null;
        Field r2 = ZeusTransformUtils.forName("com.obric.autogui.operator.BuildConfig", "com.obric.aiagent.plugin").getDeclaredField("SIGNED_CALLING_PUBLIC_KEY_PEM");     // Catch: Throwable -> L19
        r2.setAccessible(true);     // Catch: Throwable -> L19
        Object r3 = r2.get(null);     // Catch: Throwable -> L19
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L21;
        r1 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        goto L21
    L21:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        if (r4 != null) goto L24;
    L27:
        if (r0 == false) goto L31;
        Loog.INSTANCE.e(TAG, "public key is not configured; call setPublicKeyPem(...) first.");     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L31:
        f29077d = "-----BEGIN PUBLIC KEY-----\n" + r1 + "\n-----END PUBLIC KEY-----\n";     // Catch: Throwable -> L36
        x r5 = x.f38692a;     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L24:
        if (d.o.o.d(r4) == true) goto L27;
        r0 = false;
    L19:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "failed to read public key from BuildConfig", th);     // Catch: Throwable -> L36
        goto L21
    }

    private final boolean a(PublicKey r3, byte[] r4, byte[] r5) {
        PublicKey r2 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.aiagent.plugin");
        if (d.o.o.a(r2.getAlgorithm(), "EC", true) == false) goto L5;
        String r6 = "SHA256withECDSA";
    L10:
        Signature r7 = Signature.getInstance(r6);     // Catch: Throwable -> L8
        r7.initVerify(r2);     // Catch: Throwable -> L8
        r7.update(r4);     // Catch: Throwable -> L8
        return r7.verify(r5);
    L8:
        return false;
    L5:
        r6 = "SHA256withRSA";
        goto L10
    }
}
