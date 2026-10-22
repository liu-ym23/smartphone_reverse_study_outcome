package com.obric.aiagent.utils.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.a.i;
import d.a.p;
import d.h.b.o;
import d.l.n;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: TrustedCallerVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "TrustedCallerVerifier";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, c> f22337b = null;

    /* JADX INFO: compiled from: TrustedCallerVerifier.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f22338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f22339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<String> f22340c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f22341d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f22338a == r6.f22338a) goto L12;
            return false;
        L12:
            if (this.f22339b == r6.f22339b) goto L15;
            return false;
        L15:
            if (o.a(this.f22340c, r6.f22340c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f22341d, r6.f22341d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Boolean.hashCode(this.f22338a) * 31) + Integer.hashCode(this.f22339b)) * 31) + this.f22340c.hashCode()) * 31) + this.f22341d.hashCode();
        }

        public String toString() {
            return "AuthResult(allowed=" + this.f22338a + ", callingUid=" + this.f22339b + ", packages=" + this.f22340c + ", reason=" + this.f22341d + ')';
        }

        public a(boolean r3, int r4, List<String> r5, String r6) {
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            o.e(r7, "packages");
            o.e(r6, "reason");
            this.f22338a = r3;
            this.f22339b = r4;
            this.f22340c = r7;
            this.f22341d = r6;
        }

        public final boolean a() {
            return this.f22338a;
        }

        public final int b() {
            return this.f22339b;
        }

        public final List<String> c() {
            return this.f22340c;
        }

        public final String d() {
            return this.f22341d;
        }
    }

    public static /* synthetic */ CharSequence lambda$brkQavTHRcEcvWoc5Kqb9MtAvPQ(byte r0) {
        return a(r0);
    }

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f22336a = new b();
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiagent.utils.c.a.f22332a.b(), Iterable.class, "com.obric.aiagent.plugin");
        Map<String, c> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(n.c(ao.a(p.a(r0, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Object r3 = r2.next();
        r1.put(((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin")).a(), r3);
        goto L4
    L6:
        f22337b = r1;
    }

    public final a a(Context r18, String r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r19, "operation");
        a r2 = b(r1, r19);
        if (r2.a() == false) goto L5;
        ILogDepend.Companion.i(TAG, "allow " + r19 + " callerUid=" + r2.b() + " packages=" + p.a((Iterable) ZeusTransformUtils.preCheckCast(r2.c(), Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null) + " reason=" + r2.d());
    L6:
        return r2;
    L5:
        ILogDepend.Companion.w(TAG, "reject " + r19 + " callerUid=" + r2.b() + " packages=" + p.a((Iterable) ZeusTransformUtils.preCheckCast(r2.c(), Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null) + " reason=" + r2.d());
        goto L6
    }

    private final a b(Context r10, String r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        int r0 = Binder.getCallingUid();
        if (r0 == Process.myUid()) goto L5;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L10;
        r12 = r2;
    L10:
        PackageManager r3 = r12.getPackageManager();
        String[] r4 = r3.getPackagesForUid(r0);
        Object r5 = null;
        if (r4 == null) goto L13;
        List r6 = i.g(r4);
    L14:
        if (r6 != null) goto L17;
        r6 = p.b();
    L17:
        if (r6.isEmpty() == true) goto L19;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L23;
    L25:
        Iterator r14 = r13.iterator();
    L27:
        if (r14.hasNext() == false) goto L24;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin");
        if (o.a(r7, r12.getPackageName()) == false) goto L31;
    L34:
        boolean r8 = true;
    L35:
        if (r8 == false) goto L27;
        boolean r15 = true;
    L37:
        if (r15 == true) goto L39;
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L42:
        if (r16.hasNext() == false) goto L46;
        Object r17 = r16.next();
        if (f22337b.containsKey((String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.aiagent.plugin")) == false) goto L42;
        r5 = r17;
    L46:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L49;
        Set<String> r19 = a(r18);
        o.a(r3);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(a(r3, r18), Iterable.class, "com.obric.aiagent.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r21 = r9.iterator();
    L52:
        if (r21.hasNext() == false) goto L54;
        r20.add(f22336a.b((String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.aiagent.plugin")));
        goto L52
    L54:
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r22, Collection.class) == true) goto L57;
    L59:
        Iterator r23 = r22.iterator();
    L61:
        if (r23.hasNext() == false) goto L58;
        if (r19.contains((String) ZeusTransformUtils.preCheckCast(r23.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L61;
        boolean r24 = true;
    L65:
        if (r24 == false) goto L69;
        return new a(true, r0, r6, "trusted_signature:" + r18);
    L69:
        return new a(false, r0, r6, "signature_mismatch:" + r18);
    L58:
        r24 = false;
        goto L65
    L57:
        if (((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L59;
    L49:
        return new a(false, r0, r6, "package_not_trusted");
    L39:
        return new a(true, r0, r6, "same_package");
    L31:
        if (com.obric.aiagent.utils.c.a.f22332a.a().contains(r7) == true) goto L34;
        r8 = false;
    L24:
        r15 = false;
        goto L37
    L23:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L25;
    L19:
        return new a(false, r0, r6, "no_packages_for_uid:" + r11);
    L13:
        r6 = null;
        goto L14
    L5:
        return new a(true, r0, p.b(), "same_uid");
    }

    private final Set<String> a(String r2) {
        c r1 = (c) ZeusTransformUtils.preCheckCast(f22337b.get(r2), c.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return ax.b();
    L7:
        return r1.b();
    }

    private final List<String> a(PackageManager r18, String r19) {
        int r5 = 0;
        if (Build.VERSION.SDK_INT < 28) goto L16;
        SigningInfo r0 = r18.getPackageInfo(r19, 134217728).signingInfo;     // Catch: Throwable -> L24
        boolean r3 = true;
        if (r0 != null) goto L8;
    L10:
        r3 = false;
    L11:
        if (r3 == false) goto L13;
        Signature[] r1 = r0.getApkContentsSigners();     // Catch: Throwable -> L24
    L17:
        if (r1 != null) goto L19;
        r1 = new Signature[0];     // Catch: Throwable -> L24
    L19:
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r1.length), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        int r6 = r1.length;     // Catch: Throwable -> L24
    L20:
        if (r5 >= r6) goto L22;
        byte[] r8 = MessageDigest.getInstance("SHA-256").digest(r1[r5].toByteArray());     // Catch: Throwable -> L24
        o.c(r8, "digest(...)");     // Catch: Throwable -> L24
        r4.add(i.a(r8, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$b$brkQavTHRcEcvWoc5Kqb9MtAvPQ.INSTANCE, 30, null));     // Catch: Throwable -> L24
        r5 = r5 + 1;     // Catch: Throwable -> L24
        goto L20
    L22:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
    L13:
        if (r0 == null) goto L15;
        r1 = r0.getSigningCertificateHistory();     // Catch: Throwable -> L24
        goto L17
    L15:
        r1 = null;
        goto L17
    L8:
        if (r0.hasMultipleSigners() != true) goto L10;
    L16:
        r1 = r18.getPackageInfo(r19, 64).signatures;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        ILogDepend.Companion.w(TAG, "failed to get signatures for " + r19, th);
        return p.b();
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02X", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final String b(String r13) {
        String r12 = d.o.o.a(d.o.o.a(r13, ":", "", false, 4, null), " ", "", false, 4, null).toUpperCase(Locale.ROOT);
        o.c(r12, "toUpperCase(...)");
        return r12;
    }
}
