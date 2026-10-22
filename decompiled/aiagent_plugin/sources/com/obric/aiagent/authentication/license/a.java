package com.obric.aiagent.authentication.license;

import android.content.Context;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.a.c;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.ad;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.o.d;
import d.x;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AuthLicenseManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "AuthLicenseManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0329a f16384a = null;
    private static volatile a f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f16385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f16386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, V1LicenseContent> f16387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Gson f16388e;

    /* JADX INFO: renamed from: com.obric.aiagent.authentication.license.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AuthLicenseManager.kt */
    public static final class C0329a {
        public /* synthetic */ C0329a(h r1) {
            this();
        }

        private C0329a() {
        }

        public final a a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r5, "context");
            a r0 = a.a();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = a.a();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            o.c(r6, "getApplicationContext(...)");     // Catch: Throwable -> L10
            r0 = new a(r6);     // Catch: Throwable -> L10
            C0329a r7 = a.f16384a;     // Catch: Throwable -> L10
            a.a(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    static {
        f16384a = new C0329a(null);
    }

    public static /* synthetic */ CharSequence lambda$5UnUIYBN7YgcHLeZEkxp7cCXW2o(byte r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$faFmhV0kb7-gcUIs-bTUzoZ_4EE, reason: not valid java name */
    public static /* synthetic */ void m157lambda$faFmhV0kb7gcUIsbTUzoZ_4EE(a r0) {
        c(r0);
    }

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this.f16385b = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f16386c = new c();
        this.f16387d = new ConcurrentHashMap();
        this.f16388e = new Gson();
        new Handler(Looper.getMainLooper()).post(new $$Lambda$a$faFmhV0kb7gcUIsbTUzoZ_4EE(this));
    }

    public static final /* synthetic */ a a() {
        return f;
    }

    public static final /* synthetic */ void a(a r0) {
        f = r0;
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ ConcurrentHashMap b(a r0) {
        return r0.f16387d;
    }

    private static final void c(final a r3) {
        ((LauncherApps) ZeusTransformUtils.preCheckCast(r3.f16385b.getSystemService(LauncherApps.class), LauncherApps.class, "com.obric.aiagent.plugin")).registerCallback((LauncherApps.Callback) ZeusTransformUtils.preCheckCast(new AuthLicenseManager$1$1(r3), LauncherApps.Callback.class, "com.obric.aiagent.plugin"));
    }

    private final V1LicenseContent a(String r4) {
        V1LicenseContent r0 = (V1LicenseContent) ZeusTransformUtils.preCheckCast(this.f16387d.get(r4), V1LicenseContent.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        b(r4);
        return (V1LicenseContent) ZeusTransformUtils.preCheckCast(this.f16387d.get(r4), V1LicenseContent.class, "com.obric.aiagent.plugin");
    }

    private final void b(String r8) {
        Resources r1 = this.f16385b.getPackageManager().getResourcesForApplication(r8);
        o.c(r1, "getResourcesForApplication(...)");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L20
        a r7 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r1.getAssets().open("o_appintent_license.json"), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        InputStream r4 = (InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        Gson r5 = r7.f16388e;     // Catch: Throwable -> L15
        o.a(r4);     // Catch: Throwable -> L15
        License r6 = (License) ZeusTransformUtils.preCheckCast(r5.fromJson((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r4, d.f38623b), Reader.class, "com.obric.aiagent.plugin"), License.class), License.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        String r9 = r6.getContent().toString();     // Catch: Throwable -> L15
        o.c(r9, "toString(...)");     // Catch: Throwable -> L15
        if (r7.c(r9, r6.getSignature()) == true) goto L10;
        d.f.c.a(r3, null);     // Catch: Throwable -> L20
        return;
    L10:
        if (r6.getVersion() != 1) goto L12;
        ((Map) ZeusTransformUtils.preCheckCast(r7.f16387d, Map.class, "com.obric.aiagent.plugin")).put(r8, r7.f16388e.fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r6.getContent(), JsonElement.class, "com.obric.aiagent.plugin"), V1LicenseContent.class));     // Catch: Throwable -> L15
    L12:
        x r10 = x.f38692a;     // Catch: Throwable -> L15
        d.f.c.a(r3, null);     // Catch: Throwable -> L20
        Object r11 = n.f(x.f38692a);     // Catch: Throwable -> L20
    L22:
        Throwable r12 = n.c(r11);
        if (r12 == null) goto L31;
        ILogDepend.Companion.w(TAG, "loadLicense failed, packageName: " + r8 + ", error: " + r12);
        return;
    L31:
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        d.f.c.a(r3, th);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        n.a r0 = n.f38560a;
        r11 = n.f(d.o.a(th));
        goto L22
    }

    public final LicenseExecutePolicyInfo a(String r2, String r3) {
        o.e(r2, "packageName");
        o.e(r3, "intentName");
        V1LicenseContent r1 = a(r2);
        if (r1 == null) goto L11;
        Map<String, LicenseExecutePolicy> r4 = r1.getExecutePolicies();
        if (r4 == null) goto L13;
        LicenseExecutePolicy r5 = (LicenseExecutePolicy) ZeusTransformUtils.preCheckCast(r4.get(r3), LicenseExecutePolicy.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L10;
        return null;
    L10:
        return new LicenseExecutePolicyInfo(r5.getType(), r5.getSettingKey());
    L13:
        return null;
    L11:
        return null;
    }

    public final boolean a(String r11, String r12, String r13) {
        o.e(r11, "packageName");
        o.e(r12, "category");
        o.e(r13, "action");
        boolean r1 = true;
        if (o.a(r11, this.f16385b.getPackageName()) == false) goto L6;
        ILogDepend.Companion.i(TAG, "checkAuthorization call from self return true category: " + r12 + ", action: " + r13);
        return true;
    L6:
        V1LicenseContent r0 = a(r11);
        if (r0 == null) goto L15;
        Map<String, List<String>> r5 = r0.getActions();
        if (r5 == null) goto L15;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r5.get(r12), List.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L15;
        if (r6.contains(r13) != true) goto L15;
        boolean r7 = true;
    L17:
        if (r7 == true) goto L21;
        ILogDepend.Companion.w(TAG, "checkAuthorization failed no actions in license " + r11 + ' ' + r12 + ' ' + r13);
        return false;
    L21:
        if (o.a(r0.getPackageName(), r11) == true) goto L24;
        ILogDepend.Companion.w(TAG, "checkAuthorization failed license package name not match " + r11 + ' ' + r12 + ' ' + r13);
        return false;
    L24:
        String r8 = ObricProductSdk.INSTANCE.featureService().getObricProductName();
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r0.getSignatures().get(r8), Map.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L27;
        r9 = (Map) ZeusTransformUtils.preCheckCast(r0.getSignatures().get("*"), Map.class, "com.obric.aiagent.plugin");
    L27:
        if (r9 == null) goto L30;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r9.get(Build.TAGS), String.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L30;
    L33:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L36;
    L39:
        if (r1 == false) goto L43;
        ILogDepend.Companion.w(TAG, "checkAuthorization failed no signature found " + r11 + ' ' + r12 + ' ' + r13 + ' ' + r8);
        return false;
    L43:
        if (o.a(r2, "@system") == false) goto L45;
        boolean r10 = c(r11);
    L46:
        if (r10 == true) goto L48;
        ILogDepend.Companion.w(TAG, "checkAuthorization failed app signature not match " + r11 + ' ' + r12 + ' ' + r13 + ' ' + r8);
    L48:
        return r10;
    L45:
        r10 = b(r11, r2);
        goto L46
    L36:
        if (r3.length() == 0) goto L39;
        r1 = false;
    L30:
        if (r9 == null) goto L32;
        r2 = (String) ZeusTransformUtils.preCheckCast(r9.get("*"), String.class, "com.obric.aiagent.plugin");
        goto L33
    L32:
        r2 = null;
    L15:
        r7 = false;
        goto L17
    }

    private final boolean c(String r2) {
        if (this.f16385b.getPackageManager().checkSignatures("android", r2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean b(String r12, String r13) {
        Signature[] r11 = this.f16385b.getPackageManager().getPackageInfo(r12, 64).signatures;     // Catch: PackageManager.NameNotFoundException -> L12
        MessageDigest r14 = MessageDigest.getInstance("SHA-256");     // Catch: PackageManager.NameNotFoundException -> L12
        Iterator r15 = d.h.b.c.a(r11);     // Catch: PackageManager.NameNotFoundException -> L12
    L5:
        if (r15.hasNext() == false) goto L18;
        r14.update(((Signature) ZeusTransformUtils.preCheckCast(r15.next(), Signature.class, "com.obric.aiagent.plugin")).toByteArray());     // Catch: PackageManager.NameNotFoundException -> L12
        byte[] r2 = r14.digest();     // Catch: PackageManager.NameNotFoundException -> L12
        o.c(r2, "digest(...)");     // Catch: PackageManager.NameNotFoundException -> L12
        if (o.a(i.a(r2, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$a$5UnUIYBN7YgcHLeZEkxp7cCXW2o.INSTANCE, 30, null), r13) == false) goto L5;
        return true;
    L18:
        return false;
    L10:
        return false;
    }

    private static final CharSequence a(byte r3) {
        ad r0 = ad.f38485a;
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final boolean c(String r5, String r6) {
        if (r5 == null) goto L16;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L17;
        c r4 = this.f16386c;
        byte[] r7 = r5.getBytes(d.f38623b);
        o.c(r7, "getBytes(...)");
        if (r4.a(r7, com.bytedance.a.d.a(r6), 1) == 0) goto L15;
        return false;
    L15:
        return true;
    L17:
        return false;
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
        goto L11
    L16:
        return false;
    }
}
