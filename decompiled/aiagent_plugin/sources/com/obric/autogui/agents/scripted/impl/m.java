package com.obric.autogui.agents.scripted.impl;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: ScriptBundleDecryptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    private static final String TAG = "ScriptBundleDecryptor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f27019a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f27020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f27021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.f f27022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile List<c> f27023e;
    private final Object f;
    private final ConcurrentHashMap<String, byte[]> g;

    /* JADX INFO: compiled from: ScriptBundleDecryptor.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("packageName")
        private final String f27024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("verCode")
        private final String f27025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("buildDate")
        private final String f27026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("buildBy")
        private final String f27027d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27024a, r6.f27024a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27025b, r6.f27025b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f27026c, r6.f27026c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f27027d, r6.f27027d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f27024a.hashCode() * 31) + this.f27025b.hashCode()) * 31;
            String r1 = this.f27026c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f27027d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "BundleMeta(packageName=" + this.f27024a + ", verCode=" + this.f27025b + ", buildDate=" + this.f27026c + ", buildBy=" + this.f27027d + ')';
        }

        public final String a() {
            return this.f27024a;
        }

        public final String b() {
            return this.f27025b;
        }
    }

    /* JADX INFO: compiled from: ScriptBundleDecryptor.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public static final /* synthetic */ byte[] a(b r0, String r1, String r2) {
            return r0.a(r1, r2);
        }

        public static final /* synthetic */ byte[] a(b r0, byte[] r1, byte[] r2) {
            return r0.a(r1, r2);
        }

        public final m a(File r7) {
            d.h.b.o.e(r7, "rootDir");
            File r0 = new File(r7, "meta.json");
            d.h.b.h r3 = null;
            if (r0.exists() == true) goto L25;
            com.obric.autogui.agents.scripted.c.c.a(m.TAG, "meta.json not found in " + r7.getAbsolutePath());
            return null;
        L25:
            boolean r4 = true;
            a r1 = (a) ZeusTransformUtils.preCheckCast(new Gson().fromJson(d.f.k.a(r0, null, 1, null), a.class), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22
            if (r1 != null) goto L9;
        L18:
            if (r4 == false) goto L27;
            com.obric.autogui.agents.scripted.c.c.a(m.TAG, "meta.json invalid (missing packageName/verCode) in " + r7.getName());     // Catch: Exception -> L22
            return null;
        L27:
            return new m(r7, r1, r3);
        L9:
            if (r1.a() == null) goto L18;
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1.a(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L18;
            if (r1.b() == null) goto L18;
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1.b(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L18;
            r4 = false;
        L22:
            e = move-exception;
            com.obric.autogui.agents.scripted.c.c.a(m.TAG, "parse meta.json failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        }

        private final byte[] a(String r1, String r2) {
            String r0 = r1 + ":doubao:" + r2;
            MessageDigest r3 = MessageDigest.getInstance("SHA-256");
            byte[] r4 = r0.getBytes(d.o.d.f38623b);
            d.h.b.o.c(r4, "getBytes(...)");
            byte[] r5 = r3.digest(r4);
            d.h.b.o.c(r5, "digest(...)");
            return r5;
        }

        private final byte[] a(byte[] r5, byte[] r6) {
            if (r6.length < 28) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == false) goto L10;
            byte[] r7 = new byte[12];
            System.arraycopy(r6, 0, r7, 0, 4);
            System.arraycopy(r6, r6.length - 8, r7, 4, 8);
            byte[] r8 = d.a.i.a(r6, 4, r6.length - 8);
            Cipher r0 = Cipher.getInstance("ChaCha20/Poly1305/NoPadding");
            r0.init(2, (Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r5, "ChaCha20"), Key.class, "com.obric.aiagent.plugin"), (AlgorithmParameterSpec) ZeusTransformUtils.preCheckCast(new IvParameterSpec(r7), AlgorithmParameterSpec.class, "com.obric.aiagent.plugin"));
            byte[] r9 = r0.doFinal(r8);
            d.h.b.o.c(r9, "doFinal(...)");
            return r9;
        L10:
            throw new IllegalArgumentException(("encrypted data too short: " + r6.length + " bytes").toString());
        L5:
            r4 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: ScriptBundleDecryptor.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("moduleName")
        private final String f27028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("key")
        private final String f27029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("fileName")
        private final String f27030c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27028a, r6.f27028a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27029b, r6.f27029b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f27030c, r6.f27030c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f27028a.hashCode() * 31) + this.f27029b.hashCode()) * 31) + this.f27030c.hashCode();
        }

        public String toString() {
            return "IndexEntry(moduleName=" + this.f27028a + ", key=" + this.f27029b + ", fileName=" + this.f27030c + ')';
        }

        public final String a() {
            return this.f27028a;
        }

        public final String b() {
            return this.f27029b;
        }

        public final String c() {
            return this.f27030c;
        }
    }

    static {
        f27019a = new b(null);
    }

    public /* synthetic */ m(File r1, a r2, d.h.b.h r3) {
        this(r1, r2);
    }

    public static /* synthetic */ byte[] lambda$AjkYBfc6kKSMVQDa5Q_tkfSHX6k(m r0) {
        return a(r0);
    }

    private m(File r1, a r2) {
        this.f27020b = r1;
        this.f27021c = r2;
        this.f27022d = d.g.a(new $$Lambda$m$AjkYBfc6kKSMVQDa5Q_tkfSHX6k(this));
        this.f = new Object();
        this.g = new ConcurrentHashMap();
    }

    public final a a() {
        return this.f27021c;
    }

    private static final byte[] a(m r2) {
        return b.a(f27019a, r2.f27021c.a(), r2.f27021c.b());
    }

    private final byte[] b() {
        return (byte[]) ZeusTransformUtils.preCheckCast(this.f27022d.b(), byte[].class, "com.obric.aiagent.plugin");
    }

    private final List<c> c() {
        List<c> r0 = this.f27023e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Object r1 = this.f;
        monitor-enter(r1);
        List<c> r2 = this.f27023e;     // Catch: Throwable -> L18
        if (r2 == null) goto L11;
        monitor-exit(r1);
        return r2;
    L11:
        File r3 = new File(this.f27020b, "embedded/0000/00000000");     // Catch: Throwable -> L18
        if (r3.exists() == false) goto L17;
        Object r4 = new Gson().fromJson(new String(b.a(f27019a, b(), d.f.k.c(r3)), d.o.d.f38623b), c[].class);     // Catch: Throwable -> L18
        d.h.b.o.c(r4, "fromJson(...)");     // Catch: Throwable -> L18
        List<c> r5 = d.a.i.g((Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
        this.f27023e = r5;     // Catch: Throwable -> L18
        monitor-exit(r1);
        return r5;
    L17:
        throw new IllegalStateException("index file not found: " + r3.getName());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r2) {
        d.h.b.o.e(r2, "moduleName");
        return this.g.containsKey(r2);
    }

    public final byte[] b(String r6) {
        d.h.b.o.e(r6, "moduleName");
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(this.g.get(r6), byte[].class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(c(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (d.h.b.o.a(((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin")).a(), r6) == false) goto L7;
    L12:
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L21;
        File r4 = new File(this.f27020b, r3.c());
        if (r4.exists() == false) goto L19;
        byte[] r5 = Base64.getDecoder().decode(r3.b());
        b r7 = f27019a;
        d.h.b.o.a(r5);
        byte[] r8 = b.a(r7, r5, d.f.k.c(r4));
        ((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.aiagent.plugin")).put(r6, r8);
        return r8;
    L19:
        throw new IllegalStateException("encrypted file not found: " + r3.c());
    L21:
        throw new IllegalArgumentException("module not found: " + r6);
    L11:
        r2 = null;
        goto L12
    }

    public final String c(String r2) {
        d.h.b.o.e(r2, "moduleName");
        return new String(b(r2), d.o.d.f38623b);
    }
}
